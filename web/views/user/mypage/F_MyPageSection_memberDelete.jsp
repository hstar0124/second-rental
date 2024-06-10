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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	.emailText{
		margin-left:30px;
		font-weight:600;
	}
	.pwdRange{
		margin-left:18px;
		width:300px;
		height:40px;
		border-radius: 10px 10px 10px 10px;
		border: none;
		font-size:18px;
		text-align:center;
		outline:none;
		caret-color:#6E00AB;
		background: rgb(232, 232, 232);
		
	}
	.text1{
		margin-left:10px;
	}
	#myInfo{
		background:#6E00AB;
		color:white;
	}
	#emailCheckBtn{
		width:70px;
		height:30px;
		background:#6E00AB;
		border:none;
		color:white;
		border-radius: 5px 5px 5px 5px;
		margin-left:10px;
		cursor: pointer;
	}
	#emailCode{
		margin-left:87px;
		width:200px;
		height:30px;
		border-radius: 10px 10px 10px 10px;
		border: 2px solid gray;
		text-indent: 16px;
		font-size:18px;
		text-align:center;
		outline:none;
		caret-color:#6E00AB;
	}
	#emailCodeCkBtn{
		width:70px;
		height:30px;
		background:#6E00AB;
		border:none;
		color:white;
		border-radius: 5px 5px 5px 5px;
		margin-left:10px;
		cursor: pointer;	
	}
	#nextBtn{
		width:130px;
		height:50px;
		margin-left:150px;
		border:none;
		border-radius: 20px 20px 20px 20px;
		background: rgb(232, 232, 232);
		color:white;
		font-weight:600;
		font-size:20px;
		outline:none;
		cursor: pointer;
	}
</style>

</head>
<body>

	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>	
		<h1 class="text1">회원 탈퇴</h1>
		<div style="background-color:purple; width:100%; height:4px; margin-top:0px;"></div>
		<div id="updateRange">
			<table id="updateTable">
			<tr><td><label class="updateText">본인 인증</label></td></tr>
			<tr><td><div style="height:2px; width:100%; background:rgb(236, 234, 234); margin-top:10px;"></div></td></tr>
			<tr><td><p id="p1">고객 정보를 안전하게 보호하기 위해 이메일 인증을 진행합니다.<br>
			인증버튼을 누르시면 가입시 인증번호가 발송됩니다.</p></td></tr>
			<tr height="20px"></tr>
			<tr><td><label class="emailText">등록 된 이메일</label></td></tr>
			<tr height="2px"></tr>
			<tr><td><input type="email" class="pwdRange" id="email" name="email" value="<%=selectMember.getEmail() %>" readonly>
			<input type="button" id="emailCheckBtn" value="인증">
			</td></tr>	
			<tr height="10px"></tr>
			<tr id="tr1" style="visibility:hidden"><td><input type="text" id="emailCode"><input type="button" id="emailCodeCkBtn" value="인증완료"></td></tr>
			<tr height="50px"></tr>
			<tr><td><input type="button" id="nextBtn" value="확인" onclick=""></td></tr>
			</table>
		</div>
		<script>
		var emailCode = "";
			$(function(){
				$("#emailCheckBtn").click(function(){
					$("#emailCheckBtn").attr("disabled", true);
					$("#emailCheckBtn").css("background", "rgb(232, 232, 232)");
					$("#tr1").attr("style","visibility:visible");
					
					$.ajax({
						url:'<%= request.getContextPath()%>/userEmailCk.me',
						type:'get',
						data: {"email" : '<%= selectMember.getEmail()%>'},
						success:function(data){
							alert("인증번호가 발송되었습니다");
							emailCode = data;
							console.log(emailCode);
						}
					});
					
				});
				
				$("#emailCodeCkBtn").click(function(){
					if(emailCode ==$("#emailCode").val()){
					alert("인증번호가 확인되었습니다!");
					$("#nextBtn").css("background","#6E00AB");
					$("#nextBtn").attr("onclick","location.href='<%= request.getContextPath()%>/deleteMember.me?num=<%=loginMember.getUserNo()%>'");
				}else{
					alert("인증번호가 일치하지않습니다!!");
				}
				
				});
				
				
			});
		</script>
	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>	

</body>
</html>