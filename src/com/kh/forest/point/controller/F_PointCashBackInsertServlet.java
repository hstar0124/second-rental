package com.kh.forest.point.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.util.SessionUtils;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.point.model.service.F_PointService;

/**
 * Servlet implementation class F_PointCashBackInsertServlet
 */
@WebServlet("/cashbackInsert.po")
public class F_PointCashBackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_PointCashBackInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usePoint = request.getParameter("usePoint");
		String cashbackMoney = request.getParameter("cashbackMoney");
		
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginMember");
		
		int result = new F_PointService().insertCashback(m, usePoint, cashbackMoney);
		
		if(result > 0) {
			Member newMember = new F_MemberService().selectOne(Integer.parseInt(m.getUserNo()));
			session.setAttribute("loginMember", newMember);
			response.sendRedirect("views/user/mypage/F_MyPageSection_pointRefundsResult.jsp");
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
