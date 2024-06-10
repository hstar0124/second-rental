package com.kh.forest.buy.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyInfo;
import com.kh.forest.member.model.vo.Member;

/**
 * Servlet implementation class B_checkListServlet
 */
@WebServlet("/checkList.ck")
public class B_checkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_checkListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션 선언
		HttpSession session = request.getSession();
		//유저세션
		Member loginMember = (Member) session.getAttribute("loginMember");
		String userNo = loginMember.getUserNo();
		//System.out.println(userNo);
		
		//점수
		//String sum = request.getParameter("score");
		
		int score = Integer.parseInt(request.getParameter("score"));
		//System.out.println("score: " + score);
		//총 550이상이면 S
		//450 ~ 550미만 A
		//450 미만 B
		String grade = "";
		
		if(score < 450) {
			grade = "B";
		} else if (score >= 450 && score < 550) {
			grade = "A";
		} else if (score >= 550) {
			grade = "S";
		}
		//System.out.println("grade: " + grade);		
		
		
		//유저 체크리스트값
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		String answer4 = request.getParameter("answer4");
		String answer5 = request.getParameter("answer5");
		String answer6 = request.getParameter("answer6");
		
		HashMap<String, String> exampleMap = new HashMap<String, String>();
		
		exampleMap.put("1", answer1);
		exampleMap.put("2", answer2);
		exampleMap.put("3", answer3);
		exampleMap.put("4", answer4);
		exampleMap.put("5", answer5);
		exampleMap.put("6", answer6);
		
		//System.out.println(exampleMap);
		//세션에 유저 체크리스트값 담기
		session.setAttribute("exampleMap", exampleMap);
		//session.setAttribute("buyProductNo", buyProductNo);
		
		//int result = new B_buyService().insertUserCheckList(exampleMap, userNo);
		
		//세이프키 발급
		String safeKey = "";
		String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for(int i = 0 ; i < 5; i++) {
			safeKey += possible.charAt((int) Math.floor(Math.random() * possible.length()));
		}
		//System.out.println("세이프키서블릿: " + safeKey);
		
		request.setAttribute("grade", grade);
		request.setAttribute("safeKey", safeKey);
		request.setAttribute("exampleMap", exampleMap);
		//request.setAttribute("buyProductNo", buyProductNo);
		request.getRequestDispatcher("views/user/buy/B_insertPhoto.jsp").forward(request, response);
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
