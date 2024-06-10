<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.order.model.vo.*"%>
<%
	ArrayList<Purchase> list = (ArrayList<Purchase>) request.getSession().getAttribute("orderCompleteList");
	System.out.println(list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	.comBox {
		border:2px solid gray;
		margin-top:50px;
		padding:20px;
		padding-left:50px;
		width:70%;
		margin:0 auto;
	}
	.aP {
		font-size:25px;
		font-weight:bold;
	}
	 
	.orderTable {
		width:80%;
		margin:0 auto;
		margin-top:70px;
		margin-bottom:70px;
		border-collapse: collapse;
	}
	.orderTable tr td{
		padding:10px;
		border-top:2px solid lightgray;
		border-bottom:2px solid lightgray;
	}
	.orderTable tr th{
		padding:10px;
		border-top:2px solid lightgray;
	}
	
	.btn {
		height:40px;
		width:150px;
		color:#6E00AB;
		background:white;
		border:2px solid #6E00AB;
	}
	
	.btn1{
		height:40px;
		width:150px;
		background:#6E00AB;
		color:white;
		border:2px solid white;
	}
</style>
</head>
<body>
	<%@ include file="/views/user/common/B_UserMainHeader.jsp"%>
	<div style="height:50px;"></div>
	<div class="comBox">
		<p class="aP">고객님의 주문이 완료되었습니다.</p>
		
		<p>
		주문내역 및 배송에 관한 안내는 <a href="<%=request.getContextPath()%>/selectOrderList.or">마이페이지>주문현황</a>을 통하여 확인 가능합니다.<br><br>
		주문번호 : <span style="color:red;"><%= list.get(0).getOrderNo() %></span><br>
		주문일자 : <span><%= list.get(0).getOrderDate() %></span>
		</p>
	</div>
	
	
	<div>
		<table class="orderTable">
			<caption style="text-align:left; font-weight:bold; font-size:25px;">주문 상품 정보<br></caption>
			<tr height="10px"></tr>
			<tr style="height:50px;">
				<th>이미지</th>
				<th>상품정보</th>
				<th>대여가격</th>
				<th>배송구분</th>
			</tr>
			<% for(Purchase p : list){ 
				String dp = "";
				if(p.getDeliveryPrice() == 0){
					dp = "무료배송";
				}else{
					dp = p.getDeliveryPrice()+ "";
				}
			%>
			<tr>
			<tr align="center" style="height:130px;">
				<td><img height="150px" width="150px" src="<%=request.getContextPath()%>/image/productImg/<%=p.getAttachment()%>"></td>
				<td><%= p.getProductName() %><br> 대여기간 :<%= p.getRentalMonth() %>개월</td>
				<td><%= p.getPrice() %>원</td>
				<td><%= dp %></td>
			</tr>
			<% } %>
			<tr align="right" style="height:50px;">
				<td colspan="5">상품구매금액 + 배송비  = 합계 : <%= list.get(0).getPayPrice() %>원</td>
			</tr>
			<tr align="right" style="height:90px;">
				<td colspan="5" style="border-bottom:none;">
				<button class="btn" onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or'">쇼핑 계속하기</button>&nbsp;&nbsp;
				<button class="btn1" onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or'">주문 확인하기</button>
				</td>
			</tr>
		</table>
	</div>
	
	
	<%@ include file="/views/user/common/B_UserMainFooter.jsp"%>
</body>
</html>