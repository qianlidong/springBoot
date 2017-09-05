package com.qian.domain;
// Generated 2015-11-10 18:48:51 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * 企业客户申请跨境功能的申请表
 * 
 * @author huangcheng
 * 
 */
@Entity
@Table(name = "CB_CORP_APPLY_test")
public class CbCorpApply  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6483372266281397911L;
	
	public static final String aa = "0";
	
	
	/**
	 * 客户ID
	 */
	private String custId;
	
	/**
	 * 企业名称
	 */
	private String corpName;
	
	/**
	 * 企业网址
	 */
	private String corpUrl;
	
	/**
	 * 联系人姓名
	 */
	private String linkmanName;
	
	/**
	 * 联系人电话
	 */
	private String linkmanTel;
	
	/**
	 * 提交时间
	 */
	private Date applyDate;
	
	/**
	 * 审核时间
	 */
	private Date verifyDate;
	
	/**
	 * 申请状态 0-初始状态 1-待审核 2-审核通过 3-审核不通过
	 */
	private String verifyState;
	
	/**
	 * 失败原因
	 */
	private String failMessage;

	public CbCorpApply() {
	}

	public CbCorpApply(String custId) {
		this.custId = custId;
	}

	public CbCorpApply(String custId, String corpName, String corpUrl, String linkmanName, String linkmanTel,
                       Date applyDate, Date verifyDate, String verifyState, String failMessage) {

			this.custId = custId;
			this.corpName = corpName;
			this.corpUrl = corpUrl;
			this.linkmanName = linkmanName;
			this.linkmanTel = linkmanTel;
			this.applyDate = applyDate;
			this.verifyDate = verifyDate;
			this.verifyState = verifyState;
			this.failMessage = failMessage;

	}

	@Id

	@Column(name = "CUST_ID", unique = true, nullable = false, length = 10)
	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	@Column(name = "CORP_NAME", length = 100)
	public String getCorpName() {
		return this.corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	@Column(name = "CORP_URL", length = 500)
	public String getCorpUrl() {
		return this.corpUrl;
	}

	public void setCorpUrl(String corpUrl) {
		this.corpUrl = corpUrl;
	}

	@Column(name = "LINKMAN_NAME", length = 150)
	public String getLinkmanName() {
        return this.linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
	    this.linkmanName = linkmanName;
	}

	@Column(name = "LINKMAN_TEL", length = 150)
	public String getLinkmanTel() {

        return this.linkmanTel;
	}

	public void setLinkmanTel(String linkmanTel) {
	    this.linkmanTel = linkmanTel;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPLY_DATE")
	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VERIFY_DATE")
	public Date getVerifyDate() {
		return this.verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	@Column(name = "VERIFY_STATE", length = 1)
	public String getVerifyState() {
		return this.verifyState;
	}

	public void setVerifyState(String verifyState) {
		this.verifyState = verifyState;
	}

	@Column(name = "FAIL_MESSAGE", length = 500)
	public String getFailMessage() {
		return this.failMessage;
	}

	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}

}
