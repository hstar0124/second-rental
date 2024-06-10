package com.kh.forest.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.OrderStatus;

/**
 * Servlet implementation class C_userOrderStatusServlet
 */
@WebServlet("/selectOrderList.or")
public class C_userOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_userOrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		
		String userNo = m.getUserNo();
		
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
		
		C_paymentService ps = new C_paymentService();
		int listCount = ps.getListCountUser(userNo);
		
		maxPage = (int)((double) listCount / limit + 0.9);
		
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 + 1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		
		
		
		ArrayList<OrderStatus> list = new C_paymentService().selectListUser(userNo, pi);
		
		
		//--------------------------------------------------------------------------------------------------------------
		
		
		
		int currentPage2;
		int limit2;
		int maxPage2;
		int startPage2;
		int endPage2;
		
		currentPage2 = 1;
		
		if(request.getParameter("currentPage2") != null) {
			currentPage2 = Integer.parseInt(request.getParameter("currentPage2"));
		}
		
		limit2 = 10;
		
		C_paymentService ps2 = new C_paymentService();
		int listCount2 = ps2.getCancelListCountUser(userNo);
		
		maxPage2 = (int)((double) listCount2 / limit2 + 0.9);
		
		startPage2 = (((int)((double) currentPage2 / limit2 + 0.9)) -1) * 10 + 1;
		
		endPage2 = startPage2 + 10 - 1;
		
		if(maxPage2 < endPage2) {
			endPage2 = maxPage2;
		}
		
		PageInfo pi2 = new PageInfo(currentPage2, listCount2, limit2, maxPage2, startPage2, endPage2);
		
		ArrayList<OrderStatus> list2 = new C_paymentService().selectCancelListUser(userNo, pi2);
		
		
		
		
		
		
		
		String page = "";
		if(list != null) {
			page = "views/user/mypage/C_orderStatuse.jsp";
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.setAttribute("PageInfo", pi);
			request.setAttribute("PageInfo2", pi2);
		}else {
			page = "views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "실패!");
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
