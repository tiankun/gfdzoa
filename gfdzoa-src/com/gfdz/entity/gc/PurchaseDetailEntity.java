package com.gfdz.entity.gc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gfdz.entity.zhb.CpEntity;

/**
 * @Title: Entity
 * @Description: 项目材料采购申请
 * @author ant
 * @date 2015-05-28 13:59:10
 * @version V1.0
 * 
 */
@Entity
@Table(name = "gc_purchase_detail", schema = "")
public class PurchaseDetailEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8835212785853692996L;
	/** 主键 */
	private String id;
	/** 采购单主键 */
	private PurchaseEntity purchase;
	/** 材料主键 */
	private MaterialBaseEntity material;
	/** 采购计划 明细 */
	private PurchasePlanDetailEntity ppd;

	private CpEntity cp;
	/** 备注 */
	private java.lang.String remark;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 32)
	public java.lang.String getId() {   
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	@Column(name = "REMARK")
	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
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
	@JoinColumn(name = "MATERIAL_ID")
	public MaterialBaseEntity getMaterial() {
		return material;
	}

	public void setMaterial(MaterialBaseEntity material) {
		this.material = material;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAN_DETAIL_ID")
	public PurchasePlanDetailEntity getPpd() {
		return ppd;
	}

	public void setPpd(PurchasePlanDetailEntity ppd) {
		this.ppd = ppd;
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
