<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	/*-----매입거절페이지--------*/
	
	#section{
	    width: 900px;
	    height: 1100px;
	    margin: 0 auto;  
	   
	    
	}
	
	/*상단 진행바*/
	.status-table{
	    width: 600px;
	    margin: 0 auto;
	    margin-top: 90px;    
	    text-align: center;
	    font-size: 17px;
	}
	.status-table td:nth-of-type(5){
	    border-bottom: 6px solid #6E00AB;
	    /*선택안되었을때 회색*/
	    /* border-bottom: 7px solid #DADADA; */    
	    width: 100px;
	}
	.status-table td:nth-of-type(1){
	     border-bottom: 7px solid #DADADA;   
	    width: 100px;
	}
	.status-table td:nth-of-type(7){
	     border-bottom: 7px solid #DADADA;   
	    width: 100px;
	}
	.status-table td:nth-of-type(3){
	     border-bottom: 7px solid #DADADA;   
	    width: 100px; 
	    
	}
	.status-table td:nth-of-type(2n){
	    width: 20px;
	}
	
	
	
	
	
	/*에러페이지 영역*/
	.reject{   
	    
	    text-align: center;
	}
	.reject-img{
	    width: 400px;
	    height: 400px;
	    margin-top: 150px;
	}
	.reject>p{
	    font-size: 30px;
	    font-weight: bold;
	}
	
	
	/*이전, 다음 버튼영역*/
	.buyselect-button{
	    width: 100%;
	    text-align: center;
	    margin-top: 100px;
	}
	.buyselect-button>button{
	    width: 130px;
	    height: 50px;
	    background: #6E00AB;
	    color: white;
	    border: none;
	   
	}
	.buyselect-button>button:nth-of-type(2){
	    margin-left: 50px;
	}

</style>
</head>
<body>
	<%@ include file="/views/user/common/B_UserMainHeader.jsp" %>

	<!-- 세션시작 -->
	<section id="section">
		<!-- 상단 진행바 -->
		<div class="buyselect-status">
			<table class="status-table">
				<tr>
					<td>카테고리선택</td>
					<td>></td>
					<td>상품명 입력</td>
					<td>></td>
					<td>체크리스트</td>
					<td>></td>
					<td>사진등록</td>
				</tr>
			</table>
		</div>

		<!-- 에러페이지 -->
		<div class="reject">
			<input type="image" class="reject-img" src="/forest/image/userimg/define.png">
			<p>해당 상품은 매입할 수 없습니다.</p>

		</div>


		<!-- 이전버튼 -->
		<div class="buyselect-button">
			<button onclick="history.go(-1);">이전</button>

		</div>


	</section>
	<!-- 세션끝 -->

	<%@ include file="/views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>