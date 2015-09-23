package com.gfdz.entity.zhb;

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
 * @Description: 证章信息
 * @author ant
 * @date 2015-05-29 14:22:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_zzxx", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ZzxxEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**类型编号*/
	private java.lang.String lxbh;
	/**证章名称*/
	private java.lang.String zzmc;
	/**责任部门*/
	private java.lang.String zrbm;
	/**责任人*/
	private java.lang.String zrr;
	/**存放位置*/
	private java.lang.String cfwz;
	/**备注*/
	private java.lang.String bz;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	
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
	 *@return: java.lang.String  类型编号
	 */
	@Column(name ="LXBH",nullable=false,length=50)
	public java.lang.String getLxbh(){
		return this.lxbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型编号
	 */
	public void setLxbh(java.lang.String lxbh){
		this.lxbh = lxbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证章名称
	 */
	@Column(name ="ZZMC",nullable=false,length=50)
	public java.lang.String getZzmc(){
		return this.zzmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证章名称
	 */
	public void setZzmc(java.lang.String zzmc){
		this.zzmc = zzmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任部门
	 */
	@Column(name ="ZRBM",nullable=true,length=50)
	public java.lang.String getZrbm(){
		return this.zrbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任部门
	 */
	public void setZrbm(java.lang.String zrbm){
		this.zrbm = zrbm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任人
	 */
	@Column(name ="ZRR",nullable=true,length=50)
	public java.lang.String getZrr(){
		return this.zrr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任人
	 */
	public void setZrr(java.lang.String zrr){
		this.zrr = zrr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存放位置
	 */
	@Column(name ="CFWZ",nullable=true,length=50)
	public java.lang.String getCfwz(){
		return this.cfwz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存放位置
	 */
	public void setCfwz(java.lang.String cfwz){
		this.cfwz = cfwz;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
}
