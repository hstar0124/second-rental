package com.kh.forest.buy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyInfo;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;


/**
 * Servlet implementation class B_mypageBuyListSelectServlet
 */
@WebServlet("/mypageBuylist.buy")
public class B_mypageBuyListSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_mypageBuyListSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		String userNo = loginMember.getUserNo();
		
		
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		
		limit = 10;
		
		B_buyService bs = new B_buyService();
		int listCount = bs.getListCount(userNo);
		
		//System.out.println("마이페이지카운트: " + listCount);
		
		maxPage = (int) ((double) listCount / limit + 0.9);
		
		startPage = (((int) ((double) currentPage / limit + 0.9)) - 1 ) * 10  + 1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		
		ArrayList<BuyInfo> list = new B_buyService().selectBuyList(pi, userNo);
		
		String page = "";
		if(list != null) {
			page = "views/user/mypage/B_mypageBuyCurrent.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("loginMember", loginMember);
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "마이페이지리스트출력못함!");
			
		}
		request.getRequestDispatcher(page).forward(request, response);
		
		
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
