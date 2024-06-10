package com.kh.forest.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.forest.coolsms.Coolsms;





@WebServlet("/sms")
public class F_CreateMemberSendSmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public F_CreateMemberSendSmsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String phone = request.getParameter("phone");
		 
        String api_key = "NCSZFHU4FIYI4J8Q";
        String api_secret = "TIHMKVXLJFW9IK1KAEBFQXICFUTEGMXK";
        Coolsms coolsms = new Coolsms(api_key, api_secret);
    
        /*
         * Parameters
         * 관련정보 : http://www.coolsms.co.kr/SDK_Java_API_Reference_ko#toc-0
         */
        HashMap<String, String> set = new HashMap<String, String>();
        set.put("to", phone); // 수신번호
        
        //인증번호 생성
        int dum1 =  new Random().nextInt(9)+1;
		int num2 = new Random().nextInt(9)+1;
		int rum3 = new Random().nextInt(9)+1;
		int zum4 = new Random().nextInt(9)+1; 
		int lum5 = new Random().nextInt(9)+1; 
		int lum6 = new Random().nextInt(9)+1; 
		String test = "";
				
		test = Integer.toString(num2) + rum3 + zum4 + lum5 + lum6;
      
        set.put("from", "01041148566"); // 발신번호 
        set.put("text", "중고구마 휴대폰 인증 번호입니다\n" + test); // 문자내용
        set.put("type", "sms"); // 문자 타입

        
        JSONObject result = coolsms.send(set); // 보내기&전송결과받기
        if ((boolean) result.get("status")) {
            // 메시지 보내기 성공 및 전송결과 출력
        	PrintWriter out = response.getWriter();
			
			out.print(test);
			
        } else {
            // 메시지 보내기 실패
            System.out.println("실패");
            System.out.println(result.get("code")); // REST API 에러코드
            System.out.println(result.get("message")); // 에러메시지
        }        
    }    
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
