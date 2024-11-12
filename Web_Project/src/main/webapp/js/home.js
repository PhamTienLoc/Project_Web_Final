/**
 * 
 */
function loadMore() {
	var amount = document.getElementsByClassName("product").length;
	$.ajax({
		url: "loadmore", // Địa chỉ URL của servlet
		type: "get", // Phương thức GET để lấy dữ liệu từ servlet
		data: {
			exist: amount
		}, // Thêm dấu phẩy ở đây
		success: function(data) {
			var row = document.getElementById("content");
			row.innerHTML += data; // Sửa lỗi đánh máy
		},
		error: function(xhr) {
			console.error("Có lỗi xảy ra khi tải thêm dữ liệu:", xhr); // Xử lý lỗi
		}
	});
}