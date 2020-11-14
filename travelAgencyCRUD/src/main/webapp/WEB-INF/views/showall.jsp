<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>Show Customer</title>
</head>
<body style="background-color: #eee;">
	<!-- <div class="container"> -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
		<div class="container">
			<a href="/" class="navbar-brand navbar-brand-sm">WELCOME SIMPLE
				REGISTRATION PAGE</a>

		</div>
	</nav>
	<!-- </div> -->
	<div class="container ">
		<div class="text-center text-success">${ updatedonemsg}</div>
		<div class="text-center text-warning">${ updatenotdonemsg}</div>
		<div class="text-center text-success">${ deletedonemsg}</div>
		<div class="text-center text-warning">${ deletenotdonemsg}</div>
		<div class="text-center text-danger">${ checkpass}</div>
		<div class="table-responsive">
			<table
				class="table table-sm text-center table-bordered mt-3 table-light table-hover">
				<thead class="thead-dark">
					<tr>
						<th>NAME</th>
						<th>EMAIL</th>
						<th>CONTACT</th>
						<th>GENDER</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					${nothing }
					<c:forEach items="${list }" var="list">
						<tr>
							<td>${list.customerName }</td>
							<td>${list.email }</td>
							<td>${list.contact }</td>
							<td>${list.gender }</td>
							<td><a
								href="update?customerName=${list.customerName }&contact=${list.contact }&gender=${list.gender }&customerId=${list.customerId }"
								class="btn btn-primary">Update</a></td>
							<td><a href="delete?customerId=${list.customerId }"
								class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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