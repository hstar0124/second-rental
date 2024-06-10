package com.kh.forest.order.model.vo;

import java.sql.Date;

public class RentalHistory {
	private String rentalNo;
	private String status;
	private Date rentalHistoryDate;
	
	public RentalHistory() {}

	public RentalHistory(String rentalNo, String status, Date rentalHistoryDate) {
		super();
		this.rentalNo = rentalNo;
		this.status = status;
		this.rentalHistoryDate = rentalHistoryDate;
	}

	public String getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRentalHistoryDate() {
		return rentalHistoryDate;
	}

	public void setRentalHistoryDate(Date rentalHistoryDate) {
		this.rentalHistoryDate = rentalHistoryDate;
	}

	@Override
	public String toString() {
		return "RentalHistory [rentalNo=" + rentalNo + ", status=" + status + ", rentalHistoryDate=" + rentalHistoryDate
				+ "]";
	}
	
	
}
