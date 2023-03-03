<!DOCTYPE html>
<html>
  <head>
    <title>Registration</title>
    <link rel="stylesheet" href="/CSS/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
      
</head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/"><span class="text-info">Nexus</span> e-learning</a> <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler" data-bs-target="#navbarSupportedContent" data-bs-toggle="collapse" type="button"><span class="navbar-toggler-icon"></span></button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link" href="/pricing">Pricing</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/aboutus">About us</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/contact">Contact</a>
					</li>

					<li class="nav-item">
						<a class="nav-link" href="/login">Log in</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
    
<section class="body">
    <div class="container">
        <div class="login-box">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <span class="logo-font"></span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <h3 class="header-title">SIGN UP</h3>
                    <form action="/register-process" method="post" class="login-form">

                       <div class="form-group">
                            <select name= "userTypeId"  id="userTypeId" class="form-select" aria-label="Default select example">
                                <option value="1">Student</option>
                                <option value="2">Instructor</option>
                            </select>
                            <br>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder=" Name" id="firstname" name="firstname" required/>
                        </div>
                         <div class="form-group">
                            <input type="text" class="form-control" placeholder=" LastName" id="lastname" name="lastname" required/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="UserName" id="username" name="username" required/>
                            
                        </div>
                        <div class="form-group">
                            <input type="Password" class="form-control" placeholder="Password" id="password" name="password" required/>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </div>
                       
                    </form></form>
                    <p style="color:red;">${registrationError}</p>
                </div>
                <div class="col-sm-6 hide-on-mobile">
                    <div id="demo" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ul class="carousel-indicators">
                            <li data-target="#demo" data-slide-to="0" class="active"></li>
                            <li data-target="#demo" data-slide-to="1"></li>
                        </ul>
                        <!-- The slideshow -->
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="slider-feature-card">
                                    <img src="https://cf.ltkcdn.net/kids/images/orig/236795-2121x1414-kid-coding.jpg" alt="">
                                   
                                    <p class="slider-description">Nexus powers the creativity of over 60 million students and serves thousands of schools and educators worldwide.</p>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="slider-feature-card">
                                    <img src="https://i.imgur.com/Yi5KXKM.png" alt="">
                                    <h3 class="slider-title">Title Here</h3>
                                    <p class="slider-description">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione, debitis?</p>
                                </div>
                            </div>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
  </body>
</html>