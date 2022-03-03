<%--
  Created by IntelliJ IDEA.
  User: pengo
  Date: 2022/2/26
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pengo.web.mvc.base.*" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>Hello World - JSP</title>
</head>
<body>
    <h1>Hello, <%=user.getName()%></h1>
    <p>School name:
        <span style="color: red">
            <%=user.getSchool().getName()%>
        </span>
    </p>
    <p>School address:
        <span style="color: green">
            <%=user.getSchool().getAddress()%>
        </span>
    </p>
</body>
</html>
