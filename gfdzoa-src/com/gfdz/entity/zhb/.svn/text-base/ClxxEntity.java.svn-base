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
 * @Description: 车辆信息
 * @author ant
 * @date 2015-05-28 11:29:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_clxx", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ClxxEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**车辆名称*/
	private java.lang.String clmc;
	/**车牌号码*/
	private java.lang.String cphm;
	/**品牌*/
	private java.lang.String pp;
	/**车型*/
	private java.lang.String cx;
	/**发动机号*/
	private java.lang.String fdjh;
	/**购买时间*/
	private java.util.Date gmsj;
	/**购买价格*/
	private java.lang.Integer gmjg;
	/**年检时间*/
	private java.util.Date njsj;
	/**保险购买时间*/
	private java.util.Date bxgmsj;
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
	 *@return: java.lang.String  车辆名称
	 */
	@Column(name ="CLMC",nullable=false,length=50)
	public java.lang.String getClmc(){
		return this.clmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆名称
	 */
	public void setClmc(java.lang.String clmc){
		this.clmc = clmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌号码
	 */
	@Column(name ="CPHM",nullable=false,length=50)
	public java.lang.String getCphm(){
		return this.cphm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌号码
	 */
	public void setCphm(java.lang.String cphm){
		this.cphm = cphm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌
	 */
	@Column(name ="PP",nullable=false,length=50)
	public java.lang.String getPp(){
		return this.pp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌
	 */
	public void setPp(java.lang.String pp){
		this.pp = pp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车型
	 */
	@Column(name ="CX",nullable=false,length=50)
	public java.lang.String getCx(){
		return this.cx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型
	 */
	public void setCx(java.lang.String cx){
		this.cx = cx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发动机号
	 */
	@Column(name ="FDJH",nullable=false,length=30)
	public java.lang.String getFdjh(){
		return this.fdjh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发动机号
	 */
	public void setFdjh(java.lang.String fdjh){
		this.fdjh = fdjh;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  购买时间
	 */
	@Column(name ="GMSJ",nullable=true)
	public java.util.Date getGmsj(){
		return this.gmsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  购买时间
	 */
	public void setGmsj(java.util.Date gmsj){
		this.gmsj = gmsj;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  购买价格
	 */
	@Column(name ="GMJG",nullable=true)
	public java.lang.Integer getGmjg(){
		return this.gmjg;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  购买价格
	 */
	public void setGmjg(java.lang.Integer gmjg){
		this.gmjg = gmjg;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  年检时间
	 */
	@Column(name ="NJSJ",nullable=false)
	public java.util.Date getNjsj(){
		return this.njsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  年检时间
	 */
	public void setNjsj(java.util.Date njsj){
		this.njsj = njsj;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  保险购买时间
	 */
	@Column(name ="BXGMSJ",nullable=true)
	public java.util.Date getBxgmsj(){
		return this.bxgmsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  保险购买时间
	 */
	public void setBxgmsj(java.util.Date bxgmsj){
		this.bxgmsj = bxgmsj;
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
