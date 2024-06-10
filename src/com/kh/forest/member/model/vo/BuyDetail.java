package com.kh.forest.member.model.vo;

public class BuyDetail {
	private String buyNo;
	private String buyProductName;
	private String userNo;
	private String userName;
	private String grade;
	private String price;
	private String empId;
	private String day;
	private String buyStatus;
	
	public BuyDetail() {}

	public BuyDetail(String buyNo, String buyProductName, String userNo, String userName, String grade, String price,
			String empId, String day, String buyStatus) {
		super();
		this.buyNo = buyNo;
		this.buyProductName = buyProductName;
		this.userNo = userNo;
		this.userName = userName;
		this.grade = grade;
		this.price = price;
		this.empId = empId;
		this.day = day;
		this.buyStatus = buyStatus;
	}

	public String getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(String buyNo) {
		this.buyNo = buyNo;
	}

	public String getBuyProductName() {
		return buyProductName;
	}

	public void setBuyProductName(String buyProductName) {
		this.buyProductName = buyProductName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getBuyStatus() {
		return buyStatus;
	}

	public void setBuyStatus(String buyStatus) {
		this.buyStatus = buyStatus;
	}

	@Override
	public String toString() {
		return "BuyDetail [buyNo=" + buyNo + ", buyProductName=" + buyProductName + ", userNo=" + userNo + ", userName="
				+ userName + ", grade=" + grade + ", price=" + price + ", empId=" + empId + ", day=" + day
				+ ", buyStatus=" + buyStatus + "]";
	}
	
	
	
}
