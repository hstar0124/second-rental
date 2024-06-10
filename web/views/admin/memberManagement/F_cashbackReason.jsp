<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.forest.point.model.vo.Reason"%>
<%
	Reason selectReason = (Reason) request.getAttribute("reason");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환급반려사유</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	body {
    margin:0;
    padding:0;
	}
	#mainRange{
		width:100%;
		height:100%;
		margin:0 auto;
		margin:0;
    	padding:0;
	}
	#infoTable{
		width:100%;
		margin-top:20px;
		margin-bottom:30px;
		font-weight:700;
	}
	.menu{
		width:110px;
		height:38px;
		border:2px solid #828282;
		border-bottom:none;
		border-right:none;
		display:inline-flex;
		border-top-left-radius:10px;
		border-top-right-radius:10px;
		margin:0;
    	padding:0;
    	font-weight:600;
	}
	#infoBar{
		width:100%;
		background:#16AAD8;
		height:50px;
		margin:0;
    	padding:0;
	}
	.community{
		border-right:2px solid #828282;
	}
	.memberInfo{
		margin-left:160px;
		background:#ECECEC;
	}
	#lb1{
		margin:0 auto;
		margin-top: 6px;
	}
	#bar1{
		width:100%;
		height:2px;
		background:#828282;
	}
	#name{
		font-size:20px;
		font-weight:600;
		margin-left:20px;
	}
	.basic{
		font-size:18px;
		margin-left:50px;
		font-weight:600;
	}
	#info1{
		width:700px;
		margin: 0 auto;
		margin-top:20px;
	}
	.td1{
		width:200px; 
		background:#CACACA;
		height:30px;
	}
	.td2{
		width:300px; 
		border: 1px solid #CACACA;
	}
	.lb3{
		font-size:20px;
		font-weight:600;
	}
	.lb4{
		margin-left:153px;
		margin-bottom:30px;
	}
	#pointTable{
		width:100%;
		margin-top:20px;
		margin-bottom:30px;
		display:none;
	}
	#closeBtn{
		width:140px;
		height:30px;
		background:#16AAD8;
		outline:none;
		border:none;
		font-weight:600;
		color:white;
		margin-left:270px;
	}
</style>
</head>
<body>
	<div id="mainRange">
		<div id="infoBar" style="color:white; font-size:24px;">환급 반려정보</div>
		<table id="infoTable">
			<tr>
				<td style="width:120px; background:#A7C0E9;">환급번호</td>
				<td style="border:1px solid #16AAD8; font-weight:400;"><%=selectReason.getCashBackHistoryNo() %></td>
			</tr>
			<tr>
				<td style="width:100px; background:#A7C0E9;">아이디</td>
				<td style="border:1px solid #16AAD8; font-weight:400;"><%=selectReason.getUserId() %></td>
			</tr>
			<tr>
				<td style="width:100px; background:#A7C0E9;">신청환급포인트</td>
				<td style="border:1px solid #16AAD8; font-weight:400;"><%=selectReason.getPoint() %> P</td>
			</tr>
			<tr>
				<td style="width:100px; background:#A7C0E9;">신청환급금액</td>
				<td style="border:1px solid #16AAD8; font-weight:400;"><%=selectReason.getMoney() %>원</td>
			</tr>
			<tr>
				<td style="width:100px; background:#A7C0E9;">신청일</td>
				<td style="border:1px solid #16AAD8; font-weight:400;"><%=selectReason.getCashbackDate()%></td>
			</tr>
			<tr style="height:20px;"></tr>
			<tr>
				<td style="width:100px; background:#A7C0E9; height:250px;">취소 사유</td>
				<td style="border:1px solid #16AAD8; font-weight:400;"><%=selectReason.getReason() %></td>
			</tr>
			<tr height="30px"></tr>
			
		</table>
		
		<table id="info1"></table>
		
		<table id="pointTable">
			
		</table>		
	</div>
	
	<script>
		
	</script>
	
	
</body>
</html>
