package com.kh.forest.notice.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.notice.model.service.D_NoticeService;
import com.kh.forest.notice.model.vo.Notice;

/**
 * Servlet implementation class D_UpdateNoticeServlet
 */
@WebServlet("/update.no")
public class D_UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		//String eno = request.getParameter("empNo");
		//String date = request.getParameter("date");
		String content = request.getParameter("content");
		String num = request.getParameter("num");
		java.sql.Date day = null;
		
		/*if(date != null) {
			day = java.sql.Date.valueOf(date);
			
		}*/
		
		Notice notice = new Notice();
		notice.setnTitle(title);
		//notice.setnWriter(eno);
		//notice.setnEnrollDate(day);
		notice.setnContent(content);
		notice.setnBoardNo(num);
		
		//System.out.println("1.update.no : " + notice);
		
		int result = new D_NoticeService().updateNotice(notice);
		//System.out.println("2.update.no : " + result);
		
		String page = "";
		if(result > 0) {
			/*Notice changeNotice = new D_NoticeService().selectOne(num);
			page = "/forest/selectOne.no?num="+changeNotice.getnBoardNo();
			response.sendRedirect(page);*/
			response.sendRedirect("/forest/selectOne.no?num=" + num);

			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "수정실패하였습니다.");
			request.getRequestDispatcher(page).forward(request, response);
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
