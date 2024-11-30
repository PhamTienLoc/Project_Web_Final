<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chi Tiết Sản Phẩm</title>
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
.thumbnail-container {
	width: 100px; /* Đặt chiều rộng cố định cho ảnh thu nhỏ */
}

.thumbnail-image {
	cursor: pointer;
	width: 100%; /* Đặt ảnh thu nhỏ chiếm hết chiều rộng container */
	object-fit: cover; /* Giữ tỉ lệ ảnh */
}

.main-carousel {
	flex-grow: 1; /* Cho phép slider chiếm toàn bộ không gian còn lại */
}

.carousel-inner img {
	max-height: 400px; /* Giới hạn chiều cao của ảnh chính */
	object-fit: cover; /* Giữ tỉ lệ ảnh chính */
}
</style>
</head>
<body>
	<div id="menuContainer">
		<jsp:include page="Header.jsp"></jsp:include>
	</div>
	<!-- Main Content -->
	<div class="container mt-5">
		<!-- Phần Chi Tiết Sản Phẩm -->
		<div class="row">
			<!-- Phần Ảnh -->
			<div class="col-md-6 d-flex">
				<!-- Ảnh Thu Nhỏ -->
				<div class="me-3 d-flex flex-column thumbnail-container">
					<img src="${img.image1}" class="img-thumbnail mb-2 thumbnail-image"
						alt="Thumbnail 1" data-bs-slide-to="0"> <img
						src="${img.image2}" class="img-thumbnail thumbnail-image"
						alt="Thumbnail 2" data-bs-slide-to="1">
				</div>
				<!-- Ảnh Chính -->
				<div id="productImageCarousel"
					class="carousel slide flex-grow-1 main-carousel"
					data-bs-ride="carousel" data-bs-interval="2000">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="${img.image1}" class="d-block w-100" alt="Image 1">
						</div>
						<div class="carousel-item">
							<img src="${img.image2}" class="d-block w-100" alt="Image 2">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#productImageCarousel" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#productImageCarousel" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
			<!-- Phần Thông Tin Sản Phẩm -->
			<div class="col-md-6">
				<h2 class="product-title">${p.title}</h2>
				<p class="product-price">Giá: ${p.price} $</p>
				<form action="buy" method="get" onsubmit="return buy(event, this);">
					<div class="product-quantity">
						<label for="quantity">Số lượng:</label> <input type="number"
							id="quantity" name="quantity" class="form-control w-50" min="1"
							max="${p.inventoryNumber}" value="1">
					</div>
					<input type="hidden" name="id" value="${p.id}"> <input
						type="hidden" name="cid" value="${p.cid}">
					<div class="mt-3">
						<input type="submit" class="btn btn-success w-50"
							value="Add to Cart">
					</div>
				</form>
			</div>
		</div>
		<div class="row mt-4">
			<div class="col-md-12">
				<div class="product-description">
					<h5>Mô tả sản phẩm</h5>
					<p>${p.description}</p>
				</div>
				<div class="company-info mt-3">
					<h5>Về công ty chúng tôi</h5>
					<p>Chúng tôi là một công ty chuyên cung cấp các sản phẩm bạc
						cao cấp, từ trang sức bạc tinh xảo như nhẫn, vòng tay, dây chuyền,
						đến các sản phẩm bạc phong thủy đầy ý nghĩa. Sứ mệnh của chúng tôi
						là mang lại vẻ đẹp và giá trị bền vững cho khách hàng thông qua
						những thiết kế độc đáo và chất lượng vượt trội. Với đội ngũ nghệ
						nhân lành nghề và tâm huyết, chúng tôi cam kết mang đến những sản
						phẩm bạc không chỉ đẹp mà còn phù hợp với từng phong cách và cá
						tính riêng.</p>
				</div>
			</div>
		</div>

		<section>
			<h2 class="text-center">Sản Phẩm Liên Quan</h2>
			<div id="content" class="row">
				<c:forEach var="p" items="${listP}">
					<c:url var="productdetail" value="/detail">
						<c:param name="id" value="${p.id}" />
						<c:param name="cid" value="${p.cid}" />
					</c:url>

					<div class="product col-md-3 mb-4">
						<div class="card card-hover">
							<!-- Link bọc hình ảnh -->
							<a href="${productdetail}"> <img src="${p.thumbnail}"
								class="card-img-top" alt="Product Image">
							</a>
							<div class="card-body text-center">
								<!-- Link bọc title, đảm bảo không có khoảng trắng bên trong -->
								<a href="${productdetail}" class="text-decoration-none">
									<h5 class="card-title">${p.title}</h5>
								</a>
								<p class="card-text">${p.price}$</p>
								<form action="buy" method="get"
									onsubmit="return buy(event, this);">
									<input type="hidden" name="id" value="${p.id}"> <input
										type="hidden" name="cid" value="${p.cid}"> <input
										type="hidden" name="quantity" value="1"> <input
										type="submit" class="btn btn-success" value="Add to Cart">
								</form>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</div>


	<jsp:include page="Footer.jsp"></jsp:include>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/detail.js">
		
	</script>
	<script>
		function buy(event, form) {
			event.preventDefault(); // Ngăn chặn hành động mặc định của form
			const formData = $(form).serialize(); // Lấy dữ liệu từ form

			$.ajax({
				url : 'buy', // URL xử lý yêu cầu
				type : 'GET', // Phương thức GET
				data : formData, // Dữ liệu gửi đi
				success : function(response) {
					// Tải lại header (hoặc cập nhật giỏ hàng)
					$('#menuContainer').load('Header.jsp', function() {
						alert('Thêm vào giỏ hàng thành công!'); // Hiển thị thông báo thành công
					});
				},
				error : function(error) {
					alert('Có lỗi xảy ra, vui lòng thử lại!'); // Hiển thị thông báo lỗi
				}
			});

			return false; // Đảm bảo form không được gửi đi theo cách mặc định
		}
	</script>

</body>
</html>