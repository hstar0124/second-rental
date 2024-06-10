package com.kh.forest.search.dao;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.forest.product.model.vo.Product;

public class B_searchDao {
	private Properties prop = new Properties();
	
	public B_searchDao() {
		String fileName = B_searchDao.class.getResource("/sql/search/B_search-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> selectProductList(Connection con, String mainSearch) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		
		String query = prop.getProperty("selectProductList");
		
		String productName = "%" + mainSearch + "%";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setString(2, productName);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				Product p = new Product();
				
				p.setProductNo(rset.getString("PRODUCT_NO"));
				p.setManufacturerName(rset.getString("MANUFACTURER_NAME"));
				p.setManufacturerNo(rset.getString("MANUFACTURER_NO"));
				p.setCategoryName(rset.getString("CATEGORY_NAME"));
				p.setCategoryNo(rset.getString("CATEGORY_NO"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setBuyProductNo(rset.getString("BUY_PRODUCT_NO"));
				p.setRentalPrice(rset.getString("RENTAL_PRICE"));
				p.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				
				list.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<HashMap<String, Object>> selectSearchPhoto(Connection con, String mainSearch) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> photoList = null;
		HashMap<String, Object> hmap = null;
		
		String query = prop.getProperty("selectSearchPhoto");
		
		String productName = "%" + mainSearch + "%";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setString(2, productName);
			pstmt.setInt(3, 1);
			
			rset = pstmt.executeQuery();
			photoList = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				
				hmap.put("originName", rset.getString("ORIGIN_NAME"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));
				hmap.put("savePath", rset.getString("SAVE_PATH"));
				hmap.put("productLevel", rset.getInt("PRODUCT_LEVEL"));
				hmap.put("productNo", rset.getString("PRODUCT_NO"));
				hmap.put("division", rset.getString("DIVISION"));
				hmap.put("productName", rset.getString("PRODUCT_NAME"));
				hmap.put("categoryNo", rset.getString("CATEGORY_NO"));
				hmap.put("manufacturerNo", rset.getString("MANUFACTURER_NO"));
				hmap.put("categoryName", rset.getString("CATEGORY_NAME"));
				hmap.put("manufacturerName", rset.getString("MANUFACTURER_NAME"));
				hmap.put("buyProductNo", rset.getString("BUY_PRODUCT_NO"));
				hmap.put("rentalPrice", rset.getString("RENTAL_PRICE"));
				hmap.put("enrollDate", rset.getString("PRODUCT_ENROLLDATE"));
				
				
				photoList.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return photoList;
	}

	public ArrayList<HashMap<String, Object>> selectNewMainList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		
		String query = prop.getProperty("selectNewMainList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "Y");
			pstmt.setInt(2, 1);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				
				hmap.put("originName", rset.getString("ORIGIN_NAME"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));
				hmap.put("savePath", rset.getString("SAVE_PATH"));
				hmap.put("productLevel", rset.getInt("PRODUCT_LEVEL"));
				hmap.put("productNo", rset.getString("PRODUCT_NO"));
				hmap.put("division", rset.getString("DIVISION"));
				hmap.put("productName", rset.getString("PRODUCT_NAME"));
				hmap.put("categoryNo", rset.getString("CATEGORY_NO"));
				hmap.put("manufacturerNo", rset.getString("MANUFACTURER_NO"));
				hmap.put("categoryName", rset.getString("CATEGORY_NAME"));
				hmap.put("manufacturerName", rset.getString("MANUFACTURER_NAME"));
				hmap.put("buyProductNo", rset.getString("BUY_PRODUCT_NO"));
				hmap.put("rentalPrice", rset.getString("RENTAL_PRICE"));
				hmap.put("enrollDate", rset.getString("PRODUCT_ENROLLDATE"));
				
				
				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
				
		return list;

	}

}
