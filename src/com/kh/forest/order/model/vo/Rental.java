package com.kh.forest.order.model.vo;

import java.sql.Date;

public class Rental {
	private String rentalNo;
	private String productNo;
	private String productName;
	private String userNo;
	private Date expiryDate;
	private Date startDate;
	private String restTime;
	private int rentalPrice;
	private String status;
	private String userName;
	private String userId;
	private String carrierName;
	private String deliveryDate;
	private String deliveryStatus;
	private String waybillNo;
	private String takeOver;
	private String month;
	private String attachment;
	
	public Rental() {}

	public Rental(String rentalNo, String productNo, String productName, String userNo, Date expiryDate, Date startDate,
			String restTime, int rentalPrice, String status, String userName, String userId, String carrierName,
			String deliveryDate, String deliveryStatus, String waybillNo, String takeOver, String month,
			String attachment) {
		super();
		this.rentalNo = rentalNo;
		this.productNo = productNo;
		this.productName = productName;
		this.userNo = userNo;
		this.expiryDate = expiryDate;
		this.startDate = startDate;
		this.restTime = restTime;
		this.rentalPrice = rentalPrice;
		this.status = status;
		this.userName = userName;
		this.userId = userId;
		this.carrierName = carrierName;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.waybillNo = waybillNo;
		this.takeOver = takeOver;
		this.month = month;
		this.attachment = attachment;
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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getRestTime() {
		return restTime;
	}

	public void setRestTime(String restTime) {
		this.restTime = restTime;
	}

	public int getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(int rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getWaybillNo() {
		return waybillNo;
	}

	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}

	public String getTakeOver() {
		return takeOver;
	}

	public void setTakeOver(String takeOver) {
		this.takeOver = takeOver;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "Rental [rentalNo=" + rentalNo + ", productNo=" + productNo + ", productName=" + productName
				+ ", userNo=" + userNo + ", expiryDate=" + expiryDate + ", startDate=" + startDate + ", restTime="
				+ restTime + ", rentalPrice=" + rentalPrice + ", status=" + status + ", userName=" + userName
				+ ", userId=" + userId + ", carrierName=" + carrierName + ", deliveryDate=" + deliveryDate
				+ ", deliveryStatus=" + deliveryStatus + ", waybillNo=" + waybillNo + ", takeOver=" + takeOver
				+ ", month=" + month + ", attachment=" + attachment + "]";
	}


	
}
