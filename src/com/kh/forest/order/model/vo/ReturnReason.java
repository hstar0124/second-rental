package com.kh.forest.order.model.vo;

public class ReturnReason {
	private String returnNo;
	private String division;
	private String historyNo;
	private String reason;
	
	public ReturnReason() {}

	public ReturnReason(String returnNo, String division, String historyNo, String reason) {
		super();
		this.returnNo = returnNo;
		this.division = division;
		this.historyNo = historyNo;
		this.reason = reason;
	}

	public String getReturnNo() {
		return returnNo;
	}

	public void setReturnNo(String returnNo) {
		this.returnNo = returnNo;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(String historyNo) {
		this.historyNo = historyNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ReturnReason [returnNo=" + returnNo + ", division=" + division + ", historyNo=" + historyNo
				+ ", reason=" + reason + "]";
	}
	
	
}
