package com.gfdz.entity.xsb;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.gc.TransferFilesEntity;

/**   
 * @Title: Entity
 * @Description: 销售移交记录表
 * @author ant
 * @date 2015-05-28 14:44:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "XSB_Transfer", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TransferEntity implements java.io.Serializable {
	/**交底记录编号*/
	private java.lang.String id;
	/**项目编号*/
	private ProjectInfoEntity project;
	/**经办人*/
	private java.lang.String operator;
	/**交底日期*/
	private java.util.Date transferDate;
	/**备注说明*/
	private java.lang.String remarks;
	
	private List<TransferFilesEntity> transferFiles;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经办人
	 */
	@Column(name ="OPERATOR",nullable=true,length=15)
	public java.lang.String getOperator(){
		return this.operator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经办人
	 */
	public void setOperator(java.lang.String operator){
		this.operator = operator;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  交底日期
	 */
	@Column(name ="TRANSFER_DATE",nullable=true)
	public java.util.Date getTransferDate(){
		return this.transferDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  交底日期
	 */
	public void setTransferDate(java.util.Date transferDate){
		this.transferDate = transferDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注说明
	 */
	@Column(name ="REMARKS",nullable=true,length=200)
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
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="transfer",cascade=CascadeType.REMOVE)
	public List<TransferFilesEntity> getTransferFiles() {
		return transferFiles;
	}

	public void setTransferFiles(List<TransferFilesEntity> transferFiles) {
		this.transferFiles = transferFiles;
	}
	
	
}
