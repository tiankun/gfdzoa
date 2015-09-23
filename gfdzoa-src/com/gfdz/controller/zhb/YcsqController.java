package com.gfdz.controller.zhb;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.zhb.YcsqEntity;
import com.gfdz.service.zhb.YcsqServiceI;
import com.gfdz.util.workflow.Variable;



/**   
 * @Title: Controller
 * @Description: 用车申请
 * @author onlineGenerator
 * @date 2015-05-28 13:54:14
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/ycsqController")
public class YcsqController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(YcsqController.class);
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;

	@Autowired
	private YcsqServiceI ycsqService;
	
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
	 * 用车申请列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "ycsqList")
	public ModelAndView ycsqList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/ycsqList");
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
	public void datagrid(YcsqEntity ycsq,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(YcsqEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ycsq, request.getParameterMap());
		String lxbh=request.getParameter("lxbh");
		if (!"".equals(lxbh)&&lxbh!=null) {
	
		try{
		//自定义追加查询条件
			cq.like("lxbh", "%"+request.getParameter("lxbh")+"%");
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		}
		this.ycsqService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除用车申请
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(YcsqEntity ycsq, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		ycsq = systemService.getEntity(YcsqEntity.class, ycsq.getId());
		message = "用车申请删除成功";
		try{
			ycsqService.delete(ycsq);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用车申请删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除用车申请
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "用车申请删除成功";
		try{
			for(String id:ids.split(",")){
				YcsqEntity ycsq = systemService.getEntity(YcsqEntity.class, 
				id
				);
				ycsqService.delete(ycsq);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "用车申请删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

 /**
	 * 用车申请新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "ycsq")
	public ModelAndView ycsq(YcsqEntity ycsq, HttpServletRequest req) {
		TSUser user = ResourceUtil.getSessionUserName();
		if (StringUtil.isNotEmpty(ycsq.getId())) {
			ycsq = ycsqService.getEntity(YcsqEntity.class,ycsq.getId());
			req.setAttribute("ycsq", ycsq);
		}
		req.setAttribute("date", new Date());
		req.setAttribute("user", user);
		return new ModelAndView("com/gfdz/zhb/ycsq");
	}
	
	/**
	 * 添加用车申请
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(YcsqEntity ycsq, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "用车申请添加成功";
		try{
			ycsqService.ycsqWorkFlowStart(ycsq,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用车申请添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 
	  * @Title: ycsqDetail
	  * @Description: 用车申请详细信息
	  * @param ycsq
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月6日 上午10:23:39
	 */
	@RequestMapping(params = "ycsqDetail")
	public ModelAndView ycsqDetail(YcsqEntity ycsq, HttpServletRequest req) {
		
		String pid = req.getParameter("pid");
		ycsq = ycsqService.findUniqueByProperty(YcsqEntity.class,"processinstanceid", pid);
		req.setAttribute("pid", pid);
		req.setAttribute("ycsq", ycsq);
		
		return new ModelAndView("com/gfdz/zhb/ycsqDetail");
	}
	
	/**
	 * 
	  * @Title: taskCompletePageSelect
	  * @Description: 用车申请任务处理页面跳转
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

			YcsqEntity ycsq = ycsqService.get(YcsqEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("ycsq",ycsq);
			model.addAttribute("taskKey", taskKey);
			if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
				return new ModelAndView("com/gfdz/zhb/ycsqEdit");
			}else{
				return new ModelAndView("com/gfdz/zhb/ycsqHandle");
			}
	}
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 用车申请任务处理
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
	public AjaxJson completeTask(YcsqEntity ycsq,Variable var,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		try {
			ycsqService.completeTask(ycsq, request);
			String message = "办理成功";
			j.setMsg(message);
		} catch (Exception e) {
			String message = "办理失败";
			j.setMsg(message);
			e.printStackTrace();		}
		
		return j;
	}
	
	
	/**
	 * 更新用车申请
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(YcsqEntity ycsq, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "用车申请更新成功";
		YcsqEntity t = ycsqService.get(YcsqEntity.class, ycsq.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ycsq, t);
			ycsqService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用车申请更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	
	/**
	 * 用车申请编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(YcsqEntity ycsq, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ycsq.getId())) {
			ycsq = ycsqService.getEntity(YcsqEntity.class, ycsq.getId());
			req.setAttribute("ycsqPage", ycsq);
		}
		return new ModelAndView("com/gfdz/zhb/ycsq-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/gfdz/zhb/ycsqUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(YcsqEntity ycsq,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(YcsqEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ycsq, request.getParameterMap());
		List<YcsqEntity> ycsqs = this.ycsqService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"用车申请");
		modelMap.put(NormalExcelConstants.CLASS,YcsqEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("用车申请列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ycsqs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(YcsqEntity ycsq,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "用车申请");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,YcsqEntity.class);
		modelMap.put(TemplateExcelConstants.LIST_DATA,null);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<YcsqEntity> listycsqEntitys = ExcelImportUtil.importExcelByIs(file.getInputStream(),YcsqEntity.class,params);
				for (YcsqEntity ycsq : listycsqEntitys) {
					ycsqService.save(ycsq);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
}
