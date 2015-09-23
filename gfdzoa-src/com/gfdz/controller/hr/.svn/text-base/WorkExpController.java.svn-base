package com.gfdz.controller.hr;
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
import org.hibernate.criterion.Restrictions;
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

import com.gfdz.entity.hr.WorkExpEntity;
import com.gfdz.service.hr.WorkExpService;

/**   
 * @Title: Controller
 * @Description: 人员工作经历
 * @author ant
 * @date 2015-06-11 11:24:42
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/workExpController")
public class WorkExpController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkExpController.class);

	@Autowired
	private WorkExpService workExpService;
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
	 * 人员工作经历列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "workExpList")
	public ModelAndView workExpList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/workExpList");
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
	public void datagrid(WorkExpEntity workExp,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WorkExpEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, workExp, request.getParameterMap());
		String personId = request.getParameter("personId");
		cq.add(Restrictions.eq("personId", personId));
		this.workExpService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除人员工作经历
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(WorkExpEntity workExp, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		workExp = systemService.getEntity(WorkExpEntity.class, workExp.getId());
		message = "人员工作经历删除成功";
		workExpService.delete(workExp);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加人员工作经历
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(WorkExpEntity workExp, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(workExp.getId())) {
			message = "人员工作经历更新成功";
			WorkExpEntity t = workExpService.get(WorkExpEntity.class, workExp.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(workExp, t);
				workExpService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "人员工作经历更新失败";
			}
		} else {
			message = "人员工作经历添加成功";
			workExpService.save(workExp);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 人员工作经历列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(WorkExpEntity workExp, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(workExp.getId())) {
			workExp = workExpService.getEntity(WorkExpEntity.class, workExp.getId());
			req.setAttribute("workExp", workExp);
		}
		return new ModelAndView("com/gfdz/hr/workExp");
	}
}
