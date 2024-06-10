package com.kh.forest.admin.model.vo;

public class Admin {
	private String empNo;
	private String empName;
	private String phone;
	private String empId;
	private String password;
	private String status;
	
	public Admin() {}

	public Admin(String empNo, String empName, String phone, String empId, String password, String status) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.phone = phone;
		this.empId = empId;
		this.password = password;
		this.status = status;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admin [empNo=" + empNo + ", empName=" + empName + ", phone=" + phone + ", empId=" + empId
				+ ", password=" + password + ", status=" + status + "]";
	}
	
	
}
