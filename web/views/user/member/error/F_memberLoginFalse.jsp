<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String errorCode = (String)request.getAttribute("errorCode");
	int logCount = (int) request.getAttribute("logCount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<script>
	$(function(){
		<%	if(errorCode.equals("10")){%>
				alert("회원 정보가 일치 하지않습니다!\n비밀번호 <%= logCount + 1%>회 오류입니다.");
				window.location = "<%= request.getContextPath()%>/views/user/member/F_login.jsp";
		<% } %>
	});

</script>

</body>
</html>