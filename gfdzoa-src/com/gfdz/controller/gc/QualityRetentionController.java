package com.gfdz.controller.gc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
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

import com.gfdz.entity.gc.QualityRetentionEntity;
import com.gfdz.entity.zhb.ZzsqEntity;
import com.gfdz.service.gc.QualityRetentionService;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 质量保证金发放
 * @author ant
 * @date 2015-08-21 10:58:51
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/qualityRetentionController")
public class QualityRetentionController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(QualityRetentionController.class);

	@Autowired
	private QualityRetentionService qualityRetentionService;
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
	 * 质量保证金发放列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "qualityRetentionList")
	public ModelAndView qualityRetentionList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/qualityRetentionList");
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
	public void datagrid(QualityRetentionEntity qualityRetention,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(QualityRetentionEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, qualityRetention, request.getParameterMap());
		this.qualityRetentionService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除质量保证金发放
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(QualityRetentionEntity qualityRetention, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		qualityRetention = systemService.getEntity(QualityRetentionEntity.class, qualityRetention.getId());
		message = "质量保证金发放删除成功";
		qualityRetentionService.delete(qualityRetention);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加质量保证金发放
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(QualityRetentionEntity qualityRetention, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(qualityRetention.getId())) {
			message = "质量保证金发放更新成功";
			QualityRetentionEntity t = qualityRetentionService.get(QualityRetentionEntity.class, qualityRetention.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(qualityRetention, t);
				qualityRetentionService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "质量保证金发放更新失败";
			}
		} else {
			message = "质量保证金发放添加成功";
			qualityRetentionService.qrWorkFlowStart(qualityRetention,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 质量保证金发放列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(QualityRetentionEntity qualityRetention, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(qualityRetention.getId())) {
			qualityRetention = qualityRetentionService.getEntity(QualityRetentionEntity.class, qualityRetention.getId());
			req.setAttribute("qualityRetention", qualityRetention);
		}
		return new ModelAndView("com/gfdz/gc/qualityRetention");
	}
	
	/**
	 * 
	  * @Title: qualityRetentionHandle
	  * @Description: 保证金发放申请
	  * @param processInstanceId
	  * @param taskId
	  * @param taskKey
	  * @param request
	  * @param model
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月24日 上午10:25:09
	 */
	@RequestMapping(params = "qualityRetentionHandle")
	public ModelAndView qualityRetentionHandle(
			@RequestParam("processInstanceId") String processInstanceId,
			@RequestParam("taskId") String taskId,@RequestParam("taskKey") String taskKey,HttpServletRequest request,Model model) {
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
			
			String businessKey = processInstance.getBusinessKey();

			QualityRetentionEntity qualityRetention = qualityRetentionService.get(QualityRetentionEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("qualityRetention",qualityRetention);
			model.addAttribute("taskKey", taskKey);
			
			if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
				return new ModelAndView("com/gfdz/gc/qualityRetentionEdit");
			}else{
				return new ModelAndView("com/gfdz/gc/qualityRetentionHandle");
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
		public AjaxJson completeTask(QualityRetentionEntity qualityRetention,Variable var,HttpServletRequest request) {
			AjaxJson j = new AjaxJson();
			
			try {
				qualityRetentionService.completeTask(qualityRetention, request);
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
		  * @Title: qualityRetentionDetail
		  * @Description: 查看审批详细信息
		  * @param leave
		  * @param req
		  * @return ModelAndView
		  * @throws 
		  * @exception
		  * @author fly
		  * @date 2015年6月24日 下午2:34:07
		 */
		@RequestMapping(params = "qualityRetentionDetail")
		public ModelAndView qualityRetentionDetail(QualityRetentionEntity qualityRetention, HttpServletRequest req) {
			
			String pid = req.getParameter("pid");
			qualityRetention = qualityRetentionService.findUniqueByProperty(QualityRetentionEntity.class,"processinstanceid", pid);
			req.setAttribute("pid", pid);
			req.setAttribute("qualityRetention", qualityRetention);
			return new ModelAndView("com/gfdz/gc/qualityRetentionDetail");
		}
}
