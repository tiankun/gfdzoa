package com.gfdz.controller.cw;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.gfdz.entity.cw.ExpensesPlanDetailEntity;
import com.gfdz.entity.cw.ExpensesPlanEntity;
import com.gfdz.entity.cw.ReimburseDetailEntity;
import com.gfdz.service.cw.ExpensesPlanServiceI;
import com.gfdz.service.cw.ReimburseServiceI;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 费用开支计划
 * @author ant
 * @date 2015-05-28 13:48:12
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/expensesPlanController")
public class ExpensesPlanController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ExpensesPlanController.class);

	@Autowired
	private ExpensesPlanServiceI expensesPlanService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	@Autowired
	private ReimburseServiceI reimburseService;
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
	 * 费用开支计划列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "expensesPlanList")
	public ModelAndView expensesPlanList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/expensesPlanList");
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
	public void datagrid(ExpensesPlanEntity expensesPlan,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ExpensesPlanEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, expensesPlan, request.getParameterMap());
		this.expensesPlanService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除费用开支计划
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ExpensesPlanEntity expensesPlan, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		expensesPlan = systemService.getEntity(ExpensesPlanEntity.class, expensesPlan.getId());
		message = "费用开支计划删除成功";
		expensesPlanService.delete(expensesPlan);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加费用开支计划
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ExpensesPlanEntity expensesPlan, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(expensesPlan.getId())) {
			message = "费用开支计划更新成功";
			try {
				expensesPlanService.updateExpensesPlan(expensesPlan, request);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "费用开支计划更新失败";
			}
		} else {
			message = "费用开支计划添加成功";
			expensesPlanService.expensesPlanWorkFlowStart(expensesPlan,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 费用开支计划列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ExpensesPlanEntity expensesPlan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(expensesPlan.getId())) {
			List<ExpensesPlanDetailEntity> expensesPlanDetailEntity=null;
			expensesPlan = expensesPlanService.getEntity(ExpensesPlanEntity.class, expensesPlan.getId());
			expensesPlanDetailEntity=expensesPlan.getExpensesPlanDetail();
			req.setAttribute("expensesPlanPage", expensesPlan);
			req.setAttribute("list", expensesPlanDetailEntity);
		}
		req.setAttribute("user", ResourceUtil.getSessionUserName());
		return new ModelAndView("com/gfdz/cw/expensesPlan");
	}
	
	/**
	 * 
	  * @Title: taskCompletePageSelect
	  * @Description: 开支计划任务处理页面跳转
	  * @param processInstanceId
	  * @param taskId
	  * @param taskKey
	  * @param request
	  * @param model
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月6日 上午10:24:14
	 */
	@RequestMapping(params = "taskCompletePageSelect")
	public ModelAndView taskCompletePageSelect(
			@RequestParam("processInstanceId") String processInstanceId,
			@RequestParam("taskId") String taskId,@RequestParam("taskKey") String taskKey,HttpServletRequest request,Model model) {
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
			
			String businessKey = processInstance.getBusinessKey();

			ExpensesPlanEntity expensesPlan = expensesPlanService.get(ExpensesPlanEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("expensesPlan",expensesPlan);
			model.addAttribute("taskKey", taskKey);
			
			
			return new ModelAndView("com/gfdz/zhb/reimburseHandle");
	}
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 开支计划任务处理
	  * @param taskId
	  * @param var
	  * @param request
	  * @return AjaxJson
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月24日 下午2:33:12
	 */
	@RequestMapping(params = "completeTask")
	@ResponseBody
	public AjaxJson completeTask(String taskId,Variable var,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String taskKey = request.getParameter("taskKey");	//任务步骤
		String auditType = request.getParameter("auditType");//是否同意
		String postil = request.getParameter("postil");      //批注信息
		String isout = request.getParameter("isout");
		Map<String, Object> variables = taskService.getVariables(taskId);
		if(taskKey.equals(ProcessConstantsUtil.getDeptLeaderAudit())){
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getIsCheckOut(), "N".equals(isout) ? false : true);
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), ResourceUtil.getSessionUserName().getCurrentDepart().getManagerLeader().getId());
		}else if(taskKey.equals(ProcessConstantsUtil.getLeaderManagerAudit())){
			variables.put(ProcessConstantsUtil.getLeaderManagerPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getApplyUserId(),request.getParameter("applyUserId"));
		}else if(taskKey.equals(ProcessConstantsUtil.getReceiveConfirm())){
			variables.put(ProcessConstantsUtil.getBorrowUserId(), request.getParameter("staff"));
		}
		
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if(postil!=null){
			taskService.addComment(taskId, task.getProcessInstanceId(), postil);
		}
		
		taskService.complete(taskId, variables);
		
		String message = "办理成功";
		j.setMsg(message);
		return j;
	}

}
