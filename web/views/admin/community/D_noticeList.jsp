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
<style>
#searchGrid {
	width:100%;
	margin:0px;
}
/* #resultTable {
	width:100%;
	 border: 1px solid #333333;
	 border-collapse:collapse;
	 display: inline-table;
	
}
 
#resultTableTh {
	background-color: #A7C0E9;
	border:1px solid black;
}
#resultTableTd {
	text-align : center;
	border:1px solid black;
}

#orderInfo {
	background:none;
	border:0;
	ourline:0;
} */
	
	
	.AllBtn{
	width:100px;
	height:30px;
	background: #6792DA;
	border:none;
	color:white;
	font-size:15px;
	border-radius: 5px 5px 5px 5px;
	cursor:pointer;
	}
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
	#Delete {
		width : 70px;
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>중고구마</title>
</head>
<%@ include file="../common/C_menubar.jsp" %>
<body onload="ready('공지사항', '커뮤니티', '공지사항');">

	<article class="D">
		<form action="<%= request.getContextPath() %>/selectList.no" method="post">
			<table class="table1" id="searchGrid" style="border : 10px">
				<colgroup>
				<col width="20%" style="background: rgba(218, 218, 218, 0.459)" text-align="center">
				<col style="background: rgba(212, 212, 212, 0.253)">
				</colgroup>
				<tr>
					<td class="htd">검색어</td>
					<td><select class="vl">
							<option class="vl">전체</option>
					</select> <input class="vl" type="text"></td>
				</tr>
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
		
		<form id="deleteNotice" action="deleteAll.no">
		<table class="table3">
			<tr>
				<th><input type="checkbox"></th>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일자</th>
			</tr>
				<% for(int i = 0; i < list.size(); i++) { %>
			<tr>
				<td><input type="checkbox" name="nBoardNo" value="<%=list.get(i).getnBoardNo()%>"></td>
				<td class="clickTd" hidden><%= list.get(i).getnBoardNo()%></td>
				<td class="clickTd"><%= listCount - (currentPage-1)*limit - i %></td>
				<td class="clickTd"><%= list.get(i).getnTitle() %></td>
				<td class="clickTd">관리자</td>
				<td class="clickTd"><%= list.get(i).getnCount() %></td>
				<td class="clickTd"><%= list.get(i).getnEnrollDate() %></td>
			</tr>
				<% } %>
		</table>
		</form>
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/selectList.no?currentPage=1'"><<</button>
			<% if(currentPage <= 1) {
				System.out.println(listCount +"" +endPage);%>
				<button disabled><</button>
			<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectList.no?currentPage=<%= currentPage - 1 %>'"><</button>
			<% } %>
		
			<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){%>
						<button disabled><%= p %></button>
					<% }else {%>
						<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=<%=p%>'"><%=p %></button>
			<% 		}
				}%>
		
			<% if(currentPage >= maxPage){ %>
				<button disabled>></button>
			<% } else { %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectList.no?currentPage=<%= currentPage + 1 %>'">></button>
			<% } %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectList.no?currentPage=<%=maxPage %>'">>></button>
		</div>
		<br>
		<table class="table2">
            <td colspan="2" style="border : none; background : white; float:right;">
            
               <input onclick="location.href='views/admin/community/D_noticeInsertForm.jsp'"
                class="AllBtn"
                   type="submit" value="등록">
                 &nbsp;
            </td>
		</table>
        <hr>   
		<!-- <table id="searchCountTable">
			<td style="border : 1px solid gray; background : #ECECEC;">
			&nbsp;&nbsp;
				<button style="border: none; background: #828282; color: white; width: 90px; height: 25px;" onclick="deleteNotice();">선택삭제</button>
			</td>
		</table> -->
		<div class="DDD">
		&nbsp;&nbsp;
		<button style="border: none; background: #828282; color: white; width: 90px; height: 25px;" onclick="deleteNotice();">선택삭제</button>
		</div>		
	</article>
	<script>
	/* function deleteNotice(){
		$("#deleteNotice").submit();
	} */
	
	</script>
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
	
		$(function(){
			$(".table3 td").mouseenter(function(){
				$(this).parent().css({"background":"white", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css("background", "white");
			}).click(function(){
				var num = $(this).parent().children().eq(1).text();
				console.log(num);
				location.href = "<%=request.getContextPath()%>/selectOne.no?num=" + num;
			});
		})
	</script>

	<%@ include file="../common/C_menubar2.jsp" %>

</body>
</html>