<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {
 		position: absolute;
 		top:230px;
 		left:10px;
 		letter-spacing: 5px;
	}
	.bd{
		width: 280px;
		height: 250px;
		background-color: white;
		border-radius: 5px;
		position: absolute;
		top:150px;
		left:950px;
		justify-content: center;
	}
	p{
		position: absolute;
		left:120px;
		top:0px;
		font-weight: bold;
		font-size: 20px;
	}
	.zha{
		position: absolute;
		top:60px;
		left:10px;
	}
	.zha .text{
		height: 18px;
		width: 200px;
	}
	.mma{
		position: absolute;
		top:120px;
		left:10px;
	}
	.mma .pwd{
		height: 18px;
		width: 200px;
	}
	button {
		position: absolute;
		top:190px;
		left:10px;
		width:260px;
		height: 25px;
		color: white;
		background-color: #00BFFF;
		border-radius: 6px;
		border: 1px;
	}
</style>
</head>
<body style="background-color: #4682B4">
	<a style="color: white; font-size: 30px;font-weight:bold ">停车云|智慧停车管理系统</a>
	<div class="bd">
		<form method="get" action="../tcxt/dl">
			<p>登录</p>
			<div class="zha">账号：<input class="text" name="zh"><br></div>
			<div class="mma">密码：<input type="password" class="pwd" name="mm"></div>
			<button>登录</button>
		</form>
	</div>
</body>
</html>