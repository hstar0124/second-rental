<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	#updateRange{
		margin:0 auto;
		width:450px;
		height:450px;
		border:2px solid gray;
		margin-top:50px;
		margin-bottom:150px;
		border-radius: 10px 10px 10px 10px;
	}
	#updateBar{
		
	}
	.text1{
		margin-top:30px;
	}
	#updateTable{
	margin:0 auto;
	width:100%;
	margin-top:10px;
	}
	.updateText{
		font-size:28px;
		font-weight:400;
		color:#6E00AB;
		margin-left:10px;
		margin-top:10px;
	}
	#p1{
		font-size:13.5px;
		color:gray;
		font-weight:600;
		margin-left:3px;
	}
	.pwdText{
		margin-left:30px;
		font-weight:600;
	}
	.pwdRange{
		margin-left:18px;
		width:400px;
		height:40px;
		border-radius: 10px 10px 10px 10px;
		border: 2px solid gray;
		text-indent: 16px;
		font-size:30px;
		outline:none;
		caret-color:#6E00AB;
		color:#6E00AB;
	}
	#pwdCkBtn{
		width:130px;
		height:50px;
		margin-left:150px;
		border:none;
		border-radius: 20px 20px 20px 20px;
		background:#6E00AB;
		color:white;
		font-weight:600;
		font-size:20px;
		outline:none;
		cursor: pointer;
	}
	.text1{
		margin-left:10px;
	}
	#myInfo{
		background:#6E00AB;
		color:white;
	}
	
	#lb3{
		color:red;
		margin-left:30px;
	}
</style>

</head>
<body>

	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>	
		<h1 class="text1">나의 정보</h1>
		<div style="background-color:#6E00AB; width:100%; height:4px; margin-top:0px;"></div>
		<div id="updateRange">
		<form action="<%= request.getContextPath() %>/checkPwd.me?id=<%=loginMember.getUserId() %>" method="post">
			<table id="updateTable">
			<tr><td><label class="updateText">회원 정보 확인</label></td></tr>
			<tr><td><div style="height:2px; width:100%; background:rgb(236, 234, 234); margin-top:10px;"></div></td></tr>
			<tr><td><p id="p1">고객 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인합니다.
				비밀번호 입력 후 확인 버튼을 눌러 주세요.</p></td></tr>
			<tr height="50px"></tr>
			<tr><td><label class="pwdText">비밀번호</label></td></tr>
			<tr height="2px"></tr>
			<tr><td><input type="password" class="pwdRange" id="password1" name="password1"></td></tr>	
			<tr><td><label id="lb3" style="visibility:hidden">ss</label></td></tr>
			<tr height="55px"></tr>
			<tr><td><input type="submit" id="pwdCkBtn" value="확인"></td></tr>
			</table>
			</form>
		</div>
	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>	
<script>
	$(function(){
		$("#password1").blur(function(){
			var regExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
			var pwd = $("#password1").val();
			
			if(pwd==""){
				$("#lb3").text("비밀번호를 입력해주세요.")
				$("#lb3").attr("style","visibility:visible");
				$("#pwdCkBtn").attr('disabled', 'true').css('background','gray');
			}else if(!regExp.test(pwd)){
				$("#lb3").text("비밀번호 형식이 맞지 않습니다.")
				$("#lb3").attr("style","visibility:visible");
				$("#pwdCkBtn").attr('disabled', 'true').css('background','gray');
			}
		});
		
		$("#password1").focus(function(){
			$("#password1").val("");
			$("#lb3").attr("style","visibility:hidden");
			$("#pwdCkBtn").attr('disabled', false).css('background','#6E00AB');
		});
		
		$("#pwdCkBtn").click(function(){
			if($("#password1").val() ==""){
				$("#lb3").text("비밀번호를 입력해주세요")
				$("#lb3").attr("style","visibility:visible");
				$("#pwdCkBtn").attr('disabled', 'true').css('background','gray');
			}
		});
	});
</script>

</body>
</html>