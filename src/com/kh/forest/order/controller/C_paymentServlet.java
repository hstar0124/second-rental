package com.kh.forest.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.order.model.service.C_paymentService;
import com.kh.forest.order.model.vo.Rental;

/**
 * Servlet implementation class C_paymentServlet
 */
@WebServlet("/payment.or")
public class C_paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_paymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productNo = request.getParameter("productNo");
		String productName = request.getParameter("productName");
		String rentalNo = request.getParameter("rentalNo");
		String month = request.getParameter("month");
		String rentalPrice = "";
		rentalPrice = request.getParameter("price");
		int price = 0;
		System.out.println(rentalPrice);
		
		if(rentalPrice != null) {
			String reRentalPrice = rentalPrice.replace(",", "");
			reRentalPrice = reRentalPrice.replace(" ", "");
			price = Integer.parseInt(reRentalPrice);
		}
		
		String[] rentalNo1 = null;
		if(rentalNo != null) {
			rentalNo1 = rentalNo.split(",");
		}
		int num = Integer.parseInt(request.getParameter("num"));
		String takeOver="N";
		
		
		if(month != null) {
			switch(month) {
			case "1" : price += 20000; break;
			case "2" : price = price * 2; break;
			case "3" : price = price * 3; break;
			case "6" : price = price * 6; break;
			default : price = price * Integer.parseInt(month); takeOver="Y"; break;
			}
		}
		
		/*if(num == 2) {
			price = price * Integer.parseInt(month);
		}*/
		
		ArrayList<Rental> list = new ArrayList<>();
		if(num == 3) {
			for(int i = 0; i < rentalNo1.length; i++) {
				Rental rental = new C_paymentService().selectRentalBasket(rentalNo1[i]);
				list.add(rental);
				price += rental.getRentalPrice();
				System.out.println(list.get(i));
			}
		}
		
		
		String division = "상품등록사진";
		String attachment = new C_paymentService().selectAttachment(productNo, division);
		
		
		request.setAttribute("productNo", productNo);
		request.setAttribute("month", month);
		request.setAttribute("price", price);
		request.setAttribute("num", num);
		request.setAttribute("takeOver", takeOver);
		request.setAttribute("productName", productName);
		request.setAttribute("rentalNo", rentalNo);
		request.setAttribute("attachment", attachment);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/user/product/C_orderPage.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
