<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	#section{
		width:1100px;
		height:800px;
		margin: 0 auto;
	}
	.idDeleteBar{
		width:100%;
		height:3px;
		background:rgb(138, 4, 179);
	}
	.resultTable{
		width:100%;
		height:100%;
	}
	#deleteText{
		font-size:30px;
		margin-left:20px;
	}
	.imgDelete{
		margin-left:250px;
		margin-top:50px;
	}
	.homeBtn{
		margin-left:450px;
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
</style>
</head>
<body>
	<%@ include file="/views/user/common/B_UserMainHeader.jsp" %>	
	<section id="section">
		<div id="range">
			<table class="resultTable">
			<tr height="50px;"></tr>
			<tr><td><label id="deleteText">탈퇴 완료</label></td></tr>
				<tr><td><div class="idDeleteBar"></div></td></tr>
				<tr><td><img src="<%=request.getContextPath()%>/image/userimg/userDeleteImg.PNG" width="600px" height="300px" class="imgDelete"></td></tr>
				<tr height="20px"></tr>
				<tr><td><input type="button" class="homeBtn" value="돌아가기 >>" onclick="location.href='<%= request.getContextPath()%>/logOut.me'"></td></tr>
			</table>
		</div>
	
	</section>
	
	
	
	<%@ include file="/views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>