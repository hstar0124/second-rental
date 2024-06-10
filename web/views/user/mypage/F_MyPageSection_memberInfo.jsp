<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
    background: #E8E8E8;
    font-weight:600;
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
    cursor: pointer;
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
        	height:450px;
        }
        .modal-content1 {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 0px;
            border: 1px solid #888;
            width: 500px; /* Could be more or less, depending on screen size */                          
        	height:450px;
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
		background: #16AAD8;
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
	background:#16AAD8;
	border:none;
	outline:none;
	color:white;
	height:28px;
	border-radius: 3px 3px 3px 3px;
}
#ckOkBtn{
	background:#16AAD8;
	border:none;
	outline:none;
	color:white;
	height:40px;
	width:120px;
	margin-left:195px;
}
.modal-content p {
	color: white;
	margin: 0px;
	padding-top: 15px;
	font-size: 17px;
}
#newPasswordBtn{
	background: rgb(232, 232, 232);
	color:white;
	font-size: 14px;
	border:none;
	border-radius: 3px 3px 3px 3px;
	width:110px;
	height:25px;
}
</style>
</head>
<body>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
	<div id="front"><h1 class="text1">나의 정보 수정 </h1><button type="button" id="memberDeleteBtn">
	<img src="<%=request.getContextPath()%>/image/userimg/memberDelete.PNG" width="100%" height="30px">
	</button></div> 
	<div
		style="background-color: purple; width: 100%; height: 4px; margin-top: 0px;"></div>
	<div>
			<table class="updateTable">
				<tr height="10px"></tr>
				<tr height="25px"></tr>
				<tr><td><label class="q1">아이디(고객명)</label></td></tr>
				<tr><td><input type="text" class="input1" style="text-indent: 10px; " readonly value="<%=loginMember.getUserId() %>(<%=loginMember.getUserName() %>)"></td></tr>
				<tr height="25px"></tr>
				<tr>
					<td height="0px"><label class="q1">휴대전화번호</label></td>
				</tr>
				<tr>
					<td><select name="phone1" id="phone1" disabled
						style="width: 90px; height: 30px; border: none;  text-indent: 24px; background: rgb(232, 232, 232);">
							<option selected>010</option>
							<option>011</option>
							<option>016</option>
					</select> - <input type="text" id="phone2" class="input1" readonly style="width: 110px; text-indent: 30px; ">
						- <input type="text"  id="phone3" class="input1" readonly style="width: 110px; text-indent: 30px; ">
						</td>
				</tr>
				
				<tr height="25px"></tr>
				<tr>
					<td height="0px"><label class="q1">이메일</label></td>
				</tr>
				<tr>
					<td><input type="email" id="email1" name="email1" style="text-indent: 10px;"  readonly
						class="input1"> <select name="email2" id="email2" style="background:rgb(232, 232, 232); border:none;" disabled>
							<option name="naver" selected>@naver.com</option>
							<option name= "google">@gmail.com</option>
							<option name= "daum">@daum.net</option>
					</select> </td>
				</tr>
				<tr height="25px"></tr>
				<tr>
					<td><label class="q1">주소</label></td>
				</tr>
				<tr>
					<td><input type="text" id="postcode" name="postcode" style="text-indent: 10px;" readonly
						placeholder="우편번호" class="input1"> </td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td><input type="text" id="roadAddress" name="roadAddress" style="text-indent: 10px;" readonly
						placeholder="도로명주소" class="input1"></td>
				</tr>

				
				<span id="guide" style="display: hide"></span>
				<tr height="5px"></tr>
				<tr>
					<td><input type="text" id="detailAddress" class="input1" readonly style="text-indent: 10px;"
						name="detailAddress" placeholder="상세주소"></td>
				</tr>
				<tr height="25px"></tr>
				<tr>
					<td><label class="q1">은행명</label></td>
				</tr>
				<tr>
					<td><select name="bankName" id="bankName" style="background:rgb(232, 232, 232); border:none;" disabled>
							<option selected>국민은행</option>
							<option>우리은행</option>
							<option>신한은행</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="text" id="account" name="account" style="text-indent: 10px;" readonly value="<%= loginMember.getAccount() %>"
						class="input1"> 
				</tr>
				<tr height="60px"></tr>
				<tr>
					<td><input type="button" value="수정하기" id="updateBtn" onclick="location.href='<%= request.getContextPath() %>/selectForm.me?num=<%=loginMember.getUserNo() %>'"></td>
				</tr>
			</table>
	</div>

	
	<script>
		var pon = "<%= loginMember.getPhone()%>";
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
		
		
		var email = "<%= loginMember.getEmail()%>";
		var com = $("#email2").val();
		var e = email.split("@");
		var option = $("option").val();
		$("#email1").val(e[0]);
		$("#email2>option").filter(function(){
			if("@"+e[1] == $(this).val()){
				$(this).attr("selected",true);
			}
		});
		
		var ads = "<%= loginMember.getAddress()%>";
		var address = ads.split("$");
		
		$("#postcode").val(address[0]);
		$("#roadAddress").val(address[1]);
		$("#detailAddress").val(address[2]);
		
		var bn = "<%= loginMember.getBank()%>";
		$("#bankName>option").filter(function(){
			if(bn == $(this).val()){
				$(this).attr("selected",true);
			}
		});
		

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
				 }
				
	 		});
	 		}
	});
	
		$("#emailOkBtn").click(function(){
			if(emailCode == $("#newEmailCkCode").val()){
				var email = $("#newEmail").val()+$("#newEmail2").val();
				var e = email.split("@");
				var option = $("option").val();
				$("#email1").val(e[0]);
				$("#email2>option").filter(function(){
					if("@"+e[1] == $(this).val()){
						$(this).attr("selected",true);
					}
				});
				 modal.style.display = "none";
			}else{
				alert("인증번호가 일치하지않습니다!");
			}
		});
	});
	</script>
	<script>
			$("#memberDeleteBtn").click(function(){
					location.href='<%= request.getContextPath()%>/views/user/mypage/F_MyPageSection_memberDeleteInfo.jsp';
			});
			
	</script>
	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp"%>
</body>
</html>