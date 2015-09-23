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
 * @Description: 人事变动信息
 * @author ant
 * @date 2015-06-11 11:29:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_person_change", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PersonChangeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**人员id*/
	private java.lang.String personId;
	/**变动前单位*/
	private java.lang.String beforeUnit;
	/**变动前部门*/
	private java.lang.String beforeDepart;
	/**变动前岗位*/
	private java.lang.String beforeJob;
	/**变动前行政级别*/
	private java.lang.String beforeLevel;
	/**变动后单位*/
	private java.lang.String afterUnir;
	/**变动后部门*/
	private java.lang.String afterDepart;
	/**变动后岗位*/
	private java.lang.String afterJob;
	/**变动后行政级别*/
	private java.lang.String afterLevel;
	/**变动类型*/
	private java.lang.String changeType;
	/**变动日期*/
	private java.util.Date changeDate;
	/**附件*/
	private java.lang.String changeFiles;
	/**说明*/
	private java.lang.String explain;
	/**变动前状态*/
	private java.lang.String beforeState;
	/**变动后状态*/
	private java.lang.String afterState;
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
	 *@return: java.lang.String  变动前单位
	 */
	@Column(name ="BEFORE_UNIT",nullable=true,length=32)
	public java.lang.String getBeforeUnit(){
		return this.beforeUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动前单位
	 */
	public void setBeforeUnit(java.lang.String beforeUnit){
		this.beforeUnit = beforeUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动前部门
	 */
	@Column(name ="BEFORE_DEPART",nullable=true,length=32)
	public java.lang.String getBeforeDepart(){
		return this.beforeDepart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动前部门
	 */
	public void setBeforeDepart(java.lang.String beforeDepart){
		this.beforeDepart = beforeDepart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动前岗位
	 */
	@Column(name ="BEFORE_JOB",nullable=true,length=32)
	public java.lang.String getBeforeJob(){
		return this.beforeJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动前岗位
	 */
	public void setBeforeJob(java.lang.String beforeJob){
		this.beforeJob = beforeJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动前行政级别
	 */
	@Column(name ="BEFORE_LEVEL",nullable=true,length=32)
	public java.lang.String getBeforeLevel(){
		return this.beforeLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动前行政级别
	 */
	public void setBeforeLevel(java.lang.String beforeLevel){
		this.beforeLevel = beforeLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动后单位
	 */
	@Column(name ="AFTER_UNIR",nullable=true,length=32)
	public java.lang.String getAfterUnir(){
		return this.afterUnir;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动后单位
	 */
	public void setAfterUnir(java.lang.String afterUnir){
		this.afterUnir = afterUnir;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动后部门
	 */
	@Column(name ="AFTER_DEPART",nullable=true,length=32)
	public java.lang.String getAfterDepart(){
		return this.afterDepart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动后部门
	 */
	public void setAfterDepart(java.lang.String afterDepart){
		this.afterDepart = afterDepart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动后岗位
	 */
	@Column(name ="AFTER_JOB",nullable=true,length=32)
	public java.lang.String getAfterJob(){
		return this.afterJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动后岗位
	 */
	public void setAfterJob(java.lang.String afterJob){
		this.afterJob = afterJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动后行政级别
	 */
	@Column(name ="AFTER_LEVEL",nullable=true,length=32)
	public java.lang.String getAfterLevel(){
		return this.afterLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动后行政级别
	 */
	public void setAfterLevel(java.lang.String afterLevel){
		this.afterLevel = afterLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动类型
	 */
	@Column(name ="CHANGE_TYPE",nullable=true,length=32)
	public java.lang.String getChangeType(){
		return this.changeType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动类型
	 */
	public void setChangeType(java.lang.String changeType){
		this.changeType = changeType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  变动日期
	 */
	@Column(name ="CHANGE_DATE",nullable=true,scale=6)
	public java.util.Date getChangeDate(){
		return this.changeDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  变动日期
	 */
	public void setChangeDate(java.util.Date changeDate){
		this.changeDate = changeDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	@Column(name ="CHANGE_FILES",nullable=true,length=32)
	public java.lang.String getChangeFiles(){
		return this.changeFiles;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setChangeFiles(java.lang.String changeFiles){
		this.changeFiles = changeFiles;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  说明
	 */
	@Column(name ="EXPLAIN",nullable=true,length=255)
	public java.lang.String getExplain(){
		return this.explain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  说明
	 */
	public void setExplain(java.lang.String explain){
		this.explain = explain;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动前状态
	 */
	@Column(name ="BEFORE_STATE",nullable=true,length=32)
	public java.lang.String getBeforeState(){
		return this.beforeState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动前状态
	 */
	public void setBeforeState(java.lang.String beforeState){
		this.beforeState = beforeState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动后状态
	 */
	@Column(name ="AFTER_STATE",nullable=true,length=32)
	public java.lang.String getAfterState(){
		return this.afterState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动后状态
	 */
	public void setAfterState(java.lang.String afterState){
		this.afterState = afterState;
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
