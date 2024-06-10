package com.kh.forest.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.Purchase;
import com.kh.forest.order.model.vo.RentalHistory;
import com.kh.forest.product.model.vo.Product;

/**
 * Servlet implementation class C_updateRentalHistory
 */
@WebServlet("/updateRental.col")
public class C_updateRentalHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_updateRentalHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rentalNo = request.getParameter("rentalNo");
	
		String[] code = rentalNo.split(",");
		
		
		int result = 0;
		for(int i = 0; i < code.length; i++) {
			RentalHistory rentalHistory = new RentalHistory();
			rentalHistory.setStatus("회수완료");
			rentalHistory.setRentalNo(code[i]);
			Purchase p = new C_paymentService().selectPurchase(code[i]);
			
			Product pr = new Product();
			pr.setRentalStatus("N");
			pr.setProductNo(p.getProductNo());
			
			result = new C_paymentService().insertRentalHistory(rentalHistory);
			
			int result2 = new C_paymentService().updateProduct(pr);
			
			result += result;
		}
		
		String page = "";
		if(result >0) {
			page = "/collRental";
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
