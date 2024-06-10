<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.E{
		font-color : black;
		font-size : 14px;
	}
	.E td{
        border : 1px black;
        border-style: solid;
        font-size : 14px;
        
        
    }
    .E table{
    	align : center;
        background : white;
        
        width : 100%;
        color : black;
        margin-bottom : 30px;
        
        }
    .E table:not(.table1){
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
    .E th{
    	border : 1px black;
        border-style: solid;
        background : #A7C0E9;
    }

    .E .htd{
        
        background: gray;
        width:120px;
    }
    .E .bt{
        text-align: center;

    }
    .E hr {
        color: black;
    }
    .vl{
    	margin-left : 10px;
    }
    .E span{
    	color : red;
    }
   	.E select{
    	width : 100px;
    	height : 22px;
    }
    .E #bt{
		margin : 20px;
    }

	.E .table1 td:nth-child(2)  {
		background: rgb(247, 247, 247);

	}
	.E button{
		width : 70px;
	}
	.tab {
		width: 100%;
		background: white;
	}

	.tab h3 {
		color: black;
		width: 120px;
	}

	.h {
		color: black;
	}

	.tab td {
		font-size: 14px;
		background: white;
	}

	.tab .thd {
		text-align: center;
		background: #E8E8E8;
		
	}

	.thd {
		margin-left: 10px;
		text-align: center;
	}

	.tab td:not(:first-child):not(.thd){
    	border : 1px solid lightgray;
    }
    
	input[type=text] {
		border: none;
	}

	input[type=number] {
		border: none;
	}

	select {
		width: 100px;
		height: 22px;
		
	}

	#file[type="file"] {
		background: #6792DA;
		color: white;
		width: 70px;
		height: 25px;
		border: none;
	}
	#file[type="file"] {
		background: #6792DA;
		color: white;
		width: 70px;
		height: 25px;
		border: none;
	}
	.filebox label {
		display: inline-block;
	 	padding: .3em .95em;
	 	color: white;
		font-size: inherit;
		line-height: normal;
		vertical-align: middle;
		background: #6792DA;
		cursor: pointer;
		border: 1px solid #ebebeb;
 		border-bottom-color: #e2e2e2;
		border-radius: 5px 5px 5px 5px;
	}
	.filebox input[type="file"] {  /* 파일 필드 숨기기 */
		position: absolute;
		width: 1px;
		height: 1px;
		padding: 0;
		margin: -1px;
		overflow: hidden;
		clip:rect(0,0,0,0);
		border: 0;
	}
	.bt {
		text-align: center;
	}
	
	#bt2 {
		background: #6792DA;
		color: white;
		width: 70px;
		height: 25px;
		border: none;
	}
	
	.vl {
	margin:10px;
	width: 300px;
	height:30px;
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
        	text-align: center;
        }
        
        .staTb tr:first-of-type {
        	background:#A7C0E9;
        }
        
        .staTb tr td {
        	border:1px solid black;
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
        
        .modalTt {
        	font-size:30px;
        	border-bottom:1px solid black;
        	width:95%;
        	margin:0 auto;
        	margin-top:10px;
        	font-weight:bold;
        }
        .htd2 {
		text-align: center;
		background: #E8E8E8;
		
	}
	.vl2{
    	margin-left : 10px;
    }
    
</style>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>중고구마</title>
</head>
<body onload="ready('A/S 접수 처리', 'A/S 요청 관리', 'A/S 접수 처리');">
<%@ include file="../common/C_menubar.jsp"%>
	<article>
		<div>
			<form action="" method="get">
				<table class="tab">
					<tr>
						<td class="h" colspan="2"><p><b style="font-size: 16.38px; font-weight: 550;">A/S 접수 처리</b></p></td>
					</tr>
					
					
					<tr>
						<td class="thd">고객명</td>
						<td class="resultTableTd">
							<!-- <button id="orderInfo" style="width:23px; height:23px; padding:0;border:none; background-color:white;"></button> -->
							<img id="orderInfo" src="<%=request.getContextPath()%>/image/adminImg/magnifyingGlass.png" width="25px" style="vertical-align:middle;">
							<input class="vl" type="text">
						</td>
						<td class="thd">고객 번호</td>
						<td><input class="vl" type="text"></td>
					</tr>
					<tr>
						<td class="thd">아이디</td>
						<td><input class="vl" type="text"></td>
						<td class="thd">연락처</td>
						<td><input class="vl" type="text"></td>
					</tr>
					<tr>
						<td class="h" colspan="2"><p><b style="font-size: 16.38px; font-weight: 550;">A/S 요청 상품 입력</b></p></td>
					</tr>
				
					<tr>
						<td class="thd">상품 번호</td>
						<td><input class="vl" type="text"></td>
						<td class="thd">렌탈 일자</td>
						<td><input class="vl" type="text"></td>
					</tr>
					<tr>
						<td class="thd">상품명</td>
						<td><input class="vl" type="text"></td>
						<td class="thd">상품 일자</td>
						<td><input class="vl" type="text"></td>
					</tr>

					<tr>
						<td class="h" colspan="2"><p><b style="font-size: 16.38px; font-weight: 550;">A/S 필수사항</b></p></td>
					</tr>
					<tr>
						<td class="thd" id="content">내용</td>
						<td colspan="3"><textarea cols="132" rows="15"
								style="resize: none; border:none;"></textarea></td>
					</tr>
					<tr>
						<td class="h" colspan="2"><p><b style="font-size: 16.38px; font-weight: 550;">A/S 배송 정보</b></p></td>
					</tr>
					<tr>
						<td class="thd">상품 번호</td>
						<td><input class="vl" type="text"></td>
						<td class="thd">렌탈 일자</td>
						<td><input class="vl" type="text"></td>
					</tr>
					<tr>
						<td class="h" colspan="3"><p><b style="font-size: 16.38px; font-weight: 550;">고객 상담사 정보</b></p></td>
					</tr>
					<tr>
						<td class="thd">상품명</td>
						<td><input class="vl" type="text"></td>
						<td class="thd">상품 일자</td>
						<td><input class="vl" type="text"></td>
					</tr>
					<tr>
						<td class="bt" colspan="4">
						<br><br><br><br>
						<input type="submit" id="bt2" value="등록"> &nbsp;
						<input type="reset" id="bt2" value="취소"> &nbsp;
                    	</td>
					</tr>
					</table>
				</form>
			</div>
	<!-- The Modal -->
    <div id="myModal" class="modal">
 
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>                                                               
        <div class="modalTop"></div>
        <div class="modalTt">회원 조회</div>
        <table class="infoTb">
        	<colgroup>
        		<col style="background:lightgray">
        		<col>
        		<col style="background:lightgray">
        		<col>
        	</colgroup>
        		<br>
        		<tr>
					<td class="htd2">검색어</td>
					<td><select class="vl2">
							<option class="vl2">전체</option>
						</select>
					<input class="vl2" type="text"></td>
				</tr>
        </table>
        <br><br>
        <table class="staTb">
        	<tr>
        		<th><input type="checkbox"></th>
				<th>번호</th>
				<th>아이디</th>
				<th>고객이름</th>
				<th>고객번호</th>
				<th>전화번호</th>
				<th></th>
        	</tr>
			<!-- for!!!!!-->
			<tr>
				<td><input type="checkbox"></td>
				<td>?</td>
				<td>?</td>
				<td>?</td>
				<td>?</td>
				<td>?</td>
				<td class="resultTableTd"><button id="orderInfo" style="width:23px; height:23px; padding:0;border:none;"><img src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px"></button></td>
				<%-- <td><button type="button" style="width:23px; height:23px; padding:0;border:none;">
				<img style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px">
				</button></td> --%>
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

<%@ include file="../common/C_menubar2.jsp"%>
</body>
</html>