package com.kh.forest.buy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.buy.model.service.B_buyService;

/**
 * Servlet implementation class B_updateBuyStatusMypageServlet
 */
@WebServlet("/updateBuyStatusMyPage.buy")
public class B_updateBuyStatusMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_updateBuyStatusMypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buyNoVal = request.getParameter("buyNoVal");
		
		int result = new B_buyService().updateBuyStatus(buyNoVal);
		
		String page = "";
		if(result > 0) {
			page = "/forest/mypageBuylist.buy";
			request.setAttribute("buyNoVal", buyNoVal);
			response.sendRedirect(page);
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "견적확인상태업데이트 실패!");
			//request.getRequestDispatcher(page).forward(request, response);
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
