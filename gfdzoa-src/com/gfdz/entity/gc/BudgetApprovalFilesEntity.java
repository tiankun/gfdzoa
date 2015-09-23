package com.gfdz.entity.gc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.web.system.pojo.base.TSAttachment;

/**
 * @Title: Entity
 * @Description: 预算审批表附件
 * @author ant
 * @date 2015-08-12 10:18:35
 * @version V1.0
 * 
 */
@Entity
@Table(name = "GC_BUDGET_APPROVAL_FILES")
@PrimaryKeyJoinColumn(name = "id")
@SuppressWarnings("serial")
public class BudgetApprovalFilesEntity extends TSAttachment implements java.io.Serializable {
	/** budgetApprovalId */
	private BudgetApprovalEntity budgetApproval;
	/** remarks */
	private java.lang.String remarks;
	/** createName */
	private java.lang.String createName;
	/** createBy */
	private java.lang.String createBy;
	/** createDate */
	private java.util.Date createDate;
	/** updateName */
	private java.lang.String updateName;
	/** updateBy */
	private java.lang.String updateBy;
	/** updateDate */
	private java.util.Date updateDate;

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String budgetApprovalId
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUDGET_APPROVAL_ID")
	public BudgetApprovalEntity getBudgetApproval() {
		return budgetApproval;
	}

	public void setBudgetApproval(BudgetApprovalEntity budgetApproval) {
		this.budgetApproval = budgetApproval;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String remarks
	 */
	@Column(name = "REMARKS", nullable = true, length = 200)
	public java.lang.String getRemarks() {
		return this.remarks;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String remarks
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String createName
	 */
	@Column(name = "CREATE_NAME", nullable = true, length = 50)
	public java.lang.String getCreateName() {
		return this.createName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String createName
	 */
	public void setCreateName(java.lang.String createName) {
		this.createName = createName;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String createBy
	 */
	@Column(name = "CREATE_BY", nullable = true, length = 50)
	public java.lang.String getCreateBy() {
		return this.createBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String createBy
	 */
	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date createDate
	 */
	@Column(name = "CREATE_DATE", nullable = true)
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date createDate
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String updateName
	 */
	@Column(name = "UPDATE_NAME", nullable = true, length = 50)
	public java.lang.String getUpdateName() {
		return this.updateName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String updateName
	 */
	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String updateBy
	 */
	@Column(name = "UPDATE_BY", nullable = true, length = 50)
	public java.lang.String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String updateBy
	 */
	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date updateDate
	 */
	@Column(name = "UPDATE_DATE", nullable = true)
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date updateDate
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
}
