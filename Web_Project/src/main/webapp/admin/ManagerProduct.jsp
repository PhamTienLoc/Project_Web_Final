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

				<!-- Table for managing discount codes -->
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
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
								<td>${product.title}</td>
								<td>${product.price}</td>
								<td>${product.inventoryNumber}</td>
								<td>${product.category.cname}</td>
								<td>
							<fmt:formatDate value="${product.createdAt}" pattern="dd/MM/yyyy" />
								</td>
								<td>
								<c:if test="${product.inventoryNumber == 0}">
                               Hết hàng
                              </c:if> 
                              <c:if test="${product.inventoryNumber > 0}">
                              Còn hàng
                                </c:if>
								</td>
								<td><a href=""
									class="btn btn-warning btn-sm"><i class="bi bi-pencil"></i>
										Sửa</a> <a href=""
									class="btn btn-danger btn-sm"><i class="bi bi-trash"></i>
										Xóa</a></td>
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
								href="adminmanagerproduct?page=${page - 1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>

						<!-- Các nút trang -->
						<c:forEach var="i" begin="1" end="${num}" step="1">
							<li class="page-item <c:if test="${i == page}">active</c:if>">
								<a class="page-link" href="adminmanagerproduct?page=${i}">${i}</a> <!-- Chỗ này nếu không có đường dẫn thì nó mặc định là servlet hiên tại  -->
							</li>
						</c:forEach>

						<!-- Nút Next -->
						<c:if test="${page < num}">
							<li class="page-item"><a class="page-link"
								href="adminmanagerproduct?page=${page + 1}" aria-label="Next"> <span
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
</body>
</html>
