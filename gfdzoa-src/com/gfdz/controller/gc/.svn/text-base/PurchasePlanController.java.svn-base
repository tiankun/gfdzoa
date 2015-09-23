package com.gfdz.controller.gc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.gc.MaterialBaseEntity;
import com.gfdz.entity.gc.PurchasePlanEntity;
import com.gfdz.service.gc.PurchasePlanServiceI;

/**
 * @Title: Controller
 * @Description: 项目材料采购计划
 * @author ant
 * @date 2015-05-28 13:55:08
 * @version V1.0
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/purchasePlanController")
public class PurchasePlanController extends BaseController {
	@Autowired
	private PurchasePlanServiceI purchasePlanService;
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
	@RequestMapping(params = "purchasePlanList")
	public ModelAndView purchasePlanList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/purchasePlanList");
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
	public void datagrid(PurchasePlanEntity purchasePlan, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PurchasePlanEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, purchasePlan, request.getParameterMap());
		this.purchasePlanService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目材料采购计划
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PurchasePlanEntity purchasePlan, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		purchasePlan = systemService.getEntity(PurchasePlanEntity.class, purchasePlan.getId());
		message = "项目材料采购计划 删除成功";
		purchasePlanService.delete(purchasePlan);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}

	/**
	 * 采购申请页面跳转
	 * 
	 * @author WU
	 * @date 2015-7-29 上午11:57:25
	 * @param purchasePlan
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PurchasePlanEntity purchasePlan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(purchasePlan.getId())) {
			purchasePlan = purchasePlanService.getEntity(PurchasePlanEntity.class, purchasePlan.getId());
			req.setAttribute("page", purchasePlan);
		}
		req.setAttribute("userName", ResourceUtil.getSessionUserName().getRealName());
		return new ModelAndView("com/gfdz/gc/purchasePlan");
	}

	/**
	 * 采购申请
	 * 
	 * @author WU
	 * @date 2015-7-29 上午11:56:08
	 * @param purchasePlan
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PurchasePlanEntity plan, String[] mId, Integer[] num, Double[] price, String[] note, Date[] otd) {
		AjaxJson j = new AjaxJson();
		try {
			purchasePlanService.purchasePlanSave(plan, mId, num, price, note, otd);
		} catch (Exception e) {
			if (e.getMessage() != null) {
				j.setSuccess(false);
				j.setMsg(e.getMessage());
			} else {
				j.setSuccess(false);
				j.setMsg("操作异常！");
			}
			e.printStackTrace();
		}
		return j;
	}

	/**
	 * 采购申请
	 * 
	 * @author WU
	 * @date 2015-7-29 上午11:56:08
	 * @param purchasePlan
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "update")
	@ResponseBody
	public AjaxJson update(PurchasePlanEntity plan, String[] mId, Integer[] num, Double[] price, String[] note, Date[] otd) {
		AjaxJson j = new AjaxJson();
		try {
			purchasePlanService.updatePurchasePlan(plan, mId, num, price, note, otd);
		} catch (Exception e) {
			if (e.getMessage() != null) {
				j.setSuccess(false);
				j.setMsg(e.getMessage());
			} else {
				j.setSuccess(false);
				j.setMsg("操作异常！");
			}
			e.printStackTrace();
		}
		return j;
	}

	/**
	 * 采购申请选择项目材料页面
	 * 
	 * @author WU
	 * @date 2015-7-29 上午11:58:45
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "selectMaterial")
	public ModelAndView selectMaterial(HttpServletRequest req) {
		return new ModelAndView("com/gfdz/gc/selectMaterial");
	}

	/**
	 * 项目材料明细
	 * 
	 * @author WU
	 * @date 2015-7-29 下午2:18:27
	 * @param mater
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "materialGrid")
	public void materialGrid(MaterialBaseEntity mater, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaterialBaseEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, mater, request.getParameterMap());
		this.purchasePlanService.getDataGridReturn(cq, true);
		dataGrid.setField("id,cp.id,cp.cpmc,cp.brand,cp.standard,parameter,unit,designAmount,designPrice");
		TagUtil.datagrid(response, dataGrid);
	}

}
