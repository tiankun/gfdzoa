package com.buss.entity.acs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 利润分析
 * @author ant
 * @date 2015-03-27 11:40:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_base_Profit", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ProfitEntity implements java.io.Serializable {
	/**id*/
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
	/**订单号*/
	private java.lang.String orderNumber;
	/**销售价*/
	private java.lang.Double sales;
	/**成本价*/
	private java.lang.Double cost;
	/**人力成本*/
	private java.lang.Double humanCost;
	/**税收*/
	private java.lang.Double tax;
	/**交通通讯费用*/
	private java.lang.Double otherCost;
	/**总利润*/
	private java.lang.Double profit;
	/**总公司*/
	private java.lang.Double zgsProfit;
	/**合作伙伴*/
	private java.lang.Double partnersProfit;
	/**运营团队*/
	private java.lang.Double teamProfit;
	/**备注*/
	private java.lang.String cnote;
	/**安装费*/
	private Double anzmoney;		
	/**服务费*/
	private Double fuwumoney;	
	/**服务年限*/
	private Integer fuwunum;		

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
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
	@Column(name ="CREATE_DATE",nullable=true)
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
	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *@return: java.lang.String  订单号
	 */
	@Column(name ="ORDER_NUMBER",nullable=true,length=32)
	public java.lang.String getOrderNumber(){
		return this.orderNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单号
	 */
	public void setOrderNumber(java.lang.String orderNumber){
		this.orderNumber = orderNumber;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  销售价
	 */
	@Column(name ="SALES",nullable=true,precision=22)
	public java.lang.Double getSales(){
		return this.sales;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  销售价
	 */
	public void setSales(java.lang.Double sales){
		this.sales = sales;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  成本价
	 */
	@Column(name ="COST",nullable=true,precision=22)
	public java.lang.Double getCost(){
		return this.cost;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  成本价
	 */
	public void setCost(java.lang.Double cost){
		this.cost = cost;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  人力成本
	 */
	@Column(name ="HUMAN_COST",nullable=true,precision=22)
	public java.lang.Double getHumanCost(){
		return this.humanCost;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  人力成本
	 */
	public void setHumanCost(java.lang.Double humanCost){
		this.humanCost = humanCost;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  税收
	 */
	@Column(name ="TAX",nullable=true,precision=22)
	public java.lang.Double getTax(){
		return this.tax;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  税收
	 */
	public void setTax(java.lang.Double tax){
		this.tax = tax;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  交通通讯费用
	 */
	@Column(name ="OTHER_COST",nullable=true,precision=22)
	public java.lang.Double getOtherCost(){
		return this.otherCost;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  交通通讯费用
	 */
	public void setOtherCost(java.lang.Double otherCost){
		this.otherCost = otherCost;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  总利润
	 */
	@Column(name ="PROFIT",nullable=true,precision=22)
	public java.lang.Double getProfit(){
		return this.profit;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  总利润
	 */
	public void setProfit(java.lang.Double profit){
		this.profit = profit;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  总公司
	 */
	@Column(name ="ZGS_PROFIT",nullable=true,precision=22)
	public java.lang.Double getZgsProfit(){
		return this.zgsProfit;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  总公司
	 */
	public void setZgsProfit(java.lang.Double zgsProfit){
		this.zgsProfit = zgsProfit;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  合作伙伴
	 */
	@Column(name ="PARTNERS_PROFIT",nullable=true,precision=22)
	public java.lang.Double getPartnersProfit(){
		return this.partnersProfit;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  合作伙伴
	 */
	public void setPartnersProfit(java.lang.Double partnersProfit){
		this.partnersProfit = partnersProfit;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  运营团队
	 */
	@Column(name ="TEAM_PROFIT",nullable=true,precision=22)
	public java.lang.Double getTeamProfit(){
		return this.teamProfit;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  运营团队
	 */
	public void setTeamProfit(java.lang.Double teamProfit){
		this.teamProfit = teamProfit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="CNOTE",nullable=true,length=32)
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
	@Column(name ="ANZMONEY")
	public Double getAnzmoney() {
		return anzmoney;
	}

	public void setAnzmoney(Double anzmoney) {
		this.anzmoney = anzmoney;
	}
	
	@Column(name ="FUWUMONEY")
	public Double getFuwumoney() {
		return fuwumoney;
	}

	public void setFuwumoney(Double fuwumoney) {
		this.fuwumoney = fuwumoney;
	}

	public Integer getFuwunum() {
		return fuwunum;
	}
	
	@Column(name ="FUWUNUM")
	public void setFuwunum(Integer fuwunum) {
		this.fuwunum = fuwunum;
	}
	
	
}
