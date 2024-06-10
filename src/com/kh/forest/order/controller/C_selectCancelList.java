package com.kh.forest.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.OrderStatus;

/**
 * Servlet implementation class C_selectCancelList
 */
@WebServlet("/selectCancel.or")
public class C_selectCancelList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_selectCancelList() {
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
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		limit = 10;
		
		C_paymentService ps = new C_paymentService();
		int listCount = ps.getCancelListCount();
		System.out.println(">>>" + listCount);
		
		maxPage = (int)((double) listCount / limit + 0.9);
		
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 + 1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<OrderStatus> list = new C_paymentService().selectCancelList(pi);
		
		String page = "";
		if(list != null) {
			page = "views/admin/orderManagement/C_orderCancel.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			request.getRequestDispatcher(page).forward(request, response);
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
