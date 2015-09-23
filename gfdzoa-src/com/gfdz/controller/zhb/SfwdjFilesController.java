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

import com.gfdz.entity.zhb.SfwdjFilesEntity;
import com.gfdz.service.zhb.SfwdjFilesServiceI;

/**   
 * @Title: Controller
 * @Description: 收发文登记附件表
 * @author ant
 * @date 2015-05-28 11:51:24
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/sfwdjFilesController")
public class SfwdjFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SfwdjFilesController.class);

	@Autowired
	private SfwdjFilesServiceI sfwdjFilesService;
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
	 * 收发文登记附件表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sfwdjFiles")
	public ModelAndView sfwdjFiles(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/sfwdjFilesList");
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
	public void datagrid(SfwdjFilesEntity sfwdjFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SfwdjFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sfwdjFiles, request.getParameterMap());
		this.sfwdjFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除收发文登记附件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SfwdjFilesEntity sfwdjFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		sfwdjFiles = systemService.getEntity(SfwdjFilesEntity.class, sfwdjFiles.getId());
		message = "收发文登记附件表删除成功";
		sfwdjFilesService.delete(sfwdjFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加收发文登记附件表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SfwdjFilesEntity sfwdjFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sfwdjFiles.getId())) {
			message = "收发文登记附件表更新成功";
			SfwdjFilesEntity t = sfwdjFilesService.get(SfwdjFilesEntity.class, sfwdjFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(sfwdjFiles, t);
				sfwdjFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "收发文登记附件表更新失败";
			}
		} else {
			message = "收发文登记附件表添加成功";
			sfwdjFilesService.save(sfwdjFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 收发文登记附件表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SfwdjFilesEntity sfwdjFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sfwdjFiles.getId())) {
			sfwdjFiles = sfwdjFilesService.getEntity(SfwdjFilesEntity.class, sfwdjFiles.getId());
			req.setAttribute("sfwdjFilesPage", sfwdjFiles);
		}
		return new ModelAndView("com/gfdz/zhb/sfwdjFiles");
	}
}
