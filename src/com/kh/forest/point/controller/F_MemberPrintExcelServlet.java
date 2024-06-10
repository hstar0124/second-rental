package com.kh.forest.point.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.point.model.service.F_PointService;
import com.kh.forest.point.model.vo.CashbackHistory;

/**
 * Servlet implementation class F_MemberPrintExcelServlet
 */
@WebServlet("/printMember.po")
public class F_MemberPrintExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public F_MemberPrintExcelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] arr = request.getParameter("num").split(",");

		List<String> cashbackNo = new ArrayList(); 

		for(String num : arr) {
			int i = 0;
			if(!cashbackNo.contains(num)) {
				cashbackNo.add(num);
			}
		}
		List<CashbackHistory> waitList = new F_PointService().selectMemberPrint(cashbackNo);
		
		if(waitList != null) {
			int result = new F_PointService().memberPrint(waitList);
			
			if(result > 0) {
				request.setAttribute("waitList", waitList);
				request.getRequestDispatcher("views/admin/memberManagement/F_exel.jsp").forward(request, response);		
				}else {
					request.setAttribute("errorCode", "22");
					request.getRequestDispatcher("views/user/member/error/F_loginFalse.jsp").forward(request, response);
				}
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
