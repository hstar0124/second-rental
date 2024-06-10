package com.kh.forest.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.forest.common.E_ImgRenamePolicy;
import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.Product;
import com.kh.forest.product.model.vo.ProductAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class E_InventroyInsertServlet
 */
@WebServlet("/inventoryInsert")
public class E_InventroyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public E_InventroyInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024*1024*10;

			String root = request.getSession().getServletContext().getRealPath("/");

			String savePath = root+"/image/inspectImg/";

			MultipartRequest multiRequest = 
					new MultipartRequest(request, savePath, maxSize, "UTF-8", new E_ImgRenamePolicy());

			ArrayList<String> originNames = new ArrayList<String>();
			ArrayList<String> changeNames= new ArrayList<String>();

			Enumeration<String> files = multiRequest.getFileNames();

			while(files.hasMoreElements()) {
				String name = files.nextElement();

				originNames.add(multiRequest.getOriginalFileName(name));
				changeNames.add(multiRequest.getFilesystemName(name));
			}

			String buyNo = multiRequest.getParameter("buyNo");
			String categoryNo = multiRequest.getParameter("categoryNo");
			String buyProductNo= multiRequest.getParameter("buyProductNo");
			String manufacturerNo = multiRequest.getParameter("manufacturerNo");
			String grade = multiRequest.getParameter("grade");
			String marketprice = multiRequest.getParameter("price");
			String price = multiRequest.getParameter("price");
			String empNo = multiRequest.getParameter("empNo");
			String warehouseNo = multiRequest.getParameter("warehouseNo");
			String productNo = multiRequest.getParameter("productNo");
			String productName = multiRequest.getParameter("productName");
			String specialNote = multiRequest.getParameter("specialNote");

			Product insertProduct = new Product();

			insertProduct.setProductNo(productNo);
			insertProduct.setManufacturerNo(manufacturerNo);
			insertProduct.setBuyNo(buyNo);
			insertProduct.setCategoryNo(categoryNo);
			insertProduct.setProductName(productName);
			insertProduct.setWarehouseNo(warehouseNo);
			insertProduct.setBuyPrice(price);
			insertProduct.setBuyProductNo(buyProductNo);
			insertProduct.setEmpNo(empNo);
			insertProduct.setGrade(grade);
			insertProduct.setSepcialNote(specialNote);

			ArrayList<ProductAttachment> insertAttachmentList = new ArrayList<ProductAttachment>();

			for(int i = originNames.size()-1 ; i >=0; i--) {
				if(originNames.get(i)!=null) {
					ProductAttachment pa = new ProductAttachment();
					pa.setOriginName(originNames.get(i));
					pa.setChangeName(changeNames.get(i));
					pa.setSavePath(savePath);
					pa.setProductNo(productNo);

					insertAttachmentList.add(pa);
				}
			}   

			int result = new E_ProductService().inventoryInsert(insertProduct, insertAttachmentList);
			if(result > 0) {
				response.sendRedirect(request.getContextPath()+"/inventoryList");
			}else {
				for(int i = 0 ; i < changeNames.size(); i++) {
					File faildFile = new File(savePath +changeNames.get(i));
					faildFile.delete();
				}
				request.setAttribute("msg", "상품사진게시판 등록 실패!");
				request.getRequestDispatcher("views/admin/common/E_errorPage.jsp").forward(request, response);
			}
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
