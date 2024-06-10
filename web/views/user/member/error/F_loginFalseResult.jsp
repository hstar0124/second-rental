<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	#refundsTable{
		width:100%;
		margin:0 auto;
		margin-bottom:100px;
	}
	.homeBtn{
		margin-left:640px;
		width:180px;
		height:50px;
		background:#6E00AB;
		border:none;
		border-radius: 10px 10px 10px 10px;
		color:white;
		font-size:23px;
		font-weight:500;
		cursor: pointer;
	}								
</style>
</head>
<body>
	 <%@ include file="../../common/B_UserMainHeader.jsp" %>
		<h1 class="text1" style="margin-left:180px;">로그인 차단 안내</h1>
		<div style="background-color:purple; width:80%; height:4px; margin-top:0px; margin:0 auto;"></div>
		<table id="refundsTable">
			<tr height="80px"></tr>	
			<tr><td><img width="600px" height="250px" style="margin-left:440px;"src="<%=request.getContextPath()%>/image/userimg/loginFalse.PNG"></td></tr>
			<tr height="50px"></tr>
			<tr><td><input type="button" class="homeBtn" value="돌아가기 >>" onclick="location.href='<%=request.getContextPath()%>/views/user/member/F_login.jsp'"></td></tr>
			<tr height="50px"></tr>
		</table>
		 <hr class="header-hr">
 	 <%@ include file="../../common/B_UserMainFooter.jsp" %>
	
</body>
</html>