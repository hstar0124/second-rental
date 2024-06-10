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
 * Servlet implementation class B_updateBuyAddressServlet
 */
@WebServlet("/updateBuyAddress.buy")
public class B_updateBuyAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_updateBuyAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buyNoVal = request.getParameter("buyNoVal");
		String address = request.getParameter("address");
		
		String[] arr = address.split("[,]");
		String zip = arr[0];
		String add1 = arr[1];
		String add2 = arr[2];
		String buyAddress = zip + "$" + add1 + "$" + add2;
		
/*		System.out.println("zip: " + zip);
		System.out.println("add1: " + add1);
		System.out.println("add2: " + add2);
		System.out.println("buyAddress: " + buyAddress);*/
		
		BuyInfo buyinfo = new BuyInfo();
		buyinfo.setBuyNo(buyNoVal);
		buyinfo.setBuyAddress(buyAddress);
		
		int result = new B_buyService().updateBuyAddress(buyinfo);
		
		String page = "";
		if(result > 0) {
			page = "/mypageBuylist.buy";
			request.setAttribute("buyinfo", buyinfo);
			
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "주소수정실패!");
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
