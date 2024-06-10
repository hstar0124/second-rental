package com.kh.forest.member.model.vo;

import java.sql.Date;

public class WarningHistory {
	private String warningNo;
	private String reportNo;
	private String userNo;
	private String userName;
	private Date warningDate;
	private String empNo;
	private String empId;
	
	public WarningHistory() {}

	public WarningHistory(String warningNo, String reportNo, String userNo, String userName, Date warningDate,
			String empNo, String empId) {
		super();
		this.warningNo = warningNo;
		this.reportNo = reportNo;
		this.userNo = userNo;
		this.userName = userName;
		this.warningDate = warningDate;
		this.empNo = empNo;
		this.empId = empId;
	}

	public String getWarningNo() {
		return warningNo;
	}

	public void setWarningNo(String warningNo) {
		this.warningNo = warningNo;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
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

	public Date getWarningDate() {
		return warningDate;
	}

	public void setWarningDate(Date warningDate) {
		this.warningDate = warningDate;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "WarningHistory [warningNo=" + warningNo + ", reportNo=" + reportNo + ", userNo=" + userNo
				+ ", userName=" + userName + ", warningDate=" + warningDate + ", empNo=" + empNo + ", empId=" + empId
				+ "]";
	}
	
	
}
