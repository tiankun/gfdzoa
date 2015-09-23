package com.gfdz.entity.zhb;

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
 * @Description: 供应商产品表
 * @author ant
 * @date 2015-05-28 11:57:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_gyscp", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class GyscpEntity implements java.io.Serializable {
	/**产品编号*/
	private java.lang.String cpbh;
	/**编号*/
	private java.lang.String id;
	/**供应商编号*/
	private java.lang.String gysbh;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品编号
	 */
	@Column(name ="CPBH",nullable=false,length=50)
	public java.lang.String getCpbh(){
		return this.cpbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品编号
	 */
	public void setCpbh(java.lang.String cpbh){
		this.cpbh = cpbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
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
	 *@param: java.lang.String  编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商编号
	 */
	@Column(name ="GYSBH",nullable=false,length=50)
	public java.lang.String getGysbh(){
		return this.gysbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商编号
	 */
	public void setGysbh(java.lang.String gysbh){
		this.gysbh = gysbh;
	}
}
