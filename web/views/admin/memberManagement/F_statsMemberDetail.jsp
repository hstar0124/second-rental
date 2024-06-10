<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.forest.member.model.vo.PageInfo, com.kh.forest.member.model.vo.StatsMemberList"%>
<% 
	List<StatsMemberList> list = (List<StatsMemberList>) request.getAttribute("list");
	String year = (String)request.getAttribute("year");
	String month = (String)request.getAttribute("month");
	
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규회원명단</title>
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
		border-collapse: collapse;
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
	button{
		background:white;
		border:none;
		font-size:14px;
	}
</style>
</head>
<body>
<div id="mainRange">
		<div id="infoBar" style="color:white; font-size:24px; text-align:center;">20<%=year %>년 <%=month %>월 신규 회원 명단</div>
		<table id="infoTable">
			<tr>
				<th style="background:#A7C0E9; height:30px;">가입일</th>
				<th style="background:#A7C0E9; height:30px;">아이디</th>
				<th style="background:#A7C0E9; height:30px;">성별</th>
				<th style="background:#A7C0E9; height:30px;">나이(만)</th>
			</tr>
			<%for(StatsMemberList s : list) { %>
			<tr>
				<td style="text-align:center; height:30px;"><%=s.getEnrollDate() %></td>
				<td style="text-align:center;"><%=s.getUserId() %></td>
				<td style="text-align:center;"><%=s.getGender() %></td>
				<td style="text-align:center;"><%=s.getAge() %>세</td>
			</tr>			
			<% } %>
		</table>
		
		<table id="info1"></table>
		
		<% if(pi != null){ %> 
      <div class="pagingArea" align="center">
      	<button onclick="location.href='<%= request.getContextPath()%>/statsMemberList.me?currentPage=1&sysdate=<%=year%>&month=<%=month%>'"><<</button>
      <% if(currentPage <= 1){ %>
      	<button disabled><</button>
      <%} else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/statsMemberList.me?currentPage=<%= currentPage -1%>&sysdate=<%=year%>&month=<%=month%>'"><</button>
      <% } %>
      
      <% for(int p =startPage ; p <= endPage; p ++ ) {  
    	  
    	  if(p == currentPage){
    	%>	  
    		<button disabled><%= p %></button>
    	<% } else { %>
    		<button onclick="location.href ='<%= request.getContextPath()%>/statsMemberList.me?currentPage=<%= p%>&sysdate=<%=year%>&month=<%=month%>'"><%= p %></button>
    	<% } %>  
      
      <% } %>
      <% } %>
      
      
      
      <% if(currentPage >= maxPage) { %>
      	<button disabled>></button>
      <% } else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/statsMemberList.me?currentPage=<%= currentPage +1 %>&sysdate=<%=year%>&month=<%=month%>'">></button>
      <% } %>
      
      
      
      <button onclick="location.href='<%= request.getContextPath()%>/statsMemberList.me?currentPage=<%= maxPage%>&sysdate=<%=year%>&month=<%=month%>'">>></button>
      </div>
				
	</div>
</body>
</html>