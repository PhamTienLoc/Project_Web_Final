<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN" />
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css">
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
							<form action="productList" method="get" id="categoryForm">
								<div class="form-check">
									<input 
										class="form-check-input" 
										type="checkbox" 
										id="categoryIdAll" 
										name="categoryId"
										${cc[0] ? "checked" : ""}
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
							<form action="productList" method="get" id="priceRangeForm">
								<div class="form-check">
									<input 
										class="form-check-input" 
										type="checkbox" 
										id="priceIdAll"
										name="priceId"
										${prc[0] ? "checked" : ""}
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
											${prc[i+1] ? "checked" : ""}
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
						<c:set var="defaultSortParam" value="${requestScope.param}" />
						<c:if test="${not empty defaultSortParam}">
						    <c:set var="sortParam" value="${defaultSortParam}" />
						    <c:set var="sortParam" value="${sortParam.replaceAll('sortBy=[^&]*&?', '')}" />
						</c:if>
						<c:if test="${empty defaultSortParam}">
						    <c:set var="sortParam" value="" />
						</c:if>
						<div class="dropdown">
						    <button class="btn btn-primary dropdown-toggle" 
								    type="button" 
								    id="sortDropdown" 
								    data-bs-toggle="dropdown" 
								    aria-expanded="false">
						        <c:choose>
						            <c:when test="${sortBy == 'newest'}">Sản phẩm mới nhất</c:when>
						            <c:when test="${sortBy == 'price_asc'}">Giá thấp đến cao</c:when>
						            <c:when test="${sortBy == 'price_desc'}">Giá cao đến thấp</c:when>
						            <c:when test="${sortBy == 'name_asc'}">Tên từ A - Z</c:when>
						            <c:when test="${sortBy == 'name_desc'}">Tên từ Z - A</c:when>
						        </c:choose>
						    </button>
						    <ul class="dropdown-menu dropdown-menu-end pe-5" aria-labelledby="sortDropdown">
						        <li><a class="dropdown-item" href="productList?${sortParam}&sortBy=newest">Sản phẩm mới nhất</a></li>
						        <li><a class="dropdown-item" href="productList?${sortParam}&sortBy=price_asc">Giá thấp đến cao</a></li>
						        <li><a class="dropdown-item" href="productList?${sortParam}&sortBy=price_desc">Giá cao đến thấp</a></li>
						        <li><a class="dropdown-item" href="productList?${sortParam}&sortBy=name_asc">Tên từ A - Z</a></li>
						        <li><a class="dropdown-item" href="productList?${sortParam}&sortBy=name_desc">Tên từ Z - A</a></li>
						    </ul>
						</div>

						</div>
						<div class="mini-page--controller d-flex flex-grow-1 justify-content-end align-items-center">
							<div class="page-number">
								<span class="page-index">${pageIndex}</span>/<span class="page-total">${totalPage}</span>
							</div>
							<div class="d-flex justify-content-center align-items-center">
							    <c:if test="${pageIndex > 1}">
							        <a class="btn btn-outline-primary d-flex align-items-center justify-content-center me-1 py-2 px-2"
							           href="productList?${indexParam}index=${pageIndex - 1}" aria-label="Previous">
							            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
							                <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0"/>
							            </svg>
							        </a>
							    </c:if>
							    <c:if test="${pageIndex <= 1}">
							        <a class="btn btn-primary disabled d-flex align-items-center justify-content-center me-1 py-2 px-2"
							           href="#" aria-label="Previous">
							            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
							                <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0"/>
							            </svg>
							        </a>
							    </c:if>
							    <c:if test="${pageIndex < totalPage}">
							        <a class="btn btn-outline-primary d-flex align-items-center justify-content-center py-2 px-2"
							           href="productList?${indexParam}index=${pageIndex + 1}" aria-label="Next">
							            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
							                <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708"/>
							            </svg>
							        </a>
							    </c:if>
							    <c:if test="${pageIndex >= totalPage}">
							        <a class="btn btn-primary disabled d-flex align-items-center justify-content-center py-2 px-2"
							           href="#" aria-label="Next">
							            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
							                <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708"/>
							            </svg>
							        </a>
							    </c:if>
							</div>
						</div>
					</div>
					<div class="row">
						<c:if test="${not empty products}">
						<h1 class="mb-3 fs-3">Tìm thấy (${requestScope.totalProduct} sản phẩm)</h1>
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
		
										<p class="card-text">
										    <fmt:formatNumber value="${p.price}" type="number" groupingUsed="true" />đ
										</p>
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
					
					<c:set var="defaultIndexParam" value="${requestScope.param}" />
					<c:if test="${not empty defaultIndexParam}">
					    <c:set var="indexParam" value="${defaultIndexParam}" />
					    <c:set var="indexParam" value="${indexParam.replaceAll('index=[^&]*&?', '')}" />
					</c:if>
					<c:if test="${empty defaultIndexParam}">
					    <c:set var="indexParam" value="" />
					</c:if>
					
					<nav aria-label="Page navigation">
					    <ul class="pagination justify-content-center">
					        <c:if test="${pageIndex > 1}">
					            <li class="page-item">
					                <a class="page-link" href="productList?${indexParam}index=${pageIndex - 1}">
					                    <span aria-hidden="true">&laquo;</span>
					                </a>
					            </li>
					        </c:if>
					
					        <c:forEach begin="1" end="${totalPage}" var="i" step="1">
					            <li class="page-item ${i == pageIndex ? 'active' : ''}">
					                <a class="page-link" href="productList?${indexParam}index=${i}">
					                    ${i}
					                </a>
					            </li>
					        </c:forEach>
					
					        <c:if test="${pageIndex < totalPage}">
					            <li class="page-item">
					                <a class="page-link" href="productList?${indexParam}index=${pageIndex + 1}">
					                    <span aria-hidden="true">&raquo;</span>
					                </a>
					            </li>
					        </c:if>
					    </ul>
					</nav>

				</div>
			</div>
		</div>
	</main>

	<jsp:include page="Footer.jsp"></jsp:include>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/home.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/category.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js"></script>
	<script type="text/javascript">
	function setCheck(obj, name, formId) {
	    var checkboxes = document.getElementsByName(name);
	    if (obj.id === name + "All" && obj.checked) {
	        for (var i = 1; i < checkboxes.length; i++) {
	            checkboxes[i].checked = false;
	        }
	    } else {
	        checkboxes[0].checked = false;
	    }
	    document.getElementById(formId).submit();
	}
	</script>
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
				},
				error : function(error) {
					// Nếu có lỗi, hiển thị thông báo lỗi
					const notyf = new Notyf();
					notyf.open({
						duration : 1000,
						position : {
							x : 'right',
							y : 'top',
						},
						type : 'error', // Loại thông báo lỗi
						message : 'Có lỗi xảy ra, vui lòng thử lại!', // Nội dung thông báo lỗi
					});
				}
			});

			return false; // Đảm bảo form không được gửi đi theo cách mặc định
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