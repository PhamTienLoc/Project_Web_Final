<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Danh mục Blog</title>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/blogs.css">
</head>
<body class="d-flex flex-column min-vh-100">

	<jsp:include page="/Header.jsp"></jsp:include>

	<!-- Breadcrumb -->
	<div class="container mt-3">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb p-3 bg-body-tertiary rounded-3">
				<li class="breadcrumb-item"><a class="text-decoration-none"
					href="#">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">Blogs</li>
			</ol>
		</nav>
	</div>
	<!-- End of Breadcrumb -->

	<main class="flex-grow-1 mb-3">
		<div class="container px-5">
			<!-- Blog nổi bật -->
			<section class="mb-5">
				<h2 class="mb-4 text-center text-capitalize fw-bold">Bài viết
					nổi bật</h2>
				<div class="row">
					<!-- Blog -->
					<c:forEach var="blog" items="${top3}">
						<div class="col-md-4 mb-4">
							<div class="blog-card h-100">
								<img src="${blog.thumbnail}"
									class="feature-blog-thumb rounded mb-3" alt="Ảnh minh họa Blog">
								<h4 class="fw-semibold mb-2">${blog.title}</h4>
								<div class="d-flex justify-content-between">
									<span class="text-muted mb-1"><b>${blog.author}</b></span><span
										class="text-muted mb-1">${blog.createdAt}</span>
								</div>
								<p class="text-secondary">${blog.description}</p>
								<a class="fs-5 text-decoration-none fw-semibold text-warning"
									href="${pageContext.request.contextPath}/blogDetail?id=${blog.id}">Xem
									chi tiết <i class="bi bi-arrow-right-short"></i>
								</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>

			<!-- Danh sách Blog -->
			<section>
				<h2 class="mb-4 text-center text-capitalize fw-bold">Các bài
					viết đáng chú ý</h2>
				<c:forEach var="blog" items="${remain}">
					<!-- Blog Item -->
					<div class="blog-list-item">
						<a href="${pageContext.request.contextPath}/blogDetail?id=${blog.id}"
							class="blog-link d-flex"> <img src="${blog.thumbnail}"
							alt="Ảnh minh họa Blog" class="blog-thumbnail me-3">
							<div>
								<h4 class="blog-title fw-bold mb-2">${blog.title}</h4>
								<p class="text-muted mb-1"><b>${blog.author}</b> | ${blog.createdAt}</p>
								<p class="text-secondary">${blog.description}</p>
							</div>
						</a>
					</div>
				</c:forEach>
			</section>
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