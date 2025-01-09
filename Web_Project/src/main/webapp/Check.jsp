<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang Thanh Toán</title>
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
.payment-summary {
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 15px;
	background-color: #f9f9f9;
}

.product-item {
	display: flex;
	justify-content: space-between;
	border-bottom: 1px solid #ddd;
	padding: 10px 0;
}

.product-item:last-child {
	border-bottom: none;
}

.total {
	font-size: 18px;
	font-weight: bold;
	text-align: right;
	margin-top: 15px;
}
</style>
</head>
<body>
	<div id="menuContainer">
		<jsp:include page="Header.jsp"></jsp:include>
	</div>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="home">Trang chủ</a></li>
			<li class="breadcrumb-item"><a href="Cart.jsp">Giỏ Hàng</a></li>
			<li class="breadcrumb-item"><a href="FormCheckOut.jsp">Kiêm
					tra thông tin</a></li>
			<li class="breadcrumb-item"><a href="PaymentMethod.jsp">Phương
					thưc thanh toán</a></li>
			<li class="breadcrumb-item active" aria-current="page">Thanh
				toán</li>
		</ol>
	</nav>

	<div class="container mt-5 mb-5">
		<div class="row">
			<!-- Cột bên trái: Thông tin khách hàng -->
			<div class="col-md-7 checkout-form-container">
				<form action="confirmcheckout" method="post">
					<h2 class="text-center mb-4">Thanh toán</h2>
					<p class="text-center text-muted">Vui lòng kiểm tra thông tin
						khách hàng và đơn hàng trước khi đặt hàng.</p>
					<div class="mb-3">
						<label for="fullName" class="form-label">Họ và tên</label> <input
							type="text" class="form-control" id="fullName" name="fullName"
							value="${sessionScope.user.fullName}" readonly
							placeholder="Nhập họ và tên" required>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							value="${sessionScope.user.email}" placeholder="Nhập email"
							readonly required>
					</div>
					<div class="mb-3">
						<label for="phoneNumber" class="form-label">Số điện thoại</label>
						<input type="text" class="form-control" id="phoneNumber"
							value="${sessionScope.user.phoneNumber}" name="phoneNumber"
							readonly placeholder="Nhập số điện thoại" required>
					</div>
					<div class="mb-3">
						<label for="address" class="form-label">Địa chỉ</label> <input
							type="text" class="form-control" id="address" name="address"
							value="${sessionScope.user.address}" placeholder="Nhập địa chỉ"
							readonly required>
					</div>
					<div class="mb-3">
						<label for="note" class="form-label">Ghi chú</label>
						<textarea class="form-control" id="note" name="note" rows="3"
							readonly placeholder="Nhập ghi chú (không bắt buộc)">${sessionScope.order.note}</textarea>
					</div>
					<div class="mb-3">
						<label for="paymentMethod" class="form-label">Hình thức
							thanh toán</label> <input type="text" class="form-control"
							id="paymentMethod" name="paymentMethod"
							value="${sessionScope.order.paymentMethod}" readonly
							placeholder="Nhập hình thức thanh toán" required>
					</div>
					<input type="hidden" name="disID" value="${disId}">
					<button type="submit" class="btn btn-primary w-100 mt-3">Đặt
						hàng</button>
				</form>
			</div>

			<!-- Cột bên phải: Thông tin giỏ hàng -->
			<div class="col-md-5">
				<div class="payment-summary" style="margin-top: 134px">
					<h5>Giỏ hàng</h5>
					<!-- Hiển thị danh sách sản phẩm -->
					<c:forEach var="item" items="${sessionScope.cart.items}">
						<div class="product-item">
							<!-- Tên sản phẩm -->
							<span><c:out value="${item.product.title}" /></span>
							<!-- Số lượng x Giá tiền của một sản phẩm -->
							<span>(<c:out value="${item.quantity}" /> x 
									<fmt:formatNumber value="${item.product.price}" type="currency" groupingUsed="true" />)
							</span>
							<!-- Tổng giá trị -->
							<span style="float: right;">
								<fmt:formatNumber value="${item.product.price * item.quantity}" type="currency" groupingUsed="true" />
							</span>
						</div>
					</c:forEach>
					<!-- Tổng cộng -->
					<div class="total" id="total">
						<c:if test="${empty totalMoneyUseDis || totalMoneyUseDis == 0}">
                        Tổng cộng: 
                        <span><fmt:formatNumber
									value="${sessionScope.cart.geTotalMoney()}" type="currency" groupingUsed="true"
									minFractionDigits="2" maxFractionDigits="2" /></span>
						</c:if>
						<c:if
							test="${not empty totalMoneyUseDis && totalMoneyUseDis != 0}">
                        Tổng cộng: 
                       <span
								style="text-decoration: line-through; color: gray;"> <fmt:formatNumber
									value="${sessionScope.cart.geTotalMoney()}" type="currency" groupingUsed="true"
									minFractionDigits="2" maxFractionDigits="2" />
							</span>
							<span style="margin-left: 10px; color: red; font-weight: bold;">
								<fmt:formatNumber value="${totalMoneyUseDis}" type="currency" groupingUsed="true"
									minFractionDigits="2" maxFractionDigits="2" />
							</span>
						</c:if>
					</div>
					<!-- Discount -->
					<div class="mb-3">
						<label for="discountCode" class="form-label">Chọn mã giảm
							giá</label>
						<form action="applydiscount" method="get"
							onsubmit="return selectdiscount(event,this);">
							<div class="dropdown">
								<select class="form-select" id="discountCode"
									name="discountCode" required>
									<option value="0" ${param.discountCode == 0 ? 'selected' : ''}>Không
										sử dụng mã giảm giá</option>
									<c:forEach var="dis" items="${listDis}">
										<option value="${dis.id}"
											${param.discountCode == dis.id ? 'selected' : ''}>
											${dis.title} - Giảm ${dis.discount}%</option>
									</c:forEach>
								</select>
							</div>
							<button type="submit" class="btn btn-primary mt-3">Áp
								dụng mã giảm giá</button>
						</form>
					</div>
					<!-- end Discount -->
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
		function selectdiscount(event, form) {
			event.preventDefault();
			const formData = $(form).serialize();
			console.log("Dữ liệu gửi đi:", formData);

			$.ajax({
				url : 'applydiscount',
				type : 'GET',
				data : formData,
				success : function(response) {
					const updatedTotal = $(response).find('#total').html();
					$('#total').html(updatedTotal);
					console.log("Tổng tiền đã được cập nhật.");

					$('#menuContainer').load('Header.jsp', function() {
					});

					const updatedForm = $(response).find(
							'.checkout-form-container').html();
					$('.checkout-form-container').html(updatedForm);
					console.log("Form thanh toán đã được cập nhật.");

				},
				error : function(error) {
					console.error('Có lỗi xảy ra:', error);
					alert('Có lỗi xảy ra, vui lòng thử lại!');
				}
			});

			return false;
		}
	</script>
</body>
</html>
