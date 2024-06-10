package com.kh.forest.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.service.A_WishListService;
import com.kh.forest.product.model.vo.A_WishList;

/**
 * Servlet implementation class A_DeleteWishListServlet
 */
@WebServlet("/deleteWishList")
public class A_DeleteWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_DeleteWishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proNo = request.getParameter("proNo");
		String userNo = request.getParameter("userNo");
		
		System.out.println("Delete " + proNo + " : " + userNo);
		
		A_WishList wish = new A_WishList();
		wish.setUserNo(userNo);
		wish.setProductNo(proNo);
		
		int result = new A_WishListService().deleteWishlist(wish);
	
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
