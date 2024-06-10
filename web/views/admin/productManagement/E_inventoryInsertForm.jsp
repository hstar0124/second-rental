
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.forest.product.model.vo.Category"%>
<%
	ArrayList<Category> list = (ArrayList<Category>)(request.getAttribute("list"));
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
        <form action="<%=request.getContextPath() %>/inventoryInsert" method="post" encType="multipart/form-data">
            <table class="E">
            	<tr>
                    <td class="htd" >매입번호</td>
                    <td colspan="3"><input class="vl" type="text" id="buyNo" name="buyNo" onchange="sel();"></td>
                    
                </tr>   
                <tr>
                    <td class="h"><h3>상품 기본 정보</h3></td>
                </tr>
                <tr>
                    <td class="htd">분류선택</td>
                    <td colspan="3">
                        <select id="categoryNo" name="categoryNo" class="vl">
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
                    <td colspan="3"><input class="vl" id="productName" name="productName" type="text"></td>
                </tr>                    
                <tr>
                    <td class="htd">상품번호</td>
                    <td colspan="3"><input class="vl" id="productNo" name="productNo" type="text"></td>
                    
                </tr>
                <tr>
                    <td class="htd">모델명</td>
                    <td colspan="3">
                    	<input style="width:500px"class="vl" id="buyProductName" name="buyProductName" type="text">
                    	<input type="number" id="buyProductNo" name="buyProductNo"  hidden>
                    </td>
                    
                </tr>
                <tr>
                    <td class="htd">제조사</td>
                    <td colspan="3">
                    	<input class="vl" name="manufacturerName" id="manufacturerName" type="text">
                   	 	<input type="number" id="manufacturerNo" name="manufacturerNo" hidden>
                    </td>
                </tr>
                <tr>
                    <td class="htd">상품 등급</td>
                    <td colspan="3">
                    	<input id="grade" name="grade"class="vl" type="text">
                    </td>
                </tr>
                <tr>
                    <td class="h"><h3>가격 정보</h3></td>
                </tr>

                <tr>
                        <td class="htd">시세</td>
                        <td colspan="3"><input class = "vl" type="number" id="marketprice" name="marketprice" ></td>
                </tr>
                <tr>
                    <td class="htd" >매입가</td>
                    <td colspan="3"><input class="vl" type="number"id="price" name="price"></td>
                </tr>
                
                <tr>
                    <td class="h"><h3>검수 이미지</h3></td>
                </tr>

                <tr>
                    <td class="htd">입고 이미지</td>
                    <td colspan="3">
                    	<div id="ImgArea1"><img id="inspectImg1" width="300" height="300"></div>
                    	<input class="vl" id="attachFile1" name="attachFile1"  onchange="loadImg(this,1);"type="file">
                    </td>
                </tr>
                <tr>
                    <td class="htd">손상부위 이미지</td>
                    <td colspan="3">
                    	<div id="ImgArea2"><img id="inspectImg2"width="300" height="300"></div>
                    	<input class="vl" id="attachFile2" name="attachFile2"  onchange="loadImg(this,2);"type="file">
                    </td>
                </tr>
                <tr>
                    <td class="htd">추가 이미지</td>
                    <td colspan="3">
                    	<div id="ImgArea3"><img id="inspectImg3"width="300" height="300"></div>
                    	<input class="vl"  id="attachFile3" name="attachFile3"  onchange="loadImg(this,3);"type="file">
                    </td>
                </tr>
                <tr>
                    <td class="h"><h3>관리 정보</h3></td>
                </tr>

                <tr>
                        <td class="htd">검수인</td>
                        <td colspan="3">
                        	<input name="empNo" id="empNo" hidden>
                        	<input class="vl" id="empName" name="empName" type="text">
                        </td>
                </tr>
                <tr>
                    <td class="htd">상품 관리 위치</td>
                    <td colspan="3">
                    	<input id="warehouseNo" name="warehouseNo" type="text" hidden>
                    	<input class="vl"id="warehouseName" name="warehouseName" type="text">
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
                        <textarea cols="125" rows="11" style="resize:none;" id="specialNote" name="specialNote"></textarea>
                    </td>
                </tr>
                
                <tr>
                	
                	<td id="bt" colspan="4">
                	
                	<br>
                	<br>
                	<br>
                		<input style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
                		type="submit" value="등록하기">               
                		&nbsp; &nbsp; &nbsp;
                		<input style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
                		type = "reset" value="취소하기">
                	</td>
                </tr>
            </table>
        </form>

    </div>
	<script>
		function sel(){
			var buyNo = $("#buyNo").val();
			
			$.ajax({
				url : "buyHistory",
				data : {
					buyNo : buyNo
				},
				type : "get",
				success : function(data){
 					var categoryName = decodeURIComponent(data.categoryName).replace(/\+/g, " ");
 					var categoryNo = decodeURIComponent(data.categoryNo).replace(/\+/g, " ");
					var buyProductName = decodeURIComponent(data.buyProductName).replace(/\+/g, " ") ;
					var buyProductNo = decodeURIComponent(data.buyProductNo).replace(/\+/g, " ");
					var manufacturerName = decodeURIComponent(data.manufacturerName).replace(/\+/g, " ");
					var manufacturerNo = decodeURIComponent(data.manufacturerNo).replace(/\+/g, " ");
					var grade = decodeURIComponent(data.grade).replace(/\+/g, " ");
					var marketprice = decodeURIComponent(data.marketprice).replace(/\+/g, " ");
					var price = decodeURIComponent(data.price).replace(/\+/g, " ");
					var empNo = decodeURIComponent(data.empNo).replace(/\+/g, " ");
					var empName = decodeURIComponent(data.empName).replace(/\+/g, " ");
					var warehouseNo = decodeURIComponent(data.warehouseNo).replace(/\+/g, " ");
					var warehouseName = decodeURIComponent(data.warehouseName).replace(/\+/g, " ");
					
					$("#buyProductName").val(buyProductName);
					$("#buyProductNo").val(buyProductNo);
					$("#manufacturerName").val(manufacturerName);
					$("#manufacturerNo").val(manufacturerNo);
					$("#grade").val(grade);
					$("#price").val(price);
					$("#marketprice").val(marketprice);
					$("#empNo").val(empNo);
					$("#empName").val(empName);
					$("#warehouseNo").val(warehouseNo);
					$("#warehouseName").val(warehouseName);
					$("#categoryNo").val(categoryNo);
					
					
				},
				error: function(status){
					console.log(status);
				}
			});
		}
	</script>
	 <script>
      	$(function(){
      		$("#inspectImg1").hide()
      		$("#inspectImg2").hide()
      		$("#inspectImg3").hide()
      		$("#ImgArea1").click(function(){
      			$('#attachFile1').click();
      		});
      		$("#ImgArea2").click(function(){
      			$('#attachFile2').click();
      		});
      		$("#ImgArea3").click(function(){
      			$('#attachFile3').click();
      		});
      	});
      	
      	function loadImg(value, num){
      		if(value.files && value.files[0]){
      			var reader = new FileReader();
      			reader.onload = function(e){
      				switch(num){
      				
      				case 1 : $("#inspectImg1").attr("src", e.target.result); $("#inspectImg1").show(); break;
      				case 2 : $("#inspectImg2").attr("src", e.target.result); $("#inspectImg2").show(); break;
      				case 3 : $("#inspectImg3").attr("src", e.target.result); $("#inspectImg3").show(); break;
      				}
      			}
      			reader.readAsDataURL(value.files[0]);
      		}
      	}
      </script>
</article>


	<%@ include file="../common/C_menubar2.jsp" %>
	
</body>
</html>