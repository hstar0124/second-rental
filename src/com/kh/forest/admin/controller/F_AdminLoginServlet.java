package com.kh.forest.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.admin.model.service.F_AdminService;
import com.kh.forest.admin.model.vo.Admin;

/**
 * Servlet implementation class F_AdminLoginServlet
 */
@WebServlet("/adminLogin.em")
public class F_AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		Admin checkAdmin = new Admin();
		checkAdmin.setEmpId(adminId);
		checkAdmin.setPassword(adminPwd);
		
		Admin loginAdmin = new F_AdminService().checkLogin(checkAdmin);

		if(loginAdmin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", loginAdmin);
			session.setMaxInactiveInterval(40*60);
			response.sendRedirect(request.getContextPath() + "/selectAdminMain.em");
		}else {
			request.setAttribute("errorCode", "30");
			request.getRequestDispatcher("views/user/member/error/F_loginFalse.jsp").forward(request, response);
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
