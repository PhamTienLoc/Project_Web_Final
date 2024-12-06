<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<div id="menuContainer">
		<jsp:include page="Header.jsp"></jsp:include>
	</div>
	<div class="container my-4">
		<h1 class="text-center">Chi Tiết Hóa Đơn</h1>

		<!-- Hiển thị mã hóa đơn -->
		<div class="card mb-4">
			<div class="card-body">
				<h5 class="card-title">Mã Hóa Đơn: ${order.id}</h5>
				<p class="card-text">
					Ngày Mua:
					<fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy" />
				</p>
				<p class="card-text">Tổng Tiền: ${order.totalMoney}$</p>
				<p class="card-text">
					Trạng Thái:
					<c:choose>
						<c:when test="${order.status == 'pending'}">Chờ xác nhận</c:when>
						<c:when test="${order.status == 'confirmed'}">Đã xác nhận</c:when>
						<c:otherwise>Đã giao hàng</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>

		<!-- Bảng chi tiết sản phẩm trong hóa đơn -->
		<h4>Sản Phẩm Trong Hóa Đơn</h4>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th scope="col">Tên Sản Phẩm</th>
					<th scope="col">Số Lượng</th>
					<th scope="col">Đơn Giá</th>
					<th scope="col">Tổng Tiền</th>
				</tr>
			</thead>
			<tbody>
				<!-- Lặp qua các sản phẩm trong hóa đơn -->
				<c:forEach var="orderdetails" items="${listOd}">
					<tr>
						<td>${orderdetails.product.title}</td>
						<td>${orderdetails.quantity}</td>
						<td>${orderdetails.price}$</td>
						<td>${orderdetails.quantity * orderdetails.price}$</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Nút quay lại -->
		<a href="listhoadon" class="btn btn-secondary mt-3">Quay lại
			danh sách</a>
	</div>


	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>