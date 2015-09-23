package com.gfdz.entity.hr;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.web.system.pojo.base.TSAttachment;

/**   
 * @Title: Entity
 * @Description: 合同信息附件
 * @author ant
 * @date 2015-07-01 17:05:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_personContract_files", schema = "")
@PrimaryKeyJoinColumn(name = "id")
@SuppressWarnings("serial")
public class PersonContractFilesEntity extends TSAttachment implements java.io.Serializable {
	/**合同信息id*/
	private PersonContractEntity personContract;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同信息id
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name ="PERSONCONTRACT_ID")
	public PersonContractEntity getPersonContract(){
		return this.personContract;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同信息id
	 */
	public void setPersonContract(PersonContractEntity personContract){
		this.personContract = personContract;
	}
}
