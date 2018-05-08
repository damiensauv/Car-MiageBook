<%@ page import="Domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <title>Title</title>
</head>
<body>

<%
    List<User> users = (List<User>) request.getAttribute("users");
    User user = (User) request.getAttribute("user");
%>


<div class="container">

    <%@ include file="navbar.jsp" %>

    <ul>
        <%
            for (User u : users) {

                if (!u.getId().equals(user.getId())) {
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

            }
        %>
    </ul>

</div>

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
