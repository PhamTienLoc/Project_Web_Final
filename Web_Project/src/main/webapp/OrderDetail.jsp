<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="invoice.detail" bundle="${bundle}" /></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
	<div id="menuContainer">
		<jsp:include page="Header.jsp"></jsp:include>
	</div>
	<div class="container my-4">
		<h1 class="text-center"><fmt:message key="invoice.detail" bundle="${bundle}" /></h1>

		<!-- Hiển thị mã hóa đơn -->
		<div class="card mb-4">
			<div class="card-body">
				<h5 class="card-title"><fmt:message key="invoice.code" bundle="${bundle}" />: ${order.id}</h5>
				<p class="card-text">
					<fmt:message key="invoice.date" bundle="${bundle}" />:
					<fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy" />
				</p>
				<p class="card-text"><fmt:message key="cart.total" bundle="${bundle}" />: <fmt:formatNumber value="${order.totalMoney}" type="currency" groupingUsed="true" /></p>
				<p class="card-text">
					<fmt:message key="invoice.status" bundle="${bundle}" />:
					<c:choose>
						<c:when test="${order.status == 'pending'}"><fmt:message key="invoice.status.pending" bundle="${bundle}" /></c:when>
						<c:when test="${order.status == 'confirmed'}"><fmt:message key="invoice.status.confirmed" bundle="${bundle}" /></c:when>
						<c:otherwise><fmt:message key="invoice.status.delivered" bundle="${bundle}" /></c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>

		<!-- Bảng chi tiết sản phẩm trong hóa đơn -->
		<h4><fmt:message key="invoice.product_in_invoice" bundle="${bundle}" /></h4>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th scope="col"><fmt:message key="invoice.product.name" bundle="${bundle}" /></th>
					<th scope="col"><fmt:message key="invoice.product.quantity" bundle="${bundle}" /></th>
					<th scope="col"><fmt:message key="invoice.product.price" bundle="${bundle}" /></th>
					<th scope="col"><fmt:message key="cart.total" bundle="${bundle}" /></th>
				</tr>
			</thead>
			<tbody>
				<!-- Lặp qua các sản phẩm trong hóa đơn -->
				<c:forEach var="orderdetails" items="${listOd}">
					<tr>
						<td>${orderdetails.product.title}</td>
						<td>${orderdetails.quantity}</td>
						<td><fmt:formatNumber value="${orderdetails.price}" type="currency" groupingUsed="true" /></td>
						<td><fmt:formatNumber value="${orderdetails.quantity * orderdetails.price}" type="currency" groupingUsed="true" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Nút quay lại -->
		<a href="listhoadon" class="btn btn-secondary mt-3"><fmt:message key="invoice.action.back_to_list" bundle="${bundle}" /></a>
	</div>


	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>