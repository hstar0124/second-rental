package com.kh.forest.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.forest.product.model.service.A_WishListService;
import com.kh.forest.product.model.vo.A_WishList;

/**
 * Servlet implementation class A_SelectWishListServlet
 */
@WebServlet("/selectWish")
public class A_SelectWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_SelectWishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("wishSelect");
		String proNo = request.getParameter("proNo");
		String userNo = request.getParameter("userNo");
		
		//System.out.println(proNo + " : " + userNo);
		
		ArrayList<A_WishList> list = new A_WishListService().selectWishList(userNo);
	
		JSONObject wishInfo = null;
		JSONArray wishArray = new JSONArray();
		
		for(A_WishList w : list) {
			wishInfo = new JSONObject();
			wishInfo.put("userNo", w.getUserNo());
			wishInfo.put("proNo", w.getProductNo());
			
			wishArray.add(wishInfo);
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(wishArray.toJSONString());
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
