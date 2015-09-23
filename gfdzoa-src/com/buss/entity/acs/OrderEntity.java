package com.buss.entity.acs;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**   
 * @Title: Entity
 * @Description: 订单表
 * @author onlineGenerator
 * @date 2015-03-23 15:55:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_base_order", schema = "")
@SuppressWarnings("serial")
public class OrderEntity implements java.io.Serializable {
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
	/**订单编号*/
	private java.lang.String orderNumber;
	/**预约时间*/
	private java.util.Date orderDate;
	/**发票说明*/
	private java.lang.String orderNote;
	
	/**订单金额*/
	private Double orderMoney;
	/**订单类型*/
	private java.lang.String orderType;
	
	/**联系电话*/
	private java.lang.String orderPhone;
	
	/**联系地址*/
	private java.lang.String orderAddress;
	
	/**销售人*/
	private java.lang.String orderSaleser;
	
	private List<OrderDetailEntity> orderDetail;
	
	
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
	 *@return: java.lang.String  订单编号
	 */
	
	@Column(name ="ORDER_NUMBER",nullable=true,length=32)
	public java.lang.String getOrderNumber(){
		return this.orderNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单编号
	 */
	public void setOrderNumber(java.lang.String orderNumber){
		this.orderNumber = orderNumber;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预约时间
	 */
	
	@Column(name ="ORDER_DATE",nullable=true,length=32)
	public java.util.Date getOrderDate(){
		return this.orderDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预约时间
	 */
	public void setOrderDate(java.util.Date orderDate){
		this.orderDate = orderDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票说明
	 */
	
	@Column(name ="ORDER_NOTE",nullable=true,length=32)
	public java.lang.String getOrderNote(){
		return this.orderNote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票说明
	 */
	public void setOrderNote(java.lang.String orderNote){
		this.orderNote = orderNote;
	}
	
	
	@Column(name ="ORDER_MONEY")
	public Double getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	
	@Column(name ="ORDER_TYPE")
	public java.lang.String getOrderType() {
		return orderType;
	}

	public void setOrderType(java.lang.String orderType) {
		this.orderType = orderType;
	}
	
	@Column(name ="ORDER_PHONE")
	public java.lang.String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(java.lang.String orderPhone) {
		this.orderPhone = orderPhone;
	}
	
	@Column(name ="ORDER_ADDRESS")
	public java.lang.String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(java.lang.String orderAddress) {
		this.orderAddress = orderAddress;
	}
	
	
	@Column(name ="ORDER_SALESER")
	public java.lang.String getOrderSaleser() {
		return orderSaleser;
	}

	public void setOrderSaleser(java.lang.String orderSaleser) {
		this.orderSaleser = orderSaleser;
	}

	@OneToMany(mappedBy = "corder", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	public List<OrderDetailEntity> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetailEntity> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
	
}
