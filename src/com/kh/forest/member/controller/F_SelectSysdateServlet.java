package com.kh.forest.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.member.model.service.F_MemberService;

/**
 * Servlet implementation class F_SelectSysdateServlet
 */
@WebServlet("/selectSysdate.me")
public class F_SelectSysdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_SelectSysdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String sysdate = new F_MemberService().selectDate();
		  
		  String[] list = sysdate.split("/");
	      
	      if(sysdate != null) {
	         request.setAttribute("year", list[0]);
	         request.setAttribute("month", list[1]);
	         
	         request.getRequestDispatcher("/newMemberChart.me").forward(request, response);
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
