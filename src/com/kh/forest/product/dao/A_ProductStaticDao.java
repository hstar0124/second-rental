package com.kh.forest.product.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.forest.common.JDBCTemplate.*;

import com.kh.forest.product.model.vo.A_ProductMonthlyStatic;
import com.kh.forest.product.model.vo.A_ProductStatic;

public class A_ProductStaticDao {

	Properties prop = new Properties();
	
	public A_ProductStaticDao(){
		String fileName = A_ProductStaticDao.class.getResource("/sql/product/A_proStatic-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public A_ProductStatic selectAllCategory(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		A_ProductStatic proStatic = null;
		
		String query = prop.getProperty("selectProductStatic");
		
		try {
			stmt = con.createStatement();			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				
				proStatic = new A_ProductStatic();
				proStatic.setNotebook(rset.getInt("NOTEBOOK"));
				proStatic.setTablet(rset.getInt("TABLET"));
				proStatic.setLife(rset.getInt("LIFE"));
				proStatic.setKitchen(rset.getInt("KITCHEN"));
				proStatic.setBeauty(rset.getInt("BEAUTY"));
				
				//System.out.println(proStatic);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return proStatic;
	}

	public ArrayList<A_ProductMonthlyStatic> selectMonthly(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<A_ProductMonthlyStatic> list = null;
		
		String query = prop.getProperty("selectMonthlyStatic");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				A_ProductMonthlyStatic p = new A_ProductMonthlyStatic();
				p.setRequestDate(rset.getString("REQUEST_DATE"));
				p.setFirstRequest(rset.getInt("FIRST_REQUEST"));
				p.setFirstComplete(rset.getInt("FIRST_COMPLETE"));
				p.setFirstFail(rset.getInt("FIRST_FAIL"));
				p.setSecondComplete(rset.getInt("SECOND_COMPLETE"));
				p.setCancel(rset.getInt("CANCEL"));
				p.setComplete(rset.getInt("COMPLETE"));
				p.setWaiting(rset.getInt("WAITING"));
				p.setReceive(rset.getInt("RECEIVE"));
				
				list.add(p);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}
	
	
}
