<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.forest.member.model.vo.Member, com.kh.forest.member.model.vo.PageInfo" %>
<%
	List<Member> list = (List)request.getAttribute("list");
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
.searchBtn{
	width:100px;
	height:30px;
	background: #6792DA;
	border:none;
	color:white;
	font-size:15px;
	border-radius: 5px 5px 5px 5px;
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
	cursor: pointer
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
	display:none;
	cursor: pointer
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
button{
	border:none;
	color:#6E00AB;
	font-weight:600;
	background:white;
	margin-bottom:20px;
	font-size:14px;
}
</style>


</head>
<body onload="ready('회원리스트', '회원관리', '회원리스트');">

   <%@ include file="../common/C_menubar.jsp" %>
   <article>
   <form action='<%= request.getContextPath()%>/searchMember.me'>
      <table class="searchGrid" >
         <colgroup>
            <col width="20%" style="background: rgba(218, 218, 218, 0.459)" text-align="center">
            <col style="background: rgba(212, 212, 212, 0.253)">
         </colgroup>
         <tr>
            <td>회원유형</td>
            <td>
               <input type="radio" name="orderCategory" id="everyMember" value="everyMember" checked>
                  <label for="everyOrder">일반 회원</label>
               <input type="radio" name="orderCategory" id="normalMember" value="normalMember">
                  <label for="depositComplete">탈퇴 회원</label>
        
               <input type="radio" name="orderCategory" id="blackListMember" value="blackListMember">
                  <label for="readyDelivery">제제 회원</label>

                  
            </td>
         </tr>
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
   
   <article>
      <table class="resultTable">
         <tr>
            <th class="resultTableTh"><label>고객번호</label></th>
            <th class="resultTableTh"><label>고객명</label></th>
            <th class="resultTableTh"><label>아이디</label></th>
            <th class="resultTableTh"><label>포인트</label></th>
            <th class="resultTableTh"><label>경고횟수</label></th>
            <th class="resultTableTh"><label>로그인횟수</label></th>
            <th class="resultTableTh"><label>회원상태</label></th>
            <th class="resultTableTh"><label>가입일</label></th>
            <th class="resultTableTh"><label>상세</label></th>
         </tr>
         <% for(Member m : list){ %>
		<tr>
			<td class="resultTableTd"><%=m.getUserNo() %></td>
			<td class="resultTableTd"><%= m.getUserName() %></td>
			<td class="resultTableTd"><%= m.getUserId() %></td>
			<td class="resultTableTd"><%= m.getPoint() %></td>
			<td class="resultTableTd"><%= m.getWarningCount() %></td>
			<td class="resultTableTd"><%= m.getLogCount()%></td>
			<td class="resultTableTd"><%= m.getStatus() %></td>
			<td class="resultTableTd"><%= m.getEnrollDate() %></td>
			<td class="resultTableTd"><input type="button" class="crmBtn" id="crmBtn"><img src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px"></td>
		</tr>
		<% } %>
	
       
      </table>
      <br><br>
      
     <% if(pi != null){ %> 
      <div class="pagingArea" align="center">
      	<button onclick="location.href='<%= request.getContextPath()%>/selectAll.me?currentPage=1'"><<</button>
      <% if(currentPage <= 1){ %>
      	<button disabled><</button>
      <%} else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/selectAll.me?currentPage=<%= currentPage -1%>'"><</button>
      <% } %>
      
      <% for(int p =startPage ; p <= endPage; p ++ ) {  
    	  
    	  if(p == currentPage){
    	%>	  
    		<button disabled><%= p %></button>
    	<% } else { %>
    		<button onclick="location.href ='<%= request.getContextPath()%>/selectAll.me?currentPage=<%= p%>'"><%= p %></button>
    	<% } %>  
      
      <% } %>
      <% } %>
      
      
      
      <% if(currentPage >= maxPage) { %>
      	<button disabled>></button>
      <% } else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/selectAll.me?currentPage=<%= currentPage +1 %>'">></button>
      <% } %>
      
      
      
      <button onclick="location.href='<%= request.getContextPath()%>/selectAll.me?currentPage=<%= maxPage%>'">>></button>
      </div>
     
      <!-- --------------------- -->
      <hr>
      <label style="font-weight:600"></label>
      <div class="DDD">&nbsp;&nbsp;
       
      </div>
   </article>
 <script>
 	<%-- $("#crmBtn").click(function(){
 		window.open('<%= request.getContextPath()%>/selectOne.me', "pop01", "top=100,left=300,width=1000,height=800,location=no,scrollbars=no,status=no,resizable=0,titlebar=no,menubar=no,directories=no");
 	}); --%>
 	
 	
 		$(".resultTable td").click(function(){
 			var num = $(this).parent().children().eq(0).text();
 			$(this).parent().children().eq(8).click(function(){
 				window.open('<%= request.getContextPath()%>/selectOne.me?num='+num, "pop01", "top=100,left=300,width=1000,height=800,location=no,scrollbars=no,status=no,resizable=0,titlebar=no,menubar=no,directories=no");
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
  });
  </script>
   
   <%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>