package com.kh.forest.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.DeliveryHistoryPurchase;
import com.kh.forest.order.model.vo.OrderHistory;

/**
 * Servlet implementation class C_deliveryCancel
 */
@WebServlet("/complete.de")
public class C_deliveryComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_deliveryComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderCode = request.getParameter("orderCode");
		String num = request.getParameter("num");
		String company = request.getParameter("companySe");
		String wayBillNo = request.getParameter("waybillNo");
		
		String[] code = orderCode.split(",");
		
		String deStatus = "";
		String orStatus = "";
		
		
		OrderHistory orderHistory = new OrderHistory();
		DeliveryHistoryPurchase dhp = new DeliveryHistoryPurchase();
		
		if(num.equals("0")) {
			deStatus = "배송완료";
			orStatus = "배송완료";
		}else if(num.equals("1")){
			deStatus = "배송중";
			orStatus = "배송중";
		}else if(num.equals("2")) {
			deStatus = "배송대기중";
			orStatus = "상품준비중";
		}
		
		int result = 0;
		if(num.equals("2")) {
			orderHistory.setStatus(orStatus);
			dhp.setWaybillNo(wayBillNo);
			dhp.setCarrierNo(company);
			dhp.setStatus(deStatus);
			for(int i = 0; i < code.length; i++) {
				orderHistory.setOrderCode(code[i]);
				dhp.setOrderCode(code[i]);
				
				result = new C_paymentService().updateDelivery(dhp, orderHistory);
			}
		}else {
			for(int i = 0; i < code.length; i++) {
				DeliveryHistoryPurchase dh = new C_paymentService().selectWaybillNo(code[i]);
				
				orderHistory.setOrderCode(code[i]);
				orderHistory.setStatus(orStatus);
				
				dhp.setOrderCode(code[i]);
				dhp.setStatus(deStatus);
				dhp.setWaybillNo(dh.getWaybillNo());
				dhp.setCarrierNo(dh.getCarrierNo());
				
				result = new C_paymentService().updateDelivery(dhp, orderHistory);
			}
			
		}
		
		
		
	
		String page = "";
		if(result > 0) {
			page = "/select.pur";
			request.getRequestDispatcher(page).forward(request, response);
		
		}else {
			System.out.println("배송완료 처리실패ㅎ");
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
