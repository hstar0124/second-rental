package com.kh.forest.notice.model.dao;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.forest.notice.model.vo.Notice;
import com.kh.forest.notice.model.vo.PageInfo;

public class D_NoticeDao {
	private Properties prop = new Properties();
	
	public D_NoticeDao() {
		String fileName = D_NoticeDao.class.getResource("/sql/notice/D_notice-query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//관리자페이지 공지사항
	public ArrayList<Notice> selectList(Connection con) {
		ArrayList<Notice> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				Notice n = new Notice();
				n.setnBoardNo(rset.getString("NBOARD_NO"));
				n.setnTitle(rset.getString("NTITLE"));
				n.setnWriter(rset.getString("NWRITER"));
				n.setnContent(rset.getString("NCONTENT"));
				n.setnEnrollDate(rset.getDate("NENROLL_DATE"));
				n.setnModifyDate(rset.getDate("NMODIFY_DATE"));
				n.setnStatus(rset.getString("NSTATUS"));
				n.setnCount(rset.getInt("NCOUNT"));
				
				list.add(n);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}
	
	public int insertNotice(Connection con, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, notice.getnTitle());
			//pstmt.setString(2, notice.getnWriter());
			pstmt.setString(2, notice.getnContent());
			
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Notice selecOne(Connection con, int noticeNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNum);
			//pstmt.setInt(2, noticeNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setnBoardNo(rset.getString("NBOARD_NO"));
				notice.setnTitle(rset.getString("NTITLE"));
				notice.setnWriter(rset.getString("NWRITER"));
				notice.setnContent(rset.getString("NCONTENT"));
				notice.setnEnrollDate(rset.getDate("NENROLL_DATE"));
				notice.setnModifyDate(rset.getDate("NMODIFY_DATE"));
				notice.setnStatus(rset.getString("NSTATUS"));
				notice.setnCount(rset.getInt("NCOUNT"));
				
				//System.out.println("notice : " + notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return notice;
	}

	public int updateCount(Connection con, int noticeNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNum);
			pstmt.setInt(2, noticeNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public int updateNotice(Connection con, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateNotice");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, notice.getnTitle());
			pstmt.setString(2, notice.getnContent());
			pstmt.setString(3, notice.getnBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}

	public int deleteNotice(Connection con, int deleteNno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, deleteNno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	public int listCount(Connection con) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		
		return listCount;
	}
	
	public int listCountMain(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("listCountMain");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		
		return listCount;
	}

	public ArrayList<Notice> selectList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list1 = null;
		
		String query = prop.getProperty("selectListWithPaging");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
				
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list1 = new ArrayList<>();
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setnBoardNo(rset.getString("NBOARD_NO"));
				n.setnTitle(rset.getString("NTITLE"));
				n.setnContent(rset.getString("NCONTENT"));
				n.setnCount(rset.getInt("NCOUNT"));
				n.setnEnrollDate(rset.getDate("NENROLL_DATE"));
				
				list1.add(n);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list1;
	}
	
	public ArrayList<Notice> selectListMain(Connection con, PageInfo pi) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list1 = null;
		
		String query = prop.getProperty("selectListWithPagingMain");
		
		try {
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list1 = new ArrayList<>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setnBoardNo(rset.getString("NBOARD_NO"));
				n.setnTitle(rset.getString("NTITLE"));
				n.setnContent(rset.getString("NCONTENT"));
				n.setnCount(rset.getInt("NCOUNT"));
				n.setnEnrollDate(rset.getDate("NENROLL_DATE"));
				
				list1.add(n);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list1;
		
	}
}
