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

import com.gfdz.entity.hr.NoticeEntity;
import com.gfdz.entity.hr.NoticeFilesEntity;
import com.gfdz.service.hr.NoticeServiceI;

/**   
 * @Title: Controller
 * @Description: 通知公告
 * @author ant
 * @date 2015-06-01 14:06:56
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/noticeController")
public class NoticeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(NoticeController.class);

	@Autowired
	private NoticeServiceI noticeService;
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
	 * 通知公告列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "noticeList")
	public ModelAndView noticeList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/noticeList");
	}
	
	@RequestMapping(params = "myNoticeList")
	public ModelAndView myNoticeList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/myNoticeList");
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
	public void datagrid(NoticeEntity notice,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(NoticeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, notice, request.getParameterMap());
		this.noticeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通知公告
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(NoticeEntity notice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		notice = systemService.getEntity(NoticeEntity.class, notice.getId());
		message = "通知公告删除成功";
		noticeService.delete(notice);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加通知公告
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(NoticeEntity notice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(notice.getId())) {
			message = "通知公告更新成功";
			NoticeEntity t = noticeService.get(NoticeEntity.class, notice.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(notice, t);
				noticeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "通知公告更新失败";
			}
		} else {
			message = "通知公告添加成功";
			noticeService.save(notice);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(notice);
		j.setMsg(message);
		return j;
	}

	/**
	 * 通知公告列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(NoticeEntity notice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(notice.getId())) {
			notice = noticeService.getEntity(NoticeEntity.class, notice.getId());
			req.setAttribute("noticePage", notice);
			if(notice.getNoticeFiles()!=null && notice.getNoticeFiles().size()>0){
				req.setAttribute("noticeFileId", notice.getNoticeFiles().get(0).getId());
			}
		}
		return new ModelAndView("com/gfdz/hr/notice");
	}
	
	/**
	 * 
	  * @Title: saveFiles
	  * @Description: 保存通知公告附件
	  * @param request
	  * @param response
	  * @param noticeFiles
	  * @return AjaxJson
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月2日 下午4:43:06
	 */
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, NoticeFilesEntity noticeFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String noticeId = oConvertUtils.getString(request.getParameter("noticeId"));//公告ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			noticeFiles.setId(fileKey);
			noticeFiles = systemService.getEntity(NoticeFilesEntity.class, fileKey);

		}
		NoticeEntity notice = systemService.getEntity(NoticeEntity.class, noticeId);
		noticeFiles.setNotice(notice);
		UploadFile uploadFile = new UploadFile(request, noticeFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		noticeFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", noticeFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + noticeFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + noticeFiles.getId());
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
		NoticeFilesEntity file = noticeService.getEntity(NoticeFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		noticeService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
}
