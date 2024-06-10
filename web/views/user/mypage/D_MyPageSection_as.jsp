<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
#noticeSection {
	width: 100%;
}

.mainText {
	text-align: center;
	margin: auto;
}

.divMargin {
	margin: 0 auto;
}
.search {
width: 100%;
height: 150px;
background:center;
margin: 0 auto;
}
.searchGrid {
	width:100%;
	height: 60px;
}
#as{
		background:#6E00AB;
		color: white;
	}


</style>
<title>중고구마</title>
</head>
<body>
	<div>
		<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp"%>
		<table align="center" id="noticeSection">
			<tr>
				<td colspan="6"><h1>A/S신청내역</h1></td>
			</tr>
			<tr>
				<td colspan="6"><div style="background-color: purple; width: 100%; height: 4px;"></div></td>
			</tr>
		</table>
		<!--  <div class="search"> -->
		<table class="searchGrid">
			<colgroup>
				<col width="20%" style="background: rgba(218, 218, 218, 0.459)"
					text-align="center">
			<col style="background: rgba(212, 212, 212, 0.253)">
			</colgroup>
			<tr>
				<td align="center"><b>날짜 검색</b></td>
					<td>
						&nbsp;&nbsp;
						<button onclick="">오늘</button>
						<button onclick="">이번주</button>
						<button onclick="">이번달</button>
						<button onclick="">전체</button>
						&nbsp;&nbsp;
						<input type="text" id="datepicker">~<input type="text" id="datepicker1">
						&nbsp;&nbsp;						
						<button class="ui blue button">조회</button>
					</td>
			</tr>
			<br>
        </table>
<!--     </div> -->
		<br><br>
		<table align="center" id="noticeSection">
			<colgroup>
				<col style="width: 15%;">
				<col style="width: 15%;">
				<col style="width: 40%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
			</colgroup>
			<div align="center">
			</div>
			<br>
			<tr style="height: 40px;"></tr>
			<tr>
				<td colspan="6"><div
						style="background-color: black; width: 100%; height: 4px;"></div></td>
			</tr>
			<tr>
				<td><p class="mainText"><b>접수 번호</b></p></td>
				<td><p class="mainText"><b>주문 번호</b></p></td>
				<td><p class="mainText"><b>상품명</b></p></td>
				<td><p class="mainText"><b>유형</b></p></td>
				<td><p class="mainText"><b>상태</b></p></td>
				<td><p class="mainText"><b>접수일</b></p></td>
			</tr>
			<tr>
				<td colspan="6"><div
						style="background-color: black; width: 100%; height: 2px;"></div></td>
			</tr>
			<tr>
				<td class="mainText" id="textValue">공란</td>
				<td class="mainText" id="textValue">공란</td>
				<td class="mainText" id="textValue">공란</td>
				<td class="mainText" id="textValue">공란</td>
				<td class="mainText" id="textValue">공란</td>
				<td class="mainText" id="textValue">공란</td>
			</tr>
			<tr>
				<td colspan="6"><div
						style="background-color: black; width: 100%; height: 2px;"></div></td>
			</tr>
		</table>
	</div>
	<script>
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
			/* 달력버튼 */
			$("img.ui-datepicker-trigger")
					.attr("style","margin-left:2px; vertical-align:middle; cursor: Pointer; width:30px; height:30px");

		});
	
	</script>
		<%@ include file="/views/user/common/B_UserMainFooter.jsp"%>
</body>
</html>