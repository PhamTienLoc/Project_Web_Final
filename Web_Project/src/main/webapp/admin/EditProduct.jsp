<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<h2>Sửa sản phẩm</h2>
				<form action="editproduct2" method="post">
				<input type="hidden" name="id" value="${p.id}" />
					<div class="mb-3">
						<label for="productName" class="form-label">Tên Sản Phẩm</label> <input
							type="text" class="form-control" id="productName"
							name="productName" value="${p.title}" required>
					</div>
					<div class="mb-3">
						<label for="brand" class="form-label">Thương Hiệu</label> <input
							type="text" class="form-control" id="brand" name="brand"
							value="${p.brand}" required>
					</div>
					<div class="mb-3">
						<label for="price" class="form-label">Giá</label> <input
							type="number" class="form-control" id="price" name="price"
							value="${p.price}" required>
					</div>
					<div class="mb-3">
						<label for="discount" class="form-label">Giảm Giá (%)</label> <input
							type="number" class="form-control" id="discount" name="discount"
							value="${p.discount}" required>
					</div>
					<div class="mb-3">
						<label for="warranty" class="form-label">Bảo Hành</label> <input
							type="text" class="form-control" id="warranty" name="warranty"
							value="${p.warranty}" required>
					</div>
					<div class="mb-3">
						<label for="stock" class="form-label">Số Lượng Tồn Kho</label> <input
							type="number" class="form-control" id="stock" name="stock"
							value="${p.inventoryNumber}" required>
					</div>
					<div class="mb-3">
						<label for="description" class="form-label">Mô Tả</label>
						<textarea class="form-control" id="description" name="description"
							rows="3" required>${p.description} </textarea>
					</div>
					<div class="mb-3">
						<label for="category" class="form-label">Thể Loại</label> <select
							class="form-select" id="category" name="category" required>
							<!-- Dùng vòng lặp JSTL để hiển thị danh sách thể loại -->
							<c:forEach var="category" items="${listc}">
								<option value="${category.cid}"
									${category.cid == p.cid ? 'selected' : ''}>
									${category.cname}</option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<button type="submit" class="btn btn-primary">Tiếp tục</button>
						<a href="adminmanagerproduct" class="btn btn-secondary ms-2">Hủy</a>
					</div>
				</form>
			</main>
		</div>
	</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>