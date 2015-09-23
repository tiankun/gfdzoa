package com.gfdz.controller.workflow;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.service.workflow.WorkFlowSetService;

/**   
 * @Title: Controller
 * @Description: 流程设置
 * @author ant
 * @date 2015-06-17 10:09:37
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/workFlowSetController")
public class WorkFlowSetController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkFlowSetController.class);

	@Autowired
	private WorkFlowSetService workFlowSetService;
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
	 * 流程设置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "workFlowSetList")
	public ModelAndView workFlowSetList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/workflow/workFlowSetList");
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
	public void datagrid(WorkFlowSetEntity workFlowSet,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WorkFlowSetEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, workFlowSet, request.getParameterMap());
		this.workFlowSetService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除流程设置
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(WorkFlowSetEntity workFlowSet, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		workFlowSet = systemService.getEntity(WorkFlowSetEntity.class, workFlowSet.getId());
		message = "流程设置删除成功";
		workFlowSetService.delete(workFlowSet);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加流程设置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(WorkFlowSetEntity workFlowSet, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(workFlowSet.getId())) {
			message = "流程设置更新成功";
			WorkFlowSetEntity t = workFlowSetService.get(WorkFlowSetEntity.class, workFlowSet.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(workFlowSet, t);
				workFlowSetService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "流程设置更新失败";
			}
		} else {
			message = "流程设置添加成功";
			workFlowSetService.save(workFlowSet);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 流程设置列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(WorkFlowSetEntity workFlowSet, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(workFlowSet.getProcessDefinitionId())) {
			
		}
		String deploymentId = req.getParameter("deploymentId");
		if(deploymentId!=null && !"".equals(deploymentId)){
			workFlowSet = workFlowSetService.findUniqueByProperty(WorkFlowSetEntity.class, "deploymentId", deploymentId);
			if(workFlowSet !=null ){
				req.setAttribute("workFlowSet", workFlowSet);
			}else{
				ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
				ProcessDefinition pd = processEngine.getRepositoryService().createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();
				req.setAttribute("deploymentId", pd.getDeploymentId());
				req.setAttribute("processKey", pd.getKey());
				req.setAttribute("processDefinitionId", pd.getId());
		}
		}
		return new ModelAndView("com/gfdz/workflow/workFlowSet");
	}
}
