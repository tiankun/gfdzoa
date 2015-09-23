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

import com.gfdz.entity.zhb.ClxxFilesEntity;
import com.gfdz.service.zhb.ClxxFilesServiceI;

/**   
 * @Title: Controller
 * @Description: 车辆附件信息表
 * @author ant
 * @date 2015-05-28 11:39:44
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/clxxFilesController")
public class ClxxFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ClxxFilesController.class);

	@Autowired
	private ClxxFilesServiceI clxxFilesService;
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
	 * 车辆附件信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "clxxFiles")
	public ModelAndView clxxFiles(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/clxxFilesList");
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
	public void datagrid(ClxxFilesEntity clxxFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ClxxFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, clxxFiles, request.getParameterMap());
		this.clxxFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除车辆附件信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ClxxFilesEntity clxxFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		clxxFiles = systemService.getEntity(ClxxFilesEntity.class, clxxFiles.getId());
		message = "车辆附件信息表删除成功";
		clxxFilesService.delete(clxxFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加车辆附件信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ClxxFilesEntity clxxFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(clxxFiles.getId())) {
			message = "车辆附件信息表更新成功";
			ClxxFilesEntity t = clxxFilesService.get(ClxxFilesEntity.class, clxxFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(clxxFiles, t);
				clxxFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "车辆附件信息表更新失败";
			}
		} else {
			message = "车辆附件信息表添加成功";
			clxxFilesService.save(clxxFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 车辆附件信息表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ClxxFilesEntity clxxFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(clxxFiles.getId())) {
			clxxFiles = clxxFilesService.getEntity(ClxxFilesEntity.class, clxxFiles.getId());
			req.setAttribute("clxxFilesPage", clxxFiles);
		}
		return new ModelAndView("com/gfdz/zhb/clxxFiles");
	}
}
