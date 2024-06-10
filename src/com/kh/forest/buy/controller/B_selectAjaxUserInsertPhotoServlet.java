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
import com.kh.forest.buy.model.vo.BuyInfo;
import com.sun.xml.internal.ws.api.message.Attachment;

/**
 * Servlet implementation class B_selectAjaxUserInsertPhotoServlet
 */
@WebServlet("/selectAjaxUserInsertPhoto.ad")
public class B_selectAjaxUserInsertPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_selectAjaxUserInsertPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buyNoVal = request.getParameter("buyNoVal");
		
		
		ArrayList<HashMap<String, String>> fileList = new B_buyService().selectPhotoList(buyNoVal);
		
		
		JSONArray result = new JSONArray();
		JSONObject pic = null;
		
		for(int i = 0; i < fileList.size(); i++) { 
            HashMap<String, String> hmap = fileList.get(i); 
            
            pic = new JSONObject();
            pic.put("buyAttachmentNo", URLEncoder.encode(hmap.get("buyAttachmentNo"), "UTF-8"));
            pic.put("originName", URLEncoder.encode(hmap.get("originName"), "UTF-8"));
            pic.put("changeName", URLEncoder.encode(hmap.get("changeName"), "UTF-8"));
            
            result.add(pic);
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
