package com.kh.forest.member.model.vo;

public class MemberStats {
	private int newMember;
	private int menCount;
	private int womenCount;
	private int one;
	private int two;
	private int three;
	private int four;
	private int five;
	private int six;
	
	public MemberStats() {}

	public MemberStats(int newMember, int menCount, int womenCount, int one, int two, int three, int four, int five,
			int six) {
		super();
		this.newMember = newMember;
		this.menCount = menCount;
		this.womenCount = womenCount;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.six = six;
	}

	public int getNewMember() {
		return newMember;
	}

	public void setNewMember(int newMember) {
		this.newMember = newMember;
	}

	public int getMenCount() {
		return menCount;
	}

	public void setMenCount(int menCount) {
		this.menCount = menCount;
	}

	public int getWomenCount() {
		return womenCount;
	}

	public void setWomenCount(int womenCount) {
		this.womenCount = womenCount;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getThree() {
		return three;
	}

	public void setThree(int three) {
		this.three = three;
	}

	public int getFour() {
		return four;
	}

	public void setFour(int four) {
		this.four = four;
	}

	public int getFive() {
		return five;
	}

	public void setFive(int five) {
		this.five = five;
	}

	public int getSix() {
		return six;
	}

	public void setSix(int six) {
		this.six = six;
	}

	@Override
	public String toString() {
		return "MemberStats [newMember=" + newMember + ", menCount=" + menCount + ", womenCount=" + womenCount
				+ ", one=" + one + ", two=" + two + ", three=" + three + ", four=" + four + ", five=" + five + ", six="
				+ six + "]";
	}
	
	
}
