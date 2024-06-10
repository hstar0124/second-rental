package com.kh.forest.product.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.forest.common.JDBCTemplate.*;

import com.kh.forest.product.model.vo.A_MyWishlist;
import com.kh.forest.product.model.vo.A_WishList;

public class A_WishDao {
	
	Properties prop = new Properties();;
	
	public A_WishDao(){
		String fileName = A_WishDao.class.getResource("/sql/product/A_wishlist-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<A_WishList> selectWishList(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<A_WishList> list = null;
		
		String query = prop.getProperty("selectWishlist");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				A_WishList wish = new A_WishList();
				
				wish.setUserNo(userNo);
				wish.setProductNo(rset.getString("PRODUCT_NO"));
				
				list.add(wish);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	public int insertWishlist(Connection con, A_WishList wish) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertWishlist");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, wish.getUserNo());
			pstmt.setString(2, wish.getProductNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		
		return result;
	}

	public int deleteWishlist(Connection con, A_WishList wish) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteWishlist");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, wish.getUserNo());
			pstmt.setString(2, wish.getProductNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		
		return result;
	}

	public ArrayList<A_MyWishlist> selectMyWishList(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<A_MyWishlist> list = null;
		
		String query = prop.getProperty("myWishlist");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				A_MyWishlist wl = new A_MyWishlist();
				
				wl.setUserNo(rset.getString("USER_NO"));
				wl.setProductNo(rset.getString("PRODUCT_NO"));
				wl.setManufacturerName(rset.getString("MANUFACTURER_NAME"));
				wl.setProductName(rset.getString("PRODUCT_NAME"));
				wl.setChangName(rset.getString("CHANGE_NAME"));
				
				list.add(wl);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
