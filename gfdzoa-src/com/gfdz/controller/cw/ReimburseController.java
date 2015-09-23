package com.gfdz.controller.cw;
import java.util.List;
import java.util.Map;

import javassist.tools.framedump;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.cw.ReimburseDetailEntity;
import com.gfdz.entity.cw.ReimburseEntity;
import com.gfdz.service.cw.ReimburseServiceI;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 财务报账主表
 * @author ant
 * @date 2015-05-28 13:52:47
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/reimburseController")
public class ReimburseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReimburseController.class);
	
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
	 * 财务报账主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "reimburseList")
	public ModelAndView reimburseList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/reimburseList");
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
	public void datagrid(ReimburseEntity reimburse,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ReimburseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, reimburse, request.getParameterMap());
		this.reimburseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除财务报账主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ReimburseEntity reimburse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		reimburse = systemService.getEntity(ReimburseEntity.class, reimburse.getId());
		message = "财务报账主表删除成功";
		reimburseService.delete(reimburse);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}

	/**
	 * 财务报账主表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ReimburseEntity reimburse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(reimburse.getId())) {
			List<ReimburseDetailEntity> reimburseDetailEntity=null;
			reimburse = reimburseService.getEntity(ReimburseEntity.class, reimburse.getId());
			reimburseDetailEntity=reimburse.getReimburseDetail();
			req.setAttribute("reimbursePage", reimburse);
			req.setAttribute("list", reimburseDetailEntity);
		}
		req.setAttribute("user", ResourceUtil.getSessionUserName());
		return new ModelAndView("com/gfdz/cw/reimburse");
	}
	
	/**
	 * 添加财务报账
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ReimburseEntity reimburse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(reimburse.getId())) {
			try {
				message = "财务报账更新成功";
				reimburseService.updateReimburse(reimburse, request);
			} catch (Exception e) {
				e.printStackTrace();
				message = "财务报账更新失败";
			}
		} else {
			message = "财务报账添加成功";
			reimburseService.reimburseWorkFlowStart(reimburse,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}


	

	/**
	 * 
	  * @Title: reimburseDetail
	  * @Description: 财务报帐详细信息
	  * @param reimburse
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月6日 上午10:23:39
	 */
	@RequestMapping(params = "reimburseDetail")
	public ModelAndView reimburseDetail(ReimburseEntity reimburse, HttpServletRequest req) {
		TSUser user =  ClientManager.getInstance().getClient().getUser();
	     
		if (StringUtil.isNotEmpty(reimburse.getId())) {
			reimburse = reimburseService.getEntity(ReimburseEntity.class,reimburse.getId());
			req.setAttribute("reimburse", reimburse);
		}
		req.setAttribute("user", user);
		return new ModelAndView("com/gfdz/zhb/reimburseDetail");
	}
	
	/**
	 * 
	  * @Title: taskCompletePageSelect
	  * @Description: 财务报帐任务处理页面跳转
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

			ReimburseEntity reimburse = reimburseService.get(ReimburseEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("reimburse",reimburse);
			model.addAttribute("taskKey", taskKey);
			
			
			return new ModelAndView("com/gfdz/zhb/reimburseHandle");
	}
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 财务报帐任务处理
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
