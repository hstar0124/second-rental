package com.kh.forest.product.model.vo;

public class A_WishList {
	
	/*USER_NO	VARCHAR2(30 BYTE)
	PRODUCT_NO	VARCHAR2(30 BYTE)*/
	private String userNo;
	private String productNo;
	
	public A_WishList() {}

	public A_WishList(String userNo, String productNo) {
		super();
		this.userNo = userNo;
		this.productNo = productNo;
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

	@Override
	public String toString() {
		return "A_WishList [userNo=" + userNo + ", productNo=" + productNo + "]";
	}
	
	
}
