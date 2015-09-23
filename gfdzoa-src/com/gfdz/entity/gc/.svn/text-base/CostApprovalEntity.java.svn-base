package com.gfdz.entity.gc;

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

/**   
 * @Title: Entity
 * @Description: 成本合算
 * @author ant
 * @date 2015-05-28 14:49:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "gc_cost_approval", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class CostApprovalEntity implements java.io.Serializable {
	/**核定编号*/
	private java.lang.String id;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**审定施工费*/
	private Double sdsgf;
	/**增减变更金额*/
	private Double bgje;
	/**管网进度*/
	private Double gwjd;
	/**线缆进度*/
	private Double xljd;
	/**设备进度*/
	private Double sbjd;
	/**总体进度*/
	private Double ztjd;
	
	private String processinstanceId;
	
	
	public CostApprovalEntity() {

	}
	
	public CostApprovalEntity(String id, Double sdsgf, Double bgje) {
		super();
		this.id = id;
		this.sdsgf = sdsgf;
		this.bgje = bgje;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  核定编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=50)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  核定编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="PROJECT_ID")
	public ProjectInfoEntity getProject() {
		return project;
	}

	public void setProject(ProjectInfoEntity project) {
		this.project = project;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  审定施工费
	 */
	@Column(name ="SDSGF",nullable=true)
	public Double getSdsgf(){
		return this.sdsgf;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  审定施工费
	 */
	public void setSdsgf(Double sdsgf){
		this.sdsgf = sdsgf;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  增减变更金额
	 */
	@Column(name ="BGJE",nullable=true)
	public Double getBgje(){
		return this.bgje;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  增减变更金额
	 */
	public void setBgje(Double bgje){
		this.bgje = bgje;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  管网进度
	 */
	@Column(name ="GWJD",nullable=true)
	public Double getGwjd(){
		return this.gwjd;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  管网进度
	 */
	public void setGwjd(Double gwjd){
		this.gwjd = gwjd;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  线缆进度
	 */
	@Column(name ="XLJD",nullable=true)
	public Double getXljd(){
		return this.xljd;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  线缆进度
	 */
	public void setXljd(Double xljd){
		this.xljd = xljd;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  设备进度
	 */
	@Column(name ="SBJD",nullable=true)
	public Double getSbjd(){
		return this.sbjd;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  设备进度
	 */
	public void setSbjd(Double sbjd){
		this.sbjd = sbjd;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  总体进度
	 */
	@Column(name ="ZTJD",nullable=true)
	public Double getZtjd(){
		return this.ztjd;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  总体进度
	 */
	public void setZtjd(Double ztjd){
		this.ztjd = ztjd;
	}
	
	@Column(name ="PROCESSINSTANCEID",nullable=true,length=32)
	public String getProcessinstanceId() {
		return processinstanceId;
	}

	public void setProcessinstanceId(String processinstanceId) {
		this.processinstanceId = processinstanceId;
	}
	
	
}
