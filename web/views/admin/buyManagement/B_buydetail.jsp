<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.kh.forest.buy.model.vo.BuyInfo,
    	java.util.ArrayList, com.kh.forest.buy.model.vo.BuyAttachment" %>
<%
	BuyInfo buyinfo = (BuyInfo) request.getAttribute("buyinfo");
	String buyNo = (String) request.getAttribute("buyNo");
	ArrayList<BuyAttachment> fileList = (ArrayList<BuyAttachment>) request.getAttribute("fileList");
	
	BuyAttachment img1 = fileList.get(0);
	BuyAttachment img2 = fileList.get(1);
	BuyAttachment img3 = fileList.get(2);
	BuyAttachment img4 = fileList.get(3);
	BuyAttachment img5 = fileList.get(4);
%>
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
}
.table-area>table{
	width: 700px;
	text-align: center;
	margin-top: 10px;
	border-collapse:collapse;
}
.table-area tr>td:nth-of-type(1){
	width:200px;
	background: #DADADA;
}
.table-area tr>td{
	
	border: 1px solid #828282;
}

/*사진 보기 */
.photo-area {
	display: flex;
	height: 180px;
}

.photo-div {
	margin: 0 auto;
	margin-top: 5px;
	width: 100px;
	height: 100px;
}

.icon-img {
	width: 40px;
	height: 30px;
	margin-top: 30px;
}

.div2, .div3, .div4, .div5 {
	margin-left: 1px;
}

.photo-div>div {
	width: 100px;
	height: 100px;
	background-image: url('/forest/image/userimg/backimg2.png'); 	
	text-align: center;
	margin-bottom: 20px;
	cursor:pointer;
}

.photo-div>button {
	width: 100px;
	height: 30px;
	background: #16AAD8;
	color: white;
	border: none;
}

.photo-div>p {
	text-align: center;
	font-size: 17px;
	color: #828282;
	top: 0px;
	padding-bottom: 10px;
	font-weight: bold;
}
.text-area{
	width: 700px;
	height: 30px;
	margin: 0 auto;
	font-size: 15px;
	color: #828282;
}
/*주소 및 운송장 번호 입력 영역*/
.input-area{
	width:700px;
	height:180px;
	display: flex;
	margin: 0 auto;
	text-align: left;
}
.delivery-area{
	margin-left: 3px;
	margin: 0 auto;
	margin-top: 10px;
}
.address-area{
	margin : 0 auto;
	width: 300px;
}
.address-area>input{
	margin-bottom: 12px;
	
}
.address-area>p, .delivery-area>p{
	font-size: 17px;
}
.address-area tr>td{
	border: 1px solid black;
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
	cursor:pointer;
}

</style>
</head>
<body>
	<div class="top-title">
     	<p style="padding-left:20px;">매입신청 확인</p>
   	</div>

	<div class="table-area">
		<table>
			<caption style="text-align:left; font-weight:bold; font-size:19px;">| 신청 정보</caption>
			<tr>
				<td>매입번호</td>
				<td id="td-buyno"><%=buyNo%></td>
			</tr>
			<tr>
				<td>이름(아이디)</td>
				<td><%=buyinfo.getUserName() %>(<%=buyinfo.getUserId() %>)</td>
			</tr>

			<tr>
				<td>상품명</td>
				<td><%=buyinfo.getBuyProductName() %></td>
			</tr>
		</table>
	</div>

	<!------------------------ 사진 확인 ------------------------>
		<div class="photo-area">
			<div class="photo-div div1">
				<p>전면사진</p>
				<div>
					<img id="contentImg1" width="100" height="100"
						 src="<%=request.getContextPath()%>/photo_uploadFiles/<%=img1.getChangeName()%>">
				</div>
			</div>

			<div class="photo-div div2">
				<p>바닥사진</p>
				<div>
					<img id="contentImg2" width="100" height="100"
						src="<%=request.getContextPath()%>/photo_uploadFiles/<%=img2.getChangeName()%>">
				</div>
			</div>

			<div class="photo-div div3">
				<p>좌측사진</p>
				<div>
					<img id="contentImg3" width="100" height="100"
						src="<%=request.getContextPath()%>/photo_uploadFiles/<%=img3.getChangeName()%>">
				</div>
			</div>

			<div class="photo-div div4">
				<p>우측사진</p>
				<div>
					<img id="contentImg4" width="100" height="100"
						src="<%=request.getContextPath()%>/photo_uploadFiles/<%=img4.getChangeName()%>">
				</div>
			</div>

			<div class="photo-div div5">
				<p>전체사진</p>
				<div>
					<img id="contentImg5" width="100" height="100"
						src="<%=request.getContextPath()%>/photo_uploadFiles/<%=img5.getChangeName()%>">
				</div>
			</div>
		</div>
		<div class="text-area">* 사진을 누르면 원본 이미지를 볼 수 있습니다.</div>
		<div class="input-area">
			<div class="address-area">
				<p><b>| 고객 주소</b></p>
				<table>
					<% 
						String[] arr = buyinfo.getBuyAddress().split("[$]");
					%>
					
					<tr id="zip">
						<% if (buyinfo.getBuyAddress().equals("-")) { %>
							<td style="width:300px;">(<%=buyinfo.getBuyAddress() %>)</td>
						<% } else { %>	
							<td style="width:300px;">(<%=arr[0] %>)</td>
						<% } %>
					</tr>
					<tr id="address1">
						<% if (buyinfo.getBuyAddress().equals("-")) { %>
							<td style="width:300px;"><%=buyinfo.getBuyAddress() %></td>
						<% } else { %>	
							<td style="width:300px;"><%=arr[1] %></td>
						<% } %>
					</tr>
					<tr id="address2">
						<% if (buyinfo.getBuyAddress().equals("-")) { %>
							<td style="width:300px;"><%=buyinfo.getBuyAddress() %></td>
						<% } else { %>	
							<td style="width:300px;"><%=arr[2] %></td>
						<% } %>
					</tr>
				</table>
				
			</div>
			
			<div class="delivery-area">
				<p><b>| 운송장 번호</b></p>
				<input type="text" name="deliveryNo" value="<%=buyinfo.getWaybillNo() %>" readonly>  
				<!-- <p><b>| 	배송 일자</b></p>
				<input type="text" name="deliveryDate" value="" readonly> -->
			</div>
		</div>
		
		<div class="btn-area">
			<button id="closeBtn">취소</button>
				<button class="okBtn" id="sendOkBtn">인수완료</button>
		</div>
		
		<script>
			$(function(){
				//인수완료 버튼 
				var waybillNo = $("input:text[name=deliveryNo]").val();
				var buyNo = $("#td-buyno").text();
				
				console.log("waybillNo:" + waybillNo);
				
				if(waybillNo == "-"){
					$("#sendOkBtn").css({"background":"#BABABA"});
				} else {
					$("#sendOkBtn").click(function(){

						$.ajax({
							url: "/forest/updateWaybill.buy",
							type: "post",
							data: {buyNo : buyNo},
							success: function(data){
								console.log(data);	
									window.close();		
							},
							error: function(error){
								console.log(error);
							}
							
						}); 
					});
				}
				
				//사진 클릭시 원본보기
 				$("#contentImg1").click(function(){
					var img = new Image();
					var url = $("#contentImg1").attr("src");
					console.log(url);
					img.src = url;
					var img_width=img.width;
					var win_width=img.width+2;
					var img_height=img.height;
					var win=img.height+2;
					var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
					  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+ url +"' width='"+win_width+"'>");
					
				});  
 				$("#contentImg2").click(function(){
					var img = new Image();
					var url = $("#contentImg2").attr("src");
					console.log(url);
					img.src = url;
					var img_width=img.width;
					var win_width=img.width+2;
					var img_height=img.height;
					var win=img.height+2;
					var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
					  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+ url +"' width='"+win_width+"'>");
					
				});  
 				$("#contentImg3").click(function(){
					var img = new Image();
					var url = $("#contentImg3").attr("src");
					console.log(url);
					img.src = url;
					var img_width=img.width;
					var win_width=img.width+2;
					var img_height=img.height;
					var win=img.height+2;
					var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
					  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+ url +"' width='"+win_width+"'>");
					
				});  
 				$("#contentImg4").click(function(){
					var img = new Image();
					var url = $("#contentImg4").attr("src");
					console.log(url);
					img.src = url;
					var img_width=img.width;
					var win_width=img.width+2;
					var img_height=img.height;
					var win=img.height+2;
					var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
					  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+ url +"' width='"+win_width+"'>");
					
				});  
 				$("#contentImg5").click(function(){
					var img = new Image();
					var url = $("#contentImg5").attr("src");
					console.log(url);
					img.src = url;
					var img_width=img.width;
					var win_width=img.width+2;
					var img_height=img.height;
					var win=img.height+2;
					var OpenWindow=window.open('','사진상세보기', 'width='+img_width+', height='+img_height+', menubars=no, scrollbars=auto, resizable=no, left=300,top=50');
					  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+ url +"' width='"+win_width+"'>");
					
				});  

				
				
				//클로즈버튼시 윈도우오픈 닫힘
				$("#closeBtn").click(function(){
					window.close();
				});
				
				if( $("input:text[name=deliveryNo]").val() == null){
					$("input:text[name=deliveryNo]").val("-");
				}
				
			});
			
		</script>
</body>
</html>