package com.kh.forest.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.forest.chat.model.service.ChattingService;
import com.kh.forest.chat.model.vo.ChatVO;

/**
 * Servlet implementation class selectChatHistoryServlet
 */
@WebServlet("/selectChatHistory")
public class A_SelectChatHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_SelectChatHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		//System.out.println("채팅히스토리 서블릿 불림, userId : " + userId);
		
		//클릭된 유저 id를 이용해서 디비에 접근한다.
		ArrayList<ChatVO> list = new ChattingService().selectOne(userId);
		//System.out.println("불러온 채팅 히스토리" + list);
		
		JSONObject result = new JSONObject();
		JSONObject userInfo = null;
		JSONArray userArray = new JSONArray();
				
		for(ChatVO user : list) {
			if(user != null) {
				userInfo = new JSONObject();
				userInfo.put("sender", user.getSender());
				userInfo.put("receiver", user.getReceiver());
				userInfo.put("readCheck", user.getReadCheck());
				userInfo.put("message", URLEncoder.encode(user.getMessage(),"UTF-8"));
				userInfo.put("date", user.getDate());
				
				userArray.add(userInfo);
			}
		}
		
		result.put("list", userArray);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result.toJSONString());
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
