package com.kh.forest.notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable {
	
	private String nWriter;
	private String nTitle;
	private String nContent;
	private String nBoardNo;
	private String nStatus;
	private Date nModifyDate;
	private Date nEnrollDate;
	private int nCount;
	
	public Notice() {}

	public Notice(String nWriter, String nTitle, String nContent, String nBoardNo, String nStatus, Date nModifyDate,
			Date nEnrollDate, int nCount) {
		super();
		this.nWriter = nWriter;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nBoardNo = nBoardNo;
		this.nStatus = nStatus;
		this.nModifyDate = nModifyDate;
		this.nEnrollDate = nEnrollDate;
		this.nCount = nCount;
	}

	public String getnWriter() {
		return nWriter;
	}

	public String getnTitle() {
		return nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public String getnBoardNo() {
		return nBoardNo;
	}

	public String getnStatus() {
		return nStatus;
	}

	public Date getnModifyDate() {
		return nModifyDate;
	}

	public Date getnEnrollDate() {
		return nEnrollDate;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public void setnBoardNo(String nBoardNo) {
		this.nBoardNo = nBoardNo;
	}

	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}

	public void setnModifyDate(Date nModifyDate) {
		this.nModifyDate = nModifyDate;
	}

	public void setnEnrollDate(Date nEnrollDate) {
		this.nEnrollDate = nEnrollDate;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	@Override
	public String toString() {
		return "D_Notice [nWriter=" + nWriter + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nBoardNo="
				+ nBoardNo + ", nStatus=" + nStatus + ", nModifyDate=" + nModifyDate + ", nEnrollDate=" + nEnrollDate
				+ ", nCount=" + nCount + "]";
	}
	
	
}
