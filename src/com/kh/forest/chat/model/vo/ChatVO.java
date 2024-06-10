package com.kh.forest.chat.model.vo;

import java.sql.Date;

public class ChatVO {

	private String chatNo;
	private String message;
	private String date;
	private int readCheck;
	private String sender;
	private String receiver;
	
	public ChatVO() {}
	
	public ChatVO(String sender, String receiver, String message) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ChatVO [chatNo=" + chatNo + ", message=" + message + ", date=" + date + ", readCheck=" + readCheck
				+ ", sender=" + sender + ", receiver=" + receiver + "]";
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChatNo() {
		return chatNo;
	}

	public void setChatNo(String chatNo) {
		this.chatNo = chatNo;
	}

	public int getReadCheck() {
		return readCheck;
	}

	public void setReadCheck(int readCheck) {
		this.readCheck = readCheck;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
