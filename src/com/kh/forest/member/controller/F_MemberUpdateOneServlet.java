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
 * Servlet implementation class F_MemberUpdateOneServlet
 */
@WebServlet("/updateOne.me")
public class F_MemberUpdateOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberUpdateOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Member m = (Member) request.getAttribute("okMember");
		Member selectMember = new F_MemberService().selectOne(Integer.parseInt(m.getUserNo()));
		
		
		request.setAttribute("selectMember", selectMember);
		request.getRequestDispatcher("views/user/mypage/F_MyPageSection_memberInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
