<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Code Wall</title>
    <link type="text/css" rel="stylesheet" href="./css/style.css">
</head>

<body>
    <nav>
        <img src="./assets/logo.svg" alt="logo">
        <ul>
            <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li> <a href="${pageContext.request.contextPath}/signup">Signup</a></li>
        </ul>
    </nav>
    <div class="welcome-back">Welcome Back</div>
    <div class="sub-text">Share something new that you have learnt today with the code wall community.</div>

    <div class="login-form">
        <div class="title">Login</div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="email" class="label">Email</label>
            <input type="text" name="email" id="email">
            <label for="password" class="label">Password</label>
            <input type="password" name="password" id="password">

            <button class="button" type="submit">Login</button>
            <a class="forgot-password" href="">Forgot Password</a>
        </form>
    </div>
</body>

</html>