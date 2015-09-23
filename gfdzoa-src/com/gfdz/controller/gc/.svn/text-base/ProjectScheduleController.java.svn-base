package com.gfdz.controller.gc;
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

import com.gfdz.entity.gc.ProjectScheduleDetailEntity;
import com.gfdz.entity.gc.ProjectScheduleEntity;
import com.gfdz.service.gc.ProjectScheduleServiceI;

/**   
 * @Title: Controller
 * @Description: 工程信息表
 * @author ant
 * @date 2015-05-28 14:52:37
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/projectScheduleController")
public class ProjectScheduleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProjectScheduleController.class);

	@Autowired
	private ProjectScheduleServiceI projectScheduleService;
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
	 * 工程信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "projectScheduleList")
	public ModelAndView projectScheduleList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/projectScheduleList");
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
	public void datagrid(ProjectScheduleEntity projectSchedule,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProjectScheduleEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, projectSchedule, request.getParameterMap());
		this.projectScheduleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除工程信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ProjectScheduleEntity projectSchedule, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		projectSchedule = systemService.getEntity(ProjectScheduleEntity.class, projectSchedule.getId());
		message = "工程信息表删除成功";
		projectScheduleService.delete(projectSchedule);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加工程信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ProjectScheduleEntity projectSchedule, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(projectSchedule.getId())) {
			message = "工程信息表更新成功";
			ProjectScheduleEntity t = projectScheduleService.get(ProjectScheduleEntity.class, projectSchedule.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(projectSchedule, t);
				projectScheduleService.saveProjectSchedule(t,request);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "工程信息表更新失败";
			}
		} else {
			message = "工程信息表添加成功";
			projectScheduleService.saveProjectSchedule(projectSchedule,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 工程信息表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ProjectScheduleEntity projectSchedule, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(projectSchedule.getId())) {
			projectSchedule = projectScheduleService.getEntity(ProjectScheduleEntity.class, projectSchedule.getId());
			req.setAttribute("projectSchedule", projectSchedule);
		}
		return new ModelAndView("com/gfdz/gc/projectSchedule");
	}
	
	
	
	@RequestMapping(params = "projectScheduleDetailList")
	public ModelAndView projectScheduleDetailList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/projectScheduleDetailList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "projectScheduleData")
	public void projectScheduleData(ProjectScheduleDetailEntity projectScheduleDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProjectScheduleDetailEntity.class, dataGrid);
		//查询条件组装器
		String pId = request.getParameter("pId");
		cq.add(Restrictions.eq("projectSchedule.id", pId));
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, projectScheduleDetail, request.getParameterMap());
		this.projectScheduleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	  * @Title: selectSchedule
	  * @Description: 项目进度选择项目
	  * @param request
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月13日 上午9:48:18
	 */
	@RequestMapping(params = "selectSchedule")
	public ModelAndView selectSchedule(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/selectSchedule");
	}

	
}
