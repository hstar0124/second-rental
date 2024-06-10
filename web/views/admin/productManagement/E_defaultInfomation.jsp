<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import = "com.kh.forest.product.model.vo.*"
%>
<%
	DefaultInfo di = (DefaultInfo)(request.getAttribute("di"));
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
<title>Insert title here</title>
</head>
<body onload="ready('상품 기본정보 설정', '상품관리', '상품 기본정보 설정');">
	<%@ include file="../common/C_menubar.jsp" %>

	<article>
    <div>
        <form action="updateDefaultInfo" method="get">
            <table class="E">
                <tr>
                    <td class="h"><h3>공통 안내문구</h3></td>
                </tr>
                
                <tr>
                    <td class="htd" rowspan="2">유의 사항</td>
                    <td colspan="3" align="center" style="background:gray;">아래에 내용을 적어 주세요</td>
                </tr>
                <tr>
                    <td colspan="3">
                        <textarea cols="125" rows="11" style="resize:none;" name="noticeInfo"><%= di.getNoticeInfo() %></textarea>
                    </td>
				</tr>
				<tr>
                    <td class="htd" rowspan="2">배송 정보</td>
                    <td colspan="3" align="center" style="background:gray;" >아래에 내용을 적어 주세요</td>
                </tr>
                <tr>
                    <td colspan="3">
                        <textarea cols="125" rows="11" style="resize:none;" name="deliveryInfo"><%= di.getDeliveryInfo() %></textarea>
                    </td>
				</tr>
				
                	
                	<td id="bt" colspan="4">
                	<br>
                	<br>
                	<br>
					<input style="background : #6792DA; color : white; width : 70px; height : 25px;
					border:none;"
					type="submit" id="bt" value="적용">
                	<br>

                	<br>
                	<br>
                	</td>
                </tr>
            </table>
		</form>	
		<!-- <form action="" method="get">
            <table class="E">
                <tr>
                    <td class="h"><h3>기본정책</h3></td>
                </tr>
                
                <tr>
                    <td class="htd" rowspan="1">유의 사항</td>
					<td>
						<select class="vl">
							<option>우체국</option>
							<option>로젠택배</option>
							<option>CJ대한통운</option>
						</select>					
					</td>

				</tr>
                
				<tr>
					<td class="htd" rowspan="1">배송 유형</td>
					<td>
						<input type="radio" name="tran" class="vl" id="id1"><label for="id1">무료</label>
						<input type="radio" name="tran" class="vl" id="id2"><label for="id2">고정금액</label>
					</td>
                    
                </tr>
                <tr id="set" hidden>
					<td class="htd">주문 금액별<br> 배송비 설정</td>
					<td>
						<input type="number" class="vl"> <span style="color:blue">원 이상 </span>- 
						<input type="number" class="vl"><span style="color:blue">원 미만 </span> 
						<input type="number" class="vl"> <span style="color:blue">원</span>
					</td>
				</tr>
				
				<script>
					$("#id1").click(function(){
						$("#set").hide();
					});
					
					$("#id2").click(function(){
						$("#set").show();
					});
				</script>
				
                	
                	<td id="bt" colspan="4">
                	<br>
                	<br>
                	<br>
					<input style="background : #6792DA; color : white; width : 70px; height : 25px;
					border:none;"
					type="submit" id="bt" value="적용">
                	<br>

                	<br>
                	<br>
                	</td>
                </tr>
            </table>
		</form> -->
		

    </div>


</article>


	<%@ include file="../common/C_menubar2.jsp" %>
	
</body>
</html>