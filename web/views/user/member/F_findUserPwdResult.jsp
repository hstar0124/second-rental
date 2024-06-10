<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    .pwdFindBar{
        background: rgb(138, 4, 179);
        width: 1000px;
        height: 3px;
        margin: 0 auto;
        margin-top: 20px;
    }
    .pwdFindTable{
        margin: 0 auto;
    }
    .userId{
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
#pwdFindBtn{
    margin-left: 100px;
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
h1{
	font-weight:400;
}
</style>
</head>
<body>
 	<%@ include file="../common/B_UserMainHeader.jsp" %>
		<section id="section">
            <div style="margin-top: 70px;">
                <div class="loginText"><label>비밀번호 찾기</label></div><br>
                <div class="pwdFindBar"></div>
                    <form>
                        <table class="pwdFindTable">
                            <tr height="100px"></tr>
                           	<tr><td><h1>이메일로 임시 비밀번호를 보내드렸습니다.</h1><br>
                           	<h1>임시비밀번호로 로그인 하신 후 꼭 비밀번호를 변경해 주세요!</h1>
                           	
                           	</td></tr>
                            <tr height=80px></tr>
                            <tr><td><input type="button" id="pwdFindBtn" name="home" value="확인" onclick="location.href='<%= request.getContextPath()%>/views/user/member/F_login.jsp'"></td></tr>
                            <tr height="105px"></tr>
                        </table>
                    </form>
                <div class="pwdFindBar"></div>
            </div>
        </section> 	
    <%@ include file="../common/B_UserMainFooter.jsp" %>
</body>
</html>