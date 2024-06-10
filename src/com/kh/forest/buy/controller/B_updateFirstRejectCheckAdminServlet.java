package com.kh.forest.buy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyInfo;

/**
 * Servlet implementation class B_updateFirstRejectCheckAdminServlet
 */
@WebServlet("/updateFirstCheckReject.ad")
public class B_updateFirstRejectCheckAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_updateFirstRejectCheckAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reasonVal = request.getParameter("reasonVal");
		String buyNoVal = request.getParameter("buyNoVal");
		
		BuyInfo buyinfo = new BuyInfo();
		buyinfo.setReason(reasonVal);
		buyinfo.setBuyNo(buyNoVal);
		
		//System.out.println("reject:" + buyinfo);
		int result = new B_buyService().updateFirstCheckReject(buyinfo);
		
		String page = "";
		if(result > 0) {
			page = "/forest/selectRequestList.ad";
			request.setAttribute("buyinfo", buyinfo);
			response.sendRedirect(page);
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "1차검수매입불가업데이트실패!!");
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
