<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
</head>
<body>

   <%@ include file="views/user/common/B_UserMainHeader.jsp" %>

   <script>
	   $(function(){
		  location.href = "<%=request.getContextPath()%>/main";
	   });
   </script>
   
   <%@ include file="views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>