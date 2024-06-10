package com.kh.forest.order.model.service;

import static com.kh.forest.common.JDBCTemplate.close;
import static com.kh.forest.common.JDBCTemplate.commit;
import static com.kh.forest.common.JDBCTemplate.getConnection;
import static com.kh.forest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.forest.member.model.dao.F_MemberDao;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;
import com.kh.forest.order.model.dao.C_paymentDao;
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


public class C_paymentService {

	public int insertPayment(Payment payment) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertPayment(con, payment);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<String> selectImpId() {
		Connection con = getConnection();
		
		ArrayList<String> list = new C_paymentDao().selectImpId(con);
		
		if(list!=null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return list;
	}

	public int insertPurchase(Purchase purchase) {
		Connection con = getConnection();
		int result = new C_paymentDao().insertPurchase(con, purchase);
		
		if(result > 0) {
			commit(con);
		}else {
			close(con);
		}
		return result;
	}

	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new C_paymentDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<OrderStatus> selectList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<OrderStatus> list = new C_paymentDao().selectList(con, pi);
		
		for(OrderStatus o : list) {
			if(o.getStatus().equals("배송완료") && o.getBetweenDate()>6 ) {
				OrderHistory orderHistory = new OrderHistory();
				orderHistory.setOrderCode(o.getOrderCode());
				orderHistory.setStatus("인수완료");
				
				int result = new C_paymentDao().insertOrderHistory(con, orderHistory);
				
				if(result > 0) {
					commit(con);
				}else {
					rollback(con);
				}
			}
		}
		
		ArrayList<OrderStatus> list2 = new C_paymentDao().selectList(con, pi);
		
		close(con);
		
		return list2;
	}

	public ArrayList<Purchase> selectOrderCode(String orderNo) {
		Connection con = getConnection();
		
		ArrayList<Purchase> orderCode = new C_paymentDao().selectOrderCode(con, orderNo);
		
		close(con);
		
		return orderCode;
	}

	public int insertOrderHistory(OrderHistory orderHistory) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertOrderHistory(con, orderHistory);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<OrderStatus> selectOrderDetail(String orderNo, String productNo) {
		Connection con = getConnection();
		
		ArrayList<OrderStatus> os = new C_paymentDao().selectOrderDetail(con, orderNo, productNo);
		
		close(con);
		
		return os;
	}

	public int getListCountUser(String userNo) {
		Connection con = getConnection();
		
		int listCount = new C_paymentDao().getListCountUser(con, userNo);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<OrderStatus> selectListUser(String userNo, PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<OrderStatus> list = new C_paymentDao().selectListUser(con, userNo, pi);
		
		for(OrderStatus o : list) {
			if(o.getStatus().equals("배송완료") && o.getBetweenDate()>6 ) {
				OrderHistory orderHistory = new OrderHistory();
				orderHistory.setOrderCode(o.getOrderCode());
				orderHistory.setStatus("인수완료");
				
				int result = new C_paymentDao().insertOrderHistory(con, orderHistory);
				
				if(result > 0) {
					commit(con);
				}else {
					rollback(con);
				}
			}
		}
		
		ArrayList<OrderStatus> list2 = new C_paymentDao().selectListUser(con, userNo, pi);
		
		close(con);
		
		return list2;
	}

	public String selectPaymentNo(String orderNo) {
		Connection con = getConnection();
		
		String paymentNo = new C_paymentDao().selectPaymentNo(con, orderNo);
		
		close(con);
		
		return paymentNo;
	}

	public int updatePurchaseStatus(String code) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().updatePurchaseStatus(con, code);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//주문취소시 주문현황에 insert
	public int insertOrderHistoryCancel(String orCode) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertOrderHistoryCancel(con, orCode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//회수 관리 리스트 조회
	public ArrayList<Rental> selectListRental(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Rental> list = new C_paymentDao().selectListRental(con, pi);
		
		int restTime = 0;
		int result = 0;
		for(Rental r : list) {
			restTime = Integer.parseInt(r.getRestTime());
			if(restTime>=0 && restTime<=7 && !r.getStatus().equals("회수완료")) {
				RentalHistory rentalHistory = new RentalHistory();
				rentalHistory.setRentalNo(r.getRentalNo());
				rentalHistory.setStatus("회수예정");
				result = new C_paymentDao().insertRentalHistory(con, rentalHistory);
			}else if(restTime<=0 && !r.getStatus().equals("회수완료")) {
				RentalHistory rentalHistory = new RentalHistory();
				rentalHistory.setRentalNo(r.getRentalNo());
				rentalHistory.setStatus("연체");
				result = new C_paymentDao().insertRentalHistory(con, rentalHistory);
				
			}
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		
		ArrayList<Rental> list2 = new C_paymentDao().selectListRental(con, pi); 
		
		close(con);
		
		return list2;
	}

	//회수관리 리스트를 위한 리스트 수
	public int getListCountRental() {
		Connection con = getConnection();
		
		int listCount = new C_paymentDao().getListCountRental(con);
		
		close(con);
		
		return listCount;
	}

	//포인트사용 히스토리 insert
	public int insertPointHistory(Point point) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertPointHistory(con, point);
		
		int result2 = 0;
		
		if(result > 0) {
			
			result2 = new C_paymentDao().updateMemberPoint(con, point);
		}else {
			rollback(con);
		}
		
		if(result2 > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	
	//주문완료페이지 리스트 불러오기
	public ArrayList<Purchase> selectListOrder(String orderNo) {
		Connection con = getConnection();
		
		ArrayList<Purchase> list = new C_paymentDao().selectListOrder(con, orderNo);
		
		close(con);
		
		return list;
	}

	public Member updateMemberSelect(String userNo) {
		Connection con = getConnection();
		
		Member updateMember = new F_MemberDao().selectOne(con, Integer.parseInt(userNo));
		
		close(con);
		
		return updateMember;
	}

	public int getCancelListCountUser(String userNo) {
		Connection con = getConnection();
		
		int listCount = new C_paymentDao().getCancelListCountUser(con, userNo);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<OrderStatus> selectCancelListUser(String userNo, PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<OrderStatus> list = new C_paymentDao().selectCacelListUser(con, userNo, pi);
		
		close(con);
		
		return list;
	}


	public int updateDelivery(DeliveryHistoryPurchase dhp, OrderHistory orderHistory) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertOrderHistory(con, orderHistory);
		int result2 = 0;
		if(result> 0) {
			
			result2 = new C_paymentDao().insertDeliveryHistory(con, dhp);
			if(result2 > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			
		}else {
			rollback(con);
		}
		
		return result2;
	}

	public Rental selectCollDetail(String rentalNo) {
		Connection con = getConnection();
		
		Rental rental = new C_paymentDao().selectCollDetail(con, rentalNo);
		
		close(con);
		
		return rental;
	}

	public int getCancelListCount() {
		Connection con = getConnection();
		
		int count = new C_paymentDao().getCancelListCount(con);
		
		close(con);
		
		return count;
	}

	public ArrayList<OrderStatus> selectCancelList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<OrderStatus> list = new C_paymentDao().selectCancelList(con, pi);
		
		close(con);
		
		return list;
	}

	public String insertRental(Rental rental) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertRental(con, rental);
				
		String selectRentalNo = "";
		if(result > 0) {
			commit(con);
			selectRentalNo = new C_paymentDao().selectRentalNo(con, rental.getProductNo());
			
		}else {
			rollback(con);
		}
		
		close(con);
		
		return selectRentalNo;
	}

	public int insertRentalHistory(RentalHistory rentalHistory) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertRentalHistory(con, rentalHistory);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int insertProductHistory(ProductHistory productHistory) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertProductHistory(con, productHistory);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public String selectAttachment(String productNo, String division) {
		Connection con = getConnection();
			
		String attachment = new C_paymentDao().selectAttachment(con, productNo, division);
		
		close(con);
		
		return attachment;
	}

	public int updateRental(Rental rental) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().updateRental(con, rental);
		
		if(result >0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	public ArrayList<Refund> selectRefundList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Refund> list = new C_paymentDao().selectRefundList(con, pi);
		
		close(con);
		
		return list;
	}

	public int getRefundListCount() {
		Connection con = getConnection();
		
		int listCount = new C_paymentDao().getRefundListCount(con);
		
		close(con);
		
		return listCount;
	}

	public Refund selectOneRefund(String refundNo) {
		Connection con = getConnection();
		
		Refund refund = new C_paymentDao().selectOneRefund(con, refundNo);
		
		close(con);
		
		return refund;
	}

	public int insertRefundConfirm(Refund refund, Point point, RentalHistory rentalHistory) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertRefundHistory(con, refund);
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		if(result > 0) {
			result2 = new C_paymentDao().insertRefundPointHistory(con, point);
			point.setPoint(-point.getPoint());
			result3 = new C_paymentDao().updateMemberPoint(con, point);
			result4 = new C_paymentDao().insertRentalHistory(con, rentalHistory);
			result += result2 + result3 + result4;
		}
		
		if(result == 4) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int insertRefundCancel(Refund refund, ReturnReason reReason) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().insertRefundHistory(con, refund);
		int result2 = 0;
		
		if(result > 0) {
			reReason.setHistoryNo(new C_paymentDao().selectRefundHistoryNo(con, refund.getRefundNo()));
			
			result2 = new C_paymentDao().insertReturnReason(con, reReason);
			
			if(result2 > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result2;
	}

	public String selectRefundReason(String orderCode) {
		Connection con = getConnection();
		
		String reason = new C_paymentDao().selectRefundReason(con, orderCode);
		
		close(con);
		
		return reason;
	}

	public Rental selectRentalBasket(String rentalNo) {
		Connection con = getConnection();
		
		Rental list = new C_paymentDao().selectRentalBasket(con, rentalNo);
		
		close(con);
		
		return list;
	}

	public int updateRentalBascket(Rental rental) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().updateRentalBasket(con, rental);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteBasket(String userNo, String rentalNo) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().deleteBasket(con, userNo, rentalNo);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public DeliveryHistoryPurchase selectWaybillNo(String orderCode) {
		Connection con = getConnection();
		
		DeliveryHistoryPurchase dh = new C_paymentDao().selectWaybillNo(con, orderCode);
		
		close(con);
		
		return dh;
	}

	public Purchase selectPurchase(String rentalNo) {
		Connection con = getConnection();
		
		Purchase p = new C_paymentDao().selectPurchase(con, rentalNo);
		
		close(con);
		
		return p;
	}

	public int updateProduct(Product p) {
		Connection con = getConnection();
		
		int result = new C_paymentDao().updateProduct(con, p);
		
		close(con);
		
		return result;
	}

	public int insertCancelPurchase(Purchase p) {
		Connection con = getConnection();
		
		RentalHistory rentalHistory = new RentalHistory();
		rentalHistory.setRentalNo(p.getRentalNo());
		rentalHistory.setStatus("회수완료");
		
		Product pr = new Product();
		pr.setProductNo(p.getProductNo());
		pr.setRentalStatus("N");
		
		int result = new C_paymentDao().insertRentalHistory(con, rentalHistory);
		
		if(result > 0) {
			result = new C_paymentDao().updateProduct(con, pr);
		}
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	


}
