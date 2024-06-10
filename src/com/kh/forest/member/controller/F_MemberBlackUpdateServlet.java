package com.kh.forest.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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
import com.kh.forest.member.model.vo.Member;

/**
 * Servlet implementation class F_MemberBlackUpdateServlet
 */
@WebServlet("/memberBlackList.me")
public class F_MemberBlackUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberBlackUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = "";
		String host     = "smtp.naver.com";
		final String user   = "voldaktmxj@naver.com";
		final String password  = "gold1043g2580";
		List<String> boardNo = new ArrayList(); 

		String[] arr = request.getParameter("num").split(",");
		
		
		for(String num : arr) {
			int i = 0;
			if(!boardNo.contains(num)) {
				boardNo.add(num);
			}
		}
		
		List<Member> email1 = new F_MemberService().selectMemberEmail(boardNo);
		
		
		if(email1 != null) {
			
		try {
			for(int i =0; i<email1.size(); i++) {
				Properties props = new Properties();
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.auth", "true");
				
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});
			
			String to = email1.get(i).getEmail();
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Subject
			message.setSubject("중고구마  회원 제제 안내 메일입니다");
			
			message.setContent("<div style=' font-weight:bold; width:700px; height:544px; margin:0 auto;'>\r\n" + 
					"       <div style='width:80%; height:60px; margin-left: 20px; margin-top: 20px; margin-bottom: 80px; font-size: 28px; color:white;text-align:center;'><img src=\"http:192.168.30.184:8001/forest/image/userimg/warningMember.PNG\" width=\"650px;\" height=\"130px;\"></div>\r\n" + 
					"        <div style=\"font-size: 12px; margin-left: 70px; margin-top: 20px; margin-bottom: 20px;\">안녕하세요. 고객을 위한 중고 렌탈 중고구마 입니다.<br>\r\n" + 
					"            "+email1.get(i).getUserName()+"("+ email1.get(i).getUserId()+") 님께서 제제 회원이 되셨음을 알립니다.\r\n" + 
					"            경고 3회 누적으로 인해 해당 계정은 탈퇴 처리 됩니다.\r\n" + 
					"            문의는 하단의 고객센터로 연락부탁드립니다.\r\n" + 
					"            </div>\r\n" + 
					"           \r\n" + 
					"            <label style=\"margin-left: 70px;\" >◎ 불량회원 선정 사유</label>\r\n" + 
					"            <table style=\"border-collapse: collapse; margin: 0 auto; margin-top: 10px;\">\r\n" + 
					"                <tr><td style=\"width:140px; border:1px solid #BABABA; height:30px; background: #E8E8E8; font-weight:400; text-align:center;\">사유</td><td style=\"width:400px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">경고 3회 누적</td></tr>\r\n" + 
					"            </table>\r\n" + 
					"            <p style=\"font-size: 12px; margin-left: 70px; margin-top: 20px;\">\r\n" + 
					"                다시 한번 저희 쇼핑몰에 가입해주셔서 고객님께 진심으로 감사드립니다.<br>\r\n" + 
					"                앞으로도 많은 관심 부탁드립니다.</p>\r\n" + 
					"             <div style=\"background: #E8E8E8; width: 100%;\">\r\n" + 
					"                <p style=\"font-size: 12px; margin-left: 100px; margin-top: 40px; font-weight: 400;\">(주)중고구마<br>\r\n" + 
					"                    대표 : 이호성  |  이메일 :  junggoguma@hobak.com  |  개인정보관리책임자 : 김성준<br>\r\n" + 
					"                    전화 : 1688-1007 (제휴/광고/거래처관련 문의는 메일만 받습니다.)<br>\r\n" + 
					"                    사업자등록번호 : 107-20-20202  |  통신판매업 신고 : 2020-강남구-1007<br>\r\n" + 
					"                    주소 : [06240] 서울특별시 강남구 테헤란로 14길 6 남도빌딩<br>\r\n" + 
					"                    교환/반품 주소 : 서울특별시 강남구 테헤란로 14길 6 남도빌딩<br>\r\n" + 
					"                    copyrightⓒ중고구마 All rights reserved\r\n" + 
					"                </p>\r\n" + 
					"            </div>   \r\n" + 
					"    </div>"
					, "text/html; charset=UTF-8");

			Transport.send(message);
			
			int result = new F_MemberService().updateBlackMember(email1);
			
			System.out.println(result);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath()+"/warningMemberSelectAll.me");
			}else {
				request.setAttribute("errorCode", "86");
				request.getRequestDispatcher("views/user/member/error/F_loginFalse.jsp").forward(request, response);
			}
			
		}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		}else {
			request.setAttribute("errorCode", "86");
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
