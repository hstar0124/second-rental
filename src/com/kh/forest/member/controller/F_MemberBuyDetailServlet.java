package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.BuyDetail;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;

import oracle.net.aso.b;

/**
 * Servlet implementation class F_MemberBuyDetailServlet
 */
@WebServlet("/memberBuySelectAll.me")
public class F_MemberBuyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberBuyDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		String num = request.getParameter("num");
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String point = request.getParameter("userPoint");
		
		Member buyMember = new Member();
		buyMember.setUserNo(num);
		buyMember.setUserName(userName);
		buyMember.setUserId(userId);
		buyMember.setPoint(Integer.parseInt(point));
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		limit = 10;
		
		F_MemberService ns = new F_MemberService();
		int listCount = ns.getBuyDetailCount(buyMember);
		

		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 +1;
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		List<BuyDetail> list = new F_MemberService().buyDetailSelectOne(pi, buyMember);
		int buyFalse = new F_MemberService().buyFalseCount(buyMember);
		int butCom = new F_MemberService().buyComCount(buyMember);
		
		if(list != null) {
			request.setAttribute("member", buyMember);
			request.setAttribute("buyFalse", buyFalse);
			request.setAttribute("buyCom", butCom);
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/admin/memberManagement/F_buyDetail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
