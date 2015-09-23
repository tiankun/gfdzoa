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

import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.gc.PurchaseEntity;
import com.gfdz.entity.zhb.GysmlEntity;

/**
 * @Title: Entity
 * @Description: 款项支付子表
 * @author ant
 * @date 2015-07-27 10:12:52
 * @version V1.0
 * 
 */
@Entity
@Table(name = "cw_payforDetail")
@SuppressWarnings("serial")
public class PayforDetailEntity implements java.io.Serializable {
	/** 主键 */
	private String id;
	/** 采购单 */
	private PurchaseEntity purchase;

	/** 材料数量 */
	private Integer num;
	/** 材料单价 */
	private Double price;

	/** 付款金额 */
	private Double money;
	/** 付款申请人 */
	private TSUser user;
	/** 付款时间 */
	private Date odate;
	/** 供应商 */
	private GysmlEntity gysml;
	/** 款项支付主表 */
	private PayforEntity payfor;
	/** 申请事由 */
	private String applyreason;
	/** 附件数量 */
	private Integer fujnum;
	/** 项目 */
	private ProjectInfoEntity project;

	/** 创建时间 **/
	private Date createDate;

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

	/**
	 * 方法: 取得Integer
	 * 
	 * @return: Integer 材料数量
	 */
	@Column(name = "NUM", nullable = true, length = 32)
	public Integer getNum() {
		return this.num;
	}

	/**
	 * 方法: 设置Integer
	 * 
	 * @param: Integer 材料数量
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * 方法: 取得Double
	 * 
	 * @return: Double 材料单价
	 */
	@Column(name = "PRICE", nullable = true, length = 32)
	public Double getPrice() {
		return this.price;
	}

	/**
	 * 方法: 设置Double
	 * 
	 * @param: Double 材料单价
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 方法: 取得Double
	 * 
	 * @return: Double 付款金额
	 */
	@Column(name = "MONEY", nullable = true, length = 32)
	public Double getMoney() {
		return this.money;
	}

	/**
	 * 方法: 设置Double
	 * 
	 * @param: Double 付款金额
	 */
	public void setMoney(Double money) {
		this.money = money;
	}

	@Column(name = "ODATE", nullable = true, length = 32)
	public java.util.Date getOdate() {
		return this.odate;
	}

	public void setOdate(java.util.Date odate) {
		this.odate = odate;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 款项支付主表
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYFOR")
	public PayforEntity getPayfor() {
		return this.payfor;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 款项支付主表
	 */
	public void setPayfor(PayforEntity payfor) {
		this.payfor = payfor;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 申请事由
	 */
	@Column(name = "APPLYREASON", nullable = true, length = 200)
	public String getApplyreason() {
		return this.applyreason;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 申请事由
	 */
	public void setApplyreason(String applyreason) {
		this.applyreason = applyreason;
	}

	/**
	 * 方法: 取得Integer
	 * 
	 * @return: Integer 附件数量
	 */
	@Column(name = "FUJNUM", nullable = true, length = 32)
	public Integer getFujnum() {
		return this.fujnum;
	}

	/**
	 * 方法: 设置Integer
	 * 
	 * @param: Integer 附件数量
	 */
	public void setFujnum(Integer fujnum) {
		this.fujnum = fujnum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PURCHASE_ID")
	public PurchaseEntity getPurchase() {
		return purchase;
	}

	public void setPurchase(PurchaseEntity purchase) {
		this.purchase = purchase;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public TSUser getUser() {
		return user;
	}

	public void setUser(TSUser user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GYSML")
	public GysmlEntity getGysml() {
		return gysml;
	}

	public void setGysml(GysmlEntity gysml) {
		this.gysml = gysml;
	}

	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT")
	public ProjectInfoEntity getProject() {
		return project;
	}

	public void setProject(ProjectInfoEntity project) {
		this.project = project;
	}
}
