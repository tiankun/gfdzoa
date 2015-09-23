package com.gfdz.entity.gc;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 工资申报
 * @author ant
 * @date 2015-05-28 14:57:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_Wages_Declare", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class WagesDeclareEntity implements java.io.Serializable {
	/**申报人*/
	private java.lang.String declare;
	/**申报日期*/
	private java.util.Date declareDate;
	/**备注*/
	private java.lang.String remarks;
	/**项目经理审核*/
	private java.lang.String projectOpinion;
	/**部门经理审核*/
	private java.lang.String departmentOpinion;
	/**分管领导审核*/
	private java.lang.String companyOpinion;
	/**申报编号*/
	private java.lang.String id;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**月份*/
	private java.lang.String month;
	/**本次申报金额*/
	private Double amount;
	/**质保金*/
	private Double guaranteeMoney;
	/**安全互助金*/
	private Double mutualMoney;
	/**施工队*/
	private java.lang.String constructionTeam;
	
	private String processinstanceId;
	
	private String jzbyje;
	
	private String jzbybl;
	
	private String jzsyje;
	
	private String jzsybl;
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申报人
	 */
	@Column(name ="DECLARE",nullable=true,length=20)
	public java.lang.String getDeclare(){
		return this.declare;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申报人
	 */
	public void setDeclare(java.lang.String declare){
		this.declare = declare;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申报日期
	 */
	@Column(name ="DECLARE_DATE",nullable=true)
	public java.util.Date getDeclareDate(){
		return this.declareDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申报日期
	 */
	public void setDeclareDate(java.util.Date declareDate){
		this.declareDate = declareDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=500)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目经理审核
	 */
	@Column(name ="PROJECT_OPINION",nullable=true,length=200)
	public java.lang.String getProjectOpinion(){
		return this.projectOpinion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目经理审核
	 */
	public void setProjectOpinion(java.lang.String projectOpinion){
		this.projectOpinion = projectOpinion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门经理审核
	 */
	@Column(name ="DEPARTMENT_OPINION",nullable=true,length=200)
	public java.lang.String getDepartmentOpinion(){
		return this.departmentOpinion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门经理审核
	 */
	public void setDepartmentOpinion(java.lang.String departmentOpinion){
		this.departmentOpinion = departmentOpinion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分管领导审核
	 */
	@Column(name ="COMPANY_OPINION",nullable=true,length=200)
	public java.lang.String getCompanyOpinion(){
		return this.companyOpinion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分管领导审核
	 */
	public void setCompanyOpinion(java.lang.String companyOpinion){
		this.companyOpinion = companyOpinion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申报编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=50)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申报编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="PROJECT_ID")
	public ProjectInfoEntity getProject() {
		return project;
	}

	public void setProject(ProjectInfoEntity project) {
		this.project = project;
	}
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  月份
	 */
	@Column(name ="MONTH",nullable=true,length=50)
	public java.lang.String getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  月份
	 */
	public void setMonth(java.lang.String month){
		this.month = month;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  本次申报金额
	 */
	@Column(name ="AMOUNT",nullable=true)
	public Double getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  本次申报金额
	 */
	public void setAmount(Double amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  质保金
	 */
	@Column(name ="GUARANTEE_MONEY",nullable=true)
	public Double getGuaranteeMoney(){
		return this.guaranteeMoney;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  质保金
	 */
	public void setGuaranteeMoney(Double guaranteeMoney){
		this.guaranteeMoney = guaranteeMoney;
	}
	/**
	 *方法: 取得Double
	 *@return: Double  安全互助金
	 */
	@Column(name ="MUTUAL_MONEY",nullable=true)
	public Double getMutualMoney(){
		return this.mutualMoney;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  安全互助金
	 */
	public void setMutualMoney(Double mutualMoney){
		this.mutualMoney = mutualMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  施工队
	 */
	@Column(name ="CONSTRUCTION_TEAM",nullable=true,length=20)
	public java.lang.String getConstructionTeam(){
		return this.constructionTeam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  施工队
	 */
	public void setConstructionTeam(java.lang.String constructionTeam){
		this.constructionTeam = constructionTeam;
	}
	
	@Column(name ="PROCESSINSTANCEID",nullable=true,length=32)
	public String getProcessinstanceId() {
		return processinstanceId;
	}

	public void setProcessinstanceId(String processinstanceId) {
		this.processinstanceId = processinstanceId;
	}

	@Column(name ="JZBYJE")
	public String getJzbyje() {
		return jzbyje;
	}

	public void setJzbyje(String jzbyje) {
		this.jzbyje = jzbyje;
	}
	
	@Column(name ="JZBYBL")
	public String getJzbybl() {
		return jzbybl;
	}

	public void setJzbybl(String jzbybl) {
		this.jzbybl = jzbybl;
	}
	@Column(name ="JZSYJE")
	public String getJzsyje() {
		return jzsyje;
	}

	public void setJzsyje(String jzsyje) {
		this.jzsyje = jzsyje;
	}
	@Column(name ="JZSYBL")
	public String getJzsybl() {
		return jzsybl;
	}

	public void setJzsybl(String jzsybl) {
		this.jzsybl = jzsybl;
	}
	
	
}
