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
import com.gfdz.entity.gc.QualityCheckEntity;
import com.gfdz.entity.gc.QualityCheckFilesEntity;
import com.gfdz.service.gc.QualityCheckServiceI;

/**   
 * @Title: Controller
 * @Description: 质量管理
 * @author ant
 * @date 2015-05-28 14:56:08
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/qualityCheckController")
public class QualityCheckController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(QualityCheckController.class);

	@Autowired
	private QualityCheckServiceI qualityCheckService;
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
	 * 质量管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "qualityCheckList")
	public ModelAndView qualityCheckList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/qualityCheckList");
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
	public void datagrid(QualityCheckEntity qualityCheck,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(QualityCheckEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, qualityCheck, request.getParameterMap());
		this.qualityCheckService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除质量管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(QualityCheckEntity qualityCheck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		qualityCheck = systemService.getEntity(QualityCheckEntity.class, qualityCheck.getId());
		message = "质量管理删除成功";
		qualityCheckService.delete(qualityCheck);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加质量管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(QualityCheckEntity qualityCheck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(qualityCheck.getId())) {
			message = "质量管理更新成功";
			QualityCheckEntity t = qualityCheckService.get(QualityCheckEntity.class, qualityCheck.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(qualityCheck, t);
				qualityCheckService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "质量管理更新失败";
			}
		} else {
			message = "质量管理添加成功";
			qualityCheckService.save(qualityCheck);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(qualityCheck);
		j.setMsg(message);
		return j;
	}

	/**
	 * 质量管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(QualityCheckEntity qualityCheck, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(qualityCheck.getId())) {
			qualityCheck = qualityCheckService.getEntity(QualityCheckEntity.class, qualityCheck.getId());
			req.setAttribute("qualityCheck", qualityCheck);
			if(qualityCheck.getQualityCheckFiles()!=null && qualityCheck.getQualityCheckFiles().size()>0){
				req.setAttribute("qualityCheckFileId", qualityCheck.getQualityCheckFiles().get(0).getId());
				if("detail".equals(req.getParameter("load"))){
					return new ModelAndView("com/gfdz/gc/qualityCheckDetail");
				}
			}
		}
		return new ModelAndView("com/gfdz/gc/qualityCheck");
	}
	
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, QualityCheckFilesEntity qualityCheckFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String qualityCheckId = oConvertUtils.getString(request.getParameter("qualityCheckId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			qualityCheckFiles.setId(fileKey);
			qualityCheckFiles = systemService.getEntity(QualityCheckFilesEntity.class, fileKey);

		}
		QualityCheckEntity qualityCheck = systemService.getEntity(QualityCheckEntity.class, qualityCheckId);
		ProjectInfoEntity projectInfo = qualityCheck.getProject();
		qualityCheckFiles.setQualityCheck(qualityCheck);
		qualityCheckFiles.setProject(projectInfo);
		UploadFile uploadFile = new UploadFile(request, qualityCheckFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		qualityCheckFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", qualityCheckFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + qualityCheckFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + qualityCheckFiles.getId());
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
		QualityCheckFilesEntity file = qualityCheckService.getEntity(QualityCheckFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		qualityCheckService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
	
}
