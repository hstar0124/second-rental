<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.forest.buy.model.vo.BuyInfo ,
				com.kh.forest.member.model.vo.PageInfo" %>
<%
	ArrayList<BuyInfo> list = (ArrayList<BuyInfo>) request.getAttribute("list");
	
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
	int listCountCurrent = pi.getListCount();
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
	.searchGrid {
		width:100%;
		margin:0px;
	}
	.resultTable {
		width:100%;
		 border-top: 1px solid #333333;
		 border-bottom: 1px solid #333333;
		 border-collapse:collapse;
	}
	
	.resultTableTh {
		background-color: #A7C0E9;
		border: 1px solid #333333;
		font-size: 16px;
	}
	.resultTableTd {
		text-align : center;
		border: 1px solid #333333;
		font-size: 16px;
	}
	
	.DDD {
		background:#ECECEC;
		height:35px;
		line-height: 35px;
		border: 2px solid #B8B8B8;
	}
	select{
		height : 30px;
	}
	.keyword{
		height : 25px;
	}
	.pagingArea{
		margin-top: 20px;
	}
	.pagingArea>button{
		border: none;
		background: white;
	}	
/* 	.total-text1, .total-count{
		align:left;
	}
	.total-text2, .payment-point{
		align:rigth;
	} */
</style>
</head>
<body onload="ready('매입 현황 관리', '매입관리', '매입 현황 관리');">
<%@ include file="../common/C_menubar.jsp"%>
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
					<input type="checkbox" name="buyCategory" id="firstRe" value="firstRe">
						<label for="firstRe">1차검수신청</label>
						
					<input type="checkbox" name="buyCategory" id="firstOk" value="firstOk">
						<label for="firstOk">1차검수완료</label>
						
					<input type="checkbox" name="buyCategory" id="waiting" value="waiting">
						<label for="waiting">인수대기중</label>
						
					<input type="checkbox" name="buyCategory" id="finish" value="finish">
						<label for="finish">인수완료</label>
						
					<input type="checkbox" name="buyCategory" id="firstReject" value="firstReject">
						<label for="firstReject">1차검수탈락</label>
						
					<input type="checkbox" name="buyCategory" id="buyReject" value="buyReject">
						<label for="buyReject">매입불가</label>
						
					<input type="checkbox" name="buyCategory" id="buyEnd" value="buyEnd">
						<label for="buyEnd">매입완료</label>
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
						<option value="">키워드</option>
						<option value="">아이디</option>
						<option value="">이름</option>
						<option value="">상품명</option>
						<option value="">매입번호</option>
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
				<label class="total-text1">검색결과 : </label>
				<label class="total-count"><%=listCountCurrent%> 건</label><br>
			</div>
		
		</article>


<article>

	<table class="resultTable">
		<thead>
			<tr>
				<th class="resultTableTh"><label>매입번호</label></th>
				<th class="resultTableTh"><label>아이디</label></th>
				<th class="resultTableTh"><label>상품명</label></th>
				<th class="resultTableTh"><label>세이프키</label></th>
				<th class="resultTableTh"><label>접수일</label></th>
				<th class="resultTableTh"><label>포인트</label></th>
				<th class="resultTableTh"><label>상태</label></th>
				
			</tr>
		</thead>
		<tbody>
			<% for(BuyInfo bi : list) { %>
			<tr>
				<td class="resultTableTd"><%=bi.getBuyNo() %></td>
				<td class="resultTableTd"><%=bi.getUserId() %></td>
				<td class="resultTableTd"><%=bi.getBuyProductName() %></td>
				<td class="resultTableTd"><%=bi.getSafeKey() %></td>
				<td class="resultTableTd"><%=bi.getRequestDate() %></td>
				<%if(bi.getChangePoint() == 0) { %>
					<td class="resultTableTd">-</td>
				<% } else { %>
					<td class="resultTableTd"><%=bi.getChangePoint() %></td>
				<% } %>
				<td class="resultTableTd"><%=bi.getBuyStatus() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	

	<!-- 페이징페이징 -->
		<div class="pagingArea" align="center">

			<button	onclick="location.href='<%=request.getContextPath()%>/selectCurrentList.ad?currentPage=1'"><<</button>

			<%
				if (currentPage <= 1) {
			%>
			<button disabled><</button>

			<%
				} else {
			%>
			<button	onclick="location.href='<%=request.getContextPath()%>/selectCurrentList.ad?currentPage=<%=currentPage - 1%>'"><</button>

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
			<button	onclick="location.href='<%=request.getContextPath()%>/selectCurrentList.ad?currentPage=<%=p%>'"><%=p%></button>
			<%
				}

				}
			%>

			<%
				if (currentPage >= maxPage) {
			%>
			<button disabled>></button>
			<%
				} else {
			%>
			<button	onclick="location.href='<%=request.getContextPath()%>/selectCurrentList.ad?currentPage=<%=currentPage + 1%>'">></button>
			<%
				}
			%>

			<button	onclick="location.href='<%=request.getContextPath()%>/selectCurrentList.ad?currentPage=<%=maxPage%>'">>></button>
		</div>
		<!-- --------------------- -->
		
	<br><br>	


	
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
		</script>
<%@ include file="../common/C_menubar2.jsp"%>
</body>
</html>