package com.kh.forest.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.service.A_ProductStaticService;
import com.kh.forest.product.model.vo.A_ProductMonthlyStatic;
import com.kh.forest.product.model.vo.A_ProductStatic;

/**
 * Servlet implementation class A_ProductStaticServlet
 */
@WebServlet("/productStatic")
public class A_ProductStaticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_ProductStaticServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("서블릿 잠깐 들림");		
		
		//카테고리별 총 수
		A_ProductStatic proStatic = new A_ProductStaticService().selectAllCategory();
		
		//월별 매입상태 진행 수
		ArrayList<A_ProductMonthlyStatic> proMonthly = new A_ProductStaticService().selectMonthly();
		
		System.out.println(proMonthly);
		
		request.setAttribute("proStatic", proStatic);
		request.setAttribute("proMonthly", proMonthly);
		
		request.getRequestDispatcher("views/admin/statisticsManagement/A_ProductStatic.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
