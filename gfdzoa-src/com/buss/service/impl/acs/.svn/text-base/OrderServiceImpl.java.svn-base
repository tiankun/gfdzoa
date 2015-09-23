package com.buss.service.impl.acs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.JeecgSqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.entity.acs.GoodsinoutEntity;
import com.buss.entity.acs.OrderDetailEntity;
import com.buss.entity.acs.OrderEntity;
import com.buss.entity.acs.ProfitEntity;
import com.buss.service.acs.OrderServiceI;


@Service("orderService")
@Transactional
public class OrderServiceImpl extends CommonServiceImpl implements OrderServiceI {
	
	@Autowired
	private JdbcDao jdbcDao;
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((OrderEntity)entity);
 	}
	
	public void addMain(OrderEntity order){
		//保存主信息
		this.save(order);
		/**保存-订单明细*/
		List<OrderDetailEntity>	orderDetailList = order.getOrderDetail();
		Double anzmoney = 0d;
		Double fuwumoney = 0d;
		Integer fuwunum = 0;

		if(orderDetailList!=null && orderDetailList.size()>0){
			for (int i = orderDetailList.size()-1; i >= 0; i--) {
				OrderDetailEntity orderDetail = orderDetailList.get(i);
				if(orderDetail!=null && orderDetail.getGoods()!=null && orderDetail.getGoods().getId()!=null){
					orderDetail.setCorder(order);
					this.save(orderDetail);
					if("8a8080c24c78e40d014c791f4bd1000f".equals(orderDetail.getGoods().getId())){
						anzmoney = 	orderDetail.getGoodsMoney();
					}else if ("8a8080c24c72e6bf014c73805393002e".equals(orderDetail.getGoods().getId())) {
						 fuwumoney = orderDetail.getGoodsMoney();
						 fuwunum = orderDetail.getGoodsNum();
					}
					GoodsinoutEntity inOrOut = new GoodsinoutEntity();
					inOrOut.setGoods(orderDetail.getGoods());
					inOrOut.setGoodsNum(orderDetail.getGoodsNum());
					inOrOut.setInorout("1");
					inOrOut.setOrderNumber(order.getOrderNumber());
					inOrOut.setGoodsState("1");
					this.save(inOrOut);
				}
			}
		}
			
		ProfitEntity profit = new ProfitEntity();
		profit.setOrderNumber(order.getOrderNumber());//设置订单编号
		profit.setSales(order.getOrderMoney());
		//profit.setAnzmoney(anzmoney);
		profit.setFuwumoney(fuwumoney);
		profit.setFuwunum(fuwunum);
		this.save(profit);
	}

	
	public void updateMain(OrderEntity order) {
		
		OrderEntity neworder = this.get(OrderEntity.class, order.getId());
		neworder.setOrderMoney(neworder.getOrderMoney()+order.getOrderMoney());
 		/**保存-订单明细*/
		Double anzmoney = 0d;
		Double fuwumoney = 0d;
		Integer fuwunum = 0;
		List<OrderDetailEntity>	orderDetailList = order.getOrderDetail();
		
		if(orderDetailList!=null && orderDetailList.size()>0){
			for (int i = orderDetailList.size()-1; i >= 0; i--) {
				OrderDetailEntity orderDetail = orderDetailList.get(i);
				if(orderDetail!=null && orderDetail.getGoods()!=null && orderDetail.getGoods().getId()!=null){
					orderDetail.setCorder(neworder);
					this.save(orderDetail);
					
					if("8a8080c24c78e40d014c791f4bd1000f".equals(orderDetail.getGoods().getId())){
						anzmoney = 	orderDetail.getGoodsMoney();
					}else if ("8a8080c24c72e6bf014c73805393002e".equals(orderDetail.getGoods().getId())) {
						 fuwumoney = orderDetail.getGoodsMoney();
						 fuwunum = orderDetail.getGoodsNum();
					}
					
					GoodsinoutEntity inOrOut = new GoodsinoutEntity();
					inOrOut.setGoods(orderDetail.getGoods());
					inOrOut.setGoodsNum(orderDetail.getGoodsNum());
					inOrOut.setInorout("1");
					inOrOut.setOrderNumber(order.getOrderNumber());
					inOrOut.setGoodsState("1");
					this.save(inOrOut);
				}
			}
		}
		ProfitEntity profit = this.findUniqueByProperty(ProfitEntity.class, "orderNumber", neworder.getOrderNumber());
		profit.setSales((profit.getSales()!=null ?profit.getSales() : 0) +order.getOrderMoney());
		//profit.setAnzmoney((profit.getAnzmoney()!=null ? profit.getAnzmoney() : 0) +anzmoney);
		profit.setFuwumoney((profit.getFuwumoney()!=null ? profit.getFuwumoney() : 0) + fuwumoney);
		profit.setFuwunum((profit.getFuwunum()!=null ? profit.getFuwunum() : 0) + fuwunum);
		this.updateEntitie(profit);
	}

	
	public void delMain(OrderEntity order) {
		//删除主表信息
		this.delete(order);
		//===================================================================================
		//获取参数
		String orderNumber = order.getOrderNumber();
		//===================================================================================
		//更改订单商品进出记录
	    String hql0 = "from GoodsinoutEntity where 1 = 1 AND orderNumber = ? ";
	    List<GoodsinoutEntity> goodsinoutList = this.findHql(hql0,orderNumber);
	    if(goodsinoutList!=null && goodsinoutList.size()>0){
	    	for (int i = 0; i < goodsinoutList.size(); i++) {
	    		GoodsinoutEntity inout = goodsinoutList.get(i);
	    		inout.setGoodsState("0");
	    		this.updateEntitie(inout);
			}
	    }
	    //删除利润分析记录
	    ProfitEntity profit = this.findUniqueByProperty(ProfitEntity.class, "orderNumber", orderNumber);
	    if(profit!=null){
	    	this.delete(profit);
	    }
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(OrderEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(OrderEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(OrderEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,OrderEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{order_number}",String.valueOf(t.getOrderNumber()));
 		sql  = sql.replace("#{order_date}",String.valueOf(t.getOrderDate()));
 		sql  = sql.replace("#{order_note}",String.valueOf(t.getOrderNote()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}

	@Override
	public void saveCgOrder(OrderEntity order) {
		//保存主信息
		this.save(order);
			/**保存-订单明细*/
		List<OrderDetailEntity>	orderDetailList = order.getOrderDetail();
		Double anzmoney = 0d;
		Double fuwumoney = 0d;
		Integer fuwunum = 0;
		if(orderDetailList!=null && orderDetailList.size()>0){
			for (int i = orderDetailList.size()-1; i >= 0; i--) {
				OrderDetailEntity orderDetail = orderDetailList.get(i);
				if(orderDetail!=null && orderDetail.getGoods()!=null && orderDetail.getGoods().getId()!=null){
					orderDetail.setCorder(order);
					this.save(orderDetail);
					
					if("8a8080c24c78e40d014c791f4bd1000f".equals(orderDetail.getGoods().getId())){
						anzmoney = 	orderDetail.getGoodsMoney();
					}else if ("8a8080c24c72e6bf014c73805393002e".equals(orderDetail.getGoods().getId())) {
						 fuwumoney = orderDetail.getGoodsMoney();
						 fuwunum = orderDetail.getGoodsNum();
					}
					
					GoodsinoutEntity inOrOut = new GoodsinoutEntity();
					inOrOut.setGoods(orderDetail.getGoods());
					inOrOut.setGoodsNum(orderDetail.getGoodsNum());
					inOrOut.setInorout("0");
					inOrOut.setOrderNumber(order.getOrderNumber());
					inOrOut.setGoodsState("1");
					this.save(inOrOut);
				}
			}
		}
			
		ProfitEntity profit = this.findUniqueByProperty(ProfitEntity.class, "orderNumber", order.getOrderNumber());
		profit.setCost(order.getOrderMoney());
		profit.setAnzmoney((profit.getAnzmoney()!=null ? profit.getAnzmoney() : 0) +anzmoney);
		profit.setFuwumoney((profit.getFuwumoney()!=null ? profit.getFuwumoney() : 0) + fuwumoney);
		profit.setFuwunum((profit.getFuwunum()!=null ? profit.getFuwunum() : 0) + fuwunum);
		this.updateEntitie(profit);
			
	}

	@Override
	public void updateCgOrder(OrderEntity order) {
		OrderEntity neworder = this.get(OrderEntity.class, order.getId());
		neworder.setOrderMoney(neworder.getOrderMoney()+order.getOrderMoney());
 		/**保存-订单明细*/
 		
		List<OrderDetailEntity>	orderDetailList = order.getOrderDetail();
		Double anzmoney = 0d;
		Double fuwumoney = 0d;
		Integer fuwunum = 0;
		if(orderDetailList!=null && orderDetailList.size()>0){
			for (int i = orderDetailList.size()-1; i >= 0; i--) {
				OrderDetailEntity orderDetail = orderDetailList.get(i);
				if(orderDetail!=null && orderDetail.getGoods()!=null && orderDetail.getGoods().getId()!=null){
					orderDetail.setCorder(neworder);
					this.save(orderDetail);
					
					if("8a8080c24c78e40d014c791f4bd1000f".equals(orderDetail.getGoods().getId())){
						anzmoney = 	orderDetail.getGoodsMoney();
					}else if ("8a8080c24c72e6bf014c73805393002e".equals(orderDetail.getGoods().getId())) {
						 fuwumoney = orderDetail.getGoodsMoney();
						 fuwunum = orderDetail.getGoodsNum();
					}
					
					GoodsinoutEntity inOrOut = new GoodsinoutEntity();
					inOrOut.setGoods(orderDetail.getGoods());
					inOrOut.setGoodsNum(orderDetail.getGoodsNum());
					inOrOut.setInorout("0");
					inOrOut.setOrderNumber(neworder.getOrderNumber());
					inOrOut.setGoodsState("1");
					this.save(inOrOut);
				}
			}
		}
		ProfitEntity profit = this.findUniqueByProperty(ProfitEntity.class, "orderNumber", neworder.getOrderNumber());
		profit.setCost((profit.getCost()!=null ?profit.getCost() : 0) +order.getOrderMoney());
		profit.setAnzmoney((profit.getAnzmoney()!=null ? profit.getAnzmoney() : 0) +anzmoney);
		profit.setFuwumoney((profit.getFuwumoney()!=null ? profit.getFuwumoney() : 0) + fuwumoney);
		profit.setFuwunum((profit.getFuwunum()!=null ? profit.getFuwunum() : 0) + fuwunum);
		this.updateEntitie(profit);
	}

	@Override
	public void getGoodsNum(HttpServletRequest request,DataGrid dataGrid) {
		//从对应路径中，获取SQL [/jeecg/demo/sql/test/JeecgJdbcService_listAllByJdbc.sql]
		String sql = JeecgSqlUtil.getMethodSql(JeecgSqlUtil.getMethodUrl());
		String goodsName = request.getParameter("goodsname");
		if(goodsName!=null && !"".equals(goodsName)){
			sql = sql.replace("@replace", "and t1.goods_name like '%"+goodsName+"%'");
		}else{
			sql = sql.replace("@replace", "");
		}
		
		String countsql = "select count(*) from ("+sql+") c";
		List<Map<String, Object>> maplist =  jdbcDao.findForJdbcParam(sql, dataGrid.getPage(), dataGrid.getRows());
		Long count = jdbcDao.getCountForJdbcParam(countsql);
		dataGrid.setTotal(count.intValue());
		dataGrid.setResults(maplist);
		
	}

	@Override
	public void getOrderfxData(HttpServletRequest request, DataGrid dataGrid) {
		String sql = JeecgSqlUtil.getMethodSql(JeecgSqlUtil.getMethodUrl());

		String countsql = "select count(*) from ("+sql+") c";
		List<Map<String, Object>> maplist =  jdbcDao.findForJdbcParam(sql, dataGrid.getPage(), dataGrid.getRows());
		Long count = jdbcDao.getCountForJdbcParam(countsql);
		dataGrid.setTotal(count.intValue());
		dataGrid.setResults(maplist);
		
		List<Object> param = new ArrayList<Object>();
		// 设置合计
		String tsql = "select '合计' orderNumber,ifnull(sum(sales),0) sales,ifnull(sum(cost),0) cost,ifnull(sum(profit),0)-166000 profit from("+ sql.toString() + ") x";
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> mapList = this.findForJdbc(tsql, param.toArray());
		if (mapList != null && mapList.size() == 1) {
			map = mapList.get(0);
		}
		JSONObject obj = JSONObject.fromObject(map);
		dataGrid.setFooter(obj.toString().substring(1, obj.toString().length() - 1).replaceAll("\"", ""));
	}
 	
 	
 	
}