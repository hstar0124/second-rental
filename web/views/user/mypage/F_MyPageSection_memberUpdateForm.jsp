<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member selectMember = (Member)request.getAttribute("selectMember");
%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
<style>
#updateRange {
	margin: 0 auto;
	width: 450px;
	height: 450px;
	border: 2px solid gray;
	margin-top: 50px;
	margin-bottom: 150px;
	border-radius: 10px 10px 10px 10px;
}

#updateBar {
	
}

.text1 {
	margin-top: 30px;
	width:300px;
}

#updateTable {
	margin: 0 auto;
	width: 100%;
	margin-top: 10px;
}

.updateText {
	font-size: 28px;
	font-weight: 400;
	color: #6E00AB;
	margin-left: 10px;
	margin-top: 10px;
}

#p1 {
	font-size: 13.5px;
	color: gray;
	font-weight: 600;
	margin-left: 3px;
}

.pwdText {
	margin-left: 30px;
	font-weight: 600;
}

.pwdRange {
	margin-left: 18px;
	width: 400px;
	height: 40px;
	border-radius: 10px 10px 10px 10px;
	border: 2px solid gray;
	text-indent: 16px;
	font-size: 30px;
	outline: none;
	caret-color: #6E00AB;
	color: red;
}

#pwdCkBtn {
	width: 130px;
	height: 50px;
	margin-left: 150px;
	border: none;
	border-radius: 20px 20px 20px 20px;
	background: #6E00AB;
	color: white;
	font-weight: 600;
	font-size: 20px;
	outline: none;
	cursor: pointer;
}

.text1 {
	margin-left: 10px;
}

#myInfo {
	background: #6E00AB;
	color: white;
}

.updateTable {
	margin: 0 auto;
}

.phoneCk {
	width: 50px;
	height: 25px;
	border: none;
	background: #6E00AB;
	color: white;
	font-weight: 500;
	border-radius: 5px 5px 5px 5px;
	margin: 0 auto;
	cursor: pointer;
}

#phoneCkCode {
	width: 200px;
}

.phoneCkCodeCk {
	width: 70px;
	height: 25px;
	border: none;
	background: #6E00AB;
	color: white;
	font-weight: 500;
	border-radius: 5px 5px 5px 5px;
	margin: 0 auto;
	cursor: pointer;
}
.input1{
    width: 350px;
    height: 30px;
    border: none;
    background: rgb(232, 232, 232);
} 
#email1{
    width: 200px;
}
#email2{
    width: 140px;
    height: 30px;
}
.emailCk{
    width: 50px;
    height: 25px;
    border: none;
    background: #6E00AB;
    color: white;
    font-weight: 500;
    border-radius: 5px 5px 5px 5px;
    margin: 0 auto;
    cursor: pointer;
}
.addressBtn{
    width: 30px;
    height: 30px;
}
#postcode{
    width: 150px;
}
.addressBtn{
    width: 100px;
    height: 25px;
    border: none;
    background: #6E00AB;
    color: white;
    font-weight: 500;
    border-radius: 5px 5px 5px 5px;
    margin: 0 auto;
    cursor: pointer;
}
#bankName{
    width: 140px;
    height: 30px;
}
.accountCk{
    width: 80px;
    height: 25px;
    border: none;
    background: #6E00AB;
    color: white;
    font-weight: 500;
    border-radius: 5px 5px 5px 5px;
    margin: 0 auto;
    cursor: pointer;
}
#updateBtn{
	width: 120px;
    height: 40px;
    background: #6E00AB;
    color: white;
    margin-left: 130px;
    margin-bottom:110px;
    border-radius: 5px 5px 5px 5px;
    border:none;
    font-size:18px;
    cursor: pointer;
}
#memberDeleteBtn{
	float:right;
	height:40px;
	width:110px;
	margin-top:60px;
	margin-left:550px;
	border:none;
	background:white;
	outline:none;
	cursor: pointer;
}
#front{
	display:inline-flex;
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
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 0px;
            border: 1px solid #888;
            width: 500px; /* Could be more or less, depending on screen size */                          
        	height:400px;
        }
        .modal-content1 {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 0px;
            border: 1px solid #888;
            width: 500px; /* Could be more or less, depending on screen size */                          
        	height:400px;
        }
        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        #modalTable{
         width:100%
        }
        #userOk{
        	font-size:24px;
        	maigin:0px;
        }
        #okInfo{
        	font-size:15.5px;
        }
        .top-title {
		background: #6E00AB;
		height: 50px;
		width: 500px;
}
#emailCode{
	width:100px;
	border:2px solid gray;
	margin-bottom:4px;
	height:25px;
}
#emailCodeCk{
	background:#6E00AB;
	border:none;
	outline:none;
	color:white;
	height:28px;
	border-radius: 3px 3px 3px 3px;
	cursor: pointer;
}
#ckOkBtn{
	background:#6E00AB;
	border:none;
	outline:none;
	color:white;
	height:40px;
	width:120px;
	margin-left:195px;
	cursor: pointer;
}
.modal-content p {
	color: white;
	margin: 0px;
	padding-top: 15px;
	font-size: 17px;
}
#newPasswordBtn{
	background: #6E00AB;
	color:white;
	font-size: 14px;
	border:none;
	border-radius: 3px 3px 3px 3px;
	width:110px;
	height:25px;
	cursor: pointer;
}
#pwdOkBtn{
	background: gray;
	color:white;
	font-size: 14px;
	border:none;
	border-radius: 3px 3px 3px 3px;
	width:110px;
	height:30px;
	margin-left:190px;
	cursor: pointer;
}
#emailOkBtn{
	background: #6E00AB;
	color:white;
	font-size: 14px;
	border:none;
	border-radius: 3px 3px 3px 3px;
	width:110px;
	height:30px;
	margin-left:190px;
	cursor: pointer;
}
#email2{
	border:1px solid gray;
	background: rgb(232, 232, 232);
}
#bankName{
	border:1px solid gray;
	background: rgb(232, 232, 232);
}
</style>
</head>
<body>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
	<div id="front"><h1 class="text1">나의 정보 수정 </h1></div> 
	<div
		style="background-color: purple; width: 100%; height: 4px; margin-top: 0px;"></div>
	<div>
		<form action="<%=request.getContextPath() %>/updateMember.me" method="post" class="createUserForm">
			<table class="updateTable">
				<tr height="10px"></tr>
				<tr height="25px"></tr>

				<tr>
					<td height="0px"><label class="q1">휴대전화번호</label></td>
				</tr>
				<tr>
					<td><select name="phone1" id="phone1"
						style="width: 90px; height: 30px; border: none; background: rgb(232, 232, 232); font-size:14px; text-indent: 24px;">
							<option selected>010</option>
							<option>011</option>
							<option>016</option>
					</select> - <input type="text" id="phone2" name="phone2" class="input1" readonly style="width: 110px; font-size:14px; text-indent: 30px;">
						- <input type="text"  id="phone3" name="phone3" class="input1" readonly style="width: 110px; text-indent: 30px; font-size:14px;">
						<input type="button" value="변경" readonly id="phoneCk" class="phoneCk"></td>
				</tr>
				<tr height="25px"></tr>
				<tr><td><input type="button" id="newPasswordBtn" value="비밀번호 변경">
					<input type="password" id="password3" name="password3"  style="display:none;">
					<input type="text" id="userNo" name="userNo" value="<%= selectMember.getUserNo() %>"  style="display:none;">
				</td>
				</tr>
				
				<tr height="25px"></tr>
				<tr>
					<td height="0px"><label class="q1">이메일</label></td>
				</tr>
				<tr>
					<td><input type="email" id="email1" name="email1"  readonly
						class="input1"> <select name="email2" id="email2">
							<option name= "naver" >@naver.com</option>
							<option name= "google">@gmail.com</option>
							<option name= "daum">@daum.net</option>
					</select> <input type="button" value="변경" id="emailCk" class="emailCk"></td>
				</tr>
				<tr height="25px"></tr>
				<tr>
					<td><label class="q1">주소</label></td>
				</tr>
				<tr>
					<td><input type="text" id="postcode" name="postcode" readonly
						placeholder="우편번호" class="input1"> <input type="button" 
						class="addressBtn" onclick="sample4_execDaumPostcode();"
						value="등록주소변경"></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td><input type="text" id="roadAddress" name="roadAddress" readonly
						placeholder="도로명주소" class="input1"></td>
				</tr>

				
				<span id="guide" style="display: hide"></span>
				<tr height="5px"></tr>
				<tr>
					<td><input type="text" id="detailAddress" class="input1" 
						name="detailAddress" placeholder="상세주소"></td>
				</tr>
				<tr height="25px"></tr>
				<tr>
					<td><label class="q1">은행명</label></td>
				</tr>
				<tr>
					<td><select name="bankName" id="bankName">
							<option selected>국민은행</option>
							<option>우리은행</option>
							<option>신한은행</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="text" id="account" name="account"  value="<%= selectMember.getAccount() %>"
						class="input1"> <input type="button" value="계좌변경"
						class="accountCk" id="accountCk"></td>
				</tr>
				<tr height="60px"></tr>
				<tr>
					<td><input type="submit" value="수정완료" id="updateBtn"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 이메일 변경 모달 -->
    <div id="myModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content" style="height:470px;">
				<div class="top-title">
					<span class="close">&times;</span>
					<p style="padding-left: 20px;">이메일 변경</p>
				</div>                                                            
        <table id="modalTable">
        	<tr></tr>
        	<tr><td align="center"><label id="userOk">변경될 이메일 인증</label></td></tr>
        	<tr height="30px"></tr>
        	<tr><td align="center"><label id="okInfo">변경하실 이메일을 입력 후 인증 버튼을 눌러주세요.<br>
					발송된 인증번호를 인증번호란에 입력해주세요.</label></td></tr>
			<tr height="30px"></tr>
			<tr><td><label style="margin-left:80px;">변경 할 이메일</label></td></tr>
			<tr><td><input type="text" id="newEmail" name="newEmail" style="margin-left:80px;border:none; height:25px; background:rgb(232, 232, 232);">
				<select name="newEmail2" id="newEmail2" style="height:25px; border:none;  background:rgb(232, 232, 232);">
							<option name="naver" selected>@naver.com</option>
							<option name="google">@gmail.com</option>
							<option name="daum">@daum.net</option>
				</select>
				<input type="button" value="인증" id="newEmailCk" style="border:none; background:#6E00AB; color:white; height:25px; width:70px; border-radius: 3px 3px 3px 3px;"> 			
			</td></tr>
			<tr height="10px"></tr>
			<tr><td><label style="margin-left:80px;">인증번호</label></td></tr>
			<tr><td><input type="text"  id="newEmailCkCode"style="margin-left:80px;border:none; height:25px; background:rgb(232, 232, 232);"></td></tr>
			<tr height="50px"></tr>
			<tr><td><input type="button" id="emailOkBtn" value="인증 완료"></td></tr>
        </table>
      </div>
 
    </div>
    
     <div id="myModal2" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
				<div class="top-title">
					<span class="close">&times;</span>
					<p style="padding-left: 20px;">본인확인</p>
				</div>                                                            
        <table id="modalTable">
        	<tr></tr>
        	<tr><td align="center"><label id="userOk">본인확인</label></td></tr>
        	<tr height="30px"></tr>
        	<tr><td align="center"><label id="okInfo">인증요청을 누르시면 등록되있으신 이메일로 인증메일이 발송됩니다.
					하단에 인증번호를 입력해주세요.</label></td></tr>
			<tr height="30px"></tr>
			<tr><td><label style="margin-left:100px; font-size:20px; font-weight:600; padding-top:15px;">인증번호 입력 : </label><input type="text" id="emailCode" name="emailCode">
				<input type="button" id="emailCodeCk" value="인증요청">
			</td></tr>
			
			<tr height="50px"></tr>
			<tr><td><input type="button" id="ckOkBtn" value="인증 완료"></td></tr>
        </table>
      </div>
 </div>
    
      
      <div id="myModal3" class="modal">
      <!-- Modal content -->
      <div class="modal-content" style="height:500px">
				<div class="top-title">
					<span class="close">&times;</span>
					<p style="padding-left: 20px;">비밀번호 변경</p>
				</div>                                                            
        <table id="modalTable">
        	<tr></tr>
        	<tr><td align="center"><label id="userOk">새로운 비밀번호</label></td></tr>
        	<tr height="30px"></tr>
        	<tr><td align="center"><label id="okInfo">변경하시고자 하는 비밀번호를 입력해주세요.</label></td></tr>
			<tr height="30px"></tr>
			<tr>
							<td height="0px"><label class="q1" style="margin-left:80px">비밀번호</label></td>
						</tr>
						<tr>
							<td><input type="password" id="password" name="password" style="margin-left:70px"
								class="input1"></td>
						</tr>
						<tr id="pwd1" style="visibility:hidden;"><td><label id="pwdC"style="font-size:12px; margin-left:70px">sss</label></td></tr>
						<tr height="0px"></tr>
						<tr>
							<td height="0px"><label class="q1" style="margin-left:80px">비밀번호 확인</label></td>
						</tr>
						<tr>
							<td><input type="password" id="password2" name="password2" style="margin-left:70px"
								class="input1"></td>
						</tr>
						<tr><td><label id="lb5" style="font-size:12px; margin-left:80px;">비밀번호 8~16자리 (영어 대소문자, 숫자, 특수문자 포함)</label></td></tr>
						<tr height="20px"></tr>
			
			<tr height="50px"></tr>
			<tr><td><input type="button" id="pwdOkBtn" value="변경 완료" disabled></td></tr>
        </table>
      </div>
 
    </div>
     
	<script>
		var pwdResult = 0;
		$(function(){
			// Get the modal
			var modal = document.getElementById('myModal2');

			// Get the button that opens the modal
			var btn = document.getElementById("phoneCk");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[1];                                          

			// When the user clicks on the button, open the modal 
			btn.onclick = function() {
			    modal.style.display = "block";
			}

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			    modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			    if (event.target == modal) {
			        modal.style.display = "none";
			    }
			}
			
			$(function(){
      	 		$("#password").focus(function(){
      	 			$("#password").val("");
      	 			$("#password2").val("");
      	 			$("#pwd1").attr("style","visibility:hidden");
      	 		});
      	 	});
      	 	$(function(){
      	 		$("#password2").keyup(function(){
      		 		var pwd1 = $("#password").val();
      			 	var pwd2 = $("#password2").val();
      			 	var regExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

      			 	if(pwd1 != pwd2){
      			 		result = 10;
      			 	}else if(!regExp.test(pwd1)){
      			 		result = 11;
      			 	}else{
      			 		result = 99;
      			 	}
      			 	
      			 	
      		 	if(pwd1 != ""){	
      		 		 if(result == 10){
      		 			$("#pwdC").css("color","red");
      					$("#pwdC").html("비밀번호가 일치하지않습니다.");
      					$("#pwd1").attr("style","visibility:visible");
      					$("#pwdOkBtn").attr('disabled', 'true');
          	 			$("#pwdOkBtn").css('background','gray');
      					pwdResult = 3;
      		 		
      		 		}else if(result == 11){
      		 			$("#pwdC").css("color","red");
      					$("#pwdC").html("비밀번호 형식을 확인해주세요.");
      					$("#pwd1").attr("style","visibility:visible");
      					$("#pwdOkBtn").attr('disabled', 'true');
          	 			$("#pwdOkBtn").css('background','gray');
      					pwdResult = 2;
      		 		}else if(result == 99){
      		 			$("#pwdC").css("color","green");
      					$("#pwdC").html("비밀번호가 일치되었습니다.");
      					$("#pwd1").attr("style","visibility:visible");
      					$("#pwdOkBtn").attr("disabled", false);
      					$("#pwdOkBtn").css('background','#6E00AB');
      					pwdResult = 1;
      		 		}
      		 	}
      		 	});
      	 		
      	 		$("#pwdOkBtn").click(function(){
      	 		if(pwdResult == 1){
      	 			var modal = document.getElementById('myModal3');
      	 			$("#password3").val($("#password").val());
      	 			modal.style.display = "none";
      	 		}else if(pwdResult ==2){
      	 			alert("비밀번호를 확인해주세요!");
      	 		}
      	 		});
      	 	});
			
		});
	</script>
	<script>
	$(function(){
		// Get the modal
		var modal = document.getElementById('myModal3');

		// Get the button that opens the modal
		var btn = document.getElementById("newPasswordBtn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[2];                                          

		// When the user clicks on the button, open the modal 
		btn.onclick = function() {
		    modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		    modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
	});
	</script>
	<script>
	var num = 0;
	$(function(){
		// Get the modal
		var modal = document.getElementById('myModal');

		// Get the button that opens the modal
		var btn = document.getElementById("emailCk");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];                                          

		// When the user clicks on the button, open the modal 
		btn.onclick = function() {
		    modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		    modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
		
		var pon = "<%= selectMember.getPhone()%>";
		var phone1 = pon.substring(0,3);
		var phone2 = pon.substring(3,7);
		var phone3 = pon.substring(7,11);

		$("#phone1").filter(function(){
			if(phone1 == $(this).val()){
				$(this).attr("selected",true);
			}
		});
		$("#phone2").val(phone2);
		$("#phone3").val(phone3);
		
		if(num ==0){
		var email = "<%= selectMember.getEmail()%>";
		var com = $("#email2").val();
		var e = email.split("@");
		var option = $("option").val();
		$("#email1").val(e[0]);
		$("#email2>option").filter(function(){
			if("@"+e[1] == $(this).val()){
				$(this).attr("selected",true);
			}
		});
		num++;
		}
		var ads = "<%= selectMember.getAddress()%>";
		var address = ads.split("$");
		
		$("#postcode").val(address[0]);
		$("#roadAddress").val(address[1]);
		$("#detailAddress").val(address[2]);
		
		var bn = "<%= selectMember.getBank()%>";
		$("#bankName>option").filter(function(){
			if(bn == $(this).val()){
				$(this).attr("selected",true);
			}
		});
		
	});
	</script>
	<script>
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
                 
                 console.log("data.zonecode");
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
     		
     }
	</script>
	
	<script>
	$(function(){
	$("#newEmailCk").click(function(){
	 		var email = $("#newEmail").val()+$("#newEmail2").val();
	 		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		    console.log(email);
	 		if($("#newEmail").val() != "" &&$("#newEmail").val() != null && regExp.test(email)){
	 		$.ajax({
				type:"POST",
				url :'<%= request.getContextPath() %>/emailCk.me',
				async: false,
				data:{
					"email" : email
				},
				 success:function(data){
					emailCode = data;
					alert("인증번호가 전송되었습니다.");
				 }
				
	 		});
	 		}
	});
	
		$("#emailOkBtn").click(function(){
			if(emailCode == $("#newEmailCkCode").val()){
				var email = $("#newEmail").val()+$("#newEmail2").val();
				var modal = document.getElementById('myModal');
				var e = email.split("@");
				var option = $("option").val();
				
				$("#email1").val(e[0]);
				$("#email2>option").filter(function(){
					if("@"+e[1] == $(this).val()){
						$(this).attr("selected",true);
					}
				});
				 modal.style.display = "none";
				 alert("이메일이 인증 되었습니다.");
			}else{
				alert("인증번호가 일치하지않습니다!");
			}
		});
	});
	</script>
	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp"%>
</body>
</html>