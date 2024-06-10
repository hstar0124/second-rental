<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	#wishListSection {
		width:100%;
	}
	.wishArticle{
		background-color: white;
    	width: 325px;
    	height: 300px;
    	display: inline-table;
    	margin-left: 8px;
    	margin-top: 15px;
    	text-align: center;
	}
	.myWishlistImg{
		width: 280px;
		height: 220px;		
	}
	#wishNoticeDiv{
		width: 100%;
		height: 300px;
		line-height: 300px;
		font-size: 20px;
		text-align: center;
	}
	#manuNameDiv{
		width: 300px;
		height: 20px;
		text-align: left;
		margin-left: 10px;
		font-size: 15px;
		font-weight: 800;
	}
	#proNameDiv{
		width: 300px;
		height: 50px;
		text-align: left;
		margin-left: 10px;
		font-size: 15px;
		font-weight: 800;
	}
	#myWish{
		background:#6E00AB;
		color: white;
	}
	#myWishText{
		color: white;
	}
	
</style>

</head>
<body>

	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>
	
	<table id="wishListSection">
		<tr>
			<td colspan="3"><h1>위시리스트</h1></td>
		</tr>
		<tr>
			<td colspan="3"><div style="background-color:purple; width:100%; height:4px;"></div></td>
		</tr>
		<tr>
			<td colspan="3" id="wishListTd">
				<div id="wishBodyDiv" style="width:100%;">
			
				
					<div id="wishNoticeDiv">찜 목록이 없습니다</div>
					<!-- <div class="wishArticle"></div> -->
					
				</div>
			</td>
		</tr>
		
	</table>
	
	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>
	
	<script>
		var productArr = new Array();
		
		$(function(){
			var userNo = "<%= loginMember.getUserNo()%>";
						
			$.ajax({
				url: "<%= request.getContextPath() %>/myWishlist",
				type: "get",
				data: { userNo : userNo },
				success: function(data){
					
					if( data.length > 0){
						$("#wishListTd").children().find("div").remove();
					}
					
					var $wishBody = $("#wishBodyDiv");
					
					for(key in data){
						var wish = data[key];
						//userNo, proNo, manuName, proName, cngName
						<%-- console.log(wish.userNo);
						console.log(wish.proNo);
						console.log(wish.manuName);
						console.log(decodeURIComponent(wish.proName).replace(/\+/g, " "));
						console.log(wish.cngName);						
						$(".myWishlistImg").attr("src", "<%=request.getContextPath()%>/image/productImg/"+wish.cngName); --%>
						
						var $wishArticle = "<div class='wishArticle' onclick='toProductDetail(this);'>"
										 + "<img class='myWishlistImg' src=" + '<%=request.getContextPath()%>/image/productImg/'+ wish.cngName + ">"
										 + "<div id='manuNameDiv'>" + wish.manuName + "</div>"
										 + "<div id='proNameDiv'>" + decodeURIComponent(wish.proName).replace(/\+/g, " ") + "</div>"
										 + "<span id='proNoDiv' style='display:none'>" + wish.proNo + "</span>" 
										 + "</div>"	
						
						$wishBody.append($wishArticle);
						
					}
				},
				error: function(status){
					console.log(status);
				}
			});			
		});
		
		function toProductDetail(id){
			var productNo = $(id).find("span").html();
			//console.log(productNo);
			
			if(productNo.length > 5){
				location.href='<%=request.getContextPath() %>/selectOneDetail?proNum=' + productNo;
			}
		}
		
	</script>

</body>
</html>