<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.forest.member.model.vo.Member"%>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
%>    
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>중고구마</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
#wrap {
	width: 1440px;
	/* height:2500px; */
	margin: 0 auto;
}
`
#header {
	/* height: px; */
	width: 80%;
	margin: auto;
}

#nav {
	width: 100%;
}

#footer {
	height: 250px;
	width: 80%;
	margin: auto;
}

/*---------header-----------------*/
.header-title {
	text-align: center;
	width: 100%;
	height: 150px;
	margin: 0px;
	/* table-layout:fixed; */
}

.logo {
	padding: 0px;
	width: 30%;
	cursor: pointer;
}

.header-title>tr>td {
	margin: 0px;
}

.hearder-search {
	width: 60%;
}

.search-div {
	display: flex;
	width: 400px;
	height: 50px;
	border: #6E00AB solid 3px;
}

.search-div>input[name=mainSearch] {
	width: 350px;
	height: 50px;
}

#main-searchBtn {
	width: 60px;
	height: 50px;
	border: none;
	background-image: url('/forest/image/userimg/seach1.png'); 
	cursor: pointer;
}


/* .search-div {
	background: red;
	width: 400px;
	height: 56px;
	border: #6E00AB solid 3px;
} */

.header-login>td {
	border-spacing: 1px;
	padding: 0px;
/* 	vertical-align: top; */
	
}

.header-hr {
	margin-top: 0px;
	margin-bottom: 0px;
	width: 100%;
	border-bottom: 0px;
	border-color: lightgray;
}
#log, #create1, .basket{
	cursor:pointer;
}


/*----------------nav------------*/
.nav-table{
    text-align: center;    
    margin-top: 13px;
    margin-bottom: 13px;
    width: 700px;
}
.nav-sub{
    font-weight: 500;
    color: #3D3C3C;
    font-size: 17px;
    width: 400px;
    z-index: 10;
    cursor: pointer;
    font-weight: 600;
}
.nav-sub:nth-of-type(1):hover {
    color: #6E00AB;

}
.nav-sub:nth-of-type(1):hover  .sub-div{   
    background: rgba(211, 211, 211, 0.38);

}
.nav-sub:nth-of-type(1):hover  .sub-menu1{   
    /* width: 400px;
    height: 50px;
    text-align: center;    
    color: #444343;
    font-size: 17px; */
    opacity: 1;
    
}

/*서브메뉴*/
 .sub-div{
    width: 1440px;
    height:0px;
    background: white;
    margin: 0  auto;
    position: relative;
    z-index: 10;   
    
}
 .sub-menu1{
    width: 1440px;
    height: 50px;
    text-align: center;    
    color: #444343;
    font-size: 17px;
    margin: 0 auto;
    background: rgba(211, 211, 211, 0.38);
    opacity: 0;
    
    
}  
.sub-menu1 td, .sub-menu2 td{
    width: 100px;
    cursor:pointer;
}
.sub-menu1 td:nth-of-type(1), .sub-menu1 td:nth-last-of-type(1){
    width: 300px;
}
.sub-menu2 td:nth-of-type(1), .sub-menu2 td:nth-last-of-type(1){
    width: 300px;
}
.sub-menu2{
     position: absolute;
    width: 1440px;
    height: 50px;
    left: 0px;
    top: 0px;
    text-align: center;    
    color: #444343;
    font-size: 17px; 
    background: rgba(211, 211, 211, 0.38);
    opacity: 0;

    
    
}


/*---------footer-----------*/
.footer-table {
	/* position: absolute; */
	width: 1440px;
	height: 100px
}

/*---------quick menu----------*/
#followquick {
	position: absolute;
	width: 50px;
	height: 50px;
	left: 95%;
	top: 80%;
	color: #fff;
	z-index: 100;
	cursor:pointer;
}

</style>
</head>
<body >
    <div id="wrap">
    
    	<!-- 퀵메뉴 시작 -->
    	<div id="followquick" onclick="chatPopUp();">
			<img src="<%= request.getContextPath()%>/image/chatImg/sns.png" alt="??">
		</div>    	
    	<!-- 퀵메뉴 끝-->
    
        <!-- 헤더시작 -->
		<header id="header">
			<form class="header-form" action="<%=request.getContextPath()%>/selectCategoryProduct.main" >
				<table class="header-title">
					<tr align="center" height="25px;">

							
						<td class="logo" rowspan="2" colspan="2" align="center">
							<!-- <input type="image" src="/forest/image/userimg/logo.png" width="200px" height="60px"> -->
							<img src="/forest/image/userimg/logo.png" onclick="location.href='<%= request.getContextPath()%>/index.jsp'" width="200px" height="60px">
						</td>

						<!-- 검색하는부분!! -->
						<td class="header-search" rowspan="2" colspan="3" align="left">
							<div class="search-div">
								<input type="search" name="mainSearch" id="mainSearch"> 
								<span></span><button id="main-searchBtn"></button></div>
							</div>
							<div class="autocomplete">
								
							</div>
						</td>
						<!-- //검색하는부분끝!! -->

						<div class="header-login">
							<td style="width:80px; border-right: 1px solid black;" id="create1" onclick="location.href='<%= request.getContextPath()%>/views/user/member/F_memberCheck.jsp'">회원가입 </td>
							<%if(loginMember != null) { %>
								<td style="width:100px; font-size:14px; cursor:pointer; color:#444343; font-weight:600;" onclick="location.href='<%= request.getContextPath() %>/selectListMain.no'">
								<img src="/forest/image/userimg/human.png" style="width:17px; height:17px;">&nbsp;<%=loginMember.getUserName() %> 님 </td>
							<% } %>
							<td style="width:70px; border-right: 1px solid black;" text-align="right" id="log" onclick="location.href='/forest/views/user/member/F_login.jsp'">로그인 </td w>
							<td style="width:120px;" class="basket" text-align="left" onclick="location.href='<%= request.getContextPath() %>/views/user/mypage/A_MyPageSection_shoppingBasket.jsp'">
							<img src="/forest/image/userimg/cart.png" style="width:30px; height:22px;"> 장바구니</td>

						</div>
						
						<script>
						<% if(loginMember != null) { %>
							$("#log").text("로그아웃");
							$("#log").attr("onclick", "location.href='<%= request.getContextPath()%>/logOut.me'");
							$("#create1").css("visibility", "hidden");
							//$("#myPage").attr("onclick", "location.href='/forest/views/user/mypage/A_MyPageSection_wishList.jsp'");
						<%}%>
						
						</script>
					</tr>
					<tr align="center" height="125px;">
                        <td width="70px;"></td>
                        <td width="80px;"></td>                        
                        <td colspan="3" width="120px;"></td>
                    </tr>
				</table>
			</form>
		</header>
		<!-- 헤더끝 -->
        <hr class="header-hr">
        <!-- 네비시작 -->
        <nav id="nav">
            <table class="nav-table" align="center">
                <tr>
                    <td class="nav-sub" id="menu1"> 디지털 </td>
                    <td class="nav-line">|</td>
                    <td class="nav-sub" id="menu2"> 가전제품 </td>
                    <td class="nav-line">|</td>
                    <td class="nav-sub" id="buyMain" onclick="location.href='/forest/views/user/buy/B_buyMain.jsp'">상품 판매하기</td>
                    <td class="nav-line">|</td>
                    <% if(loginMember == null) { %>
                    <td class="nav-sub" id="myPage" onclick="location.href='<%=request.getContextPath() %>/views/user/member/F_login.jsp'">마이페이지</td>
                	<% } else { %>
                	<td class="nav-sub" id="myPage" onclick="location.href='<%=request.getContextPath() %>/selectListMain.no'">마이페이지</td>
                	<% } %>
                </tr>
            </table>
            
            <hr class="header-hr">
            
         <div class="sub-div">
                <table class="sub-menu1" >
                    <tr>
                    	<td></td>
                        <td>전체</td>            	
                        <td>생활가전</td>            	
                        <td>주방가전</td>            	
                        <td>미용가전</td>    
                        <td></td>        	
                    </tr>
                </table>
    
                <table class="sub-menu2">
                    <tr>
                    	<td></td>
                        <td>전체</td>            	
                        <td>노트북</td>            	
                        <td>태블릿PC</td>
                        <td></td>            	
                    </tr>
                </table>
            </div>
        </nav>
        <script>
        
        function chatPopUp(){
        	window.open('<%= request.getContextPath()%>/views/user/chatting/A_userChat.jsp'
        			  , 'window팝업'
        			  , 'width=650, height=700, menubar=no, status=no, toolbar=no');
        }
        
            $(function(){
            	$("#menu1").mouseenter(function(){
            		$(".sub-menu2").css({"opacity":"1"});
            		$(".sub-menu1").css({"opacity":"0"});
            		
            	$(".sub-div").mouseleave(function(){
            		$(".sub-menu2").css({"opacity":"0"});
            	});
            	
            	});
            	
            });
            
            $(function(){
            	$("#menu2").mouseenter(function(){
            		$(".sub-menu1").css({"opacity":"1"});
            		$(".sub-menu2").css({"opacity":"0"});
            		
            	$(".sub-div").mouseleave(function(){
            		$(".sub-menu1").css({"opacity":"0"});
            	});
            	
            	});
            	
            });           
            
                   	
            $(document).ready(function() {
            	// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
            	var floatPosition = parseInt($("#followquick").css('top'));
            	// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

            	$(window).scroll(function() {
            		// 현재 스크롤 위치를 가져온다.
            		var scrollTop = $(window).scrollTop();
            		var newPosition = scrollTop + floatPosition + "px";

            		/* 애니메이션 없이 바로 따라감
            		 $("#floatMenu").css('top', newPosition);
            		 */

            		$("#followquick").stop().animate({
            			"top" : newPosition
            		}, 200);

            	}).scroll();
            });

         	            
        </script>
        
         <script>
         $(function(){
        	    $( "#mainSearch" ).keyup(function(){
        	    	//console.log("dh");
        	    	
        	    	 var keyword = $(this).val();
        	    	 console.log("keyword:" + keyword);
                     var dataString = 'searchword='+ keyword;                
                                 
                                 
                     if(keyword=='') { 
                         $("#autocomplete").hide();
                     } else {    
                         $.ajax({
                         type: "post",
                         url: "/selectAutoSearch.main",
                         data: dataString,
                         cache: false,
                         success: function(html) {      
                        	// console.log($("#autocomplete").html(html).show());
                             $("#autocomplete").html(html).show();
                             },
                         error: function(error){
                        	// console.log(error);
                         }
                         });
                     } return false; 
        	            
        	    });
        	    
        	});
        </script> 
        
        </nav>
        <!-- 네비끝 -->
        

           
