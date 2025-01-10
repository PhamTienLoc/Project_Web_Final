<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
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
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<!-- CSS của project -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">
<title>Quên mật khẩu</title>
</head>
<body class="d-flex flex-column min-vh-100">
	<main class="form-forgotPass">
		<div class="form-wrapper">
			<h3 class="fs-5 fw-bold py-3 border-bottom">Nhập mã bảo mật</h3>
			<p class="fs-6 m-0">Vui lòng kiểm tra mã trong email của bạn. Mã này gồm 6 số.</p>
			<form action="${pageContext.request.contextPath}/confirmRecoverEmail" method="POST">
				<div class="mb-3 py-3 border-bottom">
					<input type="text" class="form-control" id="email"
						placeholder="Nhập mã" name="forgotPassOTP" required>
				</div>
				
				<c:if test="${recoverEmail != null}">
					<div class="mb-2">
						<p class="text-start my-0">Chúng tôi đã gửi mã đến <strong>${sessionScope.recoverEmail}</strong>
					</div>
				</c:if>
				
				<c:if test="${error != null}">
					<div class="mb-2">
						<p class="error-txt text-start my-0"> ${requestScope.error}
					</div>
				</c:if>
				
				<div class="text-end">
					<a href="${pageContext.request.contextPath}/Login.jsp"
						class="btn btn-secondary text-decoration-none">Hủy</a>
					<button type="submit" class="btn btn-primary">Tiếp tục</button>
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