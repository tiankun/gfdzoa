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
 * @Description: 面试信息
 * @author ant
 * @date 2015-06-11 11:30:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_interview", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class InterviewEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String pId;
	/**希望待遇*/
	private java.lang.String wantPay;
	/**待遇底线*/
	private java.lang.String payUnderline;
	/**应聘岗位*/
	private java.lang.String position;
	/**对岗位的认识*/
	private java.lang.String aboutPst;
	/**优势特点*/
	private java.lang.String superiority;
	/**现工作单位*/
	private java.lang.String unitNow;
	/**现职业状况*/
	private java.lang.String uStatus;
	/**离职原因*/
	private java.lang.String reasonL;
	/**到岗时间*/
	private java.lang.String posTime;
	/**性格*/
	private java.lang.String character;
	/**形象气质*/
	private java.lang.String form;
	/**态度举止*/
	private java.lang.String manner;
	/**表达方式*/
	private java.lang.String expression;
	/**问题解决能力*/
	private java.lang.String dealAb;
	/**表达能力*/
	private java.lang.String expAb;
	/**公司比重*/
	private java.lang.Integer uScale;
	/**个人比重*/
	private java.lang.Integer pScale;
	/**薪酬比重*/
	private java.lang.Integer mScale;
	/**人际比重*/
	private java.lang.Integer rScale;
	/**其他*/
	private java.lang.String other;
	/**其他比重*/
	private java.lang.Integer oScale;
	/**抗压能力*/
	private java.lang.String antiPres;
	/**解压方式*/
	private java.lang.String extractWay;
	/**吃苦能力*/
	private java.lang.String willpower;
	/**其他描述*/
	private java.lang.String back;
	/**考题方案评价*/
	private java.lang.String examine;
	/**结果*/
	private java.lang.String result;
	/**语言*/
	private java.lang.String language;
	/**声音*/
	private java.lang.String voice;
	/**行为*/
	private java.lang.String behavior;
	/**倾听能力*/
	private java.lang.String listen;
	/**思维能力*/
	private java.lang.String thinking;
	/**性格补充*/
	private java.lang.String oCharacter;
	/**语言补充*/
	private java.lang.String oLanguage;
	/**形象气质补充*/
	private java.lang.String oForm;
	/**态度举止补充*/
	private java.lang.String oManner;
	/**行为补充*/
	private java.lang.String oBehavior;
	/**表达方式补充*/
	private java.lang.String oExpression;
	/**解决能力补充*/
	private java.lang.String oDealAb;
	/**倾听补充*/
	private java.lang.String oListen;
	/**思维补充*/
	private java.lang.String oThinking;
	/**试用工资*/
	private java.lang.Integer entryPay;
	/**试用期*/
	private java.util.Date entryDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=80)
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
	 *@return: java.lang.String  人员编号
	 */
	@Column(name ="P_ID",nullable=false,length=80)
	public java.lang.String getPId(){
		return this.pId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员编号
	 */
	public void setPId(java.lang.String pId){
		this.pId = pId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  希望待遇
	 */
	@Column(name ="WANT_PAY",nullable=true,length=80)
	public java.lang.String getWantPay(){
		return this.wantPay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  希望待遇
	 */
	public void setWantPay(java.lang.String wantPay){
		this.wantPay = wantPay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  待遇底线
	 */
	@Column(name ="PAY_UNDERLINE",nullable=true,length=80)
	public java.lang.String getPayUnderline(){
		return this.payUnderline;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  待遇底线
	 */
	public void setPayUnderline(java.lang.String payUnderline){
		this.payUnderline = payUnderline;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应聘岗位
	 */
	@Column(name ="POSITION",nullable=true,length=160)
	public java.lang.String getPosition(){
		return this.position;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应聘岗位
	 */
	public void setPosition(java.lang.String position){
		this.position = position;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对岗位的认识
	 */
	@Column(name ="ABOUT_PST",nullable=true,length=600)
	public java.lang.String getAboutPst(){
		return this.aboutPst;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对岗位的认识
	 */
	public void setAboutPst(java.lang.String aboutPst){
		this.aboutPst = aboutPst;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优势特点
	 */
	@Column(name ="SUPERIORITY",nullable=true,length=600)
	public java.lang.String getSuperiority(){
		return this.superiority;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优势特点
	 */
	public void setSuperiority(java.lang.String superiority){
		this.superiority = superiority;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现工作单位
	 */
	@Column(name ="UNIT_NOW",nullable=true,length=200)
	public java.lang.String getUnitNow(){
		return this.unitNow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现工作单位
	 */
	public void setUnitNow(java.lang.String unitNow){
		this.unitNow = unitNow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现职业状况
	 */
	@Column(name ="U_STATUS",nullable=true,length=200)
	public java.lang.String getUStatus(){
		return this.uStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现职业状况
	 */
	public void setUStatus(java.lang.String uStatus){
		this.uStatus = uStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  离职原因
	 */
	@Column(name ="REASON_L",nullable=true,length=600)
	public java.lang.String getReasonL(){
		return this.reasonL;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  离职原因
	 */
	public void setReasonL(java.lang.String reasonL){
		this.reasonL = reasonL;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到岗时间
	 */
	@Column(name ="POS_TIME",nullable=true,length=40)
	public java.lang.String getPosTime(){
		return this.posTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到岗时间
	 */
	public void setPosTime(java.lang.String posTime){
		this.posTime = posTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性格
	 */
	@Column(name ="CHARACTER",nullable=true,length=400)
	public java.lang.String getCharacter(){
		return this.character;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性格
	 */
	public void setCharacter(java.lang.String character){
		this.character = character;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  形象气质
	 */
	@Column(name ="FORM",nullable=true,length=400)
	public java.lang.String getForm(){
		return this.form;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  形象气质
	 */
	public void setForm(java.lang.String form){
		this.form = form;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  态度举止
	 */
	@Column(name ="MANNER",nullable=true,length=400)
	public java.lang.String getManner(){
		return this.manner;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  态度举止
	 */
	public void setManner(java.lang.String manner){
		this.manner = manner;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表达方式
	 */
	@Column(name ="EXPRESSION",nullable=true,length=400)
	public java.lang.String getExpression(){
		return this.expression;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表达方式
	 */
	public void setExpression(java.lang.String expression){
		this.expression = expression;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题解决能力
	 */
	@Column(name ="DEAL_AB",nullable=true,length=400)
	public java.lang.String getDealAb(){
		return this.dealAb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题解决能力
	 */
	public void setDealAb(java.lang.String dealAb){
		this.dealAb = dealAb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表达能力
	 */
	@Column(name ="EXP_AB",nullable=true,length=200)
	public java.lang.String getExpAb(){
		return this.expAb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表达能力
	 */
	public void setExpAb(java.lang.String expAb){
		this.expAb = expAb;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  公司比重
	 */
	@Column(name ="U_SCALE",nullable=true)
	public java.lang.Integer getUScale(){
		return this.uScale;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  公司比重
	 */
	public void setUScale(java.lang.Integer uScale){
		this.uScale = uScale;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  个人比重
	 */
	@Column(name ="P_SCALE",nullable=true)
	public java.lang.Integer getPScale(){
		return this.pScale;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  个人比重
	 */
	public void setPScale(java.lang.Integer pScale){
		this.pScale = pScale;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  薪酬比重
	 */
	@Column(name ="M_SCALE",nullable=true)
	public java.lang.Integer getMScale(){
		return this.mScale;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  薪酬比重
	 */
	public void setMScale(java.lang.Integer mScale){
		this.mScale = mScale;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  人际比重
	 */
	@Column(name ="R_SCALE",nullable=true)
	public java.lang.Integer getRScale(){
		return this.rScale;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  人际比重
	 */
	public void setRScale(java.lang.Integer rScale){
		this.rScale = rScale;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他
	 */
	@Column(name ="OTHER",nullable=true,length=200)
	public java.lang.String getOther(){
		return this.other;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他
	 */
	public void setOther(java.lang.String other){
		this.other = other;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  其他比重
	 */
	@Column(name ="O_SCALE",nullable=true)
	public java.lang.Integer getOScale(){
		return this.oScale;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  其他比重
	 */
	public void setOScale(java.lang.Integer oScale){
		this.oScale = oScale;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  抗压能力
	 */
	@Column(name ="ANTI_PRES",nullable=true,length=400)
	public java.lang.String getAntiPres(){
		return this.antiPres;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  抗压能力
	 */
	public void setAntiPres(java.lang.String antiPres){
		this.antiPres = antiPres;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  解压方式
	 */
	@Column(name ="EXTRACT_WAY",nullable=true,length=400)
	public java.lang.String getExtractWay(){
		return this.extractWay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  解压方式
	 */
	public void setExtractWay(java.lang.String extractWay){
		this.extractWay = extractWay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  吃苦能力
	 */
	@Column(name ="WILLPOWER",nullable=true,length=400)
	public java.lang.String getWillpower(){
		return this.willpower;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  吃苦能力
	 */
	public void setWillpower(java.lang.String willpower){
		this.willpower = willpower;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他描述
	 */
	@Column(name ="BACK",nullable=true,length=600)
	public java.lang.String getBack(){
		return this.back;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他描述
	 */
	public void setBack(java.lang.String back){
		this.back = back;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考题方案评价
	 */
	@Column(name ="EXAMINE",nullable=true,length=600)
	public java.lang.String getExamine(){
		return this.examine;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考题方案评价
	 */
	public void setExamine(java.lang.String examine){
		this.examine = examine;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结果
	 */
	@Column(name ="RESULT",nullable=true,length=40)
	public java.lang.String getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果
	 */
	public void setResult(java.lang.String result){
		this.result = result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  语言
	 */
	@Column(name ="LANGUAGE",nullable=true,length=400)
	public java.lang.String getLanguage(){
		return this.language;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  语言
	 */
	public void setLanguage(java.lang.String language){
		this.language = language;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  声音
	 */
	@Column(name ="VOICE",nullable=true,length=400)
	public java.lang.String getVoice(){
		return this.voice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  声音
	 */
	public void setVoice(java.lang.String voice){
		this.voice = voice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行为
	 */
	@Column(name ="BEHAVIOR",nullable=true,length=400)
	public java.lang.String getBehavior(){
		return this.behavior;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行为
	 */
	public void setBehavior(java.lang.String behavior){
		this.behavior = behavior;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  倾听能力
	 */
	@Column(name ="LISTEN",nullable=true,length=400)
	public java.lang.String getListen(){
		return this.listen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  倾听能力
	 */
	public void setListen(java.lang.String listen){
		this.listen = listen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  思维能力
	 */
	@Column(name ="THINKING",nullable=true,length=400)
	public java.lang.String getThinking(){
		return this.thinking;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  思维能力
	 */
	public void setThinking(java.lang.String thinking){
		this.thinking = thinking;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性格补充
	 */
	@Column(name ="O_CHARACTER",nullable=true,length=400)
	public java.lang.String getOCharacter(){
		return this.oCharacter;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性格补充
	 */
	public void setOCharacter(java.lang.String oCharacter){
		this.oCharacter = oCharacter;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  语言补充
	 */
	@Column(name ="O_LANGUAGE",nullable=true,length=400)
	public java.lang.String getOLanguage(){
		return this.oLanguage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  语言补充
	 */
	public void setOLanguage(java.lang.String oLanguage){
		this.oLanguage = oLanguage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  形象气质补充
	 */
	@Column(name ="O_FORM",nullable=true,length=400)
	public java.lang.String getOForm(){
		return this.oForm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  形象气质补充
	 */
	public void setOForm(java.lang.String oForm){
		this.oForm = oForm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  态度举止补充
	 */
	@Column(name ="O_MANNER",nullable=true,length=400)
	public java.lang.String getOManner(){
		return this.oManner;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  态度举止补充
	 */
	public void setOManner(java.lang.String oManner){
		this.oManner = oManner;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行为补充
	 */
	@Column(name ="O_BEHAVIOR",nullable=true,length=400)
	public java.lang.String getOBehavior(){
		return this.oBehavior;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行为补充
	 */
	public void setOBehavior(java.lang.String oBehavior){
		this.oBehavior = oBehavior;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表达方式补充
	 */
	@Column(name ="O_EXPRESSION",nullable=true,length=400)
	public java.lang.String getOExpression(){
		return this.oExpression;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表达方式补充
	 */
	public void setOExpression(java.lang.String oExpression){
		this.oExpression = oExpression;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  解决能力补充
	 */
	@Column(name ="O_DEAL_AB",nullable=true,length=400)
	public java.lang.String getODealAb(){
		return this.oDealAb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  解决能力补充
	 */
	public void setODealAb(java.lang.String oDealAb){
		this.oDealAb = oDealAb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  倾听补充
	 */
	@Column(name ="O_LISTEN",nullable=true,length=400)
	public java.lang.String getOListen(){
		return this.oListen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  倾听补充
	 */
	public void setOListen(java.lang.String oListen){
		this.oListen = oListen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  思维补充
	 */
	@Column(name ="O_THINKING",nullable=true,length=400)
	public java.lang.String getOThinking(){
		return this.oThinking;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  思维补充
	 */
	public void setOThinking(java.lang.String oThinking){
		this.oThinking = oThinking;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  试用工资
	 */
	@Column(name ="ENTRY_PAY",nullable=true)
	public java.lang.Integer getEntryPay(){
		return this.entryPay;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  试用工资
	 */
	public void setEntryPay(java.lang.Integer entryPay){
		this.entryPay = entryPay;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  试用期
	 */
	@Column(name ="ENTRY_DATE",nullable=true)
	public java.util.Date getEntryDate(){
		return this.entryDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  试用期
	 */
	public void setEntryDate(java.util.Date entryDate){
		this.entryDate = entryDate;
	}
}
