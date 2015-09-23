package com.gfdz.controller.hr;
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

import com.gfdz.entity.hr.CertificateEntity;
import com.gfdz.entity.hr.CertificateFilesEntity;
import com.gfdz.service.hr.CertificateFilesService;

/**   
 * @Title: Controller
 * @Description: 证书信息附件
 * @author ant
 * @date 2015-07-01 17:01:14
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/certificateFilesController")
public class CertificateFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CertificateFilesController.class);

	@Autowired
	private CertificateFilesService certificateFilesService;
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
	 * 证书信息附件列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "certificateFilesList")
	public ModelAndView certificateFilesList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/certificateFilesList");
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
	public void datagrid(CertificateFilesEntity certificateFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CertificateFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, certificateFiles, request.getParameterMap());
		this.certificateFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除证书信息附件
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(CertificateFilesEntity certificateFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		certificateFiles = systemService.getEntity(CertificateFilesEntity.class, certificateFiles.getId());
		message = "证书信息附件删除成功";
		certificateFilesService.delete(certificateFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加证书信息附件
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(CertificateFilesEntity certificateFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(certificateFiles.getId())) {
			message = "证书信息附件更新成功";
			CertificateFilesEntity t = certificateFilesService.get(CertificateFilesEntity.class, certificateFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(certificateFiles, t);
				certificateFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "证书信息附件更新失败";
			}
		} else {
			message = "证书信息附件添加成功";
			certificateFilesService.save(certificateFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 证书信息附件列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(CertificateFilesEntity certificateFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(certificateFiles.getId())) {
			certificateFiles = certificateFilesService.getEntity(CertificateFilesEntity.class, certificateFiles.getId());
			req.setAttribute("certificateFiles", certificateFiles);
		}
		return new ModelAndView("com/gfdz/hr/certificateFiles");
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
		CertificateFilesEntity file = certificateFilesService.getEntity(CertificateFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		certificateFilesService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
}
