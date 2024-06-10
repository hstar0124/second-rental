<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.order.model.vo.*, com.kh.forest.member.model.vo.*"%>
<%
	ArrayList<Refund> list = (ArrayList<Refund>) request.getAttribute("list");
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
	width: 100%;
	margin: 0px;
}

.resultTable {
	width: 100%;
	border: 1px solid #333333;
	border-collapse: collapse;
	display: inline-table;
}

.resultTableTh {
	background-color: #A7C0E9;
	border: 1px solid black;
}

.resultTableTd {
	text-align: center;
	border: 1px solid black;
}

.resultTableTd button {
	cursor: pointer;
}

.DDD {
	background: #ECECEC;
	height: 35px;
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

.searchBtn {
	width: 100px;
	height: 30px;
	background: #6792DA;
	border: none;
	color: white;
	font-size: 15px;
	border-radius: 5px 5px 5px 5px;
}

#orderInfo {
	background: none;
	border: 0;
	ourline: 0;
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
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

.modal2 {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	/* padding: 20px; */
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}

.modal-content2 {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	/* padding: 20px; */
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}
/* The Close Button */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
	margin-right: 20px;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

.modalTop {
	margin: 0;
	width: 100%;
	height: 50px;
	background: #16AAD8;
}

.infoTb {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
	border: 1px solid gray;
}

.infoTb tr td {
	border: 1px solid gray;
}

.staTb {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
	border: 1px solid black;
}

.staTb tr:first-of-type {
	background: #A7C0E9;
}

.staTb tr td {
	border: 1px solid black;
}

.modalBtn {
	margin: 30px auto;
	text-align: center;
}

.cancel {
	width: 125px;
	height: 40px;
	background: #6792DA;
	border: 1px solid #6792DA;
	color: white;
}

.mdTt {
	margin: 30px;
	font-size: 25px;
}

.modalTt {
	font-size: 30px;
	border-bottom: 1px solid black;
	width: 95%;
	margin: 0 auto;
	margin-top: 10px;
	font-weight: bold;
}

.modalTt span {
	color: #FF8329;
}

.returnReason {
	width: 80%;
	margin: 0 auto;
}

.con {
	background: #6792DA;
	border-radius: 3px;
	border: none;
	height: 30px;
	color: white;
	width: 100px;
	margin-top: 10px;
}
</style>
</head>
<body onload="ready('환불관리', '주문관리', '환불관리');">

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
						<label for="cancelOr">환불요청</label>
						
					<input type="checkbox" name="orderCategory" id="refundOr" value="refundOr">
						<label for="refundOr">승인</label>
						
					<input type="checkbox" name="orderCategory" id="changeOr" value="changeOr">
						<label for="changeOr">반려</label>
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
				<th class="resultTableTh"><label>주문번호</label></th>
				<th class="resultTableTh"><label>상품번호</label></th>
				<th class="resultTableTh"><label>제품명</label></th>
				<th class="resultTableTh"><label>가격</label></th>
				<th class="resultTableTh"><label>현황</label></th>
				<th class="resultTableTh"><label>상세</label></th>
			</tr>
			<% 
			int no =  listCount - ((pi.getCurrentPage() - 1) * pi.getLimit() + 1) + 1;
			for(Refund r : list) { 
			%>
				<tr>
					<td class="resultTableTd"><input type="checkbox" id="checkk" class="checkk" value="<%= r.getRefundNo() %>"></td>
					<td class="resultTableTd"><%= no %></td>
					<td class="resultTableTd"><%= r.getUserId() %></td>
					<%-- <td class="resultTableTd"><%= r.getUserName() %></td> --%>
					<td class="resultTableTd"><%= r.getOrderDate() %></td>
					<td class="resultTableTd"><%= r.getOrderNo() %></td>
					<td class="resultTableTd"><%= r.getProductNo() %></td>
					<td class="resultTableTd"><%= r.getProductName() %></td>
					<td class="resultTableTd"><%= r.getPrice() %></td>
					<td class="resultTableTd"><%= r.getStatus() %></td>
					<td class="resultTableTd"><button id="orderInfo" onclick="detail('<%= r.getOrderNo() %>', '<%=r.getProductNo()%>', '<%= r.getRefundNo()%>')">
					<img style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" ></button></td>
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
		<label>분류 일괄 처리</label>
		<div class="DDD">&nbsp;&nbsp;
			<button value="0" onclick="confirm(this.value);">승인</button>
			<button value="1" onclick="returnRe(this.value);" >반려</button>
		</div>
	</article>
	
	
	
	<!-- 
		The Modal
    <div id="myModal" class="modal">
 
      Modal content
      <div class="modal-content">
        <span class="close">&times;</span>                                                               
        <div class="modalTop"></div>
        <div class="modalTt"><span>주문번호번호번호 </span>상세정보</div>
        <div class="mdTt"><b>상품정보</b></div>
        <table class="infoTb">
        	<colgroup>
        		<col style="background:lightgray">
        		<col>
        		<col style="background:lightgray">
        		<col>
        	</colgroup>
        	<tr>
        		<td>제품명</td>
        		<td>ㅁㄴㅇㄹ</td>
        		<td>상품번호</td>
        		<td>ㅁㄴㅇㄻㄴㄹ</td>
        	</tr>
        	<tr>
        		<td>구매자명</td>
        		<td>ㅁㄴㅇㄹㄴㅁ</td>
        		<td>가격</td>
        		<td>ㄴㅇㄻㄴㅇㄻ</td>
        	</tr>
        	<tr>
        		<td>주문번호</td>
        		<td>ㅁㄴㅇㄻㄴ</td>
        		<td>운송번호</td>
        		<td>ㅁㄴㅇㄻㄴ</td>
        	</tr>
        </table>
        <br><br>
        <div class="mdTt"><b>처리현황</b></div>
        <table class="staTb">
        	<tr>
        		<th>번호</th>
        		<th>처리현황</th>
        		<th>처리시각</th>
        	</tr>
        </table>
        <div class="modalBtn">
        	<span><button class="cancel">확인</button></span>
        </div>
      </div>
      </div> -->
	
		<!-- The Modal2 -->
    <div id="myModal2" class="modal2">
 
      <!-- Modal content -->
      <div class="modal-content2">
        <span class="close">&times;</span>                                                               
        <div class="modalTop"></div>
        <div class="mdTt"><b>반려 사유</b></div>
        <form action="<%=request.getContextPath()%>/insertRefund.or" method="post">
        <input type="hidden" id="num" name="num">
        <input type="hidden" id="refundNo" name="refundNo">
        <div class="returnReason"><textarea rows="20" cols="80" name="reason" style="width:100%;"></textarea></div>
        <div class="modalBtn">
        	<span><button class="con">확인</button></span>
        </div>
        </form>
      </div>
	
	<script>
		var array = new Array();
		function confirm(value){
			var index = 0;
			$(".checkk").filter(":checked").filter(function(){
				array[index] = $(this).val();
				index++;
			});
			var num = value;
			console.log(num);
			console.log(array);
			location.href="<%=request.getContextPath()%>/insertRefund.or?refundNo=" + array + "&num="+num;
			
		}	
	
	
		
	
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
	
		
		function detail(orderNo, productNo, refundNo){
			var halfWith = (document.body.offsetWidth / 2);
			var halfHeight = (document.body.offsetHeight / 2);
			var popupX = halfWith - (1000 / 2);
			//&nbsp;만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

			var popupY= halfHeight - (900 / 2);
			//&nbsp;만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
			
			window.open("<%=request.getContextPath()%>/detail.re?orderNo=" + orderNo + "&productNo=" + productNo, "tms","width=1000,height=900,top=100px,left="+popupX);
		}
		    
		    
		var modal2 = document.getElementById('myModal2');
		var btn2 = document.getElementById('cancel2');
		
		// Get the <span> element that closes the modal
		var span2 = document.getElementsByClassName("close")[0];
		function returnRe(value){
			modal2.style.display = "block";
			var index = 0;
			$(".checkk").filter(":checked").filter(function(){
				array[index] = $(this).val();
				index++;
			});
			var num = value;
			console.log(num);
			console.log(array);
			$("#refundNo").val(array);
			$("#num").val(num);
		}
		// When the user clicks on <span> (x), close the modal
		span2.onclick = function() {
		    modal2.style.display = "none";
		}
	
	</script>
	<%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>