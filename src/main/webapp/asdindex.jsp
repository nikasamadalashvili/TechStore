<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.87.0">
    <title>Signin Template · Bootstrap v5.1</title>

    <!--<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">-->


    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">

<main class="form-signin">
    <form>
        <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
        </div>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
    </form>
</main>
<textarea title="username" id="username" rows="4" cols="50">
</textarea>
<textarea id="message" rows="4" cols="50">
</textarea>
<button id="start">start</button>
<button id="send">send</button>
</body>

<label>received Text Area</label>
<textarea id="received" rows="4" cols="50">
</textarea>
<div class="form-floating">
    <input type="text" class="form-control" id="to">
</div>

<div style="height: 300px; width: 200px;" >
    <form action="/product-servlet" method="post" enctype="multipart/form-data">
        <input type="file" name="adsfsfsf">
        <input type="text" name="asdf">
        <button type="submit">submity</button>
    </form>
</div>
<script type="text/javascript">
    window.onload = () => {
        let startBut = document.getElementById('start');
        startBut.onclick = ev => {
            startBut.disabled = true;
            let username = document.getElementById('username').value
            const exampleSocket = new WebSocket("ws://localhost:8080/CustomChat?username=" + username);
            document.getElementById('send').onclick = ev => {
                let text = document.getElementById('message');
                let messageObj = {
                    from: username,
                    to: document.getElementById('to').value,
                    message: text.value,
                    sender: 'gela',
                    //sentDate: Date.now()
                };
                exampleSocket.send(JSON.stringify(messageObj));
            }

            exampleSocket.onmessage = ev => {
                let messageObj = JSON.parse(ev.data);
                document.getElementById('received').value += messageObj.message;
            }
        }
    }
</script>
</html>
