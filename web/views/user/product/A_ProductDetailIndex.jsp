<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.forest.product.model.vo.*"%>

<%
	A_ProductInfo proInfo = (A_ProductInfo) request.getAttribute("proInfo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>

<style>
.productBody {
	margin: 0 auto;
	width: 80%;
	height: 700px;
}

.displayDiv {
	float: left;
	width: 50%;
	height: 600px;
}

td {
	padding: 0px;
}

.labelBasicStyle {
	font-weight: 600;
}

#productName {
	font-weight: 600;
	font-size: 20px;
}

.bar {
	background-color: #3D3C3C;
	width: 100%;
	height: 4px;
	margin-top: 15px;
	margin-bottom: 15px;
}

.bar_thin {
	background-color: #3D3C3C;
	width: 100%;
	height: 2px;
	margin-top: 15px;
	margin-bottom: 15px;
}

#price {
	font-weight: 600;
	font-size: 20px;
}

select[name=priceChoice] {
	width: 100%;
	height: 30px;
}

.btnDiv {
	width: 95%;
	height: 40px;
	margin: 0 auto;
	text-align: center;
	line-height: 40px;
}

#basketBtn {
	border: 2px solid #6E00AB;
}

#buyBtn {
	background: #6E00AB;
}

#rentalText {
	color: white;
}

#mainImgDiv {
	width: 90%;
	height: 100%;
	text-align: center;
}

.subImgDiv {
	margin: 0 auto;
	width: 23%;
	display: inline-block;
	height: 100%;
}

.subTitle {
	text-align: center;
	font-size: 20px;
	font-weight: 600;
}

.InfoDiv {
	margin: 0 auto;
	width: 90%;
	height: 700px;
	background: white;
	margin-bottom: 50px;
}

.hideDiv {
	display: none;
}

#categoryName {
	margin-top: 50px;
	padding-left: 25px;
}

.wishImg {
	width: 45px;
	height: 45px;
}

.productStatusIcon {
	width: 70px;
	height: 70px;
}

.iconDiv {
	width: 80px;
	height: 100px;
	text-align: center;
}

.iconName {
	text-align: center;
	font-weight: 700;
}

.productInfoTd {
	width: 150px;
}

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
	margin: 15% auto; /* 15% from the top and centered */
	padding: 0px;
	border: 1px solid #888;
	width: 500px; /* Could be more or less, depending on screen size */
	height: 250px;
}

.top-title {
	height: 50px;
	width: 500px;	
	background: #6E00AB;
}

#modal-body-div {
	height: 200px;
	width: 500px;
}

.modal-body {
	width: 500px;
	height: 100px;
	text-align: center;
}

#modal-title-p {
	margin: 0;
	text-align: left;
	margin-left: 15px;
	font-size: 25px;
	color: white;
	font-family: sans-serif;
	height: 50px;
	line-height: 50px;
	width: 500px;
}

#modal-body-text {
	line-height: 100px;
	text-align: center;
	font-size: 20px;
	font-weight: 800;
}
.modal_button{
	width: 150px;
	height: 50px;
	line-height: 50px;
	text-align: center;
	color: white;
	background: #6E00AB;
	margin:0 auto;
	display: inline-block;
}

#go_shopping, #go_back{ 
	background: white;
	color: black;
	border: #6E00AB 1px solid;
}
#purchaseBlock{
	line-height: 45px;
	height: 45px;
	background: lightgray;
	color: white;
	font-size: 18px;
	text-align: center;
}

</style>


</head>
<body>

	<%@ include file="/views/user/common/B_UserMainHeader.jsp"%>

	<div class="productBody">
		<div>
			<h4 id="categoryName"><%=proInfo.getCategoryName()%></h4>
		</div>
		<div class="displayDiv">
			<table style="width: 100%; height: 100%;">
				<tr>
					<td colspan="4" style="height: 75%;">
						<div id="mainImgDiv" style="margin: 0 auto;">
							<img id="mainProductImg" width="430px" height="430px" src="">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4" style="height: 5%;"></td>
				</tr>
				<tr>
					<td>
						<div style="width: 90%; height: 100%; margin: 0 auto;">
							<div id="subImg1" class="subImgDiv">
								<img id="subProductImg1" onclick="clickImg(this);" width="115px" height="115px" src="">
							</div>
							<div id="subImg2" class="subImgDiv">
								<img id="subProductImg2" onclick="clickImg(this);" width="115px" height="115px" src="">
							</div>
							<div id="subImg3" class="subImgDiv">
								<img id="subProductImg3" onclick="clickImg(this);" width="115px" height="115px" src="">
							</div>
							<div id="subImg4" class="subImgDiv">
								<img id="subProductImg4" onclick="clickImg(this);" width="115px" height="115px" src="">
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="displayDiv">
			<table style="width: 100%; height: 100%;">
				<tr>
					<td colspan="3"><div class="bar"></div></td>
				</tr>
				<tr>
					<td colspan="3"><label class="labelBasicStyle"
						id="manufacturer"><%=proInfo.getManufacturerName()%></label></td>
				</tr>
				<tr height="4px"></tr>
				<tr>
					<td colspan="3"><label id="productName"><%=proInfo.getProductName()%></label></td>
				</tr>
				<tr height="4px"></tr>
				<tr>
					<td colspan="3"><label class="labelBasicStyle" id="pid">상품번호
							: <%=proInfo.getProductNo()%></label></td>
				</tr>
				<tr>
					<td colspan="3"><div class="bar"></div></td>
				</tr>
				<tr height="50px"></tr>
				<tr>
					<td colspan="3"><label id="price">월 <%=proInfo.getRentalPrice()%>
							원
					</label></td>
				</tr>
				<tr height="60px"></tr>
				<tr>
					<td colspan="3"><label style="font-weight: 600;">대여 기간
							선택</label></td>
				</tr>
				<tr>
					<td colspan="3"><select id="priceChoice" name="priceChoice">
							<option value="1">1개월(+ 20,000)</option>
							<option value="2">2개월</option>
							<option value="3">3개월</option>
							<option value="6">6개월</option>
							<option value="<%=proInfo.getAcceptanceMonth()%>">인수형(<%=proInfo.getAcceptanceMonth()%>개월)
							</option>
					</select></td>
				</tr>
				<tr height="50px"></tr>
				<tr>
					<td colspan="3"><label class="labelBasicStyle">최대 대여
							기간 : <%=proInfo.getAcceptanceMonth()%>개월
					</label></td>
				</tr>
				<tr height="50px"></tr>
				<tr>
					<td colspan="3"><div class="bar_thin"></div></td>
				</tr>
				<tr id="not_rental_tr">
					<td class="btnAlign" style="width: 10%;">
						<div class="btnDiv" id="wishBtn">
							<img class="wishImg"
								src="<%=request.getContextPath()%>/image/userimg/wish1.png">
						</div>
					</td>
					<td class="btnAlign" style="width: 45%;">
						<div class="btnDiv" id="basketBtn" onclick="basketClick();">
							<label id="basketText">장바구니</label>
						</div>
					</td>
					<td class="btnAlign" style="width: 45%;">
						<div class="btnDiv" id="buyBtn">
							<label id="rentalText">대여하기</label>
						</div>
						<div id="purchaseBlock">
							<label id="rentalText">렌탈중</label>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div height="40px">
		<table style="width: 100%;">
			<tr height="10px;">
				<td colspan="4"><div class="bar_thin"></div></td>
			</tr>
			<tr height="20px;">
				<td id="productTd" class="subTitle">상품정보</td>
				<td id="warningTd" class="subTitle">유의사항</td>
				<td id="deliveryTd" class="subTitle">배송정보</td>
				<td id="reviewTd" class="subTitle">이용후기</td>
			</tr>
			<tr height="10px;">
				<td colspan="4"><div class="bar_thin"></div></td>
			</tr>
		</table>
	</div>
	<div id="productDiv" class="InfoDiv">
		<div id="productDivInfo">
			<div style="font-size: 30px;">
				<div
					style="width: 10px; height: 40px; background-color: #6E00AB; float: left;"></div>
				상품 정보
			</div>
			<table>
				<tr>
					<td class="iconDiv productInfoTd"><img
						class="productStatusIcon"
						src="<%=request.getContextPath()%>/image/userimg/icon1.png">
					</td>
					<td class="iconDiv productInfoTd"><img
						class="productStatusIcon"
						src="<%=request.getContextPath()%>/image/userimg/icon2.png">
					</td>
					<td class="iconDiv productInfoTd"><img
						class="productStatusIcon" id="gradeImg" src=""></td>
					<td class="iconDiv productInfoTd"><img
						class="productStatusIcon"
						src="<%=request.getContextPath()%>/image/userimg/icon3.png">
					</td>
					<td class="iconDiv productInfoTd"><img
						class="productStatusIcon"
						src="<%=request.getContextPath()%>/image/userimg/icon4.png">
					</td>
				</tr>
				<tr>
					<td class="iconName productInfoTd" id="openCloseText">미개봉</td>
					<td class="iconName productInfoTd" id="usedText">사용감 업음</td>
					<td class="iconName productInfoTd" id="gradeText">S등급</td>
					<td class="iconName productInfoTd" id="crackText">깨짐 없음</td>
					<td class="iconName productInfoTd" id="repairText">수리내역 없 음</td>
				</tr>

			</table>

		</div>
		<hr
			style="margin-top: 40px; margin-bottom: 40px; border: solid 1px gray;">
		<div id="productDivSpec">
			<div style="font-size: 30px; margin-bottom: 20px;">
				<div
					style="width: 10px; height: 40px; background-color: #6E00AB; float: left;"></div>
				제품 사양
			</div>
			<div id="proSpecInfo"></div>
		</div>
	</div>
	<div id="warningDiv" class="InfoDiv hideDiv">
		<div id="productDivInfo">
			<div style="font-size: 30px;">
				<div
					style="width: 10px; height: 40px; background-color: #6E00AB; float: left;"></div>
				유의사항
			</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				* 계약기간 동안 제품의 소유권은 (주)중고구마에 있습니다.<br> * 무단으로 타인 양도 / 재판매 등을 할
				시에 '법적조치'를 취하게 됩니다.
			</div>
			<hr style="height: 1px; background: black; margin-top: 30px;">
			<div style="font-size: 20px; font-weight: 800; margin-top: 30px;">교환/반품
				안내</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				상품 수령일로부터 7일 이내 반품 가능합니다<br> * 상품 하자의 경우에도 기간이 경과하면 환불이 불가합니다.<br>
				* 고객 변심의 경우 왕복 택배비 포함 대여일수만큼 차감되어 환불이 진행 됩니다.<br> * 도서 산간 지역 추가
				운임 발생됩니다.<br> * 단, 7일 이내라도 상품 훼손된 경우에 전액 환불 어렵습니다.<br> 상품
				문의의 경우 화면 우측 하단에 1:1 문의를 통해 문의주시기 바랍니다.
			</div>
			<div style="font-size: 20px; font-weight: 800; margin-top: 30px;">상품
				하자시 대여 후 7일 이내 환불 가능</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				상품 파손이나, 훼손의 경우 등에도 7일 이내에 연락을 주셔야 환불이 가능합니다.<br>
			</div>
			<div style="font-size: 20px; font-weight: 800; margin-top: 30px;">실제
				상품과 색상 차이</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				상품의 색상은 실제와 다소 차이가 있을 수 있습니다.<br>
			</div>
			<div style="font-size: 20px; font-weight: 800; margin-top: 30px;">사용
				시 고장의 경우</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				대여 기간 중 상품이 고장되서 사용이 불가능 할 경우, 해당 상품을 구입하셔야 합니다. <br> 동일한 상품의
				재고가 있을 경우, 동일한 상품으로 맞교환하여 대여 기간동안 사용 가능하며,<br> 동일 상품이 없을 경우, 유사
				상품 으로 맞교환 드립니다.<br> 사용 시 고장의 경우 마이페이지>1:1문의를 통해 접수 부탁 드립니다.
			</div>
			<div style="width: 100%; height: 100px;"></div>
		</div>

	</div>
	<div id="deliveryDiv" class="InfoDiv hideDiv">
		<div id="productDivInfo">
			<div style="font-size: 30px;">
				<div
					style="width: 10px; height: 40px; background-color: #6E00AB; float: left;"></div>
				배송정보
			</div>
			<div style="width: 100%; height: 30px;"></div>

			<hr style="height: 1px; background: black; margin-top: 30px;">
			<div style="font-size: 20px; font-weight: 800; margin-top: 30px;">배송
				방법</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				오전 11시 이전 주문시 당일 상품 준비 및 출고<br> 오전 11시 이후 주문시 익일 상품 준비 및 출고<br>
				구매순 순차 배송, 공휴일/주말 제외 입니다.<br>
			</div>
			<div style="font-size: 20px; font-weight: 800; margin-top: 30px;">배송
				비용</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				50,000 이상 시 무료 배송<br> 50,000 미만 시, 선불 2500원
			</div>
			<div style="font-size: 20px; font-weight: 800; margin-top: 30px;">추가
				비용</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				도서산간 및 일부 지역 추가 비용 발생<br>
			</div>
			<div style="font-size: 20px; font-weight: 800; margin-top: 30px;">택배사</div>
			<div style="width: 100%; height: 30px;"></div>
			<div style="font-size: 15px; font-weight: 700; margin-left: 15px;">
				CJ대한통운<br> 우체국<br> 로젠
			</div>
		</div>
	</div>
	<div id="reviewDiv" class="InfoDiv hideDiv">review</div>

	<!-- 장바구니 성공 확인 모달 -->
	<div id="basketOn" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<div class="top-title">
				<p id="modal-title-p">장바구니</p>
			</div>
			<div id="modal-body-div">
				<div id="modal-body-text" class="modal-body">장바구니에 담겼습니다</div>
				<div id="modal-body-button" class="modal-body">					
					<div id="go_shopping" class="modal_button">계속 쇼핑하기</div>
					<div id="go_basket" class="modal_button">장바구니로</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 장바구니 실패 확인 모달 -->
	<div id="basketReject" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<div class="top-title">
				<p id="modal-title-p">장바구니</p>
			</div>
			<div id="modal-body-div">
				<div id="modal-body-text" class="modal-body">장바구니에 상품이 존재합니다</div>
				<div id="modal-body-button" class="modal-body">
					<div id="go_back" class="modal_button">돌아가기</div>
					<div id="renew_basket" class="modal_button">갱신하기</div>
				</div>				
			</div>
		</div>
	</div>



	<script>
	
	 function clickImg(id){
		 var img = $(id).attr("src");
		 //console.log(img);
		 
		 $("#mainProductImg").attr("src", img);
	 } 
	
	$(function(){
		var proNo = "<%=proInfo.getProductNo()%>";
		
		<%if (loginMember != null) {%>
			var userNo = "<%=loginMember.getUserNo()%>";
		<%}%>
		
		var rentalStatus = "<%= proInfo.getRentalStatus() %>";
		
		if(rentalStatus == 'Y'){	
			$("#buyBtn").hide();
			$("#purchaseBlock").show();					
		} else {
			$("#buyBtn").show();
			$("#purchaseBlock").hide();	
		}
				
		//console.log("제품번호 : " + proNo);
		//사진 불러오기
		$.ajax({
			url: "<%=request.getContextPath()%>/selectOneAttachment",
			type: "get",
			data: {productNo: proNo},
			success: function(data){
				//console.log(data);
				var mainImg = data[0].cngPic;
				var subImg1 = data[1].cngPic;
				var subImg2 = data[2].cngPic;
				var subImg3 = data[3].cngPic;
				
				//console.log(mainImg);
				if(subImg1 == null){
					//console.log(subImg1);
					subImg1 = "emptyPic.png";
				}
				if(subImg2 == null){
					//console.log(subImg1);
					subImg2 = "emptyPic.png";
				}		
				if(subImg3 == null){
					//console.log(subImg1);
					subImg3 = "emptyPic.png";
				}	

				
				$("#mainProductImg").attr("src", "<%=request.getContextPath()%>/image/productImg/" + mainImg);				
				$("#subProductImg1").attr("src", "<%=request.getContextPath()%>/image/productImg/" + mainImg);
				$("#subProductImg2").attr("src", "<%=request.getContextPath()%>/image/productImg/" + subImg1);
				$("#subProductImg3").attr("src", "<%=request.getContextPath()%>/image/productImg/" + subImg2);
				$("#subProductImg4").attr("src", "<%=request.getContextPath()%>/image/productImg/" + subImg3);
			},
			error: function(status){
				console.log(status);
			}
		});
		
		
		
		//제품 상세내역 불러와서 나눠서 저장
		var proInfo = "<%=proInfo.getProductDetail().replaceAll(System.getProperty("line.separator"), "|")%>".split("&");
		
		//제품 상세스펙 명시하는 부분
		var proSpec = proInfo[4].split("|");		
		for(var i = 0 ; i < proSpec.length; i++){
			var $span = "<span style='margin-left:15px; margin-top:15px; font-weight:800;'> " 
						+ proSpec[i] + "</span><br>";
			$("#proSpecInfo").append($span);
		}
		
		
		//console.log(proInfo[0]);	//개봉여부 - A: 개봉, B: 미개봉
		//console.log(proInfo[1]);	//사용감 - A: 적음, B: 보통, C: 많음 
		//console.log(proInfo[2]);	//파손여부 - A: 적음, B: 보통, C: 많음
		//console.log(proInfo[3]);	//수리여부 - A: 적음, B: 보통, C: 많음
		
		//개봉, 미개봉 명시 
		if(proInfo[0] == "A"){
			$("#openCloseText").text("미개봉");
		}else {
			$("#openCloseText").text("개봉");
		}
		
		//사용감
		if(proInfo[1] == "A"){
			$("#usedText").text("사용감 적음");
		}else if(proInfo[1] == "B"){
			$("#usedText").text("사용감 보통");
		}else{
			$("#usedText").text("사용감 많음");
		}
		
		//파손여부
		if(proInfo[2] == "A"){
			$("#crackText").text("파손 적음");
		}else if(proInfo[2] == "B"){
			$("#crackText").text("파손 보통");
		}else{
			$("#crackText").text("파손 많음");
		}
		
		//수리여부
		if(proInfo[3] == "A"){
			$("#repairText").text("수리횟수 적음");
		}else if(proInfo[3] == "B"){
			$("#repairText").text("수리횟수 보통");
		}else{
			$("#repairText").text("수리횟수 많음");
		}
				
		//등급에 따라 이미지와 등급명 명시
		var gradeImg = "";
		if("<%=proInfo.getGrade()%>" == "S"){
			//console.log('s');
			gradeImg = "<%=request.getContextPath()%>/image/userimg/sicon.png";
			$("#gradeText").html("S등급");
			
		} else if("<%=proInfo.getGrade()%>" == "A") {
			//console.log('a');
			gradeImg = "<%=request.getContextPath()%>/image/userimg/aicon.png";	
			$("#gradeText").html("A등급");
		} else {
			//console.log('b');
			gradeImg = "<%=request.getContextPath()%>/image/userimg/bicon.png";	
			$("#gradeText").html("B등급");
		}
		$("#gradeImg").attr("src", gradeImg);
			

			$("#productTd").click(function() {
				$("#productDiv").show();
				$("#warningDiv").hide();
				$("#deliveryDiv").hide();
				$("#reviewDiv").hide();
			});
			$("#warningTd").click(function() {
				$("#productDiv").hide();
				$("#warningDiv").show();
				$("#deliveryDiv").hide();
				$("#reviewDiv").hide();
			});
			$("#deliveryTd").click(function() {
				$("#productDiv").hide();
				$("#warningDiv").hide();
				$("#deliveryDiv").show();
				$("#reviewDiv").hide();
			});
			$("#reviewTd").click(function() {
				$("#productDiv").hide();
				$("#warningDiv").hide();
				$("#deliveryDiv").hide();
				$("#reviewDiv").show();
			});
			$("#questionTd").click(function() {
				$("#productDiv").hide();
				$("#warningDiv").hide();
				$("#deliveryDiv").hide();
				$("#reviewDiv").hide();
			});
			
			
			$("#buyBtn").click(function(){
	               var productNo = '<%=proInfo.getProductNo()%>';
	               var month = $("#priceChoice option:selected").val();
	               var price = '<%=proInfo.getRentalPrice()%>';
	               var num = "1";
	               var productName = '<%=proInfo.getProductName()%>';
	               
	               location.href="<%=request.getContextPath()%>/payment.or?productNo="
	                     +productNo+"&month="+month+"&price="+price+"&num="+num+"&productName="+productName;
	        });
			
			<%if (loginMember != null) {%>
				//회원이 이미 가지고 있는 위시리스트인지 확인
				$.ajax({
					url: "<%=request.getContextPath()%>/selectWish",
					type: "get",
					data: {proNo : proNo,
						   userNo : userNo },
					success: function(data){
						//console.log(data.length);
						
						for(key in data){
							var wish = data[key];
							if(wish.proNo == "<%=proInfo.getProductNo()%>"){
								//고객의 위시리스트에 담겨 있으면 채워진 하트 표시
								$(".wishImg").attr("src", "<%=request.getContextPath()%>/image/userimg/wish2.png");
								wishInOut = 1;
							}
						}				
					},
					error: function(status){
						console.log(status);
					}
				});

			<%}%>			
		});
	
	
			//위시리스트 버튼 기능
			var wishInOut = 0;
			$("#wishBtn").click(function(){
				
				var proNo = "<%=proInfo.getProductNo()%>";
				<%if (loginMember != null) {%>
				var userNo = "<%=loginMember.getUserNo()%>";
				<%}%>
				
				//console.log("위시 버튼 눌림");
				var wishNo = "<%=request.getContextPath()%>/image/userimg/wish1.png";
				var wishYes = "<%=request.getContextPath()%>/image/userimg/wish2.png";
				
			
				<%if (loginMember != null) {%>
					if( wishInOut == 0 ){
						
						console.log("추가하기 " + wishInOut);
						$.ajax({
							url: "<%=request.getContextPath()%>/insertWishList",
							type: "get",
							data: {proNo : proNo,
								   userNo : userNo },
							success: function(data){
								//console.log(data);
								alert("위시리스트에 상품을 추가했습니다.");
							},
							error: function(status){
								console.log(status);
							}
						});					
						$(".wishImg").attr("src", "<%=request.getContextPath()%>/image/userimg/wish2.png");
						wishInOut = 1;
					} else {
						
						console.log("빼기 " + wishInOut);
						$.ajax({
							url: "<%=request.getContextPath()%>/deleteWishList",
							type: "get",
							data: {proNo : proNo,
								   userNo : userNo },
							success: function(data){
								//console.log(data);
								alert("위시리스트에 상품을 삭제했습니다.");
							},
							error: function(status){
								console.log(status);
							}
						});					
						$(".wishImg").attr("src", "<%=request.getContextPath()%>/image/userimg/wish1.png");
								wishInOut = 0;
							}
				<%} else {%>
					alert("로그인을 먼저 해주세요");
				<%}%>
			});
			
			
			
			function basketClick(){
				
				var proNo = "<%=proInfo.getProductNo()%>";
				<%if (loginMember != null) {%>
					var userNo = "<%=loginMember.getUserNo()%>";
				<%} else {%>
					alert("로그인을 먼저 하세요");
				<%}%>
				 var month = $("#priceChoice option:selected").val();
				 var price = '<%=proInfo.getRentalPrice()%>';
				 
				 if(month == '1' || month == '2' || month == '3' || month == '6'){
					 //인수형 아님
					 var takeOver = 'N';	 
				 } else {
					 //인수형
					 var takeOver = 'Y';
				 }
				 
				//console.log("장바구니");
				/* RENTAL_NO	VARCHAR2(10 BYTE)
				PRODUCT_NO	VARCHAR2(100 BYTE)
				USER_NO	VARCHAR2(10 BYTE)
				EXPIRY_DATE	DATE
				START_DATE	DATE
				RENTAL_PRICE	VARCHAR2(10 BYTE)
				TAKE_OVER	VARCHAR2(10 BYTE) */
				$.ajax({
					url: "<%=request.getContextPath()%>/insertBasket",
				type : "get",
				data : {
					proNo : proNo,
					userNo : userNo,
					month : month,
					price : price,
					takeOver : takeOver
				},
				success : function(data) {
					if (data > 0) {

						//alert("장바구니에 추가되었습니다");
						var basketOn = document.getElementById('basketOn');
						basketOn.style.display = "block";
						
						//장바구니 아이콘 변경

					} else {

						//alert("장바구니에 상품이 존재합니다.");
						var basketReject = document.getElementById('basketReject');
						basketReject.style.display = "block";

					}
				},
				error : function(status) {
					console.log(status);
				}
			});

		}
	</script>

	<script>
		$(function() {
			// Get the modal
			var basketOn = document.getElementById('basketOn');
			
			var basketReject = document.getElementById('basketReject');

			var goShopping = document.getElementById('go_shopping');
			
			var goBasket = document.getElementById('go_basket');
			
			var goBack = document.getElementById('go_back');
			
			var renewBasket = document.getElementById('renew_basket');
			
			goShopping.onclick = function() {
				basketOn.style.display = "none";				
			}
			
			goBack.onclick = function() {
				basketReject.style.display = "none";				
			}
			
			goBasket.onclick = function() {
				location.href="<%= request.getContextPath()%>/views/user/mypage/A_MyPageSection_shoppingBasket.jsp";
			}
			
			renewBasket.onclick = function(){
				
				var proNo = "<%=proInfo.getProductNo()%>";
				<%if (loginMember != null) {%>
					var userNo = "<%=loginMember.getUserNo()%>";
				<%} else {%>
					alert("로그인을 먼저 하세요");
				<%}%>
				
				 var month = $("#priceChoice option:selected").val();
				 var price = '<%=proInfo.getRentalPrice()%>';
				 
				 if(month == '1' || month == '2' || month == '3' || month == '6'){
					 //인수형 아님
					 var takeOver = 'N';	 
				 } else {
					 //인수형
					 var takeOver = 'Y';
				 }
				 
				
				
				$.ajax({
					url: "<%=request.getContextPath()%>/updateBasket",
				type : "get",
				data : {
					proNo : proNo,
					userNo : userNo,
					month : month,
					price : price,
					takeOver : takeOver
				},
				success : function(data) {
					if (data > 0) {
						alert("장바구니가 갱신되었습니다");
						basketReject.style.display = "none";
					}
				},
				error : function(status) {
					console.log(status);
				}
			});
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				if (event.target == basketOn) {
					basketOn.style.display = "none";
				}
				if (event.target == basketReject) {
					basketReject.style.display = "none";
				}
			}
		});
	</script>

	<%@ include file="/views/user/common/B_UserMainFooter.jsp"%>

</body>
</html>