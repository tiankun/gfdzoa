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

import com.gfdz.entity.gc.ProjectAcceptEntity;
import com.gfdz.service.gc.ProjectAcceptService;

/**   
 * @Title: Controller
 * @Description: 工程验收登记
 * @author ant
 * @date 2015-08-21 10:56:19
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/projectAcceptController")
public class ProjectAcceptController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProjectAcceptController.class);

	@Autowired
	private ProjectAcceptService projectAcceptService;
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
	 * 工程验收登记列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "projectAcceptList")
	public ModelAndView projectAcceptList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/projectAcceptList");
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
	public void datagrid(ProjectAcceptEntity projectAccept,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProjectAcceptEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, projectAccept, request.getParameterMap());
		this.projectAcceptService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除工程验收登记
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ProjectAcceptEntity projectAccept, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		projectAccept = systemService.getEntity(ProjectAcceptEntity.class, projectAccept.getId());
		message = "工程验收登记删除成功";
		projectAcceptService.delete(projectAccept);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加工程验收登记
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ProjectAcceptEntity projectAccept, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(projectAccept.getId())) {
			message = "工程验收登记更新成功";
			ProjectAcceptEntity t = projectAcceptService.get(ProjectAcceptEntity.class, projectAccept.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(projectAccept, t);
				projectAcceptService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "工程验收登记更新失败";
			}
		} else {
			message = "工程验收登记添加成功";
			projectAcceptService.save(projectAccept);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 工程验收登记列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ProjectAcceptEntity projectAccept, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(projectAccept.getId())) {
			projectAccept = projectAcceptService.getEntity(ProjectAcceptEntity.class, projectAccept.getId());
			req.setAttribute("projectAccept", projectAccept);
		}
		return new ModelAndView("com/gfdz/gc/projectAccept");
	}
}
