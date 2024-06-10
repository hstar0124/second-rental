package com.kh.forest.search.service;

import static com.kh.forest.common.JDBCTemplate.close;
import static com.kh.forest.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.forest.product.model.vo.Product;
import com.kh.forest.search.dao.B_searchDao;

public class B_searchService {
	
	//메인화면 검색어로 조회
	public ArrayList<Product> selectProductList(String mainSearch) {
		Connection con = getConnection();
		
		ArrayList<Product> list = new B_searchDao().selectProductList(con, mainSearch);
		
		close(con);
		
		return list;
	}
	//검색시 사진리스트 조회
	public ArrayList<HashMap<String, Object>> selectSearchPhoto(String mainSearch) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> photoList = new B_searchDao().selectSearchPhoto(con, mainSearch);
		
		close(con);
		
		return photoList;
	}
	//메인페이지 새로나온상품 연동
	public ArrayList<HashMap<String, Object>> selectNewMainList() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new B_searchDao().selectNewMainList(con);
		
		close(con);
		
		return list;
	}


}
