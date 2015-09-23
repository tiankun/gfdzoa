package com.gfdz.entity.gc;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSUser;

import com.gfdz.entity.xsb.XsxmEntity;

/**   
 * @Title: Entity
 * @Description: 工程信息表
 * @author ant
 * @date 2015-05-28 14:51:47
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_Project_info")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ProjectInfoEntity implements java.io.Serializable {
	/**项目编号*/
	private java.lang.String id;
	/**项目名称*/
	private java.lang.String projectName;
	/**销售经理*/
	private TSUser salesManager;
	/**客户名称*/
	private java.lang.String customer;
	/**联系人*/
	private java.lang.String contacts;
	/**联系电话*/
	private java.lang.String contactPhone;
	/**合同编号*/
	private java.lang.String agreementNumber;
	/**合同金额*/
	private java.lang.Integer moneyAmount;
	/**项目经理*/
	private TSUser projectManager;
	/**项目状态*/
	private java.lang.String projectStatus;
	
	/**项目类型*/
	private java.lang.String projectType;
	
	/**建设类容*/
	private java.lang.String buildType;
	
	
	/**项目销售信息**/
	private List<XsxmEntity> xmmxList;
	
	/**项目设计材料**/
	private List<MaterialBaseEntity> materials;
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
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
	 *@param: java.lang.String  项目编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=100)
	public java.lang.String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProjectName(java.lang.String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得TSUser
	 *@return: TSUser  销售经理
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="SALES_MANAGER")
	public TSUser getSalesManager(){
		return this.salesManager;
	}

	/**
	 *方法: 设置TSUser
	 *@param: TSUser  销售经理
	 */
	public void setSalesManager(TSUser salesManager){
		this.salesManager = salesManager;
	}
	/**
	 *方法: 取得TSUser
	 *@return: TSUser  客户名称
	 */
	@Column(name ="CUSTOMER",nullable=true,length=100)
	public java.lang.String getCustomer(){
		return this.customer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCustomer(java.lang.String customer){
		this.customer = customer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	@Column(name ="CONTACTS",nullable=true,length=20)
	public java.lang.String getContacts(){
		return this.contacts;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setContacts(java.lang.String contacts){
		this.contacts = contacts;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="CONTACT_PHONE",nullable=true,length=20)
	public java.lang.String getContactPhone(){
		return this.contactPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setContactPhone(java.lang.String contactPhone){
		this.contactPhone = contactPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号
	 */
	@Column(name ="AGREEMENT_NUMBER",nullable=true,length=50)
	public java.lang.String getAgreementNumber(){
		return this.agreementNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同编号
	 */
	public void setAgreementNumber(java.lang.String agreementNumber){
		this.agreementNumber = agreementNumber;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  合同金额
	 */
	@Column(name ="MONEY_AMOUNT",nullable=true)
	public java.lang.Integer getMoneyAmount(){
		return this.moneyAmount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  合同金额
	 */
	public void setMoneyAmount(java.lang.Integer moneyAmount){
		this.moneyAmount = moneyAmount;
	}
	/**
	 *方法: 取得TSUser
	 *@return: TSUser  项目经理
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="PROJECT_MANAGER")
	public TSUser getProjectManager(){
		return this.projectManager;
	}

	/**
	 *方法: 设置TSUser
	 *@param: TSUser  项目经理
	 */
	public void setProjectManager(TSUser projectManager){
		this.projectManager = projectManager;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目状态
	 */
	@Column(name ="PROJECT_STATUS",nullable=true,length=10)
	public java.lang.String getProjectStatus(){
		return this.projectStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目状态
	 */
	public void setProjectStatus(java.lang.String projectStatus){
		this.projectStatus = projectStatus;
	}
	
	@Column(name ="PROJECT_TYPE")
	public java.lang.String getProjectType() {
		return projectType;
	}

	public void setProjectType(java.lang.String projectType) {
		this.projectType = projectType;
	}
	
	@Column(name ="BUILD_TYPE")
	public java.lang.String getBuildType() {
		return buildType;
	}

	public void setBuildType(java.lang.String buildType) {
		this.buildType = buildType;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="project",cascade=CascadeType.REMOVE)
	public List<XsxmEntity> getXmmxList() {
		return xmmxList;
	}

	public void setXmmxList(List<XsxmEntity> xmmxList) {
		this.xmmxList = xmmxList;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="project",cascade=CascadeType.REMOVE)
	public List<MaterialBaseEntity> getMaterials() {
		return materials;
	}

	public void setMaterials(List<MaterialBaseEntity> materials) {
		this.materials = materials;
	}
	
	
	
}
