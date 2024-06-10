package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;

/**
 * Servlet implementation class F_MemberSearchServlet
 */
@WebServlet("/searchMember.me")
public class F_MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderCategory = request.getParameter("orderCategory");
		String keyWord = request.getParameter("keyWord");
		String search = request.getParameter("keywordSearch");
		
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
		int listCount = ns.getSearchUserNameCount(search);
		
		
		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 +1;
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		//회원 이름으로 검색(정상 회원만)
		if(orderCategory.equals("everyMember") && keyWord.equals("userName") && !search.equals("")) {
			List<Member> list = new F_MemberService().searchUserName(pi, search);
			if(list != null) {
				request.setAttribute("list", list);
				request.setAttribute("pi", pi);
				request.getRequestDispatcher("views/admin/memberManagement/F_memberList.jsp").forward(request, response);
			}
			//아이디로 검색
		}else if(orderCategory.equals("everyMember") && keyWord.equals("userId") && !search.equals("")) {
			List<Member> list = new F_MemberService().searchUserId(search);
			if(list != null) {
				request.setAttribute("list", list);
				request.setAttribute("pi", pi);
				request.getRequestDispatcher("views/admin/memberManagement/F_memberList.jsp").forward(request, response);
			}
			//고객번호로 검색
		}else if(orderCategory.equals("everyMember") && keyWord.equals("userNo") && !search.equals("")) {
			List<Member> list = new F_MemberService().searchUserNo(search);
			if(list != null) {
				request.setAttribute("list", list);
				request.setAttribute("pi", pi);
				request.getRequestDispatcher("views/admin/memberManagement/F_memberList.jsp").forward(request, response);
			}
			
		}else if(orderCategory.equals("everyMember") && search.equals("")) {
			request.getRequestDispatcher("/selectAll.me").forward(request, response);
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
