<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Category</a></li>
						<li class="breadcrumb-item active" aria-current="#">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">

			<jsp:include page="Left.jsp"></jsp:include>

			<div class="col-sm-9">
				<div class="row">
					<c:forEach items="${listP}" var="p">
						<div class="col-12 col-md-6 col-lg-3">
							<div class="card mt-3">
								<img class="card-img-top" src="${p.thumbnail}"
									alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title show_txt">
										<a href="detail?pid=${p.id}" title="View Product">${p.title}</a>
									</h4>
									<p class="card-text show_txt">${p.title}</p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${p.price}$</p>
										</div>
										<div class="col">
											<a href="#" class="btn btn-success btn-block">Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<%--Chỗ load sản phẩm --%>
		</div>
	</div>







	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>