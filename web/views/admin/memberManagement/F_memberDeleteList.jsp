<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.forest.member.model.vo.Member, com.kh.forest.member.model.vo.PageInfo"%>
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
.keyWord{
	height:25px;
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
	height:35px;
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
	cursor: pointer;
	
}
button{
	border:none;
	color:#6E00AB;
	font-weight:600;
	background:white;
	font-size:14px;
}

/* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
 /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            /* padding: 20px; */
            border: 1px solid #888;
            width: 50%; /* Could be more or less, depending on screen size */                          
        }
        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            margin-right:20px;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        
        .modalTop{
        	margin: 0;
        	width:100%;
        	height:50px;
        	background:#16AAD8;
        } 
        
        .infoTb{
        	width:80%;
        	margin:20px auto;
          	border-collapse:collapse;
          	border:1px solid gray;
        	
        }
        
        .infoTb tr td {
        	border:1px solid gray;
        }
        
        .staTb{
        	width:80%;
        	margin:20px auto;
        	border-collapse:collapse;
        	border:1px solid black;
        }
        
        .staTb tr:first-of-type {
        	background:#A7C0E9;
        }
        
        .staTb tr td {
        	border:1px solid black;
        }
        
        .modalBtn {
        	margin: 30px auto;
        	
        	text-align:center;
        }
        .cancel {
        	width: 125px;
			height: 40px;
			background: #6792DA;
			border:1px solid #6792DA;
			color:white;
        }
        
        .mdTt {
        	margin:30px;
        	font-size:25px;
        }
        
        .modalTt {
        	font-size:30px;
        	border-bottom:1px solid black;
        	width:95%;
        	margin:0 auto;
        	margin-top:10px;
        	font-weight:bold;
        }
        .modalTt span {
        	color: #FF8329;	
        	
        }
        .crmBtn{
			border:none;
			background:white;
			outline:none;
			cursor: pointer;
		}
		.sendMail{
			border:none;
			background:#828282;
			color:white;
			width:90px;
			height:25px;
			cursor: pointer;
		}
</style>

</head>
<body onload="ready('탈퇴회원관리','회원관리','탈퇴회원관리');">
	<%@ include file="../common/C_menubar.jsp" %>

	<article>
	<form>
		<table class="searchGrid">
			<colgroup>
				<col width="20%" style="background: rgba(218, 218, 218, 0.459)" text-align="center">
				<col style="background: rgba(212, 212, 212, 0.253)">
			</colgroup>
			
			<tr>
				<td>탈퇴일자 </td>
				<td>
					<input type="text" id="datepicker">~<input type="text" id="datepicker1">
					<button onclick="">오늘</button>
					<button onclick="">이번주</button>
					<button onclick="">이번달</button>
					<button onclick="">전체</button>
				</td>
			</tr>
			<tr>
				<td>검색 키워드</td>
				<td>
					<select>
						<option value=""></option>
						<option value="">아이디</option>
						<option value="">이름</option>
						<option value="">고객번호</option>
					</select>
					<input type="text" id="keyword" name="keyword" class="keyword">
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
            <th class="resultTableTh"><input type="checkbox"></th>
            <th class="resultTableTh"><label>고객번호</label></th>
            <th class="resultTableTh"><label>고객명</label></th>
            <th class="resultTableTh"><label>아이디</label></th>
            <th class="resultTableTh"><label>경고횟수</label></th>
            <th class="resultTableTh"><label>회원상태</label></th>
            <th class="resultTableTh"><label>처리일자</label></th>
            <th class="resultTableTh"><label>상세</label></th>
         </tr>
         <% for(Member m : list){ %>
		<tr>
			<td class="resultTableTd"><input type="checkbox" name="userNo" id="userNo"></td>
			<td class="resultTableTd"><%=m.getUserNo() %></td>
			<td class="resultTableTd"><%= m.getUserName() %></td>
			<td class="resultTableTd"><%= m.getUserId() %></td>
			<td class="resultTableTd">0</td>
			<td class="resultTableTd"><%= m.getStatus() %></td>
			<td class="resultTableTd"><%= m.getModifyDate() %></td>
			<td class="resultTableTd"><button type="button" class="crmBtn" id="crmBtn"><img src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px"></button></td>
		</tr>
		<% } %>
	
       
      </table>
      <br><br>
     <% if(pi != null){ %> 
      <div class="pagingArea" align="center">
      	<button onclick="location.href='<%= request.getContextPath()%>/deleteSelectAll.me?currentPage=1'"><<</button>
      <% if(currentPage <= 1){ %>
      	<button disabled><</button>
      <%} else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/deleteSelectAll.me?currentPage=<%= currentPage -1%>'"><</button>
      <% } %>
      
      <% for(int p =startPage ; p <= endPage; p ++ ) {  
    	  
    	  if(p == currentPage){
    	%>	  
    		<button disabled><%= p %></button>
    	<% } else { %>
    		<button onclick="location.href ='<%= request.getContextPath()%>/deleteSelectAll.me?currentPage=<%= p%>'"><%= p %></button>
    	<% } %>  
      
      <% } %>
      <% } %>
      
      
      
      <% if(currentPage >= maxPage) { %>
      	<button disabled>></button>
      <% } else { %>
      	<button onclick="location.href='<%= request.getContextPath()%>/deleteSelectAll.me?currentPage=<%= currentPage +1 %>'">></button>
      <% } %>
      
      
      
      <button onclick="location.href='<%= request.getContextPath()%>/deleteSelectAll.me?currentPage=<%= maxPage%>'">>></button>
      </div>
		<!-- --------------------- -->
		<hr>
		<label>회원관리</label>
		<div class="DDD">&nbsp;&nbsp;
			<button class="sendMail" id="memberRestore">탈퇴복구</button>
		</div>
	</article>
	
		<!-- The Modal -->
 
      <!-- Modal content -->
     <script>
  	$(function(){
  		$("#memberRestore").click(function(){
  			$("input[name=userNo]").filter(function(){
 				if($(this).is(":checked")){
 					var num = $(this).parent().parent().children().eq(1).text();
 					var re = $(this).parent().parent().children().eq(5).text();
 					console.log(re);
 					var result = confirm(num + "회원 님에 탈퇴를 복구시키겠습니까 ?");
 					if(result && re=="탈퇴"){
 						$.ajax({
 							type:"POST",
 							url :'<%= request.getContextPath() %>/memberRestore.me',
 							async: false,
 							data:{
 								"num" : num
 							},
 							success:function(data){
									alert("처리가 정상적으로 완료되었습니다.")	 		
									location.reload();
 							 }
 				 		});
 					}else if(result){
							alert("대상자가 아닙니다")	
						} 
 					
 				}
  				
  			});
  		});
  	});
 </script>
     
     
	<script>
 	$(function(){
 		$(".resultTable td").click(function(){
 			var num = $(this).parent().children().eq(1).text();
 			$(this).parent().children().eq(7).click(function(){
 				window.open('<%= request.getContextPath()%>/selectOne.me?num='+num, "pop01", "top=100,left=300,width=1000,height=800,location=no,scrollbars=no,status=no,resizable=0,titlebar=no,menubar=no,directories=no");
 		
 			});
 		});
 	});
 </script>
	<script>
	/* 날짜 input jquery ui */
		$.datepicker.setDefaults({
			showOn : "both",
			buttonImage : "/forest/image/calendar.png",
			buttonImageOnly : true,
			dateFormat : 'yy-mm-dd'

		});
		$(function() {
			$("#datepicker").datepicker({});
			$("#datepicker1").datepicker({});
			/* 달력버튼 */
			$("img.ui-datepicker-trigger")
					.attr("style","margin-left:2px; vertical-align:middle; cursor: Pointer; width:30px; height:30px");

		});
	
		
		
	
	</script>

	<%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>