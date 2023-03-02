<!DOCTYPE html>
<html>
  <head>
    <title>Nexus</title>
    <link rel="stylesheet" href="/CSS/style_index.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
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
    <br><br><br><br><br>
    <h3>${welcomeMessage}</h3>

	<!-- portfolio strats -->
	<section class="portfolio section-padding" id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-header text-center pb-5">
						<h2>Courses</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6 col-md-6 col-lg-4">
					<div class="card text-light text-center bg-white pb-2">
						<div class="card-body text-dark">
							<div class="img-area mb-4"><img alt="" class="img-fluid" src="/img/html.jpg"></div>
							<h5 class="card-title">HTML Course</h5>
							<p class="lead">Instructor: John James</p><button class="btn bg-info  text-white">Enter</button>
						</div>
					</div>
				</div>
				<div class="col-6 col-md-6 col-lg-4">
					<div class="card text-light text-center bg-white pb-2">
						<div class="card-body text-dark">
							<div class="img-area mb-4"><img alt="" class="img-fluid" src="/img/python.jpg"></div>
							<h5 class="card-title">Python Course</h5>
							<p class="lead"> Instructor: Mike Saenz.</p><button class="btn bg-info  text-white">Enter</button>
						</div>
					</div>
				</div>
                <div class="col-6 col-md-6 col-lg-4">
					<div class="card text-light text-center bg-white pb-2">
						<div class="card-body text-dark">
							<div class="img-area mb-4"><img alt="" class="img-fluid" src="/img/java.jpg"></div>
							<h5 class="card-title">Java Course</h5>
							<p class="lead"> Instructor: Matt Leon.</p><button class="btn bg-info  text-white">Enter</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section><!-- portfolio ends -->
	<!-- footer starts -->
	<footer class="bg-dark p-2 text-center">
		<div class="container">
			<p class="text-white">All Right Reserved By Code Nexus</p>
		</div>
	</footer>
	<!-- footer ends -->
	
	<!-- All Js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
</body>
</html>