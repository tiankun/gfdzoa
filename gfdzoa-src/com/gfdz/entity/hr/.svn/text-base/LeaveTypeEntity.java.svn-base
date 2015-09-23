package com.gfdz.entity.hr;

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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 请假类型
 * @author ant
 * @date 2015-06-05 11:40:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_leave_type", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class LeaveTypeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**typeName*/
	private java.lang.String typeName;
	/**parentId*/
	private LeaveTypeEntity parent;
	/**leaveDays*/
	private java.math.BigDecimal leaveDays;
	/**note*/
	private java.lang.String note;
	
	private List<LeaveTypeEntity> children;
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
	 *@return: java.lang.String  typeName
	 */
	@Column(name ="TYPE_NAME",nullable=true,length=32)
	public java.lang.String getTypeName(){
		return this.typeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  typeName
	 */
	public void setTypeName(java.lang.String typeName){
		this.typeName = typeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  parentId
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="PARENT_ID")
	public LeaveTypeEntity getParent() {
		return parent;
	}

	public void setParent(LeaveTypeEntity parent) {
		this.parent = parent;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.LAZY)
	public List<LeaveTypeEntity> getChildren() {
		return children;
	}

	public void setChildren(List<LeaveTypeEntity> children) {
		this.children = children;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  leaveDays
	 */
	@Column(name ="LEAVE_DAYS",nullable=true,precision=10,scale=2)
	public java.math.BigDecimal getLeaveDays(){
		return this.leaveDays;
	}



	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  leaveDays
	 */
	public void setLeaveDays(java.math.BigDecimal leaveDays){
		this.leaveDays = leaveDays;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  note
	 */
	@Column(name ="NOTE",nullable=true,length=255)
	public java.lang.String getNote(){
		return this.note;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  note
	 */
	public void setNote(java.lang.String note){
		this.note = note;
	}
}
