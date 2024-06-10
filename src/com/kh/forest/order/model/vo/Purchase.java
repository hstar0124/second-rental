package com.kh.forest.order.model.vo;

import java.sql.Date;

public class Purchase {
	private String orderCode;	//주문신청코드
	private String orderNo;		//주문번호
	private String rentalNo;	//렌탈번호
	private String userNo;		//회원번호
	private int price;			//가격
	private int usePoint;		//사용할 포인트
	private String rentalMonth;	//렌탈기ㅏㄴ
	private Date orderDate;		//주문일자
	private String productNo;	//등록상품번호
	private int deliveryPrice;
	private int payPrice;
	private String recipient;
	private String buyerAddress;
	private String buyerPhone;
	private String productName;
	private String attachment;
	
	public Purchase() {}

	public Purchase(String orderCode, String orderNo, String rentalNo, String userNo, int price, int usePoint,
			String rentalMonth, Date orderDate, String productNo, int deliveryPrice, int payPrice, String recipient,
			String buyerAddress, String buyerPhone, String productName, String attachment) {
		super();
		this.orderCode = orderCode;
		this.orderNo = orderNo;
		this.rentalNo = rentalNo;
		this.userNo = userNo;
		this.price = price;
		this.usePoint = usePoint;
		this.rentalMonth = rentalMonth;
		this.orderDate = orderDate;
		this.productNo = productNo;
		this.deliveryPrice = deliveryPrice;
		this.payPrice = payPrice;
		this.recipient = recipient;
		this.buyerAddress = buyerAddress;
		this.buyerPhone = buyerPhone;
		this.productName = productName;
		this.attachment = attachment;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
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

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public String getRentalMonth() {
		return rentalMonth;
	}

	public void setRentalMonth(String rentalMonth) {
		this.rentalMonth = rentalMonth;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "Purchase [orderCode=" + orderCode + ", orderNo=" + orderNo + ", rentalNo=" + rentalNo + ", userNo="
				+ userNo + ", price=" + price + ", usePoint=" + usePoint + ", rentalMonth=" + rentalMonth
				+ ", orderDate=" + orderDate + ", productNo=" + productNo + ", deliveryPrice=" + deliveryPrice
				+ ", payPrice=" + payPrice + ", recipient=" + recipient + ", buyerAddress=" + buyerAddress
				+ ", buyerPhone=" + buyerPhone + ", productName=" + productName + ", attachment=" + attachment + "]";
	}

	
	
}
