<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	.text1{
		margin-top:30px;
	}
	#point1{
	height:0px;
	line-height:30px;
	margin-top:15px;
	margin-left:40px;
	width:200px;
	color:red;
	font-size:24px;
	font-weight:600;
	border:none;
	}
	#deleteTable{
		margin-bottom:200px;
	}
	#return{
		margin-left:410px;
		width:200px;
		height:55px;
		background:#6E00AB;
		border:none;
		border-radius: 10px 10px 10px 10px;
		color:white;
		font-size:23px;
		font-weight:500;
		cursor: pointer;
	}
	#memberDeleteBtn{
		border-radius: 10px 10px 10px 10px;
		background:#16AAD8;
		width:150px;
		height:40px;
		float:right;
		border:none;
		color:white;
		font-size:20px;
		font-weight:500;
		cursor: pointer;
	}
</style>
</head>
<body>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>	
		<h1 class="text1">회원 탈퇴</h1>
		<div style="background-color:purple; width:100%; height:4px; margin-top:0px;"></div>
		<table id="deleteTable">
		<tr height="50px;"></tr>
		<tr><td><div><img src="<%=request.getContextPath()%>/image/userimg/deleteCk.PNG" width="680px" height="170px" style="margin-left:180px;"></div></td></tr>
		<tr height="50px"></tr>
		<tr><td><div style="display:inline-flex;"><img src="<%=request.getContextPath()%>/image/userimg/refundsPoint.PNG" width="220px" height="60px" style="margin-left:290px;">
			<input type="text" id="point1" value="<%= loginMember.getPoint()%> P" style="height:30px;">
		</div>
		</td></tr>
		<tr height="50px"></tr>
		<tr><td><input type="button" id="return" value="돌아가기"  onclick="location.href='<%= request.getContextPath()%>/views/user/mypage/F_MyPageSection_memberInfo.jsp'"></td></tr>
		<tr height="30px"></tr>
		<tr><td><input type="button" id="memberDeleteBtn" value="탈퇴하기"></td></tr>
		</table>
		<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>	
		
		
		
<script>
$("#memberDeleteBtn").click(function(){
	<% if(loginMember.getPoint() > 0) {%>
		var result = confirm("잔여 포인트가 있습니다. 그래도 진행하시겠습니까?");
		
		if(result){
		location.href='<%= request.getContextPath()%>/deleteOne.me?num=<%= loginMember.getUserNo()%>';
		}
	<% } else {%>
		location.href='<%= request.getContextPath()%>/deleteOne.me?num=<%= loginMember.getUserNo()%>';
	<% } %>
});
</script>		
</body>
</html>