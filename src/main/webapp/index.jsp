<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<title>供货平台-供货引擎</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.min.css">
<style type="text/css" media="screen">
body, button, input, select, textarea, h1, h2, h3, h4, h5, h6 {
	font-family: Microsoft YaHei, '宋体', Tahoma, Helvetica, Arial,
		"\5b8b\4f53", sans-serif;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1.8.1.js"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>

</head>
<body>
	<header id="header" class="">
		<!--导航栏板块-->
		<nav  class='navbar navbar-inverse'>
			<!--导航栏容器处理-->
			<div class="container-fluid">
				<!--导航栏头处理-->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">供货平台-供货引擎</a>
				</div>
				<!--导航栏工具栏处理-->
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">入门必读</a></li>
						<li><a href="http://localhost:8161/admin/queues.jsp">activemq监控</a></li>
						<li><a href="http://localhost:8080/myTest/druid/index.html">druid数据监控</a></li>
						<li><a href="#"></a></li>
						<li><a href="#"></a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">拓展接口服务<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">供货板块</a></li>
								<li><a href="#">商品板块</a></li>
								<li><a href="#">支付板块</a></li>

								<li role="separator" class="divider"></li>
								<li class="dropdown-header">接口流程说明</li>
								<li><a href="#">协议支持</a></li>
								<li><a href="#">相关接口文档</a></li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="#">反馈问题 <span class="sr-only">(current)</span></a></li>
						<li><a href="#">帮助中心</a></li>
						<li><a href="#">登陆|注册</a></li> 
					</ul>
				</div><!--/.nav-collapse -->
			</div><!--/.container-fluid -->

		</nav>
		<!--banner板块-->
		<div id="banner"></div>
		
	</header>
	<div class="jumbotron">
		<div class="container">
			<h3>首页</h3>
			<p>首页总汇</p>

		</div>
	</div>
	

	<div class="container-fluid">
		<!-- 行列设计-->
		<div class="row">
			<div class="col-xs-2">
				<ul class="list-group">
					<li class="list-group-item"><a href="#" >调用流程图</a></li>
					<li class="list-group-item">请求参数列表</li>
					<li class="list-group-item">返回参数列表</li>
					<li class="list-group-item">页面可视化测试</li>
					<li class="list-group-item">对应的dubbo接口</li>
				</ul>
			</div>


			<div class=" col-xs-10 ">



				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">接口流程图</div>
					<div class="panel-body">
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
							tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
							quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
							consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
							cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
							proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
								tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
								quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
								consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
								cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
								proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

							</p>
						</div>
					</div>
					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">对应的dubbo接口</div>
						<div class="panel-body list-group-item list-group-item-success">
							<p>com.handpay.core.order.IAppService.appVersion()</p>
						</div>
					</div>
					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">可是化页面测试</div>
						<div class="panel-body">
							<form action="" class="form-horizontal">
								<div class="form-group">
									<label for="inputEmail3" class="control-label col-xs-1">API</label>
									<div class="col-xs-1">
										<input type="email" class="form-control input-sm" id="inputEmail3" placeholder="Email">
									</div>
								</div>
							</form>
						</div>
					</div>

					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">入参说明</div>
						<div class="panel-body">
							<p>
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
								tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
								quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
								consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
								cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
								proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
								<p>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
									tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
									quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
									consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
									cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
									proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

								</p>
							</div>
						</div>
						<div class="panel panel-default">
							<!-- Default panel contents -->
							<div class="panel-heading">响应参数说明</div>
							<div class="panel-body">
								<p>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
									tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
									quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
									consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
									cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
									proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
										tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
										quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
										consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
										cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
										proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

									</p>
								</div>
							</div>
				<!-- <form class="form-inline">
					<div class="form-group">
						<label for="exampleInputName2">测试点</label>
						<input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail2">API</label>
						<input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
					</div>
					<button type="submit" class="btn btn-default">Send invitation</button>
				</form> -->

			</div>

			<!-- <div class="col-md-8">
				<form class="form-horizontal">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">API</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword3" placeholder="Password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label>
									<input type="checkbox"> Remember me
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Sign in</button>
						</div>
					</div>
				</form>
				<div class="btn-group">
					<ol class="breadcrumb">
						<li><input type="text" id="inputEmail3" placeholder="AppCode"></li>
						<li><input type="text" id="inputEmail3" placeholder="应用渠道"></li>
						<li class="active">Data</li>
					</ol>
				
				</div>				
				<ul class="list-group">
					<li class="list-group-item list-group-item-success">Dapibus ac facilisis in</li>
					<li class="list-group-item list-group-item-info">Cras sit amet nibh libero</li>
					<li class="list-group-item list-group-item-warning">Porta ac consectetur ac</li>
					<li class="list-group-item list-group-item-danger">Vestibulum at eros</li>
				</ul>
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-success">Dapibus ac facilisis in</a>
					<a href="#" class="list-group-item list-group-item-info">Cras sit amet nibh libero</a>
					<a href="#" class="list-group-item list-group-item-warning">Porta ac consectetur ac</a>
					<a href="#" class="list-group-item list-group-item-danger">Vestibulum at eros</a>
				</div>
			
			</div> -->
			<!-- <div class="col-md-2">
				<ul class="list-group">
					<li class="list-group-item"><a href="#" >调用流程图</a></li>
					<li class="list-group-item">请求参数列表</li>
					<li class="list-group-item">返回参数列表</li>
					<li class="list-group-item">页面可视化测试</li>
					<li class="list-group-item">对应的dubbo接口</li>
				</ul>
				
			</div> -->


			
		</div>
	</div><!-- 行列设计-->



	<!-- <div class="container">
		左边栏
		<ul class="list-group">
			<li class="list-group-item">Cras justo odio</li>
			<li class="list-group-item">Dapibus ac facilisis in</li>
			<li class="list-group-item">Morbi leo risus</li>
			<li class="list-group-item">Porta ac consectetur ac</li>
			<li class="list-group-item">Vestibulum at eros</li>
		</ul>
	</div> -->
	<!-- 下拉按钮形式显示 -->
	<!-- <div class="btn-group">
		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			Action <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">Action</a></li>
			<li><a href="#">Another action</a></li>
			<li><a href="#">Something else here</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Separated link</a></li>
		</ul>
	</div> -->
	<!--路径形式显示-->
<!-- 	<div class="btn-group">
	<ol class="breadcrumb">
		<li><a href="#">Home</a></li>
		<li><a href="#">Library</a></li>
		<li class="active">Data</li>
	</ol>

</div> -->
<!--缩略图显示模式-->
	<!-- <div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img src="..." alt="...">
					<div class="caption">
						<h3>Thumbnail label</h3>
						<p>...</p>
						<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					</div>
				</div>
			</div>
		</div>
	
	</div> -->

	<!--中间内容-->

	<!--右边栏-->

	<footer>

	</footer>

</body>

</html>

