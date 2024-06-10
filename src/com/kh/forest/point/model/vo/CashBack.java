package com.kh.forest.point.model.vo;

import java.sql.Date;

public class CashBack {
	private String cashbackNo;
	private int cashbackPoint;
	private int Rate;
	private Date cashbackDate;
	private String userNo;
	private String userName;
	private int money;
	
	public CashBack() {}

	public CashBack(String cashbackNo, int cashbackPoint, int rate, Date cashbackDate, String userNo, String userName,
			int money) {
		super();
		this.cashbackNo = cashbackNo;
		this.cashbackPoint = cashbackPoint;
		Rate = rate;
		this.cashbackDate = cashbackDate;
		this.userNo = userNo;
		this.userName = userName;
		this.money = money;
	}

	public String getCashbackNo() {
		return cashbackNo;
	}

	public void setCashbackNo(String cashbackNo) {
		this.cashbackNo = cashbackNo;
	}

	public int getCashbackPoint() {
		return cashbackPoint;
	}

	public void setCashbackPoint(int cashbackPoint) {
		this.cashbackPoint = cashbackPoint;
	}

	public int getRate() {
		return Rate;
	}

	public void setRate(int rate) {
		Rate = rate;
	}

	public Date getCashbackDate() {
		return cashbackDate;
	}

	public void setCashbackDate(Date cashbackDate) {
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "CashBack [cashbackNo=" + cashbackNo + ", cashbackPoint=" + cashbackPoint + ", Rate=" + Rate
				+ ", cashbackDate=" + cashbackDate + ", userNo=" + userNo + ", userName=" + userName + ", money="
				+ money + "]";
	}
	
	
}
