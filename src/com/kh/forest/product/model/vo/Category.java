package com.kh.forest.product.model.vo;

public class Category {
	private String categoryNo;
	private String categoryName;
	private int categoryLevel;
	private int categoryUpper;
	
	public Category() {}

	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", categoryLevel="
				+ categoryLevel + ", categoryUpper=" + categoryUpper + "]";
	}

	public Category(String categoryNo, String categoryName, int categoryLevel, int categoryUpper) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.categoryLevel = categoryLevel;
		this.categoryUpper = categoryUpper;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public int getCategoryUpper() {
		return categoryUpper;
	}

	public void setCategoryUpper(int categoryUpper) {
		this.categoryUpper = categoryUpper;
	}

}
