package com.kh.forest.chat.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.kh.forest.chat.model.vo.ChatVO;
import com.kh.forest.member.model.vo.Member;
import com.sun.corba.se.spi.orbutil.fsm.State;
import com.sun.xml.internal.ws.resources.ProviderApiMessages;

import static com.kh.forest.common.JDBCTemplate.*;

public class ChatDAO {
	
	private Properties prop = new Properties();
	
	public ChatDAO() {
		String fileName = ChatDAO.class.getResource("/sql/chat/chat-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMessage(Connection con, ChatVO chatInfo) {
		
		PreparedStatement pstmt = null;
		int result = 0;

		/*CHAT_NO
		MASSAGE
		SEND_TIME
		READ_CHECK
		EMP_NO
		USER_NO*/
		//SEQ_CHAT_NO.NEXTVAL, ?, SYSDATE, DEFAULT, ?, ?
		String query = prop.getProperty("insertMessage");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, chatInfo.getMessage());
			pstmt.setString(2, chatInfo.getSender());
			pstmt.setString(3, chatInfo.getReceiver());
									
			if(chatInfo.getReceiver() == null || chatInfo.getSender() == null) {
				result = 0;
			} else {
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<ChatVO> selectList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<ChatVO> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			list = new ArrayList<>();
			
			while(rset.next()) {
				ChatVO c = new ChatVO();
				
				c.setChatNo(rset.getString("CHAT_NO"));
				c.setMessage(rset.getString("MESSAGE"));
				c.setDate(rset.getString("SEND_TIME"));
				c.setReadCheck(rset.getInt("READ_CHECK"));
				c.setSender(rset.getString("SENDER"));
				c.setReceiver(rset.getString("RECEIVER"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}		
		
		return list;
	}

	public ArrayList<ChatVO> selectOne(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ChatVO> list = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			//보내거나 받는 사람이 userId
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				ChatVO c = new ChatVO();
				
				c.setChatNo(rset.getString("CHAT_NO"));
				c.setMessage(rset.getString("MESSAGE"));
				
				c.setDate(rset.getString("SEND_TIME"));
				
				c.setReadCheck(rset.getInt("READ_CHECK"));
				c.setSender(rset.getString("SENDER"));
				c.setReceiver(rset.getString("RECEIVER"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return list;
	}

	public String selectOneNickname(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String userNickname = null;
		String query = prop.getProperty("selectOneNickname");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userNickname = rset.getString("USER_NAME");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
						
		return userNickname;
	}

	public int updateReadcheck(Connection con, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateReadcheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

}
