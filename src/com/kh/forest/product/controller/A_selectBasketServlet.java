package com.kh.forest.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.forest.product.model.service.A_BasketService;
import com.kh.forest.product.model.vo.A_Basket;

/**
 * Servlet implementation class A_selectBasketServlet
 */
@WebServlet("/selectBasket")
public class A_selectBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_selectBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo = request.getParameter("userNo");
		//System.out.println("basket : " + userNo);
		
		ArrayList<A_Basket> list = new A_BasketService().selectBasket(userNo);
		//System.out.println(list);
		//rentalNo, productNo, userNo, month, rentalPrice, takeOver, cngName
		
		JSONObject basketInfo = null;
		JSONArray basketArray = new JSONArray();
		
		for(A_Basket b : list) {
			basketInfo = new JSONObject();
			basketInfo.put("rentalNo", b.getRentalNo());
			basketInfo.put("productNo", b.getProductNo());
			basketInfo.put("productName", URLEncoder.encode(b.getProductName(), "UTF-8"));
			basketInfo.put("userNo", b.getUserNo());
			basketInfo.put("month", b.getMonth());
			basketInfo.put("rentalPrice", b.getRentalPrice());
			basketInfo.put("takeOver", b.getTakeOver());
			basketInfo.put("cngName", b.getCngName());
			
			basketArray.add(basketInfo);			
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(basketArray.toJSONString());
		out.flush();
		out.close();			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
