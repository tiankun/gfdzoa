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
 * @Description: 计划采购申请审核
 * @author onlineGenerator
 * @date 2015-07-20 11:41:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_planadit", schema = "")
@SuppressWarnings("serial")
public class ZhbPlanaditEntity implements java.io.Serializable {
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
	/**计划采购主表id*/
	private java.lang.String plancpId;
	/**审核说明*/
	private java.lang.String examinExplain;
	/**状态*/
	private java.math.BigDecimal flag;
	/**审核人*/
	private java.lang.String examinPerson;
	/**审核时间*/
	private java.util.Date examinTime;
	
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
	 *@return: java.lang.String  计划采购主表id
	 */
	
	@Column(name ="PLANCP_ID",nullable=true,length=36)
	public java.lang.String getPlancpId(){
		return this.plancpId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划采购主表id
	 */
	public void setPlancpId(java.lang.String plancpId){
		this.plancpId = plancpId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核说明
	 */
	
	@Column(name ="EXAMIN_EXPLAIN",nullable=true,length=2000)
	public java.lang.String getExaminExplain(){
		return this.examinExplain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核说明
	 */
	public void setExaminExplain(java.lang.String examinExplain){
		this.examinExplain = examinExplain;
	}
	
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  状态
	 */
	
	@Column(name ="FLAG",nullable=true,length=32)
	public java.math.BigDecimal getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  状态
	 */
	public void setFlag(java.math.BigDecimal flag){
		this.flag = flag;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	
	@Column(name ="EXAMIN_PERSON",nullable=true,length=32)
	public java.lang.String getExaminPerson(){
		return this.examinPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setExaminPerson(java.lang.String examinPerson){
		this.examinPerson = examinPerson;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核时间
	 */
	
	@Column(name ="EXAMIN_TIME",nullable=true,length=32)
	public java.util.Date getExaminTime(){
		return this.examinTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setExaminTime(java.util.Date examinTime){
		this.examinTime = examinTime;
	}
	
}
