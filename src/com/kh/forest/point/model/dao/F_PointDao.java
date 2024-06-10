package com.kh.forest.point.model.dao;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.kh.forest.member.controller.F_MemberCreateServlet;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.point.model.vo.CashBack;
import com.kh.forest.point.model.vo.CashbackHistory;
import com.kh.forest.point.model.vo.Point;
import com.kh.forest.point.model.vo.Reason;
import com.kh.forest.wrapper.F_CryptoUtil;

public class F_PointDao {
	private Properties prop = new Properties();

	public F_PointDao() {
		String fileName = F_PointDao.class.getResource("/sql/point/point-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Point> selectOneAll(Connection con, PageInfo pi, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Point> list = null;
		String query = prop.getProperty("selectOnePaging");
		int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			list = new ArrayList<Point>();

			rset = pstmt.executeQuery();

			while(rset.next()) {
				Point p = new Point();

				p.setPointNo(rset.getString("POINT_HISTORY_NO"));
				p.setPoint(rset.getInt("CHANGE_POINT"));
				p.setPointDate(rset.getDate("POINT_HISTORY_DATE"));
				p.setUseNo(rset.getString("번호"));
				p.setUserName(rset.getString("이름"));
				p.setStatus(rset.getString("STATUS"));

				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int getListOneCount(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("listOneCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public int getListOneCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("listCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public List<Point> selectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Point> list = null;
		String query = prop.getProperty("selectAll");
		int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			list = new ArrayList<Point>();

			rset = pstmt.executeQuery();

			while(rset.next()) {
				Point p = new Point();

				p.setPointNo(rset.getString("POINT_HISTORY_NO"));
				p.setPoint(rset.getInt("CHANGE_POINT"));
				p.setDetailDate(rset.getString("DAY"));
				p.setUseNo(rset.getString("번호"));
				p.setUserName(rset.getString("이름"));
				p.setUserNo(rset.getString("USER_NO"));
				p.setStatus(rset.getString("STATUS"));

				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int sumUsePoint(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int usePoint=0;

		String query = prop.getProperty("sumUsePoint");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				usePoint = rset.getInt("useSum"); 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return usePoint;
	}

	public int sumCashBackProPoint(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int cashBackProPoint=0;

		String query = prop.getProperty("cashBackProPointSum");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				cashBackProPoint = rset.getInt("useSum"); 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return cashBackProPoint;
	}

	public int sumCashBackPoint(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int cashBackPoint=0;

		String query = prop.getProperty("cashBackPointSum");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				cashBackPoint = rset.getInt("useSum"); 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return cashBackPoint;
	}

	public int sumRefundPoint(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int refundPoint = 0;

		String query = prop.getProperty("refundPointSum");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				refundPoint = rset.getInt("useSum"); 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return refundPoint;
	}

	public int sumBuyPoint(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int buyPoint = 0;

		String query = prop.getProperty("buyPointSum");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				buyPoint = rset.getInt("useSum"); 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return buyPoint;
	}

	public int insertCashback(Connection con, Member m, String usePoint, String cashbackMoney) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertCashback");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(usePoint));
			pstmt.setString(2, m.getUserNo());
			pstmt.setInt(3, Integer.parseInt(cashbackMoney));

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public CashBack selectOneCashbackHistory(Connection con, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CashBack cash = null;
		String query = prop.getProperty("selectCashbackNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getUserNo());

			rset = pstmt.executeQuery();

			if(rset.next()) {
				cash = new CashBack();
				cash.setCashbackNo(rset.getString("CASHBACK_NO"));
				cash.setCashbackPoint(rset.getInt("CASHBACK_POINT"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return cash;
	}

	public int insertCashbackHistory(Connection con, CashBack cash) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCashbackHistory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cash.getCashbackNo());
			pstmt.setString(2, "처리대기중");
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertPointHistory(Connection con, CashBack cash, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCashbackPointHistory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cash.getCashbackPoint());
			pstmt.setString(2, cash.getCashbackNo());
			pstmt.setString(3, m.getUserNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getcashbackWaitListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("getcashbackWaitListCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public List<CashbackHistory> cashBackWaitSelectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("cashbackWaitPaging");

		int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			list = new ArrayList<CashbackHistory>();
			rset = pstmt.executeQuery();

			while(rset.next()) {
				CashbackHistory c = new CashbackHistory();
				c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
				c.setCashbackNo(rset.getString("CASHBACK_NO"));
				c.setStatus(rset.getString("STATUS"));
				c.setCashbackDate(rset.getString("DAY"));
				c.setUserNo(rset.getString("USER_NO"));
				c.setUserName(rset.getString("USER_NAME"));
				c.setMoney(rset.getInt("MONEY"));

				list.add(c);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int getcashbackListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("getcashbackListCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public List<CashbackHistory> cashBackSelectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("cashbackPaging");

		int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			list = new ArrayList<CashbackHistory>();
			rset = pstmt.executeQuery();

			while(rset.next()) {
				CashbackHistory c = new CashbackHistory();
				c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
				c.setCashbackNo(rset.getString("CASHBACK_NO"));
				c.setStatus(rset.getString("STATUS"));
				c.setCashbackDate(rset.getString("DAY"));
				c.setUserNo(rset.getString("USER_NO"));
				c.setUserName(rset.getString("USER_NAME"));
				c.setMoney(rset.getInt("MONEY"));

				list.add(c);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<CashbackHistory> cashBackAllExel(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("cashbackExel");

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();


		try {
			stmt = con.createStatement();

			list = new ArrayList<CashbackHistory>();
			prop1.load(new FileReader(fileName));

			rset = stmt.executeQuery(query);


			while(rset.next()) {
				CashbackHistory c = new CashbackHistory();
				c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
				c.setCashbackNo(rset.getString("CASHBACK_NO"));
				c.setStatus(rset.getString("STATUS"));
				c.setCashbackDate(rset.getString("DAY"));
				c.setUserNo(rset.getString("USER_NO"));
				c.setUserName(rset.getString("USER_NAME"));
				c.setBankName(rset.getString("BANK"));
				c.setPrintCount(rset.getInt("PRINT_COUNT"));
				c.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				c.setMoney(rset.getInt("MONEY"));

				list.add(c);
			}

		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public int printUpdate(Connection con, List<CashbackHistory> waitList) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("printUpdate");
		int result = 0;
		try {

			for(int i = 0; i<waitList.size(); i++) {

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, waitList.get(i).getPrintCount()+1);
				pstmt.setString(2, waitList.get(i).getUserNo());

				result = pstmt.executeUpdate();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertPrintHistory(Connection con, List<CashbackHistory> waitList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCashbackHistory");

		try {
			for(int i = 0; i<waitList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, waitList.get(i).getCashbackNo());
				pstmt.setString(2, "처리중");

				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getcashbackProListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("getcashbackProListCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public List<CashbackHistory> cashBackProSelectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("cashbackProPaging");

		int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			list = new ArrayList<CashbackHistory>();
			rset = pstmt.executeQuery();

			while(rset.next()) {
				CashbackHistory c = new CashbackHistory();
				c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
				c.setCashbackNo(rset.getString("CASHBACK_NO"));
				c.setStatus(rset.getString("STATUS"));
				c.setCashbackDate(rset.getString("DAY"));
				c.setUserNo(rset.getString("USER_NO"));
				c.setUserName(rset.getString("USER_NAME"));
				c.setMoney(rset.getInt("MONEY"));
				c.setPrintCount(rset.getInt("PRINT_COUNT"));

				list.add(c);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<CashbackHistory> cashBackProSelectAll(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("cashbackProSelectAll");
		try {
			pstmt = con.prepareStatement(query);

			list = new ArrayList<CashbackHistory>();
			rset = pstmt.executeQuery();

			while(rset.next()) {
				CashbackHistory c = new CashbackHistory();
				c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
				c.setCashbackNo(rset.getString("CASHBACK_NO"));
				c.setStatus(rset.getString("STATUS"));
				c.setCashbackDate(rset.getString("DAY"));
				c.setUserNo(rset.getString("USER_NO"));
				c.setUserName(rset.getString("USER_NAME"));
				c.setMoney(rset.getInt("MONEY"));
				c.setPrintCount(rset.getInt("PRINT_COUNT"));

				list.add(c);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int comInsertHistory(Connection con, List<CashbackHistory> proList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCashbackHistory");

		try {
			for(int i = 0; i<proList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, proList.get(i).getCashbackNo());
				pstmt.setString(2, "처리완료");

				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int pointHistoryUpdate(Connection con, List<CashbackHistory> proList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateCashbackPointUpdate");

		try {
			for(int i = 0; i<proList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "환급완료");
				pstmt.setString(2, proList.get(i).getCashbackNo());

				result = pstmt.executeUpdate();
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<CashbackHistory> selectMemberPrint(Connection con, List<String> cashbackNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("selectMemberPrint");

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();


		try {
			list = new ArrayList<CashbackHistory>();
			for(int i = 0; i < cashbackNo.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, cashbackNo.get(i));

				prop1.load(new FileReader(fileName));

				rset = pstmt.executeQuery();

				if(rset.next()) {
					CashbackHistory c = new CashbackHistory();
					c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
					c.setCashbackNo(rset.getString("CASHBACK_NO"));
					c.setStatus(rset.getString("STATUS"));
					c.setCashbackDate(rset.getString("DAY"));
					c.setUserNo(rset.getString("USER_NO"));
					c.setUserName(rset.getString("USER_NAME"));
					c.setBankName(rset.getString("BANK"));
					c.setPrintCount(rset.getInt("PRINT_COUNT"));
					c.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
					c.setMoney(rset.getInt("MONEY"));

					list.add(c);
				}
			}

		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int memberPrintUpdate(Connection con, List<CashbackHistory> waitList) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("printUpdate");
		int result = 0;
		try {

			for(int i = 0; i<waitList.size(); i++) {

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, waitList.get(i).getPrintCount()+1);
				pstmt.setString(2, waitList.get(i).getUserNo());

				result = pstmt.executeUpdate();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int memberInsertPrintHistory(Connection con, List<CashbackHistory> waitList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCashbackHistory");

		try {
			for(int i = 0; i<waitList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, waitList.get(i).getCashbackNo());
				pstmt.setString(2, "처리중");

				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<CashbackHistory> selectMemberCashbackPro(Connection con, List<String> cashbackNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("selectMemberCashbackPro");

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();


		try {
			list = new ArrayList<CashbackHistory>();
			for(int i = 0; i < cashbackNo.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, cashbackNo.get(i));

				prop1.load(new FileReader(fileName));

				rset = pstmt.executeQuery();

				if(rset.next()) {
					CashbackHistory c = new CashbackHistory();
					c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
					c.setCashbackNo(rset.getString("CASHBACK_NO"));
					c.setStatus(rset.getString("STATUS"));
					c.setCashbackDate(rset.getString("DAY"));
					c.setUserNo(rset.getString("USER_NO"));
					c.setUserName(rset.getString("USER_NAME"));
					c.setBankName(rset.getString("BANK"));
					c.setPrintCount(rset.getInt("PRINT_COUNT"));
					c.setCashbackPoint(rset.getInt("CASHBACK_POINT"));
					c.setMemberPoint(rset.getInt("POINT"));
					c.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
					c.setEmail(rset.getString("EMAIL"));
					c.setMoney(rset.getInt("MONEY"));

					list.add(c);
				}
			}

		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int cancleCashback(Connection con, List<CashbackHistory> proList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCashbackHistory");

		try {
			for(int i = 0; i<proList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, proList.get(i).getCashbackNo());
				pstmt.setString(2, "반려");

				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int pointHistoryCancleUpdate(Connection con, List<CashbackHistory> proList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateCashbackPointUpdate");

		try {
			for(int i = 0; i<proList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "환급취소");
				pstmt.setString(2, proList.get(i).getCashbackNo());

				result = pstmt.executeUpdate();
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getListCashbackCancleOneCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("getcashbackCancleListCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public List<CashbackHistory> cashbackCancleSelectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("cashbackCancleSelectAll");
		int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			list = new ArrayList<CashbackHistory>();
			rset = pstmt.executeQuery();

			while(rset.next()) {
				CashbackHistory c = new CashbackHistory();
				c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
				c.setCashbackNo(rset.getString("CASHBACK_NO"));
				c.setStatus(rset.getString("STATUS"));
				c.setCashbackDate(rset.getString("DAY"));
				c.setUserNo(rset.getString("USER_NO"));
				c.setUserName(rset.getString("USER_NAME"));
				c.setMoney(rset.getInt("MONEY"));
				c.setPrintCount(rset.getInt("PRINT_COUNT"));

				list.add(c);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int reasonInsert(Connection con, List<CashbackHistory> proList, String reason) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertReturnReason");

		try {
			for(int i = 0; i<proList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, proList.get(i).getCashbackHistoryNo());
				pstmt.setString(2, reason);

				result = pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Reason cashbackCancleReason(Connection con, String num) {
		PreparedStatement pstmt = null;
		Reason reason = null;
		ResultSet rset = null;
		String query = prop.getProperty("cashbackCancleReason");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reason = new Reason();
				
				reason.setCashBackHistoryNo(rset.getString("HISTORY_NO"));
				reason.setReason(rset.getString("REASON"));
				reason.setCashbackDate(rset.getDate("CASHBACK_DATE"));
				reason.setPoint(rset.getInt("CASHBACK_POINT"));
				reason.setMoney(rset.getInt("MONEY"));
				reason.setUserId(rset.getString("USER_ID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return reason;
	}

	public List<CashbackHistory> selectNewHistory(Connection con, List<CashbackHistory> proList) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CashbackHistory> list = null;
		String query = prop.getProperty("cashbackCancleSelectOne");
		try {
			list = new ArrayList<CashbackHistory>();
			for(int i=0; i < proList.size(); i++) {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, proList.get(i).getCashbackNo());
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				CashbackHistory c = new CashbackHistory();
				c.setCashbackHistoryNo(rset.getString("CASHBACK_HISTORY_NO"));
				c.setCashbackNo(rset.getString("CASHBACK_NO"));
				c.setStatus(rset.getString("STATUS"));
				c.setCashbackDate(rset.getString("DAY"));
				c.setUserNo(rset.getString("USER_NO"));
				c.setUserName(rset.getString("USER_NAME"));
				c.setMoney(rset.getInt("MONEY"));
				c.setPrintCount(rset.getInt("PRINT_COUNT"));

				list.add(c);
			}
		}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int canclePoint(Connection con, List<CashbackHistory> proList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("canclePoint");
		
		try {
			for(int i =0; i<proList.size(); i++) {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, proList.get(i).getMemberPoint() + proList.get(i).getCashbackPoint());
			pstmt.setString(2, proList.get(i).getUserNo());
			
			result = pstmt.executeUpdate();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectReadCount(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("selectReadCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateCashbackReadCheck(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("updateCashbackReadCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateRefundReadCheck(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("updateRefundReadCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateUseReadCheck(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("updateUseReadCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateBuyReadCheck(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("updateBuyReadCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}



}
