package com.gfdz.entity.hr;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.web.system.pojo.base.TSAttachment;

/**   
 * @Title: Entity
 * @Description: 证书信息附件
 * @author ant
 * @date 2015-07-01 17:01:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hr_certificate_files", schema = "")
@PrimaryKeyJoinColumn(name = "id")
@SuppressWarnings("serial")
public class CertificateFilesEntity extends TSAttachment implements java.io.Serializable {
	/**证书信息id*/
	private CertificateEntity certificate;
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书信息id
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name ="CERTIFICATE_ID")
	public CertificateEntity getCertificate(){
		return this.certificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书信息id
	 */
	public void setCertificate(CertificateEntity certificate){
		this.certificate = certificate;
	}
}
