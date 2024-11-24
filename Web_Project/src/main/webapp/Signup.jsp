<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
	
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="container mt-5">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3 class="mb-0">Sign Up</h3>
			</div>

			<div class="card-body">

				<div class="d-flex justify-content-between mb-3">
					<div class="alert alert-danger flex-fill me-2" id="errorMessage"
						style="display: ${fail != null ? 'block' : 'none'};">
						<p>${fail}</p>
					</div>
					<div class="alert alert-success flex-fill ms-2" id="successMessage"
						style="display: ${success != null ? 'block' : 'none'};">
						<p>${success}</p>
					</div>
				</div>
				<form action="signup" method="post">
					<div class="mb-3">
						<label for="username" class="form-label">Username</label> <input
							type="text" class="form-control" id="username" name="username"
							value="${userName}" placeholder="Enter your username" required>
					</div>

					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							placeholder="Enter your password" name="password" required>
					</div>
					<div class="mb-3">
						<label for="repassword" class="form-label">Re-enter
							password</label> <input type="password" class="form-control"
							id="repassword" placeholder="Enter your password"
							name="repassword" required>
					</div>



					<div class="mb-3">
						<label for="fullName" class="form-label">Full Name</label> <input
							type="text" class="form-control" id="fullName" name="fullName"
							value="${fullName}" placeholder="Enter your full name" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Gender</label>
						<div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"
									id="male" value="male" ${gender1 eq 'male'?'checked':''}>
								<label class="form-check-label" for="male">Male</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"
									id="female" value="female" ${gender1 eq 'female'?'checked':''}>
								<label class="form-check-label" for="female">Female</label>
							</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="birthday" class="form-label">Birthday</label> <input
							type="date" class="form-control" id="birthday" name="birthday"
							required value="${date}">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="text" class="form-control" id="email"
							placeholder="Enter your email" name="email" required
							value="${email}">
					</div>
					<div class="mb-3">
						<label for="phoneNumber" class="form-label">Phone Number</label> <input
							type="tel" class="form-control" id="phoneNumber"
							placeholder="Enter your phone number" name="phoneNumber" required
							value="${phoneNumber}">
					</div>
					<div class="mb-3">
						<label for="address" class="form-label">Address</label> <input
							type="text" class="form-control" id="address"
							placeholder="Enter your address" name="address"
							value="${address}">
					</div>
					<button type="submit" class="btn btn-primary">Sign Up</button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>