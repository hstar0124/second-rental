<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.forest.product.model.vo.*, com.kh.forest.product.model.service.*, com.kh.forest.review.model.vo.*"%>
<%
	ArrayList<Rental> rentalList = (ArrayList<Rental>) request.getAttribute("rentalList");
	ArrayList<Review> list = (ArrayList<Review>) request.getAttribute("list");
	E_PageInfo pi = (E_PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int limit = pi.getLimit();
	int maxPage = pi.getMaxPage();
	int endPage = pi.getEndPage();
	int startPage = pi.getStartPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>

	.E .bt {
		margin: 5px;
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
		background-color: rgb(0, 0, 0); /* Fallback color */
		background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	}
	
	/* Modal Content/Box */
	.modal-content {
		background-color: #fefefe;
		margin: 15% auto; /* 15% from the top and centered */
		padding: 20px;
		border: 1px solid #888;
		width: 50%; /* Could be more or less, depending on screen size */
	}
	/* The Close Button */
	.close {
		color: #aaa;
		float: right;
		font-size: 28px;
		font-weight: bold;
	}
	
	.close:hover, .close:focus {
		color: black;
		text-decoration: none;
		cursor: pointer;
	}
	
	.productBody {
		margin: 0 auto;
		width: 100%;
		height: 700px;
	}
	
	.displayDiv {
		float: left;
		width: 100%;
		height: 600px;
	}
	
	td {
		padding: 0px;
	}
	
	.labelBasicStyle {
		font-weight: 600;
	}
	
	#productName {
		font-weight: 600;
		font-size: 20px;
	}
	
	.bar {
		background-color: #6E00AB;
		width: 100%;
		height: 4px;
		margin-top: 15px;
		margin-bottom: 15px;
	}
	
	#price {
		font-weight: 600;
		font-size: 20px;
	}
	
	select[name=month] {
		width: 100%;
		height: 30px;
	}
	
	
	
	#wishBtn {
		border: 1px solid;
	}
	
	#basketBtn {
		border: 1px solid;
	}
	
	
	
	#rentalText {
		color: white;
	}
	
	#mainImgDiv {
		background: lightgray;
		width: 90%;
		height: 100%;
	}
	
	.subImgDiv {
		margin: 0 auto;
		width: 24%;
		display: inline-block;
		height: 100%;
		background: lightgray;
	}
	
	.subTitle {
		text-align: center;
		font-size: 20px;
		font-weight: 600;
	}
	
	#categoryName {
		margin-top: 50px;
	}

	/* -------리뷰 작성------- */
	/* .outer {
		width:1000px;
		height:650px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	} */
	/* table {
		border:1px solid white;
	} */
	/* .insertArea {
		width:500px;
		height:450px;
		margin-left:auto;
		margin-right:auto;
	} */
	/* .btnArea {
		width:150px;
		margin-left:auto;
		margin-right:auto;
	} */
	#titleImgArea {
		width:350px;
		height:200px;
		/* border:2px dashed darkgray; */
		text-align:center;
		display:table-cell;
		vertical-align:middle;
	}
	#contentImgArea1, #contentImgArea2, #contentImgArea3 {
		width:150px;
		height:100px;
		/* border:2px dashed darkgray; */
		text-align:center;
		display:table-cell;
		vertical-align:middle;
	}
	#titleImgArea:hover, #contentImgArea1:hover, 
	#contentImgArea2:hover, #contentImgArea3:hover {
		cursor:pointer;
	}
	/* -------별점주기------- */
	.starR{
		background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
		background-size: auto 100%;
		width: 30px;
		height: 30px;
		display: inline-block;
		text-indent: -9999px;
		cursor: pointer;
	}
	.starR.on{
		background-position:0 0;
	}
		/* --------------------- */
</style>
</head>
<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>



<body class="E">

	<h1 class="text1">렌탈 현황</h1>
	<div
		style="background-color: #6E00AB; width: 100%; height: 4px; margin-top: 0px;"></div>

	<br>
	<br>
	<table width="100%" style="text-align: center">
		<tr style="border-bottom: 1px solid black">
			<th colspan="3" style="border-bottom: 1px solid black">주문 정보</th>
			<th style="border-bottom: 1px solid black">대여 기간</th>
			<th style="border-bottom: 1px solid black">상태</th>
			<th style="border-bottom: 1px solid black"></th>
		</tr>
		<%
			for (int i = 0; i < rentalList.size(); i++) {
		%>
		<tr style="border-top: 1px solid black">
			<td rowspan="3"><img width=150px height=150px
				src="<%=request.getContextPath()%>/image/productImg/<%=rentalList.get(i).getChangeName()%>"></td>
			<td><strong>주문번호</strong></td>
			<td><%=rentalList.get(i).getOrderNo()%></td>
			<td rowspan="3"><%=rentalList.get(i).getStartDate()%>~<br><%=rentalList.get(i).getExpiryDate()%>
			</td>
			<td rowspan="3">
				<strong><%if(rentalList.get(i).getRefundStatus()==null){ %>
						<%=rentalList.get(i).getRentalStatus()%>
						<%} %>
						<%if(rentalList.get(i).getRefundStatus()!=null){ %>
						<%=rentalList.get(i).getRefundStatus() %>
						<%} %>
						</strong></td>
			<td rowspan="4">
			
				<%if(rentalList.get(i).getRefundStatus()==null
				&&!rentalList.get(i).getOrderStatus().equals("결제완료")
				&&!rentalList.get(i).getRentalStatus().equals("회수완료")){ %>
				<input style="background: #6E00AB; color: white; width: 90px; height: 30px; border: none;"
				type="button" class="bt modal1" id="myBtn1"
				onclick="openModal(<%=rentalList.get(i).getOrderCode()%>);"
				value="환불신청"><br> 
				<%} %>
				
				
				<%if(rentalList.get(i).getRefundStatus()==null
                  &&!rentalList.get(i).getRentalStatus().equals("회수완료")) {%>
            <input style="background: #6E00AB; color: white; width: 90px; height: 30px; border: none;"
            type="button" class="bt" value="연장하기" id="myBtn2"
            onclick='openModal2("<%=rentalList.get(i).getProductNo()%>",<%=rentalList.get(i).getRentalNo()%>,<%=12 - Integer.parseInt(rentalList.get(i).getRentalMonth())%>)'><br>
             <%} %> 
				
				 <%if(rentalList.get(i).getRentalStatus().equals("회수완료")
						&&rentalList.get(i).getrTitle()==null) {%> 
				<input style="background: #6E00AB; color: white; width: 90px; height: 30px; border: none;"
				type="button" class="bt" value="후기작성" id="myBtn3"
				<%System.out.println(12 - Integer.parseInt(rentalList.get(i).getRentalMonth())); %>
				onclick='openModal3("<%=rentalList.get(i).getProductNo()%>",<%=rentalList.get(i).getRentalNo()%>)'><br>
				  <%} %>  
			</td>
		</tr>
		
		<tr>
			<td><strong>상품명</strong></td>
			<td><%=rentalList.get(i).getProductName()%></td>
		</tr>
		<tr>
			<td><strong>상품 금액</strong></td>
			<td><%=rentalList.get(i).getPrice()%></td>
		</tr>
		<tr>
			<td colspan="5" id="detail" style="text-align:center"><br>
			
			<div id="box<%=i %>">
				<div class= "detailBtn" style="cursor:pointer;"id="box<%=i %>"  >주문 상세정보 보기 >></div>
				<div class= "cont" style="width:700px; color: gray; display:none" id="info<%=i%>">
					<table style="margin-left:200px; text-align:left;">
						<tr >
							<td style="width:150px;">수령자</td>
							<td style="width:500px"><%=rentalList.get(i).getRecipient()%>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><%=rentalList.get(i).getPhone()%>
						</tr>
						<tr>
							<td>주소</td>
							<td><%=rentalList.get(i).getAddress().replace('$', ' ')%></td>
						</tr>
					</table>
				</div>
			</div>
			</td>

		</tr>
		<tr>
			<td colspan="6" style="border-bottom: 1px solid"><br> <span
				style="color: red"> <%=12 - Integer.parseInt(rentalList.get(i).getRentalMonth())%></span><span>개월
					추가 대여하시면 인수 가능합니다.</span></td>
		</tr>
		<%
			}
		%>
	</table>
	<div align="center">
		<button style="cursor: Pointer; background:white; border:none"
			onclick="location.href='<%=request.getContextPath()%>/rentalList?currentPage=1'"><<</button>
		<%
			if (currentPage <= 1) {
		%>
		<button disabled style="background:white; border:none"><</button>
		<%
			} else {
		%>
		<button style="cursor: Pointer; background:white; border:none"
			onclick="location.href='<%=request.getContextPath()%>/rentalList?currentPage=<%=currentPage - 1%>'">
			<</button>
		<%
			}
		%>

		<%
			for (int p = startPage; p <= endPage; p++) {
				if (p == currentPage) {
		%>
		<button disabled style="background:white; border:none"><%=p%></button>
		<%
			} else {
		%>
		<button style="cursor: Pointer; background:white; border:none"
			onclick="location.href='<%=request.getContextPath()%>/rentalList?currentPage=<%=p%>'"><%=p%></button>

		<%
			}
			}
		%>
		<%
			if (currentPage >= maxPage) {
		%>
		<button disabled style="background:white; border:none">></button>
		<%
			} else {
		%>
		<button style="cursor: Pointer; background:white; border:none"
			onclick="location.href='<%=request.getContextPath()%>/rentalList?currentPage=<%=currentPage + 1%>'">
			></button>
		<%
			}
		%>

		<button style="cursor: Pointer; background:white; border:none"
			onclick="location.href='<%=request.getContextPath()%>/rentalList?currentPage=<%=maxPage%>'">>></button>

	</div>


	<!-- 환불신청@@@@@@@@@@@@@@@@@@@@@@@2 -->
	<!-- The Modal -->
	<div id="myModal1" class="modal">

		<!-- Modal content -->
		<div class="modal-content"
			style="padding: 20px; width: 470px; height: 400px;">
			<p>
			<h3>*고객님의 단순 변심에 의한 환불은 불가능합니다.</h3>
			<form action="<%=request.getContextPath()%>/refund" method="post">
				<table>
					<tr>
						<td><input id="orderCode" name="orderCode" type="text" hidden>
						</td>
					</tr>
					<tr>
						<td><textarea rows="10" cols="38" name="reason"
								style="resize: none; margin: 10px; font-size: 20px;"
								placeholder="환불 사유를 입력해주세요."></textarea></td>
					</tr>
					<tr style="text-align: center">
						<td><input type="submit" value="환불 신청하기"
							style="background: #6E00AB; color: white; border: 1px solid #6E00AB; width: 120px; height: 40px;">

							<input type="reset" class="close1" value="취소"
							style="background: #6E00AB; color: white; border: 1px solid #6E00AB; width: 100px; height: 40px;">
						</td>
					</tr>
				</table>
			</form>
			</p>
		</div>

	</div>

	<!-- 연장하기@@@@@@@@@@@@@@@@@@@@@@@@22 -->
	<div id="myModal2" class="modal">

		<!-- Modal content -->
		<div class="modal-content" style="width: 500px; height: 800px;">
			
			<!------------------------------------------>
			<p>
			<div class="productBody">
				<div class="displayDiv" >
					<form action="<%=request.getContextPath()%>/payment.or">
					<input type="hidden" name="num" value="2">					
					<table style="width: 100%; height: 100%;">
						<tr >
							<td><input type="text" id="productNo" name="productNo" hidden></td>
							<td><input type="text" id="rentalNo" name="rentalNo" hidden></td>
						</tr>
						<tr><p style="color:red">연장하신 상품은 하나의 렌탈로 취급되며 <br>
						환불정책 또한 이와 동일하게 적용됩니다.</p></tr>
						<tr>
							<td colspan="3"><div class="bar"></div></td>
						</tr>
						<tr>
							<td colspan="3"><label class="labelBasicStyle"
								id="manufacturer"></label></td>
						</tr>
						<tr height="4px"></tr>
						<tr>
							<td colspan="3"><label id="productName"></label></td>
							<input type="hidden" name="productName" id="proNameHidden">
						</tr>
						<tr height="4px"></tr>
						<tr>
							<td colspan="3"><label class="labelBasicStyle" id="pid"></label>
								/ <label class="labelBasicStyle" id="category"> </label></td>
						</tr>
						<tr>
							<td colspan="3"><div class="bar"></div></td>
						</tr>
						<tr height="50px"></tr>
						<tr>
							<td colspan="3"><label id="price"></label></td>
							<input type="hidden" name="price" id="priceHidden">
						</tr>
						<tr height="60px"></tr>
						<tr>
							<td colspan="3"><label style="font-weight: 600;">대여
									기간 선택</label></td>
						</tr>
						<tr>
							<td colspan="3"><select name="month" id="month">
							</select></td>
						</tr>
						<tr height="50px"></tr>
						<tr>
							<td colspan="3"><label id="maxMonth" class="labelBasicStyle">
							</label></td>
						</tr>
						<tr height="50px"></tr>
						<tr>
							<td colspan="3"><div class="bar"></div></td>
						</tr>
						<tr>
							<td class="btnAlign" style="width: 100% ; text-align:center;">
								<div class="btnDiv" id="buyBtn">
									<input style="background: #6E00AB; color: white; width: 90px; height: 30px; border: none;"
									type="submit" class="bt" value="연장하기">&nbsp;&nbsp;&nbsp;
									<input style="background: #6E00AB; color: white; width: 90px; height: 30px; border: none;"
									type="button" class="bt close2" name="cancelExtend"value="취소하기" >
								</div>
							</td>
						</tr>
					</table>
					</form>
				</div>
			</div>
			<!-- 	---------------------- -->
			</p>
		</div>

	</div>
	
	<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@리뷰작성@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
	<!-- The Modal -->
	<div id="myModal3" class="modal">

		<!-- Modal content -->
		<div class="modal-content"
			style="padding: 20px; width: 600px; height: 750px;">
			<h3 style="text-align: center">리뷰 작성란</h3>
			<form action="<%=request.getContextPath()%>/insert.re" method="post" encType="multipart/form-data">
				<div class="insertArea">
					<table align="center">
						<tr style="text-align: center">
						<% for (int i = 0; i < rentalList.size(); i++) { %>
							<% if(!rentalList.get(i).getRentalStatus().equals("회수완료")) { %>
							<td><input type="hidden" id="productNo" name="productNo" value="<%=rentalList.get(i).getProductNo()%>"></td>
							<% } %>
						<% } %>
						</tr>
						
						<!-- 시간 -->
						<!-- <tr>
							<td><input class="vl" id="now_date" type="date" name="date" value="date"></td>
						</tr> -->
						<tr>
							<td colspan="2">대표<br>사진</td>
							<td colspan="2" style="text-align: center">
								<div id="titleImgArea">
									<img id="titleImg" width="350" height="200">
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">추가<br>사진</td>
							<td colspan="2" style="text-align: center">
								<div id="contentImgArea1">
									<img id="contentImg1" width="120" height="100">
								</div>
								<div id="contentImgArea2">
									<img id="contentImg2" width="120" height="100">
								</div>
								<div id="contentImgArea3">
									<img id="contentImg3" width="120" height="100">
								</div>
							</td>
						</tr>
						<tr style="text-align: center">
							<td colspan="4">
								<div class="starRev" style="text-align: center">
									<span> 별점 : </span>
  									<span class="starR on">별1</span>
 									<span class="starR">별2</span>
									<span class="starR">별3</span>
 									<span class="starR">별4</span>
 									<span class="starR">별5</span>
								</div>
							</td>
						</tr>
						<tr style="text-align: center">
							<td colspan="2">제목</td>
							<td colspan="2"><input type="text" size="45" name="title"></td>
						</tr>
						<tr style="text-align: center">
							<td colspan="4"><textarea rows="10" cols="38" name="content"
								style="resize: none; margin: 10px; font-size: 20px;"
								placeholder="후기를 작성해주세요."></textarea></td>
						</tr>
						<tr style="text-align: center">
							<td colspan="4"><input type="submit" value="리뷰남기기"
								style="background: #6E00AB; color: white; border: 1px solid #6E00AB; width: 120px; height: 40px;">

								<input type="reset" class="close3" value="취소"
								style="background: #6E00AB; color: white; border: 1px solid #6E00AB; width: 100px; height: 40px;">
							</td>
						</tr>
					</table>
					
					<div id="fileArea">
						<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this, 1);">
						<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="loadImg(this, 2);">
						<input type="file" id="thumbnailImg3" name="thumbnailImg3" onchange="loadImg(this, 3);">
						<input type="file" id="thumbnailImg4" name="thumbnailImg4" onchange="loadImg(this, 4);">
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
	$(document).on("click","[name=cancelExtend]",function(){
		$("#month").children().remove();
		
	})
	</script>
	<script>
	$('.detailBtn').click(function(){
		$(this).next('.cont').toggle();
	});
	</script>
	
	<script>
		//환불신청@@@@@@@@@@@@@@@@@@@@2
		var modal1 = document.getElementById('myModal1');
		// Get the button that opens the modal
		var btn1 = document.getElementById("myBtn1");
		// Get the <span> element that closes the modal
		var span1 = document.getElementsByClassName("close1")[0];
		// When the user clicks on the button, open the modal 
		
		function openModal(code) {
			modal1.style.display = "block";
		    var orderCode =code;
 		    $("#orderCode").val(orderCode); 
		}
		// When the user clicks on <span> (x), close the modal
		span1.onclick = function() {
			modal1.style.display = "none";
		}
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal1) {
				modal1.style.display = "none";
			}
		}
		
		//Get the modal
		var modal2 = document.getElementById('myModal2');
		// Get the button that opens the modal
		var btn2 = document.getElementById("myBtn2");
		// Get the <span> element that closes the modal
		var span2 = document.getElementsByClassName("close2")[0];
		// When the user clicks on the button, open the modal 
		function openModal2(pNo, rNo, mM) {
			modal2.style.display = "block";
 			var productNo = pNo;
			var rentalNo = rNo;
			var maxMonth = mM;
			console.log(productNo);
			console.log("ㅗㅗ");
			console.log(rentalNo);
			console.log(maxMonth);
			$("#productNo").val(productNo);
			$("#rentalNo").val(rentalNo);
			$.ajax({
				url:"selectExtendProduct",
				data:{productNo : productNo},
				type:"get",
				success:function(data){
					var manufacturerName = decodeURIComponent(data.manufacturerName);
					var productName = decodeURIComponent(data.productName).replace(/\+/g, " ");
					var productNo = decodeURIComponent(data.productNo);
					var categoryName = decodeURIComponent(data.categoryName);
					var rentalPrice = decodeURIComponent(data.rentalPrice).replace(/\+/g, " ");
					var acceptanceMonth = decodeURIComponent(data.acceptanceMonth);
					
					$("#manufacturer").html(manufacturerName);
					$("#productName").html(productName);
					$("#pid").html('상품번호 : ' + productNo);
					$("#category").html(categoryName);
					$("#price").html('월 ' + rentalPrice + ' 원');
					$("#option").html(acceptanceMonth + '개월');
					$("#maxMonth").html('최대대여기간 : ' + maxMonth + '개월');
					$("#priceHidden").val(rentalPrice);
					$("#proNameHidden").val(productName);
					
					var $month = $("#month");
					
					for(var i = 0 ; i < maxMonth ; i++){
						$option = $("<option value="+(i+1)+" name='tempCategory'>"+(i+1)+"개월</option>");
						$month.append($option);
					}
				},
				error:function(status){
					console.log(status);
				}
			});
			
		}
		// When the user clicks on <span> (x), close the modal
		span2.onclick = function() {
			modal2.style.display = "none";
		}
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal1) {
				modal2.style.display = "none";
			}
		}
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@후기작성@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		var modal3 = document.getElementById('myModal3');
		// Get the button that opens the modal
		var btn3 = document.getElementById("myBtn3");
		// Get the <span> element that closes the modal
		var span3 = document.getElementsByClassName("close3")[0];
		// When the user clicks on the button, open the modal 
		
		function openModal3(code) {
			modal3.style.display = "block";
		    var orderCode3 =code;
		    var productNo = decodeURIComponent(data.productNo);
 		    $("#productNo").val(productNo); 
		}
		
		// When the user clicks on <span> (x), close the modal
		span3.onclick = function() {
			modal3.style.display = "none";
		}
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal3) {
				modal3.style.display = "none";
			}
		}
	</script>
	<script>
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@후기 작성 : 별점주기@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	$('.starRev span').click(function(){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  return false;
		});
	</script>
	<script>
			$(function() {
				$("#fileArea").hide();
				
				$("#titleImgArea").click(function(){
					$("#thumbnailImg1").click();
				});
				
				$("#contentImgArea1").click(function(){
					$("#thumbnailImg2").click();
				});
				
				$("#contentImgArea2").click(function(){
					$("#thumbnailImg3").click();
				});
				
				$("#contentImgArea3").click(function() {
					$("#thumbnailImg4").click();
				});
			});
			
			function loadImg(value, num) {
				if(value.files && value.files[0]) {
					var reader = new FileReader();
					
					reader.onload = function(e) {
						console.log(e.target.result);
						switch(num) {
							case 1 : $("#titleImg").attr("src", e.target.result); break;
							case 2 : $("#contentImg1").attr("src", e.target.result); break;
							case 3 : $("#contentImg2").attr("src", e.target.result); break;
							case 4 : $("#contentImg3").attr("src", e.target.result); break;
						}
					}
					reader.readAsDataURL(value.files[0]);
				}
			}
		</script>
		<script>
		$(function() {

			
			$(".bodyNav").each(function(){
				if($(this).text()=="렌탈 현황"){
					$(this).css("background", "#6E00AB");
					$(this).children().css("color", "white");
				}
			})
					
		});
		</script>
		
</body>
<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp"%>
</html>


