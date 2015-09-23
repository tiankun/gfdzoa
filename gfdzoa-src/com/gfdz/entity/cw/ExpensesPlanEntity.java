package com.gfdz.entity.cw;

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
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 费用开支计划
 * @author ant
 * @date 2015-05-28 13:48:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_expenses_plan", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ExpensesPlanEntity implements java.io.Serializable {
	/**费用开支计划主键*/
	private java.lang.String id;
	/**用户主键*/
	private TSUser userId;
	/**申请时间*/
	private java.util.Date applyTime;
	/**预支时间*/
	private java.util.Date advanceTime;
	/**申请金额*/
	private java.math.BigDecimal totalSum;
	/**最终审批金额*/
	private java.math.BigDecimal finalSum;
	/**是否要综合办购买*/
	private java.lang.String buy;
	/**备注*/
	private java.lang.String remark;
	/**打印时间*/
	private java.util.Date print;
	/**暂支主键*/
	private AdvanceEntity advanceId;
	/**费用开支计划明细*/
	private List<ExpensesPlanDetailEntity> expensesPlanDetail;
	
	private String processinstanceid;
	/**大写申请金额*/
	private java.lang.String upperChn;
	/**部门*/
	private TSDepart  depart;
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用开支计划主键
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
	 *@param: java.lang.String  费用开支计划主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户主键
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="USER_ID")
	//@Column(name ="USER_ID",nullable=false,length=32)
	public TSUser getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户主键
	 */
	public void setUserId(TSUser userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="APPLY_TIME",nullable=false,scale=6)
	public java.util.Date getApplyTime(){
		return this.applyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setApplyTime(java.util.Date applyTime){
		this.applyTime = applyTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预支时间
	 */
	@Column(name ="ADVANCE_TIME",nullable=false)
	public java.util.Date getAdvanceTime(){
		return this.advanceTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预支时间
	 */
	public void setAdvanceTime(java.util.Date advanceTime){
		this.advanceTime = advanceTime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  申请金额
	 */
	@Column(name ="TOTAL_SUM",nullable=false,precision=19,scale=2)
	public java.math.BigDecimal getTotalSum(){
		return this.totalSum;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  申请金额
	 */
	public void setTotalSum(java.math.BigDecimal totalSum){
		this.totalSum = totalSum;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  最终审批金额
	 */
	@Column(name ="FINAL_SUM",nullable=true,precision=19,scale=2)
	public java.math.BigDecimal getFinalSum(){
		return this.finalSum;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  最终审批金额
	 */
	public void setFinalSum(java.math.BigDecimal finalSum){
		this.finalSum = finalSum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否要综合办购买
	 */
	@Column(name ="BUY",nullable=true,length=2)
	public java.lang.String getBuy(){
		return this.buy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否要综合办购买
	 */
	public void setBuy(java.lang.String buy){
		this.buy = buy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=500)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  打印时间
	 */
	@Column(name ="PRINT",nullable=true,scale=6)
	public java.util.Date getPrint(){
		return this.print;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  打印时间
	 */
	public void setPrint(java.util.Date print){
		this.print = print;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  暂支主键
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="ADVANCE_ID")
	//@Column(name ="ADVANCE_ID",nullable=true,length=32)
	public AdvanceEntity getAdvanceId(){
		return this.advanceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  暂支主键
	 */
	public void setAdvanceId(AdvanceEntity advanceId){
		this.advanceId = advanceId;
	}
	@OneToMany(mappedBy="expensesPlan",cascade={CascadeType.ALL})
	public List<ExpensesPlanDetailEntity> getExpensesPlanDetail() {
		return expensesPlanDetail;
	}

	public void setExpensesPlanDetail(
			List<ExpensesPlanDetailEntity> expensesPlanDetail) {
		this.expensesPlanDetail = expensesPlanDetail;
	}
	@Column(name ="PROCESSINSTANCEID",nullable=true,length=300)
	public String getProcessinstanceid() {
		return processinstanceid;
	}

	public void setProcessinstanceid(String processinstanceid) {
		this.processinstanceid = processinstanceid;
	}
	@Column(name ="UPPER_CHN")
	public java.lang.String getUpperChn() {
		return upperChn;
	}

	public void setUpperChn(java.lang.String upperChn) {
		this.upperChn = upperChn;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="DEPART")
	public TSDepart getDepart() {
		return depart;
	}

	public void setDepart(TSDepart depart) {
		this.depart = depart;
	}
	
	
}
