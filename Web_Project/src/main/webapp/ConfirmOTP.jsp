<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ConfirmOTP</title>
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
<style>
.countdown {
	font-size: 24px;
	font-weight: bold;
	color: #ff0000;
	text-align: center;
	margin-top: 20px;
}

.form-container {
	max-width: 400px;
	margin: 50px auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.resend-link {
	color: #007bff;
	text-decoration: none;
}

.resend-link:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>
	<div class="form-container">
	
		<h3 class="text-center">Xác nhận OTP</h3>
		<div class="d-flex justify-content-between mb-3">
					<div class="alert alert-danger flex-fill me-2" id="errorMessage"
						style="display: ${fail != null && fail != '' ? 'block' : 'none'};">
						<p>${fail}</p>
					</div>
					<div class="alert alert-success flex-fill ms-2" id="successMessage"
						style="display: ${success != null && success != '' ? 'block' : 'none'};">
						<p>${success}</p>
					</div>
				</div>
		<div class="countdown" id="countdown">Thời gian còn lại: 5:00</div>
		<form action="confirmotp" method="post">
			<div class="mb-3">
				<label for="otp" class="form-label">Nhập mã OTP:</label> <input
					type="text" class="form-control" id="otp" name="otp" required>
			</div>
			<button type="submit" class="btn btn-primary w-100">Xác nhận</button>
		</form>
		<div id="resend-link" class="text-center mt-3" style="display: none;">
			<a href="resendotp" class="resend-link">Nhấn vào đây để gửi lại
				mã OTP</a>
		</div>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/confirmOtp.js"></script>

</body>
</html>