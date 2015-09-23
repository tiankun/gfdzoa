package com.gfdz.controller.workflow;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.workflow.Leave;
import com.gfdz.service.workflow.LeaveService;
import com.gfdz.util.workflow.Variable;


/**
 * @Description: TODO(请假流程控制类)
 * @author liujinghua
 */
@Controller
@RequestMapping("/leavessController")
public class LeavesController extends BaseController{
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;

	private static final Logger logger = Logger.getLogger(LeavesController.class);
	
	/**
     * 请假流程启动
     * @param deploymentId 流程部署ID
     */
	@RequestMapping(params = "leaveStart")
	@ResponseBody
	public AjaxJson leaveStart(Leave leave, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		leave.setUserId(ResourceUtil.getSessionUserName().getId());
		
		//请假流程启动
		leaveService.leaveWorkFlowStart(leave);
	
		String message = "流程启动成功";
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 完成任务表单选择
	 */
	@RequestMapping(params = "taskCompletePageSelect")
	public ModelAndView taskCompletePageSelect(
			@RequestParam("processInstanceId") String processInstanceId,
			@RequestParam("taskId") String taskId,HttpServletRequest request,Model model) {
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
			
			String businessKey = processInstance.getBusinessKey();

			Leave leave = leaveService.get(Leave.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("leave",leave);
			
		
			return new ModelAndView("buss/activiti/my/departLeader");
	}
	
	/**
     * 完成任务
     * @param deploymentId 流程部署ID
     */
	@RequestMapping(params = "completeTask")
	@ResponseBody
	public AjaxJson completeTask(String taskId,Variable var,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		Map<String, Object> variables = taskService.getVariables(taskId);
		variables.put("deptLeaderPass", true);
		variables.put("leaveDays", 5);
		variables.put("leaderManagerId", ResourceUtil.getSessionUserName().getCurrentDepart().getManagerLeader().getId());
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		taskService.addComment(taskId, task.getProcessInstanceId(), "测试");
		taskService.complete(taskId, variables);
		//请假流程启动
		//leaveService.leaveWorkFlowStart(leave);
		
		String message = "办理成功";
		j.setMsg(message);
		return j;
	}
	
}
