package com.kh.forest.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.Product;

/**
 * Servlet implementation class E_BuyHistorySelectServlet
 */
@WebServlet("/buyHistory")
public class E_BuyHistorySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_BuyHistorySelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buyNo = request.getParameter("buyNo");
		
		Product requestP = null;
		
		requestP = new E_ProductService().selectBuyHistory(buyNo);
		
		JSONObject result = new JSONObject();
		result.put("categoryName", URLEncoder.encode(requestP.getCategoryName(),"UTF-8"));
		result.put("buyProductName", URLEncoder.encode(requestP.getBuyProductName(),"UTF-8"));
		result.put("buyProductNo", URLEncoder.encode(requestP.getBuyProductNo(),"UTF-8"));
		result.put("manufacturerName", URLEncoder.encode(requestP.getManufacturerName(),"UTF-8"));
		result.put("manufacturerNo", URLEncoder.encode(requestP.getManufacturerNo(),"UTF-8"));
		result.put("grade", URLEncoder.encode(requestP.getGrade(),"UTF-8"));
		result.put("marketprice", URLEncoder.encode(requestP.getMarketprice(),"UTF-8"));
		result.put("price", URLEncoder.encode(requestP.getBuyPrice(),"UTF-8"));
		result.put("empNo", URLEncoder.encode(requestP.getEmpNo(),"UTF-8"));
		result.put("empName", URLEncoder.encode(requestP.getEmpName(),"UTF-8"));
		result.put("warehouseNo", URLEncoder.encode(requestP.getWarehouseNo(),"UTF-8"));
		result.put("warehouseName", URLEncoder.encode(requestP.getWarehouseName(),"UTF-8"));
		result.put("categoryNo", URLEncoder.encode(requestP.getCategoryNo(),"UTF-8"));
		
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
