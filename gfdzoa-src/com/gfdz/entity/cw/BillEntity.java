package com.gfdz.entity.cw;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSUser;

import com.gfdz.entity.hr.EducationFilesEntity;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 发票开具记录
 * @author ant
 * @date 2015-05-28 13:51:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_bill", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class BillEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户主键*/
	private TSUser userId;
	/**开具发票类型（父类：工程类(1)、其他类(3)、收据(2)）*/
	private java.lang.String ftype;
	/**开具发票类型（子类：那5种增值税等）*/
	private java.lang.String stype;
	/**客户单位名称*/
	private java.lang.String unit;
	/**开具金额*/
	private java.math.BigDecimal money;
	/**计划收款时间*/
	private java.util.Date planDate;
	/**申请时间*/
	private java.util.Date inputDate;
	/**开具发票内容*/
	private java.lang.String content;
	/**附件路径（针对增值税）*/
	private java.lang.String path;
	/**付款单位*/
	private java.lang.String payUnit;
	/**发票号*/
	private java.lang.String num;
	/**地税国税号*/
	private java.lang.String disgsh;
	/**纳税人识别号(针对增值税)*/
	private java.lang.String shibh;
	/**地址(针对增值税)*/
	private java.lang.String addr;
	/**电话(针对增值税)*/
	private java.lang.String phone;
	/**开户行(针对增值税)*/
	private java.lang.String kaihh;
	/**账号(针对增值税)*/
	private java.lang.String account;
	/**备注*/
	private java.lang.String remark;
	/**状态*/
	private java.lang.String state;
	/**作废原因*/
	private java.lang.String reason;
	
	private List<BillFilesEntity> billFiles;
	
	
	/**流程id*/
	private java.lang.String processinstanceid;
	
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
	 *@return: java.lang.String  用户主键
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="USER_ID")
	//(name ="USER_ID",nullable=false,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开具发票类型（父类：工程类(1)、其他类(3)、收据(2)）
	 */
	@Column(name ="FTYPE",nullable=true,length=32)
	public java.lang.String getFtype(){
		return this.ftype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开具发票类型（父类：工程类(1)、其他类(3)、收据(2)）
	 */
	public void setFtype(java.lang.String ftype){
		this.ftype = ftype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开具发票类型（子类：那5种增值税等）
	 */
	@Column(name ="STYPE",nullable=true,length=32)
	public java.lang.String getStype(){
		return this.stype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开具发票类型（子类：那5种增值税等）
	 */
	public void setStype(java.lang.String stype){
		this.stype = stype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户单位名称
	 */
	@Column(name ="UNIT",nullable=true,length=500)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户单位名称
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  开具金额
	 */
	@Column(name ="MONEY",nullable=true,precision=19,scale=2)
	public java.math.BigDecimal getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  开具金额
	 */
	public void setMoney(java.math.BigDecimal money){
		this.money = money;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计划收款时间
	 */
	@Column(name ="PLAN_DATE",nullable=true,scale=6)
	public java.util.Date getPlanDate(){
		return this.planDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计划收款时间
	 */
	public void setPlanDate(java.util.Date planDate){
		this.planDate = planDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="INPUT_DATE",nullable=true,scale=6)
	public java.util.Date getInputDate(){
		return this.inputDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setInputDate(java.util.Date inputDate){
		this.inputDate = inputDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开具发票内容
	 */
	@Column(name ="CONTENT",nullable=true,length=500)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开具发票内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件路径（针对增值税）
	 */
	@Column(name ="PATH",nullable=true,length=500)
	public java.lang.String getPath(){
		return this.path;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件路径（针对增值税）
	 */
	public void setPath(java.lang.String path){
		this.path = path;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款单位
	 */
	@Column(name ="PAY_UNIT",nullable=true,length=10)
	public java.lang.String getPayUnit(){
		return this.payUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款单位
	 */
	public void setPayUnit(java.lang.String payUnit){
		this.payUnit = payUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票号
	 */
	@Column(name ="NUM",nullable=true,length=200)
	public java.lang.String getNum(){
		return this.num;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票号
	 */
	public void setNum(java.lang.String num){
		this.num = num;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地税国税号
	 */
	@Column(name ="DISGSH",nullable=true,length=200)
	public java.lang.String getDisgsh(){
		return this.disgsh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地税国税号
	 */
	public void setDisgsh(java.lang.String disgsh){
		this.disgsh = disgsh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  纳税人识别号(针对增值税)
	 */
	@Column(name ="SHIBH",nullable=true,length=200)
	public java.lang.String getShibh(){
		return this.shibh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  纳税人识别号(针对增值税)
	 */
	public void setShibh(java.lang.String shibh){
		this.shibh = shibh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址(针对增值税)
	 */
	@Column(name ="ADDR",nullable=true,length=300)
	public java.lang.String getAddr(){
		return this.addr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址(针对增值税)
	 */
	public void setAddr(java.lang.String addr){
		this.addr = addr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话(针对增值税)
	 */
	@Column(name ="PHONE",nullable=true,length=100)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话(针对增值税)
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行(针对增值税)
	 */
	@Column(name ="KAIHH",nullable=true,length=300)
	public java.lang.String getKaihh(){
		return this.kaihh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行(针对增值税)
	 */
	public void setKaihh(java.lang.String kaihh){
		this.kaihh = kaihh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账号(针对增值税)
	 */
	@Column(name ="ACCOUNT",nullable=true,length=100)
	public java.lang.String getAccount(){
		return this.account;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账号(针对增值税)
	 */
	public void setAccount(java.lang.String account){
		this.account = account;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATE",nullable=true,length=10)
	public java.lang.String getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setState(java.lang.String state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作废原因
	 */
	@Column(name ="REASON",nullable=true,length=500)
	public java.lang.String getReason(){
		return this.reason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作废原因
	 */
	public void setReason(java.lang.String reason){
		this.reason = reason;
	}
	@OneToMany(mappedBy="bill",cascade={CascadeType.REMOVE})
	public List<BillFilesEntity> getBillFiles() {
		return billFiles;
	}

	public void setBillFiles(List<BillFilesEntity> billFiles) {
		this.billFiles = billFiles;
	}

	public java.lang.String getProcessinstanceid() {
		return processinstanceid;
	}

	public void setProcessinstanceid(java.lang.String processinstanceid) {
		this.processinstanceid = processinstanceid;
	}
	
	
}
