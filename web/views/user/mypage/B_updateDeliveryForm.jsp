<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String buyNoVal = (String) request.getAttribute("buyNoVal");
%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<script	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
/*---------판매 필요정보 입력 영역--------- */

#buyCurrent {
	background: #6E00AB;
	color: white;
}
.title{
	margin-bottom:1px;
}

/*상단 노티스*/

.notice-area{
    width: 1010px;
    height: 200px;    
    text-align: center;
    background: #E8E8E8;
}
.notice-area>p:nth-of-type(1){
    color: red;
    font-weight: bold;
    margin-top: 0px;
    padding-top: 50px;
}
.notice-area>p:nth-last-of-type(1){
    color: #444343;
    font-size: 13px;
}

/*운송장번호입력영역*/
.delivery-insert{
    text-align: left;
    
    width: 500px;
    margin: 0 auto;
    
}
.insert-select{
    width: 100px;
    height: 30px;
   
}
.delivery-insert input[type=text]{
    height: 30px;
    width: 300px;
}
.delivery-insert>button{
    width: 50px;
    height: 30px;
    background: #6E00AB;
    color: white;
    border-radius: 5px;
    border: none;
}
.delivery-insert>p{
    margin-top: 30px;
    margin-bottom: 10px;
    font-weight: bold;
    font-size: 17px;    
}

/*주소 입력 영역*/
.address-insert{
    text-align: left;    
    width: 500px;
    margin: 0 auto;
    
}
.address-insert>p{
    margin-top: 30px;
    margin-bottom: 10px;
    font-weight: bold;
    font-size: 17px;     
}
.insert-zip{
    width: 100px;
    height: 30px;

}
.address1{
    width: 470px;
    height: 30px;
    margin-bottom: 10px;
    margin-top: 10px;
}
.address2{
    width: 470px;
    height: 30px;
    margin-bottom: 5px;
}
.address-insert>button{
    width: 70px;
    height: 30px;
    background: #6E00AB;
    color: white;
    border-radius: 5px;
    border: none;
    
}
.address-insert>label{
	font-size: 13px;
}
.submit-btn{
    margin: 0 auto;
    width: 500px;
    margin-bottom: 50px;
    text-align: center;
    margin-top: 50px;
}
.submit-btn>input{
    width: 70px;
    height: 30px;
    background: #6E00AB;
    color: white;
    border-radius: 5px;
    border: none;
    
}

#delivery-form{
	margin-top: 100px;
}

</style>
</head>
<body>
<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>


	<h1 class="title">필요 정보 수정</h1>
	<div style="background-color: #6E00AB; width: 100%; height: 4px; margin-top: 0px;"></div>

	
		<div class="address-insert">
                <p>| 주소</p>
                
                <input type="text" id="postcode" name="postcode" class="insert-zip input1" readonly
                	placeholder="우편번호">
                <input type="button" class="addressBtn" onclick="sample4_execDaumPostcode();" 
                	value="우편번호 ">
                <br>
                <input type="text" id="roadAddress" name="roadAddress" class="address1 input1" readonly
                	placeholder="도로명주소">
                <br>
                <input type="text" id="detailAddress" name="detailAddress" class="address2 input1" 
                	placeholder="지번주소"><br>
                <label>* 본 주소 입력은 고객님의 물품이 입고 불가한 사항으로 반송될 경우 받으실 주소를 입력해 주셔야합니다.</label>
                <br>
                <label>* 배송지 입력이 잘못된 경우 본 기업이 배상책임을 지지 않습니다.</label>
            </div>
		
		<div class="submit-btn">
			<input type="submit" id="submitBtn" value="입력완료">
		</div>
	
	<script>
		$(function(){
	    	//회원 기본정보 주소 불러오기
	 		var arr = "<%=loginMember.getAddress()%>".split("$");
	 		$("input[name=postcode]").val(arr[0]);
	 		$("input[name=roadAddress]").val(arr[1]);
	 		$("input[name=detailAddress]").val(arr[2]);
			
	 		//입력완료버튼 클릭시
     		$("#submitBtn").click(function(){
     			
	     		location.href = "<%=request.getContextPath()%>/updateBuyAddress.buy?buyNoVal=" +<%=buyNoVal%> 
	     					+ "&address=" + arr;
     		});
		});
		
		//우편번호 검색후 주소창에 입력
	 	 function sample4_execDaumPostcode() {
	         new daum.Postcode({
	             oncomplete: function(data) {
	                 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                 // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	                 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                 var roadAddr = data.roadAddress; // 도로명 주소 변수
	                 var extraRoadAddr = ''; // 참고 항목 변수

	                 // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                 // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                 if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                     extraRoadAddr += data.bname;
	                 }
	                 // 건물명이 있고, 공동주택일 경우 추가한다.
	                 if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                 }
	                 // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                 if(extraRoadAddr !== ''){
	                     extraRoadAddr = ' (' + extraRoadAddr + ')';
	                 }

	                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                 document.getElementById('postcode').value = data.zonecode;
	                 document.getElementById("roadAddress").value = roadAddr;
	                 document.getElementById("jibunAddress").value = data.jibunAddress;
	                 
	                 var guideTextBox = document.getElementById("guide");
	                 // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	                 if(data.autoRoadAddress) {
	                     var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                     guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                     guideTextBox.style.display = 'block';

	                 } else if(data.autoJibunAddress) {
	                     var expJibunAddr = data.autoJibunAddress;
	                     guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                     guideTextBox.style.display = 'block';
	                 } else {
	                     guideTextBox.innerHTML = '';
	                     guideTextBox.style.display = 'none';
	                 }
	             }
	         }).open();
	     };
	</script>

	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp"%>
</body>
</html>