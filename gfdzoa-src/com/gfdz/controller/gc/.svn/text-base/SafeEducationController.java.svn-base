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
import com.gfdz.entity.gc.SafeEducationEntity;
import com.gfdz.entity.gc.SafeEducationFilesEntity;
import com.gfdz.entity.hr.NoticeFilesEntity;
import com.gfdz.service.gc.SafeEducationServiceI;

/**   
 * @Title: Controller
 * @Description: 安全教育
 * @author ant
 * @date 2015-05-28 14:58:52
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/safeEducationController")
public class SafeEducationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SafeEducationController.class);

	@Autowired
	private SafeEducationServiceI safeEducationService;
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
	 * 安全教育列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "safeEducationList")
	public ModelAndView safeEducationList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/safeEducationList");
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
	public void datagrid(SafeEducationEntity safeEducation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SafeEducationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, safeEducation, request.getParameterMap());
		this.safeEducationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除安全教育
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SafeEducationEntity safeEducation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		safeEducation = systemService.getEntity(SafeEducationEntity.class, safeEducation.getId());
		message = "安全教育删除成功";
		safeEducationService.delete(safeEducation);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加安全教育
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SafeEducationEntity safeEducation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(safeEducation.getId())) {
			message = "安全教育更新成功";
			SafeEducationEntity t = safeEducationService.get(SafeEducationEntity.class, safeEducation.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(safeEducation, t);
				safeEducationService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "安全教育更新失败";
			}
		} else {
			message = "安全教育添加成功";
			safeEducationService.save(safeEducation);
			j.setObj(safeEducation);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 安全教育列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SafeEducationEntity safeEducation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(safeEducation.getId())) {
			safeEducation = safeEducationService.getEntity(SafeEducationEntity.class, safeEducation.getId());
			req.setAttribute("safeEducation", safeEducation);
			if(safeEducation.getSafeEducationFiles()!=null && safeEducation.getSafeEducationFiles().size()>0){
				req.setAttribute("safeEducationFileId", safeEducation.getSafeEducationFiles().get(0).getId());
				if("detail".equals(req.getParameter("load"))){
					return new ModelAndView("com/gfdz/gc/safeEducationDetail");
				}
			}
		}
		return new ModelAndView("com/gfdz/gc/safeEducation");
	}
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, SafeEducationFilesEntity safeEducationFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String safeEducationId = oConvertUtils.getString(request.getParameter("safeEducationId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			safeEducationFiles.setId(fileKey);
			safeEducationFiles = systemService.getEntity(SafeEducationFilesEntity.class, fileKey);

		}
		SafeEducationEntity safeEducation = systemService.getEntity(SafeEducationEntity.class, safeEducationId);
		ProjectInfoEntity projectInfo = safeEducation.getProject();
		safeEducationFiles.setSafeEducation(safeEducation);
		safeEducationFiles.setProject(projectInfo);
		UploadFile uploadFile = new UploadFile(request, safeEducationFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		safeEducationFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", safeEducationFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + safeEducationFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + safeEducationFiles.getId());
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
		SafeEducationFilesEntity file = safeEducationService.getEntity(SafeEducationFilesEntity.class, id);
		safeEducationService.deleteFile(file);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
	
}
