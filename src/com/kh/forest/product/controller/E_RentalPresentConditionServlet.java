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
import com.kh.forest.product.model.vo.Rental;

/**
 * Servlet implementation class E_RentalPresentConditionServlet
 */
@WebServlet("/rentalCondition")
public class E_RentalPresentConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public E_RentalPresentConditionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		listCount = new E_ProductService().countRentaPresentCondition();
		limit = 10;
		maxPage = (int)((double)listCount/limit+0.9);
		
		endPage = (int)((double)currentPage/limit+0.9)*10;
		startPage = endPage - 10 + 1;

		if(endPage > maxPage){
			endPage = maxPage;
		}
		E_PageInfo pi = new E_PageInfo(currentPage, listCount, limit, endPage,  maxPage, startPage);
		
		ArrayList<Rental> rentalList = new E_ProductService().rentalList(pi);
		ArrayList<Category> categoryList = new E_ProductService().selectCategory();
		String page="";
		if(rentalList != null) {
			page="views/admin/productManagement/E_RentalPresentCondition.jsp";
			
			request.setAttribute("rentalList", rentalList);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("pi", pi);
		}else {
			page="views/admin/common/E_errorPage.jsp";
			
			request.setAttribute("msg", "렌탈현황 조호 실패!");
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
