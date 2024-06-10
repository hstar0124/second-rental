package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;

/**
 * Servlet implementation class F_ReportPassServlet
 */
@WebServlet("/reportPass.me")
public class F_ReportPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_ReportPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] arr = request.getParameter("num").split(",");
		List<String> boardNo = new ArrayList();
		
		for(String num : arr) {
			int i = 0;
			if(!boardNo.contains(num)) {
				boardNo.add(num);
			}
		}
		
		int result = new F_MemberService().reportPass(boardNo);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/reportSelectAll.me");
		}else {
			request.setAttribute("errorCode", "55");
			request.getRequestDispatcher("views/user/member/error/F_loginFalse.jsp").forward(request, response);
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
