<!DOCTYPE html>
<html>
  <head>
    <title>Nexus Login</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <link rel="stylesheet" href="/CSS/style.css">
    </head>
  <body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/user/index"><span class="text-info">Nexus</span> e-learning</a> <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler" data-bs-target="#navbarSupportedContent" data-bs-toggle="collapse" type="button"><span class="navbar-toggler-icon"></span></button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link" href="/home/pricing">Pricing</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/home/aboutus">About us</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/home/pricing">Contact</a>
					</li>

					<li class="nav-item">
						<a class="nav-link" href="/user/login">Log in</a>
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
                    <h3 class="header-title">LOG IN</h3>
                    <!--<h2>${successfulRegistration}</h2> -->

                    <form method="POST" action="/user/login-process" class="login-form" >
                        <div class="form-group"> 
                            <input type="text" name="username" class="form-control" placeholder=" UserName" required/>
                        </div>
                        <div class="form-group">
                            <input type="Password" name="password" class="form-control" placeholder="Password" required/>
                            <a href="#!" class="forgot-password">Forgot Password?</a>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-block">LOGIN</button>
                        </div>
                        <div class="form-group">
                            <div class="text-center">New Member? <a href="/user/register">Sign up Now</a></div>
                        </div>

                    </form>
                    
                    <p style="color:red;">${invalidLogin}</p>
                    <p style="color:green;">${successfulRegistration}</p>
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
                                    <img src="https://i.imgur.com/Yi5KXKM.png" alt="">
                                    <h3 class="slider-title">Nexus</h3>
                                    <p class="slider-description">The best learning platform for introducing kids and teens to the joy of coding.</p>
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