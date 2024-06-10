<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
/*--------매입메인---------*/
#section {
	width: 600px;
	height: 800px;
	margin: 0 auto;
}

#section>h3 {
	margin-top: 80px;
	margin-bottom: 30px;
	margin-left: 10px;
}

.buymain-table {
	width: 600px;
	height: 500px;
}

.buy-icon[type=image] {
	width: 78px;
	height: 80px;
}

.icon-td {
	width: 90px;
	text-align: center;
}

.td-title {
	font-size: 18px;
	color: #6E00AB;
	margin: 0;
	font-weight: bold;
	height: 20px;
}
.td-title>p{
	margin-bottom: 0px;
	margin-top: 10px;
}

.buymain-table td {
	margin-top: 0px;
	margin-bottom: 0px;
	padding-top: 0px;
	padding-bottom: 0px;
}

.buymain-table>tr {
	height: 80px;
}

.buymain-table p:nth-child(2) {
	font-size: 12px;
	color: #828282;
}

.buymain-table tr:nth-of-type(2n)>td {
	border-bottom: 1px solid darkgrey;
}
.buymain-table tr:nth-of-type(2n-1)>td:nth-last-of-type(1){
	padding-bottom: 0px;
}

.buymain-table tr button {
	background: #6E00AB;
	color: white;
	border: none;
	/* border: 1px solid #6E00AB; */
	cursor: pointer;
	height: 30px;
	margin-bottom: 10px;
}

/*매입신청버튼*/
.buymain-btn {
	width: 100%;
	text-align: center;
	margin-top: 70px;
}

.buymain-btn>button {
	width: 130px;
	height: 50px;
	background: #6E00AB;
	color: white;
	border: none;
	cursor: pointer;
}

/*--------------------모달------------------------*/
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
	height: 700px;
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
.content-area{
	text-align:center;
}
.howtoImg{
	width: 600px;
	height: 550px;
}

.modal-btn{
	text-align: center;
}
.modal-btn>button{
	background: #6E00AB;
	border-radius: 3px;
	border: none;
	height: 30px;
	color: white;
	width: 100px;
	margin-top: 10px;
}


</style>
</head>
<body>
	<%@ include file="/views/user/common/B_UserMainHeader.jsp"%>

	<!-- 세션시작 -->
	<section id="section">
		<h3>|중고구마에 판매하는 방법</h3>

		<div>
			<table class="buymain-table">
				<tr>
					<td rowspan="2" class="icon-td"><input type="image"
						class="buy-icon" src="/forest/image/userimg/buymain1.png"></td>
					<td><p class="td-title">01.신청하기</p></td>
				</tr>
				<tr>
					<td>매입 가능한 물품을 확인하고 매입신청을 진행합니다.<br><br>
						<button id="howtobuy">상세내용 확인하기</button>
					</td>

				</tr>
				<tr>
					<td rowspan="2" class="icon-td"><input type="image"
						class="buy-icon" src="/forest/image/userimg/buymain2.png"></td>
					<td><p class="td-title">02. 보내기</p></td>
				</tr>
				<tr>
					<td>1차 검수가 통과된 상품을 미리 예약된 날짜에 보내주세요.</td>

				</tr>
				<tr>
					<td rowspan="2" class="icon-td"><input type="image"
						class="buy-icon" src="/forest/image/userimg/buymain3.png"></td>
					<td class="td-title" style="height:50px;"><p>03. 상품 검수 진행</p></td>
				</tr>
				<tr>
					<td><p style="margin-top:5px;">상품이 중고구마에 도착후 2~3일 내로 최종 검수결과를 안내드립니다</p>
                            <p>실물과 다르거나 고객님의 제품에 기기적 손상으로 최종 검수를 통과하지 <br> 
                                                          못할 시 상품은 반송되며 모든 배송비용은 고객님의 부담이 됩니다. </p>
                        </td>

				</tr>
				<tr>
					<td rowspan="2" class="icon-td"><input type="image"
						class="buy-icon" src="/forest/image/userimg/buymain4.png"></td>
					<td><p class="td-title">04. 매입 금액 입급</td>
				</tr>
				<tr>
					<td>매입금액을 고객님의 계정으로 포인트를 입금해 드립니다.</td>

				</tr>

			</table>
		</div>
		<div class="buymain-btn">
			<%if (loginMember == null) { %>
			<button id="buymain-ok" onclick="location.href='<%=request.getContextPath() %>/views/user/member/F_login.jsp'">
				확인</button>
			<% } else { %>
			<button id="buymain-ok" onclick="location.href='/forest/views/user/buy/B_selectCategory.jsp'">확인</button>
			<% } %>
		</div>
	
		
		<!------------------------- 매입신청 모달 ------------------------------------------>
		<div id="myModal" class="modal">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="top-title">
					<p style="padding-left: 20px;">매입신청 확인</p>
				</div>
				
				<div class="content-area">
					<input type="image" class="howtoImg" src="/forest/image/userimg/howto.png">
				</div>
				
				<div class="modal-btn">
					<button class="modal-ok">확인</button>
				</div>
			</div>
	</section>
	<!-- 세션끝 -->
	
	<!--------------------------모달 스트립트------------------ -->
	<script>
		var modal = document.getElementById('myModal');
		var btn = document.getElementById("howtobuy");
		var btn2 = document.getElementsByClassName("modal-ok")[0];

		btn.onclick = function() {
			modal.style.display = "block";
		}

		btn2.onclick = function() {
			modal.style.display = "none";
		}
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
		


	</script>
	


	<%@ include file="/views/user/common/B_UserMainFooter.jsp"%>
</body>
</html>