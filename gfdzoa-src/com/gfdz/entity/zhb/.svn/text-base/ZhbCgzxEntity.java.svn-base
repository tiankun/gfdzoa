package com.gfdz.entity.zhb;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 执行材料明细
 * @author ant
 * @date 2015-07-16 16:36:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_cgzx", schema = "")
@SuppressWarnings("serial")
public class ZhbCgzxEntity implements java.io.Serializable {
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
	/**采购申请单主键*/
	@Excel(name="采购执行单主键")
	private java.lang.String cgzxId;
	/**采购数量*/
	@Excel(name="采购数量")
	private java.math.BigDecimal buyAmount;
	/**采购单价*/
	@Excel(name="采购单价")
	private java.math.BigDecimal buyPrice;
	/**付款商家*/
	@Excel(name="付款商家")
	private java.lang.String merchant;
	/**付款金额*/
	@Excel(name="付款金额")
	private java.math.BigDecimal payAmount;
	/**付款方式*/
	@Excel(name="付款方式")
	private java.lang.String payType;
	/**付款时间*/
	@Excel(name="付款时间")
	private java.lang.String payTime;
	/**付款说明*/
	@Excel(name="付款说明")
	private java.lang.String payExplain;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	/**状态*/
	@Excel(name="状态")
	private java.math.BigDecimal flag;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
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
	@Column(name ="CREATE_NAME",nullable=true,length=50)
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
	@Column(name ="CREATE_BY",nullable=true,length=50)
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
	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
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
	@Column(name ="UPDATE_BY",nullable=true,length=50)
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
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	 *@return: java.lang.String  采购申请单主键
	 */
	@Column(name ="CGZX_ID",nullable=true,length=36)
	public java.lang.String getCgzxId(){
		return this.cgzxId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购申请单主键
	 */
	public void setCgzxId(java.lang.String cgzxId){
		this.cgzxId = cgzxId;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  采购数量
	 */
	@Column(name ="BUY_AMOUNT",nullable=true,length=32)
	public java.math.BigDecimal getBuyAmount(){
		return this.buyAmount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  采购数量
	 */
	public void setBuyAmount(java.math.BigDecimal buyAmount){
		this.buyAmount = buyAmount;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  采购单价
	 */
	@Column(name ="BUY_PRICE",nullable=true,length=32)
	public java.math.BigDecimal getBuyPrice(){
		return this.buyPrice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  采购单价
	 */
	public void setBuyPrice(java.math.BigDecimal buyPrice){
		this.buyPrice = buyPrice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款商家
	 */
	@Column(name ="MERCHANT",nullable=true,length=32)
	public java.lang.String getMerchant(){
		return this.merchant;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款商家
	 */
	public void setMerchant(java.lang.String merchant){
		this.merchant = merchant;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  付款金额
	 */
	@Column(name ="PAY_AMOUNT",nullable=true,length=32)
	public java.math.BigDecimal getPayAmount(){
		return this.payAmount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  付款金额
	 */
	public void setPayAmount(java.math.BigDecimal payAmount){
		this.payAmount = payAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款方式
	 */
	@Column(name ="PAY_TYPE",nullable=true,length=32)
	public java.lang.String getPayType(){
		return this.payType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款方式
	 */
	public void setPayType(java.lang.String payType){
		this.payType = payType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款时间
	 */
	@Column(name ="PAY_TIME",nullable=true,length=32)
	public java.lang.String getPayTime(){
		return this.payTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款时间
	 */
	public void setPayTime(java.lang.String payTime){
		this.payTime = payTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款说明
	 */
	@Column(name ="PAY_EXPLAIN",nullable=true,length=4000)
	public java.lang.String getPayExplain(){
		return this.payExplain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款说明
	 */
	public void setPayExplain(java.lang.String payExplain){
		this.payExplain = payExplain;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=4000)
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
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  状态
	 */
	@Column(name ="FLAG",nullable=true,length=32)
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
}
