<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import= "java.util.ArrayList, com.kh.forest.product.model.vo.Category, 
	com.kh.forest.product.model.vo.*"
	%>
	
<%
	Product productDefault = (Product)(request.getAttribute("productDefault"));
	ArrayList<ProductAttachment> productDefaultAttach = (ArrayList<ProductAttachment>)(request.getAttribute("productDefaultAttach"));
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
    	border : 1px solid gray;
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
<body onload="ready('상품등록', '상품관리', '상품등록');">
	<%@ include file="../common/C_menubar.jsp" %>

	<article> 
    <div> 
        <form action="productInsert" method="post" encType="multipart/form-data">
            <table class="E">
                <tr>
                    <td class="h"><h3>상품 기본 정보</h3></td>
                </tr>
                <tr>
                    <td class="htd">분류선택</td>
                    <td colspan="3">
                        <select class="vl">
                            <option>분류</option>
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
                    <td colspan="3">
                    	<input class="vl" type="text" name="productName" value="<%=productDefault.getProductName()%>">
                    </td>
                </tr>                    
                <tr>
                    <td class="htd">상품번호</td>
                    <td colspan="3">
                    	<input class="vl" type="text" name="productNo" value="<%=productDefault.getProductNo()%>" readonly>
                    </td>
                    
                </tr>
                <tr>
                    <td class="htd">모델명</td>
                    <td colspan="3">
                    	<input class="vl" type="text" value="<%=productDefault.getBuyProductName()%>" readonly>
                    </td>
                </tr>
                <tr>
                    <td class="htd">제조사</td>
                    <td colspan="3">
                    	<input class="vl" type="text" value="<%=productDefault.getManufacturerName()%>" readonly>
                    </td>
                </tr>
<!-- 				<tr hidden>
					<td class="htd">배송비 설정</td>
					<td>
						<input type="radio" name="1"><label> 기본 배송비 적용</label><br>
						<span style="font-size: 12px; color : blue">
							* 현재 기본 배송 정책 : 어쩌구 저쩌구 안보여서 못씀<br><br></span>
						<input type="radio" name="1"><label> 직접 입력하기</label><br>
						<input class="vl" type="number" border="1px solid black;">
					</td>
				</tr> -->

                <tr>
                    <td class="h"><h3>가격 정보</h3></td>
                </tr>
				<tr>
					<td class="htd">렌탈가격</td>
					<td colspan="3">
						<input class = "vl" type="number" name="price" value="<%=productDefault.getRentalPrice()%>">
					</td>
			</tr>
                <tr>
                        <td class="htd">시세</td>
                        <td colspan="3"><input class = "vl" type="text" value="<%=productDefault.getMarketprice()%>" readonly></td>
                </tr>
                <tr>
                    <td class="htd">매입가</td>
                    <td colspan="3"><input class="vl" type="text" value="<%=productDefault.getBuyPrice()%>" readonly></td>
                </tr>
                
                <tr>
                    <td class="h"><h3>상품 이미지</h3></td>
                </tr>

                <tr>
                    <td class="htd">대표 이미지</td>
                    <td colspan="3">
                    	<input class="vl" id="attachFile1" name="attachFile1"  onchange="loadImg(this,1);" type="file">
                    	<div id="ImgArea1"><img id="productImg1" width="300" height="300"
                    	<% if(productDefaultAttach.get(0).getChangeName()!=null){ %>
                    		src=<%= request.getContextPath()+"/image/productImg/"+productDefaultAttach.get(0).getChangeName() %>
                    	<% }%>
                    	></div>
                    </td>
                </tr>
                <tr>
                    <td class="htd">기본 이미지</td>
                    <td colspan="3">
                    	<input class="vl" id="attachFile2" name="attachFile2"  onchange="loadImg(this,2);" type="file">
                    	<div id="ImgArea2"><img id="productImg2" width="300" height="300"
                    	<% if(productDefaultAttach.get(1).getChangeName()!=null){ %>
                    		src=<%= request.getContextPath()+"/image/productImg/"+productDefaultAttach.get(1).getChangeName() %>
                    	<% }%>
                    	></div>
                    </td>
				</tr>
				<tr>
                    <td class="htd">기본 이미지</td>
                    <td colspan="3">
                    	<input class="vl" id="attachFile3" name="attachFile3"  onchange="loadImg(this,3);" type="file">
                    	<div id="ImgArea3"><img id="productImg3" width="300" height="300"
                    	<% if(productDefaultAttach.get(2).getChangeName()!=null){ %>
                    		src=<%= request.getContextPath()+"/image/productImg/"+productDefaultAttach.get(2).getChangeName() %>
                    	<% }%>
                    	></div>
                    </td>
				</tr>
				 <tr>
                    <td class="htd">기본 이미지</td>
                    <td colspan="3">
                    	<input class="vl" id="attachFile4" name="attachFile4"  onchange="loadImg(this,4);" type="file">
                    	<div id="ImgArea4"><img id="productImg4" width="300" height="300"
                    	<% if(productDefaultAttach.get(3).getChangeName()!=null){ %>
                    		src=<%= request.getContextPath()+"/image/productImg/"+productDefaultAttach.get(3).getChangeName() %>
                    	<% }%>
                    	></div>
                    </td>
				</tr>
                <tr>
                    <td class="h"><h3>상세 정보</h3></td>
                </tr>

                <tr>
                        <td class="htd">개봉 여부</td>
						<td colspan="1">
							<input class="vl open" name="open" id="open1" type="radio" value="A"><label for="open1">개봉</label>
							<input class="vl open" name="open" id="open2" type="radio" value="B"><label for="open2">미개봉</label>
						</td>
						<td class="htd">사용감</td>
						<td colspan="1">
							<input class="vl used" name="used" id="used1" type="radio" value="A"><label for="used1">적음</label>
							<input class="vl used" name="used" id="used2" type="radio" value="B"><label for="used2">보통</label>
							<input class="vl used" name="used" id="used3" type="radio" value="C"><label for="used3">많음</label>
						</td>
				</tr>
				<tr>
					<td class="htd">상품등급</td>
					<td colspan="1">
						<select class="vl" id="grade" name="grade">
                    		<option>등급</option>
                    		<option value="S">S</option>
                    		<option value="A">A</option>
                    		<option value="B">B</option>
                    	</select>
					</td>
					<td class="htd">파손여부</td>
					<td colspan="1">
						<input class="vl col" name="col" id="col1" type="radio" value="A"><label for="col1">적음</label>
						<input class="vl col" name="col" id="col2" type="radio" value="B"><label for="col2">보통</label>
						<input class="vl col" name="col" id="col3" type="radio" value="C"><label for="col3">많음</label>
					</td>
				</tr>
				<tr>
					<td class="htd">수리 여부</td>
					<td colspan="3">
						<input class="vl as" name="as" id="as1" type="radio" value="A"><label for="as1">적음</label>
						<input class="vl as" name="as" id="as2" type="radio" value="B"><label for="as2">보통</label>
						<input class="vl as" name="as" id="as3" type="radio" value="C"><label for="as3">많음</label>
					</td>
				</tr>
				
                <tr>
                    <td class="htd" rowspan="2">상세 설명 및  제품 사양</td>
                    <td colspan="3" align="center" style="background:gray;">아래에 내용을 적어 주세요</td>
                </tr>
                <tr>
                    <td colspan="3">
                        <textarea cols="125" rows="11" style="resize:none;" id="detail" name="detail"></textarea>
                    </td>
				</tr>
				<tr>
					<td class="h"><h3>공통 안내문구</h3></td>
				</tr>
				<tr>
					<td class="htd">유의사항</td>
					<td colspan="3">
						<input type="radio" class="vl" name="note" id="note1" checked value="Y"><label for="note1">사용함</label>
						<input type="radio" class="vl" name="note" id="note2" value="N"><label for="note2">사용하지않음</label>
					</td>
                </tr>
				<tr>
					<td class="htd">배송정보</td>
					<td colspan="3">
						<input type="radio" class="vl" name="del" id="del1" checked value="Y"><label for="del1">사용함</label>
						<input type="radio" class="vl" name="del" id="del2" value="N"><label for="del2">사용하지않음</label>
					</td>
				</tr>
                	<td id="bt" colspan="4">
                	<br>
                	<br>
                	<br>
                		<input style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
                		type="submit" value="등록하기">               
                		<input style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
                		type = "button" value="취소하기" onclick="history.back();">
                	<br>
                	<br>
                	<br>
                	<br>
                	<br>
                	<br>
                	</td>
                </tr>
            </table>
        </form>

    </div>

	 <script>
      	$(function(){
        	<% if(productDefaultAttach.get(0).getChangeName()==null){ %>
      		$("#productImg1").hide()
	    	<% }%>
        	<% if(productDefaultAttach.get(1).getChangeName()==null){ %>
      		$("#productImg2").hide()
	    	<% }%>
        	<% if(productDefaultAttach.get(2).getChangeName()==null){ %>
      		$("#productImg3").hide()
	    	<% }%>
        	<% if(productDefaultAttach.get(3).getChangeName()==null){ %>
      		$("#productImg4").hide()
	    	<% }%>
      		$("#ImgArea1").click(function(){
      			$('#attachFile1').click();
      		});
      		$("#ImgArea2").click(function(){
      			$('#attachFile2').click();
      		});
      		$("#ImgArea3").click(function(){
      			$('#attachFile3').click();
      		});
      		$("#ImgArea4").click(function(){
      			$('#attachFile4').click();
      		});
      	});
      	
      	function loadImg(value, num){
      		if(value.files && value.files[0]){
      			var reader = new FileReader();
      			reader.onload = function(e){
      				switch(num){
      				case 1 : $("#productImg1").attr("src", e.target.result); $("#productImg1").show(); break;
      				case 2 : $("#productImg2").attr("src", e.target.result); $("#productImg2").show(); break;
      				case 3 : $("#productImg3").attr("src", e.target.result); $("#productImg3").show(); break;
      				case 4 : $("#productImg4").attr("src", e.target.result); $("#productImg4").show(); break;
      				}
      			}
      			reader.readAsDataURL(value.files[0]);
      		}
      	}
      </script>
      	<script>
		$(function(){
			var categoryNo = <%= productDefault.getCategoryNo() %>;
			var grade = '<%= productDefault.getGrade() %>';
			
			$("#categoryNo").val(categoryNo);
			$("#grade").val(grade);
		});
	</script>
	
	<script>
		$(function(){
			var details = "<%=productDefault.getProductDetail().replaceAll(System.getProperty("line.separator"),"|") %>";
			var detailList = details.split('&');
			var open = detailList[0];
			var used = detailList[1];
			var col = detailList[2];
			var as = detailList[3];
			var detail = detailList[4];
			var note="<%=productDefault.getProductNotice()%>"
			var del="<%=productDefault.getDeliveryInfo()%>"
			var proSpec = detail.split("|");      
		      for(var i = 0 ; i < proSpec.length; i++){
		          $("#detail").val($("#detail").val() + proSpec[i] +'\n');
		       }
			$("input:radio[name='open']:input[value='"+open+"']").attr("checked",true);
			$("input:radio[name='used']:input[value='"+used+"']").attr("checked",true);
			$("input:radio[name='col']:input[value='"+col+"']").attr("checked",true);
			$("input:radio[name='as']:input[value='"+as+"']").attr("checked",true);
			/* $("#detail").val(detail); */
			$("input:radio[name='note']:input[value='"+note+"']").attr("checked",true);
			$("input:radio[name='del']:input[value='"+del+"']").attr("checked",true);
		});
	</script>
</article>


	<%@ include file="../common/C_menubar2.jsp" %>
	
</body>
</html>