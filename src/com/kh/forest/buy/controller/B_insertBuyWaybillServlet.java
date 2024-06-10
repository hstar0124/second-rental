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
 * Servlet implementation class B_insertBuyWaybillServlet
 */
@WebServlet("/insertBuyWaybill.buy")
public class B_insertBuyWaybillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_insertBuyWaybillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//buyinfo 테이블 주소 업데이트, 배송테이블 운송장번호 업데이트
		
		String carrier = request.getParameter("carrier");
		String waybillNo = request.getParameter("waybillNo");
		String buyNoVal = request.getParameter("buyNoVal");
		String address = request.getParameter("address");
		
		String[] arr = address.split("[,]");
		String zip = arr[0];
		String add1 = arr[1];
		String add2 = arr[2];
		String buyAddress = zip + "$" + add1 + "$" + add2;
		
		System.out.println("zip: " + zip);
		System.out.println("add1: " + add1);
		System.out.println("add2: " + add2);
		System.out.println("buyAddress: " + buyAddress);
		
		BuyInfo buyinfo = new BuyInfo();
		buyinfo.setCarrier(carrier);
		buyinfo.setWaybillNo(waybillNo);
		buyinfo.setBuyNo(buyNoVal);
		buyinfo.setBuyAddress(buyAddress);
		
		int result = new B_buyService().insertWaybill(buyinfo);
		
		String page = "";
		if(result > 0) {
			page = "/forest/mypageBuylist.buy";
			request.setAttribute("buyinfo", buyinfo);
			response.sendRedirect(page);
			
		} else {
			/*page = "views/user/buy/B_errorPage.jsp";
			request.setAttribute("msg", "운송장입력실패!");
			request.getRequestDispatcher(page).forward(request, response);*/
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
