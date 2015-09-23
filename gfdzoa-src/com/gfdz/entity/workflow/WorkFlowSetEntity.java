package com.gfdz.entity.workflow;

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
 * @Description: 流程设置
 * @author ant
 * @date 2015-06-17 10:09:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_workFlowSet", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class WorkFlowSetEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**部署id*/
	private java.lang.String deploymentId;
	/**流程key*/
	private java.lang.String processKey;
	/**流程定义id*/
	private java.lang.String processDefinitionId;
	/**开始请求*/
	private java.lang.String beginUrl;
	/**处理请求*/
	private java.lang.String handleUrl;
	/**查看请求*/
	private java.lang.String detailUrl;
	/**流程分类*/
	private java.lang.String processType;
	/**流程说明*/
	private java.lang.String processExplain;
	
	/**开始路径*/
	private java.lang.String beginPath;
	/**处理路径*/
	private java.lang.String handlePath;
	/**查看路径*/
	private java.lang.String detailPath;
	/**对应实体名称*/
	private String entityName;
	/**流程名称*/
	private String processName;
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
	 *@return: java.lang.String  部署id
	 */
	@Column(name ="DEPLOYMENT_ID",nullable=true,length=255)
	public java.lang.String getDeploymentId(){
		return this.deploymentId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部署id
	 */
	public void setDeploymentId(java.lang.String deploymentId){
		this.deploymentId = deploymentId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程key
	 */
	@Column(name ="PROCESS_KEY",nullable=true,length=255)
	public java.lang.String getProcessKey(){
		return this.processKey;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程key
	 */
	public void setProcessKey(java.lang.String processKey){
		this.processKey = processKey;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程定义id
	 */
	@Column(name ="PROCESS_DEFINITION_ID",nullable=true,length=255)
	public java.lang.String getProcessDefinitionId(){
		return this.processDefinitionId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程定义id
	 */
	public void setProcessDefinitionId(java.lang.String processDefinitionId){
		this.processDefinitionId = processDefinitionId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开始请求
	 */
	@Column(name ="BEGIN_URL",nullable=true,length=255)
	public java.lang.String getBeginUrl(){
		return this.beginUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开始请求
	 */
	public void setBeginUrl(java.lang.String beginUrl){
		this.beginUrl = beginUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理请求
	 */
	@Column(name ="HANDLE_URL",nullable=true,length=255)
	public java.lang.String getHandleUrl(){
		return this.handleUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理请求
	 */
	public void setHandleUrl(java.lang.String handleUrl){
		this.handleUrl = handleUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  查看请求
	 */
	@Column(name ="DETAIL_URL",nullable=true,length=255)
	public java.lang.String getDetailUrl(){
		return this.detailUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  查看请求
	 */
	public void setDetailUrl(java.lang.String detailUrl){
		this.detailUrl = detailUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程分类
	 */
	@Column(name ="PROCESS_TYPE",nullable=true,length=255)
	public java.lang.String getProcessType(){
		return this.processType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程分类
	 */
	public void setProcessType(java.lang.String processType){
		this.processType = processType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程说明
	 */
	@Column(name ="PROCESS_EXPLAIN",nullable=true,length=255)
	public java.lang.String getProcessExplain(){
		return this.processExplain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程说明
	 */
	public void setProcessExplain(java.lang.String processExplain){
		this.processExplain = processExplain;
	}

	@Column(name ="BEGIN_PATH",nullable=true,length=255)
	public java.lang.String getBeginPath() {
		return beginPath;
	}

	public void setBeginPath(java.lang.String beginPath) {
		this.beginPath = beginPath;
	}
	
	@Column(name ="HANDLE_PATH",nullable=true,length=255)
	public java.lang.String getHandlePath() {
		return handlePath;
	}

	public void setHandlePath(java.lang.String handlePath) {
		this.handlePath = handlePath;
	}

	@Column(name ="DETAIL_PATH",nullable=true,length=255)
	public java.lang.String getDetailPath() {
		return detailPath;
	}

	public void setDetailPath(java.lang.String detailPath) {
		this.detailPath = detailPath;
	}
	
	@Column(name ="ENTITY_NAME",nullable=true,length=255)
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	@Column(name ="PROCESS_NAME",nullable=true,length=255)
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	
}
