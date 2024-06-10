<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList, 
    		java.util.HashMap,	
    		com.kh.forest.product.model.vo.Product"%>
<%
	ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) request.getAttribute("list");

%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
/*------mainpageSection------*/
	#section{
	    height: 1700px;
	   
	}
/* 헤더이미지 */
	.slide-photo>input[type=image]{    
	    position: absolute;
	    width: 1440px;
	    height: 467px;   
	}
	.sub-img{
	    width: 1440px;
	    height: 140px;
	    margin-bottom: 10px;
	    margin-top: 30px;
	}
	.sub-img>input{
		cursor: default;
	}
	/*배너영역*/
	.container{
	
	}
	/*새로나온 상품 */
	
	.sub-title1{
	    width: 1440px;
	    height: 60px;    
	    
	}
	.sub-title1>input{
	    cursor: default;
	
	}
	.section-product1{
		height: 330px;
	    width:1114px;    
	    display:flex;
	    overflow: hidden;
	    margin:0 auto;
	    margin-top: 50px;
	    cursor:pointer;
	}
	.productList{
		width: 242px;
		height: 330px;
		margin-right: 35px;
	
	}
	.section-product1>table{
	    
	    width: 1114px;
	    height: 324px;   
	    
	   
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

	
	
	
	
	/*추천 상품 */
	.sub-title2{
	    position: absolute;
	    width: 1440px;
	    height: 51.64px;    
	    top: 1414px;
	    
	}
	.sub-title2>input{
		cursor: default;
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
	/*----------------------*/
	.dot {
	  height: 4px;
	  width: 20px;
	  margin: 0 2px;
	  background-color: #bbb;
	  /* border-radius: 50%; */
	  display: inline-block;
	  transition: background-color 0.6s ease;
	}
	/* Fading animation */
	.fade {
	  -webkit-animation-name: fade;
	  -webkit-animation-duration: 1.5s;
	  animation-name: fade;
	  animation-duration: 1.5s;
	}
	.mySlides {display: none;}
	img {vertical-align: middle;}

	/* Slideshow container */
	.slideshow-container {
	  max-width: 1440px;
	  height: 470px;
	  
	  margin: auto;
	  margin-top:50px;
	  
	}


	/* Number text (1/3 etc) */
	.numbertext {
	  color: #f2f2f2;
	  font-size: 12px;
	  padding: 8px 12px;
	  position: absolute;
	  top: 0;
	}
 	.active {
	  background-color: #6E00AB;
	} 

</style>
</head>
<body>
	
	<%@ include file="/views/user/common/B_UserMainHeader.jsp" %>
   
   <section id="section">
   
   
   <!--          <div class="slide-photo">
                <input type="image" src="/forest/image/userimg/headerimg.png">                
            </div> -->
			            
			<div class="slideshow-container">
			
				<div class="mySlides fade">
				  <div class="numbertext">1 / 3</div>
				  <img src="/forest/image/userimg/banner1.jpg" style="width:1440px; height:467px;">
				</div>
			
				<div class="mySlides fade">
				  <div class="numbertext">2 / 3</div>
				  <img src="/forest/image/userimg/banner3.jpg" style="width:1440px; height:467px;">
				</div>
			
				<div class="mySlides fade">
				  <div class="numbertext">3 / 3</div>
				  <img src="/forest/image/userimg/banner2.jpg" style="width:1440px; height:467px;">
				</div>
				
				</div>
				<div style="text-align:center;">
				  <span class="dot"></span> 
				  <span class="dot"></span> 
				  <span class="dot"></span> 
				</div>
				
            
        <div class="sub-img">
            <input type="image" src="/forest/image/userimg/subimg2.png" width="100%">
        </div>
            
         <!--새로나온상품-->
         <div class="sub-title1 title1">
             <input type="image" src="/forest/image/userimg/sub.png" width="100%;">
         </div>
            
            <div class="section-product1">
          	<% for(int i = 0; i < list.size(); i++) { 
            			HashMap<String, Object> hmap = list.get(i);
            	%>
            	<div class="productList">
                <table class="productTable" align="center">
               		 <tr class="product-tr tr-1">
		                <td>
		                	<img src="/forest/image/productImg/<%=hmap.get("changeName") %>" width="242px" height="230px">
		                	 <span style="display:none"><%= hmap.get("productNo") %></span>
		                </td>
		            </tr>
		            <tr class="product-tr tr-2">
		                <td style="font-weight:bold;">&nbsp;<%=hmap.get("manufacturerName") %></td>
		            </tr>
		            
		            <tr class="product-tr tr-3">
		                <td>&nbsp;<%=hmap.get("productName") %></td>
		            </tr>
		            
<%-- 		            <tr class="product-tr tr-3">
		                <td>&nbsp;<%=hmap.get("rentalPrice") %>원</td>
		            </tr> --%>
                </table>
                </div>
                <% } %> 
            </div>
            <!--//새로나온상품-->
            
            <!--추천상품-->
            <div class="sub-title2 title2">
                <input type="image" src="/forest/image/userimg/sub2.png" width="100%;">
            </div>
            <div class="section-product2">
                <table class="productTable" align="center">
                    <tr class="product-tr tr2-1">
                        <td>
                            <input type="image" src="/forest/image/userimg/pimg5.png" width="242px" height="181px">
                            <span style="display:none">T20200226000002</span>
                        </td>
                        <td>
                            <input type="image" src="/forest/image/userimg/pimg6.png" width="242px" height="181px">
                            <span style="display:none">N20200226000001</span>
                        </td>
                        <td>
                            <input type="image" src="/forest/image/userimg/pimg7.png" width="242px" height="181px">
                            <span style="display:none">7</span>
                        </td>
                        <td>
                            <input type="image" src="/forest/image/userimg/pimg8.png" width="242px" height="181px">
                            <span style="display:none">8</span>
                        </td>
                    </tr>
                     <tr class="product-tr tr2-2">
                        <td>
                            <p>&nbsp;Apple</p>
                            <span style="display:none">T20200226000002</span>
                        </td>
                        <td>
                            <p>&nbsp;&nbsp;Apple</p>
                           <span style="display:none">N20200226000001</span>
                        </td>
                        <td>
                            <p>&nbsp;LG전자</p>
                            <span style="display:none">7</span>
                        </td>
                        <td>
                            <p>&nbsp;삼성전자</p>
                           <span style="display:none">8</span>
                        </td>
                    </tr>
                    
                    <tr class="product-tr tr2-3">
                        <td>
                            <p>&nbsp;애플 아이패드 9.7 6세대 A1893 128G WIFI</p>
                            <span style="display:none">T20200226000002</span>
                        </td>
                        <td>                            
                            <p>&nbsp;애플 맥북프로 2018 13인치 MR9R2KH/A i5-2.3GHz</p>
                            <span style="display:none">N20200226000001</span>
                        </td>
                        <td>                            
                            <p>&nbsp;울트라북 15U590-GA5IK(i5-8265U,8GB,256GB,39.6cm)</p>
                            <span style="display:none">7</span>
                        </td>
                        <td>                           
                            <p>&nbsp;갤럭시북 Ion NT950XCJ-X78(i7,8GB,256GB,39.6cm)</p>
                            <span style="display:none">8</span>
                        </td>
                    </tr>
                </table>
            </div>
            <!--//추천상품-->
        </section>
   
   	<script>
    	$(".productTable tr td").click(function(){
			console.log($(this).find("span").html());
			var productNo = $(this).find("span").html();
			//console.log(productNo.length);
			
			if(productNo.length > 5){
				location.href='<%=request.getContextPath() %>/selectOneDetail?proNum=' + productNo;
			}
			
			<%-- $.ajax({
				url: "<%= request.getContextPath()%>/selectOneDetail?proNum=" + productNo,
				type: "get",
				success: function(data){
					console.log("서블릿 호출 성공");
				},
				error: function(status){
					console.log("status : " + status);
				}
			}); --%>
			
			
    	});	   	
    	
   	</script>
   	<script>
	   	var slideIndex = 0;
	   	showSlides();
	
	   	function showSlides() {
	   	    var i;
	   	    var slides = document.getElementsByClassName("mySlides");
	   	    var dots = document.getElementsByClassName("dot");
	   	    for (i = 0; i < slides.length; i++) {
	   	       slides[i].style.display = "none";  
	   	    }
	   	    slideIndex++;
	   	    if (slideIndex > slides.length) {slideIndex = 1}    
	   	    for (i = 0; i < dots.length; i++) {
	   	        dots[i].className = dots[i].className.replace(" active", "");
	   	    }
	   	    slides[slideIndex-1].style.display = "block";  
	   	    dots[slideIndex-1].className += " active";
	   	    setTimeout(showSlides, 2000); // Change image every 2 seconds
	   	}
   	</script>
   
    <%@ include file="/views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>