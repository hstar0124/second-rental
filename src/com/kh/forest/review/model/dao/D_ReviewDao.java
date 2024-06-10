package com.kh.forest.review.model.dao;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.forest.member.model.vo.Member;
import com.kh.forest.review.model.vo.PageInfo;
import com.kh.forest.review.model.vo.Review;
import com.kh.forest.review.model.vo.Review_Attachment;

public class D_ReviewDao {
	
	private Properties prop = new Properties();
	
	public D_ReviewDao() {
		String fileName = D_ReviewDao.class.getResource("/sql/review/D_review_query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Review> selectList(Connection con) {
		ArrayList<Review> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				Review r = new Review();
				r.setrBoardNo(rset.getString("RBOARD_NO"));
				r.setrTitle(rset.getString("RTITLE"));
				r.setrWriter(rset.getString("RWRITER"));
				r.setrContent(rset.getString("RCONTENT"));
				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setpGrade(rset.getInt("PGRADE"));
				r.setrEnrollDate(rset.getDate("RENROLL_DATE"));
				r.setrModifyDate(rset.getDate("RMODIFY_DATE"));
				r.setrStatus(rset.getString("RSTATUS"));
				r.setrCount(rset.getInt("RCOUNT"));
				r.setRentalNo(rset.getInt("RENTAL_NO"));
				list.add(r);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}
	
	public ArrayList<Review> selectListUser(Connection con) {
		ArrayList<Review> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				Review r = new Review();
				r.setrBoardNo(rset.getString("RBOARD_NO"));
				r.setrTitle(rset.getString("RTITLE"));
				r.setrWriter(rset.getString("RWRITER"));
				r.setrContent(rset.getString("RCONTENT"));
				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setpGrade(rset.getInt("PGRADE"));
				r.setrEnrollDate(rset.getDate("RENROLL_DATE"));
				r.setrModifyDate(rset.getDate("RMODIFY_DATE"));
				r.setrStatus(rset.getString("RSTATUS"));
				r.setrCount(rset.getInt("RCOUNT"));
				r.setRentalNo(rset.getInt("RENTAL_NO"));
				list.add(r);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}
	
	public int insertBoard(Connection con, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, review.getrBoardNo());
			pstmt.setString(2, review.getrTitle());
			pstmt.setString(3, review.getrContent());
			pstmt.setString(4, review.getrWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int getListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int listCount = 0;
		
		String query = prop.getProperty("listCount");
		//System.out.println("query!! : "+query);
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			//System.out.println("rset :" + rset);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}
	
	public int getListCountUser(Connection con, String userId) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		int listCount = 0;
		
		String query = prop.getProperty("listCountUser");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return listCount;
	}

	public ArrayList<Review> selectList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list1 = null;
		
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
				Review r = new Review();
				/*r.setbType(rset.getInt("BTYPE"));
				r.setCategory(rset.getString("CNAME"));
				r.setRefBid(rset.getInt("REF_BID"));*/
			
				r.setrBoardNo(rset.getString("RBOARD_NO"));
				r.setRentalNo(rset.getInt("RENTAL_NO"));
				r.setrWriter(rset.getString("RWRITER"));
				r.setrTitle(rset.getString("RTITLE"));
				r.setrContent(rset.getString("RCONTENT"));
				r.setrCount(rset.getInt("RCOUNT"));
				r.setrEnrollDate(rset.getDate("RENROLL_DATE"));
				//r.setrModifyDate(rset.getDate("MODIFY_DATE"));
				r.setrStatus(rset.getString("RSTATUS"));
				r.setUserId(rset.getString("USER_ID"));
				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setProductName(rset.getString("PRODUCT_NAME"));
				
				list1.add(r);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list1;
	}
	
	public ArrayList<Review> selectListUser(Connection con, PageInfo pi, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list1 = null;
		
		String query = prop.getProperty("selectListWithPagingUser");
		
		try {
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list1 = new ArrayList<>();
			
			while(rset.next()) {
				Review r = new Review();
				/*r.setbType(rset.getInt("BTYPE"));
				r.setCategory(rset.getString("CNAME"));
				r.setRefBid(rset.getInt("REF_BID"));*/
			
				r.setrBoardNo(rset.getString("RBOARD_NO"));
				r.setRentalNo(rset.getInt("RENTAL_NO"));
				r.setrWriter(rset.getString("RWRITER"));
				r.setrTitle(rset.getString("RTITLE"));
				r.setrContent(rset.getString("RCONTENT"));
				r.setrCount(rset.getInt("RCOUNT"));
				r.setrEnrollDate(rset.getDate("RENROLL_DATE"));
				//r.setrModifyDate(rset.getDate("MODIFY_DATE"));
				r.setrStatus(rset.getString("RSTATUS"));
				r.setUserId(rset.getString("USER_ID"));
				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setProductName(rset.getString("PRODUCT_NAME"));
				
				list1.add(r);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list1;
	}
	
	public int insertThumbnailContent(Connection con, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertThumb");
		
		try {
			pstmt = con.prepareStatement(query);
			//pstmt.setString(1, review.getrBoardNo());
			pstmt.setString(1, review.getrTitle());
			pstmt.setString(2, review.getrWriter());
			pstmt.setString(3, review.getrContent());
			pstmt.setString(4, review.getProductNo());
			//pstmt.setInt(6, review.getpGrade());
			//pstmt.setDate(7, review.getrEnrollDate());
			//pstmt.setDate(8, review.getrModifyDate());
			//pstmt.setString(9, review.getrStatus());
			//pstmt.setInt(10, review.getrCount());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int reviewAttachmentNo = 0;
		
		String query = prop.getProperty("selectCurrval");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				reviewAttachmentNo = rset.getInt("currval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return reviewAttachmentNo;
	}

	public int insertAttachment(Connection con, Review_Attachment attachment) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			//pstmt.setString(1, attachment.getReviewAttachmentNo());
			pstmt.setString(1, attachment.getOriginName());
			pstmt.setString(2, attachment.getChangeName());
			pstmt.setString(3, attachment.getSavePath());
			pstmt.setInt(4, attachment.getReviewLevel());
			pstmt.setString(5, attachment.getrBoardNo());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<HashMap<String, Object>> selectThumbnailList(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectThumbnailMap");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				hmap.put("rBoardNo", rset.getString("RBOARD_NO"));
				hmap.put("rTitle", rset.getString("RTITLE"));
				hmap.put("rWriter", rset.getString("RWRITER"));
				hmap.put("rContent", rset.getString("RCONTENT"));
				hmap.put("rCount", rset.getInt("RCOUNT"));
				hmap.put("rEnrollDate", rset.getDate("RENROLL_DATE"));
				hmap.put("reviewAttachmentNo", rset.getInt("REVIEW_ATTACHMENT_NO"));
				hmap.put("originName", rset.getString("ORIGIN_NAME"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));
				hmap.put("savePath", rset.getString("SAVE_PATH"));
				
				list.add(hmap);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int updateCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public HashMap<String, Object> selectThumbnailMap(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		Review r = null;
		ArrayList<Review_Attachment> list = null;
		Review_Attachment at = null;
		
		String query = prop.getProperty("selectThumbnailOne");
		
		try {
			System.out.println("num(해결) : "  + num);
			pstmt = con.prepareStatement(query);
			//pstmt = con.prepareStatement("select * from member");
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			System.out.println("rset : " + rset);
			hmap = new HashMap<String, Object>();
			list = new ArrayList<Review_Attachment>();
			
			while(rset.next()) {
				r = new Review();
				r.setrBoardNo(rset.getString("RBOARD_NO"));
				r.setrWriter(rset.getString("RWRITER"));
				r.setrTitle(rset.getString("RTITLE"));
				r.setrContent(rset.getString("RCONTENT"));
				r.setrCount(rset.getInt("RCOUNT"));
				r.setrEnrollDate(rset.getDate("RENROLL_DATE"));
				
				at = new Review_Attachment();
				at.setReviewAttachmentNo(rset.getString("REVIEW_ATTACHMENT_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setSavePath(rset.getString("SAVE_PATH"));
				
				list.add(at);
				
				//System.out.println("리뷰 다오 셀렉트온 LIST : " + list);
			}
			
			hmap.put("review", r);
			hmap.put("fileList", list);
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hmap;
	}

	public Review_Attachment selectOneAttachment(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Review_Attachment file = null;
		
		String query = prop.getProperty("selectOneAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				file = new Review_Attachment();
				file.setReviewAttachmentNo(rset.getString("REVIEW_ATTACHMENT_NO"));
				file.setOriginName(rset.getString("ORIGIN_NAME"));
				file.setChangeName(rset.getString("CHANGE_NAME"));
				file.setSavePath(rset.getString("SAVE_PATH"));
				file.setReviewLevel(rset.getInt("REVIEW_LEVEL"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return file;
	}

}
