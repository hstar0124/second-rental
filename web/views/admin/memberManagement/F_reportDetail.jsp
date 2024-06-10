<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.forest.member.model.vo.Report"%>
<%
	Report selectReport = (Report) request.getAttribute("selectReport");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고정보</title>
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
		cursor: pointer;
	}
</style>
</head>
<body>
	<div id="mainRange">
		<div id="infoBar" style="color:white; font-size:24px;">신고 글 정보</div>
		<table id="infoTable">
			<tr>
				<td style="width:100px; background:#A7C0E9;">리뷰제목</td>
				<td style="border:1px solid #16AAD8;"><%=selectReport.getrTitle() %>(리뷰번호 : <%=selectReport.getrBorderNo() %>)</td>
			</tr>
			<tr>
				<td style="width:100px; background:#A7C0E9;">작성자</td>
				<td style="border:1px solid #16AAD8;"><%=selectReport.getToUserName()%>(<%=selectReport.getToUserNo() %>)</td>
			</tr>
			<tr height="10px"></tr>
			<tr>
				<td style="width:100px; background:#A7C0E9; height:250px;">리뷰내용</td>
				<td style="border:1px solid #16AAD8;"><%=selectReport.getrContent() %></td>
			</tr>
			<tr height="30px"></tr>
			<tr>
				<td style="width:100px; background:#A7C0E9;">신고자</td>
				<td style="border:1px solid #16AAD8;"><%=selectReport.getFromUserName()%>(<%=selectReport.getToUserNo() %>)</td>
			</tr>
			<tr>
				<td style="width:100px; background:#A7C0E9; height:100px;">신고 내용</td>
				<td style="border:1px solid #16AAD8;"><%=selectReport.getReason() %></td>
			</tr>
		</table>
		
		<table id="info1"></table>
		
		<table id="pointTable">
			
		</table>		
	</div>
	
	<script>
		
	</script>
	
	
</body>
</html>
