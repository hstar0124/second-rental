package com.kh.forest.point.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.point.model.service.F_PointService;
import com.kh.forest.point.model.vo.CashbackHistory;

/**
 * Servlet implementation class F_CashbackInsertComHistoryServlet
 */
@WebServlet("/insertComHisory.po")
public class F_CashbackInsertComHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_CashbackInsertComHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CashbackHistory> proList = new F_PointService().selectAllProList();
		
		int result = new F_PointService().comInsertHistory(proList);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/selectAllCashCom.po");
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
