package com.kh.forest.buy.model.service;

import static com.kh.forest.common.JDBCTemplate.close;
import static com.kh.forest.common.JDBCTemplate.commit;
import static com.kh.forest.common.JDBCTemplate.getConnection;
import static com.kh.forest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.forest.buy.model.dao.B_buyDao;
import com.kh.forest.buy.model.vo.BuyAttachment;
import com.kh.forest.buy.model.vo.BuyInfo;
import com.kh.forest.buy.model.vo.BuyProduct;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;

public class B_buyService {

	public ArrayList<BuyProduct> selectCategory(int categoryNo) {
		Connection con = getConnection();
		
		ArrayList<BuyProduct> buyProductList = new B_buyDao().selectCategory(con, categoryNo);
		
		close(con);
		return buyProductList;
	}
	
	public ArrayList<BuyProduct> selectManufaturerName(String manufacturerNo, String categoryNo) {
		Connection con = getConnection();
		
		ArrayList<BuyProduct> buyProductList = new B_buyDao().selectManufaturerName(con, manufacturerNo, categoryNo);
		 
		close(con);
		return buyProductList;
	}
	//체크리스트 등록
	public int insertUserCheckList(String buyNo, BuyInfo buyinfo, HashMap<String, String> exampleMap) {
		Connection con = getConnection();
		
		int result1 = new B_buyDao().insertUserCheckList(con, buyNo, buyinfo, exampleMap);
		
		if(result1 > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result1;
	}
	//사진등록
	public int insertPhoto(ArrayList<BuyAttachment> fileList, String buyNo) {
		Connection con = getConnection();
		
		int result = 0;
		
		for(int i = 0; i < fileList.size(); i++) {
			result += new B_buyDao().insertPhoto(con, fileList.get(i), buyNo);
		}
		
		if(result == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		
		close(con);
		
		return result;
	}
	
	//관리자 매입신청현황 전체 리스트 불러오기 및 페이징 처리같이
	public ArrayList<BuyInfo> selectRequestList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<BuyInfo> list = new B_buyDao().selectRequestList(con, pi);
		
		close(con);
		
		return list;
	}
	
	//관리자 매입 신청현황 페이징용 리스트 카운트
	public int getListCountRequest() {
		Connection con = getConnection();
		
		int listCountRequest = new B_buyDao().getListCountRequest(con);
		
		close(con);
		
		return listCountRequest;
	}
	//매입신청정보 테이블 인서트
	public int insertbuyinfotable(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int buyno = new B_buyDao().insertBuyinfotable(con, buyinfo);
		int buyno2 = 0;
		if(buyno > 0) {
			commit(con);
			buyno2 = new B_buyDao().selectbuyNo(con, buyinfo);		
		} else {
			rollback(con);
		}
		close(con);
		
		return buyno2;
	}
	 //매입신청정보 히스토리남기기
	 public int insertbuyhistory(String buyNo) {
	    Connection con = getConnection();
	      
	    int history = new B_buyDao().insertbuyhistory(con, buyNo);
	      
	    close(con);
	      
	    return history;
	}
	//마이페이지 판매현황 리스트 조회 및 페이징
	public ArrayList<BuyInfo> selectBuyList(PageInfo pi, String userNo) {
		Connection con = getConnection();
		
		ArrayList<BuyInfo> list = new B_buyDao().selectBuyList(con, pi, userNo);
		
		close(con);
		
		return list;
	}
	//관리자 매입현황리스트 조회 및 페이징 처리
	public ArrayList<BuyInfo> selectCurrentList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<BuyInfo> list = new B_buyDao().selectCurrentList(con, pi);
		
		close(con);
		
		return list;
	}
	//관리자 매입현황 페이징용 리스트 카운트
	public int getListCountCurrent() {
		Connection con = getConnection();
		
		int listCountCurrent = new B_buyDao().listCountCurrent(con);
		
		close(con);
		
		return listCountCurrent;
	}
	//관리자 매입불가 페이징용 리스트 카운트
	public int getListCountReject() {
		Connection con = getConnection();
		
		int listCountReject = new B_buyDao().listCountReject(con);
		
		close(con);
		
		return listCountReject;
	}
	//관리자매입불가리스트 조회 및 페이징 처리
	public ArrayList<BuyInfo> selectRejectList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<BuyInfo> list = new B_buyDao().selectRejectList(con, pi);
		
		close(con);
		
		return list;
	}
	//마이페이지 판매현황 페이징용 리스트 카운트
	public int getListCount(String userNo) {
		Connection con = getConnection();
		
		int listCount = new B_buyDao().listCount(con, userNo);
		
		close(con);
		
		return listCount;
	}
	//관리자 매입신청 1차검수 모달안에 체크리스트 담아오기
	public ArrayList<HashMap<String, String>> selectExampleList(String buyNoVal) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, String>> exampleList = new B_buyDao().selectExampleList(con, buyNoVal);
		
		close(con);
		
		return exampleList;
	}
	//관리자 매입신청 1차검수 모달안에 이용자가 올린 사진 불러오기
	public ArrayList<HashMap<String, String>> selectPhotoList(String buyNoVal) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, String>> fileList = new B_buyDao().selectPhotoList(con, buyNoVal);
		
		close(con);
		
		return fileList;
	}
	//관리자 매입신청 1차검수  모달창 입력값 디비 업데이트
	public int updateFirstCheck(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int result1 = new B_buyDao().updateFirstCheck(con, buyinfo);
		
		int result2 = new B_buyDao().insertFirstHistory(con, buyinfo);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		
		int result = 0;
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		
		close(con);
		
		return result;
		
	}
	//관리자 매입신청 모달차 1차검수 매입불가시 업데이트
	public int updateFirstCheckReject(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int result1 = new B_buyDao().updateFirstCheckReject(con, buyinfo);
		
		int result2 = new B_buyDao().insertFirstHistoryReject(con, buyinfo);
		
		int result = 0;
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		close(con);
		
		return result;
	}
	//매입신청현황 정보확인 디테일 셀렉트
	public BuyInfo selectRequestDetail(String buyNo) {
		Connection con = getConnection();
		
		BuyInfo buyinfo = new B_buyDao().selectRequestDetail(con, buyNo);
		
		close(con);
		
		return buyinfo;
	}
	
	//매입불가시 정보확인디텔셀렉트
	public BuyInfo selectRequestDetailReject(String buyNo) {
		Connection con = getConnection();
		
		BuyInfo buyinfo = new B_buyDao().selectRequestDetailReject(con, buyNo);
		
		close(con);
		
		return buyinfo;
		
	}

	//매입신청페이지 정보확인시 사진 불러오기

	public HashMap<String, Object> selectPhotoListDetail(String buyNo) {
		Connection con = getConnection();
		
		HashMap<String, Object> hmap = new B_buyDao().selectPhotoListDetail(con, buyNo);
		
		close(con);
		
		return hmap;
	}
	//2차검수 모달창에 1차검수때 값 불러오기 
	public BuyInfo selectQuote(String buyNoVal) {
		Connection con = getConnection();
		
		BuyInfo buyinfo = new B_buyDao().selectQuote(con, buyNoVal);
		
		close(con);
		
		return buyinfo;
	}
	//매입신청시 2차검수 누르면 값 업데이트되고 인서트 되기
	public int updateSecondCheck(BuyInfo buyinfo, HashMap<String, String> hmap) {
		Connection con = getConnection();
		
		int result1 = new B_buyDao().updateSecondCheck(con, buyinfo); 
		int result2 = new B_buyDao().insertEmpAnswer(con, hmap, buyinfo);
		int result3 = new B_buyDao().insertBuyPoint(con, buyinfo);
		int result4 = new B_buyDao().insertSecondHistory(con, buyinfo);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		System.out.println("result4 : " + result4);
		int result = 0;
		if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		close(con);
		
		return result;
	}

	public int updateSecondRejectCheck(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int result1 = new B_buyDao().updateSecondRejectCheck(con, buyinfo);
		int result2 = new B_buyDao().insertSecondRejectHistory(con, buyinfo);
		
		int result = 0;
		if(result1> 0 && result2 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		close(con);
		
		return result;
	}

	//운송장번호 인서트, 회원이 입력한 주소 업데이트
	public int insertWaybill(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int result1 = new B_buyDao().insertWaybill(con, buyinfo);
		int result2 = new B_buyDao().updateBuyAddress(con, buyinfo);
		
		int result = 0;
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		close(con);
		
		return result;
	}

	public int updateBuyAddress(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int result = new B_buyDao().updateBuyAddress(con, buyinfo);
		
		if(result > 0) {
			commit(con);
			
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	//견적확인하고나서 상태업데이트 해주고 히스토리 인서트
	public int updateBuyStatus(String buyNoVal) {
		Connection con = getConnection();
		
		int result1 = new B_buyDao().updateBuyStatus(con, buyNoVal);
		int result2 = new B_buyDao().insertBuyHistoryStatus(con, buyNoVal);
		
		int result = 0;
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		
		close(con);
		
		return result;
		
	}
	//관리자 정보확인에서 인수완료 누르면 인수대기중에서 인수완료로 상태 변경 + 히스토리
	public int updatewaybillStatus(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int result1 = new B_buyDao().updatewaybillStatus(con, buyinfo);
		int result2 = new B_buyDao().insertBuyHistoryStatus(con, buyinfo);
		
		int result = 0;
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		
		close(con);
		
		return result;
	}
	//반송시 배송내역에 인서트
	public int insertDeliveryHistory(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int result = new B_buyDao().insertDeliveryHistory(con, buyinfo);
		
		if(result > 0) {
			commit(con);
			
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
		
	}
	//등급별로 시세별로 견적 계산
	public int selectBuyPrice(BuyInfo buyinfo) {
		Connection con = getConnection();
		
		int price = new B_buyDao().selectBuyPrice(con, buyinfo);
		
		close(con);
		
		return price;
	}
	//멤버 포인트
	public int selectPoint(String userNo, int point) {
		Connection con = getConnection();
		
		Member member = new B_buyDao().selectPoint(con, userNo);
		
		int memberResult = 0;
		
		if(member != null) {
			memberResult = new B_buyDao().updatePoint(con, member, point);
			if(memberResult > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		}
		return memberResult;
	}





}
