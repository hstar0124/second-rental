package com.kh.forest.buy.model.dao;

import static com.kh.forest.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.forest.buy.model.vo.BuyAttachment;
import com.kh.forest.buy.model.vo.BuyInfo;
import com.kh.forest.buy.model.vo.BuyProduct;
import com.kh.forest.member.model.vo.Member;
import com.kh.forest.member.model.vo.PageInfo;
import com.sun.xml.internal.ws.api.message.Attachment;


public class B_buyDao {
	private Properties prop = new Properties();	
	
	public B_buyDao() {
		String fileName = B_buyDao.class.getResource("/sql/buy/B_buy-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<BuyProduct> selectCategory(Connection con, int categoryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuyProduct> buyProductList = null;
		
		String query = prop.getProperty("selectCategory");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, categoryNo);
			
			buyProductList = new ArrayList<>();
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BuyProduct bp = new BuyProduct();
				
				bp.setManufacturerName(rset.getString("MANUFACTURER_NAME"));
				bp.setCategoryNo(rset.getString("CATEGORY_NO"));
				bp.setCategoryName(rset.getString("CATEGORY_NAME"));
				bp.setManufacturerNo(rset.getString("MANUFACTURER_NO"));
				
				buyProductList.add(bp);
			}
			
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return buyProductList;
	}

	public ArrayList<BuyProduct> selectManufaturerName(Connection con, String manufacturerNo, String categoryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuyProduct> buyProductList = null;
		
		String query = prop.getProperty("selectManufacturerName");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, categoryNo);
			pstmt.setString(2, manufacturerNo);
			
			rset = pstmt.executeQuery();
			
			buyProductList = new ArrayList<>();
			
			while(rset.next()) {
				BuyProduct bp = new BuyProduct();
				
				bp.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				bp.setBuyProductNo(rset.getString("BUY_PRODUCT_NO"));
				bp.setCategoryNo(rset.getString("CATEGORY_NO"));
				bp.setCategoryName(rset.getString("CATEGORY_NAME"));
				
				
				buyProductList.add(bp);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
				
		return buyProductList;
	}

	public int insertUserCheckList(Connection con, String buyNo, BuyInfo buyinfo, HashMap<String, String> exampleMap) {
		PreparedStatement pstmt = null;
		int result1 = 0;
		
		String query = prop.getProperty("insertUserCheckList");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1");
			pstmt.setString(2, exampleMap.get("1"));
			pstmt.setString(3, buyNo);
			pstmt.setString(4, buyinfo.getUserNo());
			
			pstmt.setString(5, "2");
			pstmt.setString(6, exampleMap.get("2"));
			pstmt.setString(7, buyNo);
			pstmt.setString(8, buyinfo.getUserNo());
			
			pstmt.setString(9, "3");
			pstmt.setString(10, exampleMap.get("3"));
			pstmt.setString(11, buyNo);
			pstmt.setString(12, buyinfo.getUserNo());
			
			pstmt.setString(13, "4");
			pstmt.setString(14, exampleMap.get("4"));
			pstmt.setString(15, buyNo);
			pstmt.setString(16, buyinfo.getUserNo());
			
			pstmt.setString(17, "5");
			pstmt.setString(18, exampleMap.get("5"));
			pstmt.setString(19, buyNo);
			pstmt.setString(20, buyinfo.getUserNo());
			
			pstmt.setString(21, "6");
			pstmt.setString(22, exampleMap.get("6"));
			pstmt.setString(23, buyNo);
			pstmt.setString(24, buyinfo.getUserNo());
			
			
			//System.out.println("나오니:" + exampleMap.get("6"));
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result1;
	}
	//사진등록
	public int insertPhoto(Connection con, BuyAttachment buyAttachment, String buyNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPhoto");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyAttachment.getOriginName());
			pstmt.setString(2, buyAttachment.getChangeName());
			pstmt.setString(3, buyAttachment.getFilePath());
			pstmt.setString(4, buyNo);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//페이징용 리스트 카운트
	public int getListCountRequest(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int listCountRequest = 0;
		
		String query = prop.getProperty("listCount");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1차검수신청");
			pstmt.setString(2, "1차검수완료");
			pstmt.setString(3, "인수대기중");
			pstmt.setString(4, "인수완료");
			pstmt.setString(5, "2차검수완료");
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCountRequest = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCountRequest;
	}
	
	//매입신청패이지 페이징
	public ArrayList<BuyInfo> selectRequestList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuyInfo> list = null;
		
		String query = prop.getProperty("selectListPaging");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() -1;
			
			pstmt.setString(1, "1차검수신청");
			pstmt.setString(2, "1차검수완료");
			pstmt.setString(3, "인수대기중");
			pstmt.setString(4, "인수완료");
			pstmt.setString(5, "2차검수완료");
			pstmt.setInt(6, startRow);
			pstmt.setInt(7, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				BuyInfo bi = new BuyInfo();
				
				bi.setBuyNo(rset.getString("BUY_NO"));
				bi.setUserNo(rset.getString("USER_NO"));
				bi.setUserId(rset.getString("USER_ID"));
				bi.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				bi.setSafeKey(rset.getString("SAFEKEY"));
				bi.setRequestDate(rset.getDate("REQUEST_DATE"));
				bi.setBuyStatus(rset.getString("BUY_STATUS"));
				bi.setUserName(rset.getString("USER_NAME"));
				bi.setGrade(rset.getString("GRADE"));
				bi.setBuyPrice(rset.getInt("BUY_PRICE"));
				bi.setBuyProductNo(rset.getString("BUY_PRODUCT_NO"));
				
				
				list.add(bi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}


	
	public int insertBuyinfotable(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertbuyinfotable");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyinfo.getBuyProductNo());
			pstmt.setString(2, buyinfo.getUserNo());
			pstmt.setString(3, buyinfo.getSafeKey());
			pstmt.setString(4, buyinfo.getGrade());
			pstmt.setInt(5, buyinfo.getBuyPrice());
			pstmt.setString(6, buyinfo.getBuyStatus());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int selectbuyNo(Connection con, BuyInfo buyinfo) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int buyno2 = 0;
		
		String query = prop.getProperty("selectbuyNo");
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				buyno2 = rset.getInt("BUY_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return buyno2;
	}

	public ArrayList<BuyInfo> selectBuyList(Connection con, PageInfo pi, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuyInfo> list = null;
		
		String query = prop.getProperty("selectBuyList");
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() -1;
			
			pstmt.setString(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				BuyInfo bi = new BuyInfo();
				
				bi.setBuyNo(rset.getString("BUY_NO"));
				bi.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				bi.setRequestDate(rset.getDate("REQUEST_DATE"));
				bi.setBuyStatus(rset.getString("BUY_STATUS"));
				bi.setGrade(rset.getString("GRADE"));
				bi.setBuyPrice(rset.getInt("BUY_PRICE"));
				bi.setBuyWaybillNo(rset.getString("WAYBILL_NO"));
				bi.setBuyCarrier(rset.getString("CARRIER"));
				bi.setDivision(rset.getString("DIVISION"));
				bi.setReason(rset.getString("REASON"));
				
				list.add(bi);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
		return list;
	}

	public ArrayList<BuyInfo> selectCurrentList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuyInfo> list = null;
		
		String query = prop.getProperty("selectCurrentList");
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() -1;
			
			pstmt.setInt(1, 0);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				BuyInfo bi = new BuyInfo();
				
				bi.setBuyNo(rset.getString("BUY_NO"));
				bi.setUserId(rset.getString("USER_ID"));
				bi.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				bi.setSafeKey(rset.getString("SAFEKEY"));
				bi.setRequestDate(rset.getDate("REQUEST_DATE"));
				bi.setChangePoint(rset.getInt("CP"));
				bi.setBuyStatus(rset.getString("BUY_STATUS"));
				
				
				list.add(bi);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int listCountCurrent(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCountCurrent = 0;
		
		String query = prop.getProperty("listCountCurrent");
		try {
			stmt = con.createStatement();
			
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCountCurrent = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCountCurrent;
	}

	public int listCountReject(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int listCountReject = 0;
		
		String query = prop.getProperty("listCountReject");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "매입불가");
			pstmt.setString(2, "1차검수탈락");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCountReject = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCountReject;
	}

	public ArrayList<BuyInfo> selectRejectList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuyInfo> list = null;
		
		String query = prop.getProperty("selectRejectList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() -1;
			
			pstmt.setString(1, "매입불가");
			pstmt.setString(2, "1차검수탈락");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				BuyInfo bi = new BuyInfo();
				
				bi.setBuyNo(rset.getString("BUY_NO"));
				bi.setUserId(rset.getString("USER_ID"));
				bi.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				bi.setSafeKey(rset.getString("SAFEKEY"));
				bi.setRequestDate(rset.getDate("REQUEST_DATE"));
				bi.setReason(rset.getString("REASON"));
				bi.setBuyStatus(rset.getString("BUY_STATUS"));
				bi.setBuyWaybillNo(rset.getString("WAYBILL_NO"));
				bi.setDivision(rset.getString("DIVISION"));
				bi.setUserName(rset.getString("USER_NAME"));
				
				list.add(bi);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int listCount(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("listCountMypage");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public ArrayList<HashMap<String, String>> selectExampleList(Connection con, String buyNoVal) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, String>> exampleList = null;
		HashMap<String, String> hmap = null;
		
		String query = prop.getProperty("selectExampleList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyNoVal);
			
			rset = pstmt.executeQuery();
			exampleList = new ArrayList<HashMap<String, String>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, String>();
				
				hmap.put("questionNo", rset.getString("QUESTION_NO"));
				hmap.put("answerNo", rset.getString("EXAMPLE_NO"));
				hmap.put("questionContent", rset.getString("QUESTION_CONTENT"));
				hmap.put("answerContent", rset.getString("EXAMPLE_CONTENT"));
				hmap.put("buyNo", rset.getString("BUY_NO"));
				hmap.put("buyProductName", rset.getString("BUY_PRODUCT_NAME"));
				hmap.put("userNo", rset.getString("USER_NO"));
				hmap.put("userName", rset.getString("USER_NAME"));
				
				exampleList.add(hmap);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return exampleList;
	}

	public ArrayList<HashMap<String, String>> selectPhotoList(Connection con, String buyNoVal) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, String>> fileList = null;
		HashMap<String, String> hmap = null;
		
		String query = prop.getProperty("selectUserPhotoList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyNoVal);
			
			rset = pstmt.executeQuery();
			fileList = new ArrayList<HashMap<String, String>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, String>();
				
				hmap.put("buyAttachmentNo", rset.getString("BUY_ATTACHMENT_NO"));
				hmap.put("originName", rset.getString("ORIGIN_NAME"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));
				
				fileList.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return fileList;
	}
	//buy_info 테이블에 grade, buyPrice insert
	public int updateFirstCheck(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateFirstCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "1");
			pstmt.setString(2, "1차검수완료");
			pstmt.setString(3, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//buy_history
	public int insertFirstHistory(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFirstHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1");
			pstmt.setString(2, "1차검수완료");
			pstmt.setString(3, buyinfo.getReason());
			pstmt.setString(4, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
    public int insertbuyhistory(Connection con, String buyNo) {
       PreparedStatement pstmt = null;
       int history = 0;
       
       String query = prop.getProperty("insertBuyHistory");
      
       try {
          pstmt = con.prepareStatement(query);
          pstmt.setString(1, "1차검수신청");
          pstmt.setString(2, buyNo);
         
          history = pstmt.executeUpdate();
         
         
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          close(pstmt);
       }
      
      return history;
   }

	public int updateFirstCheckReject(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateFirstCheckReject");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1");
			pstmt.setString(2, "1차검수탈락");
			pstmt.setString(3, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertFirstHistoryReject(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFirstHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1");
			pstmt.setString(2, "1차검수탈락");
			pstmt.setString(3, buyinfo.getReason());
			pstmt.setString(4, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}

	public BuyInfo selectRequestDetail(Connection con, String buyNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BuyInfo buyinfo = null;
		
		String query = prop.getProperty("selectRequestDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, buyNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				buyinfo = new BuyInfo();
				
				buyinfo.setUserName(rset.getString("USER_NAME"));
				buyinfo.setUserNo(rset.getString("USER_NO"));
				buyinfo.setUserId(rset.getString("USER_ID"));
				buyinfo.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				buyinfo.setBuyAddress(rset.getString("BUYADDRESS"));
				buyinfo.setWaybillNo(rset.getString("WAYBILL_NO"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
				
		return buyinfo;
	}
	public BuyInfo selectRequestDetailReject(Connection con, String buyNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BuyInfo buyinfo = null;
		
		String query = prop.getProperty("selectRequestDetailReject");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, buyNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				buyinfo = new BuyInfo();
				
				buyinfo.setUserName(rset.getString("USER_NAME"));
				buyinfo.setUserNo(rset.getString("USER_NO"));
				buyinfo.setUserId(rset.getString("USER_ID"));
				buyinfo.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				buyinfo.setBuyAddress(rset.getString("BUYADDRESS"));
				buyinfo.setBuyWaybillNo(rset.getString("WAYBILL_NO"));
				buyinfo.setDivision(rset.getString("DIVISION"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
				
		return buyinfo;
	}

	public HashMap<String, Object> selectPhotoListDetail(Connection con, String buyNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		BuyInfo buyinfo = null;
		
		ArrayList<BuyAttachment> list = null;
		BuyAttachment ba = null;
		
		String query = prop.getProperty("selectUserPhotoList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyNo);
			
			rset = pstmt.executeQuery();
			hmap = new HashMap<String, Object>();
			list = new ArrayList<BuyAttachment>();
			
			while(rset.next()) {
				 buyinfo = new BuyInfo();
				 buyinfo.setBuyNo(rset.getString("BUY_NO"));
				 
				 ba = new BuyAttachment();
				 ba.setBuyAttahmentNo(rset.getString("BUY_ATTACHMENT_NO"));
				 ba.setOriginName(rset.getString("ORIGIN_NAME"));
				 ba.setChangeName(rset.getString("CHANGE_NAME"));
				 
				list.add(ba);
				
			}
			hmap.put("buyinfo", buyinfo);
			hmap.put("fileList", list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hmap;
	}

	public BuyInfo selectQuote(Connection con, String buyNoVal) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BuyInfo buyinfo = null;
		
		String query = prop.getProperty("selectQuote");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyNoVal);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				buyinfo = new BuyInfo();
				
				buyinfo.setBuyNo(rset.getString("BUY_NO"));
				buyinfo.setBuyPrice(rset.getInt("BUY_PRICE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return buyinfo;
	}
	//매입신청정보 업데이트
	public int updateSecondCheck(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateSecondCheck");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "매입완료");
			pstmt.setInt(2, buyinfo.getBuyPrice());
			pstmt.setString(3, buyinfo.getGrade());
			pstmt.setString(4, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//직원 체크리스트 디비 인설트
	public int insertEmpAnswer(Connection con, HashMap<String, String> hmap, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertEmpAnswer");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "1");
			pstmt.setString(2, hmap.get("1"));
			pstmt.setString(3, buyinfo.getBuyNo());
			pstmt.setString(4, "1");
			
			pstmt.setString(5, "2");
			pstmt.setString(6, hmap.get("2"));
			pstmt.setString(7, buyinfo.getBuyNo());
			pstmt.setString(8, "1");
			
			pstmt.setString(9, "3");
			pstmt.setString(10, hmap.get("3"));
			pstmt.setString(11, buyinfo.getBuyNo());
			pstmt.setString(12, "1");
			
			pstmt.setString(13, "4");
			pstmt.setString(14, hmap.get("4"));
			pstmt.setString(15, buyinfo.getBuyNo());
			pstmt.setString(16, "1");
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	//포인트 히스토리 매입부분 이력 인서트
	public int insertBuyPoint(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBuyPoint");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyinfo.getChangePoint());
			pstmt.setString(2, buyinfo.getBuyNo());
			pstmt.setString(3, buyinfo.getUserNo());
			pstmt.setString(4, "매입 포인트 지급");
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//매입 내력 업데이트
	public int insertSecondHistory(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertSecondHistory");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1");
			pstmt.setString(2, "매입완료");
			pstmt.setString(3, buyinfo.getReason());
			pstmt.setString(4, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateSecondRejectCheck(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateSecondCheckReject");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "매입불가");
			pstmt.setString(2, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
		
				
	}

	public int insertSecondRejectHistory(Connection con, BuyInfo buyinfo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertSecondHistory");
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "1");
			pstmt.setString(2, "매입불가");
			pstmt.setString(3, buyinfo.getReason());
			pstmt.setString(4, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertWaybill(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertWaybill");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyinfo.getWaybillNo());
			pstmt.setString(2, buyinfo.getBuyNo());
			pstmt.setString(3, "배송대기중");
			pstmt.setString(4, buyinfo.getCarrier());
			pstmt.setString(5, "인수");
			
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBuyAddress(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBuyAddress");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyinfo.getBuyAddress());
			pstmt.setString(2, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBuyStatus(Connection con, String buyNoVal) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBuyStatus");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "인수대기중");
			pstmt.setString(2, buyNoVal);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBuyHistoryStatus(Connection con, String buyNoVal) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBuyHistoryStatus");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1");
			pstmt.setString(2, "인수대기중");
			pstmt.setString(3, buyNoVal);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//buy_status 업데이트
	public int updatewaybillStatus(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBuyStatus");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "인수완료");
			pstmt.setString(2, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBuyHistoryStatus(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBuyHistoryStatus");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1");
			pstmt.setString(2, "인수완료");
			pstmt.setString(3, buyinfo.getBuyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertDeliveryHistory(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertWaybill");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyinfo.getBuyWaybillNo());
			pstmt.setString(2, buyinfo.getBuyNo());
			pstmt.setString(3, "배송대기중");
			pstmt.setString(4, buyinfo.getBuyCarrier());
			pstmt.setString(5, "반송");
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectBuyPrice(Connection con, BuyInfo buyinfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int price = 0;
		
		String query = prop.getProperty("selectBuyPrice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, buyinfo.getBuyProductNo());
			pstmt.setString(2, buyinfo.getGrade());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				price = rset.getInt("PRICE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return price;
	}

	public Member selectPoint(Connection con, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		String query = prop.getProperty("selectPoint");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				member = new Member();
				
				member.setUserNo(rset.getString("USER_NO"));
				member.setPoint(rset.getInt("POINT"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int updatePoint(Connection con, Member member, int point) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePoint");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, member.getPoint() + point);
			pstmt.setString(2, member.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}







}
