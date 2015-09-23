package com.gfdz.entity.gc;

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
 * @Description: 质量保证金发放
 * @author ant
 * @date 2015-08-21 10:58:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_QUALITY_RETENTION", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class QualityRetentionEntity implements java.io.Serializable {
	/**批准金额*/
	private java.math.BigDecimal approvalMoney;
	/**核对金额*/
	private java.math.BigDecimal checkMoney;
	/**申请人*/
	private java.lang.String applyPerson;
	/**申请日期*/
	private java.util.Date applyDate;
	/**备注*/
	private java.lang.String remark;
	/**流程id*/
	private java.lang.String processinstanceid;
	/**id*/
	private java.lang.String id;
	/**项目id*/
	private java.lang.String projectId;
	/**操作组*/
	private java.lang.String actionGroup;
	/**质保金*/
	private java.math.BigDecimal retentionMoney;
	/**申请金额*/
	private java.math.BigDecimal applyMoney;
	
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  批准金额
	 */
	@Column(name ="APPROVAL_MONEY",nullable=true,precision=10,scale=2)
	public java.math.BigDecimal getApprovalMoney(){
		return this.approvalMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  批准金额
	 */
	public void setApprovalMoney(java.math.BigDecimal approvalMoney){
		this.approvalMoney = approvalMoney;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  核对金额
	 */
	@Column(name ="CHECK_MONEY",nullable=true,precision=10,scale=2)
	public java.math.BigDecimal getCheckMoney(){
		return this.checkMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  核对金额
	 */
	public void setCheckMoney(java.math.BigDecimal checkMoney){
		this.checkMoney = checkMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人
	 */
	@Column(name ="APPLY_PERSON",nullable=true,length=255)
	public java.lang.String getApplyPerson(){
		return this.applyPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人
	 */
	public void setApplyPerson(java.lang.String applyPerson){
		this.applyPerson = applyPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请日期
	 */
	@Column(name ="APPLY_DATE",nullable=true)
	public java.util.Date getApplyDate(){
		return this.applyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请日期
	 */
	public void setApplyDate(java.util.Date applyDate){
		this.applyDate = applyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=255)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目id
	 */
	@Column(name ="PROJECT_ID",nullable=true,length=32)
	public java.lang.String getProjectId(){
		return this.projectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目id
	 */
	public void setProjectId(java.lang.String projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作组
	 */
	@Column(name ="ACTION_GROUP",nullable=true,length=255)
	public java.lang.String getActionGroup(){
		return this.actionGroup;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作组
	 */
	public void setActionGroup(java.lang.String actionGroup){
		this.actionGroup = actionGroup;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  质保金
	 */
	@Column(name ="RETENTION_MONEY",nullable=true,precision=10,scale=2)
	public java.math.BigDecimal getRetentionMoney(){
		return this.retentionMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  质保金
	 */
	public void setRetentionMoney(java.math.BigDecimal retentionMoney){
		this.retentionMoney = retentionMoney;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  申请金额
	 */
	@Column(name ="APPLY_MONEY",nullable=true,precision=10,scale=2)
	public java.math.BigDecimal getApplyMoney(){
		return this.applyMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  申请金额
	 */
	public void setApplyMoney(java.math.BigDecimal applyMoney){
		this.applyMoney = applyMoney;
	}
}
