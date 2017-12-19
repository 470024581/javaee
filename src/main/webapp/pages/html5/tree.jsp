<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
	<title>test</title>
	<script src="js/jquery1.8.1.js"></script>
	<script type="text/javascript">
		function drawTrails(){
			var canvas = document.getElementById("diagonal");
			var context = canvas.getContext("2d");
			
			context.save();
			context.translate(130,250);
			// 画出树冠
			createCanopyPath(context);
			// 描边样式和填充样式
			addStyle(context);
			// 画出树干
			createRect(context);
			context.stroke();
			context.restore();
			
			// 画出小路（曲线）
			createCurve(context);
			
			context.save();
			context.translate(260,500);
			// 将第二颗树的宽高放大2倍
			context.scale(2, 2);
			createCanopyPath(context);
			addStyle(context);
			createRect(context);
			context.stroke();
			context.restore();
			
			context.save();
			context.translate(260,500);
			// x值随着y值的增加而增加，借助拉伸变换，可以创建一棵用作阴影的倾斜的树
			context.transform(1, 0, -0.5, 1, 0, 0);
			// 在y轴方向，将阴影的高度压缩为原来的60%
			context.scale(1, 0.6);
			// 使用透明度为20%的黑色填充树干
			context.fillStyle = 'rgba(0,0,0,0.1)';
			context.fillRect(-5, -50, 10, 50);
			// 绘制小树
			createCanopyPath(context);
			createRect(context);
			context.fill();
			context.stroke();
			context.restore();
			
			// 添加文本
			addText(context);
			
		}
		
		function addText(ctx){
			ctx.save();
			// 设置字体大小，字体类型。颜色、居中
			ctx.font = "60px impact";
			ctx.fillStyle = '#996600';
			ctx.textAlign = 'center';
			
			//字体添加阴影：颜色黑色，透明度为20%
			ctx.shadowColor = 'rgba(0, 0, 0, 0.2)';
			//设置阴影向右移动15向上移动10、
			ctx.shadowOffsetX = 15;
			ctx.shadowOffsetY = -10;
			//轻微模糊阴影
			ctx.shadowBlur = 2;
			
			// 设置文本内容，显示坐标，最后个参数可选（用于限制字体大小）
			ctx.fillText('Happy Trails!', 200, 60, 400);
			ctx.restore();
		}
		
		function addStyle(context){
			// 描边样式
			context.lineWidth = 4;// 加宽线条
			context.lineJoin = "round";// 平滑路径的接合点，还有bevel和miter（相应的context.miterLimit也要调整）变换拐角样式
			context.strokeStyle = "#663300";// 将颜色改为棕色
			//context.lineCap = "butt"; // 指定端点的样式，闭合图形中没有端点
			// 填充样式
			context.fillStyle = "green";// 将填充色设置为绿色
			context.fill();// 填充操作
		}
		function createCanopyPath(context){
			context.beginPath();
			context.moveTo(-25, -50);
			context.lineTo(-10,-80);
			context.lineTo(-20,-80);
			context.lineTo(-5,-110);
			context.lineTo(-15,-110);
			// 树的顶点
			context.lineTo(0,-140);
			
			context.lineTo(15,-110);
			context.lineTo(5,-110);
			context.lineTo(20,-80);
			context.lineTo(10,-80);
			context.lineTo(25,-50);
			// 连接起点，闭合路径
			context.closePath();
		}
		function createRect(context){
			// 创建渐变对象
			var trunkGradient = context.createLinearGradient(-5, -50, 5, -50);
			// 树干左边边缘一般程度的棕色
			trunkGradient.addColorStop(0, '#663300');
			// 树干中间颜色淡一些
			trunkGradient.addColorStop(0.4, '#996600');
			// 树干右边颜色要深一些
			trunkGradient.addColorStop(1, '#552200');
			context.fillStyle = trunkGradient;//'#663300'
			context.fillRect(-5, -50, 10, 50);
			//strokeRect 基于给出位置的坐标画出矩形的轮廓
			//clearRect	 清除矩形区域内所有内容，并恢复到初始状态，透明色
			
			// 创建垂直渐变，以作用树冠在树干上投影
			var canopyShadow = context.createLinearGradient(0, -50, 0, 0);
			// 投影渐变的起点是透明度为50%的黑色
			canopyShadow.addColorStop(0, 'rgba(0, 0, 0, 0.5)');
			// 方向垂直向下，渐变色在很短的距离内迅速渐变至完全透明，这段长度之外的树干上没有投影
			canopyShadow.addColorStop(0.2, 'rgba(0, 0, 0, 0)');
			context.fillStyle = canopyShadow;
			context.fillRect(-5, -50, 10, 50);
		}
		function createCurve(context){
			context.save();
			context.translate(-10, 350);
			context.beginPath();
			// 第一条曲线向右上方弯曲
			context.moveTo(0, 0);
			context.quadraticCurveTo(170, -50, 260, -190);
			
			// 第二条曲线向右下方弯曲
			context.quadraticCurveTo(310, -250, 410, -250);
			
			// 使用棕色的粗线来绘制路径
			context.strokeStyle = '#663300';
			context.lineWidth = 20;
			context.stroke();
			context.restore();
		}
		window.addEventListener("load", drawTrails, true);
	</script>
</head>
<body>
	<canvas id="diagonal" style="border:1px solid;" width="800" height="800">HTML5 Canvas is not supported in your browser.</canvas>
</body>
</html>

