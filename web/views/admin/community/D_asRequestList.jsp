<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style> 
	.h {
	}
	.D{ 
		font-color : black;
		font-size : 14px;
	}
	.D td{
        border : 1px black;
        border-style: solid;
        font-size : 14px;
       
        
    }
    .D table{
    	align : center;
        background : white;
        
        width : 100%;
        color : black;
        margin-bottom : 30px;
        
        }
    .D table:not(.table1){
    	border-collapse: collapse;
    }
    .table1 td{
    	border : none;
    }
    .table1 td:first-child{
    	text-align: center;
    }
    .table1 td:first-of-type{
    	background : #DADADA;
    }
    .table3{
    	text-align: center;
    }
    .D th{
    	border : 1px black;
        border-style: solid;
        background : #A7C0E9;
    }

    .D .htd{
        
        background: gray;
        width:120px;
    }
    .D .bt{
        text-align: center;

    }
    .D hr {
        color: black;
    }
    .vl{
    	margin-left : 10px;
    }
    .D span{
    	color : red;
    }
    select{
    	width : 100px;
    	height : 22px;
    }
    #bt{
		margin : 20px;
    }
	.table1 td:nth-child(2)  {
		background: rgb(247, 247, 247);

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
          	border:1px solid lightgray;
        	
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
</style>
<meta charset="UTF-8">
<title>중고구마</title>
</head>
<body onload="ready('A/S 요청관리', '커뮤니티', '요청관리');">
	<%@ include file="../common/C_menubar.jsp" %>

	<article class="D">
		<form>
			<table class="table1" style="border : 10px">
				<tr>
					<td class="htd">구분</td>
					<td colspan="1">
						<input class="vl" name="sep" id="sep1" type="radio"><label for="act1">처리</label>
						<input class="vl" name="sep" id="sep2" type="radio"><label for="act2">수리중</label>
						<input class="vl" name="sep" id="sep3" type="radio"><label for="act2">처리완료</label>
					</td>
				</tr>
				<tr>
				<td>날짜 검색</td>
				<td>
					<input type="text" id="datepicker">~<input type="text" id="datepicker1">
					<button onclick="">오늘</button>
					<button onclick="">이번주</button>
					<button onclick="">이번달</button>
					<button onclick="">전체</button>
				</td>
				</tr>
				<tr>
					<td colspan="2" style="border : none; background : white;">
						<input style="background : #6792DA; color : white; width : 70px; height : 25px;
						border:none;"
						type="submit" id="bt" value="검색">
					</td>
				</tr>
			</table>


		</form>
		<table class="table2">
			<td style="border : 1px solid gray; background : #ECECEC;">검색결과 : <span><>건</span> 전체 상품 : <span><>건</span></td>
		</table>

		<table class="table3">
			<tr>
				<th>번호</th>
				<th>접수번호</th>
				<th>아이디</th>
				<th>구분</th>
				<th>접수일</th>
				<th></th>
			</tr>
			<!-- for!!!!!-->
			<tr>
				<td>?</td>
				<td>?</td>
				<td>?</td>
				<td>?</td>
				<td>?</td>
				<%-- <td><button type="button" style="width:23px; height:23px; padding:0;border:none;">
				<img style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px">
				</button></td> --%>
				<td class="resultTableTd"><button id="orderInfo" style="width:23px; height:23px; padding:0;border:none;"><img src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px"></button></td>
			</tr>

		</table>
		<hr>
		<div>
					<input style="background : #6792DA; color : white; width : 70px; height : 25px;
						border:none; float:right;"
						 id="bt" type="button" value="등록하기">
		</div>
			
	
	<!-- The Modal -->
    <div id="myModal" class="modal">
 
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>                                                               
        <div class="modalTop"></div>
        <div class="modalTt"><span>modal연습 </span>상세정보</div>
        <div class="mdTt"><b>모달연습</b></div>
        <table class="infoTb">
        	<colgroup>
        		<col style="background:lightgray">
        		<col>
        		<col style="background:lightgray">
        		<col>
        	</colgroup>
        	<tr>
        		<td>모달연습</td>
        		<td>모달연습</td>
        		<td>모달연습</td>
        		<td>모달연습</td>
        	</tr>
        	<tr>
        		<td>모달연습</td>
        		<td>모달연습</td>
        		<td>모달연습</td>
        		<td>모달연습</td>
        	</tr>
        	<tr>
        		<td>모달연습</td>
        		<td>모달연습</td>
        		<td>모달연습</td>
        		<td>모달연습</td>
        	</tr>
        </table>
        <br><br>
        <div class="mdTt"><b>모달연습</b></div>
        <table class="staTb">
        	<tr>
        		<th>커밋떄문에</th>
        		<th>적은거야</th>
        		<th>지우자</th>
        	</tr>
        </table>
        <div class="modalBtn">
        	<span><button class="cancel">확인</button></span>
        </div>
      </div>
 
    </div>
				
	</article>
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
		

			
			var modal = document.getElementById('myModal');
			var btn = document.getElementById('orderInfo');
			
			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];
			
			btn.onclick = function() {
			    modal.style.display = "block";
			}
			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			    modal.style.display = "none";
			}
		
		</script>

	<%@ include file="../common/C_menubar2.jsp" %>

</body>
</html>