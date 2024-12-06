<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal fade" id="editDiscountModal" tabindex="-1"
    aria-labelledby="editDiscountModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editDiscountModalLabel">Sửa Thẻ Giảm Giá</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                    aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- Form to edit discount code -->
                <form action="updatediscount" method="post">
                    <input type="hidden" id="discountCodeId" name="id" value="${discount.id}">
                    <div class="mb-3">
                        <label for="discountTitle" class="form-label">Tên Thẻ Giảm Giá</label>
                        <input type="text" class="form-control" id="discountTitle" name="title"
                            value="${discount.title}" required>
                    </div>
                    <div class="mb-3">
                        <label for="discountValue" class="form-label">Giá Trị Giảm Giá (%)</label>
                        <input type="number" class="form-control" id="discountValue" name="discount"
                            value="${discount.discount}" required>
                    </div>
                    <div class="mb-3">
                        <label for="startDate" class="form-label">Ngày Bắt Đầu</label>
                        <input type="date" class="form-control" id="startDate" name="startDate"
                            value="${discount.startDate}" required>
                    </div>
                    <div class="mb-3">
                        <label for="endDate" class="form-label">Ngày Kết Thúc</label>
                        <input type="date" class="form-control" id="endDate" name="endDate"
                            value="${discount.endDate}" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                </form>
            </div>
        </div>
    </div>
</div>