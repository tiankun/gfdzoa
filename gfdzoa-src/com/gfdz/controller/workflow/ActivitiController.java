package com.gfdz.controller.workflow;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.persistence.entity.CommentEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.demo.controller.test.DemoController;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.cw.BillEntity;
import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.util.workflow.HistoryProcessInstanceDiagramCmd;

/**
 * @Description: TODO(工作流程定义与实例等资源处理类)
 * @author liujinghua
 * 
 */
@Controller
@RequestMapping("/activitiController")
public class ActivitiController extends BaseController {

	private static final Logger logger = Logger.getLogger(DemoController.class);

	@Autowired
	protected RepositoryService repositoryService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private SystemService systemService;

	/**
	 * 流程定义列表
	 */
	@RequestMapping(params = "processList")
	public ModelAndView processList(HttpServletRequest request) {
		return new ModelAndView("buss/activiti/process/processlist");
	}

	@RequestMapping(params = "addProcess")
	public ModelAndView addProcess(HttpServletRequest request) {
		String sessionId = request.getSession().getId();
		request.setAttribute("sessionId", sessionId);
		return new ModelAndView("buss/activiti/process/addProcess");
	}

	@RequestMapping(params = "deployProcess")
	@ResponseBody
	public AjaxJson deployProcess(HttpServletRequest request, @RequestParam MultipartFile file) {
		AjaxJson j = new AjaxJson();
		String fileName = file.getOriginalFilename();
		try {
			InputStream fileInputStream = file.getInputStream();
			String extension = FilenameUtils.getExtension(fileName);
			if ((extension.equals("zip")) || (extension.equals("bar"))) {
				ZipInputStream zip = new ZipInputStream(fileInputStream);
				this.repositoryService.createDeployment().addZipInputStream(zip).deploy();
			} else if (extension.equals("png")) {
				this.repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
			} else if (extension.indexOf("bpmn20.xml") != -1) {
				this.repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
			} else if (extension.equals("bpmn")) {
				String baseName = FilenameUtils.getBaseName(fileName);
				this.repositoryService.createDeployment().addInputStream(baseName + ".bpmn20.xml", fileInputStream).deploy();
			} else {
				throw new ActivitiException("错误信息:不支改文件类型" + extension);
			}
		} catch (Exception e) {
			this.logger.error("错误信息:在部署过程中,文件输入流异常" + e.toString());
		}
		return j;
	}

	/**
	 * 我的流程定义
	 */
	@RequestMapping(params = "myProcessList")
	public ModelAndView myProcessList(HttpServletRequest request) {
		return new ModelAndView("buss/activiti/my/myProcessList");
	}

	/**
	 * 
	 * @Title: startPageSelect
	 * @Description: 启动流程表单
	 * @param deploymentId
	 * @param request
	 * @return ModelAndView
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月17日 下午2:44:17
	 */
	@RequestMapping(params = "startPageSelect")
	public ModelAndView startPageSelect(@RequestParam("deploymentId") String deploymentId, HttpServletRequest request) {

		WorkFlowSetEntity workFlowset = systemService.findUniqueByProperty(WorkFlowSetEntity.class, "deploymentId", deploymentId);
		if (workFlowset == null) {
			throw new RuntimeException("请先对流程进行设置。流程部署ID：" + deploymentId);
		}
		request.setAttribute("processKey", workFlowset.getProcessKey());
		if (workFlowset.getBeginPath().contains("bill")) {
			List<TSType> ftype = TSTypegroup.allTypes.get("ftype".toLowerCase());
			request.setAttribute("ftype", ftype);
			request.setAttribute("stype", 9999);
			request.setAttribute("user", ResourceUtil.getSessionUserName());
		}
		return new ModelAndView(workFlowset.getBeginPath());
	}

	/**
	 * easyui 运行中流程列表页面
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "runningProcessList")
	public ModelAndView runningProcessList(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		return new ModelAndView("buss/activiti/process/runninglist");
	}

	/**
	 * easyui 运行中流程列表数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "runningProcessDataGrid")
	public void runningProcessDataGrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		/*
		 * List<HistoricProcessInstance> historicProcessInstances =
		 * historyService .createHistoricProcessInstanceQuery()
		 * .unfinished().list();
		 */
		ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
		List<ProcessInstance> list = processInstanceQuery.list();

		StringBuffer rows = new StringBuffer();
		for (ProcessInstance hi : list) {
			rows.append("{'id':" + hi.getId() + ",'processDefinitionId':'" + hi.getProcessDefinitionId() + "','processInstanceId':'" + hi.getProcessInstanceId() + "','activityId':'"
					+ hi.getActivityId() + "'},");
		}

		String rowStr = StringUtils.substringBeforeLast(rows.toString(), ",");

		JSONObject jObject = JSONObject.fromObject("{'total':" + list.size() + ",'rows':[" + rowStr + "]}");
		responseDatagrid(response, jObject);
	}

	/**
	 * 读取工作流定义的图片或xml
	 * 
	 * @throws Exception
	 */
	@RequestMapping(params = "resourceRead")
	public void resourceRead(@RequestParam("processDefinitionId") String processDefinitionId, @RequestParam("resourceType") String resourceType, HttpServletResponse response) throws Exception {
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
		String resourceName = "";
		if (resourceType.equals("image")) {
			resourceName = processDefinition.getDiagramResourceName();
		} else if (resourceType.equals("xml")) {
			resourceName = processDefinition.getResourceName();
		}
		InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
		byte[] b = new byte[1024];
		int len = -1;

		while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	/**
	 * 读取带跟踪的流程图片
	 * 
	 * @throws Exception
	 */
	@RequestMapping(params = "traceImage")
	public void traceImage(@RequestParam("processInstanceId") String processInstanceId, HttpServletResponse response) throws Exception {

		Command<InputStream> cmd = new HistoryProcessInstanceDiagramCmd(processInstanceId);

		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		InputStream is = processEngine.getManagementService().executeCommand(cmd);

		int len = 0;
		byte[] b = new byte[1024];

		while ((len = is.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	/**
	 * easyui 流程历史页面
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "viewProcessInstanceHistory")
	public ModelAndView viewProcessInstanceHistory(@RequestParam("processInstanceId") String processInstanceId, HttpServletRequest request, HttpServletResponse respone, Model model) {

		model.addAttribute("processInstanceId", processInstanceId);

		return new ModelAndView("buss/activiti/process/viewProcessInstanceHistory");
	}

	/**
	 * easyui 流程历史数据获取
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "taskHistoryList")
	public void taskHistoryList(@RequestParam("processInstanceId") String processInstanceId, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		List<HistoricTaskInstance> historicTasks = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();

		StringBuffer rows = new StringBuffer();
		for (HistoricTaskInstance hi : historicTasks) {
			rows.append("{'name':'" + hi.getName() + "','processInstanceId':'" + hi.getProcessInstanceId() + "','startTime':'" + hi.getStartTime() + "','endTime':'" + hi.getEndTime()
					+ "','assignee':'" + hi.getAssignee() + "','deleteReason':'" + hi.getDeleteReason() + "'},");
			// System.out.println(hi.getName()+"@"+hi.getAssignee()+"@"+hi.getStartTime()+"@"+hi.getEndTime());
		}

		String rowStr = StringUtils.substringBeforeLast(rows.toString(), ",");

		JSONObject jObject = JSONObject.fromObject("{'total':" + historicTasks.size() + ",'rows':[" + rowStr + "]}");
		responseDatagrid(response, jObject);
	}

	/**
	 * 
	 * @Title: setvalid
	 * @Description: 设置是流程启动/挂起
	 * @param deploymentId
	 * @param request
	 * @return AjaxJson
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年5月13日 上午9:35:50
	 */
	@RequestMapping(params = "setvalid")
	@ResponseBody
	public AjaxJson setvalid(@RequestParam("id") String id, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		ProcessDefinition processDefinition = repositoryService.getProcessDefinition(id);
		if (processDefinition.isSuspended()) {
			repositoryService.activateProcessDefinitionById(id, true, null);
		} else {
			repositoryService.suspendProcessDefinitionById(id, true, null);
		}

		String message = "操作成功";
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除部署的流程，级联删除流程实例
	 * 
	 * @param deploymentId
	 *            流程部署ID
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(@RequestParam("deploymentId") String deploymentId, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();

		repositoryService.deleteDeployment(deploymentId, true);

		String message = "删除成功";
		j.setMsg(message);
		return j;
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		List<ProcessDefinition> list = query.list();

		StringBuffer rows = new StringBuffer();
		int i = 0;
		for (ProcessDefinition pi : list) {
			Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(pi.getDeploymentId()).singleResult();
			i++;
			rows.append("{'id':" + i + ",'processDefinitionId':'" + pi.getId() + "','deploymentDate':'" + new SimpleDateFormat("yyyy-MM-dd").format(deployment.getDeploymentTime())
					+ "','resourceName':'" + pi.getResourceName() + "','deploymentId':'" + pi.getDeploymentId() + "','key':'" + pi.getKey() + "','name':'" + pi.getName() + "','version':'"
					+ pi.getVersion() + "','isSuspended':'" + pi.isSuspended() + "'},");
		}
		String rowStr = StringUtils.substringBeforeLast(rows.toString(), ",");

		JSONObject jObject = JSONObject.fromObject("{'total':" + query.count() + ",'rows':[" + rowStr + "]}");
		responseDatagrid(response, jObject);
	}

	/**
	 * easyui 待领任务页面
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "waitingClaimTask")
	public ModelAndView waitingClaimTask() {

		return new ModelAndView("buss/activiti/process/waitingClaimTask");
	}

	/**
	 * easyui AJAX请求数据 待领任务
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "waitingClaimTaskDataGrid")
	public void waitingClaimTaskDataGrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		// String userId = "hruser";
		String userId = ResourceUtil.getSessionUserName().getId();
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser(userId).active().list();// .taskCandidateGroup("hr").active().list();

		StringBuffer rows = new StringBuffer();
		for (Task t : tasks) {
			rows.append("{'name':'" + t.getName() + "','taskId':'" + t.getId() + "','processDefinitionId':'" + t.getProcessDefinitionId() + "'},");
		}
		String rowStr = StringUtils.substringBeforeLast(rows.toString(), ",");

		JSONObject jObject = JSONObject.fromObject("{'total':" + tasks.size() + ",'rows':[" + rowStr + "]}");
		responseDatagrid(response, jObject);
	}

	/**
	 * 
	 * @Title: claimedTask
	 * @Description: 待办任务页面跳转
	 * @return ModelAndView
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月18日 下午2:40:17
	 */
	@RequestMapping(params = "claimedTask")
	public ModelAndView claimedTask() {

		return new ModelAndView("buss/activiti/process/claimedTask");
	}

	/**
	 * easyui AJAX请求数据 待办任务
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "claimedTaskDataGrid")
	public void claimedTaskDataGrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String userId = ResourceUtil.getSessionUserName().getId();
		TaskQuery taskQuery = processEngine.getTaskService().createTaskQuery();
		List<Task> tasks = taskQuery.taskCandidateOrAssigned(userId).listPage(dataGrid.getStart(), dataGrid.getEnd());
		long total = taskQuery.taskCandidateOrAssigned(userId).count();
		StringBuffer rows = new StringBuffer();
		for (Task t : tasks) {
			WorkFlowSetEntity workFlowset = systemService.findUniqueByProperty(WorkFlowSetEntity.class, "processDefinitionId", t.getProcessDefinitionId());
			if (workFlowset == null)
				continue;
			rows.append("{'name':'" + t.getName() + "','description':'" + t.getDescription() + "','taskId':'" + t.getId() + "','processDefinitionId':'" + t.getProcessDefinitionId()
					+ "','processInstanceId':'" + t.getProcessInstanceId() + "','action':'" + workFlowset.getHandleUrl() + "','TaskDefinitionKey':'" + t.getTaskDefinitionKey() + "'},");
		}
		String rowStr = StringUtils.substringBeforeLast(rows.toString(), ",");
		JSONObject jObject = JSONObject.fromObject("{'total':" + total + ",'rows':[" + rowStr + "]}");
		responseDatagrid(response, jObject);
	}

	/**
	 * easyui 已办任务页面
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "finishedTask")
	public ModelAndView finishedTask() {

		return new ModelAndView("buss/activiti/process/finishedTask");
	}

	/**
	 * easyui AJAX请求数据 已办任务
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "finishedTaskDataGrid")
	public void finishedTask(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		// String userId = "leaderuser";
		String userId = ResourceUtil.getSessionUserName().getId();
		List<HistoricTaskInstance> historicTasks = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId).finished().list();

		StringBuffer rows = new StringBuffer();
		for (HistoricTaskInstance t : historicTasks) {
			rows.append("{'name':'" + t.getName() + "','description':'" + t.getDescription() + "','taskId':'" + t.getId() + "','processDefinitionId':'" + t.getProcessDefinitionId()
					+ "','processInstanceId':'" + t.getProcessInstanceId() + "'},");
		}
		String rowStr = StringUtils.substringBeforeLast(rows.toString(), ",");

		JSONObject jObject = JSONObject.fromObject("{'total':" + historicTasks.size() + ",'rows':[" + rowStr + "]}");
		responseDatagrid(response, jObject);
	}

	/**
	 * 签收任务
	 * 
	 * @param taskId
	 */
	@RequestMapping(params = "claimTask")
	@ResponseBody
	public AjaxJson claimTask(@RequestParam("taskId") String taskId, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();

		// String userId = "leaderuser";
		String userId = ResourceUtil.getSessionUserName().getId();
		TaskService taskService = processEngine.getTaskService();
		taskService.claim(taskId, userId);

		String message = "签收成功";
		j.setMsg(message);
		return j;
	}

	@RequestMapping(params = "myViewProcessHistory")
	public ModelAndView myViewProcessHistory(@RequestParam("processInstanceId") String processInstanceId, HttpServletRequest request, HttpServletResponse respone, Model model) {

		model.addAttribute("processInstanceId", processInstanceId);

		return new ModelAndView("buss/activiti/process/myViewProcessHistory");
	}

	/**
	 * easyui 流程历史数据获取
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "myTaskHistoryList")
	public void myTaskHistoryList(@RequestParam("processInstanceId") String processInstanceId, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		List<HistoricTaskInstance> historicTasks = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();

		StringBuffer rows = new StringBuffer();
		for (HistoricTaskInstance hi : historicTasks) {
			List<Comment> taskComments = taskService.getTaskComments(hi.getId());
			rows.append("{'name':'" + hi.getName() + "','processInstanceId':'" + hi.getProcessInstanceId() + "'");
			// 流程用户处理
			if (hi.getAssignee() != null) {
				TSUser user = systemService.get(TSUser.class, hi.getAssignee());
				rows.append(",'assignee':'" + user.getRealName() + "'");
			}

			// 流程开始结束时间处理
			if (hi.getStartTime() == null) {
				rows.append(",'startTime':'无'");
			} else {
				rows.append(",'startTime':'" + DateUtils.date_sdf.format(hi.getStartTime()) + "'");
			}
			if (hi.getEndTime() == null) {
				rows.append(",'endTime':'无'");

			} else {
				rows.append(",'endTime':'" + DateUtils.date_sdf.format(hi.getEndTime()) + "'");
			}

			if (hi.getDeleteReason() == null) {
				rows.append(",'deleteReason':'办理中'");
			} else {
				rows.append(",'deleteReason':'已办理'");
			}
			if (taskComments != null && taskComments.size() > 0) {
				CommentEntity commnet = (CommentEntity) taskComments.get(0);
				String msg = commnet.getMessage() == null ? "无" : commnet.getMessage();
				rows.append(",'msg':'" + msg + "'");
			} else {
				rows.append(",'msg':'无'");
			}
			rows.append("},");
		}

		String rowStr = StringUtils.substringBeforeLast(rows.toString(), ",");

		JSONObject jObject = JSONObject.fromObject("{'total':" + historicTasks.size() + ",'rows':[" + rowStr + "]}");
		responseDatagrid(response, jObject);
	}

	// -----------------------------------------------------------------------------------
	// 以下各函数可以提成共用部件 (Add by Quainty)
	// -----------------------------------------------------------------------------------
	public void responseDatagrid(HttpServletResponse response, JSONObject jObject) {
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(jObject.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
