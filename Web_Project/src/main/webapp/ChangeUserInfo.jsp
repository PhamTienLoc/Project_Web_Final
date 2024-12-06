<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Thay đổi thông tin</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/changeInfo.css">
<title>Thay đổi thông tin</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<main class="user-info__wrapper flex-grow-1">
    <div class="container py-4">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-3 col-lg-2 d-md-block sidebar d-flex flex-column">
                <div class="user-avatar--small text-center">
                    <!-- <img class="rounded-circle mb-2 " src="" alt="ảnh người dùng"> -->
                    <p class="fs-6 fw-bolder">${user.user}</p>
                    <hr>
                </div>
                <div class="list-group rounded-0">
                    <a href="#" class="list-group-item list-group-item-action active" aria-current="true">
                        Thông tin khách hàng
                    </a>
                    <a href="${pageContext.request.contextPath}/ChangePassWord.jsp" class="list-group-item list-group-item-action">Đổi mật khẩu</a>
                    <a href="#" class="list-group-item list-group-item-action">Lịch sử mua hàng</a>
                </div>
            </div>

            <!-- Main UserInfo content -->
            <div class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pb-4 user-info__content">
                <h1 class="fs-4 fw-normal mt-3 ">Hồ sơ của tôi</h1>
                <p class=" fs-5 fw-light">Quản lý thông tin hồ sơ để bảo mật tài khoản</p>
                <hr>
                <p class=" fs-5 fw-light text-success" style="display: ${status != null ? 'block' : 'none'};">${status}</p>
                <div class="d-flex">
                    <form action="changeInfo" method="post">
                        <table class="table table-borderless align-middle">
                            <tr>
                                <td class="text-end text-muted pb-3">Họ và tên</td>
                                <td class="user-info__data text-start pb-3">
                                    <input type="text" class="form-control" name="fullName" value="${user.fullName}"
                                           required>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-end text-muted pb-3">Giới tính</td>
                                <td class="user-info__data text-start pb-3">
                                    <div class="flex form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender"
                                               id="male" value="male" ${user.gender eq "true"?"checked":""}>
                                        <label class="form-check-label" for="male">Nam</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender"
                                               id="female" value="female" ${user.gender eq "false"?"checked":""}>
                                        <label class="form-check-label" for="female">Nữ</label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-end text-muted pb-3">Ngày sinh</td>
                                <td class="user-info__data text-start pb-3">
                                    <input type="date" class="form-control" id="birthday" name="birthday" value="${user.birthDay}" required>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-end text-muted pb-3">Email</td>
                                <td class="user-info__data text-start pb-3">
                                    <input type="email" class="form-control" name="email" value="${user.email}" required>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-end text-muted pb-3">Số điện thoại</td>
                                <td class="user-info__data text-start pb-3">
                                    <input type="tel" class="form-control"
                                           placeholder="Số điện thoại của bạn" name="phoneNumber"
                                           value="${user.phoneNumber}" required>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-end text-muted pb-3">Địa chỉ</td>
                                <td class="user-info__data text-start pb-3">
                                    <input type="text" class="form-control" name="address"
                                           value="${user.address}"
                                           placeholder="Địa chỉ của bạn" required>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-end"></td>
                                <td class="user-info__data text-start">
                                    <button type="submit" class="btn btn-danger rounded-1">Lưu</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <!--                    <div class="user-avatar mx-auto">-->
                    <!--                        <div class="user-avatar&#45;&#45;big d-flex flex-column">-->
                    <!--                            <img class="rounded-circle text-center my-2 align-items-center" src="" alt="ảnh người dùng">-->
                    <!--                            <input type="file" accept=".jpg,.jpeg,.png" hidden="hidden">-->
                    <!--                            <button type="submit">Chọn ảnh</button>-->
                    <!--                        </div>-->
                    <!--                        <div class="text-center">-->
                    <!--                            <div>Dung lượng tối đa 1 MB</div>-->
                    <!--                            <div>Định dạng: .JPEG, .PNG</div>-->
                    <!--                        </div>-->
                    <!--                    </div>-->
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="Footer.jsp"></jsp:include>

<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
</body>
</html>