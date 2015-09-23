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
import com.gfdz.entity.hr.PersonContractEntity;
import com.gfdz.entity.hr.PersonContractFilesEntity;
import com.gfdz.service.hr.PersonContractService;

/**   
 * @Title: Controller
 * @Description: 个人合同信息
 * @author ant
 * @date 2015-06-11 11:27:04
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/personContractController")
public class PersonContractController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PersonContractController.class);

	@Autowired
	private PersonContractService personContractService;
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
	 * 个人合同信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "personContractList")
	public ModelAndView personContractList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/personContractList");
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
	public void datagrid(PersonContractEntity personContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PersonContractEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, personContract, request.getParameterMap());
		String personId = request.getParameter("personId");
		cq.add(Restrictions.eq("personId", personId));
		this.personContractService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除个人合同信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PersonContractEntity personContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		personContract = systemService.getEntity(PersonContractEntity.class, personContract.getId());
		message = "个人合同信息删除成功";
		personContractService.delete(personContract);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加个人合同信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PersonContractEntity personContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(personContract.getId())) {
			message = "个人合同信息更新成功";
			PersonContractEntity t = personContractService.get(PersonContractEntity.class, personContract.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(personContract, t);
				personContractService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "个人合同信息更新失败";
			}
		} else {
			message = "个人合同信息添加成功";
			personContractService.save(personContract);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(personContract);
		j.setMsg(message);
		return j;
	}

	/**
	 * 个人合同信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PersonContractEntity personContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(personContract.getId())) {
			personContract = personContractService.getEntity(PersonContractEntity.class, personContract.getId());
			req.setAttribute("personContract", personContract);
			if(personContract.getPersonContractFiles()!=null && personContract.getPersonContractFiles().size()>0){
				req.setAttribute("personContractFileId", personContract.getPersonContractFiles().get(0).getId());
			}
		}
		return new ModelAndView("com/gfdz/hr/personContract");
	}
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response,PersonContractFilesEntity personContractFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String personContractId = oConvertUtils.getString(request.getParameter("personContractId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			personContractFiles.setId(fileKey);
			personContractFiles = systemService.getEntity(PersonContractFilesEntity.class, fileKey);

		}
		PersonContractEntity personContract = systemService.getEntity(PersonContractEntity.class, personContractId);
		personContractFiles.setPersonContract(personContract);
		UploadFile uploadFile = new UploadFile(request, personContractFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		personContractFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", personContractFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + personContractFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + personContractFiles.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}
	
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile( HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id  = request.getParameter("id");
		CertificateFilesEntity file = personContractService.getEntity(PersonContractFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		personContractService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
}
