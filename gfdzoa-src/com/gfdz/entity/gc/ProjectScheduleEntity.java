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

import sun.launcher.resources.launcher;

/**   
 * @Title: Entity
 * @Description: 工程进度信息表
 * @author ant
 * @date 2015-05-28 14:52:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_PROJECT_SCHEDULE")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ProjectScheduleEntity implements java.io.Serializable {
	/**报告编号*/
	private java.lang.String id;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**开始日期*/
	private java.util.Date startDate;
	/**截止日期*/
	private java.util.Date endDate;
	/**月形象进度*/
	private java.lang.Integer imageProgress;
	
	private List<ProjectScheduleDetailEntity> projectScheduleDetail;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报告编号
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
	 *@param: java.lang.String  报告编号
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始日期
	 */
	@Column(name ="START_DATE",nullable=true)
	public java.util.Date getStartDate(){
		return this.startDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始日期
	 */
	public void setStartDate(java.util.Date startDate){
		this.startDate = startDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  截止日期
	 */
	@Column(name ="END_DATE",nullable=true)
	public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  截止日期
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月形象进度
	 */
	@Column(name ="IMAGE_PROGRESS",nullable=true)
	public java.lang.Integer getImageProgress(){
		return this.imageProgress;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  月形象进度
	 */
	public void setImageProgress(java.lang.Integer imageProgress){
		this.imageProgress = imageProgress;
	}

	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="projectSchedule")
	public List<ProjectScheduleDetailEntity> getProjectScheduleDetail() {
		return projectScheduleDetail;
	}

	public void setProjectScheduleDetail(
			List<ProjectScheduleDetailEntity> projectScheduleDetail) {
		this.projectScheduleDetail = projectScheduleDetail;
	}
	
	
	
}
