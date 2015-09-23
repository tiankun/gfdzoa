package com.gfdz.controller.hr;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.hr.EvaluationEntity;
import com.gfdz.service.hr.EvaluationService;

/**   
 * @Title: Controller
 * @Description: 转正考评
 * @author ant
 * @date 2015-06-15 15:09:06
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/evaluationController")
public class EvaluationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EvaluationController.class);

	@Autowired
	private EvaluationService evaluationService;
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
	 * 转正考评列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "evaluationList")
	public ModelAndView evaluationList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/evaluationList");
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
	public void datagrid(EvaluationEntity evaluation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EvaluationEntity.class, dataGrid);
		//查询条件组装器
		String personId = request.getParameter("personId");
		cq.add(Restrictions.eq("pId", personId));
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, evaluation, request.getParameterMap());
		this.evaluationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除转正考评
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(EvaluationEntity evaluation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		evaluation = systemService.getEntity(EvaluationEntity.class, evaluation.getId());
		message = "转正考评删除成功";
		evaluationService.delete(evaluation);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加转正考评
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(EvaluationEntity evaluation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(evaluation.getId())) {
			message = "转正考评更新成功";
			EvaluationEntity t = evaluationService.get(EvaluationEntity.class, evaluation.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(evaluation, t);
				evaluationService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "转正考评更新失败";
			}
		} else {
			message = "转正考评添加成功";
			evaluationService.save(evaluation);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(evaluation);
		j.setMsg(message);
		return j;
	}

	/**
	 * 转正考评列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(EvaluationEntity evaluation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(evaluation.getId())) {
			evaluation = evaluationService.getEntity(EvaluationEntity.class, evaluation.getId());
			req.setAttribute("evaluation", evaluation);
		}
		req.setAttribute("username", ResourceUtil.getSessionUserName().getRealName());
		return new ModelAndView("com/gfdz/hr/evaluation");
	}
}
