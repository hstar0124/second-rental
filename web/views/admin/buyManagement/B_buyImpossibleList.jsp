<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.forest.buy.model.vo.BuyInfo ,
			com.kh.forest.member.model.vo.PageInfo" %>
<%
	ArrayList<BuyInfo> list = (ArrayList<BuyInfo>) request.getAttribute("list");
	
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
	int listCounReject = pi.getListCount();
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
	width: 100%;
	margin: 0px;
}

.resultTable {
	width: 100%;
	border: 1px solid #333333;
	border-collapse: collapse;
}

.resultTableTh {
	background-color: #A7C0E9;
	border: 1px solid #333333;
	font-size: 15px;
}

.resultTableTd {
	text-align: center;
	border-bottom: 1px solid #333333;
	border: 1px solid #333333;
	font-size:15px;
}
#info-td{
	border-right: 1px solid white;
}
#info-th{
	border-right:1px solid #A7C0E9;
}

.resultTableTd button {
	background: #4B6AA7;
	color: white;
	border: none;
	width: 100px;
	height: 20px;
	border-radius: 3px;
	cursor:pointer;
}

.resultTableTd button:nth-of-type(1) {
	margin-top: 10px;
	margin-bottom: 4px;
}

.resultTableTd button:nth-last-of-type(1) {
	margin-bottom: 10px;
	margin-top: 4px;
}

.DDD {
	background: #ECECEC;
	height: 35px;
	line-height: 35px;
	border: 2px solid #B8B8B8;
}

select {
	height: 30px;
}

.keyword {
	height: 25px;
}

.btn-1, .btn-2 {
	background: #BABABA;
	border: none;
	height: 30px;
	border-radius: 3px;
	color: white;
	font-size: 16px;
}

.btn-1 {
	margin-right: 10px;
}
.pagingArea{
	margin-bottom: 20px;
}
.pagingArea>button{
	border: none;
	background: white;
}

#detailBtn{
	height: 30px;
	font-size: 13px;
	width: 60px;
}
#deliverBtn{
	height: 30px;
	font-size: 14px;
	width: 60px;
	background: white;
	border: 2px solid #4B6AA7;
	color: #4B6AA7;
}

/*---------------------모달---------------------------*/
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
            margin: 5% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 700px; /* Could be more or less, depending on screen size */                          
            padding: 0px;
        }
        /* The Close Button */
        .close {
            color: white;
            float: right;
            font-size: 28px;
            font-weight: bold;
            padding-right: 10px;
            
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        .top-title {
			background: #16AAD8;
			height: 50px;
			width: 100%;
		}
		
		.top-title> p {
			color: white;
			margin: 0px;
			padding-top: 15px;
			font-size: 17px;
		}
		
		/*표 부분*/
		.table-area{
			width: 660px;
			margin: 0 auto;
			height: 250px;
			
		}
		
		
		.table-area tr>td:nth-of-type(1){
			width: 50px;
			background: #DADADA;
		}
		
		.table-area tr>td:nth-last-of-type(1){
			width: 250px;
			/* text-align: left; */
		}
		.table-area>table{
			width: 660px;
			text-align: center;
			margin-top: 10px;
			border-collapse:collapse;
		}
		.table-area tr>td{
			border: 1px solid #828282;
		}
		.table-area tr>th{
			background: #DADADA;
			border-bottom: 2px solid #828282;
		}
		
		
		/*버튼 영역*/
		.btn-area{
			height: 50px;
			text-align: center;
		}
		.btn-area>button{
			background: #6792DA;
			border-radius: 3px;
			border: none;
			height: 30px;
			color: white;
			width: 100px;
			margin-top: 10px;
		}
		.btn-area>button:nth-of-type(1){
			margin-right: 10px;
		}
		.btn-area>button:nth-last-of-type(1){
			margin-left: 10px;
		}
</style>
</head>
<body onload="ready('매입 불가 관리', '매입관리', '매입 불가 관리');">
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
						
					<input type="checkbox" name="buyCategory" id="firstReject" value="firstReject">
						<label for="firstReject">1차검수탈락</label>
						
					<input type="checkbox" name="buyCategory" id="buyReject" value="buyReject">
						<label for="buyReject">매입불가</label>
						
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
				&nbsp;&nbsp; <label class="total-text1">총 갯수 : </label><label
				class="total-count"><%=listCounReject %></label><br>
			</div>
		
		</article>


	<article>
		<table class="resultTable">
			<thead>
				<tr>
					<!-- <th class="resultTableTh"><input type="checkbox"></th> -->
					<th class="resultTableTh"><label>매입번호</label></th>
					<th class="resultTableTh"><label>아이디</label></th>
					<th class="resultTableTh"><label>상품명</label></th>
					<th class="resultTableTh"><label>세이프키</label></th>
					<th class="resultTableTh"><label>접수일</label></th>
					<th class="resultTableTh"><label>반품사유</label></th>
					<th class="resultTableTh"><label>상태</label></th>
					<th class="resultTableTh" id="info-th"><label></label></th>
					<th class="resultTableTh"><label></label></th>
				</tr>
			</thead>
			<tbody>
			<%for (BuyInfo bi : list) { %>
				<tr>
					<%-- <td class="resultTableTd"><input type="checkbox" name="check" value="<%=bi.getBuyStatus() %>"></td> --%>
					<td class="resultTableTd"><label><%=bi.getBuyNo() %></label></td>
					<td class="resultTableTd"><label><%=bi.getUserId() %></label></td>
					<td class="resultTableTd"><label><%=bi.getBuyProductName() %></label></td>
					<td class="resultTableTd"><label><%=bi.getSafeKey() %></label></td>
					<td class="resultTableTd"><label><%=bi.getRequestDate() %></label></td>
					<td class="resultTableTd"><label><%=bi.getReason() %></label></td>
					<td class="resultTableTd"><label><%=bi.getBuyStatus() %></label></td>
					<td class="resultTableTd" id="info-td"><label>
							<button id="detailBtn" value="<%=bi.getBuyNo()%>"
								onclick="detailBtn(this.value, '<%=bi.getUserId() %>');" >자세히</button> <br>
					</label></td>
					
					<% if(bi.getBuyStatus().equals("매입불가")){ 
							if(!bi.getDivision().equals("반송")) {
					%>
							<td class="resultTableTd return-td" style="width: 60px;"><label>
									<button id="deliverBtn" value="<%=bi.getBuyNo()%>"
									onclick="deliverBtn(this.value, '<%=bi.getUserId() %>', '<%=bi.getUserName()%>'
									,'<%=bi.getBuyProductName() %>');" >반송</button> <br>
							</label></td>
						<% } else if(bi.getDivision().equals("반송")) { %>
							<td class="resultTableTd return-td" style="width: 60px;"><label>&nbsp;&nbsp;</label></td>
						<% } else { %>	
							<td class="resultTableTd return-td" style="width: 60px;"><label>&nbsp;&nbsp;</label></td>
						<% } 
					
					 } else { %>	
					 <td class="resultTableTd return-td" style="width: 60px;"><label>&nbsp;&nbsp;</label></td>
					 <% } %>
				</tr>
			<% } %>
			</tbody>
		</table>
	<br>


		<!-- 페이징페이징 -->
		<div class="pagingArea" align="center">
		<button onclick="location.href='<%=request.getContextPath()%>/selectRejectList.ad?currentPage=1'"><<</button>
			<%
				if (currentPage <= 1) {
			%>
			<button disabled><</button>
			<%
				} else {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectRejectList.ad?currentPage=<%=currentPage - 1%>'"><</button>
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
				onclick="location.href='<%=request.getContextPath()%>/selectRejectList.ad?currentPage=<%=p%>'"><%=p%></button>
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
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectRejectList.ad?currentPage=<%=currentPage + 1%>'">></button>
			<%
				}
			%>
			<button onclick="location.href='<%=request.getContextPath()%>/selectRejectList.ad?currentPage=<%=maxPage%>'">>></button>
		</div>
		<!-- //페이징끝---- -->



		

	

		<!-- <button class="btn-1" id="btn-1" >운송장 입력</button> -->
		<!-- <button class="btn-2" id="btn-2" onclick="sendback();">반송하기</button>  -->

	<!---------------------------- 운송장입력 모달--------------------------------------->
	<div id="myModal" class="modal">
 
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>   
              
        <div class="top-title">
     	<p style="padding-left:20px;">반송 신청하기</p>
   	</div>

	<div class="table-area">
		<table>
			<tr>
				<td>매입번호</td>
				<td id="td-buyNo"></td>
			</tr>
			<tr>
				<td>아이디(고객명)</td>
				<td id="td-user"></td>
			</tr>
			<tr>
				<td>상품명</td>
				<td id="td-product"></td>
			</tr>
			<tr>
				<td>택배사</td>
				<td>
					<select id="select-carrier">
						<option>택배사선택</option>
						<option value="20">CJ 대한통운</option>
						<option value="10">우체국 택배</option>
						<option value="30">로젠</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>운송장 번호</td>
				<td><input type="text" id="deliveryNo" name="deliveryNo" 
					style="border:none; font-size:16px;"></td>
			</tr>
			
		</table>
	</div>


	
		<div class="btn-area">
			<button id="closeBtn">취소</button>
			<button id="okBtn">반송</button>
		</div>                                                      
      </div>
 
    </div>
		

	
	</article>

	<script>

		//정보확인 팝업창
		function detailBtn(value, userId) {
			var buyNo = value;
			var userId = userId;
			console.log("buyNo?:" + buyNo);
			window.open("<%=request.getContextPath()%>/selectAdminRejectDetail.ad?buyNo="+buyNo,
							"buyPop01_parent",
							"top=100,left=300,width=700,height=600,location=no,scrollbars=no,status=no,resizable=0,titlebar=no,menubar=no,directories=no");
		}

		//반송 모달------------------------------------------------
		
		var modal = document.getElementById('myModal');
		var btn = document.getElementById("btn-1");
		var span = document.getElementsByClassName("close")[0];                                          
		
		function deliverBtn(value, userId, userName, buyProductName){
		    modal.style.display = "block";
			var buyNo = value;
			var userId = userId;
			var userNameVal = userName;
			var buyProductName = buyProductName;
			var carrier = "";
			var waybillNo = "";
			
			console.log("userName:"+ userNameVal);
			
			$("#td-buyNo").text(value);
			$("#td-user").text(userId + "(" + userNameVal + ")");
			$("#td-product").text(buyProductName);
			
			$("#select-carrier").change(function(){
				$("#select-carrier").filter(function(){
					if($(this).find(":selected")){
						carrier = $(this).val();
						console.log(carrier);
					}
				});
			});
			
			$("#okBtn").click(function(){
				waybillNo = $("#deliveryNo").val();
				console.log(carrier);
				location.href = "<%=request.getContextPath()%>/insertDeliveryHistory.ad?buyNo=" + buyNo +
						"&waybillNo=" + waybillNo + "&carrier=" + carrier; 
			});
			
		}


		span.onclick = function() {
		    modal.style.display = "none";
		}
		$("#closeBtn").click(function(){
			modal.style.display = "none";
		});

				
				
	</script>


	<%@ include file="../common/C_menubar2.jsp"%>

</body>
</html>