<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, com.kh.forest.point.model.vo.Point, com.kh.forest.point.model.vo.PointSum, com.kh.forest.member.model.vo.PageInfo"%>
<%
	List<Point> list = (List)request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	PointSum pointSum = (PointSum) request.getAttribute("pointSum");
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
<title>중고구마</title>
<style>
.text1 {
	margin-left: 10px;
}

#pointTable {
	width: 90%;
	margin: 0 auto;
	text-align: center;
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
	font-size:18px;
}

.trb>td {
	border-bottom: 1px solid #ECECEC;
	margin: 0px;
	padding: 0px;
	height: 30px;
	font-weight: 400;
	font-size:14px;
}

#refunds {
	width: 170px;
	height: 40px;
	background: #4FD1D9;
	border: none;
	outline: none;
	color: white;
	font-size: 18px;
	margin-right:15px;
}
#nullArea{
	background: #ECECEC;
	width:100%;
	height:150px;
	border-radius: 5px 5px 5px 5px;
	align:center;
}
#nullLb{
	color:white;
	font-size:18px;
	font-weight:800;
	margin-top: 50px;
	height:100px;
	line-height:100px;
}
button{
	border:none;
	color:#6E00AB;
	font-weight:600;
	background:white;
	font-size:14px;
	cursor: pointer;
}
#pointSumTable{
	width: 70%;
	text-align: center;
	margin-bottom: 50px;
	margin:0 auto;
	border-collapse: 1px;
	border:2px solid #B8B8B8;
}
#sumRange{
	width: 90%;
	margin: 0 auto;
	margin-top: 30px;
	margin-bottom: 50px;
	border-collapse: collapse;
	font-weight:600;
}
</style>
</head>
<body>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
	<h1 class="text1">포인트 내역</h1>
	<div
		style="background-color:#6E00AB; width: 100%; height: 4px; margin-top: 0px;"></div>
		<div id="sumRange">
		<table	id="pointSumTable" style="margin-top:20px;">
			<tr style="width:200px;">
				<td rowspan="6" style="width:200px; background: #ECECEC; height:180px;">포인트 정보</td>
				<td>현재 보유중인 포인트</td>
				<td style="color:red;"><%=loginMember.getPoint() %> P</td>
			</tr>
			<tr>
				<td >총 사용 포인트</td>
				<td style="color:red;"><%=pointSum.getUseSum() %> P</td>
			</tr>
			<tr>
				<td >총 매입 지급 포인트</td>
				<td style="color:red;"><%=pointSum.getBuyPoint() %> P</td>
			</tr>
			
			<tr>
				<td>총 완료된 환급 포인트</td>
				<td style="color:red;"><%=pointSum.getCashBackPoint() %> p</td>
			</tr>
			<tr>
				<td>총 환불 포인트</td>
				<td style="color:red;"><%=pointSum.getRefundPount() %> P</td>
			</tr>
		</table>
		</div>	
		
		
	<table id="pointTable">
		<tr id="tr1" class="trb">
			<th>처리번호</th>
			<th>포인트</th>
			<th>처리일자</th>
			<th>상태</th>
		</tr>
	<% if(pi.getListCount() != 0) { %>
		<% for(Point p : list) { %>
		<tr class="trb">
			<td><%= p.getPointNo() %></td>
			<td><%= p.getPoint() %></td>
			<td><%= p.getPointDate() %></td>
			<td><%= p.getStatus() %></td>
		</tr>
		<% } %>
		
<% } else { %>
<tr>
	<td colspan="5" id="#nullArea"><div id="nullArea"><label id="nullLb">정보가 없습니다</label></div></td>
	</tr>
<% } %>		
		<tr height="40px"></tr>
		<tr>
			<td colspan="5">
				<% if(pi.getListCount() != 0){ %>
				<div class="pagingArea" align="center" style="margin-right:20px;">
					<button
						onclick="location.href='<%= request.getContextPath()%>/pointSelectOne.po?currentPage=1'"><<</button>
					<% if(currentPage <= 1){ %>
					<button disabled><</button>
					<%} else { %>
					<button
						onclick="location.href='<%= request.getContextPath()%>/pointSelectOne.po?currentPage=<%= currentPage -1%>'"><</button>
					<% } %>

					<% for(int p =startPage ; p <= endPage; p ++ ) {  
    	  
    	  if(p == currentPage){
    	%>
					<button disabled><%= p %></button>
					<% } else { %>
					<button
						onclick="location.href ='<%= request.getContextPath()%>/pointSelectOne.po?currentPage=<%= p%>'"><%= p %></button>
					<% } %>

					<% } %>

					<% if(currentPage >= maxPage) { %>
					<button disabled>></button>
					<% } else { %>
					<button
						onclick="location.href='<%= request.getContextPath()%>/pointSelectOne.po?currentPage=<%= currentPage +1 %>'">></button>
					<% } %>

					<button
						onclick="location.href='<%= request.getContextPath()%>/pointSelectOne.po?currentPage=<%= maxPage%>'">>></button>
				</div>
<% }%>

			</td>
		</tr>
		<tr height="100px;"></tr>
		<tr>
			<td colspan="5"><input type="button" id="refunds" style="cursor: pointer;"
				value="포인트 환급 받기"
				onclick="location.href='<%= request.getContextPath()%>/views/user/mypage/F_MyPageSection_pointRefunds.jsp'"></td>
		</tr>
		<tr height="100px"></tr>
		<tr>
			<td colspan="5"><img src="/forest/image/userimg/refunds.PNG"
				width="100%"></td>
		</tr>
	</table>



	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp"%>
</body>
</html>