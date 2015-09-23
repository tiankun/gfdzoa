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
 * @Description: 收发文登记表
 * @author ant
 * @date 2015-05-28 11:46:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_sfwdj", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SfwdjEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**类型编号*/
	private java.lang.String lxbh;
	/**文件名称*/
	private java.lang.String wjmc;
	/**文件编号*/
	private java.lang.String wjbh;
	/**收发文类型(1：收文；2：发文)*/
	private java.lang.Integer sfwlx;
	/**文件份数*/
	private java.lang.Integer wjfs;
	/**收/发件人*/
	private java.lang.String fjr;
	/**签收人*/
	private java.lang.String qsr;
	/**签收日期*/
	private java.util.Date qsrq;
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
	@Column(name ="LXBH",nullable=true,length=50)
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
	 *@return: java.lang.String  文件名称
	 */
	@Column(name ="WJMC",nullable=false,length=50)
	public java.lang.String getWjmc(){
		return this.wjmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件名称
	 */
	public void setWjmc(java.lang.String wjmc){
		this.wjmc = wjmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件编号
	 */
	@Column(name ="WJBH",nullable=false,length=50)
	public java.lang.String getWjbh(){
		return this.wjbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件编号
	 */
	public void setWjbh(java.lang.String wjbh){
		this.wjbh = wjbh;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  收发文类型(1：收文；2：发文)
	 */
	@Column(name ="SFWLX",nullable=true,precision=1,scale=0)
	public java.lang.Integer getSfwlx(){
		return this.sfwlx;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  收发文类型(1：收文；2：发文)
	 */
	public void setSfwlx(java.lang.Integer sfwlx){
		this.sfwlx = sfwlx;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  文件份数
	 */
	@Column(name ="WJFS",nullable=false,precision=5,scale=0)
	public java.lang.Integer getWjfs(){
		return this.wjfs;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  文件份数
	 */
	public void setWjfs(java.lang.Integer wjfs){
		this.wjfs = wjfs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收/发件人
	 */
	@Column(name ="FJR",nullable=false,length=50)
	public java.lang.String getFjr(){
		return this.fjr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收/发件人
	 */
	public void setFjr(java.lang.String fjr){
		this.fjr = fjr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签收人
	 */
	@Column(name ="QSR",nullable=false,length=50)
	public java.lang.String getQsr(){
		return this.qsr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签收人
	 */
	public void setQsr(java.lang.String qsr){
		this.qsr = qsr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签收日期
	 */
	@Column(name ="QSRQ",nullable=false)
	public java.util.Date getQsrq(){
		return this.qsrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签收日期
	 */
	public void setQsrq(java.util.Date qsrq){
		this.qsrq = qsrq;
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
