package com.kh.forest.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.A_ProductInfo;

/**
 * Servlet implementation class A_selectOneProductDetailServlet
 */
@WebServlet("/selectOneDetail")
public class A_selectOneProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_selectOneProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proNum = request.getParameter("proNum");
		//System.out.println("상품 상세내용 불러오기 : " + proNum);
		
		A_ProductInfo proInfo = new E_ProductService().selectProductDetail(proNum);
		
		//System.out.println(proInfo);
		
		String page = "";
		if(proInfo != null) {
			page = "views/user/product/A_ProductDetailIndex.jsp";
			request.setAttribute("proInfo", proInfo);
		} else {
			page = "views/user/product/A_ProductDetailIndex.jsp";
			System.out.println("proInfo에 값이 없음");
			request.setAttribute("proInfo", proInfo);
		}
		request.getRequestDispatcher(page).forward(request, response);
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
