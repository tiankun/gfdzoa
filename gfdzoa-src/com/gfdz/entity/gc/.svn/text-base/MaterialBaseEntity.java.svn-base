package com.gfdz.entity.gc;

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
 * @Description: 项目材料审计
 * @author ant
 * @date 2015-05-28 14:50:48
 * @version V1.0
 * 
 */
@Entity
@Table(name = "GC_Material_base", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class MaterialBaseEntity implements java.io.Serializable {
	/** 材料编号 */
	private java.lang.String id;
	/** 项目编号 */
	private ProjectInfoEntity project;
	/** 设备名称 */
	private CpEntity cp;
	/** 品牌 */
	private java.lang.String brand;
	/** 规格型号 */
	private java.lang.String model;
	/** 技术参数 */
	private java.lang.String parameter;
	/** 单位 */
	private java.lang.String unit;
	/** 设计数量 */
	private java.lang.Integer designAmount;
	/** 设计单价 */
	private Double designPrice;
	/** 采购数量 */
	private java.lang.Integer purchaseAmount;
	/** 采购单价 */
	private Double purchasePrice;
	/** 实到数量 */
	private java.lang.Integer receiveAmount;
	/** 安装数量 */
	private java.lang.Integer installAmount;
	/** 移交数量 */
	private java.lang.Integer transferAmount;
	/** 备注 */
	private String remark;

	/**材料类型*/
	private String ctype;
	
	public MaterialBaseEntity() {
	}

	public MaterialBaseEntity(String id) {
		super();
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 材料编号
	 */

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 50)
	public java.lang.String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 材料编号
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 项目编号
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public ProjectInfoEntity getProject() {
		return project;
	}

	public void setProject(ProjectInfoEntity project) {
		this.project = project;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 设备名称
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MATERIAL_NAME")
	public CpEntity getCp() {
		return cp;
	}

	public void setCp(CpEntity cp) {
		this.cp = cp;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 品牌
	 */
	@Column(name = "BRAND", nullable = true, length = 20)
	public java.lang.String getBrand() {
		return this.brand;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 品牌
	 */
	public void setBrand(java.lang.String brand) {
		this.brand = brand;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 规格型号
	 */
	@Column(name = "MODEL", nullable = true, length = 20)
	public java.lang.String getModel() {
		return this.model;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 规格型号
	 */
	public void setModel(java.lang.String model) {
		this.model = model;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 技术参数
	 */
	@Column(name = "PARAMETER", nullable = true, length = 200)
	public java.lang.String getParameter() {
		return this.parameter;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 技术参数
	 */
	public void setParameter(java.lang.String parameter) {
		this.parameter = parameter;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 单位
	 */
	@Column(name = "UNIT", nullable = true, length = 20)
	public java.lang.String getUnit() {
		return this.unit;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 单位
	 */
	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 设计数量
	 */
	@Column(name = "DESIGN_AMOUNT", nullable = true)
	public java.lang.Integer getDesignAmount() {
		return this.designAmount;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 设计数量
	 */
	public void setDesignAmount(java.lang.Integer designAmount) {
		this.designAmount = designAmount;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 采购数量
	 */
	@Column(name = "PURCHASE_AMOUNT", nullable = true)
	public java.lang.Integer getPurchaseAmount() {
		return this.purchaseAmount;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 采购数量
	 */
	public void setPurchaseAmount(java.lang.Integer purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 实到数量
	 */
	@Column(name = "RECEIVE_AMOUNT", nullable = true)
	public java.lang.Integer getReceiveAmount() {
		return this.receiveAmount;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 实到数量
	 */
	public void setReceiveAmount(java.lang.Integer receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 安装数量
	 */
	@Column(name = "INSTALL_AMOUNT", nullable = true)
	public java.lang.Integer getInstallAmount() {
		return this.installAmount;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 安装数量
	 */
	public void setInstallAmount(java.lang.Integer installAmount) {
		this.installAmount = installAmount;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 移交数量
	 */
	@Column(name = "TRANSFER_AMOUNT", nullable = true)
	public java.lang.Integer getTransferAmount() {
		return this.transferAmount;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 移交数量
	 */
	public void setTransferAmount(java.lang.Integer transferAmount) {
		this.transferAmount = transferAmount;
	}

	@Column(name = "PURCHASE_PRICE")
	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Column(name = "DESIGN_PRICE")
	public Double getDesignPrice() {
		return designPrice;
	}

	public void setDesignPrice(Double designPrice) {
		this.designPrice = designPrice;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Column(name = "CTYPE")
	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	
	
}
