<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@include会将两个页面合二为一，则合并后的页面共用一个作用域，可能有冲突--%>
<%@include file="/common/header.jsp"%>
<h1>网页主体</h1>
<%@include file="/common/footer.jsp"%>
<hr>
<%--jSP标签;对于拼接共享页面，一般使用标签，灵活性高
    jsp:include：拼接页面，本质还是三个--%>
<jsp:include page="/common/header.jsp"/>
<h1>网页主体</h1>
<jsp:include page="/common/footer.jsp"/>

</body>
</html>
