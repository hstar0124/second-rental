<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import="java.util.*, com.kh.forest.review.model.service.*, com.kh.forest.review.model.vo.*, com.kh.forest.member.model.vo.*" %>
	<%@ page import="com.kh.forest.review.model.vo.PageInfo" %>
	<%
	ArrayList<Review> list = (ArrayList<Review>) request.getAttribute("list");
	ArrayList<Member> list2 =(ArrayList<Member>) request.getAttribute("list");
 	PageInfo pi = (PageInfo) request.getAttribute("pi");
 	int currentPage = pi.getCurrentPage();
	int limit = pi.getLimit();
	int maxPage = pi.getMaxPage();
	int endPage = pi.getEndPage();
	int startPage = pi.getStartPage();
	int listCount = pi.getListCount();
%>
<!DOCTYPE html>
<html>
<head>
<style> 
	.D{ 
		font-color : black;
		font-size : 14px;
	}
	.D td{
        border : 1px black;
        border-style: solid;
        font-size : 14px;
        
    }
    .D table{
    	align : center;
        background : white;
        
        width : 100%;
        color : black;
        margin-bottom : 30px;
        
        }
    .D table:not(.table1){
    	border-collapse: collapse;
    }
    .table1 td{
    	border : none;
    }
    .table1 td:first-child{
    	text-align: center;
    }
    .table1 td:first-of-type{
    	background : #DADADA;
    }
    .table3{
    	text-align: center;
    }
    .D th{
    	border : 1px black;
        border-style: solid;
        background : #A7C0E9;
    }

    .D .htd{
        
        background: gray;
        width:120px;
    }
    .D .bt{
        text-align: center;

    }
    .D hr {
        color: black;
    }
    .vl{
    	margin-left : 10px;
    }
    .D span{
    	color : red;
    }
    select{
    	width : 100px;
    	height : 22px;
    }
    #bt{
		margin : 20px;
    }
	.table1 td:nth-child(2)  {
		background: rgb(247, 247, 247);

	}
	.pagingArea button{
	border:none;
	color:#6E00AB;
	font-weight:600;
	background:white;
	margin-bottom:20px;
	font-size:14px;
	}
	button {
	cursor:pointer;
	}
	.DDD {
	background:#ECECEC;
	height:35px;
	line-height: 35px;
	border: 2px solid #B8B8B8;
}
.DDD button {
	border: none;
    background: #828282;
    color: white;
    width: 90px;
    height: 25px;
}
</style>
<meta charset="UTF-8">
<title>중고구마</title>
</head>
<body onload="ready('리뷰 관리', '커뮤니티', '리뷰 관리');">
	<%@ include file="../common/C_menubar.jsp" %>


	<article class="D">
		<form action="<%= request.getContextPath() %>/selectList.re" method="post">
			<table class="table1" style="border : 10px">
				<tr>
					<td class="htd">분류선택</td>
					<td>
					<select class="vl">
							<option>1차분류</option>
					</select>
					<select class="vl">
							<option>2차분류</option>
					</select></td>
				</tr>
				<tr>
					<td class="htd">검색어</td>
					<td><select class="vl">
							<option class="vl">전체</option>
					</select> <input class="vl" type="text"></td>
				</tr>
				<!-- <tr>
					<td class="htd">평점</td>
					<td><input class="vl" type="checkbox"><label>★</label> <input
						class="vl" type="checkbox"><label>★★</label> <input
						class="vl" type="checkbox"><label>★★★</label> <input
						class="vl" type="checkbox"><label>★★★★</label>
						<input class="vl" type="checkbox"><label>★★★★★</label></td>
				</tr> -->
				<tr>
					<td>등록일</td>
					<td>
						<input type="text" id="datepicker">~<input type="text" id="datepicker1">
						<button onclick="">오늘</button>
						<button onclick="">이번주</button>
						<button onclick="">이번달</button>
						<button onclick="">전체</button>
					</td>
				</tr>
			</table>
			<br><br>
			<div align="center"><button class="searchBtn">검색</button></div>
			</form>
			<br><br>
			<div class="DDD">
			&nbsp;&nbsp;
			<label style="font-size: 16px;">검색결과 : </label><label class="searchCount" style="font-size: 16px;"><%= listCount %> 건</label>
			<%-- <label>총 현황 : </label><label class="searchCount"><%= listCount %> 건</label> --%>
			</div>
			<br><br>
			
		<form action="<%= request.getContextPath() %>/selectList.re" method="post">
		<table class="table3">
			<tr>
				<th><input type="checkbox"></th>
				<th>번호</th>
				<th>상품정보</th>
				<th>내용</th>
				<th>작성일</th>
				<th>아이디</th>
				<th>별점</th>
				<th>조회</th>
			</tr>
			<% for(int i = 0; i < list.size(); i++) { %>
			<tr>
				<td><input type="checkbox"></td>
				<td><%= listCount - (currentPage-1)*limit - i %></td>
				<td><%= list.get(i).getProductName() %></td>
				<%-- <td><%= list.get(i).getrBoardNo() %></td> --%>
				<td><%= list.get(i).getrContent() %></td>
				<td><%= list.get(i).getrEnrollDate() %></td>
				<td><%= list.get(i).getUserId() %></td>
				<td><%= list.get(i).getpGrade() %></td>
				<td><%= list.get(i).getrCount() %></td>
			</tr>
			<% } %>
		</table>
		</form>
		<div class="pagingArea" align="center">
			<button
				onclick="location.href='<%=request.getContextPath() %>/reviewList.re?currentPage=1'"><<</button>
			<% if(currentPage <= 1 ){ %>
			<button disabled><</button>
			<%} else { %>
			<button
				onclick="location.href='<%=request.getContextPath() %>/reviewList.re?currentPage=<%= currentPage - 1%>'">
				<</button>
			<% } %>

			<% for(int p = startPage; p <= endPage ; p++){ 
					if(p == currentPage){%>
						<button disabled><%= p %></button>
			<%		}else{ %>
						<button onclick="location.href='<%=request.getContextPath() %>/reviewList.re?currentPage=<%=p %>'"><%=p %></button>
				
			<%		} 
				} %>
			<% if(currentPage >= maxPage){ %>
				<button disabled> > </button>
			<% }else {  %>
				<button onclick="location.href='<%=request.getContextPath() %>/reviewList.re?currentPage=<%=currentPage + 1 %>'"> ></button>
			<% } %>	
			
			<button onclick="location.href='<%=request.getContextPath() %>/reviewList.re?currentPage=<%= maxPage%>'">>></button>

		</div>
		<hr>
		
					<!-- <input style="background : #FF8328; color : white; width : 70px; height : 25px;
						border:none; float:right;"
						 class="DDD" type="button" value="삭제"> -->
	<div class="DDD">
	&nbsp;&nbsp;
	<button style="border: none; background: #828282; color: white; width: 90px; height: 25px;" onclick="deleteNotice();">선택삭제</button>
	</div>		
	</article>
	<script>
		/* 날짜 input jquery ui */
		$.datepicker.setDefaults({
				showOn : "both",
				buttonImage : "/forest/image/calendar.png",
				buttonImageOnly : true,
				dateFormat : 'yy-mm-dd'
	
			});
			$(function() {
				$("#datepicker").datepicker({});
				$("#datepicker1").datepicker({});
				/* 달력버튼 */
				$("img.ui-datepicker-trigger")
						.attr("style","margin-left:2px; vertical-align:middle; cursor: Pointer; width:30px; height:30px");
	
			});
	</script>



	<%@ include file="../common/C_menubar2.jsp" %>

</body>
</html>