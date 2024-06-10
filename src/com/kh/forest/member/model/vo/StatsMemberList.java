package com.kh.forest.member.model.vo;

public class StatsMemberList {
	private String enrollDate;
	private String userId;
	private String gender;
	private String age;
	
	public StatsMemberList() {}

	public StatsMemberList(String enrollDate, String userId, String gender, String age) {
		super();
		this.enrollDate = enrollDate;
		this.userId = userId;
		this.gender = gender;
		this.age = age;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StatsMemberList [enrollDate=" + enrollDate + ", userId=" + userId + ", gender=" + gender + ", age="
				+ age + "]";
	}
	
	
}
