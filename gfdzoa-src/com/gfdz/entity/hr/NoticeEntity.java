package com.gfdz.entity.hr;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 通知公告
 * @author ant
 * @date 2015-06-01 14:06:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_notice", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class NoticeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**noticeTitle*/
	private java.lang.String noticeTitle;

	/**noticeType*/
	private java.lang.String noticeType;
	/**noticeRemarks*/
	private java.lang.String noticeRemarks;
	/**noticeFilesNum*/
	private java.lang.String noticeFilesNum;
	/**createName*/
	private java.lang.String createName;
	/**createBy*/
	private java.lang.String createBy;
	/**createDate*/
	private java.util.Date createDate;
	/**updateName*/
	private java.lang.String updateName;
	/**updateBy*/
	private java.lang.String updateBy;
	/**updateDate*/
	private java.util.Date updateDate;
	
	private List<NoticeFilesEntity> noticeFiles;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  noticeTitle
	 */
	@Column(name ="NOTICE_TITLE",nullable=true,length=250)
	public java.lang.String getNoticeTitle(){
		return this.noticeTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  noticeTitle
	 */
	public void setNoticeTitle(java.lang.String noticeTitle){
		this.noticeTitle = noticeTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  noticeFiles
	 */
	@OneToMany(mappedBy="notice",cascade={CascadeType.REMOVE})
	public List<NoticeFilesEntity> getNoticeFiles() {
		return noticeFiles;
	}

	public void setNoticeFiles(List<NoticeFilesEntity> noticeFiles) {
		this.noticeFiles = noticeFiles;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  noticeType
	 */
	@Column(name ="NOTICE_TYPE",nullable=true,length=200)
	public java.lang.String getNoticeType(){
		return this.noticeType;
	}

	

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  noticeType
	 */
	public void setNoticeType(java.lang.String noticeType){
		this.noticeType = noticeType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  noticeRemarks
	 */
	@Column(name ="NOTICE_REMARKS",nullable=true,length=500)
	public java.lang.String getNoticeRemarks(){
		return this.noticeRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  noticeRemarks
	 */
	public void setNoticeRemarks(java.lang.String noticeRemarks){
		this.noticeRemarks = noticeRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  noticeFilesNum
	 */
	@Column(name ="NOTICE_FILES_NUM",nullable=true,length=200)
	public java.lang.String getNoticeFilesNum(){
		return this.noticeFilesNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  noticeFilesNum
	 */
	public void setNoticeFilesNum(java.lang.String noticeFilesNum){
		this.noticeFilesNum = noticeFilesNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  createName
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  createName
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  createBy
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  createBy
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createDate
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createDate
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  updateName
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  updateName
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  updateBy
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  updateBy
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updateDate
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateDate
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
}
