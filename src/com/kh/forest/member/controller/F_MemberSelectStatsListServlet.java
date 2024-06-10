package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.member.model.vo.StatsMemberList;

/**
 * Servlet implementation class F_MemberSelectStatsListServlet
 */
@WebServlet("/statsMemberList.me")
public class F_MemberSelectStatsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberSelectStatsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("sysdate");
		String month = request.getParameter("month");
		
		
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
		
		F_MemberService ns = new F_MemberService();
		int listCount = ns.getStatsMemberListCount(year, month);
		

		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 +1;
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		List<StatsMemberList> list = new F_MemberService().selectStatsMemberList(pi, year, month);
		
		System.out.println(list);
		
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/admin/memberManagement/F_statsMemberDetail.jsp").forward(request, response);
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
