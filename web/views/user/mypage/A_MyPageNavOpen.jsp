<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
#main{
    background: white;        
    width:1440px;
    height:100%;
    border:1px solid;
}

#bodynavHead{
    margin:0 auto;    
    width:20%;
    height:600px;
    float:left;
}
#section{
    margin:0;    
    width:70%;
    height:100%;
    float:left;
}

.bodyNav{
    background: white;      
    width:100%;
    height: 50px;
    line-height:50px;
    display: inline-block;
    text-indent:15px;
    font-size: 25px;
    border:1px solid;
    border-color:lightgray;              
    border-bottom: 0px;
}
.bodyNavLast{
    background: white;
    width:100%;
    height: 50px;
    line-height:50px;
    display: inline-block;         
    text-indent:15px;
    font-size: 25px;
    border:1px solid;     
    border-color:lightgray;   
}
#body{
    width:100%;
    margin-top: 45px;
}
#navName{
    margin:0 auto;
    width:100%;
    text-align: center;
    color:#6E00AB;

}
.bodyDiv{
    margin:0 auto;
      
    display: inline-block;        
    float:left;

}

.bodyNavTitle{
	margin:0;	
    margin-left:10px;   
    font-weight: 400;
    color:black;
    
}
#navLayout{
    width:65%;
    margin:0 auto;
}
.bodyNav, .bodyNavLast{
	cursor:pointer;
}
</style>



</head>
<body>
	<%@ include file="/views/user/common/B_UserMainHeader.jsp" %>	
	 
	<div id="body">
        <div id="bodynavHead">
                <div id="navLayout">
                    <div id="navName"><h1>MY PAGE</h1></div>
                    <div class="bodyNav" id="" onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or'"><h5 class="bodyNavTitle">주문현황</h5></div>
                    <div class="bodyNav" id="buyCurrent" onclick="location.href='<%=request.getContextPath()%>//mypageBuylist.buy'"><h5 class="bodyNavTitle" id="buyCurrent">판매현황</h5></div>
                    <!-- <div class="bodyNav" id="" onclick="location.href='D_MyPageSection_as.jsp'"><h5 class="bodyNavTitle" id="as">A/S 신청내역</h5></div> -->
                    <div class="bodyNav" id="myBasket" onclick="location.href='<%=request.getContextPath()%>/views/user/mypage/A_MyPageSection_shoppingBasket.jsp'"><h5 id="myBasketText" class="bodyNavTitle">장바구니</h5></div>
                    <div class="bodyNav" id="myWish" onclick="location.href='<%=request.getContextPath()%>/views/user/mypage/A_MyPageSection_wishList.jsp'"><h5 id="myWishText" class="bodyNavTitle">위시리스트</h5></div>
                    <div class="bodyNav" id="myReview" onclick="location.href='<%=request.getContextPath()%>/selectListUser.re'"><h5 class="bodyNavTitle" id="myReview">나의 활동</h5></div>                
                    <div class="bodyNav" id="myInfo" onclick="location.href='<%= request.getContextPath()%>/views/user/mypage/F_MyPageSection_memberUpdate.jsp'"><h5 class="bodyNavTitle" id="myInfo">나의 정보</h5></div>
                    <div class="bodyNav" id=""><h5 class="bodyNavTitle" onclick="location.href='<%=request.getContextPath()%>/rentalList'">렌탈 현황</h5></div>  
                    <div class="bodyNavLast" id="notice" onclick="location.href='<%=request.getContextPath()%>/selectList2.no'"><h5 class="bodyNavTitle" id="notice">공지사항</h5></div>
                </div>
        </div>
     	<div id="section">   
     	
</body>
</html>