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

import com.gfdz.entity.zhb.GyscpEntity;
import com.gfdz.service.zhb.GyscpServiceI;

/**   
 * @Title: Controller
 * @Description: 供应商产品表
 * @author ant
 * @date 2015-05-28 11:57:44
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/gyscpController")
public class GyscpController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GyscpController.class);

	@Autowired
	private GyscpServiceI gyscpService;
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
	 * 供应商产品表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "gyscp")
	public ModelAndView gyscp(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/gyscpList");
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
	public void datagrid(GyscpEntity gyscp,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(GyscpEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, gyscp, request.getParameterMap());
		this.gyscpService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除供应商产品表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(GyscpEntity gyscp, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		gyscp = systemService.getEntity(GyscpEntity.class, gyscp.getId());
		message = "供应商产品表删除成功";
		gyscpService.delete(gyscp);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加供应商产品表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(GyscpEntity gyscp, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(gyscp.getId())) {
			message = "供应商产品表更新成功";
			GyscpEntity t = gyscpService.get(GyscpEntity.class, gyscp.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(gyscp, t);
				gyscpService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "供应商产品表更新失败";
			}
		} else {
			message = "供应商产品表添加成功";
			gyscpService.save(gyscp);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 供应商产品表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(GyscpEntity gyscp, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(gyscp.getId())) {
			gyscp = gyscpService.getEntity(GyscpEntity.class, gyscp.getId());
			req.setAttribute("gyscpPage", gyscp);
		}
		return new ModelAndView("com/gfdz/zhb/gyscp");
	}
}
