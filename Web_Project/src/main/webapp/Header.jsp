<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header
	class="container-fluid bg-light py-3 border-bottom shadow-sm">
	<div
		class="d-flex flex-wrap align-items-center justify-content-between">
		<!-- Logo -->
		<a href="home"
			class="d-flex align-items-center text-dark text-decoration-none">
			<img src="${pageContext.request.contextPath}/image/Phát Lộc.png" alt="Logo" width="40" height="100%" class="me-2 rounded-circle">
			<span class="fs-4 ml-3">PLJ</span>
		</a>

		<!-- Navigation -->
		<ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
			<li><a href="#" class="nav-link px-3 link-secondary">Home</a></li>

			<!-- Dropdown Menu -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle px-3 link-dark" href="#"
				id="featuresDropdown" role="button" data-bs-toggle="dropdown"
				aria-expanded="false"> Features </a>
				<ul class="dropdown-menu" aria-labelledby="featuresDropdown">
					<li><a class="dropdown-item" href="#">Feature 1</a></li>
					<li><a class="dropdown-item" href="#">Feature 2</a></li>
					<li><a class="dropdown-item" href="#">Feature 3</a></li>
				</ul></li>

			<li><a href="#" class="nav-link px-3 link-dark">Blog</a></li>
			<li><a href="#" class="nav-link px-3 link-dark">Chính sách</a></li>
			<li><a href="#" class="nav-link px-3 link-dark">About</a></li>
		</ul>

		<!-- Search, Cart, and Login Button -->
		<div class="d-flex align-items-center">
			<form action="search" method="get" class="d-flex align-items-center me-2">
				<div class="input-group">
					<input type="text" class="form-control" name="txt" placeholder="Search..." value="${txtS}">
					<button class="btn btn-outline-secondary" type="submit">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</form>
			<a href="#" class="btn btn-outline-dark me-2 position-relative mr-3 ml-3">
				<i class="fas fa-shopping-cart"></i> <!-- Thêm thông báo số lượng nếu cần -->
				<span
				class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					3 <!-- Số lượng sản phẩm trong giỏ -->
			</span>
			</a>
			
			<c:choose>
				<c:when test="${sessionScope.user !=null}">
					<!-- Dropdown Menu for Logged User -->
					<div class="dropdown">
						<button class="btn btn-outline-primary dropdown-toggle"
							type="button" id="loginDropdown" data-bs-toggle="dropdown"
							aria-expanded="false">Hello ${sessionScope.user.fullName}</button>
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="loginDropdown">
							<li><a class="dropdown-item" href="#">Thay đổi thông tin</a></li>
							<li><a class="dropdown-item" href="ChangePassWord.jsp">Đổi mật khẩu</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
						</ul>
					</div>
					
				</c:when>
				<c:otherwise>
					<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/Login.jsp">Login</a>
				</c:otherwise>
			</c:choose>
			
			


		</div>
	</div>
</header>
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