<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HELLO PAGE</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body style="background-color: #eee;">
	<nav class="navbar navbar-dark navbar-expand-lg bg-dark mb-3">
		<div class="container">
			<a href="#" class="navbar-brand">WELCOME SIMPLE REGISTRATION PAGE</a>
		</div>
	</nav>
	<div class="container ">
	<div class="text-center text-danger">${ sameEmail}</div>
		<div class="text-center text-success">${ nowlogin}</div>
		<form:form modelAttribute="register" action="/submitRegister"
			method="post">
			<div class="form-group ">
				<form:label path="customerName" for="name">Name</form:label>
				<form:input path="customerName" name="customerName" id="customerName" class="form-control"
					placeholder="Enter Your Name" />
				<form:errors path="customerName"/>
			</div>
			<div class="form-group">
				<form:label path="email" for="email">E-mail</form:label>
				<form:input path="email" name="email" id="email"
					class="form-control" placeholder="Enter Your Email-ID" />
				<form:errors path="email"/>
			</div>
			<div class="form-group">
				<form:label path="contact" for="contact">Contact</form:label>
				<form:input path="contact" name="contact" id="contact"
					class="form-control" placeholder="Enter Your Contact" />
				<form:errors path="contact"/>
			</div>
			<div class="form-group">
				<form:label path="gender" for="gender">Gender</form:label><br>
				<%-- <form:input path="gender" name="gender" id="gender"
					class="form-control" placeholder="Enter Your Gender" /> --%>
					<label>Male</label>
					<input type="radio" name="gender" value="Male">
					<label>Female</label>
					<input type="radio" name="gender" value="Female"><br>
				<form:errors path="gender"/>
			</div>
			<div class="form-row">
				<div class="col">
					<button type="submit" class="btn btn-success btn-block">Register</button>
				</div>
				<div class="col">
					<button type="reset" class="btn btn-warning btn-block">Reset</button>
				</div>
			</div>
		</form:form>
	</div>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark fixed-bottom">
			<div class="container">
				<a href="#" class="navbar-brand">COPYRIGHT SIMPLE REGISTRATION
					&copy; 2020</a>
			</div>
		</nav>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script>
		$('#myAlert').on('closed.bs.alert', function() {
			console.log('Alert closed...');
		})
	</script>
</body>
</html>