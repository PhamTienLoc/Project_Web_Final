<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thay Đổi Mật Khẩu</title>
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
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h3 class="text-center">Thay Đổi Mật Khẩu</h3>
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
				<form action="changepass" method="post">
					<div class="form-group">
						<label for="currentPassword">Mật khẩu hiện tại</label> <input
							type="password" class="form-control" id="currentPassword"
							name="currPass" placeholder="Nhập mật khẩu hiện tại" required>
					</div>

					<div class="form-group">
						<label for="newPassword">Mật khẩu mới</label> <input
							type="password" class="form-control" id="newPassword"
							name="newPass" placeholder="Nhập mật khẩu mới" required>
					</div>

					<div class="form-group">
						<label for="confirmNewPassword">Nhập lại mật khẩu mới</label> <input
							type="password" class="form-control" id="confirmNewPassword"
							name="renewPass" placeholder="Nhập lại mật khẩu mới" required>
					</div>

					<button type="submit" class="btn btn-primary btn-block">Lưu
						thay đổi</button>
				</form>
			</div>
		</div>
	</div>

<jsp:include page="Footer.jsp"></jsp:include>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>