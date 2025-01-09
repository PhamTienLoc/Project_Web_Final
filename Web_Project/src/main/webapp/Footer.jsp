<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
<footer class="container-fluid bg-dark text-center text-white py-4 mt-auto">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h5><fmt:message key="about_plj" bundle="${bundle}" /></h5>
				<p><fmt:message key="plj_description" bundle="${bundle}" /></p>
			</div>
			<div class="col-md-4">
				<h5><fmt:message key="contact" bundle="${bundle}" /></h5>
				<ul class="list-unstyled">
					<li><fmt:message key="email" bundle="${bundle}" /></li>
					<li><fmt:message key="phone" bundle="${bundle}" /></li>
					<li><fmt:message key="address" bundle="${bundle}" /></li>
				</ul>
			</div>
			<div class="col-md-4">
				<h5><fmt:message key="connect_with_us" bundle="${bundle}" /></h5>
				<div>
					<a href="#" class="text-white me-3"><i class="bi bi-facebook"></i></a>
					<a href="#" class="text-white me-3"><i class="bi bi-twitter"></i></a>
					<a href="#" class="text-white me-3"><i class="bi bi-instagram"></i></a>
					<a href="#" class="text-white"><i class="bi bi-linkedin"></i></a>
				</div>
			</div>
		</div>
		<div class="text-center mt-4">
			<p class="mb-0"><fmt:message key="copyright" bundle="${bundle}" /></p>
		</div>
	</div>
</footer>
