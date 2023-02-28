
<html>

<head>
    <title>Login Page</title>
</head>

<body>
    <h2>${successfulRegistration}</h2>
    <form method="POST" action="/user/login-process">
        <input type="text" name="username" placeholder="User Name"  required/> <br>
        <br>
        <input type="password" name="password" placeholder="Password"  required/> <br>
        <br>
        <button>Submit</button>
    </form><p style="color:red;">${invalidLogin}</p>
    <a href="/user/register">Don't already have an account? Sign up now!</a>
</body>
</html>