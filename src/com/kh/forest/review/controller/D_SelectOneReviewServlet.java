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
import com.kh.forest.review.model.vo.Review;
import com.kh.forest.review.model.vo.Review_Attachment;

/**
 * Servlet implementation class D_SelectOneReviewServlet
 */
@WebServlet("/selectOne.re")
public class D_SelectOneReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_SelectOneReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		//System.out.println("num : " + num);
		HashMap<String, Object> hmap = new D_ReviewService().selectThumbnailMap(num);
		
		//System.out.println("thumbnail map : " + hmap);
		
		Review r = (Review) hmap.get("review");
		//System.out.println("리뷰 r : " + r);
		ArrayList<Review_Attachment> fileList = (ArrayList<Review_Attachment>) hmap.get("fileList");
		//System.out.println("fileList : " + fileList);
		
		String page = "";
		if(hmap != null) {
			page = "views/user/mypage/D_ReviewDetail_U.jsp";
			request.setAttribute("review", r);
			request.setAttribute("fileList", fileList);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시판 상세 보기 실패!");
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
