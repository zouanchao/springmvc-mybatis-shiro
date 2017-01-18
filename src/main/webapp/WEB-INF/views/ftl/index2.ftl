<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<base href="${base}">
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>spring-mybatis-demo首页</title>
		<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!-- Bootstrap 3.3.6 -->
		<link rel="stylesheet" href="static/adminLTE/bootstrap/css/bootstrap.min.css">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="static/adminLTE/dist/css/font-awesome.min.css">
		<!-- Ionicons -->
		<link rel="stylesheet" href="static/adminLTE/dist/css/ionicons.min.css">
		<!-- Theme style -->
		<link rel="stylesheet" href="static/adminLTE/dist/css/AdminLTE.min.css">
		<!-- AdminLTE Skins. Choose a skin from the css/skins
	       folder instead of downloading all of them to reduce the load. -->
		<link rel="stylesheet" href="static/adminLTE/dist/css/skins/_all-skins.min.css">
		<!-- iCheck -->
		<link rel="stylesheet" href="static/adminLTE/plugins/iCheck/flat/blue.css">
		<!-- Morris chart -->
		<link rel="stylesheet" href="static/adminLTE/plugins/morris/morris.css">
		<!-- jvectormap -->
		<link rel="stylesheet" href="static/adminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
		<!-- Date Picker -->
		<link rel="stylesheet" href="static/adminLTE/plugins/datepicker/datepicker3.css">
		<!-- Daterange picker -->
		<link rel="stylesheet" href="static/adminLTE/plugins/daterangepicker/daterangepicker.css">
		<!-- bootstrap wysihtml5 - text editor -->
		<link rel="stylesheet" href="static/adminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
	  <script src="static/adminLTE/dist/js/html5shiv.min.js"></script>
	  <script src="static/adminLTE/dist/js/respond.min.js"></script>
	  <![endif]-->
	  <link rel="stylesheet" href="static/common/css/common.css" />
	  <script type="text/javascript">
	  		/*设置iframe的高度*/
			function initIframeHeight(){
				var ifa = "mainFrame";
				//显示Loadding
				var load_dialog = showLoadDialog("页面君努力加载中，请稍后...");
				setTimeout(function(){
					setIframeHeight(ifa);
					//关闭Load
					load_dialog.modal('hide');
				},1000);
			}
	  </script>
	</head>
	<body class="hold-transition skin-green sidebar-mini">
		<div class="wrapper">
			<header class="main-header">
				<a href="javascript:void(0);" class="logo">
					<span class="logo-mini"><b>J</b>ack</span>
					<span class="logo-lg"><b>Jack</b>Cooper</span>
				</a>
				<!-- ./logo -->
				<!-- Header Navbar -->
				<nav class="navbar navbar-static-top" role="navigation">
					<!-- 隐藏左侧按钮操作 -->
					<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
						<span class="sr-only">Toggle navigation</span>
					</a>
					<!-- Navbar Right Menu -->
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">
							<!-- 系统消息 -->
							<li class="dropdown messages-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<i class="fa fa-envelope-o"></i>
									<span class="label label-success">4</span>
								</a>
								<ul class="dropdown-menu">
									<li class="header">你有 4 条新消息</li>
									<li>
										<!-- inner menu: contains the actual data -->
										<ul class="menu">
											<li>
												<!-- start message -->
												<a href="#">
													<div class="pull-left">
														<img src="static/adminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
													</div>
													<h4>
				                        Bad Boy 邀请你匹配
				                        <small><i class="fa fa-clock-o"></i> 5 分钟前</small>
				                      </h4>
													<p>Why not ?</p>
												</a>
											</li>
											<!-- end message -->
											<li>
												<a href="#">
													<div class="pull-left">
														<img src="static/adminLTE/dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
													</div>
													<h4>
				                        AdminLTE Design...
				                        <small><i class="fa fa-clock-o"></i> 2 小时前</small>
				                      </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
											<li>
												<a href="#">
													<div class="pull-left">
														<img src="static/adminLTE/dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
													</div>
													<h4>
				                        Developers
				                        <small><i class="fa fa-clock-o"></i> 今天</small>
				                      </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
											<li>
												<a href="#">
													<div class="pull-left">
														<img src="static/adminLTE/dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
													</div>
													<h4>
				                        Sales Department
				                        <small><i class="fa fa-clock-o"></i> 昨天</small>
				                      </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
											<li>
												<a href="#">
													<div class="pull-left">
														<img src="static/adminLTE/dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
													</div>
													<h4>
				                        Reviewers
				                        <small><i class="fa fa-clock-o"></i> 2 天前</small>
				                      </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
										</ul>
									</li>
									<li class="footer">
										<a href="#">查看所有消息</a>
									</li>
								</ul>
							</li>
							<!-- 当前登录用户信息 -->
							<li class="dropdown user user-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<img src="static/adminLTE/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
									<span class="hidden-xs">超级管理员</span>
								</a>
								<ul class="dropdown-menu">
									<!-- The user image in the menu -->
									<li class="user-header">
										<img src="static/adminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
										<p>
											<strong>设置</strong>
											<small>上次登录时间:2016年12月30 00:00:12</small>
										</p>
									</li>
									<!-- Menu Body -->
									<!-- Menu Footer-->
									<li class="user-footer">
										<div class="pull-left">
											<a id="profile" href="user/profile" class="btn btn-default btn-flat">个人资料</a>
										</div>
										<div class="pull-right">
											<a href="logout" class="btn btn-default btn-flat">注销</a>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</div>
					<!-- ./navbar-custom-menu -->
				</nav>
				<!-- ./Header Navbar -->
			</header>
			<!-- ./main-header -->

			<!-- Left side column. contains the logo and sidebar -->
			<aside class="main-sidebar">
				<section class="sidebar">
					<!-- Sidebar user panel -->
					<div class="user-panel">
						<div class="pull-left image">
							<img src="static/adminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
						</div>
						<div class="pull-left info">
							<p>超级管理员</p>
							<a href="#"><i class="fa fa-circle text-danger"></i>离开</a>
						</div>
					</div>
					<!-- ./user-panel -->

					<!-- search form -->
					<form action="#" method="get" class="sidebar-form">
						<div class="input-group">
							<input type="text" name="q" class="form-control" placeholder="搜素...">
							<span class="input-group-btn">
			                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
			                </button>
			              </span>
						</div>
					</form>
					<!-- /.search form -->

					<!-- sidebar menu: : style can be found in sidebar.less -->
					<ul class="sidebar-menu">
						<li class="header">
							<span class="menu-header-title">系统菜单</span>
						</li>
						<li class="active treeview">
							<a href="#">
								<i class="fa fa-link"></i> <span>系统管理</span>
								<span class="pull-right-container">
				          <i class="fa fa-angle-left pull-right"></i>
				        </span>
							</a>
							<ul class="treeview-menu">
								<li class="active">
									<a href="user/list" target="mainFrame"><i class="fa fa-circle-o"></i>用户管理</a>
								</li>
								<li>
									<a href="index2.html"><i class="fa fa-circle-o"></i>角色管理</a>
								</li>
								<li>
									<a href="index2.html"><i class="fa fa-circle-o"></i>资源管理</a>
								</li>
							</ul>
						</li>
						<li class="treeview">
							<a href="#">
								<i class="fa fa-link"></i> <span>监控管理</span>
								<span class="pull-right-container">
				          <i class="fa fa-angle-left pull-right"></i>
				        </span>
							</a>
							<ul class="treeview-menu">
								<li class="active">
									<a href="druid/index.html" target="mainFrame"><i class="fa fa-circle-o"></i>Druid监控</a>
								</li>
								<li>
									<a href="index2.html"><i class="fa fa-circle-o"></i>数据字典</a>
								</li>
								<li>
									<a href="index2.html"><i class="fa fa-circle-o"></i>日志管理</a>
								</li>
							</ul>
						</li>
						<li class="header">
							<span class="menu-header-title">其他</span>
						</li>
						<li>
							<a href="#"><i class="fa fa-circle-o text-red"></i> <span>导入</span></a>
						</li>
						<li>
							<a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>警告</span></a>
						</li>
						<li>
							<a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>信息</span></a>
						</li>
					</ul>

				</section>
				<!-- ./sidebar -->
			</aside>
			<!-- ./main-sidebar -->
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section id="content-header" class="content-header">
					<h1>
			                        控制面板
			        <small>控制面板</small>
			      </h1>
					<ol class="breadcrumb">
						<li>
							<a href="#"><i class="fa fa-home"></i>首页</a>
						</li>
						<li class="active">控制面板</li>
					</ol>
				</section>
				<!-- Main content -->
				<section class="content main-content" id="mainContent">
					<!--
					<div class="row">
						<div class="col-xs-12">
							<div class="box-header with-border">
								<h3 class="box-title">欢迎来到AdminLTE 免费模板 </h3>
							</div>
							<div class="box-body">
								<div class="row">
									<div class="col-md-12">
										<div id="myCarousel" class="carousel-fade carousel slide">
											<ol class="carousel-indicators">
												<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
												<li data-target="#myCarousel" data-slide-to="1"></li>
												<li data-target="#myCarousel" data-slide-to="2"></li>
											</ol>   
											<div class="carousel-inner">
												<div class="item active">
													<img src="http://www.wpmomo.com/wp-content/uploads/2015/04/slider2.png" class="img-responsive carousel-img" alt="First slide">
													<div class="carousel-caption">标题 1</div>
												</div>
												<div class="item">
													<img src="http://www.wpmomo.com/wp-content/uploads/2015/04/slider2.png" class="img-responsive carousel-img" alt="Second slide">
													<div class="carousel-caption">标题 2</div>
												</div>
												<div class="item">
													<img src="http://www.wpmomo.com/wp-content/uploads/2015/04/slider2.png" class="img-responsive carousel-img" alt="Third slide">
													<div class="carousel-caption">标题 3</div>
												</div>
											</div>
											<a class="carousel-control left" href="#myCarousel"  data-slide="prev" role="button" >&lsaquo;</a>
											<a class="carousel-control right" href="#myCarousel" data-slide="next" role="button">&rsaquo;</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					-->
					<iframe name="mainFrame" id="mainFrame" frameborder="0" scrolling="no" src="demo/welcome" style="margin:0 auto;width:100%;height:100%;" onLoad="initIframeHeight()"></iframe>
				</section><!-- ./end -->
			</div>
		</div>
		<!-- ./wrapper -->
		<script src="static/common/js/jquery-1.11.3.min.js"></script>
		<script src="static/adminLTE/bootstrap/js/bootstrap.min.js"></script>
		<!-- AdminLTE App -->
		<script src="static/adminLTE/dist/js/app.min.js"></script>
		<script src="static/adminLTE/plugins/iCheck/icheck.min.js"></script>
		<script src="static/adminLTE/plugins/select2/select2.min.js"></script>
		<script src="static/adminLTE/plugins/input-mask/jquery.inputmask.js"></script>
		<script src="static/adminLTE/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
		<script src="static/adminLTE/plugins/input-mask/jquery.inputmask.extensions.js"></script>
		<script src="static/adminLTE/plugins/daterangepicker/moment.js"></script>
		<script src="static/adminLTE/plugins/daterangepicker/daterangepicker.js"></script>
		<!-- boot-box -->
		<script src="static/bootbox/bootbox.min.js"></script> 
		<!-- inline scripts related to this page -->
		<script src="static/common/js/index.js"></script> 
		<script src="static/common/js/common.js"></script> 
		<script>
			$(function() {
				$("#myCarousel").carousel('cycle');
			});
		</script>
	</body>

</html>