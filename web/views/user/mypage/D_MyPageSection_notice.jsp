<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.notice.model.vo.*" %>
    <%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
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
	.noticeSection {
		width: 100%;
		table-layout:fixed;
	}

	.mainText {
		text-align: center;
		
	}

	.tr1>td{
    height: 40px;
    border-bottom: 1px solid #060202;
    background: #ECECEC; 
    /* width: 500px; */ 
    padding-top: 5px; 
    padding-bottom: 5px;
	}
	
	.notice-tr>td{
    height: 30px;
    border-bottom: 1px solid #060202;
    
	}
	#notice{
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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>중고구마</title>
</head>
<body>
<div>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
	<article class="D">
	<%-- <form action="<%= request.getContextPath() %>/selectList.no" method="post"> --%>
	<table align="center" class="noticeSection">
	<colgroup>
		<col style="width:10%;">
		<col style="width:40%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:20%;">
	</colgroup>
		<tr>
			<td colspan="6"><h1>공지사항</h1></td>
		</tr>
		<tr>
			<td colspan="6"><div style="background-color: #6E00AB; width: 100%; height: 4px; margin-top: 0px;"></div></td>
		</tr>
		
		<tr style="height:40px;"></tr>
		<tr class="notice-tr tr1">
			<td><p class="mainText"><b>번호</b></p></td>
			<td><p class="mainText"><b>제목</b></p></td>
			<td><p class="mainText"><b>작성자</b></p></td>
			<td><p class="mainText"><b>조회수</b></p></td>
			<td><p class="mainText"><b>작성일자</b></p></td>
		</tr>
        <% for(int i = 0; i < list.size(); i++ ) { %>
		<tr class="notice-tr">
			<td class="mainText" id="textValue" hidden><%= list.get(i).getnBoardNo()%></td>
			<td class="mainText" id="textValue"><%= listCount - (currentPage-1)*limit - i %></td>
			<td class="mainText" id="textValue" onclick="location.href='<%=request.getContextPath()%>/selectOneMain.no?nboardNo=<%=list.get(i).getnBoardNo()%>'"><%= list.get(i).getnTitle() %></td>
			<%-- <td class="mainText" id="textValue"><%= list.get(i).getnTitle() %></td> --%>
			<td class="mainText" id="textValue">관리자</td>
			<td class="mainText" id="textValue"><%= list.get(i).getnCount() %></td>
			<td class="mainText" id="textValue"><%= list.get(i).getnEnrollDate() %></td>
		</tr>
		<% } %>
	</table>
	<br><br>
	<!-- </form> -->
	<div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/selectList2.no?currentPage=1'"><<</button>
			<% if(currentPage <= 1) {
				System.out.println(listCount +"" +endPage);%>
				<button disabled><</button>
			<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectList2.no?currentPage=<%= currentPage - 1 %>'"><</button>
			<% } %>
		
			<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){%>
						<button disabled><%= p %></button>
					<% }else {%>
						<button onclick="location.href='<%=request.getContextPath()%>/selectList2.no?currentPage=<%=p%>'"><%=p %></button>
			<% 		}
				}%>
		
			<% if(currentPage >= maxPage){ %>
				<button disabled>></button>
			<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectList2.no?currentPage=<%= currentPage + 1 %>'">></button>
			<% } %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectList2.no?currentPage=<%=maxPage %>'">>></button>
		</div>
		
	
	</article>
	
	<br><br>
	</div>
	<br><br><br><br>
	<%@ include file="/views/user/common/B_UserMainFooter.jsp"%>

</body>
</html>