package com.kh.forest.product.model.vo;

public class A_ProductStatic {

	/*10	디지털
	20	가전제품
	11	노트북
	12	태블릿PC
	21	생활가전
	22	주방가전
	23	미용가전*/
	private int notebook;
	private int tablet;	
	private int life;
	private int kitchen;
	private int beauty;
	
	public A_ProductStatic() {}
	
	public A_ProductStatic(int notebook, int tablet, int life, int kitchen, int beauty) {
		super();
		this.notebook = notebook;
		this.tablet = tablet;
		this.life = life;
		this.kitchen = kitchen;
		this.beauty = beauty;
	}

	public int getNotebook() {
		return notebook;
	}

	public void setNotebook(int notebook) {
		this.notebook = notebook;
	}

	public int getTablet() {
		return tablet;
	}

	public void setTablet(int tablet) {
		this.tablet = tablet;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getKitchen() {
		return kitchen;
	}

	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}

	public int getBeauty() {
		return beauty;
	}

	public void setBeauty(int beauty) {
		this.beauty = beauty;
	}

	@Override
	public String toString() {
		return "A_ProductStatic [notebook=" + notebook + ", tablet=" + tablet + ", life=" + life + ", kitchen="
				+ kitchen + ", beauty=" + beauty + "]";
	}
	
	
	
	
}
