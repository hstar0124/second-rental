<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.forest.buy.model.vo.BuyInfo, 
    	com.kh.forest.member.model.vo.PageInfo"%>
<%
	ArrayList<BuyInfo> list = (ArrayList<BuyInfo>) request.getAttribute("list");
	
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
<title>중고구마</title>
<style>
/*---------판매현황--------- */
#buyCurrent {
	background: #6E00AB;
	color: white;
}
.title{
	margin-bottom:1px;
}

/*판매현황 표*/
.current-table{
    width: 1010px;
    margin-top: 50px;
    text-align: center;
    
}

.tr1>td{
    height: 40px;
    border-bottom: 1px solid #060202;
    background: #ECECEC; 
    width: 500px; 
    padding-top: 5px; 
    padding-bottom: 5px;
    
}
.current-tr> td{
    height: 30px;
    border-bottom: 1px solid #060202;
    
}
.current-tr>td:nth-of-type(1){
    width: 150px;
}
.current-tr>td:nth-of-type(2){
    width: 300px;
}
.current-tr>td:nth-of-type(3){
    width: 200px;
}
.current-tr>td:nth-of-type(4){
    width: 150px;
}
.current-tr>td:nth-of-type( 5){
    width: 150px;
}

.change-info{
	background: #563F63;
	border-radius: 5px;
	color: white;
	border: none;
	height: 25px;
	cursor:pointer;
}
.confirm-quote{
	background: #D898FC;
	border-radius: 5px;
	color: white;
	border: none;
	height: 25px;
	cursor:pointer;
}
.reason-check{
	background: #825E96;
	border-radius: 5px;
	color: white;
	border: none;
	height: 25px;
	cursor:pointer;
}
.delivery-info{
	background: #B855EE;
	border-radius: 5px;
	color: white;
	border: none;
	height: 25px;
	cursor:pointer;
}

.checking{
	background: #BABABA;
	border-radius: 5px;
	color: white;
	border: none;
	height: 25px;
	width: 65px;
	cursor:pointer;
}
.inputfinish{
	background: #BABABA;
	border-radius: 5px;
	color: white;
	border: none;
	height: 25px;
	cursor:pointer;
}


.pagingArea{
	margin-top: 20px;
	margin-bottom: 20px;
}
.pagingArea>button{
	border: none;
	background: white;
	cursor:pointer;
}

/*--------------------견적확인 모달------------------------*/
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

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 7% auto; /* 15% from the top and centered */
	border: 1px solid #888;
	width: 650px; /* Could be more or less, depending on screen size */
	height: 800px;
	
}
.top-title {
	background: #6E00AB;
	height: 50px;
	width: 100%;
}

.modal-content p {
	color: white;
	margin: 0px;
	padding-top: 15px;
	font-size: 17px;
}
/*상단표*/
.content-area{
	width: 600px;
	height: 200px;
	margin: 0 auto;
}
.content-area>table{
	width: 600px;
	height: 200px;
	text-align:center;
	border-collapse: collapse;
	margin-top: 30px;
}
.content-area tr>td{
	border: 1px solid black;
}

.content-area tr input{
	width: 100px;
	
}
.content-area tr:nth-of-type(1)>td::nth-of-type(1){
	text-align: center;
}
.content-area tr>td:nth-of-type(1){
	width: 100px;
	background: #ECECEC;
}



/*하단표*/
.info-area{
	width: 598px;
	height: 450px;
	margin: 0 auto;
	border : 1px solid black;
}
.agree-info{
	width: 500px;
	border: 1px solid #BABABA;
	margin: 0 auto;
	margin-top: 10px;
}
.agree-info>p{
	color: black;
	text-align: center;
}
.agree-info>label{
	font-size: 13px;
}
.checkbox-area{
	text-align: center;
}

.modal-btn{
	margin: 0 auto;
	text-align: center;
}
.cancel-btn {
	background: #6E00AB;
	border-radius: 3px;
	border: none;
	height: 30px;
	color: white;
	width: 100px;
	margin-top: 10px;
	cursor:pointer;
}
.modal-ok{
	background: #BABABA;
	border-radius: 3px;
	border: none;
	height: 30px;
	color: white;
	width: 100px;
	margin-top: 10px;
	cursor:pointer;
}



/*--------------------222222222모달2222222------------------------*/
/* The Modal (background) */
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
.modal-content2 {
	background-color: #fefefe;
	margin: 7% auto; /* 15% from the top and centered */
	border: 1px solid #888;
	width: 650px; /* Could be more or less, depending on screen size */
	height: 750px;
	
}
.top-title2 {
	background: #6E00AB;
	height: 50px;
	width: 100%;
}

.modal-content2 p {
	color: white;
	margin: 0px;
	padding-top: 15px;
	font-size: 17px;
}
/*상단표*/
.content-area2{
	width: 600px;
	height: 200px;
	margin: 0 auto;
}
.content-area2>table{
	width: 600px;
	height: 200px;
	text-align:center;
	border-collapse: collapse;
	margin-top: 30px;
}
.content-area2 tr>td{
	border: 1px solid black;
}

.content-area2 tr input{
	width: 100px;
	
}
.content-area2 tr:nth-of-type(1)>td::nth-of-type(1){
	text-align: center;
}
.content-area2 tr>td:nth-of-type(1){
	text-align: center;
	background: #ECECEC;
	width: 100px;
}


/*하단표*/
/* .info-area2{
	width: 598px;
	height: 450px;
	margin: 0 auto;
	border : 1px solid black;
} */
.reject-info2{
	width: 600px;
	
	margin: 0 auto;
	margin-top: 10px;
}
.reject-info2>p{
	color: black;
	text-align: left;
	font-weight: bold;
}
.reject-info2>label{
	font-size: 13px;
}
.sendback-area2{
	text-align: left;
}
.sendback-area2>p{
	color: black;
	text-align: left;
	font-weight: bold;
}
.sendback-area2>label{
	color: black;
	text-align: left;
	font-size: 13px;
}

.modal-btn2{
	margin: 0 auto;
	text-align: center;
}
.modal-btn2>button {
	background: #6E00AB;
	border-radius: 3px;
	border: none;
	height: 30px;
	color: white;
	width: 100px;
	margin-top: 10px;
	cursor:pointer;
}

/*-------------------정보확인모달----------------------------*/
/* The Modal (background) */
.modal3 {
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
.modal-content3 {
	background-color: #fefefe;
	margin: 7% auto; /* 15% from the top and centered */
	border: 1px solid #888;
	width: 650px; /* Could be more or less, depending on screen size */
	height: 350px;
	
}
.top-title3 {
	background: #6E00AB;
	height: 50px;
	width: 650px;;
}

.modal-content3 p {
	color: white;
	margin: 0px;
	padding-top: 15px;
	font-size: 17px;
}
/*상단표*/
.content-area3{
	width: 600px;
	height: 200px;
	margin: 0 auto;
}
.content-area3>table{
	width: 600px;
	height: 200px;
	text-align:center;
	border-collapse: collapse;
	margin-top: 30px;
}
.content-area3 tr>td{
	border: 1px solid black;
}

.content-area3 tr input{
	width: 100px;
	
}
.content-area3 tr>td:nth-of-type(1){
	text-align: center;
	background: #ECECEC;
}

.modal-btn3{
	margin-top: 20px;
	margin: 0 auto;
	text-align: center;
}
.modal-btn3>button {
	background: #6E00AB;
	border-radius: 3px;
	border: none;
	height: 30px;
	color: white;
	width: 100px;
	margin-top: 10px;
	cursor:pointer;
}

</style>
</head>
<body>

	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
	
	<h2 class="title">판매 현황</h2>
        <div style="background-color: #6E00AB; width: 100%; height: 4px; margin-top: 0px;"></div>
        <div id="content">
        <p style="margin-bottom:20px;"><b>
        	| 1차검수 통과 시 상품을 중고구마 측으로 보내주시면 2차 검수가 진행 됩니다.</b></p>
            <table class="current-table"  cellspacing="0" style="margin-top:20px;">
                <thead>
                    <tr class="current-tr tr1">
                        <td>판매번호</td>
                        <td>상품명</td>
                        <td>접수일</td>
                        <td>상태</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                <% for(BuyInfo bi : list) {%>
                <tr class="current-tr">
                	<td><%=bi.getBuyNo() %></td>
                	<td><%=bi.getBuyProductName() %></td>
                	<td><%=bi.getRequestDate() %></td>
                	<td><%=bi.getBuyStatus() %></td>
                	<%if (bi.getBuyStatus().equals("인수대기중")) { 
                		if(bi.getDivision().equals("인수")) {
                	%>
                			<td><button class="inputfinish">입력완료</button>
                		<% } else { %>
                			<td><button id="deliveryinfo" class="delivery-info" value="<%=bi.getBuyNo()%>"
                				onclick="deliveryinfo(this.value, '<%=loginMember.getUserNo()%>');">운송장입력</button></td>
                		<% } 
                			
               		 } else if (bi.getBuyStatus().equals("1차검수신청")) { %>
               		<td><button class="checking">검수중</button></td>
               		<% } else if (bi.getBuyStatus().equals("1차검수완료")) { %>
               		<td><button id="confirm-quote" class="confirm-quote" value="<%=bi.getBuyNo()%>"
               			onclick="quotecheck(this.value, '<%=loginMember.getUserName()%>','<%=bi.getBuyProductName()%>', 
               				'<%=bi.getGrade()%>', '<%=bi.getBuyPrice()%>');">견적확인</button></td>
               		<% } else if (bi.getBuyStatus().equals("매입불가") || bi.getBuyStatus().equals("1차검수탈락")) { %>
               		<td><button id="reason-check" class="reason-check" value="<%=bi.getBuyNo() %>"
               			onclick="reasoncheck(this.value, '<%=loginMember.getUserName()%>', '<%=bi.getBuyProductName()%>', 
               				'<%=bi.getGrade()%>', '<%=bi.getBuyPrice()%>', '<%=bi.getReason()%>', 
               				'<%=bi.getBuyWaybillNo()%>', '<%=bi.getBuyCarrier()%>', '<%=bi.getDivision()%>');">사유확인</button></td>
               		<% } else {%>
               		<td><button id="infocheck" class="change-info" value="<%=bi.getBuyNo()%>"
               			onclick="infocheck(this.value, '<%=loginMember.getUserNo()%>', '<%=bi.getBuyProductName()%>', 
               				'<%=bi.getGrade()%>', '<%=bi.getBuyPrice()%>')">정보확인</button></td>
               		
               		<% } %>
                </tr>
                <% } %>
                </tbody>
            </table>
            <!-- 페이징페이징 -->
		<div class="pagingArea" align="center">

			<button onclick="location.href='<%=request.getContextPath()%>/mypageBuylist.buy?currentPage=1'"><<</button>
			<%
				if (currentPage <= 1) {
			%>
			<button disabled><</button>

			<%
				} else {
			%>
			<button	onclick="location.href='<%=request.getContextPath()%>/mypageBuylist.buy?currentPage=<%=currentPage - 1%>'"><</button>
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
				onclick="location.href='<%=request.getContextPath()%>/mypageBuylist.buy?currentPage=<%=p%>'"><%=p%></button>
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
				onclick="location.href='<%=request.getContextPath()%>/mypageBuylist.buy?currentPage=<%=currentPage + 1%>'">></button>
			<%
				}
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/mypageBuylist.buy?currentPage=<%=maxPage%>'">>></button>
		</div>
		<!-- ----------//페이징끝----------- -->
        </div>
        
    <!---------  견적확인모달 ------------>
	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<div class="top-title">
				<p style="padding-left: 20px;">견적 확인</p>
			</div>

			<div class="content-area">
				<table>
					<tr>
						<!-- <td rowspan="4">
							<input type="image" name="product-img1" src="/forest/image/userimg/pimg1.png">
						</td> -->
						<td>고객 성함</td>
						<td id="td-userName"></td>
					</tr>
					<tr>
						<td>삼풍명</td>
						<td id="td-productName"></td>
					</tr>
					<tr>
						<td>상품 등급</td>
						<td id="td-grade"></td>
					</tr>
					<tr>
						<td>매입 금액</td>
						<td id="td-buyPrice"></td>
					</tr>
				</table>
			</div>
			
			<div class="info-area">
				<div class="agree-info">
					<p><b><판매 안내></b></p>
					<label>                                                                      
						1. 본 상품의 매입 금액 평균 거래 시세가를 참고하여 검수체크리스트를 체크하여 가격을 측정하였습니다.<br>
						2. 본 상품의 배송관련 배송절차와 배송비는 고객이 부담하여야 합니다.<br>
						3. 본 상품이 배송 된 후에도 입고 전 2차 검수과정이 있습니다. 
						이때, 상품이 사진속 물건과 다르거나 다른 이상경우가 발생할 경우 고객께 통보 후 반송처리 합니다.(착불)<br>
						4. 배송시 파손될 위험성 또는 손해 발생을 대비해 고객님께서 보내주신 택배를 개봉할 시 사진으로 처음 사진과 비교하는 과정이 있습니다. 
						위와 같은 경우가 발생 시 과정에 대한 사진을 고객께서 필요로 할 경우 고객센터(7367-9091)로 전화주시면 확인하실 수 있습니다.<br>
						5. 2차 검수과정이 끝나고 판매 완료 처리가 되면 고객님에게 포인트로 물품 매입 가격만큼 지급하게 됩니다.<br>
						6. 위와 같은 매입과정이 끝나기 까지 최대 7일까지 소요될 수 있습니다.<br>
						7. 해당 판매와 관련하여 궁금하신게 있다면 고객센터 (7367 -9091)로 전화해주시면 감사하겠습니다.<br>
						8. 본 매입 신청은 7일 이내에 신청이 들어오지 않으면 자동으로 취소확정 됩니다.<br>
						9. 배송은 사이트 하단 주소로 꼭 고객님의 성함으로 배송시키셔야 합니다.
					</label>
				</div>
				<br>
				<div class="checkbox-area">
					<input type="checkbox" name="agree" id="agree" value="agree">
					<label for="agree">위 안내를 다 읽고 동의하시면 체크를 눌러주세요.</label>
				</div>
			</div>
			
			

			<div class="modal-btn">
				<button class="cancel-btn">취소</button>
				<button class="modal-ok">판매확정</button>
			</div>
		</div>
</div>
	
	    <!------------------------------ 사유확인 모달시작 ----------------------------->
	<div id="myModal2" class="modal2">
		<!-- Modal content -->
		<div class="modal-content2">
			<div class="top-title2">
				<p style="padding-left: 20px;">사유 확인</p>
			</div>

			<div class="content-area2">
				<table>
					<tr>
						<!-- <td rowspan="4">
							<input type="image" name="product-img1" src="/forest/image/userimg/pimg1.png">
						</td> -->
						<td>고객 성함</td>
						<td id="modal2-userName"></td>
					</tr>
					<tr>
						<td>삼풍명</td>
						<td id="modal2-productName"></td>
					</tr>
					<tr>
						<td>상품 등급</td>
						<td id="modal2-grade"></td>
					</tr>
					<tr>
						<td>매입 금액</td>
						<td id="modal2-buyPrice"></td>
					</tr>
				</table>
			</div>
			
			
				<div class="reject-info2">
					<p>| 매입 불가 사유</p>
					<textarea cols="87" rows="10"  style="resize: none;" readonly id="modal2-textarea"></textarea><br>
					<label>                                                                      
						  -매입불가 상품이 반송이 진행될 때에 고객님이 처음 입력하신 주소로 다시 반송될 예정입니다. <br>
						-배송비는 착불로 다시 배송되며 이는 약관에 의거하여 진행됨을 알려드립니다.
					</label>
				
				
				<div class="sendback-area2">
					<p>| 반송 정보</p>
					<table>
						<tr>
							<td><label>* 택배사</label></td>
							<td><input type="text" id="carrier" class="carrer" readonly></td>
						</tr>
						<tr>
							<td><label>* 운송장 번호</label></td>
							<td><input type="text" id="deliveryNo" class="deliveryNo" readonly></td>
						</tr>
					</table>
					<label>
						택배 관련 된 문의는 해당 택배사 고객센터에 문의부탁드립니다.<br>
						해당 거절 사유에 대한 문의는 1:1 문의 또는 고객센터에 문의해주시기 바랍니다.</label>
					
				</div>
			</div>
			
			

			<div class="modal-btn2">
				<button class="modal-ok2">확인</button>
			</div>
		</div>
	</div>
<!--------------------------사유확인 모달 끝 ----------------------------------------- -->

	    <!-------------------------정보확인 모달 ----------------------------->
	<div id="myModal3" class="modal3">
		<div class="modal-content3">
			<div class="top-title3">
				<p style="padding-left: 20px;">정보 확인</p>
			</div>

			<div class="content-area3">
				<table>
					<tr>
						<td>삼풍명</td>
						<td id="info-productName"></td>
					</tr>
					<tr>
						<td>상품 등급</td>
						<td id="info-grade"></td>
					</tr>
					<tr>
						<td>매입 금액</td>
						<td id="info-buyPrice"></td>
					</tr>
					
				</table>
			</div>
			

			<div class="modal-btn3">
				<button class="modal-ok3" id="infoOkBtn">확인</button>
			</div>
		</div>
	</div>
<!--------------------------정보확인 모달 끝 ----------------------------------------- -->
	<script>
		//운송장입력 화면으로 이동--------------------------------------------
		function deliveryinfo(value, userNo){
			var buyNoVal = value;
			var userNoVal = userNo;
			location.href = "<%=request.getContextPath()%>/selectDelivery.buy?buyNoVal=" + buyNoVal; 
		};
		
<%-- 		//정보변경 화면으로 이동(반송)------------------------------------------
		function changepage(value){
			var buyNoVal2 = value;
			location.href = "<%=request.getContextPath()%>/selectDeliveryBuyNo.buy?buyNoVal=" + buyNoVal2;
			
		} --%>
		//정보확인 모달-----------------------------------------------------------
		var modal3 = document.getElementById('myModal3');
		var btn5 = document.getElementById("infocheck");
		var btn6 = document.getElementById("infoOkBtn");
		
		var buyNoVal3 = "";
		var userNameVal3 = "";
		var buyProductNameVal3 = "";
		var gradeVal3 = "";
		var buyPriceVal3 = "";

		
		//모달 열리는 함수
		function infocheck(value, userName, buyProductName, grade, buyPrice){
			modal3.style.display = "block";
			
			buyNoVal3 = value;
			userNameVal3 = userName;
			buyProductNameVal3 = buyProductName;
			gradeVal3 = grade;
			buyPriceVal3 = buyPrice;
			
			$("#info-productName").text(buyProductNameVal3);
			$("#info-grade").text(gradeVal3 + "급");
			$("#info-buyPrice").text(buyPriceVal3 + "원");
			
		}
		
		
		//모달 닫히는 힘수
		btn6.onclick = function() {
			modal3.style.display = "none";
		}
		
	
		//견적확인 모달------------------------------------------------------------
		var modal = document.getElementById('myModal');
		var btn = document.getElementById("confirm-quote");
		// 취소 버튼
		var btn3 = document.getElementsByClassName("cancel-btn")[0];
		
		var buyNoVal = "";
		var userNameVal = "";
		var buyProductNameVal = "";
		var gradeVal = "";
		var buyPriceVal = "";
		
		// 모달 열리는 함수
		function quotecheck (value, userName, buyProductName, grade, buyPrice){
			modal.style.display = "block";
			
			buyNoVal = value;
			userNameVal = userName;
			buyProductNameVal = buyProductName;
			gradeVal = grade;
			buyPriceVal = buyPrice;
			
			$("#td-userName").text(userNameVal);
			$("#td-productName").text(buyProductNameVal);
			$("#td-grade").text(gradeVal + "급");
			$("#td-buyPrice").text(buyPriceVal + "원");
			
			$("input:checkbox[name=agree]").click(function(){
				if($("input:checkbox[name=agree]").is(":checked")){
					$(".modal-ok").css({"background": "#6E00AB"});
					$(".modal-ok").on("click", function(){
						location.href = "<%=request.getContextPath()%>/updateBuyStatusMyPage.buy?buyNoVal=" + buyNoVal;
					});
				}
				
			});
		}
		
		//모달 닫히는 힘수
		btn3.onclick = function() {
			modal.style.display = "none";
		}
		
		//사유확인 모달------------------------------------------------------------------

		var modal2 = document.getElementById('myModal2');
		var btn3 = document.getElementById("reason-check");
		var btn4 = document.getElementsByClassName("modal-ok2")[0];
		
		var buyNoVal2 = "";
		var userNameVal2 = "";
		var buyProductNameVal2 = "";
		var gradeVal2 = "";
		var buyPriceVal2 = "";
		var reasonVal = "";
		var carrier = "";
		var deliveryNo = "";
		
		//모달 열리는 함수
		function reasoncheck(value, userName, buyProductName, grade, buyPrice, reason, buywaybillNo, buycarrier, division){
			modal2.style.display = "block";
			
			buyNoVal2 = value;
			userNameVal2 = userName;
			buyProductNameVal2 = buyProductName;
			gradeVal2 = grade;
			buyPriceVal2 = buyPrice;
			reasonVal = reason;
			deliveryNo = buywaybillNo;
			carrier = buycarrier;
			var division = division;
			console.log("division: " + division);
			
			$("#modal2-userName").text(userNameVal2);
			$("#modal2-productName").text(buyProductNameVal2);
			$("#modal2-grade").text(gradeVal2 + "급");
			$("#modal2-buyPrice").text(buyPriceVal2 + "원");
			
			$("#modal2-textarea").val(reasonVal);
			
			if(division == "반송"){
				$("#deliveryNo").val(deliveryNo);
				$("#carrier").val(carrier);
			}
			
		}
		

		//모달 닫히는 힘수
		btn4.onclick = function() {
			modal2.style.display = "none";
		}
	</script>

	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp"%>
</body>
</html>