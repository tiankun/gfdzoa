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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 采购计划申请
 * @author onlineGenerator
 * @date 2015-07-20 11:05:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_plancp", schema = "")
@SuppressWarnings("serial")
public class ZhbPlancpEntity implements java.io.Serializable {
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
	/**计划填写人*/
	private java.lang.String applyPerson;
	/**计划时间*/
	private java.util.Date planTime;
	/**申请说明*/
	private java.lang.String planExplain;
	/**项目id*/
	private java.lang.String projectId;
	/**项目名称*/
	private java.lang.String projectName;
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
	 *@return: java.lang.String  计划填写人
	 */
	
	@Column(name ="APPLY_PERSON",nullable=true,length=32)
	public java.lang.String getApplyPerson(){
		return this.applyPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划填写人
	 */
	public void setApplyPerson(java.lang.String applyPerson){
		this.applyPerson = applyPerson;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计划时间
	 */
	
	@Column(name ="PLAN_TIME",nullable=true,length=32)
	public java.util.Date getPlanTime(){
		return this.planTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计划时间
	 */
	public void setPlanTime(java.util.Date planTime){
		this.planTime = planTime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请说明
	 */
	
	@Column(name ="PLAN_EXPLAIN",nullable=true,length=3000)
	public java.lang.String getPlanExplain(){
		return this.planExplain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请说明
	 */
	public void setPlanExplain(java.lang.String planExplain){
		this.planExplain = planExplain;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目id
	 */
	
	@Column(name ="PROJECT_ID",nullable=true,length=36)
	public java.lang.String getProjectId(){
		return this.projectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目id
	 */
	public void setProjectId(java.lang.String projectId){
		this.projectId = projectId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	
	@Column(name ="PROJECT_NAME",nullable=true,length=50)
	public java.lang.String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProjectName(java.lang.String projectName){
		this.projectName = projectName;
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
