<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form action="uploadfile" method="post"
					enctype="multipart/form-data">

					<div class="mb-3">
						<label for="image1" class="form-label">Hình Ảnh</label> <input
							type="file" class="form-control" id="image1" name="image1"
							accept="image/*" required>
					</div>
					<div class="mb-3">
						<label for="image2" class="form-label">Hình Ảnh</label> <input
							type="file" class="form-control" id="image2" name="image2"
							accept="image/*" required>
					</div>
					<div class="mb-3">
						<button type="submit" class="btn btn-primary">Thêm Sản
							Phẩm</button>
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