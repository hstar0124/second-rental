package com.kh.forest.chat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.chat.model.service.ChattingService;
import com.kh.forest.chat.model.vo.ChatVO;

/**
 * Servlet implementation class A_ChatServlet
 */
@WebServlet("/chat")
public class A_ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String message = request.getParameter("message");
		String date = request.getParameter("date");
				
		ChatVO chatInfo = new ChatVO(sender, receiver, message);
		int result = ChattingService.insertMessage(chatInfo);
		
		//System.out.println("servlet >> " + sender + ":" + message + "|" + date);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
