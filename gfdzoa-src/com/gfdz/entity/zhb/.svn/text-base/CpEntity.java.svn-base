package com.gfdz.entity.zhb;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 产品表
 * @author ant
 * @date 2015-05-28 11:56:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_cp", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class CpEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**类型*/
	private CplxEntity lxbh;
	/**规格*/
	private java.lang.String standard;
	/**品牌*/
	private java.lang.String brand;
	/**供应商人*/
	private GysmlEntity gysml;
	/**产品名称*/
	private java.lang.String cpmc;
	/**备注*/
	private java.lang.String bz;
	private java.lang.String unit;
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
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
	 *@param: java.lang.String  编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="LXBH")
	//@Column(name ="LXBH",nullable=true,length=50)
	public CplxEntity getLxbh(){
		return this.lxbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setLxbh(CplxEntity lxbh){
		this.lxbh = lxbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */
	@Column(name ="STANDARD",nullable=true,length=50)
	public java.lang.String getStandard(){
		return this.standard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格
	 */
	public void setStandard(java.lang.String standard){
		this.standard = standard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌
	 */
	@Column(name ="BRAND",nullable=true,length=50)
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
	 *@return: java.lang.String  单位
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="GYSML")
	public GysmlEntity getGysml(){
		return this.gysml;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setGysml(GysmlEntity gysml){
		this.gysml = gysml;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="CPMC",nullable=false,length=50)
	public java.lang.String getCpmc(){
		return this.cpmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setCpmc(java.lang.String cpmc){
		this.cpmc = cpmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=100)
	public java.lang.String getBz(){
		return this.bz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBz(java.lang.String bz){
		this.bz = bz;
	}
	
	@Column(name ="UNIT")
	public java.lang.String getUnit() {
		return unit;
	}

	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}
	
	
}
