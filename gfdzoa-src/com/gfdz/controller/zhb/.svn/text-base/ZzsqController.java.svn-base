package com.gfdz.controller.zhb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

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
import org.jeecgframework.core.util.QueryUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
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

import com.gfdz.entity.zhb.ZzsqEntity;
import com.gfdz.service.zhb.ZzsqServiceI;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 证章申请信息
 * @author ant
 * @date 2015-05-29 14:23:28
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/zzsqController")
public class ZzsqController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZzsqController.class);

	@Autowired
	private ZzsqServiceI zzsqService;
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
	 * 证章申请信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zzsqList")
	public ModelAndView zzsqList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/zzsqList");
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
	public void datagrid(ZzsqEntity zzsq,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZzsqEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zzsq, request.getParameterMap());
		this.zzsqService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除证章申请信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ZzsqEntity zzsq, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zzsq = systemService.getEntity(ZzsqEntity.class, zzsq.getId());
		message = "证章申请信息删除成功";
		zzsqService.delete(zzsq);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加证章申请信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ZzsqEntity zzsq, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(zzsq.getId())) {
			message = "证章申请信息更新成功";
			ZzsqEntity t = zzsqService.get(ZzsqEntity.class, zzsq.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(zzsq, t);
				zzsqService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "证章申请信息更新失败";
			}
		} else {
			message = "证章申请信息添加成功";
			zzsqService.zzsqWorkFlowStart(zzsq,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 证章申请信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ZzsqEntity zzsq, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zzsq.getId())) {
			zzsq = zzsqService.getEntity(ZzsqEntity.class, zzsq.getId());
			req.setAttribute("zzsq", zzsq);
		}
		return new ModelAndView("com/gfdz/zhb/zzsq");
	}
	
	
	/**
	 * 
	  * @Title: taskCompletePageSelect
	  * @Description: 完成证章申请跳转
	  * @param processInstanceId
	  * @param taskId
	  * @param taskKey
	  * @param request
	  * @param model
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月24日 下午2:32:15
	 */
	@RequestMapping(params = "taskCompletePageSelect")
	public ModelAndView taskCompletePageSelect(
			@RequestParam("processInstanceId") String processInstanceId,
			@RequestParam("taskId") String taskId,@RequestParam("taskKey") String taskKey,HttpServletRequest request,Model model) {
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
			
			String businessKey = processInstance.getBusinessKey();

			ZzsqEntity zzsq = zzsqService.get(ZzsqEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("zzsq",zzsq);
			model.addAttribute("taskKey", taskKey);
			
			if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
				return new ModelAndView("com/gfdz/zhb/zzsqEdit");
			}else{
				return new ModelAndView("com/gfdz/zhb/zzsqHandle");
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
	public AjaxJson completeTask(ZzsqEntity zzsq,Variable var,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		try {
			zzsqService.completeTask(zzsq, request);
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
	  * @Title: zzsqDetail
	  * @Description: 查看审批详细信息
	  * @param leave
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月24日 下午2:34:07
	 */
	@RequestMapping(params = "zzsqDetail")
	public ModelAndView zzsqDetail(ZzsqEntity zzsq, HttpServletRequest req) {
		
		String pid = req.getParameter("pid");
		zzsq = zzsqService.findUniqueByProperty(ZzsqEntity.class,"processinstanceid", pid);
		req.setAttribute("pid", pid);
		req.setAttribute("zzsq", zzsq);
		return new ModelAndView("com/gfdz/zhb/zzsqDetail");
	}
	
	@ResponseBody
	@RequestMapping(params = "getStaff")
	public JSONArray getStaff(String depId) {
		List<TSUser> list;
		if (StringUtil.isNotEmpty(depId)) {
			list = zzsqService.findHql("select new TSUser(s.id,s.realName) from TSUser s where s.TSDepart.id=? and (s.TSDepart.ctype='200' or s.TSDepart.ctype='500') ", depId);
		} else {
			list = zzsqService.findHql("select new TSUser(s.id,s.realName) from TSUser s "
					+ "where s.id in (select t.tsUser.id from TSUserOrg t where t.tsDepart.orgCode='0103')");
		}
		List<String> entityName = new ArrayList<String>();
		entityName.add("id");
		entityName.add("realName");
		return QueryUtils.entityList2JSONArray(list, entityName, null);
	}
	
}
