<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="editUserModal" tabindex="-1"
	aria-labelledby="editUserModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="editUserModalLabel">Sửa Thông Tin Người Dùng</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<!-- Form Edit User -->
				<form action="adminUserManager" method="post">
					<!-- Hidden Action and ID field for User -->
					<input type="hidden" id="action" name="action" value="update">
					<input type="hidden" id="id" name="id" value="${user.id}">

					<!-- Full Name -->
					<div class="mb-3">
						<label for="fullname" class="form-label">Họ và Tên</label> <input
							type="text" class="form-control" id="fullname" name="fullname"
							value="${user.fullName}" required>
					</div>

					<!-- Gender -->
					<div class="mb-3">
						<label class="form-label">Giới Tính</label><br>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender"
								id="genderMale" value="male" ${user.gender ? 'checked' : ''}>
							<label class="form-check-label" for="genderMale">Nam</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender"
								id="genderFemale" value="female" ${!user.gender ? 'checked' : ''}>
							<label class="form-check-label" for="genderFemale">Nữ</label>
						</div>
					</div>

					<!-- Birthday -->
					<div class="mb-3">
						<label for="birthday" class="form-label">Ngày Sinh</label> 
						<input type="date" class="form-control" id="birthday" name="birthday"
							value="${user.birthDay}" required>
					</div>

					<!-- Email -->
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> 
						<input type="email" class="form-control" id="email" name="email"
							value="${user.email}" required>
					</div>

					<!-- Phone Number -->
					<div class="mb-3">
						<label for="phoneNumber" class="form-label">Số Điện Thoại</label>
						<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" 
							value="${user.phoneNumber}" required>
					</div>

					<!-- Address -->
					<div class="mb-3">
						<label for="address" class="form-label">Địa Chỉ</label> 
						<input type="text" class="form-control" id="address" name="address"
							value="${user.address}" required>
					</div>

					<!-- Admin Role -->
					<div class="mb-3">
						<label class="form-label">Quyền Quản Trị</label><br>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="isAdmin"
								id="isAdminYes" value="yes" ${user.admin ? 'checked' : ''}>
							<label class="form-check-label" for="isAdminYes">Có</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="isAdmin"
								id="isAdminNo" value="no" ${!user.admin ? 'checked' : ''}>
							<label class="form-check-label" for="isAdminNo">Không</label>
						</div>
					</div>
					
					<!-- Email Confirm -->
					<div class="mb-3">
				        <label for="isConfirmEmail" class="form-label">Trạng thái Email</label>
				        <select class="form-control" id="isConfirmEmail" name="isConfirmEmail" required>
				            <option value="yes"  ${user.confirmEmail ? 'selected' : ''}>Đã xác thực</option>
				            <option value="no" ${!user.confirmEmail ? 'selected' : ''}>Chưa xác thực</option>
				        </select>
				    </div>

					<!-- Submit Button -->
					<div class="modal-footer"> 
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Hủy</button>
						<button type="submit" class="btn btn-primary">Lưu thay đổi</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
