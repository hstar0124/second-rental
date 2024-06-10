package com.kh.forest.order.model.vo;

import java.sql.Date;

public class OrderStatus {
	private String userId;
	private String userName;
	private String orderCode;
	private String orderNo;
	private String productNo;
	private String productName;
	private Date orderDate;
	private int price;
	private String status;
	private String changeName;
	private Date historyDate;
	private int betweenDate;
	
	public OrderStatus() {}

	public OrderStatus(String userId, String userName, String orderCode, String orderNo, String productNo,
			String productName, Date orderDate, int price, String status, String changeName, Date historyDate,
			int betweenDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.orderCode = orderCode;
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.productName = productName;
		this.orderDate = orderDate;
		this.price = price;
		this.status = status;
		this.changeName = changeName;
		this.historyDate = historyDate;
		this.betweenDate = betweenDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public Date getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}

	public int getBetweenDate() {
		return betweenDate;
	}

	public void setBetweenDate(int betweenDate) {
		this.betweenDate = betweenDate;
	}

	@Override
	public String toString() {
		return "OrderStatus [userId=" + userId + ", userName=" + userName + ", orderCode=" + orderCode + ", orderNo="
				+ orderNo + ", productNo=" + productNo + ", productName=" + productName + ", orderDate=" + orderDate
				+ ", price=" + price + ", status=" + status + ", changeName=" + changeName + ", historyDate="
				+ historyDate + ", betweenDate=" + betweenDate + "]";
	}

	
	
}
