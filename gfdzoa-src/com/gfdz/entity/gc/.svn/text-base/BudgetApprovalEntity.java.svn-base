package com.gfdz.entity.gc;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: 预算审批表附件
 * @author ant
 * @date 2015-08-12 10:14:42
 * @version V1.0
 * 
 */
@Entity
@Table(name = "GC_BUDGET_APPROVAL", schema = "")
@SuppressWarnings("serial")
public class BudgetApprovalEntity implements java.io.Serializable {
	/** 审批单号 */
	private String id;
	/** 项目编号 */
	private ProjectInfoEntity project;
	/** 类型：0 预算，1 结算 */
	private Integer type;
	/** 建设单位 */
	private String construction;
	/** 编制说明 */
	private String remark;
	/** 编制人 */
	private String compilin;
	/** 编制日期 */
	private java.util.Date compilingDate;
	/** 审核意见 */
	private String review;
	/** 审核人 */
	private String auditPerson;
	/** 审核日期 */
	private java.util.Date reviewDate;
	/** 财务意见 */
	private String financialAudit;
	/** 经办人 */
	private String treasuryAttache;
	/** 经办日期 */
	private java.util.Date financialDate;
	/** 审批意见 */
	private String approvalOpinion;
	/** 批准人 */
	private String approvalPerson;
	/** 批准日期 */
	private java.util.Date approvalDate;
	/** 流程实例ID */
	private String processInstanceId;
	/** 审核状态：0 可修改 ，1 审核中不可修改 */
	private Integer isverify;

	private List<BudgetApprovalFilesEntity> budgetApprovalFiles;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 建设单位
	 */
	@Column(name = "CONSTRUCTION", nullable = true, length = 100)
	public String getConstruction() {
		return this.construction;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 建设单位
	 */
	public void setConstruction(String construction) {
		this.construction = construction;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 编制说明
	 */
	@Column(name = "REMARK", nullable = true, length = 1000)
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 编制说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 编制人
	 */
	@Column(name = "COMPILIN", nullable = true, length = 20)
	public String getCompilin() {
		return this.compilin;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 编制人
	 */
	public void setCompilin(String compilin) {
		this.compilin = compilin;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 编制日期
	 */
	@Column(name = "COMPILING_DATE", nullable = true)
	public java.util.Date getCompilingDate() {
		return this.compilingDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 编制日期
	 */
	public void setCompilingDate(java.util.Date compilingDate) {
		this.compilingDate = compilingDate;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 审核意见
	 */
	@Column(name = "REVIEW", nullable = true, length = 500)
	public String getReview() {
		return this.review;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 审核意见
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 审核人
	 */
	@Column(name = "AUDIT_PERSON", nullable = true, length = 20)
	public String getAuditPerson() {
		return this.auditPerson;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 审核人
	 */
	public void setAuditPerson(String auditPerson) {
		this.auditPerson = auditPerson;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 审核日期
	 */
	@Column(name = "REVIEW_DATE", nullable = true)
	public java.util.Date getReviewDate() {
		return this.reviewDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 审核日期
	 */
	public void setReviewDate(java.util.Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 财务意见
	 */
	@Column(name = "FINANCIAL_AUDIT", nullable = true, length = 500)
	public String getFinancialAudit() {
		return this.financialAudit;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 财务意见
	 */
	public void setFinancialAudit(String financialAudit) {
		this.financialAudit = financialAudit;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 经办人
	 */
	@Column(name = "TREASURY_ATTACHE", nullable = true, length = 20)
	public String getTreasuryAttache() {
		return this.treasuryAttache;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 经办人
	 */
	public void setTreasuryAttache(String treasuryAttache) {
		this.treasuryAttache = treasuryAttache;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 经办日期
	 */
	@Column(name = "FINANCIAL_DATE", nullable = true)
	public java.util.Date getFinancialDate() {
		return this.financialDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 经办日期
	 */
	public void setFinancialDate(java.util.Date financialDate) {
		this.financialDate = financialDate;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 审批意见
	 */
	@Column(name = "APPROVAL_OPINION", nullable = true, length = 500)
	public String getApprovalOpinion() {
		return this.approvalOpinion;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 审批意见
	 */
	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 批准人
	 */
	@Column(name = "APPROVAL_PERSON", nullable = true, length = 20)
	public String getApprovalPerson() {
		return this.approvalPerson;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 批准人
	 */
	public void setApprovalPerson(String approvalPerson) {
		this.approvalPerson = approvalPerson;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 批准日期
	 */
	@Column(name = "APPROVAL_DATE", nullable = true)
	public java.util.Date getApprovalDate() {
		return this.approvalDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 批准日期
	 */
	public void setApprovalDate(java.util.Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@OneToMany(mappedBy = "budgetApproval", cascade = { CascadeType.REMOVE })
	public List<BudgetApprovalFilesEntity> getBudgetApprovalFiles() {
		return budgetApprovalFiles;
	}

	public void setBudgetApprovalFiles(List<BudgetApprovalFilesEntity> budgetApprovalFiles) {
		this.budgetApprovalFiles = budgetApprovalFiles;
	}

	/** 类型：0 预算，1 结算 */
	@Column(name = "TYPE")
	public Integer getType() {
		return type;
	}

	/** 类型：0 预算，1 结算 */
	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "processInstanceId")
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public ProjectInfoEntity getProject() {
		return project;
	}

	public void setProject(ProjectInfoEntity project) {
		this.project = project;
	}

	/** 审核状态：0 可修改 ，1 审核中不可修改 */
	@Column(name = "ISVERIFY")
	public Integer getIsverify() {
		return isverify;
	}

	/** 审核状态：0 可修改 ，1 审核中不可修改 */
	public void setIsverify(Integer isverify) {
		this.isverify = isverify;
	}

}
