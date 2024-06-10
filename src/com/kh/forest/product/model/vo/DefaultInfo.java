package com.kh.forest.product.model.vo;

import java.io.Serializable;

public class DefaultInfo implements Serializable{
	private String noticeInfo;
	private String deliveryInfo;
	
	public DefaultInfo() {
		
	}

	public DefaultInfo(String noticeInfo, String deliveryInfo) {
		super();
		this.noticeInfo = noticeInfo;
		this.deliveryInfo = deliveryInfo;
	}

	public String getNoticeInfo() {
		return noticeInfo;
	}

	public void setNoticeInfo(String noticeInfo) {
		this.noticeInfo = noticeInfo;
	}

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(String deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	
	

}
