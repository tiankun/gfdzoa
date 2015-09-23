package com.gfdz.service.impl.zhb;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.zhb.HtdjEntity;
import com.gfdz.service.zhb.HtdjServiceI;


import java.util.UUID;
import java.io.Serializable;

@Service("htdjService")
@Transactional
public class HtdjServiceImpl extends CommonServiceImpl implements HtdjServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((HtdjEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((HtdjEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((HtdjEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(HtdjEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(HtdjEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(HtdjEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,HtdjEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{lxbh}",String.valueOf(t.getLxbh()));
 		sql  = sql.replace("#{htbh}",String.valueOf(t.getHtbh()));
 		sql  = sql.replace("#{htmc}",String.valueOf(t.getHtmc()));
 		sql  = sql.replace("#{htnr}",String.valueOf(t.getHtnr()));
 		sql  = sql.replace("#{htdw}",String.valueOf(t.getHtdw()));
 		sql  = sql.replace("#{htrq}",String.valueOf(t.getHtrq()));
 		sql  = sql.replace("#{htje}",String.valueOf(t.getHtje()));
 		sql  = sql.replace("#{cdfs}",String.valueOf(t.getCdfs()));
 		sql  = sql.replace("#{jbr}",String.valueOf(t.getJbr()));
 		sql  = sql.replace("#{cfwz}",String.valueOf(t.getCfwz()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}