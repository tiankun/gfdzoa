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
import org.jeecgframework.web.system.pojo.base.TSDepart;

/**   
 * @Title: Entity
 * @Description: 绩效考核
 * @author ant
 * @date 2015-05-28 11:13:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_performance", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PerformanceEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**用户名*/
	private PersonInfoEntity user;
	/**部门*/
	private TSDepart depart;
	/**考核日期*/
	private java.util.Date performanceDate;
	/**备注*/
	private java.lang.String note;
	/**结果*/
	private java.lang.String results;
	
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
	 *@return: java.lang.String  用户名
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="USERNAME")
	public PersonInfoEntity getUser(){
		return this.user;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setUser(PersonInfoEntity user){
		this.user = user;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="DEPART")
	public TSDepart getDepart(){
		return this.depart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门
	 */
	public void setDepart(TSDepart depart){
		this.depart = depart;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  考核日期
	 */
	@Column(name ="PERFORMANCE_DATE",nullable=true,scale=6)
	public java.util.Date getPerformanceDate(){
		return this.performanceDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  考核日期
	 */
	public void setPerformanceDate(java.util.Date performanceDate){
		this.performanceDate = performanceDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="NOTE",nullable=true,length=255)
	public java.lang.String getNote(){
		return this.note;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setNote(java.lang.String note){
		this.note = note;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结果
	 */
	@Column(name ="RESULTS",nullable=true,length=32)
	public java.lang.String getResults(){
		return this.results;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果
	 */
	public void setResults(java.lang.String results){
		this.results = results;
	}
}
