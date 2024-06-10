package com.kh.forest.order.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class tokenServlet
 */
@WebServlet("/token.or")
public class C_tokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_tokenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		json.put("imp_key", "5384386914999679");
		json.put("imp_secret", "WPyFOqupNlRacy7jX7fWO0V2i7C2DnLAckf0LJpz5hJiQRBNYRKNRFQaMtcqQY12jg340tD6LnoBe0oc");
		
		String token = "";
		try {
			token = new C_PaymentAPIMethod().getToken(request, response, json);
			System.out.println(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().print(token);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
