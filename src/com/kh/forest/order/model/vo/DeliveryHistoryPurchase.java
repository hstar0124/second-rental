package com.kh.forest.order.model.vo;

import java.sql.Date;

public class DeliveryHistoryPurchase {
	private String deliveryHistoryNo;
	private String waybillNo;
	private String orderCode;
	private String status;
	private Date deliveryDate;
	private String carrierNo;
	private String recipient;
	private String address;
	
	public DeliveryHistoryPurchase() {}

	public DeliveryHistoryPurchase(String deliveryHistoryNo, String waybillNo, String orderCode, String status,
			Date deliveryDate, String carrierNo, String recipient, String address) {
		super();
		this.deliveryHistoryNo = deliveryHistoryNo;
		this.waybillNo = waybillNo;
		this.orderCode = orderCode;
		this.status = status;
		this.deliveryDate = deliveryDate;
		this.carrierNo = carrierNo;
		this.recipient = recipient;
		this.address = address;
	}

	public String getDeliveryHistoryNo() {
		return deliveryHistoryNo;
	}

	public void setDeliveryHistoryNo(String deliveryHistoryNo) {
		this.deliveryHistoryNo = deliveryHistoryNo;
	}

	public String getWaybillNo() {
		return waybillNo;
	}

	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCarrierNo() {
		return carrierNo;
	}

	public void setCarrierNo(String carrierNo) {
		this.carrierNo = carrierNo;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DeliveryHistoryPurchase [deliveryHistoryNo=" + deliveryHistoryNo + ", waybillNo=" + waybillNo
				+ ", orderCode=" + orderCode + ", status=" + status + ", deliveryDate=" + deliveryDate + ", carrierNo="
				+ carrierNo + ", recipient=" + recipient + ", address=" + address + "]";
	}

	
	
}
