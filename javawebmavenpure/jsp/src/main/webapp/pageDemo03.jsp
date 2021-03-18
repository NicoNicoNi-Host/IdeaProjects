<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //public void setAttribute(string name, object attribute, int scope) scope:作用域
//    public abstract class PageContext extends JspContext {
//       public static final int PAGE_SCOPE = 1;
//       public static final int REQUEST_SCOPE = 2;
//       public static final int SESSION_SCOPE = 3;
//       public static final int APPLICATION_SCOPE = 4;
    pageContext.setAttribute("name1","hello1",PageContext.SESSION_SCOPE);
%>


</body>
</html>
