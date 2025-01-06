/**
 * To be continued

	$.ajax({
	    url: '/productList',
	    data: { categoryId: categoryId },
	    success: function(response) {
	        $('#product-list').html(response);
	    }
	});
	
	function setCheck(obj, name, formId) {
	    var checkboxes = document.getElementsByName(name);
	    if (obj.id === name + "All" && obj.checked) {
	        for (var i = 1; i < checkboxes.length; i++) {
	            checkboxes[i].checked = false;
	        }
	    } else {
	        checkboxes[0].checked = false;
	    }
	    filterProducts()
	}
	
	function filterProducts() {
	    const formData = $('#categoryForm').serialize();
	    $.ajax({
	        url: 'productList',
	        type: 'GET',
	        data: formData,
	        success: function (data) {
	        	console.log(data);
	        	var row = document.getElementById("product-list");

	        	if (data.trim() === '') {
	        	    row.innerHTML = `
	        	        <div class="text-center">
	        	            <h1 class="my-3">Không tìm thấy sản phẩm phù hợp!</h1>
	        	        </div>
	        	    `;
	        	} else {
	        	    row.innerHTML = data;
	        	}
	        },
	        error: function () {
	            alert('Có lỗi xảy ra!');
	        }
	    });
	}
	
	function sortProducts(sortBy) {
	    const sortParam = '${sortParam}'; 
	    const url = `productList?${encodeURIComponent(sortParam)}&sortBy=${encodeURIComponent(sortBy)}`;
	    $.ajax({
	        url: url,
	        type: 'GET',
	        success: function (data) {
	        	console.log(data);
	        	var row = document.getElementById("product-list");

	        	if (data.trim() === '') {
	        	    row.innerHTML = `
	        	        <div class="text-center">
	        	            <h1 class="my-3">Không tìm thấy sản phẩm phù hợp!</h1>
	        	        </div>
	        	    `;
	        	} else {
	        	    row.innerHTML = data;
	        	}
	        },
	        error: function () {
	            alert('Có lỗi xảy ra!');
	        }
	    });
	}
	
	function paginateProducts(pageIndex) {
	    const indexParam = '${indexParam}'; 
	    const url = `productList?${encodeURIComponent(indexParam)}index=${encodeURIComponent(pageIndex)}`;
	    $.ajax({
	        url: url,
	        type: 'GET',
	        success: function (data) {
	        	console.log(data);
	        	var row = document.getElementById("product-list");

	        	if (data.trim() === '') {
	        	    row.innerHTML = `
	        	        <div class="text-center">
	        	            <h1 class="my-3">Không tìm thấy sản phẩm phù hợp!</h1>
	        	        </div>
	        	    `;
	        	} else {
	        	    row.innerHTML = data;
	        	}
	        },
	        error: function () {
	            alert('Có lỗi xảy ra!');
	        }
	    });
	}
*/