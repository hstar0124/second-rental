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
 * Servlet implementation class B_insertFirstCheckAdminServlet
 */
@WebServlet("/updateFirstCheck.ad")
public class B_updateFirstCheckAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_updateFirstCheckAdminServlet() {
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
		//System.out.println("1차검수모달 buyinfo: " + buyinfo);
		
		int result = new B_buyService().updateFirstCheck(buyinfo);
		
		String page = "";
		if(result > 0) {
			page = "/forest/selectRequestList.ad";
			request.setAttribute("buyinfo", buyinfo);
			response.sendRedirect(page);
					
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "1차검수모달업데이트 실팻");
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
