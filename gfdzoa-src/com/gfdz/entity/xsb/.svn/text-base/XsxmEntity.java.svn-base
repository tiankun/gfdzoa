package com.gfdz.entity.xsb;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.gfdz.entity.gc.ProjectInfoEntity;

/**   
 * @Title: Entity
 * @Description: 销售项目表
 * @author ant
 * @date 2015-05-28 13:42:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xsb_xsxm")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class XsxmEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**项目名称*/
	private ProjectInfoEntity project;
	/**日期*/
	private Date logDate;
	/**项目描述*/
	private java.lang.String description;
	/**备注*/
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
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
	 *@param: java.lang.String  编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="PROJECTID")
	public ProjectInfoEntity getProject(){
		return this.project;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProject(ProjectInfoEntity project) {
		this.project = project;
	}

	@Column(name ="LOGDATE")
	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	@Column(name ="DESCRIPTION")
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	@Column(name ="REMARK")
	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	
	
	
	
}
