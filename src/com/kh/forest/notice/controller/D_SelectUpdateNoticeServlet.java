package com.kh.forest.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.notice.model.service.D_NoticeService;
import com.kh.forest.notice.model.vo.Notice;

/**
 * Servlet implementation class D_SelectUpdateServlet
 */
@WebServlet("/selectOneUp.no")
public class D_SelectUpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_SelectUpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		//System.out.println("selectOneUp 1.updatenum : " + num);
		
		int noticeNum = Integer.parseInt(num);
		//System.out.println("selectOneUp 2.noticeNum : " + noticeNum);
		
		Notice notice = new D_NoticeService().selectOne(noticeNum);
		//System.out.println("selectOneUp 3.notice : " + notice);
		
		String page = "";
		if(notice != null) {
			page = "views/admin/community/D_noticeUpdateForm.jsp";
			//System.out.println("selectOneUp 4.notice : " + page);
			
			request.setAttribute("notice", notice);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 수정 보기 실패!");
			
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
