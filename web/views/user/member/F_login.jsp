<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
.loginBar{
    background: rgb(138, 4, 179);
    width: 1000px;
    height: 3px;
    margin: 0 auto;
    margin-top: 20px;
}
.loginText{
    font-weight: 900;
    font-size: 30px;
    width: 1000px;
    height: 3px;
    margin: 0 auto;
    margin-left: 250px;
    margin-bottom: 10px;
}
.loginForm{
    height: 450px;
    margin-top: 30px;
}
.loginTable{
    margin: 0 auto;
}
.idText{
    width: 450px;
    height: 50px;
    background: rgb(236, 234, 234);
    border-radius: 5px 5px 5px 5px;
    border: none;
    font-size: 20px;
    text-indent: 16px;
    outline:none;
}
.idLabel{
    font-size: 18px;
    font-weight: bold;
    color: black;
}
.loginBtn{
    margin-left: 0px;
    width: 450px;
    height: 80px;
    border-radius: 5px 5px 5px 5px;
    border: none;
    font-size: 25px;
    color: white;
    background: rgb(110, 0, 171);
    outline:none;
    cursor: pointer;
}

.idFindBtn{
    border:none;
    background: white;
    font-weight: 900;
    color: gray;
    outline: none;
    cursor: pointer;
}
</style>
</head>
<body>
   <%@ include file="../common/B_UserMainHeader.jsp" %>
   
   <section id="section">
            <div style="margin-top: 70px; margin-bottom:100px;">
                <div class="loginText"><label>로그인</label></div><br>
                <div class="loginBar"></div><br><br>
                <div>
                  <form action="<%= request.getContextPath()%>/login.me" method="post" class="loginForm">

                    <table class="loginTable"> 
                        <tr><td><label class="idLabel">아이디</label></td></tr>
                        <tr><td><input type="text" class="idText" name="userId" autocomplete=off></td></tr>
                        <tr height=30px></tr>
                        <tr><td><label class="idLabel">비밀번호</label></td></tr>
                        <tr><td><input type="password" name="password1" id="password1"  class="idText"></td></tr>
                        <tr><td style="font-size: 14px;">비밀번호 8자리-16자리 입력가능 (영어 대소문자, 숫자, 특수문자)</td></tr>
                        <tr height=50px></tr>
                        <tr><td><input type="submit" class="loginBtn" value="로그인"></td></tr>
                        <tr height="20px"></tr>
                        <tr><td><input type="button" class="idFindBtn" value="아이디 찾기" style="margin-left: 180px;" onclick="location.href='<%=request.getContextPath()%>/views/user/member/F_findUserId.jsp'">
                          | <input type="button" class="idFindBtn" value="비밀번호 찾기"  onclick="location.href='<%=request.getContextPath()%>/views/user/member/F_findUserPwd.jsp'">
                          | <input type="button" class="idFindBtn" value="회원가입" onclick="location.href='<%=request.getContextPath()%>/views/user/member/F_memberCheck.jsp'">
                        </td></tr>
                    </table>
                  </form>  
                </div><br>
                <div class="loginBar"></div>
            </div>
        </section>
        <script>
        
        </script>
   
   <%@ include file="../common/B_UserMainFooter.jsp" %>
</body>
</html>