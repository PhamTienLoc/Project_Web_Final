<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><fmt:message key="cart" bundle="${bundle}" /></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
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

	<div id="menuContainer">
		<jsp:include page="Header.jsp"></jsp:include>
	</div>
	<!-- Breadcrumb -->
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a
				href="${pageContext.request.contextPath}/home"><fmt:message key="home" bundle="${bundle}" /></a></li>
			<li class="breadcrumb-item active" aria-current="page"><fmt:message key="cart" bundle="${bundle}" /></li>
		</ol>
	</nav>
	<div class="container mt-5 mb-3">
		<h1 class="text-center mb-4"><fmt:message key="cart" bundle="${bundle}" /></h1>


		<div class="row">
			<!-- Cart Items -->
			<div id="cartItems" class="col-md-8">
				<!-- Loop through products using JSTL -->
				<c:forEach var="item" items="${sessionScope.cart.items}">
					<div class="card mb-3">
						<div class="row g-0">
							<div class="col-md-4">
								<img src="${pageContext.request.contextPath}/image/image1/${item.product.thumbnail}"
									class="img-fluid rounded-start" alt="Product Image">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">${item.product.title}</h5>
									<p class="card-text text-muted"><fmt:message key="cart.item_price" bundle="${bundle}" />:
										<fmt:formatNumber value="${item.product.price}" type="currency" groupingUsed="true" />
									</p>
									<p class="card-text text-muted"><fmt:message key="cart.total" bundle="${bundle}" />:
										<fmt:formatNumber value="${item.product.price * item.quantity}" type="currency" groupingUsed="true" />
									</p>
									<p class="card-text">

									<!-- Form cho nút trừ -->
									<form action="updatequantity" method="get"
										onsubmit="return updatequantity(event,this);"
										style="display: inline;">
										<input type="hidden" name="id" value="${item.product.id}">
										<input type="hidden" name="num" value="-1">
										<button type="submit" class="btn btn-outline-secondary btn-sm">-</button>
									</form>

									<span class="mx-2">${item.quantity}</span>

									<!-- Form cho nút cộng -->
									<form action="updatequantity" method="get"
										onsubmit="return updatequantity(event,this);"
										style="display: inline;">
										<input type="hidden" name="id" value="${item.product.id}">
										<input type="hidden" name="num" value="1">
										<button type="submit" class="btn btn-outline-secondary btn-sm">+</button>
									</form>

									</p>
									<form action="deleteitem" method="get" class="d-inline"
										onsubmit="return remove(event, this);">
										<input type="hidden" name="id" value="${item.product.id}">
										<button type="submit" class="btn btn-danger btn-sm"><fmt:message key="cart.delete" bundle="${bundle}" /></button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- Cart Summary -->
			<div id="cartSummary" class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title"><fmt:message key="cart.summary" bundle="${bundle}" /></h5>

						<p class="card-text">
							<fmt:message key="cart.subtotal" bundle="${bundle}" />: 
							<strong>
								<fmt:formatNumber value="${sessionScope.cart.geTotalMoney()}" type="currency" groupingUsed="true" />
							</strong>
						</p>
						<hr>
						<p class="card-text">
							<fmt:message key="cart.total" bundle="${bundle}" />: 
							<strong>
								<fmt:formatNumber value="${sessionScope.cart.geTotalMoney()}" type="currency" groupingUsed="true" />
							</strong>
						</p>


						<c:if test="${not empty sessionScope.user}">
							<a href="FormCheckOut.jsp" class="btn btn-primary w-100 mb-3"
								role="button">Thanh toán</a>
						</c:if>
						<c:if test="${empty sessionScope.user}">
							<a href="Login.jsp" class="btn btn-primary w-100 mb-3"
								role="button">Thanh toán</a>
						</c:if>




						<!-- Coupon Code Section with Select -->
						<!-- Dùng cách khác kk -->
						<!--	<c:if test="${not empty sessionScope.cart}">
							<form action="applydiscount" method="get">
								<div class="mb-3">
									<label for="couponCodeSelect" class="form-label">Select
										a coupon:</label> <select class="form-select" id="couponCodeSelect"
										name="couponCode">
										<option value="0,0" selected>Choose a coupon</option>
										<c:forEach var="d" items="${listDis}">
											<option value="${d.id},${d.discount}">${d.title}(Code:
												${d.discount})</option>
										</c:forEach>
									</select>
									<button class="btn btn-outline-secondary w-100 mt-2"
										type="submit" id="applyCoupon">Apply</button>
								</div>
							</form>
						</c:if> -->

					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

	<script type="text/javascript">
		function remove(event, form) {
			event.preventDefault();
			const formData = $(form).serialize();

			$.ajax({
				url : 'deleteitem',
				type : 'GET',
				data : formData,
				success : function(response) {
					$('#menuContainer').load('Header.jsp', function() {
					});
					$('#cartItems').load('Cart.jsp #cartItems > *', function() {
					});
					$('#cartSummary').load('Cart.jsp #cartSummary > *',
							function() {
							});
				},
				error : function(error) {
					alert('Có lỗi xảy ra, vui lòng thử lại!');
				}
			});

			return false;
		}
	</script>


	<script type="text/javascript">
		function updatequantity(event, form) {
			event.preventDefault();
			const formData = $(form).serialize();

			$.ajax({
				url : 'updatequantity',
				type : 'GET',
				data : formData,
				success : function(response) {
					$('#menuContainer').load('Header.jsp', function() {
					});
					$('#cartItems').load('Cart.jsp #cartItems > *', function() {
					});
					$('#cartSummary').load('Cart.jsp #cartSummary > *',
							function() {
							});
				},
				error : function(error) {
					alert('Có lỗi xảy ra, vui lòng thử lại!');
				}
			});

			return false;
		}
	</script>


</body>
</html>
