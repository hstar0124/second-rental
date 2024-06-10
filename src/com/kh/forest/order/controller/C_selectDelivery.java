package com.kh.forest.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.DeliveryHistoryPurchase;

/**
 * Servlet implementation class C_selectDelivery
 */
@WebServlet("/selectDelivery")
public class C_selectDelivery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_selectDelivery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderCode = request.getParameter("orderCode");
	
		DeliveryHistoryPurchase dhp = new C_paymentService().selectWaybillNo(orderCode);
		String page = "";
		
		if(dhp != null) {
			switch(dhp.getCarrierNo()) {
			case "10":dhp.setCarrierNo("01");break;
			case "20":dhp.setCarrierNo("04");break;
			case "30":dhp.setCarrierNo("06");break;
			}
		}
		
		if(dhp != null) {
			page = "views/user/mypage/C_orderStatusDelivery.jsp";
			
			request.setAttribute("dhp", dhp);
			
			request.getRequestDispatcher(page).forward(request, response);
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
