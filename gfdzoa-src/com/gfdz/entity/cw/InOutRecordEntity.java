package com.gfdz.entity.cw;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSUser;

@Entity
@Table(name = "cw_inout_record")
public class InOutRecordEntity {
	/** 主键 */
	private String id;
	/** 单据编号 */
	private String billCode;
	/** 单据类型 */
	private String billType;
	/** 出入类型 1：收入，-1支出 */
	private Integer inoutType;
	/** 收入 */
	private Double incomeMoney;
	/** 支出 */
	private Double payoutMoney;
	/** 支付方式 */
	private Integer payType;
	/** 发生时间 */
	private Date payTime;
	/** 经办人 */
	private TSUser user;
	/** 发票编号 */
	private String code;
	/** 开票时间 */
	private Date makeCodeDate;
	
	private Date createTime;
	
	private String createName;

	

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

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

	@Column(name = "BILL_TYPE")
	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	/** 收入 */
	@Column(name = "INCOME_MONEY")
	public Double getIncomeMoney() {
		return incomeMoney;
	}

	/** 收入 */
	public void setIncomeMoney(Double incomeMoney) {
		this.incomeMoney = incomeMoney;
	}

	/** 支出 */
	@Column(name = "PAYOUT_MONEY")
	public Double getPayoutMoney() {
		return payoutMoney;
	}

	/** 支出 */
	public void setPayoutMoney(Double payoutMoney) {
		this.payoutMoney = payoutMoney;
	}

	/** 出入类型 1：收入，-1支出 */
	@Column(name = "INOUT_TYPE")
	public Integer getInoutType() {
		return inoutType;
	}

	/** 出入类型 1：收入，-1支出 */
	public void setInoutType(Integer inoutType) {
		this.inoutType = inoutType;
	}

	/** 发生时间 */
	@Column(name = "PAY_TIME")
	public Date getPayTime() {
		return payTime;
	}

	/** 发生时间 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public TSUser getUser() {
		return user;
	}

	public void setUser(TSUser user) {
		this.user = user;
	}

	/** 支付方式 */
	@Column(name = "PAY_TYPE")
	public Integer getPayType() {
		return payType;
	}

	/** 支付方式 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	/** 发票编号 */
	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	/** 发票编号 */
	public void setCode(String code) {
		this.code = code;
	}

	/** 开票时间 */
	@Column(name = "MAKE_CODE_DATE")
	public Date getMakeCodeDate() {
		return makeCodeDate;
	}

	/** 开票时间 */
	public void setMakeCodeDate(Date makeCodeDate) {
		this.makeCodeDate = makeCodeDate;
	}

	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "CREATE_NAME")
	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}
}
