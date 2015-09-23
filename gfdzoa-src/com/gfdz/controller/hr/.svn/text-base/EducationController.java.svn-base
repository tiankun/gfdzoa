package com.gfdz.controller.hr;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
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

import com.gfdz.entity.hr.EducationEntity;
import com.gfdz.entity.hr.EducationFilesEntity;
import com.gfdz.service.hr.EducationService;

/**   
 * @Title: Controller
 * @Description: 个人学历信息
 * @author ant
 * @date 2015-06-11 11:28:34
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/educationController")
public class EducationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EducationController.class);

	@Autowired
	private EducationService educationService;
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
	 * 个人学历信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "educationList")
	public ModelAndView educationList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/educationList");
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
	public void datagrid(EducationEntity education,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		CriteriaQuery cq = new CriteriaQuery(EducationEntity.class, dataGrid);
		//查询条件组装器
		String personId = request.getParameter("personId");
		cq.add(Restrictions.eq("personId", personId));
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, education, request.getParameterMap());
		this.educationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除个人学历信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(EducationEntity education, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		education = systemService.getEntity(EducationEntity.class, education.getId());
		message = "个人学历信息删除成功";
		educationService.delete(education);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加个人学历信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(EducationEntity education, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(education.getId())) {
			message = "个人学历信息更新成功";
			EducationEntity t = educationService.get(EducationEntity.class, education.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(education, t);
				educationService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "个人学历信息更新失败";
			}
		} else {
			String personId = request.getParameter("personId");
			message = "个人学历信息添加成功";
			education.setPersonId(personId);
			educationService.save(education);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(education);
		j.setMsg(message);
		return j;
	}

	/**
	 * 个人学历信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(EducationEntity education, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(education.getId())) {
			education = educationService.getEntity(EducationEntity.class, education.getId());
			req.setAttribute("education", education);
			if(education.getEducationFiles()!=null && education.getEducationFiles().size()>0){
				req.setAttribute("educationFilesId", education.getEducationFiles().get(0).getId());
			}
		}
		return new ModelAndView("com/gfdz/hr/education");
	}
	
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, EducationFilesEntity educationFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String educationId = oConvertUtils.getString(request.getParameter("educationId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			educationFiles.setId(fileKey);
			educationFiles = systemService.getEntity(EducationFilesEntity.class, fileKey);

		}
		EducationEntity education = systemService.getEntity(EducationEntity.class, educationId);
		educationFiles.setEducation(education);
		UploadFile uploadFile = new UploadFile(request, educationFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		educationFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", educationFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + educationFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + educationFiles.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}
	
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile( HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id  = request.getParameter("id");
		EducationFilesEntity file = educationService.getEntity(EducationFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		educationService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
}
