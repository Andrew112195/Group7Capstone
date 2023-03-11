<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
    <title>Instructor's Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%--    <script>--%>
<%--        function addUserCourse(userId) {--%>
<%--            const userCourse = {--%>
<%--                userId: userId,--%>
<%--                courseId: 1,--%>
<%--                progress: 0,--%>
<%--            }--%>
<%--            fetch(`/user/addcourse/${userId}/1`, {--%>
<%--                method: 'POST',--%>
<%--                body: JSON.stringify(userCourse),--%>

<%--            })--%>
<%--                .then(response => {--%>
<%--                    if (!response.ok) {--%>
<%--                        throw new Error('Error adding course');--%>
<%--                    }--%>
<%--                    alert('Course added successfully');--%>
<%--                })--%>
<%--                .catch(error => {--%>
<%--                    console.error(error);--%>
<%--                    alert('Error adding course');--%>
<%--                });--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>


<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="#">Instructors Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Students</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">T</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid mt-3">
    <h2>Work Space</h2>
    <form>
        <table class="table">
            <thead>
            <tr>
                <th>Student Name</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.firstname}"</td>
                    <td>
                        <button type="submit" class="btn btn-primary" >
                            AddStudentToCourse
                        </button>
                        <c:set var="studentId" value="${student.id}"/>
                        <c:set var="studentName" value="${student.firstname}"/>
                        <input type="hidden" name="courseId" value="${studentId}"/>
                        <input type="hidden" name="courseName" value="${studentName}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

    <form action="add_student.jsp" method="POST">
        <div class="form-group">
            <label for="student-id">Student ID</label>
            <input type="text" class="form-control" id="student-id" name="studentId">
        </div>
        <div class="form-group">
            <label for="student-name">Name</label>
            <input type="text" class="form-control" id="student-name" name="studentName">
        </div>
    </form>
</div>