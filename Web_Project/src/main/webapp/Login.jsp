<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Thư viện ngoài -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<!-- CSS của project -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<title>Đăng nhập</title>
</head>
<body class="d-flex flex-column min-vh-100">
	<main class="form-signin flex-grow-1 text-center">
		<img class="mb-3 rounded-circle"
			src="${pageContext.request.contextPath}/image/Phát Lộc.png" alt="Logo" width="78">
			
		<div class="form-wrapper">
			<form class="text-center" action="login" method="POST">
				<h1 class="h3 mb-3 fw-semibold">Log in to PLJewelry</h1>
				
				<div class="form-floating mb-2 rounded">
					<input type="text" class="form-control" id="tenDangNhap" name="username" 
					value="${requestScope.username!=null?requestScope.username:""}" placeholder="Tên đăng nhập"> 
					<label for="tenDangNhap">Tên đăng nhập</label>
				</div>
				
				<div class="form-floating mb-2 rounded">
					<input type="password" class="form-control" id="matKhau" name="password" placeholder="Mật Khẩu"> 
					<label for="matKhau">Mật Khẩu</label>
				</div>

				<c:if test="${error != null}">
					<div class="mb-2">
						<p class="error-txt text-start my-0"> ${requestScope.error}
					</div>
				</c:if>

				<button class="w-100 btn btn-lg btn-primary mt-2" type="submit">Đăng Nhập</button>
				
				<div class="mt-3 justify-content-evenly">
					<a class="text-decoration-none" href="#">Quên mật khẩu?</a> - 
					<a class="text-decoration-none" href="Signup.jsp">Đăng ký tài khoản </a>
				</div>
			</form>
		</div>
	</main>

	<jsp:include page="/Footer.jsp"></jsp:include>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>