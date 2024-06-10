<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, 
				java.util.HashMap,
				com.kh.forest.buy.model.vo.BuyInfo ,
				com.kh.forest.member.model.vo.PageInfo" %>
<%
	ArrayList<BuyInfo> list = (ArrayList<BuyInfo>) request.getAttribute("list");
	
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
	int listCountRequest = pi.getListCount();
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
	width: 100%;
	border-top: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-collapse: collapse;
}

.resultTableTh {
	background-color: #A7C0E9;
	border: 1px solid #333333;
	font-size: 16px;
}

.resultTableTd {
	text-align: center;
	border: 1px solid #333333;
	font-size: 16px;
}

.DDD {
	background: #ECECEC;
	height: 35px;
	line-height: 35px;
	border: 2px solid #B8B8B8;
}

.resultTableTd button {
	background: #4B6AA7;
	border-radius: 5px;
	color: white;
	border: none;
	cursor: pointer;
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

#requestBtn, #detailBtn, #rejectPopup {
	height: 25px;
}
.pagingArea{
	margin-top: 20px;
}
.pagingArea>button{
	border: none;
	background: white;
	font-weight: bold;
}
/*--------------------------2차검수 모달-----------------------------------------*/
		.modal {
			display: none; 
			position: fixed; 
			z-index: 1; 
			left: 0;
			top: 0;
			width: 100%; 
			height: 100%; 
			overflow: auto; 
			background-color: rgb(0, 0, 0); 
			background-color: rgba(0, 0, 0, 0.4); 
		}
		
		/* Modal Content/Box */
		.modal-content {
			background-color: white;
			margin: 5% auto; 
			border: 1px solid #888;
			width: 800px;
			height: 1030px 
		}
		/* The Close Button */
		.close {
			color: white;
			float: right;
			font-size: 28px;
			font-weight: bold;
			padding-right: 10px;
		}
		
		.close:hover, .close:focus {
			color: black;
			text-decoration: none;
			cursor: pointer;
		}
		
		.top-title {
			background: #16AAD8;
			height: 50px;
			width: 100%;
		}
		
		.modal-content p {
			color: white;
			margin: 0px;
			padding-top: 15px;
			
			font-size: 17px;
		}
		
		/*사진 보기*/
		.photo-area {
			display: flex;
			height: 220px;
		}
		
		.photo-div {
			margin: 0 auto;
			margin-top: 5px;
			width: 100px;
			height: 100px;
		}
		
		.icon-img {
			width: 40px;
			height: 30px;
			margin-top: 30px;
		}
		
		.div2, .div3, .div4, .div5 {
			margin-left: 1px;
		}
		
		.photo-div>div {
			width: 100px;
			height: 100px;
			background-image: url('/forest/image/userimg/backimg2.png'); 
			text-align: center;
			margin-bottom: 20px;
		}
		
		.photo-div>button {
			width: 100px;
			height: 30px;
			background: #16AAD8;
			color: white;
			border: none;
		}
		
		.photo-div>p {
			text-align: center;
			font-size: 17px;
			color: #828282;
			top: 0px;
			padding-bottom: 10px;
		}
		
		/*---체크리스트 영역----*/
		.checkList-area {
			height: 350px;
		}
		.checkList-table{
			width:700px;
			margin:0 auto;
		}
		.checkList-table td>p{
			color: #4B6AA7; 
			font-size: 17px;
			font-weight: bold;
		}
		.checkList-table td label{
			font-size:13px;
		}
		
		
		/*------등급영역------*/
		.rank-area{
			height:150px;
			
		}
		.rank-area>table{
			text-align:left;
			margin:0 auto;
			width: 700px;
		}
		.rank-area tr>td:nth-of-type(2n-1){
			width: 150px;
			text-align: right;
			font-weight: bold;
			font-size: 17px;
			color: #4B6AA7; 
		}
		.rank-area tr>td:nth-of-type(2n){
			width: 150px;
			text-align: right;
			font-size: 17px;
			color: black;
			
		}
		
		/*버튼영역*/
		.btn-area{
			height: 50px;
			text-align:center;
		}
		.btn-area>button:nth-of-type(1){
			margin-right:10px;
		}
		.btn-area>button:nth-last-of-type(1){
			margin-left:10px;
		}
		.btn-area>button{
			background: #6792DA;
			border-radius: 3px;
			color: white;
			border: none;
			height: 30px;
			cursor: pointer;
			width: 100px;
			
		}
		
		/*---------------------------1차검수모달---------------------------------------------*/
		
		.modal1 {
			display: none; 
			position: fixed; 
			z-index: 1; 
			left: 0;
			top: 0;
			width: 100%; 
			height: 100%; 
			overflow: auto; 
			background-color: rgb(0, 0, 0); 
			background-color: rgba(0, 0, 0, 0.4); 
		}
		
		/* Modal Content/Box */
		.modal-content1 {
			background-color: #fefefe;
			margin: 7% auto; 
			border: 1px solid #888;
			width: 800px; 
			height: 900px;
		}
		/* The Close Button */
		.close1 {
			color: white;
			float: right;
			font-size: 28px;
			font-weight: bold;
			padding-right: 10px;
		}
		
		.close1:hover, .close1:focus {
			color: black;
			text-decoration: none;
			cursor: pointer;
		}
		
		.top-title1 {
			background: #16AAD8;
			height: 50px;
			width: 100%;
		}
		
		.modal-content1 p {
			color: white;
			margin: 0px;
			padding-top: 15px;
			font-size: 17px;
		}
		
		/*매입불가 모달 본문*/
		.table-area1 {
			width: 700px;
			margin: 0 auto;
			
		}
		
		.table-area1>table {
			width: 700px;
			text-align: center;
			margin-top: 10px;
			border-collapse: collapse;
			font-size: 15px;
		}
		
		.table-area1 tr>td:nth-of-type(1) {
			width: 200px;
			background: #DADADA;
		}
		
		.table-area1 tr>td {
			border: 1px solid #828282;
		}
		
		/*사진 보기 */
		.photo-area1 {
			display: flex;
			height: 180px;
		}
		
		.photo-div1 {
			margin: 0 auto;
			margin-top: 5px;
			width: 100px;
			height: 100px;
		}
		
		.icon-img {
			width: 40px;
			height: 30px;
			margin-top: 30px;
		}
		
		.div2, .div3, .div4, .div5 {
			margin-left: 1px;
		}
		
		.photo-div1>div {
			width: 100px;
			height: 100px;
			background-image: url('/forest/image/userimg/backimg2.png'); 
			text-align: center;
			margin-bottom: 20px;
			cursor:pointer;
		}
		
/* 		.photo-div1>button {
			width: 100px;
			height: 30px;
			background: #16AAD8;
			color: white;
			border: none;
		} */
		
		.photo-div1>p {
			text-align: center;
			font-size: 17px;
			color: #828282;
			top: 0px;
			padding-bottom: 10px;
		}
		.text-area{
			width: 700px;
			height: 30px;
			margin: 0 auto;
			font-size: 15px;
			color: #828282;
		}
		/*등급부분*/
		.rank-area1{
			height:200px;
			
		}
		.rank-area1>table{
			text-align:left;
			margin:0 auto;
			width: 700px;
			
		}
 		.rank-area1 tr>td:nth-of-type(1){
			width: 200px;
			text-align: left;
			font-weight: bold;
			font-size: 17px;
			color: #4B6AA7;
		} 

		/*매입불가사유영역*/
		
		.reason-area1 {
			width: 700px;
			height: 150px;
			margin: 0 auto;
		}
		
		.reason-area1>p {
			color: black;
		}
		
		.modalBtn-area1 {
			height: 50px;
			text-align: center;
		}
		
		.modalBtn-area1>button {
			background: #6792DA;
			border-radius: 3px;
			border: none;
			height: 30px;
			color: white;
			width: 100px;
			margin-top: 10px;
			cursor: pointer;
		}
		
		.modalBtn-area1>button:nth-of-type(1) {
			margin-right: 10px;
		}
		
		.modalBtn-area1>button:nth-last-of-type(1) {
			margin-left: 10px;
		}
		/*---------------//매입불가모달---------------------------------------------------*/

</style>
</head>
<body onload="ready('매입 신청 관리', '매입관리', '매입 신청 관리');">

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
					<select style="height:25px;">
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
				&nbsp;&nbsp; <label>검색결과 : </label><label class="searchCount"></label>
				<label><%=listCountRequest %> 건</label>
			</div>
		</article>
		


		<article>
			<table class="resultTable">
				<thead>
					<tr>
						<th class="resultTableTh"><input type="checkbox"></th>
						<!-- <th class="resultTableTh"><label>번호</label></th> -->
						<th class="resultTableTh"><label>매입번호</label></th>
						<th class="resultTableTh"><label>아이디</label></th>
						<th class="resultTableTh"><label>상품명</label></th>
						<th class="resultTableTh"><label>세이프키</label></th>
						<th class="resultTableTh"><label>접수일</label></th>
						<th class="resultTableTh"><label>상태</label></th>
						<th class="resultTableTh"><label></label></th>
					</tr>
				</thead>
				<tbody>
					<% for(BuyInfo bi : list) { %>
					<tr>
						
						<td class="resultTableTd"><input type="checkbox"></td>
						<!-- <td class="resultTableTd"></td> -->
						<td class="resultTableTd"><%=bi.getBuyNo() %></td>
						<td class="resultTableTd"><%=bi.getUserId() %></td>
						<td class="resultTableTd"><%=bi.getBuyProductName() %></td>
						<td class="resultTableTd"><%=bi.getSafeKey() %></td>
						<td class="resultTableTd"><%=bi.getRequestDate() %></td>
						<td class="resultTableTd"><%=bi.getBuyStatus() %></td>
						<% if(bi.getBuyStatus().equals("1차검수신청")) { %>
							<td class="resultTableTd">
							<button id="rejectPopup" value="<%=bi.getBuyNo()%>" 
								onclick="modalclick1(this.value, '<%=bi.getUserName() %>','<%=bi.getUserId() %>'
								, '<%=bi.getBuyProductName() %>', '<%=bi.getExampleContent() %>','<%=bi.getSafeKey() %>'
								, '<%=bi.getGrade() %>', '<%=bi.getBuyPrice() %>');" >1차검수</button></td>
						<% } else if (bi.getBuyStatus().equals("인수완료")) { %>
							<td class="resultTableTd"><button id="requestBtn" value="<%=bi.getBuyNo()%>"
								onclick="modalclick2(this.value, '<%=bi.getUserName() %>' , '<%=bi.getUserNo() %>'
								,'<%=bi.getUserId() %>', '<%=bi.getGrade() %>', '<%=bi.getBuyPrice() %>'
								, '<%=bi.getBuyProductName() %>', '<%=bi.getExampleContent() %>', '<%=bi.getBuyProductNo() %>');" >2차검수</button></td>
						<% } else { %>
							<td class="resultTableTd"><button id="detailBtn" value="<%=bi.getBuyNo()%>" 
								onclick="detailBtn(this.value, '<%=bi.getUserName() %>');" >정보확인</button></td>
						<% } %>	
					</tr>
					<% } %>
					
				</tbody>
			</table>

		<!-- 페이징페이징 -->
		<div class="pagingArea" align="center">
			<button	onclick="location.href='<%=request.getContextPath()%>/selectRequestList.ad?currentPage=1'"><<</button>
			<%
				if (currentPage <= 1) {
			%>
			<button disabled><</button>
			<%
				} else {
			%>
			<button	onclick="location.href='<%=request.getContextPath()%>/selectRequestList.ad?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>
			<%
				for (int p = startPage; p <= endPage; p++) {
					if (p == currentPage) {
			%>
			<button disabled><%=p%></button>
			<% } else {	%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectRequestList.ad?currentPage=<%=p%>'"><%=p%></button>
			<%	 }
				}
			%>
			<%
				if (currentPage >= maxPage) {
			%>
			<button disabled>></button>
			<% } else { %>
			<button	onclick="location.href='<%=request.getContextPath()%>/selectRequestList.ad?currentPage=<%=currentPage + 1%>'">></button>
			<% } %>
			<button	onclick="location.href='<%=request.getContextPath()%>/selectRequestList.ad?currentPage=<%=maxPage%>'">>></button>
		</div>
		<!-- //페이징끝 -->
		
			<!---------------------------------1차검수!!!!!------------------------------- -->

		<!-- The Modal -->
		<div id="myModal1" class="modal1">

			<!-- Modal content -->
			<div class="modal-content1">
				<div class="top-title1">
					<span class="close1">&times;</span>
					<p style="padding-left: 20px;">매입신청 확인</p>
				</div>
				 
      			 
				<div class="table-area1" id="table-area1">
					<table>
						<thead>
							<tr>
								<td>아이디(이름)</td>
								<td id="table-content1"></td>
							</tr>
							<tr>
								<td>매입번호 / 상품명</td>
								<td id="table-content2"></td>
							</tr>
							<tr>
								<td>세이프키</td>
								<td id="table-content3"></td>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
				

				<!------------------------ 사진 확인 ------------------------>
				<div class="photo-area1">
					<div class="photo-div1 div1">
						<p>전면사진</p>
						<div>
							<img id="contentImg1" width="100" height="100">
						</div>
					</div>

					<div class="photo-div1 div2">
						<p>바닥사진</p>
						<div>
							<img id="contentImg2" width="100" height="100">
						</div>
					</div>

					<div class="photo-div1 div3">
						<p>좌측사진</p>
						<div>
							<img id="contentImg3" width="100" height="100">
						</div>
					</div>

					<div class="photo-div1 div4">
						<p>우측사진</p>
						<div>
							<img id="contentImg4" width="100" height="100">
						</div>
					</div>

					<div class="photo-div1 div5">
						<p>전체사진</p>
						<div>
							<img id="contentImg5" width="100" height="100">
						</div>
					</div>
				</div>
				<div class="text-area">* 사진을 누르면 원본 이미지를 볼 수 있습니다.</div>
				<div class="rank-area1">
					<table>
						<tr>
							<td><label>상태 등급 입력 :</label></td>
							<td id="grade"></td>
							
						</tr>
						<tr>
							<td><label>예상 견적 입력 : </label></td>
							
							<td id="price"></td>
						</tr>
						<tr>
							<td><label>견적 사유 : <br>(or 불가 사유) </label></td>
							
							<td colspan="4"><textarea id="reasonFirst" cols="80" rows="5" style="resize: none;" 
								placeholder="사유를 적어주세요." ></textarea></td>
						<tr>
					</table>
				</div>
				

				<div class="modalBtn-area1">
					<button id="firstRejectBtn">매입 불가</button>
					<button id="firstOkBtn">매입 진행</button>
				</div>

			</div>
		</div>
		<!-----------------------------//1차검수모달끝------------------------->
		
		<!-------------------------------- 2차검수 모달 !!!!!!!------------------------------- -->
		<div id="myModal" class="modal">
			<!-- Modal content -->
			
			<div class="modal-content">
				<div class="top-title">
					<span class="close">&times;</span>
					<p style="padding-left:20px;">매입신청 확인</p>
				</div>

				
				<div class="table-area1" id="table-area2">
					<table>
						<thead>
							<tr>
								<td>아이디(이름)</td>
								<td id="table2-content1"></td>
							</tr>
							<tr>
								<td>매입번호 / 상품명</td>
								<td id="table2-content2"></td>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
				
				<!-- 체크리스트 확인  -->
				<div class="checkList-area" >
					<table class="checkList-table">
						<tr>
							<td colspan="3"><p>1. 미개봉 / 미사용 제품인가요?</p></td>
						</tr>

						<tr>
							<td><input type="radio" name="checkList1" id="q1a1" value="101">
								<input type="hidden" value="600">
								<label for="q1a1">미개봉 : 박스를 개봉하지 않은 상품</label></td>
							<td><input type="radio" name="checkList1" id="q1a2" value="102">
								<input type="hidden" value="50">
								<label for="q1a2">미사용 : 개봉 후 사용한 적이 없는 상품</label></td>
							<td><input type="radio" name="checkList1" id="q1a3" value="103">
								<input type="hidden" value="30">
							    <label for="q1a3">사용한 적이 있는 상품</label></td>
							    
						</tr>

						<tr>
							<td colspan="3"><p>2. 구성품은 무엇이 있나요?</p></td>
						</tr>

						<tr>
							<td><input type="radio" name="checkList2" id="q2a1" value="201">
								<input type="hidden" value="100">	
								<label for="q2a1">모두 있습니다.</label></td>
							<td><input type="radio" name="checkList2" id="q2a2" value="202">
								<input type="hidden" value="50">
								<label for="q2a2">일부만 있습니다.</label></td>
							<td><input type="radio" name="checkList2" id="q2a3" value="203">
								<input type="hidden" value="1">
								<label for="q2a3">아무것도 없습니다.</label></td>
						</tr>

						<tr>
							<td colspan="3"><p>3. 작동상태는 어떤가요?</p></td>
						</tr>

						<tr>
							<td><input type="radio" name="checkList3" id="q3a1" value="301">
								<input type="hidden" value="100">
								<label for="q3a1">작동 이상 없습니다.</label></td>
							<td><input type="radio" name="checkList3" id="q3a2" value="302">
								<input type="hidden" value="50">
								<label for="q3a2">약간 문제가 있습니다.</label></td>
							<td><input type="radio" name="checkList3" id="q3a3" value="303">
								<input type="hidden" value="1">
								<label for="q3a3">작동하지 않습니다.</label></td>
						</tr>

						<tr>
							<td colspan="3"><p>4. 외관 상태는 어떤가요?</p></td>
						</tr>

						<tr>
							<td><input type="radio" name="checkList4" id="q4a1" value="401">
								<input type="hidden" value="100">
								<label for="q4a1">깔끔합니다.</label></td>
							<td><input type="radio" name="checkList4" id="q4a2" value="402">
								<input type="hidden" value="50">
								<label for="q4a2">생활기스가 있습니다.</label></td>
							<td><input type="radio" name="checkList4" id="q4a3" value="403">
								<input type="hidden" value="10">
								<label for="q4a3">부서진 곳이 있습니다.</label></td>
						</tr>

					</table>
					
					

				</div>
				<div class="rank-area">
					<table>
						<tr>
							<td><label>1차검수 등급 :</label></td>
							<td id="grade1"></td>
							<td><label>2차검수 등급 :</label></td>
							<td id="grade2"></td>
						</tr>
						<tr>
							<td><label>1차검수 금액 : </label></td>
							<td id="Quote1"></td>
							<td><label>2차검수 금액 : </label></td>
							<td id="Quote2"></td>
						</tr>

						<tr>
							<td><label>견적 사유 : </label></td>
							
							<td colspan="3"><textarea id="reasonSecond" cols="80" rows="3" style="resize: none;"
								placeholder="매입불가시 불가 사유를 적어주세요."></textarea></td>
						<tr>
					</table>
				</div>
				
				<div class="btn-area">
					<p style="color:black; margin-top:0px;"> * 매입 진행을 누르면 해당 포인트가 회원에게 지급됩니다.</p>
					<br>
					<button id="secondRejectBtn">매입 불가</button>
					<button id="secondOkBtn" type="submit">매입 진행</button>
				</div>

				
			</div>
		</div>
		<!---------------------- //2차검수!!신청확인 모달 끝------------------------------ -->


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
		
		//정보확인 팝업창
		function detailBtn(value, userId) {
			var buyNo = value;
			var userId = userId;
			console.log("buyNo?:" + buyNo);
			window.open("<%=request.getContextPath()%>/selectRequestDetail.ad?buyNo="+buyNo,
							"buyPop01_parent",
							"top=100,left=300,width=700,height=600,location=no,scrollbars=no,status=no,resizable=0,titlebar=no,menubar=no,directories=no");
		}
		
		//1차검수 모달-------------------------------------------------------------------
		var modal1 = document.getElementById('myModal1');
		var btn1 = document.getElementById("rejectPopup");
		var span1 = document.getElementsByClassName("close1")[0];
		var buyNoVal = "";
		
		function modalclick1(value, userName,userId, buyProductName, exampleContent, safeKey, grade, buyPrice){
			modal1.style.display = "block";
			buyNoVal = value;
			var userNameVal = userName;
			var userIdVal = userId;
			var buyProductNameVal = buyProductName;
			var safeKeyVal = safeKey;
			var gradeVal = grade;
			var buyPriceVal = buyPrice;
			
			$("#table-content1").text(userId + "(" + userNameVal + ")");
			$("#table-content2").text(buyNoVal + " / " + buyProductNameVal );
			$("#table-content3").text(safeKeyVal);
			
			
			//매입번호로 체크리스트 불러오기용 ajax
			$.ajax({
				url:"/forest/selectAjaxUserCheckList.ad",
				type: "post",
				data: {buyNoVal : buyNoVal},
				success: function(data){
					//console.log("매입신청data: " + data);
					
					//data를 가지고 화면상으로 테이블이 추가하기
					$tableBody = $("#table-area1 tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value) {
						
					console.log("value:" + value);
						var $tr = $("<tr>");
						var name1 = decodeURIComponent(decodeURI(value.questionContent).replace(/\+/g, " "));
						var name2 = decodeURIComponent(decodeURI(value.answerContent).replace(/\+/g, " "));
						
						var $qTd = $("<td>").text(name1);
						var $aTd = $("<td>").text(name2);

						$tr.append($qTd);
						$tr.append($aTd);
						$tableBody.append($tr);
						
					});
				},
				error: function(error){
					console.log("매입신error: " + error);
				}
			});
			
			
			
			//매입번호로 이용자가 올린 사진 불러오기
			$.ajax({
				url:"/forest/selectAjaxUserInsertPhoto.ad",
				type:"post",
				data:{buyNoVal : buyNoVal},
				success: function(data){
					//console.log("selectphotoajax data: " + data);
					
					var img1 = "";
					var img2 = "";
					var img3 = "";
					var img4 = ""; 
					
					for(var key in data){
						var	img1 = decodeURIComponent(data[0].changeName);
						var img2 = decodeURIComponent(data[1].changeName);
						var img3 = decodeURIComponent(data[2].changeName);
						var img4 = decodeURIComponent(data[3].changeName);
						var img5 = decodeURIComponent(data[4].changeName);
						
						
					}
					var location1 = "<%=request.getContextPath()%>/photo_uploadFiles/"+ img1;
					var location2 = "<%=request.getContextPath()%>/photo_uploadFiles/"+ img2;
					var location3 = "<%=request.getContextPath()%>/photo_uploadFiles/"+ img3;
					var location4 = "<%=request.getContextPath()%>/photo_uploadFiles/"+ img4;
					var location5 = "<%=request.getContextPath()%>/photo_uploadFiles/"+ img5;
					
					$("#contentImg1").attr("src", location1); 
					$("#contentImg2").attr("src", location2); 
					$("#contentImg3").attr("src", location3); 
					$("#contentImg4").attr("src", location4); 
					$("#contentImg5").attr("src", location5); 
					
					
					//이미지 원본 보기
					$("#contentImg1").click(function(){
						var img = new Image();
						img.src = location1;
						var img_width=img.width;
						var win_width=img.width+2;
						var img_height=img.height;
						var win=img.height+2;
						var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
						  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+location1+"' width='"+win_width+"'>");
					});
					$("#contentImg2").click(function(){
						var img = new Image();
						img.src = location2;
						var img_width=img.width;
						var win_width=img.width+2;
						var img_height=img.height;
						var win=img.height+2;
						var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
						  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+location2+"' width='"+win_width+"'>");
					});
					$("#contentImg3").click(function(){
						var img = new Image();
						img.src = location3;
						var img_width=img.width;
						var win_width=img.width+2;
						var img_height=img.height;
						var win=img.height+2;
						var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
						  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+location3+"' width='"+win_width+"'>");
					});
					$("#contentImg4").click(function(){
						var img = new Image();
						img.src = location4;
						var img_width=img.width;
						var win_width=img.width+2;
						var img_height=img.height;
						var win=img.height+2;
						var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
						  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+location4+"' width='"+win_width+"'>");
					});
					$("#contentImg5").click(function(){
						var img = new Image();
						img.src = location5;
						var img_width=img.width;
						var win_width=img.width+2;
						var img_height=img.height;
						var win=img.height+2;
						var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
						  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+location5+"' width='"+win_width+"'>");
					});

				},
				error: function(error){
					console.log("selectphotoaajax error: " + error);
				}
			});
			
			
			
			//등급 , 가격 자동 불러오기
			$("#grade").text(gradeVal + "급");
			$("#price").text(buyPriceVal + "원");
			
			
			$("#firstOkBtn").click(function(){
				//사유 값
				var reasonVal = $("#reasonFirst").val();
				console.log(reasonVal);  
				
				location.href = "<%=request.getContextPath()%>/updateFirstCheck.ad?buyNoVal=" + buyNoVal 
						+ "&reasonVal=" + reasonVal ;
				
			});
			
			$("#firstRejectBtn").click(function(){
				//사유 값
				var reasonVal = $("#reasonFirst").val();
				console.log(reasonVal);
				
				location.href = "<%=request.getContextPath()%>/updateFirstCheckReject.ad?reasonVal=" + reasonVal
						+ "&buyNoVal=" + buyNoVal;
			});
		}

		span1.onclick = function() {
			modal1.style.display = "none";
		}
		
		
		//2차검수 모달------------------------------------------------------------------
		var modal2 = document.getElementById('myModal');
		var requestBtn = document.getElementById("requestBtn");
		var closeBtn = document.getElementsByClassName("close")[0];
		var answer1 = "";
		var answer2 = "";
		var answer3 = "";
		var answer4 = "";
		var answer5 = "";
		var answer6 = "";
		var gradeVal2 = "";
		var pointVal = "";
		var buyProductNo = "";
		var rank = "";
		var reasonVal2 = "";
		
		
		//점수
		var score1 = "";
		var score2 = "";
		var score3 = "";
		var score4 = "";
		
		function modalclick2(value, userName, userNo, userId, grade, buyPrice, buyProductName, exampleContent, buyProductNo){
			modal2.style.display = "block";
			var buyNoVal = value;
			var userNameVal = userName;
			var userNo = userNo;
			var userId = userId;
			var grade = grade;
			var buyPrice = buyPrice;
			var buyProductName = buyProductName;
			var exampleContent = exampleContent;
			buyProductNo = buyProductNo;
			
			
			console.log("userName: " + userNameVal );
			console.log("userNo: " + userNo);
			
			$("#table2-content1").text(userId + "(" + userNameVal + ")");
			$("#table2-content2").text(buyNoVal + " / " + buyProductName );
			
			//1차등급, 가격 불러오기
			$("#grade1").text(grade + "급");
			$("#Quote1").text(buyPrice + "원");
			
			//매입번호로 이용자 체크리스트 불러오기용 ajax
			$.ajax({
				url:"/forest/selectAjaxUserCheckList.ad",
				type: "post",
				data: {buyNoVal : buyNoVal},
				success: function(data){
					
					//data를 가지고 화면상으로 테이블이 추가하기
					$tableBody = $("#table-area2 tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value) {
						
					console.log("value:" + value);
						var $tr = $("<tr>");
						var name1 = decodeURIComponent(decodeURI(value.questionContent).replace(/\+/g, " "));
						var name2 = decodeURIComponent(decodeURI(value.answerContent).replace(/\+/g, " "));
						
						var $qTd = $("<td>").text(name1);
						var $aTd = $("<td>").text(name2);

						$tr.append($qTd);
						$tr.append($aTd);
						$tableBody.append($tr);
						
					});
				},
				error: function(error){
					console.log("매입신error: " + error);
				}
			});
			
			//체크리스트 값 넘기기
			$("input:radio[name=checkList1]").click(function(){
				$("input:radio[name=checkList1]").filter(function(){
					if($(this).is(":checked")){
						answer1 = $(this).val();
						score1 = $(this).parent().children().eq(1).val();
						console.log("answer1 " + answer1);
						console.log("score1 : " + score1);
					}
				});
			});
			$("input:radio[name=checkList2]").click(function(){
				$("input:radio[name=checkList2]").filter(function(){
					if($(this).is(":checked")){
						answer2 = $(this).val();
						score2 = $(this).parent().children().eq(1).val();
						console.log("answer2 " + answer2);
					}
				});
			});
			$("input:radio[name=checkList3]").click(function(){
				$("input:radio[name=checkList3]").filter(function(){
					if($(this).is(":checked")){
						answer3 = $(this).val();
						score3 = $(this).parent().children().eq(1).val();
						console.log("answer3 " + answer3);
					}
				});
			});
			$("input:radio[name=checkList4]").click(function(){
				$("input:radio[name=checkList4]").filter(function(){
					if($(this).is(":checked")){
						answer4 = $(this).val();
						score4 = $(this).parent().children().eq(1).val();
						console.log("answer4 " + answer4);
					}
				});
				
				var score = Number(score1) + Number(score2) + Number(score3) + Number(score4);
				console.log("score:" + score);
				
				//등급
				if(score >= 350){
					gradeVal2 = "S급";
					rank = "S";
				} else if(score < 350 && score >= 250){
					gradeVal2 = "A급";
					rank = "A";
				} else if(score < 250 && score >= 161){
					gradeVal2 = "B급";
					rank = "B";
				} else {
					gradeVal2 = "매입불가";
					rank = 0;
				}
				$("#grade2").text(gradeVal2);
				
				console.log("rank : " + rank);
				
				$.ajax({
					url: "/forest/B_selectbuypriceservlet",
					type: "post",
					data: {
						rank : rank,
						buyProductNo : buyProductNo
					},
					success: function(data){
						console.log(data)
						pointVal = data;
						 $("#Quote2").text(pointVal + "원");
						
						
					},
					error: function(error){
						
					}
				});
				
			});
			
			
			
			//매입진행 버튼시 포인트랑 사유 넘어가기
			$("#secondOkBtn").click(function(){
				reasonVal2 = $("#reasonSecond").val();
				
				location.href = "<%=request.getContextPath()%>/updateSecondCheck.ad?buyNoVal=" + buyNoVal + 
						"&answer1=" + answer1 + "&answer2=" + answer2 + "&answer3=" + answer3 +
						"&answer4=" + answer4 + "&reasonVal=" + reasonVal2 + "&userNo=" + userNo +
						"&userName=" + userNameVal + "&pointVal=" + pointVal + "&rank=" + rank;
				
			});
			//매입불가 버튼시 사유만 넘어가기
			$("#secondRejectBtn").click(function(){
				reasonVal2 = $("#reasonSecond").val();
				
				
				location.href = "<%=request.getContextPath()%>/updateSecondRejectCheck.ad?buyNoVal=" + buyNoVal +
						"&reasonVal=" + reasonVal2;
			});
			
			
			
			
				
			
		}

		closeBtn.onclick = function() {
			modal2.style.display = "none";
		}
		
		
		
		
		
	</script>

	<%@ include file="../common/C_menubar2.jsp"%>
</body>
</html>