<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">


<html>

<head>
    <title>Registration</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Code Nexus</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link"  th:href="@{/}" href="#">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Gallery</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Post</a>
            </li>
          </ul>
        </div>
      </nav>

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