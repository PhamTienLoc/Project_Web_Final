<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap Form</title>
<!-- Bootstrap CSS -->
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
		<h2 class="text-center mb-4">Information Form</h2>
		<form class="p-4 border rounded bg-light" action="formcheckout"
			method="post">
			<!-- Full Name -->
			<div class="mb-3">
				<label for="fullname" class="form-label">Full Name</label> <input
					type="text" class="form-control" id="fullname" name="fullname"
					value="${sessionScope.user.fullName}"
					placeholder="Enter your full name" required="required">
			</div>
			<!-- Email -->
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					value="${sessionScope.user.email}" placeholder="Enter your email"
					required="required">
			</div>
			<!-- Phone Number -->
			<div class="mb-3">
				<label for="phoneNumber" class="form-label">Phone Number</label> <input
					type="tel" class="form-control" id="phoneNumber" name="phonenumber"
					value="${sessionScope.user.phoneNumber}"
					placeholder="Enter your phone number" required="required">
			</div>
			<!-- Address -->
			<div class="mb-3">
				<label for="address" class="form-label">Address</label> <input
					type="text" class="form-control" id="address" name="address"
					value="${sessionScope.user.address}"
					placeholder="Enter your address" required="required">
			</div>
			<!-- Note -->
			<div class="mb-3">
				<label for="note" class="form-label">Note</label>
				<textarea class="form-control" id="note" rows="3" name="note"
					 placeholder="Enter any notes"></textarea>
			</div>
			<!-- Submit Button -->
			<button type="submit" class="btn btn-primary w-100">Submit</button>
		</form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<!-- Bootstrap JS Bundle -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>