package com.kh.forest.admin.model.dao;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.kh.forest.admin.model.vo.Admin;
import com.kh.forest.notice.model.vo.Notice;

public class F_AdminDao {
	private Properties prop = new Properties();
	
	public F_AdminDao() {
		String fileName = F_AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public Admin checkLogin(Connection con, Admin checkAdmin) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Admin loginAdmin = null;
		
		String query = prop.getProperty("loginCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, checkAdmin.getEmpId());
			pstmt.setString(2, checkAdmin.getPassword());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginAdmin = new Admin();
				
				loginAdmin.setEmpNo(rset.getString("EMP_NO"));
				loginAdmin.setEmpName(rset.getString("EMP_NAME"));
				loginAdmin.setPhone(rset.getString("PHONE"));
				loginAdmin.setEmpId(rset.getString("EMP_ID"));
				loginAdmin.setPassword(rset.getString("PASSWORD"));
				loginAdmin.setStatus(rset.getString("STATUS"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginAdmin; 
	}


	public HashMap<String, Integer> selectAsminMain(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		HashMap<String, Integer> map = null;
		String query = prop.getProperty("selectAsminMain");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				map = new HashMap<>();
				
				map.put("m1", rset.getInt("M1"));
				map.put("m2", rset.getInt("M2"));
				map.put("m3", rset.getInt("M3"));
				map.put("m4", rset.getInt("M4"));
				map.put("op1", rset.getInt("OP1"));
				map.put("op2", rset.getInt("OP2"));
				map.put("op3", rset.getInt("OP3"));
				map.put("op4", rset.getInt("OP4"));
				map.put("oc1", rset.getInt("OC1"));
				map.put("oc2", rset.getInt("OC2"));
				map.put("oc3", rset.getInt("OC3"));
				map.put("oc4", rset.getInt("OC4"));
				map.put("bc1", rset.getInt("BC1"));
				map.put("bc2", rset.getInt("BC2"));
				map.put("bc3", rset.getInt("BC3"));
				map.put("bc4", rset.getInt("BC4"));
				map.put("bp1", rset.getInt("BP1"));
				map.put("bp2", rset.getInt("BP2"));
				map.put("bp3", rset.getInt("BP3"));
				map.put("bp4", rset.getInt("BP4"));
				map.put("rc1", rset.getInt("RC1"));
				map.put("rc2", rset.getInt("RC2"));
				map.put("rc3", rset.getInt("RC3"));
				map.put("rc4", rset.getInt("RC4"));
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return map;
	}


	public HashMap<String, Integer> selectOrderCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		HashMap<String, Integer> map = null;
		String query = prop.getProperty("selectOrderCount");
		
		try {
			stmt = con.createStatement();
		
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				map = new HashMap<>();
				
				map.put("order1", rset.getInt("ORDER1"));
				map.put("order2", rset.getInt("ORDER2"));
				map.put("order3", rset.getInt("ORDER3"));
				map.put("order4", rset.getInt("ORDER4"));
				map.put("order5", rset.getInt("ORDER5"));
				map.put("order6", rset.getInt("ORDER6"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return map;
	}


	public List<Notice> selectNotice(Connection con) {
		Statement stmt = null; 
		ResultSet rset = null;
		List<Notice> list = null;
		String query = prop.getProperty("selectNotice");
		
		try {
			stmt = con.createStatement();
			
			list = new ArrayList<>();
			
			rset = stmt.executeQuery(query);

			while(rset.next()) {
				Notice n = new Notice();
				
				n.setnBoardNo(rset.getString("NBOARD_NO"));
				n.setnTitle(rset.getString("NTITLE"));
				n.setnWriter(rset.getString("NAME"));
				n.setnEnrollDate(rset.getDate("NENROLL_DATE"));
				
				list.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

}
