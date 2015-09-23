package com.gfdz.entity.gc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 质量管理
 * @author ant
 * @date 2015-05-28 14:56:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_Quality_check", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class QualityCheckEntity implements java.io.Serializable {
	/**巡检编号*/
	private java.lang.String id;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**工程名称*/
	private java.lang.String engineering;
	/**项目经理*/
	private java.lang.String projectManager;
	/**操作组*/
	private java.lang.String constructionTeam;
	/**质检员*/
	private java.lang.String qualityPerson;
	/**检查地点*/
	private java.lang.String inspectionPlace;
	/**问题描述*/
	private java.lang.String question;
	/**巡检日期*/
	private java.util.Date qualityDate;
	
	
	private List<QualityCheckFilesEntity> qualityCheckFiles;
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
	 *@return: java.lang.String  项目经理
	 */
	@Column(name ="PROJECT_MANAGER",nullable=true,length=20)
	public java.lang.String getProjectManager(){
		return this.projectManager;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目经理
	 */
	public void setProjectManager(java.lang.String projectManager){
		this.projectManager = projectManager;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作组
	 */
	@Column(name ="CONSTRUCTION_TEAM",nullable=true,length=50)
	public java.lang.String getConstructionTeam(){
		return this.constructionTeam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作组
	 */
	public void setConstructionTeam(java.lang.String constructionTeam){
		this.constructionTeam = constructionTeam;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  质检员
	 */
	@Column(name ="QUALITY_PERSON",nullable=true,length=20)
	public java.lang.String getQualityPerson(){
		return this.qualityPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  质检员
	 */
	public void setQualityPerson(java.lang.String qualityPerson){
		this.qualityPerson = qualityPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查地点
	 */
	@Column(name ="INSPECTION_PLACE",nullable=true,length=100)
	public java.lang.String getInspectionPlace(){
		return this.inspectionPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查地点
	 */
	public void setInspectionPlace(java.lang.String inspectionPlace){
		this.inspectionPlace = inspectionPlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题描述
	 */
	@Column(name ="QUESTION",nullable=true,length=500)
	public java.lang.String getQuestion(){
		return this.question;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题描述
	 */
	public void setQuestion(java.lang.String question){
		this.question = question;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  巡检日期
	 */
	@Column(name ="QUALITY_DATE",nullable=true)
	public java.util.Date getQualityDate(){
		return this.qualityDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  巡检日期
	 */
	public void setQualityDate(java.util.Date qualityDate){
		this.qualityDate = qualityDate;
	}
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="qualityCheck")
	public List<QualityCheckFilesEntity> getQualityCheckFiles() {
		return qualityCheckFiles;
	}

	public void setQualityCheckFiles(List<QualityCheckFilesEntity> qualityCheckFiles) {
		this.qualityCheckFiles = qualityCheckFiles;
	}
}
