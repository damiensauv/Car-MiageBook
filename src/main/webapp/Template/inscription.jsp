<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">


    <title>MiageBook</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form class="form-signin" action="/inscription" method="POST">
        <h2 class="form-signin-heading">Please sign up</h2>

        <label for="email" class="sr-only">Email address</label>
        <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>

        <label class="sr-only">pseudo</label>
        <input type="text" id="pseudo" name="pseudo" class="form-control" placeholder="Pseudo" required>

        <label class="sr-only">Password</label>
        <input type="text" id="password" name="password" class="form-control" placeholder="Password" required>

        <label class="sr-only">Name</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="name" required>

        <label class="sr-only">Surname</label>
        <input type="text" id="surname" name="surname" class="form-control" placeholder="Surname" >


        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
    </form>

</div> <!-- /container -->

</body>
</html>
