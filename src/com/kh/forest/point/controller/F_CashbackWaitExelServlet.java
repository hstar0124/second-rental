package com.kh.forest.point.controller;

import static com.kh.forest.common.JDBCTemplate.commit;

import java.io.IOException;
import java.sql.Array;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.point.model.service.F_PointService;
import com.kh.forest.point.model.vo.CashbackHistory;

/**
 * Servlet implementation class F_CashbackWaitExelServlet
 */
@WebServlet("/exelAll.po")
public class F_CashbackWaitExelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public F_CashbackWaitExelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CashbackHistory> waitList = new F_PointService().cashBackExel();
		
		int result = new F_PointService().printUpdate(waitList);


		if(waitList != null) {
			request.setAttribute("waitList", waitList);
			request.getRequestDispatcher("views/admin/memberManagement/F_exel.jsp").forward(request, response);		
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
