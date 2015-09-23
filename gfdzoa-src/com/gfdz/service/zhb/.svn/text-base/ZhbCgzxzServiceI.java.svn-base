package com.gfdz.service.zhb;


import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.zhb.ZhbCgzxEntity;
import com.gfdz.entity.zhb.ZhbCgzxzEntity;

import java.io.Serializable;

public interface ZhbCgzxzServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZhbCgzxzEntity zhbCgzxz,
	        List<ZhbCgzxEntity> zhbCgzxList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZhbCgzxzEntity zhbCgzxz,
	        List<ZhbCgzxEntity> zhbCgzxList);
	public void delMain (ZhbCgzxzEntity zhbCgzxz);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZhbCgzxzEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZhbCgzxzEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZhbCgzxzEntity t);
}
