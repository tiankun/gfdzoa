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
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 考勤记录
 * @author ant
 * @date 2015-05-28 11:14:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_attendance", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class AttendanceEntity implements java.io.Serializable {
	/**id*/
	
	private java.lang.String id;
	/**用户名称*/
	@Excel(name="姓名" )
	private java.lang.String username;
	/**部门*/
	@Excel(name="部门")
	private java.lang.String depart;
	/**考勤日期*/
	@Excel(name="日期")
	private java.lang.String attendanceDate;
	/**上午考勤*/
	@Excel(name="签到时间")
	private java.lang.String attendanceAm;
	/**下午考勤*/
	@Excel(name="签退时间")
	private java.lang.String attendancePm;
	
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
	 *@return: java.lang.String  用户名称
	 */
	@Column(name ="USERNAME",nullable=true,length=32)
	public java.lang.String getUsername(){
		return this.username;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名称
	 */
	public void setUsername(java.lang.String username){
		this.username = username;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  部门
	 */
	@Column(name ="DEPART",nullable=true,scale=6)
	public java.lang.String getDepart(){
		return this.depart;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  部门
	 */
	public void setDepart(java.lang.String depart){
		this.depart = depart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考勤日期
	 */
	@Column(name ="ATTENDANCE_DATE",nullable=true,length=32)
	public java.lang.String getAttendanceDate(){
		return this.attendanceDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考勤日期
	 */
	public void setAttendanceDate(java.lang.String attendanceDate){
		this.attendanceDate = attendanceDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上午考勤
	 */
	@Column(name ="ATTENDANCE_AM",nullable=true,length=32)
	public java.lang.String getAttendanceAm(){
		return this.attendanceAm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上午考勤
	 */
	public void setAttendanceAm(java.lang.String attendanceAm){
		this.attendanceAm = attendanceAm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下午考勤
	 */
	@Column(name ="ATTENDANCE_PM",nullable=true,length=32)
	public java.lang.String getAttendancePm(){
		return this.attendancePm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下午考勤
	 */
	public void setAttendancePm(java.lang.String attendancePm){
		this.attendancePm = attendancePm;
	}
}
