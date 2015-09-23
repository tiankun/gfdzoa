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

import com.gfdz.entity.gc.PurchaseExecuteEntity;
import com.gfdz.service.gc.PurchaseExecuteServiceI;

/**   
 * @Title: Controller
 * @Description: 项目材料采购执行
 * @author ant
 * @date 2015-05-28 14:00:44
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/purchaseExecuteController")
public class PurchaseExecuteController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PurchaseExecuteController.class);

	@Autowired
	private PurchaseExecuteServiceI purchaseExecuteService;
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
	 * 项目材料采购执行列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "purchaseExecute")
	public ModelAndView purchaseExecute(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/purchaseExecuteList");
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
	public void datagrid(PurchaseExecuteEntity purchaseExecute,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PurchaseExecuteEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, purchaseExecute, request.getParameterMap());
		this.purchaseExecuteService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目材料采购执行
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PurchaseExecuteEntity purchaseExecute, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		purchaseExecute = systemService.getEntity(PurchaseExecuteEntity.class, purchaseExecute.getId());
		message = "项目材料采购执行删除成功";
		purchaseExecuteService.delete(purchaseExecute);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目材料采购执行
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PurchaseExecuteEntity purchaseExecute, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(purchaseExecute.getId())) {
			message = "项目材料采购执行更新成功";
			PurchaseExecuteEntity t = purchaseExecuteService.get(PurchaseExecuteEntity.class, purchaseExecute.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(purchaseExecute, t);
				purchaseExecuteService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "项目材料采购执行更新失败";
			}
		} else {
			message = "项目材料采购执行添加成功";
			purchaseExecuteService.save(purchaseExecute);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目材料采购执行列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PurchaseExecuteEntity purchaseExecute, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(purchaseExecute.getId())) {
			purchaseExecute = purchaseExecuteService.getEntity(PurchaseExecuteEntity.class, purchaseExecute.getId());
			req.setAttribute("purchaseExecutePage", purchaseExecute);
		}
		return new ModelAndView("com/gfdz/gc/purchaseExecute");
	}
}
