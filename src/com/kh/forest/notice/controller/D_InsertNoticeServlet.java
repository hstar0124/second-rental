package com.kh.forest.notice.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.admin.model.vo.Admin;
import com.kh.forest.notice.model.service.D_NoticeService;
import com.kh.forest.notice.model.vo.Notice;

/**
 * Servlet implementation class D_InsertNoticeServlet
 */
@WebServlet("/insert.no")
public class D_InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("loginAdmin");
		//System.out.println(admin.getEmpId());
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String write = request.getParameter("write");
		//String date = request.getParameter("date");
		//String mdate = request.getParameter("date");
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		String count = request.getParameter("count");
		
		//System.out.println("등록 session : " + session);
		/*System.out.println(date);
		
		java.sql.Date day = null;
		java.sql.Date mday = null;
		
		if(date != "") {

			day = java.sql.Date.valueOf(date);
			//mday = java.sql.Date.valueOf(mdate);
			
		} else {
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}*/
		
		
		Notice notice = new Notice();
		//notice.setnBoardNo(bno);
		notice.setnTitle(title);
		//notice.setnWriter(write);
		//notice.setnEnrollDate(day);
		notice.setnContent(content);
		
		//System.out.println(notice);
		
		int result = new D_NoticeService().insertNotice(notice);
		
		if(result > 0) {
			response.sendRedirect("/forest/selectList.no");
		} else {
			request.setAttribute("msg", "공지사항 등록 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
