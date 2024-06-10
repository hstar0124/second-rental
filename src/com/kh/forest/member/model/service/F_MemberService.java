package com.kh.forest.member.model.service;

import static com.kh.forest.common.JDBCTemplate.close;


import static com.kh.forest.common.JDBCTemplate.commit;
import static com.kh.forest.common.JDBCTemplate.getConnection;
import static com.kh.forest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kh.forest.admin.model.vo.Admin;
import com.kh.forest.member.model.dao.F_MemberDao;
import com.kh.forest.member.model.vo.BuyDetail;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.MemberHistory;
import com.kh.forest.member.model.vo.MemberStats;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.member.model.vo.Report;
import com.kh.forest.member.model.vo.StatsMemberList;
import com.kh.forest.member.model.vo.WarningHistory;
import com.kh.forest.product.model.vo.E_PageInfo;
import com.kh.forest.product.model.vo.Rental;

import oracle.net.aso.f;

public class F_MemberService {
	//회원가입
	public int insertMember(Member createMember) {
		Connection con = getConnection();

		int result = new F_MemberDao().insertMember(con, createMember);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return result;
	}
	//로그인 확인
	public Member loginCheck(Member requestMember) {
		Connection con = getConnection();
		Member loginUser = null;

		Member selectMember = new F_MemberDao().checkId(con, requestMember);

		loginUser = new F_MemberDao().loginCheck(con, requestMember);
		if(loginUser ==null) {
			int result = new F_MemberDao().loginCount(con, selectMember);
			if(result >0) {
				commit(con);
			}else {
				rollback(con);
			}
		}else {
			if(loginUser.getLogCount() <=4) {
				int result = new F_MemberDao().resetLoginCount(con, selectMember);
				if(result >0) {
					commit(con);
				}else {
					rollback(con);
				}
			}
		}

		close(con);

		return loginUser;
	}
	//아이디 확인
	public int idCheck(String userId) {
		Connection con = getConnection();

		int result = new F_MemberDao().checkMember(con, userId);

		close(con);

		return result;
	}
	//아이디 찾기
	public String findMemberId(Member findMember) {
		Connection con = getConnection();

		String findId = new F_MemberDao().findMemberId(con , findMember);

		close(con);

		return findId;
	}
	//비밀번호 찾기
	public int findPassword(Member findPwd) {
		Connection con = getConnection();
		int result = new F_MemberDao().findPassword(con, findPwd);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		return result;
	}
	//한명의 회원을 조회
	public Member selectOne(int num) {
		Connection con = getConnection();

		Member selectMember = new F_MemberDao().selectOne(con, num);

		close(con);

		return selectMember;
	}
	//전체 회원 조회
	public List<Member> selectAll(PageInfo pi) {
		Connection con = getConnection();

		List<Member> list = new F_MemberDao().selectAll(con, pi);

		close(con);

		return list;
	}

	//채팅 전체 회원 조회용 메소드
	public List<Member> selectAll() {
		Connection con = getConnection();

		List<Member> list = new F_MemberDao().selectAll(con);

		close(con);

		return list;
	}

	//비밀번호 확인
	public Member checkPwd(Member checkMember) {
		Connection con = getConnection();

		Member okMember = new F_MemberDao().checkPwd(con, checkMember);

		close(con);

		return okMember;
	}
	//총 회원 리스트 수를 조회
	public int getListCount() {
		Connection con = getConnection();

		int listCount = new F_MemberDao().getListCount(con);

		close(con);

		return listCount;
	}
	//회원 정보 수정
	public Member updateMember(Member updateMember) {
		Connection con = getConnection();
		Member selectMember = null;
		int result = new F_MemberDao().updateMember(con, updateMember);

		if(result>0) {
			commit(con);
			selectMember = new F_MemberDao().selectOne(con, Integer.parseInt(updateMember.getUserNo()));
		}else {
			rollback(con);
		}

		close(con);

		return selectMember;
	}
	//관리자 회원리스트 검색
	public List<Member> searchUserName(PageInfo pi, String search) {
		Connection con = getConnection();

		List<Member> list = new F_MemberDao().searchUserName(con, pi, search);

		close(con);

		return list;
	}
	//관리자 회원리스트 이름 검색 시 페이징 메소드
	public int getSearchUserNameCount(String search) {
		Connection con = getConnection();

		int listCount = new F_MemberDao().getSearchUserNameCount(con, search);

		close(con);

		return listCount;
	}
	//관리자 회원리스트 검색
	public List<Member> searchUserId(String search) {
		Connection con = getConnection();

		List<Member> list = new F_MemberDao().searchUserId(con, search);

		close(con);

		return list;
	}
	//관리자 회원리스트 검색
	public List<Member> searchUserNo(String search) {
		Connection con = getConnection();

		List<Member> list = new F_MemberDao().searchUserNo(con, search);

		close(con);

		return list;
	}
	//회원의 현 로그인 횟수를 조회
	public Member logCount(Member requestMember) {
		Connection con = getConnection();

		Member selectMember = new F_MemberDao().checkId(con, requestMember);

		close(con);

		return selectMember;
	}
	//로그인 성공 또는 실패 시 카운트를 수정
	public int updateStatus(Member m) {
		Connection con = getConnection();

		int result = new F_MemberDao().updateStatus(con, m);

		if(result > 0) {
			commit(con);
			int num = new F_MemberDao().insertMemberHistory(con, m);
			if(num > 0) {
				commit(con);
			}else {
				rollback(con);
			}

		}else {
			rollback(con);
		}
		close(con);

		return result;
	}
	//회원기록이력을 전체 조회
	public List<MemberHistory> historySelectAll(PageInfo pi) {
		Connection con = getConnection();

		List<MemberHistory> list = new F_MemberDao().historySelectAll(con, pi);

		close(con);

		return list;
	}
	//회원 이력 리스트의 수를 조회
	public int historyCount() {
		Connection con = getConnection();

		int listCount = new F_MemberDao().gethistoryCount(con);

		close(con);

		return listCount;
	}
	//로그인 제제 복구
	public int loginRestore(String num) {
		Connection con = getConnection();

		int result = new F_MemberDao().memberUpdate(con , num);

		if(result > 0) {
			commit(con);
			int result1 = new F_MemberDao().loginRestoreHistory(con, num);

			if(result1 > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		}else {
			rollback(con);
		}

		close(con);
		return result;
	}

	//탈퇴메소드
	public int deleteMember(String num) {
		Connection con = getConnection();

		int result = new F_MemberDao().deleteMember(con, num);

		if(result > 0) {
			commit(con);
			int result1 = new F_MemberDao().deleteHistory(con, num);

			if(result1 > 0) {
				commit(con);
			}else {
				rollback(con);
			}

		}else {
			rollback(con);
		}

		return result;
	}
	//탈퇴 리스트 명단 수 조회
	public int getDeleteCount() {
		Connection con = getConnection();

		int listCount = new F_MemberDao().getDeleteCount(con);

		close(con);

		return listCount;
	}
	//탈퇴 회원 명단 전체 조회
	public List<Member> deleteSelectAll(PageInfo pi) {
		Connection con = getConnection();

		List<Member> list = new F_MemberDao().deleteSelectAll(con, pi);

		close(con);

		return list;
	}
	
	//회원 탈퇴 복구 
	public int memberRestore(String num) {
		Connection con = getConnection();

		int result = new F_MemberDao().deleteMemberUpdate(con , num);

		if(result > 0) {
			commit(con);
			int result1 = new F_MemberDao().memberRestoreHistory(con, num);

			if(result1 > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		}else {
			rollback(con);
		}

		close(con);
		return result;
	}
	
	//신고 리스트 계시글 수 조회
	public int getReportCount() {
		Connection con = getConnection();

		int listCount = new F_MemberDao().getReportCount(con);

		close(con);

		return listCount;
	}
	//신고 리스트 전체 조회
	public List<Report> selectAllReport(PageInfo pi) {
		Connection con = getConnection();

		List<Report> list = new F_MemberDao().selectAllReport(con, pi);

		close(con);

		return list;
	}
	
	//하나의 신고 리스트만 조회
	public Report selectOneReport(String num) {
		Connection con = getConnection();

		Report selectReport = new F_MemberDao().selectOneReport(con, num);

		close(con);

		return selectReport;
	}
	
	//신고 이력 모두 조회
	public List<Report> selectAllWarning(List<String> boardNo) {
		Connection con = getConnection();

		List<Report> list = new F_MemberDao().selectAllWanring(con, boardNo);

		close(con);

		return list;
	}
	//회원/경고이력/리뷰 업데이트
	public int updateWarning(List<Report> waringReport, Admin admin) {
		Connection con = getConnection();

		List<Member> warningCount = new F_MemberDao().warningCount(con, waringReport);

		int result = new F_MemberDao().updateWarning(con, warningCount);

			if(result > 0) {
				commit(con);
					int result1 = new F_MemberDao().updateReport(con, waringReport);
						if(result1 > 0) {
							commit(con);
								int result2 = new F_MemberDao().updateReview(con, waringReport);
									if(result2 > 0) {
										commit(con);
											int result3 = new F_MemberDao().insertWaringHistory(con, waringReport, admin);
												if(result3>0) {
													commit(con);
												}else {
													rollback(con);
												}
									}else {
										rollback(con);
									}
						}else {
							rollback(con);
						}
			}else {
				rollback(con);
			}

		close(con);

		return result;
	}
	
	//경고 리스트 카운트
	public int getWarningListCount() {
		Connection con = getConnection();

		int listCount = new F_MemberDao().getWarningListCount(con);

		close(con);

		return listCount;
	}
	
	//경고 이력 조회
	public List<WarningHistory> selectAllWarningHistory(PageInfo pi) {
		Connection con = getConnection();
		
		List<WarningHistory> list = new F_MemberDao().selectAllWarningHistory(con, pi);
		
		close(con);
		
		return list;
	}
	
	//경고가능 회원 리스트 카운트 조회
	public int getWarningMemberListCount() {
		Connection con = getConnection();

		int listCount = new F_MemberDao().getWarningMemberListCount(con);

		close(con);

		return listCount;
	}
	
	//경고 회원 (3회 이상)모두 조회
	public List<Member> warningMemberSelectAll(PageInfo pi) {
		Connection con = getConnection();

		List<Member> list = new F_MemberDao().warningMemberSelectAll(con, pi);

		close(con);

		return list;
	}
	
	//회원의 리뷰게시글에 따른 이메일 주소를 갖고오기
	public List<Member> selectMemberEmail(List<String> boardNo) {
		Connection con = getConnection();
		
		List<Member> list = new F_MemberDao().selectMemberEmail(con, boardNo);
		
		close(con);
		
		return list;
	}
	
	//회원 제제 시키기
	public int updateBlackMember(List<Member> boardNo) {
		Connection con = getConnection();

		int result = new F_MemberDao().updateBlackMember(con, boardNo);
		
		if(result > 0) {
			commit(con);
			int result1 = new F_MemberDao().insertMemberHistory(con, boardNo);
				if(result1 > 0) {
					commit(con);
				}else {
					rollback(con);
				}
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	//신고 반려처리
	public int reportPass(List<String> boardNo) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().reportPass(con, boardNo);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}
	
	//총 주문 금액
	public int allOrderMoney(int num) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().allOrderMoney(con, num);
		
		close(con);
		
		return result;
	}
	
	//주문완료 횟수
	public int orderCompleteCount(String userNo) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().orderCompleteCount(con, userNo);
		
		close(con);
		
		return result;
	}
	
	//주문 취소 횟수
	public int orderCancleCount(String userNo) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().orderCancleCount(con, userNo);
		
		close(con);
		
		return result;
	}
	
	//배송 횟수
	public int shippingCount(String userNo) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().shippingCount(con, userNo);
		
		close(con);
		
		return result;
	}
	
	//회원 상세페이지 매입 이력 카운트
	public int getBuyDetailCount(Member buyMember) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().getBuyDetailCount(con, buyMember);
		
		close(con);
		
		return result;
	}
	
	//회원 상세페이지 매입 이력 (한 회원것만)
	public List<BuyDetail> buyDetailSelectOne(PageInfo pi, Member buyMember) {
		Connection con = getConnection();
		
		List<BuyDetail> list = new F_MemberDao().buyDetailSelectOne(con, pi, buyMember);
		
		close(con);
		
		return list;
	}
	public int buyFalseCount(Member buyMember) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().buyFalseCount(con, buyMember);
		
		close(con);
		
		return result;
	}
	
	//매입완료 횟수
	public int buyComCount(Member buyMember) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().buyComCount(con, buyMember);
		
		close(con);
		
		return result;
	}
	
	//총 매입 금액
	public int allBuyMoney(int num) {
		Connection con = getConnection();
		
		int result  = new F_MemberDao().allBuyMoney(con, num);
		
		close(con);

		return result;
	}
	
	//위시 리스트 횟수
	public int wishListCount(int num) {
		Connection con = getConnection();
		
		int result  = new F_MemberDao().wishListCount(con, num);
		
		close(con);

		return result;
	}
	
	//장바구니 횟수
	public int basketCount(int num) {
		Connection con = getConnection();
		
		int result  = new F_MemberDao().basketCount(con, num);
		
		close(con);

		return result;
	}
	
	//리뷰 등록 수
	public int reviewCount(int num) {
		Connection con = getConnection();
		
		int result  = new F_MemberDao().reviewCount(con, num);
		
		close(con);

		return result;
	}
	
	//렌탈 이력 조회
	public List<Rental> rentalList(String num, PageInfo pi) {
		Connection con = getConnection();
		
		List<Rental> list = new F_MemberDao().rentalList(con, num, pi);

		close(con);
		
		return list;
	}
	
	//렌탈 이력 카운트
	public int retalListCount(String num) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().retalListCount(con, num);
		
		close(con);
		
		return result;
	}
	
	//신규 회원 차트조회(년)
	public HashMap<String, Integer> newMemberChart(String num) {
	      Connection con = getConnection();

	      HashMap<String, Integer> testMap = new F_MemberDao().newMemberChart(con, num);
	      
	      close(con);
	      
	      return testMap;
	   }
	
	//현재 날짜
	   public String selectDate() {
	      Connection con = getConnection();
	      
	      String sysdate = new F_MemberDao().selectDate(con);
	      
	      close(con);
	      
	      return sysdate;
	   }
	   
	   //회원 비율 이력
	public MemberStats getMemberStats(String year, String month) {
		Connection con = getConnection();
		
		MemberStats member = new F_MemberDao().getMemberStats(con, year, month);
		
		close(con);
		
		return member;
	}
	
	//년 월 로 찾는 회원 리스트
	public List<StatsMemberList> selectStatsMemberList(PageInfo pi, String year, String month) {
		Connection con = getConnection();
		
		List<StatsMemberList> list = new F_MemberDao().selectStatsMemberList(con, pi, year, month);

		close(con);
		
		return list;
	}
	public int getStatsMemberListCount(String year, String month) {
		Connection con = getConnection();
		
		int result = new F_MemberDao().getStatsMemberListCount(con, year, month);
		
		close(con);
		
		return result;
	}
	public HashMap<String, Integer> memberHistoryChart(String year, String month) {
		Connection con = getConnection();
		
		HashMap<String, Integer> history = new F_MemberDao().memberHistoryChart(con, year, month);
		
		close(con);
		
		return history;
	}
	public HashMap<String, Integer> sumOrderChart(String year, String month) {
		Connection con = getConnection();
		
		HashMap<String, Integer> map = new F_MemberDao().sumOrderChart(con, year, month);
		
		close(con);
		
		return map;
	}
	
	public HashMap<String, Integer> countOrderStats(String year, String month) {
		Connection con = getConnection();
		
		HashMap<String, Integer> map = new F_MemberDao().countOrderStats(con, year, month);
		
		close(con);
		
		return map;
	}

}
