
package com.gfdz.page.zhb;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.gfdz.entity.zhb.ZhbPlanlistEntity;

import javax.persistence.SequenceGenerator;


/**   
 * @Title: Entity
 * @Description: 计划采购申请审核
 * @author onlineGenerator
 * @date 2015-07-20 11:41:07
 * @version V1.0   
 *
 */
public class ZhbPlanaditPage implements java.io.Serializable {
	/**保存-计划采购材料清单*/
	private List<ZhbPlanlistEntity> zhbPlanlistList = new ArrayList<ZhbPlanlistEntity>();
	public List<ZhbPlanlistEntity> getZhbPlanlistList() {
		return zhbPlanlistList;
	}
	public void setZhbPlanlistList(List<ZhbPlanlistEntity> zhbPlanlistList) {
		this.zhbPlanlistList = zhbPlanlistList;
	}

	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**计划采购主表id*/
	private java.lang.String plancpId;
	/**审核说明*/
	private java.lang.String examinExplain;
	/**状态*/
	private java.math.BigDecimal flag;
	/**审核人*/
	private java.lang.String examinPerson;
	/**审核时间*/
	private java.util.Date examinTime;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划采购主表id
	 */
	public java.lang.String getPlancpId(){
		return this.plancpId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划采购主表id
	 */
	public void setPlancpId(java.lang.String plancpId){
		this.plancpId = plancpId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核说明
	 */
	public java.lang.String getExaminExplain(){
		return this.examinExplain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核说明
	 */
	public void setExaminExplain(java.lang.String examinExplain){
		this.examinExplain = examinExplain;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  状态
	 */
	public java.math.BigDecimal getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  状态
	 */
	public void setFlag(java.math.BigDecimal flag){
		this.flag = flag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	public java.lang.String getExaminPerson(){
		return this.examinPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setExaminPerson(java.lang.String examinPerson){
		this.examinPerson = examinPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核时间
	 */
	public java.util.Date getExaminTime(){
		return this.examinTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setExaminTime(java.util.Date examinTime){
		this.examinTime = examinTime;
	}
}
