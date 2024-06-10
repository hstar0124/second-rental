package com.kh.forest.product.model.vo;

public class A_Basket {
	
	private String rentalNo;
	private String productNo;
	private String productName;
	private String userNo;
	private String expiryDate;
	private String startDate;
	private String rentalPrice;
	private String takeOver;
	private String cngName;
	private String month;
	
	public A_Basket() {}

	public A_Basket(String rentalNo, String productNo, String productName, String userNo, String expiryDate,
			String startDate, String rentalPrice, String takeOver, String cngName, String month) {
		super();
		this.rentalNo = rentalNo;
		this.productNo = productNo;
		this.productName = productName;
		this.userNo = userNo;
		this.expiryDate = expiryDate;
		this.startDate = startDate;
		this.rentalPrice = rentalPrice;
		this.takeOver = takeOver;
		this.cngName = cngName;
		this.month = month;
	}

	public String getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(String rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public String getTakeOver() {
		return takeOver;
	}

	public void setTakeOver(String takeOver) {
		this.takeOver = takeOver;
	}

	public String getCngName() {
		return cngName;
	}

	public void setCngName(String cngName) {
		this.cngName = cngName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "A_Basket [rentalNo=" + rentalNo + ", productNo=" + productNo + ", productName=" + productName
				+ ", userNo=" + userNo + ", expiryDate=" + expiryDate + ", startDate=" + startDate + ", rentalPrice="
				+ rentalPrice + ", takeOver=" + takeOver + ", cngName=" + cngName + ", month=" + month + "]";
	}

	
}
