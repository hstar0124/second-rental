<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorCode = (String)request.getAttribute("errorCode");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<script>
	
	$(function(){
	<%  if(errorCode.equals("3")) { %>
		alert("모든 정보를 다 입력해 주세요!");
		window.location = "<%= request.getContextPath()%>/views/user/member/F_memberCreate.jsp";
	<% }else if(errorCode.equals("6")){%>	
		alert("정보가 일치하지 않습니다!");
		window.location = "<%= request.getContextPath()%>/views/user/member/F_findUserPwd.jsp";
	<%} else if (errorCode.equals("10")) { %>
		alert("회원 정보가 일치 하지 않습니다!!");
		window.location = "<%= request.getContextPath()%>/views/user/member/F_login.jsp";
	<% } else if(errorCode.equals("11")){ %>
		alert("존재 하지 않는 아이디입니다 !!");
		window.location = "<%= request.getContextPath()%>/views/user/member/F_login.jsp";
	<% }else if (errorCode.equals("12")) { %>
		alert("정보를 입력해주세요 !!");
		window.location = "<%= request.getContextPath()%>/views/user/member/F_findUserId.jsp";
	<% } else if (errorCode.equals("16")) {%>
		alert("비밀번호가 일치 하지않습니다 !!");
		window.location = "<%= request.getContextPath()%>/views/user/mypage/F_MyPageSection_memberUpdate.jsp";
	<% } else if(errorCode.equals("17")){%>
		alert("로그인 실패 5회 오류입니다!");
		window.location = "<%= request.getContextPath()%>/views/user/member/F_login.jsp";
	<% } else if(errorCode.equals("19")) { %> 
		alert("해당 정보가 없습니다!");
		window.location = "<%= request.getContextPath()%>/views/user/member/F_findUserId.jsp";
	<% } else if(errorCode.equals("22")){ %>
		alert("처리 명단이 없습니다!");
		window.location = "<%= request.getContextPath()%>/cashbackAll.po";
	<% } else if(errorCode.equals("30")) {%>
		alert("해당 정보가 일치하지 않습니다 !!");
		window.location = "<%= request.getContextPath()%>/views/admin/F_adminLogin.jsp";
	<% } else if(errorCode.equals("55")) {%>
		alert("처리된 신고 정보입니다!!");
		window.location = "<%= request.getContextPath()%>/reportSelectAll.me";
	<% }else if(errorCode.equals("83")) {%>
		alert("비밀번호가 변경되어 로그아웃됩니다");
		window.location = "<%= request.getContextPath()%>/views/user/member/F_login.jsp";
	<% } else if(errorCode.equals("86")) {%>
		alert("이미 제제된 회원입니다!!");
		window.location = "<%= request.getContextPath()%>/warningMemberSelectAll.me";
	<% }%>
	});
	</script>
</body>
</html>