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

import com.kh.forest.order.model.vo.Rental;
import com.kh.forest.product.model.vo.A_Basket;

public class A_BasketDao {
	
	Properties prop = new Properties();;
	
	public A_BasketDao(){
		String fileName = A_WishDao.class.getResource("/sql/product/A_basket-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<A_Basket> selectBasket(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<A_Basket> list = null;
		
		String query = prop.getProperty("selectMonthBasket");
		
		try {
			pstmt = con.prepareStatement(query);			
			pstmt.setString(1, userNo);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<A_Basket>();
			
			while(rset.next()) {
				A_Basket basket = new A_Basket();
				basket.setRentalNo(rset.getString("RENTAL_NO"));
				basket.setProductNo(rset.getString("PRODUCT_NO"));
				basket.setProductName(rset.getString("PRODUCT_NAME"));
				basket.setUserNo(rset.getString("USER_NO"));
				basket.setMonth(rset.getString("MONTHS"));
				basket.setRentalPrice(rset.getString("RENTAL_PRICE"));
				basket.setTakeOver(rset.getString("TAKE_OVER"));
				basket.setCngName(rset.getString("CHANGE_NAME"));
				
				list.add(basket);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}		
		
		return list;
	}

	public int insertBasket(Connection con, A_Basket basket) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBasket");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, basket.getUserNo());
			pstmt.setString(2, basket.getRentalNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		
		return result;
	}

	public int deleteRentalBasket(Connection con, String rentalNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteRentalBasket");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rentalNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBasket(Connection con, String rentalNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBasket");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rentalNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkBasket(Connection con, Rental rental) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		String query = prop.getProperty("checkBasket");
		System.out.println(rental);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rental.getUserNo());
			pstmt.setString(2, rental.getProductNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				count++;
			}
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return count;
	}

	

}
