<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	#basketSection{
		width:100%;		
		table-layout:fixed; 
	}
	
	.textCenter{
		text-align: center;
	}
	.divMargin{
		margin:0 auto;
	}
	#delete{
		border-radius: 10px;
	}
	.tdMargin{
		margin-top:5px;
	}
	#payment{
		width: 100px;
		height: 40px;
		line-height: 40px;
		color:white;
		font-size: 15px;
		font-weight: 800;
		text-align: center;
		background: #6E00AB;
	}
	#myBasket{
		background:#6E00AB;
		color: white;
	}
	#myBasketText{
		color: white;
	}
	
</style>

</head>
<body>

<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>

	<table id="basketSection">
	<colgroup>
		<col style="width:5%;">
		<col style="width:15%;">
		<col style="width:30%;">
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:20%;">
	</colgroup>
		<tr class='tdMargin'>
			<td colspan="6"><h1>장바구니</h1></td>
		</tr>
		<tr class='tdMargin'>
			<td colspan="6"><div style="background-color:purple; width:100%; height:4px;"></div></td>
		</tr>
		
		<tr style="height:40px;"></tr>
		<tr class='tdMargin'>
			<td colspan="6"><div style="background-color:black; width:100%; height:4px;"></div></td>
		</tr>
		<tr class='tdMargin'>
			<td style='text-align: center;'></td>
			<td><h5 class="textCenter">구매상품</h5></td>
			<td><h5 class="textCenter">상품명</h5></td>
			<td><h5 class="textCenter">수량</h5></td>
			<td><h5 class="textCenter">가격</h5></td>
			<td><h5 class="textCenter">삭제</h5></td>
		</tr>
		<tr class='tdMargin'>
			<!-- <td><input type="checkbox" name="basketCheck" value="2"></td>
			<td><div class="divMargin" style="background-color:lightgray; width:100px; height:100px;"
				onclick="location.href='/forest/views/user/product/A_ProductDetailIndex.jsp'"></div></td>
			<td><h5 class="textCenter">맥북 프로 13.3인치 터치바</h5></td>
			<td><h5 class="textCenter">1</h5></td>
			<td><h5 class="textCenter">(1개월) 68,500원</h5></td>
			<td><div id="delete" class="divMargin" style="background-color:purple; width:20%;"><h5 class="textCenter" style="color:white;">ㅡ</h5></div></td> -->
		</tr>
	</table>
	
	<table style="width:100%; margin-top:100px;">
		<colgroup>
		<col style="width:20%;">
		<col style="width:20%;">
		<col style="width:30%;">
		<col style="width:30%;">
		</colgroup>
		<tr>
			<td colspan="3" style="text-align:right; font-size:30px; font-weigth:800;"> 총 결제 금액 : </td>
			<td id="howMuch" style="text-align:center; font-size:30px; font-weigth:800;"> 0 원</td>			
		</tr>
		<tr><td colspan="4" style="height:2px; background:black;"></td></tr>
		<tr><td colspan="4" style="text-align:right;"><button id="payment" onclick="payment();">결제하기</button></td></tr>
	</table>
	
	<script>
		$(function(){
			
			<% if(loginMember != null){%>
				var userNo = "<%= loginMember.getUserNo() %>";
				
				var $basketSection = $("#basketSection tbody");
				
				$.ajax({				
					url: "<%=request.getContextPath()%>/selectBasket",
					type: "get",
					data: { userNo : userNo },
					success: function(data){
						//console.log(data);
						
						var $howMuch = $("#howMuch"); 
						var sum = 0;
						for(var i in data){
							var basket = data[i];
							/* console.log(basket.rentalNo);
							console.log(basket.productNo);
							console.log(decodeURIComponent(basket.productName).replace(/\+/g, " "));
							console.log(basket.userNo);
							console.log(basket.month);
							console.log(basket.rentalPrice);
							console.log(basket.takeOver);
							console.log(basket.cngName); */
							
							var $myBasket = "<tr class='tdMargin'><td style='text-align: center;'><input type='checkbox' name='basketCheck' onchange='rentalPriceFunction(this);' class='bascketCheck' rentalPrice='" + parseInt(basket.rentalPrice.replace(",", "")) + "' value='" + basket.rentalNo + "'></td>"
										  + "<td onclick='moveDetail(this);'><div class='divMargin' style='background-color:lightgray; width:100px; height:100px;'>"
										  + "<img id='basketImg' style='width:100px; height:100px;' src=" + '<%=request.getContextPath()%>/image/productImg/'+ basket.cngName + ">"
										  + "</div><span style='display:none'>" + basket.productNo + "</span></td>"
										  + "<td onclick='moveDetail(this);'><h5 class='textCenter'>" + decodeURIComponent(basket.productName).replace(/\+/g, " ") + "</h5><span style='display:none'>" + basket.productNo + "</span></td>"										   
										  + "<td><h5 class='textCenter'>1</h5></td>"
										  + "<td><h5 class='textCenter'>(" + basket.month + "개월)" + basket.rentalPrice + "원</h5></td>"
										  + "<td><div id='delete' class='divMargin' onclick='deleteBasket(this);' style='text-align:center; color:white; background-color:purple; height:25px; width:40px;'><span style='display:none'>" + basket.rentalNo + "</span>-</div></td></tr>";										  
										  
							$basketSection.append($myBasket);
							
							sum += parseInt(basket.rentalPrice.replace(",", ""));							
						}
						
						//console.log(numberWithCommas(sum));
						//$howMuch.html(numberWithCommas(sum) + " 원");
					},
					error: function(status) {
						console.log(status);
					}				
				});
				
				
			<% } else { %>
				alert("로그인을 먼저 하세요")
			<% } %>			
					
			
		});
		
		
		function rentalPriceFunction(id){
			
			var checked = $(id).is(":checked");
			//console.log(checked);
			var $howMuch = $("#howMuch"); 
			var price =  parseInt($howMuch.html().replace(",",""));
			var rentalPrice = parseInt($(id).attr("rentalPrice"));
			
			$howMuch.html("");
			
			if(isNaN(price)){
				price = 0;
			}
			var sum = 0;
			//console.log($rentalPrice);
			if(checked){
				sum = price + rentalPrice;					
			}else {
				sum = price - rentalPrice;				
			}
			
			$howMuch.html(numberWithCommas(sum) + " 원");
		}
		
		
		function payment(){
			var array = new Array();
			var num = 3;
			var index = 0;
			$(".bascketCheck").filter(":checked").filter(function(){
				array[index] = $(this).val();
				index++;
			});
			
			console.log(array);
			
			location.href="<%=request.getContextPath()%>/payment.or?rentalNo="+array + "&num="+num;
		}
		
		
		function deleteBasket(id){			
			var rentalNo = $(id).find("span").html();
			//console.log(rentalNo);
			
			$.ajax({
				url: "<%=request.getContextPath()%>/deleteBasket",
				type: "get",
				data: { rentalNo: rentalNo },
				success: function(data){
					//console.log(data);
					
					if(data > 0){
						console.log("성공");
					} else {
						console.log("실패");
					}
					
				},
				error: function(status){
					console.log(status);
				}				
			});
			
			location.reload(true);			
		}
		
		//돈 , 표시 함수
		function numberWithCommas(x) {
		    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
		
		function moveDetail(id){
			var productNo = $(id).find("span").html();
			//console.log(productNo);
			location.href='<%=request.getContextPath() %>/selectOneDetail?proNum=' + productNo;
		}
		
	</script>


<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>

</body>
</html>