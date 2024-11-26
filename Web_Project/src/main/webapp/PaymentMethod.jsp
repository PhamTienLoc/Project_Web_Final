<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chọn Phương Thức Thanh Toán</title>
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
.payment-method {
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 15px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-bottom: 15px;
	background-color: #f9f9f9;
	cursor: pointer;
	transition: background-color 0.3s;
}

.payment-method:hover {
	background-color: #e9ecef;
}

.payment-method img {
	max-width: 60px;
	max-height: 60px;
}

.payment-method-title {
	font-size: 16px;
	font-weight: 500;
}
</style>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<div class="container mt-5">
		<h2 class="text-center mb-4">Chọn phương thức thanh toán</h2>

		<c:url var="checklast1" value="/check">
			<c:param name="method" value="1" />
		</c:url>
		<!-- Phương thức 1 -->
		<a href="${checklast1}" class="text-decoration-none">
			<div class="payment-method">
				<div class="payment-method-info">
					<p class="payment-method-title">Ứng dụng thanh toán hỗ trợ
						VNPayQR</p>
				</div>
				<img src="https://via.placeholder.com/60" alt="VNPayQR">
			</div>
		</a>

		<c:url var="checklast2" value="/check">
			<c:param name="method" value="2" />
		</c:url>
		<!-- Phương thức 2 -->
		<a href="${checklast2}" class="text-decoration-none">
			<div class="payment-method">
				<div class="payment-method-info">
					<p class="payment-method-title">Thẻ nội địa và tài khoản ngân
						hàng</p>
				</div>
				<img src="https://via.placeholder.com/60" alt="Thẻ nội địa">
			</div>
		</a>

		<c:url var="checklast3" value="/check">
			<c:param name="method" value="3" />
		</c:url>
		<!-- Phương thức 3 -->
		<a href="${checklast3}" class="text-decoration-none">
			<div class="payment-method">
				<div class="payment-method-info">
					<p class="payment-method-title">Thẻ thanh toán quốc tế</p>
				</div>
				<img src="https://via.placeholder.com/60" alt="Thẻ quốc tế">
			</div>
		</a>

		<!-- Phương thức 4 -->
		<c:url var="checklast4" value="/check">
			<c:param name="method" value="4" />
		</c:url>
		<a href="${checklast4}" class="text-decoration-none">
			<div class="payment-method">
				<div class="payment-method-info">
					<p class="payment-method-title">Ví điện tử VNPay</p>
				</div>
				<img src="https://via.placeholder.com/60" alt="Ví VNPay">
			</div>
		</a>

		<!-- Phương thức 5 -->
		<c:url var="checklast5" value="/check">
			<c:param name="method" value="5" />
		</c:url>
		<a href="${checklast5}" class="text-decoration-none">
			<div class="payment-method">
				<div class="payment-method-info">
					<p class="payment-method-title">Thanh toán bằng tiền mặt</p>
				</div>
				<img src="https://via.placeholder.com/60" alt="Tiền mặt">
			</div>
		</a>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
