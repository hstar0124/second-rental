package com.kh.forest.product.model.service;

import static com.kh.forest.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.forest.product.dao.A_ProductStaticDao;
import com.kh.forest.product.model.vo.A_ProductMonthlyStatic;
import com.kh.forest.product.model.vo.A_ProductStatic;

public class A_ProductStaticService {

	public A_ProductStatic selectAllCategory() {
		
		Connection con = getConnection();
		
		A_ProductStatic proStatic = new A_ProductStaticDao().selectAllCategory(con);;
		
		close(con);
		
		return proStatic;
	}

	public ArrayList<A_ProductMonthlyStatic> selectMonthly() {
		
		Connection con = getConnection();
		
		ArrayList<A_ProductMonthlyStatic> list = new A_ProductStaticDao().selectMonthly(con);
		
		close(con);
		
		return list;
	}

}
