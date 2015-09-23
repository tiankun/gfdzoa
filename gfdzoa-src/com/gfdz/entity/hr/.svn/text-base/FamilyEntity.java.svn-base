package com.gfdz.entity.hr;

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
 * @Description: 人员家庭成员
 * @author ant
 * @date 2015-06-11 11:24:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "HR_FAMILY", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class FamilyEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**人员id*/
	private java.lang.String personId;
	/**称谓*/
	private java.lang.String appellation;
	/**姓名*/
	private java.lang.String name;
	/**工作单位*/
	private java.lang.String workUnit;
	/**联系方式*/
	private java.lang.String phone;
	/**部门*/
	private java.lang.String depar;
	/**职务*/
	private java.lang.String position;
	/**住址*/
	private java.lang.String addr;
	/**备注*/
	private java.lang.String remark;
	
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
	 *@return: java.lang.String  称谓
	 */
	@Column(name ="APPELLATION",nullable=true,length=32)
	public java.lang.String getAppellation(){
		return this.appellation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  称谓
	 */
	public void setAppellation(java.lang.String appellation){
		this.appellation = appellation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作单位
	 */
	@Column(name ="WORK_UNIT",nullable=true,length=255)
	public java.lang.String getWorkUnit(){
		return this.workUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作单位
	 */
	public void setWorkUnit(java.lang.String workUnit){
		this.workUnit = workUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系方式
	 */
	@Column(name ="PHONE",nullable=true,length=32)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系方式
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门
	 */
	@Column(name ="DEPAR",nullable=true,length=255)
	public java.lang.String getDepar(){
		return this.depar;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门
	 */
	public void setDepar(java.lang.String depar){
		this.depar = depar;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职务
	 */
	@Column(name ="POSITION",nullable=true,length=32)
	public java.lang.String getPosition(){
		return this.position;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职务
	 */
	public void setPosition(java.lang.String position){
		this.position = position;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住址
	 */
	@Column(name ="ADDR",nullable=true,length=255)
	public java.lang.String getAddr(){
		return this.addr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住址
	 */
	public void setAddr(java.lang.String addr){
		this.addr = addr;
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
}
