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
		<link rel="stylesheet" href="static/adminLTE/dist/css/skins/_all-skins.min.css">
		<!-- bootstrap wysihtml5 - text editor -->
		<link rel="stylesheet" href="static/adminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
	  <script src="static/adminLTE/dist/js/html5shiv.min.js"></script>
	  <script src="static/adminLTE/dist/js/respond.min.js"></script>
	  <![endif]-->
	  <link rel="stylesheet" href="static/common/css/common.css" />
	  <style>
	  	.center{text-align: center;}
	  	.is-must{color:red;}
	  	.is-tips{font-size:12px;font-weight:100;color: crimson;}
	  	.control-label{font-size:12px;}
	  </style>
	</head>
	<body>
		<!-- wrapper start -->
		<div class="wrapper">
			<!-- Content Header (Page header) -->
			<section id="content-header" class="content-header">
				<h1>
		           	系统管理 <small>用户管理</small>
		        </h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-home"></i>用户管理</a></li>
					<li class="active">添加用户</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content main-content" id="mainContent">
				 <div class="row">
			        <!-- left column -->
			        <div class="col-md-6">
			          <!-- general form elements -->
			          <div class="box box-primary">
			            <div class="box-header with-border">
			              <h3 class="box-title">添加用户</h3>
			            </div>
			            <!-- /.box-header -->
			            <!-- form start -->
			            <form role="form" id="userForm" action="user/addUser" method="post">
			              <div class="box-body">
			                <div class="form-group" id="userName_pane">
			                  <label for="userName">
			                  	<span class="is-must">*&nbsp;</span>用户名
			                  	<span class="is-tips">(字母、数字和下划线组成，且只能字母开头)</span>
			                  </label>
			                  <div class="input-group  input-group-sm">
				                  <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名" required="true">
				                  <span class="input-group-btn" >
			                        <button type="button" class="btn btn-info btn-flat" id="vali_user">验证用户名是否可用</button>
			                      </span>
			                   </div>
			                   <label class="control-label hidden" for="" id="userName_err"></label>
			                </div>
			                <div class="form-group" id="realName_pane">
			                  <label for="realName">
			                  	<span class="is-must">*&nbsp;</span>姓名
			                  	<span class="is-tips">(只能是字母或者中文汉字)</span>
			                  </label>
				              <input type="text" class="form-control" id="realName" name="realName" placeholder="姓名" required="true">
			                  <label class="control-label hidden" for="" id="realName_err"></label>
			                </div>
			                <div class="form-group" id="password_pane">
			                  <label for="password">
			                  	<span class="is-must">*&nbsp;</span>密码
			                  	<span class="is-tips">(密码由6到12位数字、字母或特殊字符组合)</span>
			                  </label>
			                  <input type="password" class="form-control" id="password" name="password" placeholder="用户密码" required="true">
			                  <label class="control-label hidden" for="" id="password_err"></label>
			                </div>
			                <div class="form-group" id="re_password_pane">
			                  <label for="re_password"><i class="is-must">*&nbsp;</i>确认密码</label>
			                  <input type="password" class="form-control" id="re_password" name="re_password" placeholder="再次输入用户密码" required="true">
			                  <label class="control-label hidden" for="" id="re_password_err"></label>
			                </div>
			                 <div class="form-group" id="email_pane">
			                  <label for="email">
			                  	<span class="is-must">*&nbsp;</span>邮箱
			                  	<span class="is-tips">(邮箱格式:xxxx@xxx)</span>
			                  </label>
			                  <input type="email" class="form-control" id="email" name="email" placeholder="邮箱" required="true">
			               	  <label class="control-label hidden" for="" id="email_err"></label>
			                </div>
			                <div class="form-group" id="realName_pane">
			                  <label for="userName">
			                  	<span class="is-must">&nbsp;</span>备注
			                  	<span class="is-tips">(最多输入80字符)</span>
			                  </label>
				              <textarea  class="form-control" id="remarks" name="remarks" placeholder="备注" required="true"></textarea>
			                  <label class="control-label hidden" for="" id="remarks_err"></label>
			                </div>
			              </div>
			              <!-- /.box-body -->
			
			              <div class="box-footer">
			                <button type="button" class="btn btn-primary" id="btn-save">保存</button>
			                <button type="reset" class="btn btn-primary">重置</button>
			              </div>
			            </form>
			         </div> <!-- /.box -->
			</section><!-- ./main content end -->
		</div><!-- ./wrapper end -->
		
		<script src="static/common/js/jquery-1.11.3.min.js"></script>
		<script src="static/adminLTE/bootstrap/js/bootstrap.min.js"></script>
		<!-- AdminLTE App -->
		<script src="static/adminLTE/dist/js/app.min.js"></script>
		<!-- FastClick -->
		<script src="static/adminLTE/plugins/fastclick/fastclick.js"></script>
		<!-- boot-box -->
		<script src="static/bootbox/bootbox.min.js"></script> 
		<!-- inline scripts related to this page -->
		<script src="static/common/js/common.js"></script> 
		<!-- page script -->
		<script>
			 $(function(){
			 	//验证用户名是否可用
			 	$("#vali_user").on("click",function(){
			 		validationUserName();
			 	});
			 	//保存
			 	save();
			 });
			 
			 //保存添加用户
			 function save(){
			 	$("#btn-save").on("click",function(){
			 		$("#btn-save").attr("disabled","disabled");
			 		//若用户名验证失败
			 		if(!validationUserName()){
			 			$("#btn-save").removeAttr("disabled");
			 			return false;
			 		}
			 		//验证密码
			 		if(!validationPassword()){
			 			$("#btn-save").removeAttr("disabled");
			 			return false;
			 		}
			 		$.ajax({
						url:'user/addUser',
						type:'post',
						dataType:'json',
						data:$("#userForm").serialize(),
						success:function(data){ 
							if(data.status=="suc"){
					 			 location.href="user/list";
					 		}else{
					 			$("#btn-save").removeAttr("disabled");
					 			 alert("添加失败");
					 		}
						},
						error:function(XMLHttpRequest, textStatus, errorThrown){ 
							alert("网络异常，请稍后重试"); 	
							$("#btn-save").removeAttr("disabled");
							return false;
						}
					});  
			 	});
			 }
			 
			 //验证用户名是否可用
			 function validationUserName(){
				var userName = $.trim($("#userName").val());
				if(userName==undefined||userName==""){
					hasError("userName","用户名不能为空");
					$("#userName").focus();
					return false;
				}
				//var pattern = new RegExp("^[A-Za-z0-9]+$"); 
				var pattern = new RegExp("^[a-zA-Z]+[a-zA-Z0-9_]*$");
				if(!pattern.test(userName)){
					hasError("userName","用户名只能是字母、数字和下划线组成，且只能字母开头");
					$("#userName").select();
					return false;
				}
				var flag = false;
				$.ajax({
					url:'user/validate',
					type:'post',
					async:false,
					dataType:'json',
					data:{
						userName:userName
					},
					success:function(data){ 
						if(data.isExist=="Y"){
				 			hasError("userName","用户名已存在");
				 			$("#userName").select();
				 			flag = false;
				 		}else{
				 			noError("userName");
				 			successError("userName","用户名可用");
				 			flag = true;
				 		}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){ 
						alert("网络异常，请稍后重试"); 	
						return false;
					}
				});  
				return flag;
			 }
			 
			 //验证密码（包括确认密码）
			 function validationPassword(){
			 	//强密码验证：字母+数字+特殊字符
			 	//var pattern = new RegExp("^[0-9A-Za-z][~!@#$%^&*?]{6,}$");
			 	var pattern = new RegExp("^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{6,12}$");
			 	//密码验证：
			 	var password = $.trim($("#password").val());
			 	if(password==undefined||password==""){
			 		hasError("password","请先输入密码");
					$("#password").focus();
					return false;
			 	}
			 	if(!pattern.test(password)){
			 		hasError("password","密码过于简单，密码由6到12位数字、字母或特殊字符组合");
					$("#password").select();
					return false;
			 	}
			 	successError("password","");
			 	//确认密码验证
			 	var re_password = $.trim($("#re_password").val());
			 	if(re_password==undefined||re_password==""){
			 		hasError("re_password","请先输入密码");
					$("#re_password").focus();
					return false;
			 	}
			 	//验证两次密码是否一致
			 	if(re_password!=password){
			 		hasError("re_password","两次密码输入不一致，请确认");
					$("#re_password").select();
					return false;
			 	}
			 	return true;
			 }
			 
			 /*************************************************************/
			 
			 //验证不通过信息提示
			 function hasError(id,tips){
			 	$("#"+id+"_pane").addClass("has-error");
			 	$("#"+id+"_err").empty();
			 	if(tips!=undefined&&tips!=""){
			 		$("#"+id+"_err").html('<i class="fa fa-times-circle-o"></i>'+tips);
			 	}
			 	$("#"+id+"_err").removeClass("hidden");
			 }
			 
			 //验证通过
			 function noError(id){
			 	$("#"+id+"_pane").removeClass("has-error");
			 	$("#"+id+"_err").empty();
			 	$("#"+id+"_err").addClass("hidden");
			 }
			 
			 //成功提示信息【验证】
			 function successError(id,tips){
			 	$("#"+id+"_pane").removeClass("has-error");
			 	$("#"+id+"_pane").addClass("has-success");
			 	$("#"+id+"_err").empty();
			 	if(tips!=undefined&&tips!=""){
			 		$("#"+id+"_err").html('<i class="fa fa-check"></i>'+tips);
			 	}
			 	$("#"+id+"_err").removeClass("hidden");
			 }
		</script>
	</body>

</html>