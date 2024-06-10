<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
input:-webkit-autofill {
   -webkit-box-shadow: 0 0 0 1000px rgb(236, 234, 234) inset;
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
        outline:none;
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
                    <form action="<%= request.getContextPath()%>/findId.me" id="findIdForm" method="post">
                        <table class="idFindTable">
                            <tr height="70px"></tr>
                            <tr><td><label class="label1">&nbsp;이름</label></td></tr>
                            <tr></tr>
                            <tr><td><input type="text" class="userName" id="userName" name="userName"></td></tr>
                            <tr height="30px"></tr>
                            <tr><td><label class="label1">&nbsp;등록 한 이메일</label></td></tr>
                            <tr></tr>
                            <tr><td><input type="email" class="userName" id="email" name="email"></td></tr>
                            <tr height=70px></tr>
                            <tr><td><input type="button" id="idFindBtn" name="idFindBtn" value="아이디 찾기"></td></tr>
                            <tr height="115px"></tr>
                        </table>
                    </form>
                <div class="idFindBar"></div>
            </div>
        </section> 	
          <script>
        	$("#idFindBtn").click(function(){
        		var regExp = /^[가-힣]{2,4}$/;
        		if(!regExp.test($("#userName").val()) && $("#userName").val() != ""){
        			alert("이름의 형식이 잘못되었습니다!");
        		}else{
        			$("#findIdForm").submit();
        		}
        	});
        </script>
    <%@ include file="../common/B_UserMainFooter.jsp" %>
</body>
</html>