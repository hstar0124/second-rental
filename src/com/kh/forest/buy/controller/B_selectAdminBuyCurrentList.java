package com.kh.forest.buy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyInfo;
import com.kh.forest.member.model.vo.PageInfo;

/**
 * Servlet implementation class B_selectAdminBuyCurrentList
 */
@WebServlet("/selectCurrentList.ad")
public class B_selectAdminBuyCurrentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectAdminBuyCurrentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		
		limit = 10;
		
		B_buyService bs = new B_buyService();
		int listCountCurrent = bs.getListCountCurrent();
		
		
		maxPage = (int) ((double) listCountCurrent / limit + 0.9);
		
		startPage = (((int) ((double) currentPage / limit + 0.9)) - 1 ) * 10  + 1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCountCurrent, limit, maxPage, startPage, endPage);
		
		ArrayList<BuyInfo> list = new B_buyService().selectCurrentList(pi);
		
		String page = "";
		if(list != null) {
			page = "views/admin/buyManagement/B_buyCurrentList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "매입현황관리게시판목록조회실햇");
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
