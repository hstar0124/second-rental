<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.order.model.vo.*, com.kh.forest.member.model.vo.*"%>
<%
   //결제리스트
   ArrayList<OrderStatus> list = (ArrayList<OrderStatus>) request.getAttribute("list");
   PageInfo pi = (PageInfo) request.getAttribute("PageInfo");
   int currentPage = pi.getCurrentPage();
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
   int maxPage = pi.getMaxPage();
   int listCount = pi.getListCount();
   
   //취소리스트
   ArrayList<OrderStatus> list2 = (ArrayList<OrderStatus>) request.getAttribute("list2");
   PageInfo pi2 = (PageInfo) request.getAttribute("PageInfo2");
   int currentPage2 = pi2.getCurrentPage();
   int startPage2 = pi2.getStartPage();
   int endPage2 = pi2.getEndPage();
   int maxPage2 = pi2.getMaxPage();
   int listCount2 = pi2.getListCount();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>중고구마</title>
<style>
.secWrap {
   margin-left: 50px;
}

.tab {
   list-style: none;
   margin: 0 auto;
   margin-top: 50px;
}

.tab li {
   display: inline-block;
   border: 1px solid gray;
   background: #E8E8E8;
   width: 430px;
   height: 50px;
   float: left;
   line-height: 50px;
   text-align: center;
   color: darkgray;
   font-weight: bold;
}

.tab li.current {
   background: white;
   color: black;
   border-bottom: none;
}

.tabContent {
   display: none;
   margin-top: 170px;
}

.tabContent.current {
   display: inherit;
}

.resultTable {
   width: 90%;
   text-align: center;
   margin: 0 auto;
   margin-top: 50px;
   border: 1px solid black;
   border-collapse: collapse;
}

.resultTable tr th {
   padding-left: 30px;
   background: lightgray;
   text-align: left;
   height: 40px;
}

.searchTable {
   margin: 0 auto;
   margin-top: 100px;
   width: 90%;
}

.searchWrap {
   margin: 0 auto;
   margin-top: 100px;
}

.searchTable tr:last-of-type {
   background: #E8E8E8;
   font-weight: bold;
   height: 50px;
   text-align: center;
}

.resultTable tr td {
   height: 60px;
}

.deliverBtn {
   background: #6E00AB;
   color: white;
   border: 1px solid #6E00AB;
}

.cancelBtn {
   background: #6E00AB;
   color: white;
   border: 1px solid #6E00AB;
}

.deliverBtn2 {
   background: #BABABA;
   color: white;
   border: 1px solid #BABABA;
}

.cancelBtn2 {
   background: #BABABA;
   color: white;
   border: 1px solid #BABABA;
}

.infoImg img {
   margin-top: 50px;
   margin-left: 50px;
   margin-bottom: 50px;
}

#confirm {
   background: #BABABA;
   color: white;
   border: 1px solid #BABABA;
}

td[class*=moPhoto] img {
   width: 180px;
   height: 180px;
}
button {
   cursor:pointer;
}
.pagingArea button{
   border:none;
   background:white;
}
.pagingArea {
   margin:20px;
}
/* The Modal (background) */
.modal {
   display: none; /* Hidden by default */
   position: fixed; /* Stay in place */
   z-index: 1; /* Sit on top */
   left: 0;
   top: 0;
   width: 100%; /* Full width */
   height: 100%; /* Full height */
   overflow: auto; /* Enable scroll if needed */
   background-color: rgb(0, 0, 0); /* Fallback color */
   background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

.modal2 {
   display: none; /* Hidden by default */
   position: fixed; /* Stay in place */
   z-index: 1; /* Sit on top */
   left: 0;
   top: 0;
   width: 100%; /* Full width */
   height: 100%; /* Full height */
   overflow: auto; /* Enable scroll if needed */
   background-color: rgb(0, 0, 0); /* Fallback color */
   background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

.modal3 {
   display: none; /* Hidden by default */
   position: fixed; /* Stay in place */
   z-index: 1; /* Sit on top */
   left: 0;
   top: 0;
   width: 100%; /* Full width */
   height: 100%; /* Full height */
   overflow: auto; /* Enable scroll if needed */
   background-color: rgb(0, 0, 0); /* Fallback color */
   background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
   background-color: #fefefe;
   margin: 15% auto; /* 15% from the top and centered */
   /* padding: 20px; */
   border: 1px solid #888;
   width: 50%; /* Could be more or less, depending on screen size */
}

.modal-content2 {
   background-color: #fefefe;
   margin: 15% auto; /* 15% from the top and centered */
   /* padding: 20px; */
   border: 1px solid #888;
   width: 40%; /* Could be more or less, depending on screen size */
}

.modal-content3 {
   background-color: #fefefe;
   margin: 15% auto; /* 15% from the top and centered */
   /* padding: 20px; */
   border: 1px solid #888;
   width: 40%; /* Could be more or less, depending on screen size */
}
/* The Close Button */
.close {
   color: #aaa;
   float: right;
   font-size: 28px;
   font-weight: bold;
   margin-right: 20px;
}

.close:hover, .close:focus {
   color: black;
   text-decoration: none;
   cursor: pointer;
}

.modalTb {
   margin: 30px auto;
   width: 80%;
   border: 2px solid lightgray;
   border-collapse: collapse;
   height: 600px;
   line-height: 200%;
}

.modalTb2 {
   margin: 30px auto;
   width: 80%;
   border: 2px solid lightgray;
   border-collapse: collapse;
   height: 400px;
   line-height: 200%;
}

.modalTb3 {
   margin: 30px auto;
   width: 80%;
   border: 2px solid lightgray;
   border-collapse: collapse;
   height: 170px;
   line-height: 200%;
}

.modalTb4 {
   margin: 30px auto;
   width: 80%;
   border: 2px solid lightgray;
   border-collapse: collapse;
   line-height: 200%;
}

.modalTop {
   margin: 0;
   width: 100%;
   height: 50px;
   background: #6E00AB;
}

.modalTb td {
   border: 1px solid lightgray;
   padding: 8px;
}

.modalTb2 td {
   border: 1px solid lightgray;
   padding: 8px;
}

.modalTb3 td {
   border: 1px solid lightgray;
   padding: 8px;
}

.modalTb4 td {
   border: 1px solid lightgray;
   padding: 8px;
}

.modalBtn {
   margin: 30px auto;
   text-align: center;
}

.modalBtn span button {
   width: 100px;
   height: 40px;
}

.buyCancel {
   background: #BABABA;
   color: white;
   border: 1px solid #BABABA;
}

.modalBtn .cancel {
   background: #6E00AB;
   border: 1px solid #6E00AB;
   color: white;
}

caption {
   text-align: left;
   font-weight: bold;
}
</style>
</head>
<body>
   <%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
   <section class="secWrap">
      <h1 class="text1">주문현황</h1>
      <div
         style="background-color: #6E00AB; width: 100%; height: 4px; margin-top: 0px;"></div>

      <!-- 탭 영역 -->
      <ul class="tab">
         <li class="menuTab current" data-tab="tab-1">주문 내역 조회</li>
         <li class="menuTab" data-tab="tab-2">취소/교환 조회</li>
      </ul>


      <!-- 주문내역 조회 영역 -->
      <div id="tab-1" class="tabContent current">
         <div class="searchWrap">
            <!-- <table class="searchTable">
               <tr height="50px" style="">
                  <td style="background: white;" colspan="2"></td>
               </tr>
               <tr>
                  <td>기간 검색</td>
                  <td><input type="text" id="datepicker">~<input
                     type="text" id="datepicker1">
                     <button>1개월</button>
                     <button>3개월</button>
                     <button>6개월</button>
                     <button>전체</button></td>
               </tr>
            </table> -->
         </div>
         <%
            OrderStatus os = null;
            OrderStatus os2 = null;
            for (int i = 0; i < list.size(); i++) {
               os = list.get(i);
               if (i < list.size() - 1) {
                  os2 = list.get(i + 1);
               } else if (i == list.size() - 1) {
                  os2 = new OrderStatus();
               }
               if (os.getStatus().equals("결제완료") && os.getOrderNo().equals(os2.getOrderNo())
                     && !os.getOrderCode().equals(os2.getOrderCode())) {
         %>
         <table class="resultTable">
            <colgroup>
               <col width="15%">
               <col width="55%">
               <col width="10%">
               <col width="10%">
               <col width="10%">
            </colgroup>
            <tr>
               <th colspan="5" style="font-size: 20px">주문일 : <%=os.getOrderDate()%></th>
            </tr>
            <tr>
               <td><img height="120px" width="120px"
                  src="<%=request.getContextPath()%>/image/productImg/<%=os.getChangeName()%>"></td>
               <td><%=os.getProductName()%></td>
               <td><%=os.getPrice()%>원</td>
               <td><%=os.getStatus()%><br>
               <%-- <br> 
               <%if (os.getStatus().equals("배송완료")) { %>
                  <button class="confirm" id="confirm" value="<%=os.getOrderNo()%>"
                     style="background: #6E00AB; border: 1px solid #6E00AB;"
                     onclick="modal3(this.value, '<%=os.getProductName()%>', '<%=os.getUserName()%>', '<%=os.getPrice()%>', '<%=os.getOrderCode()%>','<%=os.getChangeName()%>');">구매확정</button>
                  <%
                     } else {
                  %>
                  <button id="confirm">구매확정</button> 
                  <%    } %> --%>
                  </td>
                  
               <%
                  if (!os.getStatus().equals("결제완료")) {
               %>
               
               <td>
                  <div>
                     <button class="deliverBtn"
                        onclick="delivery('<%=os.getOrderCode()%>');">배송조회</button>
                  </div>
               </td>
               <%
                  } else {
               %>
               <td>
                  <div>
                     <button class="deliverBtn"
                        style="background: #BABABA; border: 1px solid #BABABA;"
                        onclick="" disabled>배송조회</button>
                  </div>
               </td>
               <%
                  }
               %>
            </tr>
            <tr>
               <td><img height="120px" width="120px"
                  src="<%=request.getContextPath()%>/image/productImg/<%=os2.getChangeName()%>"></td>
               <td><%=os2.getProductName()%></td>
               <td><%=os2.getPrice()%>원</td>
               <td verticle-align="top"><%-- <%=os2.getStatus()%><br>
               <br>  --%>
               <%
                   if (os2.getStatus().equals("배송완료")) {
                %>
                  <button class="confirm" id="confirm" value="<%=os2.getOrderNo()%>"
                     style="background: #6E00AB; border: 1px solid #6E00AB;"
                     onclick="modal3(this.value, '<%=os2.getProductName()%>', '<%=os2.getUserName()%>', '<%=os2.getPrice()%>', '<%=os2.getOrderCode()%>','<%=os2.getChangeName()%>');">구매확정</button>
                  <%
                     } else {
                  %>
                  <button id="confirm">구매확정</button> 
                  <%
                      }
                   %>
                   </td>
                   
               <td>
                  <div>
                     <button class="cancelBtn" id="cancelBtn"
                        onclick="modal1(this.value, '<%=os.getProductName()%>', '<%=os.getUserName()%>', '<%=os.getPrice()%>','<%=os.getChangeName()%>');"
                        value="<%=os.getOrderNo()%>">구매취소</button>
                  </div>
               </td>
            </tr>
         </table>
         <%
            i++;
               } else {
         %>


         <table class="resultTable">
            <colgroup>
               <col width="15%">
               <col width="55%">
               <col width="10%">
               <col width="10%">
               <col width="10%">
            </colgroup>
            <tr>
               <th colspan="5" style="font-size: 20px">주문일 : <%=os.getOrderDate()%></th>
            </tr>

            <tr>
               <td rowspan="2"><img height="120px" width="120px"
                  src="<%=request.getContextPath()%>/image/productImg/<%=os.getChangeName()%>"></td>
               <td rowspan="2"><%=os.getProductName()%></td>
               <td rowspan="2"><%=os.getPrice()%>원</td>
               <td rowspan="2"><%=os.getStatus()%><br>
               <br> 
               <%
                   if (os.getStatus().equals("배송완료")) {
                %>
                  <button class="confirm" id="confirm" value="<%=os.getOrderNo()%>"
                     style="background: #6E00AB; border: 1px solid #6E00AB;"
                     onclick="modal3(this.value, '<%=os.getProductName()%>', '<%=os.getUserName()%>', '<%=os.getPrice()%>', '<%=os.getOrderCode()%>','<%=os.getChangeName()%>');">구매확정</button>
                  <%
                     } else {
                  %>
                  <button id="confirm">구매확정</button>
                  <%
                      }   
                   %>
                   </td>
                   
               <%
                  if (!os.getStatus().equals("결제완료")) {
               %>
               <td>
                  <div>
                     <button class="deliverBtn"
                        onclick="delivery('<%=os.getOrderCode()%>');">배송조회</button>
                  </div>
               </td>
               <%
                  } else {
               %>
               <td>
                  <div>
                     <button class="deliverBtn"
                        style="background: #BABABA; border: 1px solid #BABABA;"
                        onclick="" disabled>배송조회</button>
                  </div>
               </td>
               <%
                  }
               %>
            </tr>
            <%
               if (os.getStatus().equals("결제완료")) {
            %>
            <tr>
               <td>
                  <div>
                     <button class="cancelBtn" id="cancelBtn"
                        onclick="modal1(this.value, '<%=os.getProductName()%>', '<%=os.getUserName()%>', '<%=os.getPrice()%>','<%=os.getChangeName()%>');"
                        value="<%=os.getOrderNo()%>">구매취소</button>
                  </div>
               </td>
            </tr>
            <%
               } else {
            %>
            <tr>
               <td>
                  <div>
                     <button class="cancelBtn" id="cancelBtn"
                        style="background: #BABABA; border: 1px solid #BABABA;" disabled>구매취소</button>
                  </div>
               </td>
            </tr>
            <%
               }
            %>
         </table>
         <%
            }
            }
         %>


         <!-- 페이징페이징 -->
         <div class="pagingArea" align="center">
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage=1'"><<</button>
            <%
               if (currentPage <= 1) {
            %>
            <button disabled><</button>
            <%
               } else {
            %>
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage=<%=currentPage - 1%>'"><</button>
            <%
               }
            %>

            <%
               for (int p = startPage; p <= endPage; p++) {
                  if (p == currentPage) {
            %>
            <button disabled><%=p%></button>

            <%
               } else {
            %>
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage=<%=p%>'"><%=p%></button>
            <%
               }
               }
            %>

            <%
               if (currentPage >= maxPage) {
            %>
            <button disabled>></button>
            <%
               } else {
            %>
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage=<%=currentPage + 1%>'">></button>
            <%
               }
            %>
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage=<%=maxPage%>'">>></button>
         </div>
         <!-- --------------------- -->


      </div>


      <!-- 취소/교환 조회 영역 -->
      <div id="tab-2" class="tabContent">
         <div class="searchWrap">
            <!-- <table class="searchTable">
               <tr height="50px" style="">
                  <td style="background: white;" colspan="2"></td>
               </tr>
               <tr>
                  <td>기간 검색</td>
                  <td><input type="text" id="datepicker3">~<input
                     type="text" id="datepicker4">
                     <button>1개월</button>
                     <button>3개월</button>
                     <button>6개월</button>
                     <button>전체</button></td>
               </tr>
            </table> -->
         </div>


         <%
            for (OrderStatus os3 : list2) {
         %>
         <table class="resultTable">
            <colgroup>
               <col width="15%">
               <col width="55%">
               <col width="10%">
               <col width="10%">
               <col width="10%">
            </colgroup>
            <tr>
               <th colspan="5" style="font-size: 20px">주문일 : <%=os3.getOrderDate()%></th>
            </tr>
            <tr>
               <td rowspan="2"><img height="120px" width="120px"
                  src="<%=request.getContextPath()%>/image/productImg/<%=os3.getChangeName()%>"></td>
               <td rowspan="2"><%=os3.getProductName()%></td>
               <td rowspan="2"><%=os3.getPrice()%>원</td>
               <td rowspan="2"><%=os3.getStatus()%><br>
               <br> <%-- <% if(os.getStatus().equals("배송완료")){ %> --%> <!-- <button id="confirm" style="background:#6E00AB; border:1px solid #6E00AB;">구매확정</button> -->
                  <%--<% }else{ 
               <button id="confirm" disabled>구매확정</button>
               <% } %>--%></td>
               <td>
                  <div>
                     <button class="deliverBtn"
                        style="background: #BABABA; border: 1px solid #BABABA;" disabled>배송조회</button>
                  </div>


               </td>
            </tr>

            <tr>
               <td>
                  <div>
                     <button class="cancelBtn" id="cancelBtn"
                        style="background: #BABABA; border: 1px solid #BABABA;" disabled>구매취소</button>
                  </div>
               </td>
            </tr>
         </table>


         <%
            }
         %>


         <!-- 페이징페이징 -->
         <div class="pagingArea" align="center">
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage2=1'"><<</button>
            <%
               if (currentPage2 <= 1) {
            %>
            <button disabled><</button>
            <%
               } else {
            %>
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage2=<%=currentPage2 - 1%>'"><</button>
            <%
               }
            %>

            <%
               for (int p = startPage2; p <= endPage2; p++) {
                  if (p == currentPage2) {
            %>
            <button disabled><%=p%></button>

            <%
               } else {
            %>
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage2=<%=p%>'"><%=p%></button>
            <%
               }
               }
            %>

            <%
               if (currentPage2 >= maxPage2) {
            %>
            <button disabled>></button>
            <%
               } else {
            %>
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage2=<%=currentPage2 + 1%>'">></button>
            <%
               }
            %>
            <button
               onclick="location.href='<%=request.getContextPath()%>/selectOrderList.or?currentPage2=<%=maxPage2%>'">>></button>
         </div>
         <!-- --------------------- -->
      </div>

      <br>
      <br>








      <!-- 안내이미지 영역 -->
      <div class="infoImg">
         <img src="/forest/image/userimg/deliveryInfo.jpg">
      </div>





      <!------------------------ 주문취소 모달 영역 ------------------------->
      <!-- The Modal -->
      <div id="myModal" class="modal">

         <!-- Modal content -->
         <div class="modal-content">
            <span class="close">&times;</span>
            <div class="modalTop"></div>
            <table class="modalTb">
               <colgroup>
                  <col width="40%">
                  <col width="20%">
                  <col width="40%">
               </colgroup>
               <tr>
                  <td rowspan="4" style="text-align: center;" class="moPhoto"></td>
                  <td>주문번호</td>
                  <td class="moNo"></td>
               </tr>
               <tr>
                  <td>상품명</td>
                  <td class="moName"></td>
               </tr>
               <tr>
                  <td>고객명</td>
                  <td class="moUser"></td>
               </tr>
               <tr>
                  <td>금액</td>
                  <td class="moPri"></td>
               </tr>
               <tr>
                  <td colspan="3"><b>취소안내</b><br>
                  <br> 1. 본 상품의 취소는 승인 후 처리되오니 1~2일의 시간이 소요될 수 있습니다.<br>
                     2. 상품 준비상태에서의 취소에서는 위약금 또는 다른 비용이 발생하지않습니다.<br> 3. 빠른 취소를
                     원하시는 분은 신청 후 고객센터를 이용해주시면 감사하겠습니다.<br> 4. 취소 후 상품 재주문은 가능하나
                     취소한 주문진행으로 복구할 수 없습니다.<br> 5. 공휴일 또는 주말에는 처리가 되지않고 평일에 진행되오니
                     이 점 양해부탁드립니다.<br> 6. 이미 배송이 시작되거나 상품을 받은 후 취소는 특정한 사유가 아닌 경우
                     취소가 불가하오니 이 점 미리 참고하여주시기 바랍니다.<br> 7. 상품이 배송준비상태라면 고객센터에서 해당
                     취소를 진행주시기 바랍니다.<br> 8. 취소 후 고객님의 취소 정보는 주문현환 > 취소/교환 조회에서 확인
                     하실 수 있습니다.<br> 9. 상품 수령 후 3일내의 특정 사유 또는 포장상자를 개봉하지 않은 경우 취소가
                     아닌 환불 절차를 이용해주시기 바랍니다.<br></td>
               </tr>
               <tr>
                  <td colspan="3"><input type="checkbox" id="check"
                     class="checkk"><label for="check">위 안내를 다 읽고
                        동의하시면 체크를 눌러주세요.</label></td>
               </tr>
            </table>

            <div class="modalBtn">
               <span><button class="buyCancel" id="buyCancel" value=""
                     disabled>구매취소</button></span>&nbsp; <span><button class="cancel">취소</button></span>
            </div>
         </div>

      </div>



      <!------------------------------- 구매확정 modal 영역 -------------------------------->
      <!-- The Modal 구매확정 -->
      <div id="myModal2" class="modal2">

         <!-- Modal content -->
         <div class="modal-content2">
            <span class="close">&times;</span>
            <div class="modalTop"></div>
            <table class="modalTb2">
               <colgroup>
                  <col width="40%">
                  <col width="20%">
                  <col width="40%">
               </colgroup>
               <tr>
                  <td rowspan="4" style="text-align: center;" class="moPhoto2"></td>
                  <td>주문번호</td>
                  <td class="moNo2"></td>
               </tr>
               <tr>
                  <td>상품명</td>
                  <td class="moName2"></td>
               </tr>
               <tr>
                  <td>고객명</td>
                  <td class="moUser2"></td>
               </tr>
               <tr>
                  <td>금액</td>
                  <td class="moPri2"></td>
               </tr>
               <tr>
                  <td colspan="3">상품수령 전에 구매자확정하는 경우 모든 책임은 구매회원에게 있으며 회사는 <br>
                     어떠한 책임도 부담하지 않습니다.
                  </td>
               </tr>
               <tr>
                  <td colspan="3"><input type="checkbox" id="check2"
                     class="checkk"><label for="check2">위 안내를 다 읽고
                        동의하시면 체크를 눌러주세요.</label></td>
               </tr>
            </table>

            <div class="modalBtn">
               <span><button class="cancel">취소</button></span>&nbsp; <span><button
                     class="buyCancel" id="buyConfirm" disabled>구매확정</button></span>
            </div>
         </div>

      </div>

   </section>

   <script>
      //탭메뉴-----------------------------------------------------------------------
      $(function() {
         $(".tab li").click(function() {
            var tab_id = $(this).attr('data-tab');

            $(".tab li").removeClass("current");
            $(".tabContent").removeClass("current");

            $(this).addClass("current");
            $("#" + tab_id).addClass("current");
         });

         $(".checkk").click(function() {

            if ($(".checkk").is(":checked")) {
               $(".buyCancel").attr("disabled", false);
               $(".buyCancel").css("background", "#6E00AB");

            } else {
               $(".buyCancel").attr("disabled", true);
               $(".buyCancel").css("background", "#BABABA");
               $(".buyCancel").css("border", "1px solid #BABABA");
            }
            ;
         });
         
         $(".bodyNav").each(function(){
            if($(this).text()=="주문현황"){
               $(this).css("background", "#6E00AB");
               $(this).children().css("color", "white");
            }
         })
               
      });

      function delivery(value) {
         var halfWith = (document.body.offsetWidth / 2);
         var halfHeight = (document.body.offsetHeight / 2);
         var popupX = halfWith - (600 / 2);
         //&nbsp;만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

         var popupY = halfHeight - (850 / 2);
         //&nbsp;만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

         window.open("<%=request.getContextPath()%>/selectDelivery?orderCode="+value, "tms","width=600, height=850, top=100px,left="+popupX);
      };
      
      
      //달력-----------------------------------------------------------------------------------------
      /* 날짜 input jquery ui */
         $.datepicker.setDefaults({
            showOn : "both",
            buttonImage : "/forest/image/calendar.png",
            buttonImageOnly : true,
            dateFormat : 'yy-mm-dd'

         });
         $(function() {
            $("#datepicker").datepicker({});
            $("#datepicker1").datepicker({});
            $("#datepicker3").datepicker({});
            $("#datepicker4").datepicker({});
            /* 달력버튼 */
            $("img.ui-datepicker-trigger").attr("style","margin-left:2px; vertical-align:middle; cursor: Pointer; width:30px; height:30px");

         });
         
         //modal-----------------------------------------------------------
         
         var modal = document.getElementById('myModal');
         var btn = document.getElementById('cancelBtn');
         var cancelBtn = document.getElementById('buyCancel');
         var orderNoVal = '';
         // Get the <span> element that closes the modal
         var span = document.getElementsByClassName("close")[0];
         
         
         function modal1(value, productName, userName, price, photo) {
             modal.style.display = "block";
             orderNoVal = value;
             var productNameVal = productName;
             var userNameVal = userName;
             var priceVal = price;
             $(".moNo").text(orderNoVal);
             $(".moName").text(productNameVal);
             $(".moUser").text(userNameVal);
             $(".moPri").text(priceVal);
             $(".moPhoto").html("<img src='<%=request.getContextPath()%>/image/productImg/"+photo+"'>")
         }
         // When the user clicks on <span> (x), close the modal
         span.onclick = function() {
             modal.style.display = "none";
         }
         
         
         
         cancelBtn.onclick = function(){
            location.href="<%= request.getContextPath()%>/cancel.or?orderNo=" + orderNoVal;
         }
      
         var modal2 = document.getElementById('myModal2');
         var btn2 = document.getElementById('confirm');
         var buyConfirmBtn = document.getElementById('buyConfirm');
         var orderCodeVal = '';
         
         function modal3(value, productName, userName, price, orderCode, photo){
             modal2.style.display = "block";
             orderNoVal = value;
             orderCodeVal = orderCode;
             var productNameVal = productName;
             var userNameVal = userName;
             var priceVal = price;
             $(".moNo2").text(orderNoVal);
             $(".moName2").text(productNameVal);
             $(".moUser2").text(userNameVal);
             $(".moPri2").text(priceVal);
             $(".moPhoto2").html("<img src='<%=request.getContextPath()%>/image/productImg/"+photo+"'>")
         }
         
         // Get the <span> element that closes the modal
         var span2 = document.getElementsByClassName("close")[1];
         
         /* btn2.onclick = function() {
             modal2.style.display = "block";
         } */
         // When the user clicks on <span> (x), close the modal
         span2.onclick = function() {
             modal2.style.display = "none";
         }
         
         buyConfirmBtn.onclick = function(){
            location.href="<%=request.getContextPath()%>/confirm.or?orderCode="+orderCodeVal;
         }
      
         
         $(".cancel").click(function(){
            modal.style.display = "none";
            modal2.style.display = "none";
         })
   </script>

   <%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp"%>
</body>
</html>