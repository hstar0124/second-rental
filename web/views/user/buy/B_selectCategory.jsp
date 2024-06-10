<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	/*--------매입분류선택---------*/
	
	#section{
	    width: 900px;
	    height: 800px;
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
	
	.status-table td:nth-of-type(2n-1){
	    /*border-bottom: 6px solid #6E00AB;*/
	    /*선택안되었을때 회색*/
	    border-bottom: 6px solid #DADADA; 
	    width: 100px;
	}
	.status-table td:nth-of-type(1){
	 	border-bottom: 6px solid #6E00AB;
	 	 width: 100px;
	}
	.status-table td:nth-of-type(2n){
	    width: 20px;
	}
	
	/*분류선택*/
	.icon-table{
	    width: 900px;
	    margin: 0 auto;
	    margin-top: 150px;  
	    text-align: center;
	}
	.icon-img{
	    width: 150px;
	    height: 150px;
	}
	#icon1, #icon2, #icon3, #icon4, #icon5{
	    opacity: 0.3;
	}
	.icon-table td>label{
	    font-size: 15px;
	    
	}
	
	/*---카테고리선택시 보이는 css*/
	
	/* .icon-table td{
	    border: 2px solid #6E00AB;;
	} */
	
	
	/*-----카테고리선택시 분류선택영역-----*/
	.select-category{
	    border: 1px solid #BABABA;
	    width: 600px;
	    height: 120px;
	    text-align: center;
	    margin: 0 auto;
	    margin-top: 100px;
	  
	}
	.select-category>p{
	    font-size: 17px;
	    margin-bottom: 40px;
	    
	}
	.category-sort:nth-of-type(1){
	   width: 200px;
	   height: 30px;
	}
	.category-sort:nth-of-type(2){
		width: 200px;
	    margin-left: 40px;
	    height: 30px;
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
	    background: #6E00AB;
	    /* background: #BABABA; */
	}

</style>
</head>
<body>
	<%@ include file="/views/user/common/B_UserMainHeader.jsp" %>
	<!-- 세션시작 -->
	<section id="section">
		<div class="buyselect-status">
			<table class="status-table">
				<tr>
					<td id="td1">카테고리선택</td>
					<td>></td>
					<td id="td2">상품명 입력</td>
					<td>></td>
					<td id="td3">체크리스트</td>
					<td>></td>
					<td id="td4">사진등록</td>
				</tr>
			</table>
		</div>
		
		<div class="buyselect-icon">
			<table class="icon-table">
				<tr>
					<td><input type="image" class="icon-img" id="icon1" value="21" src="/forest/image/userimg/bbimg1.png"><br>
						</td>
					<td><input type="image" class="icon-img" id="icon2" value="23" src="/forest/image/userimg/bbimg2.png"><br>
						</td>
					<td><input type="image" class="icon-img" id="icon3" value="22" src="/forest/image/userimg/bbimg3.png"><br>
						</td>
					<td><input type="image" class="icon-img" id="icon4" value="11" src="/forest/image/userimg/bbimg4.png"><br>
						</td>
					<td><input type="image" class="icon-img" id="icon5" value="12" src="/forest/image/userimg/bbimg5.png"><br>
						</td>
				</tr>
			</table>

		</div>
		
		
		 <!-- 상위 카테고리 선택 시 1차 2차분류 보이게하기-->
            <div id="select-category" class="select-category">
                <p>판매하실 물건의 상품명을 선택해주세요.</p>
                <select class="category-sort" id="sort1">
                    <option selected>제조사</option> 
                </select>
                
                <select class="category-sort" id="sort2">
                    <option selected>모델명</option>
                </select>
            </div>



		<div class="buyselect-button">
			<button onclick="history.go(-1);">이전</button>
			<button type="submit" id="nextBtn">다음</button>
		</div>
	</section>
	<!-- 세션끝 -->
	<script>
		$(function(){

			$("#select-category").hide();
			
			//버튼활성화 변수
			var cate1 = 0;
			var cate2 = 0;
			var cate3 = 0;
			
			//첫번째 아이콘 클릭시
			$("#icon1").click(function(){
				$(this).css({"opacity": "1","outline": "0"});
				$("#icon2").css({"opacity":"0.3"});
				$("#icon3").css({"opacity":"0.3"});
				$("#icon4").css({"opacity":"0.3"});
				$("#icon5").css({"opacity":"0.3"});
				//분류창 나오게하기
				$("#select-category").show();
				
				//상단바 변경
				$("#td1").css({"border-bottom":"6px solid #DADADA"});
				$("#td2").css({"border-bottom":"6px solid #6E00AB"});
				
				//버튼값 변경
				cate1 = 1;
				console.log(cate1);
			});
			$("#icon2").click(function(){
				$(this).css({"opacity": "1", "outline": "0"});
				$("#icon1").css({"opacity":"0.3"});
				$("#icon3").css({"opacity":"0.3"});
				$("#icon4").css({"opacity":"0.3"});
				$("#icon5").css({"opacity":"0.3"});
				//분류창 나오게하기
				$("#select-category").show();
				//상단바 변경
				$("#td1").css({"border-bottom":"6px solid #DADADA"});
				$("#td2").css({"border-bottom":"6px solid #6E00AB"});
				//버튼값 변경
				cate1 = 1;
			});
			$("#icon3").click(function(){
				$(this).css({"opacity": "1", "outline": "0"});
				$("#icon1").css({"opacity":"0.3"});
				$("#icon2").css({"opacity":"0.3"});
				$("#icon4").css({"opacity":"0.3"});
				$("#icon5").css({"opacity":"0.3"});
				$("#select-category").show();
				//상단바 변경
				$("#td1").css({"border-bottom":"6px solid #DADADA"});
				$("#td2").css({"border-bottom":"6px solid #6E00AB"});
				//버튼값 변경
				cate1 = 1;
				
			});
			$("#icon4").click(function(){
				$(this).css({"opacity": "1", "outline": "0"});
				$("#icon1").css({"opacity":"0.3"});
				$("#icon2").css({"opacity":"0.3"});
				$("#icon3").css({"opacity":"0.3"});
				$("#icon5").css({"opacity":"0.3"});
				$("#select-category").show();
				//상단바 변경
				$("#td1").css({"border-bottom":"6px solid #DADADA"});
				$("#td2").css({"border-bottom":"6px solid #6E00AB"});
				//버튼값 변경
				cate1 = 1;
			});
			$("#icon5").click(function(){
				$(this).css({"opacity": "1", "outline": "0"});
				$("#icon1").css({"opacity":"0.3"});
				$("#icon2").css({"opacity":"0.3"});
				$("#icon3").css({"opacity":"0.3"});
				$("#icon4").css({"opacity":"0.3"});
				$("#select-category").show();
				//상단바 변경
				$("#td1").css({"border-bottom":"6px solid #DADADA"});
				$("#td2").css({"border-bottom":"6px solid #6E00AB"});
				//버튼값 변경
				cate1 = 1;
			});
			
			/* $("#select-category").hide(); */
			
			var categoryNo = "";
			var manufacturerNo = "";
			var buyProductNo = "";
			
			//생활가전 클릭시 2차분류(제조사)
			$("#icon1").click(function(){
				categoryNo = $("#icon1").val();
				
				$.ajax({
					url:"/forest/select.ca",
					type: "post",
					data: {categoryNo : categoryNo},
					success: function(data){
						
						
						
						$select = $("#sort1");
						$select.find("option").remove();
						
						for(var key in data){
							
							var name = decodeURIComponent(data[key].manufacturerName);
							var $option = $("<option>");
							$option.val(data[key].manufacturerNo);
							$option.text(name);
							$select.append($option);
							
							
						}
						
						
						//제조사 선택시 3차분류(상품명)
						$("#sort1").on('change', function(){
							manufacturerNo = $(this).find(":selected").val();
							cate2 = 1;
							console.log("cate2 : " + cate2);
							
								
								$.ajax({
								url: "/forest/subSelect.ca",
								type: "post",
								data: {
									categoryNo : categoryNo,
									manufacturerNo : manufacturerNo
									},
								success: function(data){
									console.log("subdata:" + data);
									
									$select = $("#sort2");
									$select.find("option").remove();
									
									for(var key in data){
										
										var modelName = 
												decodeURIComponent(decodeURI(data[key].buyProductName).replace(/\+/g, " "));
										console.log(modelName);
										var $option = $("<option>");
										$option.val(data[key].buyProductNo);
										$option.text(modelName);
										$select.append($option);
										
										
										
									}
									
									buyProductNo = $("#sort2").find(":selected").val();
									console.log("buyProductNo:" + buyProductNo)
									cate3 = 1;	
									console.log("cate3: " + cate3);
									
									
									
								},
								error: function(error){
									console.log(error);
								}
							});
						});
						
						
					},
					error: function(error){
						console.log(error);
					}
					
				});
				
			});
			
			
			//미용가전 클릭시
			$("#icon2").click(function(){
				 categoryNo = $("#icon2").val();
				 
				 $.ajax({
					url: "/forest/select.ca",
					type: "post",
					data: {categoryNo : categoryNo},
					success: function(data){
						
						$select = $("#sort1");
						$select.find("option").remove();
						
						for(var key in data){
							
							var name = decodeURIComponent(data[key].manufacturerName);
							var $option = $("<option>");
							$option.val(data[key].manufacturerNo);
							$option.text(name);
							$select.append($option);
						}
						
						//제조사 선택시 3차분류(상품명)
						$("#sort1").on('change', function(){
							manufacturerNo = $(this).find(":selected").val();
							cate2 = 1;	
								$.ajax({
								url: "/forest/subSelect.ca",
								type: "post",
								data: {
									categoryNo : categoryNo,
									manufacturerNo : manufacturerNo
									},
								success: function(data){
									console.log("subdata:" + data);
									
									$select = $("#sort2");
									$select.find("option").remove();
									
									for(var key in data){
										
										var modelName = 
												decodeURIComponent(decodeURI(data[key].buyProductName).replace(/\+/g, " "));
										console.log(modelName);
										var $option = $("<option>");
										$option.val(data[key].buyProductNo);
										$option.text(modelName);
										$select.append($option);
										
									}
									buyProductNo = $("#sort2").find(":selected").val();
									cate3 = 1;	
								},
								error: function(error){
									console.log(error);
								}
							});
						});
					},
					
					error: function(error){
						console.log(date);
					}
				 });
			});
			
			//주방가전 클릭시
			$("#icon3").click(function(){
				 categoryNo = $("#icon3").val();
				 
				$.ajax({
					url: "/forest/select.ca",
					type: "post",
					data: {categoryNo : categoryNo},
					success: function(data){
						
						$select = $("#sort1");
						$select.find("option").remove();
						
						for(var key in data){
							
							var name = decodeURIComponent(data[key].manufacturerName);
							var $option = $("<option>");
							$option.val(data[key].manufacturerNo);
							$option.text(name);
							$select.append($option);
						}
						
						//제조사 선택시 3차분류(상품명)
						$("#sort1").on('change', function(){
							manufacturerNo = $(this).find(":selected").val();
							cate2 = 1;	
								$.ajax({
								url: "/forest/subSelect.ca",
								type: "post",
								data: {
									categoryNo : categoryNo,
									manufacturerNo : manufacturerNo
									},
								success: function(data){
									console.log("subdata:" + data);
									
									$select = $("#sort2");
									$select.find("option").remove();
									
									for(var key in data){
										
										var modelName = 
												decodeURIComponent(decodeURI(data[key].buyProductName).replace(/\+/g, " "));
										console.log(modelName);
										var $option = $("<option>");
										$option.val(data[key].buyProductNo);
										$option.text(modelName);
										$select.append($option);
										
									}
									buyProductNo = $("#sort2").find(":selected").val();
									cate3 = 1;	
								},
								error: function(error){
									console.log(error);
								}
							});
						});
						
					},
					error: function(error){
						console.log(error);
					}
				});
			});
			
			//노트북 클릭시
			$("#icon4").click(function(){
				 categoryNo = $("#icon4").val();
				 
				$.ajax({
					url: "/forest/select.ca",
					type: "post",
					data: {categoryNo : categoryNo},
					success: function(data){
						
						$select = $("#sort1");
						$select.find("option").remove();
						
						for(var key in data){
							
							var name = decodeURIComponent(data[key].manufacturerName);
							var $option = $("<option>");
							$option.val(data[key].manufacturerNo);
							$option.text(name);
							$select.append($option);
						}
						
						//제조사 선택시 3차분류(상품명)
						$("#sort1").on('change', function(){
							manufacturerNo = $(this).find(":selected").val();
							cate2 = 1;	
								$.ajax({
								url: "/forest/subSelect.ca",
								type: "post",
								data: {
									categoryNo : categoryNo,
									manufacturerNo : manufacturerNo
									},
								success: function(data){
									console.log("subdata:" + data);
									
									$select = $("#sort2");
									$select.find("option").remove();
									
									for(var key in data){
										
										var modelName = 
												decodeURIComponent(decodeURI(data[key].buyProductName).replace(/\+/g, " "));
										console.log(modelName);
										var $option = $("<option>");
										$option.val(data[key].buyProductNo);
										$option.text(modelName);
										$select.append($option);
										
									}
								buyProductNo = $("#sort2").find(":selected").val();
								cate3 = 1;	
								},
								error: function(error){
									console.log(error);
								}
							});
						});
						
					},
					error: function(error){
						console.log(error);
					}
				});
			});
			
			//태블릿pc 클릭시
			$("#icon5").click(function(){
				 categoryNo = $("#icon5").val();
				 
				$.ajax({
					url: "/forest/select.ca",
					type: "post",
					data: {categoryNo : categoryNo},
					success: function(data){
						
						$select = $("#sort1");
						$select.find("option").remove();
						
						for(var key in data){
							
							var name = decodeURIComponent(data[key].manufacturerName);
							var $option = $("<option>");
							$option.val(data[key].manufacturerNo);
							$option.text(name);
							$select.append($option);
						}
						
						//제조사 선택시 3차분류(상품명)
						$("#sort1").on('change', function(){
							manufacturerNo = $(this).find(":selected").val();
							cate2 = 1;	
							
								$.ajax({
								url: "/forest/subSelect.ca",
								type: "post",
								data: {
									categoryNo : categoryNo,
									manufacturerNo : manufacturerNo
									},
								success: function(data){
									console.log("subdata:" + data);
									
									$select = $("#sort2");
									$select.find("option").remove();
									
									for(var key in data){
										
										var modelName = 
												decodeURIComponent(decodeURI(data[key].buyProductName).replace(/\+/g, " "));
										console.log(modelName);
										var $option = $("<option>");
										$option.val(data[key].buyProductNo);
										$option.text(modelName);
										$select.append($option);
										
									}
									buyProductNo = $("#sort2").find(":selected").val();
									cate3 = 1;	
								},
								error: function(error){
									console.log(error);
								}
							});
								
						});
						
					},
					error: function(error){
						console.log(error);
					}
				});
			});
			
			

		
		$("#nextBtn").click(function(){
			
			location.href = "<%=request.getContextPath()%>/select.ck?categoryNo=" + categoryNo + 
					"&manufacturerNo="+ manufacturerNo +"&buyProductNo="+ buyProductNo;
		});
		
		
		});
	</script>
	
	
			
			




	<%@ include file="/views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>