<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal fade" id="editCategoryModal" tabindex="-1"
    aria-labelledby="editCategoryModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editCategoryModalLabel">Sửa Danh Mục Sản Phẩm</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                    aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- Form Edit Category -->
                <form action="adminCategoryManager" method="post">
                	<!-- Hidden Action and ID field for Category -->
                	<input type="hidden" id="action" name="action" value="update">
                    <input type="hidden" id="id" name="id" value="${category.cid}">
                    
                    <!-- CName -->
                    <div class="mb-3">
                        <label for="title" class="form-label">Tên Thể loại</label>
                        <input type="text" class="form-control" id="title" name="title"
                            value="${category.cname}" required>
                    </div>
                    <!-- CThumb -->
                    <div class="mb-3">
                        <label for="thumb" class="form-label">Thumb</label>
                        <input type="text" class="form-control" id="thumb" name="thumb"
                            value="${category.thumb}" required>
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