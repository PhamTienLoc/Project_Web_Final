<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal fade" id="editCategoryModal" tabindex="-1"
    aria-labelledby="editCategoryModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editCategoryModalLabel">Sửa Thể Loại</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                    aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- Form to edit discount code -->
                <form action="updateCategory" method="post">
                    <input type="hidden" id="id" name="id" value="${category.cid}">
                    <div class="mb-3">
                        <label for="Title" class="form-label">Tên Thể loại</label>
                        <input type="text" class="form-control" id="Title" name="title"
                            value="${category.cname}" required>
                    </div>
                    <div class="mb-3">
                        <label for="thumb" class="form-label">Thumb</label>
                        <input type="text" class="form-control" id="thumb" name="thumb"
                            value="${category.thumb}" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                </form>
            </div>
        </div>
    </div>
</div>