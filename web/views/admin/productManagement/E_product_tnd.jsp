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
<body onload="ready('상품 이동/삭제', '상품관리', '상품재고관리');">
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
					<td colspan="2" style="border : none; background : white;">
						<input style="background : #6792DA; color : white; width : 70px; height : 25px;
						border:none;"
						type="submit" id="bt" value="검색">
					</td>
				</tr>
				
			</table>


		</form>
		
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
			<tr>
				<td><input type="checkbox"></td>
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
		<br>
		<br>
		<form>
			<table class="table1" style="border : 10px">

				<tr>
					<td class="htd">액션</td>
					<td colspan="1">
						<input class="vl" name="act" id="act1" type="radio"><label for="act1">이동</label>
						<input class="vl" name="act" id="act2" type="radio"><label for="act2">삭제</label>
					</td>
				</tr>
				<tr>
					<td class="htd">카테고리 지정</td>
					<td colspan="3">
						<select class="vl">
							<option>1차분류</option>
						</select>
						<select class="vl">
							<option>2차분류</option>
						</select>
					</td>
				</tr>

				<tr>
					<td colspan="2" style="border : none; background : white;">
						<input style="background : #6792DA; color : white; width : 70px; height : 25px;
						border:none;"
						type="submit" id="bt" value="적용">
					</td>
				</tr>
				
			</table>


		</form>

		
									
	</article>


	<%@ include file="../common/C_menubar2.jsp" %>

</body>
</html>