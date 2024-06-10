<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>
<style>
	#refundsTable{
		width:100%;
		margin:0 auto;
		margin-top: 30px;
	}
	#point{
		margin-top: 12px;
		margin-left:120px;
		font-size:24px;
		color:red;
		font-weight:600;
	}
	#td1{
		margin-left:280px;
	}
	#pointBar{
		weight:100%;
		height:2px;
		background:#BABABA;
	}
	#fundsTable{
		width:100%;
		margin:0 auto;
		margin-top: 30px;
		margin-bottom: 70px;
		
	}
	#lb5{
		font-weight:700;
		font-size:24px;
	}
	.lbc{
		margin-left:50px;
	}
	.point1{
		margin-top: 12px;
		margin-left:100px;
		font-size:24px;
		color:red;
		font-weight:600;
		margin-top: 20px;
	}
	#div1{
		width:200px;
		height:60px;
		margin:0 auto;
		display:inline-flex;
	}
	#div2{
		display:inline-block;
		width:80px;
		height:120px;
		margin:0 auto;
	}
	#lb6{
		font-size:24px;
		font-weight:600;
	}
	
	#p1,#p2,#p3,#p4{
		text-align:center;
		width:200px;
		height:60px;
		font-weight:600;
		font-size:18px;
		color:#6E00AB;
	}
	#td3{
		color:red;
		font-size:14px;
		text-align:center;
	}
	#usePoint{
		border-radius: 10px 10px 10px 10px;
		outline:none;
		border:1px solid #CACACA;
		background:white;
		height:30px;
		color:#6E00AB;
		font-size:18px;
		font-weight:600;
		width:180px;
	}
	#refundsM{
		font-size:24px;
		font-weight:600;
		text-align:center;
	}
	#next{
		margin-left:445px;
		width:110px;
		height:40px;
		background: #ABABAB;
		border:none;
		color:white;
		font-size:18px;
		font-weight:600;
		cursor: pointer;
	}
	#next1{
		margin-left:445px;
		width:110px;
		height:40px;
		background: #6E00AB;
		border:none;
		color:white;
		font-size:18px;
		font-weight:600;
		display:none;
		cursor: pointer;
	}
	  .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 0px;
            border: 1px solid #888;
            width: 500px; /* Could be more or less, depending on screen size */                          
        	height:350px;
        }
        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        #modalTable{
         width:100%
        }
        #userOk{
        	font-size:24px;
        	maigin:0px;
        }
        #okInfo{
        	font-size:15.5px;
        }
        .top-title {
		background:#6E00AB;
		height: 50px;
		width: 500px;
}
.modal-content p {
	color: white;
	margin: 0px;
	padding-top: 15px;
	font-size: 17px;
}

#emailCode{
	width:100px;
	border:2px solid gray;
	margin-bottom:4px;
	height:25px;
}
#emailCodeCk{
	background:#6E00AB;
	outline:none;
	color:white;
	height:28px;
	border-radius: 3px 3px 3px 3px;
	border:none;
}
#ckOkBtn{
	background:#6E00AB;
	border:none;
	outline:none;
	color:white;
	height:40px;
	width:120px;
	margin-left:195px;
}
#td4{
	color:red;
	font-size:18px;
	text-align:center;
}
</style>
</head>
<body>
	<%@ include file="/views/user/mypage/A_MyPageNavOpen.jsp" %>
	<h1 class="text1">포인트 환급</h1>
		<div style="background-color:purple; width:100%; height:4px; margin-top:0px;"></div>
		<table id="refundsTable">
		<tr></tr>
			<tr>
				<td id="td1" style="display:flex"><img src="/forest/image/userimg/refundsPoint.PNG" width=200px;> <label id="point"><%= loginMember.getPoint() %> P</label></td>
			</tr>
			<tr height=20px;></tr>
			<tr><td><div id="pointBar"></div></td></tr>
		</table>
	<form action="<%= request.getContextPath()%>/cashbackInsert.po" method="post" id="form1">	
		<table id="fundsTable">
			<tr>
				<td>
					<div id="div1" style="margin-left:60px">
					<label id="lb6">환급 가능 고구마</label>
					</div>
				</td>
				<td rowspan="2">
					<div id="div1" style="width:80px">
					<img src="/forest/image/userimg/minus.PNG" width="50px" height="40px" style="margin-top: 20px">
					</div>
				</td>
				<td>
					<div id="div1" style="margin-left:80px">
					<label id="lb6">환급 고구마</label>
					</div>
				</td>
				<td rowspan="2">
					<div id="div1" style="width:80px">
					<img src="/forest/image/userimg/result.PNG" width="50px" height="40px" style="margin-top: 20px">
					</div>
				</td>
				<td>
					<div id="div1" style="margin-left:70px">
					<label id="lb6">남은 고구마</label>
					</div>
				</td>
			</tr>
			<tr>
				<td><div id="p1" style="margin:0 auto"></div></td>
				<td><div id="p2" style="margin:0 auto"><input type="text" id="usePoint" name="usePoint"></div></td>
				<td><div id="p3" style="margin:0 auto">0 P</div></td>
			</tr>
			<tr><td colspan="5" id="td4" style="visibility:hidden;">ss</td></tr>
			<tr height="30px"></tr>
			<tr>
				<td colspan="5" id="td3">※ 1,000 고구마 이상으로만 환급이 가능합니다.</td>
			</tr>
			<tr height="30px"></tr>
			<tr>
				<td colspan="5" id="refundsM">환급 금액</td>
			</tr>
			<tr height="10px"></tr>
			<tr>
				<td colspan="5"><div id="p4" style="margin:0 auto">0 원 </div><input type="text" name="cashbackMoney" id="cashbackMoney" value="ss" style="display:none;"></td>
			</tr>
			<tr height="30px"></tr>
			<tr><td colspan="5"><input type="button" id="next" value="본인인증" disabled><input type="button" id="next1" value="환급신청"><td></tr>
			<tr height="50px"></tr>
			<tr><td colspan="5"><img src="/forest/image/userimg/refundsInfo.PNG" style="margin-left:30px"></td></tr>
			<tr></tr>
		</table>
		</form>
    <!-- The Modal -->
    <div id="myModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
				<div class="top-title">
					<span class="close">&times;</span>
					<p style="padding-left: 20px;">본인확인</p>
				</div>                                                            
        <table id="modalTable">
        	<tr></tr>
        	<tr><td align="center"><label id="userOk">본인확인</label></td></tr>
        	<tr height="30px"></tr>
        	<tr><td align="center"><label id="okInfo">인증요청을 누르시면 등록되있으신 이메일로 인증메일이 발송됩니다.
					하단에 인증번호를 입력해주세요.</label></td></tr>
			<tr height="30px"></tr>
			<tr><td><label style="margin-left:100px; font-size:20px; font-weight:600; padding-top:15px;">인증번호 입력 : </label><input type="text" id="emailCode" name="emailCode">
				<input type="button" id="emailCodeCk" style="cursor: pointer;" value="인증요청">
			</td></tr>
			<tr height="50px"></tr>
			<tr><td><input type="button" id="ckOkBtn" style="cursor: pointer;" value="인증 완료"></td></tr>
        </table>
      </div>
 
    </div>
		<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("next");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];                                          

// When the user clicks on the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

</script>
	<script>
		var emailCode = "";
		$(function(){
			var num = $("#point").text().split("P")[0];
			var num1 = $("#point").text().split("P")[0];
			var use = $("#usePoint").val();
			
			if(use==""){
				use = 0;
			}else if(isNaN($("#p3"))){
				$("#p3").text("0");
			}
			$("#p1").text(num + " P");
			$("#p3").text(num-use + " P");
			
			$("#next1").click(function(){
				var result = confirm("환급 신청을 하시겠습니까?")
				
				if(result){
					$("#form1").submit();
				}
			});
			
			$("#emailCodeCk").click(function(){
				$.ajax({
					url:'<%= request.getContextPath()%>/userEmailCk.me',
					type:'get',
					success:function(data){
						alert("인증번호가 발송되었습니다");
						emailCode = data;
						$("#emailCodeCk").attr("disabled", true);
						$("#emailCodeCk").css("background", "#ABABAB");
					}
				});
			});
			
			$("#usePoint").blur(function(){
				var num = Number($("#point").text().split("P")[0]);
				var lnum = Number($("#usePoint").val());
			if($("#usePoint").val() != ""){	
				if(!($("#usePoint").val()>=1000)){
					$("#td4").text("1000원 단위 이상의 고구마부터 사용가능합니다.");
					$("#td4").attr("style","visibility:visible");
					$("#p3").text("X");
					$("#p4").text("X");
					$("#next").attr("disabled", true);
					$("#next").css("background", "#ABABAB");
				}else if(num < lnum){
					$("#td4").text("가지고 있는 고구마를 초과하실수 없습니다!");
					$("#td4").attr("style","visibility:visible");
					$("#p3").text("X");
					$("#p4").text("X");
					$("#next").attr("disabled", true);
					$("#next").css("background", "#ABABAB");
				}else{
					var size = $(this).val();
					var money = size.substring(0,size.length-2);
					var num = $("#point").text().split("P")[0];
					$(this).val(Number(money+"00"));
					
					var point = Number(money+"00");
					
					$("#p3").text(num-point + " P");
					var money = point- ((point/100)*20);
					$("#p4").text(money + " 원");
					$("#cashbackMoney").val(money);
					$("#next").attr("disabled", false);
					$("#next").css("background", "#6E00AB");
				}
			}
			});
			$("#usePoint").click(function(){
					$("#td4").attr("style","visibility:hidden");
					$(this).val("");
					var point = $("#usePoint").val();
					var num = $("#point").text().split("P")[0];
					$("#p3").text(num-point + " P");
					var money = point- ((point/100)*20);
					$("#p4").text(0 +" 원");
					$("#next").attr("disabled", true);
					$("#next").css("background", "#ABABAB");
			});
			
			$("#ckOkBtn").click(function(){
				if(emailCode == $("#emailCode").val()){
					var modal = document.getElementById('myModal');
					alert("인증이 완료되었습니다.");
					modal.style.display = "none";
					$("#next").val("환급신청");
					$("#next").removeAttr("click");
					$("#next").css("display", "none");
					$("#next1").css("display", "block");
				}else{
					alert("인증번호가 일치 하지않습니다!!");
				}
			});
			
		});
	</script>
	<%@ include file="/views/user/mypage/A_MyPageNavEnd.jsp" %>
</body>
</html>