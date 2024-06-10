package com.kh.forest.buy.model.vo;

import java.sql.Date;

public class BuyAttachment {
	private String buyAttahmentNo;
	private String originName;
	private String changeName;
	private String filePath;
	private Date enrollDate;
	private int productLevel;
	
	
	public BuyAttachment() {}


	public BuyAttachment(String buyAttahmentNo, String originName, String changeName, String filePath, Date enrollDate,
			int productLevel) {
		super();
		this.buyAttahmentNo = buyAttahmentNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.enrollDate = enrollDate;
		this.productLevel = productLevel;
	}


	public String getBuyAttahmentNo() {
		return buyAttahmentNo;
	}


	public void setBuyAttahmentNo(String buyAttahmentNo) {
		this.buyAttahmentNo = buyAttahmentNo;
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


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
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


	@Override
	public String toString() {
		return "BuyAttachment [buyAttahmentNo=" + buyAttahmentNo + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", enrollDate=" + enrollDate + ", productLevel="
				+ productLevel + "]";
	}
	
	
}
