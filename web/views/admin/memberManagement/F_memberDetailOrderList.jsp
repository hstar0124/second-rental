<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, com.kh.forest.point.model.vo.Point,com.kh.forest.order.model.vo.OrderStatus, com.kh.forest.member.model.vo.Member, com.kh.forest.member.model.vo.PageInfo"%>
<%
	List<OrderStatus> list = (List) request.getAttribute("list");
	int orderComplete = (int) request.getAttribute("orderComplete");
	int orderCancle = (int) request.getAttribute("orderCancle");
	int shipping = (int) request.getAttribute("shipping");
	Member member = (Member) request.getAttribute("member");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
body {
	margin: 0;
	padding: 0;
}

#mainRange {
	width: 100%;
	height: 100%;
	margin: 0 auto;
	margin: 0;
	padding: 0;
}

#infoTable {
	width: 100%;
	margin-top: 20px;
	margin-bottom: 30px;
}
.DDD {
   background:#ECECEC;
   height:40px;
   line-height: 35px;
   border: 2px solid #B8B8B8;
}
.menu {
	width: 110px;
	height: 38px;
	border: 2px solid #828282;
	border-bottom: none;
	border-right: none;
	display: inline-flex;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	margin: 0;
	padding: 0;
	font-weight: 600;
	cursor: pointer;
}

#infoBar {
	width: 100%;
	background: #16AAD8;
	height: 50px;
	margin: 0;
	padding: 0;
}

.community {
	border-right: 2px solid #828282;
	cursor: pointer;
}

.memberInfo {
	margin-left: 150px;
	cursor: pointer;
}

#lb1 {
	margin: 0 auto;
	margin-top: 6px;
}

#bar1 {
	width: 100%;
	height: 2px;
	background: #828282;
}

#name {
	font-size: 20px;
	font-weight: 600;
	margin-left: 20px;
}

.basic {
	font-size: 18px;
	margin-left: 50px;
	font-weight: 600;
}

#info1 {
	width: 700px;
	margin: 0 auto;
	margin-top: 20px;
}

.td1 {
	width: 200px;
	background: #CACACA;
	height: 30px;
}

.td2 {
	width: 300px;
	border: 1px solid #CACACA;
}

.lb3 {
	font-size: 20px;
	font-weight: 600;
}

.lb4 {
	margin-left: 153px;
	margin-bottom: 30px;
}

#pointTable {
	width: 90%;
	margin: 0 auto;
	text-align: center;
	margin-top: 10px;
	margin-bottom: 50px;
	border-collapse: collapse;
}
#pointSumTable{
	width: 70%;
	text-align: center;
	margin-bottom: 50px;
	margin:0 auto;
	border-collapse: 1px;
	border:1px solid black;
}
#sumRange{
	width: 90%;
	margin: 0 auto;
	margin-top: 30px;
	margin-bottom: 50px;
	border-collapse: collapse;
}

#tr1 {
	background: #ECECEC;
	height: 40px;
}

#tr1>th {
	margin: 0px;
	padding: 0px;
	border-bottom: 1px solid black;
	border-collapse: collapse;
}

.trb>td {
	border-bottom: 1px solid #B8B8B8;
	margin: 0px;
	padding: 0px;
	height: 30px;
	font-weight: 400;
}
#orderBtn{
background: #ECECEC;
cursor: pointer;
}
button{
	border:none;
	color:#6E00AB;
	font-weight:600;
	background:white;
	cursor: pointer;
}
</style>
<body>
	<div id="mainRange">
		<div id="infoBar"></div>
		<table id="infoTable">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td><label id="name"><%=member.getUserName() %>(<%=member.getUserId()%>) 님의 상세 정보</label>
					<div class="menu memberInfo" id="memberInfoBtn">
						<label id="lb1">회원정보</label>
					</div>
					<div class="menu" id="orderBtn">
						<label id="lb1">주문정보</label>
					</div>
					<div class="menu" id="pointBtn">
						<label id="lb1">포인트</label>
					</div>
					<div class="menu community" id="communityBtn">
						<label id="lb1">매입정보</label>
					</div></td>
			</tr>
			<tr style="margin: 0;">
				<td><div id="bar1"></div></td>
			</tr>
		</table>
	<div id="sumRange">
		<label class="lb3" style="margin-left:0px;">주문 종합 현황</label>
		
	<div class="DDD" style="margin-top:10px;">
      &nbsp;&nbsp;
      <%if(listCount != 0)  {%>
         <label>총 주문이력 : <%=listCount %> 건</label> / <label>총 주문취소 : <%=orderCancle %> 건</label> / <label>총 배송중 : <%=shipping %></label> / <label>총 배송완료 : <%=orderComplete %> 건</label>
         <% } else { %>
         <label>총 주문이력 : -</label>
         <% } %>
      </div>
		</div>	
		<label class="lb3" style="margin-left:50px;">주문 기록</label>
		<table id="pointTable">
			<tr id="tr1" class="trb">
				<th>주문번호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>일자</th>
				<th>상태</th>
			</tr>
			<%
				if (pi.getListCount() != 0) {
			%>
			<%
				for (OrderStatus o : list) {
			%>
			<tr class="trb">
				<td><%=o.getOrderNo()%></td>
				<td><%=o.getProductName()%></td>
				<td><%=o.getPrice()%></td>
				<td><%=o.getOrderDate()%></td>
				<td><%=o.getStatus()%></td>
			</tr>
			<%
				}
			%>

			<%
				} else {
			%>
			<tr>
				<td colspan="5" id="#nullArea"><div id="nullArea">
						<label id="nullLb">정보가 없습니다</label>
					</div></td>
			</tr>
			<%
				}
			%>
			<tr height="40px"></tr>
			<tr>
				<td colspan="5">
					<%
						if (pi.getListCount() != 0) {
					%>
					<div class="pagingArea" align="center" style="margin-right: 20px;">
						<button
							onclick="location.href='<%=request.getContextPath()%>/orderList.me?currentPage=1&num=<%= member.getUserNo()%>&userId=<%= member.getUserId()%>&userName=<%= member.getUserName()%>&userPoint=<%= member.getPoint()%>'"><<</button>
						<%
							if (currentPage <= 1) {
						%>
						<button disabled><</button>
						<%
							} else {
						%>
						<button
							onclick="location.href='<%=request.getContextPath()%>/orderList.me?currentPage=<%=currentPage - 1%>&num=<%= member.getUserNo()%>&userId=<%= member.getUserId()%>&userName=<%= member.getUserName()%>&userPoint=<%= member.getPoint()%>'"><</button>
						<%
							}
						%>

						<%
							for (int p = startPage; p <= endPage; p++) {

									if (p == currentPage) {
						%>
						<button disabled><%=p%></button>
						<%
							} else {
						%>
						<button
							onclick="location.href ='<%=request.getContextPath()%>/orderList.me?currentPage=<%=p%>&num=<%= member.getUserNo()%>&userId=<%= member.getUserId()%>&userName=<%= member.getUserName()%>&userPoint=<%= member.getPoint()%>'"><%=p%></button>
						<%
							}
						%>

						<%
							}
						%>

						<%
							if (currentPage >= maxPage) {
						%>
						<button disabled>></button>
						<%
							} else {
						%>
						<button
							onclick="location.href='<%=request.getContextPath()%>/orderList.me?currentPage=<%=currentPage + 1%>&num=<%= member.getUserNo()%>&userId=<%= member.getUserId()%>&userName=<%= member.getUserName()%>&userPoint=<%= member.getPoint()%>'">></button>
						<%
							}
						%>

						<button
							onclick="location.href='<%= request.getContextPath()%>/orderList.me?currentPage=<%= maxPage%>&num=<%= member.getUserNo()%>&userId=<%= member.getUserId()%>&userName=<%= member.getUserName()%>&userPoint=<%= member.getPoint()%>'">>></button>
					</div> <% }%>
				
		</table>
	</div>

	<script>
	$(function(){
		$("#closeBtn").click(function(){
			window.close();
		});
		
		$("#pointBtn").click(function(){
			location.href='<%= request.getContextPath()%>/pointAll.po?num=<%= member.getUserNo()%>&userId=<%= member.getUserId()%>&userName=<%= member.getUserName()%>&userPoint=<%= member.getPoint()%>';
		});
		
		$("#memberInfoBtn").click(function(){
			location.href='<%= request.getContextPath()%>/selectOne.me?num=<%= member.getUserNo()%>';
		});
		$("#communityBtn").click(function(){
			location.href='<%= request.getContextPath()%>/memberBuySelectAll.me?num=<%= member.getUserNo()%>&userId=<%= member.getUserId()%>&userName=<%= member.getUserName()%>&userPoint=<%= member.getPoint()%>';
		});
	});
</script>
	

</body>
</html>