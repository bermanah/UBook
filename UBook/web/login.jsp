<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <jsp:include page="navBar.jsp" />
        <style>
            .wrapper {    
                margin-top: 80px;
                margin-bottom: 20px;
            }

            .form-signin {
                max-width: 420px;
                padding: 30px 38px 66px;
                margin: 0 auto;
                background-color: #eee;
                border: 5px solid #8856a1;
            }

            .form-signin-heading {
              text-align:center;
              margin-bottom: 30px;
            }

            .form-control {
              position: relative;
              font-size: 16px;
              height: auto;
              padding: 10px;
            }

            input[type="text"] {
              margin-bottom: 0px;
              border-bottom-left-radius: 0;
              border-bottom-right-radius: 0;
            }

            input[type="password"] {
              margin-bottom: 20px;
              border-top-left-radius: 0;
              border-top-right-radius: 0;
            }

            .image {
                max-height: 100px;
                max-width: 100px;
            }

            .btn-custom{
                background-color: #8856a1;
                color: white;
            }

            .btn-custom:hover {
                background-color: #9c62ba; 
            }
    </style>
    </head>
    <body>
        <div class = "container">
	<div class = "wrapper">
		<form action="login" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Please Sign In</h3>
                        <div align="center">
                            <img class="image" src="images/Logo_noBook.png">
                        </div>
                          <br><br>
			  <input type="text" class="form-control" name="Username" placeholder="Username" required="" autofocus="" />
			  <input type="password" class="form-control" name="Password" placeholder="Password" required=""/>     		  
			 
			  <button class="btn btn-lg btn-block btn-custom"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form>			
	</div>
        </div>
    </body>
</html>


