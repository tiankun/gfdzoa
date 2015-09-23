package com.gfdz.cw.service.impl;
import com.gfdz.cw.service.PayfordetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.gfdz.cw.entity.PayfordetailEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("payfordetailService")
@Transactional
public class PayfordetailServiceImpl extends CommonServiceImpl implements PayfordetailServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((PayfordetailEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((PayfordetailEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((PayfordetailEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(PayfordetailEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(PayfordetailEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(PayfordetailEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,PayfordetailEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{cp}",String.valueOf(t.getCp()));
 		sql  = sql.replace("#{cgzx}",String.valueOf(t.getCgzx()));
 		sql  = sql.replace("#{num}",String.valueOf(t.getNum()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{money}",String.valueOf(t.getMoney()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{odate}",String.valueOf(t.getOdate()));
 		sql  = sql.replace("#{gysml}",String.valueOf(t.getGysml()));
 		sql  = sql.replace("#{payfor}",String.valueOf(t.getPayfor()));
 		sql  = sql.replace("#{applyreason}",String.valueOf(t.getApplyreason()));
 		sql  = sql.replace("#{fujnum}",String.valueOf(t.getFujnum()));
 		sql  = sql.replace("#{project}",String.valueOf(t.getProject()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}