package com.core.dao.domain.table;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商信息
 * 
 * @author lliang
 *
 */
public class HestiaSupplierTable implements Serializable {

	private static final long serialVersionUID = -9220122779235006449L;

	// 主键
	private Long hestiaSupplierId;

	// 供应商代码
	private String supplierCode;

	// 供应商名称
	private String supplierName;

	// 供应商状态（启用10，停用20）
	private Integer status;

	// 供应商合同开始时间
	private Date startTime;

	// 供应商合同结束时间
	private Date endTime;

	// 供应商请求地址
	private String requestUrl;

	// 供应商回调地址
	private String callbackUrl;

	// 供应商账号
	private String account;

	// 供应商密码
	private String password;

	// 应用代码
	private String appCode;
	
	// 应用名称
	private String appName;

	// 创建时间
	private Date createTime;
	
	// 更新时间
	private Date updateTime;
	
	// 版本控制
	private Integer version;

	// 账户余额
	private String accountBalance;

	// 供应商saltkey
	private String saltkey;

	
	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSaltkey() {
		return saltkey;
	}

	public void setSaltkey(String saltkey) {
		this.saltkey = saltkey;
	}

	public Long getHestiaSupplierId() {
		return hestiaSupplierId;
	}

	public void setHestiaSupplierId(Long hestiaSupplierId) {
		this.hestiaSupplierId = hestiaSupplierId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

}
