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

import com.gfdz.entity.hr.LeaveOfficeEntity;
import com.gfdz.service.hr.LeaveOfficeService;

/**   
 * @Title: Controller
 * @Description: 个人离职表
 * @author ant
 * @date 2015-06-11 11:27:33
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/leaveOfficeController")
public class LeaveOfficeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LeaveOfficeController.class);

	@Autowired
	private LeaveOfficeService leaveOfficeService;
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
	 * 个人离职表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "leaveOfficeList")
	public ModelAndView leaveOfficeList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/leaveOfficeList");
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
	public void datagrid(LeaveOfficeEntity leaveOffice,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(LeaveOfficeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, leaveOffice, request.getParameterMap());
		this.leaveOfficeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除个人离职表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(LeaveOfficeEntity leaveOffice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		leaveOffice = systemService.getEntity(LeaveOfficeEntity.class, leaveOffice.getId());
		message = "个人离职表删除成功";
		leaveOfficeService.delete(leaveOffice);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加个人离职表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(LeaveOfficeEntity leaveOffice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(leaveOffice.getId())) {
			message = "个人离职表更新成功";
			LeaveOfficeEntity t = leaveOfficeService.get(LeaveOfficeEntity.class, leaveOffice.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(leaveOffice, t);
				leaveOfficeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "个人离职表更新失败";
			}
		} else {
			message = "个人离职表添加成功";
			leaveOfficeService.save(leaveOffice);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 个人离职表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(LeaveOfficeEntity leaveOffice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(leaveOffice.getId())) {
			leaveOffice = leaveOfficeService.getEntity(LeaveOfficeEntity.class, leaveOffice.getId());
			req.setAttribute("leaveOffice", leaveOffice);
		}
		return new ModelAndView("com/gfdz/hr/leaveOffice");
	}
}
