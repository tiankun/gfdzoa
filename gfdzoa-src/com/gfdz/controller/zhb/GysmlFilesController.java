package com.gfdz.controller.zhb;
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

import com.gfdz.entity.zhb.GysmlFilesEntity;
import com.gfdz.service.zhb.GysmlFilesServiceI;

/**   
 * @Title: Controller
 * @Description: 供应上名录附件表
 * @author ant
 * @date 2015-05-28 11:54:31
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/gysmlFilesController")
public class GysmlFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GysmlFilesController.class);

	@Autowired
	private GysmlFilesServiceI gysmlFilesService;
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
	 * 供应上名录附件表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "gysmlFiles")
	public ModelAndView gysmlFiles(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/gysmlFilesList");
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
	public void datagrid(GysmlFilesEntity gysmlFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(GysmlFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, gysmlFiles, request.getParameterMap());
		this.gysmlFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除供应上名录附件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(GysmlFilesEntity gysmlFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		gysmlFiles = systemService.getEntity(GysmlFilesEntity.class, gysmlFiles.getId());
		message = "供应上名录附件表删除成功";
		gysmlFilesService.delete(gysmlFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加供应上名录附件表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(GysmlFilesEntity gysmlFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(gysmlFiles.getId())) {
			message = "供应上名录附件表更新成功";
			GysmlFilesEntity t = gysmlFilesService.get(GysmlFilesEntity.class, gysmlFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(gysmlFiles, t);
				gysmlFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "供应上名录附件表更新失败";
			}
		} else {
			message = "供应上名录附件表添加成功";
			gysmlFilesService.save(gysmlFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 供应上名录附件表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(GysmlFilesEntity gysmlFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(gysmlFiles.getId())) {
			gysmlFiles = gysmlFilesService.getEntity(GysmlFilesEntity.class, gysmlFiles.getId());
			req.setAttribute("gysmlFilesPage", gysmlFiles);
		}
		return new ModelAndView("com/gfdz/zhb/gysmlFiles");
	}
}
