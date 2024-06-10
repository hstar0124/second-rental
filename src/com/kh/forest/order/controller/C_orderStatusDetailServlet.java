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

/**
 * Servlet implementation class C_orderStatusDetailServlet
 */
@WebServlet("/selectDetail.or")
public class C_orderStatusDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_orderStatusDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNo = request.getParameter("orderNo");
		String productNo = request.getParameter("productNo");
		
		ArrayList<OrderStatus> os = new C_paymentService().selectOrderDetail(orderNo, productNo);
		
		String page = "";
		
		if(os != null) {
			page = "views/admin/orderManagement/C_orderStatusDetail.jsp";
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
