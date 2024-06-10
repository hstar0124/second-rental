package com.kh.forest.point.model.service;

import static com.kh.forest.common.JDBCTemplate.close;
import static com.kh.forest.common.JDBCTemplate.commit;
import static com.kh.forest.common.JDBCTemplate.getConnection;
import static com.kh.forest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.forest.member.model.dao.F_MemberDao;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.point.model.dao.F_PointDao;
import com.kh.forest.point.model.vo.CashBack;
import com.kh.forest.point.model.vo.CashbackHistory;
import com.kh.forest.point.model.vo.Point;
import com.kh.forest.point.model.vo.Reason;

public class F_PointService {

	public List<Point> selectOneAll(PageInfo pi, String num) {
		Connection con = getConnection();

		List<Point> list = new F_PointDao().selectOneAll(con, pi, num);

		close(con);

		return list;
	}

	public int getListOneCount(String num) {
		Connection con = getConnection();

		int result = new F_PointDao().getListOneCount(con, num);

		close(con);

		return result;
	}

	public int getListOneCount() {
		Connection con = getConnection();

		int result = new F_PointDao().getListOneCount(con);

		close(con);

		return result;
	}

	public List<Point> selectAll(PageInfo pi) {
		Connection con = getConnection();

		List<Point> list = new F_PointDao().selectAll(con, pi);

		close(con);

		return list;
	}

	public int sumUsePoint(String num) {
		Connection con = getConnection();

		int result = new F_PointDao().sumUsePoint(con, num);

		close(con);

		return result;
	}

	public int sumCashBackProPoint(String num) {
		Connection con = getConnection();

		int result = new F_PointDao().sumCashBackProPoint(con, num);

		close(con);

		return result;
	}

	public int sumCashBackPoint(String num) {
		Connection con = getConnection();

		int result = new F_PointDao().sumCashBackPoint(con, num);

		close(con);

		return result;
	}

	public int sumRefundPoint(String num) {
		Connection con = getConnection();

		int result = new F_PointDao().sumRefundPoint(con, num);

		close(con);

		return result;
	}

	public int sumBuyPoint(String num) {
		Connection con = getConnection();

		int result = new F_PointDao().sumBuyPoint(con, num);

		close(con);

		return result;
	}

	public int insertCashback(Member m, String usePoint, String cashbackMoney) {
		Connection con = getConnection();

		int result = new F_PointDao().insertCashback(con, m, usePoint, cashbackMoney);

		if(result > 0) {
			commit(con);
			CashBack cash = new F_PointDao().selectOneCashbackHistory(con, m);
			if(cash != null) {
				int result1 = new F_PointDao().insertCashbackHistory(con, cash);
				if(result1 > 0) {
					commit(con);
					int result2 = new F_PointDao().insertPointHistory(con, cash, m);
					if(result2 >0) {
						commit(con);
						int result3 = new F_MemberDao().updatePoint(con, m, cash);
						if(result3 > 0) {
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
			}
		}else {
			rollback(con);
		}

		close(con);

		return result;
	}

	public List<CashbackHistory> cashBackWaitSelectAll(PageInfo pi) {
		Connection con = getConnection();

		List<CashbackHistory> list = new F_PointDao().cashBackWaitSelectAll(con, pi);

		close(con);

		return list;
	}

	public int getcashbackWaitListCount() {
		Connection con = getConnection();

		int result = new F_PointDao().getcashbackWaitListCount(con);

		close(con);

		return result;
	}

	public int getcashbackListCount() {
		Connection con = getConnection();

		int result = new F_PointDao().getcashbackListCount(con);

		close(con);

		return result;
	}

	public List<CashbackHistory> cashBackSelectAll(PageInfo pi) {
		Connection con = getConnection();

		List<CashbackHistory> list = new F_PointDao().cashBackSelectAll(con, pi);

		close(con);

		return list;
	}

	public List<CashbackHistory> cashBackExel() {
		Connection con = getConnection();

		List<CashbackHistory> list = new F_PointDao().cashBackAllExel(con);

		close(con);

		return list;
	}

	public int printUpdate(List<CashbackHistory> waitList) {
		Connection con = getConnection();
		commit(con);
		int result = new F_PointDao().printUpdate(con, waitList);

		if(result >0) {
			commit(con);
			int result1 = new F_PointDao().insertPrintHistory(con, waitList);
			if(result1 >0) {
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

	public int getcashbackProListCount() {
		Connection con = getConnection();

		int result = new F_PointDao().getcashbackProListCount(con);

		close(con);

		return result;
	}

	public List<CashbackHistory> cashBackProSelectAll(PageInfo pi) {
		Connection con = getConnection();

		List<CashbackHistory> list = new F_PointDao().cashBackProSelectAll(con, pi);

		close(con);

		return list;
	}

	public List<CashbackHistory> selectAllProList() {
		Connection con = getConnection();

		List<CashbackHistory> list = new F_PointDao().cashBackProSelectAll(con);

		close(con);

		return list;
	}

	public int comInsertHistory(List<CashbackHistory> proList) {
		Connection con = getConnection();

		int result = new F_PointDao().comInsertHistory(con, proList);
		if(result > 0) {
			commit(con);
			int result1 = new F_PointDao().pointHistoryUpdate(con, proList);
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

	public int memberPrint(List<CashbackHistory> waitList) {
		Connection con = getConnection();
		commit(con);
		int result = new F_PointDao().memberPrintUpdate(con, waitList);

		if(result >0) {
			commit(con);
			int result1 = new F_PointDao().memberInsertPrintHistory(con, waitList);
			if(result1 >0) {
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

	public List<CashbackHistory> selectMemberPrint(List<String> cashbackNo) {
		Connection con = getConnection();

		List<CashbackHistory> list = new F_PointDao().selectMemberPrint(con, cashbackNo);

		close(con);

		return list;
	}

	public List<CashbackHistory> selectMemberCashbackPro(List<String> cashbackNo) {
		Connection con = getConnection();

		List<CashbackHistory> list = new F_PointDao().selectMemberCashbackPro(con, cashbackNo);

		close(con);

		return list;
	}

	public int cancleCashback(List<CashbackHistory> proList, String reason) {
		Connection con = getConnection();

		int result = new F_PointDao().cancleCashback(con, proList);
		int result2 = 0;
		if(result > 0){
			commit(con);
			List<CashbackHistory> historyNo = new F_PointDao().selectNewHistory(con, proList);


			int result1 = new F_PointDao().pointHistoryCancleUpdate(con, historyNo);
			if(result1 > 0) {
				commit(con);
				result2 = new F_PointDao().reasonInsert(con, historyNo, reason);
				if(result2>0) {
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

		close(con);

		return result2;
	}

	public int getListCashbackCancleOneCount() {
		Connection con = getConnection();

		int result = new F_PointDao().getListCashbackCancleOneCount(con);

		close(con);

		return result;
	}

	public List<CashbackHistory> cashbackCancleSelectAll(PageInfo pi) {
		Connection con = getConnection();

		List<CashbackHistory> list = new F_PointDao().cashbackCancleSelectAll(con, pi);

		close(con);

		return list;
	}

	public Reason cashbackCancleReason(String num) {
		Connection con = getConnection();

		Reason reason = new F_PointDao().cashbackCancleReason(con, num);

		return reason;
	}

	public int canclePoint(List<CashbackHistory> proList) {
		Connection con = getConnection();

		int result = new F_PointDao().canclePoint(con, proList);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		return result;
	}

	public int selectReadCount(String userNo) {
		Connection con  = getConnection();

		int result = new F_PointDao().selectReadCount(con, userNo);

		close(con);

		return result;
	}

	public int updateReadCheck(String userNo) {
		Connection con = getConnection();

		int result = new F_PointDao().updateCashbackReadCheck(con, userNo);
		int result1 = new F_PointDao().updateRefundReadCheck(con, userNo);
		int result2 = new F_PointDao().updateUseReadCheck(con, userNo);
		int result3 = new F_PointDao().updateBuyReadCheck(con, userNo);
		
		commit(con);


		return result;
	}

}
