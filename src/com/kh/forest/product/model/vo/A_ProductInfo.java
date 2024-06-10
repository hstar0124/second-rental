package com.kh.forest.product.model.vo;

public class A_ProductInfo {
	
	private String productNo;			//PRODUCT_NO			VARCHAR2(30 BYTE)
	private String productEnrolldate;	//PRODUCT_ENROLLDATE	DATE
	private String manufacturerName;	//MANUFACTURER_NAME		VARCHAR2(30 BYTE)
	private int acceptanceMonth;		//ACCEPTANCE_MONTH		NUMBER
	private String buyNo;				//BUY_NO				VARCHAR2(10 BYTE)
	private String categoryName;		//CATEGORY_NAME			VARCHAR2(50 BYTE)
	private String productName;			//PRODUCT_NAME			VARCHAR2(100 BYTE)
	private String warehouseNo;			//WAREHOUSE_NO			VARCHAR2(10 BYTE)
	private String productDetail;		//PRODUCT_DETAIL		VARCHAR2(4000 BYTE)
	private String homepageUpdate;		//HOMEPAGE_UPDATE		VARCHAR2(10 BYTE)
	private String productNotice;		//PRODUCT_NOTICE		VARCHAR2(4000 BYTE)
	private String deliveryInfo;		//DELIVERY_INFO			VARCHAR2(500 BYTE)
	private String mainpageUpdate;		//MAINPAGE_UPDATE		VARCHAR2(10 BYTE)
	private String buyPrice;			//BUY_PRICE				VARCHAR2(30 BYTE)
	private String buyProductNo;		//BUY_PRODUCT_NO		VARCHAR2(10 BYTE)
	private String empNo;				//EMP_NO				VARCHAR2(10 BYTE)
	private String grade;				//GRADE					VARCHAR2(3 BYTE)
	private String specialNote;			//SPECIAL_NOTE			VARCHAR2(4000 BYTE)
	private String rentalPrice;			//RENTAL_PRICE			VARCHAR2(30 BYTE)
	private String rentalStatus;		//RENTAL_STATUS			VARCHAR2(30 BYTE)
	
	public A_ProductInfo() {}
	
	public A_ProductInfo(String productNo, String productEnrolldate, String manufacturerName, int acceptanceMonth,
			String buyNo, String categoryName, String productName, String warehouseNo, String productDetail,
			String homepageUpdate, String productNotice, String deliveryInfo, String mainpageUpdate, String buyPrice,
			String buyProductNo, String empNo, String grade, String specialNote, String rentalPrice,
			String rentalStatus) {
		super();
		this.productNo = productNo;
		this.productEnrolldate = productEnrolldate;
		this.manufacturerName = manufacturerName;
		this.acceptanceMonth = acceptanceMonth;
		this.buyNo = buyNo;
		this.categoryName = categoryName;
		this.productName = productName;
		this.warehouseNo = warehouseNo;
		this.productDetail = productDetail;
		this.homepageUpdate = homepageUpdate;
		this.productNotice = productNotice;
		this.deliveryInfo = deliveryInfo;
		this.mainpageUpdate = mainpageUpdate;
		this.buyPrice = buyPrice;
		this.buyProductNo = buyProductNo;
		this.empNo = empNo;
		this.grade = grade;
		this.specialNote = specialNote;
		this.rentalPrice = rentalPrice;
		this.rentalStatus = rentalStatus;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductEnrolldate() {
		return productEnrolldate;
	}

	public void setProductEnrolldate(String productEnrolldate) {
		this.productEnrolldate = productEnrolldate;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public String getHomepageUpdate() {
		return homepageUpdate;
	}

	public void setHomepageUpdate(String homepageUpdate) {
		this.homepageUpdate = homepageUpdate;
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

	public String getBuyProductNo() {
		return buyProductNo;
	}

	public void setBuyProductNo(String buyProductNo) {
		this.buyProductNo = buyProductNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSpecialNote() {
		return specialNote;
	}

	public void setSpecialNote(String specialNote) {
		this.specialNote = specialNote;
	}

	public String getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(String rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

	@Override
	public String toString() {
		return "A_ProductInfo [productNo=" + productNo + ", productEnrolldate=" + productEnrolldate
				+ ", manufacturerName=" + manufacturerName + ", acceptanceMonth=" + acceptanceMonth + ", buyNo=" + buyNo
				+ ", categoryName=" + categoryName + ", productName=" + productName + ", warehouseNo=" + warehouseNo
				+ ", productDetail=" + productDetail + ", homepageUpdate=" + homepageUpdate + ", productNotice="
				+ productNotice + ", deliveryInfo=" + deliveryInfo + ", mainpageUpdate=" + mainpageUpdate
				+ ", buyPrice=" + buyPrice + ", buyProductNo=" + buyProductNo + ", empNo=" + empNo + ", grade=" + grade
				+ ", specialNote=" + specialNote + ", rentalPrice=" + rentalPrice + ", rentalStatus=" + rentalStatus
				+ "]";
	}
	
	
	
}
