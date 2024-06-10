<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.forest.product.model.vo.*, com.kh.forest.product.model.service.*"%>
<% 
	ArrayList<ProductAttachment> list = (ArrayList<ProductAttachment>)request.getAttribute("list");
	ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList");
	E_PageInfo pi = (E_PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int limit = pi.getLimit();
	int maxPage = pi.getMaxPage();
	int endPage = pi.getEndPage();
	int startPage = pi.getStartPage();
	int count = pi.getListCount();
%>
<!DOCTYPE html>
<html>
<head>
<style>
.DDD {
	background: #ECECEC;
	height: 35px;
	line-height: 35px;
	border: 2px solid #B8B8B8;
}

.DDD button {
	border: none;
	background: #828282;
	color: white;
	width: 90px;
	height: 25px;
cursor: Pointer;
}
.E {
	font-color: black;
	font-size: 14px;
}

.E td {
	border: 1px black;
	border-style: solid;
	font-size: 14px;
}

.E table {
	align: center;
	background: white;
	width: 100%;
	color: black;
	margin-bottom: 30px;
}

.E table:not(.table1 ){
	border-collapse: collapse;
}

.table1 td {
	border: none;
}

.table1 td:first-child {
	text-align: center;
}

.table1 td:first-of-type {
	background: #DADADA;
}

.table3 {
	text-align: center;
	border-collapse: separate

}

.E th {
	border: 1px black;
	border-style: solid;
	background: #A7C0E9;
}

.E .htd {
	background: gray;
	width: 120px;
}

.E .bt {
	text-align: center;
}

.E hr {
	color: black;
}

.vl {
	margin-left: 10px;
}

.E span {
	color: red;
}

.E select {
	width: 100px;
	height: 22px;
}

.E #bt {
	margin: 20px;
}

.E .table1 td:nth-child(2) {
	background: rgb(247, 247, 247);
}

.E button {
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

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}
/* The Close Button */
.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}


</style>
<meta charset="UTF-8">
<title>중고구마</title>
</head>
<body onload="ready('바코드 관리', '상품관리', '바코드 관리');">
	<%@ include file="../common/C_menubar.jsp"%>

	<article class="E">
		<form action="searchBarcode">
			<table class="table1" style="border: 10px">
				 <tr>
                    <td class="htd">분류선택</td>
                    <td colspan="3">
                        <select name="categoryNo" id="categoryNo" class="vl">
                            <option value="0" >분류</option>
                            <% for(int i = 0 ; i < categoryList.size() ; i++){ %>
                            <option  id="<%= categoryList.get(i).getCategoryName() %>" value="<%= categoryList.get(i).getCategoryNo() %>">
                            	<%= categoryList.get(i).getCategoryName() %>
                            </option>
                            <% } %>
                        </select>
                    </td>
                    
                </tr>
				<tr>
					<td class="htd">검색어</td>
					<td>
					<select name="select" class="vl">
							<option class="vl" value="all">전체</option>
							<option value="productNo">상품번호</option>
							<option value="productName">상품명</option>
							<option value="buyProducName">모델명</option>
					</select> 
					<input class="vl" type="text" name="value"></td>
				</tr>
				<tr>
					<td class="htd">상태</td>
					<td>
					<input class="vl" type="radio" value="Y" name="stockStatus" id="statusA">
					<label for="statusA">등록</label> 
					<input class="vl" type="radio" value="N" name="stockStatus" id="statusB">
					<label for="statusB">미등록</label>
				</tr>

				<tr>
					<td colspan="2" style="border: none; background: white;"><input
						style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
						type="submit" id="bt" value="검색"></td>
				</tr>
			</table>


		</form>
		
		
		<div class="DDD">
		&nbsp;&nbsp;
			<label>검색결과 : </label><label class="searchCount"><%= count %> 건</label>
		</div>
		<br><br>

		<form action="printBarcode" id="printBarcode">
		<table class="table3">
			<tr>
				<th><input type="checkbox" id="checkall"></th>
				<th>번호</th>
				<th>바코드 번호</th>
				<th>발급날짜</th>
				<th width="150px">상품명</th>
				<th width="150px">모델명</th>
				<th>출력</th>
			</tr>
			<% for(int i = 0 ; i < list.size(); i++){ %>
			<tr>
				<td><input type="checkbox" name="printProductNo" value="<%= list.get(i).getProductNo() %>"></td>
				<td> 
				<%= count - (currentPage-1)*limit - i %>
				</td>
				<td><%= list.get(i).getProductNo() %></td>
				<td><%= list.get(i).getEnrollDate() %></td>
				<td>
					<%if(list.get(i).getProductName()!=null){ %>
					<%= list.get(i).getProductName() %>
					<%} %>
				</td>
				<td>
					<%if(list.get(i).getProductName()!=null){ %>
					<%= list.get(i).getBuyProductName() %>
					<%} %>
				</td>
				<td><img width="300px"
					src="<%= request.getContextPath()+"/image/barcodeNewImg/"+list.get(i).getChangeName()%>"></td>
				
			</tr>
			<%} %>

		</table>

		</form>
		
		<div align="center">
			<button style="cursor: Pointer; background:white; border:none; color:purple;"
				onclick="location.href='<%=request.getContextPath() %>/barcodeList?currentPage=1'"><<</button>
			<% if(currentPage <= 1 ){ %>
			<button  style="background:white; border:none; color:purple;" disabled><</button>
			<%} else { %>
			<button style="cursor: Pointer; background:white; border:none; color:purple;"
				onclick="location.href='<%=request.getContextPath() %>/barcodeList?currentPage=<%= currentPage - 1%>'">
				<</button>
			<% } %>

			<% for(int p = startPage; p <= endPage ; p++){ 
					if(p == currentPage){%>
						<button disabled style="background:white; border:none; color:purple;"><%= p %></button>
			<%		}else{ %>
						<button style="cursor: Pointer; background:white; border:none; color:purple;" onclick="location.href='<%=request.getContextPath() %>/barcodeList?currentPage=<%=p %>'"><%=p %></button>
				
			<%		} 
				} %>
			<% if(currentPage >= maxPage){ %>
				<button disabled style="background:white; border:none; color:purple;"> > </button>
			<% }else {  %>
				<button style="cursor: Pointer; background:white; border:none; color:purple;" onclick="location.href='<%=request.getContextPath() %>/barcodeList?currentPage=<%=currentPage + 1 %>'"> ></button>
			<% } %>	
			
			<button style="cursor: Pointer; background:white; border:none; color:purple;" onclick="location.href='<%=request.getContextPath() %>/barcodeList?currentPage=<%= maxPage%>'">>></button>

		</div>

	<button id="myBtn" style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;
						border:none; float:right;">바코드 생성</button>
	
 
   

		<br>
		<br>
		<hr>

		<br> 일괄처리 <br>

		<div class="DDD">&nbsp;&nbsp;
				<button style="margin-left: 10px; width: 100px;" onclick="pagePrintPreview();" >바코드 출력</button>
				<!-- onclick="printBarcode();" -->
		</div>
		 <!-- The Modal -->
    <div id="myModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
      	<p>
        	<div style="background:#16AAD8; color:white; font-size:20px; height:80px; text-align:center; padding:3px">
        		<h2>바코드생성</h2>
        	</div>
		
			<form action="<%=request.getContextPath()%>/barcodeInsert" id="barcodeInsertForm">
				<table>
					<tr name="trBarcode">
						<input type="button" value='추가하기' onclick="add();">
						<td style="padding-left: 10px"
							><label>바코드 분류 : </label>
							<span></span>
							<span hidden>중복된 번호입니다.</span>
							<span hidden>이미 존재하는 바코드입니다.</span>
							<select name="category1" class="selectOne">
								<option value="0">
									1차분류
								</option>
								<option value="10">
									디지털
								</option>
								<option value="20">
									가전제품
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="border: none">
							<div style="text-align: center">
								<input type="button"  onclick="check();"
									style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
									id="bt" value="등록"> 
								<input type="reset"
									style="cursor: Pointer; width: 100px;    height: 30px;    background: #6792DA;    border: none;    color: white;    font-size: 15px;    border-radius: 5px 5px 5px 5px;"
									id="bt" class="close" value="취소">
							</div>
						</td>
					</tr>
				</table>
			</form> 
		</p>
			
		</div>
		
	</div>
	</article>
	<script>
	$(document).on("change","[class=selectOne]",function(){
		var category1 = $(this);
		var categoryNo = category1.val();
		if(categoryNo == 0){
			$(this).next().remove();
		}else if(categoryNo == 10){
			var $select = $("<select name='category2'>");
			var $option1 = $("<option>").text("노트북").val(11);
			var $option2 = $("<option>").text("태블릿PC").val(12);
			var $delete1 = $(this).next().next("[type=button]");
			var $delete2 = $(this).next("[type=button]");

			/* <input type="button" name="delBarcode"  value="삭제">' */
			
			$(this).next("select").remove();
			$select.append($option1);
			$select.append($option2);
			category1.parent().append($select);
			category1.parent().append($delete1);
			category1.parent().append($delete2);
			
		}else if(categoryNo == 20){
			var $select = $("<select name='category2'>");
			var $option1 = $("<option>").text("생활가전").val(21);
			var $option2 = $("<option>").text("주방가전").val(22);
			var $option3 = $("<option>").text("미용가전").val(23);
			var $delete1 = $(this).next().next("[type=button]");
			var $delete2 = $(this).next("[type=button]");
			$(this).next("select").remove();			
			$select.append($option1);
			$select.append($option2);
			$select.append($option3);
			category1.parent().append($select);
			category1.parent().append($delete1);
			category1.parent().append($delete2);
		}
	})
	</script>
	<script>
	//한글입력 방지
		var count = 0;
		$(document).on("keydown","[name=productId]",function(){
			var productNo = $(this).val();
			$(this).val(productNo.replace(/[^a-z0-9]/gi,''));
			
		})
	//폼 중복 방지
		$(document).on("change","[name=productId]",function(){
			var productNoList = $("[name=productId]");
			var alertTag1 = $(this).next().next();
			var alertTag2 = $(this).next().next().next();

			
			for(var i = 0 ; i < productNoList.length ; i++){
				$("[name=productId]:eq("+i+")").parent().children().eq(3).hide();
				for(var j = 0 ; j < i ; j++){
					var ialertTag1 = $("[name=productId]:eq("+i+")").parent().children().eq(3);
					var ialertTag2 = $("[name=productId]:eq("+i+")").parent().children().eq(4);
					var jalertTag1 = $("[name=productId]:eq("+j+")").parent().children().eq(3);
					var jalertTag2 = $("[name=productId]:eq("+i+")").parent().children().eq(4);
					
					if(productNoList[i].value==productNoList[j].value&&productNoList[i].value!=''){
						if(ialertTag2.css("display")=="none"){
							ialertTag1.show();
						}else{
							ialertTag1.hide();
						}
					}
				}
			}
			
			
	//디비 중복 방지
			var productNo = $(this).val();
			
			$.ajax({
				url : "checkBarcode",
				data : {
					productNo : productNo
				},
				method : "get",
				success : function(data){
					var barcodeCheck = data.barcodeCheck;
					var count = 0;
					alertTag2.hide();
					
					if(barcodeCheck > 0){
						alertTag1.hide();
						alertTag2.show();
						};
						
					for(var i = 0 ; i < productNoList.length ; i++){
						if(productNoList[i].value==productNo&&productNoList[i].value!=''&&alertTag2.css("display")=="none"){
							count++;
							
							if(count>1){
							alertTag1.show();

							}
						}
					}
				},
				error : function(status){
					console.log(status);
				}
			});
		});
		
		function check(){
			

				//안내문구로 걸러주는방법
				for(var i = 0 ; i < $("[name=productId]").length ; i++){
				var ialertTag1 = $("[name=productId]:eq("+i+")").parent().children().eq(3);
				var ialertTag2 = $("[name=productId]:eq("+i+")").parent().children().eq(4);
				var ialertCss1 = ialertTag1.css("display");
				var ialertCss2 = ialertTag2.css("display");
				if(ialertTag1.css("display")!="none"||ialertTag2.css("display")!="none"){
					$("[name=productId]:eq("+i+")").focus();
					return;
				}
			} 
			

/*			
			//폼
				var productNoList = $("[name=productId]");
				var checkCount1 = 0;
				for(var i = 0 ; i < productNoList.length ; i++){
					
					var count = 0;
					
					for(var j = 0 ; j < i ; j++){
						if(productNoList[i].value==productNoList[j].value&&productNoList[i].value!=''){
							count++;
						}
					}
					
					
					if(count > 1){
						return;
					}
				}
			//디비                  ajax가 스크립트구문 이후에 실행되서 안됌
			var productNoList = [];
			
			for(var i = 0 ; i < $("[name=productId]").length ;i++){
				productNoList.push($("[name=productId]").eq(i).val());
			}
			
			jQuery.ajaxSettings.traditional = true;
			
			 $.ajax({
				url : "checkBarcodeArr",
				data : {
					productNoList : productNoList
				},
				method : "get",
				success : function checkList(data){
					 var barcodeCheck = data.barcodeCheck;
					$("#countCheck").val(barcodeCheck);
					

				},
				error : function(status){
					console.log(status)
				}
			}); 
			 
			if($("#countCheck").val()>0){
				return false;
			}
			return true;*/
			console.log("리턴 true");
			$("#barcodeInsertForm").submit();
		} 
		
		
	</script>
<script>
		function add(){
				
				var addBarcodeText = 
					'<tr name="trBarcode">'+
					'	<td style="padding-left:10px"><label>바코드 분류 : </label>'+
					'	<span hidden>중복된 번호입니다.</span>'+
					'	<span hidden>이미 존재하는 바코드입니다.</span>'+
					'	<select name="category1" class="selectOne">'+
					'	<option value="0">1차분류</option>'+
					'	<option value="10">디지털</option>'+
					'	<option value="20">가전제품</option>'+
					'	</select>'+
					'	<input type="button" name="delBarcode"  value="삭제">'+
					'	</td>'
					'</tr>'
				
				var trHtml =$("tr[name=trBarcode]:last");
					
				trHtml.after(addBarcodeText);
				
				
				console.log("addMethod호출");
		}
		
/*		onclick으로 작성 시 제거가 되지 않음
		function deleteTab(){
			 var trHtml = $(this).parent().parent();
		        console.log(trHtml)
		} */
		$(document).on("click","input[name=delBarcode]",function(){
	        var trHtml = $(this).parent().parent();
	        
	        trHtml.remove(); 
	    });
</script>
	
	<script>
function pagePrintPreview(){
		
		var checkList = $("[name=printProductNo]");
		
		
		for(var i = 0 ; i < checkList.length ; i++ ){
			if(checkList[i].checked){
				var productName = $("[name=printProductNo]:eq("+i+")").parent().parent().children().eq(4).html().trim($("#").val());
				var buyProductName = $("[name=printProductNo]:eq("+i+")").parent().parent().children().eq(5).html().trim($("#").val());
				
				var $barcodeArea = $("<div style='width:50%; float:left'class='barcodeArea'>");
				var $br1 =$("<br>");
				var $br2 =$("<br>");
				var $labelPN = $("<label>").text("상품명 : ");
				var $inputPN = $("<input style='border:none;' type='text'>").val(productName);
				var barcodeImg = $("[name=printProductNo]:eq("+i+")").parent().parent().children().eq(6).children().clone().css({"margin":"10px", "padding":"10px"});
				var $labelBPN = $("<label>").text("모델명 : ");
				var $inputBPN = $("<input style='border:none;' type='text'>").val(buyProductName);
				
				$barcodeArea.append($labelPN);
				$barcodeArea.append($inputPN);
				$barcodeArea.append($br1);
				$barcodeArea.append($labelBPN);
				$barcodeArea.append($inputBPN);
				$barcodeArea.append($br2);
				$barcodeArea.append(barcodeImg);
				
				$(".print").append($barcodeArea);
			}
		}
 		$("body :not(.print):not(img)").hide();
  		$(".print").show();
  		$(".print *").show();

         var browser = navigator.userAgent.toLowerCase();
        if ( browser.indexOf('chrome')!= -1 ){
                   window.print();
        }else if ( browser.indexOf('trident') != -1 ){
                   try{
                            var webBrowser = '<OBJECT ID="previewWeb" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
                            document.body.insertAdjacentHTML('beforeEnd', webBrowser);
                            
                            previewWeb.ExecWB(7, 1);
                            //객체 해제
                            previewWeb.outerHTML = "";
                   }catch (e) {
                            alert("- 도구 > 인터넷 옵션 > 보안 탭 > 신뢰할 수 있는 사이트 선택\n   1. 사이트 버튼 클릭 > 사이트 추가\n   2. 사용자 지정 수준 클릭 > 스크립팅하기 안전하지 않은 것으로 표시된 ActiveX 컨트롤 (사용)으로 체크\n\n※ 위 설정은 프린트 기능을 사용하기 위함임");
                   }
        }  
		$(".print").children().remove();
         $("body :not(.print):not(#myModal):not(#searchBarcode)").show();
        $(".print").hide();    
}
	
	</script>
	<script>
		function printBarcode(){
			$("#printBarcode").submit();
		}
	</script>
	<script>
	$(document).ready(function(){
	    $("#checkall").click(function(){
	        if($("#checkall").prop("checked")){
	            $("input[name=printProductNo]").prop("checked",true);
	        }else{
	            $("input[name=printProductNo]").prop("checked",false);
	        }
	    })
	})
	</script>
	
<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];                                          

// When the user clicks on the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
    var productNoList = $("[name=productId]");
    for(var i = 0 ; i < productNoList.length ; i++){
		$("[name=productId]:eq("+i+")").parent().children().eq(3).hide();
		$("[name=productId]:eq("+i+")").parent().children().eq(4).hide();
	}
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
    }
}

</script>
	<%@ include file="../common/C_menubar2.jsp"%>
	
	
<div class="print" hidden></div>
</body>
</html>






