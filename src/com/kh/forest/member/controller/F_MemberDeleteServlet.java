package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.E_PageInfo;
import com.kh.forest.product.model.vo.Rental;

/**
 * Servlet implementation class F_MemberRentalCheck
 */
@WebServlet("/deleteMember.me")
public class F_MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public F_MemberDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");

		//렌탈 여부 확인
		int currentPage;
		int listCount;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		listCount = new F_MemberService().retalListCount(num);
		
		limit = 10;
		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 +1;
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		List<Rental> rentalList = new F_MemberService().rentalList(num, pi);
		
		if(rentalList.size() >0) {
			request.setAttribute("rentalList", rentalList);
			request.setAttribute("num", num);
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/user/mypage/F_MyPageSection_memberDeleteRental.jsp").forward(request, response);
			return;
			
		}else {
			int result = new F_MemberService().deleteMember(num);
			if(result >0) {
				request.getSession().invalidate();
				response.sendRedirect("views/user/mypage/F_MyPageSection_memberDeleteResult.jsp");
			}
		}
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
