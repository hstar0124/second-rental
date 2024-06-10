package com.kh.forest.buy.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyInfo;

/**
 * Servlet implementation class B_updateSecondCheckAdminServlet
 */
@WebServlet("/updateSecondCheck.ad")
public class B_updateSecondCheckAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_updateSecondCheckAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//emp_answer에 insert하고 buy_info에 update해야함!
		
		String buyNoVal = request.getParameter("buyNoVal");
		String rank = request.getParameter("rank");
		int point = Integer.parseInt(request.getParameter("pointVal"));
		String reasonVal = request.getParameter("reasonVal");
		String userNo = request.getParameter("userNo");
		
		//System.out.println("포인트 : " + point);
		BuyInfo buyinfo = new BuyInfo();
		buyinfo.setBuyNo(buyNoVal);
		buyinfo.setGrade(rank);
		buyinfo.setBuyPrice(point);
		buyinfo.setChangePoint(point);
		buyinfo.setReason(reasonVal);
		buyinfo.setUserNo(userNo);
		
		
		//멤버테이블 포인트 조회 후 업데이트
		int memberResult = new B_buyService().selectPoint(userNo, point);
		//System.out.println("memberResult:" + memberResult);

		//2차검수 관리자 답변
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		String answer4 = request.getParameter("answer4");
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("1", answer1);
		hmap.put("2", answer2);
		hmap.put("3", answer3);
		hmap.put("4", answer4);
		
		
		int result = new B_buyService().updateSecondCheck(buyinfo, hmap);
		
		
		String page = "";
		if(result > 0) {
			page = "/forest/selectRequestList.ad";
			request.setAttribute("buyinfo", buyinfo);
			response.sendRedirect(page);		
		} else {
			//page = "views/user/buy/B_errorPage.jsp";
			//request.setAttribute("msg", "2차검수모달업데이트 실팻");
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
