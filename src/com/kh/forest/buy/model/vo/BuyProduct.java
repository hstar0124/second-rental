package com.kh.forest.buy.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BuyProduct implements Serializable{
	private String buyProductNo;
	private String buyProductName;
	private String manufacturerNo;
	private String manufacturerName;
	private String categoryNo;
	private String categoryName;
	
	private String buyNo;
	private String userNo;
	private Date requestDate;
	private String safeKey;
	private String grade;
	private String empNo;
	private int buyPrice;
	private String buyStatus;
	private String userName;

	public BuyProduct () {}

	public BuyProduct(String buyProductNo, String buyProductName, String manufacturerNo, String manufacturerName,
			String categoryNo, String categoryName, String buyNo, String userNo, Date requestDate, String safeKey,
			String grade, String empNo, int buyPrice, String buyStatus, String userName) {
		super();
		this.buyProductNo = buyProductNo;
		this.buyProductName = buyProductName;
		this.manufacturerNo = manufacturerNo;
		this.manufacturerName = manufacturerName;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.buyNo = buyNo;
		this.userNo = userNo;
		this.requestDate = requestDate;
		this.safeKey = safeKey;
		this.grade = grade;
		this.empNo = empNo;
		this.buyPrice = buyPrice;
		this.buyStatus = buyStatus;
		this.userName = userName;
	}

	public String getBuyProductNo() {
		return buyProductNo;
	}

	public void setBuyProductNo(String buyProductNo) {
		this.buyProductNo = buyProductNo;
	}

	public String getBuyProductName() {
		return buyProductName;
	}

	public void setBuyProductName(String buyProductName) {
		this.buyProductName = buyProductName;
	}

	public String getManufacturerNo() {
		return manufacturerNo;
	}

	public void setManufacturerNo(String manufacturerNo) {
		this.manufacturerNo = manufacturerNo;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
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

	public String getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(String buyNo) {
		this.buyNo = buyNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getSafeKey() {
		return safeKey;
	}

	public void setSafeKey(String safeKey) {
		this.safeKey = safeKey;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getBuyStatus() {
		return buyStatus;
	}

	public void setBuyStatus(String buyStatus) {
		this.buyStatus = buyStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "BuyProduct [buyProductNo=" + buyProductNo + ", buyProductName=" + buyProductName + ", manufacturerNo="
				+ manufacturerNo + ", manufacturerName=" + manufacturerName + ", categoryNo=" + categoryNo
				+ ", categoryName=" + categoryName + ", buyNo=" + buyNo + ", userNo=" + userNo + ", requestDate="
				+ requestDate + ", safeKey=" + safeKey + ", grade=" + grade + ", empNo=" + empNo + ", buyPrice="
				+ buyPrice + ", buyStatus=" + buyStatus + ", userName=" + userName + "]";
	}
	
	
}
