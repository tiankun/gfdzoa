package com.buss.controller.acs;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.acs.GoodsEntity;
import com.buss.entity.acs.OrderDetailEntity;
import com.buss.entity.acs.OrderEntity;
import com.buss.entity.acs.ProfitEntity;
import com.buss.entity.acs.SupplierEntity;
import com.buss.service.acs.OrderServiceI;


/**   
 * @Title: Controller
 * @Description: 订单表
 * @author onlineGenerator
 * @date 2015-03-23 15:55:10
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/orderController")
public class OrderController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	private OrderServiceI orderService;
	@Autowired
	private SystemService systemService;


	/**
	 * 订单表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "orderList")
	public ModelAndView orderList(HttpServletRequest request) {
		return new ModelAndView("buss/order/orderList");
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
	public void datagrid(OrderEntity order,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OrderEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, order);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add(Restrictions.eq("orderType", request.getParameter("orderType")));
		this.orderService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	
	
	/**
	 * 删除订单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(OrderEntity order, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		order = systemService.getEntity(OrderEntity.class, order.getId());
		String message = "订单表删除成功";
		try{
			orderService.delMain(order);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "订单表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除订单表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "订单表删除成功";
		try{
			for(String id:ids.split(",")){
				OrderEntity order = systemService.getEntity(OrderEntity.class,
				id
				);
				orderService.delMain(order);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "订单表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加订单表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(OrderEntity order, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			orderService.addMain(order);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "订单表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新订单表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(OrderEntity order, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			orderService.updateMain(order);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新订单表失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 订单表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(OrderEntity order, HttpServletRequest req) {
		// 商品品牌
		List<TSType> cbrand = TSTypegroup.allTypes.get("goodsBrand".toLowerCase());
		JSONObject obj = new JSONObject();
		if (cbrand != null && cbrand.size() > 0) {
			for (int i = 0; i < cbrand.size(); i++) {
				obj.put(cbrand.get(i).getTypecode(), cbrand.get(i).getTypename());
			}
		}
		req.setAttribute("cbrand", obj.toString());
		if (StringUtil.isNotEmpty(order.getId())) {
			order = orderService.getEntity(OrderEntity.class, order.getId());
			req.setAttribute("orderPage", order);
			}
		req.setAttribute("orderNumber", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		return new ModelAndView("buss/order/goAdd");
	}
	
	/**
	 * 订单表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(OrderEntity order, HttpServletRequest req) {
		// 商品品牌
		List<TSType> cbrand = TSTypegroup.allTypes.get("goodsBrand".toLowerCase());
		JSONObject obj = new JSONObject();
		if (cbrand != null && cbrand.size() > 0) {
			for (int i = 0; i < cbrand.size(); i++) {
				obj.put(cbrand.get(i).getTypecode(), cbrand.get(i).getTypename());
			}
		}
		req.setAttribute("cbrand", obj.toString());
		if (StringUtil.isNotEmpty(order.getId())) {
			order = orderService.getEntity(OrderEntity.class, order.getId());
			req.setAttribute("orderPage", order);
		}
		List<SupplierEntity> supplierList = systemService.getList(SupplierEntity.class);
		req.setAttribute("supplierList", supplierList);
		if("cg".equals(req.getParameter("flags"))){
			return new ModelAndView("buss/order/updateCgOrder");
		}else{
			
			return new ModelAndView("buss/order/updateOrder");
		}
	}
	
	
	/**
	 * 加载明细列表[订单]
	 * 
	 * @return
	 */
	@RequestMapping(params = "orderDetailList")
	public ModelAndView orderDetailList(String orderId, HttpServletRequest req) {
		return new ModelAndView("buss/order/orderDetailList");
	}
	
	/**
	 * 
	 */
	
	@RequestMapping(params = "orderDetailData")
	public void orderDetailData(OrderDetailEntity orderDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OrderDetailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, orderDetail);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add(Restrictions.eq("corder.id", request.getParameter("orderId")));
		this.orderService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	/**
	 * 采购订单列表跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "ordercgList")
	public ModelAndView ordercgList(HttpServletRequest request) {
		return new ModelAndView("buss/order/ordercgList");
	}
	
	/**
	 * 采购单跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "cgAdd")
	public ModelAndView cgAdd(HttpServletRequest request) {
		// 商品品牌
		List<TSType> cbrand = TSTypegroup.allTypes.get("goodsBrand".toLowerCase());
		JSONObject obj = new JSONObject();
		if (cbrand != null && cbrand.size() > 0) {
			for (int i = 0; i < cbrand.size(); i++) {
				obj.put(cbrand.get(i).getTypecode(), cbrand.get(i).getTypename());
			}
		}
		request.setAttribute("cbrand", obj.toString());
		String orid = request.getParameter("orid");
		String orderNumber = request.getParameter("orderNumber");
		List<OrderDetailEntity> list = this.orderService.findByProperty(OrderDetailEntity.class, "corder.id", orid);
		List<SupplierEntity> supplierList = systemService.getList(SupplierEntity.class);
		request.setAttribute("supplierList", supplierList);
		request.setAttribute("orderNumber", orderNumber);
		request.setAttribute("list", list);
		return new ModelAndView("buss/order/cgAdd");
	}
	
	/**
	 * 采购单保存
	 * @param order
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "saveCgOrder")
	@ResponseBody
	public AjaxJson saveCgOrder(OrderEntity order, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			orderService.saveCgOrder(order);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "订单表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 采购单追加
	 * @param order
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "updateCgOrder")
	@ResponseBody
	public AjaxJson updateCgOrder(OrderEntity order, HttpServletRequest request) {
		// 商品品牌
		List<TSType> cbrand = TSTypegroup.allTypes.get("goodsBrand".toLowerCase());
		JSONObject obj = new JSONObject();
		if (cbrand != null && cbrand.size() > 0) {
			for (int i = 0; i < cbrand.size(); i++) {
				obj.put(cbrand.get(i).getTypecode(), cbrand.get(i).getTypename());
			}
		}
		request.setAttribute("cbrand", obj.toString());
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			orderService.updateCgOrder(order);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "订单表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 利润分析列表跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "orderfxList")
	public ModelAndView orderfxList(HttpServletRequest request) {
		return new ModelAndView("buss/order/orderfxList");
	}
	
	
	@RequestMapping(params = "orderfxData")
	public void orderfxData(ProfitEntity profit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		this.orderService.getOrderfxData(request,dataGrid);
		TagUtil.datagrid(response, dataGrid);
		
	}
	/**
	 * 客户订单详情
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "orderDetail")
	public ModelAndView orderDetail(HttpServletRequest request) {
		return new ModelAndView("buss/order/orderDetail");
	}

	
	/**
	 *  产品选择列表
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "goodsList")
	public ModelAndView goodsList(HttpServletRequest request) {
		return new ModelAndView("buss/order/goodsList");
	}
	
	@ResponseBody
	@RequestMapping(params = "goodsListJson")
	public void goodsListJson(GoodsEntity goods, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(GoodsEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, goods);
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 库存列表
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "goodsNumList")
	public ModelAndView goodsNumList(HttpServletRequest request) {
		return new ModelAndView("buss/order/goodsNumList");
	}
	
	/**
	 * 获取库存数量
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	
	@RequestMapping(params = "getGoodsNum")
	public void getGoodsNum(HttpServletRequest request, HttpServletResponse response,  DataGrid dataGrid){
		this.orderService.getGoodsNum(request,dataGrid);
		TagUtil.datagrid(response, dataGrid);
	}
}
