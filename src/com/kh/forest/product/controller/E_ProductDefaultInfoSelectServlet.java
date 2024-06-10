package com.kh.forest.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.Category;
import com.kh.forest.product.model.vo.Product;
import com.kh.forest.product.model.vo.ProductAttachment;

/**
 * Servlet implementation class E_ProductDefaultInfoSelectServlet
 */
@WebServlet("/selectProductDefault")
public class E_ProductDefaultInfoSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_ProductDefaultInfoSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productNo = request.getParameter("productNo");
		
		Product productDefault = null;
		ArrayList<ProductAttachment> productDefaultAttach = null;

		productDefault = new E_ProductService().selectProductDefault(productNo);
		
		productDefaultAttach = new E_ProductService().selectProductDefaultAttach(productNo);
			
		ArrayList<Category> list = new E_ProductService().selectCategory();
		String page="";
		
		if(productDefault != null) {
			request.setAttribute("productDefault", productDefault);
			request.setAttribute("productDefaultAttach", productDefaultAttach);
			request.setAttribute("list", list);
			page="views/admin/productManagement/E_productInsertForm.jsp";
			
		}else {
			request.setAttribute("msg", "기본정보 불러오기실패!");
			page="views/admin/common/E_errorPege.jsp";
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
