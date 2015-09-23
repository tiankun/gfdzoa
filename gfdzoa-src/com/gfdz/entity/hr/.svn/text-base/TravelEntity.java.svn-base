package com.gfdz.entity.hr;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;

/**   
 * @Title: Entity
 * @Description: 出差记录
 * @author ant
 * @date 2015-05-28 11:17:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_travel")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TravelEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**出差申请人*/
	private TSUser travelUser;
	/**部门*/
	private TSDepart depart;
	/**随行人员*/
	private java.lang.String travelOtheruser;
	/**开始时间*/
	private java.util.Date beginDate;
	/**结束时间*/
	private java.util.Date endDate;
	/**出差事由*/
	private java.lang.String travelReason;
	/**是否暂支*/
	private java.lang.String iszanzhi;
	/**暂支金额**/
	private Double zzmoney;
	/**出差路径*/
	private List<TravelPathEntity> travelPaths;
	/**流程id*/
	private java.lang.String processinstanceid;
	/**住宿类别*/
	private String stayType;
	
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
	 *@return: java.lang.String  出差申请人
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="TRAVEL_USER")
	public TSUser getTravelUser(){
		return this.travelUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出差申请人
	 */
	public void setTravelUser(TSUser travelUser){
		this.travelUser = travelUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门
	 */
	@ManyToOne(fetch=FetchType.LAZY)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  随行人员
	 */
	@Column(name ="TRAVEL_OTHERUSER")
	public java.lang.String getTravelOtheruser(){
		return this.travelOtheruser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  随行人员
	 */
	public void setTravelOtheruser(java.lang.String travelOtheruser){
		this.travelOtheruser = travelOtheruser;
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
	 *@return: java.lang.String  出差事由
	 */
	@Column(name ="TRAVEL_REASON",nullable=true,length=255)
	public java.lang.String getTravelReason(){
		return this.travelReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出差事由
	 */
	public void setTravelReason(java.lang.String travelReason){
		this.travelReason = travelReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否暂支
	 */
	@Column(name ="ISZANZHI",nullable=true,length=1)
	public java.lang.String getIszanzhi(){
		return this.iszanzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否暂支
	 */
	public void setIszanzhi(java.lang.String iszanzhi){
		this.iszanzhi = iszanzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出差路径
	 */
	@OneToMany(mappedBy="travel",cascade={CascadeType.REMOVE})
	public List<TravelPathEntity> getTravelPaths(){
		return this.travelPaths;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出差路径
	 */
	public void setTravelPaths(List<TravelPathEntity> travelPaths){
		this.travelPaths = travelPaths;
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
	
	@Column(name ="ZZMONEY")
	public Double getZzmoney() {
		return zzmoney;
	}

	public void setZzmoney(Double zzmoney) {
		this.zzmoney = zzmoney;
	}
	
	
	@Column(name ="STAYTYPE")
	public String getStayType() {
		return stayType;
	}

	public void setStayType(String stayType) {
		this.stayType = stayType;
	}
	
	
	
}
