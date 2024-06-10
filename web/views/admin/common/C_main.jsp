<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap, java.util.List, com.kh.forest.notice.model.vo.Notice"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%
	HashMap<String, Integer> map = (HashMap<String, Integer>) request.getAttribute("map");
	HashMap<String, Integer> orderCount = (HashMap<String, Integer>) request.getAttribute("orderCount");
	List<Notice> list = (List<Notice>)request.getAttribute("list");
	
	Calendar cal = Calendar.getInstance();

	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");

	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);

	if(strYear != null){
	  year = Integer.parseInt(strYear);
	  month = Integer.parseInt(strMonth);

	}else{

	}
	cal.set(year, month, 1);

	int startDay = cal.getMinimum(java.util.Calendar.DATE);
	int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
	int newLine = 0;

	Calendar todayCal = Calendar.getInstance();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");

	int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	.statusTb {
		width:100%;
		text-align:center;
		border-collapse: collapse;
	}
	.statusTb tr:first-of-type{
		background:#354052;
		color:white;
	}
	.currentTable {
		width:100%;
		border-collapse:collapse;
		text-align:center;
		height:120px;
	}
	
	.currentTable tr:first-of-type {
		height:20px;
	}
	.currentTable tr:last-of-type {
		height:10px;
		color:blue;
	}
	 .divDotText {
        overflow:hidden;
        text-overflow:ellipsis;
    }
</style>
</head>
<body onload="ready('중고구마', '메인', '메인');">
	
	<%@ include file="../common/C_menubar.jsp" %>
	
		<article>
			<div><p style="font-weight:bold; font-size:20px;">쇼핑몰 현황</p></div>
			
			<table class="statusTb" border="1">
			<colgroup>
				<col width="20%" style="background:#E8E8E8;">
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
			</colgroup>
				<tr>
					<th>항목</th>
					<th>오늘</th>
					<th>어제</th>
					<th>지난주</th>
					<th>이번달</th>
				</tr>
				<tr>
					<td>주문 수(건)</td>
					<td><%=map.get("oc1") %>건</td>
					<td><%=map.get("oc2") %>건</td>
					<td><%=map.get("oc3") %>건</td>
					<td><%=map.get("oc4") %>건</td>
				</tr>
				<tr>
					<td>주문금액</td>
					<td><%=map.get("op1") %>원</td>
					<td><%=map.get("op2") %>원</td>
					<td><%=map.get("op3") %>원</td>
					<td><%=map.get("op4") %>원</td>
				</tr>
				<tr>
					<td>매입 수(건)</td>
					<td><%=map.get("bc1") %>건</td>
					<td><%=map.get("bc2") %>건</td>
					<td><%=map.get("bc3") %>건</td>
					<td><%=map.get("bc4") %>건</td>
				</tr>
				<tr>
					<td>매입액(원)</td>
					<td><%=map.get("bp1") %>원</td>
					<td><%=map.get("bp2") %>원</td>
					<td><%=map.get("bp3") %>원</td>
					<td><%=map.get("bp4") %>원</td>
				</tr>
				<tr>
					<td>신규회원(명)</td>
					<td><%=map.get("m1") %>명</td>
					<td><%=map.get("m2") %>명</td>
					<td><%=map.get("m3") %>명</td>
					<td><%=map.get("m4") %>명</td>
				</tr>
				<tr>
					<td>리뷰글(건)</td>
					<td><%=map.get("rc1") %>건</td>
					<td><%=map.get("rc2") %>건</td>
					<td><%=map.get("rc3") %>건</td>
					<td><%=map.get("rc4") %>건</td>
				</tr>
			</table>
		</article>
		<article>
			<div>
				<div style="display:inline-flex; width:49%; height:320px;">
				<table id="noticeTable" style="width:100%; border-collapse:collapse; height:100%; margin:0;">
					 <tr><td colspan="4" style="color:#354052; font-weight:700; border-bottom:2px solid #D3D8E7;" onclick="location.href='<%= request.getContextPath() %>/selectList.no'">NOTICE ></td></tr> 
					<tr style="height:30px;">
						<th style="text-align:center; font-size:14px; width:50px; background:#D3D8E7; color:black;">번호</th>
						<th style="text-align:center; width:200px; background:#D3D8E7; color:black;">제목</th>
						<th style="text-align:center;width:80px; background:#D3D8E7; color:black;">작성자</th>
						<th style="text-align:center;width:80px; background:#D3D8E7; color:black;">일자</th>
					</tr>
					<%for(Notice n : list) { %>
					<tr style="border-bottom:1px solid #D3D8E7;; height:30px;">
						<td style="text-align:center;"><%=n.getnBoardNo() %></td>
						<td style="text-align:center;"><%=n.getnTitle() %></td>
						<td style="text-align:center;"><%=n.getnWriter() %></td>
						<td style="text-align:center;"><%=n.getnEnrollDate() %></td>
					</tr>
					
					<% } %>
					<tr style="height:20px;"><td colspan="4" style="color:#354052; font-weight:700; border-bottom:2px solid #D3D8E7;"></td></tr>
					</table>
					</div>
				<div style="display:inline-flex; width:49%; margin-left:10px; height:300px;">
<table border="0" cellspacing="1" cellpadding="1" bgcolor="white">
<thead>
<tr><td colspan="4" style="color:#354052; font-weight:700; "><%= year+"년 " + (month+1)+"월 " + date+"일" %></td></tr>
<tr bgcolor="#CECECE">
       <td width='100px' style="background:#D3D8E7;">
       <div align="center"><font color="black" style="font-weight:600;">일</font></div>
       </td>
      	<td width='100px' style="background:#D3D8E7;">
       <div align="center"><font color="black" style="font-weight:600;">월</font></div>
       </td>

       	<td width='100px' style="background:#D3D8E7;">
       <div align="center"><font color="black" style="font-weight:600;">화</font></div>
       </td>

       	<td width='100px' style="background:#D3D8E7;">
       <div align="center"><font color="black" style="font-weight:600;">수</font></div>
       </td>

       	<td width='100px' style="background:#D3D8E7;">
       <div align="center"><font color="black" style="font-weight:600;">목</font></div>
       </td>

      	<td width='100px' style="background:#D3D8E7;">
       <div align="center"><font color="black" style="font-weight:600;">금</font></div>
       </td>

       	<td width='100px' style="background:#D3D8E7;">
       <div align="center"><font color="black" style="font-weight:600;">토</font></div>
       </td>

	</tr>
	</thead>
	<tbody>
	<tr>
<%
for(int index = 1; index < start ; index++ ) {
  out.println("<TD >&nbsp;</TD>");
  newLine++;
}

for(int index = 1; index <= endDay; index++) {
       String color = "";

       if(newLine == 0){          
    	   color = "RED";
       }else if(newLine == 6){    
    	   color = "#529dbc";
       }else{                     
    	   color = "BLACK"; };


       String sUseDate = Integer.toString(year); 
       sUseDate += Integer.toString(month+1).length() == 1 ? "0" + Integer.toString(month+1) : Integer.toString(month+1);
       sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index) : Integer.toString(index);

 

       int iUseDate = Integer.parseInt(sUseDate);

       String backColor = "white";

       if(iUseDate == intToday ) {
             backColor = "#ECECEC";

       }

       out.println("<TD valign='top' align='left' height='55px' bgcolor='"+backColor+"' nowrap>");
       %>

       <font color='<%=color%>'>
             <%=index %>
              <%if(index==9) {%>
                <br><label style="font-size:14px; color:red;">중간발표</label>
             <% } %>
             
             <%if(index==12) {%>
                <br>&nbsp;&nbsp;&nbsp;<label style="font-size:14px; color:red;">발표!!</label>
             <% } %>
       </font>

    <% out.println("<BR>");
       out.println("<BR>");
       out.println("</TD>");

       newLine++;

       if(newLine == 7) {
         out.println("</TR>");
         if(index <= endDay) {
           out.println("<TR>");
         }
         newLine=0;
       }
	}

	while(newLine > 0 && newLine < 7) {
  				newLine++;
	}									%>

</tr>
</tbody>
</table>
				
				</div>
			</div>
		</article>
		
		<article>
			
			<div><p style="font-weight:bold; font-size:20px;">금일 주문처리별 현황</p></div>
			<table class="currentTable">
			<colgroup>
				<col width="11.1%" style="background-image:url('/forest/image/adminImg/blockArrow2.png'); background-size:100% 100%;">
				<col width="11.1%" style="background-image:url('/forest/image/adminImg/blockArrow2.png'); background-size:100% 100%;">
				<col width="11.1%" style="background-image:url('/forest/image/adminImg/blockArrow2.png'); background-size:100% 100%;">
				<col width="11.1%" style="background-image:url('/forest/image/adminImg/blockArrow4.png'); background-size:100% 100%;">
				<col width="11.1%" style="background-image:url('/forest/image/adminImg/blockArrow3.png'); background-size:100% 100%;">
				<col width="11.1%" style="background-image:url('/forest/image/adminImg/blockArrow4.png'); background-size:100% 100%;">
			</colgroup>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>&nbsp;&nbsp;&nbsp;결제완료</label></td>
					<td><label>&nbsp;&nbsp;&nbsp;상품준비</label></td>
					<td><label>&nbsp;&nbsp;&nbsp;배송중</label></td>
					<td><label>&nbsp;&nbsp;&nbsp;배송완료</label></td>
					<td><label>&nbsp;&nbsp;&nbsp;인수완료</label></td>
					<td><label>&nbsp;&nbsp;&nbsp;주문취소</label></td>
				</tr>
				<tr>
					<td><%=orderCount.get("order1") %></td>
					<td><%=orderCount.get("order2") %></td>
					<td><%=orderCount.get("order3") %></td>
					<td><%=orderCount.get("order4") %></td>
					<td><%=orderCount.get("order5") %></td>
					<td><%=orderCount.get("order6") %></td>
				</tr>
			</table>
		</article>
	<%@ include file="../common/C_menubar2.jsp" %>
	
</body>
</html>