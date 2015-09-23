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

import com.gfdz.entity.zhb.ZzxxEntity;
import com.gfdz.service.zhb.ZzxxServiceI;

/**   
 * @Title: Controller
 * @Description: 证章信息
 * @author ant
 * @date 2015-05-29 14:22:44
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/zzxxController")
public class ZzxxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZzxxController.class);

	@Autowired
	private ZzxxServiceI zzxxService;
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
	 * 证章信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zzxxList")
	public ModelAndView zzxxList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/zzxxList");
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
	public void datagrid(ZzxxEntity zzxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZzxxEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zzxx, request.getParameterMap());
		this.zzxxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除证章信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ZzxxEntity zzxx, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zzxx = systemService.getEntity(ZzxxEntity.class, zzxx.getId());
		message = "证章信息删除成功";
		zzxxService.delete(zzxx);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加证章信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ZzxxEntity zzxx, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(zzxx.getId())) {
			message = "证章信息更新成功";
			ZzxxEntity t = zzxxService.get(ZzxxEntity.class, zzxx.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(zzxx, t);
				zzxxService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "证章信息更新失败";
			}
		} else {
			message = "证章信息添加成功";
			zzxxService.save(zzxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 证章信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ZzxxEntity zzxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zzxx.getId())) {
			zzxx = zzxxService.getEntity(ZzxxEntity.class, zzxx.getId());
			req.setAttribute("zzxxPage", zzxx);
		}
		return new ModelAndView("com/gfdz/zhb/zzxx");
	}
}
