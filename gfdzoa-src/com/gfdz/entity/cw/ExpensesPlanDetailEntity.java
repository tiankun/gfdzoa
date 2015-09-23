package com.gfdz.entity.cw;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 费用开支计划明细
 * @author ant
 * @date 2015-05-28 13:48:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_expenses_plan_detail", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ExpensesPlanDetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**费用开支计划主键*/
	private ExpensesPlanEntity expensesPlan;
	/**开支项*/
	private java.lang.String item;
	/**开支金额*/
	private java.math.BigDecimal planMoney;
	/**备注*/
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用开支计划主键
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="EXPENSES_PLAN_ID")
	public ExpensesPlanEntity getExpensesPlan(){
		return this.expensesPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用开支计划主键
	 */
	public void setExpensesPlan(ExpensesPlanEntity expensesPlan){
		this.expensesPlan = expensesPlan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开支项
	 */
	@Column(name ="ITEM",nullable=false,length=200)
	public java.lang.String getItem(){
		return this.item;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开支项
	 */
	public void setItem(java.lang.String item){
		this.item = item;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  开支金额
	 */
	@Column(name ="PLAN_MONEY",nullable=false,precision=19,scale=2)
	public java.math.BigDecimal getPlanMoney(){
		return this.planMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  开支金额
	 */
	public void setPlanMoney(java.math.BigDecimal planMoney){
		this.planMoney = planMoney;
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
}
