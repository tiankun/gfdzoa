package com.gfdz.entity.hr;

import javax.persistence.CascadeType;
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
import org.jeecgframework.web.system.pojo.base.TSTerritory;

/**   
 * @Title: TravelPath Entity
 * @Description: 出差路径
 * @author ant
 * @date 2015-05-28 11:20:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_travel_path", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TravelPathEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**省*/
	private java.lang.String province;
	/**市*/
	private TSTerritory city;
	/**县*/
	private TSTerritory county;
	/**开始时间*/
	private java.util.Date beginDate;
	/**结束时间*/
	private java.util.Date endDate;
	/**交通工具*/
	private java.lang.String vehicle;
	/**报销标准*/
	private Double criterion;
	/**出差id*/
	private TravelEntity travel;
	/**出差类型*/
	private java.lang.String travelType;
	
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
	 *@return: java.lang.String  省
	 */
	@Column(name ="PROVINCE")
	public java.lang.String getProvince(){
		return this.province;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省
	 */
	public void setProvince(java.lang.String province){
		this.province = province;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  市
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="CITY")
	public TSTerritory getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  市
	 */
	public void setCity(TSTerritory city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  县
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="COUNTY")
	public TSTerritory getCounty(){
		return this.county;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  县
	 */
	public void setCounty(TSTerritory county){
		this.county = county;
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
	 *@return: java.lang.String  交通工具
	 */
	@Column(name ="VEHICLE",nullable=true,length=32)
	public java.lang.String getVehicle(){
		return this.vehicle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交通工具
	 */
	public void setVehicle(java.lang.String vehicle){
		this.vehicle = vehicle;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  报销标准
	 */
	@Column(name ="CRITERION",nullable=true,precision=10,scale=2)
	public Double getCriterion(){
		return this.criterion;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  报销标准
	 */
	public void setCriterion(Double criterion){
		this.criterion = criterion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出差id
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="TRAVEL_ID")
	public TravelEntity getTravel(){
		return this.travel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出差id
	 */
	public void setTravel(TravelEntity travel){
		this.travel = travel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出差类型
	 */
	@Column(name ="TRAVEL_TYPE",nullable=true,length=10)
	public java.lang.String getTravelType(){
		return this.travelType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出差类型
	 */
	public void setTravelType(java.lang.String travelType){
		this.travelType = travelType;
	}
}
