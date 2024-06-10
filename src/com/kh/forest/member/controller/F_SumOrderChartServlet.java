package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;

/**
 * Servlet implementation class F_SumOrderChartServlet
 */
@WebServlet("/sumOrderChart.me")
public class F_SumOrderChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_SumOrderChartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sysdate = new F_MemberService().selectDate();  

		String year = (String) request.getAttribute("year");
		String month = (String) request.getAttribute("month");
		
		HashMap<String, Integer> map = new F_MemberService().sumOrderChart(year, month);
		HashMap<String, Integer> orderStats = new F_MemberService().countOrderStats(year, month);
		
		
		if(map != null) {
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("memberMonth", map);
			request.setAttribute("orderStats", orderStats);
			request.getRequestDispatcher("views/admin/memberManagement/F_orderChart.jsp").forward(request, response);
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
