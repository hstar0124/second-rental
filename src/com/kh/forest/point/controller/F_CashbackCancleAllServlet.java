package com.kh.forest.point.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.point.model.service.F_PointService;
import com.kh.forest.point.model.vo.CashbackHistory;

/**
 * Servlet implementation class F_CashbackCancleAllServlet
 */
@WebServlet("/cashbackCancleAll.po")
public class F_CashbackCancleAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_CashbackCancleAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		limit = 10;
		
		F_PointService ps = new F_PointService();
		int listCount = ps.getListCashbackCancleOneCount();
		
		
		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 +1;
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		List<CashbackHistory> list = new F_PointService().cashbackCancleSelectAll(pi);
		
		if(list != null) {
			request.setAttribute("cancleList", list);
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/admin/memberManagement/F_cashbackCancleList.jsp").forward(request, response);
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
