package com.kh.forest.point.model.vo;

import java.sql.Date;

public class Reason {
	private String cashBackHistoryNo;
	private String reason;
	private int point;
	private int money;
	private String userId;
	private Date cashbackDate;
	
	public Reason() {}

	public Reason(String cashBackHistoryNo, String reason, int point, int money, String userId, Date cashbackDate) {
		super();
		this.cashBackHistoryNo = cashBackHistoryNo;
		this.reason = reason;
		this.point = point;
		this.money = money;
		this.userId = userId;
		this.cashbackDate = cashbackDate;
	}

	public String getCashBackHistoryNo() {
		return cashBackHistoryNo;
	}

	public void setCashBackHistoryNo(String cashBackHistoryNo) {
		this.cashBackHistoryNo = cashBackHistoryNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCashbackDate() {
		return cashbackDate;
	}

	public void setCashbackDate(Date cashbackDate) {
		this.cashbackDate = cashbackDate;
	}

	@Override
	public String toString() {
		return "Reason [cashBackHistoryNo=" + cashBackHistoryNo + ", reason=" + reason + ", point=" + point + ", money="
				+ money + ", userId=" + userId + ", cashbackDate=" + cashbackDate + "]";
	}

	
}
