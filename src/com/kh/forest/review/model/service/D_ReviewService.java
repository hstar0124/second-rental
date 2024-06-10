package com.kh.forest.review.model.service;

import static com.kh.forest.common.JDBCTemplate.close;
import static com.kh.forest.common.JDBCTemplate.commit;
import static com.kh.forest.common.JDBCTemplate.getConnection;
import static com.kh.forest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.forest.member.model.vo.Member;
import com.kh.forest.review.model.dao.D_ReviewDao;
import com.kh.forest.review.model.vo.PageInfo;
import com.kh.forest.review.model.vo.Review;
import com.kh.forest.review.model.vo.Review_Attachment;

public class D_ReviewService {

	public ArrayList<Review> selectList() {
		Connection con = getConnection();
		
		ArrayList<Review> list = new D_ReviewDao().selectList(con);
		
		close(con);
		
		return list;
	}
	
	public ArrayList<Review> selectListUser() {
		Connection con = getConnection();
		
		ArrayList<Review> list = new D_ReviewDao().selectListUser(con);
		
		close(con);
		
		return list;
	}

	public int insertBoard(Review review) {
		Connection con = getConnection();
		
		int result = new D_ReviewDao().insertBoard(con, review);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	//관리자페이지 리뷰게시판
	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new D_ReviewDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}
	
	//유저페이지 리뷰게시판
	public int getListCountUser(String userId) {
		Connection con = getConnection();
		System.out.println("....." + userId);
		int listCount = new D_ReviewDao().getListCountUser(con, userId);
		
		close(con);
		
		return listCount;
	}
	
	//관리자페이지 리뷰게시판
	public ArrayList<Review> selectList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Review> list1 = new D_ReviewDao().selectList(con, pi);
		
		close(con);
		
		return list1;
	}
	
	//유저페이지 리뷰게시판
		public ArrayList<Review> selectListUser(PageInfo pi, String userId) {
			Connection con = getConnection();
			
			ArrayList<Review> list1 = new D_ReviewDao().selectListUser(con, pi, userId);
			
			close(con);
			
			return list1;
		}
	
	
	public int insertThumbnail(Review review, ArrayList<Review_Attachment> fileList) {
		Connection con = getConnection();
		
		int result1 = new D_ReviewDao().insertThumbnailContent(con, review);
		int result2 = 0;
		
		if(result1 > 0) {
			int rBoardNo = new D_ReviewDao().selectCurrval(con);
			System.out.println("rBoardNo : " + rBoardNo);
			if(rBoardNo > 0) {
				for(int i = 0; i < fileList.size(); i++) {
					String rBoardNo2 = Integer.toString(rBoardNo);
					fileList.get(i).setrBoardNo(rBoardNo2);
					result2 += new D_ReviewDao().insertAttachment(con, fileList.get(i));
				}
			}
		}
		
		
		int result = 0;
		if(result1 > 0 && result2 == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		
		close(con);
		
		return result;
	}
	
	public ArrayList<HashMap<String, Object>> selectThumbnailList() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new D_ReviewDao().selectThumbnailList(con);
		
		close(con);
		
		return list;
	}

	public HashMap<String, Object> selectThumbnailMap(int num) {
		Connection con = getConnection();
		
		int result = new D_ReviewDao().updateCount(con, num);
		//System.out.println("result닷(해결) : " + result);
		HashMap<String, Object> hmap = null;
		if(result > 0) {
			commit(con);
			hmap = new D_ReviewDao().selectThumbnailMap(con, num);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return hmap;
	}

	public Review_Attachment selectOneAttachment(int num) {
		Connection con = getConnection();
		
		Review_Attachment file = new D_ReviewDao().selectOneAttachment(con, num);
		
		close(con);
		
		return file;
	}

}
