package com.kh.forest.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.Purchase;

/**
 * Servlet implementation class C_calcelPayServlet
 */
@WebServlet("/cancel.or")
public class C_cancelPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_cancelPayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNo = request.getParameter("orderNo");
		System.out.println("취소 주문번호 : " + orderNo);
		String orderCode = request.getParameter("orderCode");
		String number = request.getParameter("number");
		
		//결제코드 조회해오기
		String paymentNo = new C_paymentService().selectPaymentNo(orderNo);
		
		//주문신청코드 조회해오기
		ArrayList<Purchase> purchase = new C_paymentService().selectOrderCode(orderNo);
		
		//토큰 받아오기
		JSONObject json = new JSONObject();
		json.put("imp_key", "5384386914999679");
		json.put("imp_secret", "WPyFOqupNlRacy7jX7fWO0V2i7C2DnLAckf0LJpz5hJiQRBNYRKNRFQaMtcqQY12jg340tD6LnoBe0oc");
		
		String token = "";
		try {
			token = new C_PaymentAPIMethod().getToken(request, response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		int result3 = 0;
		int result4 = 0;
		
		//if(number.equals("1")) {
			//결제취소하기
			String imp_uid = paymentNo;
			
			JSONObject json2 = new JSONObject();
			json2.put("imp_uid", imp_uid);
			
			String result = new C_PaymentAPIMethod().calcelPay(request, response, token, json2, imp_uid);
			
			
			
			//결제취소 성공시 주문현황 업데이트
			if(result.equals("성공")) {
				
				
				/*String code = orderNo;
				result3 = new C_paymentService().updatePurchaseStatus(code);*/
				
				for(Purchase p : purchase) {
					
					result4 = new C_paymentService().insertOrderHistoryCancel(p.getOrderCode());
					if(result4>0) {
						result4 = new C_paymentService().insertCancelPurchase(p);
					}
				}
			}
		//}else {
			
		//}
		String page = "";
		
		if(/*result3 > 0 &&*/ result4 > 0) {
			page = "/forest/selectOrderList.or";
			response.sendRedirect(page);
		}else {
			page = "views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "실패!!");
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
