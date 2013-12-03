<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="UI/css/bootstrap.css" rel="stylesheet">
<link href="UI/css/signin.css" rel="stylesheet">
<script type="text/javascript" src="UI/js/bootstrap.min.js"></script>
<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
<title>Sign in</title>
</head>
<body>
   <div class="container"> 
      <form class="form-signin" action="loginAction" method="post">
        <h2 class="form-signin-heading" >
        <img style="margin-left:20px; margin-right:20px;margin-top:20px" src="images/title.png"/></h2>
         <input type="email" class="form-control"
         name="customer.email"
          placeholder="Email" required>
        <input type="password" class="form-control"
        name="customer.pwd"
         placeholder="Password" style="margin-top:10px;" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
 </div>
</body>