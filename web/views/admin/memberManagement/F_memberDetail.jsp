<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.forest.member.model.vo.Member"%>
<%
	Member selectMember = (Member)request.getAttribute("selectMember");
	String[] address = selectMember.getAddress().split("[$]");
	int money = (int)request.getAttribute("money");
	int buyMoney = (int)request.getAttribute("buyMoney");
	int basketList = (int)request.getAttribute("basketList");
	int wishCount = (int)request.getAttribute("wishCount");
	int reviewCount = (int)request.getAttribute("reviewCount");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세페이지</title>
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
    	cursor: pointer;
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
		margin-left:150px;
		background:#ECECEC;
		cursor: pointer;
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
		background:#ECECEC;
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
		<div id="infoBar"></div>
		<table id="infoTable">
		<tr><td></td></tr>
		<tr><td>
		<label id="name"><%=selectMember.getUserName() %>(<%=selectMember.getUserId()%>) 님의 상세 정보</label>
		<div class="menu memberInfo" id="memberInfoBtn"><label id="lb1">회원정보</label></div>
		<div class="menu" id="orderBtn"><label id="lb1">주문정보</label></div>
		<div class="menu" id="pointBtn"><label id="lb1">포인트</label></div>
		<div class="menu community" id="communityBtn"><label id="lb1">매입정보</label></div>
		</td></tr>
		<tr style="margin:0;"><td><div id="bar1"></div></td></tr>
		</table>
		
		<table id="info1">
		<tr><td><label class="lb3">회원 기본정보</label></td></tr>
		<tr height="30px;"></tr>
		<tr><td class="td1">이름(아이디)</td><td class="td2"><%=selectMember.getUserName() %>(<%=selectMember.getUserId() %>)</td></tr>
		<tr><td class="td1">이메일</td><td class="td2"><%= selectMember.getEmail() %></td></tr>
		<tr><td class="td1">주소</td><td class="td2">(<%= address[0] %>) <%= address[1] %> <%=address[2] %></td></tr>
		<tr><td class="td1">휴대폰</td><td class="td2"><%= selectMember.getPhone() %></td></tr>
		<tr height="30px;"></tr>
		<tr><td><label class="lb3">회원 이용정보</label></td></tr>
		<tr height="20px"></tr>
		<tr><td class="td1">가입일</td><td class="td2"><%=selectMember.getEnrollDate() %></td></tr>
		<tr><td class="td1">주문총액</td><td class="td2"><%=money %> 원</td></tr>
		<tr><td class="td1">판매총액</td><td class="td2"><%= buyMoney %> 원</td></tr>
		<tr><td class="td1">포인트</td><td class="td2"><%=selectMember.getPoint() %> P</td></tr>
		<tr><td class="td1">렌탈후기</td><td class="td2"><%=reviewCount %> 건</td></tr>
		<tr><td class="td1">위시리스트/장바구니</td><td class="td2"><%=wishCount %>건 / <%=basketList %>건</td></tr>
		<tr height="40px"></tr>
		<tr><td colspan="2"><input type="button" value="닫기" id="closeBtn"></td></tr>
		</table>
		<table id="pointTable">
			
		</table>		
	</div>
	<script>
		$(function(){
			$("#closeBtn").click(function(){
				window.close();
			});
			
			$("#pointBtn").click(function(){
				location.href='<%= request.getContextPath()%>/pointAll.po?num=<%= selectMember.getUserNo()%>&userId=<%= selectMember.getUserId()%>&userName=<%= selectMember.getUserName()%>&userPoint=<%= selectMember.getPoint()%>';
			});
			
			$("#memberInfoBtn").click(function(){
				$("#pointTable").hide();
				$("#info1").show();
			});
			$("#orderBtn").click(function(){
				location.href='<%= request.getContextPath()%>/orderList.me?num=<%= selectMember.getUserNo()%>&userId=<%= selectMember.getUserId()%>&userName=<%= selectMember.getUserName()%>&userPoint=<%= selectMember.getPoint()%>';
			});
			$("#communityBtn").click(function(){
				location.href='<%= request.getContextPath()%>/memberBuySelectAll.me?num=<%= selectMember.getUserNo()%>&userId=<%= selectMember.getUserId()%>&userName=<%= selectMember.getUserName()%>&userPoint=<%= selectMember.getPoint()%>';
			});
		});
	</script>
	
	
</body>
</html>
