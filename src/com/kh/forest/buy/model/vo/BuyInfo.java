package com.kh.forest.buy.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BuyInfo implements Serializable{
	private String buyNo;
	private String buyProductNo;
	private String userNo;
	private Date requestDate; //매입신청일자
	private Date buyDate; //매입 처리일자
	private String safeKey;
	private String grade;
	private String empNo;
	private int buyPrice;
	private String buyStatus; //매입신청상태
	
	private String buyProductName;
	private String userName;
	private String userId;

	private String buyPointNo; //포인트이력관리 넘버
	private int changePoint; //변경 포인트
	
	private String reason; //판단사유
	
	private String questionNo; //문항번호
	private String exampleNo;  //보기번호
	
	private String questionContent; //문항내용
	private String exampleContent;  //보기내용
	
	private String empName;
	
	private String buyAddress; //매입시 반송주소
	private String waybillNo; //매입 운송장번호
	private String carrier;
	
	private String buyWaybillNo; //반송운송장번호
	private String buyCarrier; //반송 택배사
	private String deliveryStatus; //배송상태
	private String division; //반송인지 인수인지
	
	public BuyInfo() {}


	public BuyInfo(String buyNo, String buyProductNo, String userNo, Date requestDate, Date buyDate, String safeKey,
			String grade, String empNo, int buyPrice, String buyStatus, String buyProductName, String userName,
			String userId, String buyPointNo, int changePoint, String reason, String questionNo, String exampleNo,
			String questionContent, String exampleContent, String empName, String buyAddress, String waybillNo,
			String carrier, String buyWaybillNo, String buyCarrier, String deliveryStatus, String division) {
		super();
		this.buyNo = buyNo;
		this.buyProductNo = buyProductNo;
		this.userNo = userNo;
		this.requestDate = requestDate;
		this.buyDate = buyDate;
		this.safeKey = safeKey;
		this.grade = grade;
		this.empNo = empNo;
		this.buyPrice = buyPrice;
		this.buyStatus = buyStatus;
		this.buyProductName = buyProductName;
		this.userName = userName;
		this.userId = userId;
		this.buyPointNo = buyPointNo;
		this.changePoint = changePoint;
		this.reason = reason;
		this.questionNo = questionNo;
		this.exampleNo = exampleNo;
		this.questionContent = questionContent;
		this.exampleContent = exampleContent;
		this.empName = empName;
		this.buyAddress = buyAddress;
		this.waybillNo = waybillNo;
		this.carrier = carrier;
		this.buyWaybillNo = buyWaybillNo;
		this.buyCarrier = buyCarrier;
		this.deliveryStatus = deliveryStatus;
		this.division = division;
		
	}


	public String getBuyNo() {
		return buyNo;
	}


	public void setBuyNo(String buyNo) {
		this.buyNo = buyNo;
	}


	public String getBuyProductNo() {
		return buyProductNo;
	}


	public void setBuyProductNo(String buyProductNo) {
		this.buyProductNo = buyProductNo;
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


	public Date getBuyDate() {
		return buyDate;
	}


	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
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


	public String getBuyProductName() {
		return buyProductName;
	}


	public void setBuyProductName(String buyProductName) {
		this.buyProductName = buyProductName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getBuyPointNo() {
		return buyPointNo;
	}


	public void setBuyPointNo(String buyPointNo) {
		this.buyPointNo = buyPointNo;
	}


	public int getChangePoint() {
		return changePoint;
	}


	public void setChangePoint(int changePoint) {
		this.changePoint = changePoint;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getQuestionNo() {
		return questionNo;
	}


	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}


	public String getExampleNo() {
		return exampleNo;
	}


	public void setExampleNo(String exampleNo) {
		this.exampleNo = exampleNo;
	}


	public String getQuestionContent() {
		return questionContent;
	}


	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}


	public String getExampleContent() {
		return exampleContent;
	}


	public void setExampleContent(String exampleContent) {
		this.exampleContent = exampleContent;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getBuyAddress() {
		return buyAddress;
	}
	
	public void setBuyAddress(String buyAddress) {
		this.buyAddress = buyAddress;
	}
	
	public String getWaybillNo() {
		return waybillNo;
	}
	
	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}
	
	public String getCarrier() {
		return carrier;
	}
	
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	public String getBuyWaybillNo() {
		return buyWaybillNo;
	}
	
	public void setBuyWaybillNo(String buyWaybillNo) {
		this.buyWaybillNo = buyWaybillNo;
	}
	
	public String getBuyCarrier() {
		return buyCarrier;
	}
	
	public void setBuyCarrier(String buyCarrier) {
		this.buyCarrier = buyCarrier;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}


	@Override
	public String toString() {
		return "BuyInfo [buyNo=" + buyNo + ", buyProductNo=" + buyProductNo + ", userNo=" + userNo + ", requestDate="
				+ requestDate + ", buyDate=" + buyDate + ", safeKey=" + safeKey + ", grade=" + grade + ", empNo="
				+ empNo + ", buyPrice=" + buyPrice + ", buyStatus=" + buyStatus + ", buyProductName=" + buyProductName
				+ ", userName=" + userName + ", userId=" + userId + ", buyPointNo=" + buyPointNo + ", changePoint="
				+ changePoint + ", reason=" + reason + ", questionNo=" + questionNo + ", exampleNo=" + exampleNo
				+ ", questionContent=" + questionContent + ", exampleContent=" + exampleContent + ", empName=" + empName
				+ ", buyAddress=" + buyAddress + ", waybillNo=" + waybillNo + ", carrier=" + carrier + ", buyWaybillNo="
				+ buyWaybillNo + ", buyCarrier=" + buyCarrier + ", deliveryStatus=" + deliveryStatus + ", division="
				+ division + "]";
	}

	
	
}
