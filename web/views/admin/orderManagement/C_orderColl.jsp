<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.order.model.vo.*, com.kh.forest.member.model.vo.*"%>
<%
	ArrayList<Rental> list = (ArrayList<Rental>) request.getAttribute("list");
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
	border : 1px solid black;
}
.resultTableTd {
	text-align : center;
	border : 1px solid black;
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
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

 /* Modal Content/Box */
        .modal-content {
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
            margin-right:20px;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        
        .modalTop{
        	margin: 0;
        	width:100%;
        	height:50px;
        	background:#16AAD8;
        } 
        
        .infoTb{
        	width:80%;
        	margin:20px auto;
          	border-collapse:collapse;
          	border:1px solid gray;
        	
        }
        
        .infoTb tr td {
        	border:1px solid gray;
        }
        
        .staTb{
        	width:80%;
        	margin:20px auto;
        	border-collapse:collapse;
        	border:1px solid black;
        }
        
        .staTb tr:first-of-type {
        	background:#A7C0E9;
        }
        
        .staTb tr td {
        	border:1px solid black;
        }
        
        .modalBtn {
        	margin: 30px auto;
        	
        	text-align:center;
        }
        .cancel {
        	width: 125px;
			height: 40px;
			background: #6792DA;
			border:1px solid #6792DA;
			color:white;
        }
        
        .mdTt {
        	margin:30px;
        	font-size:25px;
        }
        
        .modalTt {
        	font-size:30px;
        	border-bottom:1px solid black;
        	width:95%;
        	margin:0 auto;
        	margin-top:10px;
        	font-weight:bold;
        }
        .modalTt span {
        	color: #FF8329;	
        	
        }
        button {
	cursor:pointer;
}
</style>
</head>
<body onload="ready('회수관리', '주문관리', '회수관리');">

	<%@ include file="../common/C_menubar.jsp" %>
		<article>
			<form>
		<table class="searchGrid">
			<colgroup>
				<col width="20%" style="background: rgba(218, 218, 218, 0.459); padding-left:3px;">
				<col style="background: rgba(212, 212, 212, 0.253)">
			</colgroup>
			<tr>
				<td>렌탈번호</td>
				<td>
					<input type="text" id="keyword" name="keyword" class="keyword">
				</td>
			</tr>
			<tr>
				<td>처리현황</td>
				<td>
					<input type="checkbox" name="orderCategory" id="allColl" value="allColl">
						<label for="allColl">전체</label>
						
					<input type="checkbox" name="orderCategory" id="exColl" value="exColl">
						<label for="exColl">회수예정</label>
						
					<input type="checkbox" name="orderCategory" id="coll" value="coll">
						<label for="coll">인수중</label>
						
					<input type="checkbox" name="orderCategory" id="comColl" value="comColl">
						<label for="comColl">인수완료</label>
						
					<input type="checkbox" name="orderCategory" id="overColl" value="overColl">
						<label for="overColl">연체</label>
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
			<tr>
				<th class="resultTableTh"><input type="checkbox"></th>
				<th class="resultTableTh">번호</th>
				<th class="resultTableTh"><label>렌탈번호</label></th>
				<th class="resultTableTh"><label>상품번호</label></th>
				<th class="resultTableTh"><label>대여 만료일자</label></th>
				<th class="resultTableTh"><label>남은 일자</label></th>
				<th class="resultTableTh"><label>아이디(고객명)</label></th>
				<th class="resultTableTh"><label>처리 현황</label></th>
				<th class="resultTableTh"><label>상세</label></th>
			</tr>
			<%
			int no =  listCount - ((pi.getCurrentPage() - 1) * pi.getLimit() + 1) + 1;
			for(Rental r : list) { %>
			<tr>
				<td class="resultTableTd"><input type="checkbox" class="reTbCheck" value="<%= r.getRentalNo() %>"></td>
				<td class="resultTableTd"><%= no %></td>
				<td class="resultTableTd"><%= r.getRentalNo() %></td>
				<td class="resultTableTd"><%= r.getProductNo() %></td>
				<td class="resultTableTd"><%= r.getExpiryDate() %></td>
				<td class="resultTableTd"><%= r.getRestTime() %></td>
				<td class="resultTableTd"><%= r.getUserId() %>(<%= r.getUserName() %>)</td>
				<td class="resultTableTd"><%= r.getStatus() %></td>
				<td class="resultTableTd"><button id="orderInfo" onclick="detail('<%=r.getRentalNo()%>');">
						<img style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" >
			</tr>
			<% 
				no--;
			} %>
			<!-- <tr>
				<td class="resultTableTd"><input type="checkbox"></td>
				<td class="resultTableTd"><label>???</label></td>
				<td class="resultTableTd"><label>??</label></td>
				<td class="resultTableTd"><label>??</label></td>
				<td class="resultTableTd"><label>??</label></td>
				<td class="resultTableTd"><label>??</label></td>
				<td class="resultTableTd"><label>??</label></td>
				<td class="resultTableTd"><button id="orderInfo"><img style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" ></button></td>
			</tr> -->
		</table>
		<br><br>
		
		
		
		<!-- 페이징페이징 -->
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/collRental?currentPage=1'"><<</button>
				<% if(currentPage <= 1) { %>
				<button disabled><</button>
				<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/collRental?currentPage=<%= currentPage - 1 %>'"><</button>
				<% } %>
		
				<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){
				%>
						<button disabled><%=p %></button>
			
					<% }else {%>
						<button onclick="location.href='<%=request.getContextPath()%>/collRental?currentPage=<%=p%>'"><%=p %></button>
				<% 		}
				}%>
		
				<% if(currentPage >= maxPage){ %>
				<button disabled>></button>
				<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/collRental?currentPage=<%= currentPage + 1 %>'">></button>
				<% } %>
			<button onclick="location.href='<%= request.getContextPath() %>/collRental?currentPage=<%=maxPage %>'">>></button>
		</div>
		<!-- --------------------- -->
		
		
		<br>
		<hr>
		<label>분류 일괄 처리</label>
		<div class="DDD">&nbsp;&nbsp;
			<button onclick="complete();">회수 완료</button>
		</div>
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
	
		
		var modal = document.getElementById('myModal');
		var btn = document.getElementById('orderInfo');
		
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		
		/* btn.onclick = function() {
		    modal.style.display = "block";
		}
		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		    modal.style.display = "none";
		} */
		
		function detail(rentalNo){
			window.open("<%=request.getContextPath()%>/collDetail.re?rentalNo="+rentalNo , "tms","width=900,height=600,top=100px,left=200px");
		}
		
		var array = new Array();
		function complete(){
			var index = 0;
			$(".reTbCheck").filter(":checked").filter(function(){
				array[index] = $(this).val();
				index++;
			});
			
				
				location.href="<%=request.getContextPath()%>/updateRental.col?rentalNo=" + array ;
		}
	
	</script>
	<%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>