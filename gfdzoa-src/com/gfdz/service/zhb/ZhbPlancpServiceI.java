package com.gfdz.service.zhb;


import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.zhb.ZhbPlancpEntity;
import com.gfdz.entity.zhb.ZhbPlanlistEntity;

import java.io.Serializable;

public interface ZhbPlancpServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZhbPlancpEntity zhbPlancp,
	        List<ZhbPlanlistEntity> zhbPlanlistList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZhbPlancpEntity zhbPlancp,
	        List<ZhbPlanlistEntity> zhbPlanlistList);
	public void delMain (ZhbPlancpEntity zhbPlancp);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZhbPlancpEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZhbPlancpEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZhbPlancpEntity t);
}
