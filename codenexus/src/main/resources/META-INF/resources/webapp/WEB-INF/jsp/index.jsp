<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- "form import crashing page, without it cannot bring up the inputs in for the form" -->
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
    <div class="link_bar">
        <a href="/aboutUs">About us</a>
        <a href="/pricing">Pricing</a>
        <a href="/help">Help</a>
    </div>

	<div class="center_container">
        <div>
            <h2>Welcome to Coding Nexus!!!</h2>
        </div>
        <div class="login_card">
            <form:form action="loginprocess.jsp" method="post" modelAttribute="login">
            
                <div class="form-group">
                     <form:label path="email">Email: </form:label>
                    <form:errors path="email" class="error"/>
                    <form:input path="email" type="email" class=""/>
                    <form:label path="password">Password: </form:label>
                    <form:errors path="password" class="error"/>
                    <form:input path="password" type="password" class=""/>
                    <input type="submit" value="Login" class="submit_button"/>
                </div>
                
                <a href="/registerStudent">Don't already have an account? Sign up now!</a>
            
            </form:form>
        </div>
		
	</div>

</body>
</html>