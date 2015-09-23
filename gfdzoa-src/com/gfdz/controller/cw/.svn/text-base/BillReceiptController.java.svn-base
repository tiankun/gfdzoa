package com.gfdz.controller.cw;
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

import com.gfdz.entity.cw.BillReceiptEntity;
import com.gfdz.service.cw.BillReceiptServiceI;

/**   
 * @Title: Controller
 * @Description: 发票收款记录
 * @author ant
 * @date 2015-05-28 13:51:51
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/billReceiptController")
public class BillReceiptController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BillReceiptController.class);

	@Autowired
	private BillReceiptServiceI billReceiptService;
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
	 * 发票收款记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "billReceipt")
	public ModelAndView billReceipt(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/billReceiptList");
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
	public void datagrid(BillReceiptEntity billReceipt,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BillReceiptEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, billReceipt, request.getParameterMap());
		this.billReceiptService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除发票收款记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(BillReceiptEntity billReceipt, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		billReceipt = systemService.getEntity(BillReceiptEntity.class, billReceipt.getId());
		message = "发票收款记录删除成功";
		billReceiptService.delete(billReceipt);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加发票收款记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(BillReceiptEntity billReceipt, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(billReceipt.getId())) {
			message = "发票收款记录更新成功";
			BillReceiptEntity t = billReceiptService.get(BillReceiptEntity.class, billReceipt.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(billReceipt, t);
				billReceiptService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "发票收款记录更新失败";
			}
		} else {
			message = "发票收款记录添加成功";
			billReceiptService.save(billReceipt);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 发票收款记录列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(BillReceiptEntity billReceipt, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(billReceipt.getId())) {
			billReceipt = billReceiptService.getEntity(BillReceiptEntity.class, billReceipt.getId());
			req.setAttribute("billReceiptPage", billReceipt);
		}
		return new ModelAndView("com/gfdz/cw/billReceipt");
	}
}
