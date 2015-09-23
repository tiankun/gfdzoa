package com.gfdz.service.zhb;


import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.zhb.ZhbCgclEntity;
import com.gfdz.entity.zhb.ZhbCgqdEntity;

import java.io.Serializable;

public interface ZhbCgqdServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZhbCgqdEntity zhbCgqd,
	        List<ZhbCgclEntity> zhbCgclList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZhbCgqdEntity zhbCgqd,
	        List<ZhbCgclEntity> zhbCgclList);
	public void delMain (ZhbCgqdEntity zhbCgqd);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZhbCgqdEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZhbCgqdEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZhbCgqdEntity t);
}
