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
 * @Description: 个人离职表
 * @author ant
 * @date 2015-06-11 11:27:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_leave_office", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class LeaveOfficeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**人员id*/
	private java.lang.String personId;
	/**部门id*/
	private java.lang.String departId;
	/**申请时间*/
	private java.util.Date applyType;
	/**审核状态*/
	private java.lang.String state;
	/**离职原因*/
	private java.lang.String leaveReason;
	/**流程id*/
	private java.lang.String processId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,length=32)
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
	 *@return: java.lang.String  部门id
	 */
	@Column(name ="DEPART_ID",nullable=true,length=32)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门id
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="APPLY_TYPE",nullable=true)
	public java.util.Date getApplyType(){
		return this.applyType;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setApplyType(java.util.Date applyType){
		this.applyType = applyType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */
	@Column(name ="STATE",nullable=true,length=32)
	public java.lang.String getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setState(java.lang.String state){
		this.state = state;
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
	 *@return: java.lang.String  流程id
	 */
	@Column(name ="PROCESS_ID",nullable=true,length=32)
	public java.lang.String getProcessId(){
		return this.processId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程id
	 */
	public void setProcessId(java.lang.String processId){
		this.processId = processId;
	}
}
