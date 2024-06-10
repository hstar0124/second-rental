package com.kh.forest.order.model.vo;

public class OrderHistory {
	private String orderHistoryNo;
	private String status;
	private String orderDate;
	private String orderCode;
	
	public OrderHistory() {}

	public OrderHistory(String orderHistoryNo, String status, String orderDate, String orderCode) {
		super();
		this.orderHistoryNo = orderHistoryNo;
		this.status = status;
		this.orderDate = orderDate;
		this.orderCode = orderCode;
	}

	public String getOrderHistoryNo() {
		return orderHistoryNo;
	}

	public void setOrderHistoryNo(String orderHistoryNo) {
		this.orderHistoryNo = orderHistoryNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Override
	public String toString() {
		return "OrderHistory [orderHistoryNo=" + orderHistoryNo + ", status=" + status + ", orderDate=" + orderDate
				+ ", orderCode=" + orderCode + "]";
	}
	
	
}
