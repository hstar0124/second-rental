package com.kh.forest.chat.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Set;

import com.kh.forest.chat.model.dao.ChatDAO;
import com.kh.forest.chat.model.vo.ChatVO;
import com.kh.forest.member.model.vo.Member;

import static com.kh.forest.common.JDBCTemplate.*;

public class ChattingService {

	public static int insertMessage(ChatVO chatInfo) {
		Connection con = getConnection();
		
		int result = new ChatDAO().insertMessage(con,chatInfo);
		
		if(result > 0) {
			System.out.println("DB 입력 성공");
			commit(con);
		} else {
			System.out.println("DB 입력 실패");
			rollback(con);
		}		
		close(con);
		
		return result;
	}

	public ArrayList<ChatVO> selectList() {
		Connection con = getConnection();
		
		ArrayList<ChatVO> list = new ChatDAO().selectList(con);
		
		close(con);
		
		return list;
	}

	public ArrayList<ChatVO> selectOne(String userId) {
		Connection con = getConnection();
		
		ArrayList<ChatVO> list = new ChatDAO().selectOne(con, userId);
		int result = 0;
		//읽음 체크 업데이트
		if(list != null) {
			result = new ChatDAO().updateReadcheck(con,userId);			
		}		
		
		close(con);
		
		return list;
	}

	public String selectOneNickname(String userNo) {
		Connection con = getConnection();
		
		String nickName = new ChatDAO().selectOneNickname(con, userNo);
		
		close(con);
		
		return nickName;
	}



}
