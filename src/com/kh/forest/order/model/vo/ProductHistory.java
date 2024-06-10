package com.kh.forest.order.model.vo;

import java.sql.Date;

public class ProductHistory {
	private String proHistoryNo;
	private String productNo;
	private String productStatus;
	private Date proHistoryDate;
	
	public ProductHistory() {}

	public ProductHistory(String proHistoryNo, String productNo, String productStatus, Date proHistoryDate) {
		super();
		this.proHistoryNo = proHistoryNo;
		this.productNo = productNo;
		this.productStatus = productStatus;
		this.proHistoryDate = proHistoryDate;
	}

	public String getProHistoryNo() {
		return proHistoryNo;
	}

	public void setProHistoryNo(String proHistoryNo) {
		this.proHistoryNo = proHistoryNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public Date getProHistoryDate() {
		return proHistoryDate;
	}

	public void setProHistoryDate(Date proHistoryDate) {
		this.proHistoryDate = proHistoryDate;
	}

	@Override
	public String toString() {
		return "ProductHistory [proHistoryNo=" + proHistoryNo + ", productNo=" + productNo + ", productStatus="
				+ productStatus + ", proHistoryDate=" + proHistoryDate + "]";
	}
	
	
}
