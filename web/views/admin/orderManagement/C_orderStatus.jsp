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
<meta name="viewport" content="width=device-width, initial-scale=1">
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
            width: 30%; /* Could be more or less, depending on screen size */                          
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
        
        
        .carrierInfo {
        	width:80%;
        	margin:0 auto;
        }
        #waybillNo {
        	width:300px;
        	height:20px;
        }
        #companySe{
        	height:25px;
        	
        }
        
</style>

</head>
<body onload="ready('주문현황관리','주문관리','주문현황관리');">
	<%@ include file="../common/C_menubar.jsp" %>
<%-- <script>
$(function(){
	$.ajax({
		url: "<%=request.getContextPath()%>/token.or",
		type:"get",
		success: function(data){
			console.log("token : "+ data);
			$.ajax({
				url: "<%=request.getContextPath()%>/cancel.or",
				type:"get",
				data: {token:data},
				success: function(data){
					
					console.log(data);
				},
				error: function(error){
					console.log(error);
				}
			})
		},
		error: function(error){
			console.log(error);
		}
	});
});

</script> --%>
	<article>
	<form>
		<table class="searchGrid">
			<colgroup>
				<col width="20%" style="background: rgba(218, 218, 218, 0.459)" text-align="center">
				<col style="background: rgba(212, 212, 212, 0.253)">
			</colgroup>
			<tr>
				<td>분류</td>
				<td>
					<input type="checkbox" name="orderCategory" id="everyOrder" value="everyOrder" checked>
						<label for="everyOrder">모든 현황</label>
						
					<input type="checkbox" name="orderCategory" id="orderCancel" value="orderCancel">
						<label for="orderCancel">주문취소</label>
						
					<input type="checkbox" name="orderCategory" id="payComplete" value="payComplete">
						<label for="payComplete">결제완료</label>
						
					<input type="checkbox" name="orderCategory" id="readyDelivery" value="readyDelivery">
						<label for="readyDelivery">배송준비</label>
						
					<input type="checkbox" name="orderCategory" id="delivery" value="delivery">
						<label for="delivery">배송중</label>
						
					<input type="checkbox" name="orderCategory" id="deliveryComplete" value="deliveryComplete">
						<label for="deliveryComplete">배송완료</label>
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
			<col width="30%">
			<col>
			<col>
			<col>
			<col>
		</colgroup>
			<tr>
				<th class="resultTableTh"><input type="checkbox"></th>
				<th class="resultTableTh"><label>번호</label></th>
				<!-- <th class="resultTableTh"><label>아이디</label></th> -->
				<th class="resultTableTh"><label>이름</label></th>
				<th class="resultTableTh"><label>주문번호</label></th>
				<th class="resultTableTh"><label>상품번호</label></th>
				<th class="resultTableTh"><label>상품명</label></th>
				<th class="resultTableTh"><label>주문일자</label></th>
				<th class="resultTableTh"><label>가격</label></th>
				<th class="resultTableTh"><label>현황</label></th>
				<th class="resultTableTh"><label>상세</label></th>
			</tr>
			<%
			int no =  listCount - ((pi.getCurrentPage() - 1) * pi.getLimit() + 1) + 1;
				for(OrderStatus os : list){
			%>
					<tr>
						<td class="resultTableTd"><input type="checkbox" class="reTbCheck" value="<%= os.getOrderCode() %>"></td>
						<td class="resultTableTd"><%= no %></td>
						<td class="resultTableTd"><%= os.getUserId() %></td>
						<%-- <td class="resultTableTd"><%= os.getUserName() %></td> --%>
						<td class="resultTableTd"><%= os.getOrderNo() %></td>
						<td class="resultTableTd"><%= os.getProductNo() %></td>
						<td class="resultTableTd"><%= os.getProductName() %></td>
						<td class="resultTableTd"><%= os.getOrderDate() %></td>
						<td class="resultTableTd"><%= os.getPrice() %></td>
						<td class="resultTableTd"><%= os.getStatus() %></td>
						<td class="resultTableTd"><button id="orderInfo" onclick="detail('<%=os.getOrderNo()%>', '<%= os.getProductNo()%>');">
						<img style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" >
						</button></td>
					</tr>
			
			<% no--;	
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
		
		
		
		
		<hr>
		<label>분류 일괄 처리</label>
		<div class="DDD">&nbsp;&nbsp;
			<!-- <button>입금완료</button> -->
			<button onclick="deliveryReady();">배송준비</button>
			<button onclick="delivery();">배송중</button>
			<button onclick="completeDeli();">배송완료</button>
			<!-- <button>결제취소</button> -->
		</div>
	</article>


<!-- The Modal2 -->
    <div id="myModal" class="modal">
 
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>                                                               
        <div class="modalTop"></div>
        <div class="mdTt"><b>운송장번호 입력</b></div>
        <form action="<%=request.getContextPath()%>/complete.de" method="post">
        <input type="hidden" id="num" name="num">
        <input type="hidden" id="orderCode" name="orderCode">
        <div class="carrierInfo">
	        <span class="returnReason" id="company">
		        <select name="companySe" id="companySe">
		        	<option value="10">우체국</option>
		        	<option value="20">CJ대한통운</option>
		        	<option value="30">로젠택배</option>
		        </select>
	        </span>
	        <span>
	        	<input type="text" name="waybillNo" id="waybillNo">
	        </span>
        </div>
        <div class="modalBtn">
        	<span><button class="cancel">확인</button></span>
        </div>
        </form>
      </div>






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
		
		$(function() {
			$(".searchBtn").click(function(){
				/*if($("input:checkbox").is(":checked")){
					console.log(this.value());	
					
				}*/
				console.log("hi");
				$("input:checkbox").filter("[name:orderCategory]").filter(function(){
					if(this.checked){
						console.log(this.val());
					}
				});
				
				
			});
		});
		
		var array = new Array();
		var num = 0;
		
		function completeDeli(){
			num = 0;
			var index = 0;
			$(".reTbCheck").filter(":checked").filter(function(){
				array[index] = $(this).val();
				index++;
			});
			
				
				location.href="<%=request.getContextPath()%>/complete.de?orderCode=" + array + "&num=" + num;
		}
		
		
		
		var modal = document.getElementById('myModal');
		var btn = document.getElementById('cancel');
		
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		function deliveryReady(){
			modal.style.display = "block";

			num = 2;
			var index = 0;
			$(".reTbCheck").filter(":checked").filter(function(){
				array[index] = $(this).val();
				index++;
			});
			
			$("#num").val(num);
			$("#orderCode").val(array);
			
			/* var key = 'EEo2Y8YF1u45O8pwQN3Aew'
			
			$.ajax({
				url:"http://info.sweettracker.co.kr/api/v1/companylist?t_key="+key,
				type:"GET",
				dataType : "json",
				success:function(data){
					console.log(data);
							
					$divCompany = $("#company");
					
					var companyInfo = data.Company;
					
					$companySe = $("#companySe");
					
					$.each(companyInfo, function(index, value){
						var $option = "<option value=" + value.Code + ">" + value.Name + "</option>";
						
						$companySe.append($option);
					});
				}
			});
				 */
				
		}
		
		span.onclick = function() {
		    modal.style.display = "none";
		}
		
		
		function delivery(){
			num = 1;
			var index = 0;
			$(".reTbCheck").filter(":checked").filter(function(){
				array[index] = $(this).val();
				index++;
			});
			
				
				location.href="<%=request.getContextPath()%>/complete.de?orderCode=" + array + "&num=" + num;
		}
	
		
		var modal = document.getElementById('myModal');
		var btn = document.getElementById('orderInfo');
		
		/* // Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		
		btn.onclick = function() {
		    modal.style.display = "block";
		}
		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		    modal.style.display = "none";
		} */
		
		function detail(orderNo, productNo){
			var halfWith = (document.body.offsetWidth / 2);
			var halfHeight = (document.body.offsetHeight / 2);
			var popupX = halfWith - (1000 / 2);
			//&nbsp;만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

			var popupY= halfHeight - (700 / 2);
			//&nbsp;만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
			
			window.open("<%=request.getContextPath()%>/selectDetail.or?orderNo=" + orderNo + "&productNo=" + productNo, "tms","width=1000,height=700,top=100px,left="+popupX);
		}
	
	</script>

	<%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>