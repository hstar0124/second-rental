<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.forest.product.model.vo.*, com.kh.forest.member.model.vo.*"%>
<%
	List<Rental> list = (List) request.getAttribute("rentalList");
	String num = (String)request.getAttribute("num");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int limit = pi.getLimit();
	int maxPage = pi.getMaxPage();
	int endPage = pi.getEndPage();
	int startPage = pi.getStartPage();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	#updateRange{
		margin:0 auto;
		width:900px;
		border:1px solid gray;
		margin-top:50px;
		margin-bottom:10px;
		border-left:none;
		border-right:none;
		border-top:2px solid black;
	}
	#updateBar{
		
	}
	.text1{
		margin-top:30px;
	}
	#updateTable{
	margin:0 auto;
	width:100%;
	margin-top:10px;
	}
	.deleteMainText{
		font-size:28px;
		font-weight:400;
		color:rgb(138, 4, 179);
		margin-left:10px;
		margin-top:10px;
	}
	#p1{
		font-size:13.5px;
		color:gray;
		font-weight:600;
		margin-left:3px;
	}
	.deleteText{
		margin-left:30px;
		font-weight:600;
	}
	.reason{
		margin-left:18px;
		width:400px;
		height: 150px;
		border-radius: 10px 10px 10px 10px;
		border: none;
		font-size:18px;
		caret-color:rgb(138, 4, 179);
		background: rgb(232, 232, 232);
		outline:none;
		
	}
	.text1{
		margin-left:10px;
	}
	#myInfo{
		background:#6E00AB;
		color:white;
	}
	#emailCheckBtn{
		width:70px;
		height:30px;
		background:#6E00AB;
		border:none;
		color:white;
		border-radius: 5px 5px 5px 5px;
		margin-left:10px;
		cursor: pointer;
	}
	#emailCode{
		margin-left:87px;
		width:200px;
		height:30px;
		border-radius: 10px 10px 10px 10px;
		border: 2px solid gray;
		text-indent: 16px;
		font-size:18px;
		text-align:center;
		outline:none;
		caret-color:#6E00AB;
	}
	#emailCodeCkBtn{
		width:70px;
		height:30px;
		background:#6E00AB;
		border:none;
		color:white;
		border-radius: 5px 5px 5px 5px;
		margin-left:10px;	
		cursor: pointer;
	}
	#nextBtn{
		width:130px;
		height:50px;
		margin-left:150px;
		border:none;
		border-radius: 20px 20px 20px 20px;
		background: rgb(232, 232, 232);
		color:white;
		font-weight:600;
		font-size:20px;
		outline:none;
		cursor: pointer;
	}
	#rentalTable{
		width:100%;
		border-collapse: collapse;
	}
	#return{
		background:#6E00AB;
		border:none;
		color:white;
		border-radius: 5px 5px 5px 5px;
		font-size:18px;
		margin-left:420px;
		margin-bottom:70px;
		cursor: pointer;
	}
	button{
		border:none;
		background:white;
	}
	
</style>

</head>
<body>

	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>	
		<h1 class="text1">회원 탈퇴</h1>
		<div style="background-color:purple; width:100%; height:4px; margin-top:0px; margin-bottom:40px;"></div>
		<label style="margin-left:165px; font-weight:700; font-size:28px;">렌탈 서비스를 이용중에서는 회원탈퇴가 불가합니다.</label><br>
		  	<label style="margin-left:220px; font-weight:700; font-size:28px;">고객센터(7367 - 9091)에 문의하여주세요.</label	>
		<div id="updateRange">
			<table id="rentalTable">
				<tr>
					<th style="border-bottom: 1px solid black; height:40px; background:">렌탈번호</th>
					<th style="border-bottom: 1px solid black;">상품</th>
					<th style="border-bottom: 1px solid black;">상품명</th>
					<th style="border-bottom: 1px solid black;">가격</th>
					<th style="border-bottom: 1px solid black;">렌탈 만료일</th>					
					<th style="border-bottom: 1px solid black;">상태</th>
				</tr>
			<%for(Rental r : list) { %>
				<tr style="border-bottom:1px solid black;">
					<td style="text-align:center;"><%=r.getRentalNo() %></td>
					<td style="text-align:center;"><img width=70px height=70px style="align:center;"
								src="<%=request.getContextPath()%>/image/productImg/<%=r.getChangeName()%>"></td>
					<td style="text-align:center;"><%= r.getProductName() %></td>
					<td style="text-align:center;"><%= r.getPrice() %>원</td>
					<td style="text-align:center;">~ <%= r.getExpiryDate() %></td>
					<td style="text-align:center;"><%= r.getRentalStatus() %></td>
				</tr>
			
			<% } %>	
			</table>
		
		</div>
		 <% if(pi != null){ %> 
      <div class="pagingArea" align="center">
      	<button onclick="location.href='<%= request.getContextPath()%>/deleteMember.me?currentPage=1&num=<%=num%>'"><<</button>
      <% if(currentPage <= 1){ %>
      	<button disabled><</button>
      <%} else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/deleteMember.me?currentPage=<%= currentPage -1%>&num=<%=num%>'"><</button>
      <% } %>
      
      <% for(int p =startPage ; p <= endPage; p ++ ) {  
    	  
    	  if(p == currentPage){
    	%>	  
    		<button disabled><%= p %></button>
    	<% } else { %>
    		<button onclick="location.href ='<%= request.getContextPath()%>/deleteMember.me?currentPage=<%= p%>&num=<%=num%>'"><%= p %></button>
    	<% } %>  
      
      <% } %>
      <% } %>
      
      
      
      <% if(currentPage >= maxPage) { %>
      	<button disabled>></button>
      <% } else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/deleteMember.me?currentPage=<%= currentPage +1 %>&num=<%=num%>'">></button>
      <% } %>
      
      <button onclick="location.href='<%= request.getContextPath()%>/deleteMember.me?currentPage=<%= maxPage%>&num=<%=num%>'">>></button>
      </div>
      
      <input type="button" id="return" value="돌아가기" style="margin-top:50px; width:180px; height:50px;" onclick="location.href='<%=request.getContextPath()%>/views/user/mypage/F_MyPageSection_memberUpdate.jsp'">
		<script>
			$(function(){
				
				$(".reason").blur(function(){
					if($(".reason").val() !=""){
						$("#nextBtn").css("background","#6E00AB");
						$("#nextBtn").attr("onclick","location.href='F_MyPageSection_memberDeleteResult.jsp'");
					}else{
						$("#nextBtn").css("background","rgb(232, 232, 232)");
					}
				});
				
			});
		</script>
	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>	

</body>
</html>