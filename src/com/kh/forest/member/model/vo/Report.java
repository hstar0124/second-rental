package com.kh.forest.member.model.vo;

import java.sql.Date;

public class Report {
	private String reportNo;
	private String rBorderNo;
	private String fromUserNo;
	private String fromUserName;
	private String toUserNo;
	private String toUserName;
	private Date reportDate;
	private String email;
	private String reason;
	private String status;
	private String rTitle;
	private String rContent;
	private int warningCount;
	
	public Report() {}

	public Report(String reportNo, String rBorderNo, String fromUserNo, String fromUserName, String toUserNo,
			String toUserName, Date reportDate, String email, String reason, String status, String rTitle,
			String rContent, int warningCount) {
		super();
		this.reportNo = reportNo;
		this.rBorderNo = rBorderNo;
		this.fromUserNo = fromUserNo;
		this.fromUserName = fromUserName;
		this.toUserNo = toUserNo;
		this.toUserName = toUserName;
		this.reportDate = reportDate;
		this.email = email;
		this.reason = reason;
		this.status = status;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.warningCount = warningCount;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getrBorderNo() {
		return rBorderNo;
	}

	public void setrBorderNo(String rBorderNo) {
		this.rBorderNo = rBorderNo;
	}

	public String getFromUserNo() {
		return fromUserNo;
	}

	public void setFromUserNo(String fromUserNo) {
		this.fromUserNo = fromUserNo;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getToUserNo() {
		return toUserNo;
	}

	public void setToUserNo(String toUserNo) {
		this.toUserNo = toUserNo;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", rBorderNo=" + rBorderNo + ", fromUserNo=" + fromUserNo
				+ ", fromUserName=" + fromUserName + ", toUserNo=" + toUserNo + ", toUserName=" + toUserName
				+ ", reportDate=" + reportDate + ", email=" + email + ", reason=" + reason + ", status=" + status
				+ ", rTitle=" + rTitle + ", rContent=" + rContent + ", warningCount=" + warningCount + "]";
	}

	
	

	

}
