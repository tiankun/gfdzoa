package com.gfdz.entity.cw;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 财务报账明细
 * @author ant
 * @date 2015-05-28 13:53:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_reimburse_detail", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ReimburseDetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**报账主表id*/
	private ReimburseEntity reimburse;
	/**类型*/
	private java.lang.String paytype;
	/**其他类型说明*/
	private java.lang.String other;
	/**支付金额*/
	private java.math.BigDecimal paymoney;
	/**单据数*/
	private java.lang.Integer documentsnum;
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
	 *@return: java.lang.String  报账主表id
	 */
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */
	@Column(name ="PAYTYPE",nullable=false,length=32)
	public java.lang.String getPaytype(){
		return this.paytype;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="REIMBURSE_ID")
	public ReimburseEntity getReimburse() {
		return reimburse;
	}

	public void setReimburse(ReimburseEntity reimburse) {
		this.reimburse = reimburse;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setPaytype(java.lang.String paytype){
		this.paytype = paytype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他类型说明
	 */
	@Column(name ="OTHER",nullable=true,length=200)
	public java.lang.String getOther(){
		return this.other;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他类型说明
	 */
	public void setOther(java.lang.String other){
		this.other = other;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  支付金额
	 */
	@Column(name ="PAYMONEY",nullable=false,precision=19,scale=2)
	public java.math.BigDecimal getPaymoney(){
		return this.paymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  支付金额
	 */
	public void setPaymoney(java.math.BigDecimal paymoney){
		this.paymoney = paymoney;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  单据数
	 */
	@Column(name ="DOCUMENTSNUM",nullable=false)
	public java.lang.Integer getDocumentsnum(){
		return this.documentsnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  单据数
	 */
	public void setDocumentsnum(java.lang.Integer documentsnum){
		this.documentsnum = documentsnum;
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
