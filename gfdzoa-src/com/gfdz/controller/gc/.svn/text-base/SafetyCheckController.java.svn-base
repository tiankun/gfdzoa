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

import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.gc.SafetyCheckEntity;
import com.gfdz.entity.gc.SafetyCheckFilesEntity;
import com.gfdz.service.gc.SafetyCheckServiceI;

/**   
 * @Title: Controller
 * @Description: 安全检查
 * @author ant
 * @date 2015-05-28 14:56:58
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/safetyCheckController")
public class SafetyCheckController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SafetyCheckController.class);

	@Autowired
	private SafetyCheckServiceI safetyCheckService;
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
	 * 安全检查列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "safetyCheckList")
	public ModelAndView safetyCheckList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/safetyCheckList");
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
	public void datagrid(SafetyCheckEntity safetyCheck,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SafetyCheckEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, safetyCheck, request.getParameterMap());
		this.safetyCheckService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除安全检查
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SafetyCheckEntity safetyCheck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		safetyCheck = systemService.getEntity(SafetyCheckEntity.class, safetyCheck.getId());
		message = "安全检查删除成功";
		safetyCheckService.delete(safetyCheck);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加安全检查
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SafetyCheckEntity safetyCheck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(safetyCheck.getId())) {
			message = "安全检查更新成功";
			SafetyCheckEntity t = safetyCheckService.get(SafetyCheckEntity.class, safetyCheck.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(safetyCheck, t);
				safetyCheckService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "安全检查更新失败";
			}
		} else {
			message = "安全检查添加成功";
			safetyCheckService.save(safetyCheck);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(safetyCheck);
		j.setMsg(message);
		return j;
	}

	/**
	 * 安全检查列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SafetyCheckEntity safetyCheck, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(safetyCheck.getId())) {
			safetyCheck = safetyCheckService.getEntity(SafetyCheckEntity.class, safetyCheck.getId());
			req.setAttribute("safetyCheck", safetyCheck);
			if(safetyCheck.getSafetyCheckFiles()!=null && safetyCheck.getSafetyCheckFiles().size()>0){
				req.setAttribute("safetyCheckFileId", safetyCheck.getSafetyCheckFiles().get(0).getId());
				if("detail".equals(req.getParameter("load"))){
					return new ModelAndView("com/gfdz/gc/safetyCheckDetail");
				}
			}
		}
		return new ModelAndView("com/gfdz/gc/safetyCheck");
	}
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, SafetyCheckFilesEntity safetyCheckFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String safetyCheckId = oConvertUtils.getString(request.getParameter("safetyCheckId"));//ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			safetyCheckFiles.setId(fileKey);
			safetyCheckFiles = systemService.getEntity(SafetyCheckFilesEntity.class, fileKey);

		}
		SafetyCheckEntity safetyCheck = systemService.getEntity(SafetyCheckEntity.class, safetyCheckId);
		ProjectInfoEntity projectInfo = safetyCheck.getProject();
		safetyCheckFiles.setSafetyCheck(safetyCheck);
		safetyCheckFiles.setProject(projectInfo);
		UploadFile uploadFile = new UploadFile(request, safetyCheckFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		safetyCheckFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", safetyCheckFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + safetyCheckFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + safetyCheckFiles.getId());
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
		SafetyCheckFilesEntity file = safetyCheckService.getEntity(SafetyCheckFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		safetyCheckService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
	
}
