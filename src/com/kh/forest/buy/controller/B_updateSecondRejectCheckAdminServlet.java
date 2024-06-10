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
 * Servlet implementation class B_updateSecondRejectCheckAdminServlet
 */
@WebServlet("/updateSecondRejectCheck.ad")
public class B_updateSecondRejectCheckAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_updateSecondRejectCheckAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buyNoVal = request.getParameter("buyNoVal");
		String reasonVal = request.getParameter("reasonVal");
		
		BuyInfo buyinfo = new BuyInfo();
		buyinfo.setBuyNo(buyNoVal);
		buyinfo.setReason(reasonVal);
		
		//System.out.println("reasonVal:" + reasonVal);
		
		int result = new B_buyService().updateSecondRejectCheck(buyinfo);
		
		String page = "";
		if(result > 0) {
			page = "/selectRequestList.ad";
			request.setAttribute("buyinfo", buyinfo);
			
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "2차검수매입불가패이지 실팻");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
