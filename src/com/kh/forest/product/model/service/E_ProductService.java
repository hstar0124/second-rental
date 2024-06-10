package com.kh.forest.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.forest.product.dao.E_ProductDao;
import com.kh.forest.product.model.vo.A_ProductInfo;
import com.kh.forest.product.model.vo.Category;
import com.kh.forest.product.model.vo.DefaultInfo;
import com.kh.forest.product.model.vo.E_PageInfo;
import com.kh.forest.product.model.vo.Product;
import com.kh.forest.product.model.vo.ProductAttachment;
import com.kh.forest.product.model.vo.Rental;

import static com.kh.forest.common.JDBCTemplate.*;
public class E_ProductService {

	public int insertBarcode(ArrayList<ProductAttachment> list) {
		Connection con = getConnection();
		int result1 = 0; 
		int result2 = 0;
		
		for(int i = 0 ; i < list.size() ; i++) {
			result2 += new E_ProductDao().insertBarcode(con, list.get(i));
		}
		
		if(result2 == list.size()) {
			commit(con);
			result1 = 1;
		}else {
			rollback(con);
			result1 = 0;
		}
		
		close(con);
		
		return result1;
	}


	public int countBarcodeList() {
		Connection con = getConnection();
		int result = new E_ProductDao().countBarcodeList(con);
		
		close(con);
		
		return result;
	}


	public ArrayList<ProductAttachment> barcodeList(E_PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<ProductAttachment> list = new E_ProductDao().barcodeList(con, pi);
		
		close(con);
		
		return list;
	}


	public ArrayList<Category> selectCategory() {
		Connection con = getConnection();
		
		ArrayList<Category> list = new E_ProductDao().selectCategory(con);
		
		close(con);
		
		return list;
	}


	public Product selectBuyHistory(String buyNo) {
		Connection con = getConnection();
		
		Product requestP = new E_ProductDao().selectBuyHistroy(con, buyNo);
		
		close(con);
		
		return requestP;
	}
 

	public int inventoryInsert(Product insertProduct, ArrayList<ProductAttachment> insertAttachmentList) {
		Connection con = getConnection();
		
		int result1 = new E_ProductDao().inventoryInsert(con, insertProduct);
		
		int result2 = 0;
		if(result1 > 0) {
			for(int i = 0 ; i < insertAttachmentList.size() ; i++) {
				result2 += new E_ProductDao().insertAttachment(con, insertAttachmentList.get(i));
			}
		} 
		String status="보유중";
		int result3 = new E_ProductDao().insertProductHistory(con, insertProduct.getProductNo(), status);
		
		int result4 = 0;
		
		result4 = new E_ProductDao().insertAttachment_empty_1(con, insertProduct.getProductNo());
		for(int i = 0 ; i < 3 ; i++) {
		result4 += new E_ProductDao().insertAttachment_empty_0(con, insertProduct.getProductNo());
		}
		int result = 0;
		
		if(result1 > 0 && result2==insertAttachmentList.size()&& result3>0 && result4==4) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
			result = 0;
		}
		
		return result;
	}

	public int countInventoryList() {
		Connection con = getConnection();
		int result = new E_ProductDao().countInventoryList(con);
		
		close(con);
		
		return result;
	}


	public ArrayList<Product> inventoryList(E_PageInfo pi) {
		Connection con = getConnection();
		ArrayList<Product> productList = new E_ProductDao().inventoryList(con, pi);
		
		close(con);
		
		return productList;
	}


	public Product selectOne(String productNo) {
		Connection con = getConnection();
		
		Product selectOne = new E_ProductDao().selectOne(con, productNo);
		
		close(con);
		
		return selectOne;
	}


	public ArrayList<ProductAttachment> selectOneAttach(String productNo) {
		Connection con = getConnection();
		
		ArrayList<ProductAttachment> selectAttach = new E_ProductDao().selectOneAttach(con, productNo);
		
		close(con);

		return selectAttach;
	}


	public int updateInventory(Product requestUpdate) {
		Connection con = getConnection();
		
		int result = new E_ProductDao().updateInventory(con, requestUpdate);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}


	public DefaultInfo selectDefaultInfo() {
		Connection con = getConnection();
		
		DefaultInfo df = new E_ProductDao().selectDefaultInfo(con);
		
		close(con);
		
		return df;
	}


	public int updateDefaultInfo(DefaultInfo requestInfo) {
		Connection con = getConnection();
		
		int result = new E_ProductDao().updateDefaultInfo(con, requestInfo);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}


	public Product selectProductDefault(String productNo) {
		Connection con = getConnection();
		
		Product productDefault = new E_ProductDao().selectProductDefault(con, productNo);
		
		close(con);
		
		return productDefault;
	}


	public ArrayList<ProductAttachment> selectProductDefaultAttach(String productNo) {
		Connection con = getConnection();
		
		ArrayList<ProductAttachment> productDefaultAttach = new E_ProductDao().selectProductDefaultattach(con, productNo);
		
		close(con);
		
		
		return productDefaultAttach;
	}


	public int insertProduct(Product insertProduct, ArrayList<ProductAttachment> insertAttachmentList) {
		Connection con = getConnection();
		
		int num = new E_ProductDao().selectAttachNo(con, insertProduct.getProductNo());
		
		int result2 = new E_ProductDao().insertProduct(con, insertProduct);
		
		int result3 = 0;
		
		for(int i = 0 ; i < insertAttachmentList.size() ; i++) {
			if(!insertAttachmentList.get(i).getChangeName().equals("next")) {
				result3 += new E_ProductDao().insertProductAttach(con, insertAttachmentList.get(i), num);
			}else {
				result3++;
			}
			num++;
		}
		int result = 0;
		
		if(num>0 && result2>0 && result3==insertAttachmentList.size()) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
			result = 0;
		}
		
		
		return result;
	}


	public ArrayList<Product> productList(E_PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Product> productList = new E_ProductDao().productList(con, pi);
		
		close(con);
		
		return productList;
	}


	public A_ProductInfo selectProductDetail(String proNum) {
		Connection con = getConnection();
		
		A_ProductInfo productInfo = new E_ProductDao().selectProductDetail(con, proNum);
		
		close(con);
		
		return productInfo;
	}


	public ArrayList<Rental> rentalList(E_PageInfo pi, String loginMemberNo) {
		Connection con = getConnection();
		
		ArrayList<Rental> rentalList = new E_ProductDao().rentalList(con, pi, loginMemberNo);
		
		close(con);
		
		return rentalList;
	}


	public int refund(String reason, String orderCode) {
		Connection con =getConnection();
		int term = new E_ProductDao().calculateTerm(con, orderCode);
		int rate = 100;
		if(term>7) {
			rate=100-(term-7)*10;
		}else if(term>7&&term<18){
			rate=100;
		}else if(term>=18){
			rate=0;
		}
		int result1 = new E_ProductDao().insertRefund(con,reason,orderCode, rate);
		
		String refundNo = new E_ProductDao().selectRefundNo(con, orderCode);
		
		int result2 = new E_ProductDao().insertRefundHistory(con, refundNo);
		
		int result = 0;
		if(result1>0 && result2>0) {
			commit(con);
			result=1;
			
		}else {
			rollback(con);
			result=0;
		}
		close(con);
		
		return result;
	}


	public A_ProductInfo selectExtendProduct(String productNo) {
		Connection con = getConnection();
		
		A_ProductInfo extendProduct = new E_ProductDao().selectExtendProduct(con, productNo);
		
		close(con);
		
		return extendProduct;
	}


	public int countProductList() {
		Connection con = getConnection();
		
		int result = new E_ProductDao().countProductList(con);
		
		close(con);
		
		return result;
	}


	public int countRentalList(String loginMemberNo) {
		Connection con = getConnection();
		
		int result = new E_ProductDao().countRentalList(con, loginMemberNo);
		
		close(con);
		
		return result;
	}


	public ArrayList<ProductAttachment> searchingBarcode(E_PageInfo pi, String categoryNo, String select, String value,
			String stockStatus) {
		Connection con = getConnection();
		
		ArrayList<ProductAttachment> productAttachList =
							new E_ProductDao().searchingBarcode(con, pi, categoryNo, select, value, stockStatus);
		
		close(con);
		
		return productAttachList;
	}


	public int searchingBarcodeCount(String categoryNo, String select, String value, String stockStatus) {
		Connection con = getConnection();
		
		int count = new E_ProductDao().searchingBarcodeCount(con, categoryNo, select, value, stockStatus);
		
		close(con);
		
		return count;
	}




	public ArrayList<Product> searchingProduct(E_PageInfo pi, String categoryNo, String select, String value,
			String productStatus) {
		Connection con = getConnection();
		
		ArrayList<Product> productList =
							new E_ProductDao().searchingProduct(con, pi, categoryNo, select, value, productStatus);
		
		close(con);
		
		return productList;
	}
	
	public int searchingProductCount(String categoryNo, String select, String value, String productStatus) {
		Connection con = getConnection();
		
		int count = new E_ProductDao().searchingProductCount(con, categoryNo, select, value, productStatus);
		
		close(con);
		
		return count;
	}


	public ArrayList<Product> searchingInventory(E_PageInfo pi, String categoryNo, String select, String value,
			String productStatus) {
		Connection con = getConnection();
		
		ArrayList<Product> inventoryList =
				new E_ProductDao().searchingInventory(con, pi, categoryNo, select, value, productStatus);
		
		close(con);
		
		return inventoryList;
	}


	public int searchingInventoryCount(String categoryNo, String select, String value, String productStatus) {
		Connection con = getConnection();
		
		int count = new E_ProductDao().searchingInventoryCount(con, categoryNo, select, value, productStatus);
		
		close(con);
		
		return count;
	}


	public int countRentaPresentCondition() {
		Connection con = getConnection();
		
		int result = new E_ProductDao().countRentalPresentCondition(con);
		
		close(con);
		return result;
	}


	public ArrayList<Rental> rentalList(E_PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Rental> rentalList = new E_ProductDao().rentalList(con, pi);
		
		close(con);
		
		return rentalList;
	}


	public int checkBarcode(String productNo) {
		Connection con = getConnection();
		
		int result = new E_ProductDao().checkBarcode(con, productNo);
		
		close(con);
		return result;
	}


	public int checkBarcodeArr(String[] productNoList) {
		Connection con = getConnection();
		
		int result = 0;
		
		for(int i = 0 ; i < productNoList.length ; i++) {
			
			result += new E_ProductDao().checkBarcode(con, productNoList[i]);
			
		}
		
		close(con);
		
		return result;
	}


	public ArrayList<String> checkBarcodeList(ArrayList<String> pArray) {
		Connection con = getConnection();
		
		ArrayList<String> returnList = new ArrayList<String>();
		
		for(int i = 0 ; i <  pArray.size() ; i++) {
			int check = new E_ProductDao().checkBarcodeList(con, pArray.get(i));
			
			if(check<1) {
				returnList.add(pArray.get(i));				
			}else {
				while(check < 1) {
					int j = 1;			
					int num = Integer.parseInt(pArray.get(i).substring(10, 16)) + j;
					
					String nextNo = pArray.get(i).substring(0,10)+num;
					
					check = new E_ProductDao().checkBarcodeList(con, nextNo);
					
					if(check < 1) { 
						returnList.add(nextNo);
					}
					j++;
				}
			}
		}
		close(con);
		
		return returnList;
	}



}
