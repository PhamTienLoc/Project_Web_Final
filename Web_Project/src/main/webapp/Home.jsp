<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Category</a></li>
						<li class="breadcrumb-item active" aria-current="#">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container mt-5">
		<!-- Sản phẩm nổi bật -->
		<section class="mb-5">
			<h2 class="text-center">Sản Phẩm Mới Nhất</h2>
			<div class="row">
				<!-- Sử dụng JSTL để lặp qua danh sách sản phẩm nổi bật -->
				<c:forEach var="p" items="${list2}">
					<div class="col-md-3">
						<div class="card card-hover">
							<c:url var="productdetail" value="/detail">
								<c:param name="id" value="${p.id}" />
								<c:param name="cid" value="${p.cid}" />
							</c:url>
							<a href="${productdetail}"> <img src="${p.thumbnail}"
								class="card-img-top" alt="Product Image">
							</a>
							<div class="card-body text-center">

								<a href="${productdetail}">
									<h5 class="card-title">${p.title}</h5>
								</a>

								<p class="card-text">${p.price}$</p>
								<c:url var="buyct" value="/buy2">
									<c:param name="id" value="${p.id}"></c:param>
									<c:param name="quantity" value="1"></c:param>
								</c:url>
								<a href="${buyct}" class="btn btn-primary">Add to Cart</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>

		<!-- Danh mục sản phẩm -->
		<section class="mb-5">
			<h2 class="text-center">Danh Mục Sản Phẩm</h2>
			<div class="row">
				<!-- Sử dụng JSTL để lặp qua danh sách danh mục -->
				<c:forEach var="c" items="${listC}">
					<div class="col-md-4 mb-4">
						<a href="<c:url value='/category?id=${c.cid}' />"
							class="text-decoration-none">
							<div class="card card-hover text-center">
								<img src="${c.thumb}" class="card-img-top" alt="Category Image">
								<div class="card-body">
									<h5 class="card-title">${c.cname}</h5>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</section>

		<!-- Loạt sản phẩm -->
		<section>
			<h2 class="text-center">Loạt Sản Phẩm</h2>
			<div id="content" class="row">
				<!-- Sử dụng JSTL để lặp qua danh sách loạt sản phẩm -->
				<c:forEach var="p" items="${listP}">
					<c:url var="productdetail" value="/detail">
						<c:param name="id" value="${p.id}" />
						<c:param name="cid" value="${p.cid}" />
					</c:url>
					<c:url var="buyct" value="/buy2">
						<c:param name="id" value="${p.id}"></c:param>
						<c:param name="quantity" value="1"></c:param>
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
								<a href="${buyct}" class="btn btn-success">Add to Cart</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- Căn giữa và thêm margin-bottom -->
			<div class="d-flex justify-content-center mb-3">
				<button onclick="loadMore()" class="btn btn-primary">Load
					more</button>
			</div>
		</section>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="js/home.js"></script>
</body>
</html>