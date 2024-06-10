<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kh.forest.product.model.vo.A_ProductStatic "%>
<%@ page import="com.kh.forest.product.model.vo.A_ProductMonthlyStatic "%>

<%
	A_ProductStatic proStatic = (A_ProductStatic)request.getAttribute("proStatic");
	ArrayList<A_ProductMonthlyStatic> list = (ArrayList<A_ProductMonthlyStatic>) request.getAttribute("proMonthly");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>

<style>
.chartDiv{
	margin: 0 auto;
}
#chart_Title{
	width: 100%;
	height: 100px;
	line-height: 100px;
	font-size: 25px;
	font-weight: 800;
	text-align: center;
	color:#16AAD8;
}

select[name=select_month]{
	width: 100px;
    height: 25px;
}

</style>

</head>
<body onload="ready('상품 통계', '통계관리', '상품 통계');">
	<%@ include file="../common/C_menubar.jsp"%>

<div class="chartDiv" style="width:800px">
	<div id="chart_Title">현재 보유중인 상품</div>
    <canvas id="currentProduct"></canvas>
</div>

<div class="chartDiv" style="width:800px">
	<div id="chart_Title">진행 상황별 상품</div>
	<div style="text-align: center; margin-bottom: 30px;">
		<select name="select_month">
		    <!-- <option value="2020-02">2020-02</option> -->
		    <!-- <option value="2020-03">2020-03</option> -->
		</select>
		<input type="button" value="조회" onclick="monthly();" style="background:#16AAD8; color:white; border:none; width:70px; height:25px; border-radius: 5px 5px 5px 5px;">
	</div>
    <canvas id="monthlyProduct"></canvas>
</div>

<script>



$(function(){
	var $select = $("select[name=select_month]");
	
	//var $option = "<option value='2020-03'>2020-03</option>"
	var $option;
	
	<% for(int i = list.size() - 1 ; i >= 0; i--) {%>
		$option = "<option>" + '<%= list.get(i).getRequestDate() %>' + "</option>";
		$select.append($option);
	<% } %>
	//console.log($option);
	
	<%-- one = parseInt(<%= list.get(list.size()-1).getFirstRequest()%>); --%>
	
});

function monthly(){

	var month = $("select[name=select_month]").val();
	
	<%-- console.log(month);
	console.log("<%= list.get(0).getRequestDate() %>");
	console.log("<%= list.get(1).getRequestDate() %>"); --%>
	
	<% for(int i = list.size() - 1 ; i >= 0; i--) { %>
		if(month == "<%= list.get(i).getRequestDate()%>"){

			var dataset = config.data.datasets;
			/* console.log(dataset[0].data[0]);
			console.log(dataset[0].data[1]); */
			dataset[0].data[0] = <%= list.get(i).getFirstRequest()%>;
			dataset[0].data[1] = <%= list.get(list.size()-1).getFirstComplete()%>;
		    dataset[0].data[2] = <%= list.get(list.size()-1).getFirstFail()%>;
		    dataset[0].data[3] = <%= list.get(list.size()-1).getSecondComplete()%>;
		    dataset[0].data[4] = <%= list.get(list.size()-1).getCancel()%>;
		    dataset[0].data[5] = <%= list.get(list.size()-1).getComplete()%>;
		    dataset[0].data[6] = <%= list.get(list.size()-1).getWaiting()%>;
		    dataset[0].data[7] = <%= list.get(list.size()-1).getReceive()%>;
		    
		    myPieChart.update();
			
		}	
	<% } %>
}





//가운데 구멍이 없는 파이형 차트 
var ctx1 = document.getElementById("monthlyProduct"); 
var config = { 
		
		type: 'pie', 
		data: { 
				datasets: [{ 
					backgroundColor: [
						'#87CEFA',
		                '#1EA4FF', 
		                '#96A5FF',
		                '#828282',
		                '#5A5AFF',
		                '#483D8B',
		                '#0064CD',
		                '#354052'
					], 
					data: [<%= list.get(list.size()-1).getFirstRequest()%>
					     , <%= list.get(list.size()-1).getFirstComplete()%>
					     , <%= list.get(list.size()-1).getFirstFail()%>
					     , <%= list.get(list.size()-1).getSecondComplete()%>
					     , <%= list.get(list.size()-1).getCancel()%>
					     , <%= list.get(list.size()-1).getComplete()%>
					     , <%= list.get(list.size()-1).getWaiting()%>
					     , <%= list.get(list.size()-1).getReceive()%>] 
				}], 
				labels: ['1차검수신청','1차검수완료','1차검수탈락','2차검수완료','매입불가','매입완료','인수대기중','인수완료'] 
		}, 
		options: {} 

};
var myPieChart = new Chart(ctx1, config);

// 우선 컨텍스트를 가져옵니다. 
var ctx = document.getElementById("currentProduct").getContext('2d');
/*
- Chart를 생성하면서, 
- ctx를 첫번째 argument로 넘겨주고, 
- 두번째 argument로 그림을 그릴때 필요한 요소들을 모두 넘겨줍니다. 
*/
var currentProduct = new Chart(ctx, {
    type: 'bar',
    data: {
        //labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
        labels: ["노트북", "태블릿PC", "생활가전", "주방가전", "미용가전"],
        datasets: [{
            //label: ["노트북", "태블릿PC", "생활가전", "주방가전", "미용가전"],
            //data: [12, 19, 3, 5, 2, 3],
            data: [<%= proStatic.getNotebook() %>
            	 , <%= proStatic.getTablet() %>
            	 , <%= proStatic.getLife()%>
            	 , <%= proStatic.getKitchen()%>
            	 , <%= proStatic.getBeauty()%>
            ],
            backgroundColor: [
            	 '#1EA4FF', 
                 '#96A5FF',
                 '#828282',
                 '#5A5AFF',
                 '#483D8B',
            ],
            borderWidth: 1
        }]
    },
    options: {
        maintainAspectRatio: true, 	// default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
        legend: {					// 막대 그래프 제목 지우기
            display: false
        },
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
</script>

<%@ include file="../common/C_menubar2.jsp"%>
</body>
</html>