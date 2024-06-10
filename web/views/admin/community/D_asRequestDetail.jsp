<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.forest.notice.model.vo.*"%>
<%
	Notice notice = (Notice) request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<style>
	.tab1 {
		width: 100%;
		background: white;
	}

	.tab1 h3 {
		color: black;
		width: 120px;
	}

	.h {
		color: black;
	}

	.tab1 td {
		font-size: 14px;
		background: white;
	}

	.tab1 .sel {
		text-align: center;
		background: #E8E8E8;
		width: 100px;
	}

	.vl {
		margin-left: 10px;
	}

	#bt {
		text-align: center;
	}

	.tab1 td:not(:first-child):not(.htd){
    	border : 1px solid lightgray;
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

	.tab1 #content {
		
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
		border-radius: 5px 5px 5px 5px;
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

</style>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>중고구마</title>
</head>
<body onload="ready('공지사항', '공지사항', '게시물 등록');">
<%@ include file="../common/C_menubar.jsp"%>
	<article>
		<div>
			<form>
				<table class="tab1">
					<tr>
						<td class="h"><h3>게시물 등록</h3></td>
					</tr>
					<tr>
						<td class="sel">분류선택</td>
						<td colspan="3"><select class="vl">
								<option>분류</option>
								<option>공지</option>
								<option>배송</option>
								<option>렌탈</option>
								<option>이벤트</option>
								<!-- DB  -->
						</select></td>

					</tr>
					<tr>
						<td class="sel">작성자</td>
						<td><input class="vl" type="text" value="관리자"></td>
						<td class="sel">작성시각</td>
						<td><input class="vl" type="text" value="<%= notice.getnEnrollDate() %>" readonly></td>
					</tr>
					<tr>
						<td class="sel">제목</td>
						<td colspan="3"><input class="vl" type="text" value="<%= notice.getnTitle() %>" readonly></td>
					</tr>
					<tr>
						<td class="sel" id="content">내용</td>
						<!-- <td colspan="3" align="center" style="background:#828282;">아래에 내용을 적어 주세요</td> -->
						<td colspan="3"><textarea cols="125" rows="15"
								style="resize: none;" readonly><%= notice.getnContent() %></textarea></td>
					</tr>
					<!-- <tr>
						<td class="sel">파일첨부</td>
						<td colspan="3"><label for="file">파일 선택</label>
							<div class="filebox">
								<label for="file">업로드</label> <input type="file" id="file">
								<input class="upload-name" value="파일선택">
							</div></td>
					</tr> -->
					<tr>
						<td class="sel">파일첨부</td>
						<td colspan="3">
						<div class="filebox">
						<label for="ex_file">파일선택</label>
							<input type="file" id="ex_file"></div></td>
					</tr>
					<tr>
						<td id="bt" colspan="4">
						<br><br><br>
						<input style="background: #6792DA; color: white; width: 70px; height: 25px; border: none;"
							type="submit" id="bt2" value="수정"
							onclick="history.go(-1)"> &nbsp;
						
						<input style="background: #6792DA; color: white; width: 70px; height: 25px; border: none;"
							type="button" id="bt2" value="수정하기" 
							onclick="update();"> &nbsp;
                    	</td>
					</tr>
					</table>
				</form>
			</div>
			<script>
      		function update(){
     			 <%
     				String nBoardNo = notice.getnBoardNo();
     			 
     			 %>  
     				location.href="<%= request.getContextPath()%>/selectOneUp.no?num="+ <%=nBoardNo%>;
     		 
     	 	}
     		</script>
		</article>

<%@ include file="../common/C_menubar2.jsp"%>
</body>
</html>