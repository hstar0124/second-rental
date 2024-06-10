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
		margin-left:400px;
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
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>
		<h1 class="text1">포인트 환급</h1>
		<div style="background-color:purple; width:100%; height:4px; margin-top:0px;"></div>
		<table id="refundsTable">
			<tr height="80px"></tr>
			<tr><td><img width="500px" height="230px" style="margin-left:230px;"src="<%=request.getContextPath()%>/image/userimg/refundsResult.PNG"></td></tr>
			<tr height="30px"></tr>
			<tr><td><input type="button" class="homeBtn" value="돌아가기 >>" onclick="location.href='<%=request.getContextPath()%>/selectListMain.no'"></td></tr>
			<tr height="50px"></tr>
		</table>
		
 	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>
	
</body>
</html>