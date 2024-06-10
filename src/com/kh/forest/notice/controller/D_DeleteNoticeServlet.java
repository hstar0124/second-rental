package com.kh.forest.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.notice.model.service.D_NoticeService;

/**
 * Servlet implementation class D_DeleteNoticeServlet
 */
@WebServlet("/delete.no")
public class D_DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_DeleteNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		int deleteNno = Integer.parseInt(num);
		
		//System.out.println("1.delete NO : " + deleteNno);
		
		int result = new D_NoticeService().deleteNotice(deleteNno);
		
		//System.out.println("2.delete result : " + result);
		
		String page = "";
		if(result > 0) {
			page = "/forest/selectList.no";
			response.sendRedirect(page);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "삭제실패!!");
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
