<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>监听</title>
</head>

<body>

<title>监听器</title>

<h1>当前有 <span style="color: aqua">
    <%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span> 人在线</h1>
</body>

</html>
