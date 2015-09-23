package com.gfdz.controller.hr;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.gfdz.entity.hr.NoticeFilesEntity;
import com.gfdz.service.hr.NoticeFilesServiceI;

/**   
 * @Title: Controller
 * @Description: 公告管理附件表
 * @author ant
 * @date 2015-06-01 15:27:48
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/noticeFilesController")
public class NoticeFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(NoticeFilesController.class);

	@Autowired
	private NoticeFilesServiceI noticeFilesService;
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
	 * 公告管理附件表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "noticeFiles")
	public ModelAndView noticeFiles(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/noticeFilesList");
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
	public void datagrid(NoticeFilesEntity noticeFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(NoticeFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, noticeFiles, request.getParameterMap());
		this.noticeFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除公告管理附件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(NoticeFilesEntity noticeFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		noticeFiles = systemService.getEntity(NoticeFilesEntity.class, noticeFiles.getId());
		message = "公告管理附件表删除成功";
		noticeFilesService.delete(noticeFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加公告管理附件表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(NoticeFilesEntity noticeFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(noticeFiles.getId())) {
			message = "公告管理附件表更新成功";
			NoticeFilesEntity t = noticeFilesService.get(NoticeFilesEntity.class, noticeFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(noticeFiles, t);
				noticeFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "公告管理附件表更新失败";
			}
		} else {
			message = "公告管理附件表添加成功";
			noticeFilesService.save(noticeFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 公告管理附件表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(NoticeFilesEntity noticeFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(noticeFiles.getId())) {
			noticeFiles = noticeFilesService.getEntity(NoticeFilesEntity.class, noticeFiles.getId());
			req.setAttribute("noticeFilesPage", noticeFiles);
		}
		return new ModelAndView("com/gfdz/hr/noticeFiles");
	}
}
