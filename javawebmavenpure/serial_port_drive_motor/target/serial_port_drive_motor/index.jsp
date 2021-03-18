<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录远程电机控制系统</title>
</head>

<body>
<%--header--%>
<jsp:include page="/common/header.jsp"/>




    <h1>登录</h1>
    西华大学毕业设计
    <br>
    学号：3320170193236
    <%--${pageContext.request.contextPath}代表当前的项目--%>
    <%--这里表单表示的意思: 以post方式提交表单,提交到我们的Login请求--%>
<div style="text-align:center " class="container">

    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        用户名：<input type="text" name="username"> <br>
        密码： <input type="password" name="password"> <br>
        <br>
        <input type="submit" value="登录">
    </form>

</div>

</body>

<%--js特效--%>
<script src="static/js/line.js"></script>
<%--<canvas id="c_n7" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;" width="1521"--%>
<%--        height="754"></canvas>--%>

<script src="static/js/activate-power-mode.js"></script>
<%--<canvas width="1521" height="754"--%>
<%--        style="position: fixed; top: 0px; left: 0px; pointer-events: none; z-index: 999999;"></canvas>--%>

<script>
    POWERMODE.colorful = true; // 控制开启/开启礼花特效
    POWERMODE.shake = false; // 控制开启/关闭屏幕震动特效
    document.body.addEventListener('input', POWERMODE);
</script>

</html>

<%--
tree -N /Users/andrew/IdeaProjects/javawebmavenpure/serial_port_drive_motor/src/main
/Users/andrew/IdeaProjects/javawebmavenpure/serial_port_drive_motor/src/main
main
├── java
│   └── com
│       └── fly
│           ├── filter
│           │   ├── CharacterEncodingFilter.java
│           │   ├── LoginServlet.java
│           │   ├── LogoutServlet.java
│           │   └── SysFilter.java
│           ├── listener
│           │   └── OnlineCountListener.java
│           ├── pojo
│           │   ├── HashUtil.java
│           │   └── MD5Util.java
│           ├── servlet
│           │   ├── MyServer.java
│           │   └── Tools.java
│           ├── useless
│           │   ├── SerialTool.java
│           │   ├── SerialUtil.java
│           │   └── SerialVo.java
│           └── util
│               └── Constant.java
├── resource
└── webapp
    ├── WEB-INF
    │   └── web.xml
    ├── common
    │   ├── footer.jsp
    │   └── header.jsp
    ├── index.jsp
    ├── resource
    │   ├── i-xhu-01.png
    │   └── i-xhu-02.png
    ├── static
    │   ├── css
    │   ├── html
    │   └── js
    │       ├── activate-power-mode.js
    │       ├── cet4.js
    │       ├── line.js
    │       ├── motor-control.js
    │       └── snow.js
    └── sys
        └── success.jsp
--%>