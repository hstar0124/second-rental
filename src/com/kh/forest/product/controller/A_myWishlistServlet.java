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

import com.kh.forest.product.model.service.A_WishListService;
import com.kh.forest.product.model.vo.A_MyWishlist;
import com.kh.forest.product.model.vo.A_WishList;

/**
 * Servlet implementation class myWishlistServlet
 */
@WebServlet("/myWishlist")
public class A_myWishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_myWishlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo = request.getParameter("userNo");
		
		//System.out.println("위시리스트 서블릿 " + userNo);
		
		ArrayList<A_MyWishlist> wishlist = new A_WishListService().selectMyWishList(userNo);
		//System.out.println(wishlist);
		
		JSONObject wishInfo = null;
		JSONArray wishArray = new JSONArray();
		
		for(A_MyWishlist w : wishlist) {
			wishInfo = new JSONObject();
			//USER_NO, PRODUCT_NO, MANUFACTURER_NAME, PRODUCT_NAME, CHANGE_NAME
			wishInfo.put("userNo", w.getUserNo());
			wishInfo.put("proNo", w.getProductNo());
			wishInfo.put("manuName", w.getManufacturerName());
			wishInfo.put("proName", URLEncoder.encode(w.getProductName(), "UTF-8"));
			wishInfo.put("cngName", w.getChangName());
			
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
