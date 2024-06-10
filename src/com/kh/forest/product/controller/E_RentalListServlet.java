package com.kh.forest.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.vo.Member;

import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.E_PageInfo;
import com.kh.forest.product.model.vo.Rental;

/**
 * Servlet implementation class E_RentalListServlet
 */
@WebServlet("/rentalList")
public class E_RentalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_RentalListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginMember = (Member)(request.getSession().getAttribute("loginMember"));
		String loginMemberNo = loginMember.getUserNo();
		
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
		
		listCount = new E_ProductService().countRentalList(loginMemberNo);
		limit = 10;
		maxPage = (int)((double)listCount/limit+0.9);
		
		endPage = (int)((double)currentPage/limit+0.9)*10;
		startPage = endPage - 10 + 1;

		if(endPage > maxPage){
			endPage = maxPage;
		}
		E_PageInfo pi = new E_PageInfo(currentPage, listCount, limit, endPage,  maxPage, startPage);
		
		
		ArrayList<Rental> rentalList = new E_ProductService().rentalList(pi,loginMemberNo);
		
		String page="";
		if(rentalList != null) {
			request.setAttribute("rentalList", rentalList);
			request.setAttribute("pi", pi);	
			page="views/user/mypage/E_RentalCondition.jsp";
		}else {
			request.setAttribute("msg", "렌탈현황리스트 조회 실패!");
			page="views/admin/common/E_errorPage.jsp";
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
