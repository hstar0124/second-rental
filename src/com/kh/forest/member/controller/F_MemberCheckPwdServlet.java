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
 * Servlet implementation class F_MemberCheckPwdServlet
 */
@WebServlet("/checkPwd.me")
public class F_MemberCheckPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberCheckPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("id");
		String password = request.getParameter("password1");
		
		Member checkMember = new Member();
		checkMember.setUserId(userId);
		checkMember.setPassword(password);
		
		Member oKMember = new F_MemberService().checkPwd(checkMember);
		
		if(oKMember != null) {
			request.setAttribute("okMember", oKMember);
			request.getRequestDispatcher("/updateOne.me").forward(request, response);
			//request.getRequestDispatcher("views/user/mypage/F_MyPageSection_memberUpdateForm.jsp").forward(request, response);
		}else {
			request.setAttribute("errorCode", "16");
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
