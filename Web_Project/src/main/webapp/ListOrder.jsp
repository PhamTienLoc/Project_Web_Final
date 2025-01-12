<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="invoice.list" bundle="${bundle}" /></title>
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
.modal {
	z-index: 1100;
}

.modal-backdrop {
	z-index: 1000;
}
</style>

</head>
<body>
	<div id="menuContainer">
		<jsp:include page="Header.jsp"></jsp:include>
	</div>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="home"><fmt:message key="home" bundle="${bundle}" /></a></li>
			<li class="breadcrumb-item active" aria-current="page"><fmt:message key="invoice.list" bundle="${bundle}" /></li>
		</ol>
	</nav>
	<!-- Tiêu đề danh sách hóa đơn -->
	<div class="container my-4">
		<h1 class="text-center mb-4"><fmt:message key="invoice.list" bundle="${bundle}" /></h1>
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
					<th scope="col"><fmt:message key="invoice.code" bundle="${bundle}" /></th>
					<th scope="col"><fmt:message key="invoice.date" bundle="${bundle}" /></th>
					<th scope="col"><fmt:message key="cart.total" bundle="${bundle}" /></th>
					<th scope="col"><fmt:message key="invoice.status" bundle="${bundle}" /></th>
					<!-- Cột trạng thái -->
					<th scope="col"><fmt:message key="invoice.action" bundle="${bundle}" /></th>
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

						<td><fmt:formatNumber value="${order.totalMoney}"
								type="number" groupingUsed="true" /> VNĐ</td>

						<!-- Cột trạng thái -->
						<td><c:choose>
								<c:when test="${order.status == 'pending'}"><fmt:message key="invoice.status.pending" bundle="${bundle}" /></c:when>
								<c:when test="${order.status == 'confirmed'}"><fmt:message key="invoice.status.confirmed" bundle="${bundle}" /></c:when>
								<c:otherwise><fmt:message key="invoice.status.delivered" bundle="${bundle}" /></c:otherwise>
							</c:choose></td>

						<td><c:url var="vieworderdetail" value="/vieworderdetail">
								<c:param name="id" value="${order.id}"></c:param>
							</c:url> <a href="${vieworderdetail}" class="btn btn-info btn-sm"><fmt:message key="invoice.action.view_detail" bundle="${bundle}" /></a> <c:if test="${order.status == 'pending'}">
								<button class="btn btn-danger btn-sm"
									onclick="openConfirmCancelModal('deledeorder?oid=${order.id}')"><fmt:message key="invoice.action.cancel" bundle="${bundle}" /></button>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- Modal Xác Nhận Hủy Đơn -->
		<div class="modal fade cancel" id="confirmCancelModal" tabindex="-1"
			role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modalLabel">Xác nhận hủy đơn</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Bạn có chắc chắn muốn hủy đơn hàng
						này không?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Hủy</button>
						<a id="confirmCancelButton" href="#" class="btn btn-danger">Hủy
							đơn</a>
					</div>
				</div>
			</div>
		</div>

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
	<script>
		function openConfirmCancelModal(cancelUrl) {
			console.log("Cancel URL:", cancelUrl); // Debug để kiểm tra
			document.getElementById('confirmCancelButton').href = cancelUrl;
			$('#confirmCancelModal').modal('show');
		}
	</script>
</body>
</html>
