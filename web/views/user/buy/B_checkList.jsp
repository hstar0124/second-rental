<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String categoryNo = request.getParameter("categoryNo");
   String manufacturerNo = request.getParameter("manufacturerNo");
   String buyProductNo = request.getParameter("buyProductNo");
%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
   /*-----체크리스트--------*/
   
   #section{
       width: 900px;
       height: 1100px;
       margin: 0 auto;  
   }
   
   /*상단 진행바*/
   .status-table{
       width: 600px;
       margin: 0 auto;
       margin-top: 90px;    
       text-align: center;
       font-size: 17px;
   }
   .status-table td:nth-of-type(5){
       border-bottom: 6px solid #6E00AB;
       /*선택안되었을때 회색*/
       /* border-bottom: 7px solid #DADADA; */    
       width: 100px;
   }
   .status-table td:nth-of-type(1){
        border-bottom: 7px solid #DADADA;   
       width: 100px;
   }
   .status-table td:nth-of-type(7){
        border-bottom: 7px solid #DADADA;   
       width: 100px;
   }
   .status-table td:nth-of-type(3){
        border-bottom: 7px solid #DADADA;   
       width: 100px; 
       
   }
   .status-table td:nth-of-type(2n){
       width: 20px;
   }
   
   
   /*체크리스트*/
   .checklist-main{
       margin: 0 auto;
       
       margin-top: 50px;
   }
   .checklist-main>p{
       color: #6E00AB;
       font-weight: bold;
       font-size: 20px;
   
   }
   .checklist-div>div>label{
       font-size: 15px;
   }
   
   
   .checklist-div{
       display: flex;
       width: 1000px;
       height: 50px;
       margin-bottom: 40px;
       
   }
   
    .checklist-div>div{
       cursor:pointer;
       border: 3px solid #C4C4C4;
       width: 300px;
       text-align: center;
       line-height: 40px;
   }
   .checklist-div>div:nth-of-type(2){
       margin-left: 50px;
       margin-right: 50px;
   }
/*    .q6 div{
       margin-top: 20px;
       margin-left: 30px;
   } */
   
   input[type=radio]{
   		display: none;
   		cursor:pointer;
   }
   .checklist-div label{
   		cursor:pointer;
   }
   
   
   
   /*이전, 다음 버튼영역*/
   .buyselect-button{
       width: 100%;
       text-align: center;
       margin-top: 100px;
   }
   .buyselect-button>button{
       width: 130px;
       height: 50px;
       background: #6E00AB;
       color: white;
       border: none;
       cursor:pointer;
      
   }
   .buyselect-button>button:nth-of-type(2){
       margin-left: 50px;
       background: #BABABA;
   }
</style>
</head>
<body>
   <%@ include file="/views/user/common/B_UserMainHeader.jsp" %>

   <!-- 세션시작 -->
   <section id="section">
      <div class="buyselect-status">
         <table class="status-table">
            <tr>
               <td>카테고리선택</td>
               <td>></td>
               <td>상품명 입력</td>
               <td>></td>
               <td>체크리스트</td>
               <td>></td>
               <td>사진등록</td>
            </tr>
         </table>
      </div>

      <!-- 체크리스트 -->
      <div class="checklist-main">
         <p>| 미개봉/미사용 제품인가요?</p>
         <div class="checklist-div q1">
            <div id="question111">
               <input type="radio" name="question1"  value="101" id="question11">
               <input type="hidden" value="600">
               <label for="question11" style="font-size: 15px;">미개봉 : 박스를 개봉하지 않은 상품</label>
            </div>
            <div id="question122">
               <input type="radio" name="question1" value="102" id="question12">
               <input type="hidden" value="50">
               <label for="question12" style="font-size: 15px;">미사용 : 개봉 후 사용한 적이 없는 상품</label>
            </div>
            <div id="question133">
               <input type="radio" name="question1"  value="103" id="question13">
               <input type="hidden" value="30">
               <label for="question13" style="font-size: 15px;">사용한 적이 있는 상품</label>
            </div>
         </div>

         <p>| 구성품은 무엇이 있나요?(제품박스, 어댑터, 마우스, 파우치, 가방)</p>
         <div class="checklist-div q2">
            <div id="question211">
               <input type="radio" name="question2"  value="201" id="question21">
               <input type="hidden" value="100">
               <label for="question21" style="font-size: 15px;">모두 있습니다.</label>
            </div>
            <div id="question222">
               <input type="radio" name="question2"  value="202" id="question22">
               <input type="hidden" value="50">
               <label for="question22" style="font-size: 15px;">일부만 있습니다.</label>
            </div>
            <div id="question233">
               <input type="radio" name="question2"  value="203" id="question23">
               <input type="hidden" value="1">
               <label for="question23" style="font-size: 15px;">아무것도 없습니다.</label>
            </div>
         </div>

         <p>| 작동상태는 어떤가요?</p>
         <div class="checklist-div q3">
            <div id="question311">
               <input type="radio" name="question3"  value="301" id="question31">
               <input type="hidden" value="100">
                <label for="question31" style="font-size: 15px;">작동 이상 없습니다.</label>
            </div>
            <div id="question322">
               <input type="radio" name="question3"  value="302" id="question32">
               <input type="hidden" value="50">
               <label for="question32" style="font-size: 15px;">약간 문제가 있습니다.</label>
            </div>
            <div id="question333">
            <input type="radio" name="question3"  value="303" id="question33">
            <input type="hidden" value="1">
               <label for="question33" style="font-size: 15px;">작동하지 않습니다.</label>
            </div>
         </div>

         <p>| 외관 상태는 어떤가요?</p>
         <div class="checklist-div q4">
            <div id="question411">
               <input type="radio" name="question4" id="question41" value="401">
               <input type="hidden" value="100">
               <label for="question41" style="font-size: 15px;">깔끔합니다.</label>
            </div>
            <div id="question422">
               <input type="radio" name="question4" id="question42" value="402">
               <input type="hidden" value="50">
               <label for="question42" style="font-size: 15px;">생활기스가 있습니다.</label>
            </div>
            <div id="question433">
               <input type="radio" name="question4" id="question43" value="403">
               <input type="hidden" value="1">
               <label for="question43" style="font-size: 15px;">부서진 곳이 있습니다.</label>
            </div>
         </div>

         <p>| 국내 정식 발매 제품인가요?</p>
         <div class="checklist-div q5">
            <div id="question511">
               <input type="radio" name="question5" id="question51" value="501">
               <input type="hidden" value="100">
               <label for="question51" style="font-size: 15px;">네, 국내 정식 발매 제품입니다.</label>
            </div>
            <div id="question522">
               <input type="radio" name="question5" id="question52" value="502">
               <input type="hidden" value="50">
               <label for="question52" style="font-size: 15px;">아니요, 해외 구입 제품입니다.</label>
            </div>
            

         </div>

         <p>| 언제 구매하셨나요?</p>
         <div class="checklist-div q6">
            <div id="question6">
               <input type="radio" name="question6" id="question61" value="601">
               <input type="hidden" value="100">
               <label for="question61" style="font-size: 15px;">최근 1개월이내</label>
            </div>
            <div id="question6">
               <input type="radio" name="question6" id="question62" value="602">
               <input type="hidden" value="50">
               <label for="question62" style="font-size: 15px;">1개월이상 ~ 6개월 미만</label>
            </div>
            <div id="question6">
               <input type="radio" name="question6" id="question63" value="603">
               <input type="hidden" value="30">
               <label for="question63" style="font-size: 15px;">6개월 이상  ~ 1년 미만</label>
            </div>
         

         </div>


      </div>


      <div class="buyselect-button">
         <button onclick="history.go(-1);">이전</button>
         <button id="nextBtn" type="submit">다음</button>
      </div>

      
   </section>
   <!-- 세션끝 -->
   
   <script>
      
      $(function() {
         //유저가 선택한 값 전역변수 선언
         var answer1 = "";
         var answer2 = "";
         var answer3 = "";
         var answer4 = "";
         var answer5 = "";
         var answer6 = "";
         //질문 넘버 카운트
         var questionNo = 0;
         
         //점수 카운트
         var score = 0;
         var score1 = 0;
         var score2 = 0;
         var score3 = 0;
         var score4 = 0;
         var score5 = 0;
         var score6 = 0;
         
         //매입번호
         var buyNo = 0;
         //체크리스트거르는용
         var result1 = 0;
         var result2 = 0;
         var result3 = 0;
         var result4 = 0;
         var result5 = 0;
         var result6 = 0;
         
         
         //라디오 버튼 누를시 value값 변수에 저장 및 div 색 변경
         //라벨 눌렀을시에는 안된다 큰일, 라벨누르면 라디오버튼 클릭 안되게 막아놓음.
         $("input:radio[name=question1]").on('click', function(){
            $("input:radio[name=question1]").filter(function(){
               
               if($(this).is(":checked")){
                  answer1 = $(this).val();
                 
                 score1 = $(this).parent().children().eq(1).val(); 
                  
                  questionNo = 1;
                  
                  $(this).parent().css({"border" : "3px solid #6E00AB"});
                  console.log("score1:" + score1);
                  console.log("answer1 : " + answer1);
                  
                  result1 = 1;
                  
                  if(answer1 == 101){
                     $("#question21").attr("checked", true);
                     $("#question31").attr("checked", true);
                     $("#question41").attr("checked", true);
                     //val가져오기
                     answer2 = $("#question21").val();
                     answer3 = $("#question31").val();
                     answer4 = $("#question41").val();
                     console.log("answer234: " + answer2 + ", " + answer3 + ", " + answer4);
                     //css변경
                     $("#question211").css({"border" : "3px solid #6E00AB"});
                     $("#question311").css({"border" : "3px solid #6E00AB"});
                     $("#question411").css({"border" : "3px solid #6E00AB"});
                     
                     result2 = 1;
                     result3 = 1;
                     result4 = 1;
                     
                     //체크리스트 모두 선택 되었을때만 다음 버튼 활성화되기
                     if(result1 == 1 && result2 ==1 && result3 ==1 && result4 ==1 && result5 ==1 && result6 ==1){
                   	  		$("#nextBtn").css({"background":"#6E00AB"});
                   	  
	                  	 	 $("#nextBtn").on('click', function(){
	            	        	 score = Number(score1) + Number(score2) + Number(score3) 
	            	     				+ Number(score4) + Number(score5) + Number(score6);
	            	  	 		 console.log("score : " + score);  
	            	  	 		 
	            	            location.href = "<%=request.getContextPath()%>/checkList.ck?categoryNo=" + <%=categoryNo%> + 
	            	            "&manufacturerNo="+ <%=manufacturerNo%> +"&buyProductNo="+ <%=buyProductNo%> + "&answer1="+answer1 + 
	            	                  "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 +
	            	                  "&answer5=" + answer5 + "&answer6=" + answer6 + "&score=" + score;
	            	         }); 
                     	}
                     
                  } else {
                     
                     $("#question21").attr("checked", false);
                     $("#question31").attr("checked", false);
                     $("#question41").attr("checked", false);
                     answer2 = "";
                     answer3 = "";
                     answer4 = "";
                     console.log("answer234: " + answer2 + ", " + answer3 + ", " + answer4);
                     $("#question211").css({"border" : "3px solid #C4C4C4"});
                     $("#question311").css({"border" : "3px solid #C4C4C4"});
                     $("#question411").css({"border" : "3px solid #C4C4C4"}); 
                  }
                  
               } else {
                  //checked가 아닐 경우 회색으로됨 
                   $(this).parent().css({"border" : "3px solid #C4C4C4"});
                  
               }
               
            });
            
           });
         $("input:radio[name=question2]").on('click', function(){
            $("input:radio[name=question2]").filter(function(){
               
               if($(this).is(":checked")){
                  answer2 = $(this).val();
                  score2 = $(this).parent().children().eq(1).val();
                  
                  result2 = 1;
                  
                  if(result1 == 1 && result2 ==1 && result3 ==1 && result4 ==1 && result5 ==1 && result6 ==1){
                	  $("#nextBtn").css({"background":"#6E00AB"});
                	  
                	  $("#nextBtn").on('click', function(){
         	        	 score = Number(score1) + Number(score2) + Number(score3) 
         	     				+ Number(score4) + Number(score5) + Number(score6);
         	  	 		 console.log("score : " + score);  
         	  	 		 
         	            location.href = "<%=request.getContextPath()%>/checkList.ck?categoryNo=" + <%=categoryNo%> + 
         	            "&manufacturerNo="+ <%=manufacturerNo%> +"&buyProductNo="+ <%=buyProductNo%> + "&answer1="+answer1 + 
         	                  "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 +
         	                  "&answer5=" + answer5 + "&answer6=" + answer6 + "&score=" + score;
         	         }); 
                  }
                  
                  if(answer2 == 203){
                     location.href = "views/user/buy/B_buyReject.jsp";
                  } else {
                     questionNo = 2;
                     $(this).parent().css({"border" : "3px solid #6E00AB"});
                     console.log("score2:" + score2);
                     console.log("answer2 : " + answer2);
                     
                     
                  }
               } else {
                  $(this).parent().css({"border":"3px solid #C4C4C4"});
               }
            });
            
           });
         $("input:radio[name=question3]").on('click', function(){
            $("input:radio[name=question3]").filter(function(){
               
               if($(this).is(":checked")){
                  answer3 = $(this).val();
                  score3 = $(this).parent().children().eq(1).val();
                  
                  result3 = 1;
                  
                  if(result1 == 1 && result2 ==1 && result3 ==1 && result4 ==1 && result5 ==1 && result6 ==1){
                	  $("#nextBtn").css({"background":"#6E00AB"});
                	  
                	  $("#nextBtn").on('click', function(){
         	        	 score = Number(score1) + Number(score2) + Number(score3) 
         	     				+ Number(score4) + Number(score5) + Number(score6);
         	  	 		 console.log("score : " + score);  
         	  	 		 
         	            location.href = "<%=request.getContextPath()%>/checkList.ck?categoryNo=" + <%=categoryNo%> + 
         	            "&manufacturerNo="+ <%=manufacturerNo%> +"&buyProductNo="+ <%=buyProductNo%> + "&answer1="+answer1 + 
         	                  "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 +
         	                  "&answer5=" + answer5 + "&answer6=" + answer6 + "&score=" + score;
         	         }); 
                  }
                  
                  if(answer3 == 303){
                     location.href = "views/user/buy/B_buyReject.jsp";
                  } else {
                     questionNo = 3;
                     $(this).parent().css({"border" : "3px solid #6E00AB"});
                     console.log("score3:" + score3);
                     console.log("answer3 : " + answer3);
                     
                    
                  }
               } else {
                  $(this).parent().css({"border" : "3px solid #C4C4C4"});
               }
            });
            
           });
         $("input:radio[name=question4]").on('click', function(){
            $("input:radio[name=question4]").filter(function(){
               
               if($(this).is(":checked")){
                  answer4 = $(this).val();
                  score4 = $(this).parent().children().eq(1).val();
                  
                  result4 = 1;
                  
                  if(result1 == 1 && result2 ==1 && result3 ==1 && result4 ==1 && result5 ==1 && result6 ==1){
                	  $("#nextBtn").css({"background":"#6E00AB"});
                	  
                	  $("#nextBtn").on('click', function(){
         	        	 score = Number(score1) + Number(score2) + Number(score3) 
         	     				+ Number(score4) + Number(score5) + Number(score6);
         	  	 		 console.log("score : " + score);  
         	  	 		 
         	            location.href = "<%=request.getContextPath()%>/checkList.ck?categoryNo=" + <%=categoryNo%> + 
         	            "&manufacturerNo="+ <%=manufacturerNo%> +"&buyProductNo="+ <%=buyProductNo%> + "&answer1="+answer1 + 
         	                  "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 +
         	                  "&answer5=" + answer5 + "&answer6=" + answer6 + "&score=" + score;
         	         }); 
                  }
                  
                  if(answer4 == 403){
                     location.href = "views/user/buy/B_buyReject.jsp";
                  } else {
                     questionNo = 4;
                     $(this).parent().css({"border" : "3px solid #6E00AB"});
                     console.log("score4:" + score4);
                     console.log("answer4 : " + answer4);
                     
                     
                  }
               } else {
                  $(this).parent().css({"border" : "3px solid #C4C4C4"});
               }
            });
            
           });
         $("input:radio[name=question5]").on('click', function(){
            $("input:radio[name=question5]").filter(function(){
               
               if($(this).is(":checked")){
                  answer5 = $(this).val();
                  score5 = $(this).parent().children().eq(1).val();
                  
                  questionNo = 5;
                  $(this).parent().css({"border" : "3px solid #6E00AB"});
                  console.log("score5:" + score5);
                  console.log("answer5 : " + answer5);
                  
                  result5 = 1;
                  
                  if(result1 == 1 && result2 ==1 && result3 ==1 && result4 ==1 && result5 ==1 && result6 ==1){
                	  $("#nextBtn").css({"background":"#6E00AB"});
                	  
                	  $("#nextBtn").on('click', function(){
         	        	 score = Number(score1) + Number(score2) + Number(score3) 
         	     				+ Number(score4) + Number(score5) + Number(score6);
         	  	 		 console.log("score : " + score);  
         	  	 		 
         	            location.href = "<%=request.getContextPath()%>/checkList.ck?categoryNo=" + <%=categoryNo%> + 
         	            "&manufacturerNo="+ <%=manufacturerNo%> +"&buyProductNo="+ <%=buyProductNo%> + "&answer1="+answer1 + 
         	                  "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 +
         	                  "&answer5=" + answer5 + "&answer6=" + answer6 + "&score=" + score;
         	         }); 
                  }
               } else {
                  $(this).parent().css({"border" : "3px solid #C4C4C4"});
               }
            });
            
           });
         $("input:radio[name=question6]").on('click', function(){
            $("input:radio[name=question6]").filter(function(){
               
               if($(this).is(":checked")){
                  answer6 = $(this).val();
                  score6 = $(this).parent().children().eq(1).val();
                  
                  questionNo = 6;
                  $(this).parent().css({"border" : "3px solid #6E00AB"});
                  console.log("score6:" + score6);
                  console.log("answer6 : " + answer6);
                  
                  result6 = 1;
                   
                  if(result1 == 1 && result2 ==1 && result3 ==1 && result4 ==1 && result5 ==1 && result6 ==1){
                	  $("#nextBtn").css({"background":"#6E00AB"});
                	  
                	  $("#nextBtn").on('click', function(){
         	        	 score = Number(score1) + Number(score2) + Number(score3) 
         	     				+ Number(score4) + Number(score5) + Number(score6);
         	  	 		 console.log("score : " + score);  
         	  	 		 
         	            location.href = "<%=request.getContextPath()%>/checkList.ck?categoryNo=" + <%=categoryNo%> + 
         	            "&manufacturerNo="+ <%=manufacturerNo%> +"&buyProductNo="+ <%=buyProductNo%> + "&answer1="+answer1 + 
         	                  "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 +
         	                  "&answer5=" + answer5 + "&answer6=" + answer6 + "&score=" + score;
         	         }); 
                  }
                  
               	  
               } else {
                  $(this).parent().css({"border" : "3px solid #C4C4C4"});
               }
            });
            
           });
         


      });
   </script>   



   <%@ include file="/views/user/common/B_UserMainFooter.jsp" %>
</body>
</html>