package com.kh.forest.product.model.vo;

public class A_ProductMonthlyStatic {
/*	SELECT TO_CHAR(REQUEST_DATE, 'YYYY-MM') REQUEST_DATE
    , COUNT(CASE WHEN BUY_STATUS = '1차검수신청' THEN 1 END) "FIRST_REQUEST"
    , COUNT(CASE WHEN BUY_STATUS = '1차검수완료' THEN 1 END) "FIRST_COMPLETE"
    , COUNT(CASE WHEN BUY_STATUS = '1차검수탈락' THEN 1 END) "FIRST_FAIL"
    , COUNT(CASE WHEN BUY_STATUS = '2차검수완료' THEN 1 END) "SECOND_COMPLETE"
    , COUNT(CASE WHEN BUY_STATUS = '매입불가' THEN 1 END) "CANCEL"
    , COUNT(CASE WHEN BUY_STATUS = '매입완료' THEN 1 END) "COMPLETE"
    , COUNT(CASE WHEN BUY_STATUS = '인수대기중' THEN 1 END) "WAITING"
    , COUNT(CASE WHEN BUY_STATUS = '인수완료' THEN 1 END) "RECEIVE"
    FROM BUY_INFO
    GROUP BY TO_CHAR(REQUEST_DATE, 'YYYY-MM');*/
	private String requestDate;
	private int firstRequest;
	private int firstComplete;
	private int firstFail;
	private int secondComplete;
	private int cancel;
	private int complete;
	private int waiting;
	private int receive;
	
	public A_ProductMonthlyStatic() {}
	
	public A_ProductMonthlyStatic(String requestDate, int firstRequest, int firstComplete, int firstFail,
			int secondComplete, int cancel, int complete, int waiting, int receive) {
		super();
		this.requestDate = requestDate;
		this.firstRequest = firstRequest;
		this.firstComplete = firstComplete;
		this.firstFail = firstFail;
		this.secondComplete = secondComplete;
		this.cancel = cancel;
		this.complete = complete;
		this.waiting = waiting;
		this.receive = receive;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public int getFirstRequest() {
		return firstRequest;
	}

	public void setFirstRequest(int firstRequest) {
		this.firstRequest = firstRequest;
	}

	public int getFirstComplete() {
		return firstComplete;
	}

	public void setFirstComplete(int firstComplete) {
		this.firstComplete = firstComplete;
	}

	public int getFirstFail() {
		return firstFail;
	}

	public void setFirstFail(int firstFail) {
		this.firstFail = firstFail;
	}

	public int getSecondComplete() {
		return secondComplete;
	}

	public void setSecondComplete(int secondComplete) {
		this.secondComplete = secondComplete;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public int getWaiting() {
		return waiting;
	}

	public void setWaiting(int waiting) {
		this.waiting = waiting;
	}

	public int getReceive() {
		return receive;
	}

	public void setReceive(int receive) {
		this.receive = receive;
	}

	@Override
	public String toString() {
		return "A_ProductMonthlyStatic [requestDate=" + requestDate + ", firstRequest=" + firstRequest
				+ ", firstComplete=" + firstComplete + ", firstFail=" + firstFail + ", secondComplete=" + secondComplete
				+ ", cancel=" + cancel + ", complete=" + complete + ", waiting=" + waiting + ", receive=" + receive
				+ "]";
	}
	
}
