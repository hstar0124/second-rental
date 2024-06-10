package com.kh.forest.point.model.vo;

public class PointSum {
	private int useSum;
	private int cashBackProPoint;
	private int cashBackPoint;
	private int refundPount;
	private int buyPoint;
	
	public PointSum() {}

	public PointSum(int useSum, int cashBackProPoint, int cashBackPoint, int refundPount, int buyPoint) {
		super();
		this.useSum = useSum;
		this.cashBackProPoint = cashBackProPoint;
		this.cashBackPoint = cashBackPoint;
		this.refundPount = refundPount;
		this.buyPoint = buyPoint;
	}

	public int getUseSum() {
		return useSum;
	}

	public void setUseSum(int useSum) {
		this.useSum = useSum;
	}

	public int getCashBackProPoint() {
		return cashBackProPoint;
	}

	public void setCashBackProPoint(int cashBackProPoint) {
		this.cashBackProPoint = cashBackProPoint;
	}

	public int getCashBackPoint() {
		return cashBackPoint;
	}

	public void setCashBackPoint(int cashBackPoint) {
		this.cashBackPoint = cashBackPoint;
	}

	public int getRefundPount() {
		return refundPount;
	}

	public void setRefundPount(int refundPount) {
		this.refundPount = refundPount;
	}

	public int getBuyPoint() {
		return buyPoint;
	}

	public void setBuyPoint(int buyPoint) {
		this.buyPoint = buyPoint;
	}

	@Override
	public String toString() {
		return "PointSum [useSum=" + useSum + ", cashBackProPoint=" + cashBackProPoint + ", cashBackPoint="
				+ cashBackPoint + ", refundPount=" + refundPount + ", buyPoint=" + buyPoint + "]";
	}
	
	
}
