<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap"%>
<%
	HashMap<String, String> exampleMap  = (HashMap<String, String>) request.getAttribute("exampleMap");
	String safeKey = (String) request.getAttribute("safeKey");
	String grade = (String) request.getAttribute("grade");
%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>

	/*-----매입사진등록--------*/
	#section{
	    width: 1000px;
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
	.status-table td:nth-of-type(7){
	    border-bottom: 6px solid #6E00AB;
	    /*선택안되었을때 회색*/
	    /* border-bottom: 7px solid #DADADA; */    
	    width: 100px;
	}
	.status-table td:nth-of-type(1){
	     border-bottom: 7px solid #DADADA;   
	    width: 100px;
	}
	.status-table td:nth-of-type(5){
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
	
	/*사진등록*/
	
	.buy-photo{
	    display: flex;
	    margin: 0 auto;
	    
	    
	
	}
	.photo-div{
	    margin: 0 auto;
	    
	}
	.icon-img{
	    width: 70px;
	    height: 60px;
	    margin-top: 80px;
	}
	.photo-div{
	    margin-top: 100px;    
	
	}
	
	.div2, .div3, .div4, .div5{
	    margin-left: 30px;
	}
	.photo-div>div{
	    width: 200px;
	    height: 200px;
	    background-image: url('/forest/image/userimg/backimg.png');     
	    text-align: center;
	    margin-bottom: 30px; 
	    
	}
	.photo-div>button{
	    width: 200px;
	    height: 50px;
	    background:  #6E00AB;;
	    color: white;
	    border: none;
	    
	    
	}
	.photo-div>p{
	    text-align: center;
	    font-size: 17px;
	    color: #828282;
	}
	
	#insertBtn1, #insertBtn2, #insertBtn3, #insertBtn4, #insertBtn5{
		cursor: pointer;
		width: 200px;
	    height: 50px;
	    background:  #6E00AB;;
	    color: white;
	    border: none;
	    text-align: center;
	    font-size: 17px;
	    line-height: 50px;
	}
	
	/*세이프키*/
	.safykey-area{
	   text-align: center;
	   margin-top: 100px;
	}
	.safykey-area>p{
	    color: red;
	    font-size: 23px;
	    font-weight: bold;
	}
	.safykey-area>label{
	    font-size: 20px;
	    font-weight: bold;
	}
	.safykey-area>input{
	    text-align: center;
	}
	
	#safeKey{
		font-size: 20px;
	}
	
	
	/*이전, 다음 버튼영역*/
	.buyselect-button{
	    width: 100%;
	    text-align: center;
	    margin-top: 150px;
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
	<%@ include file="/views/user/common/B_UserMainHeader.jsp"%>

	<!-- 세션시작 -->

	
	<section id="section">
		<form  id="formArea" action="<%=request.getContextPath()%>/insertPhoto.ca?safeKey=<%=safeKey %> + &grade=<%=grade %>" method="post" encType="multipart/form-data">
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

		<!-- 사진등록 -->
		<div class="buy-photo">
			<div class="photo-div div1">
				<p>전면사진</p>
				<div>
					<img id="contentImg1" width="200" height="200">
				</div>
				<div id="insertBtn1">사진첨부</div>
			</div>

			<div class="photo-div div2">
				<p>바닥사진</p>
				<div>
					<img id="contentImg2" width="200" height="200">
				</div>
				<div id="insertBtn2">사진첨부</div>
			</div>

			<div class="photo-div div3">
				<p>좌측사진</p>
				<div>
					<img id="contentImg3" width="200" height="200">
				</div>
				<div id="insertBtn3">사진첨부</div>
			</div>

			<div class="photo-div div4">
				<p>우측사진</p>
				<div>
					<img id="contentImg4" width="200" height="200">
				</div>
				<div id="insertBtn4">사진첨부</div>
			</div>

			<div class="photo-div div5">
				<p>전체사진</p>
				<div>
					<img id="contentImg5" width="200" height="200">
				</div>
				<div id="insertBtn5">사진첨부</div>
			</div>

		</div>

		<div class="safykey-area">
			<p>[중요] 모든 사진에 세이프키와 함께 찍어주세요.</p>
			<label>세이프키는 </label><input type="text" id="safeKey" value=<%=safeKey%> readonly><label> 입니다.</label>
		</div>

		<!-- 사진등록 -->
		<div id="fileArea">
            <input type="file" id="photoImg1" name="photoImg1" onchange="loadImg(this, 1);">
            <input type="file" id="photoImg2" name="photoImg2" onchange="loadImg(this, 2);">
            <input type="file" id="photoImg3" name="photoImg3" onchange="loadImg(this, 3);">
            <input type="file" id="photoImg4" name="photoImg4" onchange="loadImg(this, 4);">
            <input type="file" id="photoImg5" name="photoImg5" onchange="loadImg(this, 5);">
         </div>



		<div class="buyselect-button">
			<button onclick="history.go(-1);">이전</button>
			<button onclick="return nextBtn();" type="submit">다음</button>
		</div>
		</form>

	</section>
	<!-- 세션끝 -->

	<script>
		
		$(function(){
			
			$("#fileArea").hide(); 
			
			$("#insertBtn1").click(function(){
				$("#photoImg1").click();
			});
			$("#insertBtn2").click(function(){
				$("#photoImg2").click();
			});
			$("#insertBtn3").click(function(){
				$("#photoImg3").click();
			});
			$("#insertBtn4").click(function(){
				$("#photoImg4").click();
			});
			$("#insertBtn5").click(function(){
				$("#photoImg5").click();
			});
			
			
			
		});
		
		function loadImg(value, num){
	    	  if(value.files && value.files[0]) {
	    		  var reader = new FileReader();
	    		  
	    		  reader.onload = function(e) { 
	    			  switch(num){
		    			  case 1 : $("#contentImg1").attr("src", e.target.result); break;
		    			  case 2 : $("#contentImg2").attr("src", e.target.result); break;
		    			  case 3 : $("#contentImg3").attr("src", e.target.result); break;
		    			  case 4 : $("#contentImg4").attr("src", e.target.result); break;
		    			  case 5 : $("#contentImg5").attr("src", e.target.result); break;
	    					  
	    			  }
	    			  
	    		  }
	    		  reader.readAsDataURL(value.files[0]);
	    		  
	    		  
	    	  }
	    	  
	      }
		
		function nextBtn() {
			var img1 = $("#contentImg1").attr("src");
			var img2 = $("#contentImg2").attr("src");
			var img3 = $("#contentImg3").attr("src");
			var img4 = $("#contentImg4").attr("src");
			var img5 = $("#contentImg5").attr("src");
			
			if(img1 == null || img2 == null || img3 == null || img4 == null || img5 == null){
				alert("사진을 5개 모두 등록해주세요.");
				return false;
			} else {
				return true;
			}
		}


	</script>

	<%@ include file="/views/user/common/B_UserMainFooter.jsp"%>
</body>
</html>