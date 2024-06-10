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
import com.kh.forest.product.model.vo.E_PageInfo;
import com.kh.forest.product.model.vo.Product;

/**
 * Servlet implementation class E_SearchingInventoryServlet
 */
@WebServlet("/serchingInventory")
public class E_SearchingInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_SearchingInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryNo = request.getParameter("categoryNo");
		String select = request.getParameter("select");
		String value = request.getParameter("value");
		String productStatus = request.getParameter("productStatus");
		int currentPage; 
		int listCount;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else {
			currentPage = 1;
		}
		
		listCount = new E_ProductService().searchingInventoryCount(categoryNo, select, value, productStatus);
		limit = 10;
		maxPage = (int)((double)listCount/limit+0.9);
		
		endPage = (int)((double)currentPage/limit+0.9)*10;
		startPage = endPage - 10 + 1;

		if(endPage > maxPage){
			endPage = maxPage;
		}
		E_PageInfo pi = new E_PageInfo(currentPage, listCount, limit, endPage,  maxPage, startPage);
		
		
		ArrayList<Product> productList = new E_ProductService().searchingInventory(pi, categoryNo, select, value, productStatus);

		ArrayList<Category> categoryList = new E_ProductService().selectCategory();
		
		
		int productCount = new E_ProductService().countInventoryList();
		
		String page="";
		if(productList!=null) {
			request.setAttribute("productList", productList);
			request.setAttribute("pi", pi);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("productCount", productCount);
			request.setAttribute("categoryNo", categoryNo);
			request.setAttribute("select", select);
			request.setAttribute("value", value);
			request.setAttribute("productStatus", productStatus);
			page="views/admin/productManagement/E_inventorySearchingPage.jsp";
		}else {
			page="views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "상품 검색 실패!");
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
