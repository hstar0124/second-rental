package com.kh.forest.product.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Rental implements Serializable{
	private String productNo;
	private String productName;
	private String changeName;
	private String price;
	private String rentalMonth;
	private Date startDate;
	private Date expiryDate;
	private String rentalStatus;
	private String orderStatus;
	private String recipient;
	private String phone;
	private String address;
	private String orderNo;
	private String orderCode;
	private String rentalNo;
	private String refundStatus;
	private String userNo;
	private String userName;
	private String rTitle;
	
	public Rental() {}

	public Rental(String productNo, String productName, String changeName, String price, String rentalMonth,
			Date startDate, Date expiryDate, String rentalStatus, String orderStatus, String recipient, String phone,
			String address, String orderNo, String orderCode, String rentalNo, String refundStatus, String userNo,
			String userName, String rTitle) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.changeName = changeName;
		this.price = price;
		this.rentalMonth = rentalMonth;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.rentalStatus = rentalStatus;
		this.orderStatus = orderStatus;
		this.recipient = recipient;
		this.phone = phone;
		this.address = address;
		this.orderNo = orderNo;
		this.orderCode = orderCode;
		this.rentalNo = rentalNo;
		this.refundStatus = refundStatus;
		this.userNo = userNo;
		this.userName = userName;
		this.rTitle = rTitle;
	}

	@Override
	public String toString() {
		return "Rental [productNo=" + productNo + ", productName=" + productName + ", changeName=" + changeName
				+ ", price=" + price + ", rentalMonth=" + rentalMonth + ", startDate=" + startDate + ", expiryDate="
				+ expiryDate + ", rentalStatus=" + rentalStatus + ", orderStatus=" + orderStatus + ", recipient="
				+ recipient + ", phone=" + phone + ", address=" + address + ", orderNo=" + orderNo + ", orderCode="
				+ orderCode + ", rentalNo=" + rentalNo + ", refundStatus=" + refundStatus + ", userNo=" + userNo
				+ ", userName=" + userName + ", rTitle=" + rTitle + "]";
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

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRentalMonth() {
		return rentalMonth;
	}

	public void setRentalMonth(String rentalMonth) {
		this.rentalMonth = rentalMonth;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
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

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}



	
	

}
