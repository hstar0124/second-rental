<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.order.model.vo.*, com.kh.forest.member.model.vo.*"%>
<%
	ArrayList<OrderStatus> list = (ArrayList<OrderStatus>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int listCount = pi.getListCount();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>

.searchGrid {
	width:100%;
	margin:0px;
}
.resultTable {
	width:100%;
	 border: 1px solid #333333;
	 border-collapse:collapse;
	 display: inline-table;
	
}

.resultTableTh {
	background-color: #A7C0E9;
	border:1px solid black;
}
.resultTableTd {
	text-align : center;
	border:1px solid black;
}
.resultTableTd button {
	cursor:pointer;
}
.DDD {
	background:#ECECEC;
	height:35px;
	line-height: 35px;
	border: 2px solid #B8B8B8;
}
.DDD button {
	border: none;
    background: #828282;
    color: white;
    width: 90px;
    height: 25px;
}
.searchBtn{
	width:100px;
	height:30px;
	background: #6792DA;
	border:none;
	color:white;
	font-size:15px;
	border-radius: 5px 5px 5px 5px;
}
#orderInfo {
	background:none;
	border:0;
	ourline:0;
}
.pagingArea button{
	border:none;
	color:#6E00AB;
	font-weight:600;
	background:white;
	margin-bottom:20px;
	font-size:14px;
}
button {
	cursor:pointer;
}
</style>
</head>
<body onload="ready('주문취소관리', '주문관리', '주문취소관리');">

	<%@ include file="../common/C_menubar.jsp" %>
		<article>
			<form>
		<table class="searchGrid">
			<colgroup>
				<col width="20%" style="background: rgba(218, 218, 218, 0.459); padding-left:3px;">
				<col style="background: rgba(212, 212, 212, 0.253)">
			</colgroup>
			<tr>
				<td>분류</td>
				<td>
					<input type="checkbox" name="orderCategory" id="cancelOr" value="cancelOr">
						<label for="cancelOr">취소</label>
						
					<input type="checkbox" name="orderCategory" id="refundOr" value="refundOr">
						<label for="refundOr">환불</label>
						
					<input type="checkbox" name="orderCategory" id="changeOr" value="changeOr">
						<label for="changeOr">교환</label>
				</td>
			</tr>
			<tr>
				<td>날짜 검색</td>
				<td>
					<input type="text" id="datepicker">~<input type="text" id="datepicker1">
					<button onclick="">오늘</button>
					<button onclick="">이번주</button>
					<button onclick="">이번달</button>
					<button onclick="">전체</button>
				</td>
			</tr>
			<tr>
				<td>검색 키워드</td>
				<td>
					<select>
						<option value=""></option>
						<option value="">아이디</option>
						<option value="">이름</option>
						<option value="">상품번호</option>
						<option value="">주문번호</option>
						<option value="">여기는 뭐 넣음</option>
					</select>
					<input type="text" id="keyword" name="keyword" class="keyword">
				</td>
			</tr>
		</table>
		<br><br>
		<div align="center"><button class="searchBtn">검색</button></div>
		</form>
		<br><br>
		<div class="DDD">
		&nbsp;&nbsp;
			<label>검색결과 : </label><label class="searchCount"><%= listCount %> 건</label>
			<%-- <label>총 현황 : </label><label class="searchCount"><%= listCount %> 건</label> --%>
		</div>
		</article>
		
		
	<article>
		<table class="resultTable">
		<colgroup>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col width="25%">
		</colgroup>
			<tr>
				<th class="resultTableTh"><input type="checkbox"></th>
				<th class="resultTableTh"><label>번호</label></th>
				<th class="resultTableTh"><label>아이디</label></th>
				<!-- <th class="resultTableTh"><label>이름</label></th> -->
				<th class="resultTableTh"><label>주문일자</label></th>
				<th class="resultTableTh"><label>상품번호</label></th>
				<th class="resultTableTh"><label>주문번호</label></th>
				<th class="resultTableTh"><label>제품명</label></th>
				<th class="resultTableTh"><label>가격</label></th>
				<th class="resultTableTh"><label>현황</label></th>
				<th class="resultTableTh"><label>상세</label></th>
			</tr>
			
			<% 
			int no =  listCount - ((pi.getCurrentPage() - 1) * pi.getLimit() + 1) + 1;
			for(OrderStatus os : list) { %>
				<tr>
					<td class="resultTableTd"><input type="checkbox"></td>
					<td class="resultTableTd"><%= no %></td>
					<td class="resultTableTd"><%= os.getUserId() %></td>
					<%-- <td class="resultTableTd"><%= os.getUserName() %></td> --%>
					<td class="resultTableTd"><%= os.getOrderDate() %></td>
					<td class="resultTableTd"><%= os.getProductNo() %></td>
					<td class="resultTableTd"><%= os.getOrderNo() %></td>
					<td class="resultTableTd"><%= os.getProductName() %></td>
					<td class="resultTableTd"><%= os.getPrice() %></td>
					<td class="resultTableTd"><%= os.getStatus() %></td>
					<td class="resultTableTd"><button id="orderInfo" onclick="detail('<%=os.getOrderNo()%>', '<%= os.getProductNo()%>');">
						<img style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" ></button>
				</tr>
			<% 
				no--;
			} %>
		</table>
		<br><br>
		
		
		
		<!-- 페이징페이징 -->
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/select.pur?currentPage=1'"><<</button>
				<% if(currentPage <= 1) { %>
				<button disabled><</button>
				<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/select.pur?currentPage=<%= currentPage - 1 %>'"><</button>
				<% } %>
		
				<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){
				%>
						<button disabled><%=p %></button>
			
					<% }else {%>
						<button onclick="location.href='<%=request.getContextPath()%>/select.pur?currentPage=<%=p%>'"><%=p %></button>
				<% 		}
				}%>
		
				<% if(currentPage >= maxPage){ %>
				<button disabled>></button>
				<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/select.pur?currentPage=<%= currentPage + 1 %>'">></button>
				<% } %>
			<button onclick="location.href='<%= request.getContextPath() %>/select.pur?currentPage=<%=maxPage %>'">>></button>
		</div>
		<!-- --------------------- -->
		
		
		
		<br>
		<hr>
		<!-- <label>분류 일괄 처리</label>
		<div class="DDD">&nbsp;&nbsp;
			<button>입금완료</button>
			<button>배송준비</button>
			<button>배송중</button>
			<button>배송완료</button>
			<button>결제취소</button>
		</div> -->
	</article>
	
		
	<script>
	/* 날짜 input jquery ui */
		$.datepicker.setDefaults({
			showOn : "both",
			buttonImage : "/forest/image/calendar.png",
			buttonImageOnly : true,
			dateFormat : 'yy-mm-dd'

		});
		$(function() {
			$("#datepicker").datepicker({});
			$("#datepicker1").datepicker({});
			/* 달력버튼 */
			$("img.ui-datepicker-trigger")
					.attr("style","margin-left:2px; vertical-align:middle; cursor: Pointer; width:30px; height:30px");

		});
	 
		
		function detail(orderNo, productNo){
			var halfWith = (document.body.offsetWidth / 2);
			var halfHeight = (document.body.offsetHeight / 2);
			var popupX = halfWith - (1000 / 2);
			//&nbsp;만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

			var popupY= halfHeight - (700 / 2);
			//&nbsp;만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
			
			window.open("<%=request.getContextPath()%>/cancelDetail?orderNo=" + orderNo + "&productNo=" + productNo, "tms","width=1000,height=700,top=100px,left="+popupX);
		}
	
	
	</script>
	<%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>