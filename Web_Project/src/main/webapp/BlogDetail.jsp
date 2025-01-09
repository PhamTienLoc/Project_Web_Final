<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${blog.title}</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/blog-detail.css">
</head>
<body class="d-flex flex-column min-vh-100">

	<jsp:include page="/Header.jsp"></jsp:include>

	<div class="container-fluid bg-body-tertiary">
		<!-- Slider 1920x640 hoặc 1920x960 -->
		<div class="container">
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
		</div>
	</div>

	<main class="flex-grow-1 my-4">
		<div class="container p-5">
			<!-- Blog info -->
			<div class="px-5">
				<h2 class="blog-title display-6 mb-3">${blog.title}</h2>
				<div class="row">
					<div class="col">
						<p class="blog-post-meta">
							<i class="bi bi-calendar"></i> ${blog.createdAt} bởi <b>${blog.author}</b>
						</p>
					</div>
					<div class="col">
						<i class="bi bi-clock"></i> Thời gian đọc: <span>${blog.readTime}</span>
						phút
					</div>
					<div class="col"></div>
				</div>
			</div>
			<hr>

			<!-- Blog content -->
			<div class="row g-5 mt-1 px-5">
				<div class="col-md-8">
					<p class="fs-5 fst-italic fw-semibold">${blog.description}</p>

					<article class="blog-post">
						<c:out value="${content}" escapeXml="false" />
					</article>
				</div>

				<div class="col-md-4">
					<div class="position-sticky" style="top: 2rem;">
						<div class="mb-3">
							<img
								src="https://www.pnj.com.vn/blog/wp-content/uploads/2020/09/1200x1200-KPN-1.jpg"
								class="img-fluid" alt="promotion-banner">
						</div>
						<!-- Khám phá thêm -->
						<div>
							<h4 class="fst-italic">Khám phá thêm</h4>
							<ul class="list-unstyled">
								<!-- More Blog -->
								<li><a
									class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top"
									href="#"> <img class="w-25"
										src="https://www.pnj.com.vn/blog/wp-content/uploads/2021/11/huong-dan-do-size-nhan-1920x1440.jpg"
										alt="Blog 1">
										<div class="col-lg-8">
											<h5 class="mb-0">Kim cương rời là gì? Có nên mua kim
												cương rời tại Phát Lộc?</h5>
											<small class="text-body-secondary">28/10/2022</small>
										</div>
								</a></li>
								<!-- More Blog -->
								<li><a
									class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top"
									href="#"> <img class="w-25"
										src="https://www.pnj.com.vn/blog/wp-content/uploads/2021/11/huong-dan-do-size-nhan-1920x1440.jpg"
										alt="Blog 2">
										<div class="col-lg-8">
											<h5 class="mb-0">Hiểu về đá Morganite – viên đá đẹp đến
												nao lòng</h5>
											<small class="text-body-secondary">24/12/2021</small>
										</div>
								</a></li>
								<!-- More Blog -->
								<li><a
									class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top"
									href="#"> <img class="w-25"
										src="https://www.pnj.com.vn/blog/wp-content/uploads/2021/11/huong-dan-do-size-nhan-1920x1440.jpg"
										alt="Blog 3">
										<div class="col-lg-8">
											<h5 class="mb-0">Hướng dẫn đo size, kích cỡ nhẫn</h5>
											<small class="text-body-secondary">17/11/2021</small>
										</div>
								</a></li>
							</ul>
						</div>

						<!-- Blog by month -->
						<div class="py-4">
							<h4 class="fst-italic">Lưu trữ theo tháng</h4>
							<ol class="list-unstyled py-1 border-top">
								<li class="py-1"><a
									class="text-light-emphasis text-decoration-none" href="#">Tháng
										12 2024</a></li>
								<li class="py-1"><a
									class="text-light-emphasis text-decoration-none" href="#">Tháng
										11 2024</a></li>
								<li class="py-1"><a
									class="text-light-emphasis text-decoration-none" href="#">Tháng
										10 2024</a></li>
								<li class="py-1"><a
									class="text-light-emphasis text-decoration-none" href="#">Tháng
										9 2024</a></li>
								<li class="py-1"><a
									class="text-light-emphasis text-decoration-none" href="#">Tháng
										8 2024</a></li>
								<li class="py-1"><a
									class="text-light-emphasis text-decoration-none" href="#">Tháng
										7 2024</a></li>
							</ol>
						</div>

					</div>
				</div>
			</div>
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