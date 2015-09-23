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
 * @Description: 项目材料采购执行详细
 * @author ant
 * @date 2015-05-28 14:01:09
 * @version V1.0   
 *
 */
@Entity
@Table(name = "gc_purchase_execute_detail", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PurchaseExecuteDetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**采购单主键*/
	private java.lang.String projectPlanId;
	/**采购申请物品主键*/
	private java.lang.String projectMaterialId;
	/**计划数量*/
	private java.lang.Integer amount;
	/**采购单价*/
	private java.lang.Integer price;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购申请物品主键
	 */
	@Column(name ="PROJECT_MATERIAL_ID",nullable=false,length=32)
	public java.lang.String getProjectMaterialId(){
		return this.projectMaterialId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购申请物品主键
	 */
	public void setProjectMaterialId(java.lang.String projectMaterialId){
		this.projectMaterialId = projectMaterialId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  计划数量
	 */
	@Column(name ="AMOUNT",nullable=false)
	public java.lang.Integer getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  计划数量
	 */
	public void setAmount(java.lang.Integer amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  采购单价
	 */
	@Column(name ="PRICE",nullable=true)
	public java.lang.Integer getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  采购单价
	 */
	public void setPrice(java.lang.Integer price){
		this.price = price;
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
