<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.review.model.vo.*" %>
   <%@ page import="com.kh.forest.review.model.vo.PageInfo" %>
   <%
	/* ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) request.getAttribute("list"); */
	ArrayList<Review> list = (ArrayList<Review>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int listCount = pi.getListCount();
	int limit = pi.getLimit();
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.reviewSection {
		width: 100%;
		table-layout:fixed;
	}

	.mainText {
		text-align: center;
		margin: auto;
	}

	.tr1>td{
    height: 40px;
    border-bottom: 1px solid #060202;
    background: #ECECEC; 
    /* width: 500px; */ 
    padding-top: 5px; 
    padding-bottom: 5px;
	}
	
	.review-tr>td{
    height: 30px;
    border-bottom: 1px solid #060202;
    
	}
	
	/* #reviewSection {
		width: 100%;
	} */
	
	#myReview{
		background:#6E00AB;
		color: white;
		cursor:pointer;
	}
	button[disabled], html input[disabled] {
    cursor: default;
	}
	.pagingArea button {
    border: none;
    background: white;
	}
	/* button[disabled], html input[disabled] {
    cursor: default;
	}
	.pagingArea button {
    border: none;
    background: white;
	} */

	/* .mainText {
		text-align: center;
		margin: auto;
	} */
	 /* --------표--------- */
	/* .outer{
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
	} */
	
	/* 카테고리버튼 */
	
		/* --------------------- */
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>중고구마</title>
</head>
<body>
<div>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
	
	<table align="center" class="reviewSection">
	<colgroup>
		<col style="width:20%;">
		<col style="width:40%;">
		<col style="width:20%;">
		<col style="width:20%;">
	</colgroup>
		<tr>
			<td colspan="6"><h1>나의활동</h1></td>
		</tr>
		<tr>
			<td colspan="6"><div style="background-color: #6E00AB; width: 100%; height: 4px; margin-top: 0px;"></div></td>
		</tr>
		
		<tr style="height:40px;"></tr>
		<tr class="review-tr tr1">
			<td><p class="mainText"><b>주문 번호</b></p></td>
			<td><p class="mainText"><b>상품정보</b></p></td>
			<td><p class="mainText"><b>별점</b></p></td>
			<td><p class="mainText"><b>작성일</b></p></td>
		</tr>
       
        <% for(int i = 0; i < list.size(); i++) { %>
		<tr class="reivew-tr">
			<td class="mainText" id="textValue"><%= listCount - (currentPage-1)*limit - i %></td>
			<td class="mainText" id="textValue"><%= list.get(i).getProductName() %></td>
			<td class="mainText" id="textValue"><%= list.get(i).getpGrade() %></td>
			<td class="mainText" id="textValue"><%= list.get(i).getrEnrollDate() %></td>
		</tr>
		<% } %>
	</table>
	 <br><br>
	<!-- </form> -->
	<div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/selectListUser.re?currentPage=1'"><<</button>
			<% if(currentPage <= 1) {
				System.out.println(listCount +"" +endPage);%>
				<button disabled><</button>
			<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectListUser.re?currentPage=<%= currentPage - 1 %>'"><</button>
			<% } %>
		
			<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){%>
						<button disabled><%= p %></button>
					<% }else {%>
						<button onclick="location.href='<%=request.getContextPath()%>/selectListUser.re?currentPage=<%=p%>'"><%=p %></button>
			<% 		}
				}%>
		
			<% if(currentPage >= maxPage){ %>
				<button disabled>></button>
			<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectListUser.re?currentPage=<%= currentPage + 1 %>'">></button>
			<% } %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectListUser.re?currentPage=<%=maxPage %>'">>></button>
		</div>
		</div>
	<script>
			$(function(){
				$(".thumb-list").click(function() {
					console.log("asdasd");
					var num = $(this).children().children().eq(0).val();
					
					console.log(num);
					location.href="<%=request.getContextPath()%>/selectOne.re?num=" + num;
				});
			});
		</script>
	

</body>
</html>