package com.gfdz.service.hr;

import java.io.Serializable;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.hr.VacationArrangementEntity;

public interface VacationArrangementService extends CommonService{
public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(VacationArrangementEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(VacationArrangementEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(VacationArrangementEntity t);

}
