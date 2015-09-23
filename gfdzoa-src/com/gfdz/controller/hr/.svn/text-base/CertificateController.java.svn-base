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

import com.gfdz.entity.hr.CertificateEntity;
import com.gfdz.entity.hr.CertificateFilesEntity;
import com.gfdz.service.hr.CertificateService;

/**   
 * @Title: Controller
 * @Description: 证书管理
 * @author ant
 * @date 2015-06-15 15:16:50
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/certificateController")
public class CertificateController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CertificateController.class);

	@Autowired
	private CertificateService certificateService;
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
	 * 证书管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "certificateList")
	public ModelAndView certificateList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/certificateList");
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
	public void datagrid(CertificateEntity certificate,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CertificateEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, certificate, request.getParameterMap());
		String personId = request.getParameter("personId");
		cq.add(Restrictions.eq("personId", personId));
		this.certificateService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除证书管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(CertificateEntity certificate, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		certificate = systemService.getEntity(CertificateEntity.class, certificate.getId());
		message = "证书管理删除成功";
		certificateService.delete(certificate);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加证书管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(CertificateEntity certificate, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(certificate.getId())) {
			message = "证书管理更新成功";
			CertificateEntity t = certificateService.get(CertificateEntity.class, certificate.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(certificate, t);
				certificateService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "证书管理更新失败";
			}
		} else {
			message = "证书管理添加成功";
			certificateService.save(certificate);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(certificate);
		j.setMsg(message);
		return j;
	}

	/**
	 * 证书管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(CertificateEntity certificate, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(certificate.getId())) {
			certificate = certificateService.getEntity(CertificateEntity.class, certificate.getId());
			req.setAttribute("certificate", certificate);
			if(certificate.getCertificateFiles()!=null && certificate.getCertificateFiles().size()>0){
				req.setAttribute("certificateFileId", certificate.getCertificateFiles().get(0).getId());
			}
		}
		return new ModelAndView("com/gfdz/hr/certificate");
	}
	
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, CertificateFilesEntity certificateFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String certificateId = oConvertUtils.getString(request.getParameter("certificateId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			certificateFiles.setId(fileKey);
			certificateFiles = systemService.getEntity(CertificateFilesEntity.class, fileKey);

		}
		CertificateEntity certificate = systemService.getEntity(CertificateEntity.class, certificateId);
		certificateFiles.setCertificate(certificate);
		UploadFile uploadFile = new UploadFile(request, certificateFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		certificateFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", certificateFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + certificateFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + certificateFiles.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}
	
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile( HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id  = request.getParameter("id");
		CertificateFilesEntity file = certificateService.getEntity(CertificateFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		certificateService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
}
