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
 * @Description: 暂支还款表
 * @author ant
 * @date 2015-05-28 13:50:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_advance_back", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class AdvanceBackEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**暂支单主键*/
	private java.lang.String advanceId;
	/**归还金额*/
	private java.math.BigDecimal backedMoney;
	/**归还时间*/
	private java.util.Date backDate;
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
	 *@return: java.lang.String  暂支单主键
	 */
	@Column(name ="ADVANCE_ID",nullable=false,length=32)
	public java.lang.String getAdvanceId(){
		return this.advanceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  暂支单主键
	 */
	public void setAdvanceId(java.lang.String advanceId){
		this.advanceId = advanceId;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  归还金额
	 */
	@Column(name ="BACKED_MONEY",nullable=false,precision=19,scale=2)
	public java.math.BigDecimal getBackedMoney(){
		return this.backedMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  归还金额
	 */
	public void setBackedMoney(java.math.BigDecimal backedMoney){
		this.backedMoney = backedMoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  归还时间
	 */
	@Column(name ="BACK_DATE",nullable=false)
	public java.util.Date getBackDate(){
		return this.backDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  归还时间
	 */
	public void setBackDate(java.util.Date backDate){
		this.backDate = backDate;
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
