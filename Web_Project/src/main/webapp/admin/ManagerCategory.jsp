<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh mục</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
				<h2>Quản lý danh mục</h2>
				<div class="d-flex justify-content-between mb-3">
					<button 
						class="btn btn-primary btn-sm" 
						data-bs-toggle="modal"
						data-bs-target="#addCategoryModal">
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
							<th>Tên danh mục</th>
							<th>Đường dẫn ảnh</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="category" items="${listc}">
							<tr>
								<td>${category.cid}</td>
								<td>${category.cname}</td>
								<td class="text-truncate">${category.thumb}</td>
								<td>
									<button 
										type="button" 
										class="btn btn-warning btn-sm"
										onclick="loadModal(${category.cid})">
										<i class="bi bi-pencil"></i> Sửa
									</button> 
									<button 
										class="btn btn-danger btn-sm" 
										data-bs-toggle="modal"
										data-bs-target="#deleteCategoryModal"
										data-id="${category.cid}">
										<i class="bi bi-trash"></i> Xóa
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- Edit modal -->
				<div id="modalContainer"></div>
				
				<!-- Add modal -->
				<jsp:include page="ModalAddCategory.jsp" />
				
				<!-- Delete modal -->
				<jsp:include page="ModalDeleteCategory.jsp" />
				
				<!-- Phân trang -->
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<!-- Nút Previous -->
						<c:if test="${page > 1}">
							<li class="page-item"><a class="page-link"
								href="adminmanagercategory?page=${page - 1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>

						<!-- Các nút trang -->
						<c:forEach var="i" begin="1" end="${num}" step="1">
							<li class="page-item <c:if test="${i == page}">active</c:if>">
								<a class="page-link" href="adminmanagercategory?page=${i}">${i}</a>
								<!-- Chỗ này nếu không có đường dẫn thì nó mặc định là servlet hiên tại  -->
							</li>
						</c:forEach>

						<!-- Nút Next -->
						<c:if test="${page < num}">
							<li class="page-item"><a class="page-link"
								href="adminmanagercategory?page=${page + 1}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>

			</main>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js">
	</script>
	<script>
		function loadModal(categoryId) {
			// Gửi AJAX đến servlet để lấy modal
			var xhr = new XMLHttpRequest();
			xhr.open('GET', 'editcategory?id=' + categoryId, true);
			xhr.onload = function() {
				if (xhr.status === 200) {
					// Gắn nội dung modal vào #modalContainer
					document.getElementById('modalContainer').innerHTML = xhr.responseText;

					// Mở modal
					var myModal = new bootstrap.Modal(document.getElementById('editCategoryModal'));
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
		
		document.addEventListener('DOMContentLoaded', function () {
		    const deleteCategoryModal = document.getElementById('deleteCategoryModal');

		    deleteCategoryModal.addEventListener('show.bs.modal', function (event) {
		        const button = event.relatedTarget;

		        const categoryId = button.getAttribute('data-id');

		        const categoryIdInput = deleteCategoryModal.querySelector('#categoryId');
		        if (categoryIdInput) {
		        	categoryIdInput.value = categoryId;
		        }
		    });
		});
	</script>
</body>
</html>
