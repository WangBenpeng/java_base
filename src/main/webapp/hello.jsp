<%--
  Created by IntelliJ IDEA.
  User: pengo
  Date: 2022/2/26
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World-JSP</title>
</head>
<body>
<%-- this is comment --%>
<h1>Hello World!</h1>
<p>
    <% out.println("your IP address is: "); %>
    <span style="color: red">
        <%= request.getRemoteAddr()%>
    </span>
</p>

</body>
</html>
