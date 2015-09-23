package com.gfdz.service.impl.zhb;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.zhb.GysmlEntity;
import com.gfdz.service.zhb.GysmlServiceI;

import java.util.UUID;
import java.io.Serializable;

@Service("gysmlService")
@Transactional
public class GysmlServiceImpl extends CommonServiceImpl implements GysmlServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((GysmlEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((GysmlEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((GysmlEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(GysmlEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(GysmlEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(GysmlEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,GysmlEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{lxbh}",String.valueOf(t.getLxbh()));
 		sql  = sql.replace("#{gysbh}",String.valueOf(t.getGysbh()));
 		sql  = sql.replace("#{gsmc}",String.valueOf(t.getGsmc()));
 		sql  = sql.replace("#{gsdh}",String.valueOf(t.getGsdh()));
 		sql  = sql.replace("#{gscz}",String.valueOf(t.getGscz()));
 		sql  = sql.replace("#{gsdz}",String.valueOf(t.getGsdz()));
 		sql  = sql.replace("#{gswz}",String.valueOf(t.getGswz()));
 		sql  = sql.replace("#{zczb}",String.valueOf(t.getZczb()));
 		sql  = sql.replace("#{gsfr}",String.valueOf(t.getGsfr()));
 		sql  = sql.replace("#{clsj}",String.valueOf(t.getClsj()));
 		sql  = sql.replace("#{fzr}",String.valueOf(t.getFzr()));
 		sql  = sql.replace("#{fzrdh}",String.valueOf(t.getFzrdh()));
 		sql  = sql.replace("#{lxr}",String.valueOf(t.getLxr()));
 		sql  = sql.replace("#{lxrdh}",String.valueOf(t.getLxrdh()));
 		sql  = sql.replace("#{fktj}",String.valueOf(t.getFktj()));
 		sql  = sql.replace("#{ghq}",String.valueOf(t.getGhq()));
 		sql  = sql.replace("#{psfs}",String.valueOf(t.getPsfs()));
 		sql  = sql.replace("#{sfjszc}",String.valueOf(t.getSfjszc()));
 		sql  = sql.replace("#{sfybnsr}",String.valueOf(t.getSfybnsr()));
 		sql  = sql.replace("#{pjbgbh}",String.valueOf(t.getPjbgbh()));
 		sql  = sql.replace("#{sclrrq}",String.valueOf(t.getSclrrq()));
 		sql  = sql.replace("#{ndfpjg}",String.valueOf(t.getNdfpjg()));
 		sql  = sql.replace("#{fpsj}",String.valueOf(t.getFpsj()));
 		sql  = sql.replace("#{pdjl}",String.valueOf(t.getPdjl()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}