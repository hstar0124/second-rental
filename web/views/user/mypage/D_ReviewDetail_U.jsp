<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.forest.review.model.vo.Review" %>
<%@ page import="com.kh.forest.member.model.vo.Member" %>
<%@ page import="com.kh.forest.review.model.vo.Review_Attachment" %>
<%@ page import="java.util.ArrayList" %>
<%
	Member m = (Member) request.getAttribute("member");
	Review r = (Review) request.getAttribute("board");
	ArrayList<Review_Attachment> fileList = (ArrayList<Review_Attachment>) request.getAttribute("fileList");
	Review_Attachment titleImg = fileList.get(0);
	Review_Attachment detailImg1 = fileList.get(1);
	Review_Attachment detailImg2 = fileList.get(2);
	Review_Attachment detailImg3 = fileList.get(3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	.outer {
		width:1000px;
		height:650px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	.detail td{
		text-align:center;
		width:1000px;
		border:1px solid white;
	}
	#titleImgArea {
		width:500px;
		height:300px;
		margin-left:auto;
		margin-right:auto;
	}
	#contentArea {
		height:30px;
	}
	.detailImgArea {
		width:250px;
		height:210px;
		margin-left:auto;
		margin-right:auto;
	}
	#titleImg {
		width:500px;
		height:300px;
	}
	.detailImg {
		width:250px;
		height:180px;
	}
</style>
</head>
<body>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
<div class="outer">
		<table class="detail" align="center">
			<tr>
				<td width="50px">제목</td>
				<td colspan="5"><label><%= r.getrTitle() %></label></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><label><%= m.getUserName() %></label></td>
				<td>조회수</td>
				<td><label><%= r.getrCount() %></label></td>
				<td>작성일</td>
				<td><label><%= r.getrEnrollDate() %></label></td>
			</tr>
			<tr>
				<td>대표사진</td>
				<td colspan="4">
					<div id="titleImgArea" align="center">
						<img id="titleImg" 
							src="<%=request.getContextPath()%>/photo_uploadFiles/<%=titleImg.getChangeName()%>">
					</div>
				</td>
				<%-- <td>
					<button onclick="location.href='<%=request.getContextPath()%>/download.tn?num=<%=titleImg.get()%>'">다운로드</button>
				</td> --%>
			</tr>
			<tr>
				<td>사진메모</td>
				<td colspan="6">
					<p id="contentArea"><%= r.getrContent() %></p>
				</td>
			</tr>
		</table>
		<table class="detail">
			<tr>
				<td>
					<div class="detailImgArea">
						<img id="detailImg1" class="detailImg" 
							src="<%=request.getContextPath()%>/photo_uploadFiles/<%=detailImg1.getChangeName()%>">
						<%-- <button onclick="location.href='<%=request.getContextPath()%>/download.tn?num=<%=detailImg1.getFid()%>'">다운로드</button> --%>
					</div>
				</td>
				<td>
					<div class="detailImgArea">
						<img id="detailImg2" class="detailImg" 
							src="<%=request.getContextPath()%>/photo_uploadFiles/<%=detailImg2.getChangeName()%>">
						<%-- <button onclick="location.href='<%=request.getContextPath()%>/download.tn?num=<%=detailImg2.getFid()%>'">다운로드</button> --%>
					</div>
				</td>
				<td>
					<div class="detailImgArea">
						<img id="detailImg3" class="detailImg" 
							src="<%=request.getContextPath()%>/photo_uploadFiles/<%=detailImg3.getChangeName()%>">
						<%-- <button onclick="location.href='<%=request.getContextPath()%>/download.tn?num=<%=detailImg3.getFid()%>'">다운로드</button> --%>
					</div>
				</td>
			</tr>
		</table>
	<%@ include file="/views/user/common/B_UserMainFooter.jsp"%>
	</div>
</body>
</html>