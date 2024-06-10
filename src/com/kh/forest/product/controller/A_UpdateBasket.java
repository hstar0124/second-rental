package com.kh.forest.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.dao.C_paymentDao;
import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.Rental;
import com.kh.forest.product.model.service.A_BasketService;
import com.kh.forest.product.model.vo.A_Basket;

/**
 * Servlet implementation class A_UpdateBasket
 */
@WebServlet("/updateBasket")
public class A_UpdateBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_UpdateBasket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		String selectRentalNo = new A_BasketService().selectRentalNo(rental.getProductNo());
		
		rental.setRentalNo(selectRentalNo);
		
		int result = new A_BasketService().deleteBasket(selectRentalNo);
		
		if(result > 0) {
			String rentalNo = new C_paymentService().insertRental(rental);
			
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
