package com.gfdz.entity.gc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.gfdz.entity.zhb.CpEntity;

/**
 * @Title: Entity
 * @Description: 项目材料采购计划
 * @author ant
 * @date 2015-05-28 13:57:46
 * @version V1.0
 * 
 */
@Entity
@Table(name = "gc_purchase_plan_detail", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PurchasePlanDetailEntity implements java.io.Serializable {
	/** 主键 */
	private String id;
	/** 采购计划主键 */
	private PurchasePlanEntity purchasePlan;
	/** 材料主键 */
	private MaterialBaseEntity material;
	/** 产品 **/
	private CpEntity cp;
	/** 计划数量 */
	private Integer planNumber;
	/** 计划单价 */
	private Double planPrice;
	/** 到货时间 */
	private Date requireTime;

	/** 是否已经生成 采购单 (1：是，0：否） */
	private Integer state;

	/** 申请说明 */
	private String palanExplain;
	/** 审核数量 */
	private Integer examineNumber;
	/** 审核单价 */
	private Double examinePrice;
	/** 审批说明 */
	private String examineExplain;
	/** 备注 */
	private String remark;

	public PurchasePlanDetailEntity() {
	}

	public PurchasePlanDetailEntity(String id) {
		super();
		this.id = id;
	}

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

	/**
	 * 方法: 取得Integer
	 * 
	 * @return: Integer 计划数量
	 */
	@Column(name = "PLAN_NUMBER", nullable = false)
	public Integer getPlanNumber() {
		return this.planNumber;
	}

	/**
	 * 方法: 设置Integer
	 * 
	 * @param: Integer 计划数量
	 */
	public void setPlanNumber(Integer planNumber) {
		this.planNumber = planNumber;
	}

	/**
	 * 方法: 取得Integer
	 * 
	 * @return: Integer 计划单价
	 */
	@Column(name = "PLAN_PRICE", nullable = false)
	public Double getPlanPrice() {
		return this.planPrice;
	}

	/**
	 * 方法: 设置Integer
	 * 
	 * @param: Integer 计划单价
	 */
	public void setPlanPrice(Double planPrice) {
		this.planPrice = planPrice;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 申请说明
	 */
	@Column(name = "PALAN_EXPLAIN", nullable = true, length = 500)
	public String getPalanExplain() {
		return this.palanExplain;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 申请说明
	 */
	public void setPalanExplain(String palanExplain) {
		this.palanExplain = palanExplain;
	}

	/**
	 * 方法: 取得Integer
	 * 
	 * @return: Integer 审核数量
	 */
	@Column(name = "EXAMINE_NUMBER", nullable = true)
	public Integer getExamineNumber() {
		return this.examineNumber;
	}

	/**
	 * 方法: 设置Integer
	 * 
	 * @param: Integer 审核数量
	 */
	public void setExamineNumber(Integer examineNumber) {
		this.examineNumber = examineNumber;
	}

	/**
	 * 方法: 取得Integer
	 * 
	 * @return: Integer 审核单价
	 */
	@Column(name = "EXAMINE_PRICE", nullable = true)
	public Double getExaminePrice() {
		return this.examinePrice;
	}

	/**
	 * 方法: 设置Integer
	 * 
	 * @param: Integer 审核单价
	 */
	public void setExaminePrice(Double examinePrice) {
		this.examinePrice = examinePrice;
	}

	/**
	 * 方法: 取得String
	 * 
	 * @return: String 审批说明
	 */
	@Column(name = "EXAMINE_EXPLAIN", nullable = true, length = 500)
	public String getExamineExplain() {
		return this.examineExplain;
	}

	/**
	 * 方法: 设置String
	 * 
	 * @param: String 审批说明
	 */
	public void setExamineExplain(String examineExplain) {
		this.examineExplain = examineExplain;
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
	@JoinColumn(name = "PROJECT_MATERIAL_ID")
	public MaterialBaseEntity getMaterial() {
		return material;
	}

	public void setMaterial(MaterialBaseEntity material) {
		this.material = material;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_PLAN_ID")
	public PurchasePlanEntity getPurchasePlan() {
		return purchasePlan;
	}

	public void setPurchasePlan(PurchasePlanEntity purchasePlan) {
		this.purchasePlan = purchasePlan;
	}

	@Column(name = "REQUIRE_TIME")
	public Date getRequireTime() {
		return requireTime;
	}

	public void setRequireTime(Date requireTime) {
		this.requireTime = requireTime;
	}

	@Column(name = "STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CP_ID")
	public CpEntity getCp() {
		return cp;
	}

	public void setCp(CpEntity cp) {
		this.cp = cp;
	}

}
