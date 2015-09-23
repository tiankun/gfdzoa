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

import com.gfdz.entity.gc.TransferFilesEntity;
import com.gfdz.service.gc.TransferFilesServiceI;

/**   
 * @Title: Controller
 * @Description: 销售交底附件表
 * @author ant
 * @date 2015-06-08 14:16:39
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/transferFilesController")
public class TransferFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TransferFilesController.class);

	@Autowired
	private TransferFilesServiceI transferFilesService;
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
	 * 销售交底附件表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "transferFiles")
	public ModelAndView transferFiles(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/transferFilesList");
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
	public void datagrid(TransferFilesEntity transferFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TransferFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, transferFiles, request.getParameterMap());
		this.transferFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除销售交底附件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TransferFilesEntity transferFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		transferFiles = systemService.getEntity(TransferFilesEntity.class, transferFiles.getId());
		message = "销售交底附件表删除成功";
		transferFilesService.delete(transferFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加销售交底附件表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TransferFilesEntity transferFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(transferFiles.getId())) {
			message = "销售交底附件表更新成功";
			TransferFilesEntity t = transferFilesService.get(TransferFilesEntity.class, transferFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(transferFiles, t);
				transferFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "销售交底附件表更新失败";
			}
		} else {
			message = "销售交底附件表添加成功";
			transferFilesService.save(transferFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 销售交底附件表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TransferFilesEntity transferFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(transferFiles.getId())) {
			transferFiles = transferFilesService.getEntity(TransferFilesEntity.class, transferFiles.getId());
			req.setAttribute("transferFilesPage", transferFiles);
		}
		return new ModelAndView("com/gfdz/gc/transferFiles");
	}
}
