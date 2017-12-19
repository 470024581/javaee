<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
	<title>test</title>
</head>
<body>
	<!-- 添加鼠标悬停播放，离开暂停的功能 -->
	<video id="movies" autoplay onmouseover="play()" onmouseout="pause()" oncanplay="startVideo();" onended="stopTimeline();" width="400px" height="300px">
		<source src="legal.ogv" type='video/ogg; codecs="theora, vorbis"'></source>
	</video>
	
	<canvas id="timeline" style="border:1px solid" width="400px" height="300px"></canvas>
	<div>
		自动播放，鼠标移入播放，移除暂停。记录播放时序图，并点击任意一帧，可以回放到该帧。
	</div>
	<script type="text/javascript">
		// 抓取帧的时间间隔：单位ms
		var updateInterval = 2000;
		// 时序中帧的尺寸
		var frameWidth = 100;
		var frameHeight = 75;
		// 时序的总帧数
		var frameRows = 4;
		var frameColumns = 4;
		var frameGrid = frameRows * frameColumns;
		// 当前帧
		var frameCount = 0;
		var intervalId;// 播放完取消计时器
		var videoStarted = false;
		
		var timeline = document.getElementById("timeline");
		timeline.onclick = function(event){
			var offX = event.layerX - timeline.offsetLeft;
			var offY = event.layerY - timeline.offsetTop;
			// 计算以0为基准的网格中哪帧被点击
			var clickedFrame = Math.floor(offY / frameHeight) * frameRows;
			clickedFrame += Math.floor(offX / frameWidth);
			// 视频开始后已经播放到多少帧
			var seekedFrame = (((Math.floor(frameCount / frameGrid)) * frameGrid) + clickedFrame);
			// 如果用户单击的帧在当前帧之前，则嘉定是上一轮的帧
			if(clickedFrame > (frameCount % 16))
				seekedFrame -= frameGrid;
			// 不允许跳出当前视频
			if(seekedFrame < 0)
				return;
			// 计算出这帧对应的视频，currentTime以s为单位，javascript的计时器以ms为单位
			var video = document.getElementById("movies");
			video.currentTime = seekedFrame * updateInterval / 1000;
			// 设置目标帧
			frameCount = seekedFrame;
		};
		function updateFrame(){
			var video = document.getElementById("movies");
			//var timeline = document.getElementById("timeline");
			var ctx = timeline.getContext("2d");
			// 根据帧数计算出当前播放位置，然后以视频为输入参数绘制图像
			var framePosition = frameCount % frameGrid;
			var frameX = (framePosition % frameColumns) * frameWidth;
			var frameY = (Math.floor(framePosition / frameRows)) * frameHeight;
			ctx.drawImage(video, 0, 0, 400, 300, frameX, frameY, frameWidth, frameHeight);
			frameCount++;
		};
		// 视频开始时调用
		function startVideo() {
			// 只在视频第一次播放时设置计时器
			if(videoStarted)
				return;
			videoStarted = true;
			// 计算初始帧，然后以规定时间间隔创建其他帧
			updateFrame();
			intervalId = setInterval(updateFrame, updateInterval);
		};
		// 视频结束时调用
		function stopTimeline(){
			clearInterval(intervalId);
		}
		
	</script>
</body>
</html>

