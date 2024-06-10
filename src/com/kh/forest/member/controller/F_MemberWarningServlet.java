package com.kh.forest.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.admin.model.vo.Admin;
import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Report;

/**
 * Servlet implementation class F_MemberWaringServlet
 */
@WebServlet("/updateWaring.me")
public class F_MemberWarningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public F_MemberWarningServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String[] arr = request.getParameter("num").split(",");
		
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("loginAdmin");
		
		List<String> boardNo = new ArrayList(); 
		
		for(String num : arr) {
			int i = 0;
			if(!boardNo.contains(num)) {
				boardNo.add(num);
			}
		}
		String host     = "smtp.naver.com";
		final String user   = "voldaktmxj@naver.com";
		final String password  = "gold1043g2580";
		List<Report> waringReport = new F_MemberService().selectAllWarning(boardNo);
		
		try {
			for(int i =0; i<waringReport.size(); i++) {
				Properties props = new Properties();
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.auth", "true");
				
				Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});
			
			String to = waringReport.get(i).getEmail();
			
			MimeMessage message = new MimeMessage(session1);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Subject
			message.setSubject("중고구마  회원 경고 메일입니다");
			
			message.setContent("<div style=' font-weight:bold; width:700px; height:638px; margin:0 auto;'>\r\n" + 
					"        <div style='width:80%; height:60px; margin-left: 20px; margin-top: 20px; margin-bottom: 100px; font-size: 28px; color:white;text-align:center;'><img src=\"http:192.168.30.184:8001/forest/image/userimg/warningMail.PNG\" width=\"650px;\" height=\"130px;\"></div>\r\n" + 
					"        <p style=\"font-size: 12px; margin-left: 70px; margin-top: 40px;\">안녕하세요. (주) 중고구마 입니다.<br>\r\n" + 
					"            "+ waringReport.get(i).getToUserName()+" 고객님께서 작성하신 리뷰글("+waringReport.get(i).getrBorderNo()+")에 대한 신고에 대해 <br> "
							+ "해당 리뷰글은 삭제되며 고객님의 계정은 경고조치 되었습니다.</p>\r\n" + 
					"            <table style=\"border-collapse: collapse; margin: 0 auto; margin-top: 30px; margin-bottom: 50px;\"><tr ><th style=\"width:180px; border:1px solid  #BABABA; background: #E8E8E8; font-weight:400;\">리뷰번호</th><th style=\"width:180px; border:1px solid #BABABA;background: #E8E8E8; font-weight:400;\">리뷰제목</th><th style=\"width:180px; border:1px solid  #BABABA;background: #E8E8E8; font-weight:400;\">경고사유</th></tr> \r\n" + 
					"                <tr><td style=\"width:150px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+waringReport.get(i).getrBorderNo()+"</td><td style=\"width:150px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+waringReport.get(i).getrTitle()+"</td><td style=\"width:150px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+waringReport.get(i).getReason()+"</td></tr>\r\n" + 
					"            </table>\r\n" + 
					"            <label style=\"margin-left: 70px;\" >◎  경고 안내</label>\r\n" + 
					"            <p style=\"font-size: 12px; margin-left: 70px;\">현재 고객님의 경고 횟수는 "+ (waringReport.get(i).getWarningCount()+1) +"회 입니다.<br>\r\n" + 	
					"            <p style=\"font-size: 12px; margin-left: 70px;\">회원 경고 시 3회 이상이 되시면 계정이 자동으로 탈퇴 처리될 수 있음을 알립니다.<br>\r\n" + 		
					"            <p style=\"font-size: 12px; margin-left: 70px; margin-top: 40px;\">항상 고객님께서 만족하실 수 있도록 정성껏 모시겠습니다.<br>\r\n" + 
					"                기타 문의사항이 있으시면 저희 쇼핑몰 고객 서비스 센터로 연락 주십시오.<br>\r\n" + 
					"                다시 한번 저희 쇼핑몰을 이용해주신 "+ waringReport.get(i).getToUserName()+" 고객님께 진심으로 감사드립니다.</p>\r\n" + 
					"             <div style=\"background: #E8E8E8; width: 100%;\">\r\n" + 
					"                <p style=\"font-size: 12px; margin-left: 100px; margin-top: 40px; font-weight: 400;\">(주)중고구마<br><br>\r\n" + 
					"                    대표 : 이호성  |  이메일 :  junggoguma@hobak.com  |  개인정보관리책임자 : 김성준<br>\r\n" + 
					"                    전화 : 1688-1007 (제휴/광고/거래처관련 문의는 메일만 받습니다.)<br>\r\n" + 
					"                    사업자등록번호 : 107-20-20202  |  통신판매업 신고 : 2020-강남구-1007<br>\r\n" + 
					"                    주소 : [06240] 서울특별시 강남구 테헤란로 14길 6 남도빌딩<br>\r\n" + 
					"                    교환/반품 주소 : 서울특별시 강남구 테헤란로 14길 6 남도빌딩<br><br>\r\n" + 
					"                    copyrightⓒ중고구마 All rights reserved\r\n" + 
					"                </p>\r\n" + 
					"            </div>   \r\n" + 
					"    </div>"
					, "text/html; charset=UTF-8");

			Transport.send(message);
			
			}
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
		int result = new F_MemberService().updateWarning(waringReport, admin);
	
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/reportSelectAll.me");
		}else {
			request.setAttribute("errorCode", "55");
			request.getRequestDispatcher("views/user/member/error/F_loginFalse.jsp").forward(request, response);
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
