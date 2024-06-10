package com.kh.forest.product.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable{
	//실질적인 PRODUCT테이블 인설트정보
	private String productNo;
	private Date productEnrolldate; 
	private String manufacturerNo;
	private int acceptanceMonth;
	private String buyNo;
	private String categoryNo; 
	private String productName;
	private String warehouseNo;
	private String productDetail;
	private String hompageUpdate;
	private String productNotice;
	private String deliveryInfo;
	private String mainpageUpdate;
	private String buyPrice;
	private String rentalStatus;
	
	
	private String categoryName;
	private String buyProductName;
	private String buyProductNo;
	private String manufacturerName;
	private String grade;
	private String marketprice;
	private String empNo;
	private String empName;
	private String warehouseName;
	private String sepcialNote;
	private String productStatus;
	private String rentalPrice;
	
	private String temp;

	public Product() {}

	public Product(String productNo, Date productEnrolldate, String manufacturerNo, int acceptanceMonth, String buyNo,
			String categoryNo, String productName, String warehouseNo, String productDetail, String hompageUpdate,
			String productNotice, String deliveryInfo, String mainpageUpdate, String buyPrice, String rentalStatus,
			String categoryName, String buyProductName, String buyProductNo, String manufacturerName, String grade,
			String marketprice, String empNo, String empName, String warehouseName, String sepcialNote,
			String productStatus, String rentalPrice, String temp) {
		super();
		this.productNo = productNo;
		this.productEnrolldate = productEnrolldate;
		this.manufacturerNo = manufacturerNo;
		this.acceptanceMonth = acceptanceMonth;
		this.buyNo = buyNo;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.warehouseNo = warehouseNo;
		this.productDetail = productDetail;
		this.hompageUpdate = hompageUpdate;
		this.productNotice = productNotice;
		this.deliveryInfo = deliveryInfo;
		this.mainpageUpdate = mainpageUpdate;
		this.buyPrice = buyPrice;
		this.rentalStatus = rentalStatus;
		this.categoryName = categoryName;
		this.buyProductName = buyProductName;
		this.buyProductNo = buyProductNo;
		this.manufacturerName = manufacturerName;
		this.grade = grade;
		this.marketprice = marketprice;
		this.empNo = empNo;
		this.empName = empName;
		this.warehouseName = warehouseName;
		this.sepcialNote = sepcialNote;
		this.productStatus = productStatus;
		this.rentalPrice = rentalPrice;
		this.temp = temp;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public Date getProductEnrolldate() {
		return productEnrolldate;
	}

	public void setProductEnrolldate(Date productEnrolldate) {
		this.productEnrolldate = productEnrolldate;
	}

	public String getManufacturerNo() {
		return manufacturerNo;
	}

	public void setManufacturerNo(String manufacturerNo) {
		this.manufacturerNo = manufacturerNo;
	}

	public int getAcceptanceMonth() {
		return acceptanceMonth;
	}

	public void setAcceptanceMonth(int acceptanceMonth) {
		this.acceptanceMonth = acceptanceMonth;
	}

	public String getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(String buyNo) {
		this.buyNo = buyNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getWarehouseNo() {
		return warehouseNo;
	}

	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getHompageUpdate() {
		return hompageUpdate;
	}

	public void setHompageUpdate(String hompageUpdate) {
		this.hompageUpdate = hompageUpdate;
	}

	public String getProductNotice() {
		return productNotice;
	}

	public void setProductNotice(String productNotice) {
		this.productNotice = productNotice;
	}

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(String deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public String getMainpageUpdate() {
		return mainpageUpdate;
	}

	public void setMainpageUpdate(String mainpageUpdate) {
		this.mainpageUpdate = mainpageUpdate;
	}

	public String getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBuyProductName() {
		return buyProductName;
	}

	public void setBuyProductName(String buyProductName) {
		this.buyProductName = buyProductName;
	}

	public String getBuyProductNo() {
		return buyProductNo;
	}

	public void setBuyProductNo(String buyProductNo) {
		this.buyProductNo = buyProductNo;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(String marketprice) {
		this.marketprice = marketprice;
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

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getSepcialNote() {
		return sepcialNote;
	}

	public void setSepcialNote(String sepcialNote) {
		this.sepcialNote = sepcialNote;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(String rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productEnrolldate=" + productEnrolldate + ", manufacturerNo="
				+ manufacturerNo + ", acceptanceMonth=" + acceptanceMonth + ", buyNo=" + buyNo + ", categoryNo="
				+ categoryNo + ", productName=" + productName + ", warehouseNo=" + warehouseNo + ", productDetail="
				+ productDetail + ", hompageUpdate=" + hompageUpdate + ", productNotice=" + productNotice
				+ ", deliveryInfo=" + deliveryInfo + ", mainpageUpdate=" + mainpageUpdate + ", buyPrice=" + buyPrice
				+ ", rentalStatus=" + rentalStatus + ", categoryName=" + categoryName + ", buyProductName="
				+ buyProductName + ", buyProductNo=" + buyProductNo + ", manufacturerName=" + manufacturerName
				+ ", grade=" + grade + ", marketprice=" + marketprice + ", empNo=" + empNo + ", empName=" + empName
				+ ", warehouseName=" + warehouseName + ", sepcialNote=" + sepcialNote + ", productStatus="
				+ productStatus + ", rentalPrice=" + rentalPrice + ", temp=" + temp + "]";
	}
	
	

}
