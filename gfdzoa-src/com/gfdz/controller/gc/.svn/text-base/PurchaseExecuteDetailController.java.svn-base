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

import com.gfdz.entity.gc.PurchaseExecuteDetailEntity;
import com.gfdz.service.gc.PurchaseExecuteDetailServiceI;

/**   
 * @Title: Controller
 * @Description: 项目材料采购执行详细
 * @author ant
 * @date 2015-05-28 14:01:09
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/purchaseExecuteDetailController")
public class PurchaseExecuteDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PurchaseExecuteDetailController.class);

	@Autowired
	private PurchaseExecuteDetailServiceI purchaseExecuteDetailService;
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
	 * 项目材料采购执行详细列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "purchaseExecuteDetail")
	public ModelAndView purchaseExecuteDetail(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/purchaseExecuteDetailList");
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
	public void datagrid(PurchaseExecuteDetailEntity purchaseExecuteDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PurchaseExecuteDetailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, purchaseExecuteDetail, request.getParameterMap());
		this.purchaseExecuteDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目材料采购执行详细
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PurchaseExecuteDetailEntity purchaseExecuteDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		purchaseExecuteDetail = systemService.getEntity(PurchaseExecuteDetailEntity.class, purchaseExecuteDetail.getId());
		message = "项目材料采购执行详细删除成功";
		purchaseExecuteDetailService.delete(purchaseExecuteDetail);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目材料采购执行详细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PurchaseExecuteDetailEntity purchaseExecuteDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(purchaseExecuteDetail.getId())) {
			message = "项目材料采购执行详细更新成功";
			PurchaseExecuteDetailEntity t = purchaseExecuteDetailService.get(PurchaseExecuteDetailEntity.class, purchaseExecuteDetail.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(purchaseExecuteDetail, t);
				purchaseExecuteDetailService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "项目材料采购执行详细更新失败";
			}
		} else {
			message = "项目材料采购执行详细添加成功";
			purchaseExecuteDetailService.save(purchaseExecuteDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目材料采购执行详细列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PurchaseExecuteDetailEntity purchaseExecuteDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(purchaseExecuteDetail.getId())) {
			purchaseExecuteDetail = purchaseExecuteDetailService.getEntity(PurchaseExecuteDetailEntity.class, purchaseExecuteDetail.getId());
			req.setAttribute("purchaseExecuteDetailPage", purchaseExecuteDetail);
		}
		return new ModelAndView("com/gfdz/gc/purchaseExecuteDetail");
	}
}
