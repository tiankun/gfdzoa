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
 * @Description: 项目材料采购到货记录
 * @author ant
 * @date 2015-05-28 14:03:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "gc_purchase_execute_confirm", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PurchaseExecuteConfirmEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**detailedId*/
	private java.lang.String detailedId;
	/**confirmNumber*/
	private java.lang.Integer confirmNumber;
	/**confirmTime*/
	private java.util.Date confirmTime;
	/**sjSuppliers*/
	private java.lang.String sjSuppliers;
	/**confirmUser*/
	private java.lang.String confirmUser;
	/**remark*/
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  detailedId
	 */
	@Column(name ="DETAILED_ID",nullable=true,length=32)
	public java.lang.String getDetailedId(){
		return this.detailedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  detailedId
	 */
	public void setDetailedId(java.lang.String detailedId){
		this.detailedId = detailedId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  confirmNumber
	 */
	@Column(name ="CONFIRM_NUMBER",nullable=true)
	public java.lang.Integer getConfirmNumber(){
		return this.confirmNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  confirmNumber
	 */
	public void setConfirmNumber(java.lang.Integer confirmNumber){
		this.confirmNumber = confirmNumber;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  confirmTime
	 */
	@Column(name ="CONFIRM_TIME",nullable=true)
	public java.util.Date getConfirmTime(){
		return this.confirmTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  confirmTime
	 */
	public void setConfirmTime(java.util.Date confirmTime){
		this.confirmTime = confirmTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjSuppliers
	 */
	@Column(name ="SJ_SUPPLIERS",nullable=true,length=32)
	public java.lang.String getSjSuppliers(){
		return this.sjSuppliers;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjSuppliers
	 */
	public void setSjSuppliers(java.lang.String sjSuppliers){
		this.sjSuppliers = sjSuppliers;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  confirmUser
	 */
	@Column(name ="CONFIRM_USER",nullable=true,length=32)
	public java.lang.String getConfirmUser(){
		return this.confirmUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  confirmUser
	 */
	public void setConfirmUser(java.lang.String confirmUser){
		this.confirmUser = confirmUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark
	 */
	@Column(name ="REMARK",nullable=true,length=500)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
}
