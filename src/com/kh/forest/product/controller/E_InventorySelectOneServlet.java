package com.kh.forest.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.Category;
import com.kh.forest.product.model.vo.Product;
import com.kh.forest.product.model.vo.ProductAttachment;

/**
 * Servlet implementation class E_InventorySelectOneServlet
 */
@WebServlet("/selectOne")
public class E_InventorySelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_InventorySelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productNo = request.getParameter("productNo");
		
		Product selectOne = null;
		selectOne = new E_ProductService().selectOne(productNo);
		
		ArrayList<ProductAttachment> selectOneAttach = null;
		selectOneAttach = new E_ProductService().selectOneAttach(productNo);
		
		ArrayList<Category> list = new E_ProductService().selectCategory();
		String page="";
		if(selectOne != null && selectOneAttach != null) {
			request.setAttribute("selectOne", selectOne);
			request.setAttribute("selectOneAttach", selectOneAttach);
			request.setAttribute("list", list);
			page="views/admin/productManagement/E_inventoryDetail.jsp";
		}else {
			request.setAttribute("msg", "상세정보 데이터검색 실패!");
			page="views/admin/common/E_errorPage";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
