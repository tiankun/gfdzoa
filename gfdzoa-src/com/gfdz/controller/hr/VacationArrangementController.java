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

import com.gfdz.entity.hr.VacationArrangementEntity;
import com.gfdz.service.hr.VacationArrangementService;

/**   
 * @Title: Controller
 * @Description: 法定节假日
 * @author ant
 * @date 2015-06-19 16:13:50
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/vacationArrangementController")
public class VacationArrangementController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(VacationArrangementController.class);

	@Autowired
	private VacationArrangementService vacationArrangementService;
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
	 * 法定节假日列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "vacationArrangementList")
	public ModelAndView vacationArrangementList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/vacationArrangementList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * 
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(VacationArrangementEntity vacationArrangement,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VacationArrangementEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vacationArrangement, request.getParameterMap());
		this.vacationArrangementService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除法定节假日
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(VacationArrangementEntity vacationArrangement, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vacationArrangement = systemService.getEntity(VacationArrangementEntity.class, vacationArrangement.getId());
		message = "法定节假日删除成功";
		vacationArrangementService.delete(vacationArrangement);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加法定节假日
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(VacationArrangementEntity vacationArrangement, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(vacationArrangement.getId())) {
			message = "法定节假日更新成功";
			VacationArrangementEntity t = vacationArrangementService.get(VacationArrangementEntity.class, vacationArrangement.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(vacationArrangement, t);
				vacationArrangementService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "法定节假日更新失败";
			}
		} else {
			message = "法定节假日添加成功";
			vacationArrangementService.save(vacationArrangement);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 法定节假日列表页面跳转
	 * ss
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(VacationArrangementEntity vacationArrangement, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vacationArrangement.getId())) {
			vacationArrangement = vacationArrangementService.getEntity(VacationArrangementEntity.class, vacationArrangement.getId());
			req.setAttribute("vacationArrangement", vacationArrangement);
		}
		return new ModelAndView("com/gfdz/hr/vacationArrangement");
	}
}
