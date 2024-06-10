package com.kh.forest.product.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.forest.common.E_ImgRenamePolicy;
import com.kh.forest.product.model.service.E_ProductService;
import com.kh.forest.product.model.vo.ProductAttachment;
import com.oreilly.servlet.MultipartRequest;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 * Servlet implementation class BarcodeInsertServlet
 */
@WebServlet("/barcodeInsert")
public class E_BarcodeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public E_BarcodeInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] categorys1 = request.getParameterValues("category1");
		String[] categorys2 = request.getParameterValues("category2");
		
		
		ArrayList<String> pArray = new ArrayList<String>();
		
		for(int i = 0 ; i < categorys1.length ; i++) {
			int j = 0 ;
			if(!categorys1[i].equals("0")) {
				String barcodeName = "";
				
				//대분류
				if(categorys1[i].equals("10")) {
					barcodeName = "D"+barcodeName;
				}else if(categorys1[i].equals("20")){
					barcodeName = "H"+barcodeName;
				}
				
				//소분류
				if(categorys2[j].equals("11")) {
					barcodeName = "N"+barcodeName;
				}else if(categorys2[j].equals("12")) {
					barcodeName = "T"+barcodeName;
				}else if(categorys2[j].equals("21")) {
					barcodeName = "D"+barcodeName;
				}else if(categorys2[j].equals("22")) {
					barcodeName = "C"+barcodeName;
				}else if(categorys2[j].equals("23")) {
					barcodeName = "B"+barcodeName;
				}
				
				SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMdd");
				Calendar time = Calendar.getInstance();
				String format_time = format.format(time.getTime());
				
				barcodeName = barcodeName+format_time;
				
				
				String random = (int)(Math.random()*999998+1)+"";
				
				for(int k = 0 ; k < 6-random.length() ; k++) {
					barcodeName += "0";
				}
				
				barcodeName += random;
				
				
				pArray.add(barcodeName);
				j++;
			}
		}
		//중복값 확인
		
		ArrayList<String> insertBarcodeList = new E_ProductService().checkBarcodeList(pArray);
		
		//바코드 직접입력시 썼던 값
		/*String[] pArray = request.getParameterValues("productId");*/
		E_ImgRenamePolicy irp = new E_ImgRenamePolicy();

		ArrayList<ProductAttachment> list = new ArrayList<ProductAttachment>();
		int result = 0;
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath =  root+"/image/barcodeNewImg/";

		for(int i = 0 ; i < pArray.size() ; i++) {
			if(pArray.get(i) != "" && pArray.get(i) != null) {
				String name = pArray.get(i);
				net.sourceforge.barbecue.Barcode barcode;
				try {
					barcode = BarcodeFactory.createCode128B(pArray.get(i));
					File oldFile = new File(savePath+pArray.get(i)+".png");
					File newFile = irp.rename(oldFile);
					
					BarcodeImageHandler.savePNG(barcode, newFile);
					ProductAttachment b = new ProductAttachment();
					b.setProductNo(pArray.get(i));
					b.setOriginName(pArray.get(i)+".png");
					b.setChangeName(newFile.getName());
					b.setSavePath(savePath);
					b.setDivision("바코드"); 
					
					
					list.add(b);
				} catch (BarcodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		result = new E_ProductService().insertBarcode(list);
		

		String page = "";
		if(result>0) {
			page="barcodeList";
			response.sendRedirect(page);
		}else {
			for(int i = 0 ; i < list.size() ; i++) {
				File faildImg = new File(savePath + list.get(i).getChangeName());
				faildImg.delete();
			}
			
			page="views/admin/common/E_errorPage.jsp";
			request.setAttribute("msg", "바코드생성 실패!");
			request.getRequestDispatcher(page).forward(request, response);
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
