<%@page import="java.text.SimpleDateFormat"%>
<%@page import="tcxt.Fkgl"%>
<%@page import="java.util.List"%>
<%@page import="tcxt.FkglDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="me" uri="http://www.trkj.com/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	hr{
		color: lightgrey;
	}
	select{
		height: 25px;
	}
	#ss {
	width: 65px;
	height: 25px;
	color: white;
	background-color: #00BFFF;
	border-radius: 6px;
	border: 1px;
}
	.ff{
	width: 95px;
	height: 25px;
	color: white;
	background-color: #00BFFF;
	border-radius: 6px;
	border: 1px;
	margin-right: 10px; 
	}
	#sj{
		margin-top: 20px;
	}
</style>
</head>
<body>
	<div id="fk">访客管理</div>
	<hr>
	<div id="che">
			<form action="../tcxt/fkgl" method="get">
			车牌号    <input name="cph">
			车场企业   <select name="xx">
				<option value="" class="sx" disabled selected hidden>请选择车场企业</option>
				<option value="中国第一汽车集团有限公司">中国第一汽车集团有限公司</option>
            	<option value="东风汽车集团有限公司">东风汽车集团有限公司</option>
            	<option value="重庆长安汽车股份有限公司">重庆长安汽车股份有限公司</option>
            	<option value="上海汽车集团股份有限公司">上海汽车集团股份有限公司</option>
			</select>
			来访事由    <select name="xx2">
				<option value="" class="sx2" disabled selected hidden>请选择来访事由</option>
				<option value="停车">停车</option>
				<option value="休整一下">休整一下</option>
			</select>
			状态    <select name="xx3">
				<option value="" class="sx3" disabled selected hidden>请选择状态</option>
				<option value="已通过">已通过</option>
				<option value="未通过">未通过</option>
			</select>
			<br>
			<br>
			预约时间    <input name="sj">
			<input type="submit" value="搜索" id="ss"> 
			</form>
			<br>
			<button class="ff" id="ewm" onclick="window.location.href='fkewm.jsp'">访客二维码</button>
			<button class="ff" id="fksz">访客设置</button>
			<button class="ff" id="lfsy">来访事由管理</button>
			<button class="ff" id="plsh">批量审核</button>
			<button class="ff" id="fkdj" onclick="window.location.href='fkdj.jsp'">访客登记</button>
	</div>
	<div id="sj">
		<table border="1">
			<tr>
				<th><input type="checkbox"></th>
				<th>编号</th>
				<th>车牌号</th>
				<th>手机号</th>
				<th>来访事由</th>
				<th>企业名称</th>
				<th>申请时间</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>状态</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
			  <%
                FkglDAO dao = new FkglDAO();
                List<Fkgl> fkglList = dao.chaxun();
                for (Fkgl fkgl : fkglList) {
            %>
            <tr>
            	<td><input type="checkbox"></td>
            	<td><%= fkgl.getCid() %></td>
                <td><%= fkgl.getCph() %></td>
                <td><%= fkgl.getPhone() %></td>
                <td><%= fkgl.getSy() %></td>
                <td><%= fkgl.getQymc() %></td>
                <td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fkgl.getSqsj()) %></td>
				<td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fkgl.getKssj()) %></td>
				<td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fkgl.getJssj()) %></td>
                <td><%= fkgl.getZt() %></td>
                <td><%= fkgl.getBz() %></td>
               <td style="display: flex;">
    				<button style="margin-right: 10px;">删除</button>
    				<button>审核</button>
			   </td>
            </tr>
            <%
                }
            %>
		</table>
	</div>
	<me:page controller="fkgg" pagesize="${param.pagesize}" total="${map.total}" curpage="${param.curpage}"/>
	<script>
    var firstCheckbox = document.querySelector("table input[type='checkbox']:first-of-type");
    firstCheckbox.onclick = function() {
        var checkboxes = document.querySelectorAll("table input[type='checkbox']");
        for (var i = 1; i < checkboxes.length; i++) {
            checkboxes[i].checked = this.checked;
        }
    };
</script>
</body>
</html>