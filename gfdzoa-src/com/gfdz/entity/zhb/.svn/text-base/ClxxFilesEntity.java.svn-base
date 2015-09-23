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
 * @Description: 车辆附件信息表
 * @author ant
 * @date 2015-05-28 11:39:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_clxx_files", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ClxxFilesEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**车辆id*/
	private java.lang.String clxxId;
	
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
	 *@return: java.lang.String  车辆id
	 */
	@Column(name ="CLXX_ID",nullable=true,length=50)
	public java.lang.String getClxxId(){
		return this.clxxId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆id
	 */
	public void setClxxId(java.lang.String clxxId){
		this.clxxId = clxxId;
	}
}
