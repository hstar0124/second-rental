package com.kh.forest.member.controller;

import java.io.FileReader;
import java.io.IOException;

import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Properties;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.wrapper.F_CryptoUtil;

import sun.security.krb5.internal.crypto.Aes256;

/**
 * Servlet implementation class F_memberCreateServlet
 */
@WebServlet("/memberCreate.me")
public class F_MemberCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public F_MemberCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String userName = request.getParameter("userName");
		String userNo = request.getParameter("userNo");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone1") + request.getParameter("phone2")
		+ request.getParameter("phone3");
		String email = request.getParameter("email1") + request.getParameter("email2");

		String postCode = request.getParameter("postcode");
		String roadAddress = request.getParameter("roadAddress");
		String detailAddress = request.getParameter("detailAddress");
		String address = postCode + "$" + roadAddress + "$" + detailAddress;
		String bank = request.getParameter("bankName");
		String accountHolder = request.getParameter("accountName");
		String account = request.getParameter("account");

		String emailCkCode = request.getParameter("emailCkCode");
		
		
		if(!userId.equals("") && !password1.equals("") && !userName.equals("") && !userNo.equals("") &&
				!gender.equals("") && !email.equals("") && ! phone.equals("") && !postCode.equals("") &&
				!accountHolder.equals("") && !account.equals("")) {
			Member createMember = new Member();
			createMember.setUserId(userId);
			createMember.setPassword(password1);
			createMember.setUserName(userName);
			createMember.setBirth(userNo);
			createMember.setGender(gender);
			createMember.setPhone(phone);
			createMember.setEmail(email);
			createMember.setAddress(address);
			createMember.setBank(bank);
			createMember.setAccountHolder(accountHolder);
			createMember.setAccount(account);
			
			int result = new F_MemberService().insertMember(createMember);
			
			String host     = "smtp.naver.com";
			final String user   = "voldaktmxj@naver.com";
			final String password  = "gold1043g2580";

			String to     = createMember.getEmail();

			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});

			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				// Subject
				message.setSubject("중고구마에 가입해주셔서 감사드립니다.");
				

				message.setContent("<div style=' font-weight:bold; width:700px; height:550px; margin:0 auto;'>\r\n" + 
						"        <div style='width:80%; height:60px; margin-left: 20px; margin-top: 20px; margin-bottom: 100px; font-size: 28px; color:white;text-align:center;'><img src=\"http:192.168.30.184:8001/forest/image/userimg/newMember.PNG\" width=\"650px;\" height=\"130px;\"></div>\r\n" + 
						"        <p style=\"font-size: 12px; margin-left: 70px; margin-top: 40px; margin-bottom: 30px;\">안녕하세요. 고객을 위한 중고 렌탈 중고구마 입니다.<br>\r\n" + 
						"            "+createMember.getUserName()+" ("+createMember.getUserId()+") 고객님의 회원가입을 축하드립니다.\r\n" + 
						"            회원님의 가입정보는 다음과 같습니다.\r\n" + 
						"            .</p>\r\n" + 
						"           \r\n" + 
						"            <label style=\"margin-left: 70px;\" >◎ 가입정보</label>\r\n" + 
						"            <table style=\"border-collapse: collapse; margin: 0 auto; margin-top: 10px;\">\r\n" + 
						"                <tr><td style=\"width:140px; border:1px solid #BABABA; height:30px; background: #E8E8E8; font-weight:400; text-align:center;\">아이디</td><td style=\"width:400px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+createMember.getUserId()+"</td></tr>\r\n" + 
						"            </table>\r\n" + 
						"            <p style=\"font-size: 12px; margin-left: 70px; margin-top: 20px;\">\r\n" + 
						"                다시 한번 저희 쇼핑몰에 가입해주셔서 고객님께 진심으로 감사드립니다.<br>\r\n" + 
						"                앞으로도 많은 관심 부탁드립니다.</p>\r\n" + 
						"             <div style=\"background: #E8E8E8; width: 100%;\">\r\n" + 
						"                <p style=\"font-size: 12px; margin-left: 100px; margin-top: 40px; font-weight: 400;\">(주)중고구마<br><br>\r\n" + 
						"                    대표 : 이호성  |  이메일 :  junggoguma@hobak.com  |  개인정보관리책임자 : 김성준<br>\r\n" + 
						"                    전화 : 1688-1007 (제휴/광고/거래처관련 문의는 메일만 받습니다.)<br>\r\n" + 
						"                    사업자등록번호 : 107-20-20202  |  통신판매업 신고 : 2020-강남구-1007<br>\r\n" + 
						"                    주소 : [06240] 서울특별시 강남구 테헤란로 14길 6 남도빌딩<br>\r\n" + 
						"                    교환/반품 주소 : 서울특별시 강남구 테헤란로 14길 6 남도빌딩<br><br>\r\n" + 
						"                    copyrightⓒ중고구마 All rights reserved\r\n" + 
						"                </p>\r\n" + 
						"            </div>   ", "text/html; charset=UTF-8");

				Transport.send(message);
				
				
				if(result >0) {
					response.sendRedirect("views/user/member/F_login.jsp");
				}else {
					System.out.println("실패!!!");
				}
				

			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			
		}else {
			request.setAttribute("errorCode", "3");
			request.getRequestDispatcher("views/user/member/error/F_loginFasle.jsp").forward(request, response);
		}
		



	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
