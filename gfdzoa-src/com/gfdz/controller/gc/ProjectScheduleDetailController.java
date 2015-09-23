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
import com.gfdz.service.gc.ProjectScheduleDetailServiceI;

/**   
 * @Title: Controller
 * @Description: 工程信息明细表
 * @author ant
 * @date 2015-05-28 14:53:21
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/projectScheduleDetailController")
public class ProjectScheduleDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProjectScheduleDetailController.class);

	@Autowired
	private ProjectScheduleDetailServiceI projectScheduleDetailService;
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
	 * 工程信息明细表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "projectScheduleDetail")
	public ModelAndView projectScheduleDetail(HttpServletRequest request) {
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

	@RequestMapping(params = "datagrid")
	public void datagrid(ProjectScheduleDetailEntity projectScheduleDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProjectScheduleDetailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, projectScheduleDetail, request.getParameterMap());
		this.projectScheduleDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除工程信息明细表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ProjectScheduleDetailEntity projectScheduleDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		projectScheduleDetail = systemService.getEntity(ProjectScheduleDetailEntity.class, projectScheduleDetail.getId());
		message = "工程信息明细表删除成功";
		projectScheduleDetailService.delete(projectScheduleDetail);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加工程信息明细表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ProjectScheduleDetailEntity projectScheduleDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(projectScheduleDetail.getId())) {
			message = "工程信息明细表更新成功";
			ProjectScheduleDetailEntity t = projectScheduleDetailService.get(ProjectScheduleDetailEntity.class, projectScheduleDetail.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(projectScheduleDetail, t);
				projectScheduleDetailService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "工程信息明细表更新失败";
			}
		} else {
			message = "工程信息明细表添加成功";
			projectScheduleDetailService.save(projectScheduleDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 工程信息明细表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ProjectScheduleDetailEntity projectScheduleDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(projectScheduleDetail.getId())) {
			projectScheduleDetail = projectScheduleDetailService.getEntity(ProjectScheduleDetailEntity.class, projectScheduleDetail.getId());
			req.setAttribute("projectScheduleDetailPage", projectScheduleDetail);
		}
		return new ModelAndView("com/gfdz/gc/projectScheduleDetail");
	}
}
