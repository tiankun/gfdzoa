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
 * @Description: 技术移交记录表
 * @author ant
 * @date 2015-05-28 14:46:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "js_transfer", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class JsTransferEntity implements java.io.Serializable {
	/**交底记录编号*/
	private java.lang.String id;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**交底时间*/
	private java.util.Date transferTiem;
	/**交底人*/
	private java.lang.String lecturer;
	/**备注说明*/
	private java.lang.String remarks;
	
	private List<JsTransferFilesEntity> jsTransferFiles;
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交底记录编号
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
	 *@param: java.lang.String  交底记录编号
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
	 *@return: java.util.Date  交底时间
	 */
	@Column(name ="TRANSFER_TIEM",nullable=true)
	public java.util.Date getTransferTiem(){
		return this.transferTiem;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  交底时间
	 */
	public void setTransferTiem(java.util.Date transferTiem){
		this.transferTiem = transferTiem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交底人
	 */
	@Column(name ="LECTURER",nullable=true,length=20)
	public java.lang.String getLecturer(){
		return this.lecturer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交底人
	 */
	public void setLecturer(java.lang.String lecturer){
		this.lecturer = lecturer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注说明
	 */
	@Column(name ="REMARKS",nullable=true,length=500)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注说明
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}

	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="jsTransfer")
	public List<JsTransferFilesEntity> getJsTransferFiles() {
		return jsTransferFiles;
	}

	public void setJsTransferFiles(List<JsTransferFilesEntity> jsTransferFiles) {
		this.jsTransferFiles = jsTransferFiles;
	}
	
	
}
