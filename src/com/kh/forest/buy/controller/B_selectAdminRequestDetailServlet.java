package com.kh.forest.buy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyAttachment;
import com.kh.forest.buy.model.vo.BuyInfo;

/**
 * Servlet implementation class B_selectAdminRequestDetailServlet
 */
@WebServlet("/selectRequestDetail.ad")
public class B_selectAdminRequestDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectAdminRequestDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buyNo = request.getParameter("buyNo");
		
		BuyInfo buyinfo = new B_buyService().selectRequestDetail(buyNo);
		
		//사진불러오기
		HashMap<String, Object> hmap = new B_buyService().selectPhotoListDetail(buyNo);
		ArrayList<BuyAttachment> fileList = (ArrayList<BuyAttachment>) hmap.get("fileList");
		
		
		String page = "";
		if(buyinfo != null && fileList != null) {
			page = "views/admin/buyManagement/B_buydetail.jsp";
			request.setAttribute("buyNo", buyNo);
			request.setAttribute("buyinfo", buyinfo);
			request.setAttribute("fileList", fileList);
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "바이디테일 조회실패!");
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
