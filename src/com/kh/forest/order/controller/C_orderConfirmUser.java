package com.kh.forest.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.OrderHistory;

/**
 * Servlet implementation class C_orderConfirmUser
 */
@WebServlet("/confirm.or")
public class C_orderConfirmUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_orderConfirmUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderCode = request.getParameter("orderCode");
		
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setOrderCode(orderCode);
		orderHistory.setStatus("인수완료");

		int result = new C_paymentService().insertOrderHistory(orderHistory);
		
		String page = "";
		if(result > 0) {
			page = "/forest/selectOrderList.or";
			response.sendRedirect(page);
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
