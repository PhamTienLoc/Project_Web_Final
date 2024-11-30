<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="container-fluid bg-light py-3 border-bottom shadow-sm">
	<div
		class="d-flex flex-wrap align-items-center justify-content-between">
		<!-- Logo -->
		<a href="home"
			class="d-flex align-items-center text-dark text-decoration-none">
			<img src="${pageContext.request.contextPath}/image/Phát Lộc.png"
			alt="Logo" width="40" height="100%" class="me-2 rounded-circle">
			<span class="fs-4 ml-3">PLJ</span>
		</a>

		<!-- Navigation -->
		<ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
			<li><a href="home" class="nav-link px-3 link-secondary">Home</a></li>

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

			<li><a href="blogs" class="nav-link px-3 link-dark">Blog</a></li>
			<li><a href="Policy.jsp" class="nav-link px-3 link-dark">Chính sách</a></li>
			<li><a href="About.jsp" class="nav-link px-3 link-dark">About</a></li>
		</ul>

		<!-- Search, Cart, and Login Button -->
		<div class="d-flex align-items-center">
			<form action="search" method="get"
				class="d-flex align-items-center me-2">
				<div class="input-group">
					<input type="text" class="form-control" name="txt"
						placeholder="Search..." value="${txtS}">
					<button class="btn btn-outline-secondary" type="submit">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</form>
			<a href="Cart.jsp"
				class="btn btn-outline-dark me-2 position-relative mr-3 ml-3"> <i
				class="fas fa-shopping-cart"></i> <!-- Thêm thông báo số lượng nếu cần -->
				<c:if test="${not empty sessionScope.size}">
					<span
						class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
						${sessionScope.size} </span>
				</c:if> <c:if test="${empty sessionScope.size}">
					<span
						class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
						0 </span>
				</c:if>
			</a>

			<c:choose>
				<c:when test="${sessionScope.user !=null}">
					<!-- Dropdown Menu for Logged User -->
					<div class="dropdown">
						<button class="btn btn-outline-primary dropdown-toggle"
							type="button" id="loginDropdown" data-bs-toggle="dropdown"
							aria-expanded="false">Hello ${sessionScope.user.user}</button>
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="loginDropdown">
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/ChangeUserInfo.jsp">Thay đổi thông tin</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/ChangePassWord.jsp">Đổi mật khẩu</a></li>

							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
						</ul>
					</div>

				</c:when>
				<c:otherwise>
					<a class="btn btn-outline-primary"
						href="${pageContext.request.contextPath}/Login.jsp">Login</a>
				</c:otherwise>
			</c:choose>

		</div>
	</div>

</header>

