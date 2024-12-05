<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Add the fmt taglib -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý hóa đơn</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Optional Bootstrap Icons -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
</head>
<body>




	<div class="container-fluid">
		<div class="row">
			<jsp:include page="SliderBar.jsp"></jsp:include>

			<!-- Main content -->
			<main class="col-md-9 ms-sm-auto col-lg-10 px-4">
				<h2>Quản lý hóa đơn</h2>
				<div class="d-flex justify-content-between mb-3">
					<button class="btn btn-primary btn-sm" data-bs-toggle="modal"
						data-bs-target="">
						<i class="bi bi-plus-circle"></i> Thêm mới
					</button>
				</div>
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
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>FullName</th>
							<th>Ngày đặt</th>
							<th>Trạng thái</th>
							<th>Hình thức thanh toán</th>
							<th>Tổng tiền</th>
							<th>Actions</th>
							<th>Chi tiết</th>
							<!-- Cột cho nút "Xem chi tiết" -->
						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${listo}">
							<tr>
								<td>${order.id}</td>
								<td>${order.fullName}</td>
								<td><fmt:formatDate value="${order.orderDate}"
										pattern="dd/MM/yyyy" /></td>
								<td><c:choose>
										<c:when test="${order.status == 'confirmed'}">Đã xác nhận</c:when>
										<c:when test="${order.status == 'pending'}">Đang xử lý</c:when>
										<c:otherwise>Chưa xử lý</c:otherwise>
									</c:choose></td>
								<td>${order.paymentMethod}</td>
								<td>${order.totalMoney}</td>
								<td>
									<!-- Chức năng Xác nhận và Hủy đơn hàng --> <c:url
										var="confirmOrder" value="/confirmorder">
										<c:param name="id" value="${order.id}" />
									</c:url>
									<button type="button" class="btn btn-success btn-sm"
										onclick="window.location.href='${confirmOrder}'">
										<i class="bi bi-check-circle"></i> Xác nhận
									</button> <c:url var="cancelOrder" value="/cancelorder">
										<c:param name="id" value="${order.id}" />
									</c:url>
									<button type="button" class="btn btn-danger btn-sm"
										onclick="window.location.href='${cancelOrder}'">
										<i class="bi bi-x-circle"></i> Hủy đơn hàng
									</button>
								</td>
								<!-- Cột mới cho nút "Xem chi tiết" -->
								<td><c:url var="viewOrderDetails" value="/vieworderdetails">
										<c:param name="id" value="${order.id}" />
									</c:url>
									<button type="button" class="btn btn-info btn-sm"
										onclick="window.location.href='${viewOrderDetails}'">
										<i class="bi bi-eye"></i> Xem chi tiết
									</button></td>
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
								href="adminmanagerorder?page=${page - 1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>

						<!-- Các nút trang -->
						<c:forEach var="i" begin="1" end="${num}" step="1">
							<li class="page-item <c:if test="${i == page}">active</c:if>">
								<a class="page-link" href="adminmanagerorder?page=${i}">${i}</a> <!-- Chỗ này nếu không có đường dẫn thì nó mặc định là servlet hiên tại  -->
							</li>
						</c:forEach>

						<!-- Nút Next -->
						<c:if test="${page < num}">
							<li class="page-item"><a class="page-link"
								href="adminmanagerorder?page=${page + 1}" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>

			</main>
		</div>
	</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		function loadModal(discountCodeId) {
			// Gửi AJAX đến servlet để lấy modal
			var xhr = new XMLHttpRequest();
			xhr.open('GET', 'editdiscount?id=' + discountCodeId, true);
			xhr.onload = function() {
				if (xhr.status === 200) {
					// Gắn nội dung modal vào #modalContainer
					document.getElementById('modalContainer').innerHTML = xhr.responseText;

					// Mở modal
					var myModal = new bootstrap.Modal(document
							.getElementById('editDiscountModal'));
					myModal.show();
				}
			};
			xhr.send();
		}
	</script>

	<script type="text/javascript">
		window.addEventListener('DOMContentLoaded', function() {
			setTimeout(
					function() {
						var successMessage = document
								.getElementById('successMessage');
						var errorMessage = document
								.getElementById('errorMessage');

						// Ẩn thông báo thành công nếu nó đang hiển thị
						if (successMessage
								&& successMessage.style.display === 'block') {
							successMessage.style.display = 'none';
						}

						// Ẩn thông báo thất bại nếu nó đang hiển thị
						if (errorMessage
								&& errorMessage.style.display === 'block') {
							errorMessage.style.display = 'none';
						}
					}, 1500); // Ẩn sau 3 giây
		});
	</script>
</body>
</html>
