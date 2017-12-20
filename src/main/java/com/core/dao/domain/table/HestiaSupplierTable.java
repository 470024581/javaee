package com.core.dao.domain.table;

import java.io.Serializable;
import java.util.Date;

/**
 * ��Ӧ����Ϣ
 * 
 * @author lliang
 *
 */
public class HestiaSupplierTable implements Serializable {

	private static final long serialVersionUID = -9220122779235006449L;

	// ����
	private Long hestiaSupplierId;

	// ��Ӧ�̴���
	private String supplierCode;

	// ��Ӧ������
	private String supplierName;

	// ��Ӧ��״̬������10��ͣ��20��
	private Integer status;

	// ��Ӧ�̺�ͬ��ʼʱ��
	private Date startTime;

	// ��Ӧ�̺�ͬ����ʱ��
	private Date endTime;

	// ��Ӧ�������ַ
	private String requestUrl;

	// ��Ӧ�̻ص���ַ
	private String callbackUrl;

	// ��Ӧ���˺�
	private String account;

	// ��Ӧ������
	private String password;

	// Ӧ�ô���
	private String appCode;
	
	// Ӧ������
	private String appName;

	// ����ʱ��
	private Date createTime;
	
	// ����ʱ��
	private Date updateTime;
	
	// �汾����
	private Integer version;

	// �˻����
	private String accountBalance;

	// ��Ӧ��saltkey
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
