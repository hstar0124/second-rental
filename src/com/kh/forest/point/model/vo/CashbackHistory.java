package com.kh.forest.point.model.vo;

public class CashbackHistory {
	private String cashbackHistoryNo;
	private String cashbackNo;
	private String cashbackDate;
	private String userNo;
	private String userName;
	private String bankName;
	private String account;
	private String email;
	private int printCount;
	private int cashbackPoint;
	private int memberPoint;
	private int money;
	private String status;
	
	public CashbackHistory() {}

	public CashbackHistory(String cashbackHistoryNo, String cashbackNo, String cashbackDate, String userNo,
			String userName, String bankName, String account, String email, int printCount, int cashbackPoint,
			int memberPoint, int money, String status) {
		super();
		this.cashbackHistoryNo = cashbackHistoryNo;
		this.cashbackNo = cashbackNo;
		this.cashbackDate = cashbackDate;
		this.userNo = userNo;
		this.userName = userName;
		this.bankName = bankName;
		this.account = account;
		this.email = email;
		this.printCount = printCount;
		this.cashbackPoint = cashbackPoint;
		this.memberPoint = memberPoint;
		this.money = money;
		this.status = status;
	}

	public String getCashbackHistoryNo() {
		return cashbackHistoryNo;
	}

	public void setCashbackHistoryNo(String cashbackHistoryNo) {
		this.cashbackHistoryNo = cashbackHistoryNo;
	}

	public String getCashbackNo() {
		return cashbackNo;
	}

	public void setCashbackNo(String cashbackNo) {
		this.cashbackNo = cashbackNo;
	}

	public String getCashbackDate() {
		return cashbackDate;
	}

	public void setCashbackDate(String cashbackDate) {
		this.cashbackDate = cashbackDate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrintCount() {
		return printCount;
	}

	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}

	public int getCashbackPoint() {
		return cashbackPoint;
	}

	public void setCashbackPoint(int cashbackPoint) {
		this.cashbackPoint = cashbackPoint;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CashbackHistory [cashbackHistoryNo=" + cashbackHistoryNo + ", cashbackNo=" + cashbackNo
				+ ", cashbackDate=" + cashbackDate + ", userNo=" + userNo + ", userName=" + userName + ", bankName="
				+ bankName + ", account=" + account + ", email=" + email + ", printCount=" + printCount
				+ ", cashbackPoint=" + cashbackPoint + ", memberPoint=" + memberPoint + ", money=" + money + ", status="
				+ status + "]";
	}

	
	
	
}
