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

import com.kh.forest.common.SelectQueryMaker;
import com.kh.forest.product.model.vo.A_ProductInfo;
import com.kh.forest.product.model.vo.Category;
import com.kh.forest.product.model.vo.DefaultInfo;
import com.kh.forest.product.model.vo.E_PageInfo;
import com.kh.forest.product.model.vo.Product;
import com.kh.forest.product.model.vo.ProductAttachment;
import com.kh.forest.product.model.vo.Rental;


public class E_ProductDao {
	Properties prop = new Properties();;

	public E_ProductDao(){
		String fileName = E_ProductDao.class.getResource("/sql/product/E_product-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertBarcode(Connection con, ProductAttachment b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertBarcode");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getOriginName());
			pstmt.setString(2, b.getChangeName());
			pstmt.setString(3, b.getSavePath());
			pstmt.setString(4, b.getProductNo());
			pstmt.setString(5, b.getDivision());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int countBarcodeList(Connection con) {
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = prop.getProperty("countBarcodeList");
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "바코드");

			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return result;
	}

	public ArrayList<ProductAttachment> barcodeList(Connection con, E_PageInfo pi) {
		ArrayList<ProductAttachment> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("barcodeList");

		try {
			pstmt = con.prepareStatement(query);


			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setString(1,"바코드");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<ProductAttachment>();

			while(rset.next()) {
				ProductAttachment b = new ProductAttachment();
				b.setProductNo(rset.getString("PRODUCT_NO"));
				b.setOriginName(rset.getString("ORIGIN_NAME"));
				b.setChangeName(rset.getString("CHANGE_NAME"));
				b.setSavePath(rset.getString("SAVE_PATH"));
				b.setEnrollDate(rset.getDate("ENROLL_DATE"));
				b.setProductName(rset.getString("PRODUCT_NAME"));
				b.setCategoryNo(rset.getString("CATEGORY_NO"));
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				list.add(b);
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

	public ArrayList<Category> selectCategory(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectCategory");
		ArrayList<Category> list = null;
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Category>();

			while(rset.next()) {
				Category c = new Category();
				c.setCategoryNo(rset.getString("CATEGORY_NO"));
				c.setCategoryName(rset.getString("CATEGORY_NAME"));
				c.setCategoryLevel(rset.getInt("CATEGORY_LEVEL"));
				c.setCategoryUpper(rset.getInt("CATEGORY_UPPER"));

				list.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public Product selectBuyHistroy(Connection con, String buyNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product requestP = null;
		String query = prop.getProperty("selectBuyHistory");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "매입완료");
			pstmt.setString(2, buyNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				requestP = new Product();
				requestP.setCategoryNo(rset.getString("CATEGORY_NO"));
				requestP.setCategoryName(rset.getString("CATEGORY_NAME"));
				requestP.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				requestP.setBuyProductNo(rset.getString("BUY_PRODUCT_NO"));
				requestP.setManufacturerName(rset.getString("MANUFACTURER_NAME"));
				requestP.setManufacturerNo(rset.getString("MANUFACTURER_NO"));
				requestP.setGrade(rset.getString("GRADE"));
				requestP.setMarketprice(rset.getString("MARKETPRICE"));
				requestP.setBuyPrice(rset.getString("PRICE"));
				requestP.setEmpNo(rset.getString("EMP_NO"));
				requestP.setEmpName(rset.getString("EMP_NAME"));
				requestP.setWarehouseName(rset.getString("WAREHOUSE_NAME"));
				requestP.setWarehouseNo(rset.getString("WAREHOUSE_NO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 


		return requestP;
	}

	public int inventoryInsert(Connection con, Product insertProduct) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("inventoryInsert");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, insertProduct.getProductNo());
			pstmt.setString(2, insertProduct.getManufacturerNo());
			pstmt.setString(3, insertProduct.getBuyNo());
			pstmt.setString(4, insertProduct.getCategoryNo());
			pstmt.setString(5, insertProduct.getProductName());
			pstmt.setString(6, insertProduct.getWarehouseNo());
			pstmt.setString(7, insertProduct.getBuyPrice());
			pstmt.setString(8, insertProduct.getBuyProductNo());
			pstmt.setString(9, insertProduct.getEmpNo());
			pstmt.setString(10, insertProduct.getGrade());
			pstmt.setString(11, insertProduct.getSepcialNote());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertAttachment(Connection con, ProductAttachment productAttachment) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertAttachment");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productAttachment.getOriginName());
			pstmt.setString(2, productAttachment.getChangeName());
			pstmt.setString(3, productAttachment.getSavePath());
			pstmt.setString(4, productAttachment.getProductNo());
			pstmt.setString(5, "상품사진");

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		}finally {
			close(pstmt);
		}

		return result;
	}
	public int insertProductHistory(Connection con, String productNo, String status) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertProductHistory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNo);
			pstmt.setString(2, status);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}


	public int countInventoryList(Connection con) {
		Statement stmt= null;
		ResultSet rset = null;
		String query = prop.getProperty("countInventoryList");
		int result = 0;

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		return result;
	}

	public ArrayList<Product> inventoryList(Connection con, E_PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("inventoryList");

		ArrayList<Product> list= null;

		try {
			pstmt = con.prepareStatement(query);

			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			list= new ArrayList<Product>();

			while(rset.next()) {
				Product p = new Product();

				p.setEmpName(rset.getString("EMP_NAME"));
				p.setProductNo(rset.getString("PRODUCT_NO"));
				p.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				p.setProductEnrolldate(rset.getDate("PRODUCT_ENROLLDATE"));
				p.setProductStatus(rset.getString("PRODUCT_STATUS"));
				p.setWarehouseName(rset.getString("WAREHOUSE_NAME"));
				p.setHompageUpdate(rset.getString("HOMEPAGE_UPDATE"));



				list.add(p);
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

	public Product selectOne(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectOne");
		Product selectOne = null;


		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				selectOne = new Product();
				selectOne.setEmpNo(rset.getString("EMP_NO"));
				selectOne.setEmpName(rset.getString("EMP_NAME"));
				selectOne.setProductNo(rset.getString("PRODUCT_NO"));
				selectOne.setProductName(rset.getString("PRODUCT_NAME"));
				selectOne.setBuyProductNo(rset.getString("BUY_PRODUCT_NO"));
				selectOne.setCategoryNo(rset.getString("CATEGORY_NO"));
				selectOne.setCategoryName(rset.getString("CATEGORY_NAME"));
				selectOne.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				selectOne.setWarehouseNo(rset.getString("WAREHOUSE_NO"));
				selectOne.setWarehouseName(rset.getString("WAREHOUSE_NAME"));
				selectOne.setManufacturerName(rset.getString("MANUFACTURER_NAME"));
				selectOne.setManufacturerNo(rset.getString("MANUFACTURER_NO"));
				selectOne.setGrade(rset.getString("GRADE"));
				selectOne.setBuyPrice(rset.getString("BUY_PRICE"));
				selectOne.setMarketprice(rset.getString("MARKETPRICE"));
				selectOne.setSepcialNote(rset.getString("SPECIAL_NOTE"));
				selectOne.setBuyNo(rset.getString("BUY_NO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return selectOne;
	}

	public ArrayList<ProductAttachment> selectOneAttach(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductAttachment> selectOneAttach = null;
		String query = prop.getProperty("selectOneAttach");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNo);
			pstmt.setString(2, "상품사진");

			rset = pstmt.executeQuery();

			selectOneAttach = new ArrayList<ProductAttachment>();

			while(rset.next()) {
				ProductAttachment p = new ProductAttachment();
				p.setChangeName(rset.getString("CHANGE_NAME"));

				selectOneAttach.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return selectOneAttach;
	}

	public int updateInventory(Connection con, Product requestUpdate) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateInventory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestUpdate.getCategoryNo());
			pstmt.setString(2, requestUpdate.getGrade());
			pstmt.setString(3, requestUpdate.getWarehouseNo());
			pstmt.setString(4, requestUpdate.getSepcialNote());
			pstmt.setString(5, requestUpdate.getProductNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public DefaultInfo selectDefaultInfo(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		DefaultInfo di = null;
		String query = prop.getProperty("selectDefaulInfo");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			di = new DefaultInfo();
			if(rset.next()) {
				di.setDeliveryInfo(rset.getString("DELIVERY_INFO"));
				di.setNoticeInfo(rset.getString("NOTICE_INFO"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}


		return di;
	}

	public int updateDefaultInfo(Connection con, DefaultInfo requestInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateDefaultInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestInfo.getNoticeInfo());
			pstmt.setString(2, requestInfo.getDeliveryInfo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}



	public int insertAttachment_empty_1(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertAttachment_empty");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 1);
			pstmt.setString(2, productNo);
			pstmt.setString(3, "상품등록사진");

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertAttachment_empty_0(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertAttachment_empty");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, productNo);
			pstmt.setString(3, "상품등록사진");

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Product selectProductDefault(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectProductDefault");

		Product productDefault = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNo);

			rset = pstmt.executeQuery();


			if(rset.next()) {
				productDefault = new Product();
				productDefault.setProductNo(rset.getString("PRODUCT_NO"));
				productDefault.setProductName(rset.getString("PRODUCT_NAME"));
				productDefault.setBuyProductNo(rset.getString("BUY_PRODUCT_NO"));
				productDefault.setCategoryNo(rset.getString("CATEGORY_NO"));
				productDefault.setCategoryName(rset.getString("CATEGORY_NAME"));
				productDefault.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				productDefault.setWarehouseName(rset.getString("WAREHOUSE_NAME"));
				productDefault.setManufacturerName(rset.getString("MANUFACTURER_NAME"));
				productDefault.setManufacturerNo(rset.getString("MANUFACTURER_NO"));
				productDefault.setGrade(rset.getString("GRADE"));
				productDefault.setBuyPrice(rset.getString("BUY_PRICE"));
				productDefault.setMarketprice(rset.getString("MARKETPRICE"));
				productDefault.setBuyNo(rset.getString("BUY_NO"));
				productDefault.setRentalPrice(rset.getString("RENTAL_PRICE"));
				productDefault.setDeliveryInfo(rset.getString("DELIVERY_INFO"));
				productDefault.setProductDetail(rset.getString("PRODUCT_DETAIL"));
				productDefault.setProductNotice(rset.getString("PRODUCT_NOTICE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productDefault;
	}

	public ArrayList<ProductAttachment> selectProductDefaultattach(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectProductDefaultAttach");

		ArrayList<ProductAttachment> productDefaultAttach = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "상품등록사진");
			pstmt.setString(2, productNo);
			rset = pstmt.executeQuery();

			productDefaultAttach = new ArrayList<ProductAttachment>();

			while(rset.next()) {
				ProductAttachment pa = new ProductAttachment();
				pa.setChangeName(rset.getString("CHANGE_NAME"));

				productDefaultAttach.add(pa);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productDefaultAttach;
	}

	public int selectAttachNo(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int num = 0;
		String query = prop.getProperty("selectAttachNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNo);
			pstmt.setString(2, "상품등록사진");

			rset = pstmt.executeQuery();
			if(rset.next()) {
				num = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return num;
	}


	public int insertProduct(Connection con, Product insertProduct) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertProduct");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, insertProduct.getProductDetail());
			pstmt.setString(2, insertProduct.getRentalPrice());
			pstmt.setString(3, insertProduct.getProductName());
			pstmt.setString(4, insertProduct.getProductNotice());
			pstmt.setString(5, insertProduct.getDeliveryInfo());
			pstmt.setString(6, insertProduct.getProductNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public int insertProductAttach(Connection con, ProductAttachment productAttachment, int num) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertProductAttach");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productAttachment.getOriginName());
			pstmt.setString(2, productAttachment.getChangeName());
			pstmt.setString(3, productAttachment.getSavePath());
			pstmt.setInt(4, num);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Product> productList(Connection con, E_PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("productList");

		ArrayList<Product> productList= null;

		try {
			pstmt = con.prepareStatement(query);

			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setString(1, "상품등록사진");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			productList= new ArrayList<Product>();

			while(rset.next()) {
				Product p = new Product();

				p.setEmpName(rset.getString("EMP_NAME"));
				p.setProductNo(rset.getString("PRODUCT_NO"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				p.setProductEnrolldate(rset.getDate("PRODUCT_ENROLLDATE"));
				p.setProductStatus(rset.getString("PRODUCT_STATUS"));
				p.setWarehouseName(rset.getString("WAREHOUSE_NAME"));
				p.setTemp(rset.getString("CHANGE_NAME"));
				p.setRentalPrice(rset.getString("RENTAL_PRICE"));
				productList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return productList;
	}

	public A_ProductInfo selectProductDetail(Connection con, String proNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		A_ProductInfo p = null;
		String query = prop.getProperty("selectOneProductDetail");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, proNum);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				p = new A_ProductInfo();

				p.setProductNo(rset.getString("PRODUCT_NO"));
				p.setProductEnrolldate(rset.getString("PRODUCT_ENROLLDATE"));
				p.setManufacturerName(rset.getString("MANUFACTURER_NAME"));
				p.setAcceptanceMonth(rset.getInt("ACCEPTANCE_MONTH"));
				p.setBuyNo(rset.getString("BUY_NO"));
				p.setCategoryName(rset.getString("CATEGORY_NAME"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setWarehouseNo(rset.getString("WAREHOUSE_NO"));
				p.setProductDetail(rset.getString("PRODUCT_DETAIL"));
				p.setHomepageUpdate(rset.getString("HOMEPAGE_UPDATE"));
				p.setProductNotice(rset.getString("PRODUCT_NOTICE"));
				p.setDeliveryInfo(rset.getString("DELIVERY_INFO"));
				p.setMainpageUpdate(rset.getString("MAINPAGE_UPDATE"));
				p.setBuyPrice(rset.getString("BUY_PRICE"));
				p.setBuyProductNo(rset.getString("BUY_PRODUCT_NO"));
				p.setEmpNo(rset.getString("EMP_NO"));
				p.setGrade(rset.getString("GRADE"));
				p.setSpecialNote(rset.getString("SPECIAL_NOTE"));
				p.setRentalPrice(rset.getString("RENTAL_PRICE"));
				p.setRentalStatus(rset.getString("RENTAL_STATUS"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public ArrayList<Rental> rentalList(Connection con, E_PageInfo pi, String loginMemberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("rentalList");

		ArrayList<Rental> rentalList = null;

		try {
			pstmt = con.prepareStatement(query);

			rentalList = new ArrayList<Rental>();

			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setString(1, loginMemberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while(rset.next()) {
				Rental r  = new Rental();

				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setProductName(rset.getString("PRODUCT_NAME"));
				r.setChangeName(rset.getString("CHANGE_NAME"));
				r.setRentalMonth(rset.getString("RENTAL_MONTH"));
				r.setPrice(rset.getString("PRICE"));
				r.setStartDate(rset.getDate("START_DATE"));
				r.setExpiryDate(rset.getDate("EXPIRY_DATE"));
				r.setRentalStatus(rset.getString("RENTAL_STATUS"));
				r.setOrderStatus(rset.getString("ORDER_STATUS"));
				r.setRecipient(rset.getString("RECIPIENT"));
				r.setPhone(rset.getString("PHONE"));
				r.setAddress(rset.getString("ADDRESS"));
				r.setOrderNo(rset.getString("ORDER_NO"));
				r.setOrderCode(rset.getString("ORDER_CODE"));
				r.setRentalNo(rset.getString("RENTAL_NO"));
				r.setRefundStatus(rset.getString("REFUND_STATUS"));
				r.setrTitle(rset.getString("RTITLE"));
				rentalList.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return rentalList;
	}

	public int insertRefund(Connection con,String reason, String orderCode, int rate) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertRefund");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderCode);
			pstmt.setString(2, reason);
			pstmt.setInt(3, rate);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public int insertRefundHistory(Connection con, String orderCode) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query= prop.getProperty("insertRefundHistory");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderCode);
			pstmt.setString(2, "환불대기중");

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public int calculateTerm(Connection con, String refundNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int term = 0;
		String query = prop.getProperty("calculateTerm");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "배송완료");
			pstmt.setString(2, refundNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				term = rset.getInt(1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return term;
	}

	public String selectRefundNo(Connection con, String orderCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String refundNo="";
		String query = prop.getProperty("selectRefundNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderCode);

			rset=pstmt.executeQuery();

			if(rset.next()) {
				refundNo=rset.getString("REFUND_NO");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return refundNo;
	}

	public A_ProductInfo selectExtendProduct(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		A_ProductInfo extendProduct = null;
		String query = prop.getProperty("selectOneProductDetail");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				extendProduct = new A_ProductInfo();

				extendProduct.setProductNo(rset.getString("PRODUCT_NO"));
				extendProduct.setProductEnrolldate(rset.getString("PRODUCT_ENROLLDATE"));
				extendProduct.setManufacturerName(rset.getString("MANUFACTURER_NAME"));
				extendProduct.setAcceptanceMonth(rset.getInt("ACCEPTANCE_MONTH"));
				extendProduct.setBuyNo(rset.getString("BUY_NO"));
				extendProduct.setCategoryName(rset.getString("CATEGORY_NAME"));
				extendProduct.setProductName(rset.getString("PRODUCT_NAME"));
				extendProduct.setWarehouseNo(rset.getString("WAREHOUSE_NO"));
				extendProduct.setProductDetail(rset.getString("PRODUCT_DETAIL"));
				extendProduct.setHomepageUpdate(rset.getString("HOMEPAGE_UPDATE"));
				extendProduct.setProductNotice(rset.getString("PRODUCT_NOTICE"));
				extendProduct.setDeliveryInfo(rset.getString("DELIVERY_INFO"));
				extendProduct.setMainpageUpdate(rset.getString("MAINPAGE_UPDATE"));
				extendProduct.setBuyPrice(rset.getString("BUY_PRICE"));
				extendProduct.setBuyProductNo(rset.getString("BUY_PRODUCT_NO"));
				extendProduct.setEmpNo(rset.getString("EMP_NO"));
				extendProduct.setGrade(rset.getString("GRADE"));
				extendProduct.setSpecialNote(rset.getString("SPECIAL_NOTE"));
				extendProduct.setRentalPrice(rset.getString("RENTAL_PRICE"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return extendProduct;
	}

	public int countProductList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("countProductList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "상품등록사진");

			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return result;
	}

	public int countRentalList(Connection con, String loginMemberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("countRentalList");
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginMemberNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally {
			close(pstmt);
			close(rset);
		}
		return result;
	}
	public int searchingBarcodeCount(Connection con, String categoryNo, String select, String value,
			String stockStatus) {
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		SelectQueryMaker withQuery = new SelectQueryMaker
				.Builder()
				.select().column("P.PRODUCT_NO")
				.comma().column("P.PRODUCT_NAME")
				.comma().column("C.CATEGORY_NO")
				.comma().column("C.CATEGORY_NAME")
				.comma().column("BP.BUY_PRODUCT_NAME").enter()
				.from().columnName("PRODUCT").as("P").enter()
				.join().columnName("BUY_INFO").as("BI").on().equalCondition("BI.BUY_NO", "P.BUY_NO").enter()
				.join().columnName("BUY_PRODUCT").as("BP").on().equalCondition("BI.BUY_PRODUCT_NO", "BP.BUY_PRODUCT_NO").enter()
				.join().columnName("CATEGORY").as("C").on().equalCondition("BP.CATEGORY_NO", "C.CATEGORY_NO").enter()
				.build();

		SelectQueryMaker countQuery_start = new SelectQueryMaker
				.Builder()
				.column("WITH PI AS ").subQuery(withQuery)
				.select().column("COUNT(B.PRODUCT_ATTACHMENT_NO)").enter()
				.from().columnName("PRODUCT_ATTACHMENT B, PI").enter()
				.where().columnName("B.PRODUCT_NO").equal().columnName("PI.PRODUCT_NO(+)").enter()
				.and().columnName("B.DIVISION").equal().condition("바코드").enter()
				.build();


		if(!categoryNo.equals("0")) {
			countQuery_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.CATEGORY_NO").equal().condition(categoryNo).enter()
							.build()	
							)
					.build();
		}
		if(select.equals("all")) {
			countQuery_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("(")
							.columnName("PI.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("PI.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("B.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.columnName(")")
							.build()
							)
					.build();
		}else if(select.equals("productNo")) {
			countQuery_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("B.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("productName")) {
			countQuery_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("buyProductName")) {
			countQuery_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}
		if(stockStatus!=null&&stockStatus.equals("Y")) {
			countQuery_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.PRODUCT_NAME").isNotNull().enter()
							.build()
							)
					.build();
		}else if(stockStatus!=null&&stockStatus.equals("N")){
			countQuery_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.PRODUCT_NAME").isNull().enter()
							.build()
							)
					.build();
		}

		SelectQueryMaker countQuery_end = new SelectQueryMaker
				.Builder()		
				.orderBy().columnName("B.ENROLL_DATE").desc()

				.build();

		SelectQueryMaker countQuery = new SelectQueryMaker
				.Builder()
				.add(countQuery_start).add(countQuery_end)
				.build();

		String query = countQuery.getQuery().toString();

		int result = 0;

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return result;
	}
	public ArrayList<ProductAttachment> searchingBarcode(Connection con, E_PageInfo pi,
			String categoryNo, String select, String value,	String stockStatus) {
		ArrayList<ProductAttachment> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SelectQueryMaker withQuery = new SelectQueryMaker
				.Builder()
				.select().column("P.PRODUCT_NO")
				.comma().column("P.PRODUCT_NAME")
				.comma().column("C.CATEGORY_NO")
				.comma().column("C.CATEGORY_NAME")
				.comma().column("BP.BUY_PRODUCT_NAME").enter()
				.from().columnName("PRODUCT").as("P").enter()
				.join().columnName("BUY_INFO").as("BI").on().equalCondition("BI.BUY_NO", "P.BUY_NO").enter()
				.join().columnName("BUY_PRODUCT").as("BP").on().equalCondition("BI.BUY_PRODUCT_NO", "BP.BUY_PRODUCT_NO").enter()
				.join().columnName("CATEGORY").as("C").on().equalCondition("BP.CATEGORY_NO", "C.CATEGORY_NO").enter()
				.build();

		SelectQueryMaker sideQuery3_start = new SelectQueryMaker
				.Builder()
				.select().column("B.PRODUCT_ATTACHMENT_NO")
				.comma().column("B.ORIGIN_NAME")
				.comma().column("B.CHANGE_NAME")
				.comma().column("B.SAVE_PATH")
				.comma().column("B.ENROLL_DATE")
				.comma().column("B.PRODUCT_LEVEL")
				.comma().column("B.PRODUCT_NO")
				.comma().column("B.DIVISION")
				.comma().column("PI.PRODUCT_NAME")
				.comma().column("PI.CATEGORY_NO")
				.comma().column("PI.CATEGORY_NAME")
				.comma().column("PI.BUY_PRODUCT_NAME").enter()
				.from().columnName("PRODUCT_ATTACHMENT B, PI").enter()
				.where().columnName("B.PRODUCT_NO").equal().columnName("PI.PRODUCT_NO(+)").enter()
				.and().columnName("B.DIVISION").equal().condition("바코드").enter()
				.build();


		if(!categoryNo.equals("0")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.CATEGORY_NO").equal().condition(categoryNo).enter()
							.build()	
							)
					.build();
		}
		if(select.equals("all")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("(")
							.columnName("PI.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("PI.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("B.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.columnName(")")
							.build()
							)
					.build();
		}else if(select.equals("productNo")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("B.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("productName")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("buyProductName")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}
		if(stockStatus!=null&&stockStatus.equals("Y")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.PRODUCT_NAME").isNotNull().enter()
							.build()
							)
					.build();
		}else if(stockStatus!=null&&stockStatus.equals("N")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("PI.PRODUCT_NAME").isNull().enter()
							.build()
							)
					.build();
		}

		SelectQueryMaker sideQuery3_end = new SelectQueryMaker
				.Builder()		
				.orderBy().columnName("B.ENROLL_DATE").desc()

				.build();

		SelectQueryMaker sideQuery3 = new SelectQueryMaker
				.Builder()
				.add(sideQuery3_start).add(sideQuery3_end)
				.build();

		SelectQueryMaker sideQuery2 = new SelectQueryMaker
				.Builder()
				.select().column("ROWNUM").as("RNUM")
				.comma().column("PRODUCT_ATTACHMENT_NO")
				.comma().column("ORIGIN_NAME")
				.comma().column("CHANGE_NAME")
				.comma().column("SAVE_PATH")
				.comma().column("ENROLL_DATE")
				.comma().column("PRODUCT_LEVEL")
				.comma().column("PRODUCT_NO")
				.comma().column("DIVISION")
				.comma().column("PRODUCT_NAME")
				.comma().column("CATEGORY_NO")
				.comma().column("CATEGORY_NAME")
				.comma().column("BUY_PRODUCT_NAME").enter()
				.from().subQuery(sideQuery3)
				.build();
		SelectQueryMaker sideQuery1 = new SelectQueryMaker
				.Builder()
				.column("WITH PI AS ").subQuery(withQuery)
				.select().column("RNUM")
				.comma().column("PRODUCT_ATTACHMENT_NO")
				.comma().column("ORIGIN_NAME")
				.comma().column("CHANGE_NAME")
				.comma().column("SAVE_PATH")
				.comma().column("ENROLL_DATE")
				.comma().column("PRODUCT_LEVEL")
				.comma().column("PRODUCT_NO")
				.comma().column("DIVISION")
				.comma().column("PRODUCT_NAME")
				.comma().column("CATEGORY_NO")
				.comma().column("CATEGORY_NAME")
				.comma().column("BUY_PRODUCT_NAME").enter()
				.from().subQuery(sideQuery2)
				.where().columnName("RNUM").betweenAnd("?", "?")
				.build();
		String query = sideQuery1.getQuery().toString();

		try {
			pstmt = con.prepareStatement(query);


			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<ProductAttachment>();

			while(rset.next()) {
				ProductAttachment b = new ProductAttachment();
				b.setProductNo(rset.getString("PRODUCT_NO"));
				b.setOriginName(rset.getString("ORIGIN_NAME"));
				b.setChangeName(rset.getString("CHANGE_NAME"));
				b.setSavePath(rset.getString("SAVE_PATH"));
				b.setEnrollDate(rset.getDate("ENROLL_DATE"));
				b.setProductName(rset.getString("PRODUCT_NAME"));
				b.setCategoryNo(rset.getString("CATEGORY_NO"));
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				list.add(b);
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
	public ArrayList<Product> searchingProduct(Connection con, E_PageInfo pi, String categoryNo, String select,
			String value, String productStatus) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		SelectQueryMaker sideQuery5 = new SelectQueryMaker
				.Builder()
				.select().column("PRODUCT_NO")
				.comma().column("MAX(PRO_HISTORY_DATE)").as("HDATE").enter()
				.from().columnName("PRODUCT_HISTORY").enter()
				.groupBy().columnName("PRODUCT_NO")
				.build();

		SelectQueryMaker sideQuery4 = new SelectQueryMaker
				.Builder()
				.select().column("PH1.PRODUCT_NO")
				.comma().column("PH2.PRODUCT_STATUS").enter()
				.from().subQuery(sideQuery5).as("PH1").enter()
				.join().columnName("PRODUCT_HISTORY").as("PH2").on().equalCondition("PH1.HDATE", "PH2.PRO_HISTORY_DATE")
				.build();

		SelectQueryMaker sideQuery3_start = new SelectQueryMaker
				.Builder()
				.select().column("E.EMP_NAME")
				.comma().column("P.PRODUCT_NO")
				.comma().column("P.PRODUCT_ENROLLDATE")
				.comma().column("P.PRODUCT_NAME")
				.comma().column("BP.BUY_PRODUCT_NAME")
				.comma().column("P.HOMEPAGE_UPDATE")
				.comma().column("P.CATEGORY_NO")
				.comma().column("C.CATEGORY_NAME")
				.comma().column("W.WAREHOUSE_NAME")
				.comma().column("S.PRODUCT_STATUS")
				.comma().column("PA.CHANGE_NAME")
				.comma().column("PA.PRODUCT_LEVEL")
				.comma().column("PA.DIVISION")
				.comma().column("P.RENTAL_PRICE").enter()
				.from().columnName("PRODUCT").as("P").enter()
				.join().columnName("EMPLOYEE").as("E").on().equalCondition("P.EMP_NO", "E.EMP_NO")
				.join().columnName("CATEGORY").as("C").on().equalCondition("P.CATEGORY_NO", "C.CATEGORY_NO").enter()
				.join().columnName("MANUFACTURER").as("MF").on().equalCondition("P.MANUFACTURER_NO", "MF.MANUFACTURER_NO").enter()
				.join().columnName("WAREHOUSE").as("W").on().equalCondition("W.WAREHOUSE_NO", "P.WAREHOUSE_NO")
				.join().columnName("BUY_INFO").as("BI").on().equalCondition("P.BUY_NO", "BI.BUY_NO").enter()
				.join().columnName("BUY_PRODUCT").as("BP").on().equalCondition("BI.BUY_PRODUCT_NO", "BP.BUY_PRODUCT_NO").enter()
				.join().columnName("PRODUCT_ATTACHMENT").as("PA").on().equalCondition("PA.PRODUCT_NO", "P.PRODUCT_NO").enter()
				.join().subQuery(sideQuery4).as("S").on().equalCondition("S.PRODUCT_NO", "P.PRODUCT_NO").enter()
				.where().columnName("PA.DIVISION").equal().condition("상품등록사진").enter()
				.and().columnName("PA.PRODUCT_LEVEL").equal().condition(1).enter()
				.and().columnName("P.HOMEPAGE_UPDATE").equal().condition("Y").enter()
				.build();
		if(!categoryNo.equals("0")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.CATEGORY_NO").equal().condition(categoryNo).enter()
							.build()	
							)
					.build();
		}
		if(select.equals("all")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("(")
							.columnName("P.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("BP.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("P.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.columnName(")")
							.build()
							)
					.build();
		}else if(select.equals("productNo")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("productName")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("buyProductName")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("BP.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}
		if(productStatus!=null&&productStatus.equals("A")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("렌탈중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("B")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("보유중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("C")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("수리중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("D")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("인수됨").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("E")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("임시대여중").enter()
							.build()
							)
					.build();
		}


		SelectQueryMaker sideQuery3_end = new SelectQueryMaker
				.Builder()
				.orderBy().columnName("P.PRODUCT_ENROLLDATE").desc()
				.build();
		SelectQueryMaker sideQuery3 = new SelectQueryMaker
				.Builder()
				.add(sideQuery3_start).add(sideQuery3_end)
				.build();

		SelectQueryMaker sideQuery2 = new SelectQueryMaker
				.Builder()
				.select().column("ROWNUM").as("RNUM")
				.comma().column("EMP_NAME")
				.comma().column("PRODUCT_NO")
				.comma().column("PRODUCT_ENROLLDATE")
				.comma().column("PRODUCT_NAME")
				.comma().column("BUY_PRODUCT_NAME")
				.comma().column("HOMEPAGE_UPDATE")
				.comma().column("CATEGORY_NAME")
				.comma().column("WAREHOUSE_NAME")
				.comma().column("PRODUCT_STATUS")
				.comma().column("CHANGE_NAME")
				.comma().column("PRODUCT_LEVEL")
				.comma().column("DIVISION")
				.comma().column("RENTAL_PRICE").enter()
				.from().subQuery(sideQuery3)
				.build();

		SelectQueryMaker sideQuery1 = new SelectQueryMaker
				.Builder()
				.select().column("RNUM")
				.comma().column("EMP_NAME")
				.comma().column("PRODUCT_NO")
				.comma().column("PRODUCT_ENROLLDATE")
				.comma().column("PRODUCT_NAME")
				.comma().column("BUY_PRODUCT_NAME")
				.comma().column("HOMEPAGE_UPDATE")
				.comma().column("CATEGORY_NAME")
				.comma().column("WAREHOUSE_NAME")
				.comma().column("PRODUCT_STATUS")
				.comma().column("CHANGE_NAME")
				.comma().column("PRODUCT_LEVEL")
				.comma().column("DIVISION")
				.comma().column("RENTAL_PRICE").enter()
				.from().subQuery(sideQuery2).enter()
				.where().columnName("RNUM").betweenAnd("?", "?")
				.build();

		String query = sideQuery1.getQuery().toString();
		ArrayList<Product> productList= null;

		try {
			pstmt = con.prepareStatement(query);

			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			productList= new ArrayList<Product>();

			while(rset.next()) {
				Product p = new Product();

				p.setEmpName(rset.getString("EMP_NAME"));
				p.setProductNo(rset.getString("PRODUCT_NO"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				p.setProductEnrolldate(rset.getDate("PRODUCT_ENROLLDATE"));
				p.setProductStatus(rset.getString("PRODUCT_STATUS"));
				p.setWarehouseName(rset.getString("WAREHOUSE_NAME"));
				p.setTemp(rset.getString("CHANGE_NAME"));
				p.setRentalPrice(rset.getString("RENTAL_PRICE"));
				productList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return productList;
	}
	public int searchingProductCount(Connection con, String categoryNo, String select, String value,
			String productStatus) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		SelectQueryMaker countQuery3 = new SelectQueryMaker
				.Builder()
				.select().column("PRODUCT_NO")
				.comma().column("MAX(PRO_HISTORY_DATE)").as("HDATE").enter()
				.from().columnName("PRODUCT_HISTORY").enter()
				.groupBy().columnName("PRODUCT_NO")
				.build();

		SelectQueryMaker countQuery2 = new SelectQueryMaker
				.Builder()
				.select().column("PH1.PRODUCT_NO")
				.comma().column("PH2.PRODUCT_STATUS").enter()
				.from().subQuery(countQuery3).as("PH1").enter()
				.join().columnName("PRODUCT_HISTORY").as("PH2").on().equalCondition("PH1.HDATE", "PH2.PRO_HISTORY_DATE")
				.build();

		SelectQueryMaker countQuery1_start = new SelectQueryMaker
				.Builder()
				.select().column("COUNT(E.EMP_NAME)").enter()
				.from().columnName("PRODUCT").as("P").enter()
				.join().columnName("EMPLOYEE").as("E").on().equalCondition("P.EMP_NO", "E.EMP_NO")
				.join().columnName("CATEGORY").as("C").on().equalCondition("P.CATEGORY_NO", "C.CATEGORY_NO").enter()
				.join().columnName("MANUFACTURER").as("MF").on().equalCondition("P.MANUFACTURER_NO", "MF.MANUFACTURER_NO").enter()
				.join().columnName("WAREHOUSE").as("W").on().equalCondition("W.WAREHOUSE_NO", "P.WAREHOUSE_NO")
				.join().columnName("BUY_INFO").as("BI").on().equalCondition("P.BUY_NO", "BI.BUY_NO").enter()
				.join().columnName("BUY_PRODUCT").as("BP").on().equalCondition("BI.BUY_PRODUCT_NO", "BP.BUY_PRODUCT_NO").enter()
				.join().columnName("PRODUCT_ATTACHMENT").as("PA").on().equalCondition("PA.PRODUCT_NO", "P.PRODUCT_NO").enter()
				.join().subQuery(countQuery2).as("S").on().equalCondition("S.PRODUCT_NO", "P.PRODUCT_NO").enter()
				.where().columnName("PA.DIVISION").equal().condition("상품등록사진").enter()
				.and().columnName("PA.PRODUCT_LEVEL").equal().condition(1).enter()
				.and().columnName("P.HOMEPAGE_UPDATE").equal().condition("Y").enter()
				.build();
		if(!categoryNo.equals("0")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.CATEGORY_NO").equal().condition(categoryNo).enter()
							.build()	
							)
					.build();
		}
		if(select.equals("all")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("(")
							.columnName("P.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("BP.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("P.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.columnName(")")
							.build()
							)
					.build();
		}else if(select.equals("productNo")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("productName")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("buyProductName")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("BP.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}
		if(productStatus!=null&&productStatus.equals("A")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("렌탈중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("B")){
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("보유중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("C")){
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("수리중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("D")){
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("인수됨").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("E")){
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("임시대여중").enter()
							.build()
							)
					.build();
		}


		SelectQueryMaker countQuery1_end = new SelectQueryMaker
				.Builder()
				.orderBy().columnName("P.PRODUCT_ENROLLDATE").desc()
				.build();
		SelectQueryMaker countQuery1 = new SelectQueryMaker
				.Builder()
				.add(countQuery1_start).add(countQuery1_end)
				.build();

		String query = countQuery1.getQuery().toString();
		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return result;
	}
	public ArrayList<Product> searchingInventory(Connection con, E_PageInfo pi, String categoryNo, String select,
			String value, String productStatus) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		SelectQueryMaker sideQuery5=
				new SelectQueryMaker
				.Builder()
				.select().column("PRODUCT_NO")
				.comma().column("MAX(PRO_HISTORY_DATE)").as("HDATE").enter()
				.from().columnName("PRODUCT_HISTORY").enter()
				.groupBy().columnName("PRODUCT_NO")
				.build();

		SelectQueryMaker sideQuery4 =
				new SelectQueryMaker
				.Builder()
				.select().column("PH1.PRODUCT_NO").comma().column("PH2.PRODUCT_STATUS").enter()
				.from().subQuery(sideQuery5).as("PH1").enter()
				.join().columnName("PRODUCT_HISTORY").as("PH2").on().equalCondition("PH1.HDATE", "PH2.PRO_HISTORY_DATE")
				.build();

		SelectQueryMaker sideQuery3_start =
				new SelectQueryMaker
				.Builder()
				.select().column("P.HOMEPAGE_UPDATE")
				.comma().column("E.EMP_NAME")
				.comma().column("P.PRODUCT_NO")
				.comma().column("P.PRODUCT_ENROLLDATE")
				.comma().column("P.PRODUCT_NAME")
				.comma().column("BP.BUY_PRODUCT_NAME")
				.comma().column("C.CATEGORY_NAME")
				.comma().column("W.WAREHOUSE_NAME")
				.comma().column("S.PRODUCT_STATUS")
				.enter()
				.from().columnName("PRODUCT").as("P")
				.join().columnName("EMPLOYEE").as("E").on().equalCondition("P.EMP_NO", "E.EMP_NO").enter()
				.join().columnName("CATEGORY").as("C").on().equalCondition("P.CATEGORY_NO", "C.CATEGORY_NO").enter()
				.join().columnName("MANUFACTURER").as("MF").on().equalCondition("P.MANUFACTURER_NO", "MF.MANUFACTURER_NO").enter()
				.join().columnName("WAREHOUSE").as("W").on().equalCondition("W.WAREHOUSE_NO", "P.WAREHOUSE_NO").enter()
				.join().columnName("BUY_INFO").as("BI").on().equalCondition("P.BUY_NO", "BI.BUY_NO").enter()
				.join().columnName("BUY_PRODUCT").as("BP").on().equalCondition("BI.BUY_PRODUCT_NO", "BP.BUY_PRODUCT_NO").enter()
				.join().subQuery(sideQuery4).as("S").on().equalCondition("S.PRODUCT_NO", "P.PRODUCT_NO").enter()
				.where().columnName("P.PRODUCT_NO").like().condition("%%").enter()
				.build();
		if(!categoryNo.equals("0")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.CATEGORY_NO").equal().condition(categoryNo).enter()
							.build()	
							)
					.build();
		}
		if(select.equals("all")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("(")
							.columnName("P.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("BP.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("P.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.columnName(")")
							.build()
							)
					.build();
		}else if(select.equals("productNo")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("productName")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("buyProductName")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("BP.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}
		if(productStatus!=null&&productStatus.equals("A")) {
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("렌탈중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("B")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("보유중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("C")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("수리중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("D")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("인수됨").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("E")){
			sideQuery3_start =
					new SelectQueryMaker
					.Builder()
					.add(sideQuery3_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("임시대여중").enter()
							.build()
							)
					.build();
		}
		
		SelectQueryMaker sideQuery3_end =
				new SelectQueryMaker
				.Builder()
				.orderBy().columnName("PRODUCT_ENROLLDATE").desc()
				.build();

		SelectQueryMaker sideQuery3 = new SelectQueryMaker
				.Builder()
				.add(sideQuery3_start).add(sideQuery3_end)
				.build();

		SelectQueryMaker sideQuery2 = 
				new SelectQueryMaker
				.Builder()
				.select().column("HOMEPAGE_UPDATE")
				.comma().column("ROWNUM").as("RNUM")
				.comma().column("EMP_NAME")
				.comma().column("PRODUCT_NO")
				.comma().column("PRODUCT_ENROLLDATE")
				.comma().column("PRODUCT_NAME")
				.comma().column("BUY_PRODUCT_NAME")
				.comma().column("CATEGORY_NAME")
				.comma().column("WAREHOUSE_NAME")
				.comma().column("PRODUCT_STATUS")
				.enter()
				.from().subQuery(sideQuery3).enter()
				.build();
		SelectQueryMaker sideQuery1 = 
				new SelectQueryMaker
				.Builder()
				.select().column("HOMEPAGE_UPDATE")
				.comma().column("RNUM")
				.comma().column("EMP_NAME")
				.comma().column("PRODUCT_NO")
				.comma().column("PRODUCT_ENROLLDATE")
				.comma().column("PRODUCT_NAME")
				.comma().column("BUY_PRODUCT_NAME")
				.comma().column("CATEGORY_NAME")
				.comma().column("WAREHOUSE_NAME")
				.comma().column("PRODUCT_STATUS")
				.enter()
				.from().subQuery(sideQuery2).enter()
				.where().columnName("RNUM").betweenAnd("?", "?")
				.build();
		String query = sideQuery1.getQuery().toString();

		ArrayList<Product> list= null;

		try {
			pstmt = con.prepareStatement(query);

			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			list= new ArrayList<Product>();

			while(rset.next()) {
				Product p = new Product();

				p.setEmpName(rset.getString("EMP_NAME"));
				p.setProductNo(rset.getString("PRODUCT_NO"));
				p.setBuyProductName(rset.getString("BUY_PRODUCT_NAME"));
				p.setProductEnrolldate(rset.getDate("PRODUCT_ENROLLDATE"));
				p.setProductStatus(rset.getString("PRODUCT_STATUS"));
				p.setWarehouseName(rset.getString("WAREHOUSE_NAME"));
				p.setHompageUpdate(rset.getString("HOMEPAGE_UPDATE"));



				list.add(p);
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
	public int searchingInventoryCount(Connection con, String categoryNo, String select, String value,
			String productStatus) {
		Statement stmt= null;
		ResultSet rset = null;
		
		SelectQueryMaker countQuery3=
				new SelectQueryMaker
				.Builder()
				.select().column("PRODUCT_NO")
				.comma().column("MAX(PRO_HISTORY_DATE)").as("HDATE").enter()
				.from().columnName("PRODUCT_HISTORY").enter()
				.groupBy().columnName("PRODUCT_NO")
				.build();

		SelectQueryMaker countQuery2 =
				new SelectQueryMaker
				.Builder()
				.select().column("PH1.PRODUCT_NO").comma().column("PH2.PRODUCT_STATUS").enter()
				.from().subQuery(countQuery3).as("PH1").enter()
				.join().columnName("PRODUCT_HISTORY").as("PH2").on().equalCondition("PH1.HDATE", "PH2.PRO_HISTORY_DATE")
				.build();

		SelectQueryMaker countQuery1_start =
				new SelectQueryMaker
				.Builder()
				.select().column("COUNT(P.HOMEPAGE_UPDATE)")
				.enter()
				.from().columnName("PRODUCT").as("P")
				.join().columnName("EMPLOYEE").as("E").on().equalCondition("P.EMP_NO", "E.EMP_NO").enter()
				.join().columnName("CATEGORY").as("C").on().equalCondition("P.CATEGORY_NO", "C.CATEGORY_NO").enter()
				.join().columnName("MANUFACTURER").as("MF").on().equalCondition("P.MANUFACTURER_NO", "MF.MANUFACTURER_NO").enter()
				.join().columnName("WAREHOUSE").as("W").on().equalCondition("W.WAREHOUSE_NO", "P.WAREHOUSE_NO").enter()
				.join().columnName("BUY_INFO").as("BI").on().equalCondition("P.BUY_NO", "BI.BUY_NO").enter()
				.join().columnName("BUY_PRODUCT").as("BP").on().equalCondition("BI.BUY_PRODUCT_NO", "BP.BUY_PRODUCT_NO").enter()
				.join().subQuery(countQuery2).as("S").on().equalCondition("S.PRODUCT_NO", "P.PRODUCT_NO").enter()
				.where().columnName("P.PRODUCT_NO").like().condition("%%").enter()
				.build();
		if(!categoryNo.equals("0")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.CATEGORY_NO").equal().condition(categoryNo).enter()
							.build()	
							)
					.build();
		}
		if(select.equals("all")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("(")
							.columnName("P.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("BP.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.or().columnName("P.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.columnName(")")
							.build()
							)
					.build();
		}else if(select.equals("productNo")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.PRODUCT_NO").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("productName")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("P.PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}else if(select.equals("buyProductName")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("BP.BUY_PRODUCT_NAME").like().condition("%"+value+"%").enter()
							.build()
							)
					.build();
		}
		if(productStatus!=null&&productStatus.equals("A")) {
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("렌탈중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("B")){
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("보유중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("C")){
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("수리중").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("D")){
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("인수됨").enter()
							.build()
							)
					.build();
		}else if(productStatus!=null&&productStatus.equals("E")){
			countQuery1_start =
					new SelectQueryMaker
					.Builder()
					.add(countQuery1_start).add(
							new SelectQueryMaker
							.Builder()
							.and().columnName("S.PRODUCT_STATUS").equal().condition("임시대여중").enter()
							.build()
							)
					.build();
		}
		
		SelectQueryMaker countQuery1_end =
				new SelectQueryMaker
				.Builder()
				.orderBy().columnName("PRODUCT_ENROLLDATE").desc()
				.build();

		SelectQueryMaker countQuery1 = new SelectQueryMaker
				.Builder()
				.add(countQuery1_start).add(countQuery1_end)
				.build();
		
		String query = countQuery1.getQuery().toString();
		int result = 0;

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		return result;
	}

	public int countRentalPresentCondition(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("countRentalPresentCondition");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		return result;
	}

	public ArrayList<Rental> rentalList(Connection con, E_PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArrayList<Rental> rentalList = null;
		
		String query = prop.getProperty("rentalPresentCondition");
		
		try {
			pstmt = con.prepareStatement(query);

			rentalList = new ArrayList<Rental>();

			int endRow = pi.getCurrentPage()*10;
			int startRow = endRow - 9;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while(rset.next()) {
				Rental r  = new Rental();

				r.setProductNo(rset.getString("PRODUCT_NO"));
				r.setProductName(rset.getString("PRODUCT_NAME"));
				r.setChangeName(rset.getString("CHANGE_NAME"));
				r.setRentalMonth(rset.getString("RENTAL_MONTH"));
				r.setPrice(rset.getString("PRICE"));
				r.setStartDate(rset.getDate("START_DATE"));
				r.setExpiryDate(rset.getDate("EXPIRY_DATE"));
				r.setRentalStatus(rset.getString("RENTAL_STATUS"));
				r.setOrderStatus(rset.getString("ORDER_STATUS"));
				r.setRecipient(rset.getString("RECIPIENT"));
				r.setPhone(rset.getString("PHONE"));
				r.setAddress(rset.getString("ADDRESS"));
				r.setOrderNo(rset.getString("ORDER_NO"));
				r.setOrderCode(rset.getString("ORDER_CODE"));
				r.setRentalNo(rset.getString("RENTAL_NO"));
				r.setRefundStatus(rset.getString("REFUND_STATUS"));
				r.setUserName(rset.getString("USER_NAME"));
				rentalList.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return rentalList;
	}

	public int checkBarcode(Connection con, String productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("checkBarcode");
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "바코드");
			pstmt.setString(2, productNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return result;
	}

	public int checkBarcodeList(Connection con, String string) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkBarcodeList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, string);
			pstmt.setString(2, "바코드");
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return result;
	}
}
