<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.forest.product.model.vo.*, com.kh.forest.product.model.service.*"%>
<% 
	ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
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
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="ready('상품 리스트', '상품관리', '상품리스트');">
	<%@ include file="../common/C_menubar.jsp" %>

	<article class="E">
		<form action="searchingProduct">
			<table class="table1" style="border: 10px">
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
					<td colspan="2" style="border: none; background: white;"><input
						style="background: #6792DA; color: white; width: 70px; height: 25px; border: none;"
						type="submit" id="bt" value="검색"></td>
				</tr>
			</table>


		</form>
		<table class="table2">
			<td style="border : 1px solid gray; background : #ECECEC;">검색결과 : <span><<%= count %>>건</span> 전체 상품 : <span><<%= productCount %>>건</span></td>
		</table>
		
		<form action="deleteProduct" id="deleteProduct">
		<table class="table3">
			<tr><th><input type="checkbox" id="checkall"></th>
				<th>번호</th>
				<th>상품번호</th>
				<th style="width:200px;">상품명</th>
				<th style="width:200px;">모델명</th>
				<th>렌탈가(한달/두달이상)</th>
				<th>상세</th>

			</tr>
			<% for(int i = 0 ; i < productList.size() ; i++){ %>
			<% int price2 = Integer.parseInt(productList.get(i).getRentalPrice())+20000; %>
			<tr>
				<td><input type="checkbox" name="deleteProductNo" value="<%=productList.get(i).getProductNo() %>"></td>
				<td><%= count - (currentPage-1)*limit - i %></td>
				<td><%=productList.get(i).getProductNo() %></td>
				<td>
					<% if(productList.get(i).getTemp()!=null){%>
					<img width=100; height=100; src="/forest/image/productImg/<%=productList.get(i).getTemp()%>">
					<%} %>
					<br>
					<%=productList.get(i).getProductName()%>

				</td>
				
				<td><%=productList.get(i).getBuyProductName() %></td>
				<td><%=price2 %>/<br><%=productList.get(i).getRentalPrice() %></td>
				<td>
					<img class="detail" style="width:23px; height:23px; margin:0"src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px">
				</td>
			</tr>
			<%} %>
		</table>
		</form>
		<form action="searchingProduct" id="searchingProduct">
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
		<br>
		일괄처리
		<br>

		
		<table class="table2">
			<td style="border : 1px solid gray; background : #ECECEC;">
				<button style="margin-left : 10px; width : 70px;" onclick="deleteProduct();">삭제</button>
			</td>
		</table>
									
	</article>
	
	<script>
		function deleteProduct(){
			$("#deleteProduct").submit();
		}
	</script>
	<script>
		$(document).ready(function(){
	    	$("#checkall").click(function(){
	        	if($("#checkall").prop("checked")){
	           		$("input[name=deleteProductNo]").prop("checked",true);
	       		}else{
	           		$("input[name=deleteProductNo]").prop("checked",false);
	        	}
	    	})
		})
	</script>
	<script>
		function changeCurrentPage(num){
			$("#currentPage").val(num);
			$("#searchingProduct").submit();
		}
	</script>
	<script>
		$(".detail").click(
			function test(){
				var productNo = $(this).parent().parent().children().eq(2).text();
					
				location.href='<%= request.getContextPath() %>/selectProductDefault?productNo='+productNo;
		});
	</script>

	<%@ include file="../common/C_menubar2.jsp" %>

</body>
</html>