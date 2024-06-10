
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.forest.product.model.vo.*"%>
<%
	ArrayList<Category> list = (ArrayList<Category>)(request.getAttribute("list"));
	ArrayList<ProductAttachment> selectOneAttach = (ArrayList<ProductAttachment>)(request.getAttribute("selectOneAttach"));
	Product selectOne = (Product)(request.getAttribute("selectOne"));
%>
<!DOCTYPE html>
<html>
<head>
<style>
    .E {  
    	width : 100%;
       background: white;
       	
    }
    .E h3{
    	color:black;
    	width:120px;
    }
   .h{
    	color : black;
    }
    .E td{
        font-size : 14px;
        background : white;
    }
    .E .htd{
        text-align: center;
        background: #E8E8E8;
        width:120px;
    }
    .vl{
    	margin-left : 10px;
    }
    #bt{
    	text-align : center;
    }
    .E td:not(:first-child):not(.htd){
    	border : 1px solid #E8E8E8;
    	border-left:none;
    }
    input[type=text]{
    	border : none;
    }
    input[type=number]{
    	border : none;
    }
    select{
    	width : 100px;
    	height : 22px;
    }
    
    

</style>
<meta charset="UTF-8">
<title>중고구마</title>
</head>
<body onload="ready('재고등록', '상품관리', '재고등록');">
	<%@ include file="../common/C_menubar.jsp" %>
	<article>
    <div>  
        <form action="<%=request.getContextPath() %>/updateInventory" method="post">
            <table class="E">
            	<tr>
                    <td class="htd" >매입번호</td>
                    <td colspan="3"><input class="vl" type="text" id="buyNo" name="buyNo" readonly value="<%= selectOne.getBuyNo() %>"></td>
                </tr>
                <tr>
                    <td class="h"><h3>상품 기본 정보</h3></td>
                </tr>
                <tr>
                    <td class="htd">분류선택</td>
                    <td colspan="3">
                        <select name="categoryNo" id="categoryNo" class="vl">
                            <option >분류</option>
                            <% for(int i = 0 ; i < list.size() ; i++){ %>
                            <option  id="<%= list.get(i).getCategoryName() %>" value="<%= list.get(i).getCategoryNo() %>">
                            	<%= list.get(i).getCategoryName() %>
                            </option>
                            <% } %>
                        </select>
                    </td>
                    
                </tr>
                <tr>
                    <td class="htd">상품명</td>
                    <td colspan="3"><input class="vl" id="productName" name="productName" type="text" readonly value="<%=selectOne.getProductName() %>"></td>
                </tr>                    
                <tr>
                    <td class="htd">상품번호</td>
                    <td colspan="3"><input class="vl" id="productNo" name="productNo" type="text" readonly value="<%= selectOne.getProductNo() %>"></td>
                    
                </tr>
                <tr>
                    <td class="htd">모델명</td>
                    <td colspan="3">
                    	<input style="width:500px"class="vl" id="buyProductName" name="buyProductName" type="text" value="<%=selectOne.getBuyProductName()%>" readonly>
                    	<input type="number" id="buyProductNo" name="buyProductNo"  hidden>
                    </td>
                    
                </tr>
                <tr>
                    <td class="htd">제조사</td>
                    <td colspan="3">
                    	<input class="vl" name="manufacturerName" id="manufacturerName" type="text" readonly value="<%= selectOne.getManufacturerName() %>">
                   	 	<input type="number" id="manufacturerNo" name="manufacturerNo" hidden>
                    </td>
                </tr>
                <tr>
                    <td class="htd">상품 등급</td>
                    <td colspan="3">
                    	<select class="vl" id="grade" name="grade">
                    		<option>등급</option>
                    		<option value="S">S</option>
                    		<option value="A">A</option>
                    		<option value="B">B</option>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td class="h"><h3>가격 정보</h3></td>
                </tr>
                <tr>
                        <td class="htd">시세</td>
                        <td colspan="3"><input class = "vl" type="number" id="marketprice" name="marketprice" value="<%=selectOne.getMarketprice()%>" readonly></td>
                </tr>
                <tr>
                    <td class="htd" >매입가</td>
                    <td colspan="3"><input class="vl" type="number"id="price" name="price" value="<%=selectOne.getBuyPrice()%>" readonly></td>
                </tr>
                <tr>
                    <td class="h"><h3>검수 이미지</h3></td>
                </tr>
					
                <tr>
                    <td class="htd">입고 이미지</td>
                    <td colspan="3">
                    	<div id="ImgArea1">
                    		<%if(selectOneAttach.size()>=1){ %>
                    		<img id="inspectImg1" width="300" height="300" src="<%=request.getContextPath()%>/image/inspectImg/<%=selectOneAttach.get(0).getChangeName()%>">
                    		<%}%>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td class="htd">손상부위 이미지</td>
                    <td colspan="3">
                    	<div id="ImgArea2">
                    		<%if(selectOneAttach.size()>=2){ %>
                    			<img id="inspectImg1" width="300" height="300" src="<%=request.getContextPath()%>/image/inspectImg/<%=selectOneAttach.get(1).getChangeName()%>">
                    		<%}%>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td class="htd">추가 이미지</td>
                    <td colspan="3">
                    	<div id="ImgArea3">
                    		<%if(selectOneAttach.size()>=3){ %>
                    			<img id="inspectImg1" width="300" height="300" src="<%=request.getContextPath()%>/image/inspectImg/<%=selectOneAttach.get(2).getChangeName()%>">
                    		<%}%>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td class="h"><h3>관리 정보</h3></td>
                </tr>

                <tr>
                        <td class="htd">검수인</td>
                        <td colspan="3">
                        	<input name="empNo" id="empNo" hidden>
                        	<input class="vl" id="empName" name="empName" type="text" readonly value="<%=selectOne.getEmpName()%>">
                        </td>
                </tr>
                <tr>
                    <td class="htd">상품 관리 위치</td>
                    <td colspan="3">
                    	<input id="warehouseNo" name="warehouseNo" type="text" hidden>
                    	<select class="vl"id="warehouseName" name="warehouseName">
                    		<option>위치</option>
                    		<option value="10">A1</option>
                    		<option value="20">A2</option>
                    		<option value="30">B1</option>
                    		<option value="40">B2</option>
                    		<option value="50">B3</option>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td class="h"><h3>특이사항</h3></td>
                </tr>
                <tr>
                    <td class="htd" rowspan="2">특이사항</td>
                    <td colspan="3" align="center" style="background:gray;">아래에 내용을 적어 주세요</td>
                </tr>
                <tr>
                    <td colspan="3">
                        <textarea cols="125" rows="11" style="resize:none;" id="specialNote" name="specialNote"><%= selectOne.getSepcialNote() %></textarea>
                    </td>
                </tr>
                
                <tr>
                	
                	<td id="bt" colspan="4">
                	
                	<br>
                	<br>
                	<br>
                		<input style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
                		type="submit" value="수정하기">               
                		&nbsp; &nbsp; &nbsp;
                		<input style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
                		type = "reset" value="확인" onclick="history.back()">
                	</td>
                </tr>
            </table>
        </form>

    </div>
	<script>
		$(function(){
			var categoryNo = <%= selectOne.getCategoryNo() %>;
			var warehouseNo = <%= selectOne.getWarehouseNo()%>;
			var grade = '<%= selectOne.getGrade() %>';
			
			$("#categoryNo").val(categoryNo);
			$("#warehouseName").val(warehouseNo);
			$("#grade").val(grade);
		});
	</script>


</article>


	<%@ include file="../common/C_menubar2.jsp" %>
	
</body>
</html>