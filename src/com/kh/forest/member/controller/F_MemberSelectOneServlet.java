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
 * Servlet implementation class F_MemberSelectOneServlet
 */
@WebServlet("/selectOne.me")
public class F_MemberSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		Member selectMember = new F_MemberService().selectOne(num);
		
		int money = new F_MemberService().allOrderMoney(num);
		int buyMoney = new F_MemberService().allBuyMoney(num);
		int wishList = new F_MemberService().wishListCount(num);
		int basketList = new F_MemberService().basketCount(num);
		int reviewCount = new F_MemberService().reviewCount(num);
		
		if(selectMember != null) {
			request.setAttribute("selectMember", selectMember);
			request.setAttribute("money", money);
			request.setAttribute("buyMoney", buyMoney);
			request.setAttribute("wishCount", wishList);
			request.setAttribute("basketList", basketList);
			request.setAttribute("reviewCount", reviewCount);
			
			request.getRequestDispatcher("views/admin/memberManagement/F_memberDetail.jsp").forward(request, response);;
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