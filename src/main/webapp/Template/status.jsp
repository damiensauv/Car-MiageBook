<%@ page import="Domain.Status" %><%--
  Created by IntelliJ IDEA.
  User: dam
  Date: 08/05/18
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <%@ include file="navbar.jsp" %>

    <%
        Status s = (Status) request.getAttribute("status");
    %>

    <div style="border: black solid">
        <h3><% out.print(s.getOwner().getPseudo());%></h3>
        <h3><% out.print(s.getDate());%></h3>
        <h3><% out.print(s.getTitle());%></h3>
        <div><% out.print(s.getText());%></div>
    </div>

</div>

</body>
</html>
