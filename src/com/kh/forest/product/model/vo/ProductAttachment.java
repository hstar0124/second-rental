package com.kh.forest.product.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ProductAttachment implements Serializable{
	private String productAttatchmentNo;
	private String originName;
	private String changeName;
	private String savePath;
	private Date enrollDate;
	private int productLevel;
	private String productNo;
	private String division;
	
	private String productName;
	private String categoryNo;
	private String categoryName;
	private String buyProductName;
	
	
	
	public ProductAttachment() {
		// TODO Auto-generated constructor stub
	}



	public ProductAttachment(String productAttatchmentNo, String originName, String changeName, String savePath,
			Date enrollDate, int productLevel, String productNo, String division, String productName, String categoryNo,
			String categoryName, String buyProductName) {
		super();
		this.productAttatchmentNo = productAttatchmentNo;
		this.originName = originName;
		this.changeName = changeName;
		this.savePath = savePath;
		this.enrollDate = enrollDate;
		this.productLevel = productLevel;
		this.productNo = productNo;
		this.division = division;
		this.productName = productName;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.buyProductName = buyProductName;
	}



	public String getProductAttatchmentNo() {
		return productAttatchmentNo;
	}



	public void setProductAttatchmentNo(String productAttatchmentNo) {
		this.productAttatchmentNo = productAttatchmentNo;
	}



	public String getOriginName() {
		return originName;
	}



	public void setOriginName(String originName) {
		this.originName = originName;
	}



	public String getChangeName() {
		return changeName;
	}



	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}



	public String getSavePath() {
		return savePath;
	}



	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}



	public Date getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}



	public int getProductLevel() {
		return productLevel;
	}



	public void setProductLevel(int productLevel) {
		this.productLevel = productLevel;
	}



	public String getProductNo() {
		return productNo;
	}



	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}



	public String getDivision() {
		return division;
	}



	public void setDivision(String division) {
		this.division = division;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getCategoryNo() {
		return categoryNo;
	}



	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getBuyProductName() {
		return buyProductName;
	}



	public void setBuyProductName(String buyProductName) {
		this.buyProductName = buyProductName;
	}



	@Override
	public String toString() {
		return "ProductAttachment [productAttatchmentNo=" + productAttatchmentNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", savePath=" + savePath + ", enrollDate=" + enrollDate
				+ ", productLevel=" + productLevel + ", productNo=" + productNo + ", division=" + division
				+ ", productName=" + productName + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName
				+ ", buyProductName=" + buyProductName + "]";
	}



	
	
}