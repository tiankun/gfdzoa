package com.gfdz.controller.cw;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.gfdz.entity.cw.AdvanceEntity;
import com.gfdz.service.cw.AdvanceServiceI;

/**   
 * @Title: Controller
 * @Description: 暂支表
 * @author ant
 * @date 2015-05-28 13:50:07
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/advanceController")
public class AdvanceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AdvanceController.class);

	@Autowired
	private AdvanceServiceI advanceService;
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
	 * 暂支表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "advanceList")
	public ModelAndView advanceList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/advanceList");
	}
	
	/**
	 * 暂支表列表 弹出框列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "advanceLists")
	public ModelAndView advanceLists(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/advanceLists");
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
	public void datagrid(AdvanceEntity advance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AdvanceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, advance, request.getParameterMap());
		this.advanceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除暂支表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(AdvanceEntity advance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		advance = systemService.getEntity(AdvanceEntity.class, advance.getId());
		message = "暂支表删除成功";
		advanceService.delete(advance);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加暂支表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(AdvanceEntity advance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(advance.getId())) {
			message = "暂支表更新成功";
			AdvanceEntity t = advanceService.get(AdvanceEntity.class, advance.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(advance, t);
				advanceService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "暂支表更新失败";
			}
		} else {
			message = "暂支表添加成功";
			advance.setApplyTime(new Date());
			advanceService.save(advance);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 暂支表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(AdvanceEntity advance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(advance.getId())) {
			advance = advanceService.getEntity(AdvanceEntity.class, advance.getId());
			req.setAttribute("advancePage", advance);
		}
		req.setAttribute("user", ResourceUtil.getSessionUserName());
		return new ModelAndView("com/gfdz/cw/advance");
	}
}
