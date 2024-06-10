package com.kh.forest.point.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.point.model.service.F_PointService;
import com.kh.forest.point.model.vo.Point;
import com.kh.forest.point.model.vo.PointSum;

/**
 * Servlet implementation class F_PointSelectAllServlet
 */
@WebServlet("/pointSelectOne.po")
public class F_PointSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public F_PointSelectOneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;

		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginMember");

		String num = m.getUserNo();

		int usePoint = new F_PointService().sumUsePoint(num); 
		int cashBackProPoint = new F_PointService().sumCashBackProPoint(num);
		int cashBackPoint = new F_PointService().sumCashBackPoint(num);
		int refundPoint = new F_PointService().sumRefundPoint(num);
		int buyPoint = new F_PointService().sumBuyPoint(num);

		PointSum sum = new PointSum();
		sum.setUseSum(usePoint);
		sum.setCashBackProPoint(cashBackProPoint);
		sum.setCashBackPoint(cashBackPoint);
		sum.setRefundPount(refundPoint);
		sum.setBuyPoint(buyPoint);

		currentPage = 1;

		Member loginMember = new F_MemberService().selectOne(Integer.parseInt(m.getUserNo()));

		session.setAttribute("loginMember", loginMember);
		session.setMaxInactiveInterval(40*60);

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		limit = 10;

		F_PointService ps = new F_PointService();
		int listCount = ps.getListOneCount(num);




		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 +1;
		endPage = startPage + 10 - 1;

		if(maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

		int result = new F_PointService().updateReadCheck(m.getUserNo());

		List<Point> list = new F_PointService().selectOneAll(pi, num);

		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("pointSum", sum);
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/user/mypage/F_MyPageSection_point.jsp").forward(request, response);
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
