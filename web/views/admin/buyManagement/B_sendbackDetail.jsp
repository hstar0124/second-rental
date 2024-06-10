<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
body{
	margin: 0px;
}
.top-title {
	background: #16AAD8;
	height: 50px;
	width: 100%;
}

.top-title> p {
	color: white;
	margin: 0px;
	padding-top: 15px;
	font-size: 17px;
}

/*표 부분*/
.table-area{
	width: 700px;
	margin: 0 auto;
	height: 300px;
}

.table-area tr>th:nth-of-type(1){
	width: 50px;
}
.table-area tr>td:nth-of-type(1){
	width: 50px;
	background: #DADADA;
}
.table-area tr>th:nth-last-of-type(1){
	width: 250px;
}
.table-area tr>td:nth-last-of-type(1){
	width: 250px;
}
.table-area>table{
	width: 700px;
	text-align: center;
	margin-top: 10px;
	border-collapse:collapse;
}
.table-area tr>td{
	border-bottom: 1px solid #828282;
}
.table-area tr>th{
	background: #DADADA;
	border-bottom: 2px solid #828282;
}

/*총 갯수 영역*/
.total-area{
	width: 700px;
	border-top: 1px solid black;
	text-align: right;
}
.total-area>p{
	margin-right: 20px;
}

/*버튼 영역*/
.btn-area{
	height: 50px;
	text-align: center;
}
.btn-area>button{
	background: #6792DA;
	border-radius: 3px;
	border: none;
	height: 30px;
	color: white;
	width: 100px;
	margin-top: 10px;
}
.btn-area>button:nth-of-type(1){
	margin-right: 10px;
}
.btn-area>button:nth-last-of-type(1){
	margin-left: 10px;
}
</style>
</head>
<body>
	<div class="top-title">
     	<p style="padding-left:20px;">반송 신청하기</p>
   	</div>

	<div class="table-area">
		<table>
			<thead>
				<tr>
					<th>매입번호</th>
					<th>아이디</th>
					<th>고객명</th>
					<th>상품명</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>001</td>
					<td>내용</td>
					<td>내용</td>
					<td>내용</td>
					<td>내용</td>
				</tr>
				<tr>
					<td>001</td>
					<td>내용</td>
					<td>내용</td>
					<td>내용</td>
					<td>내용</td>
				</tr>
			</tbody>
		</table>
	</div>
		<div class="total-area">
			<p>총 갯수 ~~ 개</p>
		</div>

	
		<div class="btn-area">
			<button id="closeBtn">취소</button>
			<button id="okBtn">확인</button>
		</div>
		
		<script>
			$(function(){
				$("#closeBtn").click(function(){
					window.close();
				});
				$("#okBtn").click(function(){
					alert("반송 신청이 완료 되었습니다.");
						window.close();
				
				});
			});
		</script>
</body>
</html>