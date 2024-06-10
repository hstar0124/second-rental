<%@ page language="java" contentType="application/vnd.ms-excel;charset=UTF-8" %><%@ page language="java" import="java.util.*,com.kh.forest.point.model.vo.CashbackHistory" %>

<% 
  java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy_MM_dd");
  String today = formatter.format(new java.util.Date());
  String file_name = "CashBack_" + today;
  String ExcelName  = new String(file_name.getBytes(),"euc-kr")+".xls";
  response.setContentType("application/vnd.ms-excel");
  response.setHeader("Content-Disposition", "attachment; filename="+ExcelName);
  response.setHeader("Pragma", "no-cache"); 
  List<CashbackHistory> waitList = (List)request.getAttribute("waitList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<table class="resultTable">
         <tr>
            <th class="resultTableTh"><label>환급번호</label></th>
            <th class="resultTableTh"><label>환급금액</label></th>
            <th class="resultTableTh"><label>회원명</label></th>
            <th class="resultTableTh"><label>은행명</label></th>
            <th class="resultTableTh"><label>지급계좌</label></th>
            <th class="resultTableTh"><label>일시</label></th>
         </tr>
         <% for(CashbackHistory c : waitList) {%>
			<tr>
            	<td class="resultTableTd"><%=c.getCashbackNo() %></td>
            	<td class="resultTableTd"><%=c.getMoney() %>원</td>
            	<td class="resultTableTd"><%=c.getUserName() %></td>
           	    <td class="resultTableTd"><%=c.getBankName()%></td>
           	    <td class="resultTableTd"><%=c.getAccount()%></td>
            	<td class="resultTableTd"><%=c.getCashbackDate() %></td>
			</tr>         
         <% }%>
         </table>

</body>
</html>