<%@page import="com.kh.forest.point.model.vo.CashBack"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.forest.point.model.vo.CashbackHistory, com.kh.forest.member.model.vo.PageInfo" %>
<%
	List<CashbackHistory> waitList = (List)request.getAttribute("cancleList");

	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>중고구마</title>


<style>
.searchGrid {
   width:100%;
   margin:0px;
}
.resultTable {
   width:100%;
    border: 1px solid #333333;
    border-collapse:collapse;
}

.resultTableTh {
   background-color: #A7C0E9;
   border:1px solid black;
}
.resultTableTd {
   text-align : center;
   border:1px solid black;
}
.DDD {
   background:#ECECEC;
   height:40px;
   line-height: 35px;
   border: 2px solid #B8B8B8;
}
.DDD1 {
   height:40px;
   line-height: 35px;
   width:100%;
}
.searchBtn{
	width:100px;
	height:30px;
	background: #6792DA;
	border:none;
	color:white;
	font-size:15px;
	border-radius: 5px 5px 5px 5px;
	cursor: pointer;
}
.keyWord{
	height:25px;
}
.sendMail{
	border:none;
	background:#828282;
	color:white;
	width:90px;
	height:25px;
	cursor: pointer;
}
.sanction{
	border:none;
	background:#828282;
	color:white;
	width:90px;
	height:25px;
}
.leave{
	border:none;
	background:#828282;
	color:white;
	width:90px;
	height:25px;
}
.pagingArea{
	margin:0 auto;
}
.memberInfoBtn{
	border:none;
	
}
.crmBtn{
	border:none;
	background:white;
	outline:none;
}
#userInfo{
	border:2px solid black;
	width: 996px;
	height:788px;
}
.userInfoTable{
	width:100%;
	height:100%;
}
#div5{
	display:inline-flex;
	height:100%;
	width:24.5%;
	margin-left:6px;
	border:1px solid black;
	align:center;
	cursor: pointer;
	
}
#div7{
	background:#16AAD8;
	color:white;
	border:none;
	cursor: pointer;
}
#div6,#div4,#div7{
	display:inline-flex;
	height:100%;
	width:24.5%;
	border:1px solid black;
	padding:0px;
	font-align:center;
	cursor: pointer;
}


#titleLb{
	margin:0 auto;
	font-weight:600;
	font-size:18px;
	cursor: pointer;
}
#cashWaitRange{
	display:none;
}
#waitRange{
}
button{
	border:none;
	color:#6E00AB;
	font-weight:600;
	background:white;
	font-size:14px;
	cursor: pointer;
}
#reasonBtn{
	width: 50px;
	height:20px;
	background:#16AAD8;
	border:none;
	color:white;
	border-radius:5px 5px 5px 5px;
	cursor: pointer;
}
</style>


</head>
<body onload="ready('환급신청관리', '회원관리', '환급신청관리');">

   <%@ include file="../common/C_menubar.jsp" %>
   
   <article id="waitRange">
   <form action='<%= request.getContextPath()%>/searchMember.me'>
   <div class="DDD1" style="margin-bottom:50px;">
			<div id="div5"><label id="titleLb">환급 처리 진행중</label></div><div id="div4"><label id="titleLb">환급 진행중</label></div><div id="div6"><label id="titleLb">환급 완료</label></div><div id="div7"><label id="titleLb">환급 취소</label></div>
      </div>
      <table class="searchGrid" >
         <colgroup>
            <col width="20%" style="background: rgba(218, 218, 218, 0.459)" text-align="center">
            <col style="background: rgba(212, 212, 212, 0.253)">
         </colgroup>
         <!-- <tr>
            <td>회원유형</td>
            <td>
               <input type="radio" name="orderCategory" id="everyMember" value="everyMember" checked>
                  <label for="everyOrder">사용</label>
                  
               <input type="radio" name="orderCategory" id="normalMember" value="normalMember">
                  <label for="depositComplete">환급</label>
                  
               <input type="radio" name="orderCategory" id="blackListMember" value="blackListMember">
                  <label for="readyDelivery">지급</label>
                  
               <input type="radio" name="orderCategory" id="leaveMember" value="leaveMember">
                  <label for="delivery">환불</label>
            
            </td>
         </tr> -->
         <tr>
            <td>검색 키워드</td>
            <td>
               <select name="keyWord" id="keyWordKind" class="keyWord">
                  <option value="userId">아이디</option>
                  <option value="userName">고객명</option>
                  <option value="userNo">고객번호</option>
               </select>
               <input type="text" id="keyword" name="keywordSearch" class="keyword1" style="height:18px; width:300px;">
            </td>
         </tr>
      </table>
      <br><br>
      <div align="center"><button class="searchBtn">검색</button></div>
      </form>
      <br><br>

      <div class="DDD">
      &nbsp;&nbsp;
      <%if(listCount != 0)  {%>
         <label>검색결과 : &nbsp; <%=listCount %> 건 </label><label class="searchCount"></label>&nbsp;&nbsp;&nbsp;
         <% } else { %>
         <label>검색결과 : -</label><label class="searchCount"></label>&nbsp;&nbsp;&nbsp;
         <% } %>
      </div>
      
   	<div id="modal" style = "display:none; padding:0; border:none;">
   		<div id="userInfo">
   			<table class="userInfoTable" border="1">
   				<tr style="background:skyblue;"><td height="10px"></td></tr>
   			</table>
   		</div>
   	</div>
   </article>
   <article id="waitRange1">
      <table class="resultTable">
         <tr>
         	<th class="resultTableTh"></th>
            <th class="resultTableTh"><label>환급이력번호</label></th>
            <th class="resultTableTh"><label>환급번호</label></th>
            <th class="resultTableTh"><label>환급금액</label></th>
            <th class="resultTableTh"><label>회원번호</label></th>
            <th class="resultTableTh"><label>회원명</label></th>
            <th class="resultTableTh"><label>일시</label></th>
            <th class="resultTableTh"><label>상태</label></th>
             <th class="resultTableTh"><label>상세</label></th>
         </tr>
        <% for(CashbackHistory c : waitList) { %> 
         <tr>
            <td class="resultTableTd"><input type="checkbox" class="reTbCheck" value="<%= c.getCashbackHistoryNo()%>"></td>
            <td class="resultTableTd"><%=c.getCashbackHistoryNo() %></td>
            <td class="resultTableTd"><%=c.getCashbackNo() %></td>
            <td class="resultTableTd"><%=c.getMoney() %>원</td>
            <td class="resultTableTd"><%=c.getUserNo() %> </td>
            <td class="resultTableTd"><%=c.getUserName() %></td>
            <td class="resultTableTd"><%=c.getCashbackDate() %></td>
            <td class="resultTableTd"><%=c.getStatus() %></td>
            <td class="resultTableTd"><input type="button" value="사유" id="reasonBtn"></td>
         </tr>
        
        <% } %>
      </table>
      
      <br><br>
     <% if(pi != null){ %> 
      <div class="pagingArea" align="center">
      	<button onclick="location.href='<%= request.getContextPath()%>/cashbackCancleAll.po?currentPage=1'"><<</button>
      <% if(currentPage <= 1){ %>
      	<button disabled><</button>
      <%} else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/cashbackCancleAll.po?currentPage=<%= currentPage -1%>'"><</button>
      <% } %>
      
      <% for(int p =startPage ; p <= endPage; p ++ ) {  
    	  
    	  if(p == currentPage){
    	%>	  
    		<button disabled><%= p %></button>
    	<% } else { %>
    		<button onclick="location.href ='<%= request.getContextPath()%>/cashbackCancleAll.po?currentPage=<%= p%>'"><%= p %></button>
    	<% } %>  
      
      <% } %>
      <% } %>
      
      
      
      <% if(currentPage >= maxPage) { %>
      	<button disabled>></button>
      <% } else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/cashbackCancleAll.po?currentPage=<%= currentPage +1 %>'">></button>
      <% } %>
      
      
      
      <button onclick="location.href='<%= request.getContextPath()%>/cashbackCancleAll.po?currentPage=<%= maxPage%>'">>></button>
      </div>
  
      <!-- --------------------- -->
      <hr>
      <label style="font-weight:600"></label>
      <div class="DDD">&nbsp;&nbsp;
      </div>
   </article>
   
   <script>
 
   		$(function(){
   			
   			$(".resultTable td").off("click").on('click',function(){
   				var num = $(this).parent().children().eq(4).text();
   				var name = $(this).parent().children().eq(5).text();
   				
   				$(this).parent().children().eq(4).off("click").on('click', function() {
   					var result = confirm(name + "님의 회원정보를 조회하시겠습니까?");
   					
   					if(result){
   						location.href='<%= request.getContextPath()%>/searchMember.me?orderCategory=everyMember&keyWord=userNo&keywordSearch='+num;
   					}else{
   						
   					}
   				});
   				
   				var num1 = $(this).parent().children().eq(1).text();
   				var userName=$(this).parent().children().eq(5).text();
				$(this).parent().children().eq(8).click(function(){
					window.open('<%= request.getContextPath()%>/selectReason.po?num1='+num1, "pop01", "top=100,left=300,width=400,height=500,location=no,scrollbars=no,status=no,resizable=0,titlebar=no,menubar=no,directories=no");
				});
   				
   			});
   			
   			
   			$("#printAll").click(function(){
   				location.href='<%= request.getContextPath()%>/exelAll.po'
   			});
   			
   			$("#print").click(function(){
   		 			var num = new Array();
   		 			var i = 0;
   		 			$(".reTbCheck").filter(":checked").filter(function(){
   		 				num[i] = $(this).val();
   		 				i++;
   					});
   		 			
   					location.href='<%= request.getContextPath()%>/printMember.po?num='+num; 
   		 		});
   		
   		});
   </script>   
 <script>
  $(function() {
    $( "#datepicker" ).datepicker({
      	showOn: "both", 
        buttonImage: "/forest/image/calendar.png",
        buttonImageOnly: true 
    });
    $( "#datepicker1" ).datepicker({
    });
    
    $("#div6").click(function(){
    	location.href="<%= request.getContextPath()%>/selectAllCashCom.po";
    });
    $("#div4").click(function(){
    	location.href="<%= request.getContextPath()%>/cashbackProAll.po";
    });
    $("#div7").click(function(){
    	location.href="<%= request.getContextPath()%>/cashbackCancleAll.po";
    });
    $("#div5").click(function(){
    	location.href="<%= request.getContextPath()%>/cashbackAll.po";
    });
   
  });
  
  </script>
   
   <%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>