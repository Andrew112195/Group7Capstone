<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"> -->
    <!-- <link rel="stylesheet" href="/CSS/style.css"> -->
    <!-- <script src="/webjars/jquery/jquery.min.js"></script> -->
    <!-- <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
</head>
<body>
    <div class="link_bar">
        <p>About us</p>
        <p>Pricing</P>
        <p>Help</P>
    </div>

	<div class="center_container">
		<!-- Gotta add .img bellow when design comes back from art team -->
        <div>
            <h2>Welcome to Coding Nexus!</h2>
        </div>
		
        <div class="login_card">
            <form:form action="" method="post" modelAttribute="login">
            
                <div class="form-group">
                    <form:label path="email">email: </form:label>
                    <form:errors path="email" class="error"/>
                    <form:input path="email" type="email" class="form-control"/>
                </div>
                
                <input type="submit" value="Login" class="submit_button"/>
            
            </form:form>
        </div>
		
	</div>

</body>
</html>