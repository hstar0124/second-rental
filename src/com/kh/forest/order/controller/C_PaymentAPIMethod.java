package com.kh.forest.order.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class C_PaymentAPIMethod {

	
	//토큰 불러오기 메소드
	public String getToken(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws Exception {

		// requestURL 아임퐅크 고유키, 시크릿 키 정보를 포함하는 url 정보

		String _token = "";

		try {

			// 불러온 정보를 string형식으로 저장하기 위함
			String requestString = "";

			URL url = new URL("https://api.iamport.kr/users/getToken");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// url 연결은 입출력이 가능한데, 연결을 출력용으로 쓰려면 true, 아니면 false로 세팅
			connection.setDoOutput(true);

			connection.setInstanceFollowRedirects(false);

			connection.setRequestMethod("POST");

			connection.setRequestProperty("Content-Type", "application/json");

			OutputStream os = connection.getOutputStream();

			os.write(json.toString().getBytes());

			connection.connect();

			StringBuilder sb = new StringBuilder();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

				String line = null;

				while ((line = br.readLine()) != null) {

					sb.append(line + "\n");

				}

				br.close();

				requestString = sb.toString();

			}

			os.flush();

			connection.disconnect();

			// json형식으로 받은 객체를 파싱하기 위함
			JSONParser jsonParser = new JSONParser();

			JSONObject jsonObj = (JSONObject) jsonParser.parse(requestString);

			// 성공적으로 값을 가져오면 code 값을 0으로 가져옴
			if ((Long) jsonObj.get("code") == 0) {

				JSONObject getToken = (JSONObject) jsonObj.get("response");

				//System.out.println("getToken==>>" + getToken.get("access_token"));

				_token = (String) getToken.get("access_token");

			}

		} catch (Exception e) {

			e.printStackTrace();

			_token = "";

		}

		return _token;

	}

	
	//결제내역 조회 메소드(최대 100개인 그거)
	public JSONArray getPayList(HttpServletRequest request, HttpServletResponse response, String token,	String merchant_uid) {

		JSONArray jsonList = null;

		try {
			String requestString = "";
			URL url = new URL("https://api.iamport.kr/payments/findAll/"+merchant_uid);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoOutput(false);

			connection.setInstanceFollowRedirects(false);

			connection.setRequestMethod("GET");

			// header에 token 저장
			connection.setRequestProperty("Authorization", token);

			StringBuilder sb = new StringBuilder();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

				String line = null;

				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}

				br.close();

				requestString = sb.toString();
			}
			

			connection.disconnect();

			JSONParser jsonParser = new JSONParser();

			JSONObject jsonObj = (JSONObject) jsonParser.parse(requestString);

			if ((Long) jsonObj.get("code") == 0) {
				JSONObject getlist = (JSONObject) jsonObj.get("response");

				jsonList = (JSONArray) getlist.get("list");

			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonList;
	}
	
	
	
	
	//결제취소하기 메소드
	public String calcelPay(HttpServletRequest request, HttpServletResponse response, String token, JSONObject json,	String imp_uid) {
		
		JSONArray jsonList = null;
		String result = "실패";
		try {
			String requestString = "";
			URL url = new URL("https://api.iamport.kr/payments/cancel/");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setDoOutput(true);
			
			connection.setInstanceFollowRedirects(false);
			
			connection.setRequestMethod("POST");
			
			// header에 token 저장
			connection.setRequestProperty("Authorization", token);
			connection.setRequestProperty("Content-Type", "application/json");
			
			OutputStream os = connection.getOutputStream();

			os.write(json.toString().getBytes());
			
			StringBuilder sb = new StringBuilder();
			
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				
				String line = null;
				
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				
				br.close();
				
				requestString = sb.toString();
			}
			
			os.flush();
			
			connection.disconnect();
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObj = (JSONObject) jsonParser.parse(requestString);
			
			if ((Long) jsonObj.get("code") == 0) {
				JSONObject getlist = (JSONObject) jsonObj.get("response");
				
				jsonList = (JSONArray) getlist.get("list");
				
				result = "성공";
			}else {
				long re = (Long) jsonObj.get("code");
				//System.out.println(re);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
