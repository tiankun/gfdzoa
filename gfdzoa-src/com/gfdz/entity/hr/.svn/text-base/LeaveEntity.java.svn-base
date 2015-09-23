package com.gfdz.entity.hr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSUser;

/**   
 * @Title: Entity
 * @Description: 请假管理
 * @author ant
 * @date 2015-06-18 09:23:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_leave", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class LeaveEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**请假类型*/
	private LeaveTypeEntity leaveType;
	/**请假人*/
	private TSUser leaveUser;
	/**开始时间*/
	private java.util.Date beginDate;
	/**开始区间*/
	private java.lang.String beginScope;
	/**结束时间*/
	private java.util.Date endDate;
	/**结束区间*/
	private java.lang.String endScope;
	/**请假原因*/
	private java.lang.String leaveReason;
	/**请假天数*/
	private double leaveDays;
	/**流程id*/
	private java.lang.String processinstanceid;
	
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
	 *@return: java.lang.String  请假类型
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="LEAVE_TYPE")
	public LeaveTypeEntity getLeaveType(){
		return this.leaveType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请假类型
	 */
	public void setLeaveType(LeaveTypeEntity leaveType){
		this.leaveType = leaveType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  请假人
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="LEAVE_USER")
	public TSUser getLeaveUser(){
		return this.leaveUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请假人
	 */
	public void setLeaveUser(TSUser leaveUser){
		this.leaveUser = leaveUser;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="BEGIN_DATE",nullable=true,scale=6)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开始区间
	 */
	@Column(name ="BEGIN_SCOPE",nullable=true,length=1)
	public java.lang.String getBeginScope(){
		return this.beginScope;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开始区间
	 */
	public void setBeginScope(java.lang.String beginScope){
		this.beginScope = beginScope;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="END_DATE",nullable=true,scale=6)
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
	 *@return: java.lang.String  结束区间
	 */
	@Column(name ="END_SCOPE",nullable=true,length=1)
	public java.lang.String getEndScope(){
		return this.endScope;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结束区间
	 */
	public void setEndScope(java.lang.String endScope){
		this.endScope = endScope;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  请假原因
	 */
	@Column(name ="LEAVE_REASON",nullable=true,length=255)
	public java.lang.String getLeaveReason(){
		return this.leaveReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请假原因
	 */
	public void setLeaveReason(java.lang.String leaveReason){
		this.leaveReason = leaveReason;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  请假天数
	 */
	@Column(name ="LEAVE_DAYS",nullable=true,precision=10,scale=2)
	public double getLeaveDays(){
		return this.leaveDays;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  请假天数
	 */
	public void setLeaveDays(double leaveDays){
		this.leaveDays = leaveDays;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程id
	 */
	@Column(name ="PROCESSINSTANCEID",nullable=true,length=32)
	public java.lang.String getProcessinstanceid(){
		return this.processinstanceid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程id
	 */
	public void setProcessinstanceid(java.lang.String processinstanceid){
		this.processinstanceid = processinstanceid;
	}
}
