package com.gfdz.entity.zhb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 不合格产品登记
 * @author ant
 * @date 2015-05-29 14:25:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zhb_bhgpdj", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class BhgpdjEntity implements java.io.Serializable {
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
	/**编号*/
	private java.lang.String id;
	/**产品名称*/
	private java.lang.String cpmc;
	/**规格型号*/
	private java.lang.String ggxh;
	/**供方名称*/
	private java.lang.String gfmc;
	/**不合格原因*/
	private java.lang.String bhgyy;
	/**不合格数量*/
	private java.lang.Integer bhgsl;
	/**经办人*/
	private java.lang.String jbr;
	/**经办时间*/
	private java.util.Date jbsj;
	/**不合格品处置*/
	private java.lang.String bhgpcz;
	/**批准人*/
	private java.lang.String pzr;
	/**批准时间*/
	private java.util.Date pzsj;
	/**备注*/
	private java.lang.String bz;
	/**创建人名称*/
	private java.lang.String createName;
	
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
	@Column(name ="CREATE_DATE",nullable=true)
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
	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="CPMC",nullable=false,length=50)
	public java.lang.String getCpmc(){
		return this.cpmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setCpmc(java.lang.String cpmc){
		this.cpmc = cpmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格型号
	 */
	@Column(name ="GGXH",nullable=false,length=50)
	public java.lang.String getGgxh(){
		return this.ggxh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格型号
	 */
	public void setGgxh(java.lang.String ggxh){
		this.ggxh = ggxh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供方名称
	 */
	@Column(name ="GFMC",nullable=false,length=100)
	public java.lang.String getGfmc(){
		return this.gfmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供方名称
	 */
	public void setGfmc(java.lang.String gfmc){
		this.gfmc = gfmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  不合格原因
	 */
	@Column(name ="BHGYY",nullable=false,length=100)
	public java.lang.String getBhgyy(){
		return this.bhgyy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  不合格原因
	 */
	public void setBhgyy(java.lang.String bhgyy){
		this.bhgyy = bhgyy;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  不合格数量
	 */
	@Column(name ="BHGSL",nullable=false,precision=5,scale=0)
	public java.lang.Integer getBhgsl(){
		return this.bhgsl;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  不合格数量
	 */
	public void setBhgsl(java.lang.Integer bhgsl){
		this.bhgsl = bhgsl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经办人
	 */
	@Column(name ="JBR",nullable=false,length=50)
	public java.lang.String getJbr(){
		return this.jbr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经办人
	 */
	public void setJbr(java.lang.String jbr){
		this.jbr = jbr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  经办时间
	 */
	@Column(name ="JBSJ",nullable=true)
	public java.util.Date getJbsj(){
		return this.jbsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  经办时间
	 */
	public void setJbsj(java.util.Date jbsj){
		this.jbsj = jbsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  不合格品处置
	 */
	@Column(name ="BHGPCZ",nullable=true,length=100)
	public java.lang.String getBhgpcz(){
		return this.bhgpcz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  不合格品处置
	 */
	public void setBhgpcz(java.lang.String bhgpcz){
		this.bhgpcz = bhgpcz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批准人
	 */
	@Column(name ="PZR",nullable=true,length=50)
	public java.lang.String getPzr(){
		return this.pzr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批准人
	 */
	public void setPzr(java.lang.String pzr){
		this.pzr = pzr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  批准时间
	 */
	@Column(name ="PZSJ",nullable=true)
	public java.util.Date getPzsj(){
		return this.pzsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  批准时间
	 */
	public void setPzsj(java.util.Date pzsj){
		this.pzsj = pzsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=100)
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
}
