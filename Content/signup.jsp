<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="UI/css/bootstrap.css" rel="stylesheet">
<link href="UI/css/signin.css" rel="stylesheet">
<script type="text/javascript" src="UI/js/bootstrap.min.js"></script>
<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
<title>Book Store</title>
<script type="text/javascript">
   $(document).ready(function(){
      $('#email').change(function(){
      if($('#email').val()!="")
          {
    	  var xmlhttp;
    	  var email = $('#email').val();
    	  if (window.XMLHttpRequest)
   	        {
   	   xmlhttp=new XMLHttpRequest();
   	        }
   	     else
   	        {
   	   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
   	        }
       xmlhttp.onreadystatechange=function()
   	      {
   	      if (xmlhttp.readyState==4 && xmlhttp.status==200)
   	        {
     	        console.log("jj",xmlhttp.responseText);
   	    	   if(xmlhttp.responseText!="OK")
   	   	    	   {   
   	   	    	    $('#emailInfo').html(xmlhttp.responseText);
   	   	    	   }
   	    	   else{
   	    		   $('#emailInfo').html('');
   	   	    	   }
   	        }
   	     };
   	 xmlhttp.open("GET","valiMailWhenReg?inputEmail="+email,true);
   	 xmlhttp.send();
          }
     });
   var imgsrc = "${sessionScope.imgAd}";
   $('#ad').attr('src',imgsrc);
   $('#rePwd').change(function(){

         if($('#rePwd').val()!=$('#pwd').val())
             { 
                $('#pwdInfo').html("<label class='alert-warning'>The Password must be equal!</label>");
             }  
         else{
        	 $('#pwdInfo').html('');
             }      
	   });
   
   });
</script>
</head>
<body>
	<div class="container">
		<div class="col-md-3 col-sm-4">
		<img src="" alt="Book Store" id="ad" 
		style="margin-left: 20px; margin-right: 20px; margin-top: 20px;
		height:400px;width:400px" 
		/>
		</div>
		<div class="col-md-4 col-sm-5 col-md-offset-4">
			<form class="form-signin" action="registerAction" method="post" id="signup">
				<h2 class="form-signin-heading">
					<img
						style="margin-left: 20px; margin-right: 20px; margin-top: 20px"
						src="images/title.png" />
				</h2>
				
				<input type="text" id="name" class="form-control"
				 name="customer.alias"
					placeholder="User Name" required autofocus> 
					
			    <input
					type="email" id="email" class="form-control" placeholder="Email" 
					name="customer.email" style="margin-top: 10px;"
					required> 
					<div id="emailInfo"></div>
					<input type="password" id="pwd"
					name="customer.pwd"
					class="form-control" placeholder="Password"
					style="margin-top: 10px;" required> 
					<input type="password" id="rePwd"
					class="form-control" placeholder="Confirm Password" required>
				    <div id="pwdInfo"></div>
				<div style="padding-top: 10px">
					<button type="submit" id="signBtn"
					class="btn btn-lg btn-primary btn-block">
					Sign Up
					</button>
				</div>
			</form>
		</div>
	</div>
</body>


</html>