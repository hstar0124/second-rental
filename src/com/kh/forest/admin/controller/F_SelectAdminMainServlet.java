package com.kh.forest.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.admin.model.service.F_AdminService;
import com.kh.forest.notice.model.vo.Notice;

/**
 * Servlet implementation class F_SelectAdminMainServlet
 */
@WebServlet("/selectAdminMain.em")
public class F_SelectAdminMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_SelectAdminMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Integer> map = new F_AdminService().selectAsminMain();
		HashMap<String, Integer> orderCount = new F_AdminService().selectOrderCount();
		
		List<Notice> list = new F_AdminService().selectNotice();
		
			
		if(map != null) {
			request.setAttribute("map", map);
			request.setAttribute("orderCount", orderCount);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/common/C_main.jsp").forward(request, response);
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
