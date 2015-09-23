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

/**   
 * @Title: Entity
 * @Description: 安全检查
 * @author ant
 * @date 2015-05-28 14:56:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_SAFETY_CHECK", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SafetyCheckEntity implements java.io.Serializable {
	/**巡检编号*/
	private java.lang.String id;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**工程名称*/
	private java.lang.String engineering;
	/**参检人员*/
	private java.lang.String projectManager;
	/**检查类别*/
	private java.lang.String constructionTeam;
	/**检查内容*/
	private java.lang.String qualityMan;
	/**存在隐患*/
	private java.lang.String inspectionPlace;
	/**整改措施*/
	private java.lang.String question;
	/**落实人*/
	private java.lang.String implementPerson;
	/**检查结论*/
	private java.lang.String conclusion;
	/**检查日期*/
	private java.util.Date qualityDate;
	
	private List<SafetyCheckFilesEntity> safetyCheckFiles;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  巡检编号
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
	 *@param: java.lang.String  巡检编号
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
	 *@return: java.lang.String  工程名称
	 */
	@Column(name ="ENGINEERING",nullable=true,length=100)
	public java.lang.String getEngineering(){
		return this.engineering;
	}

	

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工程名称
	 */
	public void setEngineering(java.lang.String engineering){
		this.engineering = engineering;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参检人员
	 */
	@Column(name ="PROJECT_MANAGER",nullable=true,length=100)
	public java.lang.String getProjectManager(){
		return this.projectManager;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参检人员
	 */
	public void setProjectManager(java.lang.String projectManager){
		this.projectManager = projectManager;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查类别
	 */
	@Column(name ="CONSTRUCTION_TEAM",nullable=true,length=50)
	public java.lang.String getConstructionTeam(){
		return this.constructionTeam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查类别
	 */
	public void setConstructionTeam(java.lang.String constructionTeam){
		this.constructionTeam = constructionTeam;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查内容
	 */
	@Column(name ="QUALITY_MAN",nullable=true,length=500)
	public java.lang.String getQualityMan(){
		return this.qualityMan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查内容
	 */
	public void setQualityMan(java.lang.String qualityMan){
		this.qualityMan = qualityMan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存在隐患
	 */
	@Column(name ="INSPECTION_PLACE",nullable=true,length=500)
	public java.lang.String getInspectionPlace(){
		return this.inspectionPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存在隐患
	 */
	public void setInspectionPlace(java.lang.String inspectionPlace){
		this.inspectionPlace = inspectionPlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  整改措施
	 */
	@Column(name ="QUESTION",nullable=true,length=500)
	public java.lang.String getQuestion(){
		return this.question;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  整改措施
	 */
	public void setQuestion(java.lang.String question){
		this.question = question;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  落实人
	 */
	@Column(name ="IMPLEMENT_PERSON",nullable=true,length=20)
	public java.lang.String getImplementPerson(){
		return this.implementPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  落实人
	 */
	public void setImplementPerson(java.lang.String implementPerson){
		this.implementPerson = implementPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查结论
	 */
	@Column(name ="CONCLUSION",nullable=true,length=500)
	public java.lang.String getConclusion(){
		return this.conclusion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查结论
	 */
	public void setConclusion(java.lang.String conclusion){
		this.conclusion = conclusion;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  检查日期
	 */
	@Column(name ="QUALITY_DATE",nullable=true)
	public java.util.Date getQualityDate(){
		return this.qualityDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  检查日期
	 */
	public void setQualityDate(java.util.Date qualityDate){
		this.qualityDate = qualityDate;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="safetyCheck")
	public List<SafetyCheckFilesEntity> getSafetyCheckFiles() {
		return safetyCheckFiles;
	}

	public void setSafetyCheckFiles(List<SafetyCheckFilesEntity> safetyCheckFiles) {
		this.safetyCheckFiles = safetyCheckFiles;
	}
	
	
}
