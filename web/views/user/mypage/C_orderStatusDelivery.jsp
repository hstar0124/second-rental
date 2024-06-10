<%@page import="com.kh.forest.order.model.vo.DeliveryHistoryPurchase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DeliveryHistoryPurchase dhp = (DeliveryHistoryPurchase) request.getAttribute("dhp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송조회</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
   body {
		padding:0;
		margin:0;
		font-size:13px;
	}
    button{
    	cursor:pointer;
    }
        /* Modal Content/Box */
        .modal-content3 {
            background-color: #fefefe;
            margin: 0 auto; /* 15% from the top and centered */
            width: 100%; /* Could be more or less, depending on screen size */                          
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
        .modalTb3 {
        	margin:30px auto;
        	width:90%;
        	border:2px solid lightgray;
        	border-collapse: collapse;
        	height:170px;
        	line-height:200%;
        }
        .modalTb4 {
        	margin:30px auto;
        	width:90%;
        	border:2px solid lightgray;
        	border-collapse: collapse;
        	line-height:200%;
        }
        .modalTop{
        	margin: 0;
        	width:100%;
        	height:50px;
        	background:#6E00AB;
        } 
        .modalTb3 td {
        	border:1px solid lightgray;
        	padding:8px;
        }
        .modalTb4 td {
        	border:1px solid lightgray;
        	padding:8px;
        }
        .modalBtn {
        	margin: 30px auto;
        	
        	text-align:center;
        } 
        .modalBtn span button {
        	width:100px;
        	height:40px;
        }
        
        .buyCancel {
        	background:#BABABA;
			color:white;
			border:1px solid #BABABA;
        }
        .modalBtn .cancel {
        	background:#6E00AB;
        	border:1px solid #6E00AB;
        	color:white;
        
        }
        caption {
        	text-align:left;
        	font-weight:bold;
        }
</style>
</head>
<body>
<!------------------------------- 배송조회 modal 영역 -------------------------------->
      <!-- Modal content -->
      <div class="modal-content3">
        <span class="close">&times;</span>                                                               
        <div class="modalTop"></div>
        	<table class="modalTb3">
        	<colgroup>
        		<col width="30%">
        	</colgroup>
        		<caption>택배정보</caption>
        		<tr>
        			<td>운송장번호</td>
        			<td><%= dhp.getWaybillNo()%></td>
        		</tr>
        		<tr>
        			<td>보낸사람</td>
        			<td>(주)중고구마</td>
        		</tr>
        		<tr>
        			<td>받는사람</td>
        			<td><%= dhp.getRecipient() %></td>
        		</tr>
        		<tr>
        			<td>받는주소</td>
        			<td id="address"></td>
        		</tr>
        	</table>
        	<table class="modalTb4"  id="modalTb4">
        		<caption>배송상세</caption>
        		<thead>
        		<tr>
        			<th>시간</th>
        			<th>현재 위치</th>
        			<th>배송 상태</th>
        		</tr>
        		<thead>
        		<tbody>
        		
        		</tbody>
        	</table>
        <div class="modalBtn">
        	<span><button class="cancel">확인</button></span>&nbsp;
        </div>
      </div>
 
    
    <script>
    	$(function(){
    			var key = 'EEo2Y8YF1u45O8pwQN3Aew'
    			var t_code = '04';
    			var t_invoice = '<%= dhp.getWaybillNo()%>';
    			$.ajax({
    				url:"http://info.sweettracker.co.kr/api/v1/trackingInfo?t_key="+ key +"&t_code="+t_code+"&t_invoice="+t_invoice,
    				type:"GET",
    				dataType : "json",
    				success:function(data){
    							
    					$tableBody = $("#modalTb4 tbody");
    					$tableBody.html('');
    					
    					var trackingDetails = data.trackingDetails;
    					
    					$.each(trackingDetails, function(index, value){
    						var $tr = $("<tr>");
    						var $timeTd = $("<td>").text(value.timeString);
    						var $whereTd = $("<td>").text(value.where);
    						var $kindTd = $("<td>").text(value.kind);
    						
    						$tr.append($timeTd);
    						$tr.append($whereTd);
    						$tr.append($kindTd);
    						$tableBody.append($tr);
    					});
    				}
    			});
    			
    			$(".cancel").click(function(){
    				window.close();
    			});
    			
    			
    			var address = '<%= dhp.getAddress()%>';
    			var array = address.split("$");
    			address = array[1]+ " " +array[2];
    			$("#address").text(address);
    			
    			
    	})
    </script>
</body>
</html>