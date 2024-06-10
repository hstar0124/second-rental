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

/**
 * Servlet implementation class E_CategorySelectServlet
 */
@WebServlet("/categorySelect")
public class E_CategorySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_CategorySelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Category> list = null;
		
		list = new E_ProductService().selectCategory();
		
		String page="";
		if(list != null) {
			page = "views/admin/productManagement/E_inventoryInsertForm.jsp";
			request.setAttribute("list", list);
		}else {
			page = "views/common/E_errorPage.jsp";
			request.setAttribute("msg", "카테고리목록 조회 실패!");
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
