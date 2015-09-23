package com.gfdz.controller.cw;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.gfdz.entity.cw.ExpensesPlanDetailEntity;
import com.gfdz.service.cw.ExpensesPlanDetailServiceI;

/**   
 * @Title: Controller
 * @Description: 费用开支计划明细
 * @author ant
 * @date 2015-05-28 13:48:53
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/expensesPlanDetailController")
public class ExpensesPlanDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ExpensesPlanDetailController.class);

	@Autowired
	private ExpensesPlanDetailServiceI expensesPlanDetailService;
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
	 * 费用开支计划明细列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "expensesPlanDetail")
	public ModelAndView expensesPlanDetail(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/expensesPlanDetailList");
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
	public void datagrid(ExpensesPlanDetailEntity expensesPlanDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ExpensesPlanDetailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, expensesPlanDetail, request.getParameterMap());
		this.expensesPlanDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除费用开支计划明细
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ExpensesPlanDetailEntity expensesPlanDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		expensesPlanDetail = systemService.getEntity(ExpensesPlanDetailEntity.class, expensesPlanDetail.getId());
		message = "费用开支计划明细删除成功";
		expensesPlanDetailService.delete(expensesPlanDetail);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加费用开支计划明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ExpensesPlanDetailEntity expensesPlanDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(expensesPlanDetail.getId())) {
			message = "费用开支计划明细更新成功";
			ExpensesPlanDetailEntity t = expensesPlanDetailService.get(ExpensesPlanDetailEntity.class, expensesPlanDetail.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(expensesPlanDetail, t);
				expensesPlanDetailService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "费用开支计划明细更新失败";
			}
		} else {
			message = "费用开支计划明细添加成功";
			expensesPlanDetailService.save(expensesPlanDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 费用开支计划明细列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ExpensesPlanDetailEntity expensesPlanDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(expensesPlanDetail.getId())) {
			expensesPlanDetail = expensesPlanDetailService.getEntity(ExpensesPlanDetailEntity.class, expensesPlanDetail.getId());
			req.setAttribute("expensesPlanDetailPage", expensesPlanDetail);
		}
		return new ModelAndView("com/gfdz/cw/expensesPlanDetail");
	}
}
