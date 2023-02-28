
<html>

<head>
    <title>Registration</title>
</head>

<body>


<form action="/user/register-process" method="post">
    <label for="UserType">User Type:</label>
    <select name="UserType" id="UserType">
        <option>Instructor</option>
        <option>Student</option>
    </select>
    <br>
    <label for="firstName">First Name:</label>
    <input type="text" id="firstname" name="firstname" required/> <br>
    <label for="lastname">Last Name:</label>
    <input type="text" id="lastname" name="lastname" required/> <br>
    <label for="user-name">User Name:</label>
    <input type="text" id="username" name="username" required/> <br>
    <label for="password">Password:</label>
    <input type="text" id="password" name="password" required/> <br>
    
    <button type="submit">Register</button>
    
</form>
</form><p style="color:red;">${registrationError}</p>
</body>
    
    
    </html>