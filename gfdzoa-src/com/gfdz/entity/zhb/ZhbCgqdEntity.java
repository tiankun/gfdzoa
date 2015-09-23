package com.gfdz.entity.zhb;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.gfdz.entity.gc.ProjectInfoEntity;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 配给采购申请单
 * @author onlineGenerator
 * @date 2015-07-27 11:16:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_cgqd", schema = "")
@SuppressWarnings("serial")
public class ZhbCgqdEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**项目主键*/
	private ProjectInfoEntity project;
	/**用户主键*/
	private java.lang.String userId;
	/**申请时间*/
	private java.util.Date inputTime;
	/**到货联系人*/
	private java.lang.String linkman;
	/**到货联系人电话*/
	private java.lang.String contactNumber;
	/**备注*/
	private java.lang.String applyRemark;
	/**状态标记*/
	private java.math.BigDecimal flag;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目主键
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	//@Column(name ="project",nullable=true,length=32)
	@JoinColumn(name ="PROJECT")
	public ProjectInfoEntity getproject(){
		return this.project;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目主键
	 */
	public void setproject(ProjectInfoEntity project){
		this.project = project;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户主键
	 */
	
	@Column(name ="USER_ID",nullable=true,length=36)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户主键
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	
	@Column(name ="INPUT_TIME",nullable=true,length=20)
	public java.util.Date getInputTime(){
		return this.inputTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setInputTime(java.util.Date inputTime){
		this.inputTime = inputTime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到货联系人
	 */
	
	@Column(name ="LINKMAN",nullable=true,length=32)
	public java.lang.String getLinkman(){
		return this.linkman;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到货联系人
	 */
	public void setLinkman(java.lang.String linkman){
		this.linkman = linkman;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到货联系人电话
	 */
	
	@Column(name ="CONTACT_NUMBER",nullable=true,length=32)
	public java.lang.String getContactNumber(){
		return this.contactNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到货联系人电话
	 */
	public void setContactNumber(java.lang.String contactNumber){
		this.contactNumber = contactNumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="APPLY_REMARK",nullable=true,length=4000)
	public java.lang.String getApplyRemark(){
		return this.applyRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setApplyRemark(java.lang.String applyRemark){
		this.applyRemark = applyRemark;
	}
	
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  状态标记
	 */
	
	@Column(name ="FLAG",nullable=true,length=32)
	public java.math.BigDecimal getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  状态标记
	 */
	public void setFlag(java.math.BigDecimal flag){
		this.flag = flag;
	}
	
}
