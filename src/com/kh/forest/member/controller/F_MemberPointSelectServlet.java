package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.point.model.service.F_PointService;
import com.kh.forest.point.model.vo.Point;
import com.kh.forest.point.model.vo.PointSum;

/**
 * Servlet implementation class F_MemberPointSelectServlet
 */
@WebServlet("/pointAll.po")
public class F_MemberPointSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberPointSelectServlet() {
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
		
		
		
		String num = request.getParameter("num");
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String point = request.getParameter("userPoint");
		
		Member pointMember = new Member();
		pointMember.setUserNo(num);
		pointMember.setUserName(userName);
		pointMember.setUserId(userId);
		pointMember.setPoint(Integer.parseInt(point));
		
		currentPage = 1;
		
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
		
		
		List<Point> list = new F_PointService().selectOneAll(pi, num);
		
		if(list != null) {
			request.setAttribute("member", pointMember);
			request.setAttribute("pointSum", sum);
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/admin/memberManagement/F_memberDetailPoint.jsp").forward(request, response);
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
