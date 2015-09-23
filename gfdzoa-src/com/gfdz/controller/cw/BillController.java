package com.gfdz.controller.cw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.QueryUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSTerritory;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;

import com.gfdz.entity.cw.BillEntity;
import com.gfdz.entity.cw.BillFilesEntity;
import com.gfdz.entity.cw.ReimburseEntity;
import com.gfdz.entity.hr.EducationEntity;
import com.gfdz.entity.hr.EducationFilesEntity;
import com.gfdz.entity.hr.LeaveEntity;
import com.gfdz.service.cw.BillServiceI;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 发票开具记录
 * @author ant
 * @date 2015-05-28 13:51:07
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/billController")
public class BillController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BillController.class);
    
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	
	@Autowired
	private BillServiceI billService;
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
	 * 发票开具记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "billList")
	public ModelAndView billList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/billList");
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
	public void datagrid(BillEntity bill,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BillEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bill, request.getParameterMap());
		this.billService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除发票开具记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(BillEntity bill, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bill = systemService.getEntity(BillEntity.class, bill.getId());
		message = "发票开具记录删除成功";
		billService.delete(bill);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加发票开具记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(BillEntity bill, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(bill.getId())) {
			message = "发票开具记录更新成功";
			BillEntity t = billService.get(BillEntity.class, bill.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(bill, t);
				billService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "发票开具记录更新失败";
			}
		} else {
			message = "发票开具记录添加成功";
			billService.billWorkFlowStart(bill, request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", bill.getId());
		j.setAttributes(map);
	
		j.setMsg(message);
		return j;
	}

	/**
	 * 发票开具记录列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(BillEntity bill, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bill.getId())) {
			bill = billService.getEntity(BillEntity.class, bill.getId());
			req.setAttribute("stype", bill.getStype());
			req.setAttribute("billPage", bill);
			List<TSType> ftype = TSTypegroup.allTypes.get("ftype".toLowerCase());
			req.setAttribute("ftype", ftype);
		}else{
			
			req.setAttribute("stype", 9999);
		}
		List<TSType> ftype = TSTypegroup.allTypes.get("ftype".toLowerCase());
		req.setAttribute("ftype", ftype);
		req.setAttribute("user", ResourceUtil.getSessionUserName());
		return new ModelAndView("com/gfdz/cw/bill");
	}
	
	/**
	 * 
	  * @Title: getStype
	  * @Description: 获取地址下级目录
	  * @param parentId
	  * @return JSONArray
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月8日 下午2:06:13
	 */
	@ResponseBody
	@RequestMapping(params = "getStype")
	public JSONArray  getStype(String ftype,HttpServletRequest req) {
		List<TSType> list1 = new ArrayList<TSType>();
		List list = null;
		TSType tsType=null;
         if (StringUtil.isNotEmpty(ftype)) {
        	 list = billService.findListbySql("select t.id" +
        	 		" from T_S_TYPE t " +
        	 		" where t.typegroupid =(select m.id from T_S_TYPEGROUP m where m.typegroupcode = 'ftype')" +
        	 		" and t.typecode ="+ftype); 
        	 
        	 List<TSType> stype = TSTypegroup.allTypes.get("stype".toLowerCase());
        	 for (int i = 0; i < stype.size(); i++) {
        		 tsType=stype.get(i);
        		 if (!("").equals(tsType)&&tsType!=null) {
        			 if(tsType.getTSType().getId().toString().equals(list.get(0).toString())){
        				 list1.add(tsType);
        			 }
        		 }
        	 }
		}
         
		
		   req.setAttribute("list1", list1);
		   List<String> entityName = new ArrayList<String>();
			entityName.add("typecode");
			entityName.add("typename");
			return QueryUtils.entityList2JSONArray(list1, entityName, null);
	}
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, BillFilesEntity billFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String billId = oConvertUtils.getString(request.getParameter("billId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			billFiles.setId(fileKey);
			billFiles = systemService.getEntity(BillFilesEntity.class, fileKey);

		}
		BillEntity bill = systemService.getEntity(BillEntity.class, billId);
		billFiles.setBill(bill);
		UploadFile uploadFile = new UploadFile(request, billFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		billFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", billFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + billFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + billFiles.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile( HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id  = request.getParameter("id");
		BillFilesEntity file = billService.getEntity(BillFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		billService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
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

			BillEntity bill = billService.get(BillEntity.class,businessKey);
			List<TSType> ftype = TSTypegroup.allTypes.get("ftype".toLowerCase());
			model.addAttribute("ftype", ftype);
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("billPage",bill);
			model.addAttribute("stype", bill.getStype());
			model.addAttribute("taskKey", taskKey);
			return new ModelAndView("com/gfdz/cw/billHandle");
	}
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 发票开具任务处理
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
	public AjaxJson completeTask(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String taskKey = request.getParameter("taskKey");	//任务步骤
		String auditType = request.getParameter("auditType");//是否同意
		String  billState = request.getParameter("billState");//发票状态
		String postil = request.getParameter("postil");      //批注信息
		String isout = request.getParameter("isout");
		String taskId = request.getParameter("taskId");
		Map<String, Object> variables = taskService.getVariables(taskId);
		if(taskKey.equals(ProcessConstantsUtil.getDeptLeaderAudit())){//部门经理审批
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), "0".equals(auditType) ? false : true);
			TSDepart depart = billService.findUniqueByProperty(TSDepart.class, "description", "treasurerAudit");
			variables.put(ProcessConstantsUtil.getTreasurerId(), depart.getDepartManager().getId());
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), ResourceUtil.getSessionUserName().getCurrentDepart().getManagerLeader().getId());
		}else if(taskKey.equals(ProcessConstantsUtil.getLeaderManagerAudit())){//分管领导审批
			variables.put(ProcessConstantsUtil.getLeaderManagerPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getApplyUserId(),request.getParameter("applyUserId"));
		}else if(taskKey.equals(ProcessConstantsUtil.getTreasurerAudit())){//财务主管审批
			variables.put(ProcessConstantsUtil.getTreasurerPass(), "0".equals(auditType) ? false : true);
		}else if(taskKey.equals(ProcessConstantsUtil.getCashierExecute())){//出纳执行
			// 签收
			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());
			if ("true".equals(billState)) {
				variables.put(ProcessConstantsUtil.getInvalid(), true);
			}else if ("false".equals(billState)) {
				variables.put(ProcessConstantsUtil.getInvalid(), false);
			}
		}else if(taskKey.equals(ProcessConstantsUtil.getAccountPayee())) {
			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());
			variables.put(ProcessConstantsUtil.getAccountPayee(), ResourceUtil.getSessionUserName().getId());
		}else if(taskKey.equals(ProcessConstantsUtil.getInvalidInvoice())){
			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());
			variables.put(ProcessConstantsUtil.getInvalidInvoice(), ResourceUtil.getSessionUserName().getId());
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
	/**
	 * 
	  * @Title: billDetail
	  * @Description: 发票开具流程详细
	  * @param leave
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月23日 下午3:05:02
	 */
	@RequestMapping(params = "billDetail")
	public ModelAndView billDetail(BillEntity bill, HttpServletRequest req) {
		String pid = req.getParameter("pid");
		bill = billService.findUniqueByProperty(BillEntity.class,"processinstanceid", pid);
		List<TSType> ftype = TSTypegroup.allTypes.get("ftype".toLowerCase());
		req.setAttribute("ftype", ftype);
		req.setAttribute("pid", pid);
		req.setAttribute("billPage", bill);
		req.setAttribute("stype", bill.getStype());
		return new ModelAndView("com/gfdz/cw/billDetail");
	}
	
}
