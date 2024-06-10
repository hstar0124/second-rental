<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.util.ArrayList, java.util.HashMap, com.kh.forest.review.model.vo.*" %>
<%
	ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) request.getAttribute("list");
	/* 	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int listCount = pi.getListCount(); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>중고구마</title>
<style>
	.outer{
		width:1000px;
		height:700px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	.thumbnailArea {
		width:760px;
		height:550px;
		margin-left:auto;
		margin-right:auto;
	}
	.searchArea {
		width:420px;
		margin-left:auto;
		margin-right:auto;
	}
	.thumb-list {
		width:220px;
		border:1px solid white;
		display:inline-block;
		margin:10px;
		align:center;
	}
	.thumb-list:hover {
		opacity:0.8;
		cursor:pointer;
	}
	
	
</style>
</head>
<body>
		<%@ include file="../common/C_menubar.jsp" %>
		<form action="<%= request.getContextPath() %>/selectList.re" method="post">
	<div class="outer">
		<br>
		<h2 align="center">사진게시판</h2>
		
		<div class="thumbnailArea">
		<% for(int i = 0; i < list.size(); i++) { 
				HashMap<String, Object> hmap = list.get(i);
		%>
				<div class="thumb-list" align="center">
					<div>
						<input type="hidden" value="<%= hmap.get("rBoardNo")%>">
						<img src="/forest/photo_uploadFiles/<%=hmap.get("changeName")%>" width="200px" height="150px">
					</div>
					<p>No. <%= hmap.get("rBoardNo") %> <%= hmap.get("rTitle") %><br>
					조회수 : <%= hmap.get("rCount") %><br><%= hmap.get("rWriter") %></p>
				</div>
		
		<% } %>
		</div>
		<%-- <script>
			$(function(){
				$(".thumb-list").click(function() {
					var num = $(this).children().children().eq(0).val();
					
					console.log(num);
					location.href="<%=request.getContextPath()%>/selectOne.tn?num=" + num;
				});
			});
		</script> --%>
		
		
		<div class="searchArea">
			<select id="searchCondition" name="searchCondition">
				<option>---</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search">
			<button type="submit">검색하기</button>
			<%-- <% if(loginAdmin != null) { %> --%>
			<button onclick="location.href='/forest/views/admin/community/D_reviewInsertForm.jsp'">작성하기</button>
			<%-- <% } %> --%>
		</div>
	</div>
		</form>
	<%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>















