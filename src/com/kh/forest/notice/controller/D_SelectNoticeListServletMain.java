package com.kh.forest.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.notice.model.service.D_NoticeService;
import com.kh.forest.notice.model.vo.Notice;
import com.kh.forest.notice.model.vo.PageInfo;
import com.kh.forest.point.model.service.F_PointService;

/**
 * Servlet implementation class D_SelectNoticeListServletMain
 */
@WebServlet("/selectListMain.no")
public class D_SelectNoticeListServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_SelectNoticeListServletMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Notice> list = new D_NoticeService().selectList();
		
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
		
		D_NoticeService ns = new D_NoticeService();
		int listCount = ns.getListCountMain();
		
		//System.out.println("listCount : " + listCount);
		
		maxPage = (int)((double)(listCount/limit + 0.9));
		
		startPage = (((int)((double) currentPage/limit + 0.9))-1)*10 +1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		//System.out.println("PageInfo : " + pi);
		
		ArrayList<Notice> list1 = new D_NoticeService().selectListMain(pi);
		
		//System.out.println("list1 : "+ list1);
		
		HttpSession session = request.getSession();
	      
	      Member m = (Member) session.getAttribute("loginMember");
	      
	      Member loginMember = new F_MemberService().selectOne(Integer.parseInt(m.getUserNo()));
	      
	      int readCount = new F_PointService().selectReadCount(m.getUserNo()); 

	      session.setAttribute("loginMember", loginMember);
	      session.setMaxInactiveInterval(40*60);
		
		String page = "";
		if(list1 != null) {
			page = "views/user/mypage/F_MyPageSection_mainMyPage.jsp";
			request.setAttribute("list", list1);
			request.setAttribute("readCount", readCount);
			request.setAttribute("pi", pi);
		} else { 
			page = "views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "공지사항 조회 실패!!");
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
