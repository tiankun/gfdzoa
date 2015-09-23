package com.gfdz.controller.gc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.gc.PurchaseEntity;
import com.gfdz.entity.gc.PurchasePlanDetailEntity;
import com.gfdz.entity.gc.PurchasePlanEntity;
import com.gfdz.service.gc.PurchaseServiceI;

/**
 * @Title: Controller
 * @Description: 项目材料采购申请
 * @author ant
 * @date 2015-05-28 13:58:18
 * @version V1.0
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/purchaseController")
public class PurchaseController extends BaseController {

	@Autowired
	private PurchaseServiceI purchaseService;
	@Autowired
	protected TaskService taskService;

	/**
	 * 项目材料采购申请列表 页面跳转
	 * 
	 * @author WU
	 * @date 2015-7-30 下午4:07:13
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "purchaseList")
	public ModelAndView purchaseList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/purchaseList");
	}

	/**
	 * 项目材料采购申请
	 * 
	 * @author WU
	 * @date 2015-7-30 下午4:07:08
	 * @param plan
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "purchase")
	public ModelAndView purchase(PurchasePlanEntity plan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(plan.getId())) {
			plan = purchaseService.getEntity(PurchasePlanEntity.class, plan.getId());
			req.setAttribute("page", plan);
		}
		return new ModelAndView("com/gfdz/gc/purchase");
	}

	/**
	 * 
	 * @author WU
	 * @date 2015-8-18 下午2:04:40
	 * @param plan
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "selectGysList")
	public ModelAndView selectGysList(HttpServletRequest req) {
		return new ModelAndView("com/gfdz/gc/selectGysList");
	}

	/**
	 * 保存生成采购执行单
	 * 
	 * @author WU
	 * @date 2015-7-31 上午11:31:04
	 * @param purchase
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "purchaseSave")
	public AjaxJson purchaseSave(PurchaseEntity purchase, String[] pdId) {
		AjaxJson j = new AjaxJson();
		try {
			purchaseService.purchaseSave(purchase, pdId);
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
	 * 
	 * @author WU
	 * @date 2015年9月9日 下午4:40:40
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "purchaseHandle")
	public ModelAndView purchaseHandle(HttpServletRequest req) {
		String pid = req.getParameter("processInstanceId");
		PurchasePlanEntity plan = purchaseService.findUniqueByProperty(PurchasePlanEntity.class, "processInstanceId", pid);
		req.setAttribute("page", plan);
		req.setAttribute("userName", ResourceUtil.getSessionUserName().getRealName());
		TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey(plan.getId()).active();
		Task task = query.singleResult();

		if ("purchaseAppy".equals(task.getTaskDefinitionKey())) {
			return new ModelAndView("com/gfdz/gc/purchaseUpdate");
		} else {
			return new ModelAndView("com/gfdz/gc/purchaseHandle");
		}
	}

	/**
	 * 
	 * @author WU
	 * @date 2015-8-5 上午11:40:33
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "createPurchase")
	public ModelAndView createPurchase(HttpServletRequest req, String[] pdId) {
		String id = req.getParameter("plan.id");
		PurchasePlanEntity plan = purchaseService.get(PurchasePlanEntity.class, id);
		req.setAttribute("page", plan);
		List<PurchasePlanDetailEntity> list = purchaseService.getPurchase(id, pdId);
		req.setAttribute("list", list);
		return new ModelAndView("com/gfdz/gc/createPurchase");
	}

	/**
	 * 
	 * @author WU
	 * @date 2015-8-5 上午9:52:50
	 * @param pid
	 * @return
	 */
	@RequestMapping(params = "purchaseView")
	public ModelAndView purchaseView(HttpServletRequest req) {
		String pid = req.getParameter("pid");
		PurchasePlanEntity plan = purchaseService.findUniqueByProperty(PurchasePlanEntity.class, "processInstanceId", pid);
		req.setAttribute("page", plan);
		return new ModelAndView("com/gfdz/gc/purchaseView");
	}

	/**
	 * 
	 * @author WU
	 * @date 2015年9月9日 下午4:40:34
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "completeTask")
	@ResponseBody
	public AjaxJson completeTask(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			purchaseService.completeTask(request);
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

	/**
	 * 删除采购执行单
	 * 
	 * @author WU
	 * @date 2015年9月9日 下午4:40:15
	 * @param p
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "del")
	public AjaxJson del(PurchaseEntity p) {
		AjaxJson j = new AjaxJson();
		try {
			purchaseService.delPurchas(p);
		} catch (Exception e) {
			String message = "删除失败！";
			if (StringUtil.isNotEmpty(e.getMessage())) {
				message = e.getMessage();
			}
			j.setSuccess(false);
			j.setMsg(message);
			e.printStackTrace();
		}

		return j;
	}

	/**
	 * 全额预付款的到货通知
	 * 
	 * @author WU
	 * @date 2015-8-28 下午5:14:42
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "arrivalNotice")
	public JSONObject arrivalNotice() {
		JSONObject obj = new JSONObject();
		try {
			obj = purchaseService.arrivalNotice();
			obj.put("success", true);
		} catch (Exception e) {
			obj.put("success", false);
			e.printStackTrace();
		}
		return obj;
	}
}
