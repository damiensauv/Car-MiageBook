<%@ page import="Domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

    <title>Title</title>
</head>
<body>

<%
    List<User> users = (List<User>) request.getAttribute("users");
%>


<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="#">Home</a>
                <a class="nav-item nav-link" href="#">Profile</a>
                <a class="nav-item nav-link" href="#">All Users</a>
                <a class="nav-item nav-link" href="#">Logout</a>
            </div>
        </div>
    </nav>

    <ul>
        <%
            for (User u : users) { %>

            <li><% out.print(u.getPseudo()); %></li>

            <%
            }
        %>
    </ul>

</div>

</body>
</html>
