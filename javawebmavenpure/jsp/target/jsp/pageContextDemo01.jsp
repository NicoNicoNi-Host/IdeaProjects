<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    pageContext.setAttribute("name1", "良辰1号"); //保存的数据只在一个页面中有效
    request.setAttribute("name2", "良辰2号"); //保存的数据只在一次请求中有效，请求转发会携带这个数据
    session.setAttribute("name3", "良辰3号"); //保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4", "良辰4号"); //保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>

<%--脚本片段中的代码,会被原封不动生成到.JSP.java
要求：这里面的代吗:必须保证Java语法的正确性
比如注释需要用java的
 --%>
<%
    //从pageContext 取出,通过寻找的方式
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5"); //不存在

//    pageContext.forward("/pageDemo02.jsp"); //转发后"良辰2号"就可以取出
    // 否则按照作用域，"pageDemo02.jsp"只能取出3、4号
%>

<%--使用EL表达式输出 ${}--%>
<h1>取出的值为:</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3> <%--不显示--%>
<%=name5%><%--显示：null；不美观--%>
<%--故取值都用EL表达式--%>


</body>
</html>
