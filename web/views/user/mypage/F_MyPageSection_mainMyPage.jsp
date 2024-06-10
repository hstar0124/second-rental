<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.notice.model.vo.*"%>
     <%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
    int readCount = (int)request.getAttribute("readCount"); 
	/* PageInfo pi = (PageInfo) request.getAttribute("pi");
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
<title>중고구마</title>
<style>
	#myPageMainTable{
		height:100px;
		width:900px;
		margin:0 auto;
		margin-bottom:40px;
	}
	#noticeBar{
		width:100%;
		height:3px;
		background: #6E00AB;
	}
	#noticeArea{
		width:100%;
		height:170px;
		/* background: rgb(232, 232, 232); */
		/* border-radius: 10px 10px 10px 10px; */
		margin:0 auto;
	}	
	.lb1{
		font-weight:600;
		font-size:24px;
	}
	#img{
		width:250px;
		height:150px;
		border:none;
		display:inline-block;
		margin-left: 30px;
	}
	.lb2{
		margin-left: 110px;
		font-weight:600;
		font-size:28px;
		margin-top:10px;
		color:red;
	}
	#pointArea{
		width:230px;
		height:38px;
		background: #EEEEEE;
		border-radius: 10px 10px 10px 10px;
		display:inline-flex;
		cursor: pointer;
		margin-left:550px;
	}
	#area2{
		display:inline-flex;
	}
	.pointImg{
		margin-left:9px;
		margin-top:3px;
		cursor: pointer;
	}
	.point{
		color:red;
		margin-top:7px;
		margin-left:6px;
		font-weight:600;
		cursor: pointer;
	}
	.lb3{
		margin-top:7px;
		font-weight:600;
		margin-left:6px;
		cursor: pointer;
	}
	
	
	#product{
		width:180px;
		height:150px;
		display: inline-table;
		margin-left: 30px;
		text-align: center;
	}
	#wishNoticeDiv{
		width: 890px;
		height: 155px;
		line-height: 155px;
		text-align: center;
		background: lightgray;
	}
	.myWishlistImg{
		width: 100px;
		height: 100px;		
	}
	#proNameDiv{
		margin-left: 12px;
		margin-top: 5px;
		text-align: left;
		font-size: 10px;
		font-weight: 800;
	}
	/* ---------공지사항---------- */
	.noticeSection {
		width: 100%;
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
	.notice-tr>td{
    height: 30px;
    border-bottom: 1px solid #060202;
    
}
#img1{
	background-image:url('<%=request.getContextPath()%>/image/userimg/pointArlam.png');
	background-size: cover;
	width:70px;
	height:60px;
	margin-left:590px;
	text-align:center;
}
</style>
</head>
<body>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>
		<table id=myPageMainTable >
			<tr height="5px;"></tr>
			<tr>
				<td>
			<% if(readCount >0) { %>
			<img src="<%=request.getContextPath()%>/image/userimg/arlamRight.png" width="20px" height="22px" class="pointImg" style="margin-left:650px;">
			<label style="color:red; font-weight:900; font-size:18px; margin-left:0px; margin-top:5px;"><%=readCount %></label><label style="color:black; font-weight:600; font-size:14px; margin-left:4px; margin-top:5px;">건의 포인트이력이 있습니다.</label>
			<% }else { %>
			<img src="<%=request.getContextPath()%>/image/userimg/arlam.png" width="20px" height="20px" class="pointImg" style="margin-left:650px;">
			<label style="color:red; font-weight:900; font-size:18px; margin-left:0px; margin-top:5px;"></label><label style="color:black; font-weight:600; font-size:14px; margin-left:0px; margin-top:5px;">새로운 포인트 내역이 없습니다.</label>
			<% } %>
				</td>
			</tr>
			<tr height="5px;"></tr>
			<tr><td id="area2"><label class="lb1">공지사항</label> 
			<div id="pointArea" onclick="location.href='<%= request.getContextPath()%>/pointSelectOne.po'">
			<img src="<%=request.getContextPath()%>/image/userimg/point.PNG" width="120px" height="30px" class="pointImg">
			<label class="point"><%= loginMember.getPoint() %></label><label class="lb3"> > </label>
			</div>
			</td></tr>
			<tr height="3px;"></tr>
			<tr><td><div id="noticeBar">
			</div></td></tr>
			<tr height=20px;></tr>
			
			
			  <tr><td><div id="noticeArea">
			  
			  <table align="center" class="noticeSection">
	<colgroup>
		<col style="width:10%;">
		<col style="width:40%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:20%;">
	</colgroup>
	<!-- 	<tr>
			<td colspan="6"><h1>공지사항</h1></td>
		</tr> -->
		<!-- <tr>
			<td colspan="6"><div style="background-color:purple; width:100%; height:4px;"></div></td>
		</tr> -->
		
	<!-- 	<tr style="height:40px;"></tr> -->
		<!-- <tr>
			<td colspan="6"><div style="background-color:lightgray; width:100%; height:3px;"></div></td>
		</tr> -->
			<tr class="notice-tr tr1">
				<td><p class="mainText" ><b>번호</b></p></td>
				<td><p class="mainText"><b>제목</b></p></td>
				<td><p class="mainText"><b>작성자</b></p></td>
				<td><p class="mainText"><b>조회수</b></p></td>
				<td><p class="mainText"><b>작성일자</b></p></td>
			</tr>
		<!-- <tr>
            <td colspan="6"><div style="background-color:lightgray; width:100%; height:2px;"></div></td>
        </tr> -->
        <% for(int i = 0 ; i < list.size() ; i ++ ) { %>
		<tr class="notice-tr">
			<td class="mainText" id="textValue"><%= 5-i %></td>
			<td class="mainText" id="textValue" onclick="location.href='<%=request.getContextPath()%>/selectOneMain.no?nboardNo=<%=list.get(i).getnBoardNo()%>'"><%= list.get(i).getnTitle() %></td>
			<td class="mainText" id="textValue">관리자</td>
			<td class="mainText" id="textValue"><%= list.get(i).getnCount() %></td>
			<td class="mainText" id="textValue"><%= list.get(i).getnEnrollDate() %></td>
		</tr>
		
		
		<% } %>
		<!-- <tr>
		 <td colspan="6"><div style="background-color:lightgray; width:100%; height:2px;"></div></td>
		</tr> -->
	</table>
			  
	</div>
		<br><br><br><br>
		</td>
			</tr> 
			<tr height=50px;></tr>
			<tr><td><label class="lb1">위시리스트</label></td></tr>
			<tr height="3px;"></tr>
			<tr><td><div id="noticeBar"></div></td></tr>
			<tr height="20px"></tr>
			<tr><td id="wishListTd">
				<div id="wishNoticeDiv">찜 목록이 없습니다</div>
				<!-- <div id="product"></div>
				<div id="product"></div>
				<div id="product"></div>
				<div id="product"></div> -->
			</td></tr>
			<tr height=60px;></tr>
			
		</table>
	
     <%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>
     
     
     <script>
     
     	//위시리스트 스크립트 시작
     	var productArr = new Array();
		
		$(function(){
			var userNo = "<%= loginMember.getUserNo()%>";
						
			$.ajax({
				url: "<%= request.getContextPath() %>/myWishlist",
				type: "get",
				data: { userNo : userNo },
				success: function(data){
					
					if( data.length > 0){
						$("#wishListTd").find("div").remove();
					}
					
					var $wishBody = $("#wishListTd");
					
					for(key in data){
						if(key < 4){
							var wish = data[key];
							//userNo, proNo, manuName, proName, cngName
							<%-- console.log(wish.userNo);
							console.log(wish.proNo);
							console.log(wish.manuName);
							console.log(decodeURIComponent(wish.proName).replace(/\+/g, " "));
							console.log(wish.cngName);						
							$(".myWishlistImg").attr("src", "<%=request.getContextPath()%>/image/productImg/"+wish.cngName); --%>
							
							var $wishArticle = "<div id='product' onclick='toProductDetail(this);'>" 
								 			 + "<img class='myWishlistImg' src=" + '<%=request.getContextPath()%>/image/productImg/'+ wish.cngName + ">"
								 			 + "<div id='proNameDiv'>" + decodeURIComponent(wish.proName).replace(/\+/g, " ") + "</div>"
								 			 + "<span id='proNoDiv' style='display:none'>" + wish.proNo + "</span>" 
											 + "</div>";
							
							$wishBody.append($wishArticle);	
						}												
					}					
				},
				error: function(status){
					console.log(status);
				}
			});			
		});
		
		function toProductDetail(id){
			var productNo = $(id).find("span").html();
			//console.log(productNo);
			
			if(productNo.length > 5){
				location.href='<%=request.getContextPath() %>/selectOneDetail?proNum=' + productNo;
			}
		}
		
		//위시리스트 스크립트 끝
		
     </script>
  
</body>
</html>