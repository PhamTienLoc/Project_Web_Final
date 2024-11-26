/**
 * 
 */
document.addEventListener('DOMContentLoaded', function() {
	const carousel = new bootstrap.Carousel(document.getElementById('productImageCarousel'));

	document.querySelectorAll('.thumbnail-image').forEach((thumbnail, index) => {
		thumbnail.addEventListener('click', () => {
			carousel.to(index);
		});
	});
});



	//function buy(event, form) {
		// Ngăn chặn hành động mặc định của form
		//event.preventDefault();

		// Lấy giá trị của các tham số từ form được truyền vào
		//const formData = $(form).serialize(); // Lấy toàn bộ dữ liệu từ form dưới dạng chuỗi query string

		// Gửi yêu cầu AJAX
		//$.ajax({
			//url: 'buy', // URL của servlet
			//type: 'GET', // Sử dụng phương thức GET
			//data: formData, // Truyền dữ liệu từ form
			//success: function(response) {
				// Xử lý kết quả trả về từ servlet
				//$('#menuContainer').load('Header.jsp', function() {
					//showToast('Thêm vào giỏ hàng thành công!');
				//});
			//},
			//error: function(error) {
				// Xử lý lỗi nếu có
				//alert('Có lỗi xảy ra, vui lòng thử lại.');
			//}
		//});

		// Ngăn chặn submit mặc định
		//return false;
	//}
	
	
