<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- TO DO: Must set the link to reference appropriate endpoints -->
    <div class="link_bar">
        <a href="#">About us</a>
        <a href="#">Pricing</a>
        <a href="#">Help</a>
    </div>

	<div class="center_container">
		<!-- TO DO: Gotta add .img bellow when design comes back from art team -->
        <div>
            <h2>Welcome to Coding Nexus!</h2>
        </div>
        <div class="login_card">
            <!-- TO DO: Action needs to be updated to POST form data to DB -->
            <form:form action="loginprocess.jsp" method="post" modelAttribute="login">
            
                <div class="form-group">
                    <form:label path="email">email: </form:label>
                    <form:errors path="email" class="error"/>
                    <form:input path="email" type="email" class="form-control"/>
                    <input type="submit" value="Login" class="submit_button"/>
                </div>
                
                <!-- TO DO: Must set the link to reference appropriate endpoints -->
                <a href="#">Don't already have an account? Sign up now!</a>
            
            </form:form>
        </div>
		
	</div>

</body>
</html>