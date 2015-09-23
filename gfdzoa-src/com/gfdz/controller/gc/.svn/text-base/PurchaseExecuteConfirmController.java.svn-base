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

import com.gfdz.entity.gc.PurchaseExecuteConfirmEntity;
import com.gfdz.service.gc.PurchaseExecuteConfirmServiceI;

/**   
 * @Title: Controller
 * @Description: 项目材料采购到货记录
 * @author ant
 * @date 2015-05-28 14:03:27
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/purchaseExecuteConfirmController")
public class PurchaseExecuteConfirmController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PurchaseExecuteConfirmController.class);

	@Autowired
	private PurchaseExecuteConfirmServiceI purchaseExecuteConfirmService;
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
	 * 项目材料采购到货记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "purchaseExecuteConfirm")
	public ModelAndView purchaseExecuteConfirm(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/purchaseExecuteConfirmList");
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
	public void datagrid(PurchaseExecuteConfirmEntity purchaseExecuteConfirm,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PurchaseExecuteConfirmEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, purchaseExecuteConfirm, request.getParameterMap());
		this.purchaseExecuteConfirmService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目材料采购到货记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PurchaseExecuteConfirmEntity purchaseExecuteConfirm, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		purchaseExecuteConfirm = systemService.getEntity(PurchaseExecuteConfirmEntity.class, purchaseExecuteConfirm.getId());
		message = "项目材料采购到货记录删除成功";
		purchaseExecuteConfirmService.delete(purchaseExecuteConfirm);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目材料采购到货记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PurchaseExecuteConfirmEntity purchaseExecuteConfirm, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(purchaseExecuteConfirm.getId())) {
			message = "项目材料采购到货记录更新成功";
			PurchaseExecuteConfirmEntity t = purchaseExecuteConfirmService.get(PurchaseExecuteConfirmEntity.class, purchaseExecuteConfirm.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(purchaseExecuteConfirm, t);
				purchaseExecuteConfirmService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "项目材料采购到货记录更新失败";
			}
		} else {
			message = "项目材料采购到货记录添加成功";
			purchaseExecuteConfirmService.save(purchaseExecuteConfirm);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目材料采购到货记录列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PurchaseExecuteConfirmEntity purchaseExecuteConfirm, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(purchaseExecuteConfirm.getId())) {
			purchaseExecuteConfirm = purchaseExecuteConfirmService.getEntity(PurchaseExecuteConfirmEntity.class, purchaseExecuteConfirm.getId());
			req.setAttribute("purchaseExecuteConfirmPage", purchaseExecuteConfirm);
		}
		return new ModelAndView("com/gfdz/gc/purchaseExecuteConfirm");
	}
}
