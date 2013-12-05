<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="UI/css/bootstrap.css" rel="stylesheet">
<link href="UI/css/signin.css" rel="stylesheet">
<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
<title>Admin Login</title>
</head>
<body>
   <div class="container"> 
        <form class="form-signin" method="post" action="adminLogin">
        <h2 class="form-signin-heading" >
        <img style="margin-left:20px; margin-right:20px;margin-top:20px" src="images/title.png"/></h2>
         <input type="email" class="form-control"
         name="email" id="email"
          placeholder="Email" required>
        <input type="password" class="form-control"
        name="pwd" id="pwd"
         placeholder="Password" style="margin-top:10px;" required>
        <button class="btn btn-lg btn-primary btn-block" id="loginBtn">Sign in</button>
        </form>
 </div>
</body>