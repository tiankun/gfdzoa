package com.gfdz.entity.gc;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 工程验收登记
 * @author ant
 * @date 2015-08-21 10:56:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "GC_PROJECT_ACCEPT", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ProjectAcceptEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**项目id*/
	private java.lang.String projectId;
	/**建设单位*/
	private java.lang.String development;
	/**设计单位*/
	private java.lang.String designUnit;
	/**监理单位*/
	private java.lang.String supervisionUnit;
	/**施工单位*/
	private java.lang.String constructionUnit;
	/**质量监督机构*/
	private java.lang.String superviseUnit;
	/**开工日期*/
	private java.util.Date begindate;
	/**竣工日期*/
	private java.util.Date enddate;
	/**质保期*/
	private java.util.Date guarantee;
	/**验收内容*/
	private java.lang.String acceptDetail;
	/**验收日期*/
	private java.util.Date acceptDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
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
	 *@return: java.lang.String  项目id
	 */
	@Column(name ="PROJECT_ID",nullable=true,length=32)
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
	 *@return: java.lang.String  建设单位
	 */
	@Column(name ="DEVELOPMENT",nullable=true,length=255)
	public java.lang.String getDevelopment(){
		return this.development;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  建设单位
	 */
	public void setDevelopment(java.lang.String development){
		this.development = development;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设计单位
	 */
	@Column(name ="DESIGN_UNIT",nullable=true,length=255)
	public java.lang.String getDesignUnit(){
		return this.designUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设计单位
	 */
	public void setDesignUnit(java.lang.String designUnit){
		this.designUnit = designUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  监理单位
	 */
	@Column(name ="SUPERVISION_UNIT",nullable=true,length=255)
	public java.lang.String getSupervisionUnit(){
		return this.supervisionUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  监理单位
	 */
	public void setSupervisionUnit(java.lang.String supervisionUnit){
		this.supervisionUnit = supervisionUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  施工单位
	 */
	@Column(name ="CONSTRUCTION_UNIT",nullable=true,length=255)
	public java.lang.String getConstructionUnit(){
		return this.constructionUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  施工单位
	 */
	public void setConstructionUnit(java.lang.String constructionUnit){
		this.constructionUnit = constructionUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  质量监督机构
	 */
	@Column(name ="SUPERVISE_UNIT",nullable=true,length=255)
	public java.lang.String getSuperviseUnit(){
		return this.superviseUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  质量监督机构
	 */
	public void setSuperviseUnit(java.lang.String superviseUnit){
		this.superviseUnit = superviseUnit;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开工日期
	 */
	@Column(name ="BEGINDATE",nullable=true)
	public java.util.Date getBegindate(){
		return this.begindate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开工日期
	 */
	public void setBegindate(java.util.Date begindate){
		this.begindate = begindate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  竣工日期
	 */
	@Column(name ="ENDDATE",nullable=true)
	public java.util.Date getEnddate(){
		return this.enddate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  竣工日期
	 */
	public void setEnddate(java.util.Date enddate){
		this.enddate = enddate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  质保期
	 */
	@Column(name ="GUARANTEE",nullable=true)
	public java.util.Date getGuarantee(){
		return this.guarantee;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  质保期
	 */
	public void setGuarantee(java.util.Date guarantee){
		this.guarantee = guarantee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  验收内容
	 */
	@Column(name ="ACCEPT_DETAIL",nullable=true,length=2000)
	public java.lang.String getAcceptDetail(){
		return this.acceptDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  验收内容
	 */
	public void setAcceptDetail(java.lang.String acceptDetail){
		this.acceptDetail = acceptDetail;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  验收日期
	 */
	@Column(name ="ACCEPT_DATE",nullable=true)
	public java.util.Date getAcceptDate(){
		return this.acceptDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  验收日期
	 */
	public void setAcceptDate(java.util.Date acceptDate){
		this.acceptDate = acceptDate;
	}
}
