<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
int dum =  new Random().nextInt(9)+1;
int num = new Random().nextInt(2)+1;
int rum = new Random().nextInt(9)+1;
char sum = (char) (new Random().nextInt(26)+97);
int aum =  new Random().nextInt(9)+1;
int zum = new Random().nextInt(9)+1;
char wnum = (char) (new Random().nextInt(26)+97);
char pnum = ' ';
char lnum = ' ';
String str = "";
if(num ==1) {
	pnum = (char) (new Random().nextInt(26)+65);
}else {
	pnum = (char) (new Random().nextInt(26)+97);
}

if(zum>=4 && zum<7) {
	lnum = (char) (new Random().nextInt(26)+97);
	str = dum + Character.toString(pnum) + rum + "@" + Character.toString(sum) + aum + lnum + wnum;
}else if(zum<4) {
	lnum = (char) (new Random().nextInt(26)+65);
	str = dum + Character.toString(pnum) + rum + "$"+ Character.toString(sum) + aum + lnum + wnum;
}else {
	str = dum + Character.toString(pnum) + rum + Character.toString(sum) +"!"+ aum + zum + wnum;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
.loginText {
	font-weight: 900;
	font-size: 30px;
	width: 1000px;
	height: 3px;
	margin: 0 auto;
	margin-left: 250px;
	margin-bottom: 10px;
}

.pwdFindBar {
	background: rgb(138, 4, 179);
	width: 1000px;
	height: 3px;
	margin: 0 auto;
	margin-top: 20px;
}

.pwdFindTable {
	margin: 0 auto;
}

.userId {
	width: 450px;
	height: 50px;
	background: rgb(236, 234, 234);
	border-radius: 5px 5px 5px 5px;
	border: none;
	font-size: 20px;
	text-indent: 16px;
}

.label1 {
	font-size: 18px;
	font-weight: bold;
	color: black;
}

#pwdFindBtn {
	margin-left: 0px;
	width: 450px;
	height: 80px;
	border-radius: 5px 5px 5px 5px;
	border: none;
	font-size: 25px;
	color: white;
	background: rgb(110, 0, 171);
}

#section {
	margin-bottom: 150px;
}
</style>
</head>
<body>
	<%@ include file="../common/B_UserMainHeader.jsp"%>
	<section id="section">
		<div style="margin-top: 70px;">
			<div class="loginText">
				<label>비밀번호 찾기</label>
			</div>
			<br>
			<div class="pwdFindBar"></div>
			<form action="<%= request.getContextPath()%>/findPwd.me"
				method="post">
				<table class="pwdFindTable">
					<tr><td><input type="password" id="password1" name="password1" style="display: none" value="<%= str%>"></td></tr>
					<tr><td><input type="password" id="password" name="password" style="display: none" value="<%= str%>"></td></tr>
					<tr height="70px"></tr>
					<tr>
						<td><label class="label1">&nbsp;아이디</label></td>
					</tr>
					<tr></tr>
					<tr>
						<td><input type="text" class="userId" id="userId"
							name="userId"></td>
					</tr>
					<tr height="30px"></tr>
					<tr>
						<td><label class="label1">&nbsp;등록 한 이메일</label></td>
					</tr>
					<tr></tr>
					<tr>
						<td><input type="email" class="userId" id="email"
							name="email"></td>
					</tr>
					<tr height=70px></tr>
					<tr>
						<td><input type="submit" id="pwdFindBtn" name="pwdFindBtn"
							value="비밀번호 찾기"></td>
					</tr>
					<tr height="115px"></tr>
				</table>
			</form>
			<div class="pwdFindBar"></div>
		</div>
	</section>
	<%@ include file="../common/B_UserMainFooter.jsp"%>
</body>
</html>