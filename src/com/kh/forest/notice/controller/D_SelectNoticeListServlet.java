package com.kh.forest.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.notice.model.service.D_NoticeService;
import com.kh.forest.notice.model.vo.Notice;
import com.kh.forest.notice.model.vo.PageInfo;

/**
 * Servlet implementation class D_SelectNoticeListServlet
 */
@WebServlet("/selectList.no")
public class D_SelectNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_SelectNoticeListServlet() {
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
		}else {
			currentPage = 1;
		}
		
		limit = 10;
		
		D_NoticeService ns = new D_NoticeService();
		int listCount = ns.getListCount();
		
		//System.out.println(" >>> : " + listCount);
		
		maxPage = (int)((double) listCount / limit + 0.9);
		
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 + 1;
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Notice> list1 = new D_NoticeService().selectList(pi);
		
		String page = "";
		if(list1 != null) {
			page = "views/admin/community/D_noticeList.jsp";
			request.setAttribute("list", list1);
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
