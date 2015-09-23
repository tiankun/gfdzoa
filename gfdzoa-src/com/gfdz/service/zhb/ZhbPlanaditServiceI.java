package com.gfdz.service.zhb;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.zhb.ZhbPlanaditEntity;
import com.gfdz.entity.zhb.ZhbPlanlistEntity;

import java.io.Serializable;

public interface ZhbPlanaditServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZhbPlanaditEntity zhbPlanadit,
	        List<ZhbPlanlistEntity> zhbPlanlistList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZhbPlanaditEntity zhbPlanadit,
	        List<ZhbPlanlistEntity> zhbPlanlistList);
	public void delMain (ZhbPlanaditEntity zhbPlanadit);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZhbPlanaditEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZhbPlanaditEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZhbPlanaditEntity t);
}
