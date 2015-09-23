package com.gfdz.entity.gc;

import java.util.Date;
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
 * @Description: 工程计划表
 * @author ant
 * @date 2015-05-28 14:54:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_Project_Task", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ProjectTaskEntity implements java.io.Serializable {
	/**任务编号*/
	private java.lang.String id;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**费用总额*/
	private java.lang.Integer totalCost;
	/**责任人*/
	private java.lang.String responsible;
	
	private Date createDate;
	
	private List<ProjectTaskFilesEntity> projectTaskFiles;
	
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任务编号
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
	 *@param: java.lang.String  任务编号
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  费用总额
	 */
	@Column(name ="TOTAL_COST",nullable=true)
	public java.lang.Integer getTotalCost(){
		return this.totalCost;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  费用总额
	 */
	public void setTotalCost(java.lang.Integer totalCost){
		this.totalCost = totalCost;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任人
	 */
	@Column(name ="RESPONSIBLE",nullable=true,length=20)
	public java.lang.String getResponsible(){
		return this.responsible;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任人
	 */
	public void setResponsible(java.lang.String responsible){
		this.responsible = responsible;
	}
	
	@Column(name ="CREATEDATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY,mappedBy="projectTask")
	public List<ProjectTaskFilesEntity> getProjectTaskFiles() {
		return projectTaskFiles;
	}

	public void setProjectTaskFiles(List<ProjectTaskFilesEntity> projectTaskFiles) {
		this.projectTaskFiles = projectTaskFiles;
	}
	
	
}
