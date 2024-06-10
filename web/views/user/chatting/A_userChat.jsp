<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.forest.member.model.vo.Member"%>
    
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
/*---------chat window---------------*/

.inbox_people {
	background: #fff;
	float: left;
	overflow: hidden;
	width: 36%;
	border-right: 1px solid #ddd;
}

.inbox_msg {
	border: 1px solid #ddd;
	overflow: hidden;
	margin: 0 auto;
	width: 100%;
}

.top_spac {
	margin: 20px 0 0;
}

.recent_heading {
	float: left;
	width: 40%;
}

.srch_bar {
	display: inline-block;
	text-align: right;
	width: 60%;
	padding:
}

.headind_srch {
	padding: 10px 29px 10px 20px;
	overflow: hidden;
	border-bottom: 1px solid #c4c4c4;
}

.recent_heading h4 {
	color: #0465ac;
	font-size: 16px;
	margin: auto;
	line-height: 29px;
}

.srch_bar input {
	outline: none;
	border: 1px solid #cdcdcd;
	border-width: 0 0 1px 0;
	width: 80%;
	padding: 2px 0 4px 6px;
	background: none;
}

.srch_bar .input-group-addon button {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	border: medium none;
	padding: 0;
	color: #707070;
	font-size: 18px;
}

.srch_bar .input-group-addon {
	margin: 0 0 0 -27px;
}

.chat_ib h5 {
	font-size: 15px;
	color: #464646;
	margin: 0 0 8px 0;
}

.chat_ib h5 span {
	font-size: 13px;
	float: right;
}

.chat_ib p {
	font-size: 12px;
	color: #989898;
	margin: auto;
	display: inline-block;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.chat_img {
	float: left;
	width: 11%;
}

.chat_img img {
	width: 100%
}

.chat_ib {
	float: left;
	padding: 0 0 0 15px;
	width: 80%;
}

.chat_people {
	overflow: hidden;
	clear: both;
}

.chat_list {
	border-bottom: 1px solid #ddd;
	margin: 0;
	height:50px;
	padding: 18px 16px 10px;
}

.inbox_chat {
	height: 550px;
	overflow-y: scroll;
}

.active_chat {
	background: #e8f6ff;
}

.incoming_msg{
	width:100%;
	margin-top: 15px;
}

.incoming_msg_img {
	display: inline-block;
	width: 6%;
}

.incoming_msg_img img {
	width: 100%;
}

.received_msg {
	display: inline-block;
	padding: 0 0 0 10px;
	vertical-align: top;
	width: 90%;
}

.received_withd_msg p {
	background: #ebebeb none repeat scroll 0 0;
	border-radius: 0 15px 15px 15px;
	color: #646464;
	font-size: 14px;
	margin: 0;
	padding: 5px 10px 5px 12px;
	width: 100%;
}

.time_date {
	color: #747474;
	display: block;
	font-size: 12px;
	margin: 8px 0 0;
}

.received_withd_msg {
	width: 57%;
}

.mesgs {
	float: left;
	padding-left: 9px;
	width: 100%;
	height: 100%;
}

.sent_msg p {
	background: #6E00AB;	
	border-top-left-radius: 15px;
    border-top-right-radius: 0;
    border-bottom-right-radius: 15px;
    border-bottom-left-radius: 15px;
	font-size: 14px;
	margin-right: 25px;
	color: #fff;
	padding: 5px 10px 5px 15px;
	width: 100%;
}

.outgoing_msg {
	overflow: hidden;
	margin-top: 15px;
}

.sent_msg {
	float: right;
	width: 46%;	
    margin-right: 30px;	
}

.input_msg_write input {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	border: medium none;
	color: #6E00AB;
	font-size: 15px;
	min-height: 48px;
	width: 90%;
	outline: none;
}

.type_msg {
	border-top: 1px solid #c4c4c4;
	position: relative;
}

.msg_send_btn {
	background: #6E00AB;
	border: none;
	border-radius: 50%;
	color: #fff;
	cursor: pointer;
	font-size: 15px;
	height: 33px;
	position: absolute;
	right: 0;
	top: 11px;
	width: 38px;
}

.messaging {
	padding: 0;
	margin: 0 auto;
	width: 100%;
	height: 630px;
}

.msg_history {
	height: 580px;
	overflow-y: auto;	
}

#white_space {
	width: 100%;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 20px;
	color: white;
	background: #6E00AB;
}
</style>

</head>

<body>
	<div id="white_space">
		중고구마 1:1 문의
	</div>

	<div class="messaging">
		<div class="inbox_msg">	
			
			<div class="mesgs">
			
				<div class="msg_history">
				
					<!-- 받은 메시지  -->
					<%-- <div class="incoming_msg">
						<div class="incoming_msg_img">
							<img src="<%= request.getContextPath() %>/image/chatImg/profile.JPG"
								alt="sunil">
						</div>
						<div class="received_msg">
							<div class="received_withd_msg">
								<p>Test which is a new approach to have all solutions</p>
								<span class="time_date"> 11:01 AM | June 9</span>
							</div>
						</div>
					</div>	 --%>
					
					
					<!-- 보낸 메시지 -->		
					<!-- <div class="outgoing_msg">
		  				<div class="sent_msg">
							<p>Test which is a new approach to have all
			  				   solutions</p>
							<span class="time_date"> 11:01 AM    |    June 9</span> 
						</div>
					</div> -->

				</div>


				<!-- 채팅 입력창 시작 -->
	  			<div class="type_msg">
					<div class="input_msg_write">
		 				<input type="text" id="input_admin_msg" class="write_msg" 
		 					   placeholder="메시지를 입력해주세요" onkeyup="enterkey()"/>
		  				<button class="msg_send_btn" type="button" id="admin_msg_btn" onclick="send();">
		  					<h6 style="margin:0px;">전송</h6>
		  				</button>
					</div>
	  			</div>
	  			<!-- 채팅 입력창 끝 -->
				
				
			</div>
		</div>
	</div>

	<script>
	
	<% if(loginMember != null) {%>
		var webSocket = new WebSocket(
		'ws://192.168.30.184:8001/forest/broadcasting?chatUser=<%= loginMember.getUserNo() %>');
		var $msgHistory = $(".msg_history");
		
		webSocket.onerror = function(event) {
		onError(event)
		};
		webSocket.onopen = function(event) {
		onOpen(event)
		};
		webSocket.onmessage = function(event) {
		onMessage(event)
		};
		
		function onMessage(event) {
		//console.log("onMessage 호출");
		var chatMsg = event.data;
		
		var date = new Date();
		var dateInfo = date.hhmm();	
		
		if (chatMsg.substring(0, 6) == 'server') {
		
			var $chat = $("<div id='enterChat'>" + chatMsg + "</div>");
			$msgHistory.append($chat);
		} else {
			
			var chatInfo = chatMsg.split("$");
			//chatInfo[0] : 보낸사람
			//chatInfo[1] : message
			//chatInfo[2] : 받을사람
							
			if(chatInfo[2] == <%= loginMember.getUserNo() %>){
				var imgsrc = "<%= request.getContextPath() %>/image/chatImg/profile.JPG"
				var $inMsg = "<div class='incoming_msg'>"
							+ "<div class='incoming_msg_img'>"
							+ "<img src='"+ imgsrc +"' alt='sunil'>" + "</div>"
							+ "<div class='received_msg'>"
							+ "<div class='received_withd_msg'>" + "<p>" + chatInfo[1]
							+ "</p>" + "<span class='time_date'>" + dateInfo
							+ "</span>" + "</div></div></div>";
		
				$msgHistory.append($inMsg);
			}				
		}
		
		$('.msg_history').scrollTop($('.msg_history').prop('scrollHeight'));
		}
		
		function onOpen(event) {
		
		var date = new Date();
		var dateInfo = date.hhmm();	
		
		var inputMsg = "※상담내용은 관계 법령에 따라 자동으로 저장됩니다.";
						
		var $outMsg = "<div class='outgoing_msg'>"
					+ "<div class='sent_msg'>" + "<p>" + inputMsg + "</p>"
					+ "<span class='time_date'>" + dateInfo + "</span>"
					+ "</div>" + "</div>";
		
		$msgHistory.append($outMsg);
		
		var chatOpenMsg = "안녕하세요 고객님! <br>" 
			+ "라이프 스타일을 렌탈하다 중고구마 입니다.<br><br>"
			+ "현재 먼저 문의 주신 고객님과 상담중에 있습니다.<br><br>"
			+ "문의 내용 남겨주시면 확인 후 답변드릴 예정이오니<br>"
			+ "잠시만 기다려주세요.^^";
		
		var imgsrc = "<%=request.getContextPath()%>/image/chatImg/profile.JPG"
		
		var $inMsg = "<div class='incoming_msg'>"
				+ "<div class='incoming_msg_img'>"
				+ "<img src='"+ imgsrc +"' alt='sunil'>" + "</div>"
				+ "<div class='received_msg'>"
				+ "<div class='received_withd_msg'>" + "<p>" + chatOpenMsg
				+ "</p>" + "<span class='time_date'>" + dateInfo
				+ "</span>" + "</div></div></div>";
		
		$msgHistory.append($inMsg);
		
		}
		
		function onError(event) {
		alert(event.data);
		}
		
		Date.prototype.hhmm = function(){
		var hh = this.getHours().toString();
		var mm = this.getMinutes().toString();
		return (hh[1] ? hh : "0" + hh[0]) + ":" + (mm[1] ? mm : "0" + mm[0]);
		}
		
		
		function send() {
		//console.log("user send 호출");
		
		
		//입력을 받아온다.
		var inputMsg = $(".write_msg").val();
		if (inputMsg == '') {
			return;
		}
		
		//현재 날짜 받아와서 채팅에 뿌려주기 위해 준비
		var date = new Date();
		var dateInfo = date.hhmm();	
		
		var adminNo = "1" 		//adminNo
		//웹소켓에 보낼 값 세팅
		var toWebSocket = <%= loginMember.getUserNo() %> + "$" + inputMsg + "$" + adminNo;
		
		
		//유저채팅창에서는 보낸이는 유저 받는 사람은 관리자로 세팅을 한다.
		var sender = <%= loginMember.getUserNo() %>;	//현재 접속중인 유저 No
		var receiver = "1";								//관리자 No
		var message = inputMsg;				
		
		
		$.ajax({
			url: "<%= request.getContextPath() %>/chat",
			data: {	
					sender: sender,
					message: message, 
					receiver: receiver,
					date: dateInfo
				  },
			type: "get",
			success: function(data){
				//console.log("user 메시지 DB에 저장");
			},
			error: function(status){
				console.log(status);
			}
		});			
								
		webSocket.send(toWebSocket);			
		
		var $outMsg = "<div class='outgoing_msg'>"
				+ "<div class='sent_msg'>" + "<p>" + inputMsg + "</p>"
				+ "<span class='time_date'>" + dateInfo + "</span>"
				+ "</div>" + "</div>";
		$msgHistory.append($outMsg);
		
		
		inputMsg = "";
		$(".write_msg").val("");
		
		$('.msg_history').scrollTop($('.msg_history').prop('scrollHeight'));
		}
		
		//엔터키를 통해 send함
		function enterkey() {
		if (window.event.keyCode == 13) {
			send();
		}
		}
		
		$(window).on('beforeunload', function() {
			return '변경하고 싶지만 변경이 안된다';
		});
	
	
	//채팅창에서 새로고침 차단
	$(document).keydown(function (e) {
		if (e.which === 116) 
		{
		    if (typeof event == "object") 
		    {
		        event.keyCode = 0;
		    }
		    return false;
		} else if (e.which === 82 && e.ctrlKey) {
		    return false;
		}
	});
	<% } else { %>
	
		alert("로그인을 먼저 해주세요");
		window.close();
		
	<% } %>
		
		
	</script>

</body>

</html>