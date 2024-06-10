package com.kh.forest.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.Refund;
import com.kh.forest.order.model.vo.RentalHistory;
import com.kh.forest.order.model.vo.ReturnReason;
import com.kh.forest.point.model.vo.Point;

/**
 * Servlet implementation class C_insertRefund
 */
@WebServlet("/insertRefund.or")
public class C_insertRefund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_insertRefund() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("refundNo");
		String[] refundNo = code.split(",");
		String num = request.getParameter("num");
		String reason = request.getParameter("reason");
		
		System.out.println("code : " + code);
		System.out.println("num : " + num);
		System.out.println("refundNo : " + refundNo[0]);
		System.out.println("reason : " + reason);
		
		int result = 0;
		if(num.equals("0")) {
			for(int i = 0; i < refundNo.length; i++) {
				Refund refund = new C_paymentService().selectOneRefund(refundNo[i]);
				refund.setRefundNo(refundNo[i]);
				refund.setStatus("환불 처리 완료");
				
				
				int p = refund.getPrice() * refund.getRate() /100;
				
				Point point = new Point();
				point.setPoint(p);
				point.setUserNo(refund.getUserNo());
				point.setStatus("환불 포인트 지급");
				point.setUseNo(refund.getRefundNo());
				
				RentalHistory rentalHistory = new RentalHistory();
				rentalHistory.setStatus("회수완료");
				rentalHistory.setRentalNo(refund.getRentalNo());
				
				result = new C_paymentService().insertRefundConfirm(refund, point, rentalHistory);
				
				
				
			}
		}else {
			for(int i = 0; i < refundNo.length; i++) {
				System.out.println("되나");
				Refund refund = new C_paymentService().selectOneRefund(refundNo[i]);
				refund.setRefundNo(refundNo[i]);
				refund.setStatus("반려");
				
				ReturnReason reReason = new ReturnReason();
				reReason.setDivision("환불");
				reReason.setReturnNo(refundNo[i]);
				reReason.setReason(reason);
				
				result = new C_paymentService().insertRefundCancel(refund, reReason);
				
			}
		}
		
		String page = "";
		if(result > 0) {
			page = "/selectRefund.or";
			
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
