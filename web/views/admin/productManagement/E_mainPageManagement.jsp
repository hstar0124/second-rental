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
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="ready('메인 페이지 상품 진열 관리', '상품관리', '메인 페이지 상품 진열관리');">
	<%@ include file="../common/C_menubar.jsp" %>

	<article class="E">
		<form>
			<table class="table1" style="border : 10px">
				<tr>
					<td class="htd">카테고리</td>
					<td>
					<select class="vl">
							<option>1차분류</option>
					</select>
					<select class="vl">
							<option>2차분류</option>
					</select></td>
				</tr>
				<tr>
					<td class="htd">검색어</td>
					<td><select class="vl">
							<option class="vl">전체</option>
					</select> <input class="vl" type="text"></td>
				</tr>
			
				<tr>
					<td class="htd">등록일</td>
					<td>
						<input class="vl" type="text" id="datepicker">~
						<input class="vl"type="text" id="datepicker1">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="border : none; background : white;">
						<input style="background : #6792DA; color : white; width : 70px; height : 25px;
						border:none;"
						type="submit" id="bt" value="검색">
					</td>
				</tr>
				
			</table>


		</form>
		<table class="table2">
			<td style="border : 1px solid gray; background : #ECECEC;">검색결과 : <span><>건</span> 전체 상품 : <span><>건</span></td>
		</table>

		<table class="table3">
			<tr><th></th>
				<th>번호</th>
				<th>상품번호</th>
				<th>상품명</th>
				<th>등록일</th>
				<th>렌탈가(한달/두달이상)</th>
				<th>상세</th>

			</tr>
			<!-- for!!!!!-->
			<tr><td><input type="checkbox"></td>
				<td>003</td>
				<td>A2001230002</td>
				<td>맥북프로 13.3인치</td>
				<td>2020.01.29 15:22:10</td>
				<td>23,500<br>/15,500</td>
				<td><button type="button" style="width:23px; height:23px; padding:0;border:none;">
				<img style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px">
				</button></td>
			</tr>

		</table>
		<hr>
		
		<form style="align:center">
			<table >
				<tr>
					<td style="width : 200px; border:none;" >
						<div style="width:200px; border: none; font-size:20px; color:orangered; background:white; font-weight:900"
						 onclick="newProduct();" id="newBtn"> &nbsp;&nbsp;새상품 </div>
					</td>
					<td style="border-right:none; border-top:none;">
						<div style="width:200px; border: none; font-size:20px; background:white;"
						onclick="recommend();" id="recommendBtn"> &nbsp;&nbsp;추천상품 </div>
					</td>
				</tr>
				<tr>
					<td style="text-align:center">템플릿</td>
					<td>
						<div id="new" style="display:block">
							<input type="image" src="/forest/image/userimg/sub.png" width="100%;">
							<input type="image" src="/forest/image/userimg/sub.png" width="24%;" height="100px;">
							<input type="image" src="/forest/image/userimg/sub.png" width="24%;" height="100px;">
							<input type="image" src="/forest/image/userimg/sub.png" width="24%;" height="100px;">
							<input type="image" src="/forest/image/userimg/sub.png" width="24%;" height="100px;">
						</div>
						
						
						<div id="recommend" style="display:none">
							<input type="image" src="/forest/image/userimg/sub2.png" width="100%;">
						</div>
						
					</td>
				</tr>
				<tr>
					<td style="text-align:center">지정상품 리스트</td>
					<td>
						
						
					</td>
				</tr>
				<tr>
						<td colspan="2" style="border : none; background : white; text-align:center;">
							<input style="background : #6792DA; color : white; width : 70px; height : 25px;
						border:none;"
						type="submit" id="bt" value="적용">
						</td>
				</tr>
				
			</table>
		</form>
		
											
	</article>
		<script>
			function newProduct(){
				$("#new").show();
				$("#recommend").hide();
				$("#newBtn").css({"color":"orangered","font-weight":"900"});
				$("#recommendBtn").css({"color":"black","font-weight":"100"});
			};
			
			function recommend(){
				$("#new").hide();
				$("#recommend").show();
				$("#newBtn").css({"color":"black","font-weight":"100"});
				$("#recommendBtn").css({"color":"orangered","font-weight":"900"});
			};
		</script>
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
	
	</script>
	<%@ include file="../common/C_menubar2.jsp" %>

</body>
</html>