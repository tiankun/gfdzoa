package com.gfdz.controller.gc;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.gc.ProjectTaskEntity;
import com.gfdz.entity.gc.ProjectTaskFilesEntity;
import com.gfdz.service.gc.ProjectTaskServiceI;

/**   
 * @Title: Controller
 * @Description: 工程计划表
 * @author ant
 * @date 2015-05-28 14:54:18
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/projectTaskController")
public class ProjectTaskController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProjectTaskController.class);

	@Autowired
	private ProjectTaskServiceI projectTaskService;
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
	 * 工程计划表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "projectTaskList")
	public ModelAndView projectTaskList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/projectTaskList");
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
	public void datagrid(ProjectTaskEntity projectTask,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProjectTaskEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, projectTask, request.getParameterMap());
		this.projectTaskService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除工程计划表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ProjectTaskEntity projectTask, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		projectTask = systemService.getEntity(ProjectTaskEntity.class, projectTask.getId());
		message = "工程计划表删除成功";
		projectTaskService.delete(projectTask);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加工程计划表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ProjectTaskEntity projectTask, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(projectTask.getId())) {
			message = "工程计划表更新成功";
			ProjectTaskEntity t = projectTaskService.get(ProjectTaskEntity.class, projectTask.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(projectTask, t);
				projectTaskService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "工程计划表更新失败";
			}
		} else {
			message = "工程计划表添加成功";
			projectTaskService.save(projectTask);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(projectTask);
		j.setMsg(message);
		return j;
	}

	/**
	 * 工程计划表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ProjectTaskEntity projectTask, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(projectTask.getId())) {
			projectTask = projectTaskService.getEntity(ProjectTaskEntity.class, projectTask.getId());
			req.setAttribute("projectTask", projectTask);
			if(projectTask.getProjectTaskFiles()!=null && projectTask.getProjectTaskFiles().size()>0){
				req.setAttribute("projectTaskFile", projectTask.getProjectTaskFiles().get(0).getId());
				if("detail".equals(req.getParameter("load"))){
					return new ModelAndView("com/gfdz/gc/projectTaskDetail");
				}
			}
		}
		return new ModelAndView("com/gfdz/gc/projectTask");
	}
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, ProjectTaskFilesEntity projectTaskFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String projectTaskId = oConvertUtils.getString(request.getParameter("projectTaskId"));//ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			projectTaskFiles.setId(fileKey);
			projectTaskFiles = systemService.getEntity(ProjectTaskFilesEntity.class, fileKey);

		}
		ProjectTaskEntity projectTask = systemService.getEntity(ProjectTaskEntity.class, projectTaskId);
		projectTaskFiles.setProject(projectTask.getProject());
		projectTaskFiles.setProjectTask(projectTask);
		UploadFile uploadFile = new UploadFile(request, projectTaskFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		projectTaskFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", projectTaskFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + projectTaskFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + projectTaskFiles.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}
	
	/**
	 * 
	  * @Title: delFile
	  * @Description: 删除附件
	  * @param request
	  * @return AjaxJson
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月2日 下午4:44:26
	 */
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile( HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id  = request.getParameter("id");
		ProjectTaskFilesEntity file = projectTaskService.getEntity(ProjectTaskFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		projectTaskService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
}
