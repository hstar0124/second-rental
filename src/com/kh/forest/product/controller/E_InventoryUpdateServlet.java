package com.kh.forest.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.Product;

/**
 * Servlet implementation class E_InventoryUpdateServlet
 */
@WebServlet("/updateInventory")
public class E_InventoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E_InventoryUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryNo = request.getParameter("categoryNo");
		String grade = request.getParameter("grade");
		String specialNote = request.getParameter("specialNote");
		String warehouseNo = request.getParameter("warehouseName");
		String productNo = request.getParameter("productNo");
		Product requestUpdate = new Product();
		requestUpdate.setCategoryNo(categoryNo);
		requestUpdate.setGrade(grade);
		requestUpdate.setSepcialNote(specialNote);
		requestUpdate.setWarehouseNo(warehouseNo);
		requestUpdate.setProductNo(productNo);
		
		int result = new E_ProductService().updateInventory(requestUpdate);
		
		String page="";
		if(result>0) {
			page="inventoryList";
		}else {
			page="views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "재고 업데이트 실패!");
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
