package com.kh.forest.point.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.point.model.service.F_PointService;
import com.kh.forest.point.model.vo.Reason;

/**
 * Servlet implementation class F_CashbackCancleReason
 */
@WebServlet("/selectReason.po")
public class F_CashbackCancleReason extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_CashbackCancleReason() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num1");
		
		Reason reason = new F_PointService().cashbackCancleReason(num);
		
		if(reason != null) {
			request.setAttribute("reason", reason);
			request.getRequestDispatcher("views/admin/memberManagement/F_cashbackReason.jsp").forward(request, response);
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
