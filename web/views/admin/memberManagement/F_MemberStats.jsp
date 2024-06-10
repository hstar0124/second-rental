<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.forest.member.model.vo.MemberStats"%>
<%
 HashMap<String, Integer> map = (HashMap<String, Integer>)request.getAttribute("memberMonth");
 HashMap<String, Integer> history = (HashMap<String, Integer>)request.getAttribute("memberHistory");
 MemberStats memberStats = (MemberStats) request.getAttribute("memberStats");
 String year = (String) request.getAttribute("year");
 String month = (String) request.getAttribute("month");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<style>
	#statsTable{
		width:100%;
		margin:0 auto;
		margin-left:20px;
		border:1px solid black;
		border-collapse: collapse;
		margin-top:10px;
		margin-bottom:100px;
	}
	.crmBtn{
	border:none;
	background:white;
	outline:none;
	cursor: pointer;
}
</style>

</head>
<body>

<body onload="ready('회원통계','통계관리','회원통계');">
   <%@ include file="../common/C_menubar.jsp" %>

   <article>
      <div style="width:100%;"><label style="margin-left:40px; font-size:26px; color:#16AAD8; font-weight:600;"><%="20"+year +"년" %></label><label style="margin-left:5px; font-size:24px;"> 신규회원 통계</label>
        <select id="year" name="year" style="height:30px; width:100px; margin-left:400px; font-weight:600;">
           <option value="19">2019년</option>
           <option value="20">2020년</option>
           <option value="21">2021년</option>
           <option value="22">2022년</option>
        </select> 
         <select id="month" name="month" style="height:30px; width:60px; font-weight:600;">
           <option value="01">1월</option>
           <option value="02">2월</option>
           <option value="03">3월</option>
           <option value="04">4월</option>
           <option value="05">5월</option>
           <option value="06">6월</option>
           <option value="07">7월</option>
           <option value="08">8월</option>
           <option value="09">9월</option>
           <option value="10">10월</option>
           <option value="11">11월</option>
           <option value="12">12월</option>
        </select> 
        
        <input type="button" value="조회" id="monthChart" style="background:#16AAD8; color:white; border:none; width:70px; height:25px; cursor: pointer; border-radius: 5px 5px 5px 5px;">
        <canvas id="canvas" style="margin-bottom:30px;"></canvas>
        <label style="margin-left:30px; font-size:20px; color:#16AAD8; font-weight:600;"><%="20"+year +"년 "+ month+"월" %></label><label style="margin-left:5px; font-size:20px;">회원 비율</label>
		<table id="statsTable">
			<tr style="background:#A7C0E9;">
				<th>년/월</th>
				<th>신규가입</th>
				<th>남녀비율</th>
				<th>20대</th>
				<th>30대</th>
				<th>40대</th>
				<th>50대</th>
				<th>60대</th>
				<th>상세</th>
			</tr>
			<tr>
				<td style="text-align:center;"><%=year%>년/<%=month%>월</td>
				<td style="text-align:center;"><%=memberStats.getNewMember() %>명</td>
				<td style="text-align:center;"><%=memberStats.getMenCount() %>명 / <%=memberStats.getWomenCount() %>명 </td>
				<td style="text-align:center;"><%=memberStats.getTwo() %>명</td>
				<td style="text-align:center;"><%=memberStats.getThree() %>명</td>
				<td style="text-align:center;"><%=memberStats.getFour() %>명</td>
				<td style="text-align:center;"><%=memberStats.getFive() %>명</td>
				<td style="text-align:center;"><%=memberStats.getSix() %>명</td>
				<td style="text-align:center;"><input type="button" class="crmBtn" id="crmBtn"><img src="<%=request.getContextPath()%>/image/userimg/crm.PNG" width="20px" style="margin-right:10px; cursor: pointer;"></td>
			</tr>
		</table>
		 <label style="margin-left:30px; font-size:20px; color:#16AAD8; font-weight:600;"><%="20"+year +"년 "+ month+"월" %></label><label style="margin-left:5px; font-size:20px;">회원이력 비율</label>
		<% if(!(history.get("delete").equals(0) &&history.get("warning").equals(0) && history.get("login").equals(0))){ %>
		<canvas id="canvas1" style="width:100%; height:400px; margin-top:5px;"></canvas>
		<%}else{ %>
			<br><br><br><label style="margin-left:390px; font-size:18px;">해당 된 조회 년월에는 정보가 없습니다.</label>
		<% } %>
      </div>
   
   </article>
<%@ include file="../common/C_menubar2.jsp" %>

<script>
new Chart(document.getElementById("canvas"), {
    type: 'line',
    data: {
        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        datasets: [{
            label: '신규회원',
            data: [
                <%=map.get("Jan")%>,
                <%=map.get("Feb")%>,
                <%=map.get("Mar")%>,
                <%=map.get("Apr")%>,
                <%=map.get("May")%>,
                <%=map.get("Jun")%>,
                <%=map.get("Jul")%>,
                <%=map.get("Aug")%>,
                <%=map.get("Sep")%>,
                <%=map.get("Oct")%>,
                <%=map.get("Nov")%>,
                <%=map.get("Dec")%>
                
            ],
            borderColor: "#16AAD8",
            backgroundColor: "white",
            fill: true,
            lineTension: 0
        }]
    },
    options: {
        responsive: true,
        title: {
            display: true,
        },
        tooltips: {
            mode: 'index',
            intersect: false,
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: '월별'
                }
            }],
            yAxes: [{
                display: true,
                ticks: {
                    suggestedMin: 0,
                },
                scaleLabel: {
                    display: true,
                    labelString: '신규회원수(명)'
                }
            }]
        }
    }
});

</script>

<script>
var canvas = document.getElementById("canvas1");
var ctx = canvas.getContext('2d');

 Chart.defaults.global.defaultFontColor = 'black';
 Chart.defaults.global.defaultFontSize = 16;

var data = {
    labels: ["로그인 실패 ", "회원 제제", "회원 탈퇴"],
      datasets: [
        {
            fill: true,
            backgroundColor: [
                '#16AAD8',
                '#A7C0E9', '#354052'],
                
            data: [<%= history.get("login")%>, <%= history.get("warning")%>, <%= history.get("delete")%>],
            borderColor:[],
            borderWidth: []
        }
    ]
};


var options = {
        title: {
                  display: true,
                  text: '회원 이력',
                  position: 'top'
              },
        rotation: -0.7 * Math.PI
};


var myBarChart = new Chart(ctx, {
    type: 'pie',
    data: data,
    options: options
});
</script>



<script>
   $("select[name=year]").children().filter(function(){
       if($(this).val()==<%=year%>){
         $(this).attr("selected", true); 
       }else{
          $(this).attr("selected", false); 
       }
   });
   $("select[name=month]").children().filter(function(){
       if($(this).val()==<%=month%>){
         $(this).attr("selected", true); 
       }else{
          $(this).attr("selected", false); 
       }
   });
   
		$("#statsTable td").click(function(){
			 var num = $("#year").val();
		     var month = $("#month").val();
			$(this).parent().children().eq(8).click(function(){
				 window.open('<%= request.getContextPath()%>/statsMemberList.me?sysdate='+num +'&month='+month, "pop01", "top=100,left=300,width=600,height=500,location=no,scrollbars=no,status=no,resizable=0,titlebar=no,menubar=no,directories=no"); 
			});
		});


   $("#monthChart").click(function(){
      var num = $("#year").val();
      var month = $("#month").val();
      location.href = '<%=request.getContextPath()%>/getYear.me?sysdate='+num +'&month='+month;
   });
</script>
</body>
</html>