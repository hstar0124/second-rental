package com.kh.forest.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.OrderStatus;
import com.kh.forest.order.model.vo.Purchase;
import com.kh.forest.order.model.vo.Rental;

/**
 * Servlet implementation class C_collRentalDetail
 */
@WebServlet("/collDetail.re")
public class C_collRentalDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_collRentalDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rentalNo = request.getParameter("rentalNo");
		
		Purchase p = new C_paymentService().selectPurchase(rentalNo);
		
		String orderNo = p.getOrderNo();
		String productNo = p.getProductNo();
		
		ArrayList<OrderStatus> os = new C_paymentService().selectOrderDetail(orderNo, productNo);
		
		String page = "";
		
		if(os != null) {
			page = "views/admin/orderManagement/C_orderCollDetail.jsp";
			request.setAttribute("list", os);
			
		}else {
			page = "views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "상세정보 불러오기 실패!!");
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
