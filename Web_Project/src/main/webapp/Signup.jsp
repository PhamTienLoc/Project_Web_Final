<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><fmt:message key="auth.register_title" bundle="${bundle}" /></title>
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
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="container mt-5">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3 class="mb-0"><fmt:message key="auth.register_title" bundle="${bundle}" /></h3>
			</div>

			<div class="card-body">

				<div class="d-flex justify-content-between mb-3">
					<div class="alert alert-danger flex-fill me-2" id="errorMessage"
						style="display: ${fail != null ? 'block' : 'none'};">
						<p>${fail}</p>
					</div>
					<div class="alert alert-success flex-fill ms-2" id="successMessage"
						style="display: ${success != null ? 'block' : 'none'};">
						<p>${success}</p>
					</div>
				</div>
				<form action="signup" method="post">
					<div class="mb-3">
						<label for="username" class="form-label"><fmt:message key="auth.username" bundle="${bundle}" /></label> <input
							type="text" class="form-control" id="username" name="username"
							value="${userName}" placeholder="<fmt:message key="auth.enter_username" bundle="${bundle}" />" required>
					</div>

					<div class="mb-3">
						<label for="password" class="form-label"><fmt:message key="auth.password" bundle="${bundle}" /></label> <input
							type="password" class="form-control" id="password"
							placeholder="<fmt:message key="auth.enter_password" bundle="${bundle}" />" name="password" required>
					</div>
					<div class="mb-3">
						<label for="repassword" class="form-label"><fmt:message key="auth.confirm_password" bundle="${bundle}" /></label> <input 
							type="password" class="form-control"
							id="repassword" placeholder="<fmt:message key="auth.enter_password" bundle="${bundle}" />"
							name="repassword" required>
					</div>



					<div class="mb-3">
						<label for="fullName" class="form-label"><fmt:message key="auth.full_name" bundle="${bundle}" /></label> <input
							type="text" class="form-control" id="fullName" name="fullName"
							value="${fullName}" placeholder="<fmt:message key="auth.enter_full_name" bundle="${bundle}" />" required>
					</div>
					<div class="mb-3">
						<label class="form-label"><fmt:message key="auth.gender" bundle="${bundle}" /></label>
						<div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"
									id="male" value="male" ${gender1 eq 'male'?'checked':''}>
								<label class="form-check-label" for="male"><fmt:message key="auth.gender_male" bundle="${bundle}" /></label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"
									id="female" value="female" ${gender1 eq 'female'?'checked':''}>
								<label class="form-check-label" for="female"><fmt:message key="auth.gender_female" bundle="${bundle}" /></label>
							</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="birthday" class="form-label"><fmt:message key="auth.date_of_birth" bundle="${bundle}" /></label> <input
							type="date" class="form-control" id="birthday" name="birthday"
							required value="${date}">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="text" class="form-control" id="email"
							placeholder="Nhập email" name="email" required
							value="${email}">
					</div>
					<div class="mb-3">
						<label for="phoneNumber" class="form-label"><fmt:message key="auth.phone_number" bundle="${bundle}" /></label> <input
							type="tel" class="form-control" id="phoneNumber"
							placeholder="<fmt:message key="auth.enter_phone_number" bundle="${bundle}" />" name="phoneNumber" required
							value="${phoneNumber}">
					</div>
					<div class="mb-3">
						<label for="address" class="form-label"><fmt:message key="auth.address" bundle="${bundle}" /></label> <input
							type="text" class="form-control" id="address"
							placeholder="<fmt:message key="auth.enter_address" bundle="${bundle}" />" name="address"
							value="${address}">
					</div>
					<button type="submit" class="btn btn-primary"><fmt:message key="auth.register_title" bundle="${bundle}" /></button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>