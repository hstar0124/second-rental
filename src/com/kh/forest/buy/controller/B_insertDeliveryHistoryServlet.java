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
 * Servlet implementation class B_insertDeliveryHistoryServlet
 */
@WebServlet("/insertDeliveryHistory.ad")
public class B_insertDeliveryHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_insertDeliveryHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buyNo = request.getParameter("buyNo");
		String waybillNo = request.getParameter("waybillNo");
		String carrier = request.getParameter("carrier");
		
		BuyInfo buyinfo = new BuyInfo();
		buyinfo.setBuyNo(buyNo);
		buyinfo.setBuyWaybillNo(waybillNo);
		buyinfo.setBuyCarrier(carrier);

		int result = new B_buyService().insertDeliveryHistory(buyinfo);
		
		String page = "";
		if(result > 0) {
			page = "/forest/selectRejectList.ad";
			request.setAttribute("buyinfo", buyinfo);
			response.sendRedirect(page);
			
		} else {
			/*page = "veiws/user/buy/B_errorPage.jsp";
			request.setAttribute("msg", "운송장입력 실패");
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
