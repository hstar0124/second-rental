package com.kh.forest.review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review_Attachment implements Serializable {
	private String reviewAttachmentNo;
	private String originName;
	private String changeName;
	private String savePath;
	private Date enrollDate;
	private int reviewLevel;
	private String rBoardNo;
	
	public Review_Attachment() {}

	public Review_Attachment(String reviewAttachmentNo, String originName, String changeName, String savePath,
			Date enrollDate, int reviewLevel, String rBoardNo) {
		super();
		this.reviewAttachmentNo = reviewAttachmentNo;
		this.originName = originName;
		this.changeName = changeName;
		this.savePath = savePath;
		this.enrollDate = enrollDate;
		this.reviewLevel = reviewLevel;
		this.rBoardNo = rBoardNo;
	}

	public String getReviewAttachmentNo() {
		return reviewAttachmentNo;
	}

	public String getOriginName() {
		return originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public String getSavePath() {
		return savePath;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public int getReviewLevel() {
		return reviewLevel;
	}

	public String getrBoardNo() {
		return rBoardNo;
	}

	public void setReviewAttachmentNo(String reviewAttachmentNo) {
		this.reviewAttachmentNo = reviewAttachmentNo;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public void setReviewLevel(int reviewLevel) {
		this.reviewLevel = reviewLevel;
	}

	public void setrBoardNo(String rBoardNo) {
		this.rBoardNo = rBoardNo;
	}

	@Override
	public String toString() {
		return "Review_Attachment [reviewAttachmentNo=" + reviewAttachmentNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", savePath=" + savePath + ", enrollDate=" + enrollDate
				+ ", reviewLevel=" + reviewLevel + ", rBoardNo=" + rBoardNo + "]";
	}
	
	
}
