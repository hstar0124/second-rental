<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.forest.order.model.vo.*"%>
<%
	String productNo = (String) request.getAttribute("productNo");
	String month = (String) request.getAttribute("month");
	int price = (int) request.getAttribute("price");
	int num = (int) request.getAttribute("num");
	String takeOver = (String) request.getAttribute("takeOver");
	String productName = (String) request.getAttribute("productName");
	String rentalNo = (String) request.getAttribute("rentalNo");
	String attachment = (String) request.getAttribute("attachment");
	ArrayList<Rental> list = (ArrayList<Rental>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"
	type="text/javascript"></script>
<title>중고구마</title>
<style>
.orderArea {
	margin: 0 auto;
	padding-top: 100px;
	height: 880px;
	width: 80%;
}

.orderDiv {
	float: left;
	margin-left: 120px;
}

.orderDiv2 {
	float: left;
	margin-left: 40px;
}

.orderTable {
	border: 2px solid lightgray; <!--
	rules: none; -->
	border-collapse: separate;
	border-spacing: 20px 10px;
}

.orderTable2 {
	border: 2px solid lightgray;
	rules: none;
	border-collapse: separate;
	border-spacing: 20px 10px;
}

.orderBtn {
	background: #6E00AB;
	color: white;
	width: 300px;
	height: 50px;
	font-size: 20px;
	border:1px solid #6E00AB;
}

.orderTable tr td input {
	height: 30px;
	width: 300px;
}

.postNum {
	background: #6E00AB;
	color: white;
	height: 30px;
}
</style>

</head>
<body>
	<%@ include file="/views/user/common/B_UserMainHeader.jsp"%>

<%if(loginMember != null){ %>
	<article class="orderArea">
		<div class="orderDiv">
			<table class="orderTable" style="width: 500px; height: 750px">

				<tr>
					<th align="left"
						style="font-size: 30px; border-bottom: 2px solid lightgray;">
						주문하기</th>
				</tr>
				<tr>
					<td style="font-size: 20px; font-weight: bold;">배송정보</td>
				</tr>
				<tr>
					<td style="font-weight: bold;">이름</td>
				</tr>
				<tr>
					<td><input type="text" name="buyerName" id="buyerName"
						value="<%= loginMember.getUserName() %>"></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">전화번호</td>
				</tr>
				<tr>
					<td><input type="text" name="phone" id="phone"
						value="<%= loginMember.getPhone()%>"></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">이메일</td>
				</tr>
				<tr>
					<td><input type="email" id="email" value="<%= loginMember.getEmail() %>"></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">주소검색</td>
				</tr>
				<tr>
					<td>
						<%
							String address = loginMember.getAddress();
							String postNum = address.split("[$]")[0];
							String add1 = address.split("[$]")[1];
							String add2 = address.split("[$]")[2];
						%>
	 				<input type="text" id="postcode" name="postcode" placeholder="우편번호"
						class="input1" style="width: 150px;" value="<%=postNum%>">
						<input type="button" class="addressBtn"
						onclick="sample4_execDaumPostcode();" value="우편번호"
						style="width: 80px;">
					</td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td><input type="text" id="roadAddress" name="roadAddress"
						placeholder="도로명주소" class="input1" value="<%=add1%>"></td>
				</tr>

				
				<tr height="5px"></tr>
				<tr>
					<td><input type="text" id="detailAddress" class="input1"
						name="detailAddress" placeholder="상세주소" value="<%=add2%>"></td>
				</tr>
				<tr>
					<td><label style="font-weight: bold;">결제수단</label>
						&nbsp;&nbsp;&nbsp; <input type="radio" id="cardRa" value="card"
						style="width: 15px; height: 15px;" checked> <label
						for="cardRa">카드</label></td>
				</tr>
			</table>
		</div>


		<div class="orderDiv2">
			<table class="orderTable2" style="width: 400px; height: 500px;">
				<colgroup>
					<col align="center">
					<col text-align="right">
				</colgroup>
				<tr>
					<th colspan="2" align="left"
						style="border-bottom: 2px solid lightgray; font-size: 20px; font-weight: bold;">결제상품</th>
				</tr>
				<% if(num == 1 || num == 2){ %>
				<tr>
					<td align="center"><img height="150px" width="150px" src="<%=request.getContextPath()%>/image/productImg/<%=attachment%>"></td>
					<td align="center"><%= productName %></td>
				</tr>
				<% }else{ 
					for(Rental r : list){
				%>
				
				<tr>
					<td align="center"><img height="150px" width="150px" src="<%=request.getContextPath()%>/image/productImg/<%=r.getAttachment()%>"></td>
					<td align="center"><%= r.getProductName() %></td>
				</tr>
				<% 	}
					}%>
				<tr>
					<td style="font-weight: bold;">상품 금액</td>
					<td align="right" class="price"><%= price %></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">사용 고구마</td>
					<td align="right">-<input type="text" class="usePoint" id="usePoint"
						 value="0" style="width: 80px;"> <label
						style="font-weight: bold;">P</label></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">보유 고구마</td>
					<td align="right" class="goguma"><%= loginMember.getPoint() %></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">배송료</td>
					<td align="right">무료배송</td>
				</tr>
				<tr>
					<td style="color: red; font-weight: bold;">결제하실 금액</td>
					<td align="right" class="totalP"
						style="color: red; font-weight: bold;"><%= price %></td>	
				</tr>
				<tr>
					<td colspan="2" align="center"
						style="border-top: 2px solid lightgray;"><button
						class="orderBtn" onclick="pg();">결제하기</button></td>
				</tr>
			</table>

		</div>

	</article>
	
	<script>
		var usePoint = 0;
		var totalPrice = 0;
		$(function() {
			//포인트  사용시 가격 변환
			$(".usePoint").blur(function() {
				usePoint =  $(this).val();
				console.log($(".price").text());
				var point = Number(usePoint); 
				var goguma = Number($(".goguma").text());
				console.log(point);
				console.log(goguma);
				if(point > goguma){
					alert("보유포인트보다 사용포인트가 더 많을 수는 없습니다.");
					$(this).val(0);
				}
				if(point < 1000){
					alert("1000포인트 이상 입력해주세요");
					$(this).val(0);
				}
				$(".totalP").text($(".price").text() - $(this).val());
				
				});
			
			//연장하기 일경우 판단
			if(<%=num%> == 2){
				$("#buyerName").attr("disabled", true);
				$("#phone").attr("disabled", true);
				$("#email").attr("disabled", true);
				$("#postcode").attr("disabled", true);
				$("#roadAddress").attr("disabled", true);
				$("#detailAddress").attr("disabled", true);
				
			}
			
		});

		

		var IMP = window.IMP; // 생략가능
		IMP.init('imp22157577'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		var merchant_uid ='M_' + new Date().getTime();
		var userNo = "<%=loginMember.getUserNo()%>";
		var buyerAdd = $("#roadAddress").val()+$("#detailAddress").val();
		var buyerName = $("#buyerName").val();
		var buyerPhone = $("#phone").val();
		totalPrice = $(".totalP").text();
		var productNo = "<%= productNo%>";
		var month = "<%= month%>";
		var rentalNo = "<%=rentalNo%>";
		var rentalPrice = '';
		
		var index = 0;
		
		<%
		if(num == 3){%>
			productNo = '';
			month = '';
		<%for(int i = 0; i < list.size(); i++){%>
			productNo += '<%= list.get(i).getProductNo()%>' + ',';			
			month += <%= list.get(i).getMonth()%> + ',';
			rentalPrice += <%= list.get(i).getRentalPrice()%> + ',';
			index++;
		<%}
		}%>

		
		function pg() {
			IMP.request_pay({
				pg : 'html5_inicis', // version 1.1.0부터 지원.
				pay_method : 'card',
				merchant_uid : merchant_uid,
				name : '주문명:결제테스트',
				amount : 100,
				buyer_email : '<%= loginMember.getEmail() %>',
				buyer_name : buyerName,
				buyer_tel : buyerPhone,
				buyer_addr : buyerAdd,
				buyer_postcode : $("#postcode").val()
			}, function(rsp) {
				 if ( rsp.success ) {
					 jQuery.ajaxSettings.traditional = true;

				    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
				    	jQuery.ajax({
				    		url: "<%=request.getContextPath()%>/payments/complete", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
				    		type: 'POST',
				    		/* dataType: 'json', */
				    		data: {
					    		imp_uid : rsp.imp_uid,			
					    		paid_amount : totalPrice,	//가격
					    		merchant_uid: merchant_uid,		//주문번호
					    		buyer_id: userNo,				//주문한 이용자 아이디
					    		apply_num : rsp.apply_num,		//카드사 승인번호
					    		use_point : usePoint,			//사용포인트
					    		status : rsp.status,			//결제상태
					    		paid_at : rsp.paid_at,			//결제시각
					    		buyer_name : rsp.buyer_name,	//받는사람
					    		buyer_tel : rsp.buyer_tel,		//받는사람 번호
					    		buyer_addr : $("#roadAddress").val()+ "$" +$("#detailAddress").val(),	//받는사람주소
					    		buyer_postcode : rsp.buyer_postcode,	//받는사람 우편번호
					    		productNo : productNo,	
					    		month : month,
					    		takeOver : '<%=takeOver%>',
					    		number : '<%=num%>',
					    		rentalNo : rentalNo,
					    		rentalPrice : rentalPrice
					    		//기타 필요한 데이터가 있으면 추가 전달
				    		},
				    		success : function(){
				    			 location.href="<%=request.getContextPath()%>/comPur.or?orderNo="+merchant_uid+"&userNo="+userNo; 
				    		},
				    		error: function(error){
				    			console.log(error);
				    		}
				    		
				    		
				    	});
				    	
				    } else {
				        var msg = '결제에 실패하였습니다.';
				        msg += '에러내용 : ' + rsp.error_msg;

				        alert(msg);
				    }
			});
		};

		//주소명 입력하는 함수
		function sample4_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var roadAddr = data.roadAddress; // 도로명 주소 변수
							var extraRoadAddr = ''; // 참고 항목 변수

							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraRoadAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraRoadAddr += (extraRoadAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraRoadAddr !== '') {
								extraRoadAddr = ' (' + extraRoadAddr + ')';
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('postcode').value = data.zonecode;
							document.getElementById("roadAddress").value = roadAddr;
							document.getElementById("jibunAddress").value = data.jibunAddress;

							console.log("data.zonecode");
							var guideTextBox = document.getElementById("guide");
							// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
							if (data.autoRoadAddress) {
								var expRoadAddr = data.autoRoadAddress
										+ extraRoadAddr;
								guideTextBox.innerHTML = '(예상 도로명 주소 : '
										+ expRoadAddr + ')';
								guideTextBox.style.display = 'block';

							} else if (data.autoJibunAddress) {
								var expJibunAddr = data.autoJibunAddress;
								guideTextBox.innerHTML = '(예상 지번 주소 : '
										+ expJibunAddr + ')';
								guideTextBox.style.display = 'block';
							} else {
								guideTextBox.innerHTML = '';
								guideTextBox.style.display = 'none';
							}
						}
					}).open();
		};
	</script>

<% } else{%>

	<script>
		$(function(){
			alert("로그인을 먼저 진행해 주세요.");
			location.href="/forest/views/user/member/F_login.jsp";
		})
	</script>
<% }%>


<%@ include file="/views/user/common/B_UserMainFooter.jsp"%>	
</body>
</html>