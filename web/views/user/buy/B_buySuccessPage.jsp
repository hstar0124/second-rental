<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	/*-----매입신청성공페이지--------*/
	
	#section{
	    width: 900px;
	    height: 1100px;
	    margin: 0 auto;  
	   
	    
	}

	
	
	
	/*에러페이지 영역*/
	.success{   
	    
	    text-align: center;
	}
	.success-img{
	    width: 400px;
	    height: 400px;
	    margin-top: 150px;
	}
	.success>p{
	    font-size: 30px;
	    font-weight: bold;
	}
	.success>label{
		font-size: 17px;
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
	    cursor: pointer;
	   
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


		<!-- 에러페이지 -->
		<div class="success">
			<input type="image" class="success-img" src="/forest/image/userimg/successimg.png">
			<p>매입 신청이 완료되었습니다.<br>
				검수 완료후 포인트가 지급됩니다.</p>
			<label>검수는 1~3일 정도 소요됩니다.</label>

		</div>


		<!-- 이전버튼 -->
		<div class="buyselect-button">
			<button onclick="goHome();">확인</button>

		</div>


	</section>
	<!-- 세션끝 -->

	<script>
		function goHome(){
			location.href = "<%=request.getContextPath()%>/mypageBuylist.buy";
		}
	</script>
	<%@ include file="/views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>