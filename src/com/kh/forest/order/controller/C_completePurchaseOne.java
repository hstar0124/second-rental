package com.kh.forest.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.Purchase;

/**
 * Servlet implementation class C_completePurchaseOne
 */
@WebServlet("/comPur.or")
public class C_completePurchaseOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_completePurchaseOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNo = request.getParameter("orderNo");
		String userNo = request.getParameter("userNo");
		
		Member updateMember = new C_paymentService().updateMemberSelect(userNo);
		
		//
		ArrayList<Purchase> list = new C_paymentService().selectListOrder(orderNo);
		String page = "";
		if(list != null) {
			page = "views/user/product/C_CompleteOrder.jsp";
			//request.setAttribute("list", list);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", updateMember);
			session.setAttribute("orderCompleteList", list);
			response.sendRedirect(page);
			
		}else {
			System.out.println("실패인듯");
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
