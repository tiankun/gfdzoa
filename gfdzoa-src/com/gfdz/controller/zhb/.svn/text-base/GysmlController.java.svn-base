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

import com.gfdz.entity.zhb.GysmlEntity;
import com.gfdz.entity.zhb.YcsqEntity;
import com.gfdz.service.zhb.GysmlServiceI;

/**   
 * @Title: Controller
 * @Description: 供应上名录表
 * @author ant
 * @date 2015-05-28 11:53:19
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/gysmlController")
public class GysmlController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GysmlController.class);

	@Autowired
	private GysmlServiceI gysmlService;
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
	 * 供应上名录表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "gysmlList")
	public ModelAndView gysmlList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/gysmlList");
	}
	/**
	 * 供应商名录表列表 (用于其他页面的弹出页面选择)
	 * 
	 * @return
	 */
	@RequestMapping(params = "gysList")
	public ModelAndView gysList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/gysList");
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
	public void datagrid(GysmlEntity gysml,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(GysmlEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, gysml, request.getParameterMap());
		this.gysmlService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除供应上名录表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(GysmlEntity gysml, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		gysml = systemService.getEntity(GysmlEntity.class, gysml.getId());
		message = "供应上名录表删除成功";
		gysmlService.delete(gysml);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加供应上名录表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(GysmlEntity gysml, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(gysml.getId())) {
			message = "供应上名录表更新成功";
			GysmlEntity t = gysmlService.get(GysmlEntity.class, gysml.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(gysml, t);
				gysmlService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "供应上名录表更新失败";
			}
		} else {
			message = "供应上名录表添加成功";
			gysmlService.save(gysml);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 供应上名录表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(GysmlEntity gysml, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(gysml.getId())) {
			gysml = gysmlService.getEntity(GysmlEntity.class, gysml.getId());
			req.setAttribute("gysmlPage", gysml);
		}
		return new ModelAndView("com/gfdz/zhb/gysml");
	}
	
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(GysmlEntity gysml, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(gysml.getId())) {
			gysml = gysmlService.getEntity(GysmlEntity.class, gysml.getId());
			req.setAttribute("gysmlPage", gysml);
		}
		return new ModelAndView("com/gfdz/zhb/gysml-update");
	}
}
