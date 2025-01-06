<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="addCategoryModal" tabindex="-1"
	aria-labelledby="addCategoryModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="addDiscountModalLabel">Thêm Danh Mục Mới</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<!-- Form Add Category -->
				<form action="adminCategoryManager" method="POST">
					<!-- Hidden Action field for Category -->
					<input type="hidden" id="action" name="action" value="add">
					
					<!-- CName -->
					<div class="mb-3">
                        <label for="title" class="form-label">Tên Danh Mục</label>
                        <input type="text" class="form-control" id="title" name="title"
                            value="${category.cname}" required>
                    </div>
                    
                    <!-- CThumb -->
                    <div class="mb-3">
                        <label for="thumb" class="form-label">Đường Dẫn Ảnh</label>
                        <input type="text" class="form-control" id="thumb" name="thumb"
                            value="${category.thumb}" required>
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