package com.gfdz.controller.gc;
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

import com.gfdz.entity.gc.JsTransferFilesEntity;
import com.gfdz.service.gc.JsTransferFilesServiceI;

/**   
 * @Title: Controller
 * @Description: 技术交底附件表
 * @author ant
 * @date 2015-06-08 14:18:14
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/jsTransferFilesController")
public class JsTransferFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JsTransferFilesController.class);

	@Autowired
	private JsTransferFilesServiceI jsTransferFilesService;
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
	 * 技术交底附件表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "jsTransferFiles")
	public ModelAndView jsTransferFiles(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/jsTransferFilesList");
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
	public void datagrid(JsTransferFilesEntity jsTransferFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(JsTransferFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jsTransferFiles, request.getParameterMap());
		this.jsTransferFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除技术交底附件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(JsTransferFilesEntity jsTransferFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		jsTransferFiles = systemService.getEntity(JsTransferFilesEntity.class, jsTransferFiles.getId());
		message = "技术交底附件表删除成功";
		jsTransferFilesService.delete(jsTransferFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加技术交底附件表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(JsTransferFilesEntity jsTransferFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(jsTransferFiles.getId())) {
			message = "技术交底附件表更新成功";
			JsTransferFilesEntity t = jsTransferFilesService.get(JsTransferFilesEntity.class, jsTransferFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(jsTransferFiles, t);
				jsTransferFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "技术交底附件表更新失败";
			}
		} else {
			message = "技术交底附件表添加成功";
			jsTransferFilesService.save(jsTransferFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 技术交底附件表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(JsTransferFilesEntity jsTransferFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jsTransferFiles.getId())) {
			jsTransferFiles = jsTransferFilesService.getEntity(JsTransferFilesEntity.class, jsTransferFiles.getId());
			req.setAttribute("jsTransferFilesPage", jsTransferFiles);
		}
		return new ModelAndView("com/gfdz/gc/jsTransferFiles");
	}
}
