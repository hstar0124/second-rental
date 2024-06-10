package com.kh.forest.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.member.model.vo.Member;
import com.kh.forest.review.model.service.D_ReviewService;
import com.kh.forest.review.model.vo.PageInfo;
import com.kh.forest.review.model.vo.Review;

/**
 * Servlet implementation class D_SelectReviewListServletUser
 */
@WebServlet("/selectListUser.re")
public class D_SelectReviewListServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_SelectReviewListServletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ArrayList<HashMap<String, Object>> list = new D_ReviewService().selectThumbnailList();
				//ArrayList<Review> list = new D_ReviewService().selectListUser();
				//System.out.println("Review list : " + list);
				HttpSession session =request.getSession();
				
				Member member = (Member) session.getAttribute("loginMember");
				String userId = member.getUserId();
				
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
				int listCount = ns.getListCountUser(userId);
				
				maxPage = (int)((double) listCount / limit + 0.9);
				
				startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 + 1;
				endPage = startPage + 10 - 1;
				
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
				PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
				
				System.out.println("pi:" + pi);
				
				ArrayList<Review> list1 = new D_ReviewService().selectListUser(pi, userId);
				System.out.println("list1 : " + list1);
				String page = "";
				if(list1 != null) {
					page = "views/user/mypage/D_MyPageSection_review.jsp";
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
