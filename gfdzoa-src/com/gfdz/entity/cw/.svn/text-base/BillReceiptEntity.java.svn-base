package com.gfdz.entity.cw;

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
 * @Description: 发票收款记录
 * @author ant
 * @date 2015-05-28 13:51:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_bill_receipt", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class BillReceiptEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**发票主键*/
	private java.lang.String billId;
	/**收款金额*/
	private java.math.BigDecimal money;
	/**收款日期*/
	private java.util.Date rdate;
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
	 *@return: java.lang.String  发票主键
	 */
	@Column(name ="BILL_ID",nullable=false,length=32)
	public java.lang.String getBillId(){
		return this.billId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票主键
	 */
	public void setBillId(java.lang.String billId){
		this.billId = billId;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  收款金额
	 */
	@Column(name ="MONEY",nullable=false,precision=19,scale=2)
	public java.math.BigDecimal getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  收款金额
	 */
	public void setMoney(java.math.BigDecimal money){
		this.money = money;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收款日期
	 */
	@Column(name ="RDATE",nullable=false)
	public java.util.Date getRdate(){
		return this.rdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收款日期
	 */
	public void setRdate(java.util.Date rdate){
		this.rdate = rdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=200)
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
