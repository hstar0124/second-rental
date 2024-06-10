package com.kh.forest.member.model.dao;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.kh.forest.admin.model.vo.Admin;
import com.kh.forest.member.controller.F_MemberCreateServlet;
import com.kh.forest.member.model.vo.BuyDetail;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.MemberHistory;
import com.kh.forest.member.model.vo.MemberStats;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.member.model.vo.Report;
import com.kh.forest.member.model.vo.StatsMemberList;
import com.kh.forest.member.model.vo.WarningHistory;
import com.kh.forest.point.model.vo.CashBack;
import com.kh.forest.point.model.vo.CashbackHistory;
import com.kh.forest.product.model.vo.E_PageInfo;
import com.kh.forest.product.model.vo.Rental;
import com.kh.forest.wrapper.F_CryptoUtil;

import oracle.net.aso.b;

public class F_MemberDao {
	private Properties prop = new Properties();

	public F_MemberDao() {
		String fileName = F_MemberDao.class.getResource("/sql/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int insertMember(Connection con, Member createMember) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertMember");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, createMember.getUserId());
			pstmt.setString(2, createMember.getUserName());
			pstmt.setString(3, createMember.getPassword());
			pstmt.setString(4, createMember.getBirth());
			pstmt.setString(5, createMember.getGender());
			pstmt.setString(6, createMember.getEmail());
			pstmt.setString(7, createMember.getPhone());
			pstmt.setString(8, createMember.getAddress());
			pstmt.setString(9, createMember.getBank());
			pstmt.setString(10, createMember.getAccountHolder());
			pstmt.setString(11, createMember.getAccount());

			result = pstmt.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}



		return result;
	}

	public Member loginCheck(Connection con, Member requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("loginCheck");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getUserId());
			pstmt.setString(2, requestMember.getPassword());

			rset = pstmt.executeQuery();
			prop1.load(new FileReader(fileName));

			if(rset.next()) {
				loginUser = new Member();

				loginUser.setUserNo(rset.getString("USER_NO"));
				loginUser.setUserId(rset.getString("USER_ID"));
				loginUser.setUserName(rset.getString("USER_NAME"));
				loginUser.setPassword(rset.getString("PASSWORD"));
				loginUser.setBirth(rset.getString("BIRTH"));
				loginUser.setGender(rset.getString("GENDER"));
				loginUser.setEmail(rset.getString("EMAIL"));
				loginUser.setPhone(rset.getString("PHONE"));
				loginUser.setAddress(rset.getString("ADDRESS"));
				loginUser.setBank(rset.getString("BANK"));
				loginUser.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				loginUser.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				loginUser.setPoint(rset.getInt("POINT"));
				loginUser.setWarningCount(rset.getInt("WARNING_COUNT"));
				loginUser.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginUser.setModifyDate(rset.getDate("MODIFY_DATE"));
				loginUser.setStatus(rset.getString("STATUS"));
				loginUser.setLogCount(rset.getInt("LOG_COUNT"));
			}

		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return loginUser;
	}

	public int checkMember(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("idCheck");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String findMemberId(Connection con, Member findMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("findId");
		String findId = "";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, findMember.getUserName());
			pstmt.setString(2, findMember.getEmail());

			rset = pstmt.executeQuery();

			if(rset.next()) {

				findId = rset.getString("USER_ID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return findId;
	}

	public int findPassword(Connection con, Member findPwd) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("findPwd");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, findPwd.getPassword());
			pstmt.setString(2, findPwd.getUserId());
			pstmt.setString(3, findPwd.getEmail());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Member selectOne(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member selectMember = null;
		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			prop1.load(new FileReader(fileName));

			rset = pstmt.executeQuery();

			if(rset.next()) {
				selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));
			}

		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selectMember;
	}

	public List<Member> selectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("selectListWithPaging");

		try {
			int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			prop1.load(new FileReader(fileName));

			list = new ArrayList<Member>();

			while(rset.next()) {
				Member selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));

				list.add(selectMember);
			}


		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Member checkPwd(Connection con, Member checkMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member okMember = null;
		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("loginCheck");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, checkMember.getUserId());
			pstmt.setString(2, checkMember.getPassword());

			rset = pstmt.executeQuery();
			prop1.load(new FileReader(fileName));

			if(rset.next()) {
				okMember = new Member();

				okMember.setUserNo(rset.getString("USER_NO"));
				okMember.setUserId(rset.getString("USER_ID"));
				okMember.setUserName(rset.getString("USER_NAME"));
				okMember.setPassword(rset.getString("PASSWORD"));
				okMember.setBirth(rset.getString("BIRTH"));
				okMember.setGender(rset.getString("GENDER"));
				okMember.setEmail(rset.getString("EMAIL"));
				okMember.setPhone(rset.getString("PHONE"));
				okMember.setAddress(rset.getString("ADDRESS"));
				okMember.setBank(rset.getString("BANK"));
				okMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				okMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				okMember.setPoint(rset.getInt("POINT"));
				okMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				okMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				okMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				okMember.setStatus(rset.getString("STATUS"));
				okMember.setLogCount(rset.getInt("LOG_COUNT"));
			}

		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return okMember;
	}

	public int getListCount(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("listCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "탈퇴");
			pstmt.setString(2, "제제");

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public int updateMember(Connection con, Member updateMember) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, updateMember.getPhone());
			pstmt.setString(2, updateMember.getPassword());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setString(4, updateMember.getAddress());
			pstmt.setString(5, updateMember.getBank());
			pstmt.setString(6, updateMember.getAccount());
			pstmt.setString(7, updateMember.getUserNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<Member> searchUserName(Connection con, PageInfo pi, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("searchUserName");

		try {
			int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, search);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			prop1.load(new FileReader(fileName));

			list = new ArrayList<Member>();

			while(rset.next()) {
				Member selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));

				list.add(selectMember);
			}


		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int getSearchUserNameCount(Connection con, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("userNameCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, search);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public List<Member> searchUserId(Connection con, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("searchUserId");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, search);

			rset = pstmt.executeQuery();

			prop1.load(new FileReader(fileName));

			list = new ArrayList<Member>();

			while(rset.next()) {
				Member selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));

				list.add(selectMember);
			}


		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Member> searchUserNo(Connection con, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("searchUserNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(search));

			rset = pstmt.executeQuery();

			prop1.load(new FileReader(fileName));

			list = new ArrayList<Member>();

			while(rset.next()) {
				Member selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));

				list.add(selectMember);
			}


		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Member checkId(Connection con, Member requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member selectMember = null;
		String query = prop.getProperty("checkId");
		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getUserId());
			prop1.load(new FileReader(fileName));
			rset = pstmt.executeQuery();

			if(rset.next()) {
				selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));
			}
		} catch (SQLException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException | IOException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selectMember;
	}

	public int loginCount(Connection con, Member selectMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("loginCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, selectMember.getLogCount()+1);
			pstmt.setString(2, selectMember.getUserId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int resetLoginCount(Connection con, Member selectMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("loginCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, selectMember.getUserId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateStatus(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("loginFalse");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getUserNo());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertMemberHistory(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertHistory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "로그인실패");
			pstmt.setString(2, m.getUserNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<MemberHistory> historySelectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<MemberHistory> list = null;

		String query = prop.getProperty("historyListWithPaging");

		int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();


			list = new ArrayList<MemberHistory>();

			while(rset.next()) {
				MemberHistory m = new MemberHistory();
				m.setHistoryNo(rset.getString("HISTORY_NO"));
				m.setStatus(rset.getString("STATUS"));
				m.setModifyDate(rset.getString("DAY"));
				m.setUserNo(rset.getString("USER_NO"));
				m.setUserName(rset.getString("USER_NAME"));

				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int gethistoryCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("historyAllCount");

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
	//채팅용 전체 조회 메소드
	public List<Member> selectAll(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		List<Member> list = null;

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("chatSelectAll");

		try {

			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			prop1.load(new FileReader(fileName));

			list = new ArrayList<Member>();

			while(rset.next()) {
				Member selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));

				list.add(selectMember);
			}


		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public int memberUpdate(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("loginRestore");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int loginRestoreHistory(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertHistory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "정상");
			pstmt.setString(2, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return  result;
	}

	public int deleteMember(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteHistory(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertHistory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "탈퇴");
			pstmt.setString(2, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return  result;
	}

	public int getDeleteCount(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("deleteListCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "탈퇴");

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

	public List<Member> deleteSelectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("deleteSelectListWithPaging");

		try {
			int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			prop1.load(new FileReader(fileName));

			list = new ArrayList<Member>();

			while(rset.next()) {
				Member selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));

				list.add(selectMember);
			}


		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int deleteMemberUpdate(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("loginRestore");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int memberRestoreHistory(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertHistory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "정상");
			pstmt.setString(2, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return  result;
	}

	public int updatePoint(Connection con, Member m, CashBack cash) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updatePoint");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, m.getPoint() -cash.getCashbackPoint());
			pstmt.setString(2, m.getUserNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getReportCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("reportAllCount");

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

	public List<Report> selectAllReport(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Report> list = null;
		String query = prop.getProperty("selectAllReport");

		try {
			int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;

			list = new ArrayList<Report>();

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while(rset.next()) {
				Report r = new Report();
				r.setReportNo(rset.getString("REPORT_NO"));
				r.setrBorderNo(rset.getString("BOARD_NO"));
				r.setFromUserNo(rset.getString("FROMNO"));
				r.setFromUserName(rset.getString("FROMNAME"));
				r.setToUserNo(rset.getString("TONO"));
				r.setToUserName(rset.getString("TONAME"));
				r.setReportDate(rset.getDate("REPORT_DATE"));
				r.setReason(rset.getString("REASON"));
				r.setStatus(rset.getString("STATUS"));

				list.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Report selectOneReport(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Report selectReport = null;

		String query = prop.getProperty("selectOneReport");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				selectReport = new Report();
				selectReport.setrBorderNo(rset.getString("BOARD_NO"));
				selectReport.setReportNo(rset.getString("REPORT_NO"));
				selectReport.setrTitle(rset.getString("RTITLE"));
				selectReport.setrContent(rset.getString("RCONTENT"));
				selectReport.setFromUserNo(rset.getString("FROMNO"));
				selectReport.setFromUserName(rset.getString("FNAME"));
				selectReport.setToUserNo(rset.getString("TONO"));
				selectReport.setToUserName(rset.getString("TONAME"));
				selectReport.setReason(rset.getString("REASON"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return selectReport;
	}

	public List<Report> selectAllWanring(Connection con, List<String> boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Report> selectWarningReport = null;

		String query = prop.getProperty("selectAllWanring");

		try {
			selectWarningReport = new ArrayList<Report>();

			for(int i = 0; i < boardNo.size(); i++) {

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, boardNo.get(i));

				rset = pstmt.executeQuery();

				if(rset.next()) {
					Report selectReport = new Report();

					selectReport.setrBorderNo(rset.getString("BOARD_NO"));
					selectReport.setReportNo(rset.getString("REPORT_NO"));
					selectReport.setReportDate(rset.getDate("REPORT_DATE"));
					selectReport.setFromUserNo(rset.getString("FROM_USER_NO"));
					selectReport.setToUserNo(rset.getString("TO_USER_NO"));
					selectReport.setrTitle(rset.getString("RTITLE"));
					selectReport.setToUserName(rset.getString("USER_NAME"));
					selectReport.setReason(rset.getString("REASON"));
					selectReport.setStatus(rset.getString("STATUS"));
					selectReport.setEmail(rset.getString("EMAIL"));
					selectReport.setWarningCount(rset.getInt("WARNING_COUNT"));
					
					selectWarningReport.add(selectReport);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return selectWarningReport;
	}


	public List<Member> warningCount(Connection con, List<Report> waringReport) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectWarningCount");
		List<Member> list = null;
		try {
			list = new ArrayList<>();
			for(int i = 0; i < waringReport.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, waringReport.get(i).getToUserNo());

				rset = pstmt.executeQuery();

				if(rset.next()) {
					Member selectMember = new Member();

					selectMember.setUserNo(rset.getString("USER_NO"));
					selectMember.setUserId(rset.getString("USER_ID"));
					selectMember.setUserName(rset.getString("USER_NAME"));
					selectMember.setPassword(rset.getString("PASSWORD"));
					selectMember.setBirth(rset.getString("BIRTH"));
					selectMember.setGender(rset.getString("GENDER"));
					selectMember.setEmail(rset.getString("EMAIL"));
					selectMember.setPhone(rset.getString("PHONE"));
					selectMember.setAddress(rset.getString("ADDRESS"));
					selectMember.setBank(rset.getString("BANK"));
					selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
					selectMember.setPoint(rset.getInt("POINT"));
					selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
					selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
					selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
					selectMember.setStatus(rset.getString("STATUS"));
					selectMember.setLogCount(rset.getInt("LOG_COUNT"));

					list.add(selectMember);
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

	public int updateWarning(Connection con, List<Member> warningCount) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateWaringMemberUpdate");

		try {
			for(int i = 0; i < warningCount.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, warningCount.get(i).getWarningCount()+1);
				pstmt.setString(2, warningCount.get(i).getUserNo());

				result = pstmt.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateReport(Connection con, List<Report> waringReport) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateReportStatus");
		
		try {
			for(int i = 0; i < waringReport.size(); i++) {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "처리완료");
			pstmt.setString(2, waringReport.get(i).getrBorderNo());
			
			result = pstmt.executeUpdate();
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReview(Connection con, List<Report> waringReport) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateReview");
		
		try {
			for(int i = 0; i < waringReport.size(); i++) {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, waringReport.get(i).getrBorderNo());
			
			result = pstmt.executeUpdate();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertWaringHistory(Connection con, List<Report> waringReport, Admin admin) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertWaringHistory");
		
		try {
			for(int i = 0; i < waringReport.size(); i++) {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, waringReport.get(i).getReportNo());
			pstmt.setString(2, waringReport.get(i).getToUserNo());
			pstmt.setString(3, admin.getEmpNo());
			
			result = pstmt.executeUpdate();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getWarningListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("getWarningListCount");

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

	public List<WarningHistory> selectAllWarningHistory(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<WarningHistory> list = null;
		
		String query = prop.getProperty("selectAllWarningHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
		
			list = new ArrayList<>();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				WarningHistory w = new WarningHistory();
				
				w.setWarningNo(rset.getString("WARNING_NO"));
				w.setReportNo(rset.getString("REPORT_NO"));
				w.setUserNo(rset.getString("USER_NO"));
				w.setUserName(rset.getString("USER_NAME"));
				w.setWarningDate(rset.getDate("WARNING_DATE"));
				w.setEmpNo(rset.getString("EMP_NO"));
				w.setEmpId(rset.getString("EMP_ID"));
				
				list.add(w);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int getWarningMemberListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("getWarningMemberListCount");

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

	public List<Member> warningMemberSelectAll(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;

		Properties prop1 = new Properties();
		String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();

		String query = prop.getProperty("warningMemberSelectAll");

		try {
			int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			prop1.load(new FileReader(fileName));

			list = new ArrayList<Member>();

			while(rset.next()) {
				Member selectMember = new Member();

				selectMember.setUserNo(rset.getString("USER_NO"));
				selectMember.setUserId(rset.getString("USER_ID"));
				selectMember.setUserName(rset.getString("USER_NAME"));
				selectMember.setPassword(rset.getString("PASSWORD"));
				selectMember.setBirth(rset.getString("BIRTH"));
				selectMember.setGender(rset.getString("GENDER"));
				selectMember.setEmail(rset.getString("EMAIL"));
				selectMember.setPhone(rset.getString("PHONE"));
				selectMember.setAddress(rset.getString("ADDRESS"));
				selectMember.setBank(rset.getString("BANK"));
				selectMember.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				selectMember.setAccount(F_CryptoUtil.decryptAES256(rset.getString("ACCOUNT"), prop1.getProperty("key1")));
				selectMember.setPoint(rset.getInt("POINT"));
				selectMember.setWarningCount(rset.getInt("WARNING_COUNT"));
				selectMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				selectMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				selectMember.setStatus(rset.getString("STATUS"));
				selectMember.setLogCount(rset.getInt("LOG_COUNT"));

				list.add(selectMember);
			}


		} catch (SQLException | IOException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Member> selectMemberEmail(Connection con, List<String> boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;
		
		String query = prop.getProperty("selectMemberEmail");
		list = new ArrayList<>();
		try {
			for(int i = 0; i < boardNo.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, boardNo.get(i));
				
			
				rset = pstmt.executeQuery();
				if(rset.next()) {
					Member m = new Member();
					m.setEmail(rset.getString("EMAIL"));
					m.setUserNo(rset.getString("USER_NO"));
					m.setUserName(rset.getString("USER_NAME"));
					m.setUserId(rset.getString("USER_ID"));
				
					list.add(m);
				}else {
					list = null;
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

	public int updateBlackMember(Connection con, List<Member> boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBlackMember");
		
		try {
			for(int i = 0; i < boardNo.size(); i++) {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, boardNo.get(i).getUserNo());
			
			result = pstmt.executeUpdate();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertMemberHistory(Connection con, List<Member> boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertHistory");

		try {
			for(int i = 0; i < boardNo.size(); i++) {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "제재");
			pstmt.setString(2, boardNo.get(i).getUserNo());
			result = pstmt.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int reportPass(Connection con, List<String> boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateReportStatus");
		
		try {
			for(int i = 0; i < boardNo.size(); i++) {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "반려");
			pstmt.setString(2, boardNo.get(i));
			
			result = pstmt.executeUpdate();
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int allOrderMoney(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("sumOrderMoney");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, String.valueOf(num));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("orderMoney");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int orderCompleteCount(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query  = prop.getProperty("orderCompleteCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("CON");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int orderCancleCount(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query  = prop.getProperty("orderCancleCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("CON");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int shippingCount(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query  = prop.getProperty("shippingCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("CON");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int getBuyDetailCount(Connection con, Member buyMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("getBuyDetailCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyMember.getUserNo());

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

	public List<BuyDetail> buyDetailSelectOne(Connection con, PageInfo pi, Member buyMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<BuyDetail> list = null;
		
		String query = prop.getProperty("buyDetailSelectOne");
		
		try {
			int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			list = new ArrayList<>();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyMember.getUserNo());
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BuyDetail b = new BuyDetail();
				
				b.setBuyNo(rset.getString("BUY_NO"));
				b.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				b.setUserNo(rset.getString("USER_NO"));
				b.setUserName(rset.getString("USER_NAME"));
				b.setGrade(rset.getString("GRADE"));
				b.setPrice(rset.getString("PRICE"));
				b.setEmpId(rset.getString("EMP_ID"));
				b.setDay(rset.getString("DAY"));
				b.setBuyStatus(rset.getString("BUY_STATUS"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int buyFalseCount(Connection con, Member buyMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("buyFalseCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyMember.getUserNo());

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

	public int buyComCount(Connection con, Member buyMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int listCount = 0;

		String query = prop.getProperty("buyComCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyMember.getUserNo());

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

	public int allBuyMoney(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int buyMoney = 0;

		String query = prop.getProperty("allBuyMoney");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, String.valueOf(num));

			rset = pstmt.executeQuery();

			if(rset.next()) {
				buyMoney = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return buyMoney;
	}

	public int wishListCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int wishListCount = 0;

		String query = prop.getProperty("wishListCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, String.valueOf(num));

			rset = pstmt.executeQuery();

			if(rset.next()) {
				wishListCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return wishListCount;
	}

	public int basketCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int basketCount = 0;

		String query = prop.getProperty("basketCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, String.valueOf(num));

			rset = pstmt.executeQuery();

			if(rset.next()) {
				basketCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return basketCount;
	}

	public int reviewCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int reviewCount = 0;

		String query = prop.getProperty("reviewCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, String.valueOf(num));

			rset = pstmt.executeQuery();

			if(rset.next()) {
				reviewCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return reviewCount;
	}

	public List<Rental> rentalList(Connection con, String num, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("rentalList");

		List<Rental> rentalList = null;

		try {
			pstmt = con.prepareStatement(query);


			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setString(1, num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			System.out.println(num);
			System.out.println(startRow);
			System.out.println(endRow);
			rentalList = new ArrayList<Rental>();
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Rental r  = new Rental();

				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setProductName(rset.getString("PRODUCT_NAME"));
				r.setChangeName(rset.getString("CHANGE_NAME"));
				r.setRentalMonth(rset.getString("RENTAL_MONTH"));
				r.setPrice(rset.getString("PRICE"));
				r.setStartDate(rset.getDate("START_DATE"));
				r.setExpiryDate(rset.getDate("EXPIRY_DATE"));
				r.setRentalStatus(rset.getString("RENTAL_STATUS"));
				r.setOrderStatus(rset.getString("ORDER_STATUS"));
				r.setRecipient(rset.getString("RECIPIENT"));
				r.setPhone(rset.getString("PHONE"));
				r.setAddress(rset.getString("ADDRESS"));
				r.setOrderNo(rset.getString("ORDER_NO"));
				r.setOrderCode(rset.getString("ORDER_CODE"));
				r.setRentalNo(rset.getString("RENTAL_NO"));
				r.setRefundStatus(rset.getString("REFUND_STATUS"));
				rentalList.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return rentalList;
	}

	public int retalListCount(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("countRentalList");
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally {
			close(pstmt);
			close(rset);
		}
		return result;
	}

	   public HashMap<String, Integer> newMemberChart(Connection con, String num) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String query = prop.getProperty("newMemberChart");
	      HashMap<String, Integer> map = null;
	      
	      try {
	         
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, num);
	         pstmt.setString(2, num);
	         pstmt.setString(3, num);
	         pstmt.setString(4, num);
	         pstmt.setString(5, num);
	         pstmt.setString(6, num);
	         pstmt.setString(7, num);
	         pstmt.setString(8, num);
	         pstmt.setString(9, num);
	         pstmt.setString(10, num);
	         pstmt.setString(11, num);
	         pstmt.setString(12, num);
	         rset = pstmt.executeQuery();
	         
	         map = new HashMap<>();
	         while(rset.next()) {
	            map.put("Jan", rset.getInt("JAN"));
	            map.put("Feb", rset.getInt("FEB"));
	            map.put("Mar", rset.getInt("MAR"));
	            map.put("Apr", rset.getInt("APR"));
	            map.put("May", rset.getInt("MAY"));
	            map.put("Jun", rset.getInt("JUN"));
	            map.put("Jul", rset.getInt("JUL"));
	            map.put("Aug", rset.getInt("AUG"));
	            map.put("Sep", rset.getInt("SEP"));
	            map.put("Oct", rset.getInt("OCT"));
	            map.put("Nov", rset.getInt("NOV"));
	            map.put("Dec", rset.getInt("DEC"));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      
	      
	      return map;
	   }

	   public String selectDate(Connection con) {
	      Statement stmt = null;
	      String sysdate = null;
	      ResultSet rset = null;
	      
	      String query = prop.getProperty("selectDate");
	      
	      try {
	         stmt = con.createStatement();
	         
	         rset = stmt.executeQuery(query);
	         
	         if(rset.next()) {
	            sysdate = rset.getString("day");
	         }
	      
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(stmt);
	      }
	      
	      return sysdate;
	   }

	public MemberStats getMemberStats(Connection con, String year, String month) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberStats member = null;
		
		String query = prop.getProperty("memberStats");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, month);
			pstmt.setString(2, year);
			pstmt.setString(3, month);
			pstmt.setString(4, year);
			pstmt.setString(5, month);
			pstmt.setString(6, year);
			pstmt.setString(7, month);
			pstmt.setString(8, year);
			pstmt.setString(9, month);
			pstmt.setString(10, year);
			pstmt.setString(11, month);
			pstmt.setString(12, year);
			pstmt.setString(13, month);
			pstmt.setString(14, year);
			pstmt.setString(15, month);
			pstmt.setString(16, year);
			pstmt.setString(17, month);
			pstmt.setString(18, year);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new MemberStats();
				
				member.setNewMember(rset.getInt("NEWMEMBER"));
				member.setMenCount(rset.getInt("MEN"));
				member.setWomenCount(rset.getInt("WOMEN"));
				member.setOne(rset.getInt("ONE"));
				member.setTwo(rset.getInt("TWO"));
				member.setThree(rset.getInt("THREE"));
				member.setFour(rset.getInt("FOUR"));
				member.setFive(rset.getInt("FIVE"));
				member.setSix(rset.getInt("SIX"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int getStatsMemberListCount(Connection con, String year, String month) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		int result= 0;
		
		String query = prop.getProperty("getStatsMemberListCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, month);
			pstmt.setString(2, year);
			
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

	public List<StatsMemberList> selectStatsMemberList(Connection con, PageInfo pi, String year, String month) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<StatsMemberList> list = null;
		
		String query = prop.getProperty("selectStatsMemberList");
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow =  (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			System.out.println(startRow);
			System.out.println(endRow);
			pstmt.setString(1, month);
			pstmt.setString(2, year);
		    pstmt.setInt(3, startRow);
		    pstmt.setInt(4, endRow);
			
			list = new ArrayList<>();
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				StatsMemberList s = new StatsMemberList();
				s.setEnrollDate(rset.getString("DAY"));
				s.setUserId(rset.getString("USER_ID"));
				s.setGender(rset.getString("GENDER"));
				s.setAge(rset.getString("AGE"));
				
				list.add(s);
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public HashMap<String, Integer> memberHistoryChart(Connection con, String year, String month) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Integer> map = null;
		
		String query = prop.getProperty("memberHistoryChart");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, month);
			pstmt.setString(2, year);
			pstmt.setString(3, month);
			pstmt.setString(4, year);
			pstmt.setString(5, month);
			pstmt.setString(6, year);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				map = new HashMap<>();
				
				map.put("login", rset.getInt("LOGIN"));
				map.put("delete", rset.getInt("OUT"));
				map.put("warning", rset.getInt("WARNING"));
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return map;
	}

	public HashMap<String, Integer> sumOrderChart(Connection con, String year, String month) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Integer> map = null;
		
		String query = prop.getProperty("sumOrderChart");
		
		try {
			
			pstmt = con.prepareStatement(query);
			 pstmt.setString(1, year);
	         pstmt.setString(2, year);
	         pstmt.setString(3, year);
	         pstmt.setString(4, year);
	         pstmt.setString(5, year);
	         pstmt.setString(6, year);
	         pstmt.setString(7, year);
	         pstmt.setString(8, year);
	         pstmt.setString(9, year);
	         pstmt.setString(10, year);
	         pstmt.setString(11, year);
	         pstmt.setString(12, year);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
					map = new HashMap<>();
				
				    map.put("Jan", rset.getInt("ONE"));
		            map.put("Feb", rset.getInt("TWO"));
		            map.put("Mar", rset.getInt("THREE"));
		            map.put("Apr", rset.getInt("FOUR"));
		            map.put("May", rset.getInt("FIVE"));
		            map.put("Jun", rset.getInt("SIX"));
		            map.put("Jul", rset.getInt("SEVEN"));
		            map.put("Aug", rset.getInt("EIGHT"));
		            map.put("Sep", rset.getInt("NINE"));
		            map.put("Oct", rset.getInt("TEN"));
		            map.put("Nov", rset.getInt("ELEVEN"));
		            map.put("Dec", rset.getInt("TEELVE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return map;
	}

	public HashMap<String, Integer> countOrderStats(Connection con, String year, String month) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Integer> map = null;
		
		String query = prop.getProperty("countOrderStats");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, month);
			pstmt.setString(2, year);
			pstmt.setString(3, month);
			pstmt.setString(4, year);
			pstmt.setString(5, month);
			pstmt.setString(6, year);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				map = new HashMap<>();
				
				map.put("order", rset.getInt("ORD"));
				map.put("pay", rset.getInt("PAY"));
				map.put("refund", rset.getInt("REFUND"));
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return map;
	}

}
