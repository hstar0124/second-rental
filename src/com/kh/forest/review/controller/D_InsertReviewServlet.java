package com.kh.forest.review.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.forest.review.model.service.D_ReviewService;
import com.kh.forest.review.model.vo.Review;
import com.kh.forest.review.model.vo.Review_Attachment;
import com.kh.forest.common.MyFileRenamePolicy;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class D_InsertReviewServlet
 */
@WebServlet("/insert.re")
public class D_InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_InsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달한 request가 multipart/form-data 방식으로 넘어온 데이터인지 확인하여 true, false 리턴
				if(ServletFileUpload.isMultipartContent(request)) {
					//전송 파일 용량 제한 : 10MB로 계산
					int maxSize = 1024 * 1024 * 10;
					
					//웹 서버 컨테이너(톰캣 내부의 web 폴더) 경로 추출
					String root = request.getSession().getServletContext().getRealPath("/");
					//System.out.println("root : " + root);
					
					//파일 저장 경로
					String savePath = root + "photo_uploadFiles/";
					//System.out.println("savePath : " + savePath);
					
					MultipartRequest multiRequest =
							new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					//System.out.println("multiRequest : " + multiRequest);
					
					//저장한 파일의 이름을 저장할 arrayList 생성
					ArrayList<String> saveFiles = new ArrayList<String>();
					//System.out.println("saveFiles : " + saveFiles);
					
					//원본 파일의 이름을 저장할 arrayList 생성
					ArrayList<String> originFiles = new ArrayList<String>();
					//System.out.println("originFiles : " + originFiles);
					
					//파일이 전송된 폼의 name값을 반환
					Enumeration<String> files = multiRequest.getFileNames();
					//System.out.println("files : " + files);
					
					while(files.hasMoreElements()) {
						String name = files.nextElement();
						//System.out.println("name : " + name);
						
						//리네임 파일 꺼내기
						saveFiles.add(multiRequest.getFilesystemName(name));
						//원본파일 꺼내기
						originFiles.add(multiRequest.getOriginalFileName(name));
					}
					
					//System.out.println("saveFiles : " + saveFiles);
					//System.out.println("originFiles : " + originFiles);
					
					
					//multipartRequest객체에서 파일 외의 값을 가져올 수 도 있다.
					
					String multiTitle = multiRequest.getParameter("title");
					String multiContent = multiRequest.getParameter("content");
					String multiproductNo = multiRequest.getParameter("productNo");
					//String rEnrollDate = multiRequest.getParameter("date");
					
					
					/*java.sql.Date day = null;
					java.sql.Date mday = null;
					if(rEnrollDate != "") {

						day = java.sql.Date.valueOf(rEnrollDate);
						mday = java.sql.Date.valueOf(rEnrollDate);
						
					} else {
						day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
					}*/
					//System.out.println("날짜 : " + rEnrollDate);
					//System.out.println("multiTitle : " + multiTitle);
					//System.out.println("multiContent : " + multiContent);
					
					//reivew 객체 생성
					Review review = new Review();
					review.setrBoardNo(review.getrBoardNo());
					review.setrTitle(multiTitle);
					review.setrContent(multiContent);
					review.setrWriter(((Member) request.getSession().getAttribute("loginMember")).getUserNo());
					review.setProductNo(multiproductNo);
					//review.setrEnrollDate(day);
					//review.setrModifyDate(mday);

					//여러 개의 Attachment정보를 ArrayList에 담기
					ArrayList<Review_Attachment> fileList = new ArrayList<Review_Attachment>();
					//전송 순서 역순으로 파일을 list에 저장했기 때문에 반복문을 역으로 수행함
					for(int i = originFiles.size() - 1; i >= 0; i--) {
						Review_Attachment at = new Review_Attachment();
						at.setSavePath(savePath);
						at.setOriginName(originFiles.get(i));
						at.setChangeName(saveFiles.get(i));
						
						if(i == originFiles.size() - 1) {
							at.setReviewLevel(0);
						} else {
							at.setReviewLevel(1);
						}
						
						fileList.add(at);
					}
					//System.out.println("review : " + review);
					//System.out.println("fileList : " + fileList);
					
					int result = new D_ReviewService().insertThumbnail(review, fileList);
					//System.out.println("result : " + result);
					
					if(result > 0) {
						response.sendRedirect(request.getContextPath() + "/selectList.re");
						//response.sendRedirect(request.getContextPath() + "/selectListUser.re");
					} else {
						//실패시 저장된 사진 삭제
						for(int i = 0; i < saveFiles.size(); i++) {
							File failedFile = new File(savePath + saveFiles.get(i));
							failedFile.delete();
						}
						
						request.setAttribute("msg", "사진게시판 등록 실패!");
						request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
					}
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
