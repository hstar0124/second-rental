package com.kh.forest.product.model.service;

import com.kh.forest.order.model.dao.C_paymentDao;
import com.kh.forest.order.model.vo.Rental;
import com.kh.forest.product.dao.A_BasketDao;
import com.kh.forest.product.model.vo.A_Basket;
import static com.kh.forest.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class A_BasketService {

	public ArrayList<A_Basket> selectBasket(String userNo) {
		
		Connection con = getConnection();
		
		ArrayList<A_Basket> list = new A_BasketDao().selectBasket(con, userNo);
		
		close(con);
		
		return list;
	}

	public int insertBasket(A_Basket basket) {
		Connection con = getConnection();
		
		int result = new A_BasketDao().insertBasket(con, basket);
		
		close(con);
		
		return result;
	}

	public int deleteBasket(String rentalNo) {
		Connection con = getConnection();
		
		int result = new A_BasketDao().deleteBasket(con, rentalNo);
		int result2 = 0;
		
		if(result > 0) {
			//System.out.println("deleteBasket 성공");
			result2 = new A_BasketDao().deleteRentalBasket(con, rentalNo);
			
			if(result2 > 0) {
				//System.out.println("deleteRental Basket 성공");
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);			
		}
		
		close(con);
		
		return result2;
	}

	public int checkBasket(Rental rental) {
		Connection con = getConnection();
		
		int result = new A_BasketDao().checkBasket(con, rental);
		
		close(con);
		
		return result;
	}

	public String selectRentalNo(String productNo) {
		Connection con = getConnection();
		
		String selectRentalNo = new C_paymentDao().selectRentalNo(con, productNo);
		
		close(con);
				
		return selectRentalNo;
	}


}
