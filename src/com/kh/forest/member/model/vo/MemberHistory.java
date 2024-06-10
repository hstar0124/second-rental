package com.kh.forest.member.model.vo;



public class MemberHistory {
	private String historyNo;
	private String status;
	private String modifyDate;
	private String userNo;
	private String userName;
	
	public MemberHistory() {}

	public MemberHistory(String historyNo, String status, String modifyDate, String userNo, String userName) {
		super();
		this.historyNo = historyNo;
		this.status = status;
		this.modifyDate = modifyDate;
		this.userNo = userNo;
		this.userName = userName;
	}

	public String getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(String historyNo) {
		this.historyNo = historyNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
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

	@Override
	public String toString() {
		return "MemberHistory [historyNo=" + historyNo + ", status=" + status + ", modifyDate=" + modifyDate
				+ ", userNo=" + userNo + ", userName=" + userName + "]";
	}

	
	
	
}
