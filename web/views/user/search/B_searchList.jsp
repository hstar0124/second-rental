<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.ArrayList, 
    		java.util.HashMap,	
    		com.kh.forest.product.model.vo.Product"%>
<%
	
	ArrayList<HashMap<String, Object>> photoList = (ArrayList<HashMap<String, Object>>) request.getAttribute("photoList");
	
	
%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	/*--------상품리스트---------*/
	
	#section{
	    width: 1079px; 
	    height: 1600px;
	    margin: 0 auto;
	}
	
	.title{
	    display: flex;
	    margin-top: 10px;
	    margin-top: 50px;
	    height: 50px;
	    
	}
	
	/*카테고리선택영역*/
	.select-table-div{
		height: 200px;
	}
	.select-table{
	    margin-top: 10px;
	    
	    width: 1079px;
	    height: 194px;
	    border: 1px solid #BABABA;
	    
	    
	    text-align: center;
	
	}
	.select-table td{
	    
	    width: 134px;
	    height: 97px;
	}
	.select-table div{
	    
	    
	    border: 2px solid #BABABA;
	    
	    border-radius: 10px;
	    width: 100px;
	    margin: 0 auto;
	    color: #828282;
	}
	
	/* div onclick시 적용 css 
	.select-table div:nth-child(1){
	    background: #6E00AB;
	    border: 2px solid #6E00AB;
	    box-sizing: border-box;
	    border-radius: 19px;
	    color:white;
	} */
	
	/*총상품안내영역*/
	.sub-title{
		height: 54px;
	}
	.sub-table{
	    position: absolute;
	    width: 1079px;
	    height: 53.03px;
	    
	     top: 528px;  
	    border-bottom: 1px solid #BABABA;
	}
	.sub-td1{
	    text-align: left;
	}
	.sub-td2{
	    text-align: right;
	}
	.sub-td2>select{
	    width: 113.74px;
	    height: 38.43px;
	    font-size: 15px;
	}
	
	/*------상품리스트1------*/
	.productList-area{
		align: center;
		height: 1094px;
		width: 1052px;
		overflow: hidden;
		margin: 0 auto;
	}
	.productList{
		float: left;
		position: relative;
		margin-top: 50px;
		margin-right: 30px;
		height: 330px;
		width: 233px;
		cursor: pointer;
	}
	.product-tr{
		
    	display: inline-block;
	}
	
 	.product-list1{
	    
	    width: 250px;
	    height: 324px;
	    top: 651px;
	
	} 
	.sub-title1{
	    position: absolute;
	    width: 1440px;
	    height: 51.64px;    
	    top: 900px;
	}
	.section-product1{
	    position: absolute;
	    width:1440px;    
	    top: 1006px;
	}
	.section-product1>table{
	    position: absolute;
	    width: 1114px;
	    height: 324px;   
	    left: 155px;
	   
	}
	.tr-1>td{
	    align-items: center;
	    width: 242px;
	    height: 181px;  
	    margin: 0px;
	}
	.tr-2>td>p{
	    
	    font-weight: 900;
	    font-size: 18px;
	}
	.tr-2>td{
	    width: 242px;
	    height: 10px;
	}
	.tr-3>td{
	    width: 242px;
	    height: 30px;
	}
	
	/*-----상품리스트2----*/
	.product-list2{
	    position: absolute;
	    width: 1114px;
	    height: 324px;
	    
	    top: 1110px;
	
	}
	.sub-title2{
	    position: absolute;
	    width: 1440px;
	    height: 51.64px;    
	    top: 1414px;
	}
	.section-product2{
	    position: absolute;
	    width:1440px;    
	    top: 1515px;
	}
	.section-product2>table{
	    position: absolute;
	    width: 1114px;
	    height: 324px;   
	    left: 155px;
	   
	}
	.tr2-1>td{
	    align-items: center;
	    width: 242px;
	    height: 181px;  
	    margin: 0px;
	}
	.tr2-2>td>p{
	    
	    font-weight: 900;
	    font-size: 18px;
	}
	.tr2-2>td{
	    width: 242px;
	    height: 10px;
	}
	.tr2-3>td{
	    width: 242px;
	    height: 30px;
	}
	
	/*페이징*/
	.paging-area{
	    position: relative;
	    width: 1114px;
	    text-align: center;
	    margin: 0 auto;
	    height: 23px;
	    
	    top: 1300px;
	    align-content: center;
	    
	}
	.paging{
	    display: flex;
	    position: absolute;
	    width: 200px;
	    left: 400px;
	    
	}
	.paging>p{
	    margin: 10px;
	}
	.paging>p:nth-child(2){
	    text-decoration-line: underline;
	    color: #6E00AB;
	    font-weight: bold;
	} 
</style>
</head>
<body>
	<%@ include file="/views/user/common/B_UserMainHeader.jsp" %>
   
	   <!-- 세션시작 -->
	<section id="section">
	
	    <div class="title">
	        <p>메인</p>&nbsp;<p>></p>&nbsp;<p>검색</p>&nbsp;<p>></p>&nbsp;<p><b>상품 검색결과</b></p>
	    </div>
	    
	    <div class="select-table-div">
	        <table class="select-table">
	            <!-- 카테고리 각 영역 클릭시 div 색 변화 -->
	            <tr class="table-tr">
	                <td>상품상태</td>
	                <td><div id="canRantal">렌탈가능</div></td>
	                <td><div id="rantaling">렌탈중</div></td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	            </tr>
	        </table>
	    </div>
	        
	    <div class="sub-title">
	        <table class="sub-table">
	            <tr>
	                <td class="sub-td1">
	                   <!--  <p>총 12개의 상품이 있습니다.</p> -->
	                </td>
	                <td class="sub-td2">
	                    <select>
	                        <option value="newest">최신순</option>
	                        <option value="low">낮은가격순</option>
	                        <option value="high">높은가격순</option>
	                    </select>
	                </td>
	            </tr>
	        </table>
	    </div>      
	    
	    <div class="productList-area">
	    	<% for(int i = 0; i < photoList.size(); i++) { 
	 				HashMap<String, Object> hmap = photoList.get(i); 
			%>
		    <div class="productList">
		        <table class="product-list1">
		            <tr class="product-tr tr-1">
		                <td>
		                	<img src="/forest/image/productImg/<%=hmap.get("changeName") %>" width="242px" height="230px">
		                	 <span style="display:none"><%= hmap.get("productNo") %></span>
		                </td>
		            </tr>
		            <tr class="product-tr tr-2">
		                <td>&nbsp;<%=hmap.get("manufacturerName") %></td>
		            </tr>
		            
		            <tr class="product-tr tr-3">
		                <td>&nbsp;<%=hmap.get("productName") %></td>
		            </tr>
		            
		            <tr class="product-tr tr-3">
		                <td>&nbsp;<%=hmap.get("rentalPrice") %>원</td>
		            </tr>
		        </table> 
		    </div>
	        <% } %>
	    </div>    

 	<script>
    	$(".product-list1 tr td").click(function(){
			console.log($(this).find("span").html());
			var productNo = $(this).find("span").html();
			//console.log(productNo.length);
			
			if(productNo.length > 5){
				location.href='<%=request.getContextPath() %>/selectOneDetail?proNum=' + productNo;
			}
    	});	   	
    	
   	</script>
<!-- 	
	    <div class="paging-area">
	        <div class="paging">
	            <p><</p>
	            <p>1</p>
	            <p>2</p>
	            <p>3</p>
	            <p>4</p>
	            <p>5</p>
	            <p>></p>
	        </div>
	
	    </div> -->
	
	
	</section>
	<!-- 세션끝 -->

   
   <%@ include file="/views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>