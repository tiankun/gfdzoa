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

import com.gfdz.entity.hr.InterviewEntity;
import com.gfdz.service.hr.InterviewService;

/**   
 * @Title: Controller
 * @Description: 面试信息
 * @author ant
 * @date 2015-06-11 11:30:38
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/interviewController")
public class InterviewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(InterviewController.class);

	@Autowired
	private InterviewService interviewService;
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
	 * 面试信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "interviewList")
	public ModelAndView interviewList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/interviewList");
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
	public void datagrid(InterviewEntity interview,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(InterviewEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, interview, request.getParameterMap());
		this.interviewService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除面试信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(InterviewEntity interview, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		interview = systemService.getEntity(InterviewEntity.class, interview.getId());
		message = "面试信息删除成功";
		interviewService.delete(interview);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加面试信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(InterviewEntity interview, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(interview.getId())) {
			message = "面试信息更新成功";
			InterviewEntity t = interviewService.get(InterviewEntity.class, interview.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(interview, t);
				interviewService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "面试信息更新失败";
			}
		} else {
			message = "面试信息添加成功";
			interviewService.save(interview);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 面试信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(InterviewEntity interview, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(interview.getId())) {
			interview = interviewService.getEntity(InterviewEntity.class, interview.getId());
			req.setAttribute("interview", interview);
		}
		return new ModelAndView("com/gfdz/hr/interview");
	}
}
