package com.kh.forest.product.model.vo;

public class A_MyWishlist {

	/*
	W.USER_NO				VARCHAR
	P.PRODUCT_NO			VARCHER
	M.MANUFACTURER_NAME		VARCHAR
	P.PRODUCT_NAME			VARCHAR
	A.CHANGE_NAME			VARCHAR
	W.USER_NO, P.PRODUCT_NO, M.MANUFACTURER_NAME, P.PRODUCT_NAME, A.CHANGE_NAME
	*/
	private String userNo;
	private String productNo;
	private String manufacturerName;
	private String productName;
	private String changName;
	
	public A_MyWishlist() {}

	public A_MyWishlist(String userNo, String productNo, String manufacturerName, String productName,
			String changName) {
		super();
		this.userNo = userNo;
		this.productNo = productNo;
		this.manufacturerName = manufacturerName;
		this.productName = productName;
		this.changName = changName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getChangName() {
		return changName;
	}

	public void setChangName(String changName) {
		this.changName = changName;
	}

	@Override
	public String toString() {
		return "A_MyWishlist [userNo=" + userNo + ", productNo=" + productNo + ", manufacturerName=" + manufacturerName
				+ ", productName=" + productName + ", changName=" + changName + "]";
	}
	
}
