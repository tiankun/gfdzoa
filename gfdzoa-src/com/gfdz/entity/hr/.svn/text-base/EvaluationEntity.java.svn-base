package com.gfdz.entity.hr;

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
 * @Description: 转正考评
 * @author ant
 * @date 2015-06-15 15:09:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "HR_EVALUATION", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class EvaluationEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**被考评人ID*/
	private java.lang.String pId;
	/**考评人ID*/
	private java.lang.String epId;
	/**部门ID*/
	private java.lang.String deptId;
	/**考评时间*/
	private java.util.Date evTime;
	/**工作质量得分*/
	private java.lang.Integer pQuality;
	/**工作质量说明*/
	private java.lang.String eQuality;
	/**工作数量得分*/
	private java.lang.Integer pQuantity;
	/**工作数量说明*/
	private java.lang.String eQuantity;
	/**纪律性得分*/
	private java.lang.Integer pDiscipline;
	/**纪律性说明*/
	private java.lang.String eDiscipline;
	/**集体观念得分*/
	private java.lang.Integer pCollective;
	/**集体观念说明*/
	private java.lang.String eCollective;
	/**积极性得分*/
	private java.lang.Integer pPositivity;
	/**积极性说明*/
	private java.lang.String ePositivity;
	/**责任感得分*/
	private java.lang.Integer pResponsibility;
	/**责任感说明*/
	private java.lang.String eResponsibility;
	/**知识得分*/
	private java.lang.Integer pKnowledge;
	/**知识说明*/
	private java.lang.String eKnowledge;
	/**判断得分*/
	private java.lang.Integer pJudge;
	/**判断说明*/
	private java.lang.String eJudge;
	/**计划得分*/
	private java.lang.Integer pPlan;
	/**计划说明*/
	private java.lang.String ePlan;
	/**人际得分*/
	private java.lang.Integer pRelationships;
	/**人际说明*/
	private java.lang.String eRelationships;
	/**成绩得分*/
	private java.lang.Integer pPerformance;
	/**成绩比例*/
	private java.lang.String rPerformance;
	/**成绩评分*/
	private java.lang.Integer sPerformance;
	/**态度得分*/
	private java.lang.Integer pAttitude;
	/**态度比例*/
	private java.lang.String rAttitude;
	/**态度评分*/
	private java.lang.Integer sAttitude;
	/**能力得分*/
	private java.lang.Integer pCapability;
	/**能力比例*/
	private java.lang.String rCapability;
	/**能力评分*/
	private java.lang.Integer sCapability;
	/**个人评分*/
	private java.lang.Integer sPersonal;
	/**综合评分*/
	private java.lang.Integer sTotal;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=200)
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
	 *@return: java.lang.String  被考评人ID
	 */
	@Column(name ="P_ID",nullable=true,length=200)

	public java.lang.String getpId() {
		return pId;
	}

	public void setpId(java.lang.String pId) {
		this.pId = pId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考评人ID
	 */
	@Column(name ="EP_ID",nullable=true,length=200)
	public java.lang.String getEpId() {
		return epId;
	}

	public void setEpId(java.lang.String epId) {
		this.epId = epId;
	}

	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门ID
	 */
	@Column(name ="DEPT_ID",nullable=true,length=200)
	public java.lang.String getDeptId() {
		return deptId;
	}

	public void setDeptId(java.lang.String deptId) {
		this.deptId = deptId;
	}
	
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  考评时间
	 */
	@Column(name ="EV_TIME",nullable=true)
	public java.util.Date getEvTime() {
		return evTime;
	}

	public void setEvTime(java.util.Date evTime) {
		this.evTime = evTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  工作质量得分
	 */
	@Column(name ="P_QUALITY",nullable=true)
	public java.lang.Integer getpQuality() {
		return pQuality;
	}

	public void setpQuality(java.lang.Integer pQuality) {
		this.pQuality = pQuality;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作质量说明
	 */
	@Column(name ="E_QUALITY",nullable=true,length=200)
	public java.lang.String geteQuality() {
		return eQuality;
	}

	public void seteQuality(java.lang.String eQuality) {
		this.eQuality = eQuality;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  工作数量得分
	 */
	@Column(name ="P_QUANTITY",nullable=true)
	public java.lang.Integer getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(java.lang.Integer pQuantity) {
		this.pQuantity = pQuantity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作数量说明
	 */
	@Column(name ="E_QUANTITY",nullable=true,length=200)
	public java.lang.String geteQuantity() {
		return eQuantity;
	}

	public void seteQuantity(java.lang.String eQuantity) {
		this.eQuantity = eQuantity;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  纪律性得分
	 */
	@Column(name ="P_DISCIPLINE",nullable=true)
	public java.lang.Integer getpDiscipline() {
		return pDiscipline;
	}

	public void setpDiscipline(java.lang.Integer pDiscipline) {
		this.pDiscipline = pDiscipline;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  纪律性说明
	 */
	@Column(name ="E_DISCIPLINE",nullable=true,length=200)
	public java.lang.String geteDiscipline() {
		return eDiscipline;
	}

	public void seteDiscipline(java.lang.String eDiscipline) {
		this.eDiscipline = eDiscipline;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  集体观念得分
	 */
	@Column(name ="P_COLLECTIVE",nullable=true)
	public java.lang.Integer getpCollective() {
		return pCollective;
	}

	public void setpCollective(java.lang.Integer pCollective) {
		this.pCollective = pCollective;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  集体观念说明
	 */
	@Column(name ="E_COLLECTIVE",nullable=true,length=200)
	public java.lang.String geteCollective() {
		return eCollective;
	}

	public void seteCollective(java.lang.String eCollective) {
		this.eCollective = eCollective;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  积极性得分
	 */
	@Column(name ="P_POSITIVITY",nullable=true)
	public java.lang.Integer getpPositivity() {
		return pPositivity;
	}

	public void setpPositivity(java.lang.Integer pPositivity) {
		this.pPositivity = pPositivity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  积极性说明
	 */
	@Column(name ="E_POSITIVITY",nullable=true,length=200)
	public java.lang.String getePositivity() {
		return ePositivity;
	}

	public void setePositivity(java.lang.String ePositivity) {
		this.ePositivity = ePositivity;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  责任感得分
	 */
	@Column(name ="P_RESPONSIBILITY",nullable=true)
	public java.lang.Integer getpResponsibility() {
		return pResponsibility;
	}

	public void setpResponsibility(java.lang.Integer pResponsibility) {
		this.pResponsibility = pResponsibility;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任感说明
	 */
	@Column(name ="E_RESPONSIBILITY",nullable=true,length=200)
	public java.lang.String geteResponsibility() {
		return eResponsibility;
	}

	public void seteResponsibility(java.lang.String eResponsibility) {
		this.eResponsibility = eResponsibility;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  知识得分
	 */
	@Column(name ="P_KNOWLEDGE",nullable=true)
	public java.lang.Integer getpKnowledge() {
		return pKnowledge;
	}

	public void setpKnowledge(java.lang.Integer pKnowledge) {
		this.pKnowledge = pKnowledge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  知识说明
	 */
	@Column(name ="E_KNOWLEDGE",nullable=true,length=200)
	public java.lang.String geteKnowledge() {
		return eKnowledge;
	}

	public void seteKnowledge(java.lang.String eKnowledge) {
		this.eKnowledge = eKnowledge;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  判断得分
	 */
	@Column(name ="P_JUDGE",nullable=true)
	public java.lang.Integer getpJudge() {
		return pJudge;
	}

	public void setpJudge(java.lang.Integer pJudge) {
		this.pJudge = pJudge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  判断说明
	 */
	@Column(name ="E_JUDGE",nullable=true,length=200)
	public java.lang.String geteJudge() {
		return eJudge;
	}

	public void seteJudge(java.lang.String eJudge) {
		this.eJudge = eJudge;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  计划得分
	 */
	@Column(name ="P_PLAN",nullable=true)
	public java.lang.Integer getpPlan() {
		return pPlan;
	}

	public void setpPlan(java.lang.Integer pPlan) {
		this.pPlan = pPlan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划说明
	 */
	@Column(name ="E_PLAN",nullable=true,length=200)
	public java.lang.String getePlan() {
		return ePlan;
	}

	public void setePlan(java.lang.String ePlan) {
		this.ePlan = ePlan;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  人际得分
	 */
	@Column(name ="P_RELATIONSHIPS",nullable=true)
	public java.lang.Integer getpRelationships() {
		return pRelationships;
	}

	public void setpRelationships(java.lang.Integer pRelationships) {
		this.pRelationships = pRelationships;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人际说明
	 */
	@Column(name ="E_RELATIONSHIPS",nullable=true,length=200)
	public java.lang.String geteRelationships() {
		return eRelationships;
	}

	public void seteRelationships(java.lang.String eRelationships) {
		this.eRelationships = eRelationships;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  成绩得分
	 */
	@Column(name ="P_PERFORMANCE",nullable=true)
	public java.lang.Integer getpPerformance() {
		return pPerformance;
	}

	public void setpPerformance(java.lang.Integer pPerformance) {
		this.pPerformance = pPerformance;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  成绩比例
	 */
	@Column(name ="R_PERFORMANCE",nullable=true,length=10)
	public java.lang.String getrPerformance() {
		return rPerformance;
	}

	public void setrPerformance(java.lang.String rPerformance) {
		this.rPerformance = rPerformance;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  成绩评分
	 */
	@Column(name ="S_PERFORMANCE",nullable=true)
	public java.lang.Integer getsPerformance() {
		return sPerformance;
	}

	public void setsPerformance(java.lang.Integer sPerformance) {
		this.sPerformance = sPerformance;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  态度得分
	 */
	@Column(name ="P_ATTITUDE",nullable=true)
	public java.lang.Integer getpAttitude() {
		return pAttitude;
	}

	public void setpAttitude(java.lang.Integer pAttitude) {
		this.pAttitude = pAttitude;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  态度比例
	 */
	@Column(name ="R_ATTITUDE",nullable=true,length=10)
	public java.lang.String getrAttitude() {
		return rAttitude;
	}

	public void setrAttitude(java.lang.String rAttitude) {
		this.rAttitude = rAttitude;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  态度评分
	 */
	@Column(name ="S_ATTITUDE",nullable=true)
	public java.lang.Integer getsAttitude() {
		return sAttitude;
	}

	public void setsAttitude(java.lang.Integer sAttitude) {
		this.sAttitude = sAttitude;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  能力得分
	 */
	@Column(name ="P_CAPABILITY",nullable=true)
	public java.lang.Integer getpCapability() {
		return pCapability;
	}

	public void setpCapability(java.lang.Integer pCapability) {
		this.pCapability = pCapability;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  能力比例
	 */
	@Column(name ="R_CAPABILITY",nullable=true,length=10)
	public java.lang.String getrCapability() {
		return rCapability;
	}

	public void setrCapability(java.lang.String rCapability) {
		this.rCapability = rCapability;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  能力评分
	 */
	@Column(name ="S_CAPABILITY",nullable=true)
	public java.lang.Integer getsCapability() {
		return sCapability;
	}

	public void setsCapability(java.lang.Integer sCapability) {
		this.sCapability = sCapability;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  个人评分
	 */
	@Column(name ="S_PERSONAL",nullable=true)
	public java.lang.Integer getsPersonal() {
		return sPersonal;
	}

	public void setsPersonal(java.lang.Integer sPersonal) {
		this.sPersonal = sPersonal;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  综合评分
	 */
	@Column(name ="S_TOTAL",nullable=true)
	public java.lang.Integer getsTotal() {
		return sTotal;
	}

	public void setsTotal(java.lang.Integer sTotal) {
		this.sTotal = sTotal;
	}
}
