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
 * @Description: 安全教育
 * @author ant
 * @date 2015-05-28 14:58:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_Safe_Education", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SafeEducationEntity implements java.io.Serializable {
	/**安全教育编号*/
	private java.lang.String id;
	/**工程名称*/
	private java.lang.String engineering;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**主讲人*/
	private java.lang.String lecturer;
	/**受教育人*/
	private java.lang.String trainee;
	/**培训日期*/
	private java.util.Date educationDate;
	/**培训类别*/
	private java.lang.String educationType;
	/**教育内容*/
	private java.lang.String educationContent;
	
	private List<SafeEducationFilesEntity> safeEducationFiles;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安全教育编号
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
	 *@param: java.lang.String  安全教育编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
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
	 *@return: java.lang.String  主讲人
	 */
	@Column(name ="LECTURER",nullable=true,length=20)
	public java.lang.String getLecturer(){
		return this.lecturer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主讲人
	 */
	public void setLecturer(java.lang.String lecturer){
		this.lecturer = lecturer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  受教育人
	 */
	@Column(name ="TRAINEE",nullable=true,length=20)
	public java.lang.String getTrainee(){
		return this.trainee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  受教育人
	 */
	public void setTrainee(java.lang.String trainee){
		this.trainee = trainee;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  培训日期
	 */
	@Column(name ="EDUCATION_DATE",nullable=true,scale=6)
	public java.util.Date getEducationDate(){
		return this.educationDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  培训日期
	 */
	public void setEducationDate(java.util.Date educationDate){
		this.educationDate = educationDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训类别
	 */
	@Column(name ="EDUCATION_TYPE",nullable=true,length=10)
	public java.lang.String getEducationType(){
		return this.educationType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训类别
	 */
	public void setEducationType(java.lang.String educationType){
		this.educationType = educationType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教育内容
	 */
	@Column(name ="EDUCATION_CONTENT",nullable=true,length=500)
	public java.lang.String getEducationContent(){
		return this.educationContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教育内容
	 */
	public void setEducationContent(java.lang.String educationContent){
		this.educationContent = educationContent;
	}
	
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="safeEducation")
	public List<SafeEducationFilesEntity> getSafeEducationFiles() {
		return safeEducationFiles;
	}

	public void setSafeEducationFiles(
			List<SafeEducationFilesEntity> safeEducationFiles) {
		this.safeEducationFiles = safeEducationFiles;
	}
	
	
}
