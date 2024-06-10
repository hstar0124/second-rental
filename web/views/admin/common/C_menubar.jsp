<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.forest.admin.model.vo.Admin"%>
<%
	String title = (String) session.getAttribute("mainTitle");
	if (title == null) {
		title = "메인";
	}
	Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<!-- font -->
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<!-- jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- jquery UI -->
<script
   src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
   integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
   crossorigin="anonymous"></script>
<!-- jquery UI calendar-->
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
  <!-- 
  텍스트 창 API  
    include codemirror (codemirror.css, codemirror.js, xml.js, formatting.js)
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/codemirror.css">
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/theme/monokai.css">
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/codemirror.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/mode/xml/xml.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/codemirror/2.36.0/formatting.js"></script>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>

<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
include summernote css/js
이 css와 js는 로컬에 있는 것들을 링크시킨 것이다.
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<link rel="stylesheet" href="/forest/views/summernote/example.css">
  <script type="text/javascript" src="../../summernote/plugin/hello/summernote-ext-hello.js"></script>
  
  
  <link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    -->
   
<style>
header {
	background: #16AAD8;
	height: 52px;
	font-size: 30px;
	margin: 0;
	vertical-align: middle;
	font-family: 'Do Hyeon', sans-serif;
}



.goguma {
	margin: 0;
	padding-top: 5px;
	padding-left: 10px;
	color: white;
	float: left;
}

.navi {
	width: 160px;
	height: 100%;
	background: #354052;
	overflow: auto;
} 

.menuTitle {
	font-size: 20px;
	font-weight: bold;
}

.menuTable {
	font-family: '고딕';
	color: white;
}

tr {
	height: 40px;
}

div {
	margin: 0;
}

.navi {
	float: left;
	height: 100%;
}

section {
	float: none;
	margin-left: 216px;
	width: 100% -216px;
}

.menuList {
	border: 0;
	background: none;
	color: white;
	font-family: '고딕';
	font-size: 13px;
}

.logout {
	float: right;
	<!--position: absolute;-->
	<!--right: 20px;-->
	padding-top: 13px;
	padding-right: 20px;
	font-weight: bold;
	border: 0;
	background: none;
	color: white;
	height:100%;
}

body {
	margin: 0;
}

.menuList:hover {
	font-weight: bold;
}

article {
	margin: 0 auto;
	padding-top: 50px;
	float: none;
	width: 80%;
}

#mainPage{
	margin:0 auto;
}

.detailMenu {
	float:right;
	height:100%;
}
.searchBtn{
	width:100px;
	height:30px;
	background: #6792DA;
	border:none;
	color:white;
	font-size:15px;
	border-radius: 5px 5px 5px 5px;
}
.menuList:hover {
   cursor:pointer;
}
.goguma:hover {
   cursor:pointer;
}
#chatAlertDiv{
	margin: 0;
	margin-right: 50px;
	height: 52px;
	line-height: 52px;	
	padding-top: 2px;
	float: right;
	background: none;
	
}
#chatAlertImg{
	height: 20px;
	width: 20px;
	margin-top: 5px;
}
#chatAlertText{
	font-size: 25px;
	font-weight: 100;
	margin: 0px;
	color: white;
}

</style>

</head>
<body>
	<div id="mainPage" style="width: 1440px; height: 100%;">
		<header>
			<h3 class="goguma" onclick="location.href='<%= request.getContextPath()%>/selectAdminMain.em'">중고구마</h3>
			<button class="logout" onclick="location.href='<%= request.getContextPath()%>/adminLogout.em'"><%= loginAdmin.getEmpId()%> 님 로그아웃</button>
			<div onclick="location.href='<%=request.getContextPath()%>/views/admin/community/A_ptopQuestion.jsp'" id="chatAlertDiv">
				<img id="chatAlertImg" src="<%= request.getContextPath()%>/image/adminImg/chatAlert.png">				
				<span id="chatAlertText">0</span>
			</div> 
		</header>
		
		<script>
		$(function(){			
			//안읽은 메시지 갯수를 메뉴바에 세팅한다				
			$.ajax({
				url: "<%= request.getContextPath()%>/chatList",
				type: "get",
				success: function(data){
					//console.log(data);
					
					for(var key in data){
						
						var user = data[key];	
						$("#chatAlertText").html(user.readCount);	
						//console.log(user.readCount);
					}					
				},
				error: function(status){
					console.log(status);
				}		
			});		
		});		
		</script>
		
		<div class="middleCon">

			<nav class="navi EqHeightDiv">
				<table class="menuTable" align="center">
					<tr>
						<td>@</td>
						<td class="menuTitle">상품관리</td>
					</tr>
					<tr>
						<td rowspan="5"></td>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/productList'">상품리스트</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/categorySelect'">재고등록</button></td>
					</tr>
					<!--<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectDefaultInfo'">상품
								기본정보 설정</button></td>
					</tr>-->
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/inventoryList'">상품
								재고 관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/rentalCondition'">렌탈 현황</button></td>
					</tr>
					<!-- <tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/views/admin/productManagement/E_categoryManagement.jsp'">카테고리
								관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/views/admin/productManagement/E_product_tnd.jsp'">상품
								이동/삭제</button></td>
					</tr> -->
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/barcodeList'">바코드
								관리</button></td>
					</tr>




					<tr>
						<td>@</td>
						<td class="menuTitle">주문관리</td>
					</tr>
					<tr>
						<td rowspan="4"></td>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/select.pur'">주문현황
								관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectCancel.or'">주문취소
								관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/collRental'">회수
								관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectRefund.or'">환불
								관리</button></td>
					</tr>


					<!-- <tr>
						<td>@</td>
						<td class="menuTitle">배송관리</td>
					</tr>
					<tr>
						<td></td>
						<td><button name="menuList" class="menuList" onclick="location.href='views/admin/testPage.jsp">배송현황
								관리</button></td>
					</tr> -->


					<tr>
						<td>@</td>
						<td class="menuTitle">회원관리</td>
					</tr>
					<tr>
						<td rowspan="6"></td>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectAll.me'">회원리스트</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/historyAll.me'">회원이력
								관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/deleteSelectAll.me'">탈퇴회원
								관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/reportSelectAll.me'">불량회원관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectAll.po'">포인트
								이력</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/cashbackAll.po'">포인트
								환급관리</button></td>
					</tr>
					<%-- <tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/views/admin/productManagement/E_inventoryList.jsp'">자동
								SMS 설정</button></td>
					</tr> --%>


					<tr>
						<td>@</td>
						<td class="menuTitle">매입관리</td>
					</tr>
					<tr>
						<td rowspan="3"></td>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectRequestList.ad'">매입
								신청 관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectCurrentList.ad'">매입
								현황 관리</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectRejectList.ad'">매입
								불가 관리</button></td>
					</tr>


					<tr>
						<td>@</td>
						<td class="menuTitle">통계관리</td>
					</tr>
					<tr>
						<td rowspan="3"></td>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectSysdate.me'">회원
								통계</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%= request.getContextPath()%>/productStatic'">상품
								통계</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%= request.getContextPath()%>/orderStatsSysdate.me'">매출
								통계</button></td>
					</tr>



					<tr>
						<td>@</td>
						<td class="menuTitle">커뮤니티</td>
					</tr>
					<tr>

						<td rowspan="3"></td>
						<td><button name="menuList" class="menuList" onclick="location.href='<%= request.getContextPath() %>/selectList.no'">
								공지사항</button></td>

					</tr>
					<%-- <tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/views/admin/community/D_asRequestList.jsp'">
								A/S요청관리</button></td>
					</tr> --%>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/views/admin/community/A_ptopQuestion.jsp'">
								1:1문의사항</button></td>
					</tr>
					<tr>
						<td><button name="menuList" class="menuList" onclick="location.href='<%=request.getContextPath()%>/selectList.re'">
								리뷰관리</button></td>
					</tr>

				</table>

			</nav>
			
			<!-- <script>
				$(function(){
					$(".menuList").parent("td").css("display","table-low");
				});
			</script> -->

			
			<section class="sect EqHeightDiv">
				<article>
					<span id="mainTitle" style="font-size: 30px; font-weight: bold;"></span>
					<div class="detailMenu"><span id="cate_1"></span> > <span id="cate_2"></span></div>
					<hr>
				</article>
				
				
				
				