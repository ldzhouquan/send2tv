package org.sky31.petstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础DO类
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-10
 */
public class BaseDO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7182800689476954216L;
	
	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 记录创建时间
	 */
	private Date gmtCreate;
	
	/**
	 * 记录修改时间
	 */
	private Date gmtModified;

	/**
	 * 获取id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置id
	 * 
	 * @param id 要设置的id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取gmtCreate
	 * 
	 * @return gmtCreate
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * 设置gmtCreate
	 * 
	 * @param gmtCreate 要设置的gmtCreate
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * 获取gmtModified
	 * 
	 * @return gmtModified
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	/**
	 * 设置gmtModified
	 * 
	 * @param gmtModified 要设置的gmtModified
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}
