<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


	<div class="container my-5">
		<div class="text-center">
			<h1 class="mb-4 text-primary">Cảm ơn bạn!</h1>
			<p class="lead">
				Chúng tôi thật sự trân trọng việc bạn đã chọn cửa hàng của chúng tôi
				giữa hàng triệu cửa hàng khác. <br> Hy vọng sản phẩm của chúng
				tôi sẽ mang lại sự hài lòng và giá trị tốt nhất cho bạn.
			</p>
			<img src="https://marketplace.canva.com/EAE7DzDu4x4/1/0/1600w/canva-peach-femenine-thank-you-for-your-order-card-su2sRWwRJpU.jpg" alt="Thank You"
				class="img-fluid rounded my-4">
			<p>
				Nếu bạn có bất kỳ câu hỏi hoặc cần hỗ trợ, đừng ngần ngại liên hệ
				với chúng tôi qua: <br>
				<strong>Email:</strong> support@cuahangcuatoi.com | <strong>Đường dây nóng:</strong>
				1900-123-456
			</p>
			<a href="home" class="btn btn-primary btn-lg mt-3">Quay về trang chủ</a>
		</div>
	</div>







	<jsp:include page="Footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>