<%--
  Created by IntelliJ IDEA.
  User: yjy
  Date: 16-10-28
  Time: 下午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test user controller</title>
</head>
<body>
<%
    response.sendRedirect(request.getContextPath()+"/v1/user/2/note");
%>
</body>
</html>
