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
 * @Description: 采购到货记录
 * @author ant
 * @date 2015-07-16 16:53:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_dh", schema = "")
@SuppressWarnings("serial")
public class ZhbDhEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
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
	/**采购执行单主键*/
	@Excel(name="采购执行单主键")
	private java.lang.String cgzxId;
	/**到货数量*/
	@Excel(name="到货数量")
	private java.math.BigDecimal aogNumber;
	/**到货日期*/
	@Excel(name="到货日期")
	private java.util.Date aogDate;
	/**实际供应商*/
	@Excel(name="实际供应商")
	private java.lang.String trueSupplier;
	/**到货确认人*/
	@Excel(name="到货确认人")
	private java.lang.String identifier;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	/**状态*/
	@Excel(name="状态")
	private java.math.BigDecimal flag;
	
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
	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购执行单主键
	 */
	@Column(name ="CGZX_ID",nullable=true,length=36)
	public java.lang.String getCgzxId(){
		return this.cgzxId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购执行单主键
	 */
	public void setCgzxId(java.lang.String cgzxId){
		this.cgzxId = cgzxId;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  到货数量
	 */
	@Column(name ="AOG_NUMBER",nullable=true,length=32)
	public java.math.BigDecimal getAogNumber(){
		return this.aogNumber;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  到货数量
	 */
	public void setAogNumber(java.math.BigDecimal aogNumber){
		this.aogNumber = aogNumber;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  到货日期
	 */
	@Column(name ="AOG_DATE",nullable=true,length=32)
	public java.util.Date getAogDate(){
		return this.aogDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  到货日期
	 */
	public void setAogDate(java.util.Date aogDate){
		this.aogDate = aogDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际供应商
	 */
	@Column(name ="TRUE_SUPPLIER",nullable=true,length=32)
	public java.lang.String getTrueSupplier(){
		return this.trueSupplier;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际供应商
	 */
	public void setTrueSupplier(java.lang.String trueSupplier){
		this.trueSupplier = trueSupplier;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到货确认人
	 */
	@Column(name ="IDENTIFIER",nullable=true,length=32)
	public java.lang.String getIdentifier(){
		return this.identifier;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到货确认人
	 */
	public void setIdentifier(java.lang.String identifier){
		this.identifier = identifier;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=4000)
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
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  状态
	 */
	@Column(name ="FLAG",nullable=true,length=32)
	public java.math.BigDecimal getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  状态
	 */
	public void setFlag(java.math.BigDecimal flag){
		this.flag = flag;
	}
}
