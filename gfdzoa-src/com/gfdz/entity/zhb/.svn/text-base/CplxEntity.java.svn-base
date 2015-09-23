package com.gfdz.entity.zhb;

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
 * @Description: 产品类型表
 * @author ant
 * @date 2015-05-28 11:57:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_cplx", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class CplxEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**类型名称*/
	private java.lang.String lxmc;
	
	/**上级分类*/
	private CplxEntity parent;

	/**下级分类*/
	private List<CplxEntity> children;
	
	/**备注*/
	private java.lang.String bz;
	
	//产品编码
	private  String code;
	
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
	 *@return: java.lang.String  类型名称
	 */
	@Column(name ="LXMC",nullable=true,length=50)
	public java.lang.String getLxmc(){
		return this.lxmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型名称
	 */
	public void setLxmc(java.lang.String lxmc){
		this.lxmc = lxmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上级分类
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="SJFL")
	public CplxEntity getParent() {
		return parent;
	}

	public void setParent(CplxEntity parent) {
		this.parent = parent;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.LAZY)
	public List<CplxEntity> getChildren() {
		return children;
	}

	public void setChildren(List<CplxEntity> children) {
		this.children = children;
	}
	
	@Column(name ="CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=1000)
	public java.lang.String getBz(){
		return this.bz;
	}



	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBz(java.lang.String bz){
		this.bz = bz;
	}
	
	
	
}
