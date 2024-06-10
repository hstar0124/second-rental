<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.forest.member.model.vo.Member"%>
<%
	String findId = (String) request.getAttribute("findId");
	String userName = (String) request.getAttribute("userName");
 	String id = "**" + findId.substring(2, findId.length());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	.loginText{
    	font-weight: 900;
    	font-size: 30px;
    	width: 1000px;
    	height: 3px;
    	margin: 0 auto;
    	margin-left: 250px;
    	margin-bottom: 10px;
	}
    .idFindBar{
        background: rgb(138, 4, 179);
        width: 1000px;
        height: 3px;
        margin: 0 auto;
        margin-top: 20px;
    }
    .idFindTable{
        margin: 0 auto;
    }
    .userName{
        width: 450px;
        height: 50px;
        background: rgb(236, 234, 234);
        border-radius: 5px 5px 5px 5px;
        border: none;
        font-size: 20px;
        text-indent: 16px;
    }
    .label1{
    font-size: 18px;
    font-weight: bold;
    color: black;
}
#idFindBtn{
    margin-left: 0px;
    width: 450px;
    height: 80px;
    border-radius: 5px 5px 5px 5px;
    border: none;
    font-size: 25px;
    color: white;
    background: rgb(110, 0, 171);
    cursor: pointer;
}   
#section{
	margin-bottom:150px;
} 
</style>
</head>
<body>
 	<%@ include file="../common/B_UserMainHeader.jsp" %>
		<section id="section">
            <div style="margin-top: 70px;">
                <div class="loginText"><label>아이디 찾기</label></div><br>
                <div class="idFindBar"></div>
               
                        <table class="idFindTable">
                            <tr height="150px"></tr>
                            <% if(!findId.equals("")) { %>
                           	<tr><td><h1 id="h11"><%=userName %> 님의 아이디는 <%=id %> 입니다.</h1></td></tr>
                            <%} else { %>
                            <tr><td><h1>입력 정보로 조회된 아이디가 없습니다!</h1></td></tr>
                            <%} %>
                            <tr height=110px></tr>
                            <tr><td><input type="button" id="idFindBtn" name="home" value="확인" onclick="location.href='<%= request.getContextPath()%>/views/user/member/F_login.jsp'"></td></tr>
                            <tr height="120px"></tr>
                        </table>
                    <script>
                    </script>
                <div class="idFindBar"></div>
            </div>
        </section> 	
    <%@ include file="../common/B_UserMainFooter.jsp" %>
</body>
</html>