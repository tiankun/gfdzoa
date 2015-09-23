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
import org.jeecgframework.core.common.model.json.ProjectInfo;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;

import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.hr.TravelPathEntity;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 财务报账主表
 * @author ant
 * @date 2015-05-28 13:52:47
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_reimburse", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ReimburseEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**申请人ID*/
	private TSUser userId;
	/**项目ID*/
	private ProjectInfoEntity projectId;
	/**申请时间*/
	private java.util.Date applyDate;
	/**申请金额*/
	private java.math.BigDecimal applyMoney;
	/**审定金额*/
	private java.math.BigDecimal validationMoney;
	/**支付方式*/
	private java.lang.String advanceType;
	/**收款单位*/
	private java.lang.String skdw;
	/**付款单位*/
	private java.lang.String fukuanUnit;
	/**备注*/
	private java.lang.String remark;
	/**打印时间*/
	private java.util.Date print;
	/**作废时间*/
	private java.util.Date zfTime;
	/**作废人*/
	private java.lang.String zfPerson;
	/**作废原因*/
	private java.lang.String zfReason;
	
	private String processinstanceid;
	
	/**财务报账明细*/
	private List<ReimburseDetailEntity> reimburseDetail;
	/**大写申请金额*/
	private java.lang.String upperChn;
	/**部门*/
	private TSDepart  depart;
	
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
	 *@return: java.lang.String  申请人ID
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="USER_ID")
	//@Column(name ="USER_ID",nullable=false,length=32)
	public TSUser getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人ID
	 */
	public void setUserId(TSUser userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目ID
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="PROJECT_ID")
	//@Column(name ="PROJECT_ID",nullable=true,length=32)
	public ProjectInfoEntity getProjectId(){
		return this.projectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目ID
	 */
	public void setProjectId(ProjectInfoEntity projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="APPLY_DATE",nullable=false,scale=6)
	public java.util.Date getApplyDate(){
		return this.applyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setApplyDate(java.util.Date applyDate){
		this.applyDate = applyDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  申请金额
	 */
	@Column(name ="APPLY_MONEY",nullable=false,precision=19,scale=2)
	public java.math.BigDecimal getApplyMoney(){
		return this.applyMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  申请金额
	 */
	public void setApplyMoney(java.math.BigDecimal applyMoney){
		this.applyMoney = applyMoney;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  审定金额
	 */
	@Column(name ="VALIDATION_MONEY",nullable=true,precision=19,scale=2)
	public java.math.BigDecimal getValidationMoney(){
		return this.validationMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  审定金额
	 */
	public void setValidationMoney(java.math.BigDecimal validationMoney){
		this.validationMoney = validationMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付方式
	 */
	@Column(name ="ADVANCE_TYPE",nullable=true,length=32)
	public java.lang.String getAdvanceType(){
		return this.advanceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付方式
	 */
	public void setAdvanceType(java.lang.String advanceType){
		this.advanceType = advanceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款单位
	 */
	@Column(name ="SKDW",nullable=true,length=500)
	public java.lang.String getSkdw(){
		return this.skdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款单位
	 */
	public void setSkdw(java.lang.String skdw){
		this.skdw = skdw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款单位
	 */
	@Column(name ="FUKUAN_UNIT",nullable=true,length=10)
	public java.lang.String getFukuanUnit(){
		return this.fukuanUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款单位
	 */
	public void setFukuanUnit(java.lang.String fukuanUnit){
		this.fukuanUnit = fukuanUnit;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  打印时间
	 */
	@Column(name ="PRINT",nullable=true)
	public java.util.Date getPrint(){
		return this.print;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  打印时间
	 */
	public void setPrint(java.util.Date print){
		this.print = print;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  作废时间
	 */
	@Column(name ="ZF_TIME",nullable=true)
	public java.util.Date getZfTime(){
		return this.zfTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  作废时间
	 */
	public void setZfTime(java.util.Date zfTime){
		this.zfTime = zfTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作废人
	 */
	@Column(name ="ZF_PERSON",nullable=true,length=32)
	public java.lang.String getZfPerson(){
		return this.zfPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作废人
	 */
	public void setZfPerson(java.lang.String zfPerson){
		this.zfPerson = zfPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作废原因
	 */
	@Column(name ="ZF_REASON",nullable=true,length=300)
	public java.lang.String getZfReason(){
		return this.zfReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作废原因
	 */
	public void setZfReason(java.lang.String zfReason){
		this.zfReason = zfReason;
	}
	
	@Column(name ="PROCESSINSTANCEID",nullable=true,length=300)
	public String getProcessinstanceid() {
		return processinstanceid;
	}

	public void setProcessinstanceid(String processinstanceid) {
		this.processinstanceid = processinstanceid;
	}
	@OneToMany(mappedBy="reimburse",cascade={CascadeType.ALL})
	public List<ReimburseDetailEntity> getReimburseDetail() {
		return reimburseDetail;
	}

	public void setReimburseDetail(List<ReimburseDetailEntity> reimburseDetail) {
		this.reimburseDetail = reimburseDetail;
	}
	@Column(name ="UPPER_CHN")
	public java.lang.String getUpperChn() {
		return upperChn;
	}

	public void setUpperChn(java.lang.String upperChn) {
		this.upperChn = upperChn;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="DEPART")
	public TSDepart getDepart() {
		return depart;
	}
	
	
	public void setDepart(TSDepart depart) {
		this.depart = depart;
	}
	
	
	
	
	
	
	
}
