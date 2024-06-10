package com.kh.forest.point.model.vo;

import java.sql.Date;

public class Point {
	private String pointNo;
	private int point;
	private Date pointDate;
	private String detailDate;
	private String userName;
	private String userNo;
	private String useNo;
	private String status;
	
	public Point() {}

	public Point(String pointNo, int point, Date pointDate, String detailDate, String userName, String userNo,
			String useNo, String status) {
		super();
		this.pointNo = pointNo;
		this.point = point;
		this.pointDate = pointDate;
		this.detailDate = detailDate;
		this.userName = userName;
		this.userNo = userNo;
		this.useNo = useNo;
		this.status = status;
	}

	public String getPointNo() {
		return pointNo;
	}

	public void setPointNo(String pointNo) {
		this.pointNo = pointNo;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getPointDate() {
		return pointDate;
	}

	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}

	public String getDetailDate() {
		return detailDate;
	}

	public void setDetailDate(String detailDate) {
		this.detailDate = detailDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUseNo() {
		return useNo;
	}

	public void setUseNo(String useNo) {
		this.useNo = useNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Point [pointNo=" + pointNo + ", point=" + point + ", pointDate=" + pointDate + ", detailDate="
				+ detailDate + ", userName=" + userName + ", userNo=" + userNo + ", useNo=" + useNo + ", status="
				+ status + "]";
	}

	
	
	
	
}
