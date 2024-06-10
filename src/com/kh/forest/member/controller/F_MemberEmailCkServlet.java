package com.kh.forest.member.controller;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.kh.forest.member.model.vo.Member;

/**
 * Servlet implementation class F_MemberEmailCkServlet
 */
@WebServlet("/userEmailCk.me")
public class F_MemberEmailCkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_MemberEmailCkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession();
		Member user1 = (Member)session1.getAttribute("loginMember");
		String email = user1.getEmail();
		String host     = "smtp.naver.com";
		final String user   = "voldaktmxj@naver.com";
		final String password  = "gold1043g2580";

		String to     = email;

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
			message.setSubject("중고구마 본인확인 인증 번호입니다.");
			int dum =  new Random().nextInt(9)+1;
			int num = new Random().nextInt(2)+1;
			int rum = new Random().nextInt(9)+1;
			char sum = (char) (new Random().nextInt(26)+97);
			int aum =  new Random().nextInt(9)+1;
			int zum = new Random().nextInt(9)+1;

			char pnum = ' ';
			char lnum = ' ';
			String str = "";
			if(num ==1) {
				pnum = (char) (new Random().nextInt(26)+65);
			}else {
				pnum = (char) (new Random().nextInt(26)+97);
			}

			if(zum>=4 && zum<7) {
				lnum = (char) (new Random().nextInt(26)+97);
				str = dum + Character.toString(pnum) + rum + Character.toString(sum) + aum + lnum;
			}else if(zum<4) {
				lnum = (char) (new Random().nextInt(26)+65);
				str = dum + Character.toString(pnum) + rum + Character.toString(sum) + aum + lnum;
			}else {
				str = dum + Character.toString(pnum) + rum + Character.toString(sum) + aum + zum;
			}

			message.setText(str);
			message.setContent("<div style=' font-weight:bold; width:700px; height:559px; margin:0 auto;'>\r\n" + 
					"       <div style='width:80%; height:60px; margin-left: 20px; margin-top: 20px; margin-bottom: 80px; font-size: 28px; color:white;text-align:center;'><img src=\"http:192.168.30.184:8001/forest/image/userimg/okCode.PNG\" width=\"650px;\" height=\"130px;\"></div>\r\n" + 
					"        <p style=\"font-size: 12px; margin-left: 70px; margin-bottom: 30px; margin-top: 10px;\">안녕하세요. (주) 중고구마 입니다.<br>\r\n" + 
					"            저희 쇼핑몰을 이용해 주셔서 감사드립니다.<br>\r\n" + 
					"            아래 인증 문자를 인증번호 입력창에 입력하여 진행해 주시기 바랍니다.</p>\r\n" + 
					"           \r\n" + 
					"            <label style=\"margin-left: 70px;\" >◎ 인증번호</label>\r\n" + 
					"            <table style=\"border-collapse: collapse; margin: 0 auto; margin-top: 10px;\">\r\n" + 
					"                <tr><td style=\"width:140px; border:1px solid #BABABA; height:30px; background: #E8E8E8; font-weight:400; text-align:center;\">인증번호</td><td style=\"width:400px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+str+"</td></tr>\r\n" + 
					"            </table>\r\n" + 
					"            <p style=\"font-size: 12px; margin-left: 70px; margin-top: 0px;\">  º 인증번호 입력창에 인증번호를 정확히 입력해주세요.<br><br><br>\r\n" + 
					"                다시 한번 저희 쇼핑몰을 이용해주신 고객님께 진심으로 감사드립니다.<br>\r\n" + 
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
					"    </div>", "text/html; charset=UTF-8");

			Transport.send(message);
			
			PrintWriter out = response.getWriter();
			
			out.print(str);
			out.flush();
			out.close();

		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
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
