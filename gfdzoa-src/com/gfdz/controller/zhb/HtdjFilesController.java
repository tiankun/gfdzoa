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

import com.gfdz.entity.zhb.HtdjFilesEntity;
import com.gfdz.service.zhb.HtdjFilesServiceI;

/**   
 * @Title: Controller
 * @Description: 合同登记附件
 * @author ant
 * @date 2015-05-29 14:26:21
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/htdjFilesController")
public class HtdjFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HtdjFilesController.class);

	@Autowired
	private HtdjFilesServiceI htdjFilesService;
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
	 * 合同登记附件列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "htdjFiles")
	public ModelAndView htdjFiles(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/htdjFilesList");
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
	public void datagrid(HtdjFilesEntity htdjFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HtdjFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, htdjFiles, request.getParameterMap());
		this.htdjFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除合同登记附件
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HtdjFilesEntity htdjFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		htdjFiles = systemService.getEntity(HtdjFilesEntity.class, htdjFiles.getId());
		message = "合同登记附件删除成功";
		htdjFilesService.delete(htdjFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加合同登记附件
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HtdjFilesEntity htdjFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(htdjFiles.getId())) {
			message = "合同登记附件更新成功";
			HtdjFilesEntity t = htdjFilesService.get(HtdjFilesEntity.class, htdjFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(htdjFiles, t);
				htdjFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "合同登记附件更新失败";
			}
		} else {
			message = "合同登记附件添加成功";
			htdjFilesService.save(htdjFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 合同登记附件列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HtdjFilesEntity htdjFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(htdjFiles.getId())) {
			htdjFiles = htdjFilesService.getEntity(HtdjFilesEntity.class, htdjFiles.getId());
			req.setAttribute("htdjFilesPage", htdjFiles);
		}
		return new ModelAndView("com/gfdz/zhb/htdjFiles");
	}
}
