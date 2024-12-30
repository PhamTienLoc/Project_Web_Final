<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="deleteCategoryModal" tabindex="-1"
	aria-labelledby="deleteCategoryModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="deleteUserModalLabel">Xóa Danh Mục Sản Phẩm</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<!-- Form Delete Category -->
				<p> Bạn có chắc chắn muốn xóa danh mục này? Hành động này không thể hoàn tác.
								
				<form action="adminCategoryManager" method="post">
					<!-- Hidden Action and ID field for Category -->
					<input type="hidden" id="action" name="action" value="delete">
					<input type="hidden" id="categoryId" name="id" value="">
					<p>${category.cid}</p>
					
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
