package com.gfdz.controller.cw;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
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

import com.gfdz.entity.cw.PayforEntity;
import com.gfdz.entity.gc.PurchaseEntity;
import com.gfdz.entity.zhb.ZhbCgzxEntity;
import com.gfdz.service.cw.PayforServiceI;

/**
 * @Title: Controller
 * @Description: 款项支付
 * @author onlineGenerator
 * @date 2015-07-24 15:41:39
 * @version V1.0
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/payforController")
public class PayforController extends BaseController {
	@Autowired
	private PayforServiceI payforService;
	@Autowired
	private SystemService systemService;

	/**
	 * 支付管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "payforList")
	public ModelAndView payfor(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/payforList");
	}

	/**
	 * 款项支付列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "payforpayList")
	public ModelAndView payforpay(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/payforpayList");
	}

	/**
	 * easyui AJAX请求数据（支付管理）
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PayforEntity payfor, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PayforEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, payfor, request.getParameterMap());
		payforService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * easyui AJAX请求数据(款项支付)
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagridPay")
	public void datagridPay(ZhbCgzxEntity cgzx, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZhbCgzxEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, cgzx, request.getParameterMap());
		payforService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除支付管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PayforEntity payfor, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		payfor = systemService.getEntity(PayforEntity.class, payfor.getId());
		try {
			payforService.delete(payfor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}

	/**
	 * 支付管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PayforEntity payfor, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(payfor.getId())) {
			payfor = payforService.getEntity(PayforEntity.class, payfor.getId());
			req.setAttribute("payforPage", payfor);
		}
		req.setAttribute("userName", ResourceUtil.getSessionUserName().getRealName());
		return new ModelAndView("com/gfdz/cw/payfor");
	}

	/**
	 * 保存支付管理
	 * 
	 * @param payfor
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PayforEntity payfor, String[] pId, Double[] money, String[] note) {
		AjaxJson j = new AjaxJson();
		try {
			payforService.payforSave(payfor, pId, money, note);
		} catch (Exception e) {
			j.setSuccess(false);
			if (e.getMessage() != null) {
				j.setMsg(e.getMessage());
			} else {
				j.setMsg("操作异常！");
			}
			e.printStackTrace();
		}
		return j;
	}

	/**
	 * 选择供应商和采购执行单
	 * 
	 * @author WU
	 * @date 2015-8-17 下午5:16:50
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "selectGysAndPurchase")
	public ModelAndView selectGysAndPurchase(HttpServletRequest req) {
		return new ModelAndView("com/gfdz/cw/selectGysAndPurchase");
	}

	/**
	 * 获取供应商对应的采购执行单
	 * 
	 * @author WU
	 * @date 2015-8-19 下午3:38:27
	 * @param purchase
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "purchaseGrid")
	public void purchaseGrid(PurchaseEntity purchase, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PurchaseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, purchase);
		payforService.getDataGridReturn(cq, true);
		dataGrid.setField("id,billCode,project.projectName,gys.gsmc,advance,yfMoney,payMoney,qkMoney");
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 
	 * @author WU
	 * @date 2015-8-19 下午3:03:23
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "payforHandle")
	public ModelAndView payforHandle(HttpServletRequest req) {
		String pid = req.getParameter("processInstanceId");
		PayforEntity page = payforService.findUniqueByProperty(PayforEntity.class, "processInstanceId", pid);
		req.setAttribute("page", page);
		req.setAttribute("userName", ResourceUtil.getSessionUserName().getRealName());
		return new ModelAndView("com/gfdz/cw/payforHandle");
	}

	/**
	 * 
	 * @author WU
	 * @date 2015-8-5 上午9:52:50
	 * @param pid
	 * @return
	 */
	@RequestMapping(params = "payforView")
	public ModelAndView payforView(HttpServletRequest req) {
		String pid = req.getParameter("pid");
		PayforEntity page = payforService.findUniqueByProperty(PayforEntity.class, "processInstanceId", pid);
		req.setAttribute("page", page);
		return new ModelAndView("com/gfdz/cw/payforView");
	}

	/**
	 * 执行任务
	 * 
	 * @param deploymentId
	 *            流程部署ID
	 */
	@RequestMapping(params = "completeTask")
	@ResponseBody
	public AjaxJson completeTask(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			payforService.completeTask(request);
		} catch (Exception e) {
			String message = "办理失败";
			if (StringUtil.isNotEmpty(e.getMessage())) {
				message = e.getMessage();
			}
			j.setSuccess(false);
			j.setMsg(message);
			e.printStackTrace();
		}

		return j;
	}

}
