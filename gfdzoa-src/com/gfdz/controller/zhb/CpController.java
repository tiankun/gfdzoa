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

import com.gfdz.entity.zhb.CpEntity;
import com.gfdz.service.zhb.CpServiceI;

/**   
 * @Title: Controller
 * @Description: 产品表
 * @author ant
 * @date 2015-05-28 11:56:34
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/cpController")
public class CpController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CpController.class);

	@Autowired
	private CpServiceI cpService;
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
	 * 产品表列表 弹出框
	 * 
	 * @return
	 */
	@RequestMapping(params = "getcpList")
	public ModelAndView getcpList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/getcpList");
	}
	/**
	 * 产品表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "cpList")
	public ModelAndView cpList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/cpList");
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
	public void datagrid(CpEntity cp,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CpEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, cp, request.getParameterMap());
		this.cpService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除产品表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(CpEntity cp, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		cp = systemService.getEntity(CpEntity.class, cp.getId());
		message = "产品表删除成功";
		cpService.delete(cp);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加产品表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(CpEntity cp, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(cp.getId())) {
			message = "产品表更新成功";
			CpEntity t = cpService.get(CpEntity.class, cp.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(cp, t);
				cpService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "产品表更新失败";
			}
		} else {
			message = "产品表添加成功";
			cpService.save(cp);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 产品表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(CpEntity cp, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(cp.getId())) {
			cp = cpService.getEntity(CpEntity.class, cp.getId());
			req.setAttribute("cpPage", cp);
		}
		return new ModelAndView("com/gfdz/zhb/cp");
	}
}
