package com.gfdz.service.impl.zhb;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;

import com.gfdz.entity.zhb.ZhbCgzxEntity;
import com.gfdz.entity.zhb.ZhbCgzxzEntity;
import com.gfdz.service.zhb.ZhbCgzxzServiceI;

import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("zhbCgzxzService")
@Transactional
public class ZhbCgzxzServiceImpl extends CommonServiceImpl implements ZhbCgzxzServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZhbCgzxzEntity)entity);
 	}
	
	public void addMain(ZhbCgzxzEntity zhbCgzxz,
	        List<ZhbCgzxEntity> zhbCgzxList){
			//保存主信息
			this.save(zhbCgzxz);
		
			/**保存-执行材料明细*/
			for(ZhbCgzxEntity zhbCgzx:zhbCgzxList){
				//外键设置
				zhbCgzx.setCgzxId(zhbCgzxz.getId());
				this.save(zhbCgzx);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(zhbCgzxz);
	}

	
	public void updateMain(ZhbCgzxzEntity zhbCgzxz,
	        List<ZhbCgzxEntity> zhbCgzxList) {
		//保存主表信息
		this.saveOrUpdate(zhbCgzxz);
		//===================================================================================
		//获取参数
		Object id0 = zhbCgzxz.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-执行材料明细
	    String hql0 = "from ZhbCgzxEntity where 1 = 1 AND cGSQ_ID = ? ";
	    List<ZhbCgzxEntity> zhbCgzxOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-执行材料明细
		for(ZhbCgzxEntity oldE:zhbCgzxOldList){
			boolean isUpdate = false;
				for(ZhbCgzxEntity sendE:zhbCgzxList){
					//需要更新的明细数据-执行材料明细
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-执行材料明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-执行材料明细
			for(ZhbCgzxEntity zhbCgzx:zhbCgzxList){
				if(oConvertUtils.isEmpty(zhbCgzx.getId())){
					//外键设置
					zhbCgzx.setCgzxId(zhbCgzxz.getId());
					this.save(zhbCgzx);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(zhbCgzxz);
	}

	
	public void delMain(ZhbCgzxzEntity zhbCgzxz) {
		//删除主表信息
		this.delete(zhbCgzxz);
		//===================================================================================
		//获取参数
		Object id0 = zhbCgzxz.getId();
		//===================================================================================
		//删除-执行材料明细
	    String hql0 = "from ZhbCgzxEntity where 1 = 1 AND cGSQ_ID = ? ";
	    List<ZhbCgzxEntity> zhbCgzxOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(zhbCgzxOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZhbCgzxzEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZhbCgzxzEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZhbCgzxzEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZhbCgzxzEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{cgqd_id}",String.valueOf(t.getCgqdId()));
 		sql  = sql.replace("#{input_time}",String.valueOf(t.getInputTime()));
 		sql  = sql.replace("#{input_user}",String.valueOf(t.getInputUser()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{falg}",String.valueOf(t.getFalg()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}