package com.gfdz.cw.entity;

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
 * @Description: 款项支付子表
 * @author ant
 * @date 2015-07-27 10:12:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_payforDetail", schema = "")
@SuppressWarnings("serial")
public class PayfordetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**材料*/
	@Excel(name="材料")
	private java.lang.String cp;
	/**采购执行子表*/
	@Excel(name="采购执行子表")
	private java.lang.String cgzx;
	/**材料数量 */
	@Excel(name="材料数量 ")
	private java.lang.Integer num;
	/**材料单价*/
	@Excel(name="材料单价")
	private java.lang.Double price;
	/**付款金额*/
	@Excel(name="付款金额")
	private java.lang.Double money;
	/**付款申请人*/
	@Excel(name="付款申请人")
	private java.lang.String userId;
	/**付款时间*/
	@Excel(name="付款时间")
	private java.util.Date odate;
	/**供应商*/
	@Excel(name="供应商")
	private java.lang.String gysml;
	/**款项支付主表*/
	@Excel(name="款项支付主表")
	private java.lang.String payfor;
	/**申请事由*/
	@Excel(name="申请事由")
	private java.lang.String applyreason;
	/**附件数量*/
	@Excel(name="附件数量")
	private java.lang.Integer fujnum;
	/**项目*/
	@Excel(name="项目")
	private java.lang.String project;
	
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
	 *@return: java.lang.String  材料
	 */
	@Column(name ="CP",nullable=true,length=32)
	public java.lang.String getCp(){
		return this.cp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料
	 */
	public void setCp(java.lang.String cp){
		this.cp = cp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购执行子表
	 */
	@Column(name ="CGZX",nullable=true,length=32)
	public java.lang.String getCgzx(){
		return this.cgzx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购执行子表
	 */
	public void setCgzx(java.lang.String cgzx){
		this.cgzx = cgzx;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  材料数量 
	 */
	@Column(name ="NUM",nullable=true,length=32)
	public java.lang.Integer getNum(){
		return this.num;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  材料数量 
	 */
	public void setNum(java.lang.Integer num){
		this.num = num;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  材料单价
	 */
	@Column(name ="PRICE",nullable=true,length=32)
	public java.lang.Double getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  材料单价
	 */
	public void setPrice(java.lang.Double price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  付款金额
	 */
	@Column(name ="MONEY",nullable=true,length=32)
	public java.lang.Double getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  付款金额
	 */
	public void setMoney(java.lang.Double money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款申请人
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款申请人
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  付款时间
	 */
	@Column(name ="ODATE",nullable=true,length=32)
	public java.util.Date getOdate(){
		return this.odate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  付款时间
	 */
	public void setOdate(java.util.Date odate){
		this.odate = odate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商
	 */
	@Column(name ="GYSML",nullable=true,length=32)
	public java.lang.String getGysml(){
		return this.gysml;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商
	 */
	public void setGysml(java.lang.String gysml){
		this.gysml = gysml;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  款项支付主表
	 */
	@Column(name ="PAYFOR",nullable=true,length=32)
	public java.lang.String getPayfor(){
		return this.payfor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  款项支付主表
	 */
	public void setPayfor(java.lang.String payfor){
		this.payfor = payfor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请事由
	 */
	@Column(name ="APPLYREASON",nullable=true,length=200)
	public java.lang.String getApplyreason(){
		return this.applyreason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请事由
	 */
	public void setApplyreason(java.lang.String applyreason){
		this.applyreason = applyreason;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  附件数量
	 */
	@Column(name ="FUJNUM",nullable=true,length=32)
	public java.lang.Integer getFujnum(){
		return this.fujnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  附件数量
	 */
	public void setFujnum(java.lang.Integer fujnum){
		this.fujnum = fujnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目
	 */
	@Column(name ="PROJECT",nullable=true,length=32)
	public java.lang.String getProject(){
		return this.project;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目
	 */
	public void setProject(java.lang.String project){
		this.project = project;
	}
}
