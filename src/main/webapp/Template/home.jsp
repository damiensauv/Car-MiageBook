<%@ page import="Domain.Status" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">


    <title>MiageBook - Home </title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<%
    List<Status> status = (List<Status>) request.getAttribute("status");

%>

<div class="container">

    <%@ include file="navbar.jsp" %>

    <br>
    <form class="form-status" action="/homeStatus" method="POST">
        <label for="inputstatus" class="sr-only">Status : </label>

        <input name="titre" type="text" id="inputTitre" class="form-control" placeholder="Write title">
        <input name="status" type="text" id="inputstatus" class="form-control" placeholder="Write status">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Publish</button>
    </form>


    <%
        if (status != null)
            for (Status s : status) {
    %>


    <div style="border: black solid">
        <h3><% out.print(s.getOwner().getPseudo());%></h3>
        <h3><% out.print(s.getDate());%></h3>
        <h3><a href="/status?s=<%out.print(s.getId());%>"><% out.print(s.getTitle());%></a></h3>
        <div><% out.print(s.getText());%></div>
    </div>


    <%
            }
    %>


</div> <!-- /container -->

</body>
</html>
