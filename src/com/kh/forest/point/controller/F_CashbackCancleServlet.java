package com.kh.forest.point.controller;

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

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.point.model.service.F_PointService;
import com.kh.forest.point.model.vo.CashbackHistory;

/**
 * Servlet implementation class F_CashbackCancleServlet
 */
@WebServlet("/cnacleCashback.po")
public class F_CashbackCancleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_CashbackCancleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] arr = request.getParameter("num").split(",");
		String reason = request.getParameter("cancleReason");
		List<String> cashbackNo = new ArrayList(); 

		
		String email = "";
		String host     = "smtp.naver.com";
		final String user   = "voldaktmxj@naver.com";
		final String password  = "gold1043g2580";
		
		
		for(String num : arr) {
			int i = 0;
			if(!cashbackNo.contains(num)) {
				cashbackNo.add(num);
			}
		}
		List<CashbackHistory> proList = new F_PointService().selectMemberCashbackPro(cashbackNo);
		
		
		try {
			for(int i =0; i<proList.size(); i++) {
				Properties props = new Properties();
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.auth", "true");
				
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});
			
			String to = proList.get(i).getEmail();
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Subject
			message.setSubject("중고구마  환급 취소 안내 매일입니다");
			
			message.setContent("<div style=' font-weight:bold; width:700px; height:638px; margin:0 auto;'>\r\n" + 
					"        <div style='width:80%; height:60px; margin-left: 20px; margin-top: 20px; margin-bottom: 100px; font-size: 28px; color:white;text-align:center;'><img src=\"http:192.168.30.184:8001/forest/image/userimg/cashbackNo.PNG\" width=\"650px;\" height=\"130px;\"></div>\r\n" + 
					"        <p style=\"font-size: 12px; margin-left: 70px; margin-top: 40px;\">안녕하세요. (주) 중고구마 입니다.<br>\r\n" + 
					"            "+ proList.get(i).getUserName()+" 고객님께서 요청하신 환급 처리가 취소 처리 되었습니다.</p>\r\n" + 
					"            <table style=\"border-collapse: collapse; margin: 0 auto; margin-top: 30px; margin-bottom: 50px;\"><tr ><th style=\"width:180px; border:1px solid  #BABABA; background: #E8E8E8; font-weight:400;\">환급번호</th><th style=\"width:180px; border:1px solid #BABABA;background: #E8E8E8; font-weight:400;\">환급금액</th><th style=\"width:180px; border:1px solid  #BABABA;background: #E8E8E8; font-weight:400;\">취소사유</th></tr> \r\n" + 
					"                <tr><td style=\"width:150px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+proList.get(i).getCashbackNo()+"</td><td style=\"width:150px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+proList.get(i).getMoney()+"</td><td style=\"width:150px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+reason+"</td></tr>\r\n" + 
					"            </table>\r\n" + 
					"            <label style=\"margin-left: 70px;\" >◎ 환급 계좌 정보</label>\r\n" + 
					"            <table style=\"border-collapse: collapse; margin: 0 auto; margin-top: 10px;\"><tr ><td style=\"width:110px; border:1px solid  #BABABA; text-align:center; background:#E8E8E8; font-weight:400;\">은행</td><td style=\"width:300px; border:1px solid #BABABA; font-weight:400;text-align:center;\">"+proList.get(i).getBankName()+"</td></tr> \r\n" + 
					"                <tr><td style=\"width:140px; border:1px solid  #BABABA; background: #E8E8E8; font-weight:400; text-align:center;\">계좌번호</td><td style=\"width:400px; border:1px solid  #BABABA; font-weight:400; text-align:center;\">"+proList.get(i).getAccount()+"</td></tr>\r\n" + 
					"            </table>\r\n" + 
					"            <p style=\"font-size: 12px; margin-left: 70px; margin-top: 40px;\">항상 고객님께서 만족하실 수 있도록 정성껏 모시겠습니다.<br>\r\n" + 
					"                기타 문의사항이 있으시면 저희 쇼핑몰 고객 서비스 센터로 연락 주십시오.<br>\r\n" + 
					"                다시 한번 저희 쇼핑몰을 이용해주신 "+ proList.get(i).getUserName()+" 고객님께 진심으로 감사드립니다.</p>\r\n" + 
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
			if(proList != null) {
			int result = new F_PointService().cancleCashback(proList, reason);
			if(result>0) {
				
				int result1 = new F_PointService().canclePoint(proList);
				if(result1 > 0) {
				
					response.sendRedirect(request.getContextPath() + "/cashbackCancleAll.po");
				}else {
					
				}
				
			}
			
			}
			
		} catch (MessagingException e) {
			e.printStackTrace();
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
