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
 * @Description: 证章申请信息
 * @author ant
 * @date 2015-05-29 14:23:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_zzsq", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ZzsqEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**借用项目*/
	private java.lang.String jyxm;
	/**使用时间*/
	private java.util.Date sysj;
	/**借用用途*/
	private java.lang.String jyyt;
	/**借用类型（可多选）*/
	private java.lang.String jylx;
	/**使用份数*/
	private java.lang.Integer syfs;
	/**备注*/
	private java.lang.String bz;
	/**申请人*/
	private java.lang.String sqr;
	/**申请时间*/
	private java.util.Date sqsj;
	/**流程id*/
	private java.lang.String processinstanceid;
	/**申请状态*/
	private java.lang.Integer sqzt;
	/**是否外借**/
	private String isout;
	
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
	 *@return: java.lang.String  借用项目
	 */
	@Column(name ="JYXM",nullable=true,length=50)
	public java.lang.String getJyxm(){
		return this.jyxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借用项目
	 */
	public void setJyxm(java.lang.String jyxm){
		this.jyxm = jyxm;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  使用时间
	 */
	@Column(name ="SYSJ",nullable=false)
	public java.util.Date getSysj(){
		return this.sysj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  使用时间
	 */
	public void setSysj(java.util.Date sysj){
		this.sysj = sysj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  借用用途
	 */
	@Column(name ="JYYT",nullable=false,length=100)
	public java.lang.String getJyyt(){
		return this.jyyt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借用用途
	 */
	public void setJyyt(java.lang.String jyyt){
		this.jyyt = jyyt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  借用类型（可多选）
	 */
	@Column(name ="JYLX",nullable=true,length=200)
	public java.lang.String getJylx(){
		return this.jylx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借用类型（可多选）
	 */
	public void setJylx(java.lang.String jylx){
		this.jylx = jylx;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  使用份数
	 */
	@Column(name ="SYFS",nullable=true)
	public java.lang.Integer getSyfs(){
		return this.syfs;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  使用份数
	 */
	public void setSyfs(java.lang.Integer syfs){
		this.syfs = syfs;
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
	 *@return: java.lang.String  申请人
	 */
	@Column(name ="SQR",nullable=false,length=50)
	public java.lang.String getSqr(){
		return this.sqr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人
	 */
	public void setSqr(java.lang.String sqr){
		this.sqr = sqr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="SQSJ",nullable=true)
	public java.util.Date getSqsj(){
		return this.sqsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setSqsj(java.util.Date sqsj){
		this.sqsj = sqsj;
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请状态
	 */
	@Column(name ="SQZT",nullable=true,precision=1,scale=0)
	public java.lang.Integer getSqzt(){
		return this.sqzt;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请状态
	 */
	public void setSqzt(java.lang.Integer sqzt){
		this.sqzt = sqzt;
	}
	
	
	@Column(name ="ISOUT")
	public String getIsout() {
		return isout;
	}

	public void setIsout(String isout) {
		this.isout = isout;
	}
	
	
}
