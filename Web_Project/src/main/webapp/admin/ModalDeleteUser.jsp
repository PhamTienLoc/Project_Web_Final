<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="deleteUserModal" tabindex="-1"
	aria-labelledby="deleteUserModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="deleteUserModalLabel">Xóa Người Dùng</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<!-- Form Delete User -->
				<p> Bạn có chắc chắn muốn xóa người dùng này? Hành động này không thể hoàn tác.
								
				<form action="adminUserManager" method="post">
					<!-- Hidden Action and ID field for User -->
					<input type="hidden" id="action" name="action" value="delete">
					<input type="hidden" id="id" name="id" value="${user.id}">

					<!-- Submit Button -->
					<div class="modal-footer"> 
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Hủy</button>
						<button type="submit" class="btn btn-danger">Xóa</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
