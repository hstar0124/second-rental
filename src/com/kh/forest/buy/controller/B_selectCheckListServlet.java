package com.kh.forest.buy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.buy.model.vo.BuyProduct;

/**
 * Servlet implementation class B_selectCheckListServlet
 */
@WebServlet("/select.ck")
public class B_selectCheckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectCheckListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryNo = request.getParameter("categoryNo");
		String manufacturerNo = request.getParameter("manufacturerNo");
		String buyProductNo = request.getParameter("buyProductNo");
		
		
		BuyProduct buyProduct = new BuyProduct();
		buyProduct.setBuyProductNo(buyProductNo);
		buyProduct.setManufacturerNo(manufacturerNo);
		buyProduct.setCategoryNo(categoryNo);
		
		
		//세션에 담기
		HttpSession session = request.getSession();
		session.setAttribute("buyProduct", buyProduct);
		
		request.setAttribute("buyProduct", buyProduct);
		request.getRequestDispatcher("views/user/buy/B_checkList.jsp").forward(request, response);
				
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
