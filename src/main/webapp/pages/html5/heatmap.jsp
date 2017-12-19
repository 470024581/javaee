<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
	<title>test</title>
	<style type="text/css">
		#heatmap{
			background-image : url("Koala.jpg");
		}
	</style>
	<script src="js/jquery1.8.1.js"></script>
	<script type="text/javascript">
		var canvas;
		var ctx;
		var points = {};
		var SCALE = 3;
		var x = -1;
		var y = -1;
		
		function loadDemo(){
			document.getElementById("resetButton").onclick = reset;
			
			canvas = document.getElementById("heatmap");
			ctx = canvas.getContext("2d");
			ctx.globalAlpha = 0.2;
			ctx.globalCompositeOperation = "lighter";
			
			function sample(){
				if(x != -1){
					addToPoint(x, y);
				}
				setTimeout(sample, 100);
			}
			
			canvas.onmousemove = function(e){
				x = e.clientX - e.target.offsetLeft;
				y = e.clientY - e.target.offsetTop;
				addToPoint(x, y);
			};
			
			sample();
		};
		
		function reset(){
			points = {};
			ctx.clearRect(0, 0, 300, 300);
			x = -1;
			y = -1;
		}
		// 鼠标移动或悬停的时候会调用该方法，热度只会升高并保存下来，
		function addToPoint(x, y){
			x = Math.floor(x/SCALE);
			y = Math.floor(y/SCALE);
			// 像素点的最高热度是10
			if (!points[[x,y]]) {
				points[[x,y]] = 1;
			} else if (points[[x,y]] == 10) {
				return;
			} else {
				points[[x,y]]++;
			}
			drawPoint(x*SCALE, y*SCALE, points[[x, y]]);
		}
		// 画点
		function drawPoint(x, y, radius){
			ctx.fillStyle = getColor(radius);
			// sqrt：square root 的缩写，返回参数的平方根，如参数16，返回值4
			radius = Math.sqrt(radius) * 6;
			
			ctx.beginPath();
			// 画一个原型，参数1和2表示原点坐标，参数3表示圆的半径，参数4表示开始弧度，0表示3点钟方向，参数5表示结束弧度，Math.PI*2表示一周360°，参数6false表示逆时针绘图，true表示顺时针绘图
			// ctx.arc(x, y, radius, 0, Math.PI*1, false); 表示从3点钟方向开始，以顺时针，绘制180°的圆
			ctx.arc(x, y, radius, 0, Math.PI*2, true);
			
			ctx.closePath();
			ctx.fill();
		}
		// 获取颜色：根据半径值越大，画出的圆越亮，越热
		function getColor(intensity){
			var colors = ["#072933", "#2E4045", "#8C593B", "#B2814E", "#FAC268", "FAD237"];
			return colors[Math.floor(intensity/2)];
		}
		window.addEventListener("load", loadDemo, true);
	</script>
</head>
<body>
	<h2>heatmap</h2>
	<canvas id="heatmap" class="clear" style="border:1px solid;" width="300" height="300">HTML5 Canvas is not supported in your browser.</canvas>
	<button id="resetButton">Reset</button>
	<span>鼠标热点轨迹</span>
</body>
</html>

