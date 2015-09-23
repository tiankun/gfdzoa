package com.gfdz.entity.gc;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSUser;

/**
 * @Title: Entity
 * @Description: 项目材料采购计划
 * @author ant
 * @date 2015-05-28 13:55:08
 * @version V1.0
 * 
 */
@Entity
@Table(name = "gc_purchase_plan", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PurchasePlanEntity implements java.io.Serializable {
	/** 主键 */
	private String id;
	/** 单号 */
	private String billCode;
	/** 项目主键 */
	private ProjectInfoEntity project;
	/** 申请人 */
	private TSUser user;
	/** 申请时间 */
	private java.util.Date applyTime;
	/** 备注 */
	private String remark;
	/** 流程 实例ID */
	private String processInstanceId;
	/** 预付款 */
	private Double advance;
	private List<PurchasePlanDetailEntity> pds;
	private List<PurchaseEntity> ps;

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 主键
	 */

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "BILL_CODE")
	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 申请时间
	 */
	@Column(name = "APPLY_TIME", nullable = false, scale = 6)
	public java.util.Date getApplyTime() {
		return this.applyTime;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 申请时间
	 */
	public void setApplyTime(java.util.Date applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 备注
	 */
	@Column(name = "REMARK", nullable = true, length = 500)
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public ProjectInfoEntity getProject() {
		return project;
	}

	public void setProject(ProjectInfoEntity project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public TSUser getUser() {
		return user;
	}

	public void setUser(TSUser user) {
		this.user = user;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "purchasePlan")
	public List<PurchasePlanDetailEntity> getPds() {
		return pds;
	}

	public void setPds(List<PurchasePlanDetailEntity> pds) {
		this.pds = pds;
	}

	@Column(name = "processInstanceId")
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
	public List<PurchaseEntity> getPs() {
		return ps;
	}

	public void setPs(List<PurchaseEntity> ps) {
		this.ps = ps;
	}

	@Column(name = "ADVANCE")
	public Double getAdvance() {
		return advance;
	}

	public void setAdvance(Double advance) {
		this.advance = advance;
	}

}
