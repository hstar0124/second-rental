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
 * Servlet implementation class B_selectSubCategoryServlet
 */
@WebServlet("/subSelect.ca")
public class B_selectSubCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectSubCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryNo = request.getParameter("categoryNo");
		String manufacturerNo = request.getParameter("manufacturerNo");
		//System.out.println("제조사: " + manufacturerNo);
		
		ArrayList<BuyProduct> buyProductList = new B_buyService().selectManufaturerName(manufacturerNo,categoryNo);
		//System.out.println("상품명 : " + buyProductList);
		
		JSONArray result = new JSONArray();
		JSONObject modelName = null;
		for(BuyProduct buyProduct : buyProductList) {
			modelName = new JSONObject();
			modelName.put("buyProductName", URLEncoder.encode(buyProduct.getBuyProductName(), "UTF-8"));
			modelName.put("buyProductNo", URLEncoder.encode(buyProduct.getBuyProductNo(), "UTF-8"));
			
			result.add(modelName);
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
