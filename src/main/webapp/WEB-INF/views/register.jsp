<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>register</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background-color: #17a2b8;
	height: 100vh;
}

#register .container #register-row #register-column #register-box {
    margin-top: 5%;
	margin-left: 50%;
	max-width: 100%;
	height: 100%;
	border: 1px solid #9C9C9C;
	background-color: #EAEAEA;
}

a .login{
    margin-left: 20%;
}

</style>
</head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<body>
	<div id="register">

		<div class="container">
			<div id="register-row"
				class="row justify-content-center align-items-center">
				<div id="register-column" class="col-md-6">
					<div id="register-box" class="col-md-12">
						<form:form id="register-form" class="form" action="register" method="post">
							<h3 class="text-center text-info">Đăng Kí Tài Khoản</h3>
                            <div class="form-group">
								<label for="name" class="text-info">Name:</label><br>
								<input type="text" name = "name" id="username" class="form-control">
							</div>
                            <div class="form-group">
								<label for="Email" class="text-info">Email:</label><br>
								<input type="text" name = "email" id="username" class="form-control">
							</div>
                            
                            <div class="form-group">
								<label for="phone" class="text-info">Phone:</label><br>
								<input type="text" name = "phone" id="username" class="form-control">
							</div>

                            <div class="form-group">
								<label for="address" class="text-info">Address:</label><br>
								<input type="text" name = "address" id="username" class="form-control">
							</div>
                        
                            <div class="form-group">
								<label for="username" class="text-info">Username:</label><br>
								<input type="text" name = "username" id="username" class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name = "password" id="password" class="form-control">
							</div>
							<div class="form-group">
								
                                <br> 
                                <input type="submit"
									name="submit" class="btn btn-info btn-md" value="Submit">
                                
                                <a href="/login" style="margin-left: 300px; font-size:18; text-decoration:underline;" >Login here</a>
							</div>
                            
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>