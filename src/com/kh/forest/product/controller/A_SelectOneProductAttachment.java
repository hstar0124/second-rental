package com.kh.forest.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.ProductAttachment;

/**
 * Servlet implementation class A_SelectOneProductAttachment
 */
@WebServlet("/selectOneAttachment")
public class A_SelectOneProductAttachment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_SelectOneProductAttachment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productNo = request.getParameter("productNo");
		
		//System.out.println("사진 서블릿 불림 : " + productNo);
		
		ArrayList<ProductAttachment> attList = new E_ProductService().selectProductDefaultAttach(productNo);
		
		//System.out.println(attList);
		
		JSONObject attachInfo = null;
		JSONArray attArr = new JSONArray();
		
		if(attList != null) {
			for(ProductAttachment p : attList) {
				attachInfo = new JSONObject();
				
				if(p.getChangeName() != null) {
					attachInfo.put("cngPic", p.getChangeName());
				}				
				attArr.add(attachInfo);				
			}
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(attArr.toJSONString());
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
