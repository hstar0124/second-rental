<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300&display=swap" rel="stylesheet">
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
.checkBar {
	background: gray;
	width: 1000px;
	height: 3px;
	margin: 0 auto;
	margin-top: 20px;
}

.checkText {
	font-weight: 900;
	font-size: 30px;
	width: 1000px;
	height: 3px;
	margin: 0 auto;
	margin-left: 250px;
	margin-bottom: 10px;
}

.createUserForm {
	margin-top: 0 auto;
	margin-bottom: 100px;
}

.createTable {
	margin: 0 auto;
	margin-top: 20px;
}

.input1 {
	width: 350px;
	height: 30px;
	border: none;
	background: rgb(232, 232, 232);
}

.q1 {
	font-weight: 500;
	font-size:18px;
}

.phoneCk {
	width: 50px;
	height: 25px;
	border: none;
	background: rgb(138, 4, 179);
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
	background: rgb(138, 4, 179);
	color: white;
	font-weight: 500;
	border-radius: 5px 5px 5px 5px;
	margin: 0 auto;
	cursor: pointer;	
}

#email1 {
	width: 200px;
}

#email2 {
	width: 140px;
	height: 30px;
}

.emailCk {
	width: 50px;
	height: 25px;
	border: none;
	background: rgb(138, 4, 179);
	color: white;
	font-weight: 500;
	border-radius: 5px 5px 5px 5px;
	margin: 0 auto;
	cursor: pointer;
}

#emailCkCode {
	width: 200px;
}

#emailCkCodeCk {
	width: 70px;
	height: 25px;
	border: none;
	background: rgb(138, 4, 179);
	color: white;
	font-weight: 500;
	border-radius: 5px 5px 5px 5px;
	margin: 0 auto;
	cursor: pointer;
}

.addressBtn {
	width: 30px;
	height: 30px;
}

#postcode {
	width: 150px;
}

.addressBtn {
	width: 100px;
	height: 25px;
	border: none;
	background: rgb(138, 4, 179);
	color: white;
	font-weight: 500;
	border-radius: 5px 5px 5px 5px;
	margin: 0 auto;
	cursor: pointer;
}

#bankName {
	width: 140px;
	height: 30px;
	border: 1px solid rgb(138, 4, 179);
}

.accountCk {
	width: 80px;
	height: 25px;
	border: none;
	background: rgb(138, 4, 179);
	color: white;
	font-weight: 500;
	border-radius: 5px 5px 5px 5px;
	margin: 0 auto;
}

#createBtn {
	width: 440px;
	height: 60px;
	background: rgb(138, 4, 179);
	color: white;
	margin: 0 auto;
	border-radius: 5px 5px 5px 5px;
	border: none;
	font-size: 18px;
	cursor: pointer;
}
.aName{
	width:150px;
	margin-left:60px;
}
#lb5{
	font-size:14px;
	color:rgb(138, 4, 179);
}
#men{
	width:150px;
	height:40px;
	border: 2px solid rgb(138, 4, 179);
	display:inline-flex;
	margin-left:0px;
	align:center;
	font-size:16px;
}
 #women{
 	width:150px;
	height:40px;
	border: 2px solid rgb(138, 4, 179);
	display:inline-flex;
	margin-left:45px;
	font-align:center;
	font-size:16px;
 }
 .userNoStyle{
 	font-align:center;
 	border:none;
 	font-weight:600;
 	outline:none;
 	text-align:center;
 	background:rgb(232, 232, 232);
 }
</style>
</head>
<body>
	<%@ include file="../common/B_UserMainHeader.jsp"%>
	<section id="section" style="margin-bottom: 0px;">
		<div style="margin-top: 70px;">
			<div class="checkText">
				<label>회원가입</label>
			</div>
			<br>
			<div class="checkBar"></div>
			<div>
				<form action="<%= request.getContextPath()%>/memberCreate.me" method="post" class="createUserForm" id="createUserForm">
					<table class="createTable">
						<tr height="10px"></tr>

						<tr>
							<td height="0px"><label class="q1">아이디</label></td>
						</tr>
						<tr>
							<td><input type="text" id="userId" name="userId"
								class="input1"></td>
						</tr>
						<tr id="id1" style="visibility:hidden"><td id="idC">sss</td></tr>

						<tr height="0px"></tr>
 
						<tr>
							<td height="0px"><label class="q1">비밀번호</label></td>
						</tr>
						<tr>
							<td><input type="password" id="password1" name="password1"
								class="input1"></td>
						</tr>
						<tr id="pwd1" style="visibility:hidden"><td id="pwdC" >sss</td></tr>
						<tr height="0px"></tr>
						<tr>
							<td height="0px"><label class="q1">비밀번호 확인</label></td>
						</tr>
						<tr>
							<td><input type="password" id="password2" name="password2"
								class="input1"></td>
						</tr>
						<tr><td><label id="lb5">비밀번호 8~16자리 (영어 대소문자, 숫자, 특수문자 포함)</label></td></tr>
						<tr height="20px"></tr>

						<tr>
							<td height="0px"><label class="q1">이름</label></td>
						</tr>
						<tr>
							<td><input type="text" id="userName" name="userName"
								class="input1"></td>
						</tr>
						<tr id="name1"style="visibility:hidden" ><td id="nameK" style="color:red;">ss</td></tr>
						<tr height="20px"></tr>

						<tr>
							<td height="0px"><label class="q1">생년월일</label></td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td id="brithBtn"><input type="hidden" id="userNo" name="userNo"
								class="input1">
									<select id="year" class="userNoStyle" style="width:130px; height: 30px;" >
										<option style="background-color:white;">년도</option>
									</select>
									<select id="month" class="userNoStyle" style="width:105px; height: 30px;">
										<option>월</option>
									</select>
									<select id="day" class="userNoStyle" style="width:105px; height: 30px;">
										<option>일</option>
									</select>
								</td>
								
						</tr>
						<tr id="brith1"style="visibility:hidden" ><td id="brithK" style="color:red;">ss</td></tr>

						<tr height="20px"></tr>

						<tr>
							<td height="0px">
								<div id="men"><label style="margin:0 auto; margin-top:8px; font-weight:600;">남성</label></div><div id="women"><label style="margin:0 auto; margin-top:8px; font-weight:600;">여성</label></div>							
							</td>
						</tr>
						<tr>
						<td>
							 <input type="text" id="gender" name="gender" style="width: 15px; height: 15px; margin-left: 70px; display:none; background: black;">
								
						</td>
						<tr>

						<tr height="25px"></tr>

						<tr>
							<td height="0px"><label class="q1">휴대전화번호</label></td>
						</tr>
						<tr>
							<td><select name="phone1" id="phone1"
								style="width: 90px; height: 30px; border: none; background: rgb(232, 232, 232);">
									<option selected>010</option>
									<option>011</option>
									<option>016</option>
							</select> - <input type="text" class="input1" id="phone2" name="phone2" autocomplete=off style="width: 110px;">
								- <input type="text" class="input1" name ="phone3" id="phone3" autocomplete=off style="width: 110px;">
								<input type="button" value="인증" class="phoneCk" id="phoneCk"></td>
						</tr>
						<tr></tr>
						<tr>
							<td><label class="q1">휴대전화 인증번호</label></td>
						</tr>
						<tr>
							<td><input type="text" id="phoneCkCode" name="phoneCkCode" autocomplete=off
								class="input1"> <input type="button" value="인증확인"
								class="phoneCkCodeCk" id="phoneCkCodeCk">
								<label id="timer1" style="color:purple"></label></td>
						</tr>
						<tr height="25px"></tr>
						<tr>
							<td height="0px"><label class="q1">이메일</label></td>
						</tr>
						<tr>
							<td><input type="text" id="email1" name="email1" autocomplete=off
								class="input1"> <select name="email2" id="email2" style="border:none; background: rgb(232, 232, 232);">
									<option selected>@naver.com</option>
									<option>@gmail.com</option>
									<option>@daum.net</option>
							</select> <input type="button" value="인증" class="emailCk" id="emailCk"></td>
						</tr>
						<tr>
							<td><label class="q1">이메일 인증번호</label></td>
						</tr>
						<tr>
							<td><input type="text" id="emailCkCode" name="emailCkCode" autocomplete=off
								class="input1"> <input type="button" value="인증확인"
								class="emailCkCodeCk" id="emailCkCodeCk">
								<label id="timer" style="color:purple"></label>
								</td>
						</tr>
						<tr height="25px"></tr>
						<tr>
							<td><label class="q1">주소</label></td>
						</tr>
						<tr>
							<td><input type="text" id="postcode" name="postcode" readonly
								placeholder="우편번호" class="input1"> <input type="button"
								class="addressBtn" onclick="sample4_execDaumPostcode();"
								value="우편번호 찾기"></td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td><input type="text" id="roadAddress" name="roadAddress" readonly
								placeholder="도로명주소" class="input1"></td>
						</tr>

						<tr>
							<td><input type="text" id="jibunAddress" class="input1" readonly
								placeholder="지번주소"></td>
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
							</select><input type="text" class="input1 aName" name="accountName" id="accountName" placeholder="예금주명"></td>
						</tr>
						<tr>
							<td><input type="text" id="account" name="account"
								class="input1"> <!-- <input type="button" value="계좌인증" 
								class="accountCk" id="accountCk"> --></td>
						</tr>
						<tr height="60px"></tr>
			
						<tr>
							<td><input type="button" value="가입하기" id="createBtn"></td>
						</tr> 
					</table>
				</form>
				
				
				<script>  
          		//아이디 중복확인 함수
          		var emailCode = "";
          		var phoneCode = "";
          		var timer = "";
          		var idResult =11;
          		var pwdResult =11;
          		var nameResult =11;
          		var phoneResult =11;
          		var emailResult =11;
          	 	$(function(){
          	 		$(function(){
          		 		$("#userId").focus(function(){
          		 			$("#userId").val("");
          		 			$("#id1").attr("style","visibility:hidden");
          		 			$("#idC").html("asdaa");
          		 			idResult = 11;
          		 		});
          		 	});
          	 		$("#userId").keyup(function(){
          	 			var regExp = /^[a-z][a-z\d]{5,11}$/;
          	 			if($("#userId").val() !=""){
          	 			if(regExp.test($("#userId").val())){
          	 			 $.ajax({
          	 				type:"POST",
          	 				url :'<%= request.getContextPath() %>/idCheck.me',
          	 				async: false,
          	 				data:{
          	 					"userId" : $("#userId").val()
          	 				},
          	 				 success:function(data){
          	 					 if(data==1){
          							$("#idC").css("color","red");
          							$("#idC").html("중복된 아이디입니다.");
          							$("#id1").attr("style","visibility:visible");
          							idResult = 10;
          	 					 }else{
          	 						$("#idC").css("color","green");
          							$("#idC").html("사용 가능한 아이디 입니다.");
          							$("#id1").attr("style","visibility:visible");
          							idResult = 0;
          	 					 }
          	 					
          	 				 }
          	 			});
          	 			
          	 			}else{
          	 				$("#idC").css("color","red");
          					$("#idC").html("아이디 형식을 다시 입력해주세요");
          					$("#id1").attr("style","visibility:visible");
          					idResult = 10;
          	 			}
          	 			}
          	 			});
          	 		
          	 	});
          	 	
          	 	
          	 	$(function(){
          	 		$("#password1").focus(function(){
          	 			$("#password1").val("");
          	 			$("#password2").val("");
          	 			$("#pwd1").attr("style","visibility:hidden");
          	 			pwdResult = 11;
          	 		});
          	 	});
          	 	$(function(){
          	 		$("#password2").blur(function(){
          		 		var pwd1 = $("#password1").val();
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
          					pwdResult = 10;
          		 		
          		 		}else if(result == 11){
          		 			$("#pwdC").css("color","red");
          					$("#pwdC").html("비밀번호 형식을 확인해주세요.");
          					$("#pwd1").attr("style","visibility:visible");
          					pwdResult = 10;
          		 		}else if(result == 99){
          		 			$("#pwdC").css("color","green");
          					$("#pwdC").html("비밀번호가 일치되었습니다.");
          					$("#pwd1").attr("style","visibility:visible");
          					pwdResult = 0;
          		 		}
          		 	}
          		 	});
          	 	});
          	 	
          	 	//이름 유효성검사
          	 	$("#userName").keyup(function(){
          	 		var regExp = /^[가-힣]{2,4}$/;
				if($("#userName").val() != ""){	
          	 		if(!regExp.test($(this).val())){
          	 				$("#nameK").css("color","red");
							$("#nameK").html("잘못된 이름입니다.");
							$("#name1").attr("style","visibility:visible");
							nameResult=11;
          	 		}else{
          	 				$("#nameK").css("color","green");
							$("#nameK").html("올바른 이름입니다.");
							$("#name1").attr("style","visibility:visible");
							nameResult=0;
          	 		}
          	 	
				}
          	 	}).focus(function(){
					$("#nameK").css("color","red");
					$("#name1").attr("style","visibility:hidden");
					$("#userName").val("");
					nameResult=10;
          	 	
          	 	});
          	 	
          	 	//생년월일 유효성 검사
          	 	$("#userNo").blur(function(){
          	 		var regExp = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/

				 if($("#userNo").val() != ""){	
          	 		if(!regExp.test($(this).val())){
          	 				$("#brithK").css("color","red");
							$("#brithK").html("잘못된 생년월일입니다.");
							$("#brith1").attr("style","visibility:visible");
							brithResult = 11;
          	 		}else{
          	 				$("#brithK").css("color","green");
							$("#brithK").html("올바른 생년월일입니다.");
							$("#brith1").attr("style","visibility:visible");
							brithResult = 0;
          	 		}
          	 	
				}
          	 	}).focus(function(){
					$("#brithK").css("color","red");
					$("#brith1").attr("style","visibility:hidden");
					$("#userNo").val("");
					brithResult = 10;
          	 	});
          	 	
          	 	
          	 	//성별 확인
          	 	$("#men").click(function(){
          	 		$(this).css("background", 'rgb(138, 4, 179)');
          	 		$(this).css("color", 'white');
          	 		$("#women").css("background", "white");
          	 		$("#women").css("color", "black");
          	 		$("#gender").val("M");
          	 	});

          	 	$("#women").click(function(){
          	 		$(this).css("background", 'rgb(138, 4, 179)');
          	 		$(this).css("color", 'white');
          	 		$("#men").css("background", "white");
          	 		$("#men").css("color", "black");
          	 		$("#gender").val("F");
          	 	});
          	 	
          	 	
	
          	 	
          	 	//휴대폰 번호를 받아서 인증 번호 보내기 함수
          	 	$("#phoneCk").click(function(){
          	 		var regExp = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
          	 		var phone = $("#phone1").val() + $("#phone2").val() + $("#phone3").val();
          	 		if(regExp.test(phone)){
          	 			$.ajax({
          	 				type:"post",
          	 			    url :"<%= request.getContextPath() %>/sms", 
          	 				async: false,
          	 				data:{
          	 					"phone" : phone
          	 				},
          	 				 success:function(data){
          	 					alert("휴대폰 인증번호가 발송되었습니다.");
          	 					phoneCode = data;
               					var min =3;
               		 			var sec=0;
               		 			$("#phoneCk").attr('disabled', 'true').css('background','gray');
               		 			$("#phone1").prop('readonly', true).css('background','gray');
               		 			$("#phone2").prop('readonly', true).css('background','gray');
               		 			$("#phone3").prop('readonly', true).css('background','gray');
               					  timer = setInterval(function(){
               			 			if(sec < 10){
               			 				sec = "0" + sec;
               			 			}
               			 			$("#timer1").html(min + " : " + sec);
               			 			sec--;
               			 		
               			 			if(min==0 && sec<0){
               			 				
               			 				clearInterval(timer);
               			 				phoneCode = "";
               			 				$("#timer1").html("");
               			 				alert("휴대폰 인증 시간이 초과되었습니다.");
               			 				$("#phoneCk").attr('disabled', false).css('backgroundColor','rgb(138, 4, 179)');
                   		 				$("#phone2").prop('readonly', false).css('backgroundColor','rgb(232, 232, 232)');
                   		 				$("#phone1").prop('readonly', false).css('backgroundColor','rgb(232, 232, 232)');
                   		 				$("#phone3").prop('readonly', false).css('backgroundColor','rgb(232, 232, 232)');
               			 			}
               			 			
               			 			if(sec<0){
               			 				min--;
               			 				sec =59;
               			 			}
               			 		},1000);
          	 				 }
          	 			});
          	 		}else{
          	 			alert("휴대폰번호를 다시 입력해주세요");
          	 		}
          	 	});
          	//휴대폰에 전송한 인증번호와 일치하는지 확인하는 함수
          	 	$("#phoneCkCodeCk").click(function(){
          	 	    if(phoneCode!=""){
          	 		var phoneNo = $("#phoneCkCode").val();
          	 		
          	 		if(phoneNo == phoneCode){
          	 			alert("휴대폰 인증이 완료 되었습니다.");
          	 			phoneResult=0;
          	 			phoneCode= "";
          	 			$("#phoneCkCode").attr('disabled', 'true');
          	 			$("#phoneCkCodeCk").val("인증완료");
          	 			$("#phoneCkCodeCk").attr('disabled', 'true');
          	 			$("#phoneCkCodeCk").css('background','gray');
          	 			clearInterval(timer);
          	 			$("#timer1").html("");
          	 		}else{
          	 			alert("휴대폰 인증 실패!!");
          	 			$("#timer1").html("");
          	 			
          	 		}
          		 }else{
          		 		alert("휴대폰 인증 요청을 해주세요!!")
          		 		$("#timer1").html("");
          		 	}
          	 	});
          	 	
          	 	
          	 	
          	 	//이메일을 입력받아 전송하는 함수
          	 	$("#emailCk").click(function(){
          	 		var email = $("#email1").val()+$("#email2").val();
          	 		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
          	 		if($("#email1").val() != "" &&$("#email1").val() != null && regExp.test(email)){
          	 		$.ajax({
           				type:"POST",
           				url :'<%= request.getContextPath() %>/emailCk.me',
           				async: false,
           				data:{
           					"email" : email
           				},
           				 success:function(data){
           					emailCode = data;
           					alert("인증메일이 전송되었습니다.");
           					var min =3;
           		 			var sec=0;
           		 			$("#emailCk").attr('disabled', 'true').css('background','gray');
           		 			$("#email2").prop('readonly', true).css('background','gray');
           		 			$("#email1").prop('readonly', true).css('background','gray');
           					  timer = setInterval(function(){
           				 		
           			 			if(sec < 10){
           			 				sec = "0" + sec;
           			 			}
           			 			$("#timer").html(min + " : " + sec);
           			 			sec--;
           			 		
           			 			if(min==0 && sec<0){
           			 				
           			 				clearInterval(timer);
           			 				emailCode = "";
           			 				$("#timer").html("");
           			 				alert("이메일 인증 시간이 초과되었습니다.");
           			 				$("#emailCk").attr('disabled', false).css('backgroundColor','rgb(138, 4, 179)');
               		 				$("#email2").prop('readonly', false).css('backgroundColor','rgb(232, 232, 232)');
               		 				$("#email1").prop('readonly', false).css('backgroundColor','rgb(232, 232, 232)');
           			 				
           			 			}
           			 			
           			 			if(sec<0){
           			 				min--;
           			 				sec =59;
           			 			}
           			 		},1000);
           				 }
           			});
          	 		}else{
          	 			alert("이메일을 확인해주세요!");
          	 		}
           			});
          	 	
          	 	//이메일에 전송한 인증번호와 일치하는지 확인하는 함수
          	 	$("#emailCkCodeCk").click(function(){
          	 	    if(emailCode!=""){
          	 		var emailNo = $("#emailCkCode").val();
          	 		
          	 		if(emailNo == emailCode){
          	 			alert("이메일 인증이 완료 되었습니다.");
          	 			emailResult=0;
          	 			emailCode= "";
          	 			$("#email").attr('disabled', 'true');
          	 			$("#emailOk").attr('disabled', 'true');
          	 			$("#emailCheck").attr('disabled', 'true');
          	 			$("#emailCkCodeCk").val("인증완료");
          	 			$("#emailCkCodeCk").attr('disabled', 'true');
          	 			$("#emailCkCode").attr('disabled', 'true');
          	 			$("#emailCkCodeCk").css('background','gray');
          	 			clearInterval(timer);
          	 			$("#timer").html("");
          	 		}else{
          	 			alert("이메일 인증 실패!!");
          	 			$("#timer").html("");
          	 			
          	 		}
          		 }else{
          		 		alert("이메일 인증 요청을 해주세요!!")
          		 		$("#timer").html("");
          		 	}
          	 	});
          	 	
          	 	
          	 	$("#createBtn").click(function(){
                	if(idResult == 0 && pwdResult == 0 && nameResult ==0 && $("#gender").val() != ""&&phoneResult==0 &&emailResult==0
                			&&$("#postcode").val()!="" && $("#detailAddress").val() !="" && $("#accountName").val()!="" && $("#account").val() !=""){
                		alert("회원가입에 성공하였습니다.");
                		$("#createUserForm").submit();
                	}else if(idResult == 11){
                		alert("아이디를 입력하세요!");
                	}else if(idResult == 10){
                		alert("아이디가 올바르지 않습니다!");
                	}else if(pwdResult == 11){
                		alert("비밀번호를 입력해주세요!");
                	}else if(pwdResult == 10){
                		alert("비밀번호가 올바르지 않습니다!");
                	}else if(nameResult == 10){
                		alert("이름을 입력해주세요!");
                	}else if(nameResult == 11){
                		alert("이름이 올바르지 않습니다!");
                	}else if($("#gender").val() == ""){
                		alert("성별을 선택하여 주세요");
                	}else if(phoneResult == 11){
                		alert("휴대폰 인증을 해주세요!");
                	}else if(emailResult == 11){
                		alert("이메일 인증을 해주세요!");
                	}else if($("#postcode").val()==""){
                		alert("주소를 입력해주세요!");
                	}else if($("#detailAddress").val()==""){
                		alert("상세 주소를 입력해주세요!");
                	}else if($("#accountName").val()==""){
                		alert("예금주명을 입력해주세요!");
                	}else if($("#account").val()==""){
                		alert("계좌를 입력해주세요!");
                	}
                });
          	 	
            //주소명 입력하는 함수
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
	         
	         
	     }
          
           
          	 	
        </script>
        <script>
        var brith = "";
        $(function(){
              	var date = new Date();
              	var year = date.getFullYear()-19;
              	var selectValue = document.getElementById("year");
              	var optionIndex = 0;

              	for(var i=year-100;i<=year;i++){
              			selectValue.add(new Option(i+"년",i),optionIndex++);                        
              	}
              	
              	$("#year").change(function(){
              	var selectMonth = document.getElementById("month"); 
              	var selectDay = document.getElementById("day");
              	var optionIndex = 0;
            	$(this).css("border", "2px solid rgb(138, 4, 179)").css("color", "black").css("background" ,"white"); 
              	$("option").css("background", "white").css("color", "black");
              	
              	$("#month").empty();
              	for(var i=1;i<=12;i++){
              		selectMonth.add(new Option(i+"월",i),optionIndex++);
          		
          		}
              	$("#day").empty();
              		for(var i=1;i<=29;i++){
              			selectDay.add(new Option(i+"일",i),optionIndex++);

              	}
              		
              	});
              	
              	
              	 
              	$("#month").change(function(){
	              	var selectMonth = document.getElementById("month").value;  
              	 	var selectDay = document.getElementById("day");
              	 	var selectValue = document.getElementById("year").value;
                  	$("#day").empty();
                	var optionIndex = 0;
              	 	if(selectValue % 4 == 0 && selectMonth == 2 ){
                  		for(var i=1;i<=29;i++){

                  			selectDay.add(new Option(i+"일",i),optionIndex++);

                  	}
                  	}else if(selectMonth==2 ){
                  		var optionIndex = 0;

                  		for(var i=1;i<=28;i++){

                  			selectDay.add(new Option(i+"일",i),optionIndex++);

                 	 	}
    					              		
                  	}else{
                  		var optionIndex = 0;

                  		for(var i=1;i<=31;i++){

                  			selectDay.add(new Option(i+"일",i),optionIndex++);

                  		}
                  	}
              	 	$(this).css("border", "2px solid rgb(138, 4, 179)").css("color", "black").css("background" ,"white"); 
                  	$("option").css("background", "white").css("color", "black");
              	 });
              	 
				$("#year").change(function(){
					var month = $("#month").val();
					var day = $("#day").val();
					
					if($("#month").val()>0 && $("#month").val()<13 && $("#day").val()<31 && $("#day").val()>0 ){
						if(month > 0 && month <10){
							month = "0" + month;
						}
						if(day >0 && day<10){
							day = "0" + day;
						}
						
						brith = $("#year").val().substring(2,4) +month + day;
						$("#userNo").val(brith);
					}
				});
				
				
				$("#month").change(function(){
					var month = $("#month").val();
					var day = $("#day").val();
					
					if($("#month").val()>0 && $("#month").val()<13 && $("#day").val()<31 && $("#day").val()>0 ){
						if(month > 0 && month <10){
							month = "0" + month;
						}
						if(day >0 && day<10){
							day = "0" + day;
						}
						
						brith = $("#year").val().substring(2,4) +month + day;
						$("#userNo").val(brith);
					}
				});
				$("#day").change(function(){
					var month = $("#month").val();
					var day = $("#day").val();
					
					if($("#month").val()>0 && $("#month").val()<13 && $("#day").val()<31 && $("#day").val()>0 ){
						if(month > 0 && month <10){
							month = "0" + month;
						}
						if(day >0 && day<10){
							day = "0" + day;
						}
						
						brith = $("#year").val().substring(2,4) +month + day;
						$("#userNo").val(brith);
					}

					$(this).css("border", "2px solid rgb(138, 4, 179)").css("color", "black").css("background" ,"white"); 
	              	$("option").css("background", "white").css("color", "black");
				});

        });
      

        </script>
			</div>
		</div>
	</section>
	<%@ include file="../common/B_UserMainFooter.jsp"%>
</body>
</html>