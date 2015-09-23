package com.gfdz.entity.cw;

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
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;

import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.gc.PurchaseEntity;
import com.gfdz.entity.zhb.GysmlEntity;

/**
 * @Title: Entity
 * @Description: 款项支付
 * @author ant
 * @date 2015-07-24 15:41:39
 * @version V1.0
 * 
 */
@Entity
@Table(name = "cw_payfor", schema = "")
@SuppressWarnings("serial")
public class PayforEntity implements java.io.Serializable {
	/** 主键 */
	private String id;
	/** 申请人 */
	private TSUser user;
	/** 申请时间 */
	private java.util.Date odate;
	/** 总金额 */
	private Double totalMoney;
	/** 审批阶段 */
	private String payforstate;
	/** 部门 */
	private TSDepart depart;
	/** 备注 */
	private String remark;
	/** 大写金额 */
	private String upperChn;
	/** 付款方式 */
	private Integer payType;
	/** 审核意见 */
	private String reason;
	/** 会计选择类型 */
	private String kjtype;
	/** 作废原因 */
	private String zfreason;
	/** 配给单类型 */
	private String pjdtype;
	/** 与材料无关额款项支付 */
	private String type;
	/** 打印标志 */
	private String print;
	/** 收款单位 */
	private GysmlEntity skId;
	/** 项目 */
	private ProjectInfoEntity project;
	/** 流程实例ID */
	private String processInstanceId;
	/** 财务报账明细 */
	private List<PayforDetailEntity> payforDetail;
	/** 采购执行单 */
	private List<PurchaseEntity> purchases;

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 36)
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

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 申请时间
	 */
	@Column(name = "ODATE", nullable = true, length = 32)
	public java.util.Date getOdate() {
		return this.odate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 申请时间
	 */
	public void setOdate(java.util.Date odate) {
		this.odate = odate;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 审批阶段
	 */
	@Column(name = "PAYFORSTATE", nullable = true, length = 32)
	public String getPayforstate() {
		return this.payforstate;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 审批阶段
	 */
	public void setPayforstate(String payforstate) {
		this.payforstate = payforstate;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 部门
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPART")
	public TSDepart getDepart() {
		return this.depart;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 部门
	 */
	public void setDepart(TSDepart depart) {
		this.depart = depart;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 大写金额
	 */
	@Column(name = "UPPER_CHN", nullable = true, length = 200)
	public String getUpperChn() {
		return this.upperChn;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 大写金额
	 */
	public void setUpperChn(String upperChn) {
		this.upperChn = upperChn;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 审核意见
	 */
	@Column(name = "REASON", nullable = true, length = 200)
	public String getReason() {
		return this.reason;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 审核意见
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 会计选择类型
	 */
	@Column(name = "KJTYPE", nullable = true, length = 32)
	public String getKjtype() {
		return this.kjtype;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 会计选择类型
	 */
	public void setKjtype(String kjtype) {
		this.kjtype = kjtype;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 作废原因
	 */
	@Column(name = "ZFREASON", nullable = true, length = 32)
	public String getZfreason() {
		return this.zfreason;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 作废原因
	 */
	public void setZfreason(String zfreason) {
		this.zfreason = zfreason;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 配给单类型
	 */
	@Column(name = "PJDTYPE", nullable = true, length = 32)
	public String getPjdtype() {
		return this.pjdtype;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 配给单类型
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 与材料无关额款项支付
	 */
	@Column(name = "TYPE", nullable = true, length = 32)
	public String getType() {
		return this.type;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 与材料无关额款项支付
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 打印标志
	 */
	@Column(name = "PRINT", nullable = true, length = 32)
	public String getPrint() {
		return this.print;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 打印标志
	 */
	public void setPrint(String print) {
		this.print = print;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 收款单位
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SK_ID")
	public GysmlEntity getSkId() {
		return this.skId;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 收款单位
	 */
	public void setSkId(GysmlEntity skId) {
		this.skId = skId;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 项目
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT")
	public ProjectInfoEntity getProject() {
		return this.project;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 项目
	 */
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

	@OneToMany(mappedBy = "payfor", cascade = { CascadeType.ALL })
	public List<PayforDetailEntity> getPayforDetail() {
		return payforDetail;
	}

	public void setPayforDetail(List<PayforDetailEntity> payforDetail) {
		this.payforDetail = payforDetail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payfor")
	public List<PurchaseEntity> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<PurchaseEntity> purchases) {
		this.purchases = purchases;
	}

	@Column(name = "PROCESSINSTANCEID")
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Column(name = "PAY_TYPE")
	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	@Column(name = "TOTAL_MONEY")
	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
