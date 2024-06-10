<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
</head>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
<body id="E">
	<h1 class="text1">렌탈 현황</h1>
	<div
		style="background-color: purple; width: 100%; height: 4px; margin-top: 0px;"></div>
	<br>
	<br><br><br> 
	<br><br><br>
	<br><br>

	<table style="text-align:center" width="100%">
		<tr>
			<td>
				<img width="500px" height="200px" src="<%=request.getContextPath()%>/image/userimg/logo.png">		
			</td>
		</tr>
		<tr>
			<td style="font-size:30px">
			<br><br>
				환불신청이 완료되었습니다.<br>
				관리자 승인 후 환불처리됩니다.
			</td>
		</tr>
		
		<tr>
			<td>
			<br><br><br><br><br><br>
			<input type="button" class="close1" value="확인"
							style="background: #6E00AB; color: white; border: 1px solid #6E00AB; font-size:30px; width: 150px; height: 60px;"
							onclick="location.href='<%=request.getContextPath()%>/rentalList'">
			<br><br><br><br><br><br><br><br>
			</td>
		</tr>		
	
	</table>
</body>
<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp"%>
</html>