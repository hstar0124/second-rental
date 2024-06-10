package com.kh.forest.search.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.forest.buy.model.vo.BuyProduct;
import com.kh.forest.product.model.vo.Product;
import com.kh.forest.search.service.B_searchService;

/**
 * Servlet implementation class B_selectAutoSearchServlet
 */
@WebServlet("/selectAutoSearch.main")
public class B_selectAutoSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectAutoSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mainSearch = request.getParameter("mainSearch");
		
		ArrayList<Product> list = new B_searchService().selectProductList(mainSearch);
		System.out.println(list);
		
		JSONArray result = new JSONArray();
		JSONObject pName = null;
		
		for(Product p : list) {
			pName = new JSONObject();
			pName.put("mainSearch", URLEncoder.encode(p.getBuyProductName(), "UTF-8"));
			
			result.add(pName);
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
