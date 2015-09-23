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

import com.gfdz.entity.gc.JsTransferEntity;
import com.gfdz.entity.gc.JsTransferFilesEntity;
import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.xsb.TransferEntity;
import com.gfdz.service.gc.JsTransferServiceI;

/**   
 * @Title: Controller
 * @Description: 技术移交记录表
 * @author ant
 * @date 2015-05-28 14:46:04
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/jsTransferController")
public class JsTransferController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JsTransferController.class);

	@Autowired
	private JsTransferServiceI jsTransferService;
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
	 * 技术移交记录表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "jsTransferList")
	public ModelAndView jsTransferList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/jsTransferList");
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
	public void datagrid(JsTransferEntity jsTransfer,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(JsTransferEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jsTransfer, request.getParameterMap());
		this.jsTransferService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除技术移交记录表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(JsTransferEntity jsTransfer, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		jsTransfer = systemService.getEntity(JsTransferEntity.class, jsTransfer.getId());
		message = "技术移交记录表删除成功";
		jsTransferService.delete(jsTransfer);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加技术移交记录表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(JsTransferEntity jsTransfer, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(jsTransfer.getId())) {
			message = "技术移交记录表更新成功";
			JsTransferEntity t = jsTransferService.get(JsTransferEntity.class, jsTransfer.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(jsTransfer, t);
				jsTransferService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "技术移交记录表更新失败";
			}
		} else {
			message = "技术移交记录表添加成功";
			jsTransferService.save(jsTransfer);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(jsTransfer);
		j.setMsg(message);
		return j;
	}

	/**
	 * 技术移交记录表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(JsTransferEntity jsTransfer, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jsTransfer.getId())) {
			jsTransfer = jsTransferService.getEntity(JsTransferEntity.class, jsTransfer.getId());
			req.setAttribute("jsTransfer", jsTransfer);
			if(jsTransfer.getJsTransferFiles()!=null &&jsTransfer.getJsTransferFiles().size()>0 ){
				req.setAttribute("jsTransferFileId",jsTransfer.getJsTransferFiles().get(0).getId());
				if("detail".equals(req.getParameter("load"))){
					return new ModelAndView("com/gfdz/gc/jsTransferDetail");
				}
			}
		}
		return new ModelAndView("com/gfdz/gc/jsTransfer");
	}
	
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, JsTransferFilesEntity jsTransferFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String jsTransferId = oConvertUtils.getString(request.getParameter("jsTransferId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			jsTransferFiles.setId(fileKey);
			jsTransferFiles = systemService.getEntity(JsTransferFilesEntity.class, fileKey);

		}
		JsTransferEntity jsTransfer = systemService.getEntity(JsTransferEntity.class, jsTransferId);
		ProjectInfoEntity projectInfo = jsTransfer.getProject();
		jsTransferFiles.setJsTransfer(jsTransfer);
		jsTransferFiles.setProject(projectInfo);
		UploadFile uploadFile = new UploadFile(request, jsTransferFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		jsTransferFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", jsTransferFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + jsTransferFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + jsTransferFiles.getId());
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
		JsTransferFilesEntity file = jsTransferService.getEntity(JsTransferFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		jsTransferService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
}
