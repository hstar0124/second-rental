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
import com.kh.forest.product.model.vo.A_ProductInfo;

/**
 * Servlet implementation class E_ExtendProductSelectServlet
 */
@WebServlet("/selectExtendProduct")
public class E_ExtendProductSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_ExtendProductSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productNo = request.getParameter("productNo");
		
		A_ProductInfo extendProduct = new E_ProductService().selectExtendProduct(productNo);
		
		JSONObject result = new JSONObject();
		result.put("manufacturerName", URLEncoder.encode(extendProduct.getManufacturerName(),"UTF-8"));
		result.put("productName", URLEncoder.encode(extendProduct.getProductName(),"UTF-8"));
		result.put("productNo", URLEncoder.encode(extendProduct.getProductNo(),"UTF-8"));
		result.put("categoryName", URLEncoder.encode(extendProduct.getCategoryName(),"UTF-8"));
		result.put("rentalPrice",URLEncoder.encode(extendProduct.getRentalPrice(),"UTF-8"));
		result.put("acceptanceMonth",extendProduct.getAcceptanceMonth());
		
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
