package com.gfdz.entity.cw;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.web.system.pojo.base.TSAttachment;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 发票附件
 * @author ant
 * @date 2015-07-01 16:26:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cw_bill_files", schema = "")
@PrimaryKeyJoinColumn(name = "id")
@SuppressWarnings("serial")
public class BillFilesEntity extends TSAttachment implements java.io.Serializable {
	/**学历信息id*/
	private BillEntity bill;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历信息id
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name ="BILL_ID")
	public BillEntity getBill(){
		return this.bill;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历信息id
	 */
	public void setBill(BillEntity bill){
		this.bill = bill;
	}
}
