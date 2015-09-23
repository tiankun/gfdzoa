package com.buss.controller.acs;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.acs.ProfitEntity;
import com.buss.service.acs.ProfitServiceI;


/**   
 * @Title: Controller
 * @Description: 利润分析
 * @author ant
 * @date 2015-03-27 11:40:22
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/profitController")
public class ProfitController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProfitController.class);

	@Autowired
	private ProfitServiceI profitService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 利润分析列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "profit")
	public ModelAndView profit(HttpServletRequest request) {
		return new ModelAndView("buss/profitList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ProfitEntity profit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProfitEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, profit, request.getParameterMap());
		this.profitService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除利润分析
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ProfitEntity profit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		profit = systemService.getEntity(ProfitEntity.class, profit.getId());
		message = "利润分析删除成功";
		profitService.delete(profit);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加利润分析
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ProfitEntity profit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(profit.getId())) {
			message = "利润分析更新成功";
			ProfitEntity t = profitService.get(ProfitEntity.class, profit.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(profit, t);
				profitService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "利润分析更新失败";
			}
		} else {
			message = "利润分析添加成功";
			profitService.save(profit);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 利润分析列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ProfitEntity profit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(profit.getId())) {
			profit = profitService.getEntity(ProfitEntity.class, profit.getId());
			req.setAttribute("profitPage", profit);
		}
		return new ModelAndView("buss/profit");
	}
}
