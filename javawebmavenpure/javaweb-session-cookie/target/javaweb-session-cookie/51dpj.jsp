<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Web控制51单片机的各个功能模块之案例测试</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script type="text/javascript">
        // 开启
        function goON() {
            var parameterId = document.getElementById("parameterId");
            parameterId.value = "on";
            document.forms[0].submit();
        }

        // 关闭
        function goOFF() {
            var parameterId = document.getElementById("parameterId");
            parameterId.value = "off";
            document.forms[0].submit();
        }
    </script>
</head>

<body>
<h2>========= Web控制51单片机的各个功能模块之案例测试 =========</h2>
说明：按下“电机启动”按钮电机开始转动，按下“电机停止”按钮电机停止转动
<br><br>
<form name="myForm" action="operator" method="post" style="margin-left: 200px;">
    <input type="hidden" name="parameter" id="parameterId"/>
    <input type="hidden" name="on" value="1" readonly="readonly"/>
    <input type="button" value="电机启动" onclick="goON();" style="font-size: 20px;"/>

    <input type="hidden" name="off" value="0" readonly="readonly"/>
    <input type="button" value="电机停止" onclick="goOFF();" style="font-size: 20px;"/>
</form>
</body>
</html>