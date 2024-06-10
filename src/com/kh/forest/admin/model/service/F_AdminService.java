package com.kh.forest.admin.model.service;

import static com.kh.forest.common.JDBCTemplate.close;
import static com.kh.forest.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import com.kh.forest.admin.model.dao.F_AdminDao;
import com.kh.forest.admin.model.vo.Admin;
import com.kh.forest.notice.model.vo.Notice;

public class F_AdminService {

	public Admin checkLogin(Admin checkAdmin) {
		Connection con = getConnection();
		
		Admin loginAdmin = new F_AdminDao().checkLogin(con, checkAdmin);
		
		close(con);
		
		
		return loginAdmin;
	}

	public HashMap<String, Integer> selectAsminMain() {
		Connection con = getConnection();
		
		HashMap<String, Integer> map = new F_AdminDao().selectAsminMain(con);
		
		close(con);
		
		return map;
	}

	public HashMap<String, Integer> selectOrderCount() {
		Connection con = getConnection();
		
		HashMap<String, Integer> map = new F_AdminDao().selectOrderCount(con);
		
		close(con);
		
		return map;
	}

	public List<Notice> selectNotice() {
		Connection con = getConnection();
		
		List<Notice> list = new F_AdminDao().selectNotice(con);
		
		close(con);
		
		return list;
	}

}
