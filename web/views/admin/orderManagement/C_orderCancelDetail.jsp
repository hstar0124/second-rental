<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.order.model.vo.*"%>
<%
	ArrayList<OrderStatus> list = (ArrayList<OrderStatus>) request.getAttribute("list");	
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	body {
		padding:0;
		margin:0;
	}
	.modal-content {
            background-color: #fefefe;
            margin: 0% auto; /* 15% from the top and centered */
            /* padding: 20px; */
            /*border: 1px solid #888;*/
            width: 100%; /* Could be more or less, depending on screen size */                          
            height: 100%;
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
        	text-align:center;
        }
        .staTb tr th {
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
</style>
</head>
<body>
 
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>                                                               
        <div class="modalTop"></div>
        <div class="modalTt"><span><%= list.get(0).getOrderNo() %></span>상세정보</div>
        <div class="mdTt"><b>상품정보</b></div>
        <table class="infoTb">
        	<colgroup>
        		<col style="background:lightgray">
        		<col>
        		<col style="background:lightgray">
        		<col>
        	</colgroup>
        	<tr>
        		<td>제품명</td>
        		<td><%= list.get(0).getProductName() %></td>
        		<td>상품번호</td>
        		<td><%= list.get(0).getProductNo() %></td>
        	</tr>
        	<tr>
        		<td>구매자명</td>
        		<td><%= list.get(0).getUserName() %></td>
        		<td>가격</td>
        		<td><%= list.get(0).getPrice() %></td>
        	</tr>
        	<tr>
        		<td>주문번호</td>
        		<td><%= list.get(0).getOrderNo() %></td>
        		<td></td>
        		<td></td>
        	</tr>
        </table>
        <br><br>
        <div class="mdTt"><b>처리현황</b></div>
        <table class="staTb">
        	<tr>
        		<th>번호</th>
        		<th>처리현황</th>
        		<th>처리시각</th>
        	</tr>
        	<% 
        	int index = list.size();
        	for(OrderStatus os : list){ 
        	%>
        		<tr>
        			<td><%= index %></td>
        			<td><%= os.getStatus() %></td>
        			<td><%= os.getHistoryDate() %>
        		</tr>
        	<%
        		index--;
        	} %>
        </table>
        <div class="modalBtn">
        	<span><button class="cancel" onclick="window.close();">확인</button></span>
        </div>
      </div>
	
	
</body>
</html>