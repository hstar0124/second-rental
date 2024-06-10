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
 * Servlet implementation class B_updateWaybillServlet
 */
@WebServlet("/updateWaybill.buy")
public class B_updateWaybillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_updateWaybillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String waybillNo = request.getParameter("waybillNo");
		String buyNo = request.getParameter("buyNo");
		
		BuyInfo buyinfo = new BuyInfo();
		buyinfo.setWaybillNo(waybillNo);
		buyinfo.setBuyNo(buyNo);
		
		//상태를 인수대기중에서 인수완료로 변경
		int result = new B_buyService().updatewaybillStatus(buyinfo);
		
		String page = "";
		if(result > 0) {
			page = "/selectRequestList.ad";
			request.setAttribute("buyinfo", buyinfo);
			//response.sendRedirect(page);
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "매입상태변경실패!");
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
