<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고구마</title>

<style>
/*---------chat window---------------*/
.container {
	max-width: 900px;
}

.inbox_people {
	background: #fff;
	float: left;
	overflow: hidden;
	width: 38%;
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
	padding-left: 15px;
	width: 60%;
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
	color: #4c4c4c;
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
	width: 35px;
}

.messaging {
	padding: 0 0 50px 0;
	margin: 0 auto;
	width: 80%;
}

.msg_history {
	height: 550px;
	overflow-y: auto;	
}

#white_space {
	width: 100%;
	height: 50px;
}
.chat_id{
	line-height: 30px;
	margin-left: 45px;
}
#peopleReadCheck{
	margin: 0;
	padding: 0;
	margin-left: 20px;
	color: red;
}

</style>

</head>

<body>
<body onload="ready('1:1 문의 관리', '커뮤니티', '1:1 문의 관리');">

	<%@ include file="../common/C_menubar.jsp"%>

	<div id="white_space"></div>

	<div class="messaging">
		<div class="inbox_msg">
			
			<!-- 채팅 목록 시작 -->
			<div class="inbox_people">
				<div class="headind_srch">
					<div class="recent_heading">
						<h4>Recent</h4>
					</div>
					<div class="srch_bar">
						<div class="stylish-input-group">
							<!-- <input type="text" class="search-bar" placeholder="Search"> -->
						</div>
					</div>
				</div>
				<div class="inbox_chat scroll">
				
									
					<%-- <div class="chat_list active_chat">
						<div class="chat_people">
							<div class="chat_img">
								<img src="<%= request.getContextPath() %>/image/chatImg/profile.JPG"
									alt="sunil">
							</div>
							<div class="chat_ib">
								<span class="chat_user">아이유</span><br>							
								<p>프로젝트 완성할 수 있겠죠??</p>
							</div>
						</div>
					</div>	
					
					<div class="chat_list">
						<div class="chat_people">
							<div class="chat_img">
								<img src="<%= request.getContextPath() %>/image/chatImg/profile2.PNG"
									alt="sunil">
							</div>
							<div class="chat_ib">
								<span class="chat_user">아이린</span><br>							
								<p>오늘 저녁에 치킨 콜?</p>
							</div>
						</div>
					</div> --%>			
					
					
				</div>
				
			</div>
			<!-- 채팅 목록 끝 -->
			
			
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

	<%@ include file="../common/C_menubar2.jsp"%>

	<script>
				
		$(function(){			
			//채팅리스트를 불러온다.					
			$.ajax({
				url: "<%= request.getContextPath()%>/chatList",
				type: "get",
				success: function(data){
					//console.log(data);
										
					for(var key in data){
						var $inbox_chat = $(".inbox_chat");
						var user = data[key];
						var $chatMember = "<div class='chat_list' onclick='chatListClick(this);'>" 
							   			+ "<div class='chat_people'>"
							   		    + "<div class='chat_img'>"
							   	        + "<img src='<%= request.getContextPath() %>/image/chatImg/profile.JPG' alt='sunil'>"
							   			+ "</div>"
							   			+ "<div class='chat_id'>"							   			
							   			+ "<span class='chat_user'>" + decodeURIComponent(user.userName) + "</span>"
							   			+ "<span style='display:none'>" + user.userNo + "</span>"
							   			+ "</div></div></div>";
						
							   			
						$inbox_chat.append($chatMember);
						//console.log(user.readCount);
					}					
				},
				error: function(status){
					console.log(status);
				}		
			});		
		});		
				
		
		var sender;
		var toUser;
		
		function setSender(sender){
			this.sender = sender;			
		}
		
		function getSender(){
			return this.sender;
		}
		
		
		function chatListClick(id){
			//console.log("클릭된 유저 번호 " + $(id).find("span").eq(1).html());
			
			//이전에 웹소켓이 연결되어 있을 수 있으니 이전 연결을 해제한다.
			//웹소켓 해제시 onMessage가 실행이 안됨.
			/* webSocket.close(); */
			<%-- webSocket = new WebSocket(
				'ws://192.168.30.184:8001/forest/broadcasting?chatUser=<%= loginAdmin.getEmpNo()  %>'); --%>
			
			userId = $(id).find("span").eq(1).html();
			
			
			toUser = userId;			
			//console.log("클릭된 toUser : " + toUser);
			setSender(toUser);
			
			//채팅내역 초기화
			var $msg_history = $(".msg_history");
			$msg_history.find("div").remove();
				
			
			$.ajax({
				url: "<%= request.getContextPath()%>/selectChatHistory",
				type: "get",
				data: {userId : userId},
				success: function(data){
					//console.log(data);
					var imgsrc = "<%= request.getContextPath() %>/image/chatImg/profile.JPG"
					
					var readCount = 0;
					
					for(var key in data.list){
						var userInfo = data.list[key];						
						/* console.log(userInfo.sender);
						console.log(userInfo.receiver);
						console.log(decodeURIComponent(userInfo.message));
						console.log(decodeURIComponent(userInfo.date));
						console.log(userInfo.readCheck); */
						
						if(userInfo.sender == toUser){
							console.log("보낸이 유저 : " + toUser);
							
							var $inMsg = "<div class='incoming_msg'>"
								+ "<div class='incoming_msg_img'>"
								+ "<img src='"+ imgsrc +"' alt='sunil'>" + "</div>"
								+ "<div class='received_msg'>"
								+ "<div class='received_withd_msg'>" + "<p>" 
								//decodeURIComponent(userInfo.message) 로 출력시 공백이 +로 출력됨
								+ decodeURIComponent(decodeURI(userInfo.message).replace(/\+/g, " "))
								+ "</p>" + "<span class='time_date'>" + userInfo.date
								+ "</span>" + "</div></div></div>";

							$msgHistory.append($inMsg);
							
						}else {
							console.log("보낸이 관리자")
							
							var $outMsg = "<div class='outgoing_msg'>"
								+ "<div class='sent_msg'>" + "<p>" + decodeURIComponent(userInfo.message).replace(/\+/g, " ") + "</p>"
								+ "<span class='time_date'>" + userInfo.date + "</span>"
								+ "</div>" + "</div>";

							$msgHistory.append($outMsg);
							
						}
											
						readCount++;
					}
					
					//window.location.reload()
					
					/* //상단 메뉴바 숫자 변경
					$chatAlertText = $("#chatAlertText");
					//console.log($chatAlertText);
					var sum = $chatAlertText.html() - readCount;
					console.log(sum);
					$chatAlertText.html(sum); */
					
					//안읽은 메시지 갯수를 메뉴바에 세팅한다				
					$.ajax({
						url: "<%= request.getContextPath()%>/chatList",
						type: "get",
						success: function(data){
							//console.log(data);
							
							for(var key in data){
								
								var user = data[key];	
								$("#chatAlertText").html(user.readCount);	
								//console.log(user.readCount);
							}					
						},
						error: function(status){
							console.log(status);
						}		
					});	
					
				},
				error: function(status){
					console.log(status);
				}		
			});					
			
			
			
		}
		
		
		var webSocket = new WebSocket(
				'ws://192.168.30.184:8001/forest/broadcasting?chatUser=<%= loginAdmin.getEmpNo() %>');
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
		webSocket.onclose = function(event){
			onClose(event);
		}
		
		function onClose(event){
			//console.log("onClose 호출");
		}

		function onMessage(event) {			
			//console.log("onMessage 호출");			
						
			var chatMsg = event.data;
			
			var $msg_history = $(".msg_history");

			var date = new Date();
			var dateInfo = date.hhmm();

			if (chatMsg.substring(0, 6) == 'server') {
				var $chat = $("<div id='enterChat'>" + chatMsg + "</div>");
				$msgHistory.append($chat);
			} else {
				
				//메시지가 오면 채팅리스트 새로 불러온다.(새로운 유저를 추가하기 위해)				
				$.ajax({
					url: "<%= request.getContextPath()%>/chatList",
					type: "get",
					success: function(data){
						console.log(data);			
						
						//현재 채팅 리스트 갱신
						var $inbox_chat = $(".inbox_chat");						
						$inbox_chat.find("div").remove();
						
						for(var key in data){
							
							var user = data[key];
							var $chatMember = "<div class='chat_list' onclick='chatListClick(this);'>" 
								   			+ "<div class='chat_people'>"
								   		    + "<div class='chat_img'>"
								   	        + "<img src='<%= request.getContextPath() %>/image/chatImg/profile.JPG' alt='sunil'>"
								   			+ "</div>"
								   			+ "<div class='chat_id'>"
								   			+ "<span class='chat_user'>" + decodeURIComponent(user.userName) + "</span><br>"
								   			+ "<span style='display:none'>" + user.userNo + "</span>"
								   			+ "</div></div></div>";
							
									   			
								$inbox_chat.append($chatMember);						
							}
						},
					error: function(status){
							console.log(status);
					}		
				});		
				
				//특정 사용자에게서만 온 메시지를 받아온다.
				var sender = getSender();
				//console.log("메시지 왔을 때 sender : " + sender);
				
				var chatSender = chatMsg.split("$");
				
				if(sender == chatSender[0]){
					var imgsrc = "<%= request.getContextPath() %>/image/chatImg/profile.JPG"
					var $inMsg = "<div class='incoming_msg'>"
								+ "<div class='incoming_msg_img'>"
								+ "<img src='"+ imgsrc +"' alt='sunil'>" + "</div>"
								+ "<div class='received_msg'>"
								+ "<div class='received_withd_msg'>" + "<p>" + chatSender[1]
								+ "</p>" + "<span class='time_date'>" + dateInfo
								+ "</span>" + "</div></div></div>";

					$msgHistory.append($inMsg);		
				}
				
				
						
				
			}						
			$('.msg_history').scrollTop($('.msg_history').prop('scrollHeight'));		
		}
		
		function onOpen(event) {
			//console.log("onOpen 호출")
			var date = new Date();
			var dateInfo = date.hhmm();
			
			//나중에 삭제하고 채팅리스트 불러와야함
			/* 안내 문구 시작 */
			var inputMsg = "※상담내용은 관계 법령에 따라 자동으로 저장됩니다.";
							
			var $outMsg = "<div class='outgoing_msg'>"
						+ "<div class='sent_msg'>" + "<p>" + inputMsg + "</p>"
						+ "<span class='time_date'>" + dateInfo + "</span>"
						+ "</div>" + "</div>";

			$msgHistory.append($outMsg);
			
			var chatOpenMsg = "안녕하세요 <%= loginAdmin.getEmpName() %> 직원님 <br>" 
				+ "오늘도 즐거운 하루 되기를 바랍니다.<br><br>"
				+ "대화내용은 모두 저장되오니<br>"
				+ "고객과의 대화시<br>친절하게 응답해주시기 바랍니다.<br><br>"
				+ "좌측 고객리스트를 클릭하면<br>고객과의 소통이 시작됩니다.";
			
			var imgsrc = "<%=request.getContextPath()%>/image/chatImg/profile.JPG"
 
			var $inMsg = "<div class='incoming_msg'>"
					+ "<div class='incoming_msg_img'>"
					+ "<img src='"+ imgsrc +"' alt='sunil'>" + "</div>"
					+ "<div class='received_msg'>"
					+ "<div class='received_withd_msg'>" + "<p>" + chatOpenMsg
					+ "</p>" + "<span class='time_date'>" + dateInfo
					+ "</span>" + "</div></div></div>";

			$msgHistory.append($inMsg);
			/* 안내 문구 끝 */
		}
		
		function onError(event) {
			alert(event.data);
		}
	
		Date.prototype.hhmm = function(){
			var hh = this.getHours().toString();
			var mm = this.getMinutes().toString();
			return (hh[1] ? hh : "0" + hh[0]) 
			+ ":" +(mm[1] ? mm : "0" + mm[0]);
		}
		
		function send() {			
			//console.log("admin send 호출");
			
			var inputMsg = $(".write_msg").val();
			if (inputMsg == '') {
				return;
			}
			
			
			var date = new Date();
			var dateInfo = date.hhmm();		
			
			//채팅리스트에서 클릭한 아이디를 불러온다.
			var sender = getSender();
			
			//웹소켓에 보낼 값 세팅
			var toWebSocket = <%= loginAdmin.getEmpNo() %> + "$" + inputMsg + "$" + sender;
						
			//유저채팅창에서는 보낸이는 유저 받는 사람은 관리자로 세팅을 한다.
			var sender = <%= loginAdmin.getEmpNo() %>;		// 접속중인 관리자번호
			var receiver = toUser;							//답장할 유저No
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
					console.log("admin 메시지 DB 저장");
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
	</script>

</body>
</html>