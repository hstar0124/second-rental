package com.kh.forest.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.OrderHistory;
import com.kh.forest.order.model.vo.Payment;
import com.kh.forest.order.model.vo.ProductHistory;
import com.kh.forest.order.model.vo.Purchase;
import com.kh.forest.order.model.vo.Rental;
import com.kh.forest.order.model.vo.RentalHistory;
import com.kh.forest.point.model.vo.Point;
import com.kh.forest.product.model.vo.Product;

/**
 * Servlet implementation class paymentCompleteServlet
 */
@WebServlet("/payments/complete")
public class C_paymentCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_paymentCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imp_uid = request.getParameter("imp_uid");
		String orderNo = request.getParameter("merchant_uid");
		String paid_amount = request.getParameter("paid_amount");
		String userNo = request.getParameter("buyer_id");
		String apply_num = request.getParameter("apply_num");
		String usePointSt = request.getParameter("use_point");
		String status = request.getParameter("status");
		String paid_at = request.getParameter("paid_at");
		String recipient = request.getParameter("buyer_name");
		String buyerPhone = request.getParameter("buyer_tel");
		String buyerAddr = request.getParameter("buyer_addr");
		String buyerPostCode = request.getParameter("buyer_postcode");
		String productNo = request.getParameter("productNo");
		String month = request.getParameter("month");
		String takeOver = request.getParameter("takeOver");
		String num = request.getParameter("number");
		String rentalNo = request.getParameter("rentalNo");
		String rentalPrice = request.getParameter("rentalPrice");
		
		System.out.println(productNo);
		System.out.println(month);
		System.out.println(rentalNo);
		
		String[] productNoArray = productNo.split(",");
		String[] monthArray = month.split(",");
		String[] rentalNoArray = rentalNo.split(",");
		String[] rentalPriceArray = rentalPrice.split(",");
		
		System.out.println("productNoArray1 : " + productNoArray[0]);
		System.out.println("monthArray1 : " + monthArray[0]);
		System.out.println("rentalNoArray1 : " + rentalNoArray[0]);
		
		int amount = Integer.parseInt(paid_amount);
		int usePoint = Integer.parseInt(usePointSt);
		
		String address = buyerPostCode + "$" + buyerAddr;
		
		if(status.equals("paid")) {
			status = "결제완료";
		}
		
		
		//렌탈객체
		Rental rental = new Rental();
		rental.setProductNo(productNo);
		rental.setUserNo(userNo);
		rental.setRentalPrice(amount);
		rental.setTakeOver(takeOver);
		rental.setMonth(month);
		
		int result6 = 0;
		if(num.equals("1")) {
		//렌탈신청 and 렌탈번호 불러오기  --첫주문일때
			rentalNoArray[0] = new C_paymentService().insertRental(rental);
		}else if(num.equals("2")) {
			//연장하기
			rental.setRentalNo(rentalNo);
			result6 = new C_paymentService().updateRental(rental);
		}else {
			//장바구니일때 렌탈 테이블 업데이트
			for(int i = 0; i < rentalNoArray.length; i++) {
				rental.setMonth(monthArray[i]);
				rental.setRentalNo(rentalNoArray[i]);
				
				result6 = new C_paymentService().updateRentalBascket(rental);
			}
		}
		
		//상품상태이력 객체
		ProductHistory productHistory = new ProductHistory();
		productHistory.setProductNo(productNo);
		productHistory.setProductStatus("렌탈중");
		
		//렌탈상태 객채
		RentalHistory rentalHistory = new RentalHistory();
		rentalHistory.setRentalNo(rentalNo);
		rentalHistory.setStatus("렌탈중");
		
		if(num.equals("1") || num.equals("3")) {		//첫주문시에만 insert
			for(int i = 0; i < rentalNoArray.length; i++) {
				productHistory.setProductNo(productNoArray[i]);
				rentalHistory.setRentalNo(rentalNoArray[i]);
				//상품상태이력관리
				int result5 = new C_paymentService().insertRentalHistory(rentalHistory);
				
				//렌탈상태이력
				int result7= new C_paymentService().insertProductHistory(productHistory);
				
				Product p = new Product();
				p.setProductNo(productNoArray[i]);
				p.setRentalStatus("Y");
				
				//렌탈 시 상품테이블에 렌탈중이라고 업데이트
				int result8 = new C_paymentService().updateProduct(p);
			}
		}
		
		
		int result2 = 0;
		for(int i = 0; i < rentalNoArray.length; i++) {
			//주문
			Purchase purchase = new Purchase();
			purchase.setOrderNo(orderNo);
			purchase.setRentalNo(rentalNoArray[i]);	//------------렌탈 insert후 받아와야함
			purchase.setUserNo(userNo);
			purchase.setUsePoint(usePoint);
			purchase.setRentalMonth(monthArray[i]);
			purchase.setProductNo(productNoArray[i]);
			purchase.setBuyerAddress(address);
			purchase.setBuyerPhone(buyerPhone);
			purchase.setRecipient(recipient);
			purchase.setPrice(amount);
			
			if(num.equals("3")) {
				purchase.setPrice(Integer.parseInt(rentalPriceArray[i]));
			}
			//주문
			result2 = new C_paymentService().insertPurchase(purchase);
		}
		
		//결제
		Payment payment = new Payment();
		payment.setPaymentNo(imp_uid);
		payment.setUserNo(userNo);
		payment.setOrderNo(orderNo);
		payment.setPrice(amount);
		payment.setConfirmNo(apply_num);
		payment.setEnrollDate(paid_at);
		
		
		
		Point point = new Point();
		point.setPoint(usePoint);
		point.setUserNo(userNo);
		point.setStatus("주문 포인트 사용");
		point.setUseNo(orderNo);
		
	
		
		
		//결제
		int result = new C_paymentService().insertPayment(payment);
	
		//주문신청코드 조회해오기
		ArrayList<Purchase> orderCode = new C_paymentService().selectOrderCode(orderNo);
		
		//포인트 이력
		if(usePoint > 0) {
			int result4 = new C_paymentService().insertPointHistory(point);
		}
		
		int result3 = 0;
		//주문상태이력
		if(num.equals("1")||num.equals("3")) {
			for(Purchase p : orderCode) {
				
				OrderHistory orderHistory = new OrderHistory();
				orderHistory.setOrderCode(p.getOrderCode());
				orderHistory.setStatus(status);
				orderHistory.setOrderDate(paid_at);
				
				result3 = new C_paymentService().insertOrderHistory(orderHistory);
				System.out.println("result3 : " + result3);
				
			}
		}else {
			for(Purchase p : orderCode) {
				
				OrderHistory orderHistory = new OrderHistory();
				orderHistory.setOrderCode(p.getOrderCode());
				orderHistory.setStatus("인수완료");
				orderHistory.setOrderDate(paid_at);
				
				result3 = new C_paymentService().insertOrderHistory(orderHistory);
				System.out.println("result3 : " + result3);
				
			}
			
		}
		
		if(num.equals("3")) {
			for(int i = 0; i < rentalNoArray.length; i++) {
				result3 = new C_paymentService().deleteBasket(userNo, rentalNoArray[i]);
			}
		}
		
		String page = "";
		if(result > 0 && result2>0 && result3>0) {
			System.out.println("성공?");
			//page = "/forest/views/user/product/C_CompleteOrder.jsp";
			
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
