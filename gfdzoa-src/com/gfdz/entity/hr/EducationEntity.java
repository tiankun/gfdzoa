package com.gfdz.entity.hr;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 个人学历信息
 * @author ant
 * @date 2015-06-11 11:28:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_education", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class EducationEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**人员id*/
	private java.lang.String personId;
	/**学历*/
	private java.lang.String education;
	/**学校*/
	private java.lang.String shcool;
	/**专业*/
	private java.lang.String major;
	/**开始时间*/
	private java.util.Date beginDate;
	/**结束时间*/
	private java.util.Date endDate;
	/**学历类型*/
	private java.lang.String eduType;
	/**毕业/结业*/
	private java.lang.String isgradua;
	/**证件照*/
	private java.lang.String cardPic;
	/**学位*/
	private java.lang.String degree;
	/**证书编号*/
	private java.lang.String certificateNo;
	/**备注*/
	private java.lang.String remark;
	
	private List<EducationFilesEntity> educationFiles;
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
	 *@return: java.lang.String  学历
	 */
	@Column(name ="EDUCATION",nullable=true,length=32)
	public java.lang.String getEducation(){
		return this.education;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEducation(java.lang.String education){
		this.education = education;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校
	 */
	@Column(name ="SHCOOL",nullable=true,length=32)
	public java.lang.String getShcool(){
		return this.shcool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校
	 */
	public void setShcool(java.lang.String shcool){
		this.shcool = shcool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */
	@Column(name ="MAJOR",nullable=true,length=32)
	public java.lang.String getMajor(){
		return this.major;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setMajor(java.lang.String major){
		this.major = major;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历类型
	 */
	@Column(name ="EDU_TYPE",nullable=true,length=32)
	public java.lang.String getEduType(){
		return this.eduType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历类型
	 */
	public void setEduType(java.lang.String eduType){
		this.eduType = eduType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业/结业
	 */
	@Column(name ="ISGRADUA",nullable=true,length=32)
	public java.lang.String getIsgradua(){
		return this.isgradua;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业/结业
	 */
	public void setIsgradua(java.lang.String isgradua){
		this.isgradua = isgradua;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件照
	 */
	@Column(name ="CARD_PIC",nullable=true,length=32)
	public java.lang.String getCardPic(){
		return this.cardPic;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件照
	 */
	public void setCardPic(java.lang.String cardPic){
		this.cardPic = cardPic;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学位
	 */
	@Column(name ="DEGREE",nullable=true,length=32)
	public java.lang.String getDegree(){
		return this.degree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学位
	 */
	public void setDegree(java.lang.String degree){
		this.degree = degree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书编号
	 */
	@Column(name ="CERTIFICATE_NO",nullable=true,length=32)
	public java.lang.String getCertificateNo(){
		return this.certificateNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书编号
	 */
	public void setCertificateNo(java.lang.String certificateNo){
		this.certificateNo = certificateNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=32)
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
	
	
	@OneToMany(mappedBy="education",cascade={CascadeType.REMOVE})
	public List<EducationFilesEntity> getEducationFiles() {
		return educationFiles;
	}

	public void setEducationFiles(List<EducationFilesEntity> educationFiles) {
		this.educationFiles = educationFiles;
	}
	
	
}
