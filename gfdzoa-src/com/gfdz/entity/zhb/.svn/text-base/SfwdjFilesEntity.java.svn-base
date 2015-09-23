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
 * @Description: 收发文登记附件表
 * @author ant
 * @date 2015-05-28 11:51:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_sfwdj_files", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SfwdjFilesEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**收发文登记附件id*/
	private java.lang.String sfwdjId;
	
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
	 *@return: java.lang.String  收发文登记附件id
	 */
	@Column(name ="SFWDJ_ID",nullable=true,length=50)
	public java.lang.String getSfwdjId(){
		return this.sfwdjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收发文登记附件id
	 */
	public void setSfwdjId(java.lang.String sfwdjId){
		this.sfwdjId = sfwdjId;
	}
}
