package com.gfdz.entity.hr;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSUser;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 人员信息表
 * @author ant
 * @date 2015-06-11 11:20:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_person_info")
@PrimaryKeyJoinColumn(name = "id")
public class PersonInfoEntity extends TSUser implements java.io.Serializable {
	
	private static final long serialVersionUID = 2347067138832014243L;
	/**性别*/
	private java.lang.String sex;
	/**出生日期*/
	private java.util.Date birthday;
	/**籍贯*/
	private java.lang.String nativePlace;
	/**民族*/
	private java.lang.String nation;
	/**健康状况*/
	private java.lang.String health;
	/**学历*/
	private java.lang.String education;
	/**政治面貌*/
	private java.lang.String politics;
	/**婚否*/
	private java.lang.String ismarried;
	/**第二学历/专业*/
	private java.lang.String secondMajor;
	/**身份证号*/
	private java.lang.String idCard;
	/**毕业学校*/
	private java.lang.String shcool;
	/**专业*/
	private java.lang.String major;
	/**希望待遇*/
	private java.lang.String expectSalary;
	/**最低试用期工资*/
	private java.lang.String minSalary;
	/**现工作单位*/
	private java.lang.String nowUnit;
	/**现职业状况*/
	private java.lang.String workState;
	/**离职原因*/
	private java.lang.String leaveReason;
	/**可到岗日期*/
	private java.lang.String arrivalDate;
	/**家庭住址*/
	private java.lang.String homeAddr;
	/**家庭电话*/
	private java.lang.String homePhone;
	/**紧急联系人*/
	private java.lang.String contact;
	/**工作简历*/
	private java.lang.String jobId;
	/**家庭成员*/
	private java.lang.String familyId;
	/**人员状态*/
	private java.lang.String personState;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=32)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */
	@Column(name ="BIRTHDAY",nullable=true,scale=6)
	public java.util.Date getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */
	@Column(name ="NATIVE_PLACE",nullable=true,length=32)
	public java.lang.String getNativePlace(){
		return this.nativePlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  籍贯
	 */
	public void setNativePlace(java.lang.String nativePlace){
		this.nativePlace = nativePlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */
	@Column(name ="NATION",nullable=true,length=32)
	public java.lang.String getNation(){
		return this.nation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNation(java.lang.String nation){
		this.nation = nation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  健康状况
	 */
	@Column(name ="HEALTH",nullable=true,length=32)
	public java.lang.String getHealth(){
		return this.health;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  健康状况
	 */
	public void setHealth(java.lang.String health){
		this.health = health;
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
	 *@return: java.lang.String  政治面貌
	 */
	@Column(name ="POLITICS",nullable=true,length=32)
	public java.lang.String getPolitics(){
		return this.politics;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setPolitics(java.lang.String politics){
		this.politics = politics;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  婚否
	 */
	@Column(name ="ISMARRIED",nullable=true,length=32)
	public java.lang.String getIsmarried(){
		return this.ismarried;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚否
	 */
	public void setIsmarried(java.lang.String ismarried){
		this.ismarried = ismarried;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第二学历/专业
	 */
	@Column(name ="SECOND_MAJOR",nullable=true,length=32)
	public java.lang.String getSecondMajor(){
		return this.secondMajor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第二学历/专业
	 */
	public void setSecondMajor(java.lang.String secondMajor){
		this.secondMajor = secondMajor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="ID_CARD",nullable=true,length=32)
	public java.lang.String getIdCard(){
		return this.idCard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdCard(java.lang.String idCard){
		this.idCard = idCard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业学校
	 */
	@Column(name ="SHCOOL",nullable=true,length=32)
	public java.lang.String getShcool(){
		return this.shcool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业学校
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  希望待遇
	 */
	@Column(name ="EXPECT_SALARY",nullable=true,length=32)
	public java.lang.String getExpectSalary(){
		return this.expectSalary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  希望待遇
	 */
	public void setExpectSalary(java.lang.String expectSalary){
		this.expectSalary = expectSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最低试用期工资
	 */
	@Column(name ="MIN_SALARY",nullable=true,length=32)
	public java.lang.String getMinSalary(){
		return this.minSalary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最低试用期工资
	 */
	public void setMinSalary(java.lang.String minSalary){
		this.minSalary = minSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现工作单位
	 */
	@Column(name ="NOW_UNIT",nullable=true,length=32)
	public java.lang.String getNowUnit(){
		return this.nowUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现工作单位
	 */
	public void setNowUnit(java.lang.String nowUnit){
		this.nowUnit = nowUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现职业状况
	 */
	@Column(name ="WORK_STATE",nullable=true,length=32)
	public java.lang.String getWorkState(){
		return this.workState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现职业状况
	 */
	public void setWorkState(java.lang.String workState){
		this.workState = workState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  离职原因
	 */
	@Column(name ="LEAVE_REASON",nullable=true,length=32)
	public java.lang.String getLeaveReason(){
		return this.leaveReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  离职原因
	 */
	public void setLeaveReason(java.lang.String leaveReason){
		this.leaveReason = leaveReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  可到岗日期
	 */
	@Column(name ="ARRIVAL_DATE",nullable=true,length=32)
	public java.lang.String getArrivalDate(){
		return this.arrivalDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  可到岗日期
	 */
	public void setArrivalDate(java.lang.String arrivalDate){
		this.arrivalDate = arrivalDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭住址
	 */
	@Column(name ="HOME_ADDR",nullable=true,length=32)
	public java.lang.String getHomeAddr(){
		return this.homeAddr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭住址
	 */
	public void setHomeAddr(java.lang.String homeAddr){
		this.homeAddr = homeAddr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭电话
	 */
	@Column(name ="HOME_PHONE",nullable=true,length=32)
	public java.lang.String getHomePhone(){
		return this.homePhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭电话
	 */
	public void setHomePhone(java.lang.String homePhone){
		this.homePhone = homePhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系人
	 */
	@Column(name ="CONTACT",nullable=true,length=32)
	public java.lang.String getContact(){
		return this.contact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系人
	 */
	public void setContact(java.lang.String contact){
		this.contact = contact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作简历
	 */
	@Column(name ="JOB_ID",nullable=true,length=32)
	public java.lang.String getJobId(){
		return this.jobId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作简历
	 */
	public void setJobId(java.lang.String jobId){
		this.jobId = jobId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭成员
	 */
	@Column(name ="FAMILY_ID",nullable=true,length=32)
	public java.lang.String getFamilyId(){
		return this.familyId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭成员
	 */
	public void setFamilyId(java.lang.String familyId){
		this.familyId = familyId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人员状态
	 */
	@Column(name ="PERSON_STATE",nullable=true,length=32)
	public java.lang.String getPersonState(){
		return this.personState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员状态
	 */
	public void setPersonState(java.lang.String personState){
		this.personState = personState;
	}
}
