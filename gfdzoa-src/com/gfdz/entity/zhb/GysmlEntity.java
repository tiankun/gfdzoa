package com.gfdz.entity.zhb;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 供应商名录
 * @author onlineGenerator
 * @date 2015-06-01 16:11:16
 * @version V1.0   
 *
 */
@Entity
@Table(name ="zhb_gysml", schema = "")
@SuppressWarnings("serial")
public class GysmlEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
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
	/**类型编号*/
	@Excel(name="类型编号")
	private java.lang.String lxbh;
	/**供应商编号*/
	@Excel(name="供应商编号")
	private java.lang.String gysbh;
	/**公司名称*/
	@Excel(name="公司名称")
	private java.lang.String gsmc;
	/**公司电话*/
	@Excel(name="公司电话")
	private java.lang.String gsdh;
	/**公司传真*/
	@Excel(name="公司传真")
	private java.lang.String gscz;
	/**公司地址*/
	@Excel(name="公司地址")
	private java.lang.String gsdz;
	/**公司网站*/
	@Excel(name="公司网站")
	private java.lang.String gswz;
	/**注册资本*/
	@Excel(name="注册资本")
	private java.lang.String zczb;
	/**公司法人*/
	@Excel(name="公司法人")
	private java.lang.String gsfr;
	/**成立时间*/
	@Excel(name="成立时间")
	private java.util.Date clsj;
	/**负责人*/
	@Excel(name="负责人")
	private java.lang.String fzr;
	/**负责人电话*/
	@Excel(name="负责人电话")
	private java.lang.String fzrdh;
	/**联系人*/
	@Excel(name="联系人")
	private java.lang.String lxr;
	/**联系人电话*/
	@Excel(name="联系人电话")
	private java.lang.String lxrdh;
	/**付款条件*/
	@Excel(name="付款条件")
	private java.lang.String fktj;
	/**供货期*/
	@Excel(name="供货期")
	private java.lang.String ghq;
	/**配送方式*/
	@Excel(name="配送方式")
	private java.lang.String psfs;
	/**是否技术支持*/
	@Excel(name="是否技术支持")
	private java.lang.Integer sfjszc;
	/**是否一般纳税人*/
	@Excel(name="是否一般纳税人")
	private java.lang.Integer sfybnsr;
	/**调查及评价报告编号*/
	@Excel(name="调查及评价报告编号")
	private java.lang.String pjbgbh;
	/**首次列入日期*/
	@Excel(name="首次列入日期")
	private java.util.Date sclrrq;
	/**年度复评结果*/
	@Excel(name="年度复评结果")
	private java.lang.Integer ndfpjg;
	/**复评时间*/
	@Excel(name="复评时间")
	private java.util.Date fpsj;
	/**评定结论*/
	@Excel(name="评定结论")
	private java.lang.String pdjl;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String bz;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
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
	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	 *@return: java.lang.String  类型编号
	 */
	@Column(name ="LXBH",nullable=true,length=50)
	public java.lang.String getLxbh(){
		return this.lxbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型编号
	 */
	public void setLxbh(java.lang.String lxbh){
		this.lxbh = lxbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商编号
	 */
	@Column(name ="GYSBH",nullable=true,length=50)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="GSMC",nullable=true,length=100)
	public java.lang.String getGsmc(){
		return this.gsmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setGsmc(java.lang.String gsmc){
		this.gsmc = gsmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司电话
	 */
	@Column(name ="GSDH",nullable=true,length=50)
	public java.lang.String getGsdh(){
		return this.gsdh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司电话
	 */
	public void setGsdh(java.lang.String gsdh){
		this.gsdh = gsdh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司传真
	 */
	@Column(name ="GSCZ",nullable=true,length=50)
	public java.lang.String getGscz(){
		return this.gscz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司传真
	 */
	public void setGscz(java.lang.String gscz){
		this.gscz = gscz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司地址
	 */
	@Column(name ="GSDZ",nullable=true,length=50)
	public java.lang.String getGsdz(){
		return this.gsdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司地址
	 */
	public void setGsdz(java.lang.String gsdz){
		this.gsdz = gsdz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司网站
	 */
	@Column(name ="GSWZ",nullable=true,length=50)
	public java.lang.String getGswz(){
		return this.gswz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司网站
	 */
	public void setGswz(java.lang.String gswz){
		this.gswz = gswz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册资本
	 */
	@Column(name ="ZCZB",nullable=true,length=50)
	public java.lang.String getZczb(){
		return this.zczb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册资本
	 */
	public void setZczb(java.lang.String zczb){
		this.zczb = zczb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司法人
	 */
	@Column(name ="GSFR",nullable=true,length=50)
	public java.lang.String getGsfr(){
		return this.gsfr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司法人
	 */
	public void setGsfr(java.lang.String gsfr){
		this.gsfr = gsfr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  成立时间
	 */
	@Column(name ="CLSJ",nullable=true,length=32)
	public java.util.Date getClsj(){
		return this.clsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  成立时间
	 */
	public void setClsj(java.util.Date clsj){
		this.clsj = clsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  负责人
	 */
	@Column(name ="FZR",nullable=true,length=50)
	public java.lang.String getFzr(){
		return this.fzr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  负责人
	 */
	public void setFzr(java.lang.String fzr){
		this.fzr = fzr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  负责人电话
	 */
	@Column(name ="FZRDH",nullable=true,length=50)
	public java.lang.String getFzrdh(){
		return this.fzrdh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  负责人电话
	 */
	public void setFzrdh(java.lang.String fzrdh){
		this.fzrdh = fzrdh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	@Column(name ="LXR",nullable=true,length=50)
	public java.lang.String getLxr(){
		return this.lxr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setLxr(java.lang.String lxr){
		this.lxr = lxr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人电话
	 */
	@Column(name ="LXRDH",nullable=true,length=50)
	public java.lang.String getLxrdh(){
		return this.lxrdh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人电话
	 */
	public void setLxrdh(java.lang.String lxrdh){
		this.lxrdh = lxrdh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款条件
	 */
	@Column(name ="FKTJ",nullable=true,length=100)
	public java.lang.String getFktj(){
		return this.fktj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款条件
	 */
	public void setFktj(java.lang.String fktj){
		this.fktj = fktj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供货期
	 */
	@Column(name ="GHQ",nullable=true,length=50)
	public java.lang.String getGhq(){
		return this.ghq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供货期
	 */
	public void setGhq(java.lang.String ghq){
		this.ghq = ghq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配送方式
	 */
	@Column(name ="PSFS",nullable=true,length=50)
	public java.lang.String getPsfs(){
		return this.psfs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配送方式
	 */
	public void setPsfs(java.lang.String psfs){
		this.psfs = psfs;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否技术支持
	 */
	@Column(name ="SFJSZC",nullable=true,length=1)
	public java.lang.Integer getSfjszc(){
		return this.sfjszc;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否技术支持
	 */
	public void setSfjszc(java.lang.Integer sfjszc){
		this.sfjszc = sfjszc;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否一般纳税人
	 */
	@Column(name ="SFYBNSR",nullable=true,length=1)
	public java.lang.Integer getSfybnsr(){
		return this.sfybnsr;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否一般纳税人
	 */
	public void setSfybnsr(java.lang.Integer sfybnsr){
		this.sfybnsr = sfybnsr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调查及评价报告编号
	 */
	@Column(name ="PJBGBH",nullable=true,length=50)
	public java.lang.String getPjbgbh(){
		return this.pjbgbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调查及评价报告编号
	 */
	public void setPjbgbh(java.lang.String pjbgbh){
		this.pjbgbh = pjbgbh;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  首次列入日期
	 */
	@Column(name ="SCLRRQ",nullable=true,length=20)
	public java.util.Date getSclrrq(){
		return this.sclrrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  首次列入日期
	 */
	public void setSclrrq(java.util.Date sclrrq){
		this.sclrrq = sclrrq;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年度复评结果
	 */
	@Column(name ="NDFPJG",nullable=true,length=1)
	public java.lang.Integer getNdfpjg(){
		return this.ndfpjg;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年度复评结果
	 */
	public void setNdfpjg(java.lang.Integer ndfpjg){
		this.ndfpjg = ndfpjg;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  复评时间
	 */
	@Column(name ="FPSJ",nullable=true,length=20)
	public java.util.Date getFpsj(){
		return this.fpsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  复评时间
	 */
	public void setFpsj(java.util.Date fpsj){
		this.fpsj = fpsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评定结论
	 */
	@Column(name ="PDJL",nullable=true,length=50)
	public java.lang.String getPdjl(){
		return this.pdjl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评定结论
	 */
	public void setPdjl(java.lang.String pdjl){
		this.pdjl = pdjl;
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
}
