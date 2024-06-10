package com.kh.forest.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.Rental;
import com.kh.forest.product.model.service.A_BasketService;
import com.kh.forest.product.model.vo.A_Basket;

/**
 * Servlet implementation class A_InsertBasket
 */
@WebServlet("/insertBasket")
public class A_InsertBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_InsertBasket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("insert basket");
		String proNo = request.getParameter("proNo");
		String userNo = request.getParameter("userNo");
		String month = request.getParameter("month");
		String price = request.getParameter("price");
		String takeOver = request.getParameter("takeOver");
		
		//렌탈객체
		Rental rental = new Rental();
		rental.setProductNo(proNo);
		rental.setUserNo(userNo);
		int amount = Integer.parseInt(price.replace(",", "").replace(" ", ""));
		if(month.equals("1")) {
			amount += 20000;
		} else {
			amount *= Integer.parseInt(month);
		}		
			
		rental.setRentalPrice(amount);
		rental.setTakeOver(takeOver);
		rental.setMonth(month);
		
		int result = 0;
		
		//장바구니에 중복된 상품이 있는지 체크(이미 값이 있으면 1이상의 수 반환)
		int checkBasket = new A_BasketService().checkBasket(rental);
		
		if(checkBasket > 0) {
			//장바구니 안에 이미 같은 상품이 있을 경우
			
			result = 0;
			
		} else { 
			//장바구니 안에 값이 없을때만 입력됨

			//System.out.println(rental);
			//렌탈 테이블에 입력 및 렌탈번호 받아오기
			String rentalNo = new C_paymentService().insertRental(rental);
			
			//System.out.println("입력된 rentalNo : " + rentalNo);
			//렌탈번호와 유저번호를 렌탈테이블에 입력
			A_Basket basket = new A_Basket();
			basket.setUserNo(userNo);
			basket.setRentalNo(rentalNo);
			
			result = new A_BasketService().insertBasket(basket);
			
		}
		
		response.getWriter().print(result);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
