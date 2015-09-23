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

import com.gfdz.entity.hr.PersonChangeEntity;
import com.gfdz.service.hr.PersonChangeService;

/**   
 * @Title: Controller
 * @Description: 人事变动信息
 * @author ant
 * @date 2015-06-11 11:29:49
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/personChangeController")
public class PersonChangeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PersonChangeController.class);

	@Autowired
	private PersonChangeService personChangeService;
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
	 * 人事变动信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "personChangeList")
	public ModelAndView personChangeList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/personChangeList");
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
	public void datagrid(PersonChangeEntity personChange,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PersonChangeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, personChange, request.getParameterMap());
		this.personChangeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除人事变动信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PersonChangeEntity personChange, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		personChange = systemService.getEntity(PersonChangeEntity.class, personChange.getId());
		message = "人事变动信息删除成功";
		personChangeService.delete(personChange);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加人事变动信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PersonChangeEntity personChange, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(personChange.getId())) {
			message = "人事变动信息更新成功";
			PersonChangeEntity t = personChangeService.get(PersonChangeEntity.class, personChange.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(personChange, t);
				personChangeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "人事变动信息更新失败";
			}
		} else {
			message = "人事变动信息添加成功";
			personChangeService.save(personChange);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 人事变动信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PersonChangeEntity personChange, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(personChange.getId())) {
			personChange = personChangeService.getEntity(PersonChangeEntity.class, personChange.getId());
			req.setAttribute("personChange", personChange);
		}
		return new ModelAndView("com/gfdz/hr/personChange");
	}
}
