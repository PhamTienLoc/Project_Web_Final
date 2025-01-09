<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Add the fmt taglib -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý Sản phẩm</title>
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
				<h2>Quản lý Sản phẩm</h2>
				<div class="d-flex justify-content-between mb-3">
					<a href="addproduct1" class="btn btn-primary btn-sm" d> <i
						class="bi bi-plus-circle"></i> Thêm mới
					</a>
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
				<!-- Table for managing discount codes -->
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Hình ảnh</th>
							<th>Tên sản phẩm</th>
							<th>Giá</th>
							<th>Số lượng tồn kho</th>
							<th>Loại sản phẩm</th>
							<th>Ngày tạo</th>
							<th>Trạng thái</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!-- JSTL foreach loop to display dynamic rows -->
						<c:forEach var="product" items="${listp}">
							<tr>
								<td>${product.id}</td>
								<td><img
									src="${pageContext.request.contextPath}/image/image1/${product.thumbnail}"
									alt="Product Image" style="width: 100px; height: auto;">
								</td>
								<td>${product.title}</td>
								<td><fmt:formatNumber value="${product.price}" type="currency" groupingUsed="true" /></td>
								<td>${product.inventoryNumber}</td>
								<td>${product.category.cname}</td>
								<td><fmt:formatDate value="${product.createdAt}"
										pattern="dd/MM/yyyy" /></td>
								<td><c:if test="${product.inventoryNumber == 0}">
                               Hết hàng
                              </c:if> <c:if
										test="${product.inventoryNumber > 0}">
                              Còn hàng
                                </c:if></td>
								<td><a href="editproduct1?id=${product.id}" class="btn btn-warning btn-sm"><i
										class="bi bi-pencil"></i> Sửa</a> <a href="#"
									class="btn btn-danger btn-sm" data-bs-toggle="modal"
									data-bs-target="#deleteModal" data-id="${product.id}"
									data-title="${product.title}"> <i class="bi bi-trash"></i>
										Xóa
								</a>
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
								href="adminmanagerproduct?page=${page - 1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>

						<!-- Các nút trang -->
						<c:forEach var="i" begin="1" end="${num}" step="1">
							<li class="page-item <c:if test="${i == page}">active</c:if>">
								<a class="page-link" href="adminmanagerproduct?page=${i}">${i}</a>
								<!-- Chỗ này nếu không có đường dẫn thì nó mặc định là servlet hiên tại  -->
							</li>
						</c:forEach>

						<!-- Nút Next -->
						<c:if test="${page < num}">
							<li class="page-item"><a class="page-link"
								href="adminmanagerproduct?page=${page + 1}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>

			</main>
		</div>
	</div>
	</div>
	<!-- Modal xóa	 -->
	<div class="modal fade" id="deleteModal" tabindex="-1"
		aria-labelledby="deleteModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteModalLabel">Xác nhận xóa</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>
						Bạn có chắc chắn muốn xóa sản phẩm <strong id="productTitle"></strong>
						không?
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Hủy</button>
					<form action="deleteproduct" method="post" id="deleteForm">
						<input type="hidden" name="id" id="productId">
						<button type="submit" class="btn btn-danger">Xác nhận</button>
					</form>
				</div>
			</div>
		</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		// Khi modal được hiển thị
		var deleteModal = document.getElementById('deleteModal');
		deleteModal.addEventListener('show.bs.modal', function(event) {
			// Lấy nút được nhấn
			var button = event.relatedTarget;
			// Lấy dữ liệu từ data-id và data-title
			var productId = button.getAttribute('data-id');
			var productTitle = button.getAttribute('data-title');

			// Gán dữ liệu vào modal
			var modalTitle = deleteModal.querySelector('#productTitle');
			var modalInput = deleteModal.querySelector('#productId');
			modalTitle.textContent = productTitle;
			modalInput.value = productId;
		});
	</script>
</body>
</html>
