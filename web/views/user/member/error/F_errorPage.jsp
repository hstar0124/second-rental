<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String errorCode = request.getParameter("errorCode");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<script>
	$(function(){
		<%	if(errorCode.equals("17")){%>
			alert("로그인 5회 실패로 로그인이 불가합니다!"); 
			window.location = "<%= request.getContextPath()%>/views/user/member/error/F_loginFalseResult.jsp";
		<% }else if(errorCode.equals("18")) { %>
			alert("제제된 회원입니다!"); 
			window.location = "<%= request.getContextPath()%>/views/user/member/F_login.jsp";
		<% }else if(errorCode.equals("82")) { %>
			alert("해당 회원은 경고 3회 누적으로 정지된 계정입니다!"); 
			window.location = "<%= request.getContextPath()%>/views/user/member/F_login.jsp";
		<% } %>
	});

</script>

</body>
</html>