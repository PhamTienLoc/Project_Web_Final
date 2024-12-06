<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Hóa Đơn</title>
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

	<!-- Tiêu đề danh sách hóa đơn -->
	<div class="container my-4">
		<h1 class="text-center mb-4">Danh sách Hóa Đơn</h1>
		<div class="d-flex justify-content-between mb-3">
			<div class="alert alert-danger flex-fill me-2" id="errorMessage"
				style="display: ${fail != null && fail != '' ? 'block' : 'none'};">
				<p>${fail}</p>
			</div>
			<div class="alert alert-success flex-fill ms-2" id="successMessage"
				style="display: ${success != null && success != '' ? 'block' : 'none'};">
				<p>${success}</p>
			</div>
		</div>
		<!-- Bảng danh sách hóa đơn -->
		<table class="table table-bordered table-striped table-hover">
			<thead class="table-dark">
				<tr>
					<th scope="col">Mã Hóa Đơn</th>
					<th scope="col">Ngày Mua</th>
					<th scope="col">Tổng Tiền</th>
					<th scope="col">Trạng Thái</th>
					<!-- Cột trạng thái -->
					<th scope="col">Hành Động</th>
				</tr>
			</thead>
			<tbody>
				<!-- Lặp qua danh sách hóa đơn -->
				<c:forEach var="order" items="${listo}">
					<tr>
						<td>${order.id}</td>

						<!-- Định dạng ngày tháng -->
						<td><fmt:formatDate value="${order.orderDate}"
								pattern="dd/MM/yyyy" /></td>

						<td>${order.totalMoney}$</td>

						<!-- Cột trạng thái -->
						<td><c:choose>
								<c:when test="${order.status == 'pending'}">Chờ xác nhận</c:when>
								<c:when test="${order.status == 'confirmed'}">Đã xác nhận</c:when>
								<c:otherwise>Đã giao hàng</c:otherwise>
							</c:choose></td>

						<td>
						<c:url var="vieworderdetail" value="/vieworderdetail">
								<c:param name="id" value="${order.id}"></c:param>
							</c:url>  
							<a href="${vieworderdetail}" class="btn btn-info btn-sm">Xem chi tiết</a> 
							<c:if test="${order.status == 'pending'}">
								<c:url var="deleteorder" value="/deledeorder">
									<c:param name="oid" value="${order.id}"></c:param>

								</c:url>
								<a href="${deleteorder}" class="btn btn-danger btn-sm">Hủy
									đơn</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Phân trang -->
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<!-- Nút Previous -->
				<c:if test="${page > 1}">
					<li class="page-item"><a class="page-link"
						href="listhoadon?page=${page - 1}" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>

				<!-- Các nút trang -->
				<c:forEach var="i" begin="1" end="${num}" step="1">
					<li class="page-item <c:if test="${i == page}">active</c:if>">
						<a class="page-link" href="listhoadon?page=${i}">${i}</a> <!-- Chỗ này nếu không có đường dẫn thì nó mặc định là servlet hiên tại  -->
					</li>
				</c:forEach>

				<!-- Nút Next -->
				<c:if test="${page < num}">
					<li class="page-item"><a class="page-link"
						href="listhoadon?page=${page + 1}" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</nav>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
