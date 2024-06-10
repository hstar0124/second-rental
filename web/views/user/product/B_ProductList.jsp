<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    
	}
	
	/*카테고리선택영역*/
	
	.select-table{
	    margin-top: 10px;
	    position: absolute;
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
	.product-list1{
	    position: absolute;
	    width: 1114px;
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
	        <p>디지털</p>&nbsp;<p>></p>&nbsp;<p>노트북</p>
	    </div>
	    
	        <table class="select-table">
	            <tr class="table-tr">
	                <td>제조사</td>
	                <td><div>전체</div></td>
	                <td><div>삼성전자</div></td>
	                <td><div>LG전자</div></td>
	                <td><div>DELL</div></td>
	                <td><div>APPLE</div></td>
	                <td><div>HP</div></td>
	                <td></td>
	            </tr>
	            <!-- 카테고리 각 영역 클릭시 div 색 변화 -->
	            <tr class="table-tr">
	                <td>상품상태</td>
	                <td><div>렌탈가능</div></td>
	                <td><div>렌탈중</div></td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	            </tr>
	        </table>
	        
	
	        
	    <div class="sub-title">
	        <table class="sub-table">
	            <tr>
	                <td class="sub-td1">
	                    <p>총 12개의 상품이 있습니다.</p>
	                </td>
	                <td class="sub-td2">
	                    <select>
	                        <option value="">최신순</option>
	                        <option value="">낮은가격순</option>
	                        <option value="">높은가격순</option>
	                    </select>
	                </td>
	            </tr>
	        </table>
	    </div>             
	
	    <div>
	        <table class="product-list1">
	            <tr class="product-tr tr-1">
	                <td>
	                    <input type="image" src="/forest/image/userimg/pimg1.png" width="242px" height="181px">
	                </td>
	                <td>
	                    <input type="image" src="/forest/image/userimg/pimg2.png" width="242px" height="181px">
	                </td>
	                <td>
	                    <input type="image" src="/forest/image/userimg/pimg3.png" width="242px" height="181px">
	                </td>
	                <td>
	                    <input type="image" src="/forest/image/userimg/pimg4.png" width="242px" height="181px">
	                </td>
	            </tr>
	            <tr class="product-tr tr-2">
	                <td>
	                    <p>&nbsp;morphy richards</p>
	                    
	                </td>
	                <td>
	                    <p>&nbsp;&nbsp;dyson</p>
	                   
	                </td>
	                <td>
	                    <p>&nbsp;morphy richards</p>
	                    
	                </td>
	                <td>
	                    <p>&nbsp;해피콜</p>
	                   
	                </td>
	            </tr>
	            
	            <tr class="product-tr tr-3">
	                <td>
	                    <p>&nbsp;모피리처드 전기포트 Aspect Scandi (Wood)</p>
	                </td>
	                <td>
	                    
	                    <p>&nbsp;&nbsp;슈퍼소닉 드라이기 HD03</p>
	                </td>
	                <td>
	                    
	                    <p>&nbsp;스팀다리미 Breeze</p>
	                </td>
	                <td>
	                   
	                    <p>&nbsp;에어프라이어 3.2L (다이얼식) HC-AF1000B</p>
	                </td>
	            </tr>
	        </table>
	
	    </div>
	    <div>
	        <table class="product-list2">
	            <tr class="product-tr tr2-1">
	                <td>
	                    <input type="image" src="/forest/image/userimg/pimg5.png" width="242px" height="181px">
	                </td>
	                <td>
	                    <input type="image" src="/forest/image/userimg/pimg6.png" width="242px" height="181px">
	                </td>
	                <td>
	                    <input type="image" src="/forest/image/userimg/pimg7.png" width="242px" height="181px">
	                </td>
	                <td>
	                    <input type="image" src="/forest/image/userimg/pimg8.png" width="242px" height="181px">
	                </td>
	            </tr>
	            <tr class="product-tr tr2-2">
	                <td>
	                    <p>&nbsp;Apple</p>
	                    
	                </td>
	                <td>
	                    <p>&nbsp;&nbsp;Apple</p>
	                   
	                </td>
	                <td>
	                    <p>&nbsp;LG전자</p>
	                    
	                </td>
	                <td>
	                    <p>&nbsp;삼성전자</p>
	                   
	                </td>
	            </tr>
	            
	            <tr class="product-tr tr2-3">
	                <td>
	                    <p>&nbsp;아이패드 7세대 10.2형 Wi-Fi 32GB 스페이스그레이 MW742KH/A</p>
	                </td>
	                <td>
	                    
	                    <p>&nbsp;맥북프로 13.3형 터치바 스페이스그레이 MV972KHA(2.4GHZ QC/8GB/512GB)</p>
	                </td>
	                <td>
	                    
	                    <p>&nbsp;울트라북 15U590-GA5IK(i5-8265U,8GB,256GB,39.6cm)</p>
	                </td>
	                <td>
	                   
	                    <p>&nbsp;갤럭시북 Ion NT950XCJ-X78(i7,8GB,256GB,39.6cm)</p>
	                </td>
	            </tr>
	        </table>
	    </div>
	
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
	
	    </div>
	
	
	</section>
	<!-- 세션끝 -->

   
   <%@ include file="/views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>