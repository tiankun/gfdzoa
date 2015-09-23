package com.buss.service.acs;
import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.buss.entity.acs.OrderEntity;

public interface OrderServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(OrderEntity order) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(OrderEntity order);
	
	/**
	 * 保存采购单子
	 * @param order
	 */
	public void  saveCgOrder(OrderEntity order);
	
	/**
	 * 追加采购单子
	 * @param order
	 */
	public void  updateCgOrder(OrderEntity order);
	
	public void delMain (OrderEntity order);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(OrderEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(OrderEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(OrderEntity t);
 
 	/**
 	 * 获取库存数据
 	 * @param request
 	 * @param dataGrid
 	 */
	public void getGoodsNum(HttpServletRequest request,DataGrid dataGrid);
	
	/**
	 * 利润分析数据
	 * @param request
	 * @param dataGrid
	 */
	public void getOrderfxData(HttpServletRequest request,DataGrid dataGrid);
}
