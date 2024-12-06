<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trang Quản Trị</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Optional Bootstrap Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

  <!-- Custom CSS for card hover effect -->
  <style>
    .card {
      transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .card:hover {
      transform: translateY(-10px); /* Nâng thẻ lên một chút */
      box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1); /* Thêm hiệu ứng bóng đổ */
    }
  </style>
</head>

<body>
  <div class="container-fluid">
    <div class="row">
      <jsp:include page="SliderBar.jsp"></jsp:include>

      <!-- Main content -->
      <main class="col-md-9 ms-sm-auto col-lg-10 px-4">
        <h2>Tổng quan</h2>
        <div class="row">
          <div class="col-lg-4 col-md-6">
            <div class="card mb-4">
              <div class="card-body">
                <h5 class="card-title">Tổng số người dùng</h5>
                <p class="card-text">${sizeu}</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6">
            <div class="card mb-4">
              <div class="card-body">
                <h5 class="card-title">Tổng số đơn hàng</h5>
                <p class="card-text">${sizeo}</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6">
            <div class="card mb-4">
              <div class="card-body">
                <h5 class="card-title">Tổng số thẻ giảm giá </h5>
                <p class="card-text">${sized}</p>
              </div>
            </div>
          </div>
        </div>

        <!-- Dòng dưới để hiển thị tổng doanh thu và tổng số sản phẩm -->
        <div class="row">
          <div class="col-lg-4 col-md-6">
            <div class="card mb-4">
              <div class="card-body">
                <h5 class="card-title">Tổng doanh thu</h5>
                <p class="card-text"> ${total} VNĐ</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6">
            <div class="card mb-4">
              <div class="card-body">
                <h5 class="card-title">Tổng số sản phẩm</h5>
                <p class="card-text">${sizep}</p>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
  </div>
</div>
  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
