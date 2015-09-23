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

import com.gfdz.entity.gc.PurchasePlanDetailEntity;
import com.gfdz.service.gc.PurchasePlanDetailServiceI;

/**   
 * @Title: Controller
 * @Description: 项目材料采购计划 
 * @author ant
 * @date 2015-05-28 13:57:45
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/purchasePlanDetailController")
public class PurchasePlanDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PurchasePlanDetailController.class);

	@Autowired
	private PurchasePlanDetailServiceI purchasePlanDetailService;
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
	 * 项目材料采购计划 列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "purchasePlanDetail")
	public ModelAndView purchasePlanDetail(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/purchasePlanDetailList");
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
	public void datagrid(PurchasePlanDetailEntity purchasePlanDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PurchasePlanDetailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, purchasePlanDetail, request.getParameterMap());
		this.purchasePlanDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目材料采购计划 
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PurchasePlanDetailEntity purchasePlanDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		purchasePlanDetail = systemService.getEntity(PurchasePlanDetailEntity.class, purchasePlanDetail.getId());
		message = "项目材料采购计划 删除成功";
		purchasePlanDetailService.delete(purchasePlanDetail);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目材料采购计划 
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PurchasePlanDetailEntity purchasePlanDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(purchasePlanDetail.getId())) {
			message = "项目材料采购计划 更新成功";
			PurchasePlanDetailEntity t = purchasePlanDetailService.get(PurchasePlanDetailEntity.class, purchasePlanDetail.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(purchasePlanDetail, t);
				purchasePlanDetailService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "项目材料采购计划 更新失败";
			}
		} else {
			message = "项目材料采购计划 添加成功";
			purchasePlanDetailService.save(purchasePlanDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目材料采购计划 列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PurchasePlanDetailEntity purchasePlanDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(purchasePlanDetail.getId())) {
			purchasePlanDetail = purchasePlanDetailService.getEntity(PurchasePlanDetailEntity.class, purchasePlanDetail.getId());
			req.setAttribute("purchasePlanDetailPage", purchasePlanDetail);
		}
		return new ModelAndView("com/gfdz/gc/purchasePlanDetail");
	}
}
