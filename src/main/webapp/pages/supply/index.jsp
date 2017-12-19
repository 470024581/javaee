<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<title>html5</title>
<script src="<%=request.getContextPath()%>/js/jquery1.8.1.js"></script>
<script type="text/javascript">
	function clickButton(jspPath){
		$("#frame").attr("src", "pages/"+jspPath+".jsp");
	}
	function setDivCenter(){
		var bodyWidth = $(document.body).width();
		var width =  (bodyWidth - 620 - 20) / 2;
		if(width > 0){
			$("#div").css("margin-left", width);
		} else {
			$("#div").css("margin-left", "auto");
		}
		$("#div").css("margin-top", "5%");
	}
	window.onload = setDivCenter;
	window.onresize = setDivCenter;
	
	function testInterface(){
		var jsonInfo = $(document.getElementById('frame').contentWindow.document.getElementById("dataForm")).serialize();
		if(jsonInfo){
			var controller = $(document.getElementById('frame').contentWindow.document.getElementById("controller")).val();
			var method = $(document.getElementById('frame').contentWindow.document.getElementById("method")).val();
			var url = "<%=request.getContextPath()%>/"+controller+"/"+method;
			$.ajax({
				type:"post",
				url:url,
				dataType:"json", 
				data:jsonInfo,
				success : function(data) { 
					var text = JSON.stringify(data);
					$("#text").text(text);
				},
				error : function(error) {
					$("#text").text(error.responseText); 
				}
			});
		} else {
			alert("选择一个要测试的方法！");
		}
	}
	function test(){
		var url = "<%=request.getContextPath()%>/apollo/querySupplyStatus";
		//var info = $("#urlForm").serialize();
		$.ajax({
			type:"post",
			url:url,
			dataType:"json", 
			//data:info,
			success : function(data) { 
				var text = JSON.stringify(data);
				$("#text").text(text);
			},
			error : function(error) {
				$("#text").text(error.responseText); 
			}
		});
	}
	
	</script>
</head>
<body id="div">
<div >
	<div>
		<h2 style="color:red">点击需要测试的方法，输入对应的参数，点击提交即可返回对应数据</h2>
		<h3>优选系统apollo</h3>
		<!-- <button onclick="clickButton('apollo', 'addACL');">addACL</button>
		<button onclick="clickButton('apollo', 'queryACL');">queryACL</button> -->
		<button onclick="clickButton('delivery');">delivery</button>
		<button onclick="clickButton('querySupplyStatus');">querySupplyStatus</button>
	</div>
	<div>
		<h3>供应商前置hestia</h3>
		<button onclick="clickButton('queryPrice');">queryPrice</button>
		<button onclick="clickButton('topup');">topup</button>
	</div>
	<iframe id="frame" src="pages/delivery.jsp" style="width:800px;height:200px;"></iframe>
	<div>
		<button onclick="testInterface();">提交</button>
		<button onclick="test();">test</button>
		<form id="urlForm"><input id="url" name="url"></form>
	</div>
	<div>
		<textarea id="text" rows="20" cols="80"></textarea>
	</div>
</div>
</body>
</html>

