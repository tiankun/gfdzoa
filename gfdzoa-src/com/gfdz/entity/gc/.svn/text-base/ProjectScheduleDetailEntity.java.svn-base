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

import com.gfdz.entity.zhb.CpEntity;

/**   
 * @Title: Entity
 * @Description: 工程进度明细表
 * @author ant
 * @date 2015-05-28 14:53:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_PROJECT_SCHEDULE_DETAIL")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ProjectScheduleDetailEntity implements java.io.Serializable {
	/**明细编号*/
	private java.lang.String id;
	/**报告编号*/
	private ProjectScheduleEntity projectSchedule;
	/**材料名称*/
	private CpEntity material;
	/**品牌*/
	private java.lang.String brand;
	/**规格*/
	private java.lang.String specifications;
	/**单位*/
	private java.lang.String unit;
	/**数量*/
	private java.lang.Integer amount;
	/**使用部位*/
	private java.lang.String position;
	/**备注*/
	private java.lang.String remarks;
	
	/**材料用途*/
	private String ctype;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  明细编号
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
	 *@param: java.lang.String  明细编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报告编号
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="PROGRESS_STATISTICS_ID")
	public ProjectScheduleEntity getProjectSchedule() {
		return projectSchedule;
	}

	public void setProjectSchedule(ProjectScheduleEntity projectSchedule) {
		this.projectSchedule = projectSchedule;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  材料名称
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="MATERIAL")
	public CpEntity getMaterial(){
		return this.material;
	}

	public void setMaterial(CpEntity material) {
		this.material = material;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌
	 */
	@Column(name ="BRAND",nullable=true,length=20)
	public java.lang.String getBrand(){
		return this.brand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌
	 */
	public void setBrand(java.lang.String brand){
		this.brand = brand;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */
	@Column(name ="SPECIFICATIONS",nullable=true,length=20)
	public java.lang.String getSpecifications(){
		return this.specifications;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格
	 */
	public void setSpecifications(java.lang.String specifications){
		this.specifications = specifications;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	@Column(name ="UNIT",nullable=true,length=10)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */
	@Column(name ="AMOUNT",nullable=true)
	public java.lang.Integer getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setAmount(java.lang.Integer amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  使用部位
	 */
	@Column(name ="POSITION",nullable=true,length=50)
	public java.lang.String getPosition(){
		return this.position;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  使用部位
	 */
	public void setPosition(java.lang.String position){
		this.position = position;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=200)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
	
	
	@Column(name ="ctype")
	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	
	
}
