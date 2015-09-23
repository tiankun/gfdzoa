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

import com.gfdz.entity.hr.PersonContractEntity;
import com.gfdz.entity.hr.PersonContractFilesEntity;
import com.gfdz.service.hr.PersonContractFilesService;

/**   
 * @Title: Controller
 * @Description: 合同信息附件
 * @author ant
 * @date 2015-07-01 17:05:31
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/personContractFilesController")
public class PersonContractFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PersonContractFilesController.class);

	@Autowired
	private PersonContractFilesService personContractFilesService;
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
	 * 合同信息附件列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "personContractFilesList")
	public ModelAndView personContractFilesList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/personContractFilesList");
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
	public void datagrid(PersonContractFilesEntity personContractFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PersonContractFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, personContractFiles, request.getParameterMap());
		this.personContractFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除合同信息附件
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PersonContractFilesEntity personContractFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		personContractFiles = systemService.getEntity(PersonContractFilesEntity.class, personContractFiles.getId());
		message = "合同信息附件删除成功";
		personContractFilesService.delete(personContractFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加合同信息附件
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PersonContractFilesEntity personContractFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(personContractFiles.getId())) {
			message = "合同信息附件更新成功";
			PersonContractFilesEntity t = personContractFilesService.get(PersonContractFilesEntity.class, personContractFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(personContractFiles, t);
				personContractFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "合同信息附件更新失败";
			}
		} else {
			message = "合同信息附件添加成功";
			personContractFilesService.save(personContractFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 合同信息附件列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PersonContractFilesEntity personContractFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(personContractFiles.getId())) {
			personContractFiles = personContractFilesService.getEntity(PersonContractFilesEntity.class, personContractFiles.getId());
			req.setAttribute("personContractFiles", personContractFiles);
		}
		return new ModelAndView("com/gfdz/hr/personContractFiles");
	}
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, PersonContractFilesEntity personContractFiles) {
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
		PersonContractFilesEntity file = personContractFilesService.getEntity(PersonContractFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		personContractFilesService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
}
