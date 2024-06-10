package com.kh.forest.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.forest.chat.model.service.ChattingService;
import com.kh.forest.chat.model.vo.ChatVO;
import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;

/**
 * Servlet implementation class A_ChatListServlet
 */
@WebServlet("/chatList")
public class A_ChatListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_ChatListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//채팅 디비 안에 있는 값을 다 가져온다.
		ArrayList<ChatVO> list = new ChattingService().selectList();
		//System.out.println(list);
		
		int readCount = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getReadCheck() == 1 && !list.get(i).getSender().equals("1")) {
				readCount++;
			}
		}
		
		//채팅을 신청한 유저를 중복없이 담아오기 위해서 set 사용
		Set<String> chatList = new HashSet<>();
		
		for(int i = 0 ; i < list.size(); i++) {
			//1은 가입해둔 관리자 번호다. 관리자번호가 아닐시 set에 담는다.
			if(list.get(i).getSender() != null 
					&& list.get(i).getReceiver() != null) {
				chatList.add(list.get(i).getSender());
				chatList.add(list.get(i).getReceiver());
				chatList.remove("1");
			}			
		}
		
		
		//System.out.println(chatList);
		//멤버정보를 불러오고 유저번호를 이용해서 닉네임을 불러온다.
		//List<Member> memberList = new F_MemberService().selectAll(); 
		
		
		JSONObject userInfo = null;
		JSONArray idArray = new JSONArray();
		
		for(String userNo : chatList) {
			userInfo = new JSONObject();			
			//System.out.println("불러온 채팅 유저번호 : " + userNo);
			
			String nickName = new ChattingService().selectOneNickname(userNo);
			//System.out.println("유저번호 -> 닉네임 : " + nickName);
			
			userInfo.put("userNo", userNo);
			userInfo.put("userName", URLEncoder.encode(nickName, "UTF-8"));
			userInfo.put("readCount", readCount);
			
			idArray.add(userInfo);
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(idArray.toJSONString());
		out.flush();
		out.close();
		
		
		/*//SET 안에 값이 제대로 들어갔는지 확인
		Iterator<String> it = chatList.iterator(); // Iterator(반복자) 생성

		while (it.hasNext()) { 				// hasNext() : 데이터가 있으면 true 없으면 false
			System.out.println("userNo in set : " + it.next()); 	// next() : 다음 데이터 리턴
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
