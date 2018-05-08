<%@ page import="Domain.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">


    <title>MiageBook - Home </title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>

<body>
<%
    User user = (User) request.getAttribute("user");
    List<User> friends = (List<User>) request.getAttribute("friends");
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
                for (User u : friends) {

        %>

        <li>
            <% out.print(u.getPseudo()); %>

            <% if (user.isFriend(u.getId())) { %>

            <button type="submit" id="<% out.print(u.getId()); %>" onclick="unfollow(<% out.print(u.getId()); %>)">
                Unfollow
            </button>

            <% } else { %>

            <button type="submit" id="<% out.print(u.getId()); %>" onclick="follow(<% out.print(u.getId()); %>)">
                follow
            </button>

            <% }%>

        </li>
        <%

                }
        %>
    </ul>


</div> <!-- /container -->

</body>
<script>

    function follow(id) {

        $.ajax({
            type: 'POST',
            url: '/rest/user/follow',
            datatype: 'text',
            data: id.toString(),
            success: function (code) {
                console.log(code)
                if (code == 0) {
                    $("#" + id).attr("onclick", "unfollow(" + id + ")");
                    $("#" + id).text("Unfollow");
                }
            }
        });

    }

    function unfollow(id) {

        $.ajax({
            type: 'POST',
            url: '/rest/user/unfollow',
            datatype: 'text',
            data: id.toString(),
            success: function (code) {
                if (code == 0) {
                    $("#" + id).attr("onclick", "follow(" + id + ")");
                    $("#" + id).text("follow");
                }
            }
        });
    }


</script>


</html>
