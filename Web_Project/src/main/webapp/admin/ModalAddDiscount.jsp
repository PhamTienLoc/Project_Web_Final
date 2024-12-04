<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="addDiscountModal" tabindex="-1"
	aria-labelledby="addDiscountModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="addDiscountModalLabel">Thêm Thẻ
					Giảm Giá Mới</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<!-- Form Thêm thẻ giảm giá -->
				<form action="adddiscount" method="POST">
					<div class="mb-3">
						<label for="discountTitle" class="form-label">Tên Thẻ Giảm
							Giá</label> <input type="text" class="form-control" id="discountTitle"
							name="title" required>
					</div>
					<div class="mb-3">
						<label for="discountValue" class="form-label">Giá trị (%)</label>
						<input type="number" class="form-control" id="discountValue"
							name="discount" required>
					</div>
					<div class="mb-3">
						<label for="startDate" class="form-label">Ngày bắt đầu</label> <input
							type="date" class="form-control" id="startDate" name="startDate"
							required>
					</div>
					<div class="mb-3">
						<label for="endDate" class="form-label">Ngày kết thúc</label> <input
							type="date" class="form-control" id="endDate" name="endDate"
							required>
					</div>
					<button type="submit" class="btn btn-primary">Lưu</button>
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Hủy</button>
				</form>
			</div>
		</div>
	</div>
</div>