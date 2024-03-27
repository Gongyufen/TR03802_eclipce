<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
                body {
                    margin: 0;
                }
                #bt {
                    padding: 0 20px;
                    width:1239px;
                    height:60px;
                    background-color:#00BFFF;
                    color:white;
                    font-size:20px;
                    text-align:center;
                    line-height:60px;
                }
                input{
                	margin:5px;
                	margin-left:10px;
                	margin-top:15px;
                }
                label{
                	margin-left:500px;
                	margin-top:20px;
                }
                #qd{
                	margin-left:1100px;
                	background-color:#00BFFF;
                	width:65px;
                	height:25px;
                	border:0px;
                	border-radius: 6px;
                }
                select{
                	margin-top:15px;
                	margin-left:20px;
                }
            </style>
            </head>
            <body>
            <div id="bt">
            访客申请
            </div>
            <form method="get" action="../tcxt/fkdj">
            <br/>
            <label for="c">车牌号</label><input name="cc" id="c"/><br/>
            <label for="s">手机号</label><input name="ss" id="s"/><br/>
            <label for="sq">申请时间</label><input name="sq" id="s2"/><br/>
            <label for="k">开始时间</label><input name="kk" id="k"/><br/>
            <label for="j">结束时间</label><input name="jj" id="j"/><br/>
            <label for="l">来访事由</label><select name="ll">
            <option value="" disabled selected hidden>请选择来访事由</option>
			<option value="停车">停车</option>
			<option value="休整一下">休整一下</option>
            </select><br/>
            <label for="q">企业名称</label><select name="qq">
			<option value=""disabled selected hidden>请选择车场企业</option>
			<option value="中国第一汽车集团有限公司">中国第一汽车集团有限公司</option>
        	<option value="东风汽车集团有限公司">东风汽车集团有限公司</option>
        	<option value="重庆长安汽车股份有限公司">重庆长安汽车股份有限公司</option>
        	<option value="上海汽车集团股份有限公司">上海汽车集团股份有限公司</option>
		</select>
            <br/>
            <label for="z">状态</label><input name="zz" id="z"/><br/>
            <label for="b">备注</label><input name="bb" id="b"/><br/>
            <input type="submit" value="确定" id="qd"/>
            </form>
</body>
</html>