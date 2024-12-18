<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Danh sách sản phẩm</title>
<!-- Thư viện ngoài -->
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
<!-- CSS của project -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/category.css">
</head>
<body class="d-flex flex-column min-vh-100">

	<div id="menuContainer"><jsp:include page="Header.jsp"></jsp:include></div>

	<!-- Breadcrumb -->
	<div class="container mt-3">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb p-3 bg-body-tertiary rounded-3">
				<li class="breadcrumb-item"><a class="text-decoration-none"
					href="#">Trang chủ</a></li>
				<li class="breadcrumb-item active" aria-current="page">Danh sách sản phẩm</li>
			</ol>
		</nav>
	</div>
	<!-- End of Breadcrumb -->

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

	<main class="mb-3">
		<div class="container">
			<div class="row">
				<div class="product-filter">
					<div class="filter-sidebar d-none d-md-block">
						<div class="filter-title mb-4">
							<h1>
								<i class="bi bi-funnel me-1"></i> BỘ LỌC TÌM KIẾM
							</h1>
						</div>
						<div class="category-filter">
							<h2>Theo Danh Mục</h2>
							<c:set var="c" value="${categories}"/>
							<c:set var="cc" value="${requestScope.categoryChecked}"/>
							<c:set var="cid" value="${requestScope.cid}"/>
							<form action="productFilter" method="get" id="categoryForm">
								<div class="form-check">
									<input 
										class="form-check-input" 
										type="checkbox" 
										id="categoryIdAll" 
										name="categoryId"
										${cc[0]?"checked":""}
										value="${0}"
										onClick="setCheck(this, 'categoryId', 'categoryForm')">
									<label class="form-check-label" for="categoryIdAll"> Tất cả </label>
								</div>
								<c:forEach begin="0" end="${c.size() - 1}" var="i">
									<div class="form-check">
										<input 
											class="form-check-input" 
											type="checkbox" 
											id="category${c.get(i).getCid()}"
											name="categoryId"
											${(cc[i+1]) ? "checked" : ""}
											value="${c.get(i).getCid()}"
											${c.get(i).getCid()==cid ? "checked" : ""}
											onClick="setCheck(this, 'categoryId', 'categoryForm')">
										<label 
											class="form-check-label" 
											for="category${c.get(i).getCid()}">
											${c.get(i).getCname()}
										</label>
									</div>
								</c:forEach>
							</form>
						</div>
						<hr>
						<div class="price-filter">
							<h2>Khoảng Giá</h2>
							<c:set var="pr" value="${requestScope.priceRange}"/>
							<c:set var="prc" value="${requestScope.priceRangeChecked}"/>
							<form action="productFilter" method="get" id="priceRangeForm">
								<div class="form-check">
									<input 
										class="form-check-input" 
										type="checkbox" 
										id="priceIdAll"
										name="priceId"
										${prc[0]?"checked":""}
										value="${0}"
										onClick="setCheck(this, 'priceId', 'priceRangeForm')">
									<label class="form-check-label" for="priceIdAll"> Tất cả </label>
								</div>
								<c:forEach begin="0" end="4" var="i">
									<div class="form-check">
										<input 
											class="form-check-input" 
											type="checkbox" 
											id="priceRange${i+1}"
											name="priceId"
											${prc[i+1]?"checked":""}
											value="${i+1}"
											onClick="setCheck(this, 'priceId', 'priceRangeForm')">
										<label 
											class="form-check-label" 
											for="priceRange${i+1}">
											${pr[i]}
										</label>
									</div>
								</c:forEach>
							</form>
						</div>
					</div>
				</div>
				<div class="product-list">
					<div class="product-sort d-flex align-items-center">
						<span class="product-sort--label me-2">Sắp xếp theo</span>
						<div class="product-sort--options">
							<select>
								<option>Sản phẩm mới nhất</option>
								<option>Giá từ thấp đến cao</option>
								<option>Giá từ cao đến thấp</option>
							</select>
						</div>
						<div
							class="mini-page--controller d-flex flex-grow-1 justify-content-end align-items-center">
							<div class="page-number">
								<span class="page-index">1</span>/<span class="page-total">12</span>
							</div>
							<div class="d-flex">
								<button type="button" class="btn btn-outline-primary rounded-1">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor"
										class="justify-content-center bi bi-chevron-left"
										viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
											d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0" />
                                </svg>
								</button>
								<button type="button" class="btn btn-primary rounded-1">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-chevron-right"
										viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
											d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708" />
                                </svg>
								</button>
							</div>
						</div>
					</div>
					<div class="row">
						<c:if test="${not empty products}">
							<h1 class="mb-3 fs-3">Tìm thấy (${products.size()} sản phẩm)</h1>
							<c:forEach var="p" items="${products}">
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
											<form action="buy2" method="get"
												onsubmit="return buy(event, this);">
												<input type="hidden" name="id" value="${p.id}"> <input
													type="hidden" name="quantity" value="1">
												<button type="submit" class="btn btn-success">
													Thêm vào giỏ hàng
												</button>
											</form>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${empty products}">
							<div class="text-center">
								<h1 class="my-3">Không tìm thấy sản phẩm phù hợp!</h1>
							</div>
						</c:if>
					</div>
					
					<nav aria-label="Page navigation">
						<ul class="pagination justify-content-center mb-4">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item active"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="Footer.jsp"></jsp:include>

	<script type="text/javascript">
	function setCheck(obj, name, formId) {
	    var checkboxes = document.getElementsByName(name);
	    if ((obj.id == name + "All") && (checkboxes[0].checked == true)) {
	        for (var i = 1; i < checkboxes.length; i++) {
	            checkboxes[i].checked = false;
	        }
	    } else {
	        for (var i = 1; i < checkboxes.length; i++) {
	            if (checkboxes[i].checked == true) {
	                checkboxes[0].checked = false;
	                break;
	            }
	        }
	    }
	    document.getElementById(formId).submit();
	}
	</script>
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