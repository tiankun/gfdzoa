package com.gfdz.entity.zhb;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 合同信息登记
 * @author onlineGenerator
 * @date 2015-06-01 15:07:25
 * @version V1.0   
 *
 */
@Entity
@Table(name ="zhb_htdj", schema ="")
@SuppressWarnings("serial")
public class HtdjEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**类别编号*/
	@Excel(name="类别编号")
	private java.lang.String lxbh;
	/**合同编号*/
	@Excel(name="合同编号")
	private java.lang.String htbh;
	/**合同名称*/
	@Excel(name="合同名称")
	private java.lang.String htmc;
	/**合同内容*/
	@Excel(name="合同内容")
	private java.lang.String htnr;
	/**合同单位*/
	@Excel(name="合同单位")
	private java.lang.String htdw;
	/**合同日期*/
	@Excel(name="合同日期")
	private java.util.Date htrq;
	/**合同金额*/
	@Excel(name="合同金额")
	private java.lang.Double htje;
	/**存档份数*/
	@Excel(name="存档份数")
	private java.lang.Integer cdfs;
	/**经办人*/
	@Excel(name="经办人")
	private java.lang.String jbr;
	/**存放位置*/
	@Excel(name="存放位置")
	private java.lang.String cfwz;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String bz;
	/**创建日期*/
	@Excel(name="创建日期")
	private java.util.Date createDate;
	/**创建人*/
	@Excel(name="创建人")
	private java.lang.String createName;
	/**编辑时间*/
	@Excel(name="编辑时间")
	private java.util.Date updateDate;
	/**编辑人*/
	@Excel(name="编辑人")
	private java.lang.String updateName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
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
	 *@return: java.lang.String  类别编号
	 */
	@Column(name ="LXBH",nullable=true,length=50)
	public java.lang.String getLxbh(){
		return this.lxbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类别编号
	 */
	public void setLxbh(java.lang.String lxbh){
		this.lxbh = lxbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号
	 */
	@Column(name ="HTBH",nullable=true,length=50)
	public java.lang.String getHtbh(){
		return this.htbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同编号
	 */
	public void setHtbh(java.lang.String htbh){
		this.htbh = htbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同名称
	 */
	@Column(name ="HTMC",nullable=true,length=50)
	public java.lang.String getHtmc(){
		return this.htmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同名称
	 */
	public void setHtmc(java.lang.String htmc){
		this.htmc = htmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同内容
	 */
	@Column(name ="HTNR",nullable=true,length=100)
	public java.lang.String getHtnr(){
		return this.htnr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同内容
	 */
	public void setHtnr(java.lang.String htnr){
		this.htnr = htnr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同单位
	 */
	@Column(name ="HTDW",nullable=true,length=50)
	public java.lang.String getHtdw(){
		return this.htdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同单位
	 */
	public void setHtdw(java.lang.String htdw){
		this.htdw = htdw;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  合同日期
	 */
	@Column(name ="HTRQ",nullable=true,length=32)
	public java.util.Date getHtrq(){
		return this.htrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  合同日期
	 */
	public void setHtrq(java.util.Date htrq){
		this.htrq = htrq;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  合同金额
	 */
	@Column(name ="HTJE",nullable=true,length=32)
	public java.lang.Double getHtje(){
		return this.htje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  合同金额
	 */
	public void setHtje(java.lang.Double htje){
		this.htje = htje;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  存档份数
	 */
	@Column(name ="CDFS",nullable=true,length=32)
	public java.lang.Integer getCdfs(){
		return this.cdfs;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  存档份数
	 */
	public void setCdfs(java.lang.Integer cdfs){
		this.cdfs = cdfs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经办人
	 */
	@Column(name ="JBR",nullable=true,length=50)
	public java.lang.String getJbr(){
		return this.jbr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经办人
	 */
	public void setJbr(java.lang.String jbr){
		this.jbr = jbr;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=32)
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
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  编辑时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true,length=32)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  编辑时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
}
