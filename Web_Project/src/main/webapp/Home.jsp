<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><fmt:message key="home" bundle="${bundle}" /></title>
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css">
<style type="text/css">
.notyf {
	z-index: 9999 !important;
}
</style>

</head>
<body>
	<div id="menuContainer">
		<jsp:include page="Header.jsp"></jsp:include>
	</div>
	<!--Slider 1920x640 hoặc 1920x960.-->
	<div id="carouselExampleSlidesOnly" class="carousel slide mb-4"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="https://cdn.pnj.io/images/promo/228/ngaydoi-1111-1972x640CTA.jpg"
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img
					src="https://cdn.pnj.io/images/promo/227/tabsale-t11-24-1972x640-chung.jpg"
					class="d-block w-100" alt="...">
			</div>
		</div>
	</div>

	<div class="container mt-5">
		<!-- Sản phẩm nổi bật -->
		<section class="mb-5">
			<h2 class="text-center"><fmt:message key="newest_products" bundle="${bundle}" /></h2>
			<div class="row">
				<!-- Sử dụng JSTL để lặp qua danh sách sản phẩm nổi bật -->
				<c:forEach var="p" items="${list2}">
					<div class="col-md-3">
						<div class="card card-hover">
							<c:url var="productdetail" value="/detail">
								<c:param name="id" value="${p.id}" />
								<c:param name="cid" value="${p.cid}" />
							</c:url>
							<a href="${productdetail}"> <img src="${pageContext.request.contextPath}/image/image1/${p.thumbnail}"
								class="card-img-top" alt="<fmt:message key="product.image_alt" bundle="${bundle}" />">
							</a>
							<div class="card-body text-center">

								<a href="${productdetail}">
									<h5 class="card-title">${p.title}</h5>
								</a>
								<p class="card-text"><fmt:formatNumber value="${p.price}" type="currency" groupingUsed="true" /></p>
								<form action="buy2" method="get"
									onsubmit="return buy(event, this);">
									<input type="hidden" name="id" value="${p.id}"> <input
										type="hidden" name="quantity" value="1">
									<button type="submit" class="btn btn-primary">
										<fmt:message key="add_to_cart" bundle="${bundle}" />
									</button>
								</form>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>

		<!-- Danh mục sản phẩm -->
		<section class="mb-5">
			<h2 class="text-center"><fmt:message key="product_categories" bundle="${bundle}" /></h2>
			<div class="row">
				<!-- Sử dụng JSTL để lặp qua danh sách danh mục -->
				<c:forEach var="c" items="${listC}">
					<div class="category col-md-4 mb-4">
						<form action="category" method="get" class="text-decoration-none">
							<input type="hidden" name="id" value="${c.cid}">
							<button type="submit" class="btn btn-link p-0">
								<div class="card card-hover text-center">
									<img src="${c.thumb}" class="card-img-top" alt="Category Image">
									<div class="card-body">
										<h5 class="card-title">${c.cname}</h5>
									</div>
								</div>
							</button>
						</form>
					</div>
				</c:forEach>
			</div>
		</section>

		<!-- Loạt sản phẩm -->
		<section>
			<h2 class="text-center"><fmt:message key="product_series" bundle="${bundle}" /></h2>
			<div id="content" class="row">
				<!-- Sử dụng JSTL để lặp qua danh sách loạt sản phẩm -->
				<c:forEach var="p" items="${listP}">
					<div class="product col-md-3 mb-4">
						<div class="card card-hover">
							<a href="detail?id=${p.id}&cid=${p.cid}"> <img src="${pageContext.request.contextPath}/image/image1/${p.thumbnail}"
								class="card-img-top" alt="<fmt:message key="product.image_alt" bundle="${bundle}" />">
							</a>
							<div class="card-body text-center">
								<a href="detail?id=${p.id}&cid=${p.cid}" class="text-decoration-none">
									<h5 class="card-title">${p.title}</h5>
								</a>
								<p class="card-text"><fmt:formatNumber value="${p.price}" type="currency" groupingUsed="true" /></p>
								<form action="buy2" method="get"
									onsubmit="return buy(event, this);">
									<input type="hidden" name="id" value="${p.id}"> <input
										type="hidden" name="quantity" value="1">
									<button type="submit" class="btn btn-success">
										<fmt:message key="add_to_cart" bundle="${bundle}" />
									</button>
								</form>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- Căn giữa và thêm margin-bottom -->
			<div class="d-flex justify-content-center mb-3">
				<button onclick="loadMore()" class="btn btn-primary">
					<fmt:message key="see_more" bundle="${bundle}" />
				</button>
			</div>
		</section>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/home.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js"></script>
	<script>
		function buy(event, form) {
			event.preventDefault(); // Ngăn chặn hành động mặc định của form
			const formData = $(form).serialize(); // Lấy dữ liệu từ form

			$.ajax({
				url : 'buy2', // URL xử lý yêu cầu
				type : 'GET', // Phương thức GET
				data : formData, // Dữ liệu gửi đi
				success : function(response) {
					// Tải lại header (hoặc cập nhật giỏ hàng)
					$('#menuContainer').load('Header.jsp', function() {
						//alert('Thêm vào giỏ hàng thành công!'); // Hiển thị thông báo thành công
					});

					// Khởi tạo Notyf để hiển thị thông báo
					const notyf = new Notyf();
					notyf.open({
						duration : 1000,
						position : {
							x : 'right',
							y : 'top',
						},
						type : 'success', // Loại thông báo thành công
						message : 'Thêm vào giỏ hàng thành công!', // Nội dung thông báo
					});
				},12