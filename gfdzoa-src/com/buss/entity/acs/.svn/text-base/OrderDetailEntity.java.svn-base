package com.buss.entity.acs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 订单
 * @author onlineGenerator
 * @date 2015-03-23 15:55:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_base_order_detail", schema = "")
@SuppressWarnings("serial")
public class OrderDetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**商品*/
	private GoodsEntity goods;
	/**商品数量*/
	@Excel(name="商品数量")
	private java.lang.Integer goodsNum;
	/**商品金额*/
	@Excel(name="商品金额")
	private java.lang.Double goodsMoney;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String cnote;
	/**订单*/
	private OrderEntity corder;
	/**供货商*/
	private SupplierEntity supplier;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="GOODS")
	public GoodsEntity getGoods(){
		return this.goods;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品
	 */
	public void setGoods(GoodsEntity goods){
		this.goods = goods;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商品数量
	 */
	@Column(name ="GOODS_NUM",nullable=true,length=32)
	public java.lang.Integer getGoodsNum(){
		return this.goodsNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商品数量
	 */
	public void setGoodsNum(java.lang.Integer goodsNum){
		this.goodsNum = goodsNum;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  商品金额
	 */
	@Column(name ="GOODS_MONEY",nullable=true,length=32)
	public java.lang.Double getGoodsMoney(){
		return this.goodsMoney;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  商品金额
	 */
	public void setGoodsMoney(java.lang.Double goodsMoney){
		this.goodsMoney = goodsMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="CNOTE",nullable=true,length=255)
	public java.lang.String getCnote(){
		return this.cnote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setCnote(java.lang.String cnote){
		this.cnote = cnote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="CORDER")
	public OrderEntity getCorder(){
		return this.corder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单
	 */
	public void setCorder(OrderEntity corder){
		this.corder = corder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供货商
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="SUPPLIER")
	public SupplierEntity getSupplier(){
		return this.supplier;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供货商
	 */
	public void setSupplier(SupplierEntity supplier){
		this.supplier = supplier;
	}
}
