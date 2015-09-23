package com.gfdz.entity.gc;

import java.util.Date;
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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSUser;

import com.gfdz.entity.cw.PayforEntity;
import com.gfdz.entity.zhb.GysmlEntity;

/**
 * @Title: Entity
 * @Description: 项目材料采购申请
 * @author ant
 * @date 2015-05-28 13:58:18
 * @version V1.0
 * 
 */
@Entity
@Table(name = "gc_purchase", schema = "")
public class PurchaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8230293026042600043L;
	/** 主键 */
	private java.lang.String id;
	/** 单号 */
	private String billCode;
	/** 单据类型 */
	private String billType;
	/** 项目主键 */
	private ProjectInfoEntity project;
	/** 用户主键 */
	private TSUser user;
	/** 申请时间 */
	private java.util.Date inputTime;
	/** 流程 实例ID */
	private java.lang.String processinstanceid;
	/** 备注 */
	private java.lang.String remark;

	private PurchasePlanEntity plan;

	private List<PurchaseDetailEntity> pd;

	private PayforEntity payfor;

	/** 要求到货时间 */
	private java.util.Date requireTime;
	/** 到货联系人 */
	private java.lang.String linkman;
	/** 到货联系人电话 */
	private java.lang.String contactNumber;
	/** 预付款 */
	private Double advance;
	/** 应付金额 */
	private Double yfMoney;
	/** 实付金额 */
	private Double payMoney;
	/** 供应商名录 **/
	private GysmlEntity gys;
	/** 付全款后几天到货 **/
	private Integer days;
	/** 到货状态 1：已到货 **/
	private Integer arriving;
	/** 到货时间 **/
	private Date arrivalDate;
	/** 欠款金额 */
	private transient Double qkMoney;

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 主键
	 */

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false)
	public java.lang.String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 主键
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 申请时间
	 */
	@Column(name = "INPUT_TIME", nullable = true, scale = 6)
	public java.util.Date getInputTime() {
		return this.inputTime;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 申请时间
	 */
	public void setInputTime(java.util.Date inputTime) {
		this.inputTime = inputTime;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 要求到货时间
	 */
	@Column(name = "REQUIRE_TIME", nullable = true)
	public java.util.Date getRequireTime() {
		return this.requireTime;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 要求到货时间
	 */
	public void setRequireTime(java.util.Date requireTime) {
		this.requireTime = requireTime;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 到货联系人
	 */
	@Column(name = "LINKMAN", nullable = true, length = 30)
	public java.lang.String getLinkman() {
		return this.linkman;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 到货联系人
	 */
	public void setLinkman(java.lang.String linkman) {
		this.linkman = linkman;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 到货联系人电话
	 */
	@Column(name = "CONTACT_NUMBER", nullable = true, length = 50)
	public java.lang.String getContactNumber() {
		return this.contactNumber;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 到货联系人电话
	 */
	public void setContactNumber(java.lang.String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 流程id
	 */
	@Column(name = "PROCESSINSTANCEID", nullable = true, length = 32)
	public java.lang.String getProcessinstanceid() {
		return this.processinstanceid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 流程id
	 */
	public void setProcessinstanceid(java.lang.String processinstanceid) {
		this.processinstanceid = processinstanceid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 备注
	 */
	@Column(name = "REMARK", length = 500)
	public java.lang.String getRemark() {
		return this.remark;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 备注
	 */
	public void setRemark(java.lang.String remark) {
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
	@JoinColumn(name = "PURCHASE_PLAN_ID")
	public PurchasePlanEntity getPlan() {
		return plan;
	}

	public void setPlan(PurchasePlanEntity plan) {
		this.plan = plan;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "purchase", cascade = { CascadeType.REMOVE })
	public List<PurchaseDetailEntity> getPd() {
		return pd;
	}

	public void setPd(List<PurchaseDetailEntity> pd) {
		this.pd = pd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public TSUser getUser() {
		return user;
	}

	public void setUser(TSUser user) {
		this.user = user;
	}

	@Column(name = "ADVANCE")
	public Double getAdvance() {
		return advance;
	}

	public void setAdvance(Double advance) {
		this.advance = advance;
	}

	@Column(name = "BILL_CODE")
	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYFOR_ID")
	public PayforEntity getPayfor() {
		return payfor;
	}

	public void setPayfor(PayforEntity payfor) {
		this.payfor = payfor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GYS_ID")
	public GysmlEntity getGys() {
		return gys;
	}

	public void setGys(GysmlEntity gys) {
		this.gys = gys;
	}

	/** 应付金额 */
	@Column(name = "YF_MONEY")
	public Double getYfMoney() {
		return yfMoney;
	}

	/** 应付金额 */
	public void setYfMoney(Double yfMoney) {
		this.yfMoney = yfMoney;
	}

	/** 实付金额 */
	@Column(name = "PAY_MONEY")
	public Double getPayMoney() {
		return payMoney;
	}

	/** 实付金额 */
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	@Transient
	public Double getQkMoney() {
		return this.yfMoney - this.payMoney;
	}

	@Column(name = "BILL_TYPE")
	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	@Column(name = "days")
	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	/** 到货状态 1：已到货 **/
	@Column(name = "arriving")
	public Integer getArriving() {
		return arriving;
	}

	/** 到货状态 1：已到货 **/
	public void setArriving(Integer arriving) {
		this.arriving = arriving;
	}

	@Column(name = "ARRIVAL_DATE")
	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
}
