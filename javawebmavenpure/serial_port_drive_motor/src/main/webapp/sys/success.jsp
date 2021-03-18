<%@ page import="static com.fly.servlet.MyServer.statusStr" %>
<%@ page import="com.fly.util.Constant" %>
<%@ page import="java.io.File" %>
<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%
    //jsp脚本片段
    String path = request.getContextPath();  //获取 Application context:
    // /motor
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";//获取url
    //  http://localhost:8080/motor/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%--    规定页面中所有相对链接的基准 URL。--%>
    <base href="<%=basePath%>">

    <title>Web串口控制51单片机</title>
    <%--   禁止浏览器从本地计算机的缓存中访问页面内容。
            无法脱机浏览，再次进入曾经访问过的页面时，浏览器必须从服务端下载最新的内容，达到刷新的效果。
    --%>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <%--    用于搜索引擎优化（SEO）--%>
    <meta http-equiv="description" content="单片机">
    <meta http-equiv="description" content="串口">
    <meta http-equiv="description" content="远程电机">

    <%--电机控制按钮--%>
    <script src="static/js/motor-control.js"></script>

</head>

<body bgcolor="white">
<%--<body  bgcolor="#f5f5f5">--%>


<div class="header" style="background: white">
    <%--    header使用纯白背景，不然两张图片背景不透明，看着不合适--%>
    <%--jSP标签;对于拼接共享页面，一般使用标签，灵活性高
    jsp:include：拼接页面，本质还是三个--%>
    <jsp:include page="/common/header.jsp"/>
</div>


<div style="text-align:left ">
    <h2>========= Web串口远程控制51单片机的测试 =========</h2>
    说明：按下“电机启动”按钮电机开始转动，按下“电机停止”按钮电机停止转动
    <br><br>
</div>

<div style="text-align: left">

    <form name="myForm" action="operator" method="post" style="margin-left: 200px;">
        <input type="hidden" name="parameter" id="parameterId"/>

        <input type="hidden" name="on_1" value="A" readonly="readonly"/>
        <input type="button" value="电机正转" onclick="goON_1();" style="font-size: 20px;"/>

        <input type="hidden" name="on_2" value="B" readonly="readonly"/>
        <input type="button" value="电机反转" onclick="goON_2();" style="font-size: 20px;"/>

        <input type="hidden" name="off" value="C" readonly="readonly"/>
        <input type="button" value="电机停止" onclick="goOFF();" style="font-size: 20px;"/>

        <input type="hidden" name="status" value="S" readonly="readonly"/>
        <input type="button" value="电机状态" onclick="getStatus();" style="font-size: 20px;"/>

        串口:<select name="port">
        <option value="COM1">COM1</option>
        <option value="COM2">COM2</option>
        <%--            默认 COM3--%>
        <option value="COM3" selected>COM3</option>
        <option value="COM4">COM4</option>
        <option value="COM5">COM5</option>
        <option value="COM6">COM6</option>
        <option value="COM7">COM7</option>
    </select>
        波特率:<select name="baudrate">
        <option value="300">300</option>
        <option value="600">600</option>
        <option value="1200">1200</option>
        <option value="1800">1800</option>
        <option value="2400">2400</option>
        <option value="3600">3600</option>
        <option value="4800">4800</option>
        <option value="7200">7200</option>
        <option value="9600" selected>9600</option>
        <option value="14400">14400</option>
        <option value="19200">19200</option>
        <option value="28800">28800</option>
    </select>
    </form>
</div>

<%--输出电机运行状态--%>
<div  name="putStatus">
<%
    String s=null;
    if(statusStr!=null){
        s=statusStr;
    }else{
        if(Constant.COUNT==0){
            Constant.COUNT=1; //刚登录时，s一定为null，此时不能输出急停状态
            s=""; //写个空字符，不然页面显示null
        }else{ //登录之后出现s为null
            s="Error:电机已急停,请点击物理复位按钮";
        }
    }

%>
    <h3><font style="color: darkcyan" size="5"> <%=s%> </font> </h3>

</div>


<br>
<form action="${pageContext.request.contextPath}/logout" method="get">
    注销：<input type="submit" value="确定">
</form>

<%--已经规定了页面中所有相对链接的基准，不需要再获取contextPath--%>
<%--<p><a href="logout">注销</a></p> --%>

<br><br><br><br>
<%--页脚--%>
<div class="footer" style="background: white">
    <jsp:include page="/common/footer.jsp"/>

</div>
</body>

<%--js特效--%>
<script src="static/js/cet4.js"></script>

<!-- 雪花特效 -->
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.3/jquery.js"></script>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="static/js/snow.js"></script>

</html>



