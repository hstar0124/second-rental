<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	body{
	background:#354052;
}
#mainPage {
	margin: 0 auto;
	background:#354052;
	border:1px solid white;
	margin-top:300px;
}
#loginTable{
	margin:0 auto;
	width:100%;
	align:center;
}
#mainTitle{
	font-weight:700;
	font-size:28px;
	color:white;
	margin-left:250px;
}
.input1{
	margin-left:100px;
	width:400px;
	height:40px;
	outline:none;
	text-indent: 12px;
	font-size: 18px;
}
#loginBtn{
	width:400px;
	height:40px;
	background:#16AAD8;
	border:none;
	color:white;
	margin-left:100px;
	cursor: pointer;
}
.input1:focus{
	outline:none;
}
</style>
</head>
<body>
	<div id="mainPage" style="width: 600px; height: 400px;">
	<form action="<%=request.getContextPath()%>/adminLogin.em" method="post">
		<table id="loginTable">
		<tr height="40px"></tr>
			<tr><td><label id="mainTitle">중고구마</label></td></tr>	
			<tr height="30px"></tr>
			<tr><td><input type="text" id="adminId" name="adminId" class="input1" placeholder="아이디"></td></tr>
			<tr height="20px"></tr>
			<tr><td><input type="password" id="adminPwd" name="adminPwd" class="input1" placeholder="비밀번호"></td></tr>
			<tr height="50px"></tr>
			<tr><td><input type="submit" value="Login" id="loginBtn"></td></tr>
		</table>
	</form>
	
	</div>
</body>
</html>