package com.gfdz.entity.gc;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 项目材料采购执行
 * @author ant
 * @date 2015-05-28 14:00:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "gc_purchase_execute", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PurchaseExecuteEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**采购单主键*/
	private java.lang.String projectPlanId;
	/**创建时间*/
	private java.util.Date inputTime;
	/**创建人*/
	private java.lang.String inputUser;
	/**供货单位*/
	private java.lang.String suppliers;
	/**流程id*/
	private java.lang.String processinstanceid;
	/**备注*/
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
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
	 *@return: java.lang.String  采购单主键
	 */
	@Column(name ="PROJECT_PLAN_ID",nullable=false,length=32)
	public java.lang.String getProjectPlanId(){
		return this.projectPlanId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购单主键
	 */
	public void setProjectPlanId(java.lang.String projectPlanId){
		this.projectPlanId = projectPlanId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="INPUT_TIME",nullable=false,scale=6)
	public java.util.Date getInputTime(){
		return this.inputTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setInputTime(java.util.Date inputTime){
		this.inputTime = inputTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="INPUT_USER",nullable=false,length=32)
	public java.lang.String getInputUser(){
		return this.inputUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setInputUser(java.lang.String inputUser){
		this.inputUser = inputUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供货单位
	 */
	@Column(name ="SUPPLIERS",nullable=false,length=32)
	public java.lang.String getSuppliers(){
		return this.suppliers;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供货单位
	 */
	public void setSuppliers(java.lang.String suppliers){
		this.suppliers = suppliers;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程id
	 */
	@Column(name ="PROCESSINSTANCEID",nullable=true,length=32)
	public java.lang.String getProcessinstanceid(){
		return this.processinstanceid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程id
	 */
	public void setProcessinstanceid(java.lang.String processinstanceid){
		this.processinstanceid = processinstanceid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=500)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
}
