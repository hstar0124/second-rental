package com.kh.forest.order.model.dao;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.order.model.vo.DeliveryHistoryPurchase;
import com.kh.forest.order.model.vo.OrderHistory;
import com.kh.forest.order.model.vo.OrderStatus;
import com.kh.forest.order.model.vo.Payment;
import com.kh.forest.order.model.vo.ProductHistory;
import com.kh.forest.order.model.vo.Purchase;
import com.kh.forest.order.model.vo.Refund;
import com.kh.forest.order.model.vo.Rental;
import com.kh.forest.order.model.vo.RentalHistory;
import com.kh.forest.order.model.vo.ReturnReason;
import com.kh.forest.point.model.vo.Point;
import com.kh.forest.product.model.vo.Product;

public class C_paymentDao {
	private Properties prop = new Properties();
	
	public C_paymentDao() {
		String fileName = C_paymentDao.class.getResource("/sql/order/C_order-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public ArrayList<String> selectImpId(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<String> list = null;
		
		String query = prop.getProperty("selectImpId");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				list.add(rset.getString("IMP_UID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(stmt);
			close(rset);
		}
		
		return list;
	}

	public int insertPayment(Connection con, Payment payment) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPayment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, payment.getPaymentNo());
			pstmt.setString(2, payment.getOrderNo());
			pstmt.setString(3, payment.getUserNo());
			pstmt.setInt(4, payment.getPrice());
			pstmt.setString(5, payment.getConfirmNo());
			pstmt.setInt(6, 0);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int insertPurchase(Connection con, Purchase purchase) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPurchase");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, purchase.getOrderNo());
			pstmt.setString(2, purchase.getRentalNo());
			pstmt.setString(3, purchase.getUserNo());
			pstmt.setInt(4, purchase.getPrice());
			pstmt.setInt(5, purchase.getUsePoint());
			pstmt.setString(6, purchase.getRentalMonth());
			pstmt.setString(7, purchase.getProductNo());
			pstmt.setString(8, purchase.getRecipient());
			pstmt.setString(9, purchase.getBuyerPhone());
			pstmt.setString(10, purchase.getBuyerAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		
		return result;
	}


	public int getListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}


	public ArrayList<OrderStatus> selectList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OrderStatus> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				OrderStatus os = new OrderStatus();
				
				os.setUserId(rset.getString("USER_ID"));
				os.setUserName(rset.getString("USER_NAME"));
				os.setOrderCode(rset.getString("ORDER_CODE"));
				os.setOrderNo(rset.getString("ORDER_NO"));
				os.setProductNo(rset.getString("PRODUCT_NO"));
				os.setProductName(rset.getString("PRODUCT_NAME"));
				os.setOrderDate(rset.getDate("ORDER_DATE"));
				os.setPrice(rset.getInt("PRICE"));
				os.setStatus(rset.getString("STATUS"));
				os.setHistoryDate(rset.getDate("ORDER_HISTORY_DATE"));
				os.setBetweenDate(rset.getInt("BETWEEN"));
				
				list.add(os);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Purchase> selectOrderCode(Connection con, String orderNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Purchase> orderCode = null;
		
		String query = prop.getProperty("selectOrderCode");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderNo);
			
			rset = pstmt.executeQuery();
			orderCode = new ArrayList<>();
			while(rset.next()) {
				Purchase p = new Purchase();
				
				p.setOrderCode(rset.getString("ORDER_CODE"));
				p.setRentalNo(rset.getString("RENTAL_NO"));
				p.setProductNo(rset.getString("PRODUCT_NO"));
				
				orderCode.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return orderCode;
	}


	public int insertOrderHistory(Connection con, OrderHistory orderHistory) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOrderHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderHistory.getStatus());
			pstmt.setString(2, orderHistory.getOrderCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public ArrayList<OrderStatus> selectOrderDetail(Connection con, String orderNo, String productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OrderStatus os = null;
		ArrayList<OrderStatus> list = null;
		
		String query = prop.getProperty("selectOrderDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderNo);
			pstmt.setString(2, productNo);
			pstmt.setString(3, orderNo);
			pstmt.setString(4, productNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				os = new OrderStatus();
				os.setUserId(rset.getString("USER_ID"));
				os.setUserName(rset.getString("USER_NAME"));
				os.setOrderNo(rset.getString("ORDER_NO"));
				os.setProductNo(rset.getString("PRODUCT_NO"));
				os.setProductName(rset.getString("PRODUCT_NAME"));
				os.setOrderDate(rset.getDate("ORDER_DATE"));
				os.setPrice(rset.getInt("PRICE"));
				os.setStatus(rset.getString("STATUS"));
				os.setHistoryDate(rset.getDate("HISTORY_DATE"));
				os.setOrderCode(rset.getString("ORDER_CODE"));
				
				list.add(os);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public int getListCountUser(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListCountUser");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setString(2, "상품등록사진");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return listCount;
	}


	public ArrayList<OrderStatus> selectListUser(Connection con, String userNo, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OrderStatus> list = null;
		
		String query = prop.getProperty("selectListUser");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setString(2, "상품등록사진");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				OrderStatus os = new OrderStatus();
				
				os.setUserId(rset.getString("USER_ID"));
				os.setUserName(rset.getString("USER_NAME"));
				os.setOrderCode(rset.getString("ORDER_CODE"));
				os.setOrderNo(rset.getString("ORDER_NO"));
				os.setProductNo(rset.getString("PRODUCT_NO"));
				os.setProductName(rset.getString("PRODUCT_NAME"));
				os.setOrderDate(rset.getDate("ORDER_DATE"));
				os.setPrice(rset.getInt("PRICE"));
				os.setStatus(rset.getString("STATUS"));
				os.setChangeName(rset.getString("CHANGE_NAME"));
				os.setHistoryDate(rset.getDate("ORDER_HISTORY_DATE"));
				os.setBetweenDate(rset.getInt("BETWEEN"));
				
				list.add(os);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public String selectPaymentNo(Connection con, String orderNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String paymentNo = "";
		
		String query = prop.getProperty("selectPaymentNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				paymentNo = rset.getString("PAYMENT_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return paymentNo;
	}


	public int updatePurchaseStatus(Connection con, String code) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		String query = prop.getProperty("updatePurchaseStatus");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "주문취소");
			pstmt.setString(2, code);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}


	public int insertOrderHistoryCancel(Connection con, String orCode) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOrderHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "주문취소");
			pstmt.setString(2, orCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}


	public ArrayList<Rental> selectListRental(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Rental> list = null;
		
		String query = prop.getProperty("selectListRental");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				Rental r = new Rental();
				r.setRentalNo(rset.getString("RENTAL_NO"));
				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setExpiryDate(rset.getDate("EXPIRY_DATE"));
				r.setRestTime(rset.getString("REST_TIME"));
				r.setUserNo(rset.getString("USER_NO"));
				r.setUserName(rset.getString("USER_NAME"));
				r.setUserId(rset.getString("USER_ID"));
				r.setStatus(rset.getString("STATUS"));
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}


	public int getListCountRental(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListCountRental");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}


	public int insertPointHistory(Connection con, Point point) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPointHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, point.getPoint());
			pstmt.setString(2, point.getUseNo());
			pstmt.setString(3, point.getUserNo());
			pstmt.setString(4, point.getStatus());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateMemberPoint(Connection con, Point point) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMemberPoint");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, point.getUserNo());
			pstmt.setInt(2, point.getPoint());
			pstmt.setString(3, point.getUserNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public ArrayList<Purchase> selectListOrder(Connection con, String orderNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Purchase> list = null;
		
		String query = prop.getProperty("selectListOrder");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderNo);
			pstmt.setString(2, "상품등록사진");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				Purchase p = new Purchase();
				//P.ORDER_CODE, P.ORDER_NO, P.RENTAL_NO, P.USER_NO, P.PRICE, P.USE_POINT, P.RENTAL_MONTH, P.ORDER_DATE, P.PRODUCT_NO, PC.PRICE "PAY_PRICE", PC.C
				p.setOrderCode(rset.getString("ORDER_CODE"));
				p.setOrderNo(rset.getString("ORDER_NO"));
				p.setRentalNo(rset.getString("RENTAL_NO"));
				p.setUserNo(rset.getString("USER_NO"));
				p.setPrice(rset.getInt("PRICE"));
				p.setRentalMonth(rset.getString("RENTAL_MONTH"));
				p.setOrderDate(rset.getDate("ORDER_DATE"));
				p.setProductNo(rset.getString("PRODUCT_NO"));
				p.setPayPrice(rset.getInt("PAY_PRICE"));
				p.setDeliveryPrice(rset.getInt("DELIVERY_PRICE"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setAttachment(rset.getString("CHANGE_NAME"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}


	public int getCancelListCountUser(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getCancelListCountUser");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setString(2, "주문취소");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return listCount;
	}


	public ArrayList<OrderStatus> selectCacelListUser(Connection con, String userNo, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OrderStatus> list = null;
		
		String query = prop.getProperty("selectCancelListUser");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setString(2, "주문취소");
			pstmt.setString(3, "상품등록사진");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				OrderStatus os = new OrderStatus();
				
				os.setUserId(rset.getString("USER_ID"));
				os.setUserName(rset.getString("USER_NAME"));
				os.setOrderNo(rset.getString("ORDER_NO"));
				os.setProductNo(rset.getString("PRODUCT_NO"));
				os.setProductName(rset.getString("PRODUCT_NAME"));
				os.setOrderDate(rset.getDate("ORDER_DATE"));
				os.setPrice(rset.getInt("PRICE"));
				os.setStatus(rset.getString("STATUS"));
				os.setChangeName(rset.getString("CHANGE_NAME"));
				
				list.add(os);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public int insertDeliveryHistory(Connection con, DeliveryHistoryPurchase dhp) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertDeliveryHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dhp.getWaybillNo());
			pstmt.setString(2, dhp.getOrderCode());
			pstmt.setString(3, dhp.getStatus());
			pstmt.setString(4, dhp.getCarrierNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
			
		return result;
	}


	public Rental selectCollDetail(Connection con, String rentalNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Rental rental = null;
		
		String query = prop.getProperty("selectCollDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public int getCancelListCount(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getCancelListCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "주문취소");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return listCount;
	}


	public ArrayList<OrderStatus> selectCancelList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OrderStatus> list = null;
		
		String query = prop.getProperty("selectCancelList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "주문취소");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				OrderStatus os = new OrderStatus();
				
				os.setUserId(rset.getString("USER_ID"));
				os.setUserName(rset.getString("USER_NAME"));
				os.setOrderNo(rset.getString("ORDER_NO"));
				os.setProductNo(rset.getString("PRODUCT_NO"));
				os.setProductName(rset.getString("PRODUCT_NAME"));
				os.setOrderDate(rset.getDate("ORDER_DATE"));
				os.setPrice(rset.getInt("PRICE"));
				os.setStatus(rset.getString("STATUS"));
				list.add(os);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public int insertRental(Connection con, Rental rental) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertRental");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rental.getProductNo());
			pstmt.setString(2, rental.getUserNo());
			pstmt.setString(3, rental.getMonth());
			pstmt.setInt(4, rental.getRentalPrice());
			pstmt.setString(5, rental.getTakeOver());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public String selectRentalNo(Connection con, String productNo) {
		PreparedStatement  pstmt = null;
		ResultSet rset = null;
		String rentalNo = "";
		
		String query = prop.getProperty("selectRentalNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				rentalNo = rset.getString("RENTAL_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rentalNo;
	}


	public int insertRentalHistory(Connection con, RentalHistory rentalHistory) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertRentalHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rentalHistory.getRentalNo());
			pstmt.setString(2, rentalHistory.getStatus());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int insertProductHistory(Connection con, ProductHistory productHistory) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertProductHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productHistory.getProductNo());
			pstmt.setString(2, productHistory.getProductStatus());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	public String selectAttachment(Connection con, String productNo, String division) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String attachment = "";
		
		String query = prop.getProperty("selectAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNo);
			pstmt.setString(2, division);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				attachment = rset.getString("CHANGE_NAME");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		
		return attachment;
	}


	public int updateRental(Connection con, Rental rental) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateRental");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rental.getRentalNo());
			pstmt.setString(2, rental.getMonth());
			pstmt.setString(3, rental.getRentalNo());
			pstmt.setInt(4, rental.getRentalPrice());
			pstmt.setString(5, rental.getRentalNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return result;
	}


	public int getRefundListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getRefundListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}


	public ArrayList<Refund> selectRefundList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Refund> list = null;
		
		String query = prop.getProperty("selectRefundList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				Refund r = new Refund();
				
				r.setUserId(rset.getString("USER_ID"));
				r.setUserName(rset.getString("USER_NAME"));
				r.setOrderDate(rset.getDate("ORDER_DATE"));
				r.setOrderNo(rset.getString("ORDER_NO"));
				r.setProductName(rset.getString("PRODUCT_NAME"));
				r.setPrice(rset.getInt("PRICE"));
				r.setStatus(rset.getString("STATUS"));
				r.setRefundReason(rset.getString("REASON"));
				r.setRate(rset.getInt("RATE"));
				r.setRefundDate(rset.getDate("REFUND_DATE"));
				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setRefundNo(rset.getString("REFUND_NO"));
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}


	public Refund selectOneRefund(Connection con, String refundNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Refund refund = null;
		
		String query = prop.getProperty("selectOneRefund");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, refundNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				refund = new Refund();
				
				refund.setOrderCode(rset.getString("ORDER_CODE"));
				refund.setRate(rset.getInt("RATE"));
				refund.setPrice(rset.getInt("PRICE"));
				refund.setUserNo(rset.getString("USER_NO"));
				refund.setRentalNo(rset.getString("RENTAL_NO"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return refund;
	}


	public int insertRefundHistory(Connection con, Refund refund) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertRefundHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, refund.getRefundNo());
			pstmt.setString(2, refund.getStatus());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int insertRefundPointHistory(Connection con, Point point) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertRefundPointHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, point.getPoint());
			pstmt.setString(2, point.getUseNo());
			pstmt.setString(3, point.getUserNo());
			pstmt.setString(4, point.getStatus());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int insertReturnReason(Connection con, ReturnReason reReason) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReturnReason");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reReason.getDivision());
			pstmt.setString(2, reReason.getHistoryNo());
			pstmt.setString(3, reReason.getReason());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public String selectRefundHistoryNo(Connection con, String refundNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String refundHistoryNo = "";
		
		String query = prop.getProperty("selectRefundHistoryNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, refundNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				refundHistoryNo = rset.getString("REFUND_HISTORY_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return refundHistoryNo;
	}


	public String selectRefundReason(Connection con, String orderCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String reason = "";
		
		String query = prop.getProperty("selectRefundReason");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reason = rset.getString("REASON");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reason;
	}


	public Rental selectRentalBasket(Connection con, String rentalNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Rental r = null;
		
		String query = prop.getProperty("selectRentalBasket");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rentalNo);
			pstmt.setString(2, "상품등록사진");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				r = new Rental();
				
				r.setRentalNo(rentalNo);
				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setProductName(rset.getString("PRODUCT_NAME"));
				r.setMonth(rset.getString("MONTH"));
				r.setRentalPrice(rset.getInt("RENTAL_PRICE"));
				r.setTakeOver(rset.getString("TAKE_OVER"));
				r.setAttachment(rset.getString("CHANGE_NAME"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}


	public int updateRentalBasket(Connection con, Rental rental) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateRentalBasket");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rental.getMonth());
			pstmt.setString(2, rental.getRentalNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int deleteBasket(Connection con, String userNo, String rentalNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBasket");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setString(2, rentalNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public DeliveryHistoryPurchase selectWaybillNo(Connection con, String orderCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DeliveryHistoryPurchase dh = null;
		
		String query = prop.getProperty("selectWaybillNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				dh = new DeliveryHistoryPurchase();
				
				dh.setWaybillNo(rset.getString("WAYBILL_NO"));
				dh.setCarrierNo(rset.getString("CARRIER_NO"));
				dh.setRecipient(rset.getString("RECIPIENT"));
				dh.setAddress(rset.getString("ADDRESS"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return dh;
	}


	public Purchase selectPurchase(Connection con, String rentalNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Purchase p = null;
		
		String query = prop.getProperty("selectPurchase");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rentalNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Purchase();
				p.setOrderCode(rset.getString("ORDER_CODE"));
				p.setProductNo(rset.getString("PRODUCT_NO"));
				p.setOrderNo(rset.getString("ORDER_NO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return p;
	}


	public int updateProduct(Connection con, Product p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateProduct");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, p.getRentalStatus());
			pstmt.setString(2, p.getProductNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



}
