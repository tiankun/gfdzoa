package com.gfdz.entity.hr;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 证书管理
 * @author ant
 * @date 2015-06-15 15:16:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "HR_CERTIFICATE", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class CertificateEntity implements java.io.Serializable {
	/**证书保管部门*/
	private java.lang.String baoGuan;
	/**是否到期提醒*/
	private java.lang.String tiXing;
	/**证件扫描件*/
	private java.lang.String zhengJian;
	/**备注*/
	private java.lang.String remark;
	/**是否年检提醒*/
	private java.lang.String nianJian;
	/**发证部门*/
	private java.lang.String faZheng;
	/**主键*/
	private java.lang.String id;
	/**员工编号*/
	private java.lang.String personId;
	/**证书分类*/
	private java.lang.String certType;
	/**是否主页显示*/
	private java.lang.String diaplay;
	/**证书名称*/
	private java.lang.String mingCheng;
	/**证书级别*/
	private java.lang.String certLevel;
	/**证书专业*/
	private java.lang.String zhuangYe;
	/**证书类型*/
	private java.lang.String majorType;
	/**证书编号*/
	private java.lang.String bianHao;
	/**认定时间*/
	private java.util.Date rdTime;
	/**有效期开始*/
	private java.util.Date xqSTime;
	/**有效期结束*/
	private java.util.Date xqETime;
	
	private List<CertificateFilesEntity> certificateFiles;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书保管部门
	 */
	@Column(name ="BAO_GUAN",nullable=true,length=300)
	public java.lang.String getBaoGuan(){
		return this.baoGuan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书保管部门
	 */
	public void setBaoGuan(java.lang.String baoGuan){
		this.baoGuan = baoGuan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否到期提醒
	 */
	@Column(name ="TI_XING",nullable=true,length=2)
	public java.lang.String getTiXing(){
		return this.tiXing;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否到期提醒
	 */
	public void setTiXing(java.lang.String tiXing){
		this.tiXing = tiXing;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件扫描件
	 */
	@Column(name ="ZHENG_JIAN",nullable=true,length=500)
	public java.lang.String getZhengJian(){
		return this.zhengJian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件扫描件
	 */
	public void setZhengJian(java.lang.String zhengJian){
		this.zhengJian = zhengJian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=1000)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否年检提醒
	 */
	@Column(name ="NIAN_JIAN",nullable=true,length=2)
	public java.lang.String getNianJian(){
		return this.nianJian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否年检提醒
	 */
	public void setNianJian(java.lang.String nianJian){
		this.nianJian = nianJian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发证部门
	 */
	@Column(name ="FA_ZHENG",nullable=true,length=300)
	public java.lang.String getFaZheng(){
		return this.faZheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发证部门
	 */
	public void setFaZheng(java.lang.String faZheng){
		this.faZheng = faZheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=100)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  员工编号
	 */
	@Column(name ="P_ID",nullable=false,length=100)
	public java.lang.String getPersonId() {
		return personId;
	}

	public void setPersonId(java.lang.String personId) {
		this.personId = personId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书分类
	 */
	@Column(name ="CERT_TYPE",nullable=true,length=20)
	public java.lang.String getCertType(){
		return this.certType;
	}



	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书分类
	 */
	public void setCertType(java.lang.String certType){
		this.certType = certType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否主页显示
	 */
	@Column(name ="DIAPLAY",nullable=true,length=2)
	public java.lang.String getDiaplay(){
		return this.diaplay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否主页显示
	 */
	public void setDiaplay(java.lang.String diaplay){
		this.diaplay = diaplay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书名称
	 */
	@Column(name ="MING_CHENG",nullable=true,length=100)
	public java.lang.String getMingCheng(){
		return this.mingCheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书名称
	 */
	public void setMingCheng(java.lang.String mingCheng){
		this.mingCheng = mingCheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书级别
	 */
	@Column(name ="CERT_LEVEL",nullable=true,length=20)
	public java.lang.String getCertLevel(){
		return this.certLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书级别
	 */
	public void setCertLevel(java.lang.String certLevel){
		this.certLevel = certLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书专业
	 */
	@Column(name ="ZHUANG_YE",nullable=true,length=100)
	public java.lang.String getZhuangYe(){
		return this.zhuangYe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书专业
	 */
	public void setZhuangYe(java.lang.String zhuangYe){
		this.zhuangYe = zhuangYe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书类型
	 */
	@Column(name ="MAJOR_TYPE",nullable=true,length=50)
	public java.lang.String getMajorType(){
		return this.majorType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书类型
	 */
	public void setMajorType(java.lang.String majorType){
		this.majorType = majorType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书编号
	 */
	@Column(name ="BIAN_HAO",nullable=true,length=50)
	public java.lang.String getBianHao(){
		return this.bianHao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书编号
	 */
	public void setBianHao(java.lang.String bianHao){
		this.bianHao = bianHao;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  认定时间
	 */
	@Column(name ="RD_TIME",nullable=true)
	public java.util.Date getRdTime(){
		return this.rdTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  认定时间
	 */
	public void setRdTime(java.util.Date rdTime){
		this.rdTime = rdTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  有效期开始
	 */
	@Column(name ="XQ_S_TIME",nullable=true)
	public java.util.Date getXqSTime(){
		return this.xqSTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  有效期开始
	 */
	public void setXqSTime(java.util.Date xqSTime){
		this.xqSTime = xqSTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  有效期结束
	 */
	@Column(name ="XQ_E_TIME",nullable=true)
	public java.util.Date getXqETime(){
		return this.xqETime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  有效期结束
	 */
	public void setXqETime(java.util.Date xqETime){
		this.xqETime = xqETime;
	}
	
	@OneToMany(mappedBy="certificate",cascade={CascadeType.REMOVE})
	public List<CertificateFilesEntity> getCertificateFiles() {
		return certificateFiles;
	}

	public void setCertificateFiles(List<CertificateFilesEntity> certificateFiles) {
		this.certificateFiles = certificateFiles;
	}

	

}
