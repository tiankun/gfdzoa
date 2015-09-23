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
 * @Description: 工作总结
 * @author ant
 * @date 2015-05-28 11:08:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_work_summary", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class WorkSummaryEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**提交日期*/
	private java.util.Date summaryDate;
	/**周数*/
	private java.lang.Integer summaryWeeks;
	/**总结内容*/
	private java.lang.String summaryNote;
	/**用户*/
	private java.lang.String summaryUser;
	/**查看次数*/
	private java.lang.String summaryNum;
	
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  提交日期
	 */
	@Column(name ="SUMMARY_DATE",nullable=true,scale=6)
	public java.util.Date getSummaryDate(){
		return this.summaryDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  提交日期
	 */
	public void setSummaryDate(java.util.Date summaryDate){
		this.summaryDate = summaryDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  周数
	 */
	@Column(name ="SUMMARY_WEEKS",nullable=true)
	public java.lang.Integer getSummaryWeeks(){
		return this.summaryWeeks;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  周数
	 */
	public void setSummaryWeeks(java.lang.Integer summaryWeeks){
		this.summaryWeeks = summaryWeeks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  总结内容
	 */
	@Column(name ="SUMMARY_NOTE",nullable=true,length=2000)
	public java.lang.String getSummaryNote(){
		return this.summaryNote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  总结内容
	 */
	public void setSummaryNote(java.lang.String summaryNote){
		this.summaryNote = summaryNote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户
	 */
	@Column(name ="SUMMARY_USER",nullable=true,length=32)
	public java.lang.String getSummaryUser(){
		return this.summaryUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户
	 */
	public void setSummaryUser(java.lang.String summaryUser){
		this.summaryUser = summaryUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  查看次数
	 */
	@Column(name ="SUMMARY_NUM",nullable=true,length=32)
	public java.lang.String getSummaryNum(){
		return this.summaryNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  查看次数
	 */
	public void setSummaryNum(java.lang.String summaryNum){
		this.summaryNum = summaryNum;
	}
}
