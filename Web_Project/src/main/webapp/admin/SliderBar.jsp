<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Top Navbar -->
      <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Trang Quản Trị</a>
          <div class="d-flex ms-auto">
            <span class="navbar-text text-bold">
              Xin chào, ${sessionScope.user.fullName}
            </span>
          </div>
        </div>
      </nav>

      <div class="row mt-5 pt-4">
        <!-- Sidebar -->
        <nav id="sidebar" class="col-md-3 col-lg-2 d-md-block bg-light sidebar">
          <div class="position-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="admindashboard">
                  <i class="bi bi-house-door"></i>
                  Tổng quan
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="adminUserManager">
                  <i class="bi bi-person-circle"></i>
                  Quản lý người dùng
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="adminmanagercategory">
                  <i class="bi bi-cart-check"></i>
                  Quản lý Thể loại
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="adminmanagerproduct">
                  <i class="bi bi-box"></i>
                  Quản lý sản phẩm
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="adminmanagerorder">
                  <i class="bi bi-cart-check"></i>
                  Quản lý đơn hàng
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="admindiscount">
                  <i class="bi bi-ticket-perforated"></i>
                  Quản lý thẻ giảm giá
                </a>
              </li>
              <!-- Đăng xuất button -->
              <li class="nav-item mt-auto">
                <a class="nav-link text-danger" href="adminlogout">
                  <i class="bi bi-box-arrow-right"></i>
                  Đăng xuất
                </a>
              </li>
            </ul>
          </div>
        </nav>