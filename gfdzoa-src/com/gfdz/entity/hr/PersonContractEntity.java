package com.gfdz.entity.hr;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 个人合同信息
 * @author ant
 * @date 2015-06-11 11:27:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_person_contract", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PersonContractEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**人员id*/
	private java.lang.String personId;
	/**合同编号*/
	private java.lang.String contractNo;
	/**合同类型*/
	private java.lang.String contractType;
	/**签订方式*/
	private java.lang.String signedType;
	/**签订日期*/
	private java.util.Date signedDate;
	/**开始时间*/
	private java.util.Date beginDate;
	/**结束时间*/
	private java.util.Date endDate;
	/**试用期开始时间*/
	private java.util.Date syBedinDate;
	/**试用期结束时间*/
	private java.util.Date syEndDate;
	/**合同解除/终止时间*/
	private java.util.Date overContractDate;
	/**补偿金额*/
	private java.lang.Integer compensation;
	/**违约金额*/
	private java.lang.Integer breach;
	/**附件*/
	private java.lang.String contractFiles;
	/**备注*/
	private java.lang.String remark;
	
	private List<PersonContractFilesEntity> personContractFiles;
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
	 *@return: java.lang.String  人员id
	 */
	@Column(name ="PERSON_ID",nullable=true,length=32)
	public java.lang.String getPersonId(){
		return this.personId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员id
	 */
	public void setPersonId(java.lang.String personId){
		this.personId = personId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号
	 */
	@Column(name ="CONTRACT_NO",nullable=true,length=32)
	public java.lang.String getContractNo(){
		return this.contractNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同编号
	 */
	public void setContractNo(java.lang.String contractNo){
		this.contractNo = contractNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同类型
	 */
	@Column(name ="CONTRACT_TYPE",nullable=true,length=32)
	public java.lang.String getContractType(){
		return this.contractType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同类型
	 */
	public void setContractType(java.lang.String contractType){
		this.contractType = contractType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签订方式
	 */
	@Column(name ="SIGNED_TYPE",nullable=true,length=32)
	public java.lang.String getSignedType(){
		return this.signedType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签订方式
	 */
	public void setSignedType(java.lang.String signedType){
		this.signedType = signedType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签订日期
	 */
	@Column(name ="SIGNED_DATE",nullable=true)
	public java.util.Date getSignedDate(){
		return this.signedDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签订日期
	 */
	public void setSignedDate(java.util.Date signedDate){
		this.signedDate = signedDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="BEGIN_DATE",nullable=true)
	public java.util.Date getBeginDate(){
		return this.beginDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setBeginDate(java.util.Date beginDate){
		this.beginDate = beginDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="END_DATE",nullable=true)
	public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  试用期开始时间
	 */
	@Column(name ="SY_BEDIN_DATE",nullable=true)
	public java.util.Date getSyBedinDate(){
		return this.syBedinDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  试用期开始时间
	 */
	public void setSyBedinDate(java.util.Date syBedinDate){
		this.syBedinDate = syBedinDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  试用期结束时间
	 */
	@Column(name ="SY_END_DATE",nullable=true)
	public java.util.Date getSyEndDate(){
		return this.syEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  试用期结束时间
	 */
	public void setSyEndDate(java.util.Date syEndDate){
		this.syEndDate = syEndDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  合同解除/终止时间
	 */
	@Column(name ="OVER_CONTRACT_DATE",nullable=true)
	public java.util.Date getOverContractDate(){
		return this.overContractDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  合同解除/终止时间
	 */
	public void setOverContractDate(java.util.Date overContractDate){
		this.overContractDate = overContractDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  补偿金额
	 */
	@Column(name ="COMPENSATION",nullable=true)
	public java.lang.Integer getCompensation(){
		return this.compensation;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  补偿金额
	 */
	public void setCompensation(java.lang.Integer compensation){
		this.compensation = compensation;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  违约金额
	 */
	@Column(name ="BREACH",nullable=true)
	public java.lang.Integer getBreach(){
		return this.breach;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  违约金额
	 */
	public void setBreach(java.lang.Integer breach){
		this.breach = breach;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	@Column(name ="CONTRACT_FILES",nullable=true,length=32)
	public java.lang.String getContractFiles(){
		return this.contractFiles;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setContractFiles(java.lang.String contractFiles){
		this.contractFiles = contractFiles;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=255)
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
	
	
	@OneToMany(mappedBy="personContract",cascade={CascadeType.REMOVE})
	public List<PersonContractFilesEntity> getPersonContractFiles() {
		return personContractFiles;
	}

	public void setPersonContractFiles(
			List<PersonContractFilesEntity> personContractFiles) {
		this.personContractFiles = personContractFiles;
	}
	
	
}
