package com.kh.forest.search.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.vo.Product;
import com.kh.forest.search.service.B_searchService;


/**
 * Servlet implementation class B_selectCategoryProductServlet
 */
@WebServlet("/selectCategoryProduct.main")
public class B_selectCategoryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectCategoryProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mainSearch = request.getParameter("mainSearch");
		
		//ArrayList<Product> list = new B_searchService().selectProductList(mainSearch);
		
		ArrayList<HashMap<String, Object>> photoList = new B_searchService().selectSearchPhoto(mainSearch);
		//System.out.println(photoList);
		
		String page = "";
		if(photoList != null) {
			page = "views/user/search/B_searchList.jsp";
			request.setAttribute("photoList", photoList);
		} else {
			
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
