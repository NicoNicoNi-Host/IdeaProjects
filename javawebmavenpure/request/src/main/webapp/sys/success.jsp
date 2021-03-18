<%@ page import="static com.fly.util.Constant.USER_SESSION" %><%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 2021-02-10
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>Success</h1>

<%--<%
    //如果有人要直接输入url访问success.jsp，跳转回登录页面
    //不在jsp做，应该使用filter
    Object userSession = request.getSession().getAttribute(USER_SESSION);
    if (userSession==null) {
//        pageContext.forward("Login.jsp");
        response.sendRedirect("Login.jsp"); //加上斜杠会跳转到 http://localhost:8080/Login.jsp
    }
%>--%>

<p><a href="${pageContext.request.contextPath}/logout">注销</a></p>
</body>
</html>
