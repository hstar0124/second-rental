package com.kh.forest.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.review.model.service.D_ReviewService;
import com.kh.forest.review.model.vo.PageInfo;
import com.kh.forest.review.model.vo.Review;

/**
 * Servlet implementation class D_SelectReviewListServlet
 */
@WebServlet("/selectList.re")
public class D_SelectReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_SelectReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ArrayList<HashMap<String, Object>> list = new D_ReviewService().selectThumbnailList();
		//ArrayList<Review> list = new D_ReviewService().selectList();
		//System.out.println("Review list : " + list);
		
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else {
			currentPage = 1;
		}
		
		limit = 10;
		
		D_ReviewService ns = new D_ReviewService();
		//System.out.println("ns : "+ns);
		int listCount = ns.getListCount();
		System.out.println("listCount : "+ listCount);
		//System.out.println(" >>> : " + listCount);
		
		maxPage = (int)((double) listCount / limit + 0.9);
		
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 + 1;
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Review> list1 = new D_ReviewService().selectList(pi);
		//System.out.println("list1 : " + list1);
		String page = "";
		if(list1 != null) {
			page = "views/admin/community/D_reviewList.jsp";
			request.setAttribute("list", list1);
			request.setAttribute("pi", pi);
		} else { 
			page = "views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "공지사항 조회 실패!!");
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
