package com.gfdz.entity.gc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: 技术移交记录表
 * @author ant
 * @date 2015-05-28 14:46:04
 * @version V1.0
 * 
 */
@Entity
@Table(name = "t_s_code", schema = "")
public class CodeEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6505464552987215821L;
	/** 主键 */
	private java.lang.String id;
	private String codeType;
	private Integer several;

	public CodeEntity() {
	}

	public CodeEntity(String codeType, Integer several) {
		super();
		this.codeType = codeType;
		this.several = several;
	}

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 50)
	public java.lang.String getId() {
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	@Column(name = "CODETYPE", nullable = true)
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	@Column(name = "SEVERAL")
	public Integer getSeveral() {
		return several;
	}

	public void setSeveral(Integer several) {
		this.several = several;
	}

}
