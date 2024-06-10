package com.kh.forest.buy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyInfo;

/**
 * Servlet implementation class B_selectbuypriceservlet
 */
@WebServlet("/B_selectbuypriceservlet")
public class B_selectbuypriceservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectbuypriceservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String grade = request.getParameter("rank");
		String buyProductNo = request.getParameter("buyProductNo");
		
		BuyInfo buyinfo = new BuyInfo();
		buyinfo.setGrade(grade);
		buyinfo.setBuyProductNo(buyProductNo);
		
		
		int price = new B_buyService().selectBuyPrice(buyinfo);
		
	
		PrintWriter out = response.getWriter();
		out.print(price);
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
