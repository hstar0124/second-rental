package com.kh.forest.notice.model.service;

import static com.kh.forest.common.JDBCTemplate.close;
import static com.kh.forest.common.JDBCTemplate.commit;
import static com.kh.forest.common.JDBCTemplate.getConnection;
import static com.kh.forest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.forest.notice.model.dao.D_NoticeDao;
import com.kh.forest.notice.model.vo.Notice;
import com.kh.forest.notice.model.vo.PageInfo;

public class D_NoticeService {
	//공지사항 목록 조회용 메소드
	public ArrayList<Notice> selectList() {

		Connection con = getConnection();
		
		ArrayList<Notice> list = new D_NoticeDao().selectList(con);
		
		close(con);
		
		return list;
	}
	
	public int insertNotice(Notice notice) {
		Connection con = getConnection();
		
		int result = new D_NoticeDao().insertNotice(con, notice);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}

	//공지사항 상세보기 조회용 메소드
	public Notice selectOne(int noticeNum) {
		
		Connection con = getConnection();
		
		//조회수 용
		int result = 0;
		
		Notice notice = new D_NoticeDao().selecOne(con, noticeNum);
		
		if(notice != null) {
			result = new D_NoticeDao().updateCount(con, noticeNum);
			if(result > 0) {
				commit(con);
				notice.setnCount(notice.getnCount() + 1);
				//System.out.println("service : " + notice);
			}else {
				rollback(con);
			}
		}
		
		close(con);
		
		return notice;
	}
	
	public int updateNotice(Notice notice) {
		Connection con = getConnection();
		
		int result = new D_NoticeDao().updateNotice(con, notice);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}
	
	public int deleteNotice(int deleteNno) {
	
		Connection con = getConnection();
		
		int result = new D_NoticeDao().deleteNotice(con, deleteNno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}
	
	//관리자페이지 공지사항
	public int getListCount() {
		Connection con =  getConnection();
		
		int listCount = new D_NoticeDao().listCount(con);
		
		close(con);
		return listCount;
	}
	
	//마이페이지 메인
	public int getListCountMain() {
		Connection con =  getConnection();
		
		int listCount = new D_NoticeDao().listCount(con);
		
		close(con);
		return listCount;
	}

	public ArrayList<Notice> selectList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Notice> list1 = new D_NoticeDao().selectList(con, pi);
		
		close(con);
				
		
		return list1;
	}
	
	public ArrayList<Notice> selectListMain(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Notice> list1 = new D_NoticeDao().selectListMain(con, pi);
		
		close(con);
				
		
		return list1;
	}

	/*public int AllDeleteNotice(String[] deleteNno) {
		Connection con = getConnection();
		
		int result = 0;
		
		for (int i = 0; i < deleteNno.length; i++) {
			result += new D_
		}
		
		return 0;
	}*/

}
