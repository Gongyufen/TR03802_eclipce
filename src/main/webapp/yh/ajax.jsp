<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$.getJSON("yy",function(v){
		for(var i=0;i<v.length;i++){
			var tr = $("<tr>").addClass("c");
			$("#tb").append(tr);
			var td1 = $("<td>").html(v[i].id);
			td1.appendTo(tr);
			var td2 = $("<td>").html(v[i].xm);
			td2.appendTo(tr);
			var td3 = $("<td>").addClass("delete-button").attr("sid", v[i].id);
			var button = $("<button>").html("删除");
			button.appendTo(td3);
			td3.appendTo(tr);
		}
	});
	$(document).on("click",".delete-button",function(){
		$("#tb").find(".c").remove();
		var sid=$(this).attr("sid");
		$.getJSON("dd",{"sid":sid},function(v){
			for(var i=0;i<v.length;i++){
				var tr = $("<tr>").addClass("c");
				$("#tb").append(tr);
				var td1 = $("<td>").html(v[i].id);
				td1.appendTo(tr);
				var td2 = $("<td>").html(v[i].xm);
				td2.appendTo(tr);
				var td3 = $("<td>").addClass("delete-button").attr("sid", v[i].id);
				td3.appendTo(tr);
				var button = $("<button>").html("删除");
				button.appendTo(td3);
			}
		});
	});
});
</script>
</head>
<body>
	<div id="box">
		<table  border=1>
			<tr>	
				<th>id</th>
				<th>name</th>
				<th>操作</th>
			</tr>
			<tbody id="tb">
			
			</tbody>
		</table>
	</div>
</body>
</html>