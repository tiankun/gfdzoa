package com.gfdz.entity.cw;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;

/**   
 * @Title: Entity
 * @Description: 暂支表
 * @author ant
 * @date 2015-05-28 13:50:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_advance", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class AdvanceEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户主键*/
	private TSUser userId;
	/**申请时间*/
	private java.util.Date applyTime;
	/**申请金额*/
	private Double applyMoney;
	/**借支类型*/
	private java.lang.String advanceType;
	/**申请原因*/
	private java.lang.String applyReason;
	/**收款单位ID*/
	private java.lang.String payeeid;
	/**收款单位*/
	private java.lang.String payeename;
	/**付款单位(km,kj)*/
	private java.lang.String fukuanUnit;
	/**部门*/
	private TSDepart  depart;
	
	private String billCode;
	

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
	 *方法: 取得TSUser
	 *@return: TSUser  用户主键
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="USER_ID")
	public TSUser getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户主键
	 */
	
	public void setUserId(TSUser userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="APPLY_TIME",nullable=true,scale=6)
	public java.util.Date getApplyTime(){
		return this.applyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setApplyTime(java.util.Date applyTime){
		this.applyTime = applyTime;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  申请金额
	 */
	@Column(name ="APPLY_MONEY",nullable=true,precision=19,scale=2)
	public Double getApplyMoney(){
		return this.applyMoney;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  申请金额
	 */
	public void setApplyMoney(Double applyMoney){
		this.applyMoney = applyMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  借支类型
	 */
	@Column(name ="ADVANCE_TYPE",nullable=true,length=32)
	public java.lang.String getAdvanceType(){
		return this.advanceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借支类型
	 */
	public void setAdvanceType(java.lang.String advanceType){
		this.advanceType = advanceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请原因
	 */
	@Column(name ="APPLY_REASON",nullable=true,length=32)
	public java.lang.String getApplyReason(){
		return this.applyReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请原因
	 */
	public void setApplyReason(java.lang.String applyReason){
		this.applyReason = applyReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款单位ID
	 */
	@Column(name ="PAYEEID",nullable=true,length=32)
	public java.lang.String getPayeeid(){
		return this.payeeid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款单位ID
	 */
	public void setPayeeid(java.lang.String payeeid){
		this.payeeid = payeeid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款单位
	 */
	@Column(name ="PAYEENAME",nullable=true,length=300)
	public java.lang.String getPayeename(){
		return this.payeename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款单位
	 */
	public void setPayeename(java.lang.String payeename){
		this.payeename = payeename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款单位(km,kj)
	 */
	@Column(name ="FUKUAN_UNIT",nullable=true,length=10)
	public java.lang.String getFukuanUnit(){
		return this.fukuanUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款单位(km,kj)
	 */
	public void setFukuanUnit(java.lang.String fukuanUnit){
		this.fukuanUnit = fukuanUnit;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="DEPART_ID")
	public TSDepart getDepart() {
		return depart;
	}

	public void setDepart(TSDepart depart) {
		this.depart = depart;
	}
	
	
	@Column(name ="BILLCODE")
	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
}
