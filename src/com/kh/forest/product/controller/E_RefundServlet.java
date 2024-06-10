package com.kh.forest.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.service.E_ProductService;

/**
 * Servlet implementation class E_RefundServlet
 */
@WebServlet("/refund")
public class E_RefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_RefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reason = request.getParameter("reason");
		String orderCode = request.getParameter("orderCode");
		int result = 0;
		
		result = new E_ProductService().refund(reason, orderCode);
		
		String page="";
		if(result>0) {
			page="views/user/mypage/E_Refund.jsp";
			response.sendRedirect(page);
		}else {
			request.setAttribute("msg", "환불신청 실패!");
			page=request.getContextPath()+"/views/admin/common/E_errorPage.jsp";
			request.getRequestDispatcher(page);
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
