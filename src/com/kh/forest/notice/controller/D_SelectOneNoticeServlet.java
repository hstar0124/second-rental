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

/**
 * Servlet implementation class D_SelectOneNoticeServlet
 */
@WebServlet("/selectOne.no")
public class D_SelectOneNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_SelectOneNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		//System.out.println("서블릿으로 넘어온 num : " + num);
		
		int noticeNum = Integer.parseInt(num);
		
		Notice notice = new D_NoticeService().selectOne(noticeNum);
		
		//System.out.println("한바뀌 돌다온 notice : " + notice);
		
		String page = "";
		if(notice != null) {
			page = "views/admin/community/D_noticeDetail.jsp";
			request.setAttribute("notice", notice);
			//System.out.println("servlet : " + notice);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세 보기 실패!");
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
