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
 * @Description: 产品进出表
 * @author onlineGenerator
 * @date 2015-03-30 09:22:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_base_goodsinout", schema = "")
@SuppressWarnings("serial")
public class GoodsinoutEntity implements java.io.Serializable {
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
	/**产品id*/
	@Excel(name="产品id")
	private GoodsEntity goods;
	/**产品数量*/
	@Excel(name="产品数量")
	private java.lang.Integer goodsNum;
	/**状态*/
	@Excel(name="状态")
	private java.lang.String goodsState;
	/**进出类型*/
	@Excel(name="进出类型")
	private java.lang.String inorout;
	/**订单编号*/
	private java.lang.String orderNumber;
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
	 *@return: java.lang.String  产品id
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="GOODS_ID")
	public GoodsEntity getGoods(){
		return this.goods;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品id
	 */
	public void setGoods(GoodsEntity goods){
		this.goods = goods;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  产品数量
	 */
	@Column(name ="GOODS_NUM",nullable=true,length=32)
	public java.lang.Integer getGoodsNum(){
		return this.goodsNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  产品数量
	 */
	public void setGoodsNum(java.lang.Integer goodsNum){
		this.goodsNum = goodsNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="GOODS_STATE",nullable=true,length=32)
	public java.lang.String getGoodsState(){
		return this.goodsState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setGoodsState(java.lang.String goodsState){
		this.goodsState = goodsState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进出类型
	 */
	@Column(name ="INOROUT",nullable=true,length=32)
	public java.lang.String getInorout(){
		return this.inorout;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进出类型
	 */
	public void setInorout(java.lang.String inorout){
		this.inorout = inorout;
	}
	@Column(name ="ORDER_NUMBER")
	public java.lang.String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(java.lang.String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	
}
