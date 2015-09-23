package com.gfdz.controller.hr;
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

import com.gfdz.entity.hr.TravelPathEntity;
import com.gfdz.service.hr.TravelPathServiceI;

/**   
 * @Title: Controller
 * @Description: 出差路径
 * @author ant
 * @date 2015-05-28 11:20:26
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/travelPathController")
public class TravelPathController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TravelPathController.class);

	@Autowired
	private TravelPathServiceI travelPathService;
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
	 * 出差路径列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "travelPath")
	public ModelAndView travelPath(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/travelPathList");
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
	public void datagrid(TravelPathEntity travelPath,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TravelPathEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, travelPath, request.getParameterMap());
		this.travelPathService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除出差路径
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TravelPathEntity travelPath, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		travelPath = systemService.getEntity(TravelPathEntity.class, travelPath.getId());
		message = "出差路径删除成功";
		travelPathService.delete(travelPath);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加出差路径
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TravelPathEntity travelPath, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(travelPath.getId())) {
			message = "出差路径更新成功";
			TravelPathEntity t = travelPathService.get(TravelPathEntity.class, travelPath.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(travelPath, t);
				travelPathService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "出差路径更新失败";
			}
		} else {
			message = "出差路径添加成功";
			travelPathService.save(travelPath);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 出差路径列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TravelPathEntity travelPath, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(travelPath.getId())) {
			travelPath = travelPathService.getEntity(TravelPathEntity.class, travelPath.getId());
			req.setAttribute("travelPathPage", travelPath);
		}
		return new ModelAndView("com/gfdz/hr/travelPath");
	}
}
