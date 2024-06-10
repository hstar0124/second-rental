<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, com.kh.forest.product.model.vo.*, com.kh.forest.product.model.service.*"%>
<% 
	ArrayList<Rental> rentalList = (ArrayList<Rental>)request.getAttribute("rentalList");
	ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList");
	E_PageInfo pi = (E_PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int limit = pi.getLimit();
	int maxPage = pi.getMaxPage();
	int endPage = pi.getEndPage();
	int startPage = pi.getStartPage();
	int count = pi.getListCount();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>

<style> 
.DDD {
	background: #ECECEC;
	height: 35px;
	line-height: 35px;
	border: 2px solid #B8B8B8;
}

.DDD button {
	border: none;
	background: #828282;
	color: white;
	width: 90px;
	height: 25px;
cursor: Pointer;
}
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
</head>
<body onload="ready('렌탈현황', '상품관리', '렌탈현황');">
	<%@ include file="../common/C_menubar.jsp" %>

	<article class="E">
		<form action="">
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
					<td colspan="2" style="border : none; background : white;">
						<input style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
						type="submit" id="bt" value="검색">
					</td>
				</tr>
			</table>


		</form>
<div class="DDD">
		&nbsp;&nbsp;
			<label>검색결과 : </label><label class="searchCount"><%= count %> 건</label>
		</div><br><br>
		<table class="table3" id="list">
			<tr>
				<th>번호</th>
				<th>상품번호</th>
				<th>렌탈번호</th>
				<th>렌탈상태</th>
				<th>시작일자</th>
				<th>만료일자</th>
				<th>구매자</th>
			</tr>
			<!-- for!!!!!-->
			<% for(int i = 0 ; i < rentalList.size(); i++){ %>
			<tr>
				<td><%= count - (currentPage-1)*limit - i %></td>
				<td><%= rentalList.get(i).getProductNo() %></td>
				<td><%= rentalList.get(i).getRentalNo() %>
				<td><%= rentalList.get(i).getRentalStatus() %></td>
				<td><%= rentalList.get(i).getStartDate() %></td>
				<td><%= rentalList.get(i).getExpiryDate() %></td>
				<td><%= rentalList.get(i).getUserName() %>
			</tr>
			<%} %>

		</table>

		<div align="center">
			<button style="cursor: Pointer; background:white; border:none; color:purple;"
				onclick="location.href='<%=request.getContextPath() %>/rentalCondition?currentPage=1'"><<</button>
			<% if(currentPage <= 1 ){ %>
			<button disabled style="background:white; border:none; color:purple;"><</button>
			<%} else { %>
			<button style="cursor: Pointer; background:white; border:none; color:purple;"
				onclick="location.href='<%=request.getContextPath() %>/rentalCondition?currentPage=<%= currentPage - 1%>'">
				<</button>
			<% } %>

			<% for(int p = startPage; p <= endPage ; p++){ 
					if(p == currentPage){%>
						<button disabled style="background:white; border:none; color:purple;"><%= p %></button>
			<%		}else{ %>
						<button style="cursor: Pointer; background:white; border:none; color:purple;" onclick="location.href='<%=request.getContextPath() %>/rentalCondition?currentPage=<%=p %>'"><%=p %></button>
				
			<%		} 
				} %>
			<% if(currentPage >= maxPage){ %>
				<button disabled style="background:white; border:none; color:purple;"> > </button>
			<% }else {  %>
				<button style="cursor: Pointer; background:white; border:none; color:purple;" onclick="location.href='<%=request.getContextPath() %>/rentalCondition?currentPage=<%=currentPage + 1 %>'"> ></button>
			<% } %>	
			
			<button style="cursor: Pointer; background:white; border:none; color:purple;" onclick="location.href='<%=request.getContextPath() %>/rentalCondition?currentPage=<%= maxPage%>'">>></button>

		</div>
		<hr>
		
<!-- 					<input style="background : #6792DA; color : white; width : 70px; height : 25px;
						border:none; float:right;"
						 id="bt" type="button" value="등록하기"> -->
				
	</article>


	<%@ include file="../common/C_menubar2.jsp" %>
</body>
</html>