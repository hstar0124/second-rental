package com.kh.forest.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import static com.kh.forest.common.JDBCTemplate.*;

import com.kh.forest.product.dao.A_WishDao;
import com.kh.forest.product.model.vo.A_MyWishlist;
import com.kh.forest.product.model.vo.A_WishList;

public class A_WishListService {

	public ArrayList<A_WishList> selectWishList(String userNo) {

		Connection con = getConnection();
		
		ArrayList<A_WishList> list = new A_WishDao().selectWishList(con, userNo);
		
		close(con);
			
		return list;
	}

	public int insertWishlist(A_WishList wish) {
		
		Connection con = getConnection();
		
		int result = new A_WishDao().insertWishlist(con, wish);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	public int deleteWishlist(A_WishList wish) {
		
		Connection con = getConnection();
		
		int result = new A_WishDao().deleteWishlist(con, wish);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	public ArrayList<A_MyWishlist> selectMyWishList(String userNo) {
		Connection con = getConnection();
		
		ArrayList<A_MyWishlist> list = new A_WishDao().selectMyWishList(con, userNo);
		
		close(con);
			
		return list;
	}
	
	

}
