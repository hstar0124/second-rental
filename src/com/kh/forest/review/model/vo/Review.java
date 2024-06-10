package com.kh.forest.review.model.vo;

import java.sql.Date;

public class Review implements java.io.Serializable {
	
	private String rBoardNo;	//리뷰게시판 번호
	private String rTitle;		//리뷰게시판 제목
	private String rWriter;		//작성자
	private String rContent;	//내용
	private String productNo;	//(null)
	private int pGrade;			//(null)
	private Date rEnrollDate;	//등록일자
	private Date rModifyDate;	//변경일자
	private String rStatus;		//삭제유무
	private int rCount;			//조회수
	private int rentalNo;		//렌탈번호
	private String userId;		//유저ID
	private String productName;	//제품명

	public Review() {}

	public Review(String rBoardNo, String rTitle, String rWriter, String rContent, String productNo, int pGrade,
			Date rEnrollDate, Date rModifyDate, String rStatus, int rCount, int rentalNo, String userId, String productName) {
		super();
		this.rBoardNo = rBoardNo;
		this.rTitle = rTitle;
		this.rWriter = rWriter;
		this.rContent = rContent;
		this.productNo = productNo;
		this.pGrade = pGrade;
		this.rEnrollDate = rEnrollDate;
		this.rModifyDate = rModifyDate;
		this.rStatus = rStatus;
		this.rCount = rCount;
		this.rentalNo = rentalNo;
		this.userId = userId;
		this.productName = productName;
	}

	public String getrBoardNo() {
		return rBoardNo;
	}

	public void setrBoardNo(String rBoardNo) {
		this.rBoardNo = rBoardNo;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public int getpGrade() {
		return pGrade;
	}

	public void setpGrade(int pGrade) {
		this.pGrade = pGrade;
	}

	public Date getrEnrollDate() {
		return rEnrollDate;
	}

	public void setrEnrollDate(Date rEnrollDate) {
		this.rEnrollDate = rEnrollDate;
	}

	public Date getrModifyDate() {
		return rModifyDate;
	}

	public void setrModifyDate(Date rModifyDate) {
		this.rModifyDate = rModifyDate;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public int getrCount() {
		return rCount;
	}

	public void setrCount(int rCount) {
		this.rCount = rCount;
	}

	public int getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(int rentalNo) {
		this.rentalNo = rentalNo;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName=productName;
	}
	
	@Override
	public String toString() {
		return "Review [rBoardNo=" + rBoardNo + ", rTitle=" + rTitle + ", rWriter=" + rWriter + ", rContent=" + rContent
				+ ", productNo=" + productNo + ", pGrade=" + pGrade + ", rEnrollDate=" + rEnrollDate + ", rModifyDate="
				+ rModifyDate + ", rStatus=" + rStatus + ", rCount=" + rCount + ", rentalNo=" + rentalNo + ", userId=" 
				+ userId + ", productName=" + productName +"]";
	}
	
}