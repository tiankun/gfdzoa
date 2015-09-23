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

import com.gfdz.entity.zhb.ZhbCgclEntity;
import com.gfdz.entity.zhb.ZhbCgqdEntity;
import com.gfdz.service.zhb.ZhbCgqdServiceI;

import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("zhbCgqdService")
@Transactional
public class ZhbCgqdServiceImpl extends CommonServiceImpl implements ZhbCgqdServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZhbCgqdEntity)entity);
 	}
	
	public void addMain(ZhbCgqdEntity zhbCgqd,
	        List<ZhbCgclEntity> zhbCgclList){
			//保存主信息
			this.save(zhbCgqd);
		
			/**保存-采购申请材料*/
			for(ZhbCgclEntity zhbCgcl:zhbCgclList){
				//外键设置
				zhbCgcl.setCgqdId(zhbCgqd.getId());
				this.save(zhbCgcl);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(zhbCgqd);
	}

	
	public void updateMain(ZhbCgqdEntity zhbCgqd,
	        List<ZhbCgclEntity> zhbCgclList) {
		//保存主表信息
		this.saveOrUpdate(zhbCgqd);
		//===================================================================================
		//获取参数
		Object id0 = zhbCgqd.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-采购申请材料
	    String hql0 = "from ZhbCgclEntity where 1 = 1 AND cGQD_ID = ? ";
	    List<ZhbCgclEntity> zhbCgclOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-采购申请材料
		for(ZhbCgclEntity oldE:zhbCgclOldList){
			boolean isUpdate = false;
				for(ZhbCgclEntity sendE:zhbCgclList){
					//需要更新的明细数据-采购申请材料
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-采购申请材料
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-采购申请材料
			for(ZhbCgclEntity zhbCgcl:zhbCgclList){
				if(oConvertUtils.isEmpty(zhbCgcl.getId())){
					//外键设置
					zhbCgcl.setCgqdId(zhbCgqd.getId());
					this.save(zhbCgcl);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(zhbCgqd);
	}

	
	public void delMain(ZhbCgqdEntity zhbCgqd) {
		//删除主表信息
		this.delete(zhbCgqd);
		//===================================================================================
		//获取参数
		Object id0 = zhbCgqd.getId();
		//===================================================================================
		//删除-采购申请材料
	    String hql0 = "from ZhbCgclEntity where 1 = 1 AND cGQD_ID = ? ";
	    List<ZhbCgclEntity> zhbCgclOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(zhbCgclOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZhbCgqdEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZhbCgqdEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZhbCgqdEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZhbCgqdEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{projiect}",String.valueOf(t.getproject()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{input_time}",String.valueOf(t.getInputTime()));
 		sql  = sql.replace("#{linkman}",String.valueOf(t.getLinkman()));
 		sql  = sql.replace("#{contact_number}",String.valueOf(t.getContactNumber()));
 		sql  = sql.replace("#{apply_remark}",String.valueOf(t.getApplyRemark()));
 		sql  = sql.replace("#{flag}",String.valueOf(t.getFlag()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}