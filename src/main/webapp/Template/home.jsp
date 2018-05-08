<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">


    <title>MiageBook - Home </title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <%@ include file="navbar.jsp" %>

<br>
    <form class="form-status" action="/homeStatus" method="POST">
        <label for="inputstatus" class="sr-only">Status : </label>

        <input name="titre" type="text" id="inputTitre" class="form-control" placeholder="Write title">
        <input name="status" type="text" id="inputstatus" class="form-control" placeholder="Write status">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Publish</button>
    </form>


</div> <!-- /container -->

</body>
</html>
