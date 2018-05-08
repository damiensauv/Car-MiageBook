<%@ page import="Domain.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">


    <title>MiageBook - Home </title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<%
    User user = (User) request.getAttribute("user");
%>

<div class="container">

    <%@ include file="navbar.jsp" %>

    <h3><%out.print(user.getPseudo());  %></h3>
    <h3><%out.print(user.getNom());  %></h3>
    <h3><%out.print(user.getPrenom());  %></h3>


    <h4>Liste amis : </h4>
    <ul>
        <%
            if (user.getFriends() != null)
                for (User u : user.getFriends()) {

        %>

        <li>
            <% out.print(u.getPseudo()); %>

            <% if (user.isFriend(u.getId())) { %>

            <button type="submit" value="submit" id="<%out.print(u.getId());%>">Unfollow</button>

            <% } else { %>

            <button type="submit" value="submit" id="<%out.print(u.getId());%>">follow</button>

            <% }%>

        </li>
        <%

                }
        %>
    </ul>


</div> <!-- /container -->

</body>
<script>




</script>


</html>
