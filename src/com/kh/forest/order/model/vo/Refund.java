package com.kh.forest.order.model.vo;

import java.sql.Date;

public class Refund {
	private String refundNo;
	private String orderCode;
	private Date refundDate;
	private String refundReason;
	private int rate;
	private String refundHistoryNo;
	private String processDate;
	private String status;
	private String userName;
	private String userNo;
	private String userId;
	private Date orderDate;
	private String productName;
	private int price;
	private String orderNo;
	private String productNo;
	private String rentalNo;
	
	public Refund() {}

	public Refund(String refundNo, String orderCode, Date refundDate, String refundReason, int rate,
			String refundHistoryNo, String processDate, String status, String userName, String userNo, String userId,
			Date orderDate, String productName, int price, String orderNo, String productNo, String rentalNo) {
		super();
		this.refundNo = refundNo;
		this.orderCode = orderCode;
		this.refundDate = refundDate;
		this.refundReason = refundReason;
		this.rate = rate;
		this.refundHistoryNo = refundHistoryNo;
		this.processDate = processDate;
		this.status = status;
		this.userName = userName;
		this.userNo = userNo;
		this.userId = userId;
		this.orderDate = orderDate;
		this.productName = productName;
		this.price = price;
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.rentalNo = rentalNo;
	}

	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getRefundHistoryNo() {
		return refundHistoryNo;
	}

	public void setRefundHistoryNo(String refundHistoryNo) {
		this.refundHistoryNo = refundHistoryNo;
	}

	public String getProcessDate() {
		return processDate;
	}

	public void setProcessDate(String processDate) {
		this.processDate = processDate;
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

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
	}

	@Override
	public String toString() {
		return "Refund [refundNo=" + refundNo + ", orderCode=" + orderCode + ", refundDate=" + refundDate
				+ ", refundReason=" + refundReason + ", rate=" + rate + ", refundHistoryNo=" + refundHistoryNo
				+ ", processDate=" + processDate + ", status=" + status + ", userName=" + userName + ", userNo="
				+ userNo + ", userId=" + userId + ", orderDate=" + orderDate + ", productName=" + productName
				+ ", price=" + price + ", orderNo=" + orderNo + ", productNo=" + productNo + ", rentalNo=" + rentalNo
				+ "]";
	}

	
	
}
