package com.gfdz.controller.xsb;
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
import com.gfdz.entity.gc.TransferFilesEntity;
import com.gfdz.entity.hr.NoticeFilesEntity;
import com.gfdz.entity.xsb.TransferEntity;
import com.gfdz.service.xsb.TransferServiceI;

/**   
 * @Title: Controller
 * @Description: 销售移交记录表
 * @author ant
 * @date 2015-05-28 14:44:37
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/transferController")
public class TransferController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TransferController.class);

	@Autowired
	private TransferServiceI transferService;
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
	 * 销售移交记录表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "transferList")
	public ModelAndView transferList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/xsb/transferList");
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
	public void datagrid(TransferEntity transfer,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TransferEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, transfer, request.getParameterMap());
		this.transferService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除销售移交记录表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TransferEntity transfer, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		transfer = systemService.getEntity(TransferEntity.class, transfer.getId());
		message = "销售移交记录表删除成功";
		transferService.delete(transfer);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加销售移交记录表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TransferEntity transfer, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			if (StringUtil.isNotEmpty(transfer.getId())) {
				message = "销售移交记录表更新成功";
				TransferEntity t = transferService.get(TransferEntity.class, transfer.getId());
					MyBeanUtils.copyBeanNotNull2Bean(transfer, t);
					transferService.saveTransfer(t);
					systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
				
				} else {
					message = "销售移交记录表添加成功";
					transferService.saveTransfer(transfer);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			} catch (Exception e) {
				e.printStackTrace();
				message = "销售移交记录表更新失败";
		}
		j.setObj(transfer);
		j.setMsg(message);
		return j;
	}

	/**
	 * 销售移交记录表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TransferEntity transfer, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(transfer.getId())) {
			transfer = transferService.getEntity(TransferEntity.class, transfer.getId());
			req.setAttribute("transfer", transfer);
				if(transfer.getTransferFiles()!=null &&transfer.getTransferFiles().size()>0 ){
					req.setAttribute("transferFileId",transfer.getTransferFiles().get(0).getId());
				if("detail".equals(req.getParameter("load"))){
					return new ModelAndView("com/gfdz/xsb/transferDetail");
				}
			}
		}
		return new ModelAndView("com/gfdz/xsb/transfer");
	}
	
	
	/**
	 * 
	  * @Title: saveFiles
	  * @Description: 保存附件
	  * @param request
	  * @param response
	  * @param noticeFiles
	  * @return AjaxJson
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月8日 下午2:00:05
	 */
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TransferFilesEntity transferFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String transferId = oConvertUtils.getString(request.getParameter("transferId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			transferFiles.setId(fileKey);
			transferFiles = systemService.getEntity(TransferFilesEntity.class, fileKey);

		}
		TransferEntity transfer = systemService.getEntity(TransferEntity.class, transferId);
		ProjectInfoEntity projectInfo = transfer.getProject();
		transferFiles.setTransfer(transfer);
		transferFiles.setProject(projectInfo);
		UploadFile uploadFile = new UploadFile(request, transferFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		transferFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", transferFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + transferFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + transferFiles.getId());
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
		NoticeFilesEntity file = transferService.getEntity(NoticeFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		transferService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
	
	
	
	@RequestMapping(params = "selectProject")
	public ModelAndView selectProject(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/selectProject");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "projectData")
	public void projectData(ProjectInfoEntity project,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProjectInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, project, request.getParameterMap());
		this.transferService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
}
