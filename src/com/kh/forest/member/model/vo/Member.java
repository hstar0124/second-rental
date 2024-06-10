package com.kh.forest.member.model.vo;

import java.sql.Date;

public class Member implements java.io.Serializable {
	private String userNo;
	private String userId;
	private String userName;
	private String password;
	private String birth;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private String bank;
	private String accountHolder;
	private String account;
	private int point;
	private int warningCount;
	private	Date enrollDate;
	private Date modifyDate;
	private String status;
	private int logCount;
	
	public Member() {}

	public Member(String userNo, String userId, String userName, String password, String birth, String gender,
			String email, String phone, String address, String bank, String accountHolder, String account, int point,
			int warningCount, Date enrollDate, Date modifyDate, String status, int logCount) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.bank = bank;
		this.accountHolder = accountHolder;
		this.account = account;
		this.point = point;
		this.warningCount = warningCount;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.logCount = logCount;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String string) {
		this.userNo = string;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getLogCount() {
		return logCount;
	}
	
	public void setLogCount(int logCount) {
		this.logCount = logCount;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", birth=" + birth + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", bank=" + bank + ", accountHolder=" + accountHolder + ", account=" + account + ", point="
				+ point + ", warningCount=" + warningCount + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate
				+ ", status=" + status + "]";
	}

	
	
	
}
