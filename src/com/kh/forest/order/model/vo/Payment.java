package com.kh.forest.order.model.vo;

import java.sql.Date;

public class Payment {
	private String paymentNo;
	private String orderNo;
	private String userNo;
	private int price;
	private String confirmNo;
	private String enrollDate;
	private int deliveryPrice;
	
	public Payment() {}

	public Payment(String paymentNo, String orderNo, String userNo, int price, String confirmNo, String enrollDate,
			int deliveryPrice) {
		super();
		this.paymentNo = paymentNo;
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.price = price;
		this.confirmNo = confirmNo;
		this.enrollDate = enrollDate;
		this.deliveryPrice = deliveryPrice;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getConfirmNo() {
		return confirmNo;
	}

	public void setConfirmNo(String confirmNo) {
		this.confirmNo = confirmNo;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	@Override
	public String toString() {
		return "Payment [paymentNo=" + paymentNo + ", orderNo=" + orderNo + ", userNo=" + userNo + ", price=" + price
				+ ", confirmNo=" + confirmNo + ", enrollDate=" + enrollDate + ", deliveryPrice=" + deliveryPrice + "]";
	}

	
	
}
