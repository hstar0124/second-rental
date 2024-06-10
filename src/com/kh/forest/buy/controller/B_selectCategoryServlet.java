package com.kh.forest.buy.controller;

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

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyProduct;

/**
 * Servlet implementation class B_selectCategoryServlet
 */
@WebServlet("/select.ca")
public class B_selectCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		
		ArrayList<BuyProduct> buyProductList = new B_buyService().selectCategory(categoryNo);
		

		JSONArray result = new JSONArray();
		JSONObject mName = null;
		for(BuyProduct buyProduct : buyProductList) {
			mName = new JSONObject();
			mName.put("manufacturerNo", URLEncoder.encode(buyProduct.getManufacturerNo(), "UTF-8"));
			mName.put("manufacturerName", URLEncoder.encode(buyProduct.getManufacturerName(), "UTF-8"));
			mName.put("categoryNo", URLEncoder.encode(buyProduct.getCategoryNo(), "UTF-8"));
			mName.put("categoryName", URLEncoder.encode(buyProduct.getCategoryName(), "UTF-8"));
			
			result.add(mName);
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result.toJSONString());
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
