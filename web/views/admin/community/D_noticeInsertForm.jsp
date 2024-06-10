<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>	
	
<%
Calendar cal = Calendar.getInstance();

int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH)+1;
int date = cal.get(Calendar.DATE);

String strYear = request.getParameter("year");
String strMonth = request.getParameter("month");


if(strYear != null){
  year = Integer.parseInt(strYear);
  month = Integer.parseInt(strMonth);

}else{

}
cal.set(year, month, 1);

int startDay = cal.getMinimum(java.util.Calendar.DATE);
int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
int newLine = 0;

Calendar todayCal = Calendar.getInstance();

SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");

int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
	
%>	
<!DOCTYPE html>
<html>
<head>
<style>
	.tab {
		width: 100%;
		background: white;
	}

	.tab h3 {
		color: black;
		width: 120px;
	}

	.h {
		color: black;
	}

	.tab td {
		font-size: 14px;
		background: white;
		
	}

	.tab .thd {
		text-align: center;
		background: #E8E8E8;
		width: 100px;
	}

	.thd {
		margin-left: 10px;
		text-align: center;
	}

	.tab td:not(:first-child):not(.htd){
    	border : 1px solid lightgray;
    }
    .vl {
		margin-left : 10px;
		width : 300px;
    }
    
	input[type=text] {
		border: none;
	}

	input[type=number] {
		border: none;
	}

	select {
		width: 100px;
		height: 22px;
		
	}

	#file[type="file"] {
		background: #6792DA;
		color: white;
		width: 70px;
		height: 25px;
		border: none;
	}
	#file[type="file"] {
		background: #6792DA;
		color: white;
		width: 70px;
		height: 25px;
		border: none;
	}
	.filebox label {
		margin-left: 5px;
		display: inline-block;
	 	padding: .3em .95em;
	 	color: white;
		font-size: inherit;
		line-height: normal;
		vertical-align: middle;
		background: #6792DA;
		cursor: pointer;
		border: 1px solid #ebebeb;
 		border-bottom-color: #e2e2e2;
		/* border-radius: 5px 5px 5px 5px; */
	}
	.filebox input[type="file"] {  /* 파일 필드 숨기기 */
		position: absolute;
		width: 1px;
		height: 1px;
		padding: 0;
		margin: -1px;
		overflow: hidden;
		clip:rect(0,0,0,0);
		border: 0;
	}
	.bt {
		text-align: center;
	}
	
	#bt2 {
		background: #6792DA;
		color: white;
		width: 70px;
		height: 25px;
		border: none;
		/* border-radius: 5px 5px 5px 5px; */
	}
	.searchBtn {
    width: 100px;
    height: 30px;
    background: #6792DA;
    border: none;
    color: white;
    font-size: 15px;
    border-radius: 5px 5px 5px 5px;
    cursor:pointer;
	}


</style>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>중고구마</title>
</head>
<body onload="ready('공지사항', '공지사항', '게시물 등록');">
<%@ include file="../common/C_menubar.jsp" %>
	<article>
<% if(loginAdmin != null){ %>
		<div>
			<form action="<%= request.getContextPath() %>/insert.no" method="post">
				<table class="tab">
					<tr>
						<td class="h"><h3>게시물 등록</h3></td>
					</tr>
					<tr>
						<td class="thd">작성자</td>
						<td><input class="vl" type="text" value="관리자" name="writer" readonly></td>
						<td class="thd">작성시간</td>
						<td><input class="vl" type="text" name="date" value="<%= year+"년 " + month+"월 " + date+"일"%>" readonly></td>
					</tr>

					<tr>
						<td class="thd">제목</td>
						<td colspan="3"><input class="vl" type="text" name="title"></td>
					</tr>

					<tr>
						<td class="thd" id="content">내용</td>
						<td colspan="3"><textarea name="content" cols="125" rows="45"
								style="resize: none;"></textarea></td>
					</tr>
					
					<tr>
						<td class="bt" colspan="4">
						<br><br><br><br>
						<input type="submit" id="insertBtn" class="searchBtn" value="등록" class="insertBtn"> &nbsp;
						<input type="button" class="searchBtn" value="취소" onclick="history.back(-1);"> &nbsp;
                    	</td>
					</tr>
					</table>
				</form>
				

			</div>
			<% }else { 
				request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
				request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
				} %>
		</article>
		<script>
		$(".insertBtn").click(function(){
		   /*  if(confirm("정말 수정하시겠습니까 ?") == true){
		    } */
		        alert("등록되었습니다");
		   /*  else{
		        return ;
		    } */
			});

		</script>
<%@ include file="../common/C_menubar2.jsp"%>
</body>
</html>