package com.kh.forest.buy.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyAttachment;
import com.kh.forest.buy.model.vo.BuyInfo;
import com.kh.forest.buy.model.vo.BuyProduct;
import com.kh.forest.common.E_ImgRenamePolicy;
import com.kh.forest.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class B_insertPhotoServlet
 */
@WebServlet("/insertPhoto.ca")
public class B_insertPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_insertPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(ServletFileUpload.isMultipartContent(request)) {
			//최대 용량
			int maxSize = 1024 * 1024 * 10;
			
			//웹 서버 경로
			String root = request.getSession().getServletContext().getRealPath("/");
			
			//System.out.println("웹서버경로 : " + root);
			
			//파일 저장 경로
			String savePath = root + "photo_uploadFiles/";
			
			MultipartRequest multiRequest = 
					new MultipartRequest(request, savePath, maxSize, 
							"UTF-8", new E_ImgRenamePolicy());
			
			//리네임이름
			ArrayList<String> saveFiles = new ArrayList<String>();
			
			//원본파일이름
			ArrayList<String> originFiles = new ArrayList<String>();
			
			//name 꺼내기
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				//System.out.println("파일이름: " + name);
				
				//리네임 파일 꺼내기
				saveFiles.add(multiRequest.getFilesystemName(name));
				//원본파일 꺼내기
				originFiles.add(multiRequest.getOriginalFileName(name));
				
			}
			
			HttpSession session = request.getSession();
			HashMap<String, String> exampleMap = (HashMap<String, String>) session.getAttribute("exampleMap");
			
			
			BuyProduct buyProduct = (BuyProduct) session.getAttribute("buyProduct");
			Member loginMember = (Member) session.getAttribute("loginMember");
			String userNo = multiRequest.getParameter("userNo");
			String safeKey = multiRequest.getParameter("safeKey");
			String grade = multiRequest.getParameter("grade");
			String buyStatus = "1차검수신청";
			
				
			
			BuyInfo buyinfo = new BuyInfo();
			buyinfo.setBuyProductNo(buyProduct.getBuyProductNo());
			buyinfo.setUserNo(loginMember.getUserNo());
			buyinfo.setSafeKey(safeKey);
			buyinfo.setBuyStatus(buyStatus);
			buyinfo.setGrade(grade);
			
			
			int price = new B_buyService().selectBuyPrice(buyinfo);
			
			buyinfo.setBuyPrice(price);
			
			int buyno2 = new B_buyService().insertbuyinfotable(buyinfo);
			
			String buyNo = String.valueOf(buyno2);
			buyinfo.setBuyNo(buyNo);
			
			
			//매입이력에 남기기
	        int history = new B_buyService().insertbuyhistory(buyNo);
			
			int result1 = new B_buyService().insertUserCheckList(buyNo, buyinfo, exampleMap);
			System.out.println("checkListResult : " + result1);
			//arrayList에 사진 저장
			ArrayList<BuyAttachment> fileList = new ArrayList<BuyAttachment>();
			
			for(int i = originFiles.size() -1; i >= 0; i--) {
				
				BuyAttachment ba = new BuyAttachment();
				ba.setFilePath(savePath);
				ba.setOriginName(originFiles.get(i));
				ba.setChangeName(saveFiles.get(i));
				
				fileList.add(ba);
				
			}
			
			//사진 인설트
			int result = new B_buyService().insertPhoto(fileList, buyNo);
			
			//System.out.println("파일리스트: " + fileList);
			if(result > 0) {
				response.sendRedirect("views/user/buy/B_buySuccessPage.jsp");
				//return;
				
			} else {
				
				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				}
				
				//request.setAttribute("msg", "사진등록실패");
				//request.getRequestDispatcher("views/user/buy/B_errorPage.jsp").forward(request, response);
				
			}
			
			/*System.out.println("리네임이름: " + saveFiles);
			System.out.println("원본이름 : " + originFiles);*/
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
