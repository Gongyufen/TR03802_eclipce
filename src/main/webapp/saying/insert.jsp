<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function () {
		$("#id").submit(function() {
			if($(".content").val.trim().length>0
			&& $(".user").val.trim().length>0){
				return true;
			}else{
				alert("请输入留言内容和留言人名称");
				return false;
			}
		});
	});
</script>
<style type="text/css">
	*{
		font-size: 14px;
	}
	.content{
		width: 400px;
		height: 100px;
	}
</style>
</head>
<body>
	<h1>给网站留言</h1>
	<form action="../saying/insert" method="post" id="id">
		<div>内容：</div>
		<div>
			<textarea class="content" name="content"></textarea>
		</div>
		<div>
			留言人：<input name="user" class="user">
		</div>
		<div>
			<input type="submit" value="提交">
		</div>
	</form>
	<a href="../saying/list">查看留言</a>
</body>
</html>