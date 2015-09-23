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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 采购申请材料详细
 * @author ant
 * @date 2015-07-20 11:05:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_planlist", schema = "")
@SuppressWarnings("serial")
public class ZhbPlanlistEntity implements java.io.Serializable {
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
	/**材料编号*/
	
	private CpEntity cp;
	/**计划数量*/
	@Excel(name="计划数量")
	private java.math.BigDecimal planNumber;
	/**计划单价*/
	@Excel(name="计划单价")
	private java.math.BigDecimal planPrice;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	/**计划采购主表id*/
	private java.lang.String plancpId;
	/**计划审核主id*/
	private java.lang.String planaditId;
	/**审核数量*/
	@Excel(name="审核数量")
	private java.math.BigDecimal examinNumber;
	/**审核单价*/
	@Excel(name="审核单价")
	private java.math.BigDecimal examinPrice;
	
	
	
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
	 *@return: java.lang.String  材料编号
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="cp")
	public CpEntity getCp(){
		return this.cp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料编号
	 */
	public void setCp(CpEntity cp){
		this.cp = cp;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  计划数量
	 */
	@Column(name ="PLAN_NUMBER",nullable=true,length=32)
	public java.math.BigDecimal getPlanNumber(){
		return this.planNumber;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  计划数量
	 */
	public void setPlanNumber(java.math.BigDecimal planNumber){
		this.planNumber = planNumber;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  计划单价
	 */
	@Column(name ="PLAN_PRICE",nullable=true,length=32)
	public java.math.BigDecimal getPlanPrice(){
		return this.planPrice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  计划单价
	 */
	public void setPlanPrice(java.math.BigDecimal planPrice){
		this.planPrice = planPrice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=300)
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
	 *@return: java.lang.String  计划采购主表id
	 */
	@Column(name ="PLANCP_ID",nullable=true,length=36)
	public java.lang.String getPlancpId(){
		return this.plancpId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划采购主表id
	 */
	public void setPlancpId(java.lang.String plancpId){
		this.plancpId = plancpId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划审核主id
	 */
	@Column(name ="PLANADIT_ID",nullable=true,length=36)
	public java.lang.String getPlanaditId(){
		return this.planaditId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划审核主id
	 */
	public void setPlanaditId(java.lang.String planaditId){
		this.planaditId = planaditId;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  审核数量
	 */
	@Column(name ="EXAMIN_NUMBER",nullable=true,length=32)
	public java.math.BigDecimal getExaminNumber(){
		return this.examinNumber;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  审核数量
	 */
	public void setExaminNumber(java.math.BigDecimal examinNumber){
		this.examinNumber = examinNumber;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  审核单价
	 */
	@Column(name ="EXAMIN_PRICE",nullable=true,length=32)
	public java.math.BigDecimal getExaminPrice(){
		return this.examinPrice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  审核单价
	 */
	public void setExaminPrice(java.math.BigDecimal examinPrice){
		this.examinPrice = examinPrice;
	}
}
