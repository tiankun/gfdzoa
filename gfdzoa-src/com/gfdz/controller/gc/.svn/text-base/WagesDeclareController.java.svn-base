package com.gfdz.controller.gc;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
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

import com.gfdz.entity.gc.CostApprovalEntity;
import com.gfdz.entity.gc.WagesDeclareEntity;
import com.gfdz.service.gc.WagesDeclareService;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 工资申报
 * @author ant
 * @date 2015-05-28 14:57:51
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/wagesDeclareController")
public class WagesDeclareController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WagesDeclareController.class);

	@Autowired
	private WagesDeclareService wagesDeclareService;
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 工资申报列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "wagesDeclareList")
	public ModelAndView wagesDeclareList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/wagesDeclareList");
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
	public void datagrid(WagesDeclareEntity wagesDeclare,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WagesDeclareEntity.class, dataGrid);
		
		String pId = request.getParameter("pId");
		if(pId!=null&&!"".equals(pId)){
			cq.add(Restrictions.eq("project.id", pId));
		}
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wagesDeclare, request.getParameterMap());
		this.wagesDeclareService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除工资申报
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(WagesDeclareEntity wagesDeclare, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		wagesDeclare = systemService.getEntity(WagesDeclareEntity.class, wagesDeclare.getId());
		message = "工资申报删除成功";
		wagesDeclareService.delete(wagesDeclare);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加工资申报
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(WagesDeclareEntity wagesDeclare, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(wagesDeclare.getId())) {
			message = "工资申报更新成功";
			WagesDeclareEntity t = wagesDeclareService.get(WagesDeclareEntity.class, wagesDeclare.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(wagesDeclare, t);
				wagesDeclareService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "工资申报更新失败";
			}
		} else {
			message = "工资申报添加成功";
			wagesDeclareService.wagesWorkFlowStart(wagesDeclare,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 工资申报列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(WagesDeclareEntity wagesDeclare, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wagesDeclare.getId())) {
			wagesDeclare = wagesDeclareService.getEntity(WagesDeclareEntity.class, wagesDeclare.getId());
			req.setAttribute("wagesDeclare", wagesDeclare);
			CostApprovalEntity costApproval = wagesDeclareService.findUniqueByProperty(CostApprovalEntity.class, "project.id", wagesDeclare.getProject().getId());
			req.setAttribute("costApproval", costApproval);
			req.setAttribute("pId", wagesDeclare.getProject().getId());
		}
		req.setAttribute("user", ResourceUtil.getSessionUserName());
		req.setAttribute("date",new Date());
		return new ModelAndView("com/gfdz/gc/wagesDeclare");
	}
	
	@RequestMapping(params = "taskCompletePageSelect")
	public ModelAndView taskCompletePageSelect(
			@RequestParam("processInstanceId") String processInstanceId,
			@RequestParam("taskId") String taskId,@RequestParam("taskKey") String taskKey,HttpServletRequest request,Model model) {
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
			
			String businessKey = processInstance.getBusinessKey();

			WagesDeclareEntity wagesDeclare = wagesDeclareService.get(WagesDeclareEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("wagesDeclare",wagesDeclare);
			model.addAttribute("taskKey", taskKey);
			
			if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
				return new ModelAndView("com/gfdz/gc/wagesDeclareEdit");
			}else{
				return new ModelAndView("com/gfdz/gc/wagesDeclareHandle");
			}
	}
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 完成任务
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
	public AjaxJson completeTask(WagesDeclareEntity wagesDeclare,Variable var,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			wagesDeclareService.completeTask(wagesDeclare, request);
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
	  * @Title: wagesDeclareDetail
	  * @Description: 查看审批详细信息
	  * @param leave
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月24日 下午2:34:07
	 */
	@RequestMapping(params = "wagesDeclareDetail")
	public ModelAndView wagesDeclareDetail(WagesDeclareEntity wagesDeclare, HttpServletRequest req) {
		
		String pid = req.getParameter("pid");
		wagesDeclare = wagesDeclareService.findUniqueByProperty(WagesDeclareEntity.class,"processinstanceId", pid);
		req.setAttribute("pid", pid);
		req.setAttribute("wagesDeclare", wagesDeclare);
		return new ModelAndView("com/gfdz/gc/wagesDeclareDetail");
	}
	
}
