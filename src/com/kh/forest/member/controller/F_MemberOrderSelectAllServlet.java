package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.OrderStatus;

/**
 * Servlet implementation class F_MemberOrderSelectAllServlet
 */
@WebServlet("/orderList.me")
public class F_MemberOrderSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberOrderSelectAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String point = request.getParameter("userPoint");
		
		Member orderMember = new Member();
		orderMember.setUserNo(num);
		orderMember.setUserName(userName);
		orderMember.setUserId(userId);
		orderMember.setPoint(Integer.parseInt(point));
		
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
		int listCount = ps.getListCountUser(orderMember.getUserNo());
		
		maxPage = (int)((double) listCount / limit + 0.9);
		
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 + 1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<OrderStatus> list = new C_paymentService().selectListUser(orderMember.getUserNo(), pi);
		int orderComplete = new F_MemberService().orderCompleteCount(orderMember.getUserNo());
		int orderCancle = new F_MemberService().orderCancleCount(orderMember.getUserNo());
		int shipping = new F_MemberService().shippingCount(orderMember.getUserNo());
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("orderComplete", orderComplete);
			request.setAttribute("orderCancle", orderCancle);
			request.setAttribute("shipping", shipping);
			request.setAttribute("member", orderMember);
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/admin/memberManagement/F_memberDetailOrderList.jsp").forward(request, response);
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
