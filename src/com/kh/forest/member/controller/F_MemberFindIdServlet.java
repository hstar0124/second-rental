package com.kh.forest.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;

/**
 * Servlet implementation class F_MemberFindIdServlet
 */
@WebServlet("/findId.me")
public class F_MemberFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberFindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		
		Member findMember = new Member();
		findMember.setUserName(userName);
		findMember.setEmail(email);
		
		
		String findId = new F_MemberService().findMemberId(findMember);
		
		
		if(userName == null || userName.equals("") || email == null || email.equals("")) {
			request.setAttribute("errorCode", "12");
			request.getRequestDispatcher("views/user/member/error/F_loginFalse.jsp").forward(request, response);
		}else if(!findId.equals("")) {
			request.setAttribute("findId", findId);
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("views/user/member/F_findUserIdResult.jsp").forward(request, response);
		}else {
			request.setAttribute("errorCode", "19");
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
