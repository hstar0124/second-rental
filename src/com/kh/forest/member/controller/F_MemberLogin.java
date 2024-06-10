package com.kh.forest.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;

/**
 * Servlet implementation class F_MemberLogin
 */
@WebServlet("/login.me")
public class F_MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password1");
		
		Member requestMember = new Member();
		requestMember.setUserId(userId);
		requestMember.setPassword(password);
		
		Member m = new F_MemberService().logCount(requestMember);
		
		
		if(m != null && m.getWarningCount()>=3) {
			response.sendRedirect("views/user/member/error/F_errorPage.jsp?errorCode=82");
			return;
		}
		
		
		if(m != null && m.getLogCount() ==5) {
			int result = new F_MemberService().updateStatus(m);
			Member loginMember = new F_MemberService().loginCheck(requestMember);
		}
		
		if(m != null && m.getLogCount() >= 5) {
			response.sendRedirect("views/user/member/error/F_errorPage.jsp?errorCode=17");
			return;
		}
		if(m != null && m.getStatus().equals("제제")) {
			response.sendRedirect("views/user/member/error/F_errorPage.jsp?errorCode=18");
			return;
		}
		
		if(m != null) {
		Member loginMember = new F_MemberService().loginCheck(requestMember);
		
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			session.setMaxInactiveInterval(40*60);
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("logCount", m.getLogCount());
			request.setAttribute("errorCode", "10");
			request.getRequestDispatcher("views/user/member/error/F_memberLoginFalse.jsp").forward(request, response);
		}
		
		}else {
			request.setAttribute("errorCode", "11");
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
