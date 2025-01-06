<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="addUserModal" tabindex="-1"
	aria-labelledby="addUserModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="addDiscountModalLabel">Thêm Người Dùng Mới</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<!-- Form Add User -->
				<form action="adminUserManager" method="POST">
					<!-- Hidden Action field for User -->
					<input type="hidden" id="action" name="action" value="add">
					
					<!-- Username -->
					<div class="mb-3">
						<label for="username" class="form-label">Tên Đăng Nhập</label> 
						<input type="text" class="form-control" id="username" name="username" required>
					</div>
					
					<!-- Password -->
					<div class="mb-3">
						<label for="password" class="form-label">Mật khẩu</label> 
						<input type="password" class="form-control" id="password" name="password" required>
					</div>
					
					<!-- Full Name -->
					<div class="mb-3">
						<label for="fullname" class="form-label">Họ và Tên</label> 
						<input type="text" class="form-control" id="fullname" name="fullname" required>
					</div>
					
					<!-- Gender -->
					<div class="mb-3">
						<label class="form-label">Giới Tính</label><br>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender"
								id="genderMale" value="male">
							<label class="form-check-label" for="genderMale">Nam</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender"
								id="genderFemale" value="female">
							<label class="form-check-label" for="genderFemale">Nữ</label>
						</div>
					</div>
					
					<!-- Birthday -->
					<div class="mb-3">
						<label for="birthday" class="form-label">Ngày Sinh</label> 
						<input type="date" class="form-control" id="birthday" name="birthday"
							placeholder="Nhập ngày sinh" required>
					</div>
					
					<!-- Email -->
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> 
						<input type="email" class="form-control" id="email" name="email"
							placeholder="Nhập email" required>
					</div>
					
					<!-- Phone Number -->
					<div class="mb-3">
						<label for="phoneNumber" class="form-label">Số Điện Thoại</label>
						<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" 
							placeholder="Nhập số điện thoại" required>
					</div>
					
					<!-- Address -->
					<div class="mb-3">
						<label for="address" class="form-label">Địa Chỉ</label> 
						<input type="text" class="form-control" id="address" name="address"
							placeholder="Nhập địa chỉ" required>
					</div>
					
					<!-- Admin Role -->
					<div class="mb-3">
						<label class="form-label">Quyền Quản Trị</label><br>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="isAdmin"
								id="isAdminYes" value="yes">
							<label class="form-check-label" for="isAdminYes">Có</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="isAdmin"
								id="isAdminNo" value="no">
							<label class="form-check-label" for="isAdminNo">Không</label>
						</div>
					</div>
					
					<!-- Submit Button -->
					<div class="modal-footer"> 
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Hủy</button>
						<button type="submit" class="btn btn-primary">Thêm</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>