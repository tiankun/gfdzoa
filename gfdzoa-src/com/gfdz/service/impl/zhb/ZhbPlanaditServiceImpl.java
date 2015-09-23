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

import com.gfdz.entity.zhb.ZhbPlanaditEntity;
import com.gfdz.entity.zhb.ZhbPlanlistEntity;
import com.gfdz.service.zhb.ZhbPlanaditServiceI;

import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("zhbPlanaditService")
@Transactional
public class ZhbPlanaditServiceImpl extends CommonServiceImpl implements ZhbPlanaditServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZhbPlanaditEntity)entity);
 	}
	
	public void addMain(ZhbPlanaditEntity zhbPlanadit,
	        List<ZhbPlanlistEntity> zhbPlanlistList){
			//保存主信息
			this.save(zhbPlanadit);
		
			/**保存-计划采购材料清单*/
			for(ZhbPlanlistEntity zhbPlanlist:zhbPlanlistList){
				//外键设置
				zhbPlanlist.setPlancpId(zhbPlanadit.getId());
				//外键设置
				zhbPlanlist.setPlanaditId(zhbPlanadit.getId());
				this.save(zhbPlanlist);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(zhbPlanadit);
	}

	
	public void updateMain(ZhbPlanaditEntity zhbPlanadit,
	        List<ZhbPlanlistEntity> zhbPlanlistList) {
		//保存主表信息
		
		this.save(zhbPlanadit);
		//===================================================================================
		//获取参数
		Object id1 = zhbPlanadit.getPlancpId();
		Object id0 = zhbPlanadit.getId();
		//Object id0 = zhbPlanadit.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-计划采购材料清单
	    String hql0 = "from ZhbPlanlistEntity where 1 = 1 AND pLANCP_ID = ?   ";
	    List<ZhbPlanlistEntity> zhbPlanlistOldList = this.findHql(hql0,id1);
		//2.筛选更新明细数据-计划采购材料清单
		for(ZhbPlanlistEntity oldE:zhbPlanlistOldList){
			boolean isUpdate = false;
				for(ZhbPlanlistEntity sendE:zhbPlanlistList){
					//需要更新的明细数据-计划采购材料清单
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-计划采购材料清单
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-计划采购材料清单
			for(ZhbPlanlistEntity zhbPlanlist:zhbPlanlistList){
				if(oConvertUtils.isEmpty(zhbPlanlist.getId())){
					//外键设置
					zhbPlanlist.setPlancpId(zhbPlanadit.getId());
					zhbPlanlist.setPlanaditId(zhbPlanadit.getId());
					this.save(zhbPlanlist);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(zhbPlanadit);
	}

	
	public void delMain(ZhbPlanaditEntity zhbPlanadit) {
		//删除主表信息
		this.delete(zhbPlanadit);
		//===================================================================================
		//获取参数
		Object id0 = zhbPlanadit.getId();
		//Object id0 = zhbPlanadit.getId();
		//===================================================================================
		//删除-计划采购材料清单
	    String hql0 = "from ZhbPlanlistEntity where 1 = 1 AND pLANCP_ID = ?  AND pLANADIT_ID = ? ";
	    List<ZhbPlanlistEntity> zhbPlanlistOldList = this.findHql(hql0,id0,id0);
		this.deleteAllEntitie(zhbPlanlistOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZhbPlanaditEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZhbPlanaditEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZhbPlanaditEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZhbPlanaditEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{plancp_id}",String.valueOf(t.getPlancpId()));
 		sql  = sql.replace("#{examin_explain}",String.valueOf(t.getExaminExplain()));
 		sql  = sql.replace("#{flag}",String.valueOf(t.getFlag()));
 		sql  = sql.replace("#{examin_person}",String.valueOf(t.getExaminPerson()));
 		sql  = sql.replace("#{examin_time}",String.valueOf(t.getExaminTime()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}