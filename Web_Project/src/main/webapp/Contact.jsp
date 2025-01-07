<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liên hệ</title>
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


	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="home">Trang chủ</a></li>
			<li class="breadcrumb-item active" aria-current="page">Liên Hệ</li>
		</ol>
	</nav>

	<div class="container mt-5 mb-3">



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
		<h2 class="text-center mb-4">Liên hệ với chúng tôi</h2>
		<p>Để biết thêm thông tin về sản phẩm và dịch vụ của chúng tôi,
			xin vui lòng gửi email cho chúng tôi. Nhân viên của chúng tôi luôn có
			mặt để giúp đỡ bạn. Đừng ngần ngại!</p>
		<p>
			<strong>Số điện thoại:</strong> 0123 456 789<br> <strong>Địa
				chỉ:</strong> 123 Đường ABC, Phường XYZ, Quận 1, Thành phố Hồ Chí Minh<br>
			<strong>Thời gian làm việc:</strong> Thứ Hai - Thứ Sáu, 8:00 - 17:00
		</p>
		<form action="submitcontact" method="post">
			<div class="mb-3">
				<label for="name" class="form-label">Họ và Tên</label> <input
					type="text" class="form-control" id="name" name="name"
					placeholder="Nhập họ và tên" required>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="Nhập email" required>
			</div>
			<div class="mb-3">
				<label for="subject" class="form-label">Tiêu đề</label> <input
					type="text" class="form-control" id="subject" name="subject"
					placeholder="Nhập tiêu đề" required>
			</div>
			<div class="mb-3">
				<label for="message" class="form-label">Nội dung</label>
				<textarea class="form-control" id="message" name="message" rows="5"
					placeholder="Nhập nội dung liên hệ" required></textarea>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Gửi liên hệ</button>
			</div>
		</form>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
