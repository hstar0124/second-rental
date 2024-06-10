package com.kh.forest.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.DefaultInfo;

/**
 * Servlet implementation class E_DefaultInfoUpdateServlet
 */
@WebServlet("/updateDefaultInfo")
public class E_DefaultInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_DefaultInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeInfo = request.getParameter("noticeInfo");
		String deliveryInfo = request.getParameter("deliveryInfo");
		
		DefaultInfo requestInfo = new DefaultInfo();
		
		requestInfo.setDeliveryInfo(deliveryInfo);
		requestInfo.setNoticeInfo(noticeInfo);
		
		int result = new E_ProductService().updateDefaultInfo(requestInfo);
		
		String page = "";
		if(result>0) {
			page = "selectDefaultInfo";
		}else {
			page = "views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "기본정보 업데이트 실패!");
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
