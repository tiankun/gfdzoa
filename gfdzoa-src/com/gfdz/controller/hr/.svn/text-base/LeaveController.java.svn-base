package com.gfdz.controller.hr;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;

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
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.hr.LeaveEntity;
import com.gfdz.service.hr.LeaveService;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 请假管理
 * @author ant
 * @date 2015-06-18 09:23:45
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/leaveController")
public class LeaveController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LeaveController.class);
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;

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
	 * 请假管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "leaveList")
	public ModelAndView leaveList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/leaveList");
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
	public void datagrid(LeaveEntity leave,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(LeaveEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, leave, request.getParameterMap());
		this.leaveService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除请假管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(LeaveEntity leave, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		leave = systemService.getEntity(LeaveEntity.class, leave.getId());
		message = "请假管理删除成功";
		leaveService.delete(leave);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加请假管理
	 * 
	 * @param ids
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(LeaveEntity leave, HttpServletRequest request) throws ParseException {
		AjaxJson j = new AjaxJson();
		Calendar calendar = Calendar.getInstance();
		if (StringUtil.isNotEmpty(leave.getId())) {
			message = "请假管理更新成功";
			LeaveEntity t = leaveService.get(LeaveEntity.class, leave.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(leave, t);
				leaveService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "请假管理更新失败";
			}
		} else {
			message = "请假管理添加成功";
			String beginScope = leave.getBeginScope();
			String endScope = leave.getEndScope();
			String begin = DateUtils.date_sdf.format(leave.getBeginDate());
			String end = DateUtils.date_sdf.format(leave.getEndDate());
			if( beginScope != null && "0".equals(beginScope)  ){
				begin+=" 00:00:00";
			}else {
				begin+=" 12:00:00";
			}
			if( endScope != null && "0".equals(endScope)  ){
				end+=" 12:00:00";
				calendar.setTime(DateUtils.datetimeFormat.parse(end));
			}else {
				end+=" 00:00:00";
				calendar.setTime(DateUtils.datetimeFormat.parse(end));
				calendar.add(Calendar.DATE, 1);
			}
			String sql="select count(*) from HR_VACATION_ARRANGEMENT t where t.vacation_date >= to_date(?, 'yyyy-MM-dd') and t.vacation_date <= to_date(?, 'yyyy-MM-dd')";
			double times =(calendar.getTimeInMillis()- DateUtils.datetimeFormat.parse(begin).getTime())/86400000d;
			Long days = (long) systemService.getCountForJdbcParam(sql, new Object[]{DateUtils.date_sdf.format(leave.getBeginDate()),DateUtils.date_sdf.format(calendar.getTime())});
			leave.setLeaveDays(Double.valueOf(times-days) );
			leaveService.leaveWorkFlowStart(leave,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 请假管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(LeaveEntity leave, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(leave.getId())) {
			leave = leaveService.getEntity(LeaveEntity.class, leave.getId());
			req.setAttribute("leave", leave);
		}
		return new ModelAndView("com/gfdz/hr/leave");
	}
	
	
	/**
     * 请假流程启动
     * @param deploymentId 流程部署ID
     */
	@RequestMapping(params = "leaveStart")
	@ResponseBody
	public AjaxJson leaveStart(LeaveEntity leave, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		leave.setLeaveUser(ResourceUtil.getSessionUserName());
		
		//请假流程启动
		leaveService.leaveWorkFlowStart(leave,request);
	
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
			@RequestParam("taskId") String taskId,@RequestParam("taskKey") String taskKey,HttpServletRequest request,Model model) {
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
			
			String businessKey = processInstance.getBusinessKey();

			LeaveEntity leave = leaveService.get(LeaveEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("leave",leave);
			model.addAttribute("taskKey", taskKey);
			
			if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
				return new ModelAndView("com/gfdz/hr/leaveEdit");

			}else{
				return new ModelAndView("com/gfdz/hr/leaveHandle");
			}
	}
	
	/**
     * 完成任务
     * @param deploymentId 流程部署ID
     */
	@RequestMapping(params = "completeTask")
	@ResponseBody
	public AjaxJson completeTask(LeaveEntity leave,Variable var,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		try {
			leaveService.completeTask(leave, request);
			String message = "办理成功";
			j.setMsg(message);
		} catch (Exception e) {
			String message = "办理失败";
			j.setMsg(message);
			e.printStackTrace();
		}
		
		return j;
	}
	
	/**
	 * 
	  * @Title: leaveDetail
	  * @Description: 请假流程详细
	  * @param leave
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月23日 下午3:05:02
	 */
	@RequestMapping(params = "leaveDetail")
	public ModelAndView leaveDetail(LeaveEntity leave, HttpServletRequest req) {
		
		String pid = req.getParameter("pid");
		leave = leaveService.findUniqueByProperty(LeaveEntity.class,"processinstanceid", pid);
		req.setAttribute("pid", pid);
		req.setAttribute("leave", leave);
		return new ModelAndView("com/gfdz/hr/leaveDetail");
	}
}
