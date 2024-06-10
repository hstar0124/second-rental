package com.kh.forest.buy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.forest.buy.model.service.B_buyService;
import com.kh.forest.buy.model.vo.BuyProduct;

/**
 * Servlet implementation class B_selecAjaxUserCheckListServlet
 */
@WebServlet("/selectAjaxUserCheckList.ad")
public class B_selecAjaxUserCheckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selecAjaxUserCheckListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buyNoVal = request.getParameter("buyNoVal");
		
		ArrayList<HashMap<String, String>> exampleList = new B_buyService().selectExampleList(buyNoVal);
		
		JSONArray result = new JSONArray();
		JSONObject content = null;
		
		for(int i = 0; i < exampleList.size(); i++) { 
            HashMap<String, String> hmap = exampleList.get(i); 
            
            content = new JSONObject();
            content.put("questionContent", URLEncoder.encode(hmap.get("questionContent"), "UTF-8"));
            content.put("answerContent", URLEncoder.encode(hmap.get("answerContent"), "UTF-8"));
            content.put("questionNo", URLEncoder.encode(hmap.get("questionNo"), "UTF-8"));
            content.put("answerNo", URLEncoder.encode(hmap.get("answerNo"), "UTF-8"));
            
            result.add(content);
		}

		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
