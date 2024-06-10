<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.forest.product.model.vo.*, com.kh.forest.product.model.service.*"%>
<% 
	ArrayList<Product> inventorylist = (ArrayList<Product>)request.getAttribute("productList");
	ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList");
	E_PageInfo pi = (E_PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int limit = pi.getLimit();
	int maxPage = pi.getMaxPage();
	int endPage = pi.getEndPage();
	int startPage = pi.getStartPage();
	int count = pi.getListCount();
	int productCount = (int)request.getAttribute("productCount");
	String categoryNo = (String)request.getAttribute("categoryNo");
	String select = (String)request.getAttribute("select");
	String value = (String)request.getAttribute("value");
	String productStatus = (String)request.getAttribute("productStatus");
%>
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
    select{
    	width : 100px;
    	height : 22px;
    }
    #bt{
		margin : 20px;
    }
	.table1 td:nth-child(2)  {
		background: rgb(247, 247, 247);

	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="ready('상품 재고관리', '상품관리', '상품 재고관리');">
	<%@ include file="../common/C_menubar.jsp" %>

	<article class="E">
		<form action="serchingInventory">
			<table class="table1" style="border : 10px">
				<tr>
                    <td class="htd">분류선택</td>
                    <td colspan="3">
                        <select name="categoryNo" id="categoryNo" class="vl">
                            <option value="0" >분류</option>
                            <% for(int i = 0 ; i < categoryList.size() ; i++){ %>
                            <option  id="<%= categoryList.get(i).getCategoryName() %>" value="<%= categoryList.get(i).getCategoryNo() %>">
                            	<%= categoryList.get(i).getCategoryName() %>
                            </option>
                            <% } %>
                        </select>
                    </td>
                    
                </tr>
				<tr>
					<td class="htd">검색어</td>
					<td>
					<select name="select" class="vl">
							<option class="vl" value="all">전체</option>
							<option value="productNo">상품번호</option>
							<option value="productName">상품명</option>
							<option value="buyProducName">모델명</option>
					</select> 
					<input class="vl" type="text" name="value"></td>
				</tr>
				<tr>
					<td class="htd">상태</td>
					<td>
					<input class="vl" type="radio" value="A" name="productStatus" id="statusA">
					<label for="statusA">렌탈중</label> 
					<input class="vl" type="radio" value="B" name="productStatus" id="statusB">
					<label for="statusB">보유중</label>
					<input class="vl" type="radio" value="C" name="productStatus" id="statusC">
					<label for="statusC">수리중</label>
					<input class="vl" type="radio" value="D" name="productStatus" id="statusD">
					<label for="statusD">인수됨</label>
					<input class="vl" type="radio" value="E" name="productStatus" id="statusE">
					<label for="statusE">임시대여중</label>
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
		<table class="table2" >
			<td style="border : 1px solid gray; background : #ECECEC;">검색결과 : <span><<%=count %>>건</span> 전체 상품 : <span><<%=productCount %>>건</span></td>
		</table>

		<table class="table3" id="list">
			<tr>
				<th>번호</th>
				<th>상품번호</th>
				<th>상품명</th>
				<th>입고일</th>
				<th>상태</th>
				<th>검수인</th>
				<th>위치</th>
				<th>홈페이지 <br>등록 여부</th>
				<th>상품등록</th>
				<th>상세</th>
			</tr>
			<!-- for!!!!!-->
			<% for(int i = 0 ; i < inventorylist.size(); i++){ %>
			<tr>
				<td><%= count - (currentPage-1)*limit - i %></td>
				<td><%= inventorylist.get(i).getProductNo() %></td>
				<td><%= inventorylist.get(i).getBuyProductName() %></td>
				<td><%= inventorylist.get(i).getProductEnrolldate() %></td>
				<td><%= inventorylist.get(i).getProductStatus() %></td>
				<td><%= inventorylist.get(i).getEmpName() %>
				<td><%= inventorylist.get(i).getWarehouseName() %>
				<td><%= inventorylist.get(i).getHompageUpdate() %>
				<td>
					<%if(inventorylist.get(i).getHompageUpdate().equals("N")){ %>
					<div class="insert" style="margin:0 auto; background : #6792DA; color : white; width : 70px; height : 25px; border:none;">
						등록
					</div>
					<%} %>
				</td>
				<td>
					<img class="detail" style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px">
				</td>
			</tr>
			<%} %>

		</table>
		<form action="serchingInventory" id="searchingInventory">
			<table hidden>
			<tr>
				<td>
					<input type="text" name="categoryNo" value="<%=categoryNo%>">
					<input type="text" name="select" value="<%=select %>">
					<input type="text" name="value" value="<%=value %>">
					<input type="text" name="productStatus" value="<%=productStatus%>">
					<input type="number" id="currentPage" name="currentPage">
				
				</td>
			</tr>
			</table>
		</form>
		<div align="center">
			<button
				onclick="changeCurrentPage(1);"><<</button>
			<% if(currentPage <= 1 ){ %>
			<button disabled><</button>
			<%} else { %>
			<button
				onclick="changeCurrentPage(<%= currentPage - 1%>);">
				<</button>
			<% } %>

			<% for(int p = startPage; p <= endPage ; p++){ 
					if(p == currentPage){%>
						<button disabled><%= p %></button>
			<%		}else{ %>
						<button onclick="changeCurrentPage(<%=p %>);"><%=p %></button>
				
			<%		} 
				} %>
			<% if(currentPage >= maxPage){ %>
				<button disabled> > </button>
			<% }else {  %>
				<button onclick="changeCurrentPage(<%=currentPage + 1 %>);"> ></button>
			<% } %>	
			
			<button onclick="changeCurrentPage(<%= maxPage%>);">>></button>

		</div>
		<hr>
		
<!-- 					<input style="background : #6792DA; color : white; width : 70px; height : 25px;
						border:none; float:right;"
						 id="bt" type="button" value="등록하기"> -->
				
	</article>

		<script>
		$(".detail").click(
		function test(){
			var productNo = $(this).parent().parent().children().eq(1).text();
			
			location.href='<%= request.getContextPath() %>/selectOne?productNo='+productNo;
		});
		$(".insert").click(
				function(){
					var productNo = $(this).parent().parent().children().eq(1).text();
					location.href='<%= request.getContextPath() %>/selectProductDefault?productNo='+productNo;
		});
	
	</script>
	<script>
		function changeCurrentPage(num){
			$("#currentPage").val(num);
			$("#searchingInventory").submit();
		}
	</script>
	<%@ include file="../common/C_menubar2.jsp" %>

</body>
</html>